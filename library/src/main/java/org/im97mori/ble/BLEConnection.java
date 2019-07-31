package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;

import org.im97mori.ble.characteristic.AbstractCharacteristic;
import org.im97mori.ble.descriptor.AbstractDescriptor;
import org.im97mori.ble.descriptor.ClientCharacteristicConfiguration;
import org.im97mori.ble.task.ConnectTask;
import org.im97mori.ble.task.DisconnectTask;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR;

/**
 * BLE connection
 */
@SuppressWarnings({"JavadocReference", "WeakerAccess"})
public class BLEConnection extends BluetoothGattCallback {

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
    protected final BLECallback mBLECallback;

    /**
     * <p>
     * current notification status
     * <p>
     * if {@link Set#contains(Object)} return true, target UUID(characteristic) is {@link BluetoothGattDescriptor#ENABLE_NOTIFICATION_VALUE} status
     * </p>
     */
    protected final Set<UUID> mNotificationSet = Collections.synchronizedSet(new HashSet<UUID>());

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
        mBLECallback = bleCallback;
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
     * <p>
     * Connect ble
     * <p>
     * if already connected, do not anything
     * </p>
     *
     * @param timeout timeout(millis)
     */
    public synchronized void connect(long timeout) {
        if (mBluetoothGatt == null) {
            start();

            ConnectTask task = new ConnectTask(this, mTaskHandler, timeout);
            Message message = ConnectTask.createConnectMessage(task);
            mTaskHandler.addTask(task, message);
        }
    }

    /**
     * <p>
     * Disconnect and clear all task
     * <p>
     * if already disconnect, do not anything
     * </p>
     */
    public synchronized void quit() {
        if (mBluetoothGatt != null) {
            mTaskHandler.clearTask();

            DisconnectTask task = new DisconnectTask(this, mBluetoothGatt);
            Message message = DisconnectTask.createDisconnectMessage(task);
            mTaskHandler.addTask(task, message);
        }
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
     * Callback at connected and service discover successed
     *
     * @param bluetoothGatt Connected {@link BluetoothGatt}
     */
    public synchronized void onConnected(BluetoothGatt bluetoothGatt) {
        mBluetoothGatt = bluetoothGatt;
        mBLECallback.onBLEConnected(mBluetoothDevice);
    }

    /**
     * Callback at disconnected
     *
     * @param bluetoothGatt Disconnected {@link BluetoothGatt}
     */
    public synchronized void onDisconnected(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt == mBluetoothGatt) {
            mBluetoothGatt = null;
            if (mTaskHandler != null) {
                mTaskHandler.quit();
                mTaskHandler = null;
            }
            mNotificationSet.clear();
            mBLECallback.onBLEDisonnected(mBluetoothDevice);
        }
    }

    /**
     * Callback at {@link ConnectTask} timeout
     */
    public synchronized void onConnectTimeout() {
        if (mTaskHandler != null) {
            mTaskHandler.quit();
            mTaskHandler = null;
        }
        mBLECallback.onBLEConnectTimeout(mBluetoothDevice);
    }

