package org.im97mori.ble.service.hts.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a1c.TemperatureMeasurementAndroid;
import org.im97mori.ble.characteristic.u2a1d.TemperatureTypeAndroid;
import org.im97mori.ble.characteristic.u2a1e.IntermediateTemperatureAndroid;
import org.im97mori.ble.characteristic.u2a21.MeasurementInterval;
import org.im97mori.ble.characteristic.u2a21.MeasurementIntervalAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.descriptor.u2906.ValidRangeAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.INTERMEDIATE_TEMPERATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MEASUREMENT_INTERVAL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TEMPERATURE_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TEMPERATURE_TYPE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.HEALTH_THERMOMETER_SERVICE;

/**
 * Health Thermometer Service (Service UUID: 0x1809) for Central
 */
public class HealthThermometerService extends AbstractCentralService {

    /**
     * {@link HealthThermometerServiceCallback} instance
     */
    private final HealthThermometerServiceCallback mHealthThermometerServiceCallback;

    /**
     * Temperature Type characteristic flag
     * {@code true}:Temperature Type characteristic is exist, {@code false}:Temperature Type characteristic is not exist or service not ready
     */
    private boolean mIsTemperatureTypeCharacteristicSupporeted;

    /**
     * Intermediate Temperature characteristic flag
     * {@code true}:Intermediate Temperature characteristic is exist, {@code false}:Intermediate Temperature characteristic is not exist or service not ready
     */
    private boolean mIsIntermediateTemperatureCharacteristicSupporeted;

    /**
     * Measurement Interval characteristic flag
     * {@code true}:Measurement Interval characteristic is exist, {@code false}:Measurement Interval characteristic is not exist or service not ready
     */
    private boolean mIsMeasurementIntervalCharacteristicSupporeted;

    /**
     * Measurement Interval characteristic indicatable flag
     * {@code true}:Measurement Interval characteristic is indicatable, {@code false}:Measurement Interval characteristic is not indicatable or service not ready
     */
    private boolean mIsMeasurementIntervalCharacteristicIndicateSupporeted;

    /**
     * Measurement Interval characteristic writable flag
     * {@code true}:Measurement Interval characteristic is writable, {@code false}:Measurement Interval characteristic is not writable or service not ready
     */
    private boolean mIsMeasurementIntervalCharacteristicWriteSupporeted;

