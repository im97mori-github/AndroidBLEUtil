package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;

import org.im97mori.ble.task.AbstractBLETask;
import org.im97mori.ble.task.ConnectTask;
import org.im97mori.ble.task.DisconnectTask;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
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

import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_FAILED;
import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_SUCCESS;
import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_TIMEOUT;
import static org.im97mori.ble.task.AbstractBLETask.TASK_ID_UNREGISTED;

/**
 * BLE connection(central role)
 * <p>
 * Synchronous
 */
@SuppressWarnings({"JavadocReference", "WeakerAccess"})
public class BLESyncConnection implements BLECallback {

    /**
     * all lock id greater than this number
     */
    private static final long NOT_AVAILABLE_LOCK_ID = 0;

    /**
     * unique lock id generetor
     */
    private static final AtomicLong LOCK_ID_GENERATOR = new AtomicLong(NOT_AVAILABLE_LOCK_ID);

    /**
     * BLE result class
     *
     * @see #onBLEConnected(long, BluetoothDevice, Bundle)
     * @see #onBLEConnectFailed(long, BluetoothDevice, int, Bundle)
     * @see #onBLEConnectTimeout(long, BluetoothDevice, Bundle)
     * @see #onBLEDisonnected(long, BluetoothDevice, int, Bundle)
     * @see #onCharacteristicReadSuccess(long, BluetoothDevice, UUID, UUID, byte[], Bundle)
     * @see #onCharacteristicReadFailed(long, BluetoothDevice, UUID, UUID, int, Bundle)
     * @see #onCharacteristicReadTimeout(long, BluetoothDevice, UUID, UUID, long, Bundle)
     * @see #onCharacteristicWriteSuccess(long, BluetoothDevice, UUID, UUID, byte[], Bundle)
     * @see #onCharacteristicWriteFailed(long, BluetoothDevice, UUID, UUID, int, Bundle)
     * @see #onCharacteristicWriteTimeout(long, BluetoothDevice, UUID, UUID, long, Bundle)
     * @see #onDescriptorReadSuccess(long, BluetoothDevice, UUID, UUID, UUID, byte[], Bundle)
     * @see #onDescriptorReadFailed(long, BluetoothDevice, UUID, UUID, UUID, int, Bundle)
     * @see #onDescriptorReadTimeout(long, BluetoothDevice, UUID, UUID, UUID, long, Bundle)
     * @see #onDescriptorWriteSuccess(long, BluetoothDevice, UUID, UUID, UUID, byte[], Bundle)
     * @see #onDescriptorWriteFailed(long, BluetoothDevice, UUID, UUID, UUID, int, Bundle)
     * @see #onDescriptorWriteTimeout(long, BluetoothDevice, UUID, UUID, UUID, long, Bundle)
     */
    @SuppressWarnings("unused")
    public static class BLEResult {

        /**
         * task success
         *
         * @see #onBLEConnected(long, BluetoothDevice, Bundle)
         * @see #onBLEDisonnected(long, BluetoothDevice, int, Bundle)
         * @see #onCharacteristicReadSuccess(long, BluetoothDevice, UUID, UUID, byte[], Bundle)
         * @see #onCharacteristicWriteSuccess(long, BluetoothDevice, UUID, UUID, byte[], Bundle)
         * @see #onDescriptorReadSuccess(long, BluetoothDevice, UUID, UUID, UUID, byte[], Bundle)
         * @see #onDescriptorWriteSuccess(long, BluetoothDevice, UUID, UUID, UUID, byte[], Bundle)
         */
        public static final int RESULT_SUCCESS = 0;

        /**
         * task failed
         *
         * @see #onBLEConnectFailed(long, BluetoothDevice, int, Bundle)
         * @see #onCharacteristicReadFailed(long, BluetoothDevice, UUID, UUID, int, Bundle)
         * @see #onCharacteristicWriteFailed(long, BluetoothDevice, UUID, UUID, int, Bundle)
         * @see #onDescriptorReadFailed(long, BluetoothDevice, UUID, UUID, UUID, int, Bundle)
         * @see #onDescriptorWriteFailed(long, BluetoothDevice, UUID, UUID, UUID, int, Bundle)
         */
        public static final int RESULT_FAILED = 1;

