package org.im97mori.ble;

import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_FAILED;
import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_SUCCESS;
import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_TIMEOUT;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.task.AbortReliableWriteTask;
import org.im97mori.ble.task.AbstractBLETask;
import org.im97mori.ble.task.BeginReliableWriteTask;
import org.im97mori.ble.task.ConnectTask;
import org.im97mori.ble.task.DisconnectTask;
import org.im97mori.ble.task.DiscoverServiceTask;
import org.im97mori.ble.task.ExecuteReliableWriteTask;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.ReadPhyTask;
import org.im97mori.ble.task.ReadRemoteRssiTask;
import org.im97mori.ble.task.RequestMtuTask;
import org.im97mori.ble.task.SetNotificationTask;
import org.im97mori.ble.task.SetPreferredPhyTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * BLE connection(central role)
 * <p>
 * Synchronous
 */
@SuppressWarnings({"WeakerAccess"})
public class BLESyncConnection implements BLECallback {

    /**
     * all lock id greater than this number
     */
    private static final long NOT_AVAILABLE_LOCK_ID = 0;

    /**
     * unique lock id generator
     */
    protected static final AtomicLong LOCK_ID_GENERATOR = new AtomicLong(NOT_AVAILABLE_LOCK_ID);

    /**
     * BLE result class
     *
     * @see #onBLEConnected(Integer, BluetoothDevice, Bundle)
     * @see #onBLEConnectFailed(Integer, BluetoothDevice, int, Bundle)
     * @see #onBLEConnectTimeout(Integer, BluetoothDevice, Bundle)
     * @see #onBLEDisconnected(Integer, BluetoothDevice, int, Bundle)
     * @see #onCharacteristicReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, byte[], Bundle)
     * @see #onCharacteristicReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see #onCharacteristicReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     * @see #onCharacteristicWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, byte[], Bundle)
     * @see #onCharacteristicWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see #onCharacteristicWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     * @see #onDescriptorReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UUID, Integer, byte[], Bundle)
     * @see #onDescriptorReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UUID, Integer, int, Bundle)
     * @see #onDescriptorReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UUID, Integer, long, Bundle)
     * @see #onDescriptorWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UUID, Integer, byte[], Bundle)
     * @see #onDescriptorWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UUID, Integer, int, Bundle)
     * @see #onDescriptorWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UUID, Integer, long, Bundle)
     * @see #onRequestMtuSuccess(Integer, BluetoothDevice, int, Bundle)
     * @see #onRequestMtuFailed(Integer, BluetoothDevice, int, Bundle)
     * @see #onRequestMtuTimeout(Integer, BluetoothDevice, long, Bundle)
     * @see #onReadPhySuccess(Integer, BluetoothDevice, int, int, Bundle)
     * @see #onReadPhyFailed(Integer, BluetoothDevice, int, Bundle)
     * @see #onReadPhyTimeout(Integer, BluetoothDevice, long, Bundle)
     * @see #onSetPreferredPhySuccess(Integer, BluetoothDevice, int, int, int, Bundle)
     * @see #onSetPreferredPhyFailed(Integer, BluetoothDevice, int, Bundle)
     * @see #onSetPreferredPhyTimeout(Integer, BluetoothDevice, long, Bundle)
     * @see #onReadRemoteRssiSuccess(Integer, BluetoothDevice, int, Bundle)
     * @see #onReadRemoteRssiFailed(Integer, BluetoothDevice, int, Bundle)
     * @see #onReadRemoteRssiTimeout(Integer, BluetoothDevice, long, Bundle)
     */
    public static class BLEResult {

        /**
         * task success
         *
         * @see #onBLEConnected(Integer, BluetoothDevice, Bundle)
         * @see #onBLEDisconnected(Integer, BluetoothDevice, int, Bundle)
         * @see #onCharacteristicReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, byte[], Bundle)
         * @see #onCharacteristicWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, byte[], Bundle)
         * @see #onDescriptorReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UUID, Integer, byte[], Bundle)
         * @see #onDescriptorWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UUID, Integer, byte[], Bundle)
         * @see #onRequestMtuSuccess(Integer, BluetoothDevice, int, Bundle)
         * @see #onReadPhySuccess(Integer, BluetoothDevice, int, int, Bundle)
         * @see #onSetPreferredPhySuccess(Integer, BluetoothDevice, int, int, int, Bundle)
         * @see #onReadRemoteRssiSuccess(Integer, BluetoothDevice, int, Bundle)
         */
        public static final int RESULT_SUCCESS = 0;

        /**
         * task failed
         *
         * @see #onBLEConnectFailed(Integer, BluetoothDevice, int, Bundle)
         * @see #onCharacteristicReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
         * @see #onCharacteristicWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
         * @see #onDescriptorReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UUID, Integer, int, Bundle)
         * @see #onDescriptorWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UUID, Integer, int, Bundle)
         * @see #onRequestMtuFailed(Integer, BluetoothDevice, int, Bundle)
         * @see #onReadPhyFailed(Integer, BluetoothDevice, int, Bundle)
         * @see #onSetPreferredPhyFailed(Integer, BluetoothDevice, int, Bundle)
         * @see #onReadRemoteRssiFailed(Integer, BluetoothDevice, int, Bundle)
         */
        public static final int RESULT_FAILED = 1;

        /**
         * task timeout
         *
         * @see #onBLEConnectTimeout(Integer, BluetoothDevice, Bundle)
         * @see #onCharacteristicReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
         * @see #onCharacteristicWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
         * @see #onDescriptorReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UUID, Integer, long, Bundle)
         * @see #onDescriptorWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UUID, Integer, long, Bundle)
         * @see #onRequestMtuTimeout(Integer, BluetoothDevice, long, Bundle)
         * @see #onReadPhyTimeout(Integer, BluetoothDevice, long, Bundle)
         * @see #onSetPreferredPhyTimeout(Integer, BluetoothDevice, long, Bundle)
         * @see #onReadRemoteRssiTimeout(Integer, BluetoothDevice, long, Bundle)
         */
        public static final int RESULT_TIMEOUT = 2;

        /**
         * task id
         */
        private final Integer mTaskId;

        /**
         * one of {@link #RESULT_SUCCESS}, {@link #RESULT_FAILED}, {@link #RESULT_TIMEOUT}
         */
        private final int mResultCode;

        /**
         * service list from {@link BluetoothGatt#getServices()}
         */
        private final List<BluetoothGattService> mServiceList;

        /**
         * task target service {@link UUID}
         */
        private final UUID mServiceUUID;

        /**
         * task target service instance id {@link BluetoothGattService#getInstanceId()}
         */
        private final Integer mServiceInstanceId;

        /**
         * task target characteristic {@link UUID}
         */
        private final UUID mCharacteristicUUID;

        /**
         * task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
         */
        private final Integer mCharacteristicInstanceId;

        /**
         * task target descriptor {@link UUID}
         */
        private final UUID mDescriptorUUID;

        /**
         * task target descriptor instance id
         */
        private final Integer mDescriptorInstanceId;

