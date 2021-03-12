package org.im97mori.ble.service.gap.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a05.ServiceChangedAndroid;
import org.im97mori.ble.characteristic.u2b29.ClientSupportedFeatures;
import org.im97mori.ble.characteristic.u2b29.ClientSupportedFeaturesAndroid;
import org.im97mori.ble.characteristic.u2b2a.DatabaseHashAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DATABASE_HASH_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SERVICE_CHANGED_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.GENERIC_ATTRIBUTE_SERVICE;

/**
 * Generic Attribute Service (Service UUID: 0x1801) for Central
 */
public class GenericAttributeService extends AbstractCentralService {

    /**
     * {@link GenericAttributeServiceCallback} instance
     */
    private final GenericAttributeServiceCallback mGenericAttributeServiceCallback;

    /**
     * Service Changed characteristic flag
     * {@code true}:Service Changed characteristic is exist, {@code false}:Service Changed characteristic is not exist or service not ready
     */
    private boolean mIsServiceChangedCharacteristicSupporeted;

    /**
     * Client Supported Features characteristic flag
     * {@code true}:Client Supported Features characteristic is exist, {@code false}:Client Supported Features characteristic is not exist or service not ready
     */
    private boolean mIsClientSupportedFeaturesCharacteristicSupporeted;

    /**
     * Database Hash characteristic flag
     * {@code true}:Database Hash characteristic is exist, {@code false}:Database Hash characteristic is not exist or service not ready
     */
    private boolean mIsDatabaseHashCharacteristicSupporeted;

