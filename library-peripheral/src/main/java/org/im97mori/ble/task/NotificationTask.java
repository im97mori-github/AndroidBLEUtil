package org.im97mori.ble.task;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEPeripheralLogUtils;
import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.TaskHandler;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.ErrorCodes.BUSY;
import static org.im97mori.ble.BLEConstants.ErrorCodes.CANCEL;
import static org.im97mori.ble.BLEConstants.ErrorCodes.UNKNOWN;

/**
 * Notification / Indication task
 * <p>
 * for peripheral role
 */
public class NotificationTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for read:5sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 5;

    /**
     * create notification sent success message
     *
     * @param bluetoothDevice BLE device
     * @return otification sent success {@link Message} instance
     */
    @NonNull
    public static Message createNotificationSentSuccessMessage(BluetoothDevice bluetoothDevice) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_BLUETOOTH_DEVICE, bluetoothDevice);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_NOTIFICATION_SUCCESS);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * create notification sent success message
     *
     * @param bluetoothDevice BLE device
     * @param status          {@link android.bluetooth.BluetoothGattServerCallback#onNotificationSent(BluetoothDevice, int)} 2nd argument
     * @return otification sent success {@link Message} instance
     */
    @NonNull
    public static Message createNotificationSentErrorMessage(BluetoothDevice bluetoothDevice, int status) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_BLUETOOTH_DEVICE, bluetoothDevice);
        bundle.putInt(KEY_STATUS, status);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_NOTIFICATION_ERROR);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }


    /**
     * {@link BLEServerCallback} instance
     */
    private final BLEServerCallback mBLEServerCallback;

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
     * service {@link UUID}
     */
    private final UUID mServiceUUID;

    /**
     * characteristic {@link UUID}
     */
    private final UUID mCharacteristicUUID;

    /**
     * task target data class
     */
    private final ByteArrayInterface mByteArrayInterface;

    /**
     * {@code true}:indication, {@code false}:notification
     */
    private final boolean mIsConfirm;

    /**
     * timeout(millis)
     */
    private final long mTimeout;

    /**
     * callback argument
     */
    private final Bundle mArgument;

    /**
     * @param bleServerCallback   {@link BLEServerCallback} instance
     * @param bluetoothGattServer {@link BluetoothGattServer} instance
     * @param bluetoothDevice     BLE device
     * @param taskHandler         task target {@link TaskHandler} instance
     * @param serviceUUID         service {@link UUID}
     * @param characteristicUUID  characteristic {@link UUID}
     * @param byteArrayInterface  task target data class
     * @param isConfirm           {@code true}:indication, {@code false}:notification
     * @param timeout             timeout(millis)
     * @param argument            callback argument
     */
    public NotificationTask(@NonNull BLEServerCallback bleServerCallback, @NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice bluetoothDevice, @NonNull TaskHandler taskHandler, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull ByteArrayInterface byteArrayInterface, boolean isConfirm, long timeout, @Nullable Bundle argument) {
        mBLEServerCallback = bleServerCallback;
        mBluetoothGattServer = bluetoothGattServer;
        mBluetoothDevice = bluetoothDevice;
        mTaskHandler = taskHandler;
        mServiceUUID = serviceUUID;
        mCharacteristicUUID = characteristicUUID;
        mByteArrayInterface = byteArrayInterface;
        mIsConfirm = isConfirm;
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
        bundle.putInt(AbstractBLETask.KEY_NEXT_PROGRESS, AbstractBLETask.PROGRESS_NOTIFICATION_START);
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
        int nextProgress = bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS);

        // timeout
        if (this == message.obj && PROGRESS_TIMEOUT == nextProgress) {
            mBLEServerCallback.onNotificationTimeout(getTaskId(), mBluetoothGattServer, mBluetoothDevice, mServiceUUID, mCharacteristicUUID, mTimeout, mArgument);
            mCurrentProgress = nextProgress;
        } else if (AbstractBLETask.PROGRESS_INIT == mCurrentProgress) {
            // current:init, next:notification start
            if (this == message.obj && AbstractBLETask.PROGRESS_NOTIFICATION_START == nextProgress) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = null;
                boolean result = false;
                BluetoothGattService bluetoothGattService = mBluetoothGattServer.getService(mServiceUUID);
                byte[] values = mByteArrayInterface.getBytes();
                if (bluetoothGattService != null) {
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(mCharacteristicUUID);
                    if (bluetoothGattCharacteristic != null) {
                        bluetoothGattCharacteristic.setValue(values);

                        // notification(indication)
                        try {
                            result = mBluetoothGattServer.notifyCharacteristicChanged(mBluetoothDevice, bluetoothGattCharacteristic, mIsConfirm);
                        } catch (Exception e) {
                            BLEPeripheralLogUtils.stackLog(e);
                        }
                    }
                }

                if (result) {
                    // set timeout message
                    Message timeoutMessage = createTimeoutMessage(this);
                    mTaskHandler.sendProcessingMessage(timeoutMessage, mTimeout);
                } else {
                    if (bluetoothGattCharacteristic == null) {
                        nextProgress = AbstractBLETask.PROGRESS_FINISHED;
                        mBLEServerCallback.onNotificationFailed(getTaskId(), mBluetoothGattServer, mBluetoothDevice, mServiceUUID, mCharacteristicUUID, UNKNOWN, mArgument);
                    } else {
                        nextProgress = AbstractBLETask.PROGRESS_BUSY;
                        mBLEServerCallback.onNotificationFailed(getTaskId(), mBluetoothGattServer, mBluetoothDevice, mServiceUUID, mCharacteristicUUID, BUSY, mArgument);
                    }
                }

                mCurrentProgress = nextProgress;
            }
        } else if (PROGRESS_NOTIFICATION_START == mCurrentProgress) {
            if (AbstractBLETask.PROGRESS_NOTIFICATION_SUCCESS == nextProgress) {
                // current:notification start, next:notification success

                mBLEServerCallback.onNotificationSuccess(getTaskId(), mBluetoothGattServer, mBluetoothDevice, mServiceUUID, mCharacteristicUUID, mByteArrayInterface.getBytes(), mArgument);
            } else if (AbstractBLETask.PROGRESS_NOTIFICATION_ERROR == nextProgress) {
                // current:notification start, next:notification error

                mBLEServerCallback.onNotificationFailed(getTaskId(), mBluetoothGattServer, mBluetoothDevice, mServiceUUID, mCharacteristicUUID, bundle.getInt(KEY_STATUS), mArgument);
            }

            mCurrentProgress = PROGRESS_FINISHED;
            // remove timeout message
            mTaskHandler.removeCallbacksAndMessages(this);
        }

        return AbstractBLETask.PROGRESS_FINISHED == mCurrentProgress || AbstractBLETask.PROGRESS_BUSY == mCurrentProgress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBusy() {
        return AbstractBLETask.PROGRESS_BUSY == mCurrentProgress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancel() {
        mCurrentProgress = AbstractBLETask.PROGRESS_FINISHED;
        mBLEServerCallback.onNotificationFailed(getTaskId(), mBluetoothGattServer, mBluetoothDevice, mServiceUUID, mCharacteristicUUID, CANCEL, mArgument);
    }
}
