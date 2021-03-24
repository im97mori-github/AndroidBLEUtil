package org.im97mori.ble.service.gatt.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a00.DeviceName;
import org.im97mori.ble.characteristic.u2a00.DeviceNameAndroid;
import org.im97mori.ble.characteristic.u2a01.Appearance;
import org.im97mori.ble.characteristic.u2a01.AppearanceAndroid;
import org.im97mori.ble.characteristic.u2a02.PeripheralPrivacyFlag;
import org.im97mori.ble.characteristic.u2a02.PeripheralPrivacyFlagAndroid;
import org.im97mori.ble.characteristic.u2a03.ReconnectionAddress;
import org.im97mori.ble.characteristic.u2a03.ReconnectionAddressAndroid;
import org.im97mori.ble.characteristic.u2a04.PeripheralPreferredConnectionParametersAndroid;
import org.im97mori.ble.characteristic.u2aa6.CentralAddressResolutionAndroid;
import org.im97mori.ble.characteristic.u2ac9.ResolvablePrivateAddressOnlyAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.WriteCharacteristicTask;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.APPEARANCE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DEVICE_NAME_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RECONNECTION_ADDRESS_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.ServiceUUID.GENERIC_ACCESS_SERVICE;

/**
 * Generic Access Service (Service UUID: 0x1800) for Central
 */
public class GenericAccessService extends AbstractCentralService {

    /**
     * {@link GenericAccessServiceCallback} instance
     */
    private final GenericAccessServiceCallback mGenericAccessServiceCallback;

    /**
     * Device Name characteristic writable flag
     * {@code true}:Device Name characteristic is writable, {@code false}:Device Name characteristic is not writable or service not ready
     */
    private boolean mIsDeviceNameCharacteristicWritable;

    /**
     * Appearance characteristic writable flag
     * {@code true}:Appearance characteristic is writable, {@code false}:Appearance characteristic is not writable or service not ready
     */
    private boolean mIsAppearanceCharacteristicWritable;

    /**
     * Peripheral Preferred Connection Parameters characteristic flag
     * {@code true}:Peripheral Preferred Connection Parameters characteristic is exist, {@code false}:Peripheral Preferred Connection Parameters characteristic is not exist or service not ready
     */
    private boolean mIsPeripheralPreferredConnectionParametersCharacteristicSupported;

    /**
     * Central Address Resolution characteristic flag
     * {@code true}:Central Address Resolution characteristic is exist, {@code false}:Central Address Resolution characteristic is not exist or service not ready
     */
    private boolean mIsCentralAddressResolutionCharacteristicSupported;

    /**
     * Resolvable Private Address Only characteristic flag
     * {@code true}:Resolvable Private Address Only characteristic is exist, {@code false}:Resolvable Private Address Only characteristic is not exist or service not ready
     */
    private boolean mIsResolvablePrivateAddressOnlyCharacteristicSupported;

    /**
     * Reconnection Address characteristic flag
     * {@code true}:Reconnection Address characteristic is exist, {@code false}:Reconnection Address characteristic is not exist or service not ready
     */
    private boolean mIsReconnectionAddressCharacteristicSupported;

    /**
     * Peripheral Privacy Flag characteristic flag
     * {@code true}:Peripheral Privacy Flag characteristic is exist, {@code false}:Peripheral Privacy Flag characteristic is not exist or service not ready
     */
    private boolean mIsPeripheralPrivacyFlagCharacteristicSupported;

    /**
     * Peripheral Privacy Flag characteristic writable flag
     * {@code true}:Peripheral Privacy Flag characteristic is writable, {@code false}:Peripheral Privacy Flag characteristic is not writable or service not ready
     */
    private boolean mIsPeripheralPrivacyFlagCharacteristicWritable;

