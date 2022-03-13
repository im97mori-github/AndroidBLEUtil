package org.im97mori.ble.task;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLELogUtils;
import org.im97mori.ble.TaskHandler;

/**
 * Connect to {@link BluetoothDevice} task
 * <p>
 * for central role
 */
public class ConnectTask extends AbstractBLETask {

    /**
     * STATUS:CANCEL
     */
    public static final int STATUS_CANCEL = -1;

    /**
     * STATUS:CONNECT_GATT_FAILED
     */
    public static final int STATUS_CONNECT_GATT_FAILED = -2;

    /**
     * STATUS:DISCOVER_SERVICES_FAILED
     */
    public static final int STATUS_DISCOVER_SERVICES_FAILED = -3;

    /**
     * Default timeout(millis) for connect:30sec
     */
    public static final long TIMEOUT_MILLIS = DiscoverServiceTask.TIMEOUT_MILLIS;

    /**
     * KEY:STATUS
     */
    public static final String KEY_STATUS = "KEY_STATUS";

    /**
     * PROGRESS:CONNECT
     */
    public static final String PROGRESS_CONNECT = "PROGRESS_CONNECT";

    /**
     * PROGRESS:CONNECT_SUCCESS
     */
    public static final String PROGRESS_CONNECT_SUCCESS = "PROGRESS_CONNECT_SUCCESS";

    /**
     * PROGRESS:DISCOVER_SERVICE_SUCCESS
     */
    public static final String PROGRESS_DISCOVER_SERVICE_SUCCESS = "PROGRESS_DISCOVER_SERVICE_SUCCESS";

    /**
     * PROGRESS:DISCOVER_SERVICE_ERROR
     */
    public static final String PROGRESS_DISCOVER_SERVICE_ERROR = "PROGRESS_DISCOVER_SERVICE_ERROR";

    /**
     * PROGRESS:REQUEST_MTU_SUCCESS
     */
    public static final String PROGRESS_REQUEST_MTU_SUCCESS = "PROGRESS_REQUEST_MTU_SUCCESS";

    /**
     * PROGRESS:REQUEST_MTU_ERROR
     */
    public static final String PROGRESS_REQUEST_MTU_ERROR = "PROGRESS_REQUEST_MTU_ERROR";

    /**
     * PROGRESS:FINISHED
     */
    public static final String PROGRESS_FINISHED = "PROGRESS_FINISHED";

