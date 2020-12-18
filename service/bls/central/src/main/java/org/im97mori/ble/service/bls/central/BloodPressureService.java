package org.im97mori.ble.service.bls.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a35.BloodPressureMeasurementAndroid;
import org.im97mori.ble.characteristic.u2a36.IntermediateCuffPressureAndroid;
import org.im97mori.ble.characteristic.u2a49.BloodPressureFeatureAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BLOOD_PRESSURE_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.BLOOD_PRESSURE_SERVICE;

/**
 * Blood Pressure Service (Service UUID: 0x1810) for Central
 */
public class BloodPressureService extends AbstractCentralService {

    /**
     * {@link BloodPressureServiceCallback} instance
     */
    private final BloodPressureServiceCallback mBloodPressureServiceCallback;

    /**
     * Intermediate Cuff Pressure characteristic flag
     * {@code true}:Intermediate Cuff Pressure characteristic is exist, {@code false}:Intermediate Cuff Pressure characteristic is not exist or service not ready
     */
    private boolean mIsIntermediateCuffPressureCharacteristicSupporeted;

    /**
     * @param bleConnection                {@link BLEConnection} instance
     * @param bloodPressureServiceCallback {@link BloodPressureServiceCallback} instance
     * @param bleCallback                  {@link BLECallback} instance(optional)
     */
    public BloodPressureService(@NonNull BLEConnection bleConnection, @NonNull BloodPressureServiceCallback bloodPressureServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mBloodPressureServiceCallback = bloodPressureServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mIsIntermediateCuffPressureCharacteristicSupporeted = false;
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
            BluetoothGattDescriptor bluetoothGattDescriptor;
            for (BluetoothGattService bluetoothGattService : serviceList) {
                if (BLOOD_PRESSURE_SERVICE.equals(bluetoothGattService.getUuid())) {
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && BluetoothGattCharacteristic.PROPERTY_NOTIFY == bluetoothGattCharacteristic.getProperties()) {
                        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_SUPPORTED_FEATURES_CHARACTERISTIC);
                        if (bluetoothGattDescriptor != null) {
                            mIsIntermediateCuffPressureCharacteristicSupporeted = true;
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BLOOD_PRESSURE_SERVICE.equals(serviceUUID) && BLOOD_PRESSURE_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
            mBloodPressureServiceCallback.onBloodPressureFeatureReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, BloodPressureFeatureAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BLOOD_PRESSURE_SERVICE.equals(serviceUUID) && BLOOD_PRESSURE_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
            mBloodPressureServiceCallback.onBloodPressureFeatureReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BLOOD_PRESSURE_SERVICE.equals(serviceUUID) && BLOOD_PRESSURE_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
            mBloodPressureServiceCallback.onBloodPressureFeatureReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BLOOD_PRESSURE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mBloodPressureServiceCallback.onBloodPressureMeasurementClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mBloodPressureServiceCallback.onIntermediateCuffPressureClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BLOOD_PRESSURE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mBloodPressureServiceCallback.onBloodPressureMeasurementClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mBloodPressureServiceCallback.onIntermediateCuffPressureClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BLOOD_PRESSURE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mBloodPressureServiceCallback.onBloodPressureMeasurementClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mBloodPressureServiceCallback.onIntermediateCuffPressureClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BLOOD_PRESSURE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mBloodPressureServiceCallback.onBloodPressureMeasurementIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                } else {
                    mBloodPressureServiceCallback.onBloodPressureMeasurementIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                }
            } else if (INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mBloodPressureServiceCallback.onIntermediateCuffPressureNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                } else {
                    mBloodPressureServiceCallback.onIntermediateCuffPressureNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                }
            }
        }
        super.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BLOOD_PRESSURE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mBloodPressureServiceCallback.onBloodPressureMeasurementIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                } else {
                    mBloodPressureServiceCallback.onBloodPressureMeasurementIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                }
            } else if (INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mBloodPressureServiceCallback.onIntermediateCuffPressureNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                } else {
                    mBloodPressureServiceCallback.onIntermediateCuffPressureNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                }
            }
        }
        super.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BLOOD_PRESSURE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mBloodPressureServiceCallback.onBloodPressureMeasurementIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                } else {
                    mBloodPressureServiceCallback.onBloodPressureMeasurementIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                }
            } else if (INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mBloodPressureServiceCallback.onIntermediateCuffPressureNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                } else {
                    mBloodPressureServiceCallback.onIntermediateCuffPressureNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                }
            }
        }
        super.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BLOOD_PRESSURE_SERVICE.equals(serviceUUID)) {
            if (BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mBloodPressureServiceCallback.onBloodPressureMeasurementIndicated(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, BloodPressureMeasurementAndroid.CREATOR.createFromByteArray(values));
            } else if (INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mBloodPressureServiceCallback.onIntermediateCuffPressureNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, IntermediateCuffPressureAndroid.CREATOR.createFromByteArray(values));
            }
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * check Intermediate Cuff Pressure characteristic
     *
     * @return {@code true}:Intermediate Cuff Pressure characteristic is exist, {@code false}:Intermediate Cuff Pressure characteristic is not exist or service not ready
     */
    public boolean isIntermediateCuffPressureSupported() {
        return mIsIntermediateCuffPressureCharacteristicSupporeted;
    }

    /**
     * get Blood Pressure Measurement's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see BloodPressureServiceCallback#onBloodPressureMeasurementClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see BloodPressureServiceCallback#onBloodPressureMeasurementClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see BloodPressureServiceCallback#onBloodPressureMeasurementClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getBloodPressureMeasurementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadDescriptorTask(BLOOD_PRESSURE_SERVICE, null, BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Blood Pressure Measurement indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see BloodPressureServiceCallback#onBloodPressureMeasurementIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see BloodPressureServiceCallback#onBloodPressureMeasurementIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see BloodPressureServiceCallback#onBloodPressureMeasurementIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startBloodPressureMeasurementIndication() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(BLOOD_PRESSURE_SERVICE, null, BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Blood Pressure Measurement indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see BloodPressureServiceCallback#onBloodPressureMeasurementIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see BloodPressureServiceCallback#onBloodPressureMeasurementIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see BloodPressureServiceCallback#onBloodPressureMeasurementIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopBloodPressureMeasurementIndication() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(BLOOD_PRESSURE_SERVICE, null, BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Intermediate Cuff Pressure's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see BloodPressureServiceCallback#onIntermediateCuffPressureClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see BloodPressureServiceCallback#onIntermediateCuffPressureClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see BloodPressureServiceCallback#onIntermediateCuffPressureClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getIntermediateCuffPressureClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isIntermediateCuffPressureSupported()) {
            taskId = mBLEConnection.createReadDescriptorTask(BLOOD_PRESSURE_SERVICE, null, INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Intermediate Cuff Pressure notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see BloodPressureServiceCallback#onIntermediateCuffPressureNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see BloodPressureServiceCallback#onIntermediateCuffPressureNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see BloodPressureServiceCallback#onIntermediateCuffPressureNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startIntermediateCuffPressureNotification() {
        Integer taskId = null;
        if (isStarted() && isIntermediateCuffPressureSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(BLOOD_PRESSURE_SERVICE, null, INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Intermediate Cuff Pressure notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see BloodPressureServiceCallback#onIntermediateCuffPressureNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see BloodPressureServiceCallback#onIntermediateCuffPressureNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see BloodPressureServiceCallback#onIntermediateCuffPressureNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopIntermediateCuffPressureNotification() {
        Integer taskId = null;
        if (isStarted() && isIntermediateCuffPressureSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(BLOOD_PRESSURE_SERVICE, null, INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Blood Pressure Feature
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see BloodPressureServiceCallback#onBloodPressureFeatureReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, BloodPressureFeatureAndroid, Bundle)
     * @see BloodPressureServiceCallback#onBloodPressureFeatureReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see BloodPressureServiceCallback#onBloodPressureFeatureReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getBloodPressureFeature() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(BLOOD_PRESSURE_SERVICE, null, BLOOD_PRESSURE_FEATURE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

}
