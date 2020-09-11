package org.im97mori.ble.service.hrs.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a37.HeartRateMeasurementAndroid;
import org.im97mori.ble.characteristic.u2a38.BodySensorLocationAndroid;
import org.im97mori.ble.characteristic.u2a39.HeartRateControlPoint;
import org.im97mori.ble.characteristic.u2a39.HeartRateControlPointAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BODY_SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HEART_RATE_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HEART_RATE_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.HEART_RATE_SERVICE;

/**
 * Heart Rate Service (Service UUID: 0x180D) for Central
 */
public class HeartRateService extends AbstractCentralService {

    /**
     * {@link HeartRateServiceCallback} instance
     */
    private final HeartRateServiceCallback mHeartRateServiceCallback;

    /**
     * Body Sensor Location characteristic flag
     * {@code true}:Body Sensor Location characteristic is exist, {@code false}:Body Sensor Location characteristic is not exist or service not ready
     */
    private boolean mIsBodySensorLocationCharacteristicSupporeted;

    /**
     * Heart Rate Control Point characteristic flag
     * {@code true}:Heart Rate Control Point characteristic is exist, {@code false}:Heart Rate Control Point characteristic is not exist or service not ready
     */
    private boolean mIsHeartRateControlPointCharacteristicSupporeted;

