package org.im97mori.ble.callback;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Parcel;
import android.os.SystemClock;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEConstants;
import org.im97mori.ble.BLEPeripheralLogUtils;
import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.task.AddServiceTask;
import org.im97mori.ble.task.NotificationTask;
import org.im97mori.ble.task.RemoveServiceTask;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.ErrorCodes.APPLICATION_ERROR_9F;

/**
 * MockCallback base class
 */
@SuppressWarnings("WeakerAccess")
public abstract class BaseMockCallback implements BLEServerCallback {

    /**
     * KEY:SERVICE_DATA
     */
    private static final String KEY_SERVICE_DATA = "KEY_SERVICE_DATA";

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
    private final Map<Pair<UUID, Integer>, BluetoothGattService> mAvailableServiceMap = new HashMap<>();

    /**
     * characteristic data with instance id
     */
    private final Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, CharacteristicData>> mRemappedServiceCharacteristicMap = new HashMap<>();

    /**
     * descriptor data with instance id
     */
    private final Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, DescriptorData>> mRemappedCharacteristicDescriptorMap = new HashMap<>();

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public BaseMockCallback(@NonNull MockData mockData, boolean isFallback) {
        mMockData = mockData;
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
                bluetoothGattCharacteristic = new BluetoothGattCharacteristic(
                        characteristicData.uuid
                        , characteristicData.property
                        , characteristicData.permission);
                for (DescriptorData descriptorData : characteristicData.descriptorDataList) {
                    bluetoothGattDescriptor = new BluetoothGattDescriptor(descriptorData.uuid
                            , descriptorData.permission);
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
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServerStopped() {
        mRemappedServiceCharacteristicMap.clear();
        mRemappedCharacteristicDescriptorMap.clear();
        mAvailableServiceMap.clear();
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
                                    Parcel parcel = Parcel.obtain();
                                    bluetoothGattDescriptor.writeToParcel(parcel, 0);
                                    parcel.setDataPosition(0);
                                    parcel.readParcelable(getClass().getClassLoader());
                                    int descriptorInstanceId = parcel.readInt();
                                    parcel.recycle();
                                    Pair<UUID, Integer> descriptorPair = Pair.create(descriptorUUID, descriptorInstanceId);
                                    if (descriptorData.uuid.equals(descriptorUUID) && !usedDescriptorSet.contains(descriptorPair)) {
                                        usedDescriptorSet.add(descriptorPair);
                                        descriptorDataMap.put(descriptorPair, descriptorData);
                                    }
                                }
                            }
                            mRemappedCharacteristicDescriptorMap.put(characteristicPair, descriptorDataMap);
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

        long now = SystemClock.elapsedRealtime();
        BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
        UUID serviceUUID = bluetoothGattService.getUuid();
        int serviceInstanceId = bluetoothGattService.getInstanceId();
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap != null) {
            BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();
            UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
            int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
            CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (characteristicData != null) {
                long delay = characteristicData.delay;
                do {
                    long delta = SystemClock.elapsedRealtime() - now;
                    if (delta < delay) {
                        try {
                            Thread.sleep(delay - delta);
                        } catch (InterruptedException e) {
                            BLEPeripheralLogUtils.stackLog(e);
                        }
                    }
                } while (now + delay > SystemClock.elapsedRealtime());
                if (bluetoothGattServer != null) {
                    byte[] data = characteristicData.data;
                    result = bluetoothGattServer.sendResponse(device
                            , requestId
                            , characteristicData.responseCode
                            , offset
                            , Arrays.copyOfRange(data, offset, data.length));
                }
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

        long now = SystemClock.elapsedRealtime();
        BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();
        BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
        UUID serviceUUID = bluetoothGattService.getUuid();
        int serviceInstanceId = bluetoothGattService.getInstanceId();
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap != null) {
            UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
            int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
            CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (characteristicData != null) {
                long delay = characteristicData.delay;
                do {
                    long delta = SystemClock.elapsedRealtime() - now;
                    if (delta < delay) {
                        try {
                            Thread.sleep(delay - delta);
                        } catch (InterruptedException e) {
                            BLEPeripheralLogUtils.stackLog(e);
                        }
                    }
                } while (now + delay > SystemClock.elapsedRealtime());

                if (responseNeeded && bluetoothGattServer != null) {
                    result = bluetoothGattServer.sendResponse(device, requestId, characteristicData.responseCode, offset, null);
                } else {
                    result = true;
                }
            }
        }

        if (responseNeeded && !result && bluetoothGattServer != null) {
            result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
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

        long now = SystemClock.elapsedRealtime();
        BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattDescriptor.getCharacteristic();
        UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
        int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
        Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
        if (descriptorDataMap != null) {
            UUID descriptorUUID = bluetoothGattDescriptor.getUuid();
            Parcel parcel = Parcel.obtain();
            bluetoothGattDescriptor.writeToParcel(parcel, 0);
            parcel.setDataPosition(0);
            parcel.readParcelable(getClass().getClassLoader());
            int descriptorInstanceId = parcel.readInt();
            parcel.recycle();
            Pair<UUID, Integer> descriptorPair = Pair.create(descriptorUUID, descriptorInstanceId);

            DescriptorData descriptorData = descriptorDataMap.get(descriptorPair);
            if (descriptorData != null) {
                long delay = descriptorData.delay;
                do {
                    long delta = SystemClock.elapsedRealtime() - now;
                    if (delta < delay) {
                        try {
                            Thread.sleep(delay - delta);
                        } catch (InterruptedException e) {
                            BLEPeripheralLogUtils.stackLog(e);
                        }
                    }
                } while (now + delay > SystemClock.elapsedRealtime());
                if (bluetoothGattServer != null) {
                    byte[] data = descriptorData.data;
                    result = bluetoothGattServer.sendResponse(device
                            , requestId
                            , descriptorData.responseCode
                            , offset
                            , Arrays.copyOfRange(data, offset, data.length));
                }
            }
        }

        if (!result && bluetoothGattServer != null) {
            result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
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
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattDescriptor.getCharacteristic();
        UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
        int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
        Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
        if (descriptorDataMap != null) {
            UUID descriptorUUID = bluetoothGattDescriptor.getUuid();
            Parcel parcel = Parcel.obtain();
            bluetoothGattDescriptor.writeToParcel(parcel, 0);
            parcel.setDataPosition(0);
            parcel.readParcelable(getClass().getClassLoader());
            int descriptorInstanceId = parcel.readInt();
            parcel.recycle();
            Pair<UUID, Integer> descriptorPair = Pair.create(descriptorUUID, descriptorInstanceId);

            DescriptorData descriptorData = descriptorDataMap.get(descriptorPair);
            if (descriptorData != null) {
                long delay = descriptorData.delay;
                do {
                    long delta = SystemClock.elapsedRealtime() - now;
                    if (delta < delay) {
                        try {
                            Thread.sleep(delay - delta);
                        } catch (InterruptedException e) {
                            BLEPeripheralLogUtils.stackLog(e);
                        }
                    }
                } while (now + delay > SystemClock.elapsedRealtime());


                if (responseNeeded && bluetoothGattServer != null) {
                    result = bluetoothGattServer.sendResponse(device, requestId, descriptorData.responseCode, offset, null);
                } else {
                    result = true;
                }

                if (BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
                    UUID serviceUUID = bluetoothGattService.getUuid();
                    int serviceInstanceId = bluetoothGattService.getInstanceId();
                    Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
                    if (characteristicMap != null) {
                        final CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                        if (characteristicData != null) {
                            if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, value)) {
                                bleServerConnection.createNotificationTask(device
                                        , serviceUUID
                                        , serviceInstanceId
                                        , characteristicUUID
                                        , characteristicInstanceId
                                        , characteristicData
                                        , false
                                        , NotificationTask.PROGRESS_TIMEOUT
                                        , null);
                            } else if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, value)) {
                                bleServerConnection.createNotificationTask(device
                                        , serviceUUID
                                        , serviceInstanceId
                                        , characteristicUUID
                                        , characteristicInstanceId
                                        , characteristicData
                                        , true
                                        , NotificationTask.PROGRESS_TIMEOUT
                                        , null);
                            }
                        }
                    }
                }
            }
        }

        if (responseNeeded && !result && bluetoothGattServer != null) {
            result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
        }
        return result;
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

}
