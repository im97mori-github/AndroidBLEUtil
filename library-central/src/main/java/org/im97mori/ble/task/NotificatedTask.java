package org.im97mori.ble.task;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Message;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEConnection;

import java.util.UUID;

/**
 * Notificated(Indicated) task
 * <p>
 * for central role
 */
public class NotificatedTask extends AbstractBLETask {

    /**
     * task target {@link BLEConnection} instance
     */
    private final BLEConnection mBLEConnection;

    /**
     * task target service {@link UUID}
     */
    private final UUID mServiceUUID;

    /**
     * task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     */
    private final Integer mServiceInstanceId;

    /**
     * task target characteristic {@link UUID}
     */
    private final UUID mCharacteristicUUID;

    /**
     * task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     */
    private final Integer mCharacteristicInstanceId;

    /**
     * task target data
     */
    private final byte[] mByteArray;

    /**
     * @param bleConnection            task target {@link BLEConnection} instance
     * @param serviceUUID              task target service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       task target characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param byteArray                task target data
     */
    public NotificatedTask(@NonNull BLEConnection bleConnection
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull byte[] byteArray) {
        mBLEConnection = bleConnection;
        mServiceUUID = serviceUUID;
        mServiceInstanceId = serviceInstanceId;
        mCharacteristicUUID = characteristicUUID;
        mCharacteristicInstanceId = characteristicInstanceId;
        mByteArray = byteArray;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public Message createInitialMessage() {
        return new Message();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean doProcess(@NonNull Message message) {
        mBLEConnection.getBLECallback().onCharacteristicNotified(mBLEConnection.getBluetoothDevice()
                , mServiceUUID
                , mServiceInstanceId
                , mCharacteristicUUID
                , mCharacteristicInstanceId
                , mByteArray);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBusy() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancel() {
        // do nothing
    }

}