    /**
     * @param bleConnection                    {@link BLEConnection} instance
     * @param healthThermometerServiceCallback {@link HealthThermometerServiceCallback} instance
     * @param bleCallback                      {@link BLECallback} instance(optional)
     */
    public HealthThermometerService(@NonNull BLEConnection bleConnection, @NonNull HealthThermometerServiceCallback healthThermometerServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mHealthThermometerServiceCallback = healthThermometerServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mIsTemperatureTypeCharacteristicSupporeted = false;
            mIsIntermediateTemperatureCharacteristicSupporeted = false;
            mIsMeasurementIntervalCharacteristicSupporeted = false;
            mIsMeasurementIntervalCharacteristicIndicateSupporeted = false;
            mIsMeasurementIntervalCharacteristicWriteSupporeted = false;
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
                if (HEALTH_THERMOMETER_SERVICE.equals(bluetoothGattService.getUuid())) {
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TEMPERATURE_TYPE_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                        mIsTemperatureTypeCharacteristicSupporeted = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(INTERMEDIATE_TEMPERATURE_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && (BluetoothGattCharacteristic.PROPERTY_NOTIFY & bluetoothGattCharacteristic.getProperties()) != 0) {
                        mIsIntermediateTemperatureCharacteristicSupporeted = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MEASUREMENT_INTERVAL_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                        mIsMeasurementIntervalCharacteristicSupporeted = true;
                        if ((BluetoothGattCharacteristic.PROPERTY_INDICATE & bluetoothGattCharacteristic.getProperties()) != 0 && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                            mIsMeasurementIntervalCharacteristicIndicateSupporeted = true;
                        }
                        if ((BluetoothGattCharacteristic.PROPERTY_WRITE & bluetoothGattCharacteristic.getProperties()) != 0 && bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR) != null) {
                            mIsMeasurementIntervalCharacteristicWriteSupporeted = true;
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
    public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEALTH_THERMOMETER_SERVICE.equals(serviceUUID)) {
            if (TEMPERATURE_TYPE_CHARACTERISTIC.equals(characteristicUUID)) {
                mHealthThermometerServiceCallback.onTemperatureTypeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, TemperatureTypeAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID)) {
                mHealthThermometerServiceCallback.onMeasurementIntervalReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, MeasurementIntervalAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEALTH_THERMOMETER_SERVICE.equals(serviceUUID)) {
            if (TEMPERATURE_TYPE_CHARACTERISTIC.equals(characteristicUUID)) {
                mHealthThermometerServiceCallback.onTemperatureTypeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID)) {
                mHealthThermometerServiceCallback.onMeasurementIntervalReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEALTH_THERMOMETER_SERVICE.equals(serviceUUID)) {
            if (TEMPERATURE_TYPE_CHARACTERISTIC.equals(characteristicUUID)) {
                mHealthThermometerServiceCallback.onTemperatureTypeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID)) {
                mHealthThermometerServiceCallback.onMeasurementIntervalReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEALTH_THERMOMETER_SERVICE.equals(serviceUUID) && MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID)) {
            mHealthThermometerServiceCallback.onMeasurementIntervalWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, MeasurementIntervalAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEALTH_THERMOMETER_SERVICE.equals(serviceUUID) && MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID)) {
            mHealthThermometerServiceCallback.onMeasurementIntervalWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEALTH_THERMOMETER_SERVICE.equals(serviceUUID) && MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID)) {
            mHealthThermometerServiceCallback.onMeasurementIntervalWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEALTH_THERMOMETER_SERVICE.equals(serviceUUID)) {
            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                if (TEMPERATURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                    mHealthThermometerServiceCallback.onTemperatureMeasurementClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (INTERMEDIATE_TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                    mHealthThermometerServiceCallback.onIntermediateTemperatureClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                } else if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID)) {
                    mHealthThermometerServiceCallback.onMeasurementIntervalClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
                }
            } else if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID) && VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                mHealthThermometerServiceCallback.onMeasurementIntervalValidRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ValidRangeAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEALTH_THERMOMETER_SERVICE.equals(serviceUUID)) {
            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                if (TEMPERATURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                    mHealthThermometerServiceCallback.onTemperatureMeasurementClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                } else if (INTERMEDIATE_TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                    mHealthThermometerServiceCallback.onIntermediateTemperatureClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                } else if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID)) {
                    mHealthThermometerServiceCallback.onMeasurementIntervalClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                }
            } else if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID) && VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                mHealthThermometerServiceCallback.onMeasurementIntervalValidRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEALTH_THERMOMETER_SERVICE.equals(serviceUUID)) {
            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                if (TEMPERATURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                    mHealthThermometerServiceCallback.onTemperatureMeasurementClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                } else if (INTERMEDIATE_TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                    mHealthThermometerServiceCallback.onIntermediateTemperatureClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                } else if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID)) {
                    mHealthThermometerServiceCallback.onMeasurementIntervalClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                }
            } else if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID) && VALID_RANGE_DESCRIPTOR.equals(descriptorUUID)) {
                mHealthThermometerServiceCallback.onMeasurementIntervalValidRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEALTH_THERMOMETER_SERVICE.equals(serviceUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    if (TEMPERATURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onTemperatureMeasurementIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                    } else if (INTERMEDIATE_TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onIntermediateTemperatureNotificateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                    } else if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onMeasurementIntervalIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                    }
                } else {
                    if (TEMPERATURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onTemperatureMeasurementIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                    } else if (INTERMEDIATE_TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onIntermediateTemperatureNotificateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                    } else if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onMeasurementIntervalIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                    }
                }
            }
        }
        super.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEALTH_THERMOMETER_SERVICE.equals(serviceUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    if (TEMPERATURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onTemperatureMeasurementIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                    } else if (INTERMEDIATE_TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onIntermediateTemperatureNotificateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                    } else if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onMeasurementIntervalIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                    }
                } else {
                    if (TEMPERATURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onTemperatureMeasurementIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                    } else if (INTERMEDIATE_TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onIntermediateTemperatureNotificateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                    } else if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onMeasurementIntervalIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                    }
                }
            }
        }
        super.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEALTH_THERMOMETER_SERVICE.equals(serviceUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    if (TEMPERATURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onTemperatureMeasurementIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                    } else if (INTERMEDIATE_TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onIntermediateTemperatureNotificateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                    } else if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onMeasurementIntervalIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                    }
                } else {
                    if (TEMPERATURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onTemperatureMeasurementIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                    } else if (INTERMEDIATE_TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onIntermediateTemperatureNotificateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                    } else if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID)) {
                        mHealthThermometerServiceCallback.onMeasurementIntervalIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                    }
                }
            }
        }
        super.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && HEALTH_THERMOMETER_SERVICE.equals(serviceUUID)) {
            if (TEMPERATURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mHealthThermometerServiceCallback.onTemperatureMeasurementIndicated(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, TemperatureMeasurementAndroid.CREATOR.createFromByteArray(values));
            } else if (INTERMEDIATE_TEMPERATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mHealthThermometerServiceCallback.onIntermediateTemperatureNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, IntermediateTemperatureAndroid.CREATOR.createFromByteArray(values));
            } else if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicUUID)) {
                mHealthThermometerServiceCallback.onMeasurementIntervalIndicated(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, MeasurementIntervalAndroid.CREATOR.createFromByteArray(values));
            }
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * Temperature Type characteristic flag
     * <p>
     * {@code true}:Temperature Type characteristic is exist, {@code false}:Temperature Type characteristic is not exist or service not ready
     */
    public boolean isTemperatureTypeCharacteristicSupporeted() {
        return mIsTemperatureTypeCharacteristicSupporeted;
    }

    /**
     * Intermediate Temperature characteristic flag
     * <p>
     * {@code true}:Intermediate Temperature characteristic is exist, {@code false}:Intermediate Temperature characteristic is not exist or service not ready
     */
    public boolean isIntermediateTemperatureCharacteristicSupporeted() {
        return mIsIntermediateTemperatureCharacteristicSupporeted;
    }

    /**
     * Measurement Interval characteristic flag
     * <p>
     * {@code true}:Measurement Interval characteristic is exist, {@code false}:Measurement Interval characteristic is not exist or service not ready
     */
    public boolean isMeasurementIntervalCharacteristicSupporeted() {
        return mIsMeasurementIntervalCharacteristicSupporeted;
    }

    /**
     * Measurement Interval characteristic indicatable flag
     * <p>
     * {@code true}:Measurement Interval characteristic is indicatable, {@code false}:Measurement Interval characteristic is not indicatable or service not ready
     */
    public boolean isMeasurementIntervalCharacteristicIndicateSupporeted() {
        return mIsMeasurementIntervalCharacteristicIndicateSupporeted;
    }

    /**
     * Measurement Interval characteristic writable flag
     * <p>
     * {@code true}:Measurement Interval characteristic is writable, {@code false}:Measurement Interval characteristic is not writable or service not ready
     */
    public boolean isMeasurementIntervalCharacteristicWriteSupporeted() {
        return mIsMeasurementIntervalCharacteristicWriteSupporeted;
    }

    /**
     * get Temperature Measurement's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HealthThermometerServiceCallback#onTemperatureMeasurementClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see HealthThermometerServiceCallback#onTemperatureMeasurementClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HealthThermometerServiceCallback#onTemperatureMeasurementClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer getTemperatureMeasurementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadDescriptorTask(HEALTH_THERMOMETER_SERVICE, null, TEMPERATURE_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Temperature Measurement indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HealthThermometerServiceCallback#onTemperatureMeasurementIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see HealthThermometerServiceCallback#onTemperatureMeasurementIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HealthThermometerServiceCallback#onTemperatureMeasurementIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startTemperatureMeasurementIndication() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(HEALTH_THERMOMETER_SERVICE, null, TEMPERATURE_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Temperature Measurement indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HealthThermometerServiceCallback#onTemperatureMeasurementIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see HealthThermometerServiceCallback#onTemperatureMeasurementIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HealthThermometerServiceCallback#onTemperatureMeasurementIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopHeartRateMeasurementIndication() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(HEALTH_THERMOMETER_SERVICE, null, TEMPERATURE_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Temperature Type
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HealthThermometerServiceCallback#onTemperatureTypeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, TemperatureTypeAndroid, Bundle)
     * @see HealthThermometerServiceCallback#onTemperatureTypeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HealthThermometerServiceCallback#onTemperatureTypeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer getTemperatureType() {
        Integer taskId = null;
        if (isStarted() && isTemperatureTypeCharacteristicSupporeted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(HEALTH_THERMOMETER_SERVICE, null, TEMPERATURE_TYPE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Intermediate Temperature's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HealthThermometerServiceCallback#onIntermediateTemperatureClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see HealthThermometerServiceCallback#onIntermediateTemperatureClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HealthThermometerServiceCallback#onIntermediateTemperatureClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer getIntermediateTemperatureClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isIntermediateTemperatureCharacteristicSupporeted()) {
            taskId = mBLEConnection.createReadDescriptorTask(HEALTH_THERMOMETER_SERVICE, null, INTERMEDIATE_TEMPERATURE_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Intermediate Temperature notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HealthThermometerServiceCallback#onIntermediateTemperatureNotificateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see HealthThermometerServiceCallback#onIntermediateTemperatureNotificateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HealthThermometerServiceCallback#onIntermediateTemperatureNotificateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startIntermediateTemperatureNotification() {
        Integer taskId = null;
        if (isStarted() && isIntermediateTemperatureCharacteristicSupporeted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(HEALTH_THERMOMETER_SERVICE, null, INTERMEDIATE_TEMPERATURE_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Intermediate Temperature notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HealthThermometerServiceCallback#onIntermediateTemperatureNotificateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see HealthThermometerServiceCallback#onIntermediateTemperatureNotificateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HealthThermometerServiceCallback#onIntermediateTemperatureNotificateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopIntermediateTemperaturNotification() {
        Integer taskId = null;
        if (isStarted() && isIntermediateTemperatureCharacteristicSupporeted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(HEALTH_THERMOMETER_SERVICE, null, INTERMEDIATE_TEMPERATURE_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Measurement Interval
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HealthThermometerServiceCallback#onMeasurementIntervalReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, MeasurementIntervalAndroid, Bundle)
     * @see HealthThermometerServiceCallback#onMeasurementIntervalReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HealthThermometerServiceCallback#onMeasurementIntervalWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer getMeasurementInterval() {
        Integer taskId = null;
        if (isStarted() && isMeasurementIntervalCharacteristicSupporeted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(HEALTH_THERMOMETER_SERVICE, null, MEASUREMENT_INTERVAL_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Measurement Interval
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HealthThermometerServiceCallback#onMeasurementIntervalWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, MeasurementIntervalAndroid, Bundle)
     * @see HealthThermometerServiceCallback#onMeasurementIntervalWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HealthThermometerServiceCallback#onMeasurementIntervalWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer setMeasurementInterval(@NonNull MeasurementInterval measurementInterval) {
        Integer taskId = null;
        if (isStarted() && isMeasurementIntervalCharacteristicWriteSupporeted()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(HEALTH_THERMOMETER_SERVICE, null, MEASUREMENT_INTERVAL_CHARACTERISTIC, null, measurementInterval, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Measurement Interval's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HealthThermometerServiceCallback#onMeasurementIntervalClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see HealthThermometerServiceCallback#onMeasurementIntervalClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HealthThermometerServiceCallback#onMeasurementIntervalClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer getMeasurementIntervalClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isMeasurementIntervalCharacteristicIndicateSupporeted()) {
            taskId = mBLEConnection.createReadDescriptorTask(HEALTH_THERMOMETER_SERVICE, null, MEASUREMENT_INTERVAL_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Measurement Interval indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HealthThermometerServiceCallback#onMeasurementIntervalIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see HealthThermometerServiceCallback#onMeasurementIntervalIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HealthThermometerServiceCallback#onMeasurementIntervalIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startMeasurementIntervalInidication() {
        Integer taskId = null;
        if (isStarted() && isMeasurementIntervalCharacteristicIndicateSupporeted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(HEALTH_THERMOMETER_SERVICE, null, MEASUREMENT_INTERVAL_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Measurement Interval indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HealthThermometerServiceCallback#onMeasurementIntervalIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see HealthThermometerServiceCallback#onMeasurementIntervalIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HealthThermometerServiceCallback#onMeasurementIntervalIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopMeasurementIntervalInidication() {
        Integer taskId = null;
        if (isStarted() && isMeasurementIntervalCharacteristicIndicateSupporeted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(HEALTH_THERMOMETER_SERVICE, null, MEASUREMENT_INTERVAL_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Measurement Interval's Valid Range
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see HealthThermometerServiceCallback#onMeasurementIntervalValidRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ValidRangeAndroid, Bundle)
     * @see HealthThermometerServiceCallback#onMeasurementIntervalValidRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see HealthThermometerServiceCallback#onMeasurementIntervalValidRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer getMeasurementIntervalValidRange() {
        Integer taskId = null;
        if (isStarted() && isMeasurementIntervalCharacteristicWriteSupporeted()) {
            taskId = mBLEConnection.createReadDescriptorTask(HEALTH_THERMOMETER_SERVICE, null, MEASUREMENT_INTERVAL_CHARACTERISTIC, null, VALID_RANGE_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

}
