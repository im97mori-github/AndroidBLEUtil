package org.im97mori.ble.profile.fmp.central;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a06.AlertLevel;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.profile.fmp.central.db.FindMeProfileBondedDatabaseHelper;
import org.im97mori.ble.service.ias.central.ImmediateAlertService;
import org.im97mori.ble.task.DiscoverServiceTask;

/**
 * Find Me Profile for Central
 */
public class FindMeProfile extends AbstractCentralProfile {

    /**
     * {@link FindMeProfileCallback} instance
     */
    protected final FindMeProfileCallback mFindMeProfileCallback;

    /**
     * {@link ImmediateAlertService} instance
     */
    protected ImmediateAlertService mImmediateAlertService;

    /**
     * @param context               {@link Context} instance
     * @param findMeProfileCallback {@link FindMeProfileCallback} instance
     */
    public FindMeProfile(@NonNull Context context, @NonNull FindMeProfileCallback findMeProfileCallback) {
        super(context, findMeProfileCallback);
        mFindMeProfileCallback = findMeProfileCallback;
    }

    /**
     * find Find Me Profile device
     *
     * @param argument callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public synchronized Integer findFindMeProfileDevices(@Nullable Bundle argument) {
        return scanDevice(new FindMeProfileScanCallback(this, null), ScanTask.TIMEOUT_MILLIS, argument);
    }

    /**
     * @see ImmediateAlertService#setAlertLevel(AlertLevel)
     */
    @Nullable
    public synchronized Integer setAlertLevel(@NonNull AlertLevel alertLevel) {
        Integer taskId = null;
        if (mImmediateAlertService != null) {
            taskId = mImmediateAlertService.setAlertLevel(alertLevel);
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return FindMeProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * create {@link ImmediateAlertService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        if (mImmediateAlertService == null) {
            mImmediateAlertService = new ImmediateAlertService(mBLEConnection, mFindMeProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mImmediateAlertService = null;
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

}
