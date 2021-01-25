package org.im97mori.ble.service.rscs.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a53.RSCMeasurementAndroid;
import org.im97mori.ble.characteristic.u2a54.RSCFeatureAndroid;
import org.im97mori.ble.characteristic.u2a55.SCControlPoint;
import org.im97mori.ble.characteristic.u2a55.SCControlPointAndroid;
import org.im97mori.ble.characteristic.u2a5d.SensorLocationAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RSC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RSC_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SC_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.RUNNING_SPEED_AND_CADENCE_SERVICE;

/**
 * Running Speed and Cadence Service (Service UUID: 0x1816) for Central
 */
public class RunningSpeedAndCadenceService extends AbstractCentralService {

    /**
     * {@link RunningSpeedAndCadenceServiceCallback} instance
     */
    private final RunningSpeedAndCadenceServiceCallback mRunningSpeedAndCadenceServiceCallback;

    /**
     * Sensor Location characteristic flag
     * {@code true}:Sensor Location characteristic is exist, {@code false}:Sensor Location characteristic is not exist or service not ready
     */
    private boolean mIsSensorLocationCharacteristicSupporeted;

    /**
     * SC Control Point characteristic flag
     * {@code true}:SC Control Point characteristic is exist, {@code false}:SC Control Point characteristic is not exist or service not ready
     */
    private boolean mIsSCControlPointCharacteristicSupporeted;