        /**
         * new mtu from {@link BLEConnection#onMtuChanged(BluetoothGatt, int, int)} 2nd argument
         */
        private final int mMtu;

        /**
         * {@link android.bluetooth.BluetoothGattCallback#onPhyRead(BluetoothGatt, int, int, int)} 2nd argument or {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 2nd argument
         */
        private final int mTxPhy;

        /**
         * {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 4th argument
         */
        private final int mPhyOptions;

        /**
         * {@link android.bluetooth.BluetoothGattCallback#onPhyRead(BluetoothGatt, int, int, int)} 3rd argument or {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 3rd argument
         */
        private final int mRxPhy;

        /**
         * {@link android.bluetooth.BluetoothGattCallback#onReadRemoteRssi(BluetoothGatt, int, int)} 2nd parameter
         */
        private final int mRssi;

        /**
         * new notification status {@link BluetoothGatt#setCharacteristicNotification(BluetoothGattCharacteristic, boolean)} 2nd parameter
         */
        private final boolean mNotificationStatus;

        /**
         * error status
         *
         * @see #onBLEConnectFailed(Integer, BluetoothDevice, int, Bundle)
         * @see #onDiscoverServiceFailed(Integer, BluetoothDevice, int, Bundle)
         * @see #onCharacteristicReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
         * @see #onCharacteristicWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
         * @see #onDescriptorReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UUID, Integer, int, Bundle)
         * @see #onDescriptorWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UUID, Integer, int, Bundle)
         * @see #onRequestMtuFailed(Integer, BluetoothDevice, int, Bundle)
         * @see #onReadPhyFailed(Integer, BluetoothDevice, int, Bundle)
         * @see #onSetPreferredPhyFailed(Integer, BluetoothDevice, int, Bundle)
         * @see #onReadRemoteRssiFailed(Integer, BluetoothDevice, int, Bundle)
         */
        private final int mStatus;

        /**
         * response data
         *
         * @see #onCharacteristicReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, byte[], Bundle)
         * @see #onDescriptorReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UUID, Integer, byte[], Bundle)
         */
        private final byte[] mValues;

        /**
         * callback argument
         */
        private final Bundle mArgument;

        /**
         * @param taskId                   task id
         * @param resultCode               one of {@link #RESULT_SUCCESS}, {@link #RESULT_FAILED}, {@link #RESULT_TIMEOUT}
         * @param serviceList              service list from {@link BluetoothGatt#getServices()}
         * @param serviceUUID              task target service {@link UUID}
         * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
         * @param characteristicUUID       task target characteristic {@link UUID}
         * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
         * @param descriptorUUID           task target descriptor {@link UUID}
         * @param descriptorInstanceId     task target descriptor instance id
         * @param mtu                      new mtu from {@link BLEConnection#onMtuChanged(BluetoothGatt, int, int)} 2nd argument
         * @param txPhy                    {@link android.bluetooth.BluetoothGattCallback#onPhyRead(BluetoothGatt, int, int, int)} 2nd argument or {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 2nd argument
         * @param rxPhy                    {@link android.bluetooth.BluetoothGattCallback#onPhyRead(BluetoothGatt, int, int, int)} 3rd argument or {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 3rd argument
         * @param phyOptions               {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 4th argument
         * @param rssi                     {@link android.bluetooth.BluetoothGattCallback#onReadRemoteRssi(BluetoothGatt, int, int)} 2nd parameter
         * @param notificationStatus       new notification status {@link BluetoothGatt#setCharacteristicNotification(BluetoothGattCharacteristic, boolean)} 2nd parameter
         * @param status                   error status
         * @param values                   response data
         * @param argument                 callback argument
         */
        private BLEResult(@Nullable Integer taskId
                , int resultCode
                , @Nullable List<BluetoothGattService> serviceList
                , @Nullable UUID serviceUUID
                , @Nullable Integer serviceInstanceId
                , @Nullable UUID characteristicUUID
                , @Nullable Integer characteristicInstanceId
                , @Nullable UUID descriptorUUID
                , @Nullable Integer descriptorInstanceId
                , int mtu
                , int txPhy
                , int rxPhy
                , int phyOptions
                , int rssi
                , boolean notificationStatus
                , int status
                , @Nullable byte[] values
                , @Nullable Bundle argument) {
            mTaskId = taskId;
            mResultCode = resultCode;
            mServiceList = serviceList;
            mServiceUUID = serviceUUID;
            mServiceInstanceId = serviceInstanceId;
            mCharacteristicUUID = characteristicUUID;
            mCharacteristicInstanceId = characteristicInstanceId;
            mDescriptorUUID = descriptorUUID;
            mDescriptorInstanceId = descriptorInstanceId;
            mMtu = mtu;
            mTxPhy = txPhy;
            mRxPhy = rxPhy;
            mPhyOptions = phyOptions;
            mRssi = rssi;
            mNotificationStatus = notificationStatus;
            mStatus = status;
            mValues = values;
            mArgument = argument;
        }

        /**
         * @return task id
         */
        @Nullable
        public Integer getTaskId() {
            return mTaskId;
        }

        /**
         * @return one of {@link #RESULT_SUCCESS}, {@link #RESULT_FAILED}, {@link #RESULT_TIMEOUT}
         */
        public int getResultCode() {
            return mResultCode;
        }

        /**
         * @return service list from {@link BluetoothGatt#getServices()}
         */
        @Nullable
        public List<BluetoothGattService> getServiceList() {
            return mServiceList;
        }

        /**
         * @return task target service {@link UUID}
         */
        @Nullable
        public UUID getServiceUUID() {
            return mServiceUUID;
        }

        /**
         * @return task target service instance id {@link BluetoothGattService#getInstanceId()}
         */
        @Nullable
        public Integer getServiceInstanceId() {
            return mServiceInstanceId;
        }

        /**
         * @return task target characteristic {@link UUID}
         */
        @Nullable
        public UUID getCharacteristicUUID() {
            return mCharacteristicUUID;
        }

        /**
         * @return task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
         */
        @Nullable
        public Integer getCharacteristicInstanceId() {
            return mCharacteristicInstanceId;
        }

        /**
         * @return task target descriptor {@link UUID}
         */
        @Nullable
        public UUID getDescriptorUUID() {
            return mDescriptorUUID;
        }

        /**
         * @return task target descriptor instance id
         */
        @Nullable
        public Integer getDescriptorInstanceId() {
            return mDescriptorInstanceId;
        }

        /**
         * @return new mtu from {@link BLEConnection#onMtuChanged(BluetoothGatt, int, int)} 2nd argument
         */
        public int getMtu() {
            return mMtu;
        }

        /**
         * {@link android.bluetooth.BluetoothGattCallback#onPhyRead(BluetoothGatt, int, int, int)} 2nd argument or {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 2nd argument
         */
        public int getTxPhy() {
            return mTxPhy;
        }

        /**
         * {@link android.bluetooth.BluetoothGattCallback#onPhyRead(BluetoothGatt, int, int, int)} 3rd argument or {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 3rd argument
         */
        public int getRxPhy() {
            return mRxPhy;
        }

