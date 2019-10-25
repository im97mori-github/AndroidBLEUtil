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
 * Read remote rssi task
 * <p>
 * for central role
 */
@SuppressWarnings("unused")
public class ReadRemoteRssiTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for discover service:5sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 5;

    /**
     * create read remote rssi success message
     *
     * @param rssi {@link android.bluetooth.BluetoothGattCallback#onReadRemoteRssi(BluetoothGatt, int, int)} 2nd parameter
     * @return read remote rssi success {@link Message} instance
     */
    @NonNull
    public static Message createReadRemoteRssiSuccessMessage(int rssi) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_READ_REMOTE_RSSI_SUCCESS);
        bundle.putInt(KEY_RSSI, rssi);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * create read remote rssi error message
     *
     * @param status {@link android.bluetooth.BluetoothGattCallback#onReadRemoteRssi(BluetoothGatt, int, int)} 3rd parameter
     * @return read remote rssi error {@link Message} instance
     */
    @NonNull
    public static Message createReadRemoteRssiErrorMessage(int status) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_STATUS, status);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_READ_REMOTE_RSSI_ERROR);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * task target {@link BLEConnection} instance
     */
    private final BLEConnection mBLEConnection;

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
     * task target {@link BluetoothGatt} instance
     */
    private final BluetoothGatt mBluetoothGatt;

    /**
     * @param bleConnection task target {@link BLEConnection} instance
     * @param bluetoothGatt task target {@link BluetoothGatt} instance
     * @param taskHandler   task target {@link TaskHandler} instance
     * @param timeout       timeout(millis)
     * @param argument      callback argument
     */
    public ReadRemoteRssiTask(@NonNull BLEConnection bleConnection, @NonNull BluetoothGatt bluetoothGatt, @NonNull TaskHandler taskHandler, long timeout, @NonNull Bundle argument) {
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
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_READ_REMOTE_RSSI_START);
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
        if (this == message.obj && PROGRESS_TIMEOUT == nextProgress) {
            mBLEConnection.getBLECallback().onReadRemoteRssiTimeout(getTaskId(), mBluetoothGatt.getDevice(), mTimeout, mArgument);
            mCurrentProgress = nextProgress;
        } else if (this == message.obj && PROGRESS_INIT == mCurrentProgress) {
            if (PROGRESS_READ_REMOTE_RSSI_START == nextProgress) {
                // current:init, next:read remote rssi start

                if (mBluetoothGatt.readRemoteRssi()) {
                    // success
                    // set timeout message
                    Message timeoutMessage = createTimeoutMessage(this);
                    mTaskHandler.sendProcessingMessage(timeoutMessage, mTimeout);
                    mCurrentProgress = nextProgress;
                } else {
                    // failed

                    mBLEConnection.getBLECallback().onReadRemoteRssiFailed(getTaskId(), mBluetoothGatt.getDevice(), UNKNOWN, mArgument);
                    mCurrentProgress = PROGRESS_BUSY;
                }
            }
        } else if (PROGRESS_READ_REMOTE_RSSI_START == mCurrentProgress) {
            if (PROGRESS_READ_REMOTE_RSSI_SUCCESS == nextProgress) {
                // current:read remote rssi start, next:read remote rssi success

                // callback
                mBLEConnection.getBLECallback().onReadRemoteRssiSuccess(getTaskId(), mBluetoothGatt.getDevice(), bundle.getInt(KEY_RSSI), mArgument);


            } else if (PROGRESS_READ_REMOTE_RSSI_ERROR == nextProgress) {
                // current:read remote rssi start, next:read remote rssi failed

                mBLEConnection.getBLECallback().onReadRemoteRssiFailed(getTaskId(), mBluetoothGatt.getDevice(), bundle.getInt(KEY_STATUS), mArgument);
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
        mTaskHandler.removeCallbacksAndMessages(this);
        mCurrentProgress = PROGRESS_FINISHED;
        mBLEConnection.getBLECallback().onReadRemoteRssiFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), CANCEL, mArgument);
    }

}
