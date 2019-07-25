package org.im97mori.ble.task;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLELogUtils;
import org.im97mori.ble.TaskHandler;

/**
 * Connect to {@link BluetoothDevice} task
 */
@SuppressWarnings("JavadocReference")
public class ConnectTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for connect:50sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 50;

    /**
     * create connect message
     *
     * @param obj instance for {@link android.os.Handler#removeCallbacksAndMessages(Object)}
     * @return create connect {@link Message} instance
     */
    public static Message createConnectMessage(Object obj) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_CONNECT);
        Message message = new Message();
        message.setData(bundle);
        message.obj = obj;
        return message;
    }

    /**
     * create connect timeout message
     *
     * @param obj instance for {@link android.os.Handler#removeCallbacksAndMessages(Object)}
     * @return create connect timeout {@link Message} instance
     */
    public static Message createConnectFinished(Object obj) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_FINISHED);
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
     * task target {@link BluetoothGatt} instance
     */
    private BluetoothGatt mBluetoothGatt;

    /**
     * @param bleConnection      task target {@link BLEConnection} instance
     * @param taskHandler task target {@link TaskHandler} instance
     * @param timeout     timeout(millis)
     */
    public ConnectTask(BLEConnection bleConnection, TaskHandler taskHandler, long timeout) {
        mBLEConnection = bleConnection;
        mTaskHandler = taskHandler;
        mTimeout = timeout;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean doProcess(Message message) {
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
                    mBluetoothGatt.disconnect();
                    mBluetoothGatt.close();
                }

                mBLEConnection.onConnectTimeout();

                mCurrentProgress = nextProgress;
            } else if (this == message.obj && PROGRESS_INIT == mCurrentProgress) {
                // current:init, next:connect
                if (PROGRESS_CONNECT == nextProgress) {

                    // create gatt connection
                    try {
                        mBluetoothGatt = mBLEConnection.getBluetoothDevice().connectGatt(mBLEConnection.getContext(), true, mBLEConnection);
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }

                    // connect failed
                    if (mBluetoothGatt == null) {
                        mBLEConnection.onConnectTimeout();
                        mCurrentProgress = PROGRESS_FINISHED;
                    } else {
                        // connecting

                        // set timeout message
                        Message timeoutMessage = createTimeoutMessage(null, this);
                        mTaskHandler.sendTimeoutMessage(timeoutMessage, mTimeout);
                        mCurrentProgress = nextProgress;
                    }
                }
            } else if (PROGRESS_CONNECT == mCurrentProgress) {
                // current:connect, next:finish(connected)
                if (mBluetoothGatt == message.obj && PROGRESS_FINISHED == nextProgress) {

                    // callback
                    mBLEConnection.onConnected(mBluetoothGatt);

                    // remove timeout message
                    mTaskHandler.removeCallbacksAndMessages(this);

                    mCurrentProgress = nextProgress;
                }
            }
        }

        return PROGRESS_FINISHED == mCurrentProgress || PROGRESS_TIMEOUT == mCurrentProgress;
    }

}
