package org.im97mori.ble.profile.tip.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Time Profile bonded device database helper
 */
public class TimeProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link TimeProfileBondedDatabaseHelper} instance
     */
    private static TimeProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link TimeProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized TimeProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new TimeProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "tip";

    /**
     * @param context {@link Context} instance
     */
    private TimeProfileBondedDatabaseHelper(@NonNull Context context) {
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
