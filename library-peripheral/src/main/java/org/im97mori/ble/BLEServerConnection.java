package org.im97mori.ble;

import static android.bluetooth.le.AdvertiseSettings.ADVERTISE_MODE_LOW_LATENCY;
import static android.bluetooth.le.AdvertiseSettings.ADVERTISE_TX_POWER_HIGH;
import static org.im97mori.ble.constants.ErrorCode.APPLICATION_ERROR_9F;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.ParcelUuid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.task.AbstractBLETask;
import org.im97mori.ble.task.AddServiceTask;
import org.im97mori.ble.task.NotifyTask;
import org.im97mori.ble.task.ReadPhyPeripheralTask;
import org.im97mori.ble.task.RemoveServiceTask;
import org.im97mori.ble.task.SetPreferredPhyPeripheralTask;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * BLE Connection(peripheral role)
 */
@SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
public class BLEServerConnection extends BluetoothGattServerCallback implements BLEServerCallbackDistributor.SubscriberInterface {

    private class BLEServerCallbackInner implements BLEServerCallback {

        @Override
        public void onServerStarted() {

        }

        @Override
        public synchronized void onServerStopped() {
            mDeviceSpecifiedTaskIdMap.clear();
        }

        @Override
        public void onDeviceConnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {

        }

        @Override
        public void onDeviceDisconnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {
            synchronized (BLEServerConnection.this) {
                Set<Integer> taskSet = mDeviceSpecifiedTaskIdMap.get(device.getAddress());
                if (taskSet != null) {
                    taskSet.forEach(taskId -> mTaskHandler.cancelTask(taskId));
                    taskSet.clear();
                }
            }
        }

        @Override
        public boolean onServiceAddSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, @Nullable Bundle argument) {
            return false;
        }

        @Override
        public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {

        }

        @Override
        public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {

        }