    /**
     * @param bleConnection            {@link BLEConnection} instance
     * @param heartRateServiceCallback {@link HeartRateServiceCallback} instance
     * @param bleCallback              {@link BLECallback} instance(optional)
     */
    public HeartRateService(@NonNull BLEConnection bleConnection, @NonNull HeartRateServiceCallback heartRateServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mHeartRateServiceCallback = heartRateServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mIsBodySensorLocationCharacteristicSupporeted = false;
            mIsHeartRateControlPointCharacteristicSupporeted = false;
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
                if (HEART_RATE_SERVICE.equals(bluetoothGattService.getUuid())) {
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BODY_SENSOR_LOCATION_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                        mIsBodySensorLocationCharacteristicSupporeted = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HEART_RATE_CONTROL_POINT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && (BluetoothGattCharacteristic.PROPERTY_WRITE & bluetoothGattCharacteristic.getProperties()) != 0) {
                        mIsHeartRateControlPointCharacteristicSupporeted = true;
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
    public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEART_RATE_SERVICE.equals(serviceUUID) && BODY_SENSOR_LOCATION_CHARACTERISTIC.equals(characteristicUUID)) {
            mHeartRateServiceCallback.onBodySensorLocationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, BodySensorLocationAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEART_RATE_SERVICE.equals(serviceUUID) && BODY_SENSOR_LOCATION_CHARACTERISTIC.equals(characteristicUUID)) {
            mHeartRateServiceCallback.onBodySensorLocationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEART_RATE_SERVICE.equals(serviceUUID) && BODY_SENSOR_LOCATION_CHARACTERISTIC.equals(characteristicUUID)) {
            mHeartRateServiceCallback.onBodySensorLocationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }

        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEART_RATE_SERVICE.equals(serviceUUID) && HEART_RATE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
            mHeartRateServiceCallback.onHeartRateControlPointWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, HeartRateControlPointAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEART_RATE_SERVICE.equals(serviceUUID) && HEART_RATE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
            mHeartRateServiceCallback.onHeartRateControlPointWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEART_RATE_SERVICE.equals(serviceUUID) && HEART_RATE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
            mHeartRateServiceCallback.onHeartRateControlPointWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEART_RATE_SERVICE.equals(serviceUUID) && HEART_RATE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            mHeartRateServiceCallback.onHeartRateMeasurementClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEART_RATE_SERVICE.equals(serviceUUID) && HEART_RATE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            mHeartRateServiceCallback.onHeartRateMeasurementClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEART_RATE_SERVICE.equals(serviceUUID) && HEART_RATE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            mHeartRateServiceCallback.onHeartRateMeasurementClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEART_RATE_SERVICE.equals(serviceUUID) && HEART_RATE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                mHeartRateServiceCallback.onHeartRateMeasurementNotificateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
            } else {
                mHeartRateServiceCallback.onHeartRateMeasurementNotificateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
            }
        }
        super.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEART_RATE_SERVICE.equals(serviceUUID) && HEART_RATE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                mHeartRateServiceCallback.onHeartRateMeasurementNotificateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else {
                mHeartRateServiceCallback.onHeartRateMeasurementNotificateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEART_RATE_SERVICE.equals(serviceUUID) && HEART_RATE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                mHeartRateServiceCallback.onHeartRateMeasurementNotificateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else {
                mHeartRateServiceCallback.onHeartRateMeasurementNotificateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEART_RATE_SERVICE.equals(serviceUUID) && HEART_RATE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
            mHeartRateServiceCallback.onHeartRateMeasurementNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, HeartRateMeasurementAndroid.CREATOR.createFromByteArray(values));
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * check Body Sensor Location characteristic flag
     *
     * @return {@code true}:Body Sensor Location characteristic is exist, {@code false}:Body Sensor Location characteristic is not exist or service not ready
     */
    public boolean isBodySensorLocationCharacteristicSupporeted() {
        return mIsBodySensorLocationCharacteristicSupporeted;
    }

    /**
     * check Heart Rate Control Point characteristic
     *
     * @return {@code true}:Heart Rate Control Point characteristic is exist, {@code false}:Heart Rate Control Point characteristic is not exist or service not ready
     */
    public boolean isHeartRateControlPointCharacteristicSupporeted() {
        return mIsHeartRateControlPointCharacteristicSupporeted;
    }

    /**
     * get Heart Rate Measurement's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HeartRateServiceCallback#onHeartRateMeasurementClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see HeartRateServiceCallback#onHeartRateMeasurementClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HeartRateServiceCallback#onHeartRateMeasurementClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer getHeartRateMeasurementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadDescriptorTask(HEART_RATE_SERVICE, null, HEART_RATE_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Heart Rate Measurement notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HeartRateServiceCallback#onHeartRateMeasurementNotificateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see HeartRateServiceCallback#onHeartRateMeasurementNotificateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HeartRateServiceCallback#onHeartRateMeasurementNotificateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startHeartRateMeasurementNotification() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(HEART_RATE_SERVICE, null, HEART_RATE_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Heart Rate Measurement notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HeartRateServiceCallback#onHeartRateMeasurementNotificateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see HeartRateServiceCallback#onHeartRateMeasurementNotificateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HeartRateServiceCallback#onHeartRateMeasurementNotificateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopHeartRateMeasurementNotification() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(HEART_RATE_SERVICE, null, HEART_RATE_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Body Sensor Location
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HeartRateServiceCallback#onBodySensorLocationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, BodySensorLocationAndroid, Bundle)
     * @see HeartRateServiceCallback#onBodySensorLocationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HeartRateServiceCallback#onBodySensorLocationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer getBodySensorLocation() {
        Integer taskId = null;
        if (isStarted() && isBodySensorLocationCharacteristicSupporeted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(HEART_RATE_SERVICE, null, BODY_SENSOR_LOCATION_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Heart Rate Control Point
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HeartRateServiceCallback#onHeartRateControlPointWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, HeartRateControlPointAndroid, Bundle)
     * @see HeartRateServiceCallback#onHeartRateControlPointWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HeartRateServiceCallback#onHeartRateControlPointWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer setHeartRateControlPoint(@NonNull HeartRateControlPoint heartRateControlPoint) {
        Integer taskId = null;
        if (isStarted() && isHeartRateControlPointCharacteristicSupporeted()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(HEART_RATE_SERVICE, null, HEART_RATE_CONTROL_POINT_CHARACTERISTIC, null, heartRateControlPoint, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

}
