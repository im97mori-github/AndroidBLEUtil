package org.im97mori.ble.task;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.os.Bundle;
import android.os.Message;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLELogUtils;

/**
 * Disconnect from {@link BluetoothGatt} task
 * <p>
 * for central role
 */
public class DisconnectTask extends AbstractBLETask {

    /**
     * STATUS:CANCEL
     */
    public static final int STATUS_CANCEL = -1;

    /**
     * STATUS:MANUAL_DISCONNECT
     */
    public static final int STATUS_MANUAL_DISCONNECT = -2;

    /**
     * KEY:STATUS
     */
    public static final String KEY_STATUS = "KEY_STATUS";

    /**
     * PROGRESS:DISCONNECT
     */
    public static final String PROGRESS_DISCONNECT = "PROGRESS_DISCONNECT";

    /**
     * PROGRESS:FINISHED
     */
    public static final String PROGRESS_FINISHED = "PROGRESS_FINISHED";

    /**
     * task target {@link BLEConnection} instance
     */
    private final BLEConnection mBLEConnection;

    /**
     * task target {@link BluetoothGatt} instance
     */
    private final BluetoothGatt mBluetoothGatt;

    /**
     * {@link android.bluetooth.BluetoothGattCallback#onConnectionStateChange(BluetoothGatt, int, int)} 2nd parameter
     * {@link #STATUS_CANCEL}
     * {@link #STATUS_MANUAL_DISCONNECT}
     */
    private final int mStatus;

    /**
     * callback argument
     */
    private final Bundle mArgument;

    /**
     * @param bleConnection task target {@link BLEConnection} instance
     * @param bluetoothGatt task target {@link BluetoothGatt} instance
     * @param argument      callback argument
     * @see DisconnectTask#DisconnectTask(BLEConnection, BluetoothGatt, int, Bundle)
     */
    public DisconnectTask(@NonNull BLEConnection bleConnection
            , @NonNull BluetoothGatt bluetoothGatt
            , @NonNull Bundle argument) {
        this(bleConnection, bluetoothGatt, STATUS_MANUAL_DISCONNECT, argument);
    }

    /**
     * @param bleConnection task target {@link BLEConnection} instance
     * @param bluetoothGatt task target {@link BluetoothGatt} instance
     * @param status        {@link android.bluetooth.BluetoothGattCallback#onConnectionStateChange(BluetoothGatt, int, int)} 2nd parameter
     *                      {@link #STATUS_CANCEL}
     *                      {@link #STATUS_MANUAL_DISCONNECT}
     * @param argument      callback argument
     */
    public DisconnectTask(@NonNull BLEConnection bleConnection
            , @NonNull BluetoothGatt bluetoothGatt
            , int status
            , @NonNull Bundle argument) {
        mBLEConnection = bleConnection;
        mBluetoothGatt = bluetoothGatt;
        mStatus = status;
        mArgument = argument;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public Message createInitialMessage() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_DISCONNECT);
        bundle.putInt(KEY_STATUS, mStatus);
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
        // if not connected, finish task
        if (!mBLEConnection.isConnected()) {
            mCurrentProgress = PROGRESS_FINISHED;
        } else {
            Bundle bundle = message.getData();
            if (bundle.containsKey(KEY_NEXT_PROGRESS)) {
                String nextProgress = bundle.getString(KEY_NEXT_PROGRESS);

                // current:init, next:disconnect
                if (this == message.obj && PROGRESS_INIT.equals(mCurrentProgress)) {
                    if (PROGRESS_DISCONNECT.equals(nextProgress)) {
                        // target is newest one
                        if (mBLEConnection.isCurrentConnectionTarget(mBluetoothGatt)) {
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
                            mBLEConnection.onDisconnected(getTaskId()
                                    , mBluetoothGatt
                                    , bundle.getInt(KEY_STATUS)
                                    , mArgument);
                        }
                        mCurrentProgress = nextProgress;
                    }
                }
            }
        }

        return PROGRESS_FINISHED.equals(mCurrentProgress) || PROGRESS_DISCONNECT.equals(mCurrentProgress);
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
        mCurrentProgress = PROGRESS_FINISHED;
        mBLEConnection.onDisconnected(getTaskId()
                , mBluetoothGatt
                , STATUS_CANCEL
                , mArgument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isIgnoreBusy() {
        return true;
    }

}
