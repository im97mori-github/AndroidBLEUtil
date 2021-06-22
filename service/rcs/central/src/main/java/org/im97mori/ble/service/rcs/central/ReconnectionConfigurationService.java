package org.im97mori.ble.service.rcs.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2b1d.RCFeatureAndroid;
import org.im97mori.ble.characteristic.u2b1e.RCSettingsAndroid;
import org.im97mori.ble.characteristic.u2b1f.ReconnectionConfigurationControlPoint;
import org.im97mori.ble.characteristic.u2b1f.ReconnectionConfigurationControlPointAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.constants.CharacteristicUUID.RC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RC_SETTINGS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.RECONNECTION_CONFIGURATION_SERVICE;

/**
 * Reconnection Configuration Service (Service UUID: 0x1829) for Central
 */
public class ReconnectionConfigurationService extends AbstractCentralService {

    /**
     * {@link ReconnectionConfigurationServiceCallback} instance
     */
    private final ReconnectionConfigurationServiceCallback mReconnectionConfigurationServiceCallback;

    /**
     * RC Settings characteristic flag
     * {@code true}:RC Settings characteristic is exist, {@code false}:RC Settings characteristic is not exist or service not ready
     */
    private boolean mIsRCSettingsCharacteristicSupported;

    /**
     * RC Settings characteristic notificatable flag
     * {@code true}:RC Settings characteristic is notificatable, {@code false}:RC Settings characteristic is not notificatable or service not ready
     */
    private boolean mIsRCSettingsCharacteristicNotifySupported;

    /**
     * Reconnection Configuration Control Point characteristic flag
     * {@code true}:Reconnection Configuration Control Point characteristic is exist, {@code false}:Reconnection Configuration Control Point characteristic is not exist or service not ready
     */
    private boolean mIsReconnectionConfigurationControlPointCharacteristicSupported;

