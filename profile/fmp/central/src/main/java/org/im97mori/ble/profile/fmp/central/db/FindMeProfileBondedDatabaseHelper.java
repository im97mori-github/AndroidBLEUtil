package org.im97mori.ble.profile.fmp.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Find Me Profile bonded device database helper
 */
public class FindMeProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link FindMeProfileBondedDatabaseHelper} instance
     */
    private static FindMeProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link FindMeProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized FindMeProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new FindMeProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "fmp";

    /**
     * @param context {@link Context} instance
     */
    private FindMeProfileBondedDatabaseHelper(@NonNull Context context) {
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
