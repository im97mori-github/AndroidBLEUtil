package org.im97mori.ble.task;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothStatusCodes;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLELogUtils;
import org.im97mori.ble.TaskHandler;

import java.util.List;
import java.util.UUID;

/**
 * Write characteristic task
 * <p>
 * for central role
 */
public class WriteCharacteristicTask extends AbstractBLETask {

    /**
     * STATUS:CANCEL
     */
    public static final int STATUS_CANCEL = -1;

    /**
     * STATUS:CHARACTERISTIC_NOT_FOUND
     */
    public static final int STATUS_CHARACTERISTIC_NOT_FOUND = -2;

    /**
     * STATUS:WRITE_CHARACTERISTIC_NOT_FOUND
     */
    public static final int STATUS_WRITE_CHARACTERISTIC_NOT_FOUND = -3;

    /**
     * KEY:SERVICE_UUID
     */
    public static final String KEY_SERVICE_UUID = "KEY_SERVICE_UUID";

    /**
     * KEY:SERVICE_INSTANCE_ID
     */
    public static final String KEY_SERVICE_INSTANCE_ID = "KEY_SERVICE_INSTANCE_ID";

    /**
     * KEY:CHARACTERISTIC_UUID
     */
    public static final String KEY_CHARACTERISTIC_UUID = "KEY_CHARACTERISTIC_UUID";

    /**
     * KEY:CHARACTERISTIC_INSTANCE_ID
     */
    public static final String KEY_CHARACTERISTIC_INSTANCE_ID = "KEY_CHARACTERISTIC_INSTANCE_ID";

    /**
     * KEY:STATUS
     */
    public static final String KEY_STATUS = "KEY_STATUS";

    /**
     * PROGRESS:CHARACTERISTIC_WRITE_START
     */
    public static final String PROGRESS_CHARACTERISTIC_WRITE_START = "PROGRESS_CHARACTERISTIC_WRITE_START";

    /**
     * PROGRESS:CHARACTERISTIC_WRITE_SUCCESS
     */
    public static final String PROGRESS_CHARACTERISTIC_WRITE_SUCCESS = "PROGRESS_CHARACTERISTIC_WRITE_SUCCESS";

    /**
     * PROGRESS:CHARACTERISTIC_WRITE_ERROR
     */
    public static final String PROGRESS_CHARACTERISTIC_WRITE_ERROR = "PROGRESS_CHARACTERISTIC_WRITE_ERROR";

    /**
     * PROGRESS:BUSY
     */
    public static final String PROGRESS_BUSY = "PROGRESS_BUSY";

    /**
     * PROGRESS:FINISHED
     */
    public static final String PROGRESS_FINISHED = "PROGRESS_FINISHED";

