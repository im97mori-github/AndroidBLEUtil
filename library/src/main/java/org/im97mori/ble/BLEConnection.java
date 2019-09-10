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
import android.os.Message;

import org.im97mori.ble.descriptor.ClientCharacteristicConfiguration;
import org.im97mori.ble.task.AbstractBLETask;
import org.im97mori.ble.task.ConnectTask;
import org.im97mori.ble.task.DisconnectTask;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR;
import static org.im97mori.ble.task.AbstractBLETask.TASK_ID_UNREGISTED;

/**
 * BLE connection(central role)
 * <p>
 * Asynchronous
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BLEConnection extends BluetoothGattCallback {

    /**
     * BLECallback wrapper for distribute
     */
    private static final class DistributionBLECallback implements BLECallback {

        /**
         * get {@link #mPrimaryBLECallback} and {@link #mAdditionalBLECallbackSet}
         */
        private final BLEConnection mBLEConnection;

        /**
         * @param bleConnection {@link BLEConnection}
         */
        private DistributionBLECallback(BLEConnection bleConnection) {
            mBLEConnection = bleConnection;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onBLEConnected(long taskId, BluetoothDevice bluetoothDevice, Bundle argument) {
            // do nothing
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onBLEConnectFailed(long taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {
            // do nothing
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onBLEConnectTimeout(long taskId, BluetoothDevice bluetoothDevice, Bundle argument) {
            // do nothing
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onBLEDisonnected(long taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {
            // do nothing
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onCharacteristicReadSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {
            synchronized (mBLEConnection) {
                mBLEConnection.mPrimaryBLECallback.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, values, argument);
                for (BLECallback bleCallback : mBLEConnection.mAdditionalBLECallbackSet) {
                    bleCallback.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, values, argument);
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onCharacteristicReadFailed(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
            synchronized (mBLEConnection) {
                mBLEConnection.mPrimaryBLECallback.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, status, argument);
                for (BLECallback bleCallback : mBLEConnection.mAdditionalBLECallbackSet) {
                    bleCallback.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, status, argument);
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onCharacteristicReadTimeout(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
            synchronized (mBLEConnection) {
                mBLEConnection.mPrimaryBLECallback.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, timeout, argument);
                for (BLECallback bleCallback : mBLEConnection.mAdditionalBLECallbackSet) {
                    bleCallback.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, timeout, argument);
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onCharacteristicWriteSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {
            synchronized (mBLEConnection) {
                mBLEConnection.mPrimaryBLECallback.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, values, argument);
                for (BLECallback bleCallback : mBLEConnection.mAdditionalBLECallbackSet) {
                    bleCallback.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, values, argument);
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onCharacteristicWriteFailed(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
            synchronized (mBLEConnection) {
                mBLEConnection.mPrimaryBLECallback.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, status, argument);
                for (BLECallback bleCallback : mBLEConnection.mAdditionalBLECallbackSet) {
                    bleCallback.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, status, argument);
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onCharacteristicWriteTimeout(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
            synchronized (mBLEConnection) {
                mBLEConnection.mPrimaryBLECallback.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, timeout, argument);
                for (BLECallback bleCallback : mBLEConnection.mAdditionalBLECallbackSet) {
                    bleCallback.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, timeout, argument);
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onDescriptorReadSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {
            synchronized (mBLEConnection) {
                mBLEConnection.mPrimaryBLECallback.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, values, argument);
                for (BLECallback bleCallback : mBLEConnection.mAdditionalBLECallbackSet) {
                    bleCallback.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, values, argument);
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onDescriptorReadFailed(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {
            synchronized (mBLEConnection) {
                mBLEConnection.mPrimaryBLECallback.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, status, argument);
                for (BLECallback bleCallback : mBLEConnection.mAdditionalBLECallbackSet) {
                    bleCallback.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, status, argument);
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onDescriptorReadTimeout(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
            synchronized (mBLEConnection) {
                mBLEConnection.mPrimaryBLECallback.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, timeout, argument);
                for (BLECallback bleCallback : mBLEConnection.mAdditionalBLECallbackSet) {
                    bleCallback.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, timeout, argument);
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onDescriptorWriteSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {
            synchronized (mBLEConnection) {
                mBLEConnection.mPrimaryBLECallback.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, values, argument);
                for (BLECallback bleCallback : mBLEConnection.mAdditionalBLECallbackSet) {
                    bleCallback.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, values, argument);
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onDescriptorWriteFailed(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {
            synchronized (mBLEConnection) {
                mBLEConnection.mPrimaryBLECallback.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, status, argument);
                for (BLECallback bleCallback : mBLEConnection.mAdditionalBLECallbackSet) {
                    bleCallback.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, status, argument);
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onDescriptorWriteTimeout(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
            synchronized (mBLEConnection) {
                mBLEConnection.mPrimaryBLECallback.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, timeout, argument);
                for (BLECallback bleCallback : mBLEConnection.mAdditionalBLECallbackSet) {
                    bleCallback.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, timeout, argument);
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onCharacteristicNotified(BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values) {
            synchronized (mBLEConnection) {
                mBLEConnection.mPrimaryBLECallback.onCharacteristicNotified(bluetoothDevice, serviceUUID, characteristicUUID, values);
                for (BLECallback bleCallback : mBLEConnection.mAdditionalBLECallbackSet) {
                    bleCallback.onCharacteristicNotified(bluetoothDevice, serviceUUID, characteristicUUID, values);
                }
                mBLEConnection.notifyAll();
            }
        }

    }

    /**
     * {@link Context} instance
     */
    protected final Context mContext;

    /**
     * BLE device
     */
    protected final BluetoothDevice mBluetoothDevice;

    /**
     * {@link BLECallback} instance
     */
    protected final BLECallback mPrimaryBLECallback;

    /**
     * additional callback from {@link BLESyncConnection}
     */
    protected final Set<BLECallback> mAdditionalBLECallbackSet = new HashSet<>();

    /**
     * <p>
     * current notification status
     * <p>
     * if {@link Set#contains(Object)} return true, target UUID(characteristic) is {@link BluetoothGattDescriptor#ENABLE_NOTIFICATION_VALUE} status
     * </p>
     */
    protected final Set<UUID> mNotificationSet = new HashSet<>();

    /**
     * {@link BLEConnection.DistributionBLECallback} instance
     */
    protected final DistributionBLECallback mDistributionBLECallback;

    /**
     * newest {@link BluetoothGatt} instance
     */
    protected BluetoothGatt mBluetoothGatt;

    /**
     * newest {@link TaskHandler} instance
     */
    protected TaskHandler mTaskHandler;

    /**
     * @param context         {@link Context} instance
     * @param bluetoothDevice BLE device
     * @param bleCallback     {@link BLECallback} instance
     */
    public BLEConnection(Context context, BluetoothDevice bluetoothDevice, BLECallback bleCallback) {
        mContext = context;
        mBluetoothDevice = bluetoothDevice;
        mPrimaryBLECallback = bleCallback;
        mDistributionBLECallback = new DistributionBLECallback(this);
    }

    /**
     * regist additional callback
     *
     * @param callback additional {@link BLECallback}
     */
    synchronized void addCallback(BLECallback callback) {
        mAdditionalBLECallbackSet.add(callback);
    }

    /**
     * unregist additional callback
     *
     * @param callback added {@link BLECallback}
     */
    synchronized void removeCallback(BLECallback callback) {
        mAdditionalBLECallbackSet.remove(callback);
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
     * @see #connect(long, Bundle)
     */
    public long connect(long timeout) {
        return connect(timeout, null);
    }

    /**
     * <p>
     * Connect ble
     * <p>
     * if already connected, do not anything
     * </p>
     *
     * @param timeout  timeout(millis)
     * @param argument callback argument
     */
    public synchronized long connect(long timeout, Bundle argument) {
        long taskId = TASK_ID_UNREGISTED;
        if (mBluetoothGatt == null) {
            start();

            ConnectTask task = new ConnectTask(this, mTaskHandler, timeout, argument);
            Message message = ConnectTask.createConnectMessage(task);
            mTaskHandler.addTask(task, message);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * @see #quit(Bundle)
     */
    public long quit() {
        return this.quit(null);
    }


    /**
     * <p>
     * Disconnect and clear all task
     * <p>
     * if already disconnect, do not anything
     * </p>
     *
     * @param argument callback argument
     */
    public synchronized long quit(Bundle argument) {
        long taskId = TASK_ID_UNREGISTED;
        if (mBluetoothGatt != null) {
            mTaskHandler.clearTask();

            DisconnectTask task = new DisconnectTask(this, mBluetoothGatt, argument);
            Message message = DisconnectTask.createDisconnectMessage(task);
            mTaskHandler.addTask(task, message);
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
    public synchronized void cancelTask(long taskId) {
        if (mTaskHandler != null) {
            mTaskHandler.cancelTask(taskId);
        }
    }

    /**
     * Add user original task
     *
     * @param task    {@link AbstractBLETask} instance
     * @param message task's first {@link Message} instance
     * @see TaskHandler#addTask(AbstractBLETask, Message)
     */
    public synchronized void addTask(AbstractBLETask task, Message message) {
        if (mTaskHandler != null) {
            mTaskHandler.addTask(task, message);
        }
    }

    /**
     * Callback at connected and service discover successed
     *
     * @param taskId        task id
     * @param bluetoothGatt Connected {@link BluetoothGatt}
     * @param argument      callback argument
     */
    public synchronized void onConnected(long taskId, BluetoothGatt bluetoothGatt, Bundle argument) {
        if (mBluetoothGatt == null) {
            mBluetoothGatt = bluetoothGatt;
            mPrimaryBLECallback.onBLEConnected(taskId, mBluetoothDevice, argument);
        }
    }

    /**
     * Callback at {@link ConnectTask} failed
     *
     * @param taskId   task id
     * @param status   one of {@link BLEConnection#onConnectionStateChange(BluetoothGatt, int, int)} 2nd parameter, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}
     * @param argument callback argument
     */
    public synchronized void onConnectFailed(long taskId, int status, Bundle argument) {
        if (mTaskHandler != null) {
            mTaskHandler.quit();
            mTaskHandler = null;
            mPrimaryBLECallback.onBLEConnectFailed(taskId, mBluetoothDevice, status, argument);
            for (BLECallback callback : mAdditionalBLECallbackSet) {
                callback.onBLEConnectFailed(taskId, mBluetoothDevice, status, argument);
            }
        }
    }

    /**
     * Callback at {@link ConnectTask} timeout
     *
     * @param taskId   task id
     * @param argument callback argument
     */
    public synchronized void onConnectTimeout(long taskId, Bundle argument) {
        if (mTaskHandler != null) {
            mTaskHandler.quit();
            mTaskHandler = null;
            mPrimaryBLECallback.onBLEConnectTimeout(taskId, mBluetoothDevice, argument);
            for (BLECallback callback : mAdditionalBLECallbackSet) {
                callback.onBLEConnectTimeout(taskId, mBluetoothDevice, argument);
            }
        }
    }


    /**
     * Callback at disconnected
     *
     * @param taskId        task id
     * @param bluetoothGatt Disconnected {@link BluetoothGatt}
     * @param status        @link android.bluetooth.BluetoothGattCallback#onConnectionStateChange(BluetoothGatt, int, int)} 2nd parameter or {@link BLEConstants.ErrorCodes#UNKNOWN}
     * @param argument      callback argument
     */
    public synchronized void onDisconnected(long taskId, BluetoothGatt bluetoothGatt, int status, Bundle argument) {
        if (bluetoothGatt == mBluetoothGatt) {
            mBluetoothGatt = null;
            if (mTaskHandler != null) {
                mTaskHandler.quit();
                mTaskHandler = null;
            }
            mNotificationSet.clear();
            mPrimaryBLECallback.onBLEDisonnected(taskId, mBluetoothDevice, status, argument);
            for (BLECallback callback : mAdditionalBLECallbackSet) {
                callback.onBLEDisonnected(taskId, mBluetoothDevice, status, argument);
            }
        }
    }

    /**
     * check {@link BluetoothGatt} is newest one
     *
     * @param bluetoothGatt check target {@link BluetoothGatt}
     * @return {@code true}:newest one, {@code false}:not newest one
     */
    public boolean isCurrentConnectionTarget(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt == mBluetoothGatt;
    }

    /**
     * @return {@link Context} instance
     */
    public Context getContext() {
        return mContext;
    }

    /**
     * @return BLE device {@link BluetoothDevice}
     */
    public BluetoothDevice getBluetoothDevice() {
        return mBluetoothDevice;
    }

    /**
     * @return {@link BLECallback} instance
     */
    public BLECallback getBLECallback() {
        return mDistributionBLECallback;
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

                    // start discover services
                    if (!gatt.discoverServices()) {
                        DisconnectTask task = new DisconnectTask(this, gatt, null);
                        Message message = DisconnectTask.createDisconnectMessage(task, status);
                        mTaskHandler.addTask(task, message);
                    }
                }
            }

            if (BluetoothGatt.STATE_DISCONNECTED == newState) {
                // disconnected

                // add disconnect task
                DisconnectTask task = new DisconnectTask(this, gatt, null);
                Message message = DisconnectTask.createDisconnectMessage(task, status);
                mTaskHandler.addTask(task, message);
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

                // maximus mtu
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    gatt.requestMtu(BLEConstants.MAXIMUX_MTU);
                } else {
                    // connect task finished
                    Message message = ConnectTask.createConnectFinished(gatt);
                    mTaskHandler.sendProcessingMessage(message);
                }
            } else {
                // service discover failed

                // add disconnect task
                DisconnectTask task = new DisconnectTask(this, gatt, null);
                Message message = DisconnectTask.createDisconnectMessage(task, status);
                mTaskHandler.addTask(task, message);
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
                mTaskHandler.sendProcessingMessage(ReadCharacteristicTask.createReadCharacteristicFinishedMessage(service.getUuid(), characteristic.getUuid(), characteristic.getValue()));
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
                mTaskHandler.sendProcessingMessage(WriteCharacteristicTask.createWriteCharacteristicFinishedMessage(service.getUuid(), characteristic.getUuid(), characteristic.getValue()));
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
            UUID uuid = characteristic.getUuid();

            // notification status check
            if (mNotificationSet.contains(uuid)) {
                mPrimaryBLECallback.onCharacteristicNotified(mBluetoothDevice, characteristic.getService().getUuid(), uuid, characteristic.getValue());
                for (BLECallback callback : mAdditionalBLECallbackSet) {
                    callback.onCharacteristicNotified(mBluetoothDevice, characteristic.getService().getUuid(), uuid, characteristic.getValue());
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
                mTaskHandler.sendProcessingMessage(ReadDescriptorTask.createReadDescriptorFinishedMessage(service.getUuid(), characteristicUUID, descriptorUUID, descriptor.getValue()));
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
                mTaskHandler.sendProcessingMessage(WriteDescriptorTask.createWriteDescriptorFinishedMessage(service.getUuid(), characteristicUUID, descriptorUUID, descriptor.getValue()));
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
    @Override
    public void onMtuChanged(BluetoothGatt gatt, int mtu, int status) {
        if (mTaskHandler != null) {
            if (BluetoothGatt.GATT_SUCCESS == status) {
                // service discover finished

                // connect task finished
                Message message = ConnectTask.createConnectFinished(gatt);
                mTaskHandler.sendProcessingMessage(message);
            } else {
                // service discover failed

                // add disconnect task
                DisconnectTask task = new DisconnectTask(this, gatt, null);
                Message message = DisconnectTask.createDisconnectMessage(task, status);
                mTaskHandler.addTask(task, message);
            }
        }
    }

    /**
     * @see #createReadCharacteristicTask(UUID, UUID, long, Bundle)
     */
    public long createReadCharacteristicTask(UUID serviceUUID, UUID characteristicUUID, long timeout) {
        return this.createReadCharacteristicTask(serviceUUID, characteristicUUID, timeout, null);
    }

    /**
     * Create read characteristic task
     *
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param timeout            timeout(millis)
     * @param argument           callback argument
     */
    public synchronized long createReadCharacteristicTask(UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
        long taskId = TASK_ID_UNREGISTED;
        BluetoothGatt bluetoothGatt = mBluetoothGatt;
        if (bluetoothGatt != null) {
            ReadCharacteristicTask task = new ReadCharacteristicTask(this, bluetoothGatt, mTaskHandler, serviceUUID, characteristicUUID, timeout, argument);
            Message message = ReadCharacteristicTask.createReadCharacteristicMessage(serviceUUID, characteristicUUID, task);
            mTaskHandler.addTask(task, message);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * @see #createWriteCharacteristicTask(UUID, UUID, ByteArrayInterface, int, long, Bundle)
     */
    public long createWriteCharacteristicTask(UUID serviceUUID, UUID characteristicUUID, ByteArrayInterface byteArrayInterface, long timeout) {
        return createWriteCharacteristicTask(serviceUUID, characteristicUUID, byteArrayInterface, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, timeout);
    }

    /**
     * @see #createWriteCharacteristicTask(UUID, UUID, ByteArrayInterface, int, long, Bundle)
     */
    public long createWriteCharacteristicTask(UUID serviceUUID, UUID characteristicUUID, ByteArrayInterface byteArrayInterface, int writeType, long timeout) {
        return this.createWriteCharacteristicTask(serviceUUID, characteristicUUID, byteArrayInterface, writeType, timeout, null);
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
     */
    public synchronized long createWriteCharacteristicTask(UUID serviceUUID, UUID characteristicUUID, ByteArrayInterface byteArrayInterface, int writeType, long timeout, Bundle argument) {
        long taskId = TASK_ID_UNREGISTED;
        if (mBluetoothGatt != null) {
            WriteCharacteristicTask task = new WriteCharacteristicTask(this, mBluetoothGatt, mTaskHandler, serviceUUID, characteristicUUID, byteArrayInterface, writeType, timeout, argument);
            Message message = WriteCharacteristicTask.createWriteCharacteristicMessage(serviceUUID, characteristicUUID, task);
            mTaskHandler.addTask(task, message);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * @see #createReadDescriptorTask(UUID, UUID, UUID, long, Bundle)
     */
    public long createReadDescriptorTask(UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout) {
        return this.createReadDescriptorTask(serviceUUID, characteristicUUID, descriptorUUID, timeout, null);
    }

    /**
     * Create read descriptor task
     *
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor {@link UUID}
     * @param timeout            timeout(millis)
     * @param argument           callback argument
     */
    public synchronized long createReadDescriptorTask(UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
        long taskId = TASK_ID_UNREGISTED;
        if (mBluetoothGatt != null) {
            ReadDescriptorTask task = new ReadDescriptorTask(this, mBluetoothGatt, mTaskHandler, serviceUUID, characteristicUUID, descriptorUUID, timeout, argument);
            Message message = ReadDescriptorTask.createReadDescriptorMessage(serviceUUID, characteristicUUID, descriptorUUID, task);
            mTaskHandler.addTask(task, message);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * @see #createWriteDescriptorTask(UUID, UUID, UUID, ByteArrayInterface, long, Bundle)
     */
    public long createWriteDescriptorTask(UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, ByteArrayInterface byteArrayInterface, long timeout) {
        return createWriteDescriptorTask(serviceUUID, characteristicUUID, descriptorUUID, byteArrayInterface, timeout, null);
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
     */
    public synchronized long createWriteDescriptorTask(UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, ByteArrayInterface byteArrayInterface, long timeout, Bundle argument) {
        long taskId = TASK_ID_UNREGISTED;
        if (mBluetoothGatt != null) {
            WriteDescriptorTask task = new WriteDescriptorTask(this, mBluetoothGatt, mTaskHandler, serviceUUID, characteristicUUID, descriptorUUID, byteArrayInterface, timeout, argument);
            Message message = WriteDescriptorTask.createWriteDescriptorMessage(serviceUUID, characteristicUUID, descriptorUUID, task);
            mTaskHandler.addTask(task, message);
            taskId = task.getTaskId();
        }
        return taskId;
    }

}
