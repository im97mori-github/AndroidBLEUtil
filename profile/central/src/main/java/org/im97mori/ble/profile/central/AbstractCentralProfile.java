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
import org.im97mori.ble.advertising.filter.FilteredLeScanCallback;
import org.im97mori.ble.advertising.filter.FilteredLeScanCallbackInterface;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallbackInterface;
import org.im97mori.ble.characteristic.u2a00.DeviceName;
import org.im97mori.ble.characteristic.u2a01.Appearance;
import org.im97mori.ble.characteristic.u2a02.PeripheralPrivacyFlag;
import org.im97mori.ble.characteristic.u2a03.ReconnectionAddress;
import org.im97mori.ble.characteristic.u2b29.ClientSupportedFeatures;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.BondTask;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.service.gap.central.GenericAttributeService;
import org.im97mori.ble.service.gatt.central.GenericAccessService;
import org.im97mori.ble.task.ConnectTask;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Core Central Profile
 */
@SuppressLint("MissingPermission")
public abstract class AbstractCentralProfile implements FilteredScanCallbackInterface, FilteredLeScanCallbackInterface, BLECallback {

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
     * {@link GenericAccessService} instance
     */
    protected GenericAccessService mGenericAccessService;

    /**
     * {@link GenericAttributeService} instance
     */
    protected GenericAttributeService mGenericAttributeService;

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
    public void clearHistory() {
        BondedDeviceDatabaseHelper bondedDeviceDatabaseHelper = getDatabaseHelper();
        if (bondedDeviceDatabaseHelper != null) {
            bondedDeviceDatabaseHelper.clearHistory();
        }
    }

    /**
     * @see BondedDeviceDatabaseHelper#syncBondedDevice()
     */
    public void syncBondedDevice() {
        BondedDeviceDatabaseHelper bondedDeviceDatabaseHelper = getDatabaseHelper();
        if (bondedDeviceDatabaseHelper != null) {
            bondedDeviceDatabaseHelper.syncBondedDevice();
        }
    }

    /**
     * @see BondedDeviceDatabaseHelper#getBondedDevices()
     */
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
    protected void createServices() {
        if (mGenericAccessService == null) {
            mGenericAccessService = new GenericAccessService(mBLEConnection, mProfileCallback, null);
        }
        if (mGenericAttributeService == null) {
            mGenericAttributeService = new GenericAttributeService(mBLEConnection, mProfileCallback, null);
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
        if (mTaskHandler != null) {
            mTaskHandler.quit();
            mTaskHandler = null;
        }
        disconnect();
        mGenericAccessService = null;
        mGenericAttributeService = null;
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
     * find Profile device
     *
     * @param argument callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public synchronized Integer findDevices(@Nullable Bundle argument) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return scanDevice(createFilteredScanCallback(), ScanTask.TIMEOUT_MILLIS, argument);
        } else {
            return scanDevice(createFilteredLeScanCallback(), ScanTask.TIMEOUT_MILLIS, argument);
        }
    }

    /**
     * create Profile specific {@link FilteredScanCallback} instance
     * @return Profile specific {@link FilteredScanCallback} instance
     */
    @NonNull
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    abstract protected FilteredScanCallback createFilteredScanCallback();

