package org.im97mori.ble.profile.blp.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Blood Pressure Profile bonded device database helper
 */
public class BloodPressureProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link BloodPressureProfileBondedDatabaseHelper} instance
     */
    private static BloodPressureProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link BloodPressureProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized BloodPressureProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new BloodPressureProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "blp";

    /**
     * @param context {@link Context} instance
     */
    private BloodPressureProfileBondedDatabaseHelper(@NonNull Context context) {
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
