package org.im97mori.ble.task;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConstants;
import org.im97mori.ble.BLELogUtils;
import org.im97mori.ble.TaskHandler;

import static org.im97mori.ble.BLEConstants.ErrorCodes.CANCEL;
import static org.im97mori.ble.BLEConstants.ErrorCodes.UNKNOWN;

/**
 * Connect to {@link BluetoothDevice} task
 * <p>
 * for central role
 */
@SuppressWarnings("unused")
public class ConnectTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for connect:50sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 50;

    /**
     * create connect success message
     *
     * @param obj current {@link BluetoothGatt} instance
     * @return create connect success {@link Message} instance
     */
    @NonNull
    public static Message createConnectSuccessMessage(@NonNull Object obj) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_CONNECT_SUCCESS);
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
     * timeout(millis)
     */
    private final long mTimeout;

    /**
     * callback argument
     */
    private final Bundle mArgument;

    /**
     * {@code true}:try 512octed mtu setting, {@code false}:no mtu setting
     */
    private final boolean mNeedMtuSetting;

    /**
     * task target {@link BluetoothGatt} instance
     */
    private BluetoothGatt mBluetoothGatt;


    /**
     * @param bleConnection  task target {@link BLEConnection} instance
     * @param taskHandler    task target {@link TaskHandler} instance
     * @param needMtuSetting {@code true}:try 512octed mtu setting, {@code false}:no mtu setting
     * @param timeout        timeout(millis)
     * @param argument       callback argument
     */
    public ConnectTask(@NonNull BLEConnection bleConnection, @NonNull TaskHandler taskHandler, boolean needMtuSetting, long timeout, @NonNull Bundle argument) {
        mBLEConnection = bleConnection;
        mTaskHandler = taskHandler;
        mTimeout = timeout;
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
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_CONNECT);
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
        // if connected, finish task
        if (mBLEConnection.isConnected()) {
            mTaskHandler.removeCallbacksAndMessages(this);
            mCurrentProgress = PROGRESS_FINISHED;
        } else {
            Bundle bundle = message.getData();
            int nextProgress = bundle.getInt(KEY_NEXT_PROGRESS);

            // timeout
            if (this == message.obj && PROGRESS_TIMEOUT == nextProgress) {

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
            } else if (this == message.obj && PROGRESS_INIT == mCurrentProgress) {
                // current:init, next:connect
                if (PROGRESS_CONNECT == nextProgress) {

                    // create gatt connection
                    try {
                        mBluetoothGatt = mBLEConnection.getBluetoothDevice().connectGatt(mBLEConnection.getContext(), false, mBLEConnection);
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }

                    // connect failed
                    if (mBluetoothGatt == null) {
                        mBLEConnection.onConnectFailed(getTaskId(), UNKNOWN, mArgument);
                        mCurrentProgress = PROGRESS_FINISHED;
                    } else {
                        // connecting

                        // set timeout message
                        Message timeoutMessage = createTimeoutMessage(this);
                        mTaskHandler.sendProcessingMessage(timeoutMessage, mTimeout);
                        mCurrentProgress = nextProgress;
                    }
                }
            } else if (PROGRESS_CONNECT == mCurrentProgress) {
                if (mBluetoothGatt == message.obj && PROGRESS_CONNECT_SUCCESS == nextProgress) {
                    // current:connect, next:discover service

                    // start discover services
                    if (!mBluetoothGatt.discoverServices()) {
                        // failed

                        mBLEConnection.onConnectFailed(getTaskId(), UNKNOWN, mArgument);
                        // remove timeout message
                        mTaskHandler.removeCallbacksAndMessages(this);

                        // add disconnect task
                        DisconnectTask task = new DisconnectTask(mBLEConnection, mBluetoothGatt, UNKNOWN, mArgument);
                        mTaskHandler.addTask(task);

                        nextProgress = PROGRESS_FINISHED;
                    }
                    mCurrentProgress = nextProgress;
                }
            } else if (PROGRESS_CONNECT_SUCCESS == mCurrentProgress) {
                if (mBluetoothGatt == message.obj && PROGRESS_DISCOVER_SERVICE_SUCCESS == nextProgress) {
                    // current:connect, next:service discovered

                    // auto mtu setting
                    if (mNeedMtuSetting) {
                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP || !mBluetoothGatt.requestMtu(BLEConstants.MAXIMUM_MTU)) {
                            nextProgress = PROGRESS_FINISHED;
                        }
                    } else {
                        nextProgress = PROGRESS_FINISHED;
                    }

                    if (PROGRESS_FINISHED == nextProgress) {
                        // callback
                        mBLEConnection.onConnected(getTaskId(), mBluetoothGatt, mArgument);

                        // remove timeout message
                        mTaskHandler.removeCallbacksAndMessages(this);
                    }
                    mCurrentProgress = nextProgress;
                } else if (mBluetoothGatt == message.obj && PROGRESS_DISCOVER_SERVICE_ERROR == nextProgress) {
                    // failed

                    int status = bundle.getInt(KEY_STATUS);
                    mBLEConnection.onConnectFailed(getTaskId(), status, mArgument);

                    // remove timeout message
                    mTaskHandler.removeCallbacksAndMessages(this);

                    // add disconnect task
                    DisconnectTask task = new DisconnectTask(mBLEConnection, mBluetoothGatt, status, mArgument);
                    mTaskHandler.addTask(task);
                }
            } else if (PROGRESS_DISCOVER_SERVICE_SUCCESS == mCurrentProgress) {
                if (mBluetoothGatt == message.obj && PROGRESS_REQUEST_MTU_SUCCESS == nextProgress) {
                    // current:service discovered, next:finish(connected)

                    // callback
                    mBLEConnection.onConnected(getTaskId(), mBluetoothGatt, mArgument);

                } else if (mBluetoothGatt == message.obj && PROGRESS_REQUEST_MTU_ERROR == nextProgress) {
                    // failed

                    mBLEConnection.onConnectFailed(getTaskId(), bundle.getInt(KEY_STATUS), mArgument);
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
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancel() {
        mTaskHandler.removeCallbacksAndMessages(this);
        mCurrentProgress = PROGRESS_FINISHED;
        mBLEConnection.onConnectFailed(getTaskId(), CANCEL, mArgument);
    }

}
