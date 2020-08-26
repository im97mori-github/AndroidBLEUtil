package org.im97mori.ble.profile.blp.central;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.profile.blp.central.db.BloodPressureProfileBondedDatabaseHelper;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.service.bls.central.BloodPressureService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;

/**
 * Blood Pressure Profile for Central
 */
public class BloodPressureProfile extends AbstractCentralProfile {

    /**
     * {@link BloodPressureProfileCallback} instance
     */
    protected final BloodPressureProfileCallback mBloodPressureProfileCallback;

    /**
     * {@link DeviceInformationService} instance
     */
    protected DeviceInformationService mDeviceInformationService;

    /**
     * {@link BloodPressureService} instance
     */
    protected BloodPressureService mBloodPressureService;

    /**
     * @param context                      {@link Context} instance
     * @param bloodPressureProfileCallback {@link BloodPressureProfileCallback} instance
     */
    public BloodPressureProfile(@NonNull Context context, @NonNull BloodPressureProfileCallback bloodPressureProfileCallback) {
        super(context, bloodPressureProfileCallback);
        mBloodPressureProfileCallback = bloodPressureProfileCallback;
    }

    /**
     * find Blood Pressure Profile device
     *
     * @param argument callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public synchronized Integer findBloodPressureProfileDevices(@Nullable Bundle argument) {
        return scanDevice(new BloodPressureProfileScanCallback(this, null), ScanTask.TIMEOUT_MILLIS, argument);
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
     * @see BloodPressureService#isIntermediateCuffPressureSupported()
     */
    @Nullable
    public synchronized Boolean isIntermediateCuffPressureSupported() {
        Boolean result = null;
        if (mBloodPressureService != null ) {
            result = mBloodPressureService.isIntermediateCuffPressureSupported();
        }
        return result;
    }

    /**
     * @see BloodPressureService#getBloodPressureMeasurementClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getBloodPressureMeasurementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mBloodPressureService != null) {
            taskId = mBloodPressureService.getBloodPressureMeasurementClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see BloodPressureService#startBloodPressureMeasurementIndication()
     */
    @Nullable
    public synchronized Integer startBloodPressureMeasurementIndication() {
        Integer taskId = null;
        if (mBloodPressureService != null) {
            taskId = mBloodPressureService.startBloodPressureMeasurementIndication();
        }
        return taskId;
    }

    /**
     * @see BloodPressureService#stopBloodPressureMeasurementIndication()
     */
    @Nullable
    public synchronized Integer stopBloodPressureMeasurementIndication() {
        Integer taskId = null;
        if (mBloodPressureService != null) {
            taskId = mBloodPressureService.stopBloodPressureMeasurementIndication();
        }
        return taskId;
    }

    /**
     * @see BloodPressureService#getIntermediateCuffPressureClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getIntermediateCuffPressureClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mBloodPressureService != null) {
            taskId = mBloodPressureService.getIntermediateCuffPressureClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see BloodPressureService#startIntermediateCuffPressureNotification()
     */
    @Nullable
    public synchronized Integer startIntermediateCuffPressureNotification() {
        Integer taskId = null;
        if (mBloodPressureService != null) {
            taskId = mBloodPressureService.startIntermediateCuffPressureNotification();
        }
        return taskId;
    }

    /**
     * @see BloodPressureService#stopIntermediateCuffPressureNotification()
     */
    @Nullable
    public synchronized Integer stopIntermediateCuffPressureNotification() {
        Integer taskId = null;
        if (mBloodPressureService != null) {
            taskId = mBloodPressureService.stopIntermediateCuffPressureNotification();
        }
        return taskId;
    }

    /**
     * @see BloodPressureService#getBloodPressureFeature()
     */
    @Nullable
    public synchronized Integer getBloodPressureFeature() {
        Integer taskId = null;
        if (mBloodPressureService != null) {
            taskId = mBloodPressureService.getBloodPressureFeature();
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return BloodPressureProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * create {@link DeviceInformationService} and {@link BloodPressureService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        if (mDeviceInformationService == null) {
            mDeviceInformationService = new DeviceInformationService(mBLEConnection, mBloodPressureProfileCallback, null);
        }
        if (mBloodPressureService == null) {
            mBloodPressureService = new BloodPressureService(mBLEConnection, mBloodPressureProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mDeviceInformationService = null;
        mBloodPressureService = null;
    }

}