        /**
         * {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 4th argument
         */
        public int getPhyOptions() {
            return mPhyOptions;
        }

        /**
         * @return {@link android.bluetooth.BluetoothGattCallback#onReadRemoteRssi(BluetoothGatt, int, int)} 2nd parameter
         */
        public int getRssi() {
            return mRssi;
        }

        /**
         * new notification status {@link BluetoothGatt#setCharacteristicNotification(BluetoothGattCharacteristic, boolean)} 2nd parameter
         */
        public boolean getNotificationStatus() {
            return mNotificationStatus;
        }

        /**
         * @return error status
         */
        public int getStatus() {
            return mStatus;
        }

        /**
         * @return response data
         */
        @Nullable
        public byte[] getValues() {
            return mValues;
        }

        /**
         * @return callback argument
         */
        @Nullable
        public Bundle getArgument() {
            return mArgument;
        }

    }

    /**
     * KEY:WRAPPED
     */
    protected static final String KEY_WRAPPED = "KEY_WRAPPED";

    /**
     * KEY:RESULT
     */
    protected static final String KEY_RESULT = "KEY_RESULT";

    /**
     * {@link Context} instance
     */
    protected final Context mContext;

    /**
     * BLE device
     */
    protected final BluetoothDevice mBluetoothDevice;

    /**
     * map for waiting result lock
     */
    protected final Map<Long, CountDownLatch> mLockMap = Collections.synchronizedMap(new LinkedHashMap<>());

    /**
     * map for result
     */
    protected final Map<Long, BLEResult> mResultMap = Collections.synchronizedMap(new LinkedHashMap<>());

    /**
     * notification(indication) listener map
     */
    protected final Map<Pair<Pair<UUID, Integer>, Pair<UUID, Integer>>, List<List<byte[]>>> mNotificationListenerMap = new LinkedHashMap<>();

    /**
     * {@link BLEConnection} instance
     */
    protected BLEConnection mBLEConnection;

    /**
     * @param context         {@link Context} instance
     * @param bluetoothDevice BLE device
     */
    public BLESyncConnection(@NonNull Context context
            , @NonNull BluetoothDevice bluetoothDevice) {
        this(context, bluetoothDevice, null);
    }

    /**
     * @param context         {@link Context} instance
     * @param bluetoothDevice BLE device
     * @param bleConnection {@link BLEConnection} instance
     */
    public BLESyncConnection(@NonNull Context context
            , @NonNull BluetoothDevice bluetoothDevice
            , @Nullable BLEConnection bleConnection) {
        mContext = context;
        mBluetoothDevice = bluetoothDevice;
        mBLEConnection = bleConnection;
    }

    /**
     * for instant synchronous communication
     *
     * @see #createReadCharacteristicTask(BLEConnection, UUID, Integer, UUID, Integer, long, long, Bundle, boolean)
     * @see #createWriteCharacteristicTask(BLEConnection, UUID, Integer, UUID, Integer, ByteArrayInterface, int, long, long, Bundle, boolean)
     * @see #createReadDescriptorTask(BLEConnection, UUID, Integer, UUID, Integer, UUID, Integer, long, long, Bundle, boolean)
     * @see #createWriteDescriptorTask(BLEConnection, UUID, Integer, UUID, Integer, UUID, Integer, ByteArrayInterface, long, long, Bundle, boolean)
     */
    private BLESyncConnection() {
        mContext = null;
        mBluetoothDevice = null;
    }

    /**
     * <p>
     * Connect ble with synchronous
     * <p>
     * if already connected, do not anything
     * </p>
     *
     * @param taskTimeout timeout include waiting time in queue, taskTimeout must greater than bleTimeout
     * @param bleTimeout  ble response timeout(millis)
     * @param argument    callback argument
     * @param isBroadcast {@code true}:task result is communicated to all attached callbacks, {@code false}:the task result is communicated to the specified callback
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    @Nullable
    public synchronized BLEResult connect(long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        if (mBLEConnection == null && mBluetoothDevice != null && mContext != null) {
            mResultMap.clear();

            BLEConnection bleConnection = BLEConnectionHolder.getInstance(mBluetoothDevice);
            if (bleConnection == null) {
                bleConnection = new BLEConnection(mContext, mBluetoothDevice, null);
                BLEConnectionHolder.addInstance(bleConnection, true);
            }
            if (bleConnection.isConnected()) {
                bleResult = new BLEResult(null
                        , RESULT_SUCCESS
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , false
                        , BluetoothGatt.GATT_SUCCESS
                        , null
                        , argument);
            } else {
                Bundle wrappedArgument = wrapArgument(argument, isBroadcast ? null : this);
                ConnectTask task = new ConnectTask(mBLEConnection, mBLEConnection.getTaskHandler(), false, bleTimeout, wrappedArgument);
                bleResult = createTaskSynchronous(bleConnection, task, getKey(wrappedArgument), taskTimeout);
                if (bleResult == null) {
                    bleResult = new BLEResult(task.getTaskId()
                            , RESULT_TIMEOUT
                            , null
                            , null
                            , null
                            , null
                            , null
                            , null
                            , null
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , false
                            , BluetoothGatt.GATT_SUCCESS
                            , null
                            , argument);
                }
                if (bleConnection.isConnected()) {
                    mBLEConnection = bleConnection;
                }
            }
        }
        return bleResult;
    }

    /**
     * create discover service task with synchronous
     *
     * @param taskTimeout timeout include waiting time in queue, taskTimeout must greater than bleTimeout
     * @param bleTimeout  ble response timeout(millis)
     * @param argument    callback argument
     * @param isBroadcast {@code true}:task result is communicated to all attached callbacks, {@code false}:the task result is communicated to the specified callback
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    @Nullable
    public BLEResult createDiscoverServiceTask(long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            Bundle wrappedArgument = wrapArgument(argument, isBroadcast ? null : this);
            DiscoverServiceTask task = new DiscoverServiceTask(bleConnection, bleConnection.getBluetoothGatt(), bleConnection.getTaskHandler(), bleTimeout, wrappedArgument);
            bleResult = createTaskSynchronous(bleConnection, task, getKey(wrappedArgument), taskTimeout);
            if (bleResult == null) {
                bleResult = new BLEResult(task.getTaskId()
                        , RESULT_TIMEOUT
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , false
                        , BluetoothGatt.GATT_SUCCESS
                        , null
                        , argument);
            }
        }
        return bleResult;
    }

    /**
     * instant discover service task
     *
     * @see #createDiscoverServiceTask(long, long, Bundle, boolean)
     */
    @Nullable
    public static BLEResult createDiscoverServiceTask(@NonNull BLEConnection bleConnection
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        if (bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleResult = bleSyncConnection.createDiscoverServiceTask(taskTimeout, bleTimeout, argument, isBroadcast);
        }
        return bleResult;
    }

    /**
     * @see #quit(Bundle, boolean)
     */
    @Nullable
    public BLEResult quit() {
        return quit(null, true);
    }

