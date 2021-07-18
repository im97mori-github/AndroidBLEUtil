package org.im97mori.ble.task;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.os.Bundle;
import android.os.Message;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLELogUtils;
import org.im97mori.ble.constants.ErrorCodeAndroid;

import static org.im97mori.ble.constants.ErrorCodeAndroid.CANCEL;

/**
 * Disconnect from {@link BluetoothGatt} task
 * <p>
 * for central role
 */
public class DisconnectTask extends AbstractBLETask {

    /**
     * task target {@link BLEConnection} instance
     */
    private final BLEConnection mBLEConnection;

    /**
     * task target {@link BluetoothGatt} instance
     */
    private final BluetoothGatt mBluetoothGatt;

    /**
     * {@link android.bluetooth.BluetoothGattCallback#onConnectionStateChange(BluetoothGatt, int, int)} 2nd parameter or {@link ErrorCodeAndroid#UNKNOWN}
     */
    private final int mStatus;

    /**
     * callback argument
     */
    private final Bundle mArgument;

    /**
     * @param bleConnection task target {@link BLEConnection} instance
     * @param bluetoothGatt task target {@link BluetoothGatt} instance
     * @param status        {@link android.bluetooth.BluetoothGattCallback#onConnectionStateChange(BluetoothGatt, int, int)} 2nd parameter or {@link ErrorCodeAndroid#UNKNOWN}
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
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_DISCONNECT);
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
                int nextProgress = bundle.getInt(KEY_NEXT_PROGRESS);

                // current:init, next:disconnect
                if (this == message.obj && PROGRESS_INIT == mCurrentProgress) {
                    if (PROGRESS_DISCONNECT == nextProgress) {
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
                            mBLEConnection.onDisconnected(getTaskId(), mBluetoothGatt, bundle.getInt(KEY_STATUS), mArgument);
                        }
                        mCurrentProgress = nextProgress;
                    }
                }
            }
        }

        return PROGRESS_FINISHED == mCurrentProgress || PROGRESS_DISCONNECT == mCurrentProgress;
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
        mBLEConnection.onDisconnected(getTaskId(), mBluetoothGatt, CANCEL, mArgument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isIgnoreBusy() {
        return true;
    }

}
