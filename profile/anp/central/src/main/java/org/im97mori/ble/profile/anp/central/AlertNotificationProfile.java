package org.im97mori.ble.profile.anp.central;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a44.AlertNotificationControlPoint;
import org.im97mori.ble.profile.anp.central.db.AlertNotificationProfileBondedDatabaseHelper;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.service.ans.central.AlertNotificationService;

/**
 * Alert Notification Profile for Central
 */
public class AlertNotificationProfile extends AbstractCentralProfile {

    /**
     * {@link AlertNotificationProfileCallback} instance
     */
    protected final AlertNotificationProfileCallback mAlertNotificationProfileCallback;

    /**
     * {@link AlertNotificationService} instance
     */
    protected AlertNotificationService mAlertNotificationService;

    /**
     * @param context                          {@link Context} instance
     * @param alertNotificationProfileCallback {@link AlertNotificationProfileCallback} instance
     */
    public AlertNotificationProfile(@NonNull Context context, @NonNull AlertNotificationProfileCallback alertNotificationProfileCallback) {
        super(context, alertNotificationProfileCallback);
        mAlertNotificationProfileCallback = alertNotificationProfileCallback;
    }

    /**
     * find Alert Notification Profile device
     *
     * @param argument callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public synchronized Integer findAlertNotificationProfileDevices(@Nullable Bundle argument) {
        return scanDevice(new AlertNotificationProfileScanCallback(this, null), ScanTask.TIMEOUT_MILLIS, argument);
    }

    /**
     * @see AlertNotificationService#getSupportedNewAlertCategory()
     */
    @Nullable
    public synchronized Integer getSupportedNewAlertCategory() {
        Integer taskId = null;
        if (mAlertNotificationService != null) {
            taskId = mAlertNotificationService.getSupportedNewAlertCategory();
        }
        return taskId;
    }

    /**
     * @see AlertNotificationService#getNewAlertClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getNewAlertClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mAlertNotificationService != null) {
            taskId = mAlertNotificationService.getNewAlertClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see AlertNotificationService#startNewAlertNotification()
     */
    @Nullable
    public synchronized Integer startNewAlertNotification() {
        Integer taskId = null;
        if (mAlertNotificationService != null) {
            taskId = mAlertNotificationService.startNewAlertNotification();
        }
        return taskId;
    }

    /**
     * @see AlertNotificationService#stopNewAlertNotification()
     */
    @Nullable
    public synchronized Integer stopNewAlertNotification() {
        Integer taskId = null;
        if (mAlertNotificationService != null) {
            taskId = mAlertNotificationService.stopNewAlertNotification();
        }
        return taskId;
    }

    /**
     * @see AlertNotificationService#getSupportedUnreadAlertCategory()
     */
    @Nullable
    public synchronized Integer getSupportedUnreadAlertCategory() {
        Integer taskId = null;
        if (mAlertNotificationService != null) {
            taskId = mAlertNotificationService.getSupportedUnreadAlertCategory();
        }
        return taskId;
    }

    /**
     * @see AlertNotificationService#getUnreadAlertStatusClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getUnreadAlertStatusClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mAlertNotificationService != null) {
            taskId = mAlertNotificationService.getUnreadAlertStatusClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see AlertNotificationService#startUnreadAlertStatusNotification()
     */
    @Nullable
    public synchronized Integer startUnreadAlertStatusNotification() {
        Integer taskId = null;
        if (mAlertNotificationService != null) {
            taskId = mAlertNotificationService.startUnreadAlertStatusNotification();
        }
        return taskId;
    }

    /**
     * @see AlertNotificationService#stopUnreadAlertStatusNotification()
     */
    @Nullable
    public synchronized Integer stopUnreadAlertStatusNotification() {
        Integer taskId = null;
        if (mAlertNotificationService != null) {
            taskId = mAlertNotificationService.stopUnreadAlertStatusNotification();
        }
        return taskId;
    }

    /**
     * @see AlertNotificationService#setAlertNotificationControlPoint(AlertNotificationControlPoint)
     */
    @Nullable
    public synchronized Integer setAlertNotificationControlPoint(@NonNull AlertNotificationControlPoint alertNotificationControlPoint) {
        Integer taskId = null;
        if (mAlertNotificationService != null) {
            taskId = mAlertNotificationService.setAlertNotificationControlPoint(alertNotificationControlPoint);
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return AlertNotificationProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * create {@link AlertNotificationService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        super.createServices();
        if (mAlertNotificationService == null) {
            mAlertNotificationService = new AlertNotificationService(mBLEConnection, mAlertNotificationProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mAlertNotificationService = null;
    }

}
