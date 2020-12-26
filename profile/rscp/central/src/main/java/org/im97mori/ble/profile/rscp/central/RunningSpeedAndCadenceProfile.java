package org.im97mori.ble.profile.rscp.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a55.SCControlPoint;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.profile.rscp.central.db.RunningSpeedAndCadenceProfileBondedDatabaseHelper;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.rscs.central.RunningSpeedAndCadenceService;
import org.im97mori.ble.task.DiscoverServiceTask;

import java.util.List;

import static org.im97mori.ble.BLEConstants.ServiceUUID.DEVICE_INFORMATION_SERVICE;

/**
 * Running Speed and Cadence Profile for Central
 */
public class RunningSpeedAndCadenceProfile extends AbstractCentralProfile {

    /**
     * {@link RunningSpeedAndCadenceProfileCallback} instance
     */
    protected final RunningSpeedAndCadenceProfileCallback mRunningSpeedAndCadenceProfileCallback;

    /**
     * {@link RunningSpeedAndCadenceService} instance
     */
    protected RunningSpeedAndCadenceService mRunningSpeedAndCadenceService;

    /**
     * {@link DeviceInformationService} instance
     */
    protected DeviceInformationService mDeviceInformationService;

    /**
     * {@code true}:Device has Device Information Service, {@code false}:no Device information Service
     */
    private boolean mHasDeviceInformationService;

    /**
     * @param context                               {@link Context} instance
     * @param runningSpeedAndCadenceProfileCallback {@link RunningSpeedAndCadenceProfileCallback} instance
     */
    public RunningSpeedAndCadenceProfile(@NonNull Context context, @NonNull RunningSpeedAndCadenceProfileCallback runningSpeedAndCadenceProfileCallback) {
        super(context, runningSpeedAndCadenceProfileCallback);
        mRunningSpeedAndCadenceProfileCallback = runningSpeedAndCadenceProfileCallback;
    }

    /**
     * find Cycling Speed and Cadence Profile device
     *
     * @param argument callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public synchronized Integer findRunningSpeedAndCadenceProfileDevices(@Nullable Bundle argument) {
        return scanDevice(new RunningSpeedAndCadenceProfileScanCallback(this, null), ScanTask.TIMEOUT_MILLIS, argument);
    }

    /**
     * @return {@code true}:Device has Device Information Service, {@code false}:no Device information Service. if {@code null} returned, profile is not ready
     */
    @Nullable
    public synchronized Boolean hasDeviceInformationService() {
        Boolean result = null;
        if (mDeviceInformationService != null) {
            result = mHasDeviceInformationService;
        }
        return result;
    }

    /**
     * @see RunningSpeedAndCadenceService#isSensorLocationCharacteristicSupporeted()
     */
    public synchronized Boolean isSensorLocationCharacteristicSupporeted() {
        Boolean result = null;
        if (mRunningSpeedAndCadenceService != null) {
            result = mRunningSpeedAndCadenceService.isSensorLocationCharacteristicSupporeted();
        }
        return result;
    }

    /**
     * @see RunningSpeedAndCadenceService#isSCControlPointCharacteristicSupporeted()
     */
    public synchronized Boolean isSCControlPointCharacteristicSupporeted() {
        Boolean result = null;
        if (mRunningSpeedAndCadenceService != null) {
            result = mRunningSpeedAndCadenceService.isSCControlPointCharacteristicSupporeted();
        }
        return result;
    }

    /**
     * @see RunningSpeedAndCadenceService#getRSCFeature()
     */
    @Nullable
    public synchronized Integer getRSCFeature() {
        Integer taskId = null;
        if (mRunningSpeedAndCadenceService != null) {
            taskId = mRunningSpeedAndCadenceService.getRSCFeature();
        }
        return taskId;
    }

    /**
     * @see RunningSpeedAndCadenceService#getRSCMeasurementClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getRSCMeasurementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mRunningSpeedAndCadenceService != null) {
            taskId = mRunningSpeedAndCadenceService.getRSCMeasurementClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see RunningSpeedAndCadenceService#startRSCMeasurementNotification()
     */
    @Nullable
    public synchronized Integer startRSCMeasurementNotification() {
        Integer taskId = null;
        if (mRunningSpeedAndCadenceService != null) {
            taskId = mRunningSpeedAndCadenceService.startRSCMeasurementNotification();
        }
        return taskId;
    }