    /**
     * @param bleConnection                            {@link BLEConnection} instance
     * @param reconnectionConfigurationServiceCallback {@link ReconnectionConfigurationServiceCallback} instance
     * @param bleCallback                              {@link BLECallback} instance(optional)
     */
    public ReconnectionConfigurationService(@NonNull BLEConnection bleConnection, @NonNull ReconnectionConfigurationServiceCallback reconnectionConfigurationServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mReconnectionConfigurationServiceCallback = reconnectionConfigurationServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mIsRCSettingsCharacteristicSupported = false;
            mIsRCSettingsCharacteristicNotifySupported = false;
            mIsReconnectionConfigurationControlPointCharacteristicSupported = false;
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
                if (RECONNECTION_CONFIGURATION_SERVICE.equals(bluetoothGattService.getUuid())) {
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RC_SETTINGS_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_READ) != 0) {
                        mIsRCSettingsCharacteristicSupported = true;
                        if ((bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0
                                && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                            mIsRCSettingsCharacteristicNotifySupported = true;
                        }
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && (BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE) == bluetoothGattCharacteristic.getProperties()
                            && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsReconnectionConfigurationControlPointCharacteristicSupported = true;
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RECONNECTION_CONFIGURATION_SERVICE.equals(serviceUUID)) {
            if (RC_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onRCFeatureReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, RCFeatureAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (RC_SETTINGS_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onRCSettingsReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, RCSettingsAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RECONNECTION_CONFIGURATION_SERVICE.equals(serviceUUID)) {
            if (RC_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onRCFeatureReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (RC_SETTINGS_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onRCSettingsReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RECONNECTION_CONFIGURATION_SERVICE.equals(serviceUUID)) {
            if (RC_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onRCFeatureReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (RC_SETTINGS_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onRCSettingsReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RECONNECTION_CONFIGURATION_SERVICE.equals(serviceUUID)) {
            if (RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onReconnectionConfigurationControlPointWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RECONNECTION_CONFIGURATION_SERVICE.equals(serviceUUID)) {
            if (RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onReconnectionConfigurationControlPointWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RECONNECTION_CONFIGURATION_SERVICE.equals(serviceUUID)) {
            if (RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onReconnectionConfigurationControlPointWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RECONNECTION_CONFIGURATION_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (RC_SETTINGS_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onRCSettingsClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onReconnectionConfigurationControlPointClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RECONNECTION_CONFIGURATION_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (RC_SETTINGS_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onRCSettingsClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            } else if (RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onReconnectionConfigurationControlPointClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            }
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RECONNECTION_CONFIGURATION_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (RC_SETTINGS_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onRCSettingsClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            } else if (RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onReconnectionConfigurationControlPointClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            }
        }
        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RECONNECTION_CONFIGURATION_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (RC_SETTINGS_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mReconnectionConfigurationServiceCallback.onRCSettingsNotificateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                } else {
                    mReconnectionConfigurationServiceCallback.onRCSettingsNotificateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                }
            } else if (RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mReconnectionConfigurationServiceCallback.onReconnectionConfigurationControlPointIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                } else {
                    mReconnectionConfigurationServiceCallback.onReconnectionConfigurationControlPointIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                }
            }
        }
        super.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RECONNECTION_CONFIGURATION_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (RC_SETTINGS_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mReconnectionConfigurationServiceCallback.onRCSettingsNotificateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                } else {
                    mReconnectionConfigurationServiceCallback.onRCSettingsNotificateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                }
            } else if (RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mReconnectionConfigurationServiceCallback.onReconnectionConfigurationControlPointIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                } else {
                    mReconnectionConfigurationServiceCallback.onReconnectionConfigurationControlPointIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                }
            }
        }
        super.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RECONNECTION_CONFIGURATION_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (RC_SETTINGS_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mReconnectionConfigurationServiceCallback.onRCSettingsNotificateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                } else {
                    mReconnectionConfigurationServiceCallback.onRCSettingsNotificateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                }
            } else if (RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mReconnectionConfigurationServiceCallback.onReconnectionConfigurationControlPointIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                } else {
                    mReconnectionConfigurationServiceCallback.onReconnectionConfigurationControlPointIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                }
            }
        }
        super.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && RECONNECTION_CONFIGURATION_SERVICE.equals(serviceUUID)) {
            if (RC_SETTINGS_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onRCSettingsNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, RCSettingsAndroid.CREATOR.createFromByteArray(values));
            } else if (RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mReconnectionConfigurationServiceCallback.onReconnectionConfigurationControlPointIndicated(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ReconnectionConfigurationControlPointAndroid.CREATOR.createFromByteArray(values));
            }
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * RC Settings characteristic flag
     * {@code true}:RC Settings characteristic is exist, {@code false}:RC Settings characteristic is not exist or service not ready
     */
    public boolean isRCSettingsCharacteristicSupported() {
        return mIsRCSettingsCharacteristicSupported;
    }

    /**
     * RC Settings characteristic notificatable flag
     * {@code true}:RC Settings characteristic is notificatable, {@code false}:RC Settings characteristic is not notificatable or service not ready
     */
    public boolean isRCSettingsCharacteristicNotifySupported() {
        return mIsRCSettingsCharacteristicNotifySupported;
    }

    /**
     * Reconnection Configuration Control Point characteristic flag
     * {@code true}:Reconnection Configuration Control Point characteristic is exist, {@code false}:Reconnection Configuration Control Point characteristic is not exist or service not ready
     */
    public boolean isReconnectionConfigurationControlPointCharacteristicSupported() {
        return mIsReconnectionConfigurationControlPointCharacteristicSupported;
    }

    /**
     * get RC Feature
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see ReconnectionConfigurationServiceCallback#onRCFeatureReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, RCFeatureAndroid, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onRCFeatureReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onRCFeatureReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getRCFeature() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(RECONNECTION_CONFIGURATION_SERVICE, null, RC_FEATURE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get RC Settings
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see ReconnectionConfigurationServiceCallback#onRCSettingsReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, RCSettingsAndroid, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onRCSettingsReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onRCSettingsReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getRCSettings() {
        Integer taskId = null;
        if (isStarted() && isRCSettingsCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(RECONNECTION_CONFIGURATION_SERVICE, null, RC_SETTINGS_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get RC Settings's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see ReconnectionConfigurationServiceCallback#onRCSettingsClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onRCSettingsClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onRCSettingsClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getRCSettingsClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isRCSettingsCharacteristicNotifySupported()) {
            taskId = mBLEConnection.createReadDescriptorTask(RECONNECTION_CONFIGURATION_SERVICE, null, RC_SETTINGS_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start RC Settings notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see ReconnectionConfigurationServiceCallback#onRCSettingsNotificateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onRCSettingsNotificateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onRCSettingsNotificateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startRCSettingsNotification() {
        Integer taskId = null;
        if (isStarted() && isRCSettingsCharacteristicNotifySupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(RECONNECTION_CONFIGURATION_SERVICE, null, RC_SETTINGS_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop RC Settings notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see ReconnectionConfigurationServiceCallback#onRCSettingsNotificateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onRCSettingsNotificateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onRCSettingsNotificateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopRCSettingsNotification() {
        Integer taskId = null;
        if (isStarted() && isRCSettingsCharacteristicNotifySupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(RECONNECTION_CONFIGURATION_SERVICE, null, RC_SETTINGS_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * set Reconnection Configuration Control Point
     *
     * @param reconnectionConfigurationControlPoint {@link ReconnectionConfigurationControlPoint} instance
     * @return task id. if {@code null} returned, service is not ready
     * @see ReconnectionConfigurationServiceCallback#onReconnectionConfigurationControlPointWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ReconnectionConfigurationControlPointAndroid, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onReconnectionConfigurationControlPointWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onReconnectionConfigurationControlPointWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setReconnectionConfigurationControlPoint(@NonNull ReconnectionConfigurationControlPoint reconnectionConfigurationControlPoint) {
        Integer taskId = null;
        if (isStarted() && isReconnectionConfigurationControlPointCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(RECONNECTION_CONFIGURATION_SERVICE, null, RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC, null, reconnectionConfigurationControlPoint, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Reconnection Configuration Control Point's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see ReconnectionConfigurationServiceCallback#onReconnectionConfigurationControlPointClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onReconnectionConfigurationControlPointClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onReconnectionConfigurationControlPointClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getReconnectionConfigurationControlPointClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isReconnectionConfigurationControlPointCharacteristicSupported()) {
            taskId = mBLEConnection.createReadDescriptorTask(RECONNECTION_CONFIGURATION_SERVICE, null, RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Reconnection Configuration Control Point indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see ReconnectionConfigurationServiceCallback#onReconnectionConfigurationControlPointIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onReconnectionConfigurationControlPointIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onReconnectionConfigurationControlPointIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer startReconnectionConfigurationControlPointIndication() {
        Integer taskId = null;
        if (isStarted() && isReconnectionConfigurationControlPointCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(RECONNECTION_CONFIGURATION_SERVICE, null, RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Reconnection Configuration Control Point indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see ReconnectionConfigurationServiceCallback#onReconnectionConfigurationControlPointIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onReconnectionConfigurationControlPointIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     * @see ReconnectionConfigurationServiceCallback#onReconnectionConfigurationControlPointIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     */
    @Nullable
    public synchronized Integer stopReconnectionConfigurationControlPointIndication() {
        Integer taskId = null;
        if (isStarted() && isReconnectionConfigurationControlPointCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(RECONNECTION_CONFIGURATION_SERVICE, null, RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

}
