package org.im97mori.ble.task;

import static org.im97mori.ble.constants.ErrorCodeAndroid.BUSY;
import static org.im97mori.ble.constants.ErrorCodeAndroid.CANCEL;
import static org.im97mori.ble.constants.ErrorCodeAndroid.UNKNOWN;

import android.annotation.SuppressLint;
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
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.TaskHandler;

import java.util.List;
import java.util.UUID;

/**
 * Notification / Indication task
 * <p>
 * for peripheral role
 */
public class NotificationTask extends AbstractBLETask {

    /**
     * KEY:STATUS
     */
    public static final String KEY_STATUS = "KEY_STATUS";

    /**
     * KEY:BLUETOOTH_DEVICE
     */
    public static final String KEY_BLUETOOTH_DEVICE = "KEY_BLUETOOTH_DEVICE";

    /**
     * PROGRESS:NOTIFICATION_START
     */
    public static final String PROGRESS_NOTIFICATION_START = "PROGRESS_NOTIFICATION_START";

    /**
     * PROGRESS:NOTIFICATION_SUCCESS
     */
    public static final String PROGRESS_NOTIFICATION_SUCCESS = "PROGRESS_NOTIFICATION_SUCCESS";

    /**
     * PROGRESS:NOTIFICATION_ERROR
     */
    public static final String PROGRESS_NOTIFICATION_ERROR = "PROGRESS_NOTIFICATION_ERROR";

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
     * create notification sent success message
     *
     * @param bluetoothDevice BLE device
     * @return otification sent success {@link Message} instance
     */
    @NonNull
    public static Message createNotificationSentSuccessMessage(BluetoothDevice bluetoothDevice) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_BLUETOOTH_DEVICE, bluetoothDevice);
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_NOTIFICATION_SUCCESS);
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
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_NOTIFICATION_ERROR);
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
     * service {@link UUID}
     */
    private final UUID mServiceUUID;

    /**
     * task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     */
    private final int mServiceInstanceId;

    /**
     * task target characteristic {@link UUID}
     */
    private final UUID mCharacteristicUUID;

    /**
     * task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     */
    private final int mCharacteristicInstanceId;

    /**
     * task target data
     */
    private final byte[] mByteArray;

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
     * @param bleServerConnection      {@link BLEServerConnection} instance
     * @param bluetoothGattServer      {@link BluetoothGattServer} instance
     * @param bluetoothDevice          BLE device
     * @param taskHandler              task target {@link TaskHandler} instance
     * @param serviceUUID              task target service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       task target characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param byteArray                task target data
     * @param isConfirm                {@code true}:indication, {@code false}:notification
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    public NotificationTask(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattServer bluetoothGattServer
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull TaskHandler taskHandler
            , @NonNull UUID serviceUUID
            , int serviceInstanceId
            , @NonNull UUID characteristicUUID
            , int characteristicInstanceId
            , @NonNull byte[] byteArray
            , boolean isConfirm
            , long timeout
            , @Nullable Bundle argument) {
        mBLEServerConnection = bleServerConnection;
        mBluetoothGattServer = bluetoothGattServer;
        mBluetoothDevice = bluetoothDevice;
        mTaskHandler = taskHandler;
        mServiceUUID = serviceUUID;
        mServiceInstanceId = serviceInstanceId;
        mCharacteristicUUID = characteristicUUID;
        mCharacteristicInstanceId = characteristicInstanceId;
        mByteArray = byteArray;
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
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_NOTIFICATION_START);
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
                mBLEServerConnection.getBLEServerCallback().onNotificationTimeout(getTaskId(), mBLEServerConnection, mBluetoothDevice, mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mTimeout, mArgument);
                mCurrentProgress = nextProgress;
            } else if (PROGRESS_INIT.equals(mCurrentProgress)) {
                // current:init, next:notification start
                if (this == message.obj && PROGRESS_NOTIFICATION_START.equals(nextProgress)) {
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = null;
                    boolean result = false;
                    BluetoothGattService bluetoothGattService = null;
                    List<BluetoothGattService> serviceList = mBluetoothGattServer.getServices();
                    for (BluetoothGattService targetBluetoothGattService : serviceList) {
                        if (mServiceUUID.equals(targetBluetoothGattService.getUuid()) && mServiceInstanceId == targetBluetoothGattService.getInstanceId()) {
                            bluetoothGattService = targetBluetoothGattService;
                            break;
                        }
                    }
                    if (bluetoothGattService != null) {
                        List<BluetoothGattCharacteristic> characteristicList = bluetoothGattService.getCharacteristics();
                        for (BluetoothGattCharacteristic targetBluetoothGattCharacteristic : characteristicList) {
                            if (mCharacteristicUUID.equals(targetBluetoothGattCharacteristic.getUuid()) && mCharacteristicInstanceId == targetBluetoothGattCharacteristic.getInstanceId()) {
                                bluetoothGattCharacteristic = targetBluetoothGattCharacteristic;
                                break;
                            }
                        }
                        if (bluetoothGattCharacteristic != null) {
                            bluetoothGattCharacteristic.setValue(mByteArray);

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
                            nextProgress = PROGRESS_FINISHED;
                            mBLEServerConnection.getBLEServerCallback().onNotificationFailed(getTaskId(), mBLEServerConnection, mBluetoothDevice, mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, UNKNOWN, mArgument);
                        } else {
                            nextProgress = PROGRESS_BUSY;
                            mBLEServerConnection.getBLEServerCallback().onNotificationFailed(getTaskId(), mBLEServerConnection, mBluetoothDevice, mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, BUSY, mArgument);
                        }
                    }

                    mCurrentProgress = nextProgress;
                }
            } else if (PROGRESS_NOTIFICATION_START.equals(mCurrentProgress)) {
                if (PROGRESS_NOTIFICATION_SUCCESS.equals(nextProgress)) {
                    // current:notification start, next:notification success

                    mBLEServerConnection.getBLEServerCallback().onNotificationSuccess(getTaskId(), mBLEServerConnection, mBluetoothDevice, mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mByteArray, mArgument);
                } else if (PROGRESS_NOTIFICATION_ERROR.equals(nextProgress)) {
                    // current:notification start, next:notification error

                    mBLEServerConnection.getBLEServerCallback().onNotificationFailed(getTaskId(), mBLEServerConnection, mBluetoothDevice, mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, bundle.getInt(KEY_STATUS), mArgument);
                }

                mCurrentProgress = PROGRESS_FINISHED;
                // remove timeout message
                mTaskHandler.removeCallbacksAndMessages(this);
            }
        }

        return PROGRESS_FINISHED.equals(mCurrentProgress) || PROGRESS_BUSY.equals(mCurrentProgress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBusy() {
        return PROGRESS_BUSY.equals(mCurrentProgress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancel() {
        mTaskHandler.removeCallbacksAndMessages(this);
        mCurrentProgress = PROGRESS_FINISHED;
        mBLEServerConnection.getBLEServerCallback().onNotificationFailed(getTaskId(), mBLEServerConnection, mBluetoothDevice, mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, CANCEL, mArgument);
    }
}
