package org.im97mori.ble.task;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.TaskHandler;

import static org.im97mori.ble.constants.ErrorCodeAndroid.CANCEL;

/**
 * Abort reliable write task
 * <p>
 * for central role
 */
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class AbortReliableWriteTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for request mtu:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

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
    public AbortReliableWriteTask(@NonNull BLEConnection bleConnection
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
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_ABORT_RELIABLE_WRITE_START);
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
            int nextProgress = bundle.getInt(KEY_NEXT_PROGRESS);

            // timeout
            if (message.obj == this && PROGRESS_TIMEOUT == nextProgress) {
                mBLEConnection.getBLECallback().onAbortReliableWriteTimeout(getTaskId(), mBLEConnection.getBluetoothDevice(), mTimeout, mArgument);
                mCurrentProgress = nextProgress;
            } else if (this == message.obj && PROGRESS_INIT == mCurrentProgress) {
                if (PROGRESS_ABORT_RELIABLE_WRITE_START == nextProgress) {
                    // current:init, next:abort reliable write start

                    mBluetoothGatt.abortReliableWrite();

                    // set timeout message
                    mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);

                    mCurrentProgress = nextProgress;
                }
            } else if (PROGRESS_ABORT_RELIABLE_WRITE_START == mCurrentProgress) {
                if (PROGRESS_EXECUTE_RELIABLE_WRITE_SUCCESS == nextProgress) {
                    // current:abort reliable write start, next:abort reliable write success

                    // callback
                    mBLEConnection.getBLECallback().onAbortReliableWriteSuccess(getTaskId(), mBluetoothGatt.getDevice(), mArgument);

                } else if (PROGRESS_EXECUTE_RELIABLE_WRITE_ERROR == nextProgress) {
                    // current:abort reliable write start, next:abort reliable write failed

                    mBLEConnection.getBLECallback().onAbortReliableWriteFailed(getTaskId(), mBluetoothGatt.getDevice(), bundle.getInt(KEY_STATUS), mArgument);
                }

                // remove timeout message
                mTaskHandler.removeCallbacksAndMessages(this);

                mCurrentProgress = PROGRESS_FINISHED;
            }
        }

        return PROGRESS_FINISHED == mCurrentProgress || PROGRESS_TIMEOUT == mCurrentProgress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBusy() {
        return PROGRESS_TIMEOUT == mCurrentProgress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancel() {
        mCurrentProgress = PROGRESS_FINISHED;
        mBLEConnection.getBLECallback().onAbortReliableWriteFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), CANCEL, mArgument);
    }

}
