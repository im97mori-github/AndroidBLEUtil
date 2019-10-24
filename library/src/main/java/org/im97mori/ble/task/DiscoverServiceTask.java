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
 * Discover service task
 * <p>
 * for central role
 */
@SuppressWarnings("unused")
public class DiscoverServiceTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for discover service:5sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 5;

    /**
     * create discover service success message
     *
     * @param obj current {@link BluetoothGatt} instance
     * @return create discover service success {@link Message} instance
     */
    public static Message createDiscoverServiceSuccessMessage(Object obj) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_DISCOVER_SERVICE_SUCCESS);
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
     * @return read discover service error {@link Message} instance
     */
    public static Message createDiscoverServiceErrorMessage(Object obj, int status) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_STATUS, status);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_DISCOVER_SERVICE_ERROR);
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
    public DiscoverServiceTask(@NonNull BLEConnection bleConnection, @NonNull BluetoothGatt bluetoothGatt, @NonNull TaskHandler taskHandler, long timeout, @NonNull Bundle argument) {
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
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_DISCOVER_SERVICE_START);
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
            mBLEConnection.getBLECallback().onDiscoverServiceTimeout(getTaskId(), mBluetoothGatt.getDevice(), mTimeout, mArgument);
            mCurrentProgress = nextProgress;
        } else if (this == message.obj && PROGRESS_INIT == mCurrentProgress) {
            if (PROGRESS_DISCOVER_SERVICE_START == nextProgress) {
                // current:init, next:discover service start

                if (mBluetoothGatt.discoverServices()) {
                    // success
                    // set timeout message
                    Message timeoutMessage = createTimeoutMessage(this);
                    mTaskHandler.sendProcessingMessage(timeoutMessage, mTimeout);
                    mCurrentProgress = nextProgress;
                } else {
                    // failed

                    mBLEConnection.getBLECallback().onDiscoverServiceFailed(getTaskId(), mBluetoothGatt.getDevice(), UNKNOWN, mArgument);
                    mCurrentProgress = PROGRESS_BUSY;
                }
            }
        } else if (PROGRESS_DISCOVER_SERVICE_START == mCurrentProgress) {
            if (PROGRESS_DISCOVER_SERVICE_SUCCESS == nextProgress) {
                // current:discover service start, next:discover service success

                // callback
                mBLEConnection.getBLECallback().onDiscoverServiceSuccess(getTaskId(), mBluetoothGatt.getDevice(), mBluetoothGatt.getServices(), mArgument);


            } else if (PROGRESS_DISCOVER_SERVICE_ERROR == nextProgress) {
                // current:discover service start, next:discover service failed

                mBLEConnection.getBLECallback().onDiscoverServiceFailed(getTaskId(), mBluetoothGatt.getDevice(), bundle.getInt(KEY_STATUS), mArgument);
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
        mBLEConnection.getBLECallback().onDiscoverServiceFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), CANCEL, mArgument);
    }

}