        /**
         * task timeout
         *
         * @see #onBLEConnectTimeout(long, BluetoothDevice, Bundle)
         * @see #onCharacteristicReadTimeout(long, BluetoothDevice, UUID, UUID, long, Bundle)
         * @see #onCharacteristicWriteTimeout(long, BluetoothDevice, UUID, UUID, long, Bundle)
         * @see #onDescriptorReadTimeout(long, BluetoothDevice, UUID, UUID, UUID, long, Bundle)
         * @see #onDescriptorWriteTimeout(long, BluetoothDevice, UUID, UUID, UUID, long, Bundle)
         */
        public static final int RESULT_TIMEOUT = 2;

        /**
         * task id
         */
        private final long mTaskId;

        /**
         * one of {@link #RESULT_SUCCESS}, {@link #RESULT_FAILED}, {@link #RESULT_TIMEOUT}
         */
        private final int mResultCode;

        /**
         * task target service {@link UUID}
         */
        private final UUID mServiceUUID;

        /**
         * task target characteristic {@link UUID}
         */
        private final UUID mCharacteristicUUID;

        /**
         * task target descriptor {@link UUID}
         */
        private final UUID mDescriptorUUID;

        /**
         * error status
         *
         * @see #onBLEConnectFailed(long, BluetoothDevice, int, Bundle)
         * @see #onCharacteristicReadFailed(long, BluetoothDevice, UUID, UUID, int, Bundle)
         * @see #onCharacteristicWriteFailed(long, BluetoothDevice, UUID, UUID, int, Bundle)
         * @see #onDescriptorReadFailed(long, BluetoothDevice, UUID, UUID, UUID, int, Bundle)
         * @see #onDescriptorWriteFailed(long, BluetoothDevice, UUID, UUID, UUID, int, Bundle)
         */
        private final int mStatus;

        /**
         * response data
         *
         * @see #onCharacteristicReadSuccess(long, BluetoothDevice, UUID, UUID, byte[], Bundle)
         * @see #onDescriptorReadSuccess(long, BluetoothDevice, UUID, UUID, UUID, byte[], Bundle)
         */
        private final byte[] mValues;

        /**
         * callback argument
         */
        private final Bundle mArgument;

        /**
         * @param taskId             task id
         * @param resultCode         one of {@link #RESULT_SUCCESS}, {@link #RESULT_FAILED}, {@link #RESULT_TIMEOUT}
         * @param serviceUUID        task target service {@link UUID}
         * @param characteristicUUID task target characteristic {@link UUID}
         * @param descriptorUUID     task target descriptor {@link UUID}
         * @param status             error status
         * @param values             response data
         * @param argument           callback argument
         */
        private BLEResult(long taskId, int resultCode, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, byte[] values, Bundle argument) {
            mTaskId = taskId;
            mResultCode = resultCode;
            mServiceUUID = serviceUUID;
            mCharacteristicUUID = characteristicUUID;
            mDescriptorUUID = descriptorUUID;
            mStatus = status;
            mValues = values;
            mArgument = argument;
        }

        /**
         * @return task id
         */
        public long getTaskId() {
            return mTaskId;
        }

        /**
         * @return one of {@link #RESULT_SUCCESS}, {@link #RESULT_FAILED}, {@link #RESULT_TIMEOUT}
         */
        public int getResultCode() {
            return mResultCode;
        }

        /**
         * @return task target service {@link UUID}
         */
        public UUID getServiceUUID() {
            return mServiceUUID;
        }

        /**
         * @return task target characteristic {@link UUID}
         */
        public UUID getCharacteristicUUID() {
            return mCharacteristicUUID;
        }