    /**
     * @see #quit(int, Bundle, boolean)
     */
    @Nullable
    public synchronized BLEResult quit(@Nullable Bundle argument
            , boolean isBroadcast) {
        return quit(DisconnectTask.STATUS_MANUAL_DISCONNECT, null, true);
    }

    /**
     * <p>
     * Disconnect with synchronous
     * <p>
     * if already disconnect, do not anything
     * </p>
     *
     * @param status      {@link android.bluetooth.BluetoothGattCallback#onConnectionStateChange(BluetoothGatt, int, int)} 2nd parameter
     *                    {@link DisconnectTask#STATUS_CANCEL}
     *                    {@link DisconnectTask#STATUS_MANUAL_DISCONNECT}
     * @param argument    callback argument
     * @param isBroadcast {@code true}:task result is communicated to all attached callbacks, {@code false}:the task result is communicated to the specified callback
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    @Nullable
    public synchronized BLEResult quit(int status
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        if (mBLEConnection != null) {
            Bundle wrappedArgument = wrapArgument(argument, isBroadcast ? null : this);
            DisconnectTask task = new DisconnectTask(mBLEConnection, mBLEConnection.getBluetoothGatt(), status, wrappedArgument);
            bleResult = createTaskSynchronous(mBLEConnection, task, getKey(wrappedArgument), ConnectTask.TIMEOUT_MILLIS);
            if (bleResult == null) {
                bleResult = new BLEResult(task.getTaskId()
                        , RESULT_TIMEOUT
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , false
                        , BluetoothGatt.GATT_SUCCESS
                        , null
                        , argument);
            }
            mLockMap.clear();
            mBLEConnection = null;
        }
        return bleResult;
    }

    /**
     * Create read characteristic task with synchronous
     *
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param taskTimeout              timeout include waiting time in queue, taskTimeout must greater equal bleTimeout
     * @param bleTimeout               ble response timeout(millis)
     * @param argument                 callback argument
     * @param isBroadcast              {@code true}:task result is communicated to all attached callbacks, {@code false}:the task result is communicated to the specified callback
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    @Nullable
    public BLEResult createReadCharacteristicTask(@NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            Bundle wrappedArgument = wrapArgument(argument, isBroadcast ? null : this);
            ReadCharacteristicTask task = new ReadCharacteristicTask(bleConnection
                    , bleConnection.getBluetoothGatt()
                    , bleConnection.getTaskHandler()
                    , serviceUUID
                    , serviceInstanceId
                    , characteristicUUID
                    , characteristicInstanceId
                    , bleTimeout
                    , wrappedArgument);
            bleResult = createTaskSynchronous(bleConnection
                    , task
                    , getKey(wrappedArgument)
                    , bleTimeout);
            if (bleResult == null) {
                bleResult = new BLEResult(task.getTaskId()
                        , RESULT_TIMEOUT
                        , null
                        , serviceUUID
                        , serviceInstanceId
                        , characteristicUUID
                        , characteristicInstanceId
                        , null
                        , null
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , false
                        , BluetoothGatt.GATT_SUCCESS
                        , null
                        , argument);
            }
        }
        return bleResult;
    }

    /**
     * instant read characterisitic task
     *
     * @see #createReadCharacteristicTask(UUID, Integer, UUID, Integer, long, long, Bundle, boolean)
     */
    @Nullable
    public static BLEResult createReadCharacteristicTask(@NonNull BLEConnection bleConnection
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        if (bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;

            bleResult = bleSyncConnection.createReadCharacteristicTask(serviceUUID
                    , serviceInstanceId
                    , characteristicUUID
                    , characteristicInstanceId
                    , taskTimeout
                    , bleTimeout
                    , argument
                    , isBroadcast);
        }
        return bleResult;
    }

    /**
     * Create write characteristic task with synchronous
     *
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param byteArrayInterface       write data
     * @param writeType                one of {@link BluetoothGattCharacteristic#WRITE_TYPE_DEFAULT}, {@link BluetoothGattCharacteristic#WRITE_TYPE_NO_RESPONSE}, {@link BluetoothGattCharacteristic#WRITE_TYPE_SIGNED}
     * @param taskTimeout              timeout include waiting time in queue, taskTimeout must greater equal bleTimeout
     * @param bleTimeout               ble response timeout(millis)
     * @param argument                 callback argument
     * @param isBroadcast              {@code true}:task result is communicated to all attached callbacks, {@code false}:the task result is communicated to the specified callback
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    @Nullable
    public BLEResult createWriteCharacteristicTask(@NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull ByteArrayInterface byteArrayInterface
            , int writeType
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            Bundle wrappedArgument = wrapArgument(argument, isBroadcast ? null : this);
            WriteCharacteristicTask task = new WriteCharacteristicTask(bleConnection
                    , bleConnection.getBluetoothGatt()
                    , bleConnection.getTaskHandler()
                    , serviceUUID
                    , serviceInstanceId
                    , characteristicUUID
                    , characteristicInstanceId
                    , byteArrayInterface.getBytes()
                    , writeType
                    , bleTimeout
                    , wrappedArgument);
            bleResult = createTaskSynchronous(mBLEConnection, task, getKey(wrappedArgument), taskTimeout);
            if (bleResult == null) {
                bleResult = new BLEResult(task.getTaskId()
                        , RESULT_TIMEOUT
                        , null
                        , serviceUUID
                        , serviceInstanceId
                        , characteristicUUID
                        , characteristicInstanceId
                        , null
                        , null
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , false
                        , BluetoothGatt.GATT_SUCCESS
                        , byteArrayInterface.getBytes()
                        , argument);
            }
        }
        return bleResult;
    }

    /**
     * instant write characteristic task
     *
     * @see #createWriteCharacteristicTask(UUID, Integer, UUID, Integer, ByteArrayInterface, int, long, long, Bundle, boolean)
     */
    @Nullable
    public static BLEResult createWriteCharacteristicTask(@NonNull BLEConnection bleConnection
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull ByteArrayInterface byteArrayInterface
            , int writeType
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        if (bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleResult = bleSyncConnection.createWriteCharacteristicTask(serviceUUID
                    , serviceInstanceId
                    , characteristicUUID
                    , characteristicInstanceId
                    , byteArrayInterface
                    , writeType
                    , taskTimeout
                    , bleTimeout
                    , argument
                    , isBroadcast);
        }
        return bleResult;
    }

