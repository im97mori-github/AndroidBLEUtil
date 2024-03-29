package org.im97mori.ble.profile.cscp.central;

import static org.im97mori.ble.constants.ServiceUUID.DEVICE_INFORMATION_SERVICE;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.advertising.filter.FilteredLeScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a55.SCControlPoint;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.cscp.central.db.CyclingSpeedAndCadenceProfileBondedDatabaseHelper;
import org.im97mori.ble.service.cscs.central.CyclingSpeedAndCadenceService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.task.DiscoverServiceTask;

import java.util.List;

/**
 * Cycling Speed and Cadence Profile for Central
 */
public class CyclingSpeedAndCadenceProfile extends AbstractCentralProfile {

    /**
     * {@link CyclingSpeedAndCadenceProfileCallback} instance
     */
    protected final CyclingSpeedAndCadenceProfileCallback mCyclingSpeedAndCadenceProfileCallback;

    /**
     * {@link CyclingSpeedAndCadenceService} instance
     */
    protected CyclingSpeedAndCadenceService mCyclingSpeedAndCadenceService;

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
     * @param cyclingSpeedAndCadenceProfileCallback {@link CyclingSpeedAndCadenceProfileCallback} instance
     */
    public CyclingSpeedAndCadenceProfile(@NonNull Context context, @NonNull CyclingSpeedAndCadenceProfileCallback cyclingSpeedAndCadenceProfileCallback) {
        super(context, cyclingSpeedAndCadenceProfileCallback);
        mCyclingSpeedAndCadenceProfileCallback = cyclingSpeedAndCadenceProfileCallback;
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
     * @see CyclingSpeedAndCadenceService#isSensorLocationCharacteristicSupported()
     */
    public synchronized Boolean isSensorLocationCharacteristicSupported() {
        Boolean result = null;
        if (mCyclingSpeedAndCadenceService != null) {
            result = mCyclingSpeedAndCadenceService.isSensorLocationCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see CyclingSpeedAndCadenceService#isSCControlPointCharacteristicSupported()
     */
    public synchronized Boolean isSCControlPointCharacteristicSupported() {
        Boolean result = null;
        if (mCyclingSpeedAndCadenceService != null) {
            result = mCyclingSpeedAndCadenceService.isSCControlPointCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see CyclingSpeedAndCadenceService#getCSCFeature()
     */
    @Nullable
    public synchronized Integer getCSCFeature() {
        Integer taskId = null;
        if (mCyclingSpeedAndCadenceService != null) {
            taskId = mCyclingSpeedAndCadenceService.getCSCFeature();
        }
        return taskId;
    }

    /**
     * @see CyclingSpeedAndCadenceService#getCSCMeasurementClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getCSCMeasurementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mCyclingSpeedAndCadenceService != null) {
            taskId = mCyclingSpeedAndCadenceService.getCSCMeasurementClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see CyclingSpeedAndCadenceService#startCSCMeasurementNotification()
     */
    @Nullable
    public synchronized Integer startCSCMeasurementNotification() {
        Integer taskId = null;
        if (mCyclingSpeedAndCadenceService != null) {
            taskId = mCyclingSpeedAndCadenceService.startCSCMeasurementNotification();
        }
        return taskId;
    }

    /**
     * @see CyclingSpeedAndCadenceService#stopCSCMeasurementNotification()
     */
    @Nullable
    public synchronized Integer stopCSCMeasurementNotification() {
        Integer taskId = null;
        if (mCyclingSpeedAndCadenceService != null) {
            taskId = mCyclingSpeedAndCadenceService.stopCSCMeasurementNotification();
        }
        return taskId;
    }

    /**
     * @see CyclingSpeedAndCadenceService#getSensorLocation()
     */
    @Nullable
    public synchronized Integer getSensorLocation() {
        Integer taskId = null;
        if (mCyclingSpeedAndCadenceService != null) {
            taskId = mCyclingSpeedAndCadenceService.getSensorLocation();
        }
        return taskId;
    }

    /**
     * @see CyclingSpeedAndCadenceService#setSCControlPoint(SCControlPoint)
     */
    @Nullable
    public synchronized Integer setSCControlPoint(@NonNull SCControlPoint scControlPoint) {
        Integer taskId = null;
        if (mCyclingSpeedAndCadenceService != null) {
            taskId = mCyclingSpeedAndCadenceService.setSCControlPoint(scControlPoint);
        }
        return taskId;
    }

    /**
     * @see CyclingSpeedAndCadenceService#getSCControlPointClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getSCControlPointClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mCyclingSpeedAndCadenceService != null)
            taskId = mCyclingSpeedAndCadenceService.getSCControlPointClientCharacteristicConfiguration();
        return taskId;
    }

    /**
     * @see CyclingSpeedAndCadenceService#startSCControlPointIndication()
     */
    @Nullable
    public synchronized Integer startSCControlPointIndication() {
        Integer taskId = null;
        if (mCyclingSpeedAndCadenceService != null)
            taskId = mCyclingSpeedAndCadenceService.startSCControlPointIndication();
        return taskId;
    }

    /**
     * @see CyclingSpeedAndCadenceService#stopSCControlPointIndication()
     */
    @Nullable
    public synchronized Integer stopSCControlPointIndication() {
        Integer taskId = null;
        if (mCyclingSpeedAndCadenceService != null)
            taskId = mCyclingSpeedAndCadenceService.stopSCControlPointIndication();
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
        return CyclingSpeedAndCadenceProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * create {@link CyclingSpeedAndCadenceService} and {@link DeviceInformationService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        super.createServices();
        if (mCyclingSpeedAndCadenceService == null) {
            mCyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null);
        }
        if (mDeviceInformationService == null) {
            mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingSpeedAndCadenceProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mHasDeviceInformationService = false;
        mCyclingSpeedAndCadenceService = null;
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

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected FilteredScanCallback createFilteredScanCallback() {
        return new CyclingSpeedAndCadenceProfileScanCallback(this, null);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    protected FilteredLeScanCallback createFilteredLeScanCallback() {
        return new CyclingSpeedAndCadenceProfileLeScanCallback(this, null);
    }

}
