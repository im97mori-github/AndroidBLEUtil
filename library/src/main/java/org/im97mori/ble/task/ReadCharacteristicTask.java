package org.im97mori.ble.task;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.TaskHandler;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.ErrorCodes.UNKNOWN;

/**
 * Read characteristic task
 */
@SuppressWarnings("JavadocReference")
public class ReadCharacteristicTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for read:5sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 5;

    /**
     * create read characteristic message
     *
     * @param characteristicUUID target characteristic UUID
     * @param obj                instance for {@link android.os.Handler#removeCallbacksAndMessages(Object)}
     * @return read characteristic {@link Message} instance
     */
    public static Message createReadCharacteristicMessage(UUID characteristicUUID, Object obj) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, characteristicUUID);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_CHARACTERISTIC_READ_START);
        Message message = new Message();
        message.setData(bundle);
        message.obj = obj;
        return message;
    }

    /**
     * create read characteristic finished message
     *
     * @param characteristicUUID target characteristic UUID
     * @param values             {@link BluetoothGattCharacteristic#getValue()}
     * @return read characteristic finished {@link Message} instance
     */
    public static Message createReadCharacteristicFinishedMessage(UUID characteristicUUID, byte[] values) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, characteristicUUID);
        bundle.putByteArray(KEY_VALUES, values);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_CHARACTERISTIC_READ_SUCCESS);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * create read characteristic error message
     *
     * @param characteristicUUID target characteristic UUID
     * @param status             {@link android.bluetooth.BluetoothGattCallback#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     * @return read characteristic error {@link Message} instance
     */
    public static Message createReadCharacteristicErrorMessage(UUID characteristicUUID, int status) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, characteristicUUID);
        bundle.putInt(KEY_STATUS, status);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_CHARACTERISTIC_READ_ERROR);
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
     * timeout(millis)
     */
    private final long mTimeout;

    /**
     * @param bleConnection      task target {@link BLEConnection} instance
     * @param bluetoothGatt      task target {@link BluetoothGatt} instance
     * @param taskHandler        task target {@link TaskHandler} instance
     * @param serviceUUID        task target service {@link UUID}
     * @param characteristicUUID task target characteristic {@link UUID}
     * @param timeout            timeout(millis)
     */
    public ReadCharacteristicTask(BLEConnection bleConnection, BluetoothGatt bluetoothGatt, TaskHandler taskHandler, UUID serviceUUID, UUID characteristicUUID, long timeout) {
        mBLEConnection = bleConnection;
        mBluetoothGatt = bluetoothGatt;
        mServiceUUID = serviceUUID;
        mCharacteristicUUID = characteristicUUID;
        mTaskHandler = taskHandler;
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
        if (this == message.obj && PROGRESS_TIMEOUT == nextProgress) {
            mBLEConnection.getBLECallback().onCharacteristicReadTimeout(mBLEConnection.getBluetoothDevice(), mCharacteristicUUID, mTimeout);
            mCurrentProgress = nextProgress;
        } else if (PROGRESS_INIT == mCurrentProgress) {
            // current:init, next:read start
            if (this == message.obj && PROGRESS_CHARACTERISTIC_READ_START == nextProgress) {

                BluetoothGattService bluetoothGattService = mBluetoothGatt.getService(mServiceUUID);
                if (bluetoothGattService != null) {
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(mCharacteristicUUID);
                    if (bluetoothGattCharacteristic != null) {

                        // read characteristic
                        if (mBluetoothGatt.readCharacteristic(bluetoothGattCharacteristic)) {

                            // set timeout message
                            mTaskHandler.sendProcessingMessage(createTimeoutMessage(mCharacteristicUUID, this), mTimeout);
                        } else {
                            nextProgress = PROGRESS_FINISHED;
                            mBLEConnection.getBLECallback().onCharacteristicReadFailed(mBLEConnection.getBluetoothDevice(), mCharacteristicUUID, UNKNOWN);
                        }
                    }
                }
                mCurrentProgress = nextProgress;
            }
        } else if (PROGRESS_CHARACTERISTIC_READ_START == mCurrentProgress) {
            if (mCharacteristicUUID.equals(characteristicUUID)) {
                // current:read start, next:read success
                if (PROGRESS_CHARACTERISTIC_READ_SUCCESS == nextProgress) {
                    mBLEConnection.getBLECallback().onCharacteristicReadSuccess(mBLEConnection.getBluetoothDevice(), mCharacteristicUUID, bundle.getByteArray(KEY_VALUES));
                } else if (PROGRESS_CHARACTERISTIC_READ_ERROR == nextProgress) {
                    // current:read start, next:read error
                    mBLEConnection.getBLECallback().onCharacteristicReadFailed(mBLEConnection.getBluetoothDevice(), mCharacteristicUUID, bundle.getInt(KEY_STATUS));
                }

                mCurrentProgress = PROGRESS_FINISHED;
                // remove timeout message
                mTaskHandler.removeCallbacksAndMessages(this);
            }
        }

        return PROGRESS_FINISHED == mCurrentProgress || PROGRESS_TIMEOUT == mCurrentProgress;
    }
}
