package org.im97mori.ble.task;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattServer;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.BLEPeripheralLogUtils;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.TaskHandler;

/**
 * Read phy task
 * <p>
 * for peripheral role
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class ReadPhyPeripheralTask extends AbstractBLETask {

    /**
     * STATUS:CANCEL
     */
    public static final int STATUS_CANCEL = -1;

    /**
     * STATUS:READ_PHY_FAILED
     */
    public static final int STATUS_READ_PHY_FAILED = -2;

    /**
     * KEY:STATUS
     */
    public static final String KEY_STATUS = "KEY_STATUS";

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
     * PROGRESS:READ_PHY_START
     */
    public static final String PROGRESS_READ_PHY_START = "PROGRESS_READ_PHY_START";

    /**
     * PROGRESS:READ_PHY_SUCCESS
     */
    public static final String PROGRESS_READ_PHY_SUCCESS = "PROGRESS_READ_PHY_SUCCESS";

    /**
     * PROGRESS:READ_PHY_ERROR
     */
    public static final String PROGRESS_READ_PHY_ERROR = "PROGRESS_READ_PHY_ERROR";

    /**
     * PROGRESS:BUSY
     */
    public static final String PROGRESS_BUSY = "PROGRESS_BUSY";

    /**
     * PROGRESS:FINISHED
     */
    public static final String PROGRESS_FINISHED = "PROGRESS_FINISHED";

    /**
     * Default timeout(millis) for read:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

    /**
     * create read phy success message
     *
     * @param bluetoothDevice BLE device
     * @param txPhy           {@link android.bluetooth.BluetoothGattServerCallback#onPhyRead(BluetoothDevice, int, int, int)} 2nd parameter
     * @param rxPhy           {@link android.bluetooth.BluetoothGattServerCallback#onPhyRead(BluetoothDevice, int, int, int)} 3rd parameter
     * @return read phy success {@link Message} instance
     */
    @NonNull
    public static Message createReadPhySuccessMessage(@NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_BLUETOOTH_DEVICE, bluetoothDevice.toString());
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_READ_PHY_SUCCESS);
        bundle.putInt(KEY_TX_PHY, txPhy);
        bundle.putInt(KEY_RX_PHY, rxPhy);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * create read phy error message
     *
     * @param bluetoothDevice BLE device
     * @param status          {@link android.bluetooth.BluetoothGattServerCallback#onNotificationSent(BluetoothDevice, int)} 2nd argument
     * @return read phy error {@link Message} instance
     */
    @NonNull
    public static Message createReadPhyErrorMessage(BluetoothDevice bluetoothDevice, int status) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_BLUETOOTH_DEVICE, bluetoothDevice.getAddress());
        bundle.putInt(KEY_STATUS, status);
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_READ_PHY_ERROR);
        Message message = new Message();
        message.setData(bundle);
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
     * BLE device
     */
    private final BluetoothDevice mBluetoothDevice;

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
     * @param bleServerConnection {@link BLEServerConnection} instance
     * @param bluetoothGattServer {@link BluetoothGattServer} instance
     * @param bluetoothDevice     BLE device
     * @param taskHandler         task target {@link TaskHandler} instance
     * @param timeout             timeout(millis)
     * @param argument            callback argument
     */
    public ReadPhyPeripheralTask(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattServer bluetoothGattServer
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull TaskHandler taskHandler
            , long timeout
            , @Nullable Bundle argument) {
        mBLEServerConnection = bleServerConnection;
        mBluetoothGattServer = bluetoothGattServer;
        mBluetoothDevice = bluetoothDevice;
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
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_READ_PHY_START);
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
                mBLEServerConnection.getBLEServerCallback().onPhyReadTimeout(getTaskId()
                        , mBLEServerConnection
                        , mBluetoothDevice
                        , mTimeout
                        , mArgument);
                mCurrentProgress = nextProgress;
            } else if (PROGRESS_INIT.equals(mCurrentProgress)) {
                // current:init, next:read phy start
                if (this == message.obj && PROGRESS_READ_PHY_START.equals(nextProgress)) {
                    boolean result = false;
                    // read phy
                    try {
                        mBluetoothGattServer.readPhy(mBluetoothDevice);
                        result = true;
                    } catch (Exception e) {
                        BLEPeripheralLogUtils.stackLog(e);
                    }
                    if (result) {
                        // set timeout message
                        Message timeoutMessage = createTimeoutMessage(this);
                        mTaskHandler.sendProcessingMessage(timeoutMessage, mTimeout);
                    } else {
                        nextProgress = PROGRESS_BUSY;
                        mBLEServerConnection.getBLEServerCallback().onPhyReadFailed(getTaskId()
                                , mBLEServerConnection
                                , mBluetoothDevice
                                , STATUS_READ_PHY_FAILED
                                , mArgument);
                    }

                    mCurrentProgress = nextProgress;
                }
            } else if (PROGRESS_READ_PHY_START.equals(mCurrentProgress)) {
                if (mBluetoothDevice.getAddress().equals(bundle.getString(KEY_BLUETOOTH_DEVICE))) {
                    if (PROGRESS_READ_PHY_SUCCESS.equals(nextProgress)) {
                        // current:read phy start, next:read phy success

                        mBLEServerConnection.getBLEServerCallback().onPhyReadSuccess(getTaskId()
                                , mBLEServerConnection
                                , mBluetoothDevice
                                , bundle.getInt(KEY_TX_PHY)
                                , bundle.getInt(KEY_RX_PHY)
                                , mArgument);
                    } else if (PROGRESS_READ_PHY_ERROR.equals(nextProgress)) {
                        // current:read phy start, next:read phy error

                        mBLEServerConnection.getBLEServerCallback().onPhyReadFailed(getTaskId()
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
        mBLEServerConnection.getBLEServerCallback().onPhyReadFailed(getTaskId()
                , mBLEServerConnection
                , mBluetoothDevice
                , STATUS_CANCEL
                , mArgument);
    }
}
