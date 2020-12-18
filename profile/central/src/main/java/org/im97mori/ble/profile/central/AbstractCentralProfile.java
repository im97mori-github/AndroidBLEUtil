package org.im97mori.ble.profile.central;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConnectionHolder;
import org.im97mori.ble.TaskHandler;
import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallbackInterface;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.task.ConnectTask;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Core Central Profile
 */
@SuppressLint("MissingPermission")
public abstract class AbstractCentralProfile implements FilteredScanCallbackInterface, BLECallback {

    /**
     * {@link Context} instance
     */
    protected final Context mContext;

    /**
     * {@link ProfileCallback} instance
     */
    protected final ProfileCallback mProfileCallback;

    /**
     * {@link TaskHandler} instance for {@link ScanTask}, {@link BondTask} or non-{@link BLEConnection} controlled task
     */
    protected TaskHandler mTaskHandler;

    /**
     * current connect target {@link BluetoothDevice} instance
     */
    protected BluetoothDevice mCurrentBluetoothDevice;

    /**
     * current {@link BLEConnection} instance
     *
     * @see #mCurrentBluetoothDevice
     */
    protected BLEConnection mBLEConnection;

    /**
     * @param context         {@link Context} instance
     * @param profileCallback {@link ProfileCallback} instance
     */
    public AbstractCentralProfile(@NonNull Context context, @NonNull ProfileCallback profileCallback) {
        mContext = context;
        mProfileCallback = profileCallback;
    }

    /**
     * get this bluetooth profile's {@link BondedDeviceDatabaseHelper}
     *
     * @return this bluetooth profile's {@link BondedDeviceDatabaseHelper} or {@code null} if profile dont need bond
     */
    @Nullable
    public abstract BondedDeviceDatabaseHelper getDatabaseHelper();

    /**
     * @see BondedDeviceDatabaseHelper#addHistory(BluetoothDevice)
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public Long addHistory(@NonNull BluetoothDevice bluetoothDevice) {
        Long result = null;
        BondedDeviceDatabaseHelper bondedDeviceDatabaseHelper = getDatabaseHelper();
        if (bondedDeviceDatabaseHelper != null) {
            result = bondedDeviceDatabaseHelper.addHistory(bluetoothDevice);
        }
        return result;
    }

    /**
     * @see BondedDeviceDatabaseHelper#removeHistory(BluetoothDevice)
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public Boolean removeHistory(@NonNull BluetoothDevice bluetoothDevice) {
        Boolean result = null;
        BondedDeviceDatabaseHelper bondedDeviceDatabaseHelper = getDatabaseHelper();
        if (bondedDeviceDatabaseHelper != null) {
            result = bondedDeviceDatabaseHelper.removeHistory(bluetoothDevice);
        }
        return result;
    }

    /**
     * @see BondedDeviceDatabaseHelper#clearHistory()
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void clearHistory() {
        BondedDeviceDatabaseHelper bondedDeviceDatabaseHelper = getDatabaseHelper();
        if (bondedDeviceDatabaseHelper != null) {
            bondedDeviceDatabaseHelper.clearHistory();
        }
    }

    /**
     * @see BondedDeviceDatabaseHelper#syncBondedDevice()
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void syncBondedDevice() {
        BondedDeviceDatabaseHelper bondedDeviceDatabaseHelper = getDatabaseHelper();
        if (bondedDeviceDatabaseHelper != null) {
            bondedDeviceDatabaseHelper.syncBondedDevice();
        }
    }

    /**
     * @see BondedDeviceDatabaseHelper#getBondedDevices()
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    public synchronized Set<BluetoothDevice> getBondedDevices() {
        Set<BluetoothDevice> bondedDeviesSet = null;
        BondedDeviceDatabaseHelper bondedDeviceDatabaseHelper = getDatabaseHelper();
        if (bondedDeviceDatabaseHelper != null) {
            bondedDeviesSet = bondedDeviceDatabaseHelper.getBondedDevices();
        }
        return bondedDeviesSet;
    }

    /**
     * Start task handling
     * <p>
     * used for scan or bond task
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
     * check connection status
     *
     * @return {@code true}:{@link BLEConnection} has connected {@link BluetoothGatt}, {@code false}:dont have connected {@link BluetoothGatt}
     */
    public synchronized boolean isConnected() {
        return mBLEConnection != null && mBLEConnection.isConnected();
    }

    /**
     * connect to target {@link BluetoothDevice}(reuse {@link BLEConnection} instance on {@link BLEConnectionHolder})
     *
     * @param bluetoothDevice connect target {@link BluetoothDevice}
     * @return task id. if {@code null} returned, task was not registed
     * @see #createServices()
     */
    public synchronized Integer connect(@NonNull BluetoothDevice bluetoothDevice) {
        Integer taskId = null;

        if (mCurrentBluetoothDevice == null) {
            mCurrentBluetoothDevice = bluetoothDevice;
            mBLEConnection = BLEConnectionHolder.getInstance(mCurrentBluetoothDevice);
            if (mBLEConnection == null) {
                mBLEConnection = new BLEConnection(mContext, mCurrentBluetoothDevice, null);
                BLEConnectionHolder.addInstance(mBLEConnection, false);
            }
            mBLEConnection.start();
            mBLEConnection.attach(this);
            mBLEConnection.attach(mProfileCallback);

            createServices();

            if (!isConnected()) {
                taskId = mBLEConnection.connect(ConnectTask.TIMEOUT_MILLIS);
            }
        }
        return taskId;
    }

