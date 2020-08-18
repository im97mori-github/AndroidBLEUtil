package org.im97mori.ble.profile.pxp.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Proximity  Profile bonded device database helper
 */
public class ProximityProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link ProximityProfileBondedDatabaseHelper} instance
     */
    private static ProximityProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link ProximityProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized ProximityProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new ProximityProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "pxp";

    /**
     * @param context {@link Context} instance
     */
    private ProximityProfileBondedDatabaseHelper(@NonNull Context context) {
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
