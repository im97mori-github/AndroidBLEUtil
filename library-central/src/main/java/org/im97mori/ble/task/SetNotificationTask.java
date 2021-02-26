package org.im97mori.ble.task;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.TaskHandler;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.ErrorCodes.BUSY;
import static org.im97mori.ble.BLEConstants.ErrorCodes.CANCEL;

/**
 * Set notification task
 * <p>
 * for central role
 */
public class SetNotificationTask extends AbstractBLETask {

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
     * task target service {@link UUID}
     */
    private final UUID mServiceUUID;

    /**
     * task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     */
    private Integer mServiceInstanceId;

    /**
     * task target characteristic {@link UUID}
     */
    private final UUID mCharacteristicUUID;

    /**
     * task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     */
    private Integer mCharacteristicInstanceId;

    /**
     * {@link BluetoothGatt#setCharacteristicNotification(BluetoothGattCharacteristic, boolean)} 2nd paramater
     */
    private final boolean mNotificationStatus;

    /**
     * callback argument
     */
    private final Bundle mArgumemnt;

    /**
     * @param bleConnection            task target {@link BLEConnection} instance
     * @param bluetoothGatt            task target {@link BluetoothGatt} instance
     * @param taskHandler              task target {@link TaskHandler} instance
     * @param serviceUUID              task target service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       task target characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param notificationStatus       {@link BluetoothGatt#setCharacteristicNotification(BluetoothGattCharacteristic, boolean)} 2nd paramater
     * @param argument                 callback argument
     */
    public SetNotificationTask(@NonNull BLEConnection bleConnection
            , @NonNull BluetoothGatt bluetoothGatt
            , @NonNull TaskHandler taskHandler
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , boolean notificationStatus
            , @NonNull Bundle argument) {
        mBLEConnection = bleConnection;
        mBluetoothGatt = bluetoothGatt;
        mTaskHandler = taskHandler;
        mServiceUUID = serviceUUID;
        mServiceInstanceId = serviceInstanceId;
        mCharacteristicUUID = characteristicUUID;
        mCharacteristicInstanceId = characteristicInstanceId;
        mNotificationStatus = notificationStatus;
        mArgumemnt = argument;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public Message createInitialMessage() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_SERVICE_UUID, mServiceUUID);
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, mCharacteristicUUID);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_SET_NOTIFICATION_START);
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

            if (PROGRESS_INIT == mCurrentProgress) {
                // current:init, next:set notification start
                if (message.obj == this && PROGRESS_SET_NOTIFICATION_START == nextProgress) {
                    boolean result = false;
                    BluetoothGattService bluetoothGattService = null;
                    if (mServiceInstanceId == null) {
                        bluetoothGattService = mBluetoothGatt.getService(mServiceUUID);
                    } else {
                        // multiple service
                        List<BluetoothGattService> serviceList = mBluetoothGatt.getServices();
                        for (BluetoothGattService targetBluetoothGattService : serviceList) {
                            if (mServiceUUID.equals(targetBluetoothGattService.getUuid()) && mServiceInstanceId == targetBluetoothGattService.getInstanceId()) {
                                bluetoothGattService = targetBluetoothGattService;
                                break;
                            }
                        }
                    }
                    if (bluetoothGattService != null) {
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = null;
                        if (mCharacteristicInstanceId == null) {
                            bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(mCharacteristicUUID);
                        } else {
                            // multiple characteristic
                            List<BluetoothGattCharacteristic> characteristicList = bluetoothGattService.getCharacteristics();
                            for (BluetoothGattCharacteristic targetBluetoothGattCharacteristic : characteristicList) {
                                if (mCharacteristicUUID.equals(targetBluetoothGattCharacteristic.getUuid()) && mCharacteristicInstanceId == targetBluetoothGattCharacteristic.getInstanceId()) {
                                    bluetoothGattCharacteristic = targetBluetoothGattCharacteristic;
                                    break;
                                }
                            }
                        }

                        if (bluetoothGattCharacteristic != null) {
                            mServiceInstanceId = bluetoothGattService.getInstanceId();
                            mCharacteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();

                            result = mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, mNotificationStatus);
                        }
                    }

                    if (result) {
                        nextProgress = PROGRESS_FINISHED;
                        mBLEConnection.getBLECallback().onSetNotificationSuccess(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mNotificationStatus, mArgumemnt);
                    } else {
                        nextProgress = PROGRESS_BUSY;
                        mBLEConnection.getBLECallback().onSetNotificationFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mNotificationStatus, BUSY, mArgumemnt);
                    }
                }
                mCurrentProgress = nextProgress;
            }
        }

        return PROGRESS_FINISHED == mCurrentProgress | PROGRESS_BUSY == mCurrentProgress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBusy() {
        return PROGRESS_BUSY == mCurrentProgress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancel() {
        mTaskHandler.removeCallbacksAndMessages(this);
        mCurrentProgress = PROGRESS_FINISHED;
        mBLEConnection.getBLECallback().onSetNotificationFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mNotificationStatus, CANCEL, mArgumemnt);
    }

}
