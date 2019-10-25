package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.descriptor.ClientCharacteristicConfiguration;
import org.im97mori.ble.task.AbstractBLETask;
import org.im97mori.ble.task.ConnectTask;
import org.im97mori.ble.task.DisconnectTask;
import org.im97mori.ble.task.DiscoverServiceTask;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.ReadPhyTask;
import org.im97mori.ble.task.RequestMtuTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR;

/**
 * BLE connection(central role)
 * <p>
 * Asynchronous
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BLEConnection extends BluetoothGattCallback implements BLECallbackDistributer.SubscriberInterface {

    /**
     * {@link Context} instance
     */
    protected final Context mContext;

    /**
     * BLE device
     */
    protected final BluetoothDevice mBluetoothDevice;

    /**
     * callback for {@link #mBluetoothDevice}
     */
    protected final Set<BLECallback> mAttachedBLECallbackSet = new HashSet<>();

    /**
     * <p>
     * current notification status
     * <p>
     * if {@link Set#contains(Object)} return true, target UUID(characteristic) is {@link BluetoothGattDescriptor#ENABLE_NOTIFICATION_VALUE} status
     * </p>
     */
    protected final Set<UUID> mNotificationSet = new HashSet<>();

    /**
     * {@link BLECallbackDistributer} instance
     */
    protected BLECallbackDistributer mBLECallbackDistributer;

    /**
     * newest {@link BluetoothGatt} instance
     */
    protected BluetoothGatt mBluetoothGatt;

    /**
     * newest {@link TaskHandler} instance
     */
    protected TaskHandler mTaskHandler;

    /**
     * @param context                {@link Context} instance
     * @param bluetoothDevice        BLE device
     * @param bleCallbackDistributer distributer instance
     */
    public BLEConnection(@NonNull Context context, @NonNull BluetoothDevice bluetoothDevice, @Nullable BLECallbackDistributer bleCallbackDistributer) {
        mContext = context.getApplicationContext();
        mBluetoothDevice = bluetoothDevice;
        mBLECallbackDistributer = bleCallbackDistributer;
    }

    /**
     * attach callback
     *
     * @param callback {@link BLECallback}
     */
    public synchronized void attach(@NonNull BLECallback callback) {
        mAttachedBLECallbackSet.add(callback);
    }

    /**
     * detach callback
     *
     * @param callback {@link BLECallback}
     */
    public synchronized void detach(@NonNull BLECallback callback) {
        mAttachedBLECallbackSet.remove(callback);
    }

    /**
     * check target callback is attached
     *
     * @param callback target callback
     * @return {@code true}:attached, {@code false}:not attached
     */
    public synchronized boolean isAttached(@NonNull BLECallback callback) {
        return mAttachedBLECallbackSet.contains(callback);
    }

    /**
     * <p>
     * Start task handling
     * <p>
     * used for original Connect task(such as connect and manual bonding or application layer key exchange)
     * </p>
     */
    public synchronized void start() {
        if (mTaskHandler == null) {
            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            mTaskHandler = new TaskHandler(thread.getLooper());
        }
    }

    /**
     * @see #connect(boolean, long, Bundle, BLECallback)
     */
    @Nullable
    public Integer connect(long timeout) {
        return connect(false, timeout, null, null);
    }

    /**
     * @see #connect(boolean, long, Bundle, BLECallback)
     */
    @Nullable
    public Integer connect(long timeout, @Nullable Bundle argument) {
        return connect(false, timeout, argument, null);
    }

    /**
     * <p>
     * Connect ble
     * <p>
     * if already connected, do not anything
     * </p>
     *
     * @param needMtuSetting {@code true}:try 512octed mtu setting, {@code false}:no mtu setting
     * @param timeout        timeout(millis)
     * @param argument       callback argument
     * @param bleCallback    {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public synchronized Integer connect(boolean needMtuSetting, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (mBluetoothGatt == null) {
            start();

            ConnectTask task = new ConnectTask(this, mTaskHandler, needMtuSetting, timeout, BLECallbackDistributer.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * create discover service task
     *
     * @param timeout     timeout(millis)
     * @param argument    callback argument
     * @param bleCallback {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public Integer createDiscoverServiceTask(long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        BluetoothGatt bluetoothGatt = mBluetoothGatt;
        if (bluetoothGatt != null) {
            DiscoverServiceTask task = new DiscoverServiceTask(this, bluetoothGatt, mTaskHandler, timeout, BLECallbackDistributer.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * create request mtu task
     *
     * @param mtu         new mtu
     * @param timeout     timeout(millis)
     * @param argument    callback argument
     * @param bleCallback {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Integer createRequestMtuTask(int mtu, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        BluetoothGatt bluetoothGatt = mBluetoothGatt;
        if (bluetoothGatt != null) {
            RequestMtuTask task = new RequestMtuTask(this, bluetoothGatt, mTaskHandler, mtu, timeout, BLECallbackDistributer.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * @see #quit(Bundle, BLECallback)
     */
    public Integer quit() {
        return quit(null, null);
    }


    /**
     * <p>
     * Disconnect and clear all task
     * <p>
     * if already disconnect, do not anything
     * </p>
     *
     * @param argument    callback argument
     * @param bleCallback {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registed
     */
    public synchronized Integer quit(@Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (mBluetoothGatt != null) {
            mTaskHandler.clearTask();

            DisconnectTask task = new DisconnectTask(this, mBluetoothGatt, BLEConstants.ErrorCodes.UNKNOWN, BLECallbackDistributer.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * Clear all task
     */
    public synchronized void clear() {
        if (mTaskHandler != null) {
            mTaskHandler.clearTask();
        }
    }

    /**
     * Cancel target task
     *
     * @param taskId task id
     */
    public synchronized void cancelTask(@NonNull Integer taskId) {
        if (mTaskHandler != null) {
            mTaskHandler.cancelTask(taskId);
        }
    }

    /**
     * Add user original task
     *
     * @param task {@link AbstractBLETask} instance
     * @see TaskHandler#addTask(AbstractBLETask)
     */
    public synchronized void addTask(@NonNull AbstractBLETask task) {
        if (mTaskHandler != null) {
            mTaskHandler.addTask(task);
        }
    }

    /**
     * Callback at connected and service discover successed
     *
     * @param taskId        task id
     * @param bluetoothGatt Connected {@link BluetoothGatt}
     * @param argument      callback argument
     */
    public synchronized void onConnected(@NonNull Integer taskId, @NonNull BluetoothGatt bluetoothGatt, @NonNull Bundle argument) {
        if (mBluetoothGatt == null) {
            mBluetoothGatt = bluetoothGatt;

            getBLECallback().onBLEConnected(taskId, mBluetoothDevice, argument);
        }
    }

    /**
     * Callback at {@link ConnectTask} failed
     *
     * @param taskId   task id
     * @param status   one of {@link BLEConnection#onConnectionStateChange(BluetoothGatt, int, int)} 2nd parameter, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}
     * @param argument callback argument
     */
    public synchronized void onConnectFailed(@NonNull Integer taskId, int status, @NonNull Bundle argument) {
        if (mTaskHandler != null) {
            mTaskHandler.quit();
            mTaskHandler = null;

            getBLECallback().onBLEConnectFailed(taskId, mBluetoothDevice, status, argument);
        }
    }

    /**
     * Callback at {@link ConnectTask} timeout
     *
     * @param taskId   task id
     * @param argument callback argument
     */
    public synchronized void onConnectTimeout(@NonNull Integer taskId, @NonNull Bundle argument) {
        if (mTaskHandler != null) {
            mTaskHandler.quit();
            mTaskHandler = null;

            getBLECallback().onBLEConnectTimeout(taskId, mBluetoothDevice, argument);
        }
    }

    /**
     * Callback at disconnected
     *
     * @param taskId        task id
     * @param bluetoothGatt Disconnected {@link BluetoothGatt}
     * @param status        {@link android.bluetooth.BluetoothGattCallback#onConnectionStateChange(BluetoothGatt, int, int)} 2nd parameter or {@link BLEConstants.ErrorCodes#UNKNOWN}
     * @param argument      callback argument
     */
    public synchronized void onDisconnected(@NonNull Integer taskId, @NonNull BluetoothGatt bluetoothGatt, int status, @NonNull Bundle argument) {
        if (bluetoothGatt == mBluetoothGatt) {
            mBluetoothGatt = null;
            if (mTaskHandler != null) {
                mTaskHandler.quit();
                mTaskHandler = null;
            }
            mNotificationSet.clear();

            getBLECallback().onBLEDisconnected(taskId, mBluetoothDevice, status, argument);
        }
    }

    /**
     * check {@link BluetoothGatt} is newest one
     *
     * @param bluetoothGatt check target {@link BluetoothGatt}
     * @return {@code true}:newest one, {@code false}:not newest one
     */
    public boolean isCurrentConnectionTarget(@NonNull BluetoothGatt bluetoothGatt) {
        return bluetoothGatt == mBluetoothGatt;
    }

    /**
     * @return {@link Context} instance
     */
    @NonNull
    public Context getContext() {
        return mContext;
    }

    /**
     * @return BLE device {@link BluetoothDevice}
     */
    @NonNull
    public BluetoothDevice getBluetoothDevice() {
        return mBluetoothDevice;
    }

    /**
     * @return {@link BLECallback} instance
     */
    @NonNull
    public synchronized BLECallback getBLECallback() {
        if (mBLECallbackDistributer == null) {
            mBLECallbackDistributer = new BLECallbackDistributer(this);
        }
        return mBLECallbackDistributer;
    }

    /**
     * check connection status
     *
     * @return {@code true}:{@link BLEConnection} has connected {@link BluetoothGatt}, {@code false}:dont have connected {@link BluetoothGatt}
     */
    public boolean isConnected() {
        return mBluetoothGatt != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
        if (mTaskHandler != null) {
            if (BluetoothGatt.GATT_SUCCESS == status) {
                if (BluetoothGatt.STATE_CONNECTED == newState) {
                    // connected

                    mTaskHandler.sendProcessingMessage(ConnectTask.createConnectSuccessMessage(gatt));
                }
            }

            if (BluetoothGatt.STATE_DISCONNECTED == newState) {
                // disconnected

                // add disconnect task
                DisconnectTask task = new DisconnectTask(this, gatt, status, BLECallbackDistributer.wrapArgument(null, null));
                mTaskHandler.addTask(task);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onServicesDiscovered(BluetoothGatt gatt, int status) {
        if (mTaskHandler != null) {
            if (BluetoothGatt.GATT_SUCCESS == status) {
                // service discover finished

                // service discovered
                mTaskHandler.sendProcessingMessage(DiscoverServiceTask.createDiscoverServiceSuccessMessage(gatt));
            } else {
                // service discover failed

                mTaskHandler.sendProcessingMessage(DiscoverServiceTask.createDiscoverServiceErrorMessage(gatt, status));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        // gatt instance is not matched
        if (gatt != mBluetoothGatt) {
            return;
        }
        try {
            BluetoothGattService service = characteristic.getService();
            if (BluetoothGatt.GATT_SUCCESS == status) {
                mTaskHandler.sendProcessingMessage(ReadCharacteristicTask.createReadCharacteristicSuccessMessage(service.getUuid(), characteristic.getUuid(), characteristic.getValue()));
            } else {
                mTaskHandler.sendProcessingMessage(ReadCharacteristicTask.createReadCharacteristicErrorMessage(service.getUuid(), characteristic.getUuid(), status));
            }

            // if characteristic / descriptor callbacked, clear busy status
            mTaskHandler.clearBusy();
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        // gatt instance is not matched
        if (gatt != mBluetoothGatt) {
            return;
        }
        try {
            BluetoothGattService service = characteristic.getService();
            if (BluetoothGatt.GATT_SUCCESS == status) {
                mTaskHandler.sendProcessingMessage(WriteCharacteristicTask.createWriteCharacteristicSuccessMessage(service.getUuid(), characteristic.getUuid(), characteristic.getValue()));
            } else {
                mTaskHandler.sendProcessingMessage(WriteCharacteristicTask.createWriteCharacteristicErrorMessage(service.getUuid(), characteristic.getUuid(), status));
            }

            // if characteristic / descriptor callbacked, clear busy status
            mTaskHandler.clearBusy();
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        // gatt instance is not matched
        if (gatt != mBluetoothGatt) {
            return;
        }
        try {
            getBLECallback().onCharacteristicNotified(mBluetoothDevice, characteristic.getService().getUuid(), characteristic.getUuid(), characteristic.getValue());
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        // gatt instance is not matched
        if (gatt != mBluetoothGatt) {
            return;
        }
        try {
            BluetoothGattCharacteristic characteristic = descriptor.getCharacteristic();
            UUID characteristicUUID = characteristic.getUuid();
            BluetoothGattService service = characteristic.getService();
            UUID descriptorUUID = descriptor.getUuid();
            if (BluetoothGatt.GATT_SUCCESS == status) {
                if (CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR.equals(descriptorUUID)) {
                    ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptor);
                    boolean isNotification = clientCharacteristicConfiguration.isNotification() || clientCharacteristicConfiguration.isIndication();

                    // set notification status
                    if (isNotification) {
                        mNotificationSet.add(characteristicUUID);
                    } else {
                        mNotificationSet.remove(characteristicUUID);
                    }
                    gatt.setCharacteristicNotification(descriptor.getCharacteristic(), isNotification);
                }
                // read decriptor task finished
                mTaskHandler.sendProcessingMessage(ReadDescriptorTask.createReadDescriptorSuccessMessage(service.getUuid(), characteristicUUID, descriptorUUID, descriptor.getValue()));
            } else {
                mTaskHandler.sendProcessingMessage(ReadDescriptorTask.createReadDescriptorErrorMessage(service.getUuid(), characteristicUUID, descriptorUUID, status));
            }

            // if characteristic / descriptor callbacked, clear busy status
            mTaskHandler.clearBusy();
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        // gatt instance is not matched
        if (gatt != mBluetoothGatt) {
            return;
        }
        try {
            BluetoothGattCharacteristic characteristic = descriptor.getCharacteristic();
            UUID characteristicUUID = characteristic.getUuid();
            BluetoothGattService service = characteristic.getService();
            UUID descriptorUUID = descriptor.getUuid();
            if (BluetoothGatt.GATT_SUCCESS == status) {
                if (CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR.equals(descriptorUUID)) {
                    ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptor);
                    boolean isNotification = clientCharacteristicConfiguration.isNotification() || clientCharacteristicConfiguration.isIndication();

                    // set notification status
                    if (isNotification) {
                        mNotificationSet.add(characteristicUUID);
                    } else {
                        mNotificationSet.remove(characteristicUUID);
                    }
                    gatt.setCharacteristicNotification(descriptor.getCharacteristic(), isNotification);
                }
                // write decriptor task finished
                mTaskHandler.sendProcessingMessage(WriteDescriptorTask.createWriteDescriptorSuccessMessage(service.getUuid(), characteristicUUID, descriptorUUID, descriptor.getValue()));
            } else {
                mTaskHandler.sendProcessingMessage(WriteDescriptorTask.createWriteDescriptorErrorMessage(service.getUuid(), characteristicUUID, descriptorUUID, status));
            }

            // if characteristic / descriptor callbacked, clear busy status
            mTaskHandler.clearBusy();
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public synchronized void onMtuChanged(BluetoothGatt gatt, int mtu, int status) {
        BLELogUtils.stackLog(mtu, status);
        if (mTaskHandler != null) {
            if (BluetoothGatt.GATT_SUCCESS == status) {
                // mtu updated

                mTaskHandler.sendProcessingMessage(RequestMtuTask.createRequestMtuSuccess(mtu));
            } else {
                // mtu update failed

                mTaskHandler.sendProcessingMessage(RequestMtuTask.createRequestMtuErrorMessage(gatt, status));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public synchronized void onPhyRead(BluetoothGatt gatt, int txPhy, int rxPhy, int status) {
        BLELogUtils.stackLog(txPhy, rxPhy, status);
        if (mTaskHandler != null) {
            if (BluetoothGatt.GATT_SUCCESS == status) {
                // mtu updated

                mTaskHandler.sendProcessingMessage(ReadPhyTask.createReadPhySuccessMessage(txPhy, rxPhy));
            } else {
                // mtu update failed

                mTaskHandler.sendProcessingMessage(ReadPhyTask.createReadPhyErrorMessage(status));
            }
        }
    }

    /**
     * @see #createReadCharacteristicTask(UUID, UUID, long, Bundle, BLECallback)
     */
    public Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout) {
        return createReadCharacteristicTask(serviceUUID, characteristicUUID, timeout, null, null);
    }

    /**
     * Create read characteristic task
     *
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param timeout            timeout(millis)
     * @param argument           callback argument
     * @param bleCallback        {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registed
     */
    public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        BluetoothGatt bluetoothGatt = mBluetoothGatt;
        if (bluetoothGatt != null) {
            ReadCharacteristicTask task = new ReadCharacteristicTask(this, bluetoothGatt, mTaskHandler, serviceUUID, characteristicUUID, timeout, BLECallbackDistributer.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * @see #createWriteCharacteristicTask(UUID, UUID, ByteArrayInterface, int, long, Bundle, BLECallback)
     */
    public Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout) {
        return createWriteCharacteristicTask(serviceUUID, characteristicUUID, byteArrayInterface, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, timeout, null, null);
    }

    /**
     * @see #createWriteCharacteristicTask(UUID, UUID, ByteArrayInterface, int, long, Bundle, BLECallback)
     */
    public Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout) {
        return createWriteCharacteristicTask(serviceUUID, characteristicUUID, byteArrayInterface, writeType, timeout, null, null);
    }

    /**
     * Create write characteristic task
     *
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param byteArrayInterface write data
     * @param writeType          one of {@link BluetoothGattCharacteristic#WRITE_TYPE_DEFAULT}, {@link BluetoothGattCharacteristic#WRITE_TYPE_NO_RESPONSE}, {@link BluetoothGattCharacteristic#WRITE_TYPE_SIGNED}
     * @param timeout            timeout(millis)
     * @param argument           callback argument
     * @param bleCallback        {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registed
     */
    public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (mBluetoothGatt != null) {
            WriteCharacteristicTask task = new WriteCharacteristicTask(this, mBluetoothGatt, mTaskHandler, serviceUUID, characteristicUUID, byteArrayInterface, writeType, timeout, BLECallbackDistributer.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * @see #createReadDescriptorTask(UUID, UUID, UUID, long, Bundle, BLECallback)
     */
    public Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout) {
        return createReadDescriptorTask(serviceUUID, characteristicUUID, descriptorUUID, timeout, null, null);
    }

    /**
     * Create read descriptor task
     *
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor {@link UUID}
     * @param timeout            timeout(millis)
     * @param argument           callback argument
     * @param bleCallback        {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registed
     */
    public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (mBluetoothGatt != null) {
            ReadDescriptorTask task = new ReadDescriptorTask(this, mBluetoothGatt, mTaskHandler, serviceUUID, characteristicUUID, descriptorUUID, timeout, BLECallbackDistributer.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * @see #createWriteDescriptorTask(UUID, UUID, UUID, ByteArrayInterface, long, Bundle, BLECallback)
     */
    public Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout) {
        return createWriteDescriptorTask(serviceUUID, characteristicUUID, descriptorUUID, byteArrayInterface, timeout, null, null);
    }

    /**
     * Create write descriptor task
     *
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor {@link UUID}
     * @param byteArrayInterface write data
     * @param timeout            timeout(millis)
     * @param argument           callback argument
     * @param bleCallback        {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registed
     */
    public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (mBluetoothGatt != null) {
            WriteDescriptorTask task = new WriteDescriptorTask(this, mBluetoothGatt, mTaskHandler, serviceUUID, characteristicUUID, descriptorUUID, byteArrayInterface, timeout, BLECallbackDistributer.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * Create read phy task
     *
     * @param timeout     timeout(millis)
     * @param argument    callback argument
     * @param bleCallback {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registed
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public synchronized Integer createReadPhyTask(long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (mBluetoothGatt != null) {
            ReadPhyTask task = new ReadPhyTask(this, mBluetoothGatt, mTaskHandler, timeout, BLECallbackDistributer.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized Set<BLECallback> getSubscriberCallbackSet() {
        return new HashSet<>(mAttachedBLECallbackSet);
    }
}
