package org.im97mori.ble.task;

import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLELogUtils;
import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.TaskHandler;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;

import java.util.List;
import java.util.UUID;

/**
 * Write descriptor task
 * <p>
 * for central role
 */
public class WriteDescriptorTask extends AbstractBLETask {

    /**
     * STATUS:CANCEL
     */
    public static final int STATUS_CANCEL = -1;

    /**
     * STATUS:DESCRIPTOR_NOT_FOUND
     */
    public static final int STATUS_DESCRIPTOR_NOT_FOUND = -2;

    /**
     * STATUS:WRITE_DESCRIPTOR_FAILED
     */
    public static final int STATUS_WRITE_DESCRIPTOR_FAILED = -3;

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
     * KEY:DESCRIPTOR_UUID
     */
    public static final String KEY_DESCRIPTOR_UUID = "KEY_DESCRIPTOR_UUID";

    /**
     * KEY:DESCRIPTOR_INSTANCE_ID
     */
    public static final String KEY_DESCRIPTOR_INSTANCE_ID = "KEY_DESCRIPTOR_INSTANCE_ID";

    /**
     * KEY:VALUES
     */
    public static final String KEY_VALUES = "KEY_VALUES";

    /**
     * KEY:STATUS
     */
    public static final String KEY_STATUS = "KEY_STATUS";

    /**
     * PROGRESS:DESCRIPTOR_WRITE_START
     */
    public static final String PROGRESS_DESCRIPTOR_WRITE_START = "PROGRESS_DESCRIPTOR_WRITE_START";

    /**
     * PROGRESS:DESCRIPTOR_WRITE_SUCCESS
     */
    public static final String PROGRESS_DESCRIPTOR_WRITE_SUCCESS = "PROGRESS_DESCRIPTOR_WRITE_SUCCESS";

    /**
     * PROGRESS:DESCRIPTOR_WRITE_ERROR
     */
    public static final String PROGRESS_DESCRIPTOR_WRITE_ERROR = "PROGRESS_DESCRIPTOR_WRITE_ERROR";

    /**
     * PROGRESS:BUSY
     */
    public static final String PROGRESS_BUSY = "PROGRESS_BUSY";

    /**
     * PROGRESS:FINISHED
     */
    public static final String PROGRESS_FINISHED = "PROGRESS_FINISHED";

