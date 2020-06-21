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

import org.im97mori.ble.BLEPeripheralLogUtils;
import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.ByteArrayInterface;
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

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ErrorCodes.APPLICATION_ERROR_9F;

/**
 * MockCallback base class
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class BaseMockCallback implements BLEServerCallback {

    /**
     * KEY:SERVICE_DATA
     */
    private static final String KEY_SERVICE_DATA = "KEY_SERVICE_DATA";

    /**
     * KEY:NOTIFICATION_COUNT
     */
    private static final String KEY_NOTIFICATION_COUNT = "KEY_NOTIFICATION_COUNT";

    /**
     * KEY:DESCRIPTOR_INSTANCE_ID
     */
    private static final String KEY_DESCRIPTOR_INSTANCE_ID = "KEY_DESCRIPTOR_INSTANCE_ID";

    /**
     * notification interval:1s
     */
    private static final long NOTIFICATION_INTERVAL = 1000L;

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
     * current characteristic data(overwrited by write characteristic)
     */
    protected final Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, byte[]>> mCurrentCharacteristicDataMap = new HashMap<>();

    /**
     * current descriptor data(overwrited by write descriptor)
     */
    protected final Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, byte[]>>> mCurrentDescriptorDataMap = new HashMap<>();

    /**
     * temporary characteristic data(in reliable write)
     */
    protected final Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, byte[]>> mTemporaryCharacteristicDataMap = new HashMap<>();

    /**
     * temporary descriptor data(in reliable write)
     */
    protected final Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, byte[]>>> mTemporaryDescriptorDataMap = new HashMap<>();

    /**
     * reliable write status
     * {@code true}:in reliable write
     */
    protected boolean mIsReliable = false;

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
                bluetoothGattCharacteristic.setValue(characteristicData.data);
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
        mCurrentCharacteristicDataMap.clear();
        mCurrentDescriptorDataMap.clear();
        mTemporaryCharacteristicDataMap.clear();
        mTemporaryDescriptorDataMap.clear();
        mIsReliable = false;
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

                    byte[] data = getCharacteristicData(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
                    if (data == null) {
                        data = characteristicData.data;
                    }
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
     * get current characteristic data
     *
     * @param serviceUUID              target service {@link UUID} instance
     * @param serviceInstanceId        {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       target characteristic {@link UUID} instance
     * @param characteristicInstanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @return current characteristic data or {@code null}
     */
    @Nullable
    protected synchronized byte[] getCharacteristicData(@NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId) {
        byte[] data = null;
        Pair<UUID, Integer> serviceKey = Pair.create(serviceUUID, serviceInstanceId);
        Map<Pair<UUID, Integer>, byte[]> characteristicDataMap = mCurrentCharacteristicDataMap.get(serviceKey);
        if (characteristicDataMap != null) {
            data = characteristicDataMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
        }
        return data;
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
                if (responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                }
            } else {
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

                    if (responseNeeded) {
                        result = bluetoothGattServer.sendResponse(device, requestId, characteristicData.responseCode, offset, null);
                    } else {
                        result = true;
                    }

                    if (result && BluetoothGatt.GATT_SUCCESS == characteristicData.responseCode) {
                        mIsReliable |= preparedWrite;

                        Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, byte[]>> targetMap;
                        if (mIsReliable) {
                            targetMap = mTemporaryCharacteristicDataMap;
                        } else {
                            targetMap = mCurrentCharacteristicDataMap;
                        }

                        setCharacteristicData(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, targetMap, value);
                    }
                }
            }
        }
        return result;
    }

    /**
     * set characteristic data
     *
     * @param serviceUUID              target service {@link UUID} instance
     * @param serviceInstanceId        {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       target characteristic {@link UUID} instance
     * @param characteristicInstanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param targetMap                {@link #mCurrentCharacteristicDataMap} or {@link #mTemporaryCharacteristicDataMap}
     * @param data                     characteristic data
     */
    protected synchronized void setCharacteristicData(@NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, byte[]>> targetMap, @NonNull byte[] data) {
        Pair<UUID, Integer> key = Pair.create(serviceUUID, serviceInstanceId);
        Map<Pair<UUID, Integer>, byte[]> characteristicDataMap = targetMap.get(key);
        if (characteristicDataMap == null) {
            characteristicDataMap = new HashMap<>();
            targetMap.put(key, characteristicDataMap);
        }

        characteristicDataMap.put(Pair.create(characteristicUUID, characteristicInstanceId), data);
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
            BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
            UUID serviceUUID = bluetoothGattService.getUuid();
            int serviceInstanceId = bluetoothGattService.getInstanceId();
            UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
            int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
            Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (descriptorDataMap == null) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            } else {
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
                    byte[] data = getDescriptorData(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId);
                    if (data == null) {
                        data = descriptorData.data;
                    }
                    result = bluetoothGattServer.sendResponse(device
                            , requestId
                            , descriptorData.responseCode
                            , offset
                            , Arrays.copyOfRange(data, offset, data.length));
                }
            }
        }
        return result;
    }

    /**
     * get current descriptor data
     *
     * @param serviceUUID              target service {@link UUID} instance
     * @param serviceInstanceId        {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       target characteristic {@link UUID} instance
     * @param characteristicInstanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           target descriptor {@link UUID} instance
     * @param descriptorInstanceId     target descriptor instance id
     * @return current descriptor data or {@code null}
     */
    @Nullable
    protected synchronized byte[] getDescriptorData(@NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull @SuppressWarnings("SameParameterValue") UUID descriptorUUID, int descriptorInstanceId) {
        byte[] data = null;
        Pair<UUID, Integer> serviceKey = Pair.create(serviceUUID, serviceInstanceId);
        Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, byte[]>> characteristicDataMap = mCurrentDescriptorDataMap.get(serviceKey);
        if (characteristicDataMap != null) {
            Map<Pair<UUID, Integer>, byte[]> descriptorDataMap = characteristicDataMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (descriptorDataMap != null) {
                data = descriptorDataMap.get(Pair.create(descriptorUUID, descriptorInstanceId));
            }
        }
        return data;
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
        BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
        UUID serviceUUID = bluetoothGattService.getUuid();
        int serviceInstanceId = bluetoothGattService.getInstanceId();
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

                if (result && BluetoothGatt.GATT_SUCCESS == descriptorData.responseCode) {
                    mIsReliable |= preparedWrite;

                    Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, byte[]>>> targetMap;
                    if (mIsReliable) {
                        targetMap = mTemporaryDescriptorDataMap;
                    } else {
                        targetMap = mCurrentDescriptorDataMap;
                    }

                    setDescriptorData(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, targetMap, value);
                }

                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && !mIsReliable) {
                    startNotification(bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, 0, null);
                }
            }
        }

        if (responseNeeded && !result && bluetoothGattServer != null) {
            result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
        }
        return result;
    }

    /**
     * set descriptor data
     *
     * @param serviceUUID              target service {@link UUID} instance
     * @param serviceInstanceId        {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       target characteristic {@link UUID} instance
     * @param characteristicInstanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           target descriptor {@link UUID} instance
     * @param descriptorInstanceId     target descriptor instance id
     * @param targetMap                {@link #mCurrentDescriptorDataMap} or {@link #mTemporaryDescriptorDataMap}
     * @param data                     descriptor data
     */
    protected synchronized void setDescriptorData(@NonNull UUID serviceUUID
            , int serviceInstanceId
            , @NonNull UUID characteristicUUID
            , int characteristicInstanceId
            , @NonNull @SuppressWarnings("SameParameterValue") UUID descriptorUUID
            , int descriptorInstanceId
            , @NonNull Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, byte[]>>> targetMap
            , @NonNull byte[] data) {
        Pair<UUID, Integer> serviceKey = Pair.create(serviceUUID, serviceInstanceId);
        Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, byte[]>> characteristicDataMap = targetMap.get(serviceKey);
        if (characteristicDataMap == null) {
            characteristicDataMap = new HashMap<>();
            targetMap.put(serviceKey, characteristicDataMap);
        }

        Pair<UUID, Integer> characteristicKey = Pair.create(characteristicUUID, characteristicInstanceId);
        Map<Pair<UUID, Integer>, byte[]> descriptorMap = characteristicDataMap.get(characteristicKey);
        if (descriptorMap == null) {
            descriptorMap = new HashMap<>();
            characteristicDataMap.put(characteristicKey, descriptorMap);
        }

        descriptorMap.put(Pair.create(descriptorUUID, descriptorInstanceId), data);
    }

    /**
     * start notification / indication
     *
     * @param bleServerConnection      {@link BLEServerConnection} instance
     * @param device                   BLE device
     * @param serviceUUID              target service {@link UUID} instance
     * @param serviceInstanceId        {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       target characteristic {@link UUID} instance
     * @param characteristicInstanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     target descriptor instance id
     * @param delay                    notification delay(millis)
     * @param notificationCount        notification / indication count. if {@code null}, default notification count is used
     * @return task id
     * @see BLEServerConnection#createNotificationTask(BluetoothDevice, UUID, int, UUID, int, ByteArrayInterface, boolean, long, long, Bundle, BLEServerCallback)
     */
    @SuppressWarnings("UnusedReturnValue")
    protected synchronized Integer startNotification(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , @NonNull UUID serviceUUID
            , int serviceInstanceId
            , @NonNull UUID characteristicUUID
            , int characteristicInstanceId
            , int descriptorInstanceId
            , long delay
            , @Nullable Integer notificationCount) {

        Integer taskId = null;

        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap != null) {
            CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (characteristicData != null) {
                byte[] data = getCharacteristicData(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
                if (data != null) {
                    characteristicData.data = data;
                }
                Bundle bundle = new Bundle();
                bundle.putInt(KEY_NOTIFICATION_COUNT, notificationCount == null ? characteristicData.notificationCount : notificationCount);
                bundle.putInt(KEY_DESCRIPTOR_INSTANCE_ID, descriptorInstanceId);

                byte[] descriptorData = getDescriptorData(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, descriptorInstanceId);
                Boolean isConfirm = null;
                if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, descriptorData)) {
                    isConfirm = false;
                } else if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, descriptorData)) {
                    isConfirm = true;
                }

                if (isConfirm != null) {
                    taskId = bleServerConnection.createNotificationTask(device
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
                }
            }
        }

        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onNotificationSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull byte[] value, @Nullable Bundle argument) {
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap != null) {
            CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (characteristicData != null && argument != null && argument.containsKey(KEY_NOTIFICATION_COUNT)) {
                int notificationCount = argument.getInt(KEY_NOTIFICATION_COUNT);
                if (notificationCount != 0) {
                    if (notificationCount > 0) {
                        notificationCount--;
                    }

                    int descriptorInstanceId = argument.getInt(KEY_DESCRIPTOR_INSTANCE_ID, -1);
                    startNotification(bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, NOTIFICATION_INTERVAL, notificationCount);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onNotificationFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int status, @Nullable Bundle argument) {
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap != null) {
            CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (characteristicData != null && argument != null && argument.containsKey(KEY_NOTIFICATION_COUNT)) {
                int notificationCount = argument.getInt(KEY_NOTIFICATION_COUNT);
                if (notificationCount != 0) {
                    if (notificationCount > 0) {
                        notificationCount--;
                    }

                    int descriptorInstanceId = argument.getInt(KEY_DESCRIPTOR_INSTANCE_ID, -1);
                    startNotification(bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, NOTIFICATION_INTERVAL, notificationCount);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onNotificationTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap != null) {
            CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (characteristicData != null && argument != null && argument.containsKey(KEY_NOTIFICATION_COUNT)) {
                int notificationCount = argument.getInt(KEY_NOTIFICATION_COUNT);
                if (notificationCount != 0) {
                    if (notificationCount > 0) {
                        notificationCount--;
                    }

                    int descriptorInstanceId = argument.getInt(KEY_DESCRIPTOR_INSTANCE_ID, -1);
                    startNotification(bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, NOTIFICATION_INTERVAL, notificationCount);
                }
            }
        }
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
            if (execute) {
                Pair<UUID, Integer> serviceKey;
                Pair<UUID, Integer> characteristicKey;
                for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, byte[]>> serviceEntry : mTemporaryCharacteristicDataMap.entrySet()) {
                    serviceKey = serviceEntry.getKey();
                    Map<Pair<UUID, Integer>, byte[]> characteristicMap = mCurrentCharacteristicDataMap.get(serviceKey);
                    if (characteristicMap == null) {
                        mCurrentCharacteristicDataMap.put(serviceKey, serviceEntry.getValue());
                    } else {
                        characteristicMap.putAll(serviceEntry.getValue());
                    }
                }

                for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, byte[]>>> serviceEntry : mTemporaryDescriptorDataMap.entrySet()) {
                    serviceKey = serviceEntry.getKey();
                    Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, byte[]>> characteristicMap = mCurrentDescriptorDataMap.get(serviceKey);
                    Map<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, byte[]>> temporaryCharacteristicMap = serviceEntry.getValue();
                    if (characteristicMap == null) {
                        mCurrentDescriptorDataMap.put(serviceKey, temporaryCharacteristicMap);
                    } else {
                        Map<Pair<UUID, Integer>, byte[]> descriptorMap;
                        Map<Pair<UUID, Integer>, byte[]> temporaryDescriptorMap;
                        for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, byte[]>> characteristicEntry : temporaryCharacteristicMap.entrySet()) {
                            characteristicKey = characteristicEntry.getKey();
                            descriptorMap = characteristicMap.get(characteristicKey);
                            if (descriptorMap == null) {
                                descriptorMap = new HashMap<>();
                                characteristicMap.put(characteristicKey, descriptorMap);
                            } else {
                                Map<Pair<UUID, Integer>, CharacteristicData> characteristicDataMap;
                                for (Map.Entry<Pair<UUID, Integer>, byte[]> descriptorEntry : descriptorMap.entrySet()) {
                                    Pair<UUID, Integer> descriptorKey = descriptorEntry.getKey();
                                    if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorKey.first)
                                            && !Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, descriptorEntry.getValue())
                                            && Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, descriptorMap.get(descriptorKey))) {
                                        characteristicDataMap = mRemappedServiceCharacteristicMap.get(serviceKey);
                                        if (characteristicDataMap != null) {
                                            CharacteristicData characteristicData = characteristicDataMap.get(characteristicKey);
                                            if (characteristicData != null) {
                                                startNotification(bleServerConnection, device, serviceKey.first, serviceKey.second, characteristicKey.first, characteristicKey.second, descriptorKey.second, 0, characteristicData.notificationCount);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            mIsReliable = false;
            mTemporaryCharacteristicDataMap.clear();
            mTemporaryDescriptorDataMap.clear();
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
