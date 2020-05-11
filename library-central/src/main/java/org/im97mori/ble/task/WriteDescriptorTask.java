package org.im97mori.ble.task;

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
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.TaskHandler;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ErrorCodes.BUSY;
import static org.im97mori.ble.BLEConstants.ErrorCodes.CANCEL;
import static org.im97mori.ble.BLEConstants.ErrorCodes.UNKNOWN;

/**
 * Write descriptor task
 * <p>
 * for central role
 */
@SuppressWarnings("unused")
public class WriteDescriptorTask extends AbstractBLETask {

    /**
     * Default timeout(millis) for write descriptor:30sec
     */
    public static final long TIMEOUT_MILLIS = DateUtils.SECOND_IN_MILLIS * 30;

    /**
     * create write descriptor success message
     *
     * @param serviceUUID              target service UUID
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       target characteristic UUID
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           target descriptor UUID
     * @param values                   {@link BluetoothGattDescriptor#getValue()}
     * @return write descriptor success {@link Message} instance
     */
    @NonNull
    public static Message createWriteDescriptorSuccessMessage(@NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_SERVICE_UUID, serviceUUID);
        bundle.putInt(KEY_SERVICE_INSTANCE_ID, serviceInstanceId);
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, characteristicUUID);
        bundle.putInt(KEY_CHARACTERISTIC_INSTANCE_ID, characteristicInstanceId);
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
     * @param serviceUUID              target service UUID
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       target characteristic UUID
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           target descriptor UUID
     * @param status                   {@link android.bluetooth.BluetoothGattCallback#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     * @return write descriptor error {@link Message} instance
     */
    @NonNull
    public static Message createWriteDescriptorErrorMessage(@NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull UUID descriptorUUID, int status) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_SERVICE_UUID, serviceUUID);
        bundle.putInt(KEY_SERVICE_INSTANCE_ID, serviceInstanceId);
        bundle.putSerializable(KEY_CHARACTERISTIC_UUID, characteristicUUID);
        bundle.putInt(KEY_CHARACTERISTIC_INSTANCE_ID, characteristicInstanceId);
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
    private final Bundle mArgumemnt;

    /**
     * @param bleConnection            task target {@link BLEConnection} instance
     * @param bluetoothGatt            task target {@link BluetoothGatt} instance
     * @param taskHandler              task target {@link TaskHandler} instance
     * @param serviceUUID              task target service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       task target characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param byteArrayInterface       task target data class
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
            , @NonNull ByteArrayInterface byteArrayInterface
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
        mByteArrayInterface = byteArrayInterface;
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
        bundle.putSerializable(KEY_DESCRIPTOR_UUID, mDescriptorUUID);
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_DESCRIPTOR_WRITE_START);
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
        int serviceInstanceId = bundle.getInt(KEY_SERVICE_INSTANCE_ID);
        UUID characteristicUUID = (UUID) bundle.getSerializable(KEY_CHARACTERISTIC_UUID);
        int characteristicInstanceId = bundle.getInt(KEY_CHARACTERISTIC_INSTANCE_ID);
        UUID descriptorUUID = (UUID) bundle.getSerializable(KEY_DESCRIPTOR_UUID);
        int nextProgress = bundle.getInt(KEY_NEXT_PROGRESS);

        // timeout
        if (this == message.obj && PROGRESS_TIMEOUT == nextProgress) {
            mBLEConnection.getBLECallback().onDescriptorWriteTimeout(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mDescriptorUUID, mTimeout, mArgumemnt);
            mCurrentProgress = PROGRESS_TIMEOUT;
        } else if (PROGRESS_INIT == mCurrentProgress) {
            // current:init, next:write descriptor start
            if (message.obj == this && PROGRESS_DESCRIPTOR_WRITE_START == nextProgress) {

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
                        if (bluetoothGattDescriptor != null) {
                            byte[] bytes = mByteArrayInterface.getBytes();
                            bluetoothGattDescriptor.setValue(bytes);

                            // write descriptor
                            mServiceInstanceId = bluetoothGattService.getInstanceId();
                            mCharacteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
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
                        mBLEConnection.getBLECallback().onDescriptorWriteFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mDescriptorUUID, UNKNOWN, mArgumemnt);
                    } else {
                        nextProgress = PROGRESS_BUSY;
                        mBLEConnection.getBLECallback().onDescriptorWriteFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mDescriptorUUID, BUSY, mArgumemnt);
                    }
                }
                mCurrentProgress = nextProgress;
            }
        } else if (PROGRESS_DESCRIPTOR_WRITE_START == mCurrentProgress) {
            if (mServiceUUID.equals(serviceUUID) && mCharacteristicUUID.equals(characteristicUUID) || mDescriptorUUID.equals(descriptorUUID)) {
                // current:write descriptor start, next:write descriptor success
                if (PROGRESS_DESCRIPTOR_WRITE_SUCCESS == nextProgress) {
                    byte[] value = bundle.getByteArray(KEY_VALUES);
                    if (value == null) {
                        mBLEConnection.getBLECallback().onDescriptorWriteFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mDescriptorUUID, UNKNOWN, mArgumemnt);
                    } else {
                        mBLEConnection.getBLECallback().onDescriptorWriteSuccess(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mDescriptorUUID, value, mArgumemnt);
                    }
                } else if (PROGRESS_DESCRIPTOR_WRITE_ERROR == nextProgress) {
                    // current:write descriptor start, next:write descriptor error
                    mBLEConnection.getBLECallback().onDescriptorWriteFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mDescriptorUUID, bundle.getInt(KEY_STATUS), mArgumemnt);
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
        mBLEConnection.getBLECallback().onDescriptorWriteFailed(getTaskId(), mBLEConnection.getBluetoothDevice(), mServiceUUID, mServiceInstanceId, mCharacteristicUUID, mCharacteristicInstanceId, mDescriptorUUID, CANCEL, mArgumemnt);
    }

}