    /**
     * @param bleConnection                   {@link BLEConnection} instance
     * @param genericAttributeServiceCallback {@link GenericAttributeServiceCallback} instance
     * @param bleCallback                     {@link BLECallback} instance(optional)
     */
    public GenericAttributeService(@NonNull BLEConnection bleConnection, @NonNull GenericAttributeServiceCallback genericAttributeServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mGenericAttributeServiceCallback = genericAttributeServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mIsServiceChangedCharacteristicSupporeted = false;
            mIsClientSupportedFeaturesCharacteristicSupporeted = false;
            mIsDatabaseHashCharacteristicSupporeted = false;
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
                if (GENERIC_ATTRIBUTE_SERVICE.equals(bluetoothGattService.getUuid())) {
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SERVICE_CHANGED_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && (BluetoothGattCharacteristic.PROPERTY_INDICATE & bluetoothGattCharacteristic.getProperties()) != 0
                            && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsServiceChangedCharacteristicSupporeted = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && (BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties()) {
                        mIsClientSupportedFeaturesCharacteristicSupporeted = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DATABASE_HASH_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && BluetoothGattCharacteristic.PROPERTY_READ == bluetoothGattCharacteristic.getProperties()) {
                        mIsDatabaseHashCharacteristicSupporeted = true;
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ATTRIBUTE_SERVICE.equals(serviceUUID)) {
            if (CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAttributeServiceCallback.onClientSupportedFeaturesReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientSupportedFeaturesAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (DATABASE_HASH_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAttributeServiceCallback.onDatabaseHashReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, DatabaseHashAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ATTRIBUTE_SERVICE.equals(serviceUUID)) {
            if (CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAttributeServiceCallback.onClientSupportedFeaturesReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (DATABASE_HASH_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAttributeServiceCallback.onDatabaseHashReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ATTRIBUTE_SERVICE.equals(serviceUUID)) {
            if (CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAttributeServiceCallback.onClientSupportedFeaturesReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (DATABASE_HASH_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAttributeServiceCallback.onDatabaseHashReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ATTRIBUTE_SERVICE.equals(serviceUUID)) {
            if (CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAttributeServiceCallback.onClientSupportedFeaturesWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientSupportedFeaturesAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ATTRIBUTE_SERVICE.equals(serviceUUID)) {
            if (CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAttributeServiceCallback.onClientSupportedFeaturesWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ATTRIBUTE_SERVICE.equals(serviceUUID)) {
            if (CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC.equals(characteristicUUID)) {
                mGenericAttributeServiceCallback.onClientSupportedFeaturesWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ATTRIBUTE_SERVICE.equals(serviceUUID) && SERVICE_CHANGED_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            mGenericAttributeServiceCallback.onServiceChangedClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ATTRIBUTE_SERVICE.equals(serviceUUID) && SERVICE_CHANGED_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            mGenericAttributeServiceCallback.onServiceChangedClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ATTRIBUTE_SERVICE.equals(serviceUUID) && SERVICE_CHANGED_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            mGenericAttributeServiceCallback.onServiceChangedClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
        }
        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ATTRIBUTE_SERVICE.equals(serviceUUID) && SERVICE_CHANGED_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                mGenericAttributeServiceCallback.onServiceChangedIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
            } else {
                mGenericAttributeServiceCallback.onServiceChangedIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
            }
        }
        super.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ATTRIBUTE_SERVICE.equals(serviceUUID) && SERVICE_CHANGED_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                mGenericAttributeServiceCallback.onServiceChangedIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            } else {
                mGenericAttributeServiceCallback.onServiceChangedIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            }
        }
        super.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ATTRIBUTE_SERVICE.equals(serviceUUID) && SERVICE_CHANGED_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                mGenericAttributeServiceCallback.onServiceChangedIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            } else {
                mGenericAttributeServiceCallback.onServiceChangedIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            }
        }
        super.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && GENERIC_ATTRIBUTE_SERVICE.equals(serviceUUID) && SERVICE_CHANGED_CHARACTERISTIC.equals(characteristicUUID)) {
            mGenericAttributeServiceCallback.onServiceChangedIndicated(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ServiceChangedAndroid.CREATOR.createFromByteArray(values));
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * check Service Changed characteristic
     *
     * @return {@code true}:Service Changed characteristic is exist, {@code false}:Service Changed characteristic is not exist or service not ready
     */
    public boolean isServiceChangedCharacteristicSupporeted() {
        return mIsServiceChangedCharacteristicSupporeted;
    }

    /**
     * check Client Supported Features characteristic
     *
     * @return {@code true}:Client Supported Features characteristic is exist, {@code false}:Client Supported Features characteristic is not exist or service not ready
     */
    public boolean isClientSupportedFeaturesCharacteristicSupporeted() {
        return mIsClientSupportedFeaturesCharacteristicSupporeted;
    }

    /**
     * check Database Hash Features characteristic
     *
     * @return {@code true}:Database Hashs characteristic is exist, {@code false}:Database Hash characteristic is not exist or service not ready
     */
    public boolean isDatabaseHashCharacteristicSupporeted() {
        return mIsDatabaseHashCharacteristicSupporeted;
    }

    /**
     * get Service Changed's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see GenericAttributeServiceCallback#onServiceChangedClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see GenericAttributeServiceCallback#onServiceChangedClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see GenericAttributeServiceCallback#onServiceChangedClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getServiceChangedClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isServiceChangedCharacteristicSupporeted()) {
            taskId = mBLEConnection.createReadDescriptorTask(GENERIC_ATTRIBUTE_SERVICE, null, SERVICE_CHANGED_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Service Changed indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see GenericAttributeServiceCallback#onServiceChangedIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see GenericAttributeServiceCallback#onServiceChangedIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see GenericAttributeServiceCallback#onServiceChangedIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startServiceChangedIndication() {
        Integer taskId = null;
        if (isStarted() && isServiceChangedCharacteristicSupporeted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(GENERIC_ATTRIBUTE_SERVICE, null, SERVICE_CHANGED_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Service Changed indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see GenericAttributeServiceCallback#onServiceChangedIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see GenericAttributeServiceCallback#onServiceChangedIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see GenericAttributeServiceCallback#onServiceChangedIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopServiceChangedIndication() {
        Integer taskId = null;
        if (isStarted() && isServiceChangedCharacteristicSupporeted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(GENERIC_ATTRIBUTE_SERVICE, null, SERVICE_CHANGED_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Client Supported Features
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see GenericAttributeServiceCallback#onClientSupportedFeaturesReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientSupportedFeaturesAndroid, Bundle)
     * @see GenericAttributeServiceCallback#onClientSupportedFeaturesReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see GenericAttributeServiceCallback#onClientSupportedFeaturesReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getClientSupportedFeatures() {
        Integer taskId = null;
        if (isStarted() && isClientSupportedFeaturesCharacteristicSupporeted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(GENERIC_ATTRIBUTE_SERVICE, null, CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Client Supported Features
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see GenericAttributeServiceCallback#onClientSupportedFeaturesWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientSupportedFeaturesAndroid, Bundle)
     * @see GenericAttributeServiceCallback#onClientSupportedFeaturesWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see GenericAttributeServiceCallback#onClientSupportedFeaturesWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setClientSupportedFeatures(@NonNull ClientSupportedFeatures clientSupportedFeatures) {
        Integer taskId = null;
        if (isStarted() && isClientSupportedFeaturesCharacteristicSupporeted()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(GENERIC_ATTRIBUTE_SERVICE, null, CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC, null, clientSupportedFeatures, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Database Hash
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see GenericAttributeServiceCallback#onDatabaseHashReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, DatabaseHashAndroid, Bundle)
     * @see GenericAttributeServiceCallback#onDatabaseHashReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see GenericAttributeServiceCallback#onDatabaseHashReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDatabaseHash() {
        Integer taskId = null;
        if (isStarted() && isDatabaseHashCharacteristicSupporeted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(GENERIC_ATTRIBUTE_SERVICE, null, DATABASE_HASH_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

}