    /**
     * Create read descriptor task with synchronous
     *
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           descriptor {@link UUID}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param taskTimeout              timeout include waiting time in queue, taskTimeout must greater equal bleTimeout
     * @param bleTimeout               ble response timeout(millis)
     * @param argument                 callback argument
     * @param isBroadcast              {@code true}:task result is communicated to all attached callbacks, {@code false}:the task result is communicated to the specified callback
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    @Nullable
    public BLEResult createReadDescriptorTask(@NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull UUID descriptorUUID
            , @Nullable Integer descriptorInstanceId
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            Bundle wrappedArgument = wrapArgument(argument, isBroadcast ? null : this);
            ReadDescriptorTask task = new ReadDescriptorTask(bleConnection
                    , bleConnection.getBluetoothGatt()
                    , bleConnection.getTaskHandler()
                    , serviceUUID
                    , serviceInstanceId
                    , characteristicUUID
                    , characteristicInstanceId
                    , descriptorUUID
                    , descriptorInstanceId
                    , bleTimeout
                    , wrappedArgument);
            bleResult = createTaskSynchronous(mBLEConnection, task, getKey(wrappedArgument), taskTimeout);
            if (bleResult == null) {
                bleResult = new BLEResult(task.getTaskId()
                        , RESULT_TIMEOUT
                        , null
                        , serviceUUID
                        , serviceInstanceId
                        , characteristicUUID
                        , characteristicInstanceId
                        , null
                        , null
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , false
                        , BluetoothGatt.GATT_SUCCESS
                        , null
                        , argument);
            }
        }
        return bleResult;
    }

    /**
     * instant read descriptor task
     *
     * @see #createReadDescriptorTask(UUID, Integer, UUID, Integer, UUID, Integer, long, long, Bundle, boolean)
     */
    @Nullable
    public static BLEResult createReadDescriptorTask(@NonNull BLEConnection bleConnection
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull UUID descriptorUUID
            , @Nullable Integer descriptorInstanceId
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        if (bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleResult = bleSyncConnection.createReadDescriptorTask(serviceUUID
                    , serviceInstanceId
                    , characteristicUUID
                    , characteristicInstanceId
                    , descriptorUUID
                    , descriptorInstanceId
                    , taskTimeout
                    , bleTimeout
                    , argument
                    , isBroadcast);
        }
        return bleResult;
    }

    /**
     * Create write descriptor task with synchronous
     *
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           descriptor {@link UUID}
     * @param descriptorInstanceId     task target descriptor instance id
     * @param byteArrayInterface       write data
     * @param taskTimeout              timeout include waiting time in queue, taskTimeout must greater equal bleTimeout
     * @param bleTimeout               ble response timeout(millis)
     * @param argument                 callback argument
     * @param isBroadcast              {@code true}:task result is communicated to all attached callbacks, {@code false}:the task result is communicated to the specified callback
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    @Nullable
    public BLEResult createWriteDescriptorTask(@NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull UUID descriptorUUID
            , @Nullable Integer descriptorInstanceId
            , @NonNull ByteArrayInterface byteArrayInterface
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            Bundle wrappedArgument = wrapArgument(argument, isBroadcast ? null : this);
            WriteDescriptorTask task = new WriteDescriptorTask(bleConnection
                    , bleConnection.getBluetoothGatt()
                    , bleConnection.getTaskHandler()
                    , serviceUUID
                    , serviceInstanceId
                    , characteristicUUID
                    , characteristicInstanceId
                    , descriptorUUID
                    , descriptorInstanceId
                    , byteArrayInterface.getBytes()
                    , bleTimeout
                    , wrappedArgument);
            bleResult = createTaskSynchronous(mBLEConnection, task, getKey(wrappedArgument), taskTimeout);
            if (bleResult == null) {
                bleResult = new BLEResult(task.getTaskId()
                        , RESULT_TIMEOUT
                        , null
                        , serviceUUID
                        , serviceInstanceId
                        , characteristicUUID
                        , characteristicInstanceId
                        , null
                        , null
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , false
                        , BluetoothGatt.GATT_SUCCESS
                        , byteArrayInterface.getBytes()
                        , argument);
            }
        }
        return bleResult;
    }

    /**
     * instant write descriptor task
     *
     * @see #createWriteDescriptorTask(UUID, Integer, UUID, Integer, UUID, Integer, ByteArrayInterface, long, long, Bundle, boolean)
     */
    @Nullable
    public static BLEResult createWriteDescriptorTask(@NonNull BLEConnection bleConnection
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull UUID descriptorUUID
            , @Nullable Integer descriptorInstanceId
            , @NonNull ByteArrayInterface byteArrayInterface
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        if (bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleResult = bleSyncConnection.createWriteDescriptorTask(serviceUUID
                    , serviceInstanceId
                    , characteristicUUID
                    , characteristicInstanceId
                    , descriptorUUID
                    , descriptorInstanceId
                    , byteArrayInterface
                    , taskTimeout
                    , bleTimeout
                    , argument
                    , isBroadcast);
        }
        return bleResult;
    }

    /**
     * Create read phy task with synchronous
     *
     * @param taskTimeout include waiting time in queue, taskTimeout must greater equal bleTimeout
     * @param bleTimeout  ble response timeout(millis)
     * @param argument    callback argument
     * @param isBroadcast {@code true}:task result is communicated to all attached callbacks, {@code false}:the task result is communicated to the specified callback
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    public BLEResult createReadPhyTask(long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            Bundle wrappedArgument = wrapArgument(argument, isBroadcast ? null : this);
            ReadPhyTask task = new ReadPhyTask(bleConnection
                    , bleConnection.getBluetoothGatt()
                    , bleConnection.getTaskHandler()
                    , bleTimeout
                    , wrappedArgument);
            bleResult = createTaskSynchronous(mBLEConnection, task, getKey(wrappedArgument), taskTimeout);
            if (bleResult == null) {
                bleResult = new BLEResult(task.getTaskId()
                        , RESULT_TIMEOUT
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , false
                        , BluetoothGatt.GATT_SUCCESS
                        , null
                        , argument);
            }
        }
        return bleResult;
    }

    /**
     * instant read phy task
     *
     * @see #createReadPhyTask(long, long, Bundle, boolean)
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    public static BLEResult createReadPhyTask(@NonNull BLEConnection bleConnection
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        if (bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleResult = bleSyncConnection.createReadPhyTask(taskTimeout, bleTimeout, argument, isBroadcast);
        }
        return bleResult;
    }

    /**
     * Create set preferred phy task with synchronous
     *
     * @param txPhy       new txPhy for {@link BluetoothGatt#setPreferredPhy(int, int, int)} 1st argument
     * @param rxPhy       new rxPhy for {@link BluetoothGatt#setPreferredPhy(int, int, int)} 2nd argument
     * @param phyOptions  new phyOptions for {@link BluetoothGatt#setPreferredPhy(int, int, int)} 3rd argument
     * @param taskTimeout include waiting time in queue, taskTimeout must greater equal bleTimeout
     * @param bleTimeout  ble response timeout(millis)
     * @param argument    callback argument
     * @param isBroadcast {@code true}:task result is communicated to all attached callbacks, {@code false}:the task result is communicated to the specified callback
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    public BLEResult createSetPreferredPhyTask(int txPhy
            , int rxPhy
            , int phyOptions
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            Bundle wrappedArgument = wrapArgument(argument, isBroadcast ? null : this);
            SetPreferredPhyTask task = new SetPreferredPhyTask(bleConnection
                    , bleConnection.getBluetoothGatt()
                    , bleConnection.getTaskHandler()
                    , txPhy
                    , rxPhy
                    , phyOptions
                    , bleTimeout
                    , wrappedArgument);
            bleResult = createTaskSynchronous(mBLEConnection, task, getKey(wrappedArgument), taskTimeout);
            if (bleResult == null) {
                bleResult = new BLEResult(task.getTaskId()
                        , RESULT_TIMEOUT
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , 0
                        , txPhy
                        , rxPhy
                        , phyOptions
                        , 0
                        , false
                        , BluetoothGatt.GATT_SUCCESS
                        , null
                        , argument);
            }
        }
        return bleResult;
    }

    /**
     * instant set preferred phy task
     *
     * @see #createSetPreferredPhyTask(int, int, int, long, long, Bundle, boolean)
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    public static BLEResult createSetPreferredPhyTask(@NonNull BLEConnection bleConnection
            , int txPhy
            , int rxPhy
            , int phyOptions
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        if (bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleResult = bleSyncConnection.createSetPreferredPhyTask(txPhy
                    , rxPhy
                    , phyOptions
                    , taskTimeout
                    , bleTimeout
                    , argument
                    , isBroadcast);
        }
        return bleResult;
    }

    /**
     * Listen notification or indication
     *
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param duration           listen duration(millis)
     * @return notification or indication value list
     */
    @NonNull
    public List<byte[]> listen(@NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long duration) {
        List<byte[]> listener = new LinkedList<>();

        try {
            mBLEConnection.attach(this);
            Pair<Pair<UUID, Integer>, Pair<UUID, Integer>> pair = Pair.create(Pair.create(serviceUUID, serviceInstanceId), Pair.create(characteristicUUID, characteristicInstanceId));
            List<List<byte[]>> listenerList;
            synchronized (mNotificationListenerMap) {
                listenerList = mNotificationListenerMap.get(pair);
                if (listenerList == null) {
                    listenerList = new LinkedList<>();
                    mNotificationListenerMap.put(pair, listenerList);
                }
                listenerList.add(listener);
                mNotificationListenerMap.notifyAll();
            }

            long end = SystemClock.elapsedRealtime() + duration;
            do {
                try {
                    //noinspection BusyWait
                    Thread.sleep(end - SystemClock.elapsedRealtime());
                } catch (InterruptedException e) {
                    BLELogUtils.stackLog(e);
                }
            } while (end > SystemClock.elapsedRealtime());

            synchronized (mNotificationListenerMap) {
                listenerList.remove(listener);
                mNotificationListenerMap.notifyAll();
            }
        } finally {
            mBLEConnection.detach(this);
        }
        return listener;
    }

