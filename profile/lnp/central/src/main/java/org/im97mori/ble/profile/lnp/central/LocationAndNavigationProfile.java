package org.im97mori.ble.profile.lnp.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a6b.LNControlPoint;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.profile.lnp.central.db.LocationAndNavigationProfileBondedDatabaseHelper;
import org.im97mori.ble.service.bas.central.BatteryService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.lns.central.LocationAndNavigationService;
import org.im97mori.ble.task.DiscoverServiceTask;

import java.util.List;

import static org.im97mori.ble.BLEConstants.ServiceUUID.BATTERY_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.DEVICE_INFORMATION_SERVICE;

/**
 * Location and Navigation Profile for Central
 */
public class LocationAndNavigationProfile extends AbstractCentralProfile {

    /**
     * {@link LocationAndNavigationProfileCallback} instance
     */
    protected final LocationAndNavigationProfileCallback mLocationAndNavigationProfileCallback;

    /**
     * {@link DeviceInformationService} instance
     */
    protected DeviceInformationService mDeviceInformationService;

    /**
     * {@link BatteryService} instance
     */
    protected BatteryService mBatteryService;

    /**
     * {@link LocationAndNavigationService} instance
     */
    protected LocationAndNavigationService mLocationAndNavigationService;

    /**
     * {@code true}:Device has Device Information Service, {@code false}:no Device information Service
     */
    private boolean mHasDeviceInformationService;

    /**
     * {@code true}:Device has Battery Service, {@code false}:no Battery Service
     */
    private boolean mHasBatteryService;

    /**
     * @param context                              {@link Context} instance
     * @param locationAndNavigationProfileCallback {@link LocationAndNavigationProfileCallback} instance
     */
    public LocationAndNavigationProfile(@NonNull Context context, @NonNull LocationAndNavigationProfileCallback locationAndNavigationProfileCallback) {
        super(context, locationAndNavigationProfileCallback);
        mLocationAndNavigationProfileCallback = locationAndNavigationProfileCallback;
    }

    /**
     * find Location and Navigation Profile device
     *
     * @param argument callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public synchronized Integer findLocationAndNavigationProfileDevices(@Nullable Bundle argument) {
        return scanDevice(new LocationAndNavigationProfileScanCallback(this, null), ScanTask.TIMEOUT_MILLIS, argument);
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
     * get Battery Level
     *
     * @param index Battery Service index
     * @return task id. if {@code null} returned, profile is not ready, index is out of range or no Battery Service
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
     * get Battery Level's notificatable status
     *
     * @param index Battery Service index
     * @return {@code true}:target Battery Service is notificatable, {@code false}:not notificatable. if {@code null} returned, profile is not ready or no Battery Service
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
     * get Battery Level's Characteristic Presentation Format
     *
     * @param index Battery Service index
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Battery Service
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
     * get Battery Level's Client Characteristic Configuration
     *
     * @param index Battery Service index
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Battery Service
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
     * start Battery Level's notification
     *
     * @param index Battery Service index
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Battery Service
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
     * stop Battery Level's notification
     *
     * @param index Battery Service index
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Battery Service
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
     * check Position Quality characteristic
     *
     * @return {@code true}:Position Quality characteristic is exist, {@code false}:Position Quality characteristic is not exist or service not ready. if {@code null} returned, profile is not ready or no Location and Navigation Service
     * @see LocationAndNavigationService#isPositionQualityCharacteristicSupporeted()
     */
    @Nullable
    public Boolean isPositionQualityCharacteristicSupporeted() {
        Boolean result = null;
        if (mLocationAndNavigationService != null) {
            result = mLocationAndNavigationService.isPositionQualityCharacteristicSupporeted();
        }
        return result;
    }

    /**
     * check LN Control Point characteristic
     *
     * @return {@code true}:LN Control Point characteristic is exist, {@code false}:LN Control Point characteristic is not exist or service not ready. if {@code null} returned, profile is not ready or no Location and Navigation Service
     * @see LocationAndNavigationService#isLNControlPointCharacteristicSupporeted()
     */
    @Nullable
    public Boolean isLNControlPointCharacteristicSupporeted() {
        Boolean result = null;
        if (mLocationAndNavigationService != null) {
            result = mLocationAndNavigationService.isLNControlPointCharacteristicSupporeted();
        }
        return result;
    }

    /**
     * check Navigation characteristic
     *
     * @return {@code true}:Navigation characteristic is exist, {@code false}:Navigation characteristic is not exist or service not ready. if {@code null} returned, profile is not ready or no Location and Navigation Service
     * @see LocationAndNavigationService#isNavigationCharacteristicSupporeted()
     */
    @Nullable
    public Boolean isNavigationCharacteristicSupporeted() {
        Boolean result = null;
        if (mLocationAndNavigationService != null) {
            result = mLocationAndNavigationService.isNavigationCharacteristicSupporeted();
        }
        return result;
    }

