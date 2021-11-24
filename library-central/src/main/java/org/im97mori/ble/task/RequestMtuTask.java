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

/**
 * Request mtu task
 * <p>
 * for central role
 */
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class RequestMtuTask extends AbstractBLETask {

    /**
     * STATUS:CANCEL
     */
    public static final int STATUS_CANCEL = -1;

    /**
     * STATUS:REQUEST_MTU_FAILED
     */
    public static final int STATUS_REQUEST_MTU_FAILED = -2;
    /**
     * KEY:MTU
     */
    public static final String KEY_MTU = "KEY_MTU";

    /**
     * KEY:STATUS
     */
    public static final String KEY_STATUS = "KEY_STATUS";

    /**
     * PROGRESS:REQUEST_MTU_START
     */
    public static final String PROGRESS_REQUEST_MTU_START = "PROGRESS_REQUEST_MTU_START";

    /**
     * PROGRESS:REQUEST_MTU_SUCCESS
     */
    public static final String PROGRESS_REQUEST_MTU_SUCCESS = "PROGRESS_REQUEST_MTU_SUCCESS";

    /**
     * PROGRESS:REQUEST_MTU_ERROR
     */
    public static final String PROGRESS_REQUEST_MTU_ERROR = "PROGRESS_REQUEST_MTU_ERROR";

    /**
     * PROGRESS:BUSY
     */
    public static final String PROGRESS_BUSY = "PROGRESS_BUSY";

    /**
     * PROGRESS:FINISHED
     */
    public static final String PROGRESS_FINISHED = "PROGRESS_FINISHED";

    /**
     * Maximum MTU size
     * <p>
     * Core Specification v5.3 Vol 3 Part F 3.2.9
     */
    public static final int MAXIMUM_MTU = 512;

    /**
     * Default timeout(millis) for request mtu:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

    /**
     * create request mtu success message
     *
     * @param mtu {@link android.bluetooth.BluetoothGattCallback#onMtuChanged(BluetoothGatt, int, int)} 2nd parameter
     * @return request mtu success {@link Message} instance
     */
    @NonNull
    public static Message createRequestMtuSuccessMessage(int mtu) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_MTU, mtu);
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_REQUEST_MTU_SUCCESS);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * create request mtu error message
     *
     * @param obj    current {@link BluetoothGatt} instance
     * @param status {@link android.bluetooth.BluetoothGattCallback#onMtuChanged(BluetoothGatt, int, int)} 3rd parameter
     * @return request mtu error {@link Message} instance
     */
    @NonNull
    public static Message createRequestMtuErrorMessage(Object obj, int status) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_STATUS, status);
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_REQUEST_MTU_ERROR);
        Message message = new Message();
        message.setData(bundle);
        message.obj = obj;
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
     * new mtu for {@link BluetoothGatt#requestMtu(int)} 1st argument
     */
    private final int mMtu;

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
     * @param mtu           new mtu for {@link BluetoothGatt#requestMtu(int)} 1st argument
     * @param timeout       timeout(millis)
     * @param argument      callback argument
     */
    public RequestMtuTask(@NonNull BLEConnection bleConnection
            , @NonNull BluetoothGatt bluetoothGatt
            , @NonNull TaskHandler taskHandler
            , int mtu
            , long timeout
            , @NonNull Bundle argument) {
        mBLEConnection = bleConnection;
        mBluetoothGatt = bluetoothGatt;
        mTaskHandler = taskHandler;
        mMtu = mtu;
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
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_REQUEST_MTU_START);
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

                mBLEConnection.getBLECallback().onRequestMtuTimeout(getTaskId(), mBluetoothGatt.getDevice(), mTimeout, mArgument);

                mCurrentProgress = nextProgress;
            } else if (this == message.obj && PROGRESS_INIT.equals(mCurrentProgress)) {
                if (PROGRESS_REQUEST_MTU_START.equals(nextProgress)) {
                    // current:init, next:request mtu start

                    // success
                    if (mBluetoothGatt.requestMtu(mMtu)) {
                        // set timeout message
                        mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);
                    } else {
                        // failed
                        mBLEConnection.getBLECallback().onRequestMtuFailed(getTaskId()
                                , mBluetoothGatt.getDevice()
                                , STATUS_REQUEST_MTU_FAILED
                                , mArgument);
                        nextProgress = PROGRESS_BUSY;
                    }

                    mCurrentProgress = nextProgress;
                }
            } else if (PROGRESS_REQUEST_MTU_START.equals(mCurrentProgress)) {
                if (PROGRESS_REQUEST_MTU_SUCCESS.equals(nextProgress)) {
                    // current:request mtu start, next:request mtu success

                    // callback
                    mBLEConnection.getBLECallback().onRequestMtuSuccess(getTaskId()
                            , mBluetoothGatt.getDevice()
                            , bundle.getInt(KEY_MTU)
                            , mArgument);

                } else if (PROGRESS_REQUEST_MTU_ERROR.equals(nextProgress)) {
                    // current:request mtu start, next:request mtu failed

                    mBLEConnection.getBLECallback().onRequestMtuFailed(getTaskId()
                            , mBluetoothGatt.getDevice()
                            , bundle.getInt(KEY_STATUS)
                            , mArgument);
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
        mBLEConnection.getBLECallback().onRequestMtuFailed(getTaskId()
                , mBLEConnection.getBluetoothDevice()
                , STATUS_CANCEL
                , mArgument);
    }

}
