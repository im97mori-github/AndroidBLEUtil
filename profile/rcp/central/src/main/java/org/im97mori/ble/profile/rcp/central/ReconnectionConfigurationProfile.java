package org.im97mori.ble.profile.rcp.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2aa4.BondManagementControlPoint;
import org.im97mori.ble.characteristic.u2b1f.ReconnectionConfigurationControlPoint;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.profile.rcp.central.db.ReconnectionConfigurationProfileBondedDatabaseHelper;
import org.im97mori.ble.service.bms.central.BondManagementService;
import org.im97mori.ble.service.rcs.central.ReconnectionConfigurationService;
import org.im97mori.ble.task.DiscoverServiceTask;

import java.util.List;

import static org.im97mori.ble.BLEConstants.ServiceUUID.BOND_MANAGEMENT_SERVICE;

/**
 * Reconnection Configuration Profile for Central
 */
public class ReconnectionConfigurationProfile extends AbstractCentralProfile {

    /**
     * {@link ReconnectionConfigurationProfileCallback} instance
     */
    protected final ReconnectionConfigurationProfileCallback mReconnectionConfigurationProfileCallback;

    /**
     * {@link ReconnectionConfigurationService} instance
     */
    protected ReconnectionConfigurationService mReconnectionConfigurationService;

    /**
     * {@link BondManagementService} instance
     */
    protected BondManagementService mBondManagementService;

    /**
     * {@code true}:Device has Bond Management Service, {@code false}:no Bond Management Service
     */
    private boolean mHasBondManagementService;

    /**
     * @param context                                  {@link Context} instance
     * @param reconnectionConfigurationProfileCallback {@link ReconnectionConfigurationProfileCallback} instance
     */
    public ReconnectionConfigurationProfile(@NonNull Context context, @NonNull ReconnectionConfigurationProfileCallback reconnectionConfigurationProfileCallback) {
        super(context, reconnectionConfigurationProfileCallback);
        mReconnectionConfigurationProfileCallback = reconnectionConfigurationProfileCallback;
    }

    /**
     * find Reconnection Configuration Profile device
     *
     * @param argument callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public synchronized Integer findReconnectionConfigurationProfileDevices(@Nullable Bundle argument) {
        return scanDevice(new ReconnectionConfigurationProfileScanCallback(this, null), ScanTask.TIMEOUT_MILLIS, argument);
    }

    /**
     * @return {@code true}:Device has Bond Management Service, {@code false}:no Bond Management Service. if {@code null} returned, profile is not ready
     */
    @Nullable
    public synchronized Boolean hasBondManagementService() {
        Boolean result = null;
        if (mBondManagementService != null) {
            result = mHasBondManagementService;
        }
        return result;
    }

