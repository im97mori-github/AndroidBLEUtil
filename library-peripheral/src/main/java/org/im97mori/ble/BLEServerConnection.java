package org.im97mori.ble;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.ParcelUuid;
import android.os.SystemClock;
import android.text.format.DateUtils;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEConstants.ErrorCodes;
import org.im97mori.ble.characteristic.MockControl;
import org.im97mori.ble.task.NotificationTask;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;

import static android.bluetooth.le.AdvertiseSettings.ADVERTISE_MODE_LOW_LATENCY;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ErrorCodes.APPLICATION_ERROR_9F;

/**
 * BLE Connection(peripheral role)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class BLEServerConnection extends BluetoothGattServerCallback {

    /**
     * Default server setting
     */
    @SuppressWarnings("WeakerAccess")
    public static abstract class DefaultServerSetting implements BLEServerCallback {

        /**
         * Default response message
         */
        public static final String MESSAGE_SUCCESS = "MESSAGE_SUCCESS";

        // UUID for service / characteristic / descriptor

        /**
         * DEFAULT_SERVICE
         */
        public static final UUID DEFAULT_SERVICE_UUID = UUID.fromString("00000000-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * UNDEFINED_SERVICE (for test)
         */
        public static final UUID UNDIFINED_SERVICE_UUID = UUID.fromString("ffffffff-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * READABLE_CHARACTERICTIS
         */
        public static final UUID READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT = UUID.fromString("00000001-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * READABLE_CHARACTERICTIS (10sec wait)
         */
        public static final UUID READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S = UUID.fromString("00000002-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * READABLE_ERROR_CHARACTERISTIC
         *
         * @see ErrorCodes#REQUEST_NOT_SUPPORTED
         */
        public static final UUID READABLE_CHARACTERISTIC_UUID_WITH_ERROR = UUID.fromString("00000003-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * WRITABLE_CHARACTERISTIC
         */
        public static final UUID WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT = UUID.fromString("00000004-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * WRITABLE_CHARACTERISTIC (10sec wait)
         */
        public static final UUID WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S = UUID.fromString("00000005-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * WRITABLE_ERROR_CHARACTERISTIC
         *
         * @see ErrorCodes#REQUEST_NOT_SUPPORTED
         */
        public static final UUID WRITABLE_CHARACTERISTIC_UUID_WITH_ERROR = UUID.fromString("00000006-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * WRITABLE_NO_RESPONSE_CHARACTERISTIC
         *
         * @see BluetoothGattCharacteristic#WRITE_TYPE_NO_RESPONSE
         */
        public static final UUID WRITABLE_NO_RESPONSE_CHARACTERISTIC_UUID = UUID.fromString("00000007-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * NOTIFICATABLE_CHARACTERISTIC_UUID
         *
         * @see BluetoothGattCharacteristic#PROPERTY_NOTIFY
         */
        public static final UUID NOTIFICATABLE_CHARACTERISTIC_UUID = UUID.fromString("00000008-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * INDICATABLE_CHARACTERISTIC_UUID
         *
         * @see BluetoothGattCharacteristic#PROPERTY_INDICATE
         */
        public static final UUID INDICATABLE_CHARACTERISTIC_UUID = UUID.fromString("00000009-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * UNDEFINED_CHARACTERISTIC (for test)
         */
        public static final UUID UNDIFINED_CHARACTERISTIC_UUID = UUID.fromString("fffffffe-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * READABLE_DESCRIPTOR
         */
        public static final UUID READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT = UUID.fromString("0000000a-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * READABLE_DESCRIPTOR (10sec wait)
         */
        public static final UUID READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S = UUID.fromString("0000000b-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * READABLE_ERROR_DESCRIPTOR
         *
         * @see ErrorCodes#REQUEST_NOT_SUPPORTED
         */
        public static final UUID READABLE_DESCRIPTOR_UUID_WITH_ERROR = UUID.fromString("0000000c-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * WRITABLE_DESCRIPTOR
         */
        public static final UUID WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT = UUID.fromString("0000000d-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * WRITABLE_DESCRIPTOR (10sec wait)
         */
        public static final UUID WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S = UUID.fromString("0000000e-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * WRITABLE_ERROR_DESCRIPTOR
         *
         * @see ErrorCodes#REQUEST_NOT_SUPPORTED
         */
        public static final UUID WRITABLE_DESCRIPTOR_UUID_WITH_ERROR = UUID.fromString("0000000f-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * MULTI_INSTANCE_SERVICE
         */
        public static final UUID MULTI_INSTANCE_SERVICE_UUID = UUID.fromString("00000010-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * MULTI_INSTANCE_CHARACTERISTIC
         */
        public static final UUID MULTI_INSTANCE_CHARACTERISTIC_UUID = UUID.fromString("00000011-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * UNDEFINED_DESCRIPTOR (for test)
         */
        public static final UUID UNDIFINED_DESCRIPTOR_UUID = UUID.fromString("fffffffd-a087-4fa3-add4-3b8a7d5d4920");

        /**
         * connected devices
         */
        private final Set<BluetoothDevice> mConnectedDeviceSet = Collections.synchronizedSet(new LinkedHashSet<BluetoothDevice>());

        /**
         * Client Characteristic Configuration (Descriptor UUID: 0x2902) status map
         */
        private final Map<Pair<BluetoothDevice, UUID>, byte[]> mCccdMap = Collections.synchronizedMap(new LinkedHashMap<Pair<BluetoothDevice, UUID>, byte[]>());

        /**
         * response mock map
         */
        private final Map<BluetoothDevice, Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, MockControl>>>> mMockMap = new LinkedHashMap<>();

        /**
         * newest {@link TaskHandler} instance
         */
        private TaskHandler mTaskHandler;

        /**
         * {@inheritDoc}
         */
        public List<BluetoothGattService> getBluetoothGattServiceList() {
            BluetoothGattService bluetoothGattService;
            BluetoothGattCharacteristic bluetoothGattCharacteristic;
            BluetoothGattDescriptor bluetoothGattDescriptor;
            List<BluetoothGattService> list = new LinkedList<>();

            bluetoothGattService = new BluetoothGattService(DEFAULT_SERVICE_UUID, BluetoothGattService.SERVICE_TYPE_PRIMARY);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY | BluetoothGattCharacteristic.PROPERTY_INDICATE, BluetoothGattCharacteristic.PERMISSION_READ);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(READABLE_DESCRIPTOR_UUID_WITH_ERROR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(READABLE_DESCRIPTOR_UUID_WITH_ERROR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(READABLE_CHARACTERISTIC_UUID_WITH_ERROR, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_NOTIFY | BluetoothGattCharacteristic.PROPERTY_INDICATE, BluetoothGattCharacteristic.PERMISSION_WRITE);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(WRITABLE_DESCRIPTOR_UUID_WITH_ERROR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_WRITE);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(WRITABLE_DESCRIPTOR_UUID_WITH_ERROR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WRITABLE_CHARACTERISTIC_UUID_WITH_ERROR, BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_WRITE);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(WRITABLE_NO_RESPONSE_CHARACTERISTIC_UUID, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, BluetoothGattCharacteristic.PERMISSION_WRITE);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(NOTIFICATABLE_CHARACTERISTIC_UUID, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INDICATABLE_CHARACTERISTIC_UUID, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            list.add(bluetoothGattService);

            bluetoothGattService = new BluetoothGattService(MULTI_INSTANCE_SERVICE_UUID, BluetoothGattService.SERVICE_TYPE_PRIMARY);
            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MULTI_INSTANCE_CHARACTERISTIC_UUID, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            list.add(bluetoothGattService);

            bluetoothGattService = new BluetoothGattService(MULTI_INSTANCE_SERVICE_UUID, BluetoothGattService.SERVICE_TYPE_PRIMARY);
            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MULTI_INSTANCE_CHARACTERISTIC_UUID, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            list.add(bluetoothGattService);
            return list;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onCharacteristicReadRequest(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattCharacteristic characteristic) {
            if (READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT.equals(characteristic.getUuid())) {
                bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, 0, MESSAGE_SUCCESS.getBytes());
            } else if (READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S.equals(characteristic.getUuid())) {
                long end = SystemClock.elapsedRealtime() + DateUtils.SECOND_IN_MILLIS * 10;
                do {
                    try {
                        Thread.sleep(end - SystemClock.elapsedRealtime());
                    } catch (InterruptedException e) {
                        BLEPeripheralLogUtils.stackLog(e);
                    }
                } while (end > SystemClock.elapsedRealtime());
                bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, 0, MESSAGE_SUCCESS.getBytes());
            } else if (READABLE_CHARACTERISTIC_UUID_WITH_ERROR.equals(characteristic.getUuid())) {
                bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, 0, null);
            } else if (MULTI_INSTANCE_CHARACTERISTIC_UUID.equals(characteristic.getUuid())) {
                BluetoothGattService bluetoothGattService = characteristic.getService();
                byte[] data = new byte[8];
                ByteBuffer bb = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
                bb.putInt(bluetoothGattService.getInstanceId());
                bb.putInt(characteristic.getInstanceId());
                bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, 0, data);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onCharacteristicWriteRequest(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattCharacteristic characteristic, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value) {
            if (WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT.equals(characteristic.getUuid())) {
                if (responseNeeded) {
                    bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, 0, null);
                }
            } else if (WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S.equals(characteristic.getUuid())) {
                long end = SystemClock.elapsedRealtime() + DateUtils.SECOND_IN_MILLIS * 10;
                do {
                    try {
                        Thread.sleep(end - SystemClock.elapsedRealtime());
                    } catch (InterruptedException e) {
                        BLEPeripheralLogUtils.stackLog(e);
                    }
                } while (end > SystemClock.elapsedRealtime());
                if (responseNeeded) {
                    bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, 0, null);
                }
            } else if (WRITABLE_CHARACTERISTIC_UUID_WITH_ERROR.equals(characteristic.getUuid())) {
                if (responseNeeded) {
                    bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, 0, null);
                }
            } else if (WRITABLE_NO_RESPONSE_CHARACTERISTIC_UUID.equals(characteristic.getUuid())) {
                if (responseNeeded) {
                    bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, 0, null);
                }
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onDescriptorReadRequest(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattDescriptor descriptor) {
            if (READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT.equals(descriptor.getUuid())) {
                bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, 0, MESSAGE_SUCCESS.getBytes());
            } else if (READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S.equals(descriptor.getUuid())) {
                long end = SystemClock.elapsedRealtime() + DateUtils.SECOND_IN_MILLIS * 10;
                do {
                    try {
                        Thread.sleep(end - SystemClock.elapsedRealtime());
                    } catch (InterruptedException e) {
                        BLEPeripheralLogUtils.stackLog(e);
                    }
                } while (end > SystemClock.elapsedRealtime());
                bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, 0, MESSAGE_SUCCESS.getBytes());
            } else if (READABLE_DESCRIPTOR_UUID_WITH_ERROR.equals(descriptor.getUuid())) {
                bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, 0, null);
            } else if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptor.getUuid())) {
                byte[] values;
                Pair<BluetoothDevice, UUID> pair = Pair.create(device, descriptor.getCharacteristic().getUuid());
                if (mCccdMap.containsKey(pair)) {
                    values = mCccdMap.get(pair);
                } else {
                    values = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
                }
                bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, 0, values);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onDescriptorWriteRequest(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattDescriptor descriptor, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value) {
            if (WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT.equals(descriptor.getUuid())) {
                if (responseNeeded) {
                    bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, 0, null);
                }
            } else if (WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S.equals(descriptor.getUuid())) {
                long end = SystemClock.elapsedRealtime() + DateUtils.SECOND_IN_MILLIS * 10;
                do {
                    try {
                        Thread.sleep(end - SystemClock.elapsedRealtime());
                    } catch (InterruptedException e) {
                        BLEPeripheralLogUtils.stackLog(e);
                    }
                } while (end > SystemClock.elapsedRealtime());
                if (responseNeeded) {
                    bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, 0, null);
                }
            } else if (WRITABLE_DESCRIPTOR_UUID_WITH_ERROR.equals(descriptor.getUuid())) {
                if (responseNeeded) {
                    bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, 0, null);
                }
            } else if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptor.getUuid())) {
                if (responseNeeded) {
                    bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, 0, null);
                }
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onNotificationSent(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, int status) {
            if (BluetoothGatt.GATT_SUCCESS == status) {
                mTaskHandler.sendProcessingMessage(NotificationTask.createNotificationSentSuccessMessage(device));
            } else {
                mTaskHandler.sendProcessingMessage(NotificationTask.createNotificationSentErrorMessage(device, status));
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onNotificationSuccess(@NonNull Integer taskId, @NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull byte[] value, @Nullable Bundle argument) {
            createNotificationTask(bluetoothGattServer, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onNotificationFailed(@NonNull Integer taskId, @NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int status, @Nullable Bundle argument) {
            if (ErrorCodes.CANCEL != status) {
                createNotificationTask(bluetoothGattServer, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onNotificationTimeout(@NonNull Integer taskId, @NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, long timeout, @Nullable Bundle argument) {
            createNotificationTask(bluetoothGattServer, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onClientCharacteristicConfigurationUpdated(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull byte[] value) {
            Pair<BluetoothDevice, UUID> pair = Pair.create(device, characteristicUUID);
            byte[] beforeValues = mCccdMap.put(pair, value);
            if ((beforeValues == null || Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, beforeValues))
                    && (Arrays.equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, value) || Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, value))) {
                createNotificationTask(bluetoothGattServer, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onMockUpdated(@NonNull BluetoothDevice device, @NonNull MockControl mockControl) {
            Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, MockControl>>> deviceMap = mMockMap.get(device);
            if (deviceMap == null) {
                deviceMap = new LinkedHashMap<>();
                mMockMap.put(device, deviceMap);
            }
            Pair<UUID, Integer> servicePair = Pair.create(mockControl.getServiceUUID(), mockControl.getServiceInstanceId());
            Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, MockControl>> serviceMap = deviceMap.get(servicePair);
            if (serviceMap == null) {
                serviceMap = new LinkedHashMap<>();
                deviceMap.put(servicePair, serviceMap);
            }
            Pair<UUID, Integer> characteristicPair = Pair.create(mockControl.getCharacteristicUUID(), mockControl.getCharacteristicInstanceId());
            Map<Pair<UUID, Integer>, MockControl> characteristicMap = serviceMap.get(characteristicPair);
            if (characteristicMap == null) {
                characteristicMap = new LinkedHashMap<>();
                serviceMap.put(characteristicPair, characteristicMap);
            }

            if (MockControl.TARGET_CLEAR == mockControl.getTargetType()) {
                int targetType;
                if (MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID.equals(mockControl.getDescriptorUUID())) {
                    targetType = MockControl.TARGET_TYPE_CHARACTERISTIC;
                } else if (MOCK_CONTROL_TARGET_NOTIFICATION_UUID.equals(mockControl.getDescriptorUUID())) {
                    targetType = MockControl.TARGET_TYPE_NOTIFICATION;
                } else {
                    targetType = MockControl.TARGET_TYPE_DESCRIPTOR;
                }
                characteristicMap.remove(Pair.create(mockControl.getDescriptorUUID(), targetType));
            } else {
                characteristicMap.put(Pair.create(mockControl.getDescriptorUUID(), mockControl.getTargetType()), mockControl);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onExecuteWrite(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, int requestId, boolean execute) {
            bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, 0, null);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public synchronized void onServerStarted() {
            if (mTaskHandler == null) {
                mConnectedDeviceSet.clear();
                mCccdMap.clear();

                HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
                thread.start();
                mTaskHandler = new TaskHandler(thread.getLooper());
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public synchronized void onServerStopped() {
            if (mTaskHandler != null) {
                mTaskHandler.quit();
                mTaskHandler = null;
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public synchronized void onDeviceConnected(@NonNull BluetoothDevice device) {
            mConnectedDeviceSet.add(device);

            // clear cccd status
            Iterator<Map.Entry<Pair<BluetoothDevice, UUID>, byte[]>> it = mCccdMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Pair<BluetoothDevice, UUID>, byte[]> entry = it.next();
                if (entry.getKey().first.equals(device)) {
                    it.remove();
                }
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public synchronized void onDeviceDisconnected(@NonNull BluetoothDevice device) {
            mConnectedDeviceSet.remove(device);
            mMockMap.remove(device);
        }

        /**
         * create notification(indication) task
         *
         * @param bluetoothGattServer      {@link BluetoothGattServer} instance
         * @param device                   notification(indication) target device
         * @param serviceUUID              service {@link UUID}
         * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
         * @param characteristicUUID       characteristic {@link UUID}
         * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
         */
        private synchronized void createNotificationTask(@NonNull BluetoothGattServer bluetoothGattServer
                , @NonNull BluetoothDevice device
                , @NonNull UUID serviceUUID
                , int serviceInstanceId
                , @NonNull UUID characteristicUUID
                , int characteristicInstanceId) {
            if (mConnectedDeviceSet.contains(device)) {
                Pair pair = Pair.create(device, characteristicUUID);
                byte[] values = mCccdMap.get(pair);
                boolean isIndication = Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, values);
                if (isIndication || Arrays.equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, values)) {
                    MockControl mockControl = findMockControl(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
                    final byte[] value;
                    if (mockControl == null) {
                        value = new Date().toString().getBytes();
                    } else {
                        value = mockControl.getValue();
                    }
                    NotificationTask task = new NotificationTask(
                            this
                            , bluetoothGattServer
                            , device
                            , mTaskHandler
                            , serviceUUID
                            , serviceInstanceId
                            , characteristicUUID
                            , characteristicInstanceId
                            , new ByteArrayInterface() {

                        @Override
                        @NonNull
                        public byte[] getBytes() {
                            return value;
                        }
                    }
                            , isIndication
                            , NotificationTask.TIMEOUT_MILLIS
                            , null);
                    mTaskHandler.addTaskDelayed(task, DateUtils.SECOND_IN_MILLIS);
                }
            }
        }

        /**
         * find matched {@link MockControl}
         *
         * @param bluetoothDevice          central BLE device
         * @param serviceUUID              target service
         * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
         * @param characteristicUUID       target characteristic
         * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
         * @return matched {@link MockControl}
         */
        private MockControl findMockControl(@NonNull BluetoothDevice bluetoothDevice
                , @NonNull UUID serviceUUID
                , int serviceInstanceId
                , @NonNull UUID characteristicUUID
                , int characteristicInstanceId) {
            MockControl mockControl = null;

            Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, MockControl>>> deviceMap = mMockMap.get(bluetoothDevice);
            if (deviceMap != null) {
                for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, MockControl>>> serviceEntry : deviceMap.entrySet()) {
                    Pair<UUID, Integer> servicePair = serviceEntry.getKey();
                    if (servicePair.first.equals(serviceUUID) && (servicePair.second == null || (servicePair.second.equals(serviceInstanceId)))) {
                        Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, MockControl>> serviceMap = serviceEntry.getValue();
                        for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, MockControl>> characteristicEntry : serviceMap.entrySet()) {
                            Pair<UUID, Integer> characteristicPair = characteristicEntry.getKey();
                            if (characteristicPair.first.equals(characteristicUUID) && (characteristicPair.second == null || (characteristicPair.second.equals(characteristicInstanceId)))) {
                                Map<Pair<UUID, Integer>, MockControl> characteristicMap = characteristicEntry.getValue();
                                mockControl = characteristicMap.get(Pair.create(MOCK_CONTROL_TARGET_NOTIFICATION_UUID, MockControl.TARGET_TYPE_NOTIFICATION));
                                break;
                            }
                        }
                        if (mockControl != null) {
                            break;
                        }
                    }
                }
            }
            return mockControl;
        }

    }

    /**
     * SERVICE_UUID for Advertising
     *
     * @see org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes#DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS
     */
    public static final UUID MOCK_CONTROL_SERVICE_UUID = UUID.fromString("00000000-a087-4fa3-add4-3b8a7d5d491f");

    /**
     * mock control from central
     */
    public static final UUID MOCK_CONTROL_CHARACTERISTIC_UUID = UUID.fromString("00000001-a087-4fa3-add4-3b8a7d5d491f");

    /**
     * mock target characteristic
     */
    public static final UUID MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID = UUID.fromString("ffffffff-a087-4fa3-add4-3b8a7d5d491f");

    /**
     * mock target notification(indication)
     */
    public static final UUID MOCK_CONTROL_TARGET_NOTIFICATION_UUID = UUID.fromString("fffffffe-a087-4fa3-add4-3b8a7d5d491f");

    /**
     * {@link Context} instance
     */
    private final Context mContext;

    /**
     * {@link BluetoothManager} instance
     */
    private final BluetoothManager mBluetoothManager;

    /**
     * {@link BluetoothAdapter} instance
     */
    private final BluetoothAdapter mBluetoothAdapter;

    /**
     * connected devices
     */
    private final Set<BluetoothDevice> mConnectedDeviceSet = Collections.synchronizedSet(new LinkedHashSet<BluetoothDevice>());

    /**
     * Client Characteristic Configuration (Descriptor UUID: 0x2902) status map
     */
    private final Map<Pair<BluetoothDevice, Pair<UUID, Integer>>, byte[]> mCccdMap = new LinkedHashMap<>();

    /**
     * response mock map
     */
    private final Map<BluetoothDevice, Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, MockControl>>>> mMockMap = new LinkedHashMap<>();

    /**
     * {@link BLEServerCallback} instance
     */
    private BLEServerCallback mBLEServerCallback;

    /**
     * {@link BluetoothGattServer} instance
     */
    private BluetoothGattServer mBluetoothGattServer;

    /**
     * temporary service list for {@link BluetoothGattServer#addService(BluetoothGattService)} loop
     */
    private Queue<BluetoothGattService> mWorkBluetoothGattServiceList;

    /**
     * {@link AdvertiseCallback} instance
     */
    private AdvertiseCallback mAdvertiseCallback;

    /**
     * {@link BluetoothLeAdvertiser} instance
     */
    private BluetoothLeAdvertiser mBluetoothLeAdvertiser;


    /**
     * @param context           {@link Context} instance
     * @param bleServerCallback {@link BLEServerCallback} instance
     */
    public BLEServerConnection(@NonNull Context context
            , @NonNull BLEServerCallback bleServerCallback) {
        mContext = context;
        mBluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        mBLEServerCallback = bleServerCallback;
    }

    /**
     * check server status
     *
     * @return {@code true}:{@link BluetoothGattServer} and {@link BluetoothLeAdvertiser} started, {@code false}: server stopped
     */
    public boolean isStarted() {
        return mAdvertiseCallback != null;
    }

    /**
     * start {@link BluetoothGattServer} and {@link BluetoothLeAdvertiser}
     */
    public synchronized void start() {
        if (mBluetoothGattServer == null) {
            mCccdMap.clear();
            mMockMap.clear();

            mBluetoothGattServer = mBluetoothManager.openGattServer(mContext, this);

            mWorkBluetoothGattServiceList = new LinkedList<>(mBLEServerCallback.getBluetoothGattServiceList());
            BluetoothGattService bluetoothGattService = new BluetoothGattService(MOCK_CONTROL_SERVICE_UUID, BluetoothGattService.SERVICE_TYPE_PRIMARY);
            bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(
                    MOCK_CONTROL_CHARACTERISTIC_UUID
                    , BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_WRITE
            ));
            mBluetoothGattServer.addService(bluetoothGattService);
        }
    }

    /**
     * <p>
     * update server response callback
     *
     * <b>Warning</b> change peripheral's service / characteristic / descriptor setting after bonded, central's {@link android.bluetooth.BluetoothGattCallback#onConnectionStateChange(BluetoothGatt, int, int)} return 133 error.
     * if you change peripheral's service / characteristic / descriptor setting, need re-bonding.
     * </p>
     *
     * @param bleServerCallback new server response callback
     */
    public synchronized void updateServerCallback(@NonNull BLEServerCallback bleServerCallback) {
        if (mBluetoothGattServer != null) {
            mBLEServerCallback.onServerStopped();
        }

        mBLEServerCallback = bleServerCallback;

        if (mBluetoothGattServer != null) {
            mBLEServerCallback.onServerStarted();

            // set current connected device
            for (BluetoothDevice device : mConnectedDeviceSet) {
                mBLEServerCallback.onDeviceConnected(device);
            }

            // set current cccd status
            for (Map.Entry<Pair<BluetoothDevice, Pair<UUID, Integer>>, byte[]> entry : mCccdMap.entrySet()) {
                BluetoothDevice device = entry.getKey().first;
                Pair<UUID, Integer> characteristicPair = entry.getKey().second;
                UUID characteristicUUID = characteristicPair.first;

                for (BluetoothGattService service : mBluetoothGattServer.getServices()) {
                    if (service.getCharacteristic(characteristicUUID) != null) {
                        mBLEServerCallback.onClientCharacteristicConfigurationUpdated(mBluetoothGattServer, device, service.getUuid(), service.getInstanceId(), characteristicUUID, characteristicPair.second, entry.getValue());
                        break;
                    }
                }
            }
        }
    }

    /**
     * stop {@link BluetoothGattServer} and {@link BluetoothLeAdvertiser}
     */
    public synchronized void quit() {
        if (mBluetoothLeAdvertiser != null) {
            mBluetoothLeAdvertiser.stopAdvertising(mAdvertiseCallback);
            mAdvertiseCallback = null;
            mBluetoothLeAdvertiser = null;
        }

        if (mBluetoothGattServer != null) {
            mBluetoothGattServer.close();
            mBluetoothGattServer = null;
            mConnectedDeviceSet.clear();
            mBLEServerCallback.onServerStopped();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onConnectionStateChange(@NonNull BluetoothDevice device
            , int status
            , int newState) {
        if (BluetoothProfile.STATE_CONNECTED == newState) {
            mConnectedDeviceSet.add(device);
            mBLEServerCallback.onDeviceConnected(device);
        } else if (BluetoothProfile.STATE_DISCONNECTED == newState) {
            mConnectedDeviceSet.remove(device);
            mMockMap.remove(device);
            mBLEServerCallback.onDeviceDisconnected(device);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onServiceAdded(int status
            , @NonNull BluetoothGattService service) {
        if (mBluetoothGattServer != null) {
            if (BluetoothGatt.GATT_SUCCESS == status) {
                BluetoothGattService next = mWorkBluetoothGattServiceList.poll();
                if (next == null) {
                    // add finished, start advertising
                    if (mAdvertiseCallback == null) {
                        AdvertiseSettings.Builder asBuilder = new AdvertiseSettings.Builder();
                        asBuilder.setConnectable(true);
                        asBuilder.setAdvertiseMode(ADVERTISE_MODE_LOW_LATENCY);
                        AdvertiseData.Builder adBuilder = new AdvertiseData.Builder();
                        adBuilder.setIncludeDeviceName(false);
                        adBuilder.addServiceUuid(new ParcelUuid(MOCK_CONTROL_SERVICE_UUID));
                        mAdvertiseCallback = new AdvertiseCallback() {

                            /**
                             * {@inheritDoc}
                             */
                            @Override
                            public void onStartSuccess(AdvertiseSettings settingsInEffect) {
                                BLEServerCallback bleServerCallback = mBLEServerCallback;
                                if (bleServerCallback != null) {
                                    bleServerCallback.onServerStarted();
                                }
                            }

                            /**
                             * {@inheritDoc}
                             */
                            @Override
                            public void onStartFailure(int errorCode) {
                                quit();
                            }

                        };
                        mBluetoothLeAdvertiser = mBluetoothAdapter.getBluetoothLeAdvertiser();
                        mBluetoothLeAdvertiser.startAdvertising(asBuilder.build(), adBuilder.build(), mAdvertiseCallback);
                    }
                } else {
                    // add next service

                    mBluetoothGattServer.addService(next);
                }
            } else {
                quit();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadRequest(@NonNull BluetoothDevice device
            , int requestId
            , int offset
            , @NonNull BluetoothGattCharacteristic characteristic) {
        MockControl mockControl = findMockControl(device, characteristic.getService().getUuid(), characteristic.getService().getInstanceId(), characteristic.getUuid(), characteristic.getInstanceId(), MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, MockControl.TARGET_TYPE_CHARACTERISTIC);
        if (mockControl == null) {
            mBLEServerCallback.onCharacteristicReadRequest(mBluetoothGattServer, device, requestId, offset, characteristic);
        } else {
            mBluetoothGattServer.sendResponse(device, requestId, mockControl.getStatus(), 0, mockControl.getValue());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteRequest(@NonNull BluetoothDevice device
            , int requestId
            , @NonNull BluetoothGattCharacteristic characteristic
            , boolean preparedWrite
            , boolean responseNeeded
            , int offset
            , @NonNull byte[] value) {
        MockControl mockControl = null;
        if (MOCK_CONTROL_CHARACTERISTIC_UUID.equals(characteristic.getUuid())) {
            try {
                mockControl = MockControl.CREATOR.createFromByteArray(Arrays.copyOfRange(value, offset, value.length));
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }

            int status;
            if (mockControl == null) {
                status = APPLICATION_ERROR_9F;
            } else {
                if (MOCK_CONTROL_SERVICE_UUID.equals(mockControl.getServiceUUID()) && MOCK_CONTROL_CHARACTERISTIC_UUID.equals(mockControl.getCharacteristicUUID())) {
                    status = APPLICATION_ERROR_9F;
                } else {
                    status = BluetoothGatt.GATT_SUCCESS;

                    Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, MockControl>>> deviceMap = mMockMap.get(device);
                    if (deviceMap == null) {
                        deviceMap = new LinkedHashMap<>();
                        mMockMap.put(device, deviceMap);
                    }
                    Pair<UUID, Integer> servicePair = Pair.create(mockControl.getServiceUUID(), mockControl.getServiceInstanceId());
                    Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, MockControl>> serviceMap = deviceMap.get(servicePair);
                    if (serviceMap == null) {
                        serviceMap = new LinkedHashMap<>();
                        deviceMap.put(servicePair, serviceMap);
                    }
                    Pair<UUID, Integer> characteristicPair = Pair.create(mockControl.getCharacteristicUUID(), mockControl.getCharacteristicInstanceId());
                    Map<Pair<UUID, Integer>, MockControl> characteristicMap = serviceMap.get(characteristicPair);
                    if (characteristicMap == null) {
                        characteristicMap = new LinkedHashMap<>();
                        serviceMap.put(characteristicPair, characteristicMap);
                    }

                    if (MockControl.TARGET_CLEAR == mockControl.getTargetType()) {
                        int targetType;
                        if (MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID.equals(mockControl.getDescriptorUUID())) {
                            targetType = MockControl.TARGET_TYPE_CHARACTERISTIC;
                        } else if (MOCK_CONTROL_TARGET_NOTIFICATION_UUID.equals(mockControl.getDescriptorUUID())) {
                            targetType = MockControl.TARGET_TYPE_NOTIFICATION;
                        } else {
                            targetType = MockControl.TARGET_TYPE_DESCRIPTOR;
                        }
                        characteristicMap.remove(Pair.create(mockControl.getDescriptorUUID(), targetType));
                    } else {
                        characteristicMap.put(Pair.create(mockControl.getDescriptorUUID(), mockControl.getTargetType()), mockControl);
                    }

                    mBLEServerCallback.onMockUpdated(device, mockControl);
                }
            }

            if (responseNeeded) {
                mBluetoothGattServer.sendResponse(device, requestId, status, 0, null);
            }
        } else {
            mockControl = findMockControl(device, characteristic.getService().getUuid(), characteristic.getService().getInstanceId(), characteristic.getUuid(), characteristic.getInstanceId(), MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, MockControl.TARGET_TYPE_CHARACTERISTIC);
            if (mockControl == null) {
                mBLEServerCallback.onCharacteristicWriteRequest(mBluetoothGattServer, device, requestId, characteristic, preparedWrite, responseNeeded, offset, value);
            } else if (responseNeeded) {
                mBluetoothGattServer.sendResponse(device, requestId, mockControl.getStatus(), 0, mockControl.getValue());
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadRequest(@NonNull BluetoothDevice device
            , int requestId
            , int offset
            , @NonNull BluetoothGattDescriptor descriptor) {
        MockControl mockControl = findMockControl(device, descriptor.getCharacteristic().getService().getUuid(), descriptor.getCharacteristic().getService().getInstanceId(), descriptor.getCharacteristic().getUuid(), descriptor.getCharacteristic().getInstanceId(), descriptor.getUuid(), MockControl.TARGET_TYPE_DESCRIPTOR);
        if (mockControl == null) {
            mBLEServerCallback.onDescriptorReadRequest(mBluetoothGattServer, device, requestId, offset, descriptor);
        } else {
            mBluetoothGattServer.sendResponse(device, requestId, mockControl.getStatus(), 0, mockControl.getValue());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteRequest(@NonNull BluetoothDevice device
            , int requestId
            , BluetoothGattDescriptor descriptor
            , boolean preparedWrite
            , boolean responseNeeded
            , int offset
            , @NonNull byte[] value) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = descriptor.getCharacteristic();
        BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
        MockControl mockControl = findMockControl(device, descriptor.getCharacteristic().getService().getUuid(), descriptor.getCharacteristic().getService().getInstanceId(), bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getInstanceId(), descriptor.getUuid(), MockControl.TARGET_TYPE_DESCRIPTOR);
        if (mockControl == null) {
            mBLEServerCallback.onDescriptorWriteRequest(mBluetoothGattServer, device, requestId, descriptor, preparedWrite, responseNeeded, offset, value);
        } else if (responseNeeded) {
            mBluetoothGattServer.sendResponse(device, requestId, mockControl.getStatus(), 0, mockControl.getValue());
        }

        // update cccd status
        if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptor.getUuid())) {
            mCccdMap.put(Pair.create(device, Pair.create(bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getInstanceId())), value);
            mBLEServerCallback.onClientCharacteristicConfigurationUpdated(mBluetoothGattServer, device, bluetoothGattService.getUuid(), bluetoothGattService.getInstanceId(), bluetoothGattCharacteristic.getUuid(), bluetoothGattCharacteristic.getInstanceId(), value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onExecuteWrite(BluetoothDevice device
            , int requestId
            , boolean execute) {
        mBLEServerCallback.onExecuteWrite(mBluetoothGattServer, device, requestId, execute);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onNotificationSent(BluetoothDevice device
            , int status) {
        mBLEServerCallback.onNotificationSent(mBluetoothGattServer, device, status);
    }

    /**
     * find matched {@link MockControl}
     *
     * @param bluetoothDevice          central BLE device
     * @param serviceUUID              target service {@link UUID}
     * @param serviceInstanceId        target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       target characteristic {@link UUID}
     * @param characteristicInstanceId target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           target descriptor UUID
     * @param targetType               {@link MockControl#TARGET_TYPE_CHARACTERISTIC} or {@link MockControl#TARGET_TYPE_DESCRIPTOR}
     * @return matched {@link MockControl}
     */
    private MockControl findMockControl(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , int serviceInstanceId
            , @NonNull UUID characteristicUUID
            , int characteristicInstanceId
            , @NonNull UUID descriptorUUID
            , int targetType) {
        MockControl mockControl = null;
        Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, MockControl>>> deviceMap = mMockMap.get(bluetoothDevice);
        if (deviceMap != null) {
            for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, MockControl>>> serviceEntry : deviceMap.entrySet()) {
                Pair<UUID, Integer> servicePair = serviceEntry.getKey();
                if (servicePair.first.equals(serviceUUID) && (servicePair.second == null || (servicePair.second.equals(serviceInstanceId)))) {
                    Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, MockControl>> serviceMap = serviceEntry.getValue();
                    for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, MockControl>> characteristicEntry : serviceMap.entrySet()) {
                        Pair<UUID, Integer> characteristicPair = characteristicEntry.getKey();
                        if (characteristicPair.first.equals(characteristicUUID) && (characteristicPair.second == null || (characteristicPair.second.equals(characteristicInstanceId)))) {
                            Map<Pair<UUID, Integer>, MockControl> characteristicMap = characteristicEntry.getValue();
                            mockControl = characteristicMap.get(Pair.create(descriptorUUID, targetType));
                            break;
                        }
                    }
                    if (mockControl != null) {
                        break;
                    }
                }
            }
        }
        return mockControl;
    }

}
