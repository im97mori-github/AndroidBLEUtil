package org.im97mori.ble.profile.blp.central;

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
import org.im97mori.ble.profile.blp.central.db.BloodPressureProfileBondedDatabaseHelper;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.service.bls.central.BloodPressureService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;

import java.util.List;

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
     * {@code true}:Device has User Data Service, {@code false}:no User Data Service
     */
    private boolean mHasDeviceInformationService;

    /**
     * @param context                      {@link Context} instance
     * @param bloodPressureProfileCallback {@link BloodPressureProfileCallback} instance
     */
    public BloodPressureProfile(@NonNull Context context, @NonNull BloodPressureProfileCallback bloodPressureProfileCallback) {
        super(context, bloodPressureProfileCallback);
        mBloodPressureProfileCallback = bloodPressureProfileCallback;
    }

    /**
     * @return {@code true}:Device has Device Information Service, {@code false}:no Device Information Service
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
     * @see DeviceInformationService#hasSystemId()
     */
    @Nullable
    public synchronized Boolean hasSystemId() {
        Boolean result = null;
        if (mDeviceInformationService != null) {
            result = mDeviceInformationService.hasSystemId();
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
     * @see BloodPressureService#isIntermediateCuffPressureSupported()
     */
    @Nullable
    public synchronized Boolean isIntermediateCuffPressureSupported() {
        Boolean result = null;
        if (mBloodPressureService != null) {
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
     * {@inheritDoc}
     */
    @Override
    public synchronized void disconnect() {
        mHasDeviceInformationService = false;
        super.disconnect();
    }

    /**
     * create {@link DeviceInformationService} and {@link BloodPressureService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        super.createServices();
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
        return new BloodPressureProfileScanCallback(this, null);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    protected FilteredLeScanCallback createFilteredLeScanCallback() {
        return new BloodPressureProfileLeScanCallback(this, null);
    }

}
