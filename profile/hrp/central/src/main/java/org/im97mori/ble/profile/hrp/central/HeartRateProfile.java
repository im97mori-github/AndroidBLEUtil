package org.im97mori.ble.profile.hrp.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a39.HeartRateControlPoint;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.profile.hrp.central.db.HeartRateProfileBondedDatabaseHelper;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.hrs.central.HeartRateService;
import org.im97mori.ble.task.DiscoverServiceTask;

import java.util.List;

import static org.im97mori.ble.BLEConstants.ServiceUUID.DEVICE_INFORMATION_SERVICE;

/**
 * Heart Rate Profile for Central
 */
public class HeartRateProfile extends AbstractCentralProfile {

    /**
     * {@link HeartRateProfileCallback} instance
     */
    protected final HeartRateProfileCallback mHeartRateProfileCallback;

    /**
     * {@link DeviceInformationService} instance
     */
    protected DeviceInformationService mDeviceInformationService;

    /**
     * {@link HeartRateService} instance
     */
    protected HeartRateService mHeartRateService;

    /**
     * {@code true}:Device has Device Information Service, {@code false}:no Device information Service
     */
    private boolean mHasDeviceInformationService;

    /**
     * @param context                  {@link Context} instance
     * @param heartRateProfileCallback {@link HeartRateProfileCallback} instance
     */
    public HeartRateProfile(@NonNull Context context, @NonNull HeartRateProfileCallback heartRateProfileCallback) {
        super(context, heartRateProfileCallback);
        mHeartRateProfileCallback = heartRateProfileCallback;
    }

    /**
     * find Heart Rate Profile device
     *
     * @param argument callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public synchronized Integer findHeartRateProfileDevices(@Nullable Bundle argument) {
        return scanDevice(new HeartRateProfileScanCallback(this, null), ScanTask.TIMEOUT_MILLIS, argument);
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
     * @see DeviceInformationService#hasManufacturerNameString()
     */
    @Nullable
    public synchronized Boolean hasManufacturerNameString() {
        Boolean result = null;
        if (mDeviceInformationService != null && mHasDeviceInformationService) {
            result = mDeviceInformationService.hasManufacturerNameString();
        }
        return result;
    }

    /**
     * @see DeviceInformationService#getManufacturerNameString()
     */
    @Nullable
    public synchronized Integer getManufacturerNameString() {
        Integer taskId = null;
        if (mDeviceInformationService != null && mHasDeviceInformationService) {
            taskId = mDeviceInformationService.getManufacturerNameString();
        }
        return taskId;
    }

    /**
     * @see HeartRateService#isBodySensorLocationCharacteristicSupporeted()
     */
    @Nullable
    public synchronized Boolean isBodySensorLocationCharacteristicSupporeted() {
        Boolean result = null;
        if (mHeartRateService != null) {
            result = mHeartRateService.isBodySensorLocationCharacteristicSupporeted();
        }
        return result;
    }

    /**
     * @see HeartRateService#isHeartRateControlPointCharacteristicSupporeted()
     */
    @Nullable
    public synchronized Boolean isHeartRateControlPointCharacteristicSupporeted() {
        Boolean result = null;
        if (mHeartRateService != null) {
            result = mHeartRateService.isHeartRateControlPointCharacteristicSupporeted();
        }
        return result;
    }

    /**
     * @see HeartRateService#getHeartRateMeasurementClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getHeartRateMeasurementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mHeartRateService != null) {
            taskId = mHeartRateService.getHeartRateMeasurementClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see HeartRateService#startHeartRateMeasurementNotification()
     */
    @Nullable
    public synchronized Integer startHeartRateMeasurementNotification() {
        Integer taskId = null;
        if (mHeartRateService != null) {
            taskId = mHeartRateService.startHeartRateMeasurementNotification();
        }
        return taskId;
    }

    /**
     * @see HeartRateService#stopHeartRateMeasurementNotification()
     */
    @Nullable
    public synchronized Integer stopHeartRateMeasurementNotification() {
        Integer taskId = null;
        if (mHeartRateService != null) {
            taskId = mHeartRateService.stopHeartRateMeasurementNotification();
        }
        return taskId;
    }

    /**
     * @see HeartRateService#getBodySensorLocation()
     */
    @Nullable
    public synchronized Integer getBodySensorLocation() {
        Integer taskId = null;
        if (mHeartRateService != null) {
            taskId = mHeartRateService.getBodySensorLocation();
        }
        return taskId;
    }

    /**
     * @see HeartRateService#setHeartRateControlPoint(HeartRateControlPoint)
     */
    @Nullable
    public synchronized Integer setHeartRateControlPoint(@NonNull HeartRateControlPoint heartRateControlPoint) {
        Integer taskId = null;
        if (mHeartRateService != null) {
            taskId = mHeartRateService.setHeartRateControlPoint(heartRateControlPoint);
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return HeartRateProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void disconnect() {
        mHasDeviceInformationService = false;
        super.disconnect();
    }

    /**
     * create {@link DeviceInformationService} and {@link HeartRateService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        if (mDeviceInformationService == null) {
            mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHeartRateProfileCallback, null);
        }
        if (mHeartRateService == null) {
            mHeartRateService = new HeartRateService(mBLEConnection, mHeartRateProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mDeviceInformationService = null;
        mHeartRateService = null;
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
                }
            }
        }
        super.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, argument);
    }

}
