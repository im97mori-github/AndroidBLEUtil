package org.im97mori.ble.service.rtus.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a16.TimeUpdateControlPoint;
import org.im97mori.ble.characteristic.u2a16.TimeUpdateControlPointAndroid;
import org.im97mori.ble.characteristic.u2a17.TimeUpdateStateAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.WriteCharacteristicTask;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TIME_UPDATE_STATE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.ServiceUUID.REFERENCE_TIME_UPDATE_SERVICE;

/**
 * Current Time Service (Service UUID: 0x1805) for Central
 */
public class ReferenceTimeUpdateService extends AbstractCentralService {

    /**
     * {@link ReferenceTimeUpdateServiceCallback} instance
     */
    private final ReferenceTimeUpdateServiceCallback mReferenceTimeUpdateServiceCallback;

    /**
     * @param bleConnection                      {@link BLEConnection} instance
     * @param referenceTimeUpdateServiceCallback {@link ReferenceTimeUpdateServiceCallback} instance
     * @param bleCallback                        {@link BLECallback} instance(optional)
     */
    public ReferenceTimeUpdateService(@NonNull BLEConnection bleConnection, @NonNull ReferenceTimeUpdateServiceCallback referenceTimeUpdateServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mReferenceTimeUpdateServiceCallback = referenceTimeUpdateServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && REFERENCE_TIME_UPDATE_SERVICE.equals(serviceUUID) && TIME_UPDATE_STATE_CHARACTERISTIC.equals(characteristicUUID)) {
            mReferenceTimeUpdateServiceCallback.onTimeUpdateStateReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, TimeUpdateStateAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && REFERENCE_TIME_UPDATE_SERVICE.equals(serviceUUID) && TIME_UPDATE_STATE_CHARACTERISTIC.equals(characteristicUUID)) {
            mReferenceTimeUpdateServiceCallback.onTimeUpdateStateReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && REFERENCE_TIME_UPDATE_SERVICE.equals(serviceUUID) && TIME_UPDATE_STATE_CHARACTERISTIC.equals(characteristicUUID)) {
            mReferenceTimeUpdateServiceCallback.onTimeUpdateStateReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && REFERENCE_TIME_UPDATE_SERVICE.equals(serviceUUID) && TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
            mReferenceTimeUpdateServiceCallback.onTimeUpdateControlPointWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, TimeUpdateControlPointAndroid.CREATOR.createFromByteArray(values), argument);
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && REFERENCE_TIME_UPDATE_SERVICE.equals(serviceUUID) && TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
            mReferenceTimeUpdateServiceCallback.onTimeUpdateControlPointWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && REFERENCE_TIME_UPDATE_SERVICE.equals(serviceUUID) && TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
            mReferenceTimeUpdateServiceCallback.onTimeUpdateControlPointWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * set Time Update Control Point
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see ReferenceTimeUpdateServiceCallback#onTimeUpdateControlPointWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, TimeUpdateControlPointAndroid, Bundle)
     * @see ReferenceTimeUpdateServiceCallback#onTimeUpdateControlPointWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see ReferenceTimeUpdateServiceCallback#onTimeUpdateControlPointWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setTimeUpdateControlPoint(@NonNull TimeUpdateControlPoint timeUpdateControlPoint) {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(REFERENCE_TIME_UPDATE_SERVICE, null, TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC, null, timeUpdateControlPoint, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }


    /**
     * get Time Update State
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see ReferenceTimeUpdateServiceCallback#onTimeUpdateStateReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, TimeUpdateStateAndroid, Bundle)
     * @see ReferenceTimeUpdateServiceCallback#onTimeUpdateStateReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see ReferenceTimeUpdateServiceCallback#onTimeUpdateStateReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTimeUpdateState() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(REFERENCE_TIME_UPDATE_SERVICE, null, TIME_UPDATE_STATE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

}
