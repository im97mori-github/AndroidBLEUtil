package org.im97mori.ble.profile.rscp.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Running Speed and Cadence Profile bonded device database helper
 */
public class RunningSpeedAndCadenceProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link RunningSpeedAndCadenceProfileBondedDatabaseHelper} instance
     */
    private static RunningSpeedAndCadenceProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link RunningSpeedAndCadenceProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized RunningSpeedAndCadenceProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new RunningSpeedAndCadenceProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "rscp";

    /**
     * @param context {@link Context} instance
     */
    private RunningSpeedAndCadenceProfileBondedDatabaseHelper(@NonNull Context context) {
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
