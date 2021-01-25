package org.im97mori.ble.profile.ftmp.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Fitness Machine Profile bonded device database helper
 */
public class FitnessMachineProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link FitnessMachineProfileBondedDatabaseHelper} instance
     */
    private static FitnessMachineProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link FitnessMachineProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized FitnessMachineProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new FitnessMachineProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "ftmp";

    /**
     * @param context {@link Context} instance
     */
    private FitnessMachineProfileBondedDatabaseHelper(@NonNull Context context) {
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