    /**
     * create connect success message
     *
     * @param obj current {@link BluetoothGatt} instance
     * @return create connect success {@link Message} instance
     */
    @NonNull
    public static Message createConnectSuccessMessage(@NonNull Object obj) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_CONNECT_SUCCESS);
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
     * task target {@link TaskHandler} instance
     */
    private final TaskHandler mTaskHandler;


    /**
     * {@code true}:try 512 octet mtu setting, {@code false}:no mtu setting
     */
    private final boolean mNeedMtuSetting;

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
    private BluetoothGatt mBluetoothGatt;


    /**
     * @param bleConnection  task target {@link BLEConnection} instance
     * @param taskHandler    task target {@link TaskHandler} instance
     * @param needMtuSetting {@code true}:try 512octet mtu setting, {@code false}:no mtu setting
     * @param timeout        timeout(millis)
     * @param argument       callback argument
     */
    public ConnectTask(@NonNull BLEConnection bleConnection
            , @NonNull TaskHandler taskHandler
            , boolean needMtuSetting
            , long timeout
            , @NonNull Bundle argument) {
        mBLEConnection = bleConnection;
        mTaskHandler = taskHandler;
        if (Build.VERSION_CODES.LOLLIPOP <= Build.VERSION.SDK_INT && needMtuSetting) {
            mTimeout = timeout + RequestMtuTask.TIMEOUT_MILLIS;
        } else {
            mTimeout = timeout;
        }
        mNeedMtuSetting = needMtuSetting;
        mArgument = argument;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public Message createInitialMessage() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_CONNECT);
        Message message = new Message();
        message.setData(bundle);
        message.obj = this;
        return message;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint({"ObsoleteSdkInt", "MissingPermission"})
    @Override
    public boolean doProcess(@NonNull Message message) {
        // if connected, finish task
        if (mBLEConnection.isConnected()) {
            mTaskHandler.removeCallbacksAndMessages(this);
            mCurrentProgress = PROGRESS_FINISHED;
        } else {
            Bundle bundle = message.getData();
            if (bundle.containsKey(KEY_NEXT_PROGRESS)) {
                String nextProgress = bundle.getString(KEY_NEXT_PROGRESS);

                // timeout
                if (this == message.obj && PROGRESS_TIMEOUT.equals(nextProgress)) {

                    // disconnect current target
                    if (mBluetoothGatt != null) {
                        try {
                            mBluetoothGatt.disconnect();
                        } catch (Exception e) {
                            BLELogUtils.stackLog(e);
                        }
                        try {
                            mBluetoothGatt.close();
                        } catch (Exception e) {
                            BLELogUtils.stackLog(e);
                        }
                    }

                    mBLEConnection.onConnectTimeout(getTaskId(), mArgument);

                    mCurrentProgress = nextProgress;
                } else if (this == message.obj && PROGRESS_INIT.equals(mCurrentProgress)) {
                    // current:init, next:connect
                    if (PROGRESS_CONNECT.equals(nextProgress)) {

                        // create gatt connection
                        try {
                            mBluetoothGatt = mBLEConnection.getBluetoothDevice().connectGatt(mBLEConnection.getContext(), false, mBLEConnection);
                        } catch (Exception e) {
                            BLELogUtils.stackLog(e);
                        }

                        // connect failed
                        if (mBluetoothGatt == null) {
                            mBLEConnection.onConnectFailed(getTaskId()
                                    , STATUS_CONNECT_GATT_FAILED
                                    , mArgument);
                            mCurrentProgress = PROGRESS_FINISHED;
                        } else {
                            // connecting

                            // set timeout message
                            mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);
                            mCurrentProgress = nextProgress;
                        }
                    }
                } else if (PROGRESS_CONNECT.equals(mCurrentProgress)) {
                    if (mBluetoothGatt == message.obj && PROGRESS_CONNECT_SUCCESS.equals(nextProgress)) {
                        // current:connect, next:discover service

                        // start discover services
                        if (!mBluetoothGatt.discoverServices()) {
                            // failed

                            mBLEConnection.onConnectFailed(getTaskId()
                                    , STATUS_DISCOVER_SERVICES_FAILED
                                    , mArgument);
                            // remove timeout message
                            mTaskHandler.removeCallbacksAndMessages(this);

                            // add disconnect task
                            DisconnectTask task = new DisconnectTask(mBLEConnection, mBluetoothGatt, mArgument);
                            mTaskHandler.addTask(task);

                            nextProgress = PROGRESS_FINISHED;
                        }
                        mCurrentProgress = nextProgress;
                    }
                } else if (PROGRESS_CONNECT_SUCCESS.equals(mCurrentProgress)) {
                    if (mBluetoothGatt == message.obj && PROGRESS_DISCOVER_SERVICE_SUCCESS.equals(nextProgress)) {
                        // current:connect, next:service discovered

                        // auto mtu setting
                        if (mNeedMtuSetting) {
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP || !mBluetoothGatt.requestMtu(RequestMtuTask.MAXIMUM_MTU)) {
                                nextProgress = PROGRESS_FINISHED;
                            }
                        } else {
                            nextProgress = PROGRESS_FINISHED;
                        }

                        if (PROGRESS_FINISHED.equals(nextProgress)) {
                            // callback
                            mBLEConnection.onConnected(getTaskId()
                                    , mBluetoothGatt
                                    , mArgument);

                            // remove timeout message
                            mTaskHandler.removeCallbacksAndMessages(this);
                        }
                        mCurrentProgress = nextProgress;
                    } else if (mBluetoothGatt == message.obj && PROGRESS_DISCOVER_SERVICE_ERROR.equals(nextProgress)) {
                        // failed

                        int status = bundle.getInt(KEY_STATUS);
                        mBLEConnection.onConnectFailed(getTaskId()
                                , status
                                , mArgument);

                        // remove timeout message
                        mTaskHandler.removeCallbacksAndMessages(this);

                        // add disconnect task
                        DisconnectTask task = new DisconnectTask(mBLEConnection, mBluetoothGatt, status, mArgument);
                        mTaskHandler.addTask(task);
                    }
                } else if (PROGRESS_DISCOVER_SERVICE_SUCCESS.equals(mCurrentProgress)) {
                    if (mBluetoothGatt == message.obj && PROGRESS_REQUEST_MTU_SUCCESS.equals(nextProgress)) {
                        // current:service discovered, next:finish(connected)

                        // callback
                        mBLEConnection.onConnected(getTaskId()
                                , mBluetoothGatt
                                , mArgument);

                    } else if (mBluetoothGatt == message.obj && PROGRESS_REQUEST_MTU_ERROR.equals(nextProgress)) {
                        // failed

                        mBLEConnection.onConnectFailed(getTaskId()
                                , bundle.getInt(KEY_STATUS)
                                , mArgument);
                    }

                    // remove timeout message
                    mTaskHandler.removeCallbacksAndMessages(this);

                    mCurrentProgress = PROGRESS_FINISHED;
                }
            }
        }

        return PROGRESS_FINISHED.equals(mCurrentProgress) || PROGRESS_TIMEOUT.equals(mCurrentProgress);
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
        mTaskHandler.removeCallbacksAndMessages(this);
        mCurrentProgress = PROGRESS_FINISHED;
        mBLEConnection.onConnectFailed(getTaskId()
                , STATUS_CANCEL
                , mArgument);
    }

}
