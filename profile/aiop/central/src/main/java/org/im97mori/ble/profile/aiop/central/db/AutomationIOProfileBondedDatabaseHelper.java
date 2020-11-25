package org.im97mori.ble.profile.aiop.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Automation IO Profile bonded device database helper
 */
public class AutomationIOProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link AutomationIOProfileBondedDatabaseHelper} instance
     */
    private static AutomationIOProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link AutomationIOProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized AutomationIOProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new AutomationIOProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "aiop";

    /**
     * @param context {@link Context} instance
     */
    private AutomationIOProfileBondedDatabaseHelper(@NonNull Context context) {
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
