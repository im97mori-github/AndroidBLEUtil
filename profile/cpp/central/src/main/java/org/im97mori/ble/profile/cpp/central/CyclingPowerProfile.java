package org.im97mori.ble.profile.cpp.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a66.CyclingPowerControlPoint;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.profile.cpp.central.db.CyclingPowerProfileBondedDatabaseHelper;
import org.im97mori.ble.service.bas.central.BatteryService;
import org.im97mori.ble.service.cps.central.CyclingPowerService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.task.DiscoverServiceTask;

import java.util.List;

import static org.im97mori.ble.constants.ServiceUUID.BATTERY_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.DEVICE_INFORMATION_SERVICE;

/**
 *Cycling Power Profile for Central
 */
public class CyclingPowerProfile extends AbstractCentralProfile {

    /**
     * {@link CyclingPowerProfileCallback} instance
     */
    protected final CyclingPowerProfileCallback mCyclingPowerProfileCallback;

    /**
     * {@link CyclingPowerService} instance
     */
    protected CyclingPowerService mCyclingPowerService;

    /**
     * {@link DeviceInformationService} instance
     */
    protected DeviceInformationService mDeviceInformationService;

    /**
     * {@link BatteryService} instance
     */
    protected BatteryService mBatteryService;

    /**
     * {@code true}:Device has Device Information Service, {@code false}:no Device information Service
     */
    private boolean mHasDeviceInformationService;

    /**
     * {@code true}:Device has Battery Service, {@code false}:no Battery Service
     */
    private boolean mHasBatteryService;

    /**
     * @param context                     {@link Context} instance
     * @param cyclingPowerProfileCallback {@link CyclingPowerProfileCallback} instance
     */
    public CyclingPowerProfile(@NonNull Context context, @NonNull CyclingPowerProfileCallback cyclingPowerProfileCallback) {
        super(context, cyclingPowerProfileCallback);
        mCyclingPowerProfileCallback = cyclingPowerProfileCallback;
    }

    /**
     * find Cycling Power Profile device
     *
     * @param argument callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public synchronized Integer findCyclingPowerProfileDevices(@Nullable Bundle argument) {
        return scanDevice(new CyclingPowerProfileScanCallback(this, null), ScanTask.TIMEOUT_MILLIS, argument);
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
     * @return {@code true}:Device has Battery Service, {@code false}:no Battery Service. if {@code null} returned, profile is not ready
     */
    @Nullable
    public synchronized Boolean hasBatteryService() {
        Boolean result = null;
        if (mBatteryService != null) {
            result = mHasBatteryService;
        }
        return result;
    }

