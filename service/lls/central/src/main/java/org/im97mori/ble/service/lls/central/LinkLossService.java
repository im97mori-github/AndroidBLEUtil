package org.im97mori.ble.service.lls.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a06.AlertLevel;
import org.im97mori.ble.characteristic.u2a06.AlertLevelAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.WriteCharacteristicTask;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ALERT_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.ServiceUUID.LINK_LOSS_SERVICE;

/**
 * Link Loss Service (Service UUID: 0x1803) for Central
 */
public class LinkLossService extends AbstractCentralService {

    /**
     * {@link LinkLossService} instance
     */
    private final LinkLossServiceCallback mLinkLossServiceCallback;

    /**
     * @param bleConnection           {@link BLEConnection} instance
     * @param linkLossServiceCallback {@link LinkLossServiceCallback} instance
     * @param bleCallback             {@link BLECallback} instance(optional)
     */
    public LinkLossService(@NonNull BLEConnection bleConnection, @NonNull LinkLossServiceCallback linkLossServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mLinkLossServiceCallback = linkLossServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LINK_LOSS_SERVICE.equals(serviceUUID) && ALERT_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            mLinkLossServiceCallback.onAlertLevelReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AlertLevelAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LINK_LOSS_SERVICE.equals(serviceUUID) && ALERT_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            mLinkLossServiceCallback.onAlertLevelReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LINK_LOSS_SERVICE.equals(serviceUUID) && ALERT_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            mLinkLossServiceCallback.onAlertLevelReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LINK_LOSS_SERVICE.equals(serviceUUID) && ALERT_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            mLinkLossServiceCallback.onAlertLevelWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AlertLevelAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LINK_LOSS_SERVICE.equals(serviceUUID) && ALERT_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            mLinkLossServiceCallback.onAlertLevelWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && LINK_LOSS_SERVICE.equals(serviceUUID) && ALERT_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            mLinkLossServiceCallback.onAlertLevelWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * get Alert Level
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see LinkLossServiceCallback#onAlertLevelReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AlertLevelAndroid, Bundle)
     * @see LinkLossServiceCallback#onAlertLevelReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see LinkLossServiceCallback#onAlertLevelReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     */
    public Integer getAlertLevel() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(LINK_LOSS_SERVICE, null, ALERT_LEVEL_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Alert Level
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see LinkLossServiceCallback#onAlertLevelWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AlertLevelAndroid, Bundle)
     * @see LinkLossServiceCallback#onAlertLevelWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see LinkLossServiceCallback#onAlertLevelWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer setAlertLevel(@NonNull AlertLevel alertLevel) {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(LINK_LOSS_SERVICE
                    , null
                    , ALERT_LEVEL_CHARACTERISTIC
                    , null
                    , alertLevel
                    , BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
                    , WriteCharacteristicTask.TIMEOUT_MILLIS
                    , null
                    , this);
        }
        return taskId;
    }

}