        @Override
        public void onServiceRemoveSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, @Nullable Bundle argument) {

        }

        @Override
        public void onServiceRemoveFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {

        }

        @Override
        public void onServiceRemoveTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {

        }

        @Override
        public boolean onCharacteristicReadRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean force) {
            return false;
        }

        @Override
        public boolean onCharacteristicWriteRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value, boolean force) {
            return false;
        }

        @Override
        public boolean onDescriptorReadRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattDescriptor bluetoothGattDescriptor, boolean force) {
            return false;
        }

        @Override
        public boolean onDescriptorWriteRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattDescriptor bluetoothGattDescriptor, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value, boolean force) {
            return false;
        }

        @Override
        public void onNotificationSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull byte[] value, @Nullable Bundle argument) {

        }

        @Override
        public synchronized void onNotificationFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int status, @Nullable Bundle argument) {

        }

        @Override
        public void onNotificationTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, long timeout, @Nullable Bundle argument) {

        }

        @Override
        public boolean onExecuteWrite(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, boolean execute, boolean force) {
            return false;
        }

        @Override
        public void onMtuChanged(@NonNull BluetoothDevice device, int mtu) {

        }

        @Override
        public synchronized void onPhyReadSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int txPhy, int rxPhy, @Nullable Bundle argument) {
            removeTaskId(device, taskId);
        }

        @Override
        public synchronized void onPhyReadFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int status, @Nullable Bundle argument) {
            removeTaskId(device, taskId);
        }

        @Override
        public synchronized void onPhyReadTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, long timeout, @Nullable Bundle argument) {
            removeTaskId(device, taskId);
        }

        @Override
        public synchronized void onSetPreferredPhySuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int txPhy, int rxPhy, int phyOptions, @Nullable Bundle argument) {
            removeTaskId(device, taskId);
        }

        @Override
        public synchronized void onSetPreferredPhyFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int status, @Nullable Bundle argument) {
            removeTaskId(device, taskId);
        }

        @Override
        public synchronized void onSetPreferredPhyTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, long timeout, @Nullable Bundle argument) {
            removeTaskId(device, taskId);
        }

        @Override
        public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {

        }

        @Override
        public void onAdvertisingStartFailed(@Nullable Integer errorCode) {

        }

        @Override
        public void onAdvertisingFinished() {

        }

        @Override
        public void setup(@NonNull BLEServerConnection bleServerConnection) {

        }

        @Override
        public void tearDown(@NonNull BLEServerConnection bleServerConnection) {

        }

        @Override
        public boolean isFallback() {
            return false;
        }
    }

    /**
     * Default(Minimum) MTU size
     */
    @SuppressWarnings("unused")
    public static final int DEFAULT_MTU = 23;

    /**
     * SERVICE_UUID for Advertising
     *
     * @see org.im97mori.ble.constants.DataType#COMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE
     */
    public static final UUID MOCK_CONTROL_SERVICE_UUID = UUID.fromString("00000000-a087-4fa3-add4-3b8a7d5d491f");

    /**
     * {@link Context} instance
     */
    protected final Context mContext;

    /**
     * {@link BluetoothManager} instance
     */
    protected final BluetoothManager mBluetoothManager;

    /**
     * {@link BluetoothAdapter} instance
     */
    protected final BluetoothAdapter mBluetoothAdapter;

    /**
     * {@link BluetoothGattServer} instance
     */
    protected BluetoothGattServer mBluetoothGattServer;

    /**
     * {@link AdvertiseCallback} instance
     */
    protected AdvertiseCallback mAdvertiseCallback;

    /**
     * {@link BluetoothLeAdvertiser} instance
     */
    protected BluetoothLeAdvertiser mBluetoothLeAdvertiser;

    /**
     * newest {@link TaskHandler} instance
     */
    protected TaskHandler mTaskHandler;

    /**
     * {@link BLEServerCallbackDistributor} instance
     */
    protected BLEServerCallbackDistributor mBLEServerCallbackDistributor;

    /**
     * for {@link BLEServerCallbackDistributor.SubscriberInterface#getSubscriberCallbackList()}
     */
    protected final List<BLEServerCallback> mAttachedBLEServerCallbackList = new LinkedList<>();

    /**
     * device specified task id map
     */
    protected final Map<String, Set<Integer>> mDeviceSpecifiedTaskIdMap = new HashMap<>();

    /**
     * @param context {@link Context} instance
     */
    public BLEServerConnection(@NonNull Context context) {
        mContext = context.getApplicationContext();
        mBluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        if (mBluetoothManager == null) {
            mBluetoothAdapter = null;
        } else {
            mBluetoothAdapter = mBluetoothManager.getAdapter();
        }
        mBLEServerCallbackDistributor = new BLEServerCallbackDistributor(this);
    }

    /**
     * check server status
     *
     * @return {@code true}:{@link BluetoothGattServer} and {@link BluetoothLeAdvertiser} started, {@code false}: server stopped
     */
    @SuppressWarnings("unused")
    public boolean isStarted() {
        return mBluetoothGattServer != null;
    }

    /**
     * start {@link BluetoothGattServer} and {@link BluetoothLeAdvertiser}
     */
    @SuppressLint("MissingPermission")
    public synchronized void start() {
        if (mBluetoothGattServer == null) {

            if (mBluetoothManager != null) {
                mBluetoothGattServer = mBluetoothManager.openGattServer(mContext, this);
                if (mBluetoothGattServer != null) {

                    HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
                    thread.start();
                    mTaskHandler = new TaskHandler(thread.getLooper());

                    mBLEServerCallbackDistributor.onServerStarted();

                    for (BLEServerCallback bleServerCallback : mAttachedBLEServerCallbackList) {
                        bleServerCallback.setup(this);
                    }
                }
            }
        }
    }

    /**
     * stop {@link BluetoothGattServer} and {@link BluetoothLeAdvertiser}
     */
    @SuppressLint("MissingPermission")
    public synchronized void quit() {
        stopAdvertising();

        if (mBluetoothGattServer != null) {
            mBluetoothGattServer.clearServices();
            mBluetoothGattServer.close();
            mBluetoothGattServer = null;
            mBLEServerCallbackDistributor.onServerStopped();
        }

        if (mTaskHandler != null) {
            mTaskHandler.quit();
            mTaskHandler = null;
        }

        mDeviceSpecifiedTaskIdMap.clear();
    }

    /**
     * attach callback
     *
     * @param bleServerCallback {@link BLEServerCallback}
     */
    public synchronized void attach(BLEServerCallback bleServerCallback) {
        if (mAttachedBLEServerCallbackList.add(bleServerCallback) && mBluetoothGattServer != null) {
            bleServerCallback.setup(this);
        }
    }

    /**
     * detach callback
     *
     * @param bleServerCallback {@link BLEServerCallback}
     */
    public synchronized void detach(BLEServerCallback bleServerCallback) {
        if (mAttachedBLEServerCallbackList.remove(bleServerCallback) && mBluetoothGattServer != null) {
            bleServerCallback.tearDown(this);
        }
    }

    /**
     * check target callback is attached
     *
     * @param bleServerCallback target callback
     * @return {@code true}:attached, {@code false}:not attached
     */
    public synchronized boolean isAttached(BLEServerCallback bleServerCallback) {
        return mAttachedBLEServerCallbackList.contains(bleServerCallback);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onConnectionStateChange(@NonNull BluetoothDevice device
            , int status
            , int newState) {
        if (mBluetoothGattServer != null) {
            if (BluetoothProfile.STATE_CONNECTED == newState) {
                mBLEServerCallbackDistributor.onDeviceConnected(this, device);
            } else if (BluetoothProfile.STATE_DISCONNECTED == newState) {
                mBLEServerCallbackDistributor.onDeviceDisconnected(this, device);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onServiceAdded(int status
            , @NonNull BluetoothGattService service) {
        if (mBluetoothGattServer != null) {
            if (BluetoothGatt.GATT_SUCCESS == status) {
                mTaskHandler.sendProcessingMessage(AddServiceTask.createAddServiceSuccessMessage(service));
            } else {
                mTaskHandler.sendProcessingMessage(AddServiceTask.createAddServiceErrorMessage(service, status));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("MissingPermission")
    @Override
    public synchronized void onCharacteristicReadRequest(@NonNull BluetoothDevice device
            , int requestId
            , int offset
            , @NonNull BluetoothGattCharacteristic characteristic) {
        if (mBluetoothGattServer != null) {
            if (!mBLEServerCallbackDistributor.onCharacteristicReadRequest(this, device, requestId, offset, characteristic, true)) {
                mBluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("MissingPermission")
    @Override
    public synchronized void onCharacteristicWriteRequest(@NonNull BluetoothDevice device
            , int requestId
            , @NonNull BluetoothGattCharacteristic characteristic
            , boolean preparedWrite
            , boolean responseNeeded
            , int offset
            , @NonNull byte[] value) {
        if (mBluetoothGattServer != null) {
            if (!mBLEServerCallbackDistributor.onCharacteristicWriteRequest(this, device, requestId, characteristic, preparedWrite, responseNeeded, offset, value, true) && responseNeeded) {
                mBluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("MissingPermission")
    @Override
    public synchronized void onDescriptorReadRequest(@NonNull BluetoothDevice device
            , int requestId
            , int offset
            , @NonNull BluetoothGattDescriptor descriptor) {
        if (mBluetoothGattServer != null) {
            if (!mBLEServerCallbackDistributor.onDescriptorReadRequest(this, device, requestId, offset, descriptor, true)) {
                mBluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("MissingPermission")
    @Override
    public synchronized void onDescriptorWriteRequest(@NonNull BluetoothDevice device
            , int requestId
            , BluetoothGattDescriptor descriptor
            , boolean preparedWrite
            , boolean responseNeeded
            , int offset
            , @NonNull byte[] value) {
        if (mBluetoothGattServer != null) {
            if (!mBLEServerCallbackDistributor.onDescriptorWriteRequest(this, device, requestId, descriptor, preparedWrite, responseNeeded, offset, value, true) && responseNeeded) {
                mBluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("MissingPermission")
    @Override
    public synchronized void onExecuteWrite(BluetoothDevice device
            , int requestId
            , boolean execute) {
        if (mBluetoothGattServer != null) {
            if (!mBLEServerCallbackDistributor.onExecuteWrite(this, device, requestId, execute, true)) {
                mBluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, 0, null);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onNotificationSent(BluetoothDevice device
            , int status) {
        if (mBluetoothGattServer != null) {
            if (BluetoothGatt.GATT_SUCCESS == status) {
                mTaskHandler.sendProcessingMessage(NotifyTask.createNotificationSentSuccessMessage(device));
            } else {
                mTaskHandler.sendProcessingMessage(NotifyTask.createNotificationSentErrorMessage(device, status));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onMtuChanged(BluetoothDevice device, int mtu) {
        BLEPeripheralLogUtils.stackLog(device, mtu);
        if (mBluetoothGattServer != null) {
            mBLEServerCallbackDistributor.onMtuChanged(device, mtu);
        }
    }

    /**
     * {@inheritDoc}
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onPhyUpdate(BluetoothDevice device, int txPhy, int rxPhy, int status) {
        if (mBluetoothGattServer != null) {
            if (BluetoothGatt.GATT_SUCCESS == status) {
                mTaskHandler.sendProcessingMessage(SetPreferredPhyPeripheralTask.createSetPreferredPhySuccessMessage(device, txPhy, rxPhy));
            } else {
                mTaskHandler.sendProcessingMessage(SetPreferredPhyPeripheralTask.createSetPreferredPhyErrorMessage(device, status));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onPhyRead(BluetoothDevice device, int txPhy, int rxPhy, int status) {
        if (mBluetoothGattServer != null) {
            if (BluetoothGatt.GATT_SUCCESS == status) {
                mTaskHandler.sendProcessingMessage(ReadPhyPeripheralTask.createReadPhySuccessMessage(device, txPhy, rxPhy));
            } else {
                mTaskHandler.sendProcessingMessage(ReadPhyPeripheralTask.createReadPhyErrorMessage(device, status));
            }
        }
    }

    /**
     * @return {@link BLEServerCallback} instance
     */
    @NonNull
    public synchronized BLEServerCallback getBLEServerCallback() {
        if (mBLEServerCallbackDistributor == null) {
            mBLEServerCallbackDistributor = new BLEServerCallbackDistributor(this);
        }
        return mBLEServerCallbackDistributor;
    }

    /**
     * @return {@link BLEServerCallback} instance
     */
    @Override
    public List<BLEServerCallback> getSubscriberCallbackList() {
        // add device specified task cleaner at last
        LinkedList<BLEServerCallback> list = new LinkedList<>(mAttachedBLEServerCallbackList);
        list.add(new BLEServerCallbackInner());
        return Collections.synchronizedList(list);
    }

    /**
     * @return current {@link BluetoothGattServer} instance
     */
    @Nullable
    public BluetoothGattServer getBluetoothGattServer() {
        return mBluetoothGattServer;
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
     * Create add service task
     *
     * @param bluetoothGattService task target {@link BluetoothGattService} instance
     * @param timeout              timeout(millis)
     * @param argument             callback argument
     * @param bleServerCallback    {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @Nullable
    public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService
            , long timeout
            , @Nullable Bundle argument
            , @Nullable BLEServerCallback bleServerCallback) {
        Integer taskId = null;
        if (mBluetoothGattServer != null) {
            AddServiceTask task = new AddServiceTask(this
                    , mTaskHandler
                    , bluetoothGattService
                    , timeout
                    , BLEServerCallbackDistributor.wrapArgument(argument, bleServerCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * Create remove service task
     *
     * @param bluetoothGattService task target {@link BluetoothGattService} instance
     * @param timeout              timeout(millis)
     * @param argument             callback argument
     * @param bleServerCallback    {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @Nullable
    public synchronized Integer createRemoveServiceTask(@NonNull BluetoothGattService bluetoothGattService
            , long timeout
            , @Nullable Bundle argument
            , @Nullable BLEServerCallback bleServerCallback) {
        Integer taskId = null;
        if (mBluetoothGattServer != null) {
            RemoveServiceTask task = new RemoveServiceTask(this
                    , mTaskHandler
                    , bluetoothGattService
                    , timeout
                    , BLEServerCallbackDistributor.wrapArgument(argument, bleServerCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * Create Notification / Indication task
     *
     * @param device                   task target {@link BluetoothDevice} instance
     * @param serviceUUID              task target service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       task target characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param byteArrayInterface       task target data class
     * @param isConfirm                {@code true}:indication, {@code false}:notification
     * @param timeout                  timeout(millis)
     * @param delay                    delay(millis)
     * @param argument                 callback argument
     * @param bleServerCallback        {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @Nullable
    public synchronized Integer createNotifyTask(@NonNull BluetoothDevice device
            , @NonNull UUID serviceUUID
            , int serviceInstanceId
            , @NonNull UUID characteristicUUID
            , int characteristicInstanceId
            , @NonNull ByteArrayInterface byteArrayInterface
            , boolean isConfirm
            , long timeout
            , long delay
            , @Nullable Bundle argument
            , @Nullable BLEServerCallback bleServerCallback) {
        Integer taskId = null;
        if (mBluetoothGattServer != null) {
            NotifyTask task = new NotifyTask(this
                    , mBluetoothGattServer
                    , device
                    , mTaskHandler
                    , serviceUUID
                    , serviceInstanceId
                    , characteristicUUID
                    , characteristicInstanceId
                    , byteArrayInterface.getBytes()
                    , isConfirm
                    , timeout
                    , BLEServerCallbackDistributor.wrapArgument(argument, bleServerCallback));
            mTaskHandler.addTaskDelayed(task, delay);
            taskId = task.getTaskId();
            addTaskId(device, taskId);
        }
        return taskId;
    }

    /**
     * add device specified task id
     *
     * @param device target device
     * @param taskId task id
     */
    private synchronized void addTaskId(@NonNull BluetoothDevice device, @NonNull Integer taskId) {
        Set<Integer> taskIdSet = mDeviceSpecifiedTaskIdMap.get(device.getAddress());
        if (taskIdSet == null) {
            taskIdSet = new HashSet<>();
            mDeviceSpecifiedTaskIdMap.put(device.getAddress(), taskIdSet);
        }
        taskIdSet.add(taskId);
    }

    /**
     * remove device specified task id
     *
     * @param device target device
     * @param taskId task id
     */
    private synchronized void removeTaskId(@NonNull BluetoothDevice device, @NonNull Integer taskId) {
        Set<Integer> taskSet = mDeviceSpecifiedTaskIdMap.get(device.getAddress());
        if (taskSet != null) {
            taskSet.remove(taskId);
        }
    }

    /**
     * Create read phy task
     *
     * @param device            target device
     * @param timeout           timeout(millis)
     * @param argument          callback argument
     * @param bleServerCallback {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    public synchronized Integer createReadPhyTask(@NonNull BluetoothDevice device
            , long timeout
            , @Nullable Bundle argument
            , @Nullable BLEServerCallback bleServerCallback) {
        Integer taskId = null;
        if (mBluetoothGattServer != null) {
            ReadPhyPeripheralTask task = new ReadPhyPeripheralTask(this
                    , mBluetoothGattServer
                    , device
                    , mTaskHandler
                    , timeout
                    , BLEServerCallbackDistributor.wrapArgument(argument, bleServerCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
            addTaskId(device, taskId);
        }
        return taskId;
    }

    /**
     * Create set preferred phy task
     *
     * @param device            target device
     * @param txPhy             new txPhy for {@link BluetoothGattServer#setPreferredPhy(BluetoothDevice, int, int, int)}} 2nd argument
     * @param rxPhy             new rxPhy for {@link BluetoothGattServer#setPreferredPhy(BluetoothDevice, int, int, int)}} 3rd argument
     * @param phyOptions        new phyOptions for {@link BluetoothGattServer#setPreferredPhy(BluetoothDevice, int, int, int)}} 4th argument
     * @param timeout           timeout(millis)
     * @param argument          callback argument
     * @param bleServerCallback {@code null}:task result is communicated to all attached callbacks, {@code non-null}:the task result is communicated to the specified callback
     * @return task id. if {@code null} returned, task was not registered
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    public synchronized Integer createSetPreferredPhyTask(@NonNull BluetoothDevice device
            , int txPhy
            , int rxPhy
            , int phyOptions
            , long timeout
            , @Nullable Bundle argument
            , @Nullable BLEServerCallback bleServerCallback) {
        Integer taskId = null;
        if (mBluetoothGattServer != null) {
            SetPreferredPhyPeripheralTask task = new SetPreferredPhyPeripheralTask(this
                    , mBluetoothGattServer
                    , device
                    , mTaskHandler
                    , txPhy
                    , rxPhy
                    , phyOptions
                    , timeout
                    , BLEServerCallbackDistributor.wrapArgument(argument, bleServerCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
            addTaskId(device, taskId);
        }
        return taskId;
    }

    /**
     * @see #startAdvertising(boolean, UUID)
     */
    public synchronized boolean startAdvertising() {
        return startAdvertising(false, null);
    }

    /**
     * @see #startAdvertising(boolean, boolean, UUID)
     */
    public synchronized boolean startAdvertising(boolean includeDeviceName, @Nullable UUID serviceUUID) {
        return startAdvertising(includeDeviceName, true, serviceUUID);
    }

    /**
     * start advertising
     *
     * @param includeDeviceName flag for {@link android.bluetooth.le.AdvertiseData.Builder#setIncludeDeviceName(boolean)}
     * @param includeUUID       flag for {@link android.bluetooth.le.AdvertiseData.Builder#addServiceUuid(ParcelUuid)}
     * @param serviceUUID       UUID for {@link android.bluetooth.le.AdvertiseData.Builder#addServiceUuid(ParcelUuid)}
     * @return {@code true}:advertising started, {@code false}:advertising not started(already started)
     */
    @SuppressLint("MissingPermission")
    public synchronized boolean startAdvertising(boolean includeDeviceName, boolean includeUUID, @Nullable UUID serviceUUID) {
        boolean result = false;
        if (mBluetoothLeAdvertiser == null) {
            if (mBluetoothAdapter != null) {
                mBluetoothLeAdvertiser = mBluetoothAdapter.getBluetoothLeAdvertiser();
                if (mBluetoothLeAdvertiser != null) {
                    AdvertiseSettings.Builder asBuilder = new AdvertiseSettings.Builder();
                    asBuilder.setConnectable(true);
                    asBuilder.setAdvertiseMode(ADVERTISE_MODE_LOW_LATENCY);
                    asBuilder.setTxPowerLevel(ADVERTISE_TX_POWER_HIGH);
                    asBuilder.setTimeout(0);
                    AdvertiseData.Builder adBuilder = new AdvertiseData.Builder();
                    adBuilder.setIncludeDeviceName(includeDeviceName);
                    if (includeUUID) {
                        adBuilder.addServiceUuid(new ParcelUuid(serviceUUID == null ? MOCK_CONTROL_SERVICE_UUID : serviceUUID));
                    }

                    mAdvertiseCallback = new AdvertiseCallback() {

                        /**
                         * {@inheritDoc}
                         */
                        @Override
                        public void onStartSuccess(AdvertiseSettings settingsInEffect) {
                            mBLEServerCallbackDistributor.onAdvertisingStartSuccess(settingsInEffect);
                        }

                        /**
                         * {@inheritDoc}
                         */
                        @Override
                        public void onStartFailure(int errorCode) {
                            synchronized (BLEServerConnection.this) {
                                mAdvertiseCallback = null;
                                mBLEServerCallbackDistributor.onAdvertisingStartFailed(errorCode);
                            }
                        }

                    };

                    mBluetoothLeAdvertiser.startAdvertising(asBuilder.build(), adBuilder.build(), mAdvertiseCallback);
                    result = true;
                }
            }
        }

        if (!result) {
            mBLEServerCallbackDistributor.onAdvertisingStartFailed(null);
        }

        return result;
    }

    /**
     * Advertising stop
     *
     * @return {@code true}:advertising stopped, {@code false}:advertising not stopped(already stopped)
     */
    @SuppressLint("MissingPermission")
    public synchronized boolean stopAdvertising() {
        boolean result = false;
        if (mAdvertiseCallback != null) {
            if (mBluetoothAdapter != null && mBluetoothAdapter.isEnabled()) {
                mBluetoothLeAdvertiser.stopAdvertising(mAdvertiseCallback);
            }
            mAdvertiseCallback = null;
            mBluetoothLeAdvertiser = null;
            mBLEServerCallbackDistributor.onAdvertisingFinished();
            result = true;
        }
        return result;
    }

}
