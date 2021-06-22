package org.im97mori.ble.service.scps.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a31.ScanRefreshAndroid;
import org.im97mori.ble.characteristic.u2a4f.ScanIntervalWindow;
import org.im97mori.ble.characteristic.u2a4f.ScanIntervalWindowAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.constants.CharacteristicUUID.SCAN_INTERVAL_WINDOW_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SCAN_REFRESH_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.SCAN_PARAMETERS_SERVICE;

/**
 * Scan Parameters Service (Service UUID: 0x1813) for Central
 */
public class ScanParametersService extends AbstractCentralService {

    /**
     * {@link ScanParametersServiceCallback} instance
     */
    private final ScanParametersServiceCallback mScanParametersServiceCallback;

    /**
     * Scan Refresh characteristic flag
     * {@code true}:Scan Refresh characteristic is exist, {@code false}:Scan Refresh characteristic is not exist or service not ready
     */
    private boolean mIsScanRefreshCharacteristicSupported;

    /**
     * @param bleConnection                 {@link BLEConnection} instance
     * @param scanParametersServiceCallback {@link ScanParametersServiceCallback} instance
     * @param bleCallback                   {@link BLECallback} instance(optional)
     */
    public ScanParametersService(@NonNull BLEConnection bleConnection, @NonNull ScanParametersServiceCallback scanParametersServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mScanParametersServiceCallback = scanParametersServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mIsScanRefreshCharacteristicSupported = false;
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
                if (SCAN_PARAMETERS_SERVICE.equals(bluetoothGattService.getUuid())) {
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SCAN_REFRESH_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_NOTIFY == bluetoothGattCharacteristic.getProperties()
                            && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsScanRefreshCharacteristicSupported = true;
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
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && SCAN_PARAMETERS_SERVICE.equals(serviceUUID)) {
            if (SCAN_INTERVAL_WINDOW_CHARACTERISTIC.equals(characteristicUUID)) {
                mScanParametersServiceCallback.onScanIntervalWindowWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ScanIntervalWindowAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && SCAN_PARAMETERS_SERVICE.equals(serviceUUID)) {
            if (SCAN_INTERVAL_WINDOW_CHARACTERISTIC.equals(characteristicUUID)) {
                mScanParametersServiceCallback.onScanIntervalWindowWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && SCAN_PARAMETERS_SERVICE.equals(serviceUUID)) {
            if (SCAN_INTERVAL_WINDOW_CHARACTERISTIC.equals(characteristicUUID)) {
                mScanParametersServiceCallback.onScanIntervalWindowWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && SCAN_PARAMETERS_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (SCAN_REFRESH_CHARACTERISTIC.equals(characteristicUUID)) {
                mScanParametersServiceCallback.onScanRefreshClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && SCAN_PARAMETERS_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (SCAN_REFRESH_CHARACTERISTIC.equals(characteristicUUID)) {
                mScanParametersServiceCallback.onScanRefreshClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            }
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && SCAN_PARAMETERS_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (SCAN_REFRESH_CHARACTERISTIC.equals(characteristicUUID)) {
                mScanParametersServiceCallback.onScanRefreshClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            }
        }
        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && SCAN_PARAMETERS_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (SCAN_REFRESH_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mScanParametersServiceCallback.onScanRefreshNotificateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                } else {
                    mScanParametersServiceCallback.onScanRefreshNotificateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && SCAN_PARAMETERS_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (SCAN_REFRESH_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mScanParametersServiceCallback.onScanRefreshNotificateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                } else {
                    mScanParametersServiceCallback.onScanRefreshNotificateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && SCAN_PARAMETERS_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (SCAN_REFRESH_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mScanParametersServiceCallback.onScanRefreshNotificateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                } else {
                    mScanParametersServiceCallback.onScanRefreshNotificateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && SCAN_PARAMETERS_SERVICE.equals(serviceUUID)) {
            if (SCAN_REFRESH_CHARACTERISTIC.equals(characteristicUUID)) {
                mScanParametersServiceCallback.onScanRefreshNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ScanRefreshAndroid.CREATOR.createFromByteArray(values));
            }
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * check Scan Refresh characteristic
     *
     * @return {@code true}:Scan Refresh characteristic is exist, {@code false}:Scan Refresh characteristic is not exist or service not ready
     */
    public boolean isScanRefreshCharacteristicSupported() {
        return mIsScanRefreshCharacteristicSupported;
    }

    /**
     * set Scan Interval Window Point
     *
     * @param scanIntervalWindow {@link ScanIntervalWindow} instance
     * @return task id. if {@code null} returned, service is not ready
     * @see ScanParametersServiceCallback#onScanIntervalWindowWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ScanIntervalWindowAndroid, Bundle)
     * @see ScanParametersServiceCallback#onScanIntervalWindowWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see ScanParametersServiceCallback#onScanIntervalWindowWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setScanIntervalWindow(@NonNull ScanIntervalWindow scanIntervalWindow) {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(SCAN_PARAMETERS_SERVICE, null, SCAN_INTERVAL_WINDOW_CHARACTERISTIC, null, scanIntervalWindow, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Scan Refresh's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see ScanParametersServiceCallback#onScanRefreshClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see ScanParametersServiceCallback#onScanRefreshClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see ScanParametersServiceCallback#onScanRefreshClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getScanRefreshClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isScanRefreshCharacteristicSupported()) {
            taskId = mBLEConnection.createReadDescriptorTask(SCAN_PARAMETERS_SERVICE, null, SCAN_REFRESH_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Scan Refresh notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see ScanParametersServiceCallback#onScanRefreshNotificateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see ScanParametersServiceCallback#onScanRefreshNotificateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see ScanParametersServiceCallback#onScanRefreshNotificateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startScanRefreshNotification() {
        Integer taskId = null;
        if (isStarted() && isScanRefreshCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(SCAN_PARAMETERS_SERVICE, null, SCAN_REFRESH_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Scan Refresh notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see ScanParametersServiceCallback#onScanRefreshNotificateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see ScanParametersServiceCallback#onScanRefreshNotificateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see ScanParametersServiceCallback#onScanRefreshNotificateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopScanRefreshNotification() {
        Integer taskId = null;
        if (isStarted() && isScanRefreshCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(SCAN_PARAMETERS_SERVICE, null, SCAN_REFRESH_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

}
