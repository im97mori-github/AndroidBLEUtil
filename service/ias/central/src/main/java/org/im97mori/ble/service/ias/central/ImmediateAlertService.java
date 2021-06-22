package org.im97mori.ble.service.ias.central;

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
import org.im97mori.ble.task.WriteCharacteristicTask;

import java.util.UUID;

import static org.im97mori.ble.constants.CharacteristicUUID.ALERT_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.IMMEDIATE_ALERT_SERVICE;

/**
 * Immediate Alert Service (Service UUID: 0x1802) for Central
 */
public class ImmediateAlertService extends AbstractCentralService {

    /**
     * {@link ImmediateAlertServiceCallback} instance
     */
    private final ImmediateAlertServiceCallback mImmediateAlertServiceCallback;

    /**
     * @param bleConnection                 {@link BLEConnection} instance
     * @param immediateAlertServiceCallback {@link ImmediateAlertServiceCallback} instance
     * @param bleCallback                   {@link BLECallback} instance(optional)
     */
    public ImmediateAlertService(@NonNull BLEConnection bleConnection, @NonNull ImmediateAlertServiceCallback immediateAlertServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mImmediateAlertServiceCallback = immediateAlertServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && IMMEDIATE_ALERT_SERVICE.equals(serviceUUID) && ALERT_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            mImmediateAlertServiceCallback.onAlertLevelWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AlertLevelAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && IMMEDIATE_ALERT_SERVICE.equals(serviceUUID) && ALERT_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            mImmediateAlertServiceCallback.onAlertLevelWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && IMMEDIATE_ALERT_SERVICE.equals(serviceUUID) && ALERT_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            mImmediateAlertServiceCallback.onAlertLevelWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * set Alert Level
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see ImmediateAlertServiceCallback#onAlertLevelWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AlertLevelAndroid, Bundle)
     * @see ImmediateAlertServiceCallback#onAlertLevelWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see ImmediateAlertServiceCallback#onAlertLevelWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAlertLevel(@NonNull AlertLevel alertLevel) {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(IMMEDIATE_ALERT_SERVICE
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
