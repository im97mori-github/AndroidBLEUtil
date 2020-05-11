package org.im97mori.ble.task;

import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.TaskHandler;

import static org.im97mori.ble.BLEConstants.ErrorCodes.CANCEL;
import static org.im97mori.ble.BLEConstants.ErrorCodes.UNKNOWN;

/**
 * Add service task
 * <p>
 * for peripheral role
 */
public class AddServiceTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for add service:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

    /**
     * create add service success message
     *
     * @param bluetoothGattService target {@link BluetoothGattService}
     * @return add service success {@link Message} instance
     */
    @NonNull
    public static Message createAddServiceSuccessMessage(@NonNull BluetoothGattService bluetoothGattService) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_ADD_SERVICE_SUCCESS);
        Message message = new Message();
        message.setData(bundle);
        message.obj = bluetoothGattService;
        return message;
    }

    /**
     * create add service error message
     *
     * @param bluetoothGattService target {@link BluetoothGattService}
     * @param status               {@link android.bluetooth.BluetoothGattServerCallback#onServiceAdded(int, BluetoothGattService)} 1st parameter
     * @return add service error {@link Message} instance
     */
    @NonNull
    public static Message createAddServiceErrorMessage(@NonNull BluetoothGattService bluetoothGattService, int status) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_ADD_SERVICE_ERROR);
        bundle.putInt(KEY_STATUS, status);
        Message message = new Message();
        message.setData(bundle);
        message.obj = bluetoothGattService;
        return message;
    }

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
    public AddServiceTask(BLEServerConnection bleServerConnection
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
        bundle.putInt(AbstractBLETask.KEY_NEXT_PROGRESS, AbstractBLETask.PROGRESS_ADD_SERVICE);
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
        BluetoothGattService bluetoothGattService;
        int nextProgress = bundle.getInt(KEY_NEXT_PROGRESS);

        // timeout
        if (this == message.obj && PROGRESS_TIMEOUT == nextProgress) {
            mBLEServerConnection.getBLEServerCallback().onServiceAddTimeout(getTaskId(), mBLEServerConnection, mBluetoothGattService, mTimeout, mArgument);
            mCurrentProgress = nextProgress;
        } else if (PROGRESS_INIT == mCurrentProgress) {
            // current:init, next:add service start
            if (this == message.obj && PROGRESS_ADD_SERVICE == nextProgress) {

                if (mBluetoothGattServer.addService(mBluetoothGattService)) {
                    mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);
                } else {
                    nextProgress = PROGRESS_FINISHED;
                    mBLEServerConnection.getBLEServerCallback().onServiceAddFailed(getTaskId(), mBLEServerConnection, mBluetoothGattService, UNKNOWN, mArgument);
                }
                mCurrentProgress = nextProgress;
            }
        } else if (PROGRESS_ADD_SERVICE == mCurrentProgress) {
            bluetoothGattService = (BluetoothGattService) message.obj;
            if (mBluetoothGattService.getUuid().equals(bluetoothGattService.getUuid()) && mBluetoothGattService.getType() == bluetoothGattService.getType()) {
                // current:add service start, next:add service success
                if (PROGRESS_ADD_SERVICE_SUCCESS == nextProgress) {
                    if (!mBLEServerConnection.getBLEServerCallback().onServiceAddSuccess(getTaskId(), mBLEServerConnection, bluetoothGattService, mArgument)) {
                        mBLEServerConnection.createRemoveServiceTask(bluetoothGattService, RemoveServiceTask.TIMEOUT_MILLIS, null, null);
                    }
                } else if (PROGRESS_ADD_SERVICE_ERROR == nextProgress) {
                    // current:add service start, next:add service error
                    mBLEServerConnection.getBLEServerCallback().onServiceAddFailed(getTaskId(), mBLEServerConnection, mBluetoothGattService, bundle.getInt(KEY_STATUS), mArgument);
                }
                mCurrentProgress = PROGRESS_FINISHED;
                // remove timeout message
                mTaskHandler.removeCallbacksAndMessages(this);
            }
        }

        return PROGRESS_FINISHED == mCurrentProgress || PROGRESS_TIMEOUT == mCurrentProgress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBusy() {
        return PROGRESS_TIMEOUT == mCurrentProgress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancel() {
        mTaskHandler.removeCallbacksAndMessages(this);
        mCurrentProgress = PROGRESS_FINISHED;
        mBLEServerConnection.getBLEServerCallback().onServiceAddFailed(getTaskId(), mBLEServerConnection, mBluetoothGattService, CANCEL, mArgument);
    }
}
