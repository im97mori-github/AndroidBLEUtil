package org.im97mori.ble.task;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.TaskHandler;

/**
 * Discover service task
 * <p>
 * for central role
 */
public class DiscoverServiceTask extends AbstractBLETask {

    /**
     * STATUS:CANCEL
     */
    public static final int STATUS_CANCEL = -1;

    /**
     * STATUS:DISCOVER_SERVICES_FAILED
     */
    public static final int STATUS_DISCOVER_SERVICES_FAILED = -2;

    /**
     * KEY:STATUS
     */
    public static final String KEY_STATUS = "KEY_STATUS";

    /**
     * PROGRESS:BUSY
     */
    public static final String PROGRESS_BUSY = "PROGRESS_BUSY";

    /**
     * PROGRESS:DISCOVER_SERVICE_START
     */
    public static final String PROGRESS_DISCOVER_SERVICE_START = "PROGRESS_DISCOVER_SERVICE_START";

    /**
     * PROGRESS:DISCOVER_SERVICE_SUCCESS
     */
    public static final String PROGRESS_DISCOVER_SERVICE_SUCCESS = "PROGRESS_DISCOVER_SERVICE_SUCCESS";

    /**
     * PROGRESS:DISCOVER_SERVICE_ERROR
     */
    public static final String PROGRESS_DISCOVER_SERVICE_ERROR = "PROGRESS_DISCOVER_SERVICE_ERROR";

    /**
     * PROGRESS:FINISHED
     */
    public static final String PROGRESS_FINISHED = "PROGRESS_FINISHED";

    /**
     * Default timeout(millis) for discover service:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

    /**
     * create discover service success message
     *
     * @param obj current {@link BluetoothGatt} instance
     * @return discover service success {@link Message} instance
     */
    @NonNull
    public static Message createDiscoverServiceSuccessMessage(Object obj) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_DISCOVER_SERVICE_SUCCESS);
        Message message = new Message();
        message.setData(bundle);
        message.obj = obj;
        return message;
    }

    /**
     * create discover service error message
     *
     * @param obj    current {@link BluetoothGatt} instance
     * @param status {@link android.bluetooth.BluetoothGattCallback#onServicesDiscovered(BluetoothGatt, int)} 2nd parameter
     * @return discover service error {@link Message} instance
     */
    @NonNull
    public static Message createDiscoverServiceErrorMessage(Object obj, int status) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_STATUS, status);
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_DISCOVER_SERVICE_ERROR);
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
    public DiscoverServiceTask(@NonNull BLEConnection bleConnection
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
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_DISCOVER_SERVICE_START);
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
                mBLEConnection.getBLECallback().onDiscoverServiceTimeout(getTaskId()
                        , mBluetoothGatt.getDevice()
                        , mTimeout
                        , mArgument);
                mCurrentProgress = nextProgress;
            } else if (this == message.obj && PROGRESS_INIT.equals(mCurrentProgress)) {
                if (PROGRESS_DISCOVER_SERVICE_START.equals(nextProgress)) {
                    // current:init, next:discover service start

                    if (mBluetoothGatt.discoverServices()) {
                        // success
                        // set timeout message
                        mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);
                        mCurrentProgress = nextProgress;
                    } else {
                        // failed

                        mBLEConnection.getBLECallback().onDiscoverServiceFailed(getTaskId()
                                , mBluetoothGatt.getDevice()
                                , STATUS_DISCOVER_SERVICES_FAILED
                                , mArgument);
                        mCurrentProgress = PROGRESS_BUSY;
                    }
                }
            } else if (PROGRESS_DISCOVER_SERVICE_START.equals(mCurrentProgress)) {
                if (PROGRESS_DISCOVER_SERVICE_SUCCESS.equals(nextProgress)) {
                    // current:discover service start, next:discover service success

                    // callback
                    mBLEConnection.getBLECallback().onDiscoverServiceSuccess(getTaskId()
                            , mBluetoothGatt.getDevice()
                            , mBluetoothGatt.getServices()
                            , mArgument);


                } else if (PROGRESS_DISCOVER_SERVICE_ERROR.equals(nextProgress)) {
                    // current:discover service start, next:discover service failed

                    mBLEConnection.getBLECallback().onDiscoverServiceFailed(getTaskId()
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
        mBLEConnection.getBLECallback().onDiscoverServiceFailed(getTaskId()
                , mBLEConnection.getBluetoothDevice()
                , STATUS_CANCEL
                , mArgument);
    }

}
