package org.im97mori.ble.profile.pasp.central;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.advertising.filter.FilteredLeScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a40.RingerControlPoint;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.pasp.central.db.PhoneAlertStatusProfileBondedDatabaseHelper;
import org.im97mori.ble.service.pass.central.PhoneAlertStatusService;
import org.im97mori.ble.task.DiscoverServiceTask;

/**
 * Phone Alert Status Profile for Central
 */
public class PhoneAlertStatusProfile extends AbstractCentralProfile {

    /**
     * {@link PhoneAlertStatusProfileCallback} instance
     */
    protected final PhoneAlertStatusProfileCallback mPhoneAlertStatusProfileCallback;

    /**
     * {@link PhoneAlertStatusService} instance
     */
    protected PhoneAlertStatusService mPhoneAlertStatusService;

    /**
     * @param context                         {@link Context} instance
     * @param phoneAlertStatusProfileCallback {@link PhoneAlertStatusProfileCallback} instance
     */
    public PhoneAlertStatusProfile(@NonNull Context context, @NonNull PhoneAlertStatusProfileCallback phoneAlertStatusProfileCallback) {
        super(context, phoneAlertStatusProfileCallback);
        mPhoneAlertStatusProfileCallback = phoneAlertStatusProfileCallback;
    }

    /**
     * @see PhoneAlertStatusService#getAlertStatus()
     */
    @Nullable
    public synchronized Integer getAlertStatus() {
        Integer taskId = null;
        if (mPhoneAlertStatusService != null) {
            taskId = mPhoneAlertStatusService.getAlertStatus();
        }
        return taskId;
    }

    /**
     * @see PhoneAlertStatusService#getAlertStatusClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getAlertStatusClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mPhoneAlertStatusService != null) {
            taskId = mPhoneAlertStatusService.getAlertStatusClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see PhoneAlertStatusService#startAlertStatusNotification()
     */
    @Nullable
    public synchronized Integer startAlertStatusNotification() {
        Integer taskId = null;
        if (mPhoneAlertStatusService != null) {
            taskId = mPhoneAlertStatusService.startAlertStatusNotification();
        }
        return taskId;
    }

    /**
     * @see PhoneAlertStatusService#stopAlertStatusNotification()
     */
    @Nullable
    public synchronized Integer stopAlertStatusNotification() {
        Integer taskId = null;
        if (mPhoneAlertStatusService != null) {
            taskId = mPhoneAlertStatusService.stopAlertStatusNotification();
        }
        return taskId;
    }

    /**
     * @see PhoneAlertStatusService#getRingerSetting()
     */
    @Nullable
    public synchronized Integer getRingerSetting() {
        Integer taskId = null;
        if (mPhoneAlertStatusService != null) {
            taskId = mPhoneAlertStatusService.getRingerSetting();
        }
        return taskId;
    }

    /**
     * @see PhoneAlertStatusService#getRingerSettingClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getRingerSettingClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mPhoneAlertStatusService != null) {
            taskId = mPhoneAlertStatusService.getRingerSettingClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see PhoneAlertStatusService#startRingerSettingNotification()
     */
    @Nullable
    public synchronized Integer startRingerSettingNotification() {
        Integer taskId = null;
        if (mPhoneAlertStatusService != null) {
            taskId = mPhoneAlertStatusService.startRingerSettingNotification();
        }
        return taskId;
    }

    /**
     * @see PhoneAlertStatusService#stopRingerSettingNotification()
     */
    @Nullable
    public synchronized Integer stopRingerSettingNotification() {
        Integer taskId = null;
        if (mPhoneAlertStatusService != null) {
            taskId = mPhoneAlertStatusService.stopRingerSettingNotification();
        }
        return taskId;
    }

    /**
     * @see PhoneAlertStatusService#setRingerControlPoint(RingerControlPoint)
     */
    @Nullable
    public synchronized Integer setRingerControlPoint(@NonNull RingerControlPoint ringerControlPoint) {
        Integer taskId = null;
        if (mPhoneAlertStatusService != null) {
            taskId = mPhoneAlertStatusService.setRingerControlPoint(ringerControlPoint);
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return PhoneAlertStatusProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * create {@link PhoneAlertStatusService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        super.createServices();
        if (mPhoneAlertStatusService == null) {
            mPhoneAlertStatusService = new PhoneAlertStatusService(mBLEConnection, mPhoneAlertStatusProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mPhoneAlertStatusService = null;
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
    @NonNull
    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected FilteredScanCallback createFilteredScanCallback() {
        return new PhoneAlertStatusProfileScanCallback(this, null);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    protected FilteredLeScanCallback createFilteredLeScanCallback() {
        return new PhoneAlertStatusProfileLeScanCallback(this, null);
    }

}