    /**
     * @param bleConnection                         {@link BLEConnection} instance
     * @param runningSpeedAndCadenceServiceCallback {@link RunningSpeedAndCadenceServiceCallback} instance
     * @param bleCallback                           {@link BLECallback} instance(optional)
     */
    public RunningSpeedAndCadenceService(@NonNull BLEConnection bleConnection, @NonNull RunningSpeedAndCadenceServiceCallback runningSpeedAndCadenceServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mRunningSpeedAndCadenceServiceCallback = runningSpeedAndCadenceServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mIsSensorLocationCharacteristicSupporeted = false;
            mIsSCControlPointCharacteristicSupporeted = false;
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
                if (RUNNING_SPEED_AND_CADENCE_SERVICE.equals(bluetoothGattService.getUuid())) {
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SENSOR_LOCATION_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_READ == bluetoothGattCharacteristic.getProperties()) {
                        mIsSensorLocationCharacteristicSupporeted = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && (BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE) == bluetoothGattCharacteristic.getProperties()
                            && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsSCControlPointCharacteristicSupporeted = true;
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RUNNING_SPEED_AND_CADENCE_SERVICE.equals(serviceUUID)) {
            if (RSC_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onRSCFeatureReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, RSCFeatureAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (SENSOR_LOCATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onSensorLocationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, SensorLocationAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RUNNING_SPEED_AND_CADENCE_SERVICE.equals(serviceUUID)) {
            if (RSC_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onRSCFeatureReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (SENSOR_LOCATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onSensorLocationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RUNNING_SPEED_AND_CADENCE_SERVICE.equals(serviceUUID)) {
            if (RSC_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onRSCFeatureReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (SENSOR_LOCATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onSensorLocationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RUNNING_SPEED_AND_CADENCE_SERVICE.equals(serviceUUID)) {
            if (SC_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onSCControlPointWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, SCControlPointAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RUNNING_SPEED_AND_CADENCE_SERVICE.equals(serviceUUID)) {
            if (SC_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onSCControlPointWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RUNNING_SPEED_AND_CADENCE_SERVICE.equals(serviceUUID)) {
            if (SC_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onSCControlPointWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RUNNING_SPEED_AND_CADENCE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (RSC_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onRSCMeasurementClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (SC_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onSCControlPointClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RUNNING_SPEED_AND_CADENCE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (RSC_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onRSCMeasurementClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (SC_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onSCControlPointClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RUNNING_SPEED_AND_CADENCE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (RSC_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onRSCMeasurementClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (SC_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onSCControlPointClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RUNNING_SPEED_AND_CADENCE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (RSC_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mRunningSpeedAndCadenceServiceCallback.onRSCMeasurementNotificateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                } else {
                    mRunningSpeedAndCadenceServiceCallback.onRSCMeasurementNotificateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                }
            } else if (SC_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mRunningSpeedAndCadenceServiceCallback.onSCControlPointIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                } else {
                    mRunningSpeedAndCadenceServiceCallback.onSCControlPointIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RUNNING_SPEED_AND_CADENCE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (RSC_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mRunningSpeedAndCadenceServiceCallback.onRSCMeasurementNotificateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                } else {
                    mRunningSpeedAndCadenceServiceCallback.onRSCMeasurementNotificateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                }
            } else if (SC_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mRunningSpeedAndCadenceServiceCallback.onSCControlPointIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                } else {
                    mRunningSpeedAndCadenceServiceCallback.onSCControlPointIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RUNNING_SPEED_AND_CADENCE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (RSC_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mRunningSpeedAndCadenceServiceCallback.onRSCMeasurementNotificateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                } else {
                    mRunningSpeedAndCadenceServiceCallback.onRSCMeasurementNotificateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                }
            } else if (SC_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mRunningSpeedAndCadenceServiceCallback.onSCControlPointIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                } else {
                    mRunningSpeedAndCadenceServiceCallback.onSCControlPointIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RUNNING_SPEED_AND_CADENCE_SERVICE.equals(serviceUUID)) {
            if (RSC_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onRSCMeasurementNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, RSCMeasurementAndroid.CREATOR.createFromByteArray(values));
            } else if (SC_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mRunningSpeedAndCadenceServiceCallback.onSCControlPointIndicated(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, SCControlPointAndroid.CREATOR.createFromByteArray(values));
            }
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * check Sensor Location characteristic
     *
     * @return {@code true}:Sensor Location characteristic is exist, {@code false}:Sensor Location characteristic is not exist or service not ready
     */
    public boolean isSensorLocationCharacteristicSupporeted() {
        return mIsSensorLocationCharacteristicSupporeted;
    }

    /**
     * check SC Control Point characteristic
     *
     * @return {@code true}:SC Control Point characteristic is exist, {@code false}:SC Control Point characteristic is not exist or service not ready
     */
    public boolean isSCControlPointCharacteristicSupporeted() {
        return mIsSCControlPointCharacteristicSupporeted;
    }

    /**
     * get RSC Feature
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see RunningSpeedAndCadenceServiceCallback#onRSCFeatureReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, RSCFeatureAndroid, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onRSCFeatureReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onRSCFeatureReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getRSCFeature() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(RUNNING_SPEED_AND_CADENCE_SERVICE, null, RSC_FEATURE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get RSC Measurement's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see RunningSpeedAndCadenceServiceCallback#onRSCMeasurementClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onRSCMeasurementClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onRSCMeasurementClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getRSCMeasurementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadDescriptorTask(RUNNING_SPEED_AND_CADENCE_SERVICE, null, RSC_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start RSC Measurement notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see RunningSpeedAndCadenceServiceCallback#onRSCMeasurementNotificateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onRSCMeasurementNotificateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onRSCMeasurementNotificateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startRSCMeasurementNotification() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(RUNNING_SPEED_AND_CADENCE_SERVICE, null, RSC_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop RSC Measurement notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see RunningSpeedAndCadenceServiceCallback#onRSCMeasurementNotificateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onRSCMeasurementNotificateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onRSCMeasurementNotificateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopRSCMeasurementNotification() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(RUNNING_SPEED_AND_CADENCE_SERVICE, null, RSC_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Sensor Location
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see RunningSpeedAndCadenceServiceCallback#onSensorLocationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, SensorLocationAndroid, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onSensorLocationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onSensorLocationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSensorLocation() {
        Integer taskId = null;
        if (isStarted() && isSensorLocationCharacteristicSupporeted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(RUNNING_SPEED_AND_CADENCE_SERVICE, null, SENSOR_LOCATION_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set SC Control Point
     *
     * @param scControlPoint {@link SCControlPoint} instance
     * @return task id. if {@code null} returned, service is not ready
     * @see RunningSpeedAndCadenceServiceCallback#onSCControlPointWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, SCControlPointAndroid, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onSCControlPointWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onSCControlPointWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setSCControlPoint(@NonNull SCControlPoint scControlPoint) {
        Integer taskId = null;
        if (isStarted() && isSCControlPointCharacteristicSupporeted()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(RUNNING_SPEED_AND_CADENCE_SERVICE, null, SC_CONTROL_POINT_CHARACTERISTIC, null, scControlPoint, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get SC Control Point's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see RunningSpeedAndCadenceServiceCallback#onSCControlPointClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onSCControlPointClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onSCControlPointClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSCControlPointClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isSCControlPointCharacteristicSupporeted()) {
            taskId = mBLEConnection.createReadDescriptorTask(RUNNING_SPEED_AND_CADENCE_SERVICE, null, SC_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start SC Control Point indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see RunningSpeedAndCadenceServiceCallback#onSCControlPointIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onSCControlPointIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onSCControlPointIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startSCControlPointIndication() {
        Integer taskId = null;
        if (isStarted() && isSCControlPointCharacteristicSupporeted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(RUNNING_SPEED_AND_CADENCE_SERVICE, null, SC_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop SC Control Point indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see RunningSpeedAndCadenceServiceCallback#onSCControlPointIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onSCControlPointIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see RunningSpeedAndCadenceServiceCallback#onSCControlPointIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopSCControlPointIndication() {
        Integer taskId = null;
        if (isStarted() && isSCControlPointCharacteristicSupporeted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(RUNNING_SPEED_AND_CADENCE_SERVICE, null, SC_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

}
