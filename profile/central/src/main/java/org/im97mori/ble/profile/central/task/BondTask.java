package org.im97mori.ble.profile.central.task;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.TaskHandler;
import org.im97mori.ble.profile.central.BondStateReceiver;
import org.im97mori.ble.profile.central.ProfileCallback;
import org.im97mori.ble.task.AbstractBLETask;

import static org.im97mori.ble.BLEConstants.ErrorCodes.CANCEL;
import static org.im97mori.ble.BLEConstants.ErrorCodes.UNKNOWN;

/**
 * Bond device task
 * <p>
 * for central role
 */
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
@SuppressLint("MissingPermission")
public class BondTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for bond device:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

    /**
     * create bond success message
     *
     * @param bluetoothDevice bonded {@link BluetoothDevice} instance
     * @return bond success {@link Message} instance
     */
    @NonNull
    public static Message createBondSuccessMessage(@NonNull BluetoothDevice bluetoothDevice) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_BLUETOOTH_DEVICE, bluetoothDevice);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_BOND_SUCCESS);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * create bond error message
     *
     * @param bluetoothDevice bond failed {@link BluetoothDevice} instance
     * @return bond error {@link Message} instance
     */
    @NonNull
    public static Message createBondErrorMessage(@NonNull BluetoothDevice bluetoothDevice) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_BLUETOOTH_DEVICE, bluetoothDevice);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_BOND_ERROR);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * {@link ProfileCallback} instance
     */
    private final ProfileCallback mProfileCallback;

    /**
     * {@link Context} instance for {@link Context#registerReceiver(BroadcastReceiver, IntentFilter)}
     */
    private final Context mContext;

    /**
     * task target {@link TaskHandler} instance
     */
    private final TaskHandler mTaskHandler;

    /**
     * bond target {@link BluetoothDevice} instance
     */
    private final BluetoothDevice mTargetBluetoothDevice;

    /**
     * {@link BondStateReceiver} instance
     */
    private final BondStateReceiver mBondStateReceiver;

    /**
     * timeout(millis)
     */
    private final long mTimeout;

    /**
     * callback argument
     */
    private final Bundle mArgument;

    /**
     * @param context               {@link Context} instance for {@link Context#registerReceiver(BroadcastReceiver, IntentFilter)}
     * @param taskHandler           task target {@link TaskHandler} instance
     * @param bondStateReceiver     {@link BondStateReceiver} instance
     * @param profileCallback       {@link ProfileCallback} instance
     * @param targetBluetoothDevice bond target {@link BluetoothDevice} instance
     * @param timeout               timeout(millis)
     * @param argument              callback argument
     */
    public BondTask(@NonNull Context context
            , @NonNull TaskHandler taskHandler
            , @NonNull BondStateReceiver bondStateReceiver
            , @NonNull ProfileCallback profileCallback
            , @NonNull BluetoothDevice targetBluetoothDevice
            , long timeout
            , @Nullable Bundle argument) {
        mContext = context;
        mTaskHandler = taskHandler;
        mBondStateReceiver = bondStateReceiver;
        mProfileCallback = profileCallback;
        mTargetBluetoothDevice = targetBluetoothDevice;
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
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_BOND_START);
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
            mContext.unregisterReceiver(mBondStateReceiver);
            mProfileCallback.onBondTimeout(mTargetBluetoothDevice, mTimeout, mArgument);
            mCurrentProgress = PROGRESS_TIMEOUT;
        } else if (PROGRESS_INIT == mCurrentProgress) {
            // current:init, next:bond start
            if (this == message.obj && PROGRESS_BOND_START == nextProgress) {

                mContext.registerReceiver(mBondStateReceiver, BondStateReceiver.createIntentFilter());

                if (mTargetBluetoothDevice.createBond()) {
                    // set timeout message
                    mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);
                } else {
                    mContext.unregisterReceiver(mBondStateReceiver);
                    mProfileCallback.onBondFailed(mTargetBluetoothDevice, UNKNOWN, mArgument);
                    nextProgress = PROGRESS_FINISHED;
                }
                mCurrentProgress = nextProgress;
            }
        } else if (PROGRESS_BOND_START == mCurrentProgress) {
            BluetoothDevice bluetoothDevice = bundle.getParcelable(KEY_BLUETOOTH_DEVICE);
            if (mTargetBluetoothDevice.equals(bluetoothDevice)) {
                // current:bond start, next:bond success
                if (PROGRESS_BOND_SUCCESS == nextProgress) {
                    mContext.unregisterReceiver(mBondStateReceiver);
                    mProfileCallback.onBondSuccess(mTargetBluetoothDevice, mArgument);
                    mTaskHandler.removeCallbacksAndMessages(this);
                    mCurrentProgress = PROGRESS_FINISHED;
                } else if (PROGRESS_BOND_ERROR == nextProgress) {
                    // current:bond start, next:bond error
                    mContext.unregisterReceiver(mBondStateReceiver);
                    mProfileCallback.onBondFailed(mTargetBluetoothDevice, UNKNOWN, mArgument);
                    mTaskHandler.removeCallbacksAndMessages(this);
                    mCurrentProgress = PROGRESS_FINISHED;
                }
            }
        }

        return PROGRESS_FINISHED == mCurrentProgress || PROGRESS_TIMEOUT == mCurrentProgress;
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
        if (PROGRESS_BOND_START == mCurrentProgress) {
            mContext.unregisterReceiver(mBondStateReceiver);
        }
        mProfileCallback.onBondFailed(mTargetBluetoothDevice, CANCEL, mArgument);
        mTaskHandler.removeCallbacksAndMessages(this);
        mCurrentProgress = PROGRESS_FINISHED;
    }

}
