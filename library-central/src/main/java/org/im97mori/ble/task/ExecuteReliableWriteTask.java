package org.im97mori.ble.task;

import android.bluetooth.BluetoothGatt;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.TaskHandler;

import static org.im97mori.ble.BLEConstants.ErrorCodes.CANCEL;
import static org.im97mori.ble.BLEConstants.ErrorCodes.UNKNOWN;

/**
 * Execute reliable write task
 * <p>
 * for central role
 */
@SuppressWarnings("unused")
public class ExecuteReliableWriteTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for execute reliable write:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

    /**
     * create execute reliable write success message
     *
     * @return execute reliable write success {@link Message} instance
     */
    @NonNull
    public static Message createExecuteReliableWriteSuccessMessage() {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_EXECUTE_RELIABLE_WRITE_SUCCESS);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * create execute reliable write error message
     *
     * @param status {@link android.bluetooth.BluetoothGattCallback#onReliableWriteCompleted(BluetoothGatt, int)} 2nd parameter
     * @return execute reliable write error {@link Message} instance
     */
    @NonNull
    public static Message createExecuteReliableWriteErrorMessage(int status) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_STATUS, status);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_EXECUTE_RELIABLE_WRITE_ERROR);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * task target {@link BLEConnection} instance
     */
    private final BLEConnection mBLEConnection;

    /**
     * task target {@link BluetoothGatt} instance
     */
    private final BluetoothGatt mBluetoothGatt;

    /**
     * task target {@link TaskHandler} instance
     */
    private final TaskHandler mTaskHandler;

    /**
     * timeout(millis)
     */
    private final long mTimeout;

    /**
     * callback argument
     */
    private final Bundle mArgument;


    /**
     * @param bleConnection task target {@link BLEConnection} instance
     * @param bluetoothGatt task target {@link BluetoothGatt} instance
     * @param taskHandler   task target service {@link TaskHandler} instance
     * @param timeout       timeout(millis)
     * @param argument      callback argument
     */
    public ExecuteReliableWriteTask(@NonNull BLEConnection bleConnection
            , @NonNull BluetoothGatt bluetoothGatt
            , @NonNull TaskHandler taskHandler
            , long timeout
            , @NonNull Bundle argument) {
        mBLEConnection = bleConnection;
        mBluetoothGatt = bluetoothGatt;
        mTaskHandler = taskHandler;
        mTimeout = timeout;
        mArgument = argument;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public Message createInitialMessage() {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_EXECUTE_RELIABLE_WRITE_START);
        Message message = new Message();
        message.setData(bundle);
        message.obj = this;
        return message;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean doProcess(@NonNull Message message) {
        Bundle bundle = message.getData();
        int nextProgress = bundle.getInt(KEY_NEXT_PROGRESS);

        // timeout
        if (message.obj == this && PROGRESS_TIMEOUT == nextProgress) {
            mBLEConnection.getBLECallback().onExecuteReliableWriteTimeout(getTaskId(), mBLEConnection.getBluetoothDevice(), mTimeout, mArgument);
            mCurrentProgress = nextProgress;
        } else if (this == message.obj && PROGRESS_INIT == mCurrentProgress) {
            if (PROGRESS_EXECUTE_RELIABLE_WRITE_START == nextProgress) {
                // current:init, next:execute reliable write start

                // success
                if (mBluetoothGatt.executeReliableWrite()) {
                    // set timeout message
                    mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);
                } else {
                    mBLEConnection.getBLECallback().onExecuteReliableWriteFailed(getTaskId(), mBluetoothGatt.getDevice(), UNKNOWN, mArgument);
                    nextProgress = PROGRESS_BUSY;
                }

                mCurrentProgress = nextProgress;
            }
        } else if (PROGRESS_EXECUTE_RELIABLE_WRITE_START == mCurrentProgress) {
            if (PROGRESS_EXECUTE_RELIABLE_WRITE_SUCCESS == nextProgress) {
                // current:execute reliable write start, next:execute reliable write success

                // callback
                mBLEConnection.getBLECallback().onExecuteReliableWriteSuccess(getTaskId(), mBluetoothGatt.getDevice(), mArgument);

            } else if (PROGRESS_EXECUTE_RELIABLE_WRITE_ERROR == nextProgress) {
                // current:execute reliable write start, next:execute reliable write failed

                mBLEConnection.getBLECallback().onExecuteReliableWriteFailed(getTaskId(), mBluetoothGatt.getDevice(), bundle.getInt(KEY_STATUS), mArgument);
            }

            // remove timeout message
            mTaskHandler.removeCallbacksAndMessages(this);

            mCurrentProgress = PROGRESS_FINISHED;
        }

        return PROGRESS_FINISHED == mCurrentProgress || PROGRESS_BUSY == mCurrentProgress || PROGRESS_TIMEOUT == mCurrentProgress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBusy() {
        return PROGRESS_BUSY == mCurrentProgress || PROGRESS_TIMEOUT == mCurrentProgress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancel() {
        mCurrentProgress = PROGRESS_FINISHED;
        mBLEConnection.getBLECallback().onExecuteReliableWriteFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), CANCEL, mArgument);
    }

}
