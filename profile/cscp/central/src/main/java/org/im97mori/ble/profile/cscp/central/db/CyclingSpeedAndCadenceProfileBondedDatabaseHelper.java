package org.im97mori.ble.profile.cscp.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Cycling Speed and Cadence Profile bonded device database helper
 */
public class CyclingSpeedAndCadenceProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link CyclingSpeedAndCadenceProfileBondedDatabaseHelper} instance
     */
    private static CyclingSpeedAndCadenceProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link CyclingSpeedAndCadenceProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized CyclingSpeedAndCadenceProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new CyclingSpeedAndCadenceProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "cscp";

    /**
     * @param context {@link Context} instance
     */
    private CyclingSpeedAndCadenceProfileBondedDatabaseHelper(@NonNull Context context) {
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
