package org.im97mori.ble_peripheral.task;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Message;

import org.im97mori.ble.task.AbstractBLETask;
import org.im97mori.ble_peripheral.BLEPeripheralLogUtils;
import org.im97mori.ble_peripheral.BLEServerCallback;
import org.im97mori.ble.ByteArrayInterface;

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
     * callback argument
     */
    private final Bundle mArgument;

    /**
     * @param bleServerCallback   {@link BLEServerCallback} instance
     * @param bluetoothGattServer {@link BluetoothGattServer} instance
     * @param bluetoothDevice     BLE device
     * @param serviceUUID         service {@link UUID}
     * @param characteristicUUID  characteristic {@link UUID}
     * @param byteArrayInterface  task target data class
     * @param isConfirm           {@code true}:indication, {@code false}:notification
     * @param argument            callback argument
     */
    public NotificationTask(BLEServerCallback bleServerCallback, BluetoothGattServer bluetoothGattServer, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, ByteArrayInterface byteArrayInterface, boolean isConfirm, Bundle argument) {
        mBLEServerCallback = bleServerCallback;
        mBluetoothGattServer = bluetoothGattServer;
        mBluetoothDevice = bluetoothDevice;
        mServiceUUID = serviceUUID;
        mCharacteristicUUID = characteristicUUID;
        mByteArrayInterface = byteArrayInterface;
        mIsConfirm = isConfirm;
        mArgument = argument;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Message createInitialMessage() {
        Bundle bundle = new Bundle();
        bundle.putInt(AbstractBLETask.KEY_NEXT_PROGRESS, AbstractBLETask.PROGRESS_NOTIFICATION);
        Message message = new Message();
        message.setData(bundle);
        message.obj = this;
        return message;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean doProcess(Message message) {
        Bundle bundle = message.getData();
        int nextProgress = bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS);

        if (AbstractBLETask.PROGRESS_INIT == mCurrentProgress) {
            // current:init, next:notification
            if (this == message.obj && AbstractBLETask.PROGRESS_NOTIFICATION == nextProgress) {
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
                    nextProgress = AbstractBLETask.PROGRESS_FINISHED;
                    mBLEServerCallback.onNotificationSuccess(mTaskId, mBluetoothGattServer, mBluetoothDevice, mServiceUUID, mCharacteristicUUID, values, mArgument);
                } else {
                    if (bluetoothGattCharacteristic == null) {
                        nextProgress = AbstractBLETask.PROGRESS_FINISHED;
                        mBLEServerCallback.onNotificationFailed(mTaskId, mBluetoothGattServer, mBluetoothDevice, mServiceUUID, mCharacteristicUUID, UNKNOWN, mArgument);
                    } else {
                        nextProgress = AbstractBLETask.PROGRESS_BUSY;
                        mBLEServerCallback.onNotificationFailed(mTaskId, mBluetoothGattServer, mBluetoothDevice, mServiceUUID, mCharacteristicUUID, BUSY, mArgument);
                    }
                }

                mCurrentProgress = nextProgress;
            }
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
        mBLEServerCallback.onNotificationFailed(mTaskId, mBluetoothGattServer, mBluetoothDevice, mServiceUUID, mCharacteristicUUID, CANCEL, mArgument);
    }
}
