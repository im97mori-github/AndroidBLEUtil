package org.im97mori.ble.service.gap.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DATABASE_HASH_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SERVICE_CHANGED_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ATTRIBUTE_SERVICE;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2a05.ServiceChanged;
import org.im97mori.ble.characteristic.u2b29.ClientSupportedFeatures;
import org.im97mori.ble.characteristic.u2b2a.DatabaseHash;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Generic Attribute Service (Service UUID: 0x1801) for Peripheral
 * (not work)
 */
public class GenericAttributeServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link GenericAttributeServiceMockCallback}
     *
     * @param <T> subclass of {@link GenericAttributeServiceMockCallback}
     */
    public static class Builder<T extends GenericAttributeServiceMockCallback> extends AbstractServiceMockCallback.Builder<GenericAttributeServiceMockCallback, ServiceData> {

        /**
         * Service Changed data
         */
        protected CharacteristicData mServiceChangedData;

        /**
         * Client Supported Features data
         */
        protected CharacteristicData mClientSupportedFeaturesData;

        /**
         * Database Hash data
         */
        protected CharacteristicData mDatabaseHashData;

        /**
         * @see #addServiceChanged(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addServiceChanged(@NonNull ServiceChanged serviceChanged, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addServiceChanged(BluetoothGatt.GATT_SUCCESS, 0, serviceChanged.getBytes(), 1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Service Changed characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Intermediate Cuff Pressure notification count
         * @param descriptorResponseCode     descriptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descriptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addServiceChanged(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mServiceChangedData = new CharacteristicData(SERVICE_CHANGED_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_INDICATE
                    , 0
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponseCode
                    , characteristicDelay
                    , characteristicValue
                    , notificationCount);
            return this;
        }

        /**
         * remove Service Changed characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeServiceChanged() {
            mServiceChangedData = null;
            return this;
        }

        /**
         * @see #addClientSupportedFeatures(byte[])
         */
        @NonNull
        public Builder<T> addClientSupportedFeatures(@NonNull ClientSupportedFeatures clientSupportedFeatures) {
            return addClientSupportedFeatures(clientSupportedFeatures.getBytes());
        }

        /**
         * @see #addClientSupportedFeatures(int, long, byte[])
         */
        @NonNull
        public Builder<T> addClientSupportedFeatures(@NonNull byte[] value) {
            return addClientSupportedFeatures(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Client Supported Features characteristic
         *
         * @param responseCode response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addClientSupportedFeatures(int responseCode, long delay, @NonNull byte[] value) {
            mClientSupportedFeaturesData = new CharacteristicData(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Client Supported Features characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeClientSupportedFeatures() {
            mClientSupportedFeaturesData = null;
            return this;
        }

        /**
         * @see #addDatabaseHash(byte[])
         */
        @NonNull
        public Builder<T> addDatabaseHash(@NonNull DatabaseHash databaseHash) {
            return addDatabaseHash(databaseHash.getBytes());
        }

        /**
         * @see #addDatabaseHash(int, long, byte[])
         */
        @NonNull
        public Builder<T> addDatabaseHash(@NonNull byte[] value) {
            return addDatabaseHash(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Database Hash characteristic
         *
         * @param responseCode response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addDatabaseHash(int responseCode, long delay, @NonNull byte[] value) {
            mDatabaseHashData = new CharacteristicData(DATABASE_HASH_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Database Hash characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDatabaseHash() {
            mDatabaseHashData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData createData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mServiceChangedData != null) {
                characteristicList.add(mServiceChangedData);
            }
            if (mClientSupportedFeaturesData == null) {
                if (mServiceChangedData != null
                        && mDatabaseHashData != null) {
                    throw new RuntimeException("no Client Supported Features data");
                }
            } else {
                characteristicList.add(mClientSupportedFeaturesData);
            }
            if (mDatabaseHashData != null) {
                characteristicList.add(mDatabaseHashData);
            }
            return new ServiceData(GENERIC_ATTRIBUTE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GenericAttributeServiceMockCallback build() {
            return new GenericAttributeServiceMockCallback(createData(), false);
        }

    }

    /**
     * @param serviceData   {@link ServiceData} instance
     * @param isFallback fallback flag
     */
    public GenericAttributeServiceMockCallback(@NonNull ServiceData serviceData, boolean isFallback) {
        super(serviceData, isFallback);
    }

    /**
     * {@inheritDoc}
     * @noinspection deprecation
     */
    @Override
    @Deprecated
    public synchronized boolean onServiceAddSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, @Nullable Bundle argument) {
        boolean result = super.onServiceAddSuccess(taskId, bleServerConnection, bluetoothGattService, argument);
        if (result) {
            updateGenericAttributeServiceStatus(bleServerConnection, bluetoothGattService);
        }
        return result;
    }

    /**
     * Update Database Hash and indication Service Changed
     *
     * @param bleServerConnection  {@link BLEServerConnection} instance
     * @param bluetoothGattService {@link BluetoothGattService} instance
     */
    protected void updateGenericAttributeServiceStatus(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService) {
        UUID serviceUUID = bluetoothGattService.getUuid();
        int serviceInstanceId = bluetoothGattService.getInstanceId();
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap != null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DATABASE_HASH_CHARACTERISTIC);
            if (bluetoothGattCharacteristic != null) {
                UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
                int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                if (characteristicData != null) {
                    // make random hash, because cannot read attribute handle value
                    byte[] value = new byte[16];
                    Random random = new Random();
                    do {
                        random.nextBytes(value);
                    } while (Arrays.equals(characteristicData.getBytes(), value));
                    characteristicData.currentData = value;
                }
            }
            bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SERVICE_CHANGED_CHARACTERISTIC);
            if (bluetoothGattCharacteristic != null) {
                UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
                int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                if (descriptorDataMap != null) {
                    for (Map.Entry<Pair<UUID, Integer>, DescriptorData> entry : descriptorDataMap.entrySet()) {
                        Pair<UUID, Integer> key = entry.getKey();
                        if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(key.first)) {
                            DescriptorData descriptorData = entry.getValue();
                            if (Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, descriptorData.getBytes())) {
                                startNotification(null, bleServerConnection, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, key.second, 0, null, null);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     * @noinspection deprecation
     */
    @Override
    @Deprecated
    public synchronized void onServiceRemoveSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, @Nullable Bundle argument) {
        int beforeServiceSize = mAvailableServiceMap.size();
        super.onServiceRemoveSuccess(taskId, bleServerConnection, bluetoothGattService, argument);
        int afterServiceSize = mAvailableServiceMap.size();
        if (beforeServiceSize != afterServiceSize) {
            updateGenericAttributeServiceStatus(bleServerConnection, bluetoothGattService);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingStartFailed(@Nullable Integer errorCode) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingFinished() {
        // do nothing
    }

}
