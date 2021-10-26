package org.im97mori.ble.profile.scpp.central;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.advertising.filter.FilteredLeScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a4f.ScanIntervalWindow;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.scpp.central.db.ScanParametersProfileBondedDatabaseHelper;
import org.im97mori.ble.service.scps.central.ScanParametersService;

import java.util.UUID;

/**
 * Scan Parameters Profile for Central
 */
public class ScanParametersProfile extends AbstractCentralProfile {

    /**
     * {@link ScanParametersProfileCallback} instance
     */
    protected final ScanParametersProfileCallback mScanParametersProfileCallback;

    /**
     * advertising UUID
     */
    protected final UUID mServiceUUId;

    /**
     * {@link ScanParametersService} instance
     */
    protected ScanParametersService mScanParametersService;

    /**
     * @param context                       {@link Context} instance
     * @param scanParametersProfileCallback {@link ScanParametersProfileCallback} instance
     * @param serviceUUID                   advertising UUID
     */
    public ScanParametersProfile(@NonNull Context context, @NonNull ScanParametersProfileCallback scanParametersProfileCallback, @NonNull UUID serviceUUID) {
        super(context, scanParametersProfileCallback);
        mScanParametersProfileCallback = scanParametersProfileCallback;
        mServiceUUId = serviceUUID;
    }

    /**
     * @see ScanParametersService#isScanRefreshCharacteristicSupported
     */
    public Boolean isScanRefreshCharacteristicSupported() {
        Boolean result = null;
        if (mScanParametersService != null) {
            result = mScanParametersService.isScanRefreshCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see ScanParametersService#setScanIntervalWindow(ScanIntervalWindow)
     */
    @Nullable
    public synchronized Integer setScanIntervalWindow(@NonNull ScanIntervalWindow scanIntervalWindow) {
        Integer taskId = null;
        if (mScanParametersService != null) {
            taskId = mScanParametersService.setScanIntervalWindow(scanIntervalWindow);
        }
        return taskId;
    }

    /**
     * @see ScanParametersService#getScanRefreshClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getScanRefreshClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mScanParametersService != null) {
            taskId = mScanParametersService.getScanRefreshClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see ScanParametersService#startScanRefreshNotification()
     */
    @Nullable
    public synchronized Integer startScanRefreshNotification() {
        Integer taskId = null;
        if (mScanParametersService != null) {
            taskId = mScanParametersService.startScanRefreshNotification();
        }
        return taskId;
    }

    /**
     * @see ScanParametersService#stopScanRefreshNotification()
     */
    @Nullable
    public synchronized Integer stopScanRefreshNotification() {
        Integer taskId = null;
        if (mScanParametersService != null) {
            taskId = mScanParametersService.stopScanRefreshNotification();
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return ScanParametersProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * create {@link ScanParametersService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        super.createServices();
        if (mScanParametersService == null) {
            mScanParametersService = new ScanParametersService(mBLEConnection, mScanParametersProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mScanParametersService = null;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected FilteredScanCallback createFilteredScanCallback() {
        return new ScanParametersProfileScanCallback(mServiceUUId, this, null);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    protected FilteredLeScanCallback createFilteredLeScanCallback() {
        return new ScanParametersProfileLeScanCallback(mServiceUUId, this, null);
    }

}
