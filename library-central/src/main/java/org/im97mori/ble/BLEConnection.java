package org.im97mori.ble;

import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;

import android.annotation.SuppressLint;
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

import androidx.annotation.DeprecatedSinceApi;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.task.AbortReliableWriteTask;
import org.im97mori.ble.task.AbstractBLETask;
import org.im97mori.ble.task.BeginReliableWriteTask;
import org.im97mori.ble.task.ConnectTask;
import org.im97mori.ble.task.DisconnectTask;
import org.im97mori.ble.task.DiscoverServiceTask;
import org.im97mori.ble.task.ExecuteReliableWriteTask;
import org.im97mori.ble.task.NotifiedTask;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.ReadPhyTask;
import org.im97mori.ble.task.ReadRemoteRssiTask;
import org.im97mori.ble.task.RequestMtuTask;
import org.im97mori.ble.task.ServiceChangedTask;
import org.im97mori.ble.task.SetNotifyTask;
import org.im97mori.ble.task.SetPreferredPhyTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * BLE connection(central role)
 * <p>
 * Asynchronous
 */
public class BLEConnection extends BluetoothGattCallback implements BLECallbackDistributor.SubscriberInterface {

    /**
     * BLE device
     */
    private final BluetoothDevice mBluetoothDevice;

    /**
     * {@link Context} instance
     */
    protected final Context mContext;

    /**
     * newest {@link BluetoothGatt} instance
     */
    protected BluetoothGatt mBluetoothGatt;

    /**
     * newest {@link TaskHandler} instance
     */
    protected TaskHandler mTaskHandler;

    /**
     * for {@link BLECallbackDistributor.SubscriberInterface#getSubscriberCallbackSet()}
     */
    protected final Set<BLECallback> mAttachedBLECallbackSet = new HashSet<>();

    /**
     * {@link BLECallbackDistributor} instance
     */
    protected BLECallbackDistributor mBLECallbackDistributor;

    /**
     * @param context                {@link Context} instance
     * @param bluetoothDevice        BLE device
     * @param bleCallbackDistributor distributor instance
     */
    public BLEConnection(@NonNull Context context, @NonNull BluetoothDevice bluetoothDevice, @Nullable BLECallbackDistributor bleCallbackDistributor) {
        mContext = context.getApplicationContext();
        mBluetoothDevice = bluetoothDevice;
        mBLECallbackDistributor = bleCallbackDistributor;
    }

    /**
     * newest {@link BluetoothGatt} instance
     */
    public BluetoothGatt getBluetoothGatt() {
        return mBluetoothGatt;
    }

