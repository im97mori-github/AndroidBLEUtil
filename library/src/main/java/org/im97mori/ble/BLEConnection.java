package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
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

/**
 * BLE connection(central role)
 * <p>
 * Asynchronous
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BLEConnection extends BluetoothGattCallback {

    /**
     * KEY:CALLBACK_ID
     */
    protected static final String KEY_CALLBACK_ID = "KEY_CALLBACK_ID";

    /**
     * KEY:WRAPPED_ARGUMENT
     */
    protected static final String KEY_WRAPPED_ARGUMENT = "KEY_WRAPPED_ARGUMENT";

    /**
     * BLECallback wrapper for distribute
     */
    private static final class DistributionBLECallback implements BLECallback {

        /**
         * {@link #mAttachedBLECallbackSet}
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
        public void onBLEConnected(Integer taskId, BluetoothDevice bluetoothDevice, Bundle argument) {
            synchronized (mBLEConnection) {

                Integer callbackId;
                if (argument.containsKey(KEY_CALLBACK_ID)) {
                    callbackId = argument.getInt(KEY_CALLBACK_ID);
                } else {
                    callbackId = null;
                }
                Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        if (callbackId == null) {
                            bleCallback.onBLEConnected(taskId, bluetoothDevice, originalArgument);
                        } else if (bleCallback.hashCode() == callbackId) {
                            bleCallback.onBLEConnected(taskId, bluetoothDevice, originalArgument);
                            break;
                        }
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onBLEConnectFailed(Integer taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {
            synchronized (mBLEConnection) {

                Integer callbackId;
                if (argument.containsKey(KEY_CALLBACK_ID)) {
                    callbackId = argument.getInt(KEY_CALLBACK_ID);
                } else {
                    callbackId = null;
                }
                Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        if (callbackId == null) {
                            bleCallback.onBLEConnectFailed(taskId, bluetoothDevice, status, originalArgument);
                        } else if (bleCallback.hashCode() == callbackId) {
                            bleCallback.onBLEConnectFailed(taskId, bluetoothDevice, status, originalArgument);
                            break;
                        }
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
                }
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onBLEConnectTimeout(Integer taskId, BluetoothDevice bluetoothDevice, Bundle argument) {
            synchronized (mBLEConnection) {

                Integer callbackId;
                if (argument.containsKey(KEY_CALLBACK_ID)) {
                    callbackId = argument.getInt(KEY_CALLBACK_ID);
                } else {
                    callbackId = null;
                }
                Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        if (callbackId == null) {
                            bleCallback.onBLEConnectTimeout(taskId, bluetoothDevice, originalArgument);
                        } else if (bleCallback.hashCode() == callbackId) {
                            bleCallback.onBLEConnectTimeout(taskId, bluetoothDevice, originalArgument);
                            break;
                        }
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
                }
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onBLEDisconnected(Integer taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {
            synchronized (mBLEConnection) {

                Integer callbackId;
                if (argument.containsKey(KEY_CALLBACK_ID)) {
                    callbackId = argument.getInt(KEY_CALLBACK_ID);
                } else {
                    callbackId = null;
                }
                Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        if (callbackId == null) {
                            bleCallback.onBLEDisconnected(taskId, bluetoothDevice, status, originalArgument);
                        } else if (bleCallback.hashCode() == callbackId) {
                            bleCallback.onBLEDisconnected(taskId, bluetoothDevice, status, originalArgument);
                            break;
                        }
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
                }
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onCharacteristicReadSuccess(Integer taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {
            synchronized (mBLEConnection) {

                Integer callbackId;
                if (argument.containsKey(KEY_CALLBACK_ID)) {
                    callbackId = argument.getInt(KEY_CALLBACK_ID);
                } else {
                    callbackId = null;
                }
                Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        if (callbackId == null) {
                            bleCallback.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, values, originalArgument);
                        } else if (bleCallback.hashCode() == callbackId) {
                            bleCallback.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, values, originalArgument);
                            break;
                        }
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onCharacteristicReadFailed(Integer taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
            synchronized (mBLEConnection) {

                Integer callbackId;
                if (argument.containsKey(KEY_CALLBACK_ID)) {
                    callbackId = argument.getInt(KEY_CALLBACK_ID);
                } else {
                    callbackId = null;
                }
                Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        if (callbackId == null) {
                            bleCallback.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, status, originalArgument);
                        } else if (bleCallback.hashCode() == callbackId) {
                            bleCallback.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, status, originalArgument);
                            break;
                        }
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onCharacteristicReadTimeout(Integer taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
            synchronized (mBLEConnection) {

                Integer callbackId;
                if (argument.containsKey(KEY_CALLBACK_ID)) {
                    callbackId = argument.getInt(KEY_CALLBACK_ID);
                } else {
                    callbackId = null;
                }
                Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        if (callbackId == null) {
                            bleCallback.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, timeout, originalArgument);
                        } else if (bleCallback.hashCode() == callbackId) {
                            bleCallback.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, timeout, originalArgument);
                            break;
                        }
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onCharacteristicWriteSuccess(Integer taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {
            synchronized (mBLEConnection) {

                Integer callbackId;
                if (argument.containsKey(KEY_CALLBACK_ID)) {
                    callbackId = argument.getInt(KEY_CALLBACK_ID);
                } else {
                    callbackId = null;
                }
                Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        if (callbackId == null) {
                            bleCallback.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, values, originalArgument);
                        } else if (bleCallback.hashCode() == callbackId) {
                            bleCallback.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, values, originalArgument);
                            break;
                        }
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onCharacteristicWriteFailed(Integer taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
            synchronized (mBLEConnection) {

                Integer callbackId;
                if (argument.containsKey(KEY_CALLBACK_ID)) {
                    callbackId = argument.getInt(KEY_CALLBACK_ID);
                } else {
                    callbackId = null;
                }
                Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        if (callbackId == null) {
                            bleCallback.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, status, originalArgument);
                        } else if (bleCallback.hashCode() == callbackId) {
                            bleCallback.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, status, originalArgument);
                            break;
                        }
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onCharacteristicWriteTimeout(Integer taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
            synchronized (mBLEConnection) {

                Integer callbackId;
                if (argument.containsKey(KEY_CALLBACK_ID)) {
                    callbackId = argument.getInt(KEY_CALLBACK_ID);
                } else {
                    callbackId = null;
                }
                Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        if (callbackId == null) {
                            bleCallback.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, timeout, originalArgument);
                        } else if (bleCallback.hashCode() == callbackId) {
                            bleCallback.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, timeout, originalArgument);
                            break;
                        }
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onDescriptorReadSuccess(Integer taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {
            synchronized (mBLEConnection) {

                Integer callbackId;
                if (argument.containsKey(KEY_CALLBACK_ID)) {
                    callbackId = argument.getInt(KEY_CALLBACK_ID);
                } else {
                    callbackId = null;
                }
                Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        if (callbackId == null) {
                            bleCallback.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, values, originalArgument);
                        } else if (bleCallback.hashCode() == callbackId) {
                            bleCallback.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, values, originalArgument);
                            break;
                        }
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onDescriptorReadFailed(Integer taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {
            synchronized (mBLEConnection) {

                Integer callbackId;
                if (argument.containsKey(KEY_CALLBACK_ID)) {
                    callbackId = argument.getInt(KEY_CALLBACK_ID);
                } else {
                    callbackId = null;
                }
                Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        if (callbackId == null) {
                            bleCallback.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, status, originalArgument);
                        } else if (bleCallback.hashCode() == callbackId) {
                            bleCallback.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, status, originalArgument);
                            break;
                        }
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onDescriptorReadTimeout(Integer taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
            synchronized (mBLEConnection) {

                Integer callbackId;
                if (argument.containsKey(KEY_CALLBACK_ID)) {
                    callbackId = argument.getInt(KEY_CALLBACK_ID);
                } else {
                    callbackId = null;
                }
                Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        if (callbackId == null) {
                            bleCallback.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, timeout, originalArgument);
                        } else if (bleCallback.hashCode() == callbackId) {
                            bleCallback.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, timeout, originalArgument);
                            break;
                        }
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onDescriptorWriteSuccess(Integer taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {
            synchronized (mBLEConnection) {

                Integer callbackId;
                if (argument.containsKey(KEY_CALLBACK_ID)) {
                    callbackId = argument.getInt(KEY_CALLBACK_ID);
                } else {
                    callbackId = null;
                }
                Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        if (callbackId == null) {
                            bleCallback.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, values, originalArgument);
                        } else if (bleCallback.hashCode() == callbackId) {
                            bleCallback.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, values, originalArgument);
                            break;
                        }
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onDescriptorWriteFailed(Integer taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {
            synchronized (mBLEConnection) {

                Integer callbackId;
                if (argument.containsKey(KEY_CALLBACK_ID)) {
                    callbackId = argument.getInt(KEY_CALLBACK_ID);
                } else {
                    callbackId = null;
                }
                Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        if (callbackId == null) {
                            bleCallback.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, status, originalArgument);
                        } else if (bleCallback.hashCode() == callbackId) {
                            bleCallback.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, status, originalArgument);
                            break;
                        }
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
                }
                mBLEConnection.notifyAll();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onDescriptorWriteTimeout(Integer taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
            synchronized (mBLEConnection) {

                Integer callbackId;
                if (argument.containsKey(KEY_CALLBACK_ID)) {
                    callbackId = argument.getInt(KEY_CALLBACK_ID);
                } else {
                    callbackId = null;
                }
                Bundle originalArgument = argument.getBundle(KEY_WRAPPED_ARGUMENT);

                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        if (callbackId == null) {
                            bleCallback.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, timeout, originalArgument);
                        } else if (bleCallback.hashCode() == callbackId) {
                            bleCallback.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, characteristicUUID, descriptorUUID, timeout, originalArgument);
                            break;
                        }
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
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
                for (BLECallback bleCallback : mBLEConnection.mAttachedBLECallbackSet) {
                    try {
                        bleCallback.onCharacteristicNotified(bluetoothDevice, serviceUUID, characteristicUUID, values);
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
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
     * {@link DistributionBLECallback} instance
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
     */
    public BLEConnection(Context context, BluetoothDevice bluetoothDevice) {
        mContext = context.getApplicationContext();
        mBluetoothDevice = bluetoothDevice;
        mDistributionBLECallback = new DistributionBLECallback(this);
    }

    /**
     * attach callback
     *
     * @param callback {@link BLECallback}
     */
    public synchronized void attach(BLECallback callback) {
        mAttachedBLECallbackSet.add(callback);
    }

    /**
     * detach callback
     *
     * @param callback {@link BLECallback}
     */
    public synchronized void detach(BLECallback callback) {
        mAttachedBLECallbackSet.remove(callback);
    }

    /**
     * check target callback is attached
     *
     * @param callback target callback
     * @return {@code true}:attached, {@code false}:not attached
     */
    public synchronized boolean isAttached(BLECallback callback) {
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
    public Integer connect(long timeout) {
        return connect(false, timeout, null, null);
    }

    /**
     * @see #connect(boolean, long, Bundle, BLECallback)
     */
    public Integer connect(long timeout, Bundle argument) {
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
    public synchronized Integer connect(boolean needMtuSetting, long timeout, Bundle argument, BLECallback bleCallback) {
        Integer taskId = null;
        if (mBluetoothGatt == null) {
            start();

            ConnectTask task = new ConnectTask(this, mTaskHandler, needMtuSetting, timeout, wrapArgument(argument, bleCallback));
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
    public synchronized Integer quit(Bundle argument, BLECallback bleCallback) {
        Integer taskId = null;
        if (mBluetoothGatt != null) {
            mTaskHandler.clearTask();

            DisconnectTask task = new DisconnectTask(this, mBluetoothGatt, BLEConstants.ErrorCodes.UNKNOWN, wrapArgument(argument, bleCallback));
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
    public synchronized void cancelTask(Integer taskId) {
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
    public synchronized void addTask(AbstractBLETask task) {
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
    public synchronized void onConnected(int taskId, BluetoothGatt bluetoothGatt, Bundle argument) {
        if (mBluetoothGatt == null) {
            mBluetoothGatt = bluetoothGatt;

            mDistributionBLECallback.onBLEConnected(taskId, mBluetoothDevice, argument);
        }
    }

    /**
     * Callback at {@link ConnectTask} failed
     *
     * @param taskId   task id
     * @param status   one of {@link BLEConnection#onConnectionStateChange(BluetoothGatt, int, int)} 2nd parameter, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}
     * @param argument callback argument
     */
    public synchronized void onConnectFailed(int taskId, int status, Bundle argument) {
        if (mTaskHandler != null) {
            mTaskHandler.quit();
            mTaskHandler = null;

            mDistributionBLECallback.onBLEConnectFailed(taskId, mBluetoothDevice, status, argument);
        }
    }

    /**
     * Callback at {@link ConnectTask} timeout
     *
     * @param taskId   task id
     * @param argument callback argument
     */
    public synchronized void onConnectTimeout(int taskId, Bundle argument) {
        if (mTaskHandler != null) {
            mTaskHandler.quit();
            mTaskHandler = null;

            mDistributionBLECallback.onBLEConnectTimeout(taskId, mBluetoothDevice, argument);
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
    public synchronized void onDisconnected(int taskId, BluetoothGatt bluetoothGatt, int status, Bundle argument) {
        if (bluetoothGatt == mBluetoothGatt) {
            mBluetoothGatt = null;
            if (mTaskHandler != null) {
                mTaskHandler.quit();
                mTaskHandler = null;
            }
            mNotificationSet.clear();

            mDistributionBLECallback.onBLEDisconnected(taskId, mBluetoothDevice, status, argument);
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
                        DisconnectTask task = new DisconnectTask(this, gatt, status, null);
                        mTaskHandler.addTask(task);
                    }
                }
            }

            if (BluetoothGatt.STATE_DISCONNECTED == newState) {
                // disconnected

                // add disconnect task
                DisconnectTask task = new DisconnectTask(this, gatt, status, null);
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
                Message message = ConnectTask.createServiceDiscovered(gatt);
                mTaskHandler.sendProcessingMessage(message);
            } else {
                // service discover failed

                // add disconnect task
                DisconnectTask task = new DisconnectTask(this, gatt, status, null);
                mTaskHandler.addTask(task);
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
                for (BLECallback callback : mAttachedBLECallbackSet) {
                    try {
                        callback.onCharacteristicNotified(mBluetoothDevice, characteristic.getService().getUuid(), uuid, characteristic.getValue());
                    } catch (Exception e) {
                        BLELogUtils.stackLog(e);
                    }
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
                DisconnectTask task = new DisconnectTask(this, gatt, status, null);
                mTaskHandler.addTask(task);
            }
        }
    }

    /**
     * @see #createReadCharacteristicTask(UUID, UUID, long, Bundle, BLECallback)
     */
    public Integer createReadCharacteristicTask(UUID serviceUUID, UUID characteristicUUID, long timeout) {
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
    public synchronized Integer createReadCharacteristicTask(UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument, BLECallback bleCallback) {
        Integer taskId = null;
        BluetoothGatt bluetoothGatt = mBluetoothGatt;
        if (bluetoothGatt != null) {
            ReadCharacteristicTask task = new ReadCharacteristicTask(this, bluetoothGatt, mTaskHandler, serviceUUID, characteristicUUID, timeout, wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * @see #createWriteCharacteristicTask(UUID, UUID, ByteArrayInterface, int, long, Bundle, BLECallback)
     */
    public Integer createWriteCharacteristicTask(UUID serviceUUID, UUID characteristicUUID, ByteArrayInterface byteArrayInterface, long timeout) {
        return createWriteCharacteristicTask(serviceUUID, characteristicUUID, byteArrayInterface, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, timeout, null, null);
    }

    /**
     * @see #createWriteCharacteristicTask(UUID, UUID, ByteArrayInterface, int, long, Bundle, BLECallback)
     */
    public Integer createWriteCharacteristicTask(UUID serviceUUID, UUID characteristicUUID, ByteArrayInterface byteArrayInterface, int writeType, long timeout) {
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
    public synchronized Integer createWriteCharacteristicTask(UUID serviceUUID, UUID characteristicUUID, ByteArrayInterface byteArrayInterface, int writeType, long timeout, Bundle argument, BLECallback bleCallback) {
        Integer taskId = null;
        if (mBluetoothGatt != null) {
            WriteCharacteristicTask task = new WriteCharacteristicTask(this, mBluetoothGatt, mTaskHandler, serviceUUID, characteristicUUID, byteArrayInterface, writeType, timeout, wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * @see #createReadDescriptorTask(UUID, UUID, UUID, long, Bundle, BLECallback)
     */
    public Integer createReadDescriptorTask(UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout) {
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
    public synchronized Integer createReadDescriptorTask(UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument, BLECallback bleCallback) {
        Integer taskId = null;
        if (mBluetoothGatt != null) {
            ReadDescriptorTask task = new ReadDescriptorTask(this, mBluetoothGatt, mTaskHandler, serviceUUID, characteristicUUID, descriptorUUID, timeout, wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * @see #createWriteDescriptorTask(UUID, UUID, UUID, ByteArrayInterface, long, Bundle, BLECallback)
     */
    public Integer createWriteDescriptorTask(UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, ByteArrayInterface byteArrayInterface, long timeout) {
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
    public synchronized Integer createWriteDescriptorTask(UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, ByteArrayInterface byteArrayInterface, long timeout, Bundle argument, BLECallback bleCallback) {
        Integer taskId = null;
        if (mBluetoothGatt != null) {
            WriteDescriptorTask task = new WriteDescriptorTask(this, mBluetoothGatt, mTaskHandler, serviceUUID, characteristicUUID, descriptorUUID, byteArrayInterface, timeout, wrapArgument(argument, bleCallback));
            mTaskHandler.addTask(task);
            taskId = task.getTaskId();
        }
        return taskId;
    }

    /**
     * wrap original argument
     *
     * @param argument    original argument
     * @param bleCallback callback instance for get callback id
     * @return wrapped argument(original argument and callback id)
     */
    public Bundle wrapArgument(Bundle argument, BLECallback bleCallback) {
        Bundle wrap = new Bundle();
        if (bleCallback != null) {
            wrap.putInt(KEY_CALLBACK_ID, bleCallback.hashCode());
        }
        if (argument != null) {
            wrap.putBundle(KEY_WRAPPED_ARGUMENT, argument);
        }
        return wrap;
    }

}
