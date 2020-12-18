package org.im97mori.ble.service.tps.central;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a07.TxPowerLevelAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TX_POWER_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.ServiceUUID.TX_POWER_SERVICE;

/**
 * Tx Power Service (Service UUID: 0x1804) for Central
 */
public class TxPowerService extends AbstractCentralService {

    /**
     * {@link TxPowerService} instance
     */
    private final TxPowerServiceCallback mTxPowerServiceCallback;

    /**
     * @param bleConnection          {@link BLEConnection} instance
     * @param txPowerServiceCallback {@link TxPowerServiceCallback} instance
     * @param bleCallback            {@link BLECallback} instance(optional)
     */
    public TxPowerService(@NonNull BLEConnection bleConnection, @NonNull TxPowerServiceCallback txPowerServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mTxPowerServiceCallback = txPowerServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && TX_POWER_SERVICE.equals(serviceUUID) && TX_POWER_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            mTxPowerServiceCallback.onTxPowerLevelReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, TxPowerLevelAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && TX_POWER_SERVICE.equals(serviceUUID) && TX_POWER_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            mTxPowerServiceCallback.onTxPowerLevelReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && TX_POWER_SERVICE.equals(serviceUUID) && TX_POWER_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            mTxPowerServiceCallback.onTxPowerLevelReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * get Tx Power Level
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see TxPowerServiceCallback#onTxPowerLevelReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, TxPowerLevelAndroid, Bundle)
     * @see TxPowerServiceCallback#onTxPowerLevelReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see TxPowerServiceCallback#onTxPowerLevelReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    public synchronized Integer getTxPowerLevel() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(TX_POWER_SERVICE, null, TX_POWER_LEVEL_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

}
