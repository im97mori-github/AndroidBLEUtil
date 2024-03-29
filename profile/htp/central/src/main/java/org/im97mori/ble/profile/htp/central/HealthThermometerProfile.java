package org.im97mori.ble.profile.htp.central;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.advertising.filter.FilteredLeScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a21.MeasurementInterval;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
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
     * @see HealthThermometerService#isTemperatureTypeCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isTemperatureTypeCharacteristicSupported() {
        Boolean result = null;
        if (mHealthThermometerService != null) {
            result = mHealthThermometerService.isTemperatureTypeCharacteristicSupported();
        }
        return result;
    }


    /**
     * @see HealthThermometerService#isIntermediateTemperatureCharacteristicSupported()
     */
    public synchronized Boolean isIntermediateTemperatureCharacteristicSupported() {
        Boolean result = null;
        if (mHealthThermometerService != null) {
            result = mHealthThermometerService.isIntermediateTemperatureCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see HealthThermometerService#isMeasurementIntervalCharacteristicSupported()
     */
    public synchronized Boolean isMeasurementIntervalCharacteristicSupported() {
        Boolean result = null;
        if (mHealthThermometerService != null) {
            result = mHealthThermometerService.isMeasurementIntervalCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see HealthThermometerService#isMeasurementIntervalCharacteristicIndicateSupported()
     */
    public synchronized Boolean isMeasurementIntervalCharacteristicIndicateSupported() {
        Boolean result = null;
        if (mHealthThermometerService != null) {
            result = mHealthThermometerService.isMeasurementIntervalCharacteristicIndicateSupported();
        }
        return result;
    }

    /**
     * @see HealthThermometerService#isMeasurementIntervalCharacteristicWriteSupported()
     */
    public synchronized Boolean isMeasurementIntervalCharacteristicWriteSupported() {
        Boolean result = null;
        if (mHealthThermometerService != null) {
            result = mHealthThermometerService.isMeasurementIntervalCharacteristicWriteSupported();
        }
        return result;
    }

    /**
     * @see HealthThermometerService#getTemperatureMeasurementClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getTemperatureMeasurementClientCharacteristicConfiguration() {
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
     * @see HealthThermometerService#stopHeartRateMeasurementIndication()
     */
    @Nullable
    public synchronized Integer stopHeartRateMeasurementIndication() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.stopHeartRateMeasurementIndication();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#getTemperatureType()
     */
    @Nullable
    public synchronized Integer getTemperatureType() {
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
    public synchronized Integer getIntermediateTemperatureClientCharacteristicConfiguration() {
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
     * @see HealthThermometerService#stopIntermediateTemperatureNotification()
     */
    @Nullable
    public synchronized Integer stopIntermediateTemperatureNotification() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.stopIntermediateTemperatureNotification();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#getMeasurementInterval()
     */
    @Nullable
    public synchronized Integer getMeasurementInterval() {
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
    public synchronized Integer setMeasurementInterval(@NonNull MeasurementInterval measurementInterval) {
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
    public synchronized Integer getMeasurementIntervalClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.getMeasurementIntervalClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#startMeasurementIntervalIndication()
     */
    @Nullable
    public synchronized Integer startMeasurementIntervalIndication() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.startMeasurementIntervalIndication();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#stopMeasurementIntervalIndication()
     */
    @Nullable
    public synchronized Integer stopMeasurementIntervalIndication() {
        Integer taskId = null;
        if (mHealthThermometerService != null) {
            taskId = mHealthThermometerService.stopMeasurementIntervalIndication();
        }
        return taskId;
    }

    /**
     * @see HealthThermometerService#getMeasurementIntervalValidRange()
     */
    @Nullable
    public synchronized Integer getMeasurementIntervalValidRange() {
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
        super.createServices();
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

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected FilteredScanCallback createFilteredScanCallback() {
        return new HealthThermometerProfileScanCallback(this, null);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    protected FilteredLeScanCallback createFilteredLeScanCallback() {
        return new HealthThermometerProfileLeScanCallback(this, null);
    }

}
