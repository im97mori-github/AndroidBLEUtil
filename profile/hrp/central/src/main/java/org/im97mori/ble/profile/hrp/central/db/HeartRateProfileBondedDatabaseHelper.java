package org.im97mori.ble.profile.hrp.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Heart Rate Profile bonded device database helper
 */
public class HeartRateProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link HeartRateProfileBondedDatabaseHelper} instance
     */
    private static HeartRateProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link HeartRateProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized HeartRateProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new HeartRateProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "hrp";

    /**
     * @param context {@link Context} instance
     */
    private HeartRateProfileBondedDatabaseHelper(@NonNull Context context) {
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
