package org.im97mori.ble.service.cps.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a5d.SensorLocationAndroid;
import org.im97mori.ble.characteristic.u2a63.CyclingPowerMeasurementAndroid;
import org.im97mori.ble.characteristic.u2a64.CyclingPowerVectorAndroid;
import org.im97mori.ble.characteristic.u2a65.CyclingPowerFeatureAndroid;
import org.im97mori.ble.characteristic.u2a66.CyclingPowerControlPoint;
import org.im97mori.ble.characteristic.u2a66.CyclingPowerControlPointAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CYCLING_POWER_VECTOR_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.CYCLING_POWER_SERVICE;

/**
 * Cycling Power Service (Service UUID: 0x1805) for Central
 */
public class CyclingPowerService extends AbstractCentralService {

    /**
     * {@link CyclingPowerServiceCallback} instance
     */
    private final CyclingPowerServiceCallback mCyclingPowerServiceCallback;

    /**
     * Cycling Power Control Point characteristic flag
     * {@code true}:Cycling Power Control Point characteristic is exist, {@code false}:Cycling Power Control Point characteristic is not exist or service not ready
     */
    private boolean mIsCyclingPowerControlPointCharacteristicSupporeted;

    /**
     * Cycling Power Vector characteristic flag
     * {@code true}:Cycling Power Vector characteristic is exist, {@code false}:Cycling Power Vector characteristic is not exist or service not ready
     */
    private boolean mIsCyclingPowerVectorCharacteristicSupporeted;

