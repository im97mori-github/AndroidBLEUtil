package org.im97mori.ble.profile.rcp.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Reconnection Configuration Profile bonded device database helper
 */
public class ReconnectionConfigurationProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link ReconnectionConfigurationProfileBondedDatabaseHelper} instance
     */
    private static ReconnectionConfigurationProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link ReconnectionConfigurationProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized ReconnectionConfigurationProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new ReconnectionConfigurationProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "rcp";

    /**
     * @param context {@link Context} instance
     */
    private ReconnectionConfigurationProfileBondedDatabaseHelper(@NonNull Context context) {
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
