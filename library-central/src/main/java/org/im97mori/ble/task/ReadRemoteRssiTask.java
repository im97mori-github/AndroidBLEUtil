package org.im97mori.ble.task;

import static org.im97mori.ble.constants.ErrorCodeAndroid.CANCEL;
import static org.im97mori.ble.constants.ErrorCodeAndroid.UNKNOWN;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.TaskHandler;

/**
 * Read remote rssi task
 * <p>
 * for central role
 */
public class ReadRemoteRssiTask extends AbstractBLETask {

    /**
     * KEY:RSSI
     */
    public static final String  KEY_RSSI = "KEY_RSSI";

    /**
     * KEY:STATUS
     */
    public static final String  KEY_STATUS = "KEY_STATUS";

    /**
     * PROGRESS:READ_REMOTE_RSSI_START
     */
    public static final String  PROGRESS_READ_REMOTE_RSSI_START = "PROGRESS_READ_REMOTE_RSSI_START";

    /**
     * PROGRESS:READ_REMOTE_RSSI_SUCCESS
     */
    public static final String  PROGRESS_READ_REMOTE_RSSI_SUCCESS = "PROGRESS_READ_REMOTE_RSSI_SUCCESS";

    /**
     * PROGRESS:READ_REMOTE_RSSI_ERROR
     */
    public static final String  PROGRESS_READ_REMOTE_RSSI_ERROR = "PROGRESS_READ_REMOTE_RSSI_ERROR";

    /**
     * PROGRESS:BUSY
     */
    public static final String  PROGRESS_BUSY = "PROGRESS_BUSY";

    /**
     * PROGRESS:FINISHED
     */
    public static final String  PROGRESS_FINISHED = "PROGRESS_FINISHED";

    /**
     * Default timeout(millis) for read remote rssi:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

    /**
     * create read remote rssi success message
     *
     * @param rssi {@link android.bluetooth.BluetoothGattCallback#onReadRemoteRssi(BluetoothGatt, int, int)} 2nd parameter
     * @return read remote rssi success {@link Message} instance
     */
    @NonNull
    public static Message createReadRemoteRssiSuccessMessage(int rssi) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_READ_REMOTE_RSSI_SUCCESS);
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
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_READ_REMOTE_RSSI_ERROR);
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
     * @param taskHandler   task target {@link TaskHandler} instance
     * @param timeout       timeout(millis)
     * @param argument      callback argument
     */
    public ReadRemoteRssiTask(@NonNull BLEConnection bleConnection
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
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_READ_REMOTE_RSSI_START);
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
            if (this == message.obj && PROGRESS_TIMEOUT.equals(nextProgress)) {
                mBLEConnection.getBLECallback().onReadRemoteRssiTimeout(getTaskId(), mBluetoothGatt.getDevice(), mTimeout, mArgument);
                mCurrentProgress = nextProgress;
            } else if (this == message.obj && PROGRESS_INIT.equals(mCurrentProgress)) {
                if (PROGRESS_READ_REMOTE_RSSI_START.equals(nextProgress)) {
                    // current:init, next:read remote rssi start

                    if (mBluetoothGatt.readRemoteRssi()) {
                        // success

                        // set timeout message
                        mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);
                        mCurrentProgress = nextProgress;
                    } else {
                        // failed

                        mBLEConnection.getBLECallback().onReadRemoteRssiFailed(getTaskId(), mBluetoothGatt.getDevice(), UNKNOWN, mArgument);
                        mCurrentProgress = PROGRESS_BUSY;
                    }
                }
            } else if (PROGRESS_READ_REMOTE_RSSI_START.equals(mCurrentProgress)) {
                if (PROGRESS_READ_REMOTE_RSSI_SUCCESS.equals(nextProgress)) {
                    // current:read remote rssi start, next:read remote rssi success

                    // callback
                    mBLEConnection.getBLECallback().onReadRemoteRssiSuccess(getTaskId(), mBluetoothGatt.getDevice(), bundle.getInt(KEY_RSSI), mArgument);


                } else if (PROGRESS_READ_REMOTE_RSSI_ERROR.equals(nextProgress)) {
                    // current:read remote rssi start, next:read remote rssi failed

                    mBLEConnection.getBLECallback().onReadRemoteRssiFailed(getTaskId(), mBluetoothGatt.getDevice(), bundle.getInt(KEY_STATUS), mArgument);
                }

                // remove timeout message
                mTaskHandler.removeCallbacksAndMessages(this);

                mCurrentProgress = PROGRESS_FINISHED;
            }
        }

        return PROGRESS_FINISHED.equals(mCurrentProgress) || PROGRESS_BUSY.equals(mCurrentProgress) || PROGRESS_TIMEOUT.equals(mCurrentProgress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBusy() {
        return PROGRESS_BUSY.equals(mCurrentProgress) || PROGRESS_TIMEOUT.equals(mCurrentProgress);
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