        /**
         * @return task target descriptor {@link UUID}
         */
        public UUID getDescriptorUUID() {
            return mDescriptorUUID;
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
        public byte[] getValues() {
            return mValues;
        }

        /**
         * @return callback argument
         */
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
    protected final Map<Long, CountDownLatch> mLockMap = Collections.synchronizedMap(new LinkedHashMap<Long, CountDownLatch>());

    /**
     * map for result
     */
    protected final Map<Long, BLEResult> mResultMap = Collections.synchronizedMap(new LinkedHashMap<Long, BLEResult>());

    /**
     * notification(indication) listner map
     */
    protected final Map<Pair<UUID, UUID>, List<List<byte[]>>> mNotificationListenerMap = new LinkedHashMap<>();

    /**
     * {@link BLEConnection} instance
     */
    protected BLEConnection mBLEConnection;

    /**
     * @param context         {@link Context} instance
     * @param bluetoothDevice BLE device
     */
    public BLESyncConnection(Context context, BluetoothDevice bluetoothDevice) {
        mContext = context;
        mBluetoothDevice = bluetoothDevice;
    }

    /**
     * for instant synchronous communication
     *
     * @see #createReadCharacteristicTask(BLEConnection, UUID, UUID, long, long, Bundle)
     * @see #createWriteCharacteristicTask(BLEConnection, UUID, UUID, ByteArrayInterface, int, long, long, Bundle)
     * @see #createReadDescriptorTask(BLEConnection, UUID, UUID, UUID, long, long, Bundle)
     * @see #createWriteDescriptorTask(BLEConnection, UUID, UUID, UUID, ByteArrayInterface, long, long, Bundle)
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
     * @param taskTimeout timeout include waiting time in queue, ble response(millis), taskTimeout must greater than bleTimeout
     * @param bleTimeout  ble response timeout(millis)
     * @param argument    callback argument
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    public synchronized BLEResult connect(long taskTimeout, long bleTimeout, Bundle argument) {
        BLEResult bleResult = null;
        if (mBLEConnection == null) {
            mResultMap.clear();
            BLEConnection bleConnection = new BLEConnection(mContext, mBluetoothDevice, this);

            bleResult = createTaskSynchronous(bleConnection, ConnectTask.class, null, null, null, null, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, taskTimeout, bleTimeout, argument);

            if (bleConnection.isConnected()) {
                mBLEConnection = bleConnection;
            } else {
                bleConnection.quit();
            }
        }
        return bleResult;
    }

    /**
     * @see #quit(Bundle)
     */
    public BLEResult quit() {
        return quit(null);
    }

    /**
     * <p>
     * Disconnect with synchronous
     * <p>
     * if already disconnect, do not anything
     * </p>
     *
     * @param argument callback argument
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    public synchronized BLEResult quit(Bundle argument) {
        BLEResult bleResult = null;
        if (mBLEConnection != null) {
            bleResult = createTaskSynchronous(mBLEConnection, DisconnectTask.class, null, null, null, null, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, DisconnectTask.PROGRESS_TIMEOUT + 1, DisconnectTask.PROGRESS_TIMEOUT, argument);
            mLockMap.clear();
            mBLEConnection = null;
        }
        return bleResult;
    }

    /**
     * Create read characteristic task with synchronous
     *
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param taskTimeout        timeout include waiting time in queue, ble response(millis), taskTimeout must greater equal bleTimeout
     * @param bleTimeout         ble response timeout(millis)
     * @param argument           callback argument
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    public BLEResult createReadCharacteristicTask(UUID serviceUUID, UUID characteristicUUID, long taskTimeout, long bleTimeout, Bundle argument) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            bleResult = createTaskSynchronous(bleConnection, ReadCharacteristicTask.class, serviceUUID, characteristicUUID, null, null, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, taskTimeout, bleTimeout, argument);
        }
        return bleResult;
    }

    /**
     * instance read characterisitc task
     *
     * @see #createReadDescriptorTask(BLEConnection, UUID, UUID, UUID, long, long, Bundle)
     */
    public static BLEResult createReadCharacteristicTask(BLEConnection bleConnection, UUID serviceUUID, UUID characteristicUUID, long taskTimeout, long bleTimeout, Bundle argument) {
        BLEResult bleResult = null;
        if (bleConnection != null) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleConnection.addCallback(bleSyncConnection);
            bleResult = bleSyncConnection.createReadCharacteristicTask(serviceUUID, characteristicUUID, taskTimeout, bleTimeout, argument);
            bleConnection.removeCallback(bleSyncConnection);
        }
        return bleResult;
    }