    /**
     * Default timeout(millis) for write characteristic:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

    /**
     * create write characteristic success message
     *
     * @param serviceUUID              target service UUID
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       target characteristic UUID
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @return write characteristic success {@link Message} instance
     */
    @NonNull
    public static Message createWriteCharacteristicSuccessMessage(@NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_SERVICE_UUID, serviceUUID.toString());
        bundle.putInt(KEY_SERVICE_INSTANCE_ID, serviceInstanceId);
        bundle.putString(KEY_CHARACTERISTIC_UUID, characteristicUUID.toString());
        bundle.putInt(KEY_CHARACTERISTIC_INSTANCE_ID, characteristicInstanceId);
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_CHARACTERISTIC_WRITE_SUCCESS);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * create write characteristic error message
     *
     * @param serviceUUID              target service UUID
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       target characteristic UUID
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   {@link android.bluetooth.BluetoothGattCallback#onCharacteristicWrite(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     * @return write characteristic error {@link Message} instance
     */
    @NonNull
    public static Message createWriteCharacteristicErrorMessage(@NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int status) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_SERVICE_UUID, serviceUUID.toString());
        bundle.putInt(KEY_SERVICE_INSTANCE_ID, serviceInstanceId);
        bundle.putString(KEY_CHARACTERISTIC_UUID, characteristicUUID.toString());
        bundle.putInt(KEY_CHARACTERISTIC_INSTANCE_ID, characteristicInstanceId);
        bundle.putInt(KEY_STATUS, status);
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_CHARACTERISTIC_WRITE_ERROR);
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
     * task target service instance id {@link BluetoothGattService#getInstanceId()}
     */
    private Integer mServiceInstanceId;

    /**
     * task target characteristic {@link UUID}
     */
    private final UUID mCharacteristicUUID;

    /**
     * task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     */
    private Integer mCharacteristicInstanceId;

    /**
     * task target data
     */
    private final byte[] mByteArray;

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
    private final Bundle mArgument;

    /**
     * @param bleConnection            task target {@link BLEConnection} instance
     * @param bluetoothGatt            task target {@link BluetoothGatt} instance
     * @param taskHandler              task target {@link TaskHandler} instance
     * @param serviceUUID              task target service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       task target characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param byteArray                task target data
     * @param writeType                one of {@link BluetoothGattCharacteristic#WRITE_TYPE_DEFAULT}, {@link BluetoothGattCharacteristic#WRITE_TYPE_NO_RESPONSE}, {@link BluetoothGattCharacteristic#WRITE_TYPE_SIGNED}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    public WriteCharacteristicTask(@NonNull BLEConnection bleConnection
            , @NonNull BluetoothGatt bluetoothGatt
            , @NonNull TaskHandler taskHandler
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull byte[] byteArray
            , int writeType
            , long timeout
            , @NonNull Bundle argument) {
        mBLEConnection = bleConnection;
        mBluetoothGatt = bluetoothGatt;
        mTaskHandler = taskHandler;
        mServiceUUID = serviceUUID;
        mServiceInstanceId = serviceInstanceId;
        mCharacteristicUUID = characteristicUUID;
        mCharacteristicInstanceId = characteristicInstanceId;
        mByteArray = byteArray;
        mWriteType = writeType;
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
        bundle.putString(KEY_SERVICE_UUID, mServiceUUID.toString());
        bundle.putString(KEY_CHARACTERISTIC_UUID, mCharacteristicUUID.toString());
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_CHARACTERISTIC_WRITE_START);
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
    @Deprecated
    public boolean doProcess(@NonNull Message message) {
        Bundle bundle = message.getData();
        if (bundle.containsKey(KEY_NEXT_PROGRESS)) {
            UUID serviceUUID = UUID.fromString(bundle.getString(KEY_SERVICE_UUID));
            int serviceInstanceId = bundle.getInt(KEY_SERVICE_INSTANCE_ID);
            UUID characteristicUUID = UUID.fromString(bundle.getString(KEY_CHARACTERISTIC_UUID));
            int characteristicInstanceId = bundle.getInt(KEY_CHARACTERISTIC_INSTANCE_ID);
            String nextProgress = bundle.getString(KEY_NEXT_PROGRESS);

            // timeout
            if (message.obj == this && PROGRESS_TIMEOUT.equals(nextProgress)) {
                mBLEConnection.getBLECallback().onCharacteristicWriteTimeout(getTaskId()
                        , mBLEConnection.getBluetoothDevice()
                        , mServiceUUID
                        , mServiceInstanceId
                        , mCharacteristicUUID
                        , mCharacteristicInstanceId
                        , mTimeout
                        , mArgument);
                mCurrentProgress = nextProgress;
            } else if (PROGRESS_INIT.equals(mCurrentProgress)) {
                // current:init, next:write characteristic start
                if (message.obj == this && PROGRESS_CHARACTERISTIC_WRITE_START.equals(nextProgress)) {

                    BluetoothGattCharacteristic bluetoothGattCharacteristic = null;
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

                    int status = STATUS_WRITE_CHARACTERISTIC_NOT_FOUND;
                    if (bluetoothGattService != null) {
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
                            // write characteristic
                            mServiceInstanceId = bluetoothGattService.getInstanceId();
                            mCharacteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                            try {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                    status = mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic, mByteArray, mWriteType);
                                    result = status == BluetoothStatusCodes.SUCCESS;
                                } else {
                                    bluetoothGattCharacteristic.setValue(mByteArray);
                                    bluetoothGattCharacteristic.setWriteType(mWriteType);
                                    result = mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
                                }
                            } catch (Exception e) {
                                BLELogUtils.stackLog(e);
                            }
                        }
                    }

                    if (result) {
                        // set timeout message
                        mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);
                    } else {
                        if (bluetoothGattCharacteristic == null) {
                            nextProgress = PROGRESS_FINISHED;
                            mBLEConnection.getBLECallback().onCharacteristicWriteFailed(getTaskId()
                                    , mBLEConnection.getBluetoothDevice()
                                    , mServiceUUID
                                    , mServiceInstanceId
                                    , mCharacteristicUUID
                                    , mCharacteristicInstanceId
                                    , STATUS_CHARACTERISTIC_NOT_FOUND
                                    , mArgument);
                        } else {
                            nextProgress = PROGRESS_BUSY;
                            mBLEConnection.getBLECallback().onCharacteristicWriteFailed(getTaskId()
                                    , mBLEConnection.getBluetoothDevice()
                                    , mServiceUUID
                                    , mServiceInstanceId
                                    , mCharacteristicUUID
                                    , mCharacteristicInstanceId
                                    , status
                                    , mArgument);
                        }
                    }
                    mCurrentProgress = nextProgress;
                }
            } else if (PROGRESS_CHARACTERISTIC_WRITE_START.equals(mCurrentProgress)) {
                if (mServiceUUID.equals(serviceUUID) && mServiceInstanceId == serviceInstanceId && mCharacteristicUUID.equals(characteristicUUID) && mCharacteristicInstanceId == characteristicInstanceId) {
                    // current:write characteristic start, next:write characteristic success
                    if (PROGRESS_CHARACTERISTIC_WRITE_SUCCESS.equals(nextProgress)) {
                        mBLEConnection.getBLECallback().onCharacteristicWriteSuccess(getTaskId()
                                , mBLEConnection.getBluetoothDevice()
                                , mServiceUUID
                                , mServiceInstanceId
                                , mCharacteristicUUID
                                , mCharacteristicInstanceId
                                , mByteArray
                                , mArgument);
                    } else if (PROGRESS_CHARACTERISTIC_WRITE_ERROR.equals(nextProgress)) {
                        // current:write characteristic start, next:write characteristic error
                        mBLEConnection.getBLECallback().onCharacteristicWriteFailed(getTaskId()
                                , mBLEConnection.getBluetoothDevice()
                                , mServiceUUID
                                , mServiceInstanceId
                                , mCharacteristicUUID
                                , mCharacteristicInstanceId
                                , bundle.getInt(KEY_STATUS)
                                , mArgument);
                    }

                    mCurrentProgress = PROGRESS_FINISHED;
                    // remove timeout message
                    mTaskHandler.removeCallbacksAndMessages(this);
                }
            }
        }

        return PROGRESS_FINISHED.equals(mCurrentProgress) || PROGRESS_BUSY.equals(mCurrentProgress) || PROGRESS_TIMEOUT.equals(mCurrentProgress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBusy() {
        return PROGRESS_BUSY.equals(mCurrentProgress) || PROGRESS_TIMEOUT.equals(mCurrentProgress);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancel() {
        mTaskHandler.removeCallbacksAndMessages(this);
        mCurrentProgress = PROGRESS_FINISHED;
        mBLEConnection.getBLECallback().onCharacteristicWriteFailed(getTaskId()
                , mBLEConnection.getBluetoothDevice()
                , mServiceUUID
                , mServiceInstanceId
                , mCharacteristicUUID
                , mCharacteristicInstanceId
                , STATUS_CANCEL
                , mArgument);
    }

}
