package org.im97mori.ble.task;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.TaskHandler;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.ErrorCodes.BUSY;
import static org.im97mori.ble.BLEConstants.ErrorCodes.CANCEL;
import static org.im97mori.ble.BLEConstants.ErrorCodes.UNKNOWN;

/**
 * Set characteristic notification task
 */
@SuppressWarnings("JavadocReference")
public class WriteDescriptorTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for write:10sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 10;

    /**
     * create write descriptor message
     *
     * @param serviceUUID        target service UUID
     * @param characteristicUUID target characteristic UUID
     * @param descriptorUUID     target descriptor UUID
     * @param obj                instance for {@link android.os.Handler#removeCallbacksAndMessages(Object)}
     * @return write descriptor {@link Message} instance
     */
    public static Message createWriteDescriptorMessage(UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, Object obj) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_SERVICE_UUID, serviceUUID);
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, characteristicUUID);
        bundle.putSerializable(KEY_DESCRIPTOR_UUID, descriptorUUID);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_DESCRIPTOR_WRITE_START);
        Message message = new Message();
        message.setData(bundle);
        message.obj = obj;
        return message;
    }

    /**
     * create write descriptor finished message
     *
     * @param serviceUUID        target service UUID
     * @param characteristicUUID target characteristic UUID
     * @param descriptorUUID     target descriptor UUID
     * @param values             {@link BluetoothGattDescriptor#getValue()}
     * @return write descriptor finished {@link Message} instance
     */
    public static Message createWriteDescriptorFinishedMessage(UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_SERVICE_UUID, serviceUUID);
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, characteristicUUID);
        bundle.putSerializable(KEY_DESCRIPTOR_UUID, descriptorUUID);
        bundle.putByteArray(KEY_VALUES, values);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_DESCRIPTOR_WRITE_SUCCESS);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * create write descriptor finished message
     *
     * @param serviceUUID        target service UUID
     * @param characteristicUUID target characteristic UUID
     * @param descriptorUUID     target descriptor UUID
     * @param status             {@link android.bluetooth.BluetoothGattCallback#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     * @return write descriptor error {@link Message} instance
     */
    public static Message createWriteDescriptorErrorMessage(UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_SERVICE_UUID, serviceUUID);
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, characteristicUUID);
        bundle.putSerializable(KEY_DESCRIPTOR_UUID, descriptorUUID);
        bundle.putInt(KEY_STATUS, status);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_DESCRIPTOR_WRITE_ERROR);
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
     * task target service {@link UUID}
     */
    private final UUID mServiceUUID;

    /**
     * task target characteristic {@link UUID}
     */
    private final UUID mCharacteristicUUID;

    /**
     * task target descriptor {@link UUID}
     */
    private final UUID mDescriptorUUID;

    /**
     * task target data class
     */
    private final ByteArrayInterface mByteArrayInterface;

    /**
     * timeout(millis)
     */
    private final long mTimeout;

    /**
     * callback argument
     */
    private final Bundle mArguemnt;

    /**
     * @param bleConnection      task target {@link BLEConnection} instance
     * @param bluetoothGatt      task target {@link TaskHandler} instance
     * @param taskHandler        task target {@link BluetoothGatt} instance
     * @param serviceUUID        task target service {@link UUID}
     * @param characteristicUUID task target characteristic {@link UUID}
     * @param byteArrayInterface task target data class
     * @param timeout            timeout(millis)
     * @param argument           callback argument
     */
    public WriteDescriptorTask(BLEConnection bleConnection, BluetoothGatt bluetoothGatt, TaskHandler taskHandler, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, ByteArrayInterface byteArrayInterface, long timeout, Bundle argument) {
        mBLEConnection = bleConnection;
        mBluetoothGatt = bluetoothGatt;
        mTaskHandler = taskHandler;
        mServiceUUID = serviceUUID;
        mCharacteristicUUID = characteristicUUID;
        mDescriptorUUID = descriptorUUID;
        mByteArrayInterface = byteArrayInterface;
        mTimeout = timeout;
        mArguemnt = argument;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean doProcess(Message message) {
        Bundle bundle = message.getData();
        UUID serviceUUID = (UUID) bundle.getSerializable(KEY_SERVICE_UUID);
        UUID characteristicUUID = (UUID) bundle.getSerializable(KEY_CHARACTERISTIC_UUID);
        UUID descriptorUUID = (UUID) bundle.getSerializable(KEY_DESCRIPTOR_UUID);
        int nextProgress = bundle.getInt(KEY_NEXT_PROGRESS);

        // timeout
        if (this == message.obj && PROGRESS_TIMEOUT == nextProgress) {
            mBLEConnection.getBLECallback().onDescriptorWriteTimeout(mTaskId, mBLEConnection.getBluetoothDevice(), mServiceUUID, mCharacteristicUUID, mDescriptorUUID, mTimeout, mArguemnt);
            mCurrentProgress = PROGRESS_TIMEOUT;
        } else if (PROGRESS_INIT == mCurrentProgress) {
            // current:init, next:write start
            if (message.obj == this && PROGRESS_DESCRIPTOR_WRITE_START == nextProgress) {

                BluetoothGattDescriptor bluetoothGattDescriptor = null;
                boolean result = false;
                BluetoothGattService bluetoothGattService = mBluetoothGatt.getService(mServiceUUID);
                if (bluetoothGattService != null) {
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(mCharacteristicUUID);
                    if (bluetoothGattCharacteristic != null) {
                        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(mDescriptorUUID);
                        if (bluetoothGattDescriptor != null) {
                            byte[] bytes = mByteArrayInterface.getBytes();
                            bluetoothGattDescriptor.setValue(bytes);

                            // write descriptor
                            result = mBluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
                        }
                    }
                }

                if (result) {
                    // set timeout message
                    mTaskHandler.sendProcessingMessage(createTimeoutMessage(mCharacteristicUUID, this), mTimeout);
                } else {
                    if (bluetoothGattDescriptor == null) {
                        nextProgress = PROGRESS_FINISHED;
                        mBLEConnection.getBLECallback().onDescriptorWriteFailed(mTaskId, mBLEConnection.getBluetoothDevice(), mServiceUUID, mCharacteristicUUID, mDescriptorUUID, UNKNOWN, mArguemnt);
                    } else {
                        nextProgress = PROGRESS_BUSY;
                        mBLEConnection.getBLECallback().onDescriptorWriteFailed(mTaskId, mBLEConnection.getBluetoothDevice(), mServiceUUID, mCharacteristicUUID, mDescriptorUUID, BUSY, mArguemnt);
                    }
                }
                mCurrentProgress = nextProgress;
            }
        } else if (PROGRESS_DESCRIPTOR_WRITE_START == mCurrentProgress) {
            if (mServiceUUID.equals(serviceUUID) && mCharacteristicUUID.equals(characteristicUUID) || mDescriptorUUID.equals(descriptorUUID)) {
                // current:write start, next:write success
                if (PROGRESS_DESCRIPTOR_WRITE_SUCCESS == nextProgress) {
                    mBLEConnection.getBLECallback().onDescriptorWriteSuccess(mTaskId, mBLEConnection.getBluetoothDevice(), mServiceUUID, mCharacteristicUUID, mDescriptorUUID, bundle.getByteArray(KEY_VALUES), mArguemnt);
                } else if (PROGRESS_DESCRIPTOR_WRITE_ERROR == nextProgress) {
                    // current:write start, next:write error
                    mBLEConnection.getBLECallback().onDescriptorWriteFailed(mTaskId, mBLEConnection.getBluetoothDevice(), mServiceUUID, mCharacteristicUUID, mDescriptorUUID, bundle.getInt(KEY_STATUS), mArguemnt);
                }

                mCurrentProgress = PROGRESS_FINISHED;
                // remove timeout message
                mTaskHandler.removeCallbacksAndMessages(this);
            }
        }

        return PROGRESS_FINISHED == mCurrentProgress || PROGRESS_BUSY == mCurrentProgress || PROGRESS_TIMEOUT == mCurrentProgress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBusy() {
        return PROGRESS_BUSY == mCurrentProgress || PROGRESS_TIMEOUT == mCurrentProgress;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancel() {
        mBLEConnection.getBLECallback().onDescriptorWriteFailed(mTaskId, mBLEConnection.getBluetoothDevice(), mServiceUUID, mCharacteristicUUID, mDescriptorUUID, CANCEL, mArguemnt);
    }

}
