package org.im97mori.ble.service.wss.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a9d.WeightMeasurementAndroid;
import org.im97mori.ble.characteristic.u2a9e.WeightScaleFeatureAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WEIGHT_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WEIGHT_SCALE_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.WEIGHT_SCALE_SERVICE;

/**
 * Weight Scale Service (Service UUID: 0x181D) for Central
 */
public class WeightScaleService extends AbstractCentralService {

    /**
     * {@link WeightScaleServiceCallback} instance
     */
    private final WeightScaleServiceCallback mWeightScaleServiceCallback;

    /**
     * @param bleConnection              {@link BLEConnection} instance
     * @param weightScaleServiceCallback {@link WeightScaleServiceCallback} instance
     * @param bleCallback                {@link BLECallback} instance(optional)
     */
    public WeightScaleService(@NonNull BLEConnection bleConnection, @NonNull WeightScaleServiceCallback weightScaleServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mWeightScaleServiceCallback = weightScaleServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && WEIGHT_SCALE_SERVICE.equals(serviceUUID) && WEIGHT_SCALE_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
            mWeightScaleServiceCallback.onWeightScaleFeatureReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, WeightScaleFeatureAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && WEIGHT_SCALE_SERVICE.equals(serviceUUID) && WEIGHT_SCALE_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
            mWeightScaleServiceCallback.onWeightScaleFeatureReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && WEIGHT_SCALE_SERVICE.equals(serviceUUID) && WEIGHT_SCALE_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
            mWeightScaleServiceCallback.onWeightScaleFeatureReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && WEIGHT_SCALE_SERVICE.equals(serviceUUID) && WEIGHT_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            mWeightScaleServiceCallback.onWeightMeasurementClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && WEIGHT_SCALE_SERVICE.equals(serviceUUID) && WEIGHT_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            mWeightScaleServiceCallback.onWeightMeasurementClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && WEIGHT_SCALE_SERVICE.equals(serviceUUID) && WEIGHT_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            mWeightScaleServiceCallback.onWeightMeasurementClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && WEIGHT_SCALE_SERVICE.equals(serviceUUID) && WEIGHT_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                mWeightScaleServiceCallback.onWeightMeasurementIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
            } else {
                mWeightScaleServiceCallback.onWeightMeasurementIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
            }
        }
        super.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && WEIGHT_SCALE_SERVICE.equals(serviceUUID) && WEIGHT_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                mWeightScaleServiceCallback.onWeightMeasurementIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else {
                mWeightScaleServiceCallback.onWeightMeasurementIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && WEIGHT_SCALE_SERVICE.equals(serviceUUID) && WEIGHT_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                mWeightScaleServiceCallback.onWeightMeasurementIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else {
                mWeightScaleServiceCallback.onWeightMeasurementIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && WEIGHT_SCALE_SERVICE.equals(serviceUUID) && WEIGHT_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
            mWeightScaleServiceCallback.onWeightMeasurementIndicated(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, WeightMeasurementAndroid.CREATOR.createFromByteArray(values));
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * get Weight Scale Feature
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see WeightScaleServiceCallback#onWeightScaleFeatureReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, WeightScaleFeatureAndroid, Bundle)
     * @see WeightScaleServiceCallback#onWeightScaleFeatureReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see WeightScaleServiceCallback#onWeightScaleFeatureReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer getWeightScaleFeature() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(WEIGHT_SCALE_SERVICE, null, WEIGHT_SCALE_FEATURE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Weight Measurement's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see WeightScaleServiceCallback#onWeightMeasurementClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see WeightScaleServiceCallback#onWeightMeasurementClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see WeightScaleServiceCallback#onWeightMeasurementClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer getWeightMeasurementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadDescriptorTask(WEIGHT_SCALE_SERVICE, null, WEIGHT_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Weight Measurement indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see WeightScaleServiceCallback#onWeightMeasurementIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see WeightScaleServiceCallback#onWeightMeasurementIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see WeightScaleServiceCallback#onWeightMeasurementIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startWeightMeasurementIndication() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(WEIGHT_SCALE_SERVICE, null, WEIGHT_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Weight Measurement indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see WeightScaleServiceCallback#onWeightMeasurementIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see WeightScaleServiceCallback#onWeightMeasurementIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see WeightScaleServiceCallback#onWeightMeasurementIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopWeightMeasurementIndication() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(WEIGHT_SCALE_SERVICE, null, WEIGHT_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

}
