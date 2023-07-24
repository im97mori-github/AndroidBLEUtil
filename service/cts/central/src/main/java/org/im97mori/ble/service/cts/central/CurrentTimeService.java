package org.im97mori.ble.service.cts.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformationAndroid;
import org.im97mori.ble.characteristic.u2a14.ReferenceTimeInformationAndroid;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.characteristic.u2a2b.CurrentTimeAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.constants.CharacteristicUUID.CURRENT_TIME_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LOCAL_TIME_INFORMATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.REFERENCE_TIME_INFORMATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.CURRENT_TIME_SERVICE;

/**
 * Current Time Service (Service UUID: 0x1805) for Central
 */
public class CurrentTimeService extends AbstractCentralService {

    /**
     * {@link CurrentTimeServiceCallback} instance
     */
    private final CurrentTimeServiceCallback mCurrentTimeServiceCallback;

    /**
     * Current Time characteristic writable flag
     * {@code true}:Current Time characteristic is writable, {@code false}:Current Time characteristic is not writable or service not ready
     */
    private boolean mIsCurrentTimeCharacteristicWritable;

    /**
     * Local Time Information characteristic flag
     * {@code true}:Local Time Information characteristic is exist, {@code false}:Local Time Information characteristic is not exist or service not ready
     */
    private boolean mIsLocalTimeInformationCharacteristicSupported;

    /**
     * Local Time Information characteristic writable flag
     * {@code true}:Local Time Information characteristic is writable, {@code false}:Local Time Information characteristic is not writable or service not ready
     */
    private boolean mIsLocalTimeInformationCharacteristicWritable;

    /**
     * Reference Time Information characteristic flag
     * {@code true}:Reference Time Information characteristic is exist, {@code false}:Reference Time Information characteristic is not exist or service not ready
     */
    private boolean mIsReferenceTimeInformationCharacteristicSupported;