    /**
     * instant listen notification or indication
     *
     * @see #listen(BLEConnection, UUID, Integer, UUID, Integer, long)
     */
    @Nullable
    public static List<byte[]> listen(@NonNull BLEConnection bleConnection
            , @NonNull UUID serviceUUID
            , @NonNull UUID characteristicUUID
            , long duration) {
        return listen(bleConnection, serviceUUID, null, characteristicUUID, null, duration);
    }

    /**
     * instant listen notification or indication
     *
     * @see #listen(UUID, Integer, UUID, Integer, long)
     */
    @Nullable
    public static List<byte[]> listen(@NonNull BLEConnection bleConnection
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long duration) {
        List<byte[]> listener = null;
        if (bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            listener = bleSyncConnection.listen(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, duration);
        }
        return listener;
    }


    /**
     * Create request mtu task with synchronous
     *
     * @param mtu         new mtu for {@link BluetoothGatt#requestMtu(int)} 1st argument
     * @param taskTimeout timeout include waiting time in queue, taskTimeout must greater equal bleTimeout
     * @param bleTimeout  ble response timeout(millis)
     * @param argument    callback argument
     * @param isBroadcast {@code true}:task result is communicated to all attached callbacks, {@code false}:the task result is communicated to the specified callback
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    @Nullable
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BLEResult createRequestMtuTask(int mtu
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            Bundle wrappedArgument = wrapArgument(argument, isBroadcast ? null : this);
            RequestMtuTask task = new RequestMtuTask(bleConnection
                    , bleConnection.getBluetoothGatt()
                    , bleConnection.getTaskHandler()
                    , mtu
                    , bleTimeout
                    , wrappedArgument);
            bleResult = createTaskSynchronous(mBLEConnection, task, getKey(wrappedArgument), taskTimeout);
            if (bleResult == null) {
                bleResult = new BLEResult(task.getTaskId()
                        , RESULT_TIMEOUT
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , mtu
                        , 0
                        , 0
                        , 0
                        , 0
                        , false
                        , BluetoothGatt.GATT_SUCCESS
                        , null
                        , argument);
            }
        }
        return bleResult;
    }

    /**
     * instant request mtu task
     *
     * @see #createRequestMtuTask(int, long, long, Bundle, boolean)
     */
    @Nullable
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static BLEResult createRequestMtuTask(@NonNull BLEConnection bleConnection
            , int mtu
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        if (bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleResult = bleSyncConnection.createRequestMtuTask(mtu, taskTimeout, bleTimeout, argument, isBroadcast);
        }
        return bleResult;
    }

    /**
     * Create read remote rssi task with synchronous
     *
     * @param taskTimeout timeout include waiting time in queue, taskTimeout must greater equal bleTimeout
     * @param bleTimeout  ble response timeout(millis)
     * @param argument    callback argument
     * @param isBroadcast {@code true}:task result is communicated to all attached callbacks, {@code false}:the task result is communicated to the specified callback
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    @Nullable
    public BLEResult createReadRemoteRssiTask(long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            Bundle wrappedArgument = wrapArgument(argument, isBroadcast ? null : this);
            ReadRemoteRssiTask task = new ReadRemoteRssiTask(bleConnection
                    , bleConnection.getBluetoothGatt()
                    , bleConnection.getTaskHandler()
                    , bleTimeout
                    , wrappedArgument);
            bleResult = createTaskSynchronous(mBLEConnection, task, getKey(wrappedArgument), taskTimeout);
            if (bleResult == null) {
                bleResult = new BLEResult(task.getTaskId()
                        , RESULT_TIMEOUT
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , false
                        , BluetoothGatt.GATT_SUCCESS
                        , null
                        , argument);
            }
        }
        return bleResult;
    }

    /**
     * instant read remote rssi task
     *
     * @see #createReadRemoteRssiTask(long, long, Bundle, boolean)
     */
    @Nullable
    public static BLEResult createReadRemoteRssiTask(@NonNull BLEConnection bleConnection
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        if (bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleResult = bleSyncConnection.createReadRemoteRssiTask(taskTimeout, bleTimeout, argument, isBroadcast);
        }
        return bleResult;
    }