    /**
     * Default timeout(millis) for write descriptor:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

    /**
     * create write descriptor success message
     *
     * @param serviceUUID              target service UUID
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       target characteristic UUID
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           target descriptor UUID
     * @param descriptorInstanceId     task target descriptor instance id
     * @param values                   {@link BluetoothGattDescriptor#getValue()}
     * @return write descriptor success {@link Message} instance
     */
    @NonNull
    public static Message createWriteDescriptorSuccessMessage(@NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_SERVICE_UUID, serviceUUID);
        bundle.putInt(KEY_SERVICE_INSTANCE_ID, serviceInstanceId);
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, characteristicUUID);
        bundle.putInt(KEY_CHARACTERISTIC_INSTANCE_ID, characteristicInstanceId);
        bundle.putSerializable(KEY_DESCRIPTOR_UUID, descriptorUUID);
        bundle.putInt(KEY_DESCRIPTOR_INSTANCE_ID, descriptorInstanceId);
        bundle.putByteArray(KEY_VALUES, values);
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_DESCRIPTOR_WRITE_SUCCESS);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * create write descriptor finished message
     *
     * @param serviceUUID              target service UUID
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       target characteristic UUID
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           target descriptor UUID
     * @param descriptorInstanceId     task target descriptor instance id
     * @param status                   {@link android.bluetooth.BluetoothGattCallback#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     * @return write descriptor error {@link Message} instance
     */
    @NonNull
    public static Message createWriteDescriptorErrorMessage(@NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, int status) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_SERVICE_UUID, serviceUUID);
        bundle.putInt(KEY_SERVICE_INSTANCE_ID, serviceInstanceId);
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, characteristicUUID);
        bundle.putInt(KEY_CHARACTERISTIC_INSTANCE_ID, characteristicInstanceId);
        bundle.putSerializable(KEY_DESCRIPTOR_UUID, descriptorUUID);
        bundle.putInt(KEY_DESCRIPTOR_INSTANCE_ID, descriptorInstanceId);
        bundle.putInt(KEY_STATUS, status);
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_DESCRIPTOR_WRITE_ERROR);
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
     * task target descriptor {@link UUID}
     */
    private final UUID mDescriptorUUID;

    /**
     * task target descriptor instance id
     */
    private Integer mDescriptorInstanceId;

    /**
     * task target data
     */
    private final byte[] mByteArray;

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
     * @param descriptorUUID           task target descriptor {@link UUID}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param byteArray                task target data
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    public WriteDescriptorTask(@NonNull BLEConnection bleConnection
            , @NonNull BluetoothGatt bluetoothGatt
            , @NonNull TaskHandler taskHandler
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull UUID descriptorUUID
            , @Nullable Integer descriptorInstanceId
            , @NonNull byte[] byteArray
            , long timeout
            , @NonNull Bundle argument) {
        mBLEConnection = bleConnection;
        mBluetoothGatt = bluetoothGatt;
        mTaskHandler = taskHandler;
        mServiceUUID = serviceUUID;
        mServiceInstanceId = serviceInstanceId;
        mCharacteristicUUID = characteristicUUID;
        mCharacteristicInstanceId = characteristicInstanceId;
        mDescriptorUUID = descriptorUUID;
        mDescriptorInstanceId = descriptorInstanceId;
        mByteArray = byteArray;
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
        bundle.putSerializable(KEY_SERVICE_UUID, mServiceUUID);
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, mCharacteristicUUID);
        bundle.putSerializable(KEY_DESCRIPTOR_UUID, mDescriptorUUID);
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_DESCRIPTOR_WRITE_START);
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
            UUID serviceUUID = (UUID) bundle.getSerializable(KEY_SERVICE_UUID);
            int serviceInstanceId = bundle.getInt(KEY_SERVICE_INSTANCE_ID);
            UUID characteristicUUID = (UUID) bundle.getSerializable(KEY_CHARACTERISTIC_UUID);
            int characteristicInstanceId = bundle.getInt(KEY_CHARACTERISTIC_INSTANCE_ID);
            UUID descriptorUUID = (UUID) bundle.getSerializable(KEY_DESCRIPTOR_UUID);
            int descriptorInstanceId = bundle.getInt(KEY_DESCRIPTOR_INSTANCE_ID);
            String nextProgress = bundle.getString(KEY_NEXT_PROGRESS);

            // timeout
            if (this == message.obj && PROGRESS_TIMEOUT.equals(nextProgress)) {
                mBLEConnection.getBLECallback().onDescriptorWriteTimeout(getTaskId()
                        , mBLEConnection.getBluetoothDevice()
                        , mServiceUUID
                        , mServiceInstanceId
                        , mCharacteristicUUID
                        , mCharacteristicInstanceId
                        , mDescriptorUUID
                        , mDescriptorInstanceId
                        , mTimeout
                        , mArgument);
                mCurrentProgress = PROGRESS_TIMEOUT;
            } else if (PROGRESS_INIT.equals(mCurrentProgress)) {
                // current:init, next:write descriptor start
                if (message.obj == this && PROGRESS_DESCRIPTOR_WRITE_START.equals(nextProgress)) {

                    BluetoothGattDescriptor bluetoothGattDescriptor = null;
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
                            bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(mDescriptorUUID);

                            if (mDescriptorInstanceId == null) {
                                bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(mDescriptorUUID);
                            } else {
                                // multiple descriptor
                                List<BluetoothGattDescriptor> descriptorList = bluetoothGattCharacteristic.getDescriptors();
                                for (BluetoothGattDescriptor targetBluetoothGattDescriptor : descriptorList) {
                                    if (mDescriptorUUID.equals(targetBluetoothGattDescriptor.getUuid()) && mDescriptorInstanceId == BLEUtilsAndroid.getDescriptorInstanceId(targetBluetoothGattDescriptor)) {
                                        bluetoothGattDescriptor = targetBluetoothGattDescriptor;
                                        break;
                                    }
                                }
                            }

                            if (bluetoothGattDescriptor != null) {
                                bluetoothGattDescriptor.setValue(mByteArray);

                                // write descriptor
                                mServiceInstanceId = bluetoothGattService.getInstanceId();
                                mCharacteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                                mDescriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);
                                try {
                                    result = mBluetoothGatt.writeDescriptor(bluetoothGattDescriptor);

                                    if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                                        ClientCharacteristicConfigurationAndroid clientCharacteristicConfiguration = new ClientCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
                                        mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic
                                                , clientCharacteristicConfiguration.isPropertiesNotificationsEnabled()
                                                        || clientCharacteristicConfiguration.isPropertiesIndicationsEnabled());
                                    }
                                } catch (Exception e) {
                                    BLELogUtils.stackLog(e);
                                }

                            }
                        }
                    }

                    if (result) {
                        // set timeout message
                        mTaskHandler.sendProcessingMessage(createTimeoutMessage(this), mTimeout);
                    } else {
                        if (bluetoothGattDescriptor == null) {
                            nextProgress = PROGRESS_FINISHED;
                            mBLEConnection.getBLECallback().onDescriptorWriteFailed(getTaskId()
                                    , mBLEConnection.getBluetoothDevice()
                                    , mServiceUUID
                                    , mServiceInstanceId
                                    , mCharacteristicUUID
                                    , mCharacteristicInstanceId
                                    , mDescriptorUUID
                                    , mDescriptorInstanceId
                                    , STATUS_DESCRIPTOR_NOT_FOUND
                                    , mArgument);
                        } else {
                            nextProgress = PROGRESS_BUSY;
                            mBLEConnection.getBLECallback().onDescriptorWriteFailed(getTaskId()
                                    , mBLEConnection.getBluetoothDevice()
                                    , mServiceUUID
                                    , mServiceInstanceId
                                    , mCharacteristicUUID
                                    , mCharacteristicInstanceId
                                    , mDescriptorUUID
                                    , mDescriptorInstanceId
                                    , STATUS_WRITE_DESCRIPTOR_FAILED
                                    , mArgument);
                        }
                    }
                    mCurrentProgress = nextProgress;
                }
            } else if (PROGRESS_DESCRIPTOR_WRITE_START.equals(mCurrentProgress)) {
                if (mServiceUUID.equals(serviceUUID)
                        && mServiceInstanceId == serviceInstanceId
                        && mCharacteristicUUID.equals(characteristicUUID)
                        && mCharacteristicInstanceId == characteristicInstanceId
                        && mDescriptorUUID.equals(descriptorUUID)
                        && mDescriptorInstanceId == descriptorInstanceId) {
                    // current:write descriptor start, next:write descriptor success
                    if (PROGRESS_DESCRIPTOR_WRITE_SUCCESS.equals(nextProgress)) {
                        byte[] value = bundle.getByteArray(KEY_VALUES);
                        //noinspection ConstantConditions
                        mBLEConnection.getBLECallback().onDescriptorWriteSuccess(getTaskId()
                                , mBLEConnection.getBluetoothDevice()
                                , mServiceUUID
                                , mServiceInstanceId
                                , mCharacteristicUUID
                                , mCharacteristicInstanceId
                                , mDescriptorUUID
                                , mDescriptorInstanceId
                                , value
                                , mArgument);
                    } else if (PROGRESS_DESCRIPTOR_WRITE_ERROR.equals(nextProgress)) {
                        // current:write descriptor start, next:write descriptor error
                        mBLEConnection.getBLECallback().onDescriptorWriteFailed(getTaskId()
                                , mBLEConnection.getBluetoothDevice()
                                , mServiceUUID
                                , mServiceInstanceId
                                , mCharacteristicUUID
                                , mCharacteristicInstanceId
                                , mDescriptorUUID
                                , mDescriptorInstanceId
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
        mBLEConnection.getBLECallback().onDescriptorWriteFailed(getTaskId()
                , mBLEConnection.getBluetoothDevice()
                , mServiceUUID
                , mServiceInstanceId
                , mCharacteristicUUID
                , mCharacteristicInstanceId
                , mDescriptorUUID
                , mDescriptorInstanceId
                , STATUS_CANCEL
                , mArgument);
    }

}
