package org.im97mori.ble.task;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.TaskHandler;
import org.im97mori.ble.characteristic.AbstractCharacteristic;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.ErrorCodes.UNKNOWN;

/**
 * Write characteristic task
 */
@SuppressWarnings("JavadocReference")
public class WriteCharacteristicTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for write:10sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 10;

    /**
     * create write characteristic message
     *
     * @param characteristicUUID target characteristic UUID
     * @param obj                instance for {@link android.os.Handler#removeCallbacksAndMessages(Object)}
     * @return write characteristic {@link Message} instance
     */
    public static Message createWriteCharacteristicMessage(UUID characteristicUUID, Object obj) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, characteristicUUID);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_CHARACTERISTIC_WRITE_START);
        Message message = new Message();
        message.setData(bundle);
        message.obj = obj;
        return message;
    }

    /**
     * create write characteristic finished message
     *
     * @param characteristicUUID target characteristic UUID
     * @param values             {@link BluetoothGattCharacteristic#getValue()}
     * @return write characteristic finished {@link Message} instance
     */
    public static Message createWriteCharacteristicFinishedMessage(UUID characteristicUUID, byte[] values) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, characteristicUUID);
        bundle.putByteArray(KEY_VALUES, values);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_CHARACTERISTIC_WRITE_SUCCESS);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * create write characteristic error message
     *
     * @param characteristicUUID target characteristic UUID
     * @param status             {@link android.bluetooth.BluetoothGattCallback#onCharacteristicWrite(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     * @return write characteristic error {@link Message} instance
     */
    public static Message createWriteCharacteristicErrorMessage(UUID characteristicUUID, int status) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, characteristicUUID);
        bundle.putInt(KEY_STATUS, status);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_CHARACTERISTIC_WRITE_ERROR);
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
     * task target data class
     */
    private final AbstractCharacteristic mAbstractCharacteristic;

    /**
     * timeout(millis)
     */
    private final long mTimeout;

    /**
     * @param bleConnection          task target {@link BLEConnection} instance
     * @param bluetoothGatt          task target {@link BluetoothGatt} instance
     * @param taskHandler            task target service {@link UUID}
     * @param serviceUUID            task target characteristic {@link UUID}
     * @param characteristicUUID     task target {@link TaskHandler} instance
     * @param abstractCharacteristic task target data class
     * @param timeout                timeout(millis)
     */
    public WriteCharacteristicTask(BLEConnection bleConnection, BluetoothGatt bluetoothGatt, TaskHandler taskHandler, UUID serviceUUID, UUID characteristicUUID, AbstractCharacteristic abstractCharacteristic, long timeout) {
        mBLEConnection = bleConnection;
        mBluetoothGatt = bluetoothGatt;
        mTaskHandler = taskHandler;
        mServiceUUID = serviceUUID;
        mCharacteristicUUID = characteristicUUID;
        mAbstractCharacteristic = abstractCharacteristic;
        mTimeout = timeout;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean doProcess(Message message) {
        Bundle bundle = message.getData();
        UUID characteristicUUID = (UUID) bundle.getSerializable(KEY_CHARACTERISTIC_UUID);
        int nextProgress = bundle.getInt(KEY_NEXT_PROGRESS);

        // timeout
        if (message.obj == this && PROGRESS_TIMEOUT == nextProgress) {
            mBLEConnection.getBLECallback().onCharacteristicWriteTimeout(mBLEConnection.getBluetoothDevice(), mCharacteristicUUID, mTimeout);
            mCurrentProgress = nextProgress;
        } else if (PROGRESS_INIT == mCurrentProgress) {
            // current:init, next:write start
            if (message.obj == this && PROGRESS_CHARACTERISTIC_WRITE_START == nextProgress) {
                BluetoothGattService bluetoothGattService = mBluetoothGatt.getService(mServiceUUID);
                if (bluetoothGattService != null) {
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(mCharacteristicUUID);
                    if (bluetoothGattCharacteristic != null) {
                        bluetoothGattCharacteristic.setValue(mAbstractCharacteristic.getBytes());

                        // write characteristic
                        if (mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic)) {

                            // set timeout message
                            mTaskHandler.sendProcessingMessage(createTimeoutMessage(mCharacteristicUUID, this), mTimeout);
                        } else {
                            nextProgress = PROGRESS_FINISHED;
                            mBLEConnection.getBLECallback().onCharacteristicWriteFailed(mBLEConnection.getBluetoothDevice(), mCharacteristicUUID, UNKNOWN);
                        }
                    }
                }
                mCurrentProgress = nextProgress;
            }
        } else if (PROGRESS_CHARACTERISTIC_WRITE_START == mCurrentProgress) {
            if (mCharacteristicUUID.equals(characteristicUUID)) {
                // current:write start, next:write success
                if (PROGRESS_CHARACTERISTIC_WRITE_SUCCESS == nextProgress) {
                    mBLEConnection.getBLECallback().onCharacteristicWriteSuccess(mBLEConnection.getBluetoothDevice(), mCharacteristicUUID, bundle.getByteArray(KEY_VALUES));
                } else if (PROGRESS_CHARACTERISTIC_WRITE_ERROR == nextProgress) {
                    // current:write start, next:write error
                    mBLEConnection.getBLECallback().onCharacteristicWriteFailed(mBLEConnection.getBluetoothDevice(), mCharacteristicUUID, bundle.getInt(KEY_STATUS));
                }

                mCurrentProgress = PROGRESS_FINISHED;
                // remove timeout message
                mTaskHandler.removeCallbacksAndMessages(this);
            }
        }

        return PROGRESS_FINISHED == mCurrentProgress || PROGRESS_TIMEOUT == mCurrentProgress;
    }

}