    /**
     * Create write characteristic task with synchronous
     *
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param byteArrayInterface write data
     * @param writeType          one of {@link BluetoothGattCharacteristic#WRITE_TYPE_DEFAULT}, {@link BluetoothGattCharacteristic#WRITE_TYPE_NO_RESPONSE}, {@link BluetoothGattCharacteristic#WRITE_TYPE_SIGNED}
     * @param taskTimeout        timeout include waiting time in queue, ble response(millis), taskTimeout must greater equal bleTimeout
     * @param bleTimeout         ble response timeout(millis)
     * @param argument           callback argument
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    public BLEResult createWriteCharacteristicTask(UUID serviceUUID, UUID characteristicUUID, ByteArrayInterface byteArrayInterface, int writeType, long taskTimeout, long bleTimeout, Bundle argument) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            bleResult = createTaskSynchronous(bleConnection, WriteCharacteristicTask.class, serviceUUID, characteristicUUID, null, byteArrayInterface, writeType, taskTimeout, bleTimeout, argument);
        }
        return bleResult;
    }

    /**
     * instant write characteristic task
     *
     * @see #createWriteCharacteristicTask(UUID, UUID, ByteArrayInterface, int, long, long, Bundle)
     */
    public static BLEResult createWriteCharacteristicTask(BLEConnection bleConnection, UUID serviceUUID, UUID characteristicUUID, ByteArrayInterface byteArrayInterface, int writeType, long taskTimeout, long bleTimeout, Bundle argument) {
        BLEResult bleResult = null;
        if (bleConnection != null && bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleConnection.addCallback(bleSyncConnection);
            bleResult = bleSyncConnection.createWriteCharacteristicTask(serviceUUID, characteristicUUID, byteArrayInterface, writeType, taskTimeout, bleTimeout, argument);
            bleConnection.removeCallback(bleSyncConnection);
        }
        return bleResult;
    }

    /**
     * Create read descriptor task with synchronous
     *
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor {@link UUID}
     * @param taskTimeout        timeout include waiting time in queue, ble response(millis), taskTimeout must greater equal bleTimeout
     * @param bleTimeout         ble response timeout(millis)
     * @param argument           callback argument
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    public BLEResult createReadDescriptorTask(UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long taskTimeout, long bleTimeout, Bundle argument) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            bleResult = createTaskSynchronous(bleConnection, ReadDescriptorTask.class, serviceUUID, characteristicUUID, descriptorUUID, null, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, taskTimeout, bleTimeout, argument);
        }
        return bleResult;
    }

    /**
     * instant read descriptor task
     *
     * @see #createReadDescriptorTask(UUID, UUID, UUID, long, long, Bundle)
     */
    public static BLEResult createReadDescriptorTask(BLEConnection bleConnection, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long taskTimeout, long bleTimeout, Bundle argument) {
        BLEResult bleResult = null;
        if (bleConnection != null && bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleConnection.addCallback(bleSyncConnection);
            bleResult = bleSyncConnection.createReadDescriptorTask(serviceUUID, characteristicUUID, descriptorUUID, taskTimeout, bleTimeout, argument);
            bleConnection.removeCallback(bleSyncConnection);
        }
        return bleResult;
    }

    /**
     * Create write descriptor task with synchronous
     *
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor {@link UUID}
     * @param byteArrayInterface write data
     * @param taskTimeout        timeout include waiting time in queue, ble response(millis), taskTimeout must greater equal bleTimeout
     * @param bleTimeout         ble response timeout(millis)
     * @param argument           callback argument
     * @return {@code null}:BLE not connected, {@link BLEResult}:connected
     */
    public BLEResult createWriteDescriptorTask(UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, ByteArrayInterface byteArrayInterface, long taskTimeout, long bleTimeout, Bundle argument) {
        BLEResult bleResult = null;
        BLEConnection bleConnection = mBLEConnection;
        if (bleConnection != null) {
            bleResult = createTaskSynchronous(bleConnection, WriteDescriptorTask.class, serviceUUID, characteristicUUID, descriptorUUID, byteArrayInterface, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, taskTimeout, bleTimeout, argument);
        }
        return bleResult;
    }

    /**
     * instant write descriptor task
     *
     * @see #createWriteDescriptorTask(UUID, UUID, UUID, ByteArrayInterface, long, long, Bundle)
     */
    public static BLEResult createWriteDescriptorTask(BLEConnection bleConnection, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, ByteArrayInterface byteArrayInterface, long taskTimeout, long bleTimeout, Bundle argument) {
        BLEResult bleResult = null;
        if (bleConnection != null && bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleConnection.addCallback(bleSyncConnection);
            bleResult = bleSyncConnection.createWriteDescriptorTask(serviceUUID, characteristicUUID, descriptorUUID, byteArrayInterface, taskTimeout, bleTimeout, argument);
            bleConnection.removeCallback(bleSyncConnection);
        }
        return bleResult;
    }