    /**
     * newest {@link TaskHandler} instance
     */
    public TaskHandler getTaskHandler() {
        return mTaskHandler;
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
    @SuppressWarnings("unused")
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
     * @param needMtuSetting {@code true}:try 512octet mtu setting, {@code false}:no mtu setting
     * @param timeout        timeout(millis)
     * @param argument       callback argument
     * @param bleCallback    {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @Nullable
    public synchronized Integer connect(boolean needMtuSetting
            , long timeout
            , @Nullable Bundle argument
            , @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (mBluetoothGatt == null) {
            start();

            ConnectTask task = new ConnectTask(this, mTaskHandler, needMtuSetting, timeout, BLECallbackDistributor.wrapArgument(argument, bleCallback));
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
     * @return task id. if {@code null} returned, task was not registered
     */
    @SuppressWarnings("unused")
    @Nullable
    public Integer createDiscoverServiceTask(long timeout
            , @Nullable Bundle argument
            , @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        BluetoothGatt bluetoothGatt = mBluetoothGatt;
        if (bluetoothGatt != null) {
            DiscoverServiceTask task = new DiscoverServiceTask(this, bluetoothGatt, mTaskHandler, timeout, BLECallbackDistributor.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * create request mtu task
     *
     * @param mtu         {@link BluetoothGatt#requestMtu(int)} 1st argument
     * @param timeout     timeout(millis)
     * @param argument    callback argument
     * @param bleCallback {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @SuppressWarnings("unused")
    @Nullable
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Integer createRequestMtuTask(int mtu
            , long timeout
            , @Nullable Bundle argument
            , @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        BluetoothGatt bluetoothGatt = mBluetoothGatt;
        if (bluetoothGatt != null) {
            RequestMtuTask task = new RequestMtuTask(this, bluetoothGatt, mTaskHandler, mtu, timeout, BLECallbackDistributor.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * @see #quit(Bundle, BLECallback)
     */
    @SuppressWarnings("UnusedReturnValue")
    @Nullable
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
     * @return task id. if {@code null} returned, task was not registered
     */
    @Nullable
    public synchronized Integer quit(@Nullable Bundle argument
            , @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (isConnected()) {
            mTaskHandler.clearTask();

            DisconnectTask task = new DisconnectTask(this, mBluetoothGatt, BLECallbackDistributor.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * Clear all task
     */
    @SuppressWarnings("unused")
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
    @SuppressWarnings("unused")
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
     * Callback at connected and service discover success
     *
     * @param taskId        task id
     * @param bluetoothGatt Connected {@link BluetoothGatt}
     * @param argument      callback argument
     */
    public synchronized void onConnected(@NonNull Integer taskId
            , @NonNull BluetoothGatt bluetoothGatt
            , @NonNull Bundle argument) {
        if (mBluetoothGatt == null) {
            mBluetoothGatt = bluetoothGatt;

            getBLECallback().onBLEConnected(taskId, mBluetoothDevice, argument);
        }
    }

    /**
     * Callback at {@link ConnectTask} failed
     *
     * @param taskId   task id
     * @param status   {@link BLEConnection#onConnectionStateChange(BluetoothGatt, int, int)} 2nd parameter
     *                 {@link org.im97mori.ble.task.ConnectTask#STATUS_CANCEL}
     *                 {@link org.im97mori.ble.task.ConnectTask#STATUS_CONNECT_GATT_FAILED}
     *                 {@link org.im97mori.ble.task.ConnectTask#STATUS_DISCOVER_SERVICES_FAILED}
     * @param argument callback argument
     */
    public synchronized void onConnectFailed(@NonNull Integer taskId
            , int status
            , @NonNull Bundle argument) {
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
    public synchronized void onConnectTimeout(@NonNull Integer taskId
            , @NonNull Bundle argument) {
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
     * @param status        {@link android.bluetooth.BluetoothGattCallback#onConnectionStateChange(BluetoothGatt, int, int)} 2nd parameter
     *                      {@link org.im97mori.ble.task.DisconnectTask#STATUS_CANCEL}
     *                      {@link org.im97mori.ble.task.DisconnectTask#STATUS_MANUAL_DISCONNECT}
     * @param argument      callback argument
     */
    public synchronized void onDisconnected(@NonNull Integer taskId
            , @NonNull BluetoothGatt bluetoothGatt
            , int status
            , @NonNull Bundle argument) {
        if (bluetoothGatt == mBluetoothGatt) {
            mBluetoothGatt = null;
            if (mTaskHandler != null) {
                mTaskHandler.quit();
                mTaskHandler = null;
            }

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
        if (mBLECallbackDistributor == null) {
            mBLECallbackDistributor = new BLECallbackDistributor(this);
        }
        return mBLECallbackDistributor;
    }

    /**
     * check connection status
     *
     * @return {@code true}:{@link BLEConnection} has connected {@link BluetoothGatt}, {@code false}:don't have connected {@link BluetoothGatt}
     */
    public boolean isConnected() {
        return mBluetoothGatt != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onConnectionStateChange(BluetoothGatt gatt
            , int status
            , int newState) {
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
                DisconnectTask task = new DisconnectTask(this, gatt, status, BLECallbackDistributor.wrapArgument(null, null));
                mTaskHandler.addTask(task);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onServicesDiscovered(BluetoothGatt gatt
            , int status) {
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
    @DeprecatedSinceApi(api = Build.VERSION_CODES.TIRAMISU)
    @Deprecated
    public synchronized void onCharacteristicRead(BluetoothGatt gatt
            , BluetoothGattCharacteristic characteristic
            , int status) {
        // gatt instance is not matched
        if (gatt != mBluetoothGatt) {
            return;
        }
        try {
            BluetoothGattService service = characteristic.getService();
            if (BluetoothGatt.GATT_SUCCESS == status) {
                mTaskHandler.sendProcessingMessage(ReadCharacteristicTask.createReadCharacteristicSuccessMessage(service.getUuid(), service.getInstanceId(), characteristic.getUuid(), characteristic.getInstanceId(), characteristic.getValue()));
            } else {
                mTaskHandler.sendProcessingMessage(ReadCharacteristicTask.createReadCharacteristicErrorMessage(service.getUuid(), service.getInstanceId(), characteristic.getUuid(), characteristic.getInstanceId(), status));
            }

            // if characteristic / descriptor callback, clear busy status
            mTaskHandler.clearBusy();
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicRead(@NonNull BluetoothGatt gatt
            , @NonNull BluetoothGattCharacteristic characteristic
            , @NonNull byte[] value
            , int status) {
        // gatt instance is not matched
        if (gatt != mBluetoothGatt) {
            return;
        }
        try {
            BluetoothGattService service = characteristic.getService();
            if (BluetoothGatt.GATT_SUCCESS == status) {
                mTaskHandler.sendProcessingMessage(ReadCharacteristicTask.createReadCharacteristicSuccessMessage(service.getUuid(), service.getInstanceId(), characteristic.getUuid(), characteristic.getInstanceId(), value));
            } else {
                mTaskHandler.sendProcessingMessage(ReadCharacteristicTask.createReadCharacteristicErrorMessage(service.getUuid(), service.getInstanceId(), characteristic.getUuid(), characteristic.getInstanceId(), status));
            }

            // if characteristic / descriptor callback, clear busy status
            mTaskHandler.clearBusy();
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWrite(BluetoothGatt gatt
            , BluetoothGattCharacteristic characteristic
            , int status) {
        // gatt instance is not matched
        if (gatt != mBluetoothGatt) {
            return;
        }
        try {
            BluetoothGattService service = characteristic.getService();
            if (BluetoothGatt.GATT_SUCCESS == status) {
                mTaskHandler.sendProcessingMessage(WriteCharacteristicTask.createWriteCharacteristicSuccessMessage(service.getUuid(), service.getInstanceId(), characteristic.getUuid(), characteristic.getInstanceId()));
            } else {
                mTaskHandler.sendProcessingMessage(WriteCharacteristicTask.createWriteCharacteristicErrorMessage(service.getUuid(), service.getInstanceId(), characteristic.getUuid(), characteristic.getInstanceId(), status));
            }

            // if characteristic / descriptor callback, clear busy status
            mTaskHandler.clearBusy();
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @DeprecatedSinceApi(api = Build.VERSION_CODES.TIRAMISU)
    @Deprecated
    public synchronized void onCharacteristicChanged(BluetoothGatt gatt
            , BluetoothGattCharacteristic characteristic) {
        // gatt instance is not matched
        if (gatt != mBluetoothGatt) {
            return;
        }
        try {
            mTaskHandler.addHighPriorityTask(new NotifiedTask(this, characteristic.getService().getUuid(), characteristic.getService().getInstanceId(), characteristic.getUuid(), characteristic.getInstanceId(), characteristic.getValue()));
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicChanged(@NonNull BluetoothGatt gatt
            , @NonNull BluetoothGattCharacteristic characteristic
            , @NonNull byte[] value) {
        // gatt instance is not matched
        if (gatt != mBluetoothGatt) {
            return;
        }
        try {
            mTaskHandler.addHighPriorityTask(new NotifiedTask(this, characteristic.getService().getUuid(), characteristic.getService().getInstanceId(), characteristic.getUuid(), characteristic.getInstanceId(), value));
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("MissingPermission")
    @Override
    @DeprecatedSinceApi(api = Build.VERSION_CODES.TIRAMISU)
    @Deprecated
    public synchronized void onDescriptorRead(BluetoothGatt gatt
            , BluetoothGattDescriptor descriptor
            , int status) {
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
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    ClientCharacteristicConfigurationAndroid clientCharacteristicConfiguration = new ClientCharacteristicConfigurationAndroid(descriptor.getValue());
                    gatt.setCharacteristicNotification(descriptor.getCharacteristic(), clientCharacteristicConfiguration.isPropertiesNotificationsEnabled() || clientCharacteristicConfiguration.isPropertiesIndicationsEnabled());
                }
                // read descriptor task finished
                mTaskHandler.sendProcessingMessage(ReadDescriptorTask.createReadDescriptorSuccessMessage(service.getUuid(), service.getInstanceId(), characteristicUUID, characteristic.getInstanceId(), descriptorUUID, BLEUtilsAndroid.getDescriptorInstanceId(descriptor), descriptor.getValue()));
            } else {
                mTaskHandler.sendProcessingMessage(ReadDescriptorTask.createReadDescriptorErrorMessage(service.getUuid(), service.getInstanceId(), characteristicUUID, characteristic.getInstanceId(), descriptorUUID, BLEUtilsAndroid.getDescriptorInstanceId(descriptor), status));
            }

            // if characteristic / descriptor callback, clear busy status
            mTaskHandler.clearBusy();
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("MissingPermission")
    @Override
    public void onDescriptorRead(@NonNull BluetoothGatt gatt
            , @NonNull BluetoothGattDescriptor descriptor
            , int status
            , @NonNull byte[] value) {
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
                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                    ClientCharacteristicConfigurationAndroid clientCharacteristicConfiguration = new ClientCharacteristicConfigurationAndroid(value);
                    gatt.setCharacteristicNotification(descriptor.getCharacteristic(), clientCharacteristicConfiguration.isPropertiesNotificationsEnabled() || clientCharacteristicConfiguration.isPropertiesIndicationsEnabled());
                }
                // read descriptor task finished
                mTaskHandler.sendProcessingMessage(ReadDescriptorTask.createReadDescriptorSuccessMessage(service.getUuid(), service.getInstanceId(), characteristicUUID, characteristic.getInstanceId(), descriptorUUID, BLEUtilsAndroid.getDescriptorInstanceId(descriptor), value));
            } else {
                mTaskHandler.sendProcessingMessage(ReadDescriptorTask.createReadDescriptorErrorMessage(service.getUuid(), service.getInstanceId(), characteristicUUID, characteristic.getInstanceId(), descriptorUUID, BLEUtilsAndroid.getDescriptorInstanceId(descriptor), status));
            }

            // if characteristic / descriptor callback, clear busy status
            mTaskHandler.clearBusy();
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWrite(BluetoothGatt gatt
            , BluetoothGattDescriptor descriptor
            , int status) {
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
                // write descriptor task finished
                mTaskHandler.sendProcessingMessage(WriteDescriptorTask.createWriteDescriptorSuccessMessage(service.getUuid(), service.getInstanceId(), characteristicUUID, characteristic.getInstanceId(), descriptorUUID, BLEUtilsAndroid.getDescriptorInstanceId(descriptor)));
            } else {
                mTaskHandler.sendProcessingMessage(WriteDescriptorTask.createWriteDescriptorErrorMessage(service.getUuid(), service.getInstanceId(), characteristicUUID, characteristic.getInstanceId(), descriptorUUID, BLEUtilsAndroid.getDescriptorInstanceId(descriptor), status));
            }

            // if characteristic / descriptor callback, clear busy status
            mTaskHandler.clearBusy();
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReliableWriteCompleted(BluetoothGatt gatt
            , int status) {
        // gatt instance is not matched
        if (gatt != mBluetoothGatt) {
            return;
        }
        try {
            if (BluetoothGatt.GATT_SUCCESS == status) {
                // reliable write success

                mTaskHandler.sendProcessingMessage(ExecuteReliableWriteTask.createExecuteReliableWriteSuccessMessage());
            } else {
                // reliable write failed

                mTaskHandler.sendProcessingMessage(ExecuteReliableWriteTask.createExecuteReliableWriteErrorMessage(status));
            }
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadRemoteRssi(BluetoothGatt gatt
            , int rssi
            , int status) {
        // gatt instance is not matched
        if (gatt != mBluetoothGatt) {
            return;
        }
        try {
            if (BluetoothGatt.GATT_SUCCESS == status) {
                // read remote rssi success

                mTaskHandler.sendProcessingMessage(ReadRemoteRssiTask.createReadRemoteRssiSuccessMessage(rssi));
            } else {
                // read remote rssi failed

                mTaskHandler.sendProcessingMessage(ReadRemoteRssiTask.createReadRemoteRssiErrorMessage(status));
            }
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public synchronized void onMtuChanged(BluetoothGatt gatt
            , int mtu
            , int status) {
        try {
            if (mTaskHandler != null) {
                if (BluetoothGatt.GATT_SUCCESS == status) {
                    // mtu update success

                    mTaskHandler.sendProcessingMessage(RequestMtuTask.createRequestMtuSuccessMessage(mtu));
                } else {
                    // mtu update failed

                    mTaskHandler.sendProcessingMessage(RequestMtuTask.createRequestMtuErrorMessage(gatt, status));
                }
            }
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceChanged(@NonNull BluetoothGatt gatt) {
        // gatt instance is not matched
        if (gatt != mBluetoothGatt) {
            return;
        }
        try {
            mTaskHandler.addHighPriorityTask(new ServiceChangedTask(this));
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onPhyUpdate(BluetoothGatt gatt
            , int txPhy
            , int rxPhy
            , int status) {
        // gatt instance is not matched
        if (gatt != mBluetoothGatt) {
            return;
        }
        try {
            if (BluetoothGatt.GATT_SUCCESS == status) {
                // phy update success

                mTaskHandler.sendProcessingMessage(SetPreferredPhyTask.createSetPreferredPhySuccessMessage(txPhy, rxPhy));
            } else {
                // phy update failed

                mTaskHandler.sendProcessingMessage(SetPreferredPhyTask.createSetPreferredPhyErrorMessage(status));
            }
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public synchronized void onPhyRead(BluetoothGatt gatt
            , int txPhy
            , int rxPhy
            , int status) {
        // gatt instance is not matched
        if (gatt != mBluetoothGatt) {
            return;
        }
        try {
            if (BluetoothGatt.GATT_SUCCESS == status) {
                // phy read success

                mTaskHandler.sendProcessingMessage(ReadPhyTask.createReadPhySuccessMessage(txPhy, rxPhy));
            } else {
                // phy read failed

                mTaskHandler.sendProcessingMessage(ReadPhyTask.createReadPhyErrorMessage(status));
            }
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * @see #createReadCharacteristicTask(UUID, Integer, UUID, Integer, long, Bundle, BLECallback)
     */
    @SuppressWarnings("unused")
    @Nullable
    public Integer createReadCharacteristicTask(@NonNull UUID serviceUUID
            , @NonNull UUID characteristicUUID
            , long timeout) {
        return createReadCharacteristicTask(serviceUUID, null, characteristicUUID, null, timeout, null, null);
    }

    /**
     * Create read characteristic task
     *
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     * @param bleCallback              {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @Nullable
    public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument
            , @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        BluetoothGatt bluetoothGatt = mBluetoothGatt;
        if (bluetoothGatt != null) {
            ReadCharacteristicTask task = new ReadCharacteristicTask(this, bluetoothGatt, mTaskHandler, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, BLECallbackDistributor.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * @see #createWriteCharacteristicTask(UUID, Integer, UUID, Integer, ByteArrayInterface, int, long, Bundle, BLECallback)
     */
    @SuppressWarnings("unused")
    @Nullable
    public Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID
            , @NonNull UUID characteristicUUID
            , @NonNull ByteArrayInterface byteArrayInterface
            , long timeout) {
        return createWriteCharacteristicTask(serviceUUID, null, characteristicUUID, null, byteArrayInterface, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, timeout, null, null);
    }

    /**
     * @see #createWriteCharacteristicTask(UUID, Integer, UUID, Integer, ByteArrayInterface, int, long, Bundle, BLECallback)
     */
    @SuppressWarnings("unused")
    @Nullable
    public Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID
            , @NonNull UUID characteristicUUID
            , @NonNull ByteArrayInterface byteArrayInterface
            , int writeType
            , long timeout) {
        return createWriteCharacteristicTask(serviceUUID, null, characteristicUUID, null, byteArrayInterface, writeType, timeout, null, null);
    }

    /**
     * Create write characteristic task
     *
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param byteArrayInterface       write data
     * @param writeType                {@link BluetoothGattCharacteristic#WRITE_TYPE_DEFAULT}
     *                                 {@link BluetoothGattCharacteristic#WRITE_TYPE_NO_RESPONSE}
     *                                 {@link BluetoothGattCharacteristic#WRITE_TYPE_SIGNED}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     * @param bleCallback              {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @Nullable
    public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull ByteArrayInterface byteArrayInterface
            , int writeType
            , long timeout
            , @Nullable Bundle argument
            , @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (isConnected()) {
            WriteCharacteristicTask task = new WriteCharacteristicTask(this, mBluetoothGatt, mTaskHandler, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, byteArrayInterface.getBytes(), writeType, timeout, BLECallbackDistributor.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * @see #createReadDescriptorTask(UUID, Integer, UUID, Integer, UUID, Integer, long, Bundle, BLECallback)
     */
    @SuppressWarnings("unused")
    @Nullable
    public Integer createReadDescriptorTask(@NonNull UUID serviceUUID
            , @NonNull UUID characteristicUUID
            , @NonNull UUID descriptorUUID
            , long timeout) {
        return createReadDescriptorTask(serviceUUID, null, characteristicUUID, null, descriptorUUID, null, timeout, null, null);
    }

    /**
     * Create read descriptor task
     *
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           descriptor {@link UUID}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     * @param bleCallback              {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @Nullable
    public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull UUID descriptorUUID
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument
            , @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (isConnected()) {
            ReadDescriptorTask task = new ReadDescriptorTask(this, mBluetoothGatt, mTaskHandler, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, BLECallbackDistributor.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * @see #createWriteDescriptorTask(UUID, Integer, UUID, Integer, UUID, Integer, ByteArrayInterface, long, Bundle, BLECallback)
     */
    @SuppressWarnings("unused")
    @Nullable
    public Integer createWriteDescriptorTask(@NonNull UUID serviceUUID
            , @NonNull UUID characteristicUUID
            , @NonNull UUID descriptorUUID
            , @NonNull ByteArrayInterface byteArrayInterface
            , long timeout) {
        return createWriteDescriptorTask(serviceUUID, null, characteristicUUID, null, descriptorUUID, null, byteArrayInterface, timeout, null, null);
    }

    /**
     * Create write descriptor task
     *
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           descriptor {@link UUID}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param byteArrayInterface       write data
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     * @param bleCallback              {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @Nullable
    public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull UUID descriptorUUID
            , @Nullable Integer descriptorInstanceId
            , @NonNull ByteArrayInterface byteArrayInterface
            , long timeout
            , @Nullable Bundle argument
            , @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (isConnected()) {
            WriteDescriptorTask task = new WriteDescriptorTask(this, mBluetoothGatt, mTaskHandler, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, byteArrayInterface.getBytes(), timeout, BLECallbackDistributor.wrapArgument(argument, bleCallback));
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
     * @return task id. if {@code null} returned, task was not registered
     */
    @SuppressWarnings("unused")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    public synchronized Integer createReadPhyTask(long timeout
            , @Nullable Bundle argument
            , @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (isConnected()) {
            ReadPhyTask task = new ReadPhyTask(this, mBluetoothGatt, mTaskHandler, timeout, BLECallbackDistributor.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * Create set preferred phy task
     *
     * @param txPhy       new txPhy for {@link BluetoothGatt#setPreferredPhy(int, int, int)} 1st argument
     * @param rxPhy       new rxPhy for {@link BluetoothGatt#setPreferredPhy(int, int, int)} 2nd argument
     * @param phyOptions  new phyOptions for {@link BluetoothGatt#setPreferredPhy(int, int, int)} 3rd argument
     * @param timeout     timeout(millis)
     * @param argument    callback argument
     * @param bleCallback {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @SuppressWarnings("unused")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    public synchronized Integer createSetPreferredPhyTask(int txPhy
            , int rxPhy
            , int phyOptions
            , long timeout
            , @Nullable Bundle argument
            , @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (isConnected()) {
            SetPreferredPhyTask task = new SetPreferredPhyTask(this, mBluetoothGatt, mTaskHandler, txPhy, rxPhy, phyOptions, timeout, BLECallbackDistributor.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * Create read remote rssi task
     *
     * @param timeout     timeout(millis)
     * @param argument    callback argument
     * @param bleCallback {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @SuppressWarnings("unused")
    @Nullable
    public synchronized Integer createReadRemoteRssiTask(long timeout
            , @Nullable Bundle argument
            , @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (isConnected()) {
            ReadRemoteRssiTask task = new ReadRemoteRssiTask(this, mBluetoothGatt, mTaskHandler, timeout, BLECallbackDistributor.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * Create begin reliable write task
     *
     * @param argument    callback argument
     * @param bleCallback {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @SuppressWarnings("unused")
    @Nullable
    public synchronized Integer createBeginReliableWriteTask(@Nullable Bundle argument
            , @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (isConnected()) {
            BeginReliableWriteTask task = new BeginReliableWriteTask(this, mBluetoothGatt, BLECallbackDistributor.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * Create execute reliable write task
     *
     * @param timeout     timeout(millis)
     * @param argument    callback argument
     * @param bleCallback {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @SuppressWarnings("unused")
    @Nullable
    public synchronized Integer createExecuteReliableWriteTask(long timeout
            , @Nullable Bundle argument
            , @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (isConnected()) {
            ExecuteReliableWriteTask task = new ExecuteReliableWriteTask(this, mBluetoothGatt, mTaskHandler, timeout, BLECallbackDistributor.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * Create abort reliable write task
     *
     * @param timeout     timeout(millis)
     * @param argument    callback argument
     * @param bleCallback {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @SuppressWarnings("unused")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public synchronized Integer createAbortReliableWriteTask(long timeout
            , @Nullable Bundle argument
            , @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        if (isConnected()) {
            AbortReliableWriteTask task = new AbortReliableWriteTask(this, mBluetoothGatt, mTaskHandler, timeout, BLECallbackDistributor.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * Create set notification task
     *
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param notificationStatus       {@link BluetoothGatt#setCharacteristicNotification(BluetoothGattCharacteristic, boolean)} 2nd parameter
     * @param argument                 callback argument
     * @param bleCallback              {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @SuppressWarnings("unused")
    @Nullable
    public synchronized Integer createSetNotifyTask(@NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , boolean notificationStatus
            , @Nullable Bundle argument
            , @Nullable BLECallback bleCallback) {
        Integer taskId = null;
        BluetoothGatt bluetoothGatt = mBluetoothGatt;
        if (bluetoothGatt != null) {
            SetNotifyTask task = new SetNotifyTask(this, bluetoothGatt, mTaskHandler, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, notificationStatus, BLECallbackDistributor.wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public synchronized Set<BLECallback> getSubscriberCallbackSet() {
        return Collections.synchronizedSet(new HashSet<>(mAttachedBLECallbackSet));
    }
}