    /**
     * @param bleConnection              {@link BLEConnection} instance
     * @param currentTimeServiceCallback {@link CurrentTimeServiceCallback} instance
     * @param bleCallback                {@link BLECallback} instance(optional)
     */
    public CurrentTimeService(@NonNull BLEConnection bleConnection, @NonNull CurrentTimeServiceCallback currentTimeServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mCurrentTimeServiceCallback = currentTimeServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mIsCurrentTimeCharacteristicWritable = false;
            mIsLocalTimeInformationCharacteristicSupported = false;
            mIsLocalTimeInformationCharacteristicWritable = false;
            mIsReferenceTimeInformationCharacteristicSupported = false;
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
                if (CURRENT_TIME_SERVICE.equals(bluetoothGattService.getUuid())) {
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CURRENT_TIME_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && (BluetoothGattCharacteristic.PROPERTY_WRITE & bluetoothGattCharacteristic.getProperties()) != 0) {
                        mIsCurrentTimeCharacteristicWritable = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && (BluetoothGattCharacteristic.PROPERTY_READ & bluetoothGattCharacteristic.getProperties()) != 0) {
                        mIsLocalTimeInformationCharacteristicSupported = true;

                        if ((BluetoothGattCharacteristic.PROPERTY_WRITE & bluetoothGattCharacteristic.getProperties()) != 0) {
                            mIsLocalTimeInformationCharacteristicWritable = true;
                        }
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(REFERENCE_TIME_INFORMATION_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && BluetoothGattCharacteristic.PROPERTY_READ == bluetoothGattCharacteristic.getProperties()) {
                        mIsReferenceTimeInformationCharacteristicSupported = true;
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CURRENT_TIME_SERVICE.equals(serviceUUID)) {
            if (CURRENT_TIME_CHARACTERISTIC.equals(characteristicUUID)) {
                mCurrentTimeServiceCallback.onCurrentTimeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, CurrentTimeAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (LOCAL_TIME_INFORMATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mCurrentTimeServiceCallback.onLocalTimeInformationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, LocalTimeInformationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (REFERENCE_TIME_INFORMATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mCurrentTimeServiceCallback.onReferenceTimeInformationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ReferenceTimeInformationAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CURRENT_TIME_SERVICE.equals(serviceUUID)) {
            if (CURRENT_TIME_CHARACTERISTIC.equals(characteristicUUID)) {
                mCurrentTimeServiceCallback.onCurrentTimeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (LOCAL_TIME_INFORMATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mCurrentTimeServiceCallback.onLocalTimeInformationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (REFERENCE_TIME_INFORMATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mCurrentTimeServiceCallback.onReferenceTimeInformationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CURRENT_TIME_SERVICE.equals(serviceUUID)) {
            if (CURRENT_TIME_CHARACTERISTIC.equals(characteristicUUID)) {
                mCurrentTimeServiceCallback.onCurrentTimeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (LOCAL_TIME_INFORMATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mCurrentTimeServiceCallback.onLocalTimeInformationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (REFERENCE_TIME_INFORMATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mCurrentTimeServiceCallback.onReferenceTimeInformationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CURRENT_TIME_SERVICE.equals(serviceUUID)) {
            if (CURRENT_TIME_CHARACTERISTIC.equals(characteristicUUID)) {
                mCurrentTimeServiceCallback.onCurrentTimeWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, CurrentTimeAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (LOCAL_TIME_INFORMATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mCurrentTimeServiceCallback.onLocalTimeInformationWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, LocalTimeInformationAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CURRENT_TIME_SERVICE.equals(serviceUUID)) {
            if (CURRENT_TIME_CHARACTERISTIC.equals(characteristicUUID)) {
                mCurrentTimeServiceCallback.onCurrentTimeWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (LOCAL_TIME_INFORMATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mCurrentTimeServiceCallback.onLocalTimeInformationWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CURRENT_TIME_SERVICE.equals(serviceUUID)) {
            if (CURRENT_TIME_CHARACTERISTIC.equals(characteristicUUID)) {
                mCurrentTimeServiceCallback.onCurrentTimeWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (LOCAL_TIME_INFORMATION_CHARACTERISTIC.equals(characteristicUUID)) {
                mCurrentTimeServiceCallback.onLocalTimeInformationWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CURRENT_TIME_SERVICE.equals(serviceUUID) && CURRENT_TIME_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            mCurrentTimeServiceCallback.onCurrentTimeClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CURRENT_TIME_SERVICE.equals(serviceUUID) && CURRENT_TIME_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            mCurrentTimeServiceCallback.onCurrentTimeClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CURRENT_TIME_SERVICE.equals(serviceUUID) && CURRENT_TIME_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            mCurrentTimeServiceCallback.onCurrentTimeClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
        }
        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CURRENT_TIME_SERVICE.equals(serviceUUID) && CURRENT_TIME_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                mCurrentTimeServiceCallback.onCurrentTimeNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
            } else {
                mCurrentTimeServiceCallback.onCurrentTimeNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
            }
        }
        super.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CURRENT_TIME_SERVICE.equals(serviceUUID) && CURRENT_TIME_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                mCurrentTimeServiceCallback.onCurrentTimeNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            } else {
                mCurrentTimeServiceCallback.onCurrentTimeNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            }
        }
        super.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CURRENT_TIME_SERVICE.equals(serviceUUID) && CURRENT_TIME_CHARACTERISTIC.equals(characteristicUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                mCurrentTimeServiceCallback.onCurrentTimeNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            } else {
                mCurrentTimeServiceCallback.onCurrentTimeNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            }
        }
        super.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && CURRENT_TIME_SERVICE.equals(serviceUUID) && CURRENT_TIME_CHARACTERISTIC.equals(characteristicUUID)) {
            mCurrentTimeServiceCallback.onCurrentTimeNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, CurrentTimeAndroid.CREATOR.createFromByteArray(values));
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * check Current Time characteristic writable
     *
     * @return {@code true}:Current Time characteristic is writable, {@code false}:Current Time characteristic is not writable or service not ready
     */
    public boolean isCurrentTimeCharacteristicWritable() {
        return mIsCurrentTimeCharacteristicWritable;
    }

    /**
     * check Local Time Information characteristic
     *
     * @return {@code true}:Local Time Information characteristic is exist, {@code false}:Local Time Information characteristic is not exist or service not ready
     */
    public boolean isLocalTimeInformationCharacteristicSupported() {
        return mIsLocalTimeInformationCharacteristicSupported;
    }

    /**
     * check Local Time Information characteristic writable
     *
     * @return {@code true}:Local Time Information characteristic is writable, {@code false}:Local Time Information characteristic is not writable or service not ready
     */
    public boolean isLocalTimeInformationCharacteristicWritable() {
        return mIsLocalTimeInformationCharacteristicWritable;
    }

    /**
     * check Reference Time Information characteristic
     *
     * @return {@code true}:Reference Time Information characteristic is exist, {@code false}:Reference Time Information characteristic is not exist or service not ready
     */
    public boolean isReferenceTimeInformationCharacteristicSupported() {
        return mIsReferenceTimeInformationCharacteristicSupported;
    }

    /**
     * get Current Time
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CurrentTimeServiceCallback#onCurrentTimeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, CurrentTimeAndroid, Bundle)
     * @see CurrentTimeServiceCallback#onCurrentTimeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see CurrentTimeServiceCallback#onCurrentTimeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getCurrentTime() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(CURRENT_TIME_SERVICE, null, CURRENT_TIME_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Current Time
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CurrentTimeServiceCallback#onCurrentTimeWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, CurrentTimeAndroid, Bundle)
     * @see CurrentTimeServiceCallback#onCurrentTimeWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see CurrentTimeServiceCallback#onCurrentTimeWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setCurrentTime(@NonNull CurrentTime currentTime) {
        Integer taskId = null;
        if (isStarted() && isCurrentTimeCharacteristicWritable()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(CURRENT_TIME_SERVICE, null, CURRENT_TIME_CHARACTERISTIC, null, currentTime, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Current Time's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CurrentTimeServiceCallback#onCurrentTimeClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see CurrentTimeServiceCallback#onCurrentTimeClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see CurrentTimeServiceCallback#onCurrentTimeClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getCurrentTimeClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadDescriptorTask(CURRENT_TIME_SERVICE, null, CURRENT_TIME_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Current Time notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CurrentTimeServiceCallback#onCurrentTimeNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see CurrentTimeServiceCallback#onCurrentTimeNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see CurrentTimeServiceCallback#onCurrentTimeNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startCurrentTimeNotification() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(CURRENT_TIME_SERVICE, null, CURRENT_TIME_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Current Time notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CurrentTimeServiceCallback#onCurrentTimeNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see CurrentTimeServiceCallback#onCurrentTimeNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see CurrentTimeServiceCallback#onCurrentTimeNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopCurrentTimeNotification() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(CURRENT_TIME_SERVICE, null, CURRENT_TIME_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Local Time Information
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CurrentTimeServiceCallback#onLocalTimeInformationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, LocalTimeInformationAndroid, Bundle)
     * @see CurrentTimeServiceCallback#onLocalTimeInformationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see CurrentTimeServiceCallback#onLocalTimeInformationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getLocalTimeInformation() {
        Integer taskId = null;
        if (isStarted() && isLocalTimeInformationCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(CURRENT_TIME_SERVICE, null, LOCAL_TIME_INFORMATION_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Local Time Information
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CurrentTimeServiceCallback#onLocalTimeInformationWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, LocalTimeInformationAndroid, Bundle)
     * @see CurrentTimeServiceCallback#onLocalTimeInformationWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see CurrentTimeServiceCallback#onLocalTimeInformationWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setLocalTimeInformation(@NonNull LocalTimeInformation localTimeInformation) {
        Integer taskId = null;
        if (isStarted() && isLocalTimeInformationCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(CURRENT_TIME_SERVICE, null, LOCAL_TIME_INFORMATION_CHARACTERISTIC, null, localTimeInformation, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Reference Time Information
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see CurrentTimeServiceCallback#onReferenceTimeInformationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ReferenceTimeInformationAndroid, Bundle)
     * @see CurrentTimeServiceCallback#onReferenceTimeInformationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see CurrentTimeServiceCallback#onReferenceTimeInformationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getReferenceTimeInformation() {
        Integer taskId = null;
        if (isStarted() && isReferenceTimeInformationCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(CURRENT_TIME_SERVICE, null, REFERENCE_TIME_INFORMATION_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

}
