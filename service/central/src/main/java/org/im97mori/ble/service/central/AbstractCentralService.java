package org.im97mori.ble.service.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.task.ConnectTask;
import org.im97mori.ble.task.DiscoverServiceTask;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Core Central Service
 */
public abstract class AbstractCentralService implements BLECallback {

    /**
     * KEY:STATUS
     */
    protected static final String KEY_STATUS = "KEY_STATUS";

    /**
     * STATUS:START
     */
    protected static final int STATUS_START = 0;

    /**
     * STATUS:STOP
     */
    protected static final int STATUS_STOP = 1;

    /**
     * {@link BLEConnection} instance
     */
    protected final BLEConnection mBLEConnection;

    /**
     * {@link BLECallback} instance(optional)
     */
    protected final BLECallback mBLECallback;

    /**
     * Service Discovered flag
     * {@code true}:{@link #onDiscoverServiceSuccess} callbacked, {@code false}] not callbacked
     */
    protected boolean mIsServiceDiscovered = false;

    /**
     * availabled characteristics for check non mandatory characteristics
     */
    protected final Set<UUID> mAvailableCharacteristicSet = new HashSet<>();

    /**
     * @param bleConnection {@link BLEConnection} instance{@link BLEConnection} instance
     * @param bleCallback   {@link BLECallback} instance(optional)
     */
    public AbstractCentralService(@NonNull BLEConnection bleConnection, @Nullable BLECallback bleCallback) {
        mBLEConnection = bleConnection;
        mBLECallback = bleCallback;
        mBLEConnection.attach(this);
    }

    /**
     * check connection state
     *
     * @return {@code true}:service ready(connected and service discovered), {@code false}:service not ready
     */
    public synchronized boolean isStarted() {
        return mBLEConnection.isConnected() && mIsServiceDiscovered;
    }

    /**
     * service start
     *
     * @return task id. if {@code null} returned, service ready
     */
    public synchronized Integer start() {
        Integer taskId = null;
        if (!isStarted()) {
            if (mBLEConnection.isConnected()) {
                taskId = mBLEConnection.createDiscoverServiceTask(DiscoverServiceTask.TIMEOUT_MILLIS, null, this);
            } else {
                taskId = mBLEConnection.connect(ConnectTask.TIMEOUT_MILLIS);
            }
        }
        return taskId;
    }

    /**
     * service quit
     *
     * @return task id. if {@code null} returned, service not ready
     */
    public synchronized Integer quit() {
        Integer taskId = null;
        if (mBLEConnection.isConnected()) {
            taskId = mBLEConnection.quit();
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onBLEConnected(taskId, bluetoothDevice, argument);
        }
        mBLEConnection.createDiscoverServiceTask(DiscoverServiceTask.TIMEOUT_MILLIS, null, this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onBLEConnectFailed(taskId, bluetoothDevice, status, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEConnectTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onBLEConnectTimeout(taskId, bluetoothDevice, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mAvailableCharacteristicSet.clear();
            mIsServiceDiscovered = false;
        }
        if (mBLECallback != null) {
            mBLECallback.onBLEDisconnected(taskId, bluetoothDevice, status, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            this.mIsServiceDiscovered = true;
        }

        if (mBLECallback != null) {
            mBLECallback.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDiscoverServiceFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onDiscoverServiceFailed(taskId, bluetoothDevice, status, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDiscoverServiceTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onDiscoverServiceTimeout(taskId, bluetoothDevice, timeout, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onRequestMtuSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int mtu, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onRequestMtuSuccess(taskId, bluetoothDevice, mtu, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onRequestMtuFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onRequestMtuFailed(taskId, bluetoothDevice, status, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onRequestMtuTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onRequestMtuTimeout(taskId, bluetoothDevice, timeout, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, values, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, status, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, timeout, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, values, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, status, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, timeout, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values) {
        if (mBLECallback != null) {
            mBLECallback.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onReadPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onReadPhySuccess(taskId, bluetoothDevice, txPhy, rxPhy, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onReadPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onReadPhyFailed(taskId, bluetoothDevice, status, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onReadPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onReadPhyTimeout(taskId, bluetoothDevice, timeout, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onSetPreferredPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, int phyOptions, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onSetPreferredPhySuccess(taskId, bluetoothDevice, txPhy, rxPhy, phyOptions, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onSetPreferredPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onSetPreferredPhyFailed(taskId, bluetoothDevice, status, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onSetPreferredPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onSetPreferredPhyTimeout(taskId, bluetoothDevice, timeout, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onReadRemoteRssiSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int rssi, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onReadRemoteRssiSuccess(taskId, bluetoothDevice, rssi, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onReadRemoteRssiFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onReadRemoteRssiFailed(taskId, bluetoothDevice, status, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onReadRemoteRssiTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onReadRemoteRssiTimeout(taskId, bluetoothDevice, timeout, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBeginReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onBeginReliableWriteSuccess(taskId, bluetoothDevice, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBeginReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onBeginReliableWriteFailed(taskId, bluetoothDevice, status, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onExecuteReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onExecuteReliableWriteSuccess(taskId, bluetoothDevice, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onExecuteReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onExecuteReliableWriteFailed(taskId, bluetoothDevice, status, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onExecuteReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onExecuteReliableWriteTimeout(taskId, bluetoothDevice, timeout, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onAbortReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onAbortReliableWriteSuccess(taskId, bluetoothDevice, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onAbortReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onAbortReliableWriteFailed(taskId, bluetoothDevice, status, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onAbortReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        if (mBLECallback != null) {
            mBLECallback.onAbortReliableWriteTimeout(taskId, bluetoothDevice, timeout, argument);
        }
    }

}
