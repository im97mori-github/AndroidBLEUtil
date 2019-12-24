package org.im97mori.ble.task;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLELogUtils;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.TaskHandler;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.ErrorCodes.BUSY;
import static org.im97mori.ble.BLEConstants.ErrorCodes.CANCEL;
import static org.im97mori.ble.BLEConstants.ErrorCodes.UNKNOWN;

/**
 * Write characteristic task
 * <p>
 * for central role
 */
@SuppressWarnings("unused")
public class WriteCharacteristicTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for write characteristic:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

    /**
     * create write characteristic success message
     *
     * @param serviceUUID        target service UUID
     * @param characteristicUUID target characteristic UUID
     * @param values             {@link BluetoothGattCharacteristic#getValue()}
     * @return write characteristic success {@link Message} instance
     */
    @NonNull
    public static Message createWriteCharacteristicSuccessMessage(@NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_SERVICE_UUID, serviceUUID);
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
     * @param serviceUUID        target service UUID
     * @param characteristicUUID target characteristic UUID
     * @param status             {@link android.bluetooth.BluetoothGattCallback#onCharacteristicWrite(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     * @return write characteristic error {@link Message} instance
     */
    @NonNull
    public static Message createWriteCharacteristicErrorMessage(@NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_SERVICE_UUID, serviceUUID);
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
    private final ByteArrayInterface mbyteArrayInterface;

    /**
     * one of {@link BluetoothGattCharacteristic#WRITE_TYPE_DEFAULT}, {@link BluetoothGattCharacteristic#WRITE_TYPE_NO_RESPONSE}, {@link BluetoothGattCharacteristic#WRITE_TYPE_SIGNED}
     */
    private final int mWriteType;

    /**
     * timeout(millis)
     */
    private final long mTimeout;

    /**
     * callback argument
     */
    private final Bundle mArgumemnt;

    /**
     * @param bleConnection      task target {@link BLEConnection} instance
     * @param bluetoothGatt      task target {@link BluetoothGatt} instance
     * @param taskHandler        task target {@link TaskHandler} instance
     * @param serviceUUID        task target service {@link UUID}
     * @param characteristicUUID task target characteristic {@link UUID}
     * @param byteArrayInterface task target data class
     * @param writeType          one of {@link BluetoothGattCharacteristic#WRITE_TYPE_DEFAULT}, {@link BluetoothGattCharacteristic#WRITE_TYPE_NO_RESPONSE}, {@link BluetoothGattCharacteristic#WRITE_TYPE_SIGNED}
     * @param timeout            timeout(millis)
     * @param argument           callback argument
     */
    public WriteCharacteristicTask(@NonNull BLEConnection bleConnection
            , @NonNull BluetoothGatt bluetoothGatt
            , @NonNull TaskHandler taskHandler
            , @NonNull UUID serviceUUID
            , @NonNull UUID characteristicUUID
            , @NonNull ByteArrayInterface byteArrayInterface
            , int writeType
            , long timeout
            , @NonNull Bundle argument) {
        mBLEConnection = bleConnection;
        mBluetoothGatt = bluetoothGatt;
        mTaskHandler = taskHandler;
        mServiceUUID = serviceUUID;
        mCharacteristicUUID = characteristicUUID;
        mbyteArrayInterface = byteArrayInterface;
        mWriteType = writeType;
        mTimeout = timeout;
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
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_CHARACTERISTIC_WRITE_START);
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
        UUID serviceUUID = (UUID) bundle.getSerializable(KEY_SERVICE_UUID);
        UUID characteristicUUID = (UUID) bundle.getSerializable(KEY_CHARACTERISTIC_UUID);
        int nextProgress = bundle.getInt(KEY_NEXT_PROGRESS);

        // timeout
        if (message.obj == this && PROGRESS_TIMEOUT == nextProgress) {
            mBLEConnection.getBLECallback().onCharacteristicWriteTimeout(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mCharacteristicUUID, mTimeout, mArgumemnt);
            mCurrentProgress = nextProgress;
        } else if (PROGRESS_INIT == mCurrentProgress) {
            // current:init, next:write characteristic start
            if (message.obj == this && PROGRESS_CHARACTERISTIC_WRITE_START == nextProgress) {

                BluetoothGattCharacteristic bluetoothGattCharacteristic = null;
                boolean result = false;
                BluetoothGattService bluetoothGattService = mBluetoothGatt.getService(mServiceUUID);
                if (bluetoothGattService != null) {
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(mCharacteristicUUID);
                    if (bluetoothGattCharacteristic != null) {
                        bluetoothGattCharacteristic.setValue(mbyteArrayInterface.getBytes());
                        bluetoothGattCharacteristic.setWriteType(mWriteType);

                        // write characteristic
                        try {
                            result = mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
                        } catch (Exception e) {
                            BLELogUtils.stackLog(e);
                        }
                    }
                }

                if (result) {
                    // with response
                    if (BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT == mWriteType) {
                        // set timeout message
                        mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);
                    } else {
                        // with no response
                        mBLEConnection.getBLECallback().onCharacteristicWriteSuccess(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mCharacteristicUUID, mbyteArrayInterface.getBytes(), mArgumemnt);
                    }
                } else {
                    if (bluetoothGattCharacteristic == null) {
                        nextProgress = PROGRESS_FINISHED;
                        mBLEConnection.getBLECallback().onCharacteristicWriteFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mCharacteristicUUID, UNKNOWN, mArgumemnt);
                    } else {
                        nextProgress = PROGRESS_BUSY;
                        mBLEConnection.getBLECallback().onCharacteristicWriteFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mCharacteristicUUID, BUSY, mArgumemnt);
                    }
                }
                mCurrentProgress = nextProgress;
            }
        } else if (PROGRESS_CHARACTERISTIC_WRITE_START == mCurrentProgress) {
            if (mServiceUUID.equals(serviceUUID) && mCharacteristicUUID.equals(characteristicUUID)) {
                // current:write characteristic start, next:write characteristic success
                if (PROGRESS_CHARACTERISTIC_WRITE_SUCCESS == nextProgress) {
                    byte[] value = bundle.getByteArray(KEY_VALUES);
                    if (value == null) {
                        mBLEConnection.getBLECallback().onCharacteristicWriteFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mCharacteristicUUID, UNKNOWN, mArgumemnt);
                    } else {
                        mBLEConnection.getBLECallback().onCharacteristicWriteSuccess(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mCharacteristicUUID, value, mArgumemnt);
                    }
                } else if (PROGRESS_CHARACTERISTIC_WRITE_ERROR == nextProgress) {
                    // current:write characteristic start, next:write characteristic error
                    mBLEConnection.getBLECallback().onCharacteristicWriteFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mCharacteristicUUID, bundle.getInt(KEY_STATUS), mArgumemnt);
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
        mTaskHandler.removeCallbacksAndMessages(this);
        mCurrentProgress = PROGRESS_FINISHED;
        mBLEConnection.getBLECallback().onCharacteristicWriteFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mCharacteristicUUID, CANCEL, mArgumemnt);
    }

}