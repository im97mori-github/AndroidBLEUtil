package org.im97mori.ble.profile.htp.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Health Thermometer Profile bonded device database helper
 */
public class HealthThermometerProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link HealthThermometerProfileBondedDatabaseHelper} instance
     */
    private static HealthThermometerProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link HealthThermometerProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized HealthThermometerProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new HealthThermometerProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "htp";

    /**
     * @param context {@link Context} instance
     */
    private HealthThermometerProfileBondedDatabaseHelper(@NonNull Context context) {
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