    /**
     * disconnect(keep {@link BLEConnection} instance on {@link BLEConnectionHolder})
     */
    public synchronized void disconnect() {
        if (mBLEConnection != null) {
            mBLEConnection.detach(this);
            mBLEConnection.detach(mProfileCallback);
            mBLEConnection = null;
        }
        mCurrentBluetoothDevice = null;
    }

    /**
     * create {@link org.im97mori.ble.service.central.AbstractCentralService} for this profile
     *
     * @see #connect(BluetoothDevice)
     */
    protected abstract void createServices();

    /**
     * <p>
     * Disconnect and clear all task
     * <p>
     * if already disconnect, do not anything
     * </p>
     */
    public synchronized void quit() {
        if (mTaskHandler != null) {
            mTaskHandler.quit();
            mTaskHandler = null;
        }
        disconnect();
    }

    /**
     * get current connected or connecting {@link BluetoothDevice}
     *
     * @return current connected or connecting {@link BluetoothDevice} or {@code null}(not connected or connecting)
     */
    @Nullable
    public BluetoothDevice getCurrentBluetoothDevice() {
        return mCurrentBluetoothDevice;
    }

    /**
     * Create scan task
     *
     * @param filteredScanCallback profile specific filter {@link FilteredScanCallback} instance
     * @param timeout              timeout(millis)
     * @param argument             callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    public synchronized Integer scanDevice(@NonNull FilteredScanCallback filteredScanCallback
            , long timeout
            , @Nullable Bundle argument) {
        Integer taskId = null;
        if (mTaskHandler != null) {
            ScanTask scanTask = new ScanTask(mTaskHandler, filteredScanCallback, mProfileCallback, timeout, argument);
            taskId = scanTask.getTaskId();
            mTaskHandler.addTask(scanTask);
        }
        return taskId;
    }

    /**
     * @param bluetoothDevice bond target {@link BluetoothDevice} instance
     * @param timeout         timeout(millis)
     * @param argument        callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    public synchronized Integer bondDevice(@NonNull BluetoothDevice bluetoothDevice
            , long timeout
            , @Nullable Bundle argument) {
        Integer taskId = null;
        if (mTaskHandler != null && BluetoothDevice.BOND_NONE == bluetoothDevice.getBondState()) {
            BondTask bondTask = new BondTask(mContext, mTaskHandler, new BondStateReceiver(this, bluetoothDevice), mProfileCallback, bluetoothDevice, timeout, argument);
            taskId = bondTask.getTaskId();
            mTaskHandler.addTask(bondTask);
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public synchronized void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {
        if (mTaskHandler != null) {
            mTaskHandler.sendProcessingMessage(ScanTask.createDeviceFoundMessage(result));
        }
    }

    /**
     * {@inheritDoc}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public synchronized void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {
        if (mTaskHandler != null) {
            mTaskHandler.sendProcessingMessage(ScanTask.createDeviceFoundMessage(results));
        }
    }

    /**
     * {@inheritDoc}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public synchronized void onScanFailed(int errorCode) {
        if (mTaskHandler != null) {
            mTaskHandler.sendProcessingMessage(ScanTask.createDeviceScanErrorMessage(errorCode));
        }
    }

    /**
     * Bond success callback
     *
     * @param bluetoothDevice bonded {@link BluetoothDevice}
     * @see BondStateReceiver
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public synchronized void onBondSuccess(@NonNull BluetoothDevice bluetoothDevice) {
        if (mTaskHandler != null) {
            mTaskHandler.sendProcessingMessage(BondTask.createBondSuccessMessage(bluetoothDevice));
        }
    }

    /**
     * Bond error callback
     *
     * @param bluetoothDevice bond error {@link BluetoothDevice}
     * @see BondStateReceiver
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public synchronized void onBondFailed(@NonNull BluetoothDevice bluetoothDevice) {
        if (mTaskHandler != null) {
            mTaskHandler.sendProcessingMessage(BondTask.createBondErrorMessage(bluetoothDevice));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEConnectTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (bluetoothDevice.equals(mCurrentBluetoothDevice)) {
            mCurrentBluetoothDevice = null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDiscoverServiceFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDiscoverServiceTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onRequestMtuSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int mtu, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onRequestMtuFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onRequestMtuTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onReadPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onReadPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onReadPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onSetPreferredPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, int phyOptions, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onSetPreferredPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onSetPreferredPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onReadRemoteRssiSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int rssi, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onReadRemoteRssiFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onReadRemoteRssiTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBeginReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBeginReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onExecuteReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onExecuteReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onExecuteReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onAbortReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onAbortReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onAbortReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

}