    /**
     * Create begin reliable write task with synchronous
     *
     * @param taskTimeout timeout include waiting time in queue, taskTimeout must greater equal bleTimeout
     * @param argument    callback argument
     * @param isBroadcast {@code true}:task result is communicated to all attached callbacks, {@code false}:the task result is communicated to the specified callback
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    @Nullable
    public BLEResult createBeginReliableWriteTask(long taskTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            Bundle wrappedArgument = wrapArgument(argument, isBroadcast ? null : this);
            BeginReliableWriteTask task = new BeginReliableWriteTask(bleConnection
                    , bleConnection.getBluetoothGatt()
                    , wrappedArgument);
            bleResult = createTaskSynchronous(mBLEConnection, task, getKey(wrappedArgument), taskTimeout);
            if (bleResult == null) {
                bleResult = new BLEResult(task.getTaskId()
                        , RESULT_TIMEOUT
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , false
                        , BluetoothGatt.GATT_SUCCESS
                        , null
                        , argument);
            }
        }
        return bleResult;
    }

    /**
     * instant begin reliable write task
     *
     * @see #createBeginReliableWriteTask(long, Bundle, boolean)
     */
    @Nullable
    public static BLEResult createBeginReliableWriteTask(@NonNull BLEConnection bleConnection
            , long taskTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        if (bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleResult = bleSyncConnection.createBeginReliableWriteTask(taskTimeout, argument, isBroadcast);
        }
        return bleResult;
    }

    /**
     * Create execute reliable write task with synchronous
     *
     * @param taskTimeout timeout include waiting time in queue, taskTimeout must greater equal bleTimeout
     * @param bleTimeout  ble response timeout(millis)
     * @param argument    callback argument
     * @param isBroadcast {@code true}:task result is communicated to all attached callbacks, {@code false}:the task result is communicated to the specified callback
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    @Nullable
    public BLEResult createExecuteReliableWriteTask(long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            Bundle wrappedArgument = wrapArgument(argument, isBroadcast ? null : this);
            ExecuteReliableWriteTask task = new ExecuteReliableWriteTask(bleConnection
                    , bleConnection.getBluetoothGatt()
                    , bleConnection.getTaskHandler()
                    , bleTimeout
                    , wrappedArgument);
            bleResult = createTaskSynchronous(mBLEConnection, task, getKey(wrappedArgument), taskTimeout);
            if (bleResult == null) {
                bleResult = new BLEResult(task.getTaskId()
                        , RESULT_TIMEOUT
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , false
                        , BluetoothGatt.GATT_SUCCESS
                        , null
                        , argument);
            }
        }
        return bleResult;
    }

    /**
     * instant execute reliable write task
     *
     * @see #createExecuteReliableWriteTask(long, long, Bundle, boolean)
     */
    @Nullable
    public static BLEResult createExecuteReliableWriteTask(@NonNull BLEConnection bleConnection
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        if (bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleResult = bleSyncConnection.createExecuteReliableWriteTask(taskTimeout, bleTimeout, argument, isBroadcast);
        }
        return bleResult;
    }

    /**
     * Create abort reliable write task with synchronous
     *
     * @param taskTimeout timeout include waiting time in queue, taskTimeout must greater equal bleTimeout
     * @param bleTimeout  ble response timeout(millis)
     * @param argument    callback argument
     * @param isBroadcast {@code true}:task result is communicated to all attached callbacks, {@code false}:the task result is communicated to the specified callback
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    public BLEResult createAbortReliableWriteTask(long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            Bundle wrappedArgument = wrapArgument(argument, isBroadcast ? null : this);
            AbortReliableWriteTask task = new AbortReliableWriteTask(bleConnection
                    , bleConnection.getBluetoothGatt()
                    , bleConnection.getTaskHandler()
                    , bleTimeout
                    , wrappedArgument);
            bleResult = createTaskSynchronous(mBLEConnection, task, getKey(wrappedArgument), taskTimeout);
            if (bleResult == null) {
                bleResult = new BLEResult(task.getTaskId()
                        , RESULT_TIMEOUT
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , false
                        , BluetoothGatt.GATT_SUCCESS
                        , null
                        , argument);
            }
        }
        return bleResult;
    }

    /**
     * instant abort reliable write task
     *
     * @see #createExecuteReliableWriteTask(long, long, Bundle, boolean)
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    public static BLEResult createAbortReliableWriteTask(@NonNull BLEConnection bleConnection
            , long taskTimeout
            , long bleTimeout
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        if (bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleResult = bleSyncConnection.createAbortReliableWriteTask(taskTimeout, bleTimeout, argument, isBroadcast);
        }
        return bleResult;
    }

    /**
     * Create set notification task with synchronous
     *
     * @param taskTimeout     timeout include waiting time in queue, taskTimeout must greater equal bleTimeout
     * @param setNotification {@link BluetoothGatt#setCharacteristicNotification(BluetoothGattCharacteristic, boolean)} 2nd parameter
     * @param argument        callback argument
     * @param isBroadcast     {@code true}:task result is communicated to all attached callbacks, {@code false}:the task result is communicated to the specified callback
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    @Nullable
    public BLEResult createSetNotificationTask(@NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long taskTimeout
            , boolean setNotification
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            Bundle wrappedArgument = wrapArgument(argument, isBroadcast ? null : this);
            SetNotificationTask task = new SetNotificationTask(bleConnection
                    , bleConnection.getBluetoothGatt()
                    , bleConnection.getTaskHandler()
                    , serviceUUID
                    , serviceInstanceId
                    , characteristicUUID
                    , characteristicInstanceId
                    , setNotification
                    , wrappedArgument);
            bleResult = createTaskSynchronous(mBLEConnection, task, getKey(wrappedArgument), taskTimeout);
            if (bleResult == null) {
                bleResult = new BLEResult(task.getTaskId()
                        , RESULT_TIMEOUT
                        , null
                        , serviceUUID
                        , serviceInstanceId
                        , characteristicUUID
                        , characteristicInstanceId
                        , null
                        , null
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , false
                        , BluetoothGatt.GATT_SUCCESS
                        , null
                        , argument);
            }
        }
        return bleResult;
    }

    /**
     * instant set notification task
     *
     * @see #createSetNotificationTask(UUID, Integer, UUID, Integer, long, boolean, Bundle, boolean)
     */
    @Nullable
    public static BLEResult createSetNotificationTask(@NonNull BLEConnection bleConnection
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long taskTimeout
            , boolean setNotification
            , @Nullable Bundle argument
            , boolean isBroadcast) {
        BLEResult bleResult = null;
        if (bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleResult = bleSyncConnection.createSetNotificationTask(serviceUUID
                    , serviceInstanceId
                    , characteristicUUID
                    , characteristicInstanceId
                    , taskTimeout
                    , setNotification
                    , argument
                    , isBroadcast);
        }
        return bleResult;
    }

