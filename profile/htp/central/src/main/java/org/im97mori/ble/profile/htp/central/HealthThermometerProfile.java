package org.im97mori.ble.profile.htp.central;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a21.MeasurementInterval;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.profile.htp.central.db.HealthThermometerProfileBondedDatabaseHelper;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.hts.central.HealthThermometerService;

/**
 * Health Thermometer Profile for Central
 */
public class HealthThermometerProfile extends AbstractCentralProfile {

    /**
     * {@link HealthThermometerProfileCallback} instance
     */
    protected final HealthThermometerProfileCallback mHealthThermometerProfileCallback;

    /**
     * {@link DeviceInformationService} instance
     */
    protected DeviceInformationService mDeviceInformationService;

    /**
     * {@link HealthThermometerService} instance
     */
    protected HealthThermometerService mHealthThermometerService;

    /**
     * @param context                          {@link Context} instance
     * @param healthThermometerProfileCallback {@link HealthThermometerProfileCallback} instance
     */
    public HealthThermometerProfile(@NonNull Context context, @NonNull HealthThermometerProfileCallback healthThermometerProfileCallback) {
        super(context, healthThermometerProfileCallback);
        mHealthThermometerProfileCallback = healthThermometerProfileCallback;
    }

    /**
     * find Health Thermometer Profile device
     *
     * @param argument callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public synchronized Integer findHealthThermometerProfileDevices(@Nullable Bundle argument) {
        return scanDevice(new HealthThermometerProfileScanCallback(this, null), ScanTask.TIMEOUT_MILLIS, argument);
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
     * @see DeviceInformationService#getSystemId()
     */
    @Nullable
    public synchronized Integer getSystemId() {
        Integer taskId = null;
        if (mDeviceInformationService != null) {
            taskId = mDeviceInformationService.getSystemId();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#isTemperatureTypeCharacteristicSupporeted()
     */
    @Nullable
    public synchronized Boolean isTemperatureTypeCharacteristicSupporeted() {
        Boolean result = null;
        if (mHealthThermometerService != null) {
            result = mHealthThermometerService.isTemperatureTypeCharacteristicSupporeted();
        }
        return result;
    }


    /**
     * @see HealthThermometerService#isIntermediateTemperatureCharacteristicSupporeted()
     */
    public synchronized Boolean isIntermediateTemperatureCharacteristicSupporeted() {
        Boolean result = null;
        if (mHealthThermometerService != null) {
            result = mHealthThermometerService.isIntermediateTemperatureCharacteristicSupporeted();
        }
        return result;
    }

    /**
     * @see HealthThermometerService#isMeasurementIntervalCharacteristicSupporeted()
     */
    public synchronized Boolean isMeasurementIntervalCharacteristicSupporeted() {
        Boolean result = null;
        if (mHealthThermometerService != null) {
            result = mHealthThermometerService.isMeasurementIntervalCharacteristicSupporeted();
        }
        return result;
    }

    /**
     * @see HealthThermometerService#isMeasurementIntervalCharacteristicIndicateSupporeted()
     */
    public synchronized Boolean isMeasurementIntervalCharacteristicIndicateSupporeted() {
        Boolean result = null;
        if (mHealthThermometerService != null) {
            result = mHealthThermometerService.isMeasurementIntervalCharacteristicIndicateSupporeted();
        }
        return result;
    }

    /**
     * @see HealthThermometerService#isMeasurementIntervalCharacteristicWriteSupporeted()
     */
    public synchronized Boolean isMeasurementIntervalCharacteristicWriteSupporeted() {
        Boolean result = null;
        if (mHealthThermometerService != null) {
            result = mHealthThermometerService.isMeasurementIntervalCharacteristicWriteSupporeted();
        }
        return result;
    }

    /**
     * @see HealthThermometerService#getTemperatureMeasurementClientCharacteristicConfiguration()
     */
    @Nullable
    public Integer getTemperatureMeasurementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.getTemperatureMeasurementClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#startTemperatureMeasurementIndication()
     */
    @Nullable
    public synchronized Integer startTemperatureMeasurementIndication() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.startTemperatureMeasurementIndication();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#stopHeartRateMeasurementNotification()
     */
    @Nullable
    public synchronized Integer stopHeartRateMeasurementNotification() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.stopHeartRateMeasurementNotification();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#getTemperatureType()
     */
    @Nullable
    public Integer getTemperatureType() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.getTemperatureType();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#getIntermediateTemperatureClientCharacteristicConfiguration()
     */
    @Nullable
    public Integer getIntermediateTemperatureClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.getIntermediateTemperatureClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#startIntermediateTemperatureNotification()
     */
    @Nullable
    public synchronized Integer startIntermediateTemperatureNotification() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.startIntermediateTemperatureNotification();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#stopIntermediateTemperaturNotification()
     */
    @Nullable
    public synchronized Integer stopIntermediateTemperaturNotification() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.stopIntermediateTemperaturNotification();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#getMeasurementInterval()
     */
    @Nullable
    public Integer getMeasurementInterval() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.getMeasurementInterval();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#setMeasurementInterval(MeasurementInterval)
     */
    @Nullable
    public Integer setMeasurementInterval(@NonNull MeasurementInterval measurementInterval) {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.setMeasurementInterval(measurementInterval);
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#getMeasurementIntervalClientCharacteristicConfiguration()
     */
    @Nullable
    public Integer getMeasurementIntervalClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.getMeasurementIntervalClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#startMeasurementIntervalInidication()
     */
    @Nullable
    public synchronized Integer startMeasurementIntervalInidication() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.startMeasurementIntervalInidication();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#stopMeasurementIntervalInidication()
     */
    @Nullable
    public synchronized Integer stopMeasurementIntervalInidication() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.stopMeasurementIntervalInidication();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#getMeasurementIntervalValidRange()
     */
    @Nullable
    public Integer getMeasurementIntervalValidRange() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.getMeasurementIntervalValidRange();
        }
        return taskId;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return HealthThermometerProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * create {@link DeviceInformationService} and {@link HealthThermometerService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        if (mDeviceInformationService == null) {
            mDeviceInformationService = new DeviceInformationService(mBLEConnection, mHealthThermometerProfileCallback, null);
        }
        if (mHealthThermometerService == null) {
            mHealthThermometerService = new HealthThermometerService(mBLEConnection, mHealthThermometerProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mDeviceInformationService = null;
        mHealthThermometerService = null;
    }

}
