package org.im97mori.ble.task;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.os.Bundle;
import android.os.Message;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEConnection;

import static org.im97mori.ble.constants.ErrorCodeAndroid.CANCEL;
import static org.im97mori.ble.constants.ErrorCodeAndroid.UNKNOWN;

/**
 * Begin reliable write task
 * <p>
 * for central role
 */
public class BeginReliableWriteTask extends AbstractBLETask {

    /**
     * PROGRESS:BEGIN_RELIABLE_WRITE_START
     */
    public static final String PROGRESS_BEGIN_RELIABLE_WRITE_START = "PROGRESS_BEGIN_RELIABLE_WRITE_START";

    /**
     * PROGRESS:FINISHED
     */
    public static final String PROGRESS_FINISHED = "PROGRESS_FINISHED";
    
    /**
     * task target {@link BLEConnection} instance
     */
    private final BLEConnection mBLEConnection;

    /**
     * task target {@link BluetoothGatt} instance
     */
    private final BluetoothGatt mBluetoothGatt;

    /**
     * callback argument
     */
    private final Bundle mArgument;

    /**
     * @param bleConnection task target {@link BLEConnection} instance
     * @param bluetoothGatt task target {@link BluetoothGatt} instance
     * @param argument      callback argument
     */
    public BeginReliableWriteTask(@NonNull BLEConnection bleConnection
            , @NonNull BluetoothGatt bluetoothGatt
            , @NonNull Bundle argument) {
        mBLEConnection = bleConnection;
        mBluetoothGatt = bluetoothGatt;
        mArgument = argument;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public Message createInitialMessage() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_BEGIN_RELIABLE_WRITE_START);
        Message message = new Message();
        message.setData(bundle);
        message.obj = this;
        return message;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("MissingPermission")
    @Override
    public boolean doProcess(@NonNull Message message) {
        Bundle bundle = message.getData();
        if (bundle.containsKey(KEY_NEXT_PROGRESS)) {
            String nextProgress = bundle.getString(KEY_NEXT_PROGRESS);

            if (this == message.obj && PROGRESS_INIT.equals(mCurrentProgress)) {
                if (PROGRESS_BEGIN_RELIABLE_WRITE_START.equals(nextProgress)) {
                    // current:init, next:begin reliable write start

                    // success
                    if (mBluetoothGatt.beginReliableWrite()) {
                        mBLEConnection.getBLECallback().onBeginReliableWriteSuccess(getTaskId(), mBluetoothGatt.getDevice(), mArgument);
                    } else {
                        mBLEConnection.getBLECallback().onBeginReliableWriteFailed(getTaskId(), mBluetoothGatt.getDevice(), UNKNOWN, mArgument);
                    }

                    mCurrentProgress = PROGRESS_FINISHED;
                }
            }
        }

        return PROGRESS_FINISHED.equals(mCurrentProgress);
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
        mCurrentProgress = PROGRESS_FINISHED;
        mBLEConnection.getBLECallback().onBeginReliableWriteFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), CANCEL, mArgument);
    }

}