    /**
     * @param bleConnection               {@link BLEConnection} instance
     * @param cyclingPowerServiceCallback {@link CyclingPowerServiceCallback} instance
     * @param bleCallback                 {@link BLECallback} instance(optional)
     */
    public CyclingPowerService(@NonNull BLEConnection bleConnection, @NonNull CyclingPowerServiceCallback cyclingPowerServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mCyclingPowerServiceCallback = cyclingPowerServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mIsCyclingPowerControlPointCharacteristicSupporeted = false;
            mIsCyclingPowerVectorCharacteristicSupporeted = false;
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
                if (CYCLING_POWER_SERVICE.equals(bluetoothGattService.getUuid())) {
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && (BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE) == bluetoothGattCharacteristic.getProperties()
                            && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsCyclingPowerControlPointCharacteristicSupporeted = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CYCLING_POWER_VECTOR_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_NOTIFY == bluetoothGattCharacteristic.getProperties()
                            && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsCyclingPowerVectorCharacteristicSupporeted = true;
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CYCLING_POWER_SERVICE.equals(serviceUUID)) {
            if (CYCLING_POWER_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onCyclingPowerFeatureReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, CyclingPowerFeatureAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (SENSOR_LOCATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onSensorLocationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, SensorLocationAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CYCLING_POWER_SERVICE.equals(serviceUUID)) {
            if (CYCLING_POWER_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onCyclingPowerFeatureReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (SENSOR_LOCATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onSensorLocationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CYCLING_POWER_SERVICE.equals(serviceUUID)) {
            if (CYCLING_POWER_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onCyclingPowerFeatureReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (SENSOR_LOCATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onSensorLocationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CYCLING_POWER_SERVICE.equals(serviceUUID)) {
            if (CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onCyclingPowerControlPointWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CYCLING_POWER_SERVICE.equals(serviceUUID)) {
            if (CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onCyclingPowerControlPointWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CYCLING_POWER_SERVICE.equals(serviceUUID)) {
            if (CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onCyclingPowerControlPointWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CYCLING_POWER_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (CYCLING_POWER_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onCyclingPowerMeasurementClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onCyclingPowerControlPointClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (CYCLING_POWER_VECTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onCyclingPowerVectorClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CYCLING_POWER_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (CYCLING_POWER_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onCyclingPowerMeasurementClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onCyclingPowerControlPointClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (CYCLING_POWER_VECTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onCyclingPowerVectorClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CYCLING_POWER_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (CYCLING_POWER_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onCyclingPowerMeasurementClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onCyclingPowerControlPointClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (CYCLING_POWER_VECTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                mCyclingPowerServiceCallback.onCyclingPowerVectorClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CYCLING_POWER_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (CYCLING_POWER_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mCyclingPowerServiceCallback.onCyclingPowerMeasurementNotificateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                } else {
                    mCyclingPowerServiceCallback.onCyclingPowerMeasurementNotificateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                }
            } else if (CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mCyclingPowerServiceCallback.onCyclingPowerControlPointIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                } else {
                    mCyclingPowerServiceCallback.onCyclingPowerControlPointIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                }
            } else if (CYCLING_POWER_VECTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mCyclingPowerServiceCallback.onCyclingPowerVectorNotificateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                } else {
                    mCyclingPowerServiceCallback.onCyclingPowerVectorNotificateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CYCLING_POWER_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (CYCLING_POWER_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mCyclingPowerServiceCallback.onCyclingPowerMeasurementNotificateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                } else {
                    mCyclingPowerServiceCallback.onCyclingPowerMeasurementNotificateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                }
            } else if (CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mCyclingPowerServiceCallback.onCyclingPowerControlPointIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                } else {
                    mCyclingPowerServiceCallback.onCyclingPowerControlPointIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                }
            } else if (CYCLING_POWER_VECTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mCyclingPowerServiceCallback.onCyclingPowerVectorNotificateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                } else {
                    mCyclingPowerServiceCallback.onCyclingPowerVectorNotificateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CYCLING_POWER_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (CYCLING_POWER_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mCyclingPowerServiceCallback.onCyclingPowerMeasurementNotificateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                } else {
                    mCyclingPowerServiceCallback.onCyclingPowerMeasurementNotificateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                }
            } else if (CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mCyclingPowerServiceCallback.onCyclingPowerControlPointIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                } else {
                    mCyclingPowerServiceCallback.onCyclingPowerControlPointIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                }
            } else if (CYCLING_POWER_VECTOR_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mCyclingPowerServiceCallback.onCyclingPowerVectorNotificateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                } else {
                    mCyclingPowerServiceCallback.onCyclingPowerVectorNotificateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
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
        if (CYCLING_POWER_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
            mCyclingPowerServiceCallback.onCyclingPowerMeasurementNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, CyclingPowerMeasurementAndroid.CREATOR.createFromByteArray(values));
        } else if (CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
            mCyclingPowerServiceCallback.onCyclingPowerControlPointIndicated(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, CyclingPowerControlPointAndroid.CREATOR.createFromByteArray(values));
        } else if (CYCLING_POWER_VECTOR_CHARACTERISTIC.equals(characteristicUUID)) {
            mCyclingPowerServiceCallback.onCyclingPowerVectorNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, CyclingPowerVectorAndroid.CREATOR.createFromByteArray(values));
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * check Cycling Power Control Point characteristic
     *
     * @return {@code true}:Cycling Power Control Point characteristic is exist, {@code false}:Cycling Power Control Point characteristic is not exist or service not ready
     */
    public boolean isCyclingPowerControlPointCharacteristicSupporeted() {
        return mIsCyclingPowerControlPointCharacteristicSupporeted;
    }

    /**
     * check Cycling Power Vector characteristic
     *
     * @return {@code true}:Cycling Power Vector characteristic is exist, {@code false}:Cycling Power Vector characteristic is not exist or service not ready
     */
    public boolean isCyclingPowerVectorCharacteristicSupporeted() {
        return mIsCyclingPowerVectorCharacteristicSupporeted;
    }

    /**
     * get Cycling Power Feature
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CyclingPowerServiceCallback#onCyclingPowerFeatureReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, CyclingPowerFeatureAndroid, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerFeatureReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerFeatureReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getCyclingPowerFeature() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(CYCLING_POWER_SERVICE, null, CYCLING_POWER_FEATURE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Cycling Power Measurement's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CyclingPowerServiceCallback#onCyclingPowerMeasurementClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerMeasurementClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerMeasurementClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getCyclingPowerMeasurementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadDescriptorTask(CYCLING_POWER_SERVICE, null, CYCLING_POWER_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Cycling Power Measurement notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CyclingPowerServiceCallback#onCyclingPowerMeasurementNotificateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerMeasurementNotificateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerMeasurementNotificateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startCyclingPowerMeasurementNotification() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(CYCLING_POWER_SERVICE, null, CYCLING_POWER_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Cycling Power Measurement notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CyclingPowerServiceCallback#onCyclingPowerMeasurementNotificateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerMeasurementNotificateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerMeasurementNotificateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopCyclingPowerMeasurementNotification() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(CYCLING_POWER_SERVICE, null, CYCLING_POWER_MEASUREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Sensor Location
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CyclingPowerServiceCallback#onSensorLocationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, SensorLocationAndroid, Bundle)
     * @see CyclingPowerServiceCallback#onSensorLocationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see CyclingPowerServiceCallback#onSensorLocationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSensorLocation() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(CYCLING_POWER_SERVICE, null, SENSOR_LOCATION_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Cycling Power Control Point
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CyclingPowerServiceCallback#onCyclingPowerControlPointWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, CyclingPowerControlPointAndroid, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerControlPointWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerControlPointWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setCyclingPowerControlPoint(@NonNull CyclingPowerControlPoint cyclingPowerControlPoint) {
        Integer taskId = null;
        if (isStarted() && isCyclingPowerControlPointCharacteristicSupporeted()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(CYCLING_POWER_SERVICE, null, CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, null, cyclingPowerControlPoint, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Cycling Power Control Point's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CyclingPowerServiceCallback#onCyclingPowerControlPointClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerControlPointClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerControlPointClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getCyclingPowerControlPointClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isCyclingPowerControlPointCharacteristicSupporeted()) {
            taskId = mBLEConnection.createReadDescriptorTask(CYCLING_POWER_SERVICE, null, CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Cycling Power Control Point indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CyclingPowerServiceCallback#onCyclingPowerControlPointIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerControlPointIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerControlPointIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startCyclingPowerControlPointIndication() {
        Integer taskId = null;
        if (isStarted() && isCyclingPowerControlPointCharacteristicSupporeted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(CYCLING_POWER_SERVICE, null, CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Cycling Power Control Point indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CyclingPowerServiceCallback#onCyclingPowerControlPointIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerControlPointIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerControlPointIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopCyclingPowerControlPointIndication() {
        Integer taskId = null;
        if (isStarted() && isCyclingPowerControlPointCharacteristicSupporeted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(CYCLING_POWER_SERVICE, null, CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Cycling Power Vector's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CyclingPowerServiceCallback#onCyclingPowerVectorClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerVectorClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerVectorClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getCyclingPowerVectorClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isCyclingPowerVectorCharacteristicSupporeted()) {
            taskId = mBLEConnection.createReadDescriptorTask(CYCLING_POWER_SERVICE, null, CYCLING_POWER_VECTOR_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Cycling Power Vector notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CyclingPowerServiceCallback#onCyclingPowerVectorNotificateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerVectorNotificateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerVectorNotificateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startCyclingPowerVectorNotification() {
        Integer taskId = null;
        if (isStarted() && isCyclingPowerVectorCharacteristicSupporeted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(CYCLING_POWER_SERVICE, null, CYCLING_POWER_VECTOR_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Cycling Power Vector notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CyclingPowerServiceCallback#onCyclingPowerVectorNotificateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerVectorNotificateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     * @see CyclingPowerServiceCallback#onCyclingPowerVectorNotificateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopCyclingPowerVectorNotification() {
        Integer taskId = null;
        if (isStarted() && isCyclingPowerVectorCharacteristicSupporeted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(CYCLING_POWER_SERVICE, null, CYCLING_POWER_VECTOR_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

}
