package org.im97mori.ble.profile.pasp.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Phone Alert Status Profile bonded device database helper
 */
public class PhoneAlertStatusProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link PhoneAlertStatusProfileBondedDatabaseHelper} instance
     */
    private static PhoneAlertStatusProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link PhoneAlertStatusProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized PhoneAlertStatusProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new PhoneAlertStatusProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "pasp";

    /**
     * @param context {@link Context} instance
     */
    private PhoneAlertStatusProfileBondedDatabaseHelper(@NonNull Context context) {
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
