package org.im97mori.ble.task;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.TaskHandler;

import static org.im97mori.ble.constants.ErrorCodeAndroid.CANCEL;
import static org.im97mori.ble.constants.ErrorCodeAndroid.UNKNOWN;

/**
 * Remove service task
 * <p>
 * for peripheral role
 */
public class RemoveServiceTask extends AbstractBLETask {

    /**
     * KEY:STATUS
     */
    public static final String KEY_STATUS = "KEY_STATUS";

    /**
     * PROGRESS:REMOVE_SERVICE_START
     */
    public static final String PROGRESS_REMOVE_SERVICE_START = "PROGRESS_REMOVE_SERVICE_START";

    /**
     * PROGRESS:REMOVE_SERVICE_SUCCESS
     */
    public static final String PROGRESS_REMOVE_SERVICE_SUCCESS = "PROGRESS_REMOVE_SERVICE_SUCCESS";

    /**
     * PROGRESS:REMOVE_SERVICE_ERROR
     */
    public static final String PROGRESS_REMOVE_SERVICE_ERROR = "PROGRESS_REMOVE_SERVICE_ERROR";

    /**
     * PROGRESS:FINISHED
     */
    public static final String PROGRESS_FINISHED = "PROGRESS_FINISHED";
    
    /**
     * Default timeout(millis) for remove service:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

    /**
     * {@link BLEServerConnection} instance
     */
    private final BLEServerConnection mBLEServerConnection;

    /**
     * {@link BluetoothGattServer} instance
     */
    private final BluetoothGattServer mBluetoothGattServer;

    /**
     * task target {@link TaskHandler} instance
     */
    private final TaskHandler mTaskHandler;

    /**
     * {@link BluetoothGattService} instance
     */
    private final BluetoothGattService mBluetoothGattService;

    /**
     * timeout(millis)
     */
    private final long mTimeout;

    /**
     * callback argument
     */
    private final Bundle mArgument;

    /**
     * @param bleServerConnection  {@link BLEServerConnection} instance
     * @param taskHandler          task target {@link TaskHandler} instance
     * @param bluetoothGattService task target {@link BluetoothGattService} instance
     * @param timeout              timeout(millis)
     * @param argument             callback argument
     */
    public RemoveServiceTask(BLEServerConnection bleServerConnection
            , @NonNull TaskHandler taskHandler
            , @NonNull BluetoothGattService bluetoothGattService
            , long timeout
            , @Nullable Bundle argument) {
        mBLEServerConnection = bleServerConnection;
        mBluetoothGattServer = bleServerConnection.getBluetoothGattServer();
        mTaskHandler = taskHandler;
        mBluetoothGattService = bluetoothGattService;
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
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_REMOVE_SERVICE_START);
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
            BluetoothGattService bluetoothGattService;
            String nextProgress = bundle.getString(KEY_NEXT_PROGRESS);

            // timeout
            if (this == message.obj && PROGRESS_TIMEOUT.equals(nextProgress)) {
                mBLEServerConnection.getBLEServerCallback().onServiceRemoveTimeout(getTaskId(), mBLEServerConnection, mBluetoothGattService, mTimeout, mArgument);
                mCurrentProgress = nextProgress;
            } else if (PROGRESS_INIT.equals(mCurrentProgress)) {
                // current:init, next:remove service start
                if (this == message.obj && PROGRESS_REMOVE_SERVICE_START.equals(nextProgress)) {
                    if (mBluetoothGattServer.removeService(mBluetoothGattService)) {
                        mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);
                    } else {
                        nextProgress = PROGRESS_FINISHED;
                        mBLEServerConnection.getBLEServerCallback().onServiceRemoveFailed(getTaskId(), mBLEServerConnection, mBluetoothGattService, UNKNOWN, mArgument);
                    }
                    mCurrentProgress = nextProgress;
                }
            } else if (PROGRESS_REMOVE_SERVICE_START.equals(mCurrentProgress)) {
                if (message.obj instanceof BluetoothGattService) {
                    bluetoothGattService = (BluetoothGattService) message.obj;
                    if (mBluetoothGattService.getUuid().equals(bluetoothGattService.getUuid()) && mBluetoothGattService.getType() == bluetoothGattService.getType()) {
                        // current:remove service start, next:remove service success
                        if (PROGRESS_REMOVE_SERVICE_SUCCESS.equals(nextProgress)) {
                            mBLEServerConnection.getBLEServerCallback().onServiceRemoveSuccess(getTaskId(), mBLEServerConnection, bluetoothGattService, mArgument);
                        } else if (PROGRESS_REMOVE_SERVICE_ERROR.equals(nextProgress)) {
                            // current:remove service start, next:remove service error
                            mBLEServerConnection.getBLEServerCallback().onServiceRemoveFailed(getTaskId(), mBLEServerConnection, mBluetoothGattService, bundle.getInt(KEY_STATUS), mArgument);
                        }
                        mCurrentProgress = PROGRESS_FINISHED;
                        // remove timeout message
                        mTaskHandler.removeCallbacksAndMessages(this);
                    }
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
        return PROGRESS_TIMEOUT.equals(mCurrentProgress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancel() {
        mTaskHandler.removeCallbacksAndMessages(this);
        mCurrentProgress = PROGRESS_FINISHED;
        mBLEServerConnection.getBLEServerCallback().onServiceRemoveFailed(getTaskId(), mBLEServerConnection, mBluetoothGattService, CANCEL, mArgument);
    }

}
