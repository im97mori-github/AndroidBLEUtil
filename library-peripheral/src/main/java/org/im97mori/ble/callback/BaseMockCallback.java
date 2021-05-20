package org.im97mori.ble.callback;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEPeripheralLogUtils;
import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.task.AddServiceTask;
import org.im97mori.ble.task.NotificationTask;
import org.im97mori.ble.task.RemoveServiceTask;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ErrorCodes.APPLICATION_ERROR_9F;

/**
 * MockCallback base class
 */
@SuppressWarnings({"WeakerAccess"})
public abstract class BaseMockCallback implements BLEServerCallback {

    /**
     * KEY:SERVICE_DATA
     */
    protected static final String KEY_SERVICE_DATA = "KEY_SERVICE_DATA";

    /**
     * KEY:NOTIFICATION_COUNT
     */
    protected static final String KEY_NOTIFICATION_COUNT = "KEY_NOTIFICATION_COUNT";

    /**
     * KEY:DESCRIPTOR_INSTANCE_ID
     */
    protected static final String KEY_DESCRIPTOR_INSTANCE_ID = "KEY_DESCRIPTOR_INSTANCE_ID";

    /**
     * KEY:ORIGINAL_ARGUMENT
     */
    protected static final String KEY_ORIGINAL_ARGUMENT = "KEY_ORIGINAL_ARGUMENT";

    /**
     * notification interval:1s
     */
    protected static final long NOTIFICATION_INTERVAL = 1000L;

    /**
     * {@link MockData} callback
     */
    private final MockData mMockData;

    /**
     * fallback flag
     */
    private final boolean mIsFallback;

    /**
     * available service map
     */
    protected final Map<Pair<UUID, Integer>, BluetoothGattService> mAvailableServiceMap = new HashMap<>();

    /**
     * characteristic data with instance id
     */
    protected final Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, CharacteristicData>> mRemappedServiceCharacteristicMap = new HashMap<>();

    /**
     * descriptor data with instance id
     */
    protected final Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, DescriptorData>> mRemappedCharacteristicDescriptorMap = new HashMap<>();

    /**
     * reliable write status
     * {@code true}:in reliable write
     */
    protected boolean mIsReliable = false;

    /**
     * connected central devices
     */
    protected final Set<BluetoothDevice> mConnectedDeviceSet = new HashSet<>();

    /**
     * activated notification or indication map
     */
    protected final Hashtable<NotificationData, Integer> mActivatedNotificationMap = new Hashtable<>();

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     * @see BaseMockCallback#BaseMockCallback(List, boolean)
     */
    public BaseMockCallback(@NonNull MockData mockData, boolean isFallback) {
        this(Collections.singletonList(mockData), isFallback);
    }

