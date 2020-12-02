package org.im97mori.ble.profile.anp.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Alert Notification Profile bonded device database helper
 */
public class AlertNotificationProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link AlertNotificationProfileBondedDatabaseHelper} instance
     */
    private static AlertNotificationProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link AlertNotificationProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized AlertNotificationProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new AlertNotificationProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "anp";

    /**
     * @param context {@link Context} instance
     */
    private AlertNotificationProfileBondedDatabaseHelper(@NonNull Context context) {
        super(context);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    protected String getProfileName() {
        return PROFILE_NAME;
    }

}
