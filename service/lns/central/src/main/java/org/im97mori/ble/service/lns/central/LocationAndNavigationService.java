package org.im97mori.ble.service.lns.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a67.LocationAndSpeedAndroid;
import org.im97mori.ble.characteristic.u2a68.NavigationAndroid;
import org.im97mori.ble.characteristic.u2a69.PositionQualityAndroid;
import org.im97mori.ble.characteristic.u2a6a.LNFeatureAndroid;
import org.im97mori.ble.characteristic.u2a6b.LNControlPoint;
import org.im97mori.ble.characteristic.u2a6b.LNControlPointAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LN_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LN_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LOCATION_AND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.NAVIGATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.POSITION_QUALITY_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.LOCATION_AND_NAVIGATION_SERVICE;

/**
 * Location and Navigation Service (Service UUID: 0x1810) for Central
 */
public class LocationAndNavigationService extends AbstractCentralService {

    /**
     * {@link LocationAndNavigationServiceCallback} instance
     */
    private final LocationAndNavigationServiceCallback mLocationAndNavigationServiceCallback;

    /**
     * Position Quality characteristic flag
     * {@code true}:Position Quality characteristic is exist, {@code false}:Position Quality characteristic is not exist or service not ready
     */
    private boolean mIsPositionQualityCharacteristicSupporeted;

    /**
     * LN Control Point characteristic flag
     * {@code true}:LN Control Point characteristic is exist, {@code false}:LN Control Point characteristic is not exist or service not ready
     */
    private boolean mIsLNControlPointCharacteristicSupporeted;

    /**
     * Navigation characteristic flag
     * {@code true}:Navigation characteristic is exist, {@code false}:Navigation characteristic is not exist or service not ready
     */
    private boolean mIsNavigationCharacteristicSupporeted;

