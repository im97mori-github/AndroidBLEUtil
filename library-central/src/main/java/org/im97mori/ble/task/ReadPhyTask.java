package org.im97mori.ble.task;

import android.bluetooth.BluetoothGatt;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.TaskHandler;

import static org.im97mori.ble.BLEConstants.ErrorCodes.CANCEL;

/**
 * Read phy task
 * <p>
 * for central role
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class ReadPhyTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for read phy:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

    /**
     * create read phy success message
     *
     * @param txPhy {@link android.bluetooth.BluetoothGattCallback#onPhyRead(BluetoothGatt, int, int, int)} 2nd argument
     * @param rxPhy {@link android.bluetooth.BluetoothGattCallback#onPhyRead(BluetoothGatt, int, int, int)} 3rd argument
     * @return read phy success {@link Message} instance
     */
    @NonNull
    public static Message createReadPhySuccessMessage(int txPhy, int rxPhy) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_TX_PHY, txPhy);
        bundle.putInt(KEY_RX_PHY, rxPhy);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_READ_PHY_SUCCESS);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * create read phy error message
     *
     * @param status {@link android.bluetooth.BluetoothGattCallback#onPhyRead(BluetoothGatt, int, int, int)} 4th argument
     * @return read phy error {@link Message} instance
     */
    @NonNull
    public static Message createReadPhyErrorMessage(int status) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_STATUS, status);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_READ_PHY_ERROR);
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
    public ReadPhyTask(@NonNull BLEConnection bleConnection
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
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_READ_PHY_START);
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
            mBLEConnection.getBLECallback().onReadPhyTimeout(getTaskId(), mBluetoothGatt.getDevice(), mTimeout, mArgument);
            mCurrentProgress = nextProgress;
        } else if (this == message.obj && PROGRESS_INIT == mCurrentProgress) {
            if (PROGRESS_READ_PHY_START == nextProgress) {
                // current:init, next:read phy start

                mBluetoothGatt.readPhy();

                // set timeout message
                mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);
                mCurrentProgress = nextProgress;
            }
        } else if (PROGRESS_READ_PHY_START == mCurrentProgress) {
            if (PROGRESS_READ_PHY_SUCCESS == nextProgress) {
                // current:read phy start, next:read phy success

                // callback
                mBLEConnection.getBLECallback().onReadPhySuccess(getTaskId(), mBluetoothGatt.getDevice(), bundle.getInt(KEY_TX_PHY), bundle.getInt(KEY_RX_PHY), mArgument);
            } else if (PROGRESS_READ_PHY_ERROR == nextProgress) {
                // current:read phy start, next:read phy failed

                mBLEConnection.getBLECallback().onReadPhyFailed(getTaskId(), mBluetoothGatt.getDevice(), bundle.getInt(KEY_STATUS), mArgument);
            }

            // remove timeout message
            mTaskHandler.removeCallbacksAndMessages(this);

            mCurrentProgress = PROGRESS_FINISHED;
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
        mBLEConnection.getBLECallback().onReadPhyFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), CANCEL, mArgument);
    }

}