    /**
     * Listen notification or indication
     *
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param duration           listen duration
     * @return notification or indication value list
     */
    public List<byte[]> listen(UUID serviceUUID, UUID characteristicUUID, long duration) {
        List<byte[]> listener = new LinkedList<>();

        Pair<UUID, UUID> pair = Pair.create(serviceUUID, characteristicUUID);
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
                Thread.sleep(end - SystemClock.elapsedRealtime());
            } catch (InterruptedException e) {
                BLELogUtils.stackLog(e);
            }
        } while (end > SystemClock.elapsedRealtime());

        synchronized (mNotificationListenerMap) {
            listenerList.remove(listener);
            mNotificationListenerMap.notifyAll();
        }
        return listener;
    }

    /**
     * instant listen notification or indication
     *
     * @see #listen(UUID, UUID, long)
     */
    public static List<byte[]> listen(BLEConnection bleConnection, UUID serviceUUID, UUID characteristicUUID, long duration) {
        List<byte[]> listener = null;
        if (bleConnection != null && bleConnection.isConnected()) {
            BLESyncConnection bleSyncConnection = new BLESyncConnection();
            bleSyncConnection.mBLEConnection = bleConnection;
            bleConnection.addCallback(bleSyncConnection);
            listener = bleSyncConnection.listen(serviceUUID, characteristicUUID, duration);
            bleConnection.removeCallback(bleSyncConnection);
        }
        return listener;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBLEConnected(long taskId, BluetoothDevice bluetoothDevice, Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, null, null, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBLEConnectFailed(long taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, null, null, null, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBLEConnectTimeout(long taskId, BluetoothDevice bluetoothDevice, Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, null, null, null, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBLEDisonnected(long taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, null, null, null, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, serviceUUID, characteristicUUID, null, BluetoothGatt.GATT_SUCCESS, values, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadFailed(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, serviceUUID, characteristicUUID, null, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadTimeout(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, serviceUUID, characteristicUUID, null, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, serviceUUID, characteristicUUID, null, BluetoothGatt.GATT_SUCCESS, values, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteFailed(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, serviceUUID, characteristicUUID, null, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteTimeout(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, serviceUUID, characteristicUUID, null, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, serviceUUID, characteristicUUID, descriptorUUID, BluetoothGatt.GATT_SUCCESS, values, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadFailed(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, serviceUUID, characteristicUUID, descriptorUUID, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadTimeout(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, serviceUUID, characteristicUUID, descriptorUUID, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_SUCCESS, serviceUUID, characteristicUUID, descriptorUUID, BluetoothGatt.GATT_SUCCESS, values, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteFailed(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_FAILED, serviceUUID, characteristicUUID, descriptorUUID, status, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteTimeout(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
        unlock(argument, new BLEResult(taskId, RESULT_TIMEOUT, serviceUUID, characteristicUUID, descriptorUUID, BluetoothGatt.GATT_SUCCESS, null, argument.getBundle(KEY_WRAPPED)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicNotified(BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values) {
        synchronized (mNotificationListenerMap) {
            List<List<byte[]>> list = mNotificationListenerMap.get(Pair.create(serviceUUID, characteristicUUID));
            //noinspection ConstantConditions
            for (List<byte[]> listener : list) {
                listener.add(values);
            }
            mNotificationListenerMap.notifyAll();
        }
    }

    /**
     * synchronous ble request
     *
     * @param bleConnection      {@link BLEConnection} instance
     * @param taskClass          one of {@link ConnectTask}, {@link DisconnectTask}, {@link ReadCharacteristicTask}, {@link WriteCharacteristicTask}, {@link ReadDescriptorTask}, {@link WriteDescriptorTask}
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor {@link UUID}
     * @param byteArrayInterface write data
     * @param writeType          one of {@link BluetoothGattCharacteristic#WRITE_TYPE_DEFAULT}, {@link BluetoothGattCharacteristic#WRITE_TYPE_NO_RESPONSE}, {@link BluetoothGattCharacteristic#WRITE_TYPE_SIGNED}
     * @param taskTimeout        timeout include waiting time in queue, ble response(millis), taskTimeout must greater equal bleTimeout
     * @param bleTimeout         ble response timeout(millis)
     * @param argument           callback argument
     * @return BLE result
     */
    private BLEResult createTaskSynchronous(BLEConnection bleConnection, Class<? extends AbstractBLETask> taskClass, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, ByteArrayInterface byteArrayInterface, int writeType, long taskTimeout, long bleTimeout, Bundle argument) {
        taskTimeout = taskTimeout < bleTimeout ? bleTimeout : taskTimeout;
        long end = taskTimeout + SystemClock.elapsedRealtime();

        // create lock
        long key = LOCK_ID_GENERATOR.incrementAndGet();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        mLockMap.put(key, countDownLatch);

        // wrap original argument
        Bundle wrappedArgument = new Bundle();
        wrappedArgument.putBundle(KEY_WRAPPED, argument);
        wrappedArgument.putLong(KEY_RESULT, key);

        // call async
        long taskId;
        if (ConnectTask.class.equals(taskClass)) {
            taskId = bleConnection.connect(bleTimeout, wrappedArgument);
        } else if (DisconnectTask.class.equals(taskClass)) {
            taskId = bleConnection.quit(wrappedArgument);
        } else if (ReadCharacteristicTask.class.equals(taskClass)) {
            taskId = bleConnection.createReadCharacteristicTask(serviceUUID, characteristicUUID, bleTimeout, wrappedArgument);
        } else if (WriteCharacteristicTask.class.equals(taskClass)) {
            taskId = bleConnection.createWriteCharacteristicTask(serviceUUID, characteristicUUID, byteArrayInterface, writeType, bleTimeout, wrappedArgument);
        } else if (ReadDescriptorTask.class.equals(taskClass)) {
            taskId = bleConnection.createReadDescriptorTask(serviceUUID, characteristicUUID, descriptorUUID, bleTimeout, wrappedArgument);
        } else if (WriteDescriptorTask.class.equals(taskClass)) {
            taskId = bleConnection.createWriteDescriptorTask(serviceUUID, characteristicUUID, descriptorUUID, byteArrayInterface, bleTimeout, wrappedArgument);
        } else {
            taskId = TASK_ID_UNREGISTED;
        }

        BLEResult bleResult;
        // create task failed
        if (TASK_ID_UNREGISTED == taskId) {
            // create failed result
            bleResult = new BLEResult(TASK_ID_UNREGISTED, RESULT_FAILED, serviceUUID, characteristicUUID, descriptorUUID, BLEConstants.ErrorCodes.UNKNOWN, null, argument);
        } else {
            // create task success

            // remove old lock
            Set<Long> resultKeySet = mResultMap.keySet();
            resultKeySet.removeAll(mLockMap.keySet());
            resultKeySet.remove(key);
            for (long oldKey : resultKeySet) {
                mResultMap.remove(oldKey);
            }

            // waiting task result
            do {
                try {
                    countDownLatch.await(end - SystemClock.elapsedRealtime(), TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    BLELogUtils.stackLog(e);
                }
            } while (!mResultMap.containsKey(key) && !bleConnection.isConnected() && end < SystemClock.currentThreadTimeMillis());

            // get task result and remove lock instance
            bleResult = mResultMap.remove(key);
            if (bleResult == null) {
                bleResult = new BLEResult(taskId, RESULT_TIMEOUT, serviceUUID, characteristicUUID, descriptorUUID, BluetoothGatt.GATT_SUCCESS, null, argument);
            }
            mLockMap.remove(key);
        }

        return bleResult;
    }

    /**
     * free lock and put result
     *
     * @param argument  {@link #createTaskSynchronous(BLEConnection, Class, UUID, UUID, UUID, ByteArrayInterface, int, long, long, Bundle)} 10th argument
     * @param bleResult ble request result
     */
    private void unlock(Bundle argument, BLEResult bleResult) {
        long key = argument.getLong(KEY_RESULT, 0);
        CountDownLatch countDownLatch = mLockMap.get(key);
        if (countDownLatch != null) {
            mResultMap.put(key, bleResult);
            countDownLatch.countDown();
        }
    }

}
