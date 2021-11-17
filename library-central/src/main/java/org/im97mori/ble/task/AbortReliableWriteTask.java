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
     * KEY:STATUS
     */
    public static final String KEY_STATUS = "KEY_STATUS";
    
    /**
     * PROGRESS:ABORT_RELIABLE_WRITE_START
     */
    public static final String PROGRESS_ABORT_RELIABLE_WRITE_START = "PROGRESS_ABORT_RELIABLE_WRITE_START";

    /**
     * PROGRESS:FINISHED
     */
    public static final String PROGRESS_FINISHED = "PROGRESS_FINISHED";

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
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_ABORT_RELIABLE_WRITE_START);
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

            // timeout
            if (message.obj == this && PROGRESS_TIMEOUT.equals(nextProgress)) {
                mBLEConnection.getBLECallback().onAbortReliableWriteTimeout(getTaskId(), mBLEConnection.getBluetoothDevice(), mTimeout, mArgument);
                mCurrentProgress = nextProgress;
            } else if (this == message.obj && PROGRESS_INIT.equals(mCurrentProgress)) {
                if (PROGRESS_ABORT_RELIABLE_WRITE_START.equals(nextProgress)) {
                    // current:init, next:abort reliable write start

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        mBluetoothGatt.abortReliableWrite();
                    } else {
                        mBluetoothGatt.abortReliableWrite(mBluetoothGatt.getDevice());
                    }

                    // set timeout message
                    mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);

                    mCurrentProgress = nextProgress;
                }
            } else if (PROGRESS_ABORT_RELIABLE_WRITE_START.equals(mCurrentProgress)) {
                if (ExecuteReliableWriteTask.PROGRESS_EXECUTE_RELIABLE_WRITE_SUCCESS.equals(nextProgress)) {
                    // current:abort reliable write start, next:abort reliable write success

                    // callback
                    mBLEConnection.getBLECallback().onAbortReliableWriteSuccess(getTaskId(), mBluetoothGatt.getDevice(), mArgument);

                } else if (ExecuteReliableWriteTask.PROGRESS_EXECUTE_RELIABLE_WRITE_ERROR.equals(nextProgress)) {
                    // current:abort reliable write start, next:abort reliable write failed

                    mBLEConnection.getBLECallback().onAbortReliableWriteFailed(getTaskId(), mBluetoothGatt.getDevice(), bundle.getInt(KEY_STATUS), mArgument);
                }

                // remove timeout message
                mTaskHandler.removeCallbacksAndMessages(this);

                mCurrentProgress = PROGRESS_FINISHED;
            }
        }

        return PROGRESS_FINISHED.equals(mCurrentProgress) || PROGRESS_TIMEOUT.equals(mCurrentProgress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBusy() {
        return PROGRESS_TIMEOUT.equals(mCurrentProgress);
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
