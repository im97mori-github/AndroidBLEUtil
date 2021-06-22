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

import static org.im97mori.ble.constants.ErrorCodeAndroid.CANCEL;

/**
 * Set preferred phy task
 * <p>
 * for central role
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class SetPreferredPhyTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for set preferred phy:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

    /**
     * create set preferred phy success message
     *
     * @param txPhy {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 2nd argument
     * @param rxPhy {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 3rd argument
     * @return write characteristic success {@link Message} instance
     */
    @NonNull
    public static Message createSetPreferredPhySuccessMessage(int txPhy, int rxPhy) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_TX_PHY, txPhy);
        bundle.putInt(KEY_RX_PHY, rxPhy);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_SET_PREFERRED_PHY_SUCCESS);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * create set preferred phy error message
     *
     * @param status {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 4th argument
     * @return set preferred phy error {@link Message} instance
     */
    @NonNull
    public static Message createSetPreferredPhyErrorMessage(int status) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_STATUS, status);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_SET_PREFERRED_PHY_ERROR);
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
     * new txPhy for {@link BluetoothGatt#setPreferredPhy(int, int, int)} 1st argument
     */
    private final int mTxPhy;

    /**
     * new rxPhy for {@link BluetoothGatt#setPreferredPhy(int, int, int)} 2nd argument
     */
    private final int mRxPhy;

    /**
     * new phyOptions for {@link BluetoothGatt#setPreferredPhy(int, int, int)} 3rd argument
     */
    private final int mPhyOptions;

    /**
     * timeout(millis)
     */
    private final long mTimeout;

    /**
     * callback argument
     */
    private final Bundle mArgumemnt;

    /**
     * @param bleConnection task target {@link BLEConnection} instance
     * @param bluetoothGatt task target {@link BluetoothGatt} instance
     * @param taskHandler   task target {@link TaskHandler} instance
     * @param txPhy         new txPhy for {@link BluetoothGatt#setPreferredPhy(int, int, int)} 1st argument
     * @param rxPhy         new rxPhy for {@link BluetoothGatt#setPreferredPhy(int, int, int)} 2nd argument
     * @param phyOptions    new phyOptions for {@link BluetoothGatt#setPreferredPhy(int, int, int)} 3rd argument
     * @param timeout       timeout(millis)
     * @param argument      callback argument
     */
    public SetPreferredPhyTask(@NonNull BLEConnection bleConnection
            , @NonNull BluetoothGatt bluetoothGatt
            , @NonNull TaskHandler taskHandler
            , int txPhy
            , int rxPhy
            , int phyOptions
            , long timeout
            , @NonNull Bundle argument) {
        mBLEConnection = bleConnection;
        mBluetoothGatt = bluetoothGatt;
        mTaskHandler = taskHandler;
        mTxPhy = txPhy;
        mRxPhy = rxPhy;
        mPhyOptions = phyOptions;
        mTimeout = timeout;
        mArgumemnt = argument;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public Message createInitialMessage() {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_SET_PREFERRED_PHY_START);
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
        if (bundle.containsKey(KEY_NEXT_PROGRESS)) {
            int nextProgress = bundle.getInt(KEY_NEXT_PROGRESS);

            // timeout
            if (message.obj == this && PROGRESS_TIMEOUT == nextProgress) {
                mBLEConnection.getBLECallback().onSetPreferredPhyTimeout(getTaskId(), mBLEConnection.getBluetoothDevice(), mTimeout, mArgumemnt);
                mCurrentProgress = nextProgress;
            } else if (PROGRESS_INIT == mCurrentProgress) {
                if (message.obj == this && PROGRESS_SET_PREFERRED_PHY_START == nextProgress) {
                    // current:init, next:set preferred phy start
                    mBluetoothGatt.setPreferredPhy(mTxPhy, mRxPhy, mPhyOptions);

                    // set timeout message
                    mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);
                    mCurrentProgress = nextProgress;
                }
            } else if (PROGRESS_SET_PREFERRED_PHY_START == mCurrentProgress) {
                // current:set preferred phy start, next:set preferred phy success
                if (PROGRESS_SET_PREFERRED_PHY_SUCCESS == nextProgress) {
                    mBLEConnection.getBLECallback().onSetPreferredPhySuccess(getTaskId(), mBLEConnection.getBluetoothDevice(), bundle.getInt(KEY_TX_PHY), bundle.getInt(KEY_RX_PHY), bundle.getInt(KEY_PHY_OPTIONS), mArgumemnt);
                } else if (PROGRESS_SET_PREFERRED_PHY_ERROR == nextProgress) {
                    // current:set preferred phy start, next:set preferred phy error
                    mBLEConnection.getBLECallback().onSetPreferredPhyFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), bundle.getInt(KEY_STATUS), mArgumemnt);
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
        mBLEConnection.getBLECallback().onSetPreferredPhyFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), CANCEL, mArgumemnt);
    }

}
