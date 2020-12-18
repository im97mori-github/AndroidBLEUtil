package org.im97mori.ble.service.ndcs.central;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a11.TimeWithDstAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TIME_WITH_DST_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.ServiceUUID.NEXT_DST_CHANGE_SERVICE;

/**
 * Next DST Change Service (Service UUID: 0x1807) for Central
 */
public class NextDstChangeService extends AbstractCentralService {

    /**
     * {@link NextDstChangeServiceCallback} instance
     */
    private final NextDstChangeServiceCallback mNextDstChangeServiceCallback;

    /**
     * @param bleConnection                {@link BLEConnection} instance
     * @param nextDstChangeServiceCallback {@link NextDstChangeServiceCallback} instance
     * @param bleCallback                  {@link BLECallback} instance(optional)
     */
    public NextDstChangeService(@NonNull BLEConnection bleConnection, @NonNull NextDstChangeServiceCallback nextDstChangeServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mNextDstChangeServiceCallback = nextDstChangeServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && NEXT_DST_CHANGE_SERVICE.equals(serviceUUID) && TIME_WITH_DST_CHARACTERISTIC.equals(characteristicUUID)) {
            mNextDstChangeServiceCallback.onTimeWithDstReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, TimeWithDstAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && NEXT_DST_CHANGE_SERVICE.equals(serviceUUID) && TIME_WITH_DST_CHARACTERISTIC.equals(characteristicUUID)) {
            mNextDstChangeServiceCallback.onTimeWithDstReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && NEXT_DST_CHANGE_SERVICE.equals(serviceUUID) && TIME_WITH_DST_CHARACTERISTIC.equals(characteristicUUID)) {
            mNextDstChangeServiceCallback.onTimeWithDstReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * get Next DST Change
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see NextDstChangeServiceCallback#onTimeWithDstReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, TimeWithDstAndroid, Bundle)
     * @see NextDstChangeServiceCallback#onTimeWithDstReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see NextDstChangeServiceCallback#onTimeWithDstReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTimeWithDst() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(NEXT_DST_CHANGE_SERVICE, null, TIME_WITH_DST_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

}