    /**
     * @param bleConnection                {@link BLEConnection} instance
     * @param genericAccessServiceCallback {@link GenericAccessServiceCallback} instance
     * @param bleCallback                  {@link BLECallback} instance(optional)
     */
    public GenericAccessService(@NonNull BLEConnection bleConnection, @NonNull GenericAccessServiceCallback genericAccessServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mGenericAccessServiceCallback = genericAccessServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mIsDeviceNameCharacteristicWritable = false;
            mIsAppearanceCharacteristicWritable = false;
            mIsPeripheralPreferredConnectionParametersCharacteristicSupported = false;
            mIsCentralAddressResolutionCharacteristicSupported = false;
            mIsResolvablePrivateAddressOnlyCharacteristicSupported = false;
            mIsReconnectionAddressCharacteristicSupported = false;
            mIsPeripheralPrivacyFlagCharacteristicSupported = false;
            mIsPeripheralPrivacyFlagCharacteristicWritable = false;
        }
        super.onBLEDisconnected(taskId, bluetoothDevice, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic;
            for (BluetoothGattService bluetoothGattService : serviceList) {
                if (GENERIC_ACCESS_SERVICE.equals(bluetoothGattService.getUuid())) {
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DEVICE_NAME_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && (BluetoothGattCharacteristic.PROPERTY_WRITE & bluetoothGattCharacteristic.getProperties()) != 0) {
                        mIsDeviceNameCharacteristicWritable = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(APPEARANCE_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && (BluetoothGattCharacteristic.PROPERTY_WRITE & bluetoothGattCharacteristic.getProperties()) != 0) {
                        mIsAppearanceCharacteristicWritable = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && BluetoothGattCharacteristic.PROPERTY_READ == bluetoothGattCharacteristic.getProperties()) {
                        mIsPeripheralPreferredConnectionParametersCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && BluetoothGattCharacteristic.PROPERTY_READ == bluetoothGattCharacteristic.getProperties()) {
                        mIsCentralAddressResolutionCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && BluetoothGattCharacteristic.PROPERTY_READ == bluetoothGattCharacteristic.getProperties()) {
                        mIsResolvablePrivateAddressOnlyCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RECONNECTION_ADDRESS_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && BluetoothGattCharacteristic.PROPERTY_WRITE == bluetoothGattCharacteristic.getProperties()) {
                        mIsReconnectionAddressCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                        mIsPeripheralPrivacyFlagCharacteristicSupported = true;
                        if ((BluetoothGattCharacteristic.PROPERTY_WRITE & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mIsPeripheralPrivacyFlagCharacteristicWritable = true;
                        }
                    }
                }
            }
        }
        super.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ACCESS_SERVICE.equals(serviceUUID)) {
            if (DEVICE_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onDeviceNameReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, DeviceNameAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (APPEARANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onAppearanceReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AppearanceAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onPeripheralPreferredConnectionParametersReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, PeripheralPreferredConnectionParametersAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onCentralAddressResolutionReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, CentralAddressResolutionAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onResolvablePrivateAddressOnlyReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ResolvablePrivateAddressOnlyAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onPeripheralPrivacyFlagReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, PeripheralPrivacyFlagAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ACCESS_SERVICE.equals(serviceUUID)) {
            if (DEVICE_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onDeviceNameReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (APPEARANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onAppearanceReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onPeripheralPreferredConnectionParametersReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onCentralAddressResolutionReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onResolvablePrivateAddressOnlyReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onPeripheralPrivacyFlagReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ACCESS_SERVICE.equals(serviceUUID)) {
            if (DEVICE_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onDeviceNameReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (APPEARANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onAppearanceReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onPeripheralPreferredConnectionParametersReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onCentralAddressResolutionReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onResolvablePrivateAddressOnlyReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onPeripheralPrivacyFlagReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ACCESS_SERVICE.equals(serviceUUID)) {
            if (DEVICE_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onDeviceNameWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, DeviceNameAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (APPEARANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onAppearanceWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AppearanceAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (RECONNECTION_ADDRESS_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onReconnectionAddressWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ReconnectionAddressAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onPeripheralPrivacyFlagWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, PeripheralPrivacyFlagAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ACCESS_SERVICE.equals(serviceUUID)) {
            if (DEVICE_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onDeviceNameWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (APPEARANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onAppearanceWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (RECONNECTION_ADDRESS_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onReconnectionAddressWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onPeripheralPrivacyFlagWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ACCESS_SERVICE.equals(serviceUUID)) {
            if (DEVICE_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onDeviceNameWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (APPEARANCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onAppearanceWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (RECONNECTION_ADDRESS_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onReconnectionAddressWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAccessServiceCallback.onPeripheralPrivacyFlagWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * check Device Name characteristic writable
     *
     * @return {@code true}:Device Name characteristic is writable, {@code false}:Device Name characteristic is not writable or service not ready
     */
    public boolean isDeviceNameCharacteristicWritable() {
        return mIsDeviceNameCharacteristicWritable;
    }

    /**
     * check Appearance characteristic writable
     *
     * @return {@code true}:Appearance characteristic is writable, {@code false}:Appearance characteristic is not writable or service not ready
     */
    public boolean isAppearanceCharacteristicWritable() {
        return mIsAppearanceCharacteristicWritable;
    }

    /**
     * check Peripheral Preferred Connection Parameters characteristic
     *
     * @return {@code true}:Peripheral Preferred Connection Parameters characteristic is exist, {@code false}:Peripheral Preferred Connection Parameters characteristic is not exist or service not ready
     */
    public boolean isPeripheralPreferredConnectionParametersCharacteristicSupported() {
        return mIsPeripheralPreferredConnectionParametersCharacteristicSupported;
    }

    /**
     * check Central Address Resolution characteristic
     *
     * @return {@code true}:Central Address Resolution characteristic is exist, {@code false}:Central Address Resolution characteristic is not exist or service not ready
     */
    public boolean isCentralAddressResolutionCharacteristicSupported() {
        return mIsCentralAddressResolutionCharacteristicSupported;
    }

    /**
     * check Resolvable Private Address Only characteristic
     *
     * @return {@code true}:Resolvable Private Address Only characteristic is exist, {@code false}:Resolvable Private Address Only characteristic is not exist or service not ready
     */
    public boolean isResolvablePrivateAddressOnlyCharacteristicSupported() {
        return mIsResolvablePrivateAddressOnlyCharacteristicSupported;
    }

    /**
     * check Reconnection Address characteristic
     *
     * @return {@code true}:Reconnection Address characteristic is exist, {@code false}:Reconnection Address characteristic is not exist or service not ready
     */
    public boolean isReconnectionAddressCharacteristicSupported() {
        return mIsReconnectionAddressCharacteristicSupported;
    }

    /**
     * check Peripheral Privacy Flag characteristic
     *
     * @return {@code true}:Peripheral Privacy Flag characteristic is exist, {@code false}:Peripheral Privacy Flag characteristic is not exist or service not ready
     */
    public boolean isPeripheralPrivacyFlagCharacteristicSupported() {
        return mIsPeripheralPrivacyFlagCharacteristicSupported;
    }

    /**
     * check Peripheral Privacy Flag characteristic writable
     *
     * @return {@code true}:Peripheral Privacy Flag characteristic is writable, {@code false}:Peripheral Privacy Flag characteristic is not writable or service not ready
     */
    public boolean isPeripheralPrivacyFlagCharacteristicWritable() {
        return mIsPeripheralPrivacyFlagCharacteristicWritable;
    }

    /**
     * get Device Name
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see GenericAccessServiceCallback#onDeviceNameReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, DeviceNameAndroid, Bundle)
     * @see GenericAccessServiceCallback#onDeviceNameReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see GenericAccessServiceCallback#onDeviceNameReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDeviceName() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(GENERIC_ACCESS_SERVICE, null, DEVICE_NAME_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Device Name
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see GenericAccessServiceCallback#onDeviceNameWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, DeviceNameAndroid, Bundle)
     * @see GenericAccessServiceCallback#onDeviceNameWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, DeviceNameAndroid, Bundle)
     * @see GenericAccessServiceCallback#onDeviceNameWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setDeviceName(@NonNull DeviceName deviceName) {
        Integer taskId = null;
        if (isStarted() && isDeviceNameCharacteristicWritable()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(GENERIC_ACCESS_SERVICE, null, DEVICE_NAME_CHARACTERISTIC, null, deviceName, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Appearance
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see GenericAccessServiceCallback#onAppearanceReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AppearanceAndroid, Bundle)
     * @see GenericAccessServiceCallback#onAppearanceReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see GenericAccessServiceCallback#onAppearanceReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAppearance() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(GENERIC_ACCESS_SERVICE, null, APPEARANCE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Appearance
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see GenericAccessServiceCallback#onAppearanceWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AppearanceAndroid, Bundle)
     * @see GenericAccessServiceCallback#onAppearanceWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see GenericAccessServiceCallback#onAppearanceWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAppearance(@NonNull Appearance appearance) {
        Integer taskId = null;
        if (isStarted() && isAppearanceCharacteristicWritable()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(GENERIC_ACCESS_SERVICE, null, APPEARANCE_CHARACTERISTIC, null, appearance, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Peripheral Preferred Connection Parameters
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see GenericAccessServiceCallback#onPeripheralPreferredConnectionParametersReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, PeripheralPreferredConnectionParametersAndroid, Bundle)
     * @see GenericAccessServiceCallback#onPeripheralPreferredConnectionParametersReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see GenericAccessServiceCallback#onPeripheralPreferredConnectionParametersReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getPeripheralPreferredConnectionParameters() {
        Integer taskId = null;
        if (isStarted() && isPeripheralPreferredConnectionParametersCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(GENERIC_ACCESS_SERVICE, null, PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Central Address Resolution Parameters
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see GenericAccessServiceCallback#onCentralAddressResolutionReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, CentralAddressResolutionAndroid, Bundle)
     * @see GenericAccessServiceCallback#onCentralAddressResolutionReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see GenericAccessServiceCallback#onCentralAddressResolutionReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getCentralAddressResolutionParameters() {
        Integer taskId = null;
        if (isStarted() && isCentralAddressResolutionCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(GENERIC_ACCESS_SERVICE, null, CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Resolvable Private Address Only Parameters
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see GenericAccessServiceCallback#onResolvablePrivateAddressOnlyReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ResolvablePrivateAddressOnlyAndroid, Bundle)
     * @see GenericAccessServiceCallback#onResolvablePrivateAddressOnlyReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see GenericAccessServiceCallback#onResolvablePrivateAddressOnlyReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getResolvablePrivateAddressOnly() {
        Integer taskId = null;
        if (isStarted() && isResolvablePrivateAddressOnlyCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(GENERIC_ACCESS_SERVICE, null, RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Reconnection Address
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see GenericAccessServiceCallback#onReconnectionAddressWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ReconnectionAddressAndroid, Bundle)
     * @see GenericAccessServiceCallback#onReconnectionAddressWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see GenericAccessServiceCallback#onReconnectionAddressWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setReconnectionAddress(@NonNull ReconnectionAddress reconnectionAddress) {
        Integer taskId = null;
        if (isStarted() && isReconnectionAddressCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(GENERIC_ACCESS_SERVICE, null, RECONNECTION_ADDRESS_CHARACTERISTIC, null, reconnectionAddress, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Peripheral Privacy Flag Parameters
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see GenericAccessServiceCallback#onPeripheralPrivacyFlagReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, PeripheralPrivacyFlagAndroid, Bundle)
     * @see GenericAccessServiceCallback#onPeripheralPrivacyFlagReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see GenericAccessServiceCallback#onPeripheralPrivacyFlagReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getPeripheralPrivacyFlag() {
        Integer taskId = null;
        if (isStarted() && isPeripheralPrivacyFlagCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(GENERIC_ACCESS_SERVICE, null, PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Peripheral Privacy Flag
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see GenericAccessServiceCallback#onPeripheralPrivacyFlagWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, PeripheralPrivacyFlagAndroid, Bundle)
     * @see GenericAccessServiceCallback#onPeripheralPrivacyFlagWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see GenericAccessServiceCallback#onPeripheralPrivacyFlagWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setPeripheralPrivacyFlag(@NonNull PeripheralPrivacyFlag peripheralPrivacyFlag) {
        Integer taskId = null;
        if (isStarted() && isPeripheralPrivacyFlagCharacteristicWritable()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(GENERIC_ACCESS_SERVICE, null, PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC, null, peripheralPrivacyFlag, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

}
