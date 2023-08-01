package org.im97mori.ble.task;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattServer;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.TaskHandler;

/**
 * Set preferred phy task
 * <p>
 * for peripheral role
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class SetPreferredPhyPeripheralTask extends AbstractBLETask {

    /**
     * STATUS:CANCEL
     */
    public static final int STATUS_CANCEL = -1;

    /**
     * KEY:BLUETOOTH_DEVICE
     */
    public static final String KEY_BLUETOOTH_DEVICE = "KEY_BLUETOOTH_DEVICE";

    /**
     * KEY:TX_PHY
     */
    public static final String KEY_TX_PHY = "KEY_TX_PHY";

    /**
     * KEY:RX_PHY
     */
    public static final String KEY_RX_PHY = "KEY_RX_PHY";

    /**
     * KEY:STATUS
     */
    public static final String KEY_STATUS = "KEY_STATUS";

    /**
     * PROGRESS:SET_PREFERRED_PHY_START
     */
    public static final String PROGRESS_SET_PREFERRED_PHY_START = "PROGRESS_SET_PREFERRED_PHY_START";

    /**
     * PROGRESS:SET_PREFERRED_PHY_SUCCESS
     */
    public static final String PROGRESS_SET_PREFERRED_PHY_SUCCESS = "PROGRESS_SET_PREFERRED_PHY_SUCCESS";

    /**
     * PROGRESS:SET_PREFERRED_PHY_ERROR
     */
    public static final String PROGRESS_SET_PREFERRED_PHY_ERROR = "PROGRESS_SET_PREFERRED_PHY_ERROR";

    /**
     * PROGRESS:FINISHED
     */
    public static final String PROGRESS_FINISHED = "PROGRESS_FINISHED";

    /**
     * Default timeout(millis) for set preferred phy:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

    /**
     * create set preferred phy success message
     *
     * @param bluetoothDevice BLE device
     * @param txPhy           {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 2nd argument
     * @param rxPhy           {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 3rd argument
     * @return write characteristic success {@link Message} instance
     */
    @NonNull
    public static Message createSetPreferredPhySuccessMessage(@NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_BLUETOOTH_DEVICE, bluetoothDevice.toString());
        bundle.putInt(KEY_TX_PHY, txPhy);
        bundle.putInt(KEY_RX_PHY, rxPhy);
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_SET_PREFERRED_PHY_SUCCESS);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * create set preferred phy error message
     *
     * @param bluetoothDevice BLE device
     * @param status          {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 4th argument
     * @return set preferred phy error {@link Message} instance
     */
    @NonNull
    public static Message createSetPreferredPhyErrorMessage(@NonNull BluetoothDevice bluetoothDevice, int status) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_BLUETOOTH_DEVICE, bluetoothDevice.toString());
        bundle.putInt(KEY_STATUS, status);
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_SET_PREFERRED_PHY_ERROR);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * task target {@link BLEServerConnection} instance
     */
    private final BLEServerConnection mBLEServerConnection;

    /**
     * task target {@link BluetoothGatt} instance
     */
    private final BluetoothGattServer mBluetoothGattServer;

    /**
     * task target {@link TaskHandler} instance
     */
    private final TaskHandler mTaskHandler;

    /**
     * BLE device
     */
    private final BluetoothDevice mBluetoothDevice;

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
    private final Bundle mArgument;

    /**
     * @param bleServerConnection task target {@link BLEServerConnection} instance
     * @param bluetoothGattServer task target {@link BluetoothGattServer} instance
     * @param taskHandler         task target {@link TaskHandler} instance
     * @param txPhy               new txPhy for {@link BluetoothGattServer#setPreferredPhy(BluetoothDevice, int, int, int)}} 2nd argument
     * @param rxPhy               new rxPhy for {@link BluetoothGattServer#setPreferredPhy(BluetoothDevice, int, int, int)}} 3rd argument
     * @param phyOptions          new phyOptions for {@link BluetoothGattServer#setPreferredPhy(BluetoothDevice, int, int, int)}} 4th argument
     * @param timeout             timeout(millis)
     * @param argument            callback argument
     */
    public SetPreferredPhyPeripheralTask(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattServer bluetoothGattServer
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull TaskHandler taskHandler
            , int txPhy
            , int rxPhy
            , int phyOptions
            , long timeout
            , @NonNull Bundle argument) {
        mBLEServerConnection = bleServerConnection;
        mBluetoothGattServer = bluetoothGattServer;
        mBluetoothDevice = bluetoothDevice;
        mTaskHandler = taskHandler;
        mTxPhy = txPhy;
        mRxPhy = rxPhy;
        mPhyOptions = phyOptions;
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
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_SET_PREFERRED_PHY_START);
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
            if (message.obj == this && PROGRESS_TIMEOUT.equals(nextProgress)) {
                mBLEServerConnection.getBLEServerCallback().onSetPreferredPhyTimeout(getTaskId()
                        , mBLEServerConnection
                        , mBluetoothDevice
                        , mTimeout
                        , mArgument);
                mCurrentProgress = nextProgress;
            } else if (PROGRESS_INIT.equals(mCurrentProgress)) {
                if (message.obj == this && PROGRESS_SET_PREFERRED_PHY_START.equals(nextProgress)) {
                    // current:init, next:set preferred phy start
                    mBluetoothGattServer.setPreferredPhy(mBluetoothDevice, mTxPhy, mRxPhy, mPhyOptions);

                    // set timeout message
                    mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);
                    mCurrentProgress = nextProgress;
                }
            } else if (PROGRESS_SET_PREFERRED_PHY_START.equals(mCurrentProgress)) {
                if (mBluetoothDevice.getAddress().equals(bundle.getString(KEY_BLUETOOTH_DEVICE))) {
                    if (PROGRESS_SET_PREFERRED_PHY_SUCCESS.equals(nextProgress)) {
                        // current:set preferred phy start, next:set preferred phy success
                        mBLEServerConnection.getBLEServerCallback().onSetPreferredPhySuccess(getTaskId()
                                , mBLEServerConnection
                                , mBluetoothDevice
                                , bundle.getInt(KEY_TX_PHY)
                                , bundle.getInt(KEY_RX_PHY)
                                , mPhyOptions
                                , mArgument);
                    } else if (PROGRESS_SET_PREFERRED_PHY_ERROR.equals(nextProgress)) {
                        // current:set preferred phy start, next:set preferred phy error
                        mBLEServerConnection.getBLEServerCallback().onSetPreferredPhyFailed(getTaskId()
                                , mBLEServerConnection
                                , mBluetoothDevice
                                , bundle.getInt(KEY_STATUS)
                                , mArgument);
                    }
                }

                mCurrentProgress = PROGRESS_FINISHED;
                // remove timeout message
                mTaskHandler.removeCallbacksAndMessages(this);
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
        mBLEServerConnection.getBLEServerCallback().onSetPreferredPhyFailed(getTaskId()
                , mBLEServerConnection
                , mBluetoothDevice
                , STATUS_CANCEL
                , mArgument);
    }
}