    /**
     * @see RunningSpeedAndCadenceService#stopRSCMeasurementNotification()
     */
    @Nullable
    public synchronized Integer stopRSCMeasurementNotification() {
        Integer taskId = null;
        if (mRunningSpeedAndCadenceService != null) {
            taskId = mRunningSpeedAndCadenceService.stopRSCMeasurementNotification();
        }
        return taskId;
    }

    /**
     * @see RunningSpeedAndCadenceService#getSensorLocation()
     */
    @Nullable
    public synchronized Integer getSensorLocation() {
        Integer taskId = null;
        if (mRunningSpeedAndCadenceService != null) {
            taskId = mRunningSpeedAndCadenceService.getSensorLocation();
        }
        return taskId;
    }

    /**
     * @see RunningSpeedAndCadenceService#setSCControlPoint(SCControlPoint)
     */
    @Nullable
    public synchronized Integer setSCControlPoint(@NonNull SCControlPoint scControlPoint) {
        Integer taskId = null;
        if (mRunningSpeedAndCadenceService != null) {
            taskId = mRunningSpeedAndCadenceService.setSCControlPoint(scControlPoint);
        }
        return taskId;
    }

    /**
     * @see RunningSpeedAndCadenceService#getSCControlPointClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getSCControlPointClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mRunningSpeedAndCadenceService != null)
            taskId = mRunningSpeedAndCadenceService.getSCControlPointClientCharacteristicConfiguration();
        return taskId;
    }

    /**
     * @see RunningSpeedAndCadenceService#startSCControlPointIndication()
     */
    @Nullable
    public synchronized Integer startSCControlPointIndication() {
        Integer taskId = null;
        if (mRunningSpeedAndCadenceService != null)
            taskId = mRunningSpeedAndCadenceService.startSCControlPointIndication();
        return taskId;
    }

    /**
     * @see RunningSpeedAndCadenceService#stopSCControlPointIndication()
     */
    @Nullable
    public synchronized Integer stopSCControlPointIndication() {
        Integer taskId = null;
        if (mRunningSpeedAndCadenceService != null)
            taskId = mRunningSpeedAndCadenceService.stopSCControlPointIndication();
        return taskId;
    }

    /**
     * @see DeviceInformationService#hasManufacturerNameString()
     */
    @Nullable
    public synchronized Boolean hasManufacturerNameString() {
        Boolean result = null;
        if (mDeviceInformationService != null) {
            result = mDeviceInformationService.hasManufacturerNameString();
        }
        return result;
    }

    /**
     * @see DeviceInformationService#hasModelNumberString()
     */
    @Nullable
    public synchronized Boolean hasModelNumberString() {
        Boolean result = null;
        if (mDeviceInformationService != null) {
            result = mDeviceInformationService.hasModelNumberString();
        }
        return result;
    }

    /**
     * @see DeviceInformationService#getManufacturerNameString()
     */
    @Nullable
    public synchronized Integer getManufacturerNameString() {
        Integer taskId = null;
        if (mDeviceInformationService != null) {
            taskId = mDeviceInformationService.getManufacturerNameString();
        }
        return taskId;
    }

    /**
     * @see DeviceInformationService#getModelNumberString()
     */
    @Nullable
    public synchronized Integer getModelNumberString() {
        Integer taskId = null;
        if (mDeviceInformationService != null) {
            taskId = mDeviceInformationService.getModelNumberString();
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return RunningSpeedAndCadenceProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * create {@link RunningSpeedAndCadenceService} and {@link DeviceInformationService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        if (mRunningSpeedAndCadenceService == null) {
            mRunningSpeedAndCadenceService = new RunningSpeedAndCadenceService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null);
        }
        if (mDeviceInformationService == null) {
            mDeviceInformationService = new DeviceInformationService(mBLEConnection, mRunningSpeedAndCadenceProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mHasDeviceInformationService = false;
        mRunningSpeedAndCadenceService = null;
        mDeviceInformationService = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        if (bluetoothDevice.equals(mCurrentBluetoothDevice)) {
            mBLEConnection.createDiscoverServiceTask(DiscoverServiceTask.TIMEOUT_MILLIS, null, this);
        }
        super.onBLEConnected(taskId, bluetoothDevice, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
        if (bluetoothDevice.equals(mCurrentBluetoothDevice)) {
            for (BluetoothGattService bluetoothGattService : serviceList) {
                if (DEVICE_INFORMATION_SERVICE.equals(bluetoothGattService.getUuid())) {
                    mHasDeviceInformationService = true;
                }
            }
        }
        super.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, argument);
    }

}