    /**
     * @see ReconnectionConfigurationService#isRCSettingsCharacteristicSupported()
     */
    @Nullable
    public Boolean isRCSettingsCharacteristicSupported() {
        Boolean result = null;
        if (mReconnectionConfigurationService != null) {
            result = mReconnectionConfigurationService.isRCSettingsCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see ReconnectionConfigurationService#isRCSettingsCharacteristicNotifySupported()
     */
    @Nullable
    public Boolean isRCSettingsCharacteristicNotifySupported() {
        Boolean result = null;
        if (mReconnectionConfigurationService != null) {
            result = mReconnectionConfigurationService.isRCSettingsCharacteristicNotifySupported();
        }
        return result;
    }

    /**
     * @see ReconnectionConfigurationService#isReconnectionConfigurationControlPointCharacteristicSupported()
     */
    @Nullable
    public Boolean isReconnectionConfigurationControlPointCharacteristicSupported() {
        Boolean result = null;
        if (mReconnectionConfigurationService != null) {
            result = mReconnectionConfigurationService.isReconnectionConfigurationControlPointCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see ReconnectionConfigurationService#getRCFeature()
     */
    @Nullable
    public synchronized Integer getRCFeature() {
        Integer taskId = null;
        if (mReconnectionConfigurationService != null) {
            taskId = mReconnectionConfigurationService.getRCFeature();
        }
        return taskId;
    }

    /**
     * @see ReconnectionConfigurationService#getRCSettings()
     */
    @Nullable
    public synchronized Integer getRCSettings() {
        Integer taskId = null;
        if (mReconnectionConfigurationService != null) {
            taskId = mReconnectionConfigurationService.getRCSettings();
        }
        return taskId;
    }

    /**
     * @see ReconnectionConfigurationService#getRCSettingsClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getRCSettingsClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mReconnectionConfigurationService != null) {
            taskId = mReconnectionConfigurationService.getRCSettingsClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see ReconnectionConfigurationService#startRCSettingsNotification()
     */
    @Nullable
    public synchronized Integer startRCSettingsNotification() {
        Integer taskId = null;
        if (mReconnectionConfigurationService != null) {
            taskId = mReconnectionConfigurationService.startRCSettingsNotification();
        }
        return taskId;
    }

    /**
     * @see ReconnectionConfigurationService#stopRCSettingsNotification()
     */
    @Nullable
    public synchronized Integer stopRCSettingsNotification() {
        Integer taskId = null;
        if (mReconnectionConfigurationService != null) {
            taskId = mReconnectionConfigurationService.stopRCSettingsNotification();
        }
        return taskId;
    }

    /**
     * @see ReconnectionConfigurationService#setReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint)
     */
    @Nullable
    public synchronized Integer setReconnectionConfigurationControlPoint(@NonNull ReconnectionConfigurationControlPoint reconnectionConfigurationControlPoint) {
        Integer taskId = null;
        if (mReconnectionConfigurationService != null) {
            taskId = mReconnectionConfigurationService.setReconnectionConfigurationControlPoint(reconnectionConfigurationControlPoint);
        }
        return taskId;
    }

    /**
     * @see ReconnectionConfigurationService#getReconnectionConfigurationControlPointClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getReconnectionConfigurationControlPointClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mReconnectionConfigurationService != null) {
            taskId = mReconnectionConfigurationService.getReconnectionConfigurationControlPointClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see ReconnectionConfigurationService#startReconnectionConfigurationControlPointIndication()
     */
    @Nullable
    public synchronized Integer startReconnectionConfigurationControlPointIndication() {
        Integer taskId = null;
        if (mReconnectionConfigurationService != null) {
            taskId = mReconnectionConfigurationService.startReconnectionConfigurationControlPointIndication();
        }
        return taskId;
    }

    /**
     * @see ReconnectionConfigurationService#stopReconnectionConfigurationControlPointIndication()
     */
    @Nullable
    public synchronized Integer stopReconnectionConfigurationControlPointIndication() {
        Integer taskId = null;
        if (mReconnectionConfigurationService != null) {
            taskId = mReconnectionConfigurationService.stopReconnectionConfigurationControlPointIndication();
        }
        return taskId;
    }

    /**
     * @see BondManagementService#getBondManagementFeatures()
     */
    @Nullable
    public synchronized Integer getBondManagementFeatures() {
        Integer taskId = null;
        if (mBondManagementService != null) {
            taskId = mBondManagementService.getBondManagementFeatures();
        }
        return taskId;
    }

    /**
     * @see BondManagementService#setBondManagementControlPoint(BondManagementControlPoint)
     */
    @Nullable
    public synchronized Integer setBondManagementControlPoint(@NonNull BondManagementControlPoint bondManagementControlPoint) {
        Integer taskId = null;
        if (mBondManagementService != null) {
            taskId = mBondManagementService.setBondManagementControlPoint(bondManagementControlPoint);
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return ReconnectionConfigurationProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * create {@link ReconnectionConfigurationService} and {@link BondManagementService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        super.createServices();
        if (mReconnectionConfigurationService == null) {
            mReconnectionConfigurationService = new ReconnectionConfigurationService(mBLEConnection, mReconnectionConfigurationProfileCallback, null);
        }
        if (mBondManagementService == null) {
            mBondManagementService = new BondManagementService(mBLEConnection, mReconnectionConfigurationProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mReconnectionConfigurationService = null;
        mBondManagementService = null;
        mHasBondManagementService = false;
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
                if (BOND_MANAGEMENT_SERVICE.equals(bluetoothGattService.getUuid())) {
                    mHasBondManagementService = true;
                }
            }
        }
        super.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, argument);
    }

}
