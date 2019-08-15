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
import android.os.Message;
import android.os.ParcelUuid;
import android.os.SystemClock;
import android.text.format.DateUtils;
import android.util.Pair;

import org.im97mori.ble.task.NotificationTask;

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
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR;

/**
 * BLE Connection(peripheral role)
 */
@SuppressWarnings("WeakerAccess")
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class BLEServerConnection extends BluetoothGattServerCallback {

    /**
     * Default server setting
     */
    public static class DefaultServerSetting implements BLEServerCallback {

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
         * @see org.im97mori.ble.BLEConstants.ErrorCodes#REQUEST_NOT_SUPPORTED
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
         * @see org.im97mori.ble.BLEConstants.ErrorCodes#REQUEST_NOT_SUPPORTED
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
         * @see org.im97mori.ble.BLEConstants.ErrorCodes#REQUEST_NOT_SUPPORTED
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
         * @see org.im97mori.ble.BLEConstants.ErrorCodes#REQUEST_NOT_SUPPORTED
         */
        public static final UUID WRITABLE_DESCRIPTOR_UUID_WITH_ERROR = UUID.fromString("0000000f-a087-4fa3-add4-3b8a7d5d4920");

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
            bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INDICATABLE_CHARACTERISTIC_UUID, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
            bluetoothGattDescriptor = new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE);
            bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
            bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

            list.add(bluetoothGattService);
            return list;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean onCharacteristicReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, int offset, BluetoothGattCharacteristic characteristic) {
            boolean result = false;
            if (READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT.equals(characteristic.getUuid())) {
                result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, MESSAGE_SUCCESS.getBytes());
            } else if (READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S.equals(characteristic.getUuid())) {
                long end = SystemClock.elapsedRealtime() + DateUtils.SECOND_IN_MILLIS * 10;
                do {
                    try {
                        Thread.sleep(end - SystemClock.elapsedRealtime());
                    } catch (InterruptedException e) {
                        BLELogUtils.stackLog(e);
                    }
                } while (end > SystemClock.elapsedRealtime());
                result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, MESSAGE_SUCCESS.getBytes());
            } else if (READABLE_CHARACTERISTIC_UUID_WITH_ERROR.equals(characteristic.getUuid())) {
                result = bluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.VALUE_NOT_ALLOWED, offset, null);
            }
            return result;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean onCharacteristicWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, BluetoothGattCharacteristic characteristic, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
            boolean result = false;
            if (WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT.equals(characteristic.getUuid())) {
                if (responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, null);
                }
            } else if (WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S.equals(characteristic.getUuid())) {
                long end = SystemClock.elapsedRealtime() + DateUtils.SECOND_IN_MILLIS * 10;
                do {
                    try {
                        Thread.sleep(end - SystemClock.elapsedRealtime());
                    } catch (InterruptedException e) {
                        BLELogUtils.stackLog(e);
                    }
                } while (end > SystemClock.elapsedRealtime());
                if (responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, null);
                }
            } else if (WRITABLE_CHARACTERISTIC_UUID_WITH_ERROR.equals(characteristic.getUuid())) {
                if (responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.VALUE_NOT_ALLOWED, offset, null);
                }
            }
            return result;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean onDescriptorReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, int offset, BluetoothGattDescriptor descriptor) {
            boolean result = false;
            if (READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT.equals(descriptor.getUuid())) {
                result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, MESSAGE_SUCCESS.getBytes());
            } else if (READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S.equals(descriptor.getUuid())) {
                long end = SystemClock.elapsedRealtime() + DateUtils.SECOND_IN_MILLIS * 10;
                do {
                    try {
                        Thread.sleep(end - SystemClock.elapsedRealtime());
                    } catch (InterruptedException e) {
                        BLELogUtils.stackLog(e);
                    }
                } while (end > SystemClock.elapsedRealtime());
                result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, MESSAGE_SUCCESS.getBytes());
            } else if (READABLE_DESCRIPTOR_UUID_WITH_ERROR.equals(descriptor.getUuid())) {
                result = bluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.VALUE_NOT_ALLOWED, offset, null);
            } else if (CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR.equals(descriptor.getUuid())) {
                byte[] values;
                Pair<BluetoothDevice, UUID> pair = Pair.create(device, descriptor.getCharacteristic().getUuid());
                if (mCccdMap.containsKey(pair)) {
                    values = mCccdMap.get(pair);
                } else {
                    values = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
                }
                result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, values);
            }
            return result;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean onDescriptorWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, BluetoothGattDescriptor descriptor, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
            boolean result = false;
            if (WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT.equals(descriptor.getUuid())) {
                if (responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, null);
                }
            } else if (WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S.equals(descriptor.getUuid())) {
                long end = SystemClock.elapsedRealtime() + DateUtils.SECOND_IN_MILLIS * 10;
                do {
                    try {
                        Thread.sleep(end - SystemClock.elapsedRealtime());
                    } catch (InterruptedException e) {
                        BLELogUtils.stackLog(e);
                    }
                } while (end > SystemClock.elapsedRealtime());
                if (responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, null);
                }
            } else if (WRITABLE_DESCRIPTOR_UUID_WITH_ERROR.equals(descriptor.getUuid())) {
                if (responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.VALUE_NOT_ALLOWED, offset, null);
                }
            } else if (CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR.equals(descriptor.getUuid())) {
                if (responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, null);
                }
            }
            return result;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onNotificationSuccess(long taskId, BluetoothGattServer bluetoothGattServer, BluetoothDevice device, UUID serviceUUID, UUID chacteristicUUID, byte[] value, Bundle argument) {
            createNotificationTask(bluetoothGattServer, device, serviceUUID, chacteristicUUID);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onNotificationFailed(long taskId, BluetoothGattServer bluetoothGattServer, BluetoothDevice device, UUID serviceUUID, UUID chacteristicUUID, int status, Bundle argument) {
            createNotificationTask(bluetoothGattServer, device, serviceUUID, chacteristicUUID);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onClientCharacteristicConfigurationUpdated(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] value) {
            Pair<BluetoothDevice, UUID> pair = Pair.create(device, characteristicUUID);
            byte[] beforeValues = mCccdMap.put(pair, value);
            if ((beforeValues == null || Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, beforeValues))
                    && (Arrays.equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, value) || Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, value))) {
                createNotificationTask(bluetoothGattServer, device, serviceUUID, characteristicUUID);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public synchronized void onServerStarted() {
            if (mTaskHandler == null) {
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

                mConnectedDeviceSet.clear();
                mCccdMap.clear();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public synchronized void onDeviceConnected(BluetoothDevice device) {
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
        public synchronized void onDeviceDisconnected(BluetoothDevice device) {
            mConnectedDeviceSet.remove(device);
        }

        /**
         * create notification(indication) task
         *
         * @param bluetoothGattServer {@link BluetoothGattServer} instance
         * @param device              notification(indication) target device
         * @param serviceUUID         service {@link UUID}
         * @param characteristicUUID  characteristic {@link UUID}
         */
        private synchronized void createNotificationTask(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID) {
            if (mConnectedDeviceSet.contains(device)) {
                Pair pair = Pair.create(device, characteristicUUID);
                byte[] values = mCccdMap.get(pair);
                boolean isIndication = Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, values);
                if (isIndication || Arrays.equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, values)) {
                    NotificationTask task = new NotificationTask(
                            this
                            , bluetoothGattServer
                            , device
                            , serviceUUID
                            , characteristicUUID
                            , new ByteArrayInterface() {
                        @Override
                        public byte[] getBytes() {
                            return new Date().toString().getBytes();
                        }
                    }
                            , isIndication
                            , null);
                    Message message = NotificationTask.createNotificationMessage(task);
                    mTaskHandler.addTaskDelayed(task, message, DateUtils.SECOND_IN_MILLIS);
                }
            }
        }

    }

    /**
     * SERVICE_UUID for Advertising
     *
     * @see org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes#DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS
     */
    public static final UUID CONTROL_SERVICE_UUID = UUID.fromString("00000000-a087-4fa3-add4-3b8a7d5d491f");

    /**
     * TODO
     */
    public static final UUID CONTROL_CHARACTERISTIC_UUID = UUID.fromString("00000001-a087-4fa3-add4-3b8a7d5d491f");

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
    private final Map<Pair<BluetoothDevice, UUID>, byte[]> mCccdMap = Collections.synchronizedMap(new LinkedHashMap<Pair<BluetoothDevice, UUID>, byte[]>());

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
     * TODO
     */
    private long mLastUpdate;

    /**
     * @param context           {@link Context} instance
     * @param bleServerCallback {@link BLEServerCallback} instance
     */
    public BLEServerConnection(Context context, BLEServerCallback bleServerCallback) {
        mContext = context;
        mBluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = mBluetoothManager.getAdapter();
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
            mBluetoothGattServer = mBluetoothManager.openGattServer(mContext, this);

            mWorkBluetoothGattServiceList = new LinkedList<>(mBLEServerCallback.getBluetoothGattServiceList());
            BluetoothGattService bluetoothGattService = new BluetoothGattService(CONTROL_SERVICE_UUID, BluetoothGattService.SERVICE_TYPE_PRIMARY);
            bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(
                    CONTROL_CHARACTERISTIC_UUID
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
            ));
            mBluetoothGattServer.addService(bluetoothGattService);

            // TODO
            mLastUpdate = SystemClock.elapsedRealtime();
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
    public synchronized void updateServerCallback(BLEServerCallback bleServerCallback) {
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
            for (Map.Entry<Pair<BluetoothDevice, UUID>, byte[]> entry : mCccdMap.entrySet()) {
                BluetoothDevice device = entry.getKey().first;
                UUID characteristicUUID = entry.getKey().second;

                for (BluetoothGattService service : mBluetoothGattServer.getServices()) {
                    if (service.getCharacteristic(characteristicUUID) != null) {
                        mBLEServerCallback.onClientCharacteristicConfigurationUpdated(mBluetoothGattServer, device, service.getUuid(), characteristicUUID, entry.getValue());
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
            mCccdMap.clear();
            mBLEServerCallback.onServerStopped();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onConnectionStateChange(BluetoothDevice device, int status, int newState) {
        if (BluetoothProfile.STATE_CONNECTED == newState) {
            mConnectedDeviceSet.add(device);
            mBLEServerCallback.onDeviceConnected(device);
        } else if (BluetoothProfile.STATE_DISCONNECTED == newState) {
            mConnectedDeviceSet.remove(device);
            mBLEServerCallback.onDeviceDisconnected(device);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onServiceAdded(int status, BluetoothGattService service) {
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
                        adBuilder.addServiceUuid(new ParcelUuid(CONTROL_SERVICE_UUID));
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
    public synchronized void onCharacteristicReadRequest(BluetoothDevice device, int requestId, int offset, BluetoothGattCharacteristic characteristic) {
        boolean result = false;
        if (CONTROL_CHARACTERISTIC_UUID.equals(characteristic.getUuid())) {
            characteristic.setValue(String.valueOf(mLastUpdate));
            result = mBluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, offset, String.valueOf(mLastUpdate).getBytes());
        } else {
            if (mBLEServerCallback != null) {
                result = mBLEServerCallback.onCharacteristicReadRequest(mBluetoothGattServer, device, requestId, offset, characteristic);
            }
        }

        // fallback response
        // if you dont response, cause 133 error
        if (!result) {
            mBluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.REQUEST_NOT_SUPPORTED, offset, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteRequest(BluetoothDevice device, int requestId, BluetoothGattCharacteristic characteristic, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
        boolean result = false;
        if (CONTROL_CHARACTERISTIC_UUID.equals(characteristic.getUuid())) {
            // TODO
        } else {
            if (mBLEServerCallback != null) {
                result = mBLEServerCallback.onCharacteristicWriteRequest(mBluetoothGattServer, device, requestId, characteristic, preparedWrite, responseNeeded, offset, value);
            }
        }

        // fallback response
        // if you dont response, cause 133 error
        if (responseNeeded && !result) {
            mBluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.REQUEST_NOT_SUPPORTED, offset, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadRequest(BluetoothDevice device, int requestId, int offset, BluetoothGattDescriptor descriptor) {
        boolean result = false;
        if (mBLEServerCallback != null) {
            result = mBLEServerCallback.onDescriptorReadRequest(mBluetoothGattServer, device, requestId, offset, descriptor);
        }

        // fallback response
        // if you dont response, cause 133 error
        if (!result) {
            mBluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.REQUEST_NOT_SUPPORTED, offset, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteRequest(BluetoothDevice device, int requestId, BluetoothGattDescriptor descriptor, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
        boolean result = false;
        if (mBLEServerCallback != null) {
            result = mBLEServerCallback.onDescriptorWriteRequest(mBluetoothGattServer, device, requestId, descriptor, preparedWrite, responseNeeded, offset, value);
        }

        // update cccd status
        if (CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR.equals(descriptor.getUuid())) {
            mCccdMap.put(Pair.create(device, descriptor.getCharacteristic().getUuid()), value);
            mBLEServerCallback.onClientCharacteristicConfigurationUpdated(mBluetoothGattServer, device, descriptor.getCharacteristic().getService().getUuid(), descriptor.getCharacteristic().getUuid(), value);
        }

        // fallback response
        // if you dont response, cause 133 error
        if (responseNeeded && !result) {
            mBluetoothGattServer.sendResponse(device, requestId, BLEConstants.ErrorCodes.REQUEST_NOT_SUPPORTED, offset, null);
        }
    }

}
