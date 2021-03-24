package org.im97mori.ble.profile.scpp.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Scan Parameters Profile bonded device database helper
 */
public class ScanParametersProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link ScanParametersProfileBondedDatabaseHelper} instance
     */
    private static ScanParametersProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link ScanParametersProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized ScanParametersProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new ScanParametersProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "scpp";

    /**
     * @param context {@link Context} instance
     */
    private ScanParametersProfileBondedDatabaseHelper(@NonNull Context context) {
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