    /**
     * @param bleConnection                        {@link BLEConnection} instance
     * @param locationAndNavigationServiceCallback {@link LocationAndNavigationServiceCallback} instance
     * @param bleCallback                          {@link BLECallback} instance(optional)
     */
    public LocationAndNavigationService(@NonNull BLEConnection bleConnection, @NonNull LocationAndNavigationServiceCallback locationAndNavigationServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mLocationAndNavigationServiceCallback = locationAndNavigationServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mIsPositionQualityCharacteristicSupporeted = false;
            mIsLNControlPointCharacteristicSupporeted = false;
            mIsNavigationCharacteristicSupporeted = false;
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
                if (LOCATION_AND_NAVIGATION_SERVICE.equals(bluetoothGattService.getUuid())) {
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POSITION_QUALITY_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && BluetoothGattCharacteristic.PROPERTY_READ == bluetoothGattCharacteristic.getProperties()) {
                        mIsPositionQualityCharacteristicSupporeted = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LN_CONTROL_POINT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && BluetoothGattCharacteristic.PROPERTY_INDICATE == bluetoothGattCharacteristic.getProperties()) {
                        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
                        if (bluetoothGattDescriptor != null) {
                            mIsLNControlPointCharacteristicSupporeted = true;
                        }
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NAVIGATION_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && BluetoothGattCharacteristic.PROPERTY_NOTIFY == bluetoothGattCharacteristic.getProperties()) {
                        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
                        if (bluetoothGattDescriptor != null) {
                            mIsNavigationCharacteristicSupporeted = true;
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LOCATION_AND_NAVIGATION_SERVICE.equals(serviceUUID)) {
            if (LN_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onLNFeatureReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, LNFeatureAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (POSITION_QUALITY_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onPositionQualityReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, PositionQualityAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LOCATION_AND_NAVIGATION_SERVICE.equals(serviceUUID)) {
            if (LN_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onLNFeatureReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (POSITION_QUALITY_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onPositionQualityReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LOCATION_AND_NAVIGATION_SERVICE.equals(serviceUUID)) {
            if (LN_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onLNFeatureReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (POSITION_QUALITY_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onPositionQualityReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LOCATION_AND_NAVIGATION_SERVICE.equals(serviceUUID) && LN_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
            mLocationAndNavigationServiceCallback.onLNControlPointWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, LNControlPointAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LOCATION_AND_NAVIGATION_SERVICE.equals(serviceUUID) && LN_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
            mLocationAndNavigationServiceCallback.onLNControlPointWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LOCATION_AND_NAVIGATION_SERVICE.equals(serviceUUID) && LN_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
            mLocationAndNavigationServiceCallback.onLNControlPointWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LOCATION_AND_NAVIGATION_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (LOCATION_AND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onLocationAndSpeedClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (LN_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onLNControlPointClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (NAVIGATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onNavigationClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LOCATION_AND_NAVIGATION_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (LOCATION_AND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onLocationAndSpeedClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (LN_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onLNControlPointClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (NAVIGATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onNavigationClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LOCATION_AND_NAVIGATION_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (LOCATION_AND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onLocationAndSpeedClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (LN_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onLNControlPointClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (NAVIGATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onNavigationClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LOCATION_AND_NAVIGATION_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (LOCATION_AND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mLocationAndNavigationServiceCallback.onLocationAndSpeedNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                } else {
                    mLocationAndNavigationServiceCallback.onLocationAndSpeedNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                }
            } else if (LN_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mLocationAndNavigationServiceCallback.onLNControlPointIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                } else {
                    mLocationAndNavigationServiceCallback.onLNControlPointIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                }
            } else if (NAVIGATION_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mLocationAndNavigationServiceCallback.onNavigationNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
                } else {
                    mLocationAndNavigationServiceCallback.onNavigationNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, argument);
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LOCATION_AND_NAVIGATION_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (LOCATION_AND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mLocationAndNavigationServiceCallback.onLocationAndSpeedNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                } else {
                    mLocationAndNavigationServiceCallback.onLocationAndSpeedNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                }
            } else if (LN_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mLocationAndNavigationServiceCallback.onLNControlPointIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                } else {
                    mLocationAndNavigationServiceCallback.onLNControlPointIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                }
            } else if (NAVIGATION_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mLocationAndNavigationServiceCallback.onNavigationNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
                } else {
                    mLocationAndNavigationServiceCallback.onNavigationNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LOCATION_AND_NAVIGATION_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (LOCATION_AND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mLocationAndNavigationServiceCallback.onLocationAndSpeedNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                } else {
                    mLocationAndNavigationServiceCallback.onLocationAndSpeedNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                }
            } else if (LN_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mLocationAndNavigationServiceCallback.onLNControlPointIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                } else {
                    mLocationAndNavigationServiceCallback.onLNControlPointIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                }
            } else if (NAVIGATION_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mLocationAndNavigationServiceCallback.onNavigationNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
                } else {
                    mLocationAndNavigationServiceCallback.onNavigationNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LOCATION_AND_NAVIGATION_SERVICE.equals(serviceUUID)) {
            if (LOCATION_AND_SPEED_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onLocationAndSpeedNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, LocationAndSpeedAndroid.CREATOR.createFromByteArray(values));
            } else if (LN_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onLNControlPointIndicated(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, LNControlPointAndroid.CREATOR.createFromByteArray(values));
            } else if (NAVIGATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mLocationAndNavigationServiceCallback.onNavigationNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, NavigationAndroid.CREATOR.createFromByteArray(values));
            }
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * check Position Quality characteristic
     *
     * @return {@code true}:Position Quality characteristic is exist, {@code false}:Position Quality characteristic is not exist or service not ready
     */
    public boolean isPositionQualityCharacteristicSupporeted() {
        return mIsPositionQualityCharacteristicSupporeted;
    }

    /**
     * check LN Control Point characteristic
     *
     * @return {@code true}:LN Control Point characteristic is exist, {@code false}:LN Control Point characteristic is not exist or service not ready
     */
    public boolean isLNControlPointCharacteristicSupporeted() {
        return mIsLNControlPointCharacteristicSupporeted;
    }

    /**
     * check Navigation characteristic
     *
     * @return {@code true}:Navigation characteristic is exist, {@code false}:Navigation characteristic is not exist or service not ready
     */
    public boolean isNavigationCharacteristicSupporeted() {
        return mIsNavigationCharacteristicSupporeted;
    }

    /**
     * get LN Feature Feature
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see LocationAndNavigationServiceCallback#onLNFeatureReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, LNFeatureAndroid, Bundle)
     * @see LocationAndNavigationServiceCallback#onLNFeatureReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see LocationAndNavigationServiceCallback#onLNFeatureReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer getLNFeature() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(LOCATION_AND_NAVIGATION_SERVICE, null, LN_FEATURE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Location and Speed's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see LocationAndNavigationServiceCallback#onLocationAndSpeedClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see LocationAndNavigationServiceCallback#onLocationAndSpeedClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see LocationAndNavigationServiceCallback#onLocationAndSpeedClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer getLocationAndSpeedClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadDescriptorTask(LOCATION_AND_NAVIGATION_SERVICE, null, LOCATION_AND_SPEED_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Location and Speed notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see LocationAndNavigationServiceCallback#onLocationAndSpeedNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see LocationAndNavigationServiceCallback#onLocationAndSpeedNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see LocationAndNavigationServiceCallback#onLocationAndSpeedNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startLocationAndSpeedNotification() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(LOCATION_AND_NAVIGATION_SERVICE, null, LOCATION_AND_SPEED_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Location and Speed notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see LocationAndNavigationServiceCallback#onLocationAndSpeedNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see LocationAndNavigationServiceCallback#onLocationAndSpeedNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see LocationAndNavigationServiceCallback#onLocationAndSpeedNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopLocationAndSpeedNotification() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(LOCATION_AND_NAVIGATION_SERVICE, null, LOCATION_AND_SPEED_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Position Quality
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see LocationAndNavigationServiceCallback#onPositionQualityReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, PositionQualityAndroid, Bundle)
     * @see LocationAndNavigationServiceCallback#onPositionQualityReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see LocationAndNavigationServiceCallback#onPositionQualityReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer getPositionQuality() {
        Integer taskId = null;
        if (isStarted() && isPositionQualityCharacteristicSupporeted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(LOCATION_AND_NAVIGATION_SERVICE, null, POSITION_QUALITY_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set LN Control Point
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see LocationAndNavigationServiceCallback#onLNControlPointWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, LNControlPointAndroid, Bundle)
     * @see LocationAndNavigationServiceCallback#onLNControlPointWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see LocationAndNavigationServiceCallback#onLNControlPointWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer setLNControlPoint(@NonNull LNControlPoint lnControlPoint) {
        Integer taskId = null;
        if (isStarted() && isLNControlPointCharacteristicSupporeted()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(LOCATION_AND_NAVIGATION_SERVICE, null, LN_CONTROL_POINT_CHARACTERISTIC, null, lnControlPoint, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get LN Control Point's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see LocationAndNavigationServiceCallback#onLNControlPointClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see LocationAndNavigationServiceCallback#onLNControlPointClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see LocationAndNavigationServiceCallback#onLNControlPointClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer getLNControlPointClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadDescriptorTask(LOCATION_AND_NAVIGATION_SERVICE, null, LN_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start LN Control Point indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see LocationAndNavigationServiceCallback#onLNControlPointIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see LocationAndNavigationServiceCallback#onLNControlPointIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see LocationAndNavigationServiceCallback#onLNControlPointIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startLNControlPointIndication() {
        Integer taskId = null;
        if (isStarted() && isLNControlPointCharacteristicSupporeted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(LOCATION_AND_NAVIGATION_SERVICE, null, LN_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop LN Control Point indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see LocationAndNavigationServiceCallback#onLNControlPointIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see LocationAndNavigationServiceCallback#onLNControlPointIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see LocationAndNavigationServiceCallback#onLNControlPointIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopLNControlPointIndication() {
        Integer taskId = null;
        if (isStarted() && isLNControlPointCharacteristicSupporeted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(LOCATION_AND_NAVIGATION_SERVICE, null, LN_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * start Navigation notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see LocationAndNavigationServiceCallback#onNavigationNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see LocationAndNavigationServiceCallback#onNavigationNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see LocationAndNavigationServiceCallback#onNavigationNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startNavigationNotification() {
        Integer taskId = null;
        if (isStarted() && isNavigationCharacteristicSupporeted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(LOCATION_AND_NAVIGATION_SERVICE, null, NAVIGATION_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Navigation notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see LocationAndNavigationServiceCallback#onNavigationNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Bundle)
     * @see LocationAndNavigationServiceCallback#onNavigationNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see LocationAndNavigationServiceCallback#onNavigationNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopNavigationNotification() {
        Integer taskId = null;
        if (isStarted() && isNavigationCharacteristicSupporeted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(LOCATION_AND_NAVIGATION_SERVICE, null, NAVIGATION_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

}