    /**
     * get LN Feature Feature
     *
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Location and Navigation Service
     * @see LocationAndNavigationService#getLNFeature()
     */
    @Nullable
    public Integer getLNFeature() {
        Integer taskId = null;
        if (mLocationAndNavigationService != null) {
            taskId = mLocationAndNavigationService.getLNFeature();
        }
        return taskId;
    }

    /**
     * get Location and Speed's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Location and Navigation Service
     * @see LocationAndNavigationService#getLocationAndSpeedClientCharacteristicConfiguration()
     */
    @Nullable
    public Integer getLocationAndSpeedClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mLocationAndNavigationService != null) {
            taskId = mLocationAndNavigationService.getLocationAndSpeedClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * start Location and Speed notification
     *
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Location and Navigation Service
     * @see LocationAndNavigationService#startLocationAndSpeedNotification()
     */
    @Nullable
    public synchronized Integer startLocationAndSpeedNotification() {
        Integer taskId = null;
        if (mLocationAndNavigationService != null) {
            taskId = mLocationAndNavigationService.startLocationAndSpeedNotification();
        }
        return taskId;
    }

    /**
     * stop Location and Speed notification
     *
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Location and Navigation Service
     * @see LocationAndNavigationService#stopLocationAndSpeedNotification()
     */
    @Nullable
    public synchronized Integer stopLocationAndSpeedNotification() {
        Integer taskId = null;
        if (mLocationAndNavigationService != null) {
            taskId = mLocationAndNavigationService.stopLocationAndSpeedNotification();
        }
        return taskId;
    }

    /**
     * get Position Quality
     *
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Location and Navigation Service
     * @see LocationAndNavigationService#getPositionQuality()
     */
    @Nullable
    public Integer getPositionQuality() {
        Integer taskId = null;
        if (mLocationAndNavigationService != null) {
            taskId = mLocationAndNavigationService.getPositionQuality();
        }
        return taskId;
    }

    /**
     * set LN Control Point
     *
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Location and Navigation Service
     * @see LocationAndNavigationService#setLNControlPoint(LNControlPoint)
     */
    @Nullable
    public Integer setLNControlPoint(@NonNull LNControlPoint lnControlPoint) {
        Integer taskId = null;
        if (mLocationAndNavigationService != null) {
            taskId = mLocationAndNavigationService.setLNControlPoint(lnControlPoint);
        }
        return taskId;
    }

    /**
     * start LN Control Point indication
     *
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Location and Navigation Service
     * @see LocationAndNavigationService#startLNControlPointIndication()
     */
    @Nullable
    public synchronized Integer startLNControlPointIndication() {
        Integer taskId = null;
        if (mLocationAndNavigationService != null) {
            taskId = mLocationAndNavigationService.startLNControlPointIndication();
        }
        return taskId;
    }

    /**
     * stop LN Control Point indication
     *
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Location and Navigation Service
     * @see LocationAndNavigationService#stopLNControlPointIndication()
     */
    @Nullable
    public synchronized Integer stopLNControlPointIndication() {
        Integer taskId = null;
        if (mLocationAndNavigationService != null) {
            taskId = mLocationAndNavigationService.stopLNControlPointIndication();
        }
        return taskId;
    }

    /**
     * start Navigation notification
     *
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Location and Navigation Service
     * @see LocationAndNavigationService#startNavigationNotification()
     */
    @Nullable
    public synchronized Integer startNavigationNotification() {
        Integer taskId = null;
        if (mLocationAndNavigationService != null) {
            taskId = mLocationAndNavigationService.startNavigationNotification();
        }
        return taskId;
    }

    /**
     * stop Navigation notification
     *
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Location and Navigation Service
     * @see LocationAndNavigationService#stopNavigationNotification()
     */
    @Nullable
    public synchronized Integer stopNavigationNotification() {
        Integer taskId = null;
        if (mLocationAndNavigationService != null) {
            taskId = mLocationAndNavigationService.stopNavigationNotification();
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return LocationAndNavigationProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * create {@link DeviceInformationService} and {@link BatteryService} and {@link LocationAndNavigationService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        if (mDeviceInformationService == null) {
            mDeviceInformationService = new DeviceInformationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
        }
        if (mBatteryService == null) {
            mBatteryService = new BatteryService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
        }
        if (mLocationAndNavigationService == null) {
            mLocationAndNavigationService = new LocationAndNavigationService(mBLEConnection, mLocationAndNavigationProfileCallback, null);
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
        mDeviceInformationService = null;
        mBatteryService = null;
        mLocationAndNavigationService = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
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