    /**
     * Create set notification task with synchronous
     *
     * @param taskTimeout     timeout include waiting time in queue, taskTimeout must greater equal bleTimeout
     * @param wrappedArgument wrapped argument, {@link #wrapArgument(Bundle, BLESyncConnection)}
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    @Nullable
    public BLEResult createTask(@NonNull AbstractBLETask task
            , long taskTimeout
            , @NonNull Bundle wrappedArgument) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            bleResult = createTaskSynchronous(mBLEConnection, task, getKey(wrappedArgument), taskTimeout);
            if (bleResult == null) {
                bleResult = new BLEResult(task.getTaskId()
                        , RESULT_TIMEOUT
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , null
                        , 0
                        , 0
                        , 0
                        , 0
                        , 0
                        , false
                        , BluetoothGatt.GATT_SUCCESS
                        , null
                        , wrappedArgument.getBundle(KEY_WRAPPED));
            }
        }
        return bleResult;
    }

    /**
     * instant create task
     *
     * @see #createTask(AbstractBLETask, long, Bundle)
     */
    @SuppressWarnings("unused")
    @Nullable
    public static BLEResult createTask(@NonNull BLEConnection bleConnection
            , @NonNull AbstractBLETask task
            , long taskTimeout
            , @NonNull Bundle wrappedArgument) {
        BLEResult bleResult = null;
        if (bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleResult = bleSyncConnection.createTask(task, taskTimeout, wrappedArgument);
        }
        return bleResult;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBLEConnected(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBLEConnectFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBLEConnectTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBLEDisconnected(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDiscoverServiceSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull List<BluetoothGattService> serviceList
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, serviceList, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDiscoverServiceFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDiscoverServiceTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , long timeout
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onRequestMtuSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , int mtu
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, null, null, null, null, null, null, mtu, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onRequestMtuFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onRequestMtuTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , long timeout
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull byte[] values
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, values, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, null, null, 0, 0, 0, 0, 0, false, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull byte[] values
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, values, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, null, null, 0, 0, 0, 0, 0, false, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull UUID descriptorUUID
            , @NonNull Integer descriptorInstanceId
            , @NonNull byte[] values
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, values, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull UUID descriptorUUID
            , @Nullable Integer descriptorInstanceId
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, null, 0, 0, 0, 0, 0, false, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull UUID descriptorUUID
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull UUID descriptorUUID
            , @NonNull Integer descriptorInstanceId
            , @NonNull byte[] values
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, values, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull UUID descriptorUUID
            , @Nullable Integer descriptorInstanceId, int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, null, 0, 0, 0, 0, 0, false, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull UUID descriptorUUID
            , @Nullable Integer descriptorInstanceId, long timeout
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull byte[] values) {
        synchronized (mNotificationListenerMap) {
            List<List<byte[]>> list = mNotificationListenerMap.get(Pair.create(Pair.create(serviceUUID, serviceInstanceId), Pair.create(characteristicUUID, characteristicInstanceId)));
            if (list != null) {
                for (List<byte[]> listener : list) {
                    listener.add(values);
                }
            }
            list = mNotificationListenerMap.get(Pair.create(Pair.create(serviceUUID, null), Pair.create(characteristicUUID, null)));
            if (list != null) {
                for (List<byte[]> listener : list) {
                    listener.add(values);
                }
            }
            mNotificationListenerMap.notifyAll();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadPhySuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , int txPhy
            , int rxPhy
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, null, null, null, null, null, null, 0, txPhy, rxPhy, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadPhyFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadPhyTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , long timeout
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSetPreferredPhySuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , int txPhy
            , int rxPhy
            , int phyOptions
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, null, null, null, null, null, null, 0, txPhy, rxPhy, phyOptions, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSetPreferredPhyFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSetPreferredPhyTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , long timeout
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadRemoteRssiSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , int rssi
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, null, null, null, null, null, null, 0, 0, 0, 0, rssi, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadRemoteRssiFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadRemoteRssiTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , long timeout
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBeginReliableWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBeginReliableWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onExecuteReliableWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onExecuteReliableWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onExecuteReliableWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , long timeout
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAbortReliableWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAbortReliableWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAbortReliableWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , long timeout
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, false, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSetNotificationSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , boolean notificationStatus
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, null, null, 0, 0, 0, 0, 0, notificationStatus, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSetNotificationFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , boolean notificationStatus
            , int status
            , @SuppressWarnings("NullableProblems") @NonNull Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, null, null, 0, 0, 0, 0, 0, notificationStatus, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * synchronous ble request
     *
     * @param bleConnection {@link BLEConnection} instance
     * @param task          {@link AbstractBLETask} instance
     * @param taskTimeout   timeout include waiting time in queue, ble response(millis), taskTimeout must greater equal bleTimeout
     * @return BLE result
     */
    @SuppressLint("NewApi")
    @Nullable
    protected BLEResult createTaskSynchronous(@NonNull BLEConnection bleConnection
            , @NonNull AbstractBLETask task
            , long key
            , long taskTimeout) {
        long end = taskTimeout + SystemClock.elapsedRealtime();

        // create lock
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mLockMap.put(key, countDownLatch);

        // call async
        BLEResult bleResult;
        try {
            bleConnection.attach(this);
            bleConnection.addTask(task);

            // remove old lock
            Set<Long> resultKeySet = mResultMap.keySet();
            resultKeySet.removeAll(mLockMap.keySet());
            resultKeySet.remove(key);
            for (long oldKey : resultKeySet) {
                mResultMap.remove(oldKey);
            }

            // waiting task result
            boolean awaitResult = false;
            do {
                try {
                    awaitResult = countDownLatch.await(end - SystemClock.elapsedRealtime(), TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    BLELogUtils.stackLog(e);
                }
            } while (!mResultMap.containsKey(key) && !bleConnection.isConnected() && !awaitResult);

            // get task result and remove lock instance
            bleResult = mResultMap.remove(key);
            mLockMap.remove(key);
        } finally {
            bleConnection.detach(this);
        }

        return bleResult;
    }

    /**
     * Wrap original argument
     *
     * @param argument          original argument
     * @param bleSyncConnection {@link BLESyncConnection} instance
     * @return wrapped argument
     */
    @NonNull
    public static Bundle wrapArgument(@Nullable Bundle argument, @Nullable BLESyncConnection bleSyncConnection) {
        long key = LOCK_ID_GENERATOR.incrementAndGet();
        Bundle wrappedArgument = new Bundle();
        wrappedArgument.putBundle(KEY_WRAPPED, argument);
        wrappedArgument.putLong(KEY_RESULT, key);
        return BLECallbackDistributor.wrapArgument(wrappedArgument, bleSyncConnection);
    }

    /**
     * get key from wrappedArgument
     *
     * @param wrappedArgument {@link BLECallbackDistributor#wrapArgument(Bundle, BLECallback)}
     * @return key
     */
    private long getKey(@NonNull Bundle wrappedArgument) {
        long key = 0;
        Bundle unwrappedArgument = wrappedArgument.getBundle(BLECallbackDistributor.KEY_WRAPPED_ARGUMENT);
        if (unwrappedArgument != null) {
            key = unwrappedArgument.getLong(KEY_RESULT);
        }
        return key;
    }

    /**
     * free lock and put result
     *
     * @param argument  {@link #wrapArgument(Bundle, BLESyncConnection)}
     * @param bleResult ble request result
     */
    protected void unlock(@NonNull Bundle argument
            , @NonNull BLEResult bleResult) {
        long key = argument.getLong(KEY_RESULT, 0);
        CountDownLatch countDownLatch = mLockMap.get(key);
        if (countDownLatch != null) {
            mResultMap.put(key, bleResult);
            countDownLatch.countDown();
        }
    }

}
