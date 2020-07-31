package org.im97mori.ble.profile.lnp.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Location and Navigation Profile bonded device database helper
 */
public class LocationAndNavigationProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link LocationAndNavigationProfileBondedDatabaseHelper} instance
     */
    private static LocationAndNavigationProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link LocationAndNavigationProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized LocationAndNavigationProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new LocationAndNavigationProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "lnp";

    /**
     * @param context {@link Context} instance
     */
    private LocationAndNavigationProfileBondedDatabaseHelper(@NonNull Context context) {
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
