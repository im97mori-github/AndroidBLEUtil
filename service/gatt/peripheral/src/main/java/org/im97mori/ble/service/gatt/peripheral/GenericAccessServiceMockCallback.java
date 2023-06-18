package org.im97mori.ble.service.gatt.peripheral;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2a00.DeviceName;
import org.im97mori.ble.characteristic.u2a01.Appearance;
import org.im97mori.ble.characteristic.u2a02.PeripheralPrivacyFlag;
import org.im97mori.ble.characteristic.u2a04.PeripheralPreferredConnectionParameters;
import org.im97mori.ble.characteristic.u2aa6.CentralAddressResolution;
import org.im97mori.ble.characteristic.u2ac9.ResolvablePrivateAddressOnly;
import org.im97mori.ble.characteristic.u2b88.EncryptedDataKeyMaterial;
import org.im97mori.ble.characteristic.u2bf5.LeGattSecurityLevels;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.APPEARANCE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DEVICE_NAME_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ENCRYPTED_DATA_KEY_MATERIAL_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LE_GATT_SECURITY_LEVELS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RECONNECTION_ADDRESS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;

/**
 * Generic Access Service (Service UUID: 0x1800) for Peripheral
 * (not work)
 */
public class GenericAccessServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link GenericAccessServiceMockCallback}
     *
     * @param <T> subclass of {@link GenericAccessServiceMockCallback}
     */
    public static class Builder<T extends GenericAccessServiceMockCallback> extends AbstractServiceMockCallback.Builder<GenericAccessServiceMockCallback, ServiceData> {

        /**
         * Device Name data
         */
        protected CharacteristicData mDeviceNameData;

        /**
         * Appearance data
         */
        protected CharacteristicData mAppearanceData;

        /**
         * Peripheral Preferred Connection Parameters data
         */
        protected CharacteristicData mPeripheralPreferredConnectionParametersData;

        /**
         * Central Address Resolution data
         */
        protected CharacteristicData mCentralAddressResolutionData;

        /**
         * Resolvable Private Address Only data
         */
        protected CharacteristicData mResolvablePrivateAddressOnlyData;

        /**
         * Reconnection Address data
         */
        protected CharacteristicData mReconnectionAddressData;

        /**
         * Peripheral Privacy Flag data
         */
        protected CharacteristicData mPeripheralPrivacyFlagData;

        /**
         * Encrypted Data Key Material data
         */
        protected CharacteristicData mEncryptedDataKeyMaterialData;

        /**
         * LE GATT Security Levels data
         */
        protected CharacteristicData mLeGattSecurityLevelsData;

        /**
         * @see #addDeviceName(byte[])
         */
        @NonNull
        public Builder<T> addDeviceName(@NonNull DeviceName deviceName) {
            return addDeviceName(deviceName.getBytes());
        }

        /**
         * @see #addDeviceName(boolean, int, long, byte[])
         */
        @NonNull
        public Builder<T> addDeviceName(@NonNull byte[] value) {
            return addDeviceName(true, BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Device Name characteristic
         *
         * @param isWritable   {@code true}:Device Name is writable, {@code false}:read only
         * @param responseCode response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addDeviceName(boolean isWritable, int responseCode, long delay, @NonNull byte[] value) {
            int property = BluetoothGattCharacteristic.PROPERTY_READ;
            int permission = BluetoothGattCharacteristic.PERMISSION_READ;
            if (isWritable) {
                property |= BluetoothGattCharacteristic.PROPERTY_WRITE;
                permission |= BluetoothGattCharacteristic.PERMISSION_WRITE;
            }
            mDeviceNameData = new CharacteristicData(DEVICE_NAME_CHARACTERISTIC
                    , property
                    , permission
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Device Name characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDeviceName() {
            mDeviceNameData = null;
            return this;
        }

        /**
         * @see #addAppearance(byte[])
         */
        @NonNull
        public Builder<T> addAppearance(@NonNull Appearance appearance) {
            return addAppearance(appearance.getBytes());
        }

        /**
         * @see #addAppearance(boolean, int, long, byte[])
         */
        @NonNull
        public Builder<T> addAppearance(@NonNull byte[] value) {
            return addAppearance(true, BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Appearance characteristic
         *
         * @param isWritable   {@code true}:Appearance is writable, {@code false}:read only
         * @param responseCode response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAppearance(boolean isWritable, int responseCode, long delay, @NonNull byte[] value) {
            int property = BluetoothGattCharacteristic.PROPERTY_READ;
            int permission = BluetoothGattCharacteristic.PERMISSION_READ;
            if (isWritable) {
                property |= BluetoothGattCharacteristic.PROPERTY_WRITE;
                permission |= BluetoothGattCharacteristic.PERMISSION_WRITE;
            }
            mAppearanceData = new CharacteristicData(APPEARANCE_CHARACTERISTIC
                    , property
                    , permission
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Appearance characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAppearance() {
            mAppearanceData = null;
            return this;
        }

        /**
         * @see #addPeripheralPreferredConnectionParameters(byte[])
         */
        @NonNull
        public Builder<T> addPeripheralPreferredConnectionParameters(@NonNull PeripheralPreferredConnectionParameters peripheralPreferredConnectionParameters) {
            return addPeripheralPreferredConnectionParameters(peripheralPreferredConnectionParameters.getBytes());
        }

        /**
         * @see #addPeripheralPreferredConnectionParameters(int, long, byte[])
         */
        @NonNull
        public Builder<T> addPeripheralPreferredConnectionParameters(@NonNull byte[] value) {
            return addPeripheralPreferredConnectionParameters(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Peripheral Preferred Connection Parameters characteristic
         *
         * @param responseCode response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addPeripheralPreferredConnectionParameters(int responseCode, long delay, @NonNull byte[] value) {
            mPeripheralPreferredConnectionParametersData = new CharacteristicData(PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC
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
         * remove Peripheral Preferred Connection Parameters characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removePeripheralPreferredConnectionParameters() {
            mPeripheralPreferredConnectionParametersData = null;
            return this;
        }

        /**
         * @see #addCentralAddressResolution(byte[])
         */
        @NonNull
        public Builder<T> addCentralAddressResolution(@NonNull CentralAddressResolution centralAddressResolution) {
            return addCentralAddressResolution(centralAddressResolution.getBytes());
        }

        /**
         * @see #addCentralAddressResolution(int, long, byte[])
         */
        @NonNull
        public Builder<T> addCentralAddressResolution(@NonNull byte[] value) {
            return addCentralAddressResolution(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Central Address Resolution characteristic
         *
         * @param responseCode response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addCentralAddressResolution(int responseCode, long delay, @NonNull byte[] value) {
            mCentralAddressResolutionData = new CharacteristicData(CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC
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
         * remove Central Address Resolution characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeCentralAddressResolution() {
            mCentralAddressResolutionData = null;
            return this;
        }

        /**
         * @see #addResolvablePrivateAddressOnly(byte[])
         */
        @NonNull
        public Builder<T> addResolvablePrivateAddressOnly(@NonNull ResolvablePrivateAddressOnly resolvablePrivateAddressOnly) {
            return addResolvablePrivateAddressOnly(resolvablePrivateAddressOnly.getBytes());
        }

        /**
         * @see #addResolvablePrivateAddressOnly(int, long, byte[])
         */
        @NonNull
        public Builder<T> addResolvablePrivateAddressOnly(@NonNull byte[] value) {
            return addResolvablePrivateAddressOnly(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Resolvable Private Address Only characteristic
         *
         * @param responseCode response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addResolvablePrivateAddressOnly(int responseCode, long delay, @NonNull byte[] value) {
            mResolvablePrivateAddressOnlyData = new CharacteristicData(RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC
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
         * remove Resolvable Private Address Only characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeResolvablePrivateAddressOnly() {
            mResolvablePrivateAddressOnlyData = null;
            return this;
        }

        /**
         * add Reconnection Address characteristic
         *
         * @param responseCode response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addReconnectionAddress(int responseCode, long delay) {
            mReconnectionAddressData = new CharacteristicData(RECONNECTION_ADDRESS_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , null
                    , 0);
            return this;
        }

        /**
         * remove Reconnection Address characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeReconnectionAddress() {
            mReconnectionAddressData = null;
            return this;
        }

        /**
         * @see #addPeripheralPrivacyFlag(byte[])
         */
        @NonNull
        public Builder<T> addPeripheralPrivacyFlag(@NonNull PeripheralPrivacyFlag peripheralPrivacyFlag) {
            return addPeripheralPrivacyFlag(peripheralPrivacyFlag.getBytes());
        }

        /**
         * @see #addPeripheralPrivacyFlag(boolean, int, long, byte[])
         */
        @NonNull
        public Builder<T> addPeripheralPrivacyFlag(@NonNull byte[] value) {
            return addPeripheralPrivacyFlag(true, BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Peripheral Privacy Flag characteristic
         *
         * @param isWritable   {@code true}:Peripheral Privacy Flag is writable, {@code false}:read only
         * @param responseCode response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addPeripheralPrivacyFlag(boolean isWritable, int responseCode, long delay, @NonNull byte[] value) {
            int property = BluetoothGattCharacteristic.PROPERTY_READ;
            int permission = BluetoothGattCharacteristic.PERMISSION_READ;
            if (isWritable) {
                property |= BluetoothGattCharacteristic.PROPERTY_WRITE;
                permission |= BluetoothGattCharacteristic.PERMISSION_WRITE;
            }
            mPeripheralPrivacyFlagData = new CharacteristicData(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC
                    , property
                    , permission
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Peripheral Privacy Flag characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removePeripheralPrivacyFlag() {
            mPeripheralPrivacyFlagData = null;
            return this;
        }

        /**
         * @see #addEncryptedDataKeyMaterial(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addEncryptedDataKeyMaterial(@NonNull EncryptedDataKeyMaterial encryptedDataKeyMaterial, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addEncryptedDataKeyMaterial(BluetoothGatt.GATT_SUCCESS, 0, encryptedDataKeyMaterial.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Encrypted Data Key Material characteristic
         *
         * @param responseCode response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addEncryptedDataKeyMaterial(int responseCode, long delay, @NonNull byte[] value, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mEncryptedDataKeyMaterialData = new CharacteristicData(ENCRYPTED_DATA_KEY_MATERIAL_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , responseCode
                    , delay
                    , value
                    , notificationCount);
            return this;
        }

        /**
         * remove Encrypted Data Key Material characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeEncryptedDataKeyMaterial() {
            mEncryptedDataKeyMaterialData = null;
            return this;
        }

        /**
         * @see #addLeGattSecurityLevels(byte[])
         */
        @NonNull
        public Builder<T> addLeGattSecurityLevels(@NonNull LeGattSecurityLevels leGattSecurityLevels) {
            return addLeGattSecurityLevels(leGattSecurityLevels.getBytes());
        }

        /**
         * @see #addLeGattSecurityLevels(int, long, byte[])
         */
        @NonNull
        public Builder<T> addLeGattSecurityLevels(@NonNull byte[] value) {
            return addLeGattSecurityLevels(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add LE GATT Security Levels characteristic
         *
         * @param responseCode response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addLeGattSecurityLevels(int responseCode, long delay, @NonNull byte[] value) {
            mLeGattSecurityLevelsData = new CharacteristicData(LE_GATT_SECURITY_LEVELS_CHARACTERISTIC
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
         * remove LE GATT Security Levels characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeLeGattSecurityLevels() {
            mLeGattSecurityLevelsData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData createData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mDeviceNameData == null) {
                throw new RuntimeException("no Device Name data");
            } else {
                characteristicList.add(mDeviceNameData);
            }

            if (mAppearanceData == null) {
                throw new RuntimeException("no Appearance data");
            } else {
                characteristicList.add(mAppearanceData);
            }

            if (mPeripheralPreferredConnectionParametersData != null) {
                characteristicList.add(mPeripheralPreferredConnectionParametersData);
            }

            if (mCentralAddressResolutionData != null) {
                characteristicList.add(mCentralAddressResolutionData);
            }

            if (mResolvablePrivateAddressOnlyData != null) {
                characteristicList.add(mResolvablePrivateAddressOnlyData);
            }

            if (mReconnectionAddressData != null) {
                characteristicList.add(mReconnectionAddressData);
            }

            if (mPeripheralPrivacyFlagData != null) {
                characteristicList.add(mPeripheralPrivacyFlagData);
            }

            if (mEncryptedDataKeyMaterialData != null) {
                characteristicList.add(mEncryptedDataKeyMaterialData);
            }

            if (mLeGattSecurityLevelsData != null) {
                characteristicList.add(mLeGattSecurityLevelsData);
            }

            return new ServiceData(GENERIC_ACCESS_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GenericAccessServiceMockCallback build() {
            return new GenericAccessServiceMockCallback(createData(), false);
        }

    }

    /**
     * @param serviceData {@link ServiceData} instance
     * @param isFallback  fallback flag
     */
    public GenericAccessServiceMockCallback(@NonNull ServiceData serviceData, boolean isFallback) {
        super(serviceData, isFallback);
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