    /**
     * check {@link BluetoothGatt} is newest one
     *
     * @param bluetoothGatt check target {@link BluetoothGatt}
     * @return {@link true}:newest one, {@link false}:not newest one
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
        return mBLECallback;
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
        if (BluetoothGatt.GATT_SUCCESS == status) {
            if (BluetoothGatt.STATE_CONNECTED == newState) {
                // connected

                // start discover services
                gatt.discoverServices();
            } else if (BluetoothGatt.STATE_DISCONNECTED == newState) {
                // disconnected

                // add disconnect task
                if (mTaskHandler != null) {
                    DisconnectTask task = new DisconnectTask(this, gatt);
                    Message message = DisconnectTask.createDisconnectMessage(task);
                    mTaskHandler.addTask(task, message);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onServicesDiscovered(BluetoothGatt gatt, int status) {
        if (BluetoothGatt.GATT_SUCCESS == status) {
            // service discover finished
            if (mTaskHandler != null) {

                // connect task finished
                Message message = ConnectTask.createConnectFinished(gatt);
                mTaskHandler.sendProcessingMessage(message);
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
            UUID uuid = characteristic.getUuid();
            if (BluetoothGatt.GATT_SUCCESS == status) {
                mTaskHandler.sendProcessingMessage(ReadCharacteristicTask.createReadCharacteristicFinishedMessage(uuid, characteristic.getValue()));
            } else {
                mTaskHandler.sendProcessingMessage(ReadCharacteristicTask.createReadCharacteristicErrorMessage(uuid, status));
            }
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
            UUID uuid = characteristic.getUuid();
            if (BluetoothGatt.GATT_SUCCESS == status) {
                mTaskHandler.sendProcessingMessage(WriteCharacteristicTask.createWriteCharacteristicFinishedMessage(uuid, characteristic.getValue()));
            } else {
                mTaskHandler.sendProcessingMessage(WriteCharacteristicTask.createWriteCharacteristicErrorMessage(uuid, status));
            }
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
                mBLECallback.onCharacteristicNotified(mBluetoothDevice, uuid, characteristic.getValue());
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
            UUID chacteristicUuid = descriptor.getCharacteristic().getUuid();
            UUID descriptorUuid = descriptor.getUuid();
            if (BluetoothGatt.GATT_SUCCESS == status) {
                if (CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR.equals(descriptorUuid)) {
                    ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptor);
                    boolean isNotification = clientCharacteristicConfiguration.isNotification() || clientCharacteristicConfiguration.isIndication();

                    // set notification status
                    if (isNotification) {
                        mNotificationSet.add(chacteristicUuid);
                    } else {
                        mNotificationSet.remove(chacteristicUuid);
                    }
                    gatt.setCharacteristicNotification(descriptor.getCharacteristic(), isNotification);
                }
                // read decriptor task finished
                mTaskHandler.sendProcessingMessage(ReadDescriptorTask.createReadDescriptorFinishedMessage(chacteristicUuid, descriptorUuid, descriptor.getValue()));
            } else {
                mTaskHandler.sendProcessingMessage(ReadDescriptorTask.createReadDescriptorErrorMessage(chacteristicUuid, descriptorUuid, status));
            }
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
            UUID chacteristicUuid = descriptor.getCharacteristic().getUuid();
            UUID descriptorUuid = descriptor.getUuid();
            if (BluetoothGatt.GATT_SUCCESS == status) {
                if (CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR.equals(descriptorUuid)) {
                    ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptor);
                    boolean isNotification = clientCharacteristicConfiguration.isNotification() || clientCharacteristicConfiguration.isIndication();

                    // set notification status
                    if (isNotification) {
                        mNotificationSet.add(chacteristicUuid);
                    } else {
                        mNotificationSet.remove(chacteristicUuid);
                    }
                    gatt.setCharacteristicNotification(descriptor.getCharacteristic(), isNotification);
                }
                // write decriptor task finished
                mTaskHandler.sendProcessingMessage(WriteDescriptorTask.createWriteDescriptorFinishedMessage(chacteristicUuid, descriptorUuid, descriptor.getValue()));
            } else {
                mTaskHandler.sendProcessingMessage(WriteDescriptorTask.createWriteDescriptorErrorMessage(chacteristicUuid, descriptorUuid, status));
            }
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
        }
    }

    /**
     * Create read characteristic task
     *
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param timeout            timeout(millis)
     */
    public void createReadCharacteristicTask(UUID serviceUUID, UUID characteristicUUID, long timeout) {
        BluetoothGatt bluetoothGatt = mBluetoothGatt;
        if (bluetoothGatt != null) {
            ReadCharacteristicTask task = new ReadCharacteristicTask(this, bluetoothGatt, mTaskHandler, serviceUUID, characteristicUUID, timeout);
            Message message = ReadCharacteristicTask.createReadCharacteristicMessage(characteristicUUID, task);
            mTaskHandler.addTask(task, message);
        }
    }

    /**
     * Create write characteristic task
     *
     * @param serviceUUID            service {@link UUID}
     * @param characteristicUUID     characteristic {@link UUID}
     * @param abstractCharacteristic write data
     * @param timeout                timeout(millis)
     */
    public void createWriteCharacteristicTask(UUID serviceUUID, UUID characteristicUUID, AbstractCharacteristic abstractCharacteristic, long timeout) {
        BluetoothGatt bluetoothGatt = mBluetoothGatt;
        if (bluetoothGatt != null) {
            WriteCharacteristicTask task = new WriteCharacteristicTask(this, bluetoothGatt, mTaskHandler, serviceUUID, characteristicUUID, abstractCharacteristic, timeout);
            Message message = WriteCharacteristicTask.createWriteCharacteristicMessage(characteristicUUID, task);
            mTaskHandler.addTask(task, message);
        }
    }

    /**
     * Create read descriptor task
     *
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor {@link UUID}
     * @param timeout            timeout(millis)
     */
    public void createReadDescriptorTask(UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout) {
        BluetoothGatt bluetoothGatt = mBluetoothGatt;
        if (bluetoothGatt != null) {
            ReadDescriptorTask task = new ReadDescriptorTask(this, bluetoothGatt, mTaskHandler, serviceUUID, characteristicUUID, descriptorUUID, timeout);
            Message message = ReadDescriptorTask.createReadDescriptorMessage(characteristicUUID, descriptorUUID, task);
            mTaskHandler.addTask(task, message);
        }
    }

    /**
     * Create write descriptor task
     *
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor {@link UUID}
     * @param abstractDescriptor write data
     * @param timeout            timeout(millis)
     */
    public void createWriteDescriptorTask(UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, AbstractDescriptor abstractDescriptor, long timeout) {
        BluetoothGatt bluetoothGatt = mBluetoothGatt;
        if (bluetoothGatt != null) {
            WriteDescriptorTask task = new WriteDescriptorTask(this, bluetoothGatt, mTaskHandler, serviceUUID, characteristicUUID, descriptorUUID, abstractDescriptor, timeout);
            Message message = WriteDescriptorTask.createWriteDescriptorMessage(characteristicUUID, descriptorUUID, task);
            mTaskHandler.addTask(task, message);
        }
    }

}
