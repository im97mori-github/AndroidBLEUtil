package org.im97mori.ble.task;

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

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.constants.ErrorCodeAndroid.BUSY;
import static org.im97mori.ble.constants.ErrorCodeAndroid.CANCEL;
import static org.im97mori.ble.constants.ErrorCodeAndroid.UNKNOWN;

/**
 * Read descriptor task
 * <p>
 * for central role
 */
public class ReadDescriptorTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for read descriptor:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

    /**
     * create read descriptor success message
     *
     * @param serviceUUID              target service UUID
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       target characteristic UUID
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           target descriptor UUID
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param values                   {@link BluetoothGattDescriptor#getValue()}
     * @return read descriptor success {@link Message} instance
     */
    @NonNull
    public static Message createReadDescriptorSuccessMessage(@NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_SERVICE_UUID, serviceUUID);
        bundle.putInt(KEY_SERVICE_INSTANCE_ID, serviceInstanceId);
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, characteristicUUID);
        bundle.putInt(KEY_CHARACTERISTIC_INSTANCE_ID, characteristicInstanceId);
        bundle.putSerializable(KEY_DESCRIPTOR_UUID, descriptorUUID);
        bundle.putInt(KEY_DESCRIPTOR_INSTANCE_ID, descriptorInstanceId);
        bundle.putByteArray(KEY_VALUES, values);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_DESCRIPTOR_READ_SUCCESS);
        Message message = new Message();
        message.setData(bundle);
        return message;
    }

    /**
     * create read descriptor finished message
     *
     * @param serviceUUID              target service UUID
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       target characteristic UUID
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           target descriptor UUID
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param status                   {@link android.bluetooth.BluetoothGattCallback#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     * @return read descriptor error {@link Message} instance
     */
    @NonNull
    public static Message createReadDescriptorErrorMessage(@NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, int status) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_SERVICE_UUID, serviceUUID);
        bundle.putInt(KEY_SERVICE_INSTANCE_ID, serviceInstanceId);
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, characteristicUUID);
        bundle.putInt(KEY_CHARACTERISTIC_INSTANCE_ID, characteristicInstanceId);
        bundle.putSerializable(KEY_DESCRIPTOR_UUID, descriptorUUID);
        bundle.putInt(KEY_DESCRIPTOR_INSTANCE_ID, descriptorInstanceId);
        bundle.putInt(KEY_STATUS, status);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_DESCRIPTOR_READ_ERROR);
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
     * task target descriptor {@link UUID}
     */
    private final UUID mDescriptorUUID;

    /**
     * task target descriptor incetanceId
     */
    private Integer mDescriptorInstanceId;

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
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       task target characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           task target descriptor {@link UUID}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    public ReadDescriptorTask(@NonNull BLEConnection bleConnection
            , @NonNull BluetoothGatt bluetoothGatt
            , @NonNull TaskHandler taskHandler
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull UUID descriptorUUID
            , @Nullable Integer descriptorInstanceId
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
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_DESCRIPTOR_READ_START);
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
            int nextProgress = bundle.getInt(KEY_NEXT_PROGRESS);

            // timeout
            if (this == message.obj && PROGRESS_TIMEOUT == nextProgress) {
                mBLEConnection.getBLECallback().onDescriptorReadTimeout(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mDescriptorUUID, mDescriptorInstanceId, mTimeout, mArgument);
                mCurrentProgress = PROGRESS_TIMEOUT;
            } else if (PROGRESS_INIT == mCurrentProgress) {
                // current:init, next:read descriptor start
                if (message.obj == this && PROGRESS_DESCRIPTOR_READ_START == nextProgress) {

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
                                // read descriptor
                                mServiceInstanceId = bluetoothGattService.getInstanceId();
                                mCharacteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                                mDescriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);
                                try {
                                    result = mBluetoothGatt.readDescriptor(bluetoothGattDescriptor);
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
                            mBLEConnection.getBLECallback().onDescriptorReadFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mDescriptorUUID, mDescriptorInstanceId, UNKNOWN, mArgument);
                        } else {
                            nextProgress = PROGRESS_BUSY;
                            mBLEConnection.getBLECallback().onDescriptorReadFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mDescriptorUUID, mDescriptorInstanceId, BUSY, mArgument);
                        }
                    }
                    mCurrentProgress = nextProgress;
                }
            } else if (PROGRESS_DESCRIPTOR_READ_START == mCurrentProgress) {
                if (mServiceUUID.equals(serviceUUID)
                        && mServiceInstanceId == serviceInstanceId
                        && mCharacteristicUUID.equals(characteristicUUID)
                        && mCharacteristicInstanceId == characteristicInstanceId
                        && mDescriptorUUID.equals(descriptorUUID)
                        && mDescriptorInstanceId == descriptorInstanceId) {
                    // current:read descriptor start, next:read descriptor success
                    if (PROGRESS_DESCRIPTOR_READ_SUCCESS == nextProgress) {
                        byte[] value = bundle.getByteArray(KEY_VALUES);
                        if (value == null) {
                            mBLEConnection.getBLECallback().onDescriptorReadFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mDescriptorUUID, mDescriptorInstanceId, UNKNOWN, mArgument);
                        } else {
                            mBLEConnection.getBLECallback().onDescriptorReadSuccess(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mDescriptorUUID, mDescriptorInstanceId, value, mArgument);
                        }
                    } else if (PROGRESS_DESCRIPTOR_READ_ERROR == nextProgress) {
                        // current:read descriptor start, next:read descriptor error
                        mBLEConnection.getBLECallback().onDescriptorReadFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mDescriptorUUID, mDescriptorInstanceId, bundle.getInt(KEY_STATUS), mArgument);
                    }

                    mCurrentProgress = PROGRESS_FINISHED;
                    // remove timeout message
                    mTaskHandler.removeCallbacksAndMessages(this);
                }
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
        mBLEConnection.getBLECallback().onDescriptorReadFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mDescriptorUUID, mDescriptorInstanceId, CANCEL, mArgument);
    }

}