    /**
     * @param mockDataList {@link MockData} instance list
     * @param isFallback   fallback flag
     */
    public BaseMockCallback(@NonNull List<MockData> mockDataList, boolean isFallback) {
        mMockData = new MockData();
        for (MockData mockData : mockDataList) {
            mMockData.serviceDataList.addAll(mockData.serviceDataList);
        }
        mIsFallback = isFallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void setup(@NonNull BLEServerConnection bleServerConnection) {
        mRemappedServiceCharacteristicMap.clear();
        mRemappedCharacteristicDescriptorMap.clear();
        mAvailableServiceMap.clear();

        BluetoothGattService bluetoothGattService;
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        BluetoothGattDescriptor bluetoothGattDescriptor;
        Bundle bundle;

        for (ServiceData serviceData : mMockData.serviceDataList) {
            bluetoothGattService = new BluetoothGattService(serviceData.uuid, serviceData.type);
            for (CharacteristicData characteristicData : serviceData.characteristicDataList) {
                characteristicData.currentData = null;
                characteristicData.temporaryData = null;
                bluetoothGattCharacteristic = new BluetoothGattCharacteristic(
                        characteristicData.uuid
                        , characteristicData.property
                        , characteristicData.permission);
                bluetoothGattCharacteristic.setValue(characteristicData.getBytes());
                for (DescriptorData descriptorData : characteristicData.descriptorDataList) {
                    bluetoothGattDescriptor = new BluetoothGattDescriptor(descriptorData.uuid
                            , descriptorData.permission);
                    bluetoothGattDescriptor.setValue(descriptorData.data);
                    bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
                }
                bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
            }

            bundle = new Bundle();
            bundle.putParcelable(KEY_SERVICE_DATA, serviceData);
            bleServerConnection.createAddServiceTask(bluetoothGattService, AddServiceTask.TIMEOUT_MILLIS, bundle, this);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void tearDown(@NonNull BLEServerConnection bleServerConnection) {
        for (BluetoothGattService bluetoothGattService : mAvailableServiceMap.values()) {
            bleServerConnection.createRemoveServiceTask(bluetoothGattService, RemoveServiceTask.TIMEOUT_MILLIS, null, null);
        }
        mRemappedServiceCharacteristicMap.clear();
        mRemappedCharacteristicDescriptorMap.clear();
        mAvailableServiceMap.clear();
        mIsReliable = false;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("EmptyMethod")
    @Override
    public void onServerStarted() {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServerStopped() {
        mRemappedServiceCharacteristicMap.clear();
        mRemappedCharacteristicDescriptorMap.clear();
        mAvailableServiceMap.clear();
        mConnectedDeviceSet.clear();
        mActivatedNotificationMap.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDeviceConnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {
        mConnectedDeviceSet.add(device);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDeviceDisconnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {
        mConnectedDeviceSet.remove(device);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean onServiceAddSuccess(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattService bluetoothGattService
            , @Nullable Bundle argument) {
        boolean result = false;

        UUID serviceUUID = bluetoothGattService.getUuid();
        int serviceInstanceId = bluetoothGattService.getInstanceId();
        if (argument != null) {
            ServiceData serviceData = argument.getParcelable(KEY_SERVICE_DATA);
            Pair<UUID, Integer> servicePair = Pair.create(serviceUUID, serviceInstanceId);
            if (serviceData != null && mMockData.serviceDataList.contains(serviceData) && !mAvailableServiceMap.containsKey(servicePair)) {
                mAvailableServiceMap.put(servicePair, bluetoothGattService);
                result = true;

                Set<Pair<UUID, Integer>> usedCharacteristicSet = new HashSet<>();
                Map<Pair<UUID, Integer>, CharacteristicData> characteristicDataMap = new HashMap<>();
                for (CharacteristicData characteristicData : serviceData.characteristicDataList) {
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                        UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
                        int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                        Pair<UUID, Integer> characteristicPair = Pair.create(characteristicUUID, characteristicInstanceId);
                        if (characteristicData.uuid.equals(characteristicUUID) && !usedCharacteristicSet.contains(characteristicPair)) {
                            usedCharacteristicSet.add(characteristicPair);
                            characteristicDataMap.put(characteristicPair, characteristicData);

                            Set<Pair<UUID, Integer>> usedDescriptorSet = new HashSet<>();
                            Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = new HashMap<>();
                            for (DescriptorData descriptorData : characteristicData.descriptorDataList) {
                                for (BluetoothGattDescriptor bluetoothGattDescriptor : bluetoothGattCharacteristic.getDescriptors()) {
                                    UUID descriptorUUID = bluetoothGattDescriptor.getUuid();
                                    int descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);
                                    Pair<UUID, Integer> descriptorPair = Pair.create(descriptorUUID, descriptorInstanceId);
                                    if (descriptorData.uuid.equals(descriptorUUID) && !usedDescriptorSet.contains(descriptorPair)) {
                                        usedDescriptorSet.add(descriptorPair);
                                        descriptorDataMap.put(descriptorPair, descriptorData);
                                        break;
                                    }
                                }
                            }
                            mRemappedCharacteristicDescriptorMap.put(characteristicPair, descriptorDataMap);
                            break;
                        }
                    }
                    mRemappedServiceCharacteristicMap.put(servicePair, characteristicDataMap);
                }
            }
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onServiceRemoveSuccess(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattService bluetoothGattService
            , @Nullable Bundle argument) {
        UUID serviceUUID = bluetoothGattService.getUuid();
        int serviceInstanceId = bluetoothGattService.getInstanceId();
        if (argument != null) {
            ServiceData serviceData = argument.getParcelable(KEY_SERVICE_DATA);
            Pair<UUID, Integer> servicePair = Pair.create(serviceUUID, serviceInstanceId);
            if (serviceData != null && mAvailableServiceMap.containsKey(servicePair)) {
                mAvailableServiceMap.remove(servicePair);

                Map<Pair<UUID, Integer>, CharacteristicData> characteristicDataMap = mRemappedServiceCharacteristicMap.remove(servicePair);
                if (characteristicDataMap != null) {
                    for (Pair<UUID, Integer> characteristicPair : characteristicDataMap.keySet()) {
                        mRemappedCharacteristicDescriptorMap.remove(characteristicPair);
                    }
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean onCharacteristicReadRequest(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , int offset
            , @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic
            , boolean force) {
        boolean result = false;
        BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();

        if (bluetoothGattServer != null) {
            long now = SystemClock.elapsedRealtime();
            BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
            UUID serviceUUID = bluetoothGattService.getUuid();
            int serviceInstanceId = bluetoothGattService.getInstanceId();
            Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
            if (characteristicMap != null) {
                UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
                int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                if (characteristicData != null) {
                    delay(now, characteristicData.delay);

                    byte[] data = characteristicData.getBytes();
                    result = bluetoothGattServer.sendResponse(device
                            , requestId
                            , characteristicData.responseCode
                            , offset
                            , Arrays.copyOfRange(data, offset, data.length));
                }
            }

            if (force && !result) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean onCharacteristicWriteRequest(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic
            , boolean preparedWrite
            , boolean responseNeeded
            , int offset
            , @NonNull byte[] value
            , boolean force) {
        boolean result = false;
        BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();

        if (bluetoothGattServer != null) {
            long now = SystemClock.elapsedRealtime();
            BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
            UUID serviceUUID = bluetoothGattService.getUuid();
            int serviceInstanceId = bluetoothGattService.getInstanceId();
            Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
            if (characteristicMap == null) {
                if (force && responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                }
            } else {
                UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
                int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                if (characteristicData != null) {
                    delay(now, characteristicData.delay);

                    if (responseNeeded) {
                        result = bluetoothGattServer.sendResponse(device, requestId, characteristicData.responseCode, offset, null);
                    } else {
                        result = true;
                    }

                    if (result && BluetoothGatt.GATT_SUCCESS == characteristicData.responseCode) {
                        mIsReliable |= preparedWrite;

                        if (mIsReliable) {
                            characteristicData.temporaryData = Arrays.copyOfRange(value, offset, value.length);
                        } else {
                            characteristicData.currentData = Arrays.copyOfRange(value, offset, value.length);
                        }
                    }
                }

                if (force && !result && responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                }
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean onDescriptorReadRequest(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , int offset
            , @NonNull BluetoothGattDescriptor bluetoothGattDescriptor
            , boolean force) {
        boolean result = false;
        BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();

        if (bluetoothGattServer != null) {
            long now = SystemClock.elapsedRealtime();
            BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattDescriptor.getCharacteristic();
            UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
            int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
            Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (descriptorDataMap != null) {
                UUID descriptorUUID = bluetoothGattDescriptor.getUuid();
                int descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);
                Pair<UUID, Integer> descriptorPair = Pair.create(descriptorUUID, descriptorInstanceId);

                DescriptorData descriptorData = descriptorDataMap.get(descriptorPair);
                if (descriptorData != null) {
                    delay(now, descriptorData.delay);

                    byte[] data = descriptorData.getBytes();
                    result = bluetoothGattServer.sendResponse(device
                            , requestId
                            , descriptorData.responseCode
                            , offset
                            , Arrays.copyOfRange(data, offset, data.length));
                }
            }

            if (force && !result) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean onDescriptorWriteRequest(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , @NonNull BluetoothGattDescriptor bluetoothGattDescriptor
            , boolean preparedWrite
            , boolean responseNeeded
            , int offset
            , @NonNull byte[] value
            , boolean force) {
        boolean result = false;

        long now = SystemClock.elapsedRealtime();
        BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();

        if (bluetoothGattServer != null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattDescriptor.getCharacteristic();
            BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
            UUID serviceUUID = bluetoothGattService.getUuid();
            int serviceInstanceId = bluetoothGattService.getInstanceId();
            UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
            int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
            Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (descriptorDataMap != null) {
                UUID descriptorUUID = bluetoothGattDescriptor.getUuid();
                int descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);
                Pair<UUID, Integer> descriptorPair = Pair.create(descriptorUUID, descriptorInstanceId);

                DescriptorData descriptorData = descriptorDataMap.get(descriptorPair);
                if (descriptorData != null) {
                    delay(now, descriptorData.delay);

                    if (responseNeeded) {
                        result = bluetoothGattServer.sendResponse(device, requestId, descriptorData.responseCode, offset, null);
                    } else {
                        result = true;
                    }

                    if (result && BluetoothGatt.GATT_SUCCESS == descriptorData.responseCode) {
                        mIsReliable |= preparedWrite;

                        if (mIsReliable) {
                            descriptorData.temporaryData = Arrays.copyOfRange(value, offset, value.length);
                        } else {
                            byte[] oldData = descriptorData.getBytes();
                            descriptorData.currentData = Arrays.copyOfRange(value, offset, value.length);

                            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                                if (!Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, descriptorData.currentData)
                                        && Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, oldData)) {
                                    startNotification(null, bleServerConnection, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, 0, null, null);
                                } else if (Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, descriptorData.currentData)
                                        && !Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, oldData)) {
                                    mActivatedNotificationMap.remove(new NotificationData(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId));
                                }
                            }
                        }
                    }
                }
            }

            if (force && !result && responseNeeded) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        }
        return result;
    }

    /**
     * start notification / indication
     *
     * @param taskId                   task id
     * @param bleServerConnection      {@link BLEServerConnection} instance
     * @param device                   BLE device
     * @param serviceUUID              target service {@link UUID} instance
     * @param serviceInstanceId        {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       target characteristic {@link UUID} instance
     * @param characteristicInstanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     target descriptor instance id
     * @param delay                    notification delay(millis)
     * @param notificationCount        notification / indication count. if {@code null}, default notification count is used
     * @param argument                 callback argument
     * @see BLEServerConnection#createNotificationTask(BluetoothDevice, UUID, int, UUID, int, ByteArrayInterface, boolean, long, long, Bundle, BLEServerCallback)
     */
    protected synchronized void startNotification(@Nullable Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @Nullable BluetoothDevice device
            , @NonNull UUID serviceUUID
            , int serviceInstanceId
            , @NonNull UUID characteristicUUID
            , int characteristicInstanceId
            , int descriptorInstanceId
            , long delay
            , @Nullable Integer notificationCount
            , @SuppressWarnings("SameParameterValue") @Nullable Bundle argument) {

        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap != null) {
            CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (characteristicData != null) {
                int targetNotificationCount = notificationCount == null ? characteristicData.notificationCount : notificationCount;
                if (targetNotificationCount != 0) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(KEY_NOTIFICATION_COUNT, notificationCount == null ? characteristicData.notificationCount : notificationCount);
                    bundle.putInt(KEY_DESCRIPTOR_INSTANCE_ID, descriptorInstanceId);
                    if (argument != null) {
                        bundle.putBundle(KEY_ORIGINAL_ARGUMENT, argument);
                    }

                    Boolean isConfirm = null;
                    Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                    if (descriptorDataMap != null) {
                        DescriptorData descriptorData = descriptorDataMap.get(Pair.create(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, descriptorInstanceId));
                        if (descriptorData != null) {
                            if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, descriptorData.getBytes())) {
                                isConfirm = false;
                            } else if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, descriptorData.getBytes())) {
                                isConfirm = true;
                            }
                        }
                    }

                    if (isConfirm != null) {
                        NotificationData notificationData;
                        if (device == null) {
                            for (BluetoothDevice bluetoothDevice : mConnectedDeviceSet) {
                                notificationData = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
                                if (!mActivatedNotificationMap.containsKey(notificationData)) {
                                    Integer newTaskId = bleServerConnection.createNotificationTask(bluetoothDevice
                                            , serviceUUID
                                            , serviceInstanceId
                                            , characteristicUUID
                                            , characteristicInstanceId
                                            , characteristicData
                                            , isConfirm
                                            , NotificationTask.TIMEOUT_MILLIS
                                            , delay
                                            , bundle
                                            , this);
                                    if (newTaskId != null) {
                                        mActivatedNotificationMap.put(notificationData, newTaskId);
                                    }
                                }
                            }
                        } else {
                            notificationData = new NotificationData(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
                            if (mConnectedDeviceSet.contains(device)) {
                                Integer currentTaskId = mActivatedNotificationMap.get(notificationData);
                                if (currentTaskId == null || currentTaskId.equals(taskId)) {
                                    Integer newTaskId = bleServerConnection.createNotificationTask(device
                                            , serviceUUID
                                            , serviceInstanceId
                                            , characteristicUUID
                                            , characteristicInstanceId
                                            , characteristicData
                                            , isConfirm
                                            , NotificationTask.TIMEOUT_MILLIS
                                            , delay
                                            , bundle
                                            , this);
                                    if (newTaskId != null) {
                                        mActivatedNotificationMap.put(notificationData, newTaskId);
                                    }
                                }
                            } else {
                                mActivatedNotificationMap.remove(notificationData);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * repeat notification or indication
     *
     * @param taskId                   task id
     * @param bleServerConnection      {@link BLEServerConnection} instance
     * @param device                   BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param argument                 callback argument
     */
    protected synchronized void repeatNotification(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @Nullable Bundle argument) {
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap != null) {
            CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (characteristicData != null && argument != null && argument.containsKey(KEY_NOTIFICATION_COUNT)) {
                int notificationCount = argument.getInt(KEY_NOTIFICATION_COUNT);
                if (notificationCount > 0) {
                    notificationCount--;
                }
                if (notificationCount == 0) {
                    mActivatedNotificationMap.remove(new NotificationData(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId));
                } else {
                    int descriptorInstanceId = argument.getInt(KEY_DESCRIPTOR_INSTANCE_ID, -1);
                    startNotification(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, NOTIFICATION_INTERVAL, notificationCount, null);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onNotificationSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull byte[] value, @Nullable Bundle argument) {
        repeatNotification(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onNotificationFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int status, @Nullable Bundle argument) {
        repeatNotification(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onNotificationTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        repeatNotification(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean onExecuteWrite(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , boolean execute
            , boolean force) {
        boolean result = false;
        BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();
        if (bluetoothGattServer != null) {

            for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, CharacteristicData>> serviceEntry : mRemappedServiceCharacteristicMap.entrySet()) {
                for (Map.Entry<Pair<UUID, Integer>, CharacteristicData> characteristicEntry : serviceEntry.getValue().entrySet()) {
                    CharacteristicData characteristicData = characteristicEntry.getValue();
                    if (execute) {
                        if (characteristicData.temporaryData != null) {
                            characteristicData.currentData = characteristicData.temporaryData;
                        }
                    }
                    characteristicData.temporaryData = null;
                }
            }

            for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, DescriptorData>> characteristicEntry : mRemappedCharacteristicDescriptorMap.entrySet()) {
                Pair<UUID, Integer> characteristicKey = characteristicEntry.getKey();
                for (Map.Entry<Pair<UUID, Integer>, DescriptorData> descriptorEntry : characteristicEntry.getValue().entrySet()) {
                    Pair<UUID, Integer> descriptorKey = descriptorEntry.getKey();
                    DescriptorData descriptorData = descriptorEntry.getValue();
                    if (execute) {
                        if (descriptorData.temporaryData != null) {
                            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorData.uuid)) {
                                for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, CharacteristicData>> serviceEntry : mRemappedServiceCharacteristicMap.entrySet()) {
                                    CharacteristicData characteristicData = serviceEntry.getValue().get(characteristicKey);
                                    if (characteristicData != null) {
                                        if (!Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, descriptorData.temporaryData)
                                                && Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, descriptorData.getBytes())) {
                                            startNotification(null, bleServerConnection, null, serviceEntry.getKey().first, serviceEntry.getKey().second, characteristicKey.first, characteristicKey.second, descriptorKey.second, 0, characteristicData.notificationCount, null);
                                        } else if (Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, descriptorData.temporaryData)
                                                && !Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, descriptorData.getBytes())) {
                                            mActivatedNotificationMap.remove(new NotificationData(device, serviceEntry.getKey().first, serviceEntry.getKey().second, characteristicKey.first, characteristicKey.second));
                                        }
                                    }
                                }
                            }
                            descriptorData.currentData = descriptorData.temporaryData;
                        }
                    }

                    descriptorData.temporaryData = null;
                }
            }
            mIsReliable = false;
            result = bluetoothGattServer.sendResponse(device, requestId, BluetoothGatt.GATT_SUCCESS, 0, null);
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFallback() {
        return mIsFallback;
    }

    /**
     * @param start    {@link SystemClock#elapsedRealtime()}
     * @param duration wait duration
     */
    protected void delay(long start, long duration) {
        do {
            long delta = SystemClock.elapsedRealtime() - start;
            if (delta < duration) {
                try {
                    //noinspection BusyWait
                    Thread.sleep(duration - delta);
                } catch (InterruptedException e) {
                    BLEPeripheralLogUtils.stackLog(e);
                }
            }
        } while (start + duration > SystemClock.elapsedRealtime());
    }

    /**
     * find target characteristic data
     *
     * @param serviceUUID        target service {@link UUID} instance
     * @param characteristicUUID target characteristic {@link UUID} instance
     * @param clazz              return class
     * @param <T>                child of {@link CharacteristicData} class
     * @return target characteristic data, or {@code null}
     * @see #findCharacteristicData(Map, UUID, Class)
     */
    @Nullable
    protected <T extends CharacteristicData> T findCharacteristicData(@NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull Class<T> clazz) {
        T target = null;
        for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, CharacteristicData>> serviceDataEntry : mRemappedServiceCharacteristicMap.entrySet()) {
            if (serviceUUID.equals(serviceDataEntry.getKey().first)) {
                target = findCharacteristicData(serviceDataEntry.getValue(), characteristicUUID, clazz);
                break;
            }
        }
        return target;
    }

    /**
     * find target characteristic data
     *
     * @param characteristicDataMap target characteristic map
     * @param characteristicUUID    target characteristic {@link UUID} instance
     * @param clazz                 return class
     * @param <T>                   child of {@link CharacteristicData} class
     * @return target characteristic data, or {@code null}
     */
    @Nullable
    protected <T extends CharacteristicData> T findCharacteristicData(@NonNull Map<Pair<UUID, Integer>, CharacteristicData> characteristicDataMap, @NonNull UUID characteristicUUID, @NonNull Class<T> clazz) {
        T target = null;
        for (Map.Entry<Pair<UUID, Integer>, CharacteristicData> characteristicEntry : characteristicDataMap.entrySet()) {
            if (characteristicUUID.equals(characteristicEntry.getKey().first)) {
                CharacteristicData characteristicData = characteristicEntry.getValue();
                if (characteristicData != null && clazz.isAssignableFrom(characteristicData.getClass())) {
                    target = clazz.cast(characteristicData);
                }
                break;
            }
        }
        return target;
    }

}
