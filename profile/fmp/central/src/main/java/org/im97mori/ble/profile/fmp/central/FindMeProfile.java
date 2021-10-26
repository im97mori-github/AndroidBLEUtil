package org.im97mori.ble.profile.fmp.central;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.advertising.filter.FilteredLeScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a06.AlertLevel;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.fmp.central.db.FindMeProfileBondedDatabaseHelper;
import org.im97mori.ble.service.ias.central.ImmediateAlertService;

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
        super.createServices();
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
    @NonNull
    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected FilteredScanCallback createFilteredScanCallback() {
        return new FindMeProfileScanCallback(this, null);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    protected FilteredLeScanCallback createFilteredLeScanCallback() {
        return new FindMeProfileLeScanCallback(this, null);
    }

}
