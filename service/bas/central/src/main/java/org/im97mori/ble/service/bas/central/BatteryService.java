package org.im97mori.ble.service.bas.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a19.BatteryLevelAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormatAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BATTERY_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.BATTERY_SERVICE;

/**
 * Battery Service (Service UUID: 0x180A) for Central
 */
public class BatteryService extends AbstractCentralService {

    /**
     * KEY:STATUS
     */
    private static final String KEY_STATUS = "KEY_STATUS";

    /**
     * STATUS:START
     */
    private static final int STATUS_START = 0;

    /**
     * STATUS:STOP
     */
    private static final int STATUS_STOP = 1;

    /**
     * {@link BatteryServiceCallback} instance
     */
    private final BatteryServiceCallback mBatteryServiceCallback;

    /**
     * Battery Service list
     */
    private final List<BluetoothGattService> mBatteryServiceList = new LinkedList<>();

    /**
     * @param bleConnection          {@link BLEConnection} instance
     * @param batteryServiceCallback {@link BatteryServiceCallback} instance
     * @param bleCallback            {@link BLECallback} instance (optional)
     */
    public BatteryService(@NonNull BLEConnection bleConnection, @NonNull BatteryServiceCallback batteryServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mBatteryServiceCallback = batteryServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mBatteryServiceList.clear();
        }
        super.onBLEDisconnected(taskId, bluetoothDevice, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            for (BluetoothGattService bluetoothGattService : serviceList) {
                if (BATTERY_SERVICE.equals(bluetoothGattService.getUuid())) {
                    mBatteryServiceList.add(bluetoothGattService);
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BATTERY_SERVICE.equals(serviceUUID) && BATTERY_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            mBatteryServiceCallback.onBatteryLevelReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getIndex(serviceInstanceId, characteristicInstanceId), BatteryLevelAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * get service index
     *
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @return service index. {@link BatteryService#getBatteryLevel(int)} 1st parameter or null
     */
    @Nullable
    private Integer getIndex(@Nullable Integer serviceInstanceId, @Nullable Integer characteristicInstanceId) {
        Integer index = null;
        BluetoothGattService bluetoothGattService;
        for (int i = 0; i < mBatteryServiceList.size(); i++) {
            bluetoothGattService = mBatteryServiceList.get(i);
            if (serviceInstanceId != null && serviceInstanceId == bluetoothGattService.getInstanceId()) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
                if (bluetoothGattCharacteristic != null && characteristicInstanceId != null && characteristicInstanceId == bluetoothGattCharacteristic.getInstanceId()) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BATTERY_SERVICE.equals(serviceUUID) && BATTERY_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            mBatteryServiceCallback.onBatteryLevelReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getIndex(serviceInstanceId, characteristicInstanceId), status, argument);
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BATTERY_SERVICE.equals(serviceUUID) && BATTERY_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            mBatteryServiceCallback.onBatteryLevelReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getIndex(serviceInstanceId, characteristicInstanceId), timeout, argument);
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BATTERY_SERVICE.equals(serviceUUID) && BATTERY_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                mBatteryServiceCallback.onBatteryLevelClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getIndex(serviceInstanceId, characteristicInstanceId), ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR.equals(descriptorUUID)) {
                mBatteryServiceCallback.onBatteryLevelCharacteristicPresentationFormatReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getIndex(serviceInstanceId, characteristicInstanceId), CharacteristicPresentationFormatAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BATTERY_SERVICE.equals(serviceUUID) && BATTERY_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                mBatteryServiceCallback.onBatteryLevelClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getIndex(serviceInstanceId, characteristicInstanceId), status, argument);
            } else if (CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR.equals(descriptorUUID)) {
                mBatteryServiceCallback.onBatteryLevelCharacteristicPresentationFormatReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getIndex(serviceInstanceId, characteristicInstanceId), status, argument);
            }
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BATTERY_SERVICE.equals(serviceUUID) && BATTERY_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                mBatteryServiceCallback.onBatteryLevelClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getIndex(serviceInstanceId, characteristicInstanceId), timeout, argument);
            } else if (CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR.equals(descriptorUUID)) {
                mBatteryServiceCallback.onBatteryLevelCharacteristicPresentationFormatReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getIndex(serviceInstanceId, characteristicInstanceId), timeout, argument);
            }
        }
        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BATTERY_SERVICE.equals(serviceUUID) && BATTERY_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mBatteryServiceCallback.onBatteryLevelNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getIndex(serviceInstanceId, characteristicInstanceId), argument);
                } else if (argument.getInt(KEY_STATUS, STATUS_STOP) == STATUS_STOP) {
                    mBatteryServiceCallback.onBatteryLevelNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getIndex(serviceInstanceId, characteristicInstanceId), argument);
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BATTERY_SERVICE.equals(serviceUUID) && BATTERY_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mBatteryServiceCallback.onBatteryLevelNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getIndex(serviceInstanceId, characteristicInstanceId), status, argument);
                } else if (argument.getInt(KEY_STATUS, STATUS_STOP) == STATUS_STOP) {
                    mBatteryServiceCallback.onBatteryLevelNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getIndex(serviceInstanceId, characteristicInstanceId), status, argument);
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BATTERY_SERVICE.equals(serviceUUID) && BATTERY_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mBatteryServiceCallback.onBatteryLevelNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getIndex(serviceInstanceId, characteristicInstanceId), timeout, argument);
                } else if (argument.getInt(KEY_STATUS, STATUS_STOP) == STATUS_STOP) {
                    mBatteryServiceCallback.onBatteryLevelNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getIndex(serviceInstanceId, characteristicInstanceId), timeout, argument);
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
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BATTERY_SERVICE.equals(serviceUUID) && BATTERY_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            mBatteryServiceCallback.onBatteryLevelNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, getIndex(serviceInstanceId, characteristicInstanceId), BatteryLevelAndroid.CREATOR.createFromByteArray(values));
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * get available Battery Service count
     *
     * @return available Battery Service count,. if {@code null} returned, service is not ready
     */
    @Nullable
    public synchronized Integer getBatteryLevelCount() {
        Integer count = null;
        if (isStarted()) {
            count = mBatteryServiceList.size();
        }
        return count;
    }

    /**
     * @see #getBatteryLevel(int)
     */
    @Nullable
    public synchronized Integer getBatteryLevel() {
        return getBatteryLevel(0);
    }

    /**
     * get Battery Level
     *
     * @param index Battery Service index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see BatteryServiceCallback#onBatteryLevelReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, BatteryLevelAndroid, Bundle)
     * @see BatteryServiceCallback#onBatteryLevelReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see BatteryServiceCallback#onBatteryLevelReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getBatteryLevel(int index) {
        Integer taskId = null;
        if (isStarted() && index >= 0 && index < mBatteryServiceList.size()) {
            BluetoothGattService bluetoothGattService = mBatteryServiceList.get(index);
            BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
            if (bluetoothGattCharacteristic != null) {
                taskId = mBLEConnection.createReadCharacteristicTask(BATTERY_SERVICE, bluetoothGattService.getInstanceId(), BATTERY_LEVEL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
            }
        }
        return taskId;
    }

    /**
     * @see #isBatteryLevelNotificatable(int)
     */
    public synchronized boolean isBatteryLevelNotificatable() {
        return isBatteryLevelNotificatable(0);
    }

    /**
     * get Battery Level's notificatable status
     *
     * @param index Battery Service index
     * @return {@code true}:target Battery Service is notificatable, {@code false}:not notificatable
     */
    public synchronized boolean isBatteryLevelNotificatable(int index) {
        boolean result = false;
        if (isStarted() && index >= 0 && index < mBatteryServiceList.size()) {
            BluetoothGattService bluetoothGattService = mBatteryServiceList.get(index);
            BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
            result = bluetoothGattCharacteristic != null && (bluetoothGattCharacteristic.getProperties() & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0 && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null;
        }
        return result;
    }

    /**
     * @see #getBatteryLevelCharacteristicPresentationFormat(int)
     */
    @Nullable
    public synchronized Integer getBatteryLevelCharacteristicPresentationFormat() {
        return getBatteryLevelCharacteristicPresentationFormat(0);
    }

    /**
     * get Battery Level's Characteristic Presentation Format
     *
     * @param index Battery Service index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see BatteryServiceCallback#onBatteryLevelCharacteristicPresentationFormatReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, CharacteristicPresentationFormatAndroid, Bundle)
     * @see BatteryServiceCallback#onBatteryLevelCharacteristicPresentationFormatReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see BatteryServiceCallback#onBatteryLevelCharacteristicPresentationFormatReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getBatteryLevelCharacteristicPresentationFormat(int index) {
        Integer taskId = null;
        if (isStarted() && index >= 0 && index < mBatteryServiceList.size()) {
            BluetoothGattService bluetoothGattService = mBatteryServiceList.get(index);
            BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
            if (bluetoothGattCharacteristic != null) {
                BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR);
                if (bluetoothGattDescriptor != null) {
                    taskId = mBLEConnection.createReadDescriptorTask(BATTERY_SERVICE, bluetoothGattService.getInstanceId(), BATTERY_LEVEL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
                }
            }
        }
        return taskId;
    }

    /**
     * @see #getBatteryLevelClientCharacteristicConfiguration(int)
     */
    @Nullable
    public synchronized Integer getBatteryLevelClientCharacteristicConfiguration() {
        return getBatteryLevelClientCharacteristicConfiguration(0);
    }

    /**
     * get Battery Level's Client Characteristic Configuration
     *
     * @param index Battery Service index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see BatteryServiceCallback#onBatteryLevelClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see BatteryServiceCallback#onBatteryLevelClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see BatteryServiceCallback#onBatteryLevelClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getBatteryLevelClientCharacteristicConfiguration(int index) {
        Integer taskId = null;
        if (isStarted() && index >= 0 && index < mBatteryServiceList.size()) {
            BluetoothGattService bluetoothGattService = mBatteryServiceList.get(index);
            if (isBatteryLevelNotificatable(index)) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
                BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
                if (bluetoothGattDescriptor != null) {
                    taskId = mBLEConnection.createReadDescriptorTask(BATTERY_SERVICE, bluetoothGattService.getInstanceId(), BATTERY_LEVEL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
                }
            }
        }
        return taskId;
    }

    /**
     * @see #startBatteryLevelNotification(int)
     */
    @Nullable
    public synchronized Integer startBatteryLevelNotification() {
        return startBatteryLevelNotification(0);
    }

    /**
     * start Battery Level's notification
     *
     * @param index Battery Service index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see BatteryServiceCallback#onBatteryLevelNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see BatteryServiceCallback#onBatteryLevelNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see BatteryServiceCallback#onBatteryLevelNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startBatteryLevelNotification(int index) {
        Integer taskId = null;
        if (isStarted() && index >= 0 && index < mBatteryServiceList.size()) {
            BluetoothGattService bluetoothGattService = mBatteryServiceList.get(index);
            if (isBatteryLevelNotificatable(index)) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
                BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
                if (bluetoothGattDescriptor != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(KEY_STATUS, STATUS_START);
                    taskId = mBLEConnection.createWriteDescriptorTask(BATTERY_SERVICE, bluetoothGattService.getInstanceId(), BATTERY_LEVEL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
                }
            }
        }
        return taskId;
    }

    /**
     * @see #stopBatteryLevelNotification(int)
     */
    @Nullable
    public synchronized Integer stopBatteryLevelNotification() {
        return stopBatteryLevelNotification(0);
    }

    /**
     * stop Battery Level's notification
     *
     * @param index Battery Service index
     * @return task id. if {@code null} returned, service is not ready or index is out of range
     * @see BatteryServiceCallback#onBatteryLevelNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see BatteryServiceCallback#onBatteryLevelNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see BatteryServiceCallback#onBatteryLevelNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopBatteryLevelNotification(int index) {
        Integer taskId = null;
        if (isStarted() && index >= 0 && index < mBatteryServiceList.size()) {
            BluetoothGattService bluetoothGattService = mBatteryServiceList.get(index);
            if (isBatteryLevelNotificatable(index)) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
                BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
                if (bluetoothGattDescriptor != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(KEY_STATUS, STATUS_STOP);
                    taskId = mBLEConnection.createWriteDescriptorTask(BATTERY_SERVICE, bluetoothGattService.getInstanceId(), BATTERY_LEVEL_CHARACTERISTIC, bluetoothGattCharacteristic.getInstanceId(), CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
                }
            }
        }
        return taskId;
    }

}
