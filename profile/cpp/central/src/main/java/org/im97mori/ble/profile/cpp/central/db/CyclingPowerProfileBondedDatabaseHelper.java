package org.im97mori.ble.profile.cpp.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Cycling Power Profile bonded device database helper
 */
public class CyclingPowerProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link CyclingPowerProfileBondedDatabaseHelper} instance
     */
    private static CyclingPowerProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link CyclingPowerProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized CyclingPowerProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new CyclingPowerProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "cpp";

    /**
     * @param context {@link Context} instance
     */
    private CyclingPowerProfileBondedDatabaseHelper(@NonNull Context context) {
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