    /**
     * create Profile specific {@link FilteredLeScanCallback} instance
     * @return Profile specific {@link FilteredLeScanCallback} instance
     */
    @NonNull
    abstract protected FilteredLeScanCallback createFilteredLeScanCallback();

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
            ScanTask scanTask = new ScanTask(mContext, mTaskHandler, filteredScanCallback, mProfileCallback, timeout, argument);
            taskId = scanTask.getTaskId();
            mTaskHandler.addTask(scanTask);
        }
        return taskId;
    }

    /**
     * Create scan task
     *
     * @param filteredLeScanCallback profile specific filter {@link FilteredLeScanCallback} instance
     * @param timeout                timeout(millis)
     * @param argument               callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public synchronized Integer scanDevice(@NonNull FilteredLeScanCallback filteredLeScanCallback
            , long timeout
            , @Nullable Bundle argument) {
        Integer taskId = null;
        if (mTaskHandler != null) {
            ScanTask scanTask = new ScanTask(mContext, mTaskHandler, filteredLeScanCallback, mProfileCallback, timeout, argument);
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
    @Override
    public void onFilteredLeScan(@NonNull BluetoothDevice device, int rssi, @NonNull byte[] scanRecord, @NonNull AdvertisingDataParser.AdvertisingDataParseResult result) {
        if (mTaskHandler != null) {
            mTaskHandler.sendProcessingMessage(ScanTask.createDeviceFoundMessage(device));
        }
    }

    /**
     * {@inheritDoc}
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public synchronized void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {
        if (mTaskHandler != null) {
            mTaskHandler.sendProcessingMessage(ScanTask.createDeviceFoundMessage(results.toArray(new ScanResult[0])));
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
    public void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBLEConnectTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (bluetoothDevice.equals(mCurrentBluetoothDevice)) {
            mCurrentBluetoothDevice = null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDiscoverServiceFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDiscoverServiceTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onRequestMtuSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int mtu, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onRequestMtuFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onRequestMtuTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
    public void onReadPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSetPreferredPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, int phyOptions, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSetPreferredPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSetPreferredPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadRemoteRssiSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int rssi, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadRemoteRssiFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReadRemoteRssiTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBeginReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBeginReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onExecuteReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onExecuteReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onExecuteReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAbortReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAbortReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAbortReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSetNotificationSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, boolean notificationStatus, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onSetNotificationFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, boolean notificationStatus, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * @see GenericAccessService#isDeviceNameCharacteristicWritable()
     */
    @Nullable
    public Boolean isDeviceNameCharacteristicWritable() {
        Boolean result = null;
        if (mGenericAccessService != null) {
            result = mGenericAccessService.isDeviceNameCharacteristicWritable();
        }
        return result;
    }

    /**
     * @see GenericAccessService#isAppearanceCharacteristicWritable()
     */
    @Nullable
    public Boolean isAppearanceCharacteristicWritable() {
        Boolean result = null;
        if (mGenericAccessService != null) {
            result = mGenericAccessService.isAppearanceCharacteristicWritable();
        }
        return result;
    }

    /**
     * @see GenericAccessService#isPeripheralPreferredConnectionParametersCharacteristicSupported()
     */
    @Nullable
    public Boolean isPeripheralPreferredConnectionParametersCharacteristicSupported() {
        Boolean result = null;
        if (mGenericAccessService != null) {
            result = mGenericAccessService.isPeripheralPreferredConnectionParametersCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see GenericAccessService#isCentralAddressResolutionCharacteristicSupported()
     */
    @Nullable
    public Boolean isCentralAddressResolutionCharacteristicSupported() {
        Boolean result = null;
        if (mGenericAccessService != null) {
            result = mGenericAccessService.isCentralAddressResolutionCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see GenericAccessService#isResolvablePrivateAddressOnlyCharacteristicSupported()
     */
    @Nullable
    public Boolean isResolvablePrivateAddressOnlyCharacteristicSupported() {
        Boolean result = null;
        if (mGenericAccessService != null) {
            result = mGenericAccessService.isResolvablePrivateAddressOnlyCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see GenericAccessService#isReconnectionAddressCharacteristicSupported()
     */
    @Nullable
    public Boolean isReconnectionAddressCharacteristicSupported() {
        Boolean result = null;
        if (mGenericAccessService != null) {
            result = mGenericAccessService.isReconnectionAddressCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see GenericAccessService#isPeripheralPrivacyFlagCharacteristicSupported()
     */
    @Nullable
    public Boolean isPeripheralPrivacyFlagCharacteristicSupported() {
        Boolean result = null;
        if (mGenericAccessService != null) {
            result = mGenericAccessService.isPeripheralPrivacyFlagCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see GenericAccessService#isPeripheralPrivacyFlagCharacteristicWritable()
     */
    public Boolean isPeripheralPrivacyFlagCharacteristicWritable() {
        Boolean result = null;
        if (mGenericAccessService != null) {
            result = mGenericAccessService.isPeripheralPrivacyFlagCharacteristicWritable();
        }
        return result;
    }

    /**
     * @see GenericAttributeService#isServiceChangedCharacteristicSupported()
     */
    @Nullable
    public Boolean isServiceChangedCharacteristicSupported() {
        Boolean result = null;
        if (mGenericAttributeService != null) {
            result = mGenericAttributeService.isServiceChangedCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see GenericAttributeService#isClientSupportedFeaturesCharacteristicSupported()
     */
    @Nullable
    public Boolean isClientSupportedFeaturesCharacteristicSupported() {
        Boolean result = null;
        if (mGenericAttributeService != null) {
            result = mGenericAttributeService.isClientSupportedFeaturesCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see GenericAttributeService#isDatabaseHashCharacteristicSupported()
     */
    @Nullable
    public Boolean isDatabaseHashCharacteristicSupported() {
        Boolean result = null;
        if (mGenericAttributeService != null) {
            result = mGenericAttributeService.isDatabaseHashCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see GenericAccessService#getDeviceName()
     */
    @Nullable
    public synchronized Integer getDeviceName() {
        Integer taskId = null;
        if (mGenericAccessService != null) {
            taskId = mGenericAccessService.getDeviceName();
        }
        return taskId;
    }

    /**
     * @see GenericAccessService#setDeviceName(DeviceName)
     */
    @Nullable
    public synchronized Integer setDeviceName(@NonNull DeviceName deviceName) {
        Integer taskId = null;
        if (mGenericAccessService != null) {
            taskId = mGenericAccessService.setDeviceName(deviceName);
        }
        return taskId;
    }

    /**
     * @see GenericAccessService#getAppearance()
     */
    @Nullable
    public synchronized Integer getAppearance() {
        Integer taskId = null;
        if (mGenericAccessService != null) {
            taskId = mGenericAccessService.getAppearance();
        }
        return taskId;
    }

    /**
     * @see GenericAccessService#setAppearance(Appearance)
     */
    @Nullable
    public synchronized Integer setAppearance(@NonNull Appearance appearance) {
        Integer taskId = null;
        if (mGenericAccessService != null) {
            taskId = mGenericAccessService.setAppearance(appearance);
        }
        return taskId;
    }

    /**
     * @see GenericAccessService#getPeripheralPreferredConnectionParameters()
     */
    @Nullable
    public synchronized Integer getPeripheralPreferredConnectionParameters() {
        Integer taskId = null;
        if (mGenericAccessService != null) {
            taskId = mGenericAccessService.getPeripheralPreferredConnectionParameters();
        }
        return taskId;
    }

    /**
     * @see GenericAccessService#getCentralAddressResolutionParameters()
     */
    @Nullable
    public synchronized Integer getCentralAddressResolutionParameters() {
        Integer taskId = null;
        if (mGenericAccessService != null) {
            taskId = mGenericAccessService.getCentralAddressResolutionParameters();
        }
        return taskId;
    }

    /**
     * @see GenericAccessService#getResolvablePrivateAddressOnly()
     */
    @Nullable
    public synchronized Integer getResolvablePrivateAddressOnly() {
        Integer taskId = null;
        if (mGenericAccessService != null) {
            taskId = mGenericAccessService.getResolvablePrivateAddressOnly();
        }
        return taskId;
    }

    /**
     * @see GenericAccessService#setReconnectionAddress(ReconnectionAddress)
     */
    @Nullable
    public synchronized Integer setReconnectionAddress(@NonNull ReconnectionAddress reconnectionAddress) {
        Integer taskId = null;
        if (mGenericAccessService != null) {
            taskId = mGenericAccessService.setReconnectionAddress(reconnectionAddress);
        }
        return taskId;
    }

    /**
     * @see GenericAccessService#getPeripheralPrivacyFlag()
     */
    @Nullable
    public synchronized Integer getPeripheralPrivacyFlag() {
        Integer taskId = null;
        if (mGenericAccessService != null) {
            taskId = mGenericAccessService.getPeripheralPrivacyFlag();
        }
        return taskId;
    }

    /**
     * @see GenericAccessService#setPeripheralPrivacyFlag(PeripheralPrivacyFlag)
     */
    @Nullable
    public synchronized Integer setPeripheralPrivacyFlag(@NonNull PeripheralPrivacyFlag peripheralPrivacyFlag) {
        Integer taskId = null;
        if (mGenericAccessService != null) {
            taskId = mGenericAccessService.setPeripheralPrivacyFlag(peripheralPrivacyFlag);
        }
        return taskId;
    }

    /**
     * @see GenericAttributeService#getServiceChangedClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getServiceChangedClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mGenericAttributeService != null) {
            taskId = mGenericAttributeService.getServiceChangedClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see GenericAttributeService#startServiceChangedIndication()
     */
    @Nullable
    public synchronized Integer startServiceChangedIndication() {
        Integer taskId = null;
        if (mGenericAttributeService != null) {
            taskId = mGenericAttributeService.startServiceChangedIndication();
        }
        return taskId;
    }

    /**
     * @see GenericAttributeService#stopServiceChangedIndication()
     */
    @Nullable
    public synchronized Integer stopServiceChangedIndication() {
        Integer taskId = null;
        if (mGenericAttributeService != null) {
            taskId = mGenericAttributeService.stopServiceChangedIndication();
        }
        return taskId;
    }

    /**
     * @see GenericAttributeService#getClientSupportedFeatures()
     */
    @Nullable
    public synchronized Integer getClientSupportedFeatures() {
        Integer taskId = null;
        if (mGenericAttributeService != null) {
            taskId = mGenericAttributeService.getClientSupportedFeatures();
        }
        return taskId;
    }

    /**
     * @see GenericAttributeService#setClientSupportedFeatures(ClientSupportedFeatures)
     */
    @Nullable
    public synchronized Integer setClientSupportedFeatures(@NonNull ClientSupportedFeatures clientSupportedFeatures) {
        Integer taskId = null;
        if (mGenericAttributeService != null) {
            taskId = mGenericAttributeService.setClientSupportedFeatures(clientSupportedFeatures);
        }
        return taskId;
    }

    /**
     * @see GenericAttributeService#getDatabaseHash()
     */
    @Nullable
    public synchronized Integer getDatabaseHash() {
        Integer taskId = null;
        if (mGenericAttributeService != null) {
            taskId = mGenericAttributeService.getDatabaseHash();
        }
        return taskId;
    }

}
