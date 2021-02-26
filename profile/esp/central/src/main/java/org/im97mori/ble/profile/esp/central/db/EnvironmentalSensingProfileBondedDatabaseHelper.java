package org.im97mori.ble.profile.esp.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Environmental Sensing Profile bonded device database helper
 */
public class EnvironmentalSensingProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link EnvironmentalSensingProfileBondedDatabaseHelper} instance
     */
    private static EnvironmentalSensingProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link EnvironmentalSensingProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized EnvironmentalSensingProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new EnvironmentalSensingProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "esp";

    /**
     * @param context {@link Context} instance
     */
    private EnvironmentalSensingProfileBondedDatabaseHelper(@NonNull Context context) {
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