    /**
     * @see CyclingPowerService#isCyclingPowerControlPointCharacteristicSupported()
     */
    public synchronized Boolean isCyclingPowerControlPointCharacteristicSupported() {
        Boolean result = null;
        if (mCyclingPowerService != null) {
            result = mCyclingPowerService.isCyclingPowerControlPointCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see CyclingPowerService#isCyclingPowerVectorCharacteristicSupported()
     */
    public synchronized Boolean isCyclingPowerVectorCharacteristicSupported() {
        Boolean result = null;
        if (mCyclingPowerService != null) {
            result = mCyclingPowerService.isCyclingPowerVectorCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see CyclingPowerService#isCyclingPowerVectorCharacteristicSupported()
     */
    @Nullable
    public synchronized Integer getCyclingPowerFeature() {
        Integer taskId = null;
        if (mCyclingPowerService != null) {
            taskId = mCyclingPowerService.getCyclingPowerFeature();
        }
        return taskId;
    }

    /**
     * @see CyclingPowerService#getCyclingPowerMeasurementClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getCyclingPowerMeasurementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mCyclingPowerService != null) {
            taskId = mCyclingPowerService.getCyclingPowerMeasurementClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see CyclingPowerService#startCyclingPowerMeasurementNotification()
     */
    @Nullable
    public synchronized Integer startCyclingPowerMeasurementNotification() {
        Integer taskId = null;
        if (mCyclingPowerService != null) {
            taskId = mCyclingPowerService.startCyclingPowerMeasurementNotification();
        }
        return taskId;
    }

    /**
     * @see CyclingPowerService#stopCyclingPowerMeasurementNotification()
     */
    @Nullable
    public synchronized Integer stopCyclingPowerMeasurementNotification() {
        Integer taskId = null;
        if (mCyclingPowerService != null) {
            taskId = mCyclingPowerService.stopCyclingPowerMeasurementNotification();
        }
        return taskId;
    }

    /**
     * @see CyclingPowerService#getSensorLocation()
     */
    @Nullable
    public synchronized Integer getSensorLocation() {
        Integer taskId = null;
        if (mCyclingPowerService != null) {
            taskId = mCyclingPowerService.getSensorLocation();
        }
        return taskId;
    }

    /**
     * @see CyclingPowerService#setCyclingPowerControlPoint(CyclingPowerControlPoint)
     */
    @Nullable
    public synchronized Integer setCyclingPowerControlPoint(@NonNull CyclingPowerControlPoint cyclingPowerControlPoint) {
        Integer taskId = null;
        if (mCyclingPowerService != null) {
            taskId = mCyclingPowerService.setCyclingPowerControlPoint(cyclingPowerControlPoint);
        }
        return taskId;
    }

    /**
     * @see CyclingPowerService#getCyclingPowerControlPointClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getCyclingPowerControlPointClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mCyclingPowerService != null) {
            taskId = mCyclingPowerService.getCyclingPowerControlPointClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see CyclingPowerService#startCyclingPowerControlPointIndication()
     */
    @Nullable
    public synchronized Integer startCyclingPowerControlPointIndication() {
        Integer taskId = null;
        if (mCyclingPowerService != null) {
            taskId = mCyclingPowerService.startCyclingPowerControlPointIndication();
        }
        return taskId;
    }

    /**
     * @see CyclingPowerService#stopCyclingPowerControlPointIndication()
     */
    @Nullable
    public synchronized Integer stopCyclingPowerControlPointIndication() {
        Integer taskId = null;
        if (mCyclingPowerService != null) {
            taskId = mCyclingPowerService.stopCyclingPowerControlPointIndication();
        }
        return taskId;
    }

    /**
     * @see CyclingPowerService#getCyclingPowerVectorClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getCyclingPowerVectorClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mCyclingPowerService != null) {
            taskId = mCyclingPowerService.getCyclingPowerVectorClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see CyclingPowerService#startCyclingPowerVectorNotification()
     */
    @Nullable
    public synchronized Integer startCyclingPowerVectorNotification() {
        Integer taskId = null;
        if (mCyclingPowerService != null) {
            taskId = mCyclingPowerService.startCyclingPowerVectorNotification();
        }
        return taskId;
    }

    /**
     * @see CyclingPowerService#stopCyclingPowerVectorNotification()
     */
    @Nullable
    public synchronized Integer stopCyclingPowerVectorNotification() {
        Integer taskId = null;
        if (mCyclingPowerService != null) {
            taskId = mCyclingPowerService.stopCyclingPowerVectorNotification();
        }
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
     * get available Battery Service count
     *
     * @return available Battery Service count. if {@code null} returned, profile is not ready or no Battery Service
     * @see BatteryService#getBatteryLevelCount()
     */
    @Nullable
    public synchronized Integer getBatteryLevelCount() {
        Integer count = null;
        if (mBatteryService != null) {
            count = mBatteryService.getBatteryLevelCount();
        }
        return count;
    }

    /**
     * @see #getBatteryLevel(int)
     */
    @Nullable
    public synchronized Integer getBatteryLevel() {
        return getBatteryLevel(0);
    }

    /**
     * @see BatteryService#getBatteryLevel(int)
     */
    @Nullable
    public synchronized Integer getBatteryLevel(int index) {
        Integer batteryLevel = null;
        if (mBatteryService != null) {
            batteryLevel = mBatteryService.getBatteryLevel(index);
        }
        return batteryLevel;
    }

    /**
     * @see #isBatteryLevelNotificatable(int)
     */
    public synchronized Boolean isBatteryLevelNotificatable() {
        return isBatteryLevelNotificatable(0);
    }

    /**
     * @see BatteryService#isBatteryLevelNotificatable(int)
     */
    public synchronized Boolean isBatteryLevelNotificatable(int index) {
        Boolean result = null;
        if (mBatteryService != null) {
            result = mBatteryService.isBatteryLevelNotificatable(index);
        }
        return result;
    }

    /**
     * @see #getBatteryLevelCharacteristicPresentationFormat(int)
     */
    @Nullable
    public synchronized Integer getBatteryLevelCharacteristicPresentationFormat() {
        return getBatteryLevelCharacteristicPresentationFormat(0);
    }

    /**
     * @see BatteryService#getBatteryLevelCharacteristicPresentationFormat(int)
     */
    @Nullable
    public synchronized Integer getBatteryLevelCharacteristicPresentationFormat(int index) {
        Integer taskId = null;
        if (mBatteryService != null) {
            taskId = mBatteryService.getBatteryLevelCharacteristicPresentationFormat(index);
        }
        return taskId;
    }

    /**
     * @see #getBatteryLevelClientCharacteristicConfiguration(int)
     */
    @Nullable
    public synchronized Integer getBatteryLevelClientCharacteristicConfiguration() {
        return getBatteryLevelClientCharacteristicConfiguration(0);
    }

    /**
     * @see BatteryService#getBatteryLevelClientCharacteristicConfiguration(int)
     */
    @Nullable
    public synchronized Integer getBatteryLevelClientCharacteristicConfiguration(int index) {
        Integer taskId = null;
        if (mBatteryService != null) {
            taskId = mBatteryService.getBatteryLevelClientCharacteristicConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #startBatteryLevelNotification(int)
     */
    @Nullable
    public synchronized Integer startBatteryLevelNotification() {
        return startBatteryLevelNotification(0);
    }

    /**
     * @see BatteryService#startBatteryLevelNotification(int)
     */
    @Nullable
    public synchronized Integer startBatteryLevelNotification(int index) {
        Integer taskId = null;
        if (mBatteryService != null) {
            taskId = mBatteryService.startBatteryLevelNotification(index);
        }
        return taskId;
    }

    /**
     * @see #stopBatteryLevelNotification(int)
     */
    @Nullable
    public synchronized Integer stopBatteryLevelNotification() {
        return stopBatteryLevelNotification(0);
    }

    /**
     * @see BatteryService#stopBatteryLevelNotification(int)
     */
    @Nullable
    public synchronized Integer stopBatteryLevelNotification(int index) {
        Integer taskId = null;
        if (mBatteryService != null) {
            taskId = mBatteryService.stopBatteryLevelNotification(index);
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return CyclingPowerProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * create {@link CyclingPowerService}, {@link DeviceInformationService} and {@link BatteryService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        super.createServices();
        if (mCyclingPowerService == null) {
            mCyclingPowerService = new CyclingPowerService(mBLEConnection, mCyclingPowerProfileCallback, null);
        }
        if (mDeviceInformationService == null) {
            mDeviceInformationService = new DeviceInformationService(mBLEConnection, mCyclingPowerProfileCallback, null);
        }
        if (mBatteryService == null) {
            mBatteryService = new BatteryService(mBLEConnection, mCyclingPowerProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mHasDeviceInformationService = false;
        mHasBatteryService = false;
        mCyclingPowerService = null;
        mDeviceInformationService = null;
        mBatteryService = null;
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
                } else if (BATTERY_SERVICE.equals(bluetoothGattService.getUuid())) {
                    mHasBatteryService = true;
                }
            }
        }
        super.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, argument);
    }

}
