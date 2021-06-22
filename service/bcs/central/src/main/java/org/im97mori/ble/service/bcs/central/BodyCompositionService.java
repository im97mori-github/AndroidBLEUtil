package org.im97mori.ble.service.bcs.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a9b.BodyCompositionFeatureAndroid;
import org.im97mori.ble.characteristic.u2a9c.BodyCompositionMeasurementAndroid;
import org.im97mori.ble.characteristic.u2a9c.BodyCompositionMeasurementPacketAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.UUID;

import static org.im97mori.ble.constants.CharacteristicUUID.BODY_COMPOSITION_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.BODY_COMPOSITION_SERVICE;

/**
 * Body Composition Service (Service UUID: 0x181B) for Central
 */
public class BodyCompositionService extends AbstractCentralService {

    /**
     * {@link BodyCompositionServiceCallback} instance
     */
    private final BodyCompositionServiceCallback mBodyCompositionServiceCallback;

    /**
     * @param bleConnection                  {@link BLEConnection} instance
     * @param bodyCompositionServiceCallback {@link BodyCompositionServiceCallback} instance
     * @param bleCallback                    {@link BLECallback} instance(optional)
     */
    public BodyCompositionService(@NonNull BLEConnection bleConnection, @NonNull BodyCompositionServiceCallback bodyCompositionServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mBodyCompositionServiceCallback = bodyCompositionServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BODY_COMPOSITION_SERVICE.equals(serviceUUID) && BODY_COMPOSITION_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
            mBodyCompositionServiceCallback.onBodyCompositionFeatureReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, BodyCompositionFeatureAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BODY_COMPOSITION_SERVICE.equals(serviceUUID) && BODY_COMPOSITION_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
            mBodyCompositionServiceCallback.onBodyCompositionFeatureReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BODY_COMPOSITION_SERVICE.equals(serviceUUID) && BODY_COMPOSITION_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
            mBodyCompositionServiceCallback.onBodyCompositionFeatureReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BODY_COMPOSITION_SERVICE.equals(serviceUUID) && BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            mBodyCompositionServiceCallback.onBodyCompositionMeasurementClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BODY_COMPOSITION_SERVICE.equals(serviceUUID) && BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            mBodyCompositionServiceCallback.onBodyCompositionMeasurementClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BODY_COMPOSITION_SERVICE.equals(serviceUUID) && BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            mBodyCompositionServiceCallback.onBodyCompositionMeasurementClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
        }

        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BODY_COMPOSITION_SERVICE.equals(serviceUUID) && BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                mBodyCompositionServiceCallback.onBodyCompositionMeasurementIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
            } else {
                mBodyCompositionServiceCallback.onBodyCompositionMeasurementIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
            }
        }
        super.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BODY_COMPOSITION_SERVICE.equals(serviceUUID) && BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                mBodyCompositionServiceCallback.onBodyCompositionMeasurementIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            } else {
                mBodyCompositionServiceCallback.onBodyCompositionMeasurementIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            }
        }
        super.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BODY_COMPOSITION_SERVICE.equals(serviceUUID) && BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                mBodyCompositionServiceCallback.onBodyCompositionMeasurementIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            } else {
                mBodyCompositionServiceCallback.onBodyCompositionMeasurementIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            }
        }
        super.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BODY_COMPOSITION_SERVICE.equals(serviceUUID) && BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
            mBodyCompositionServiceCallback.onBodyCompositionMeasurementIndicated(bluetoothDevice
                    , serviceUUID
                    , serviceInstanceId
                    , characteristicUUID
                    , characteristicInstanceId
                    , BodyCompositionMeasurementAndroid.CREATOR.createFromMultiplePacketArray(new BodyCompositionMeasurementPacketAndroid[]{BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(values)}));
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * get Body Composition Feature
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see BodyCompositionServiceCallback#onBodyCompositionFeatureReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, BodyCompositionFeatureAndroid, Bundle)
     * @see BodyCompositionServiceCallback#onBodyCompositionFeatureReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see BodyCompositionServiceCallback#onBodyCompositionFeatureReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getBodyCompositionFeature() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(BODY_COMPOSITION_SERVICE, null, BODY_COMPOSITION_FEATURE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }


    /**
     * get Body Composition Measurement's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see BodyCompositionServiceCallback#onBodyCompositionMeasurementClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see BodyCompositionServiceCallback#onBodyCompositionMeasurementClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see BodyCompositionServiceCallback#onBodyCompositionMeasurementClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getBodyCompositionMeasurementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadDescriptorTask(BODY_COMPOSITION_SERVICE, null, BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Body Composition Measurement indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see BodyCompositionServiceCallback#onBodyCompositionMeasurementIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see BodyCompositionServiceCallback#onBodyCompositionMeasurementIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see BodyCompositionServiceCallback#onBodyCompositionMeasurementIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startBodyCompositionMeasurementIndication() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(BODY_COMPOSITION_SERVICE, null, BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Body Composition Measurement indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see BodyCompositionServiceCallback#onBodyCompositionMeasurementIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see BodyCompositionServiceCallback#onBodyCompositionMeasurementIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see BodyCompositionServiceCallback#onBodyCompositionMeasurementIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopBodyCompositionMeasurementIndication() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(BODY_COMPOSITION_SERVICE, null, BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

}
