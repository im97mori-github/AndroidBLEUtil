package org.im97mori.ble.profile.wsp.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

/**
 * Weight Scale Profile bonded device database helper
 */
public class WeightScaleProfileBondedDatabaseHelper extends BondedDeviceDatabaseHelper {

    /**
     * {@link WeightScaleProfileBondedDatabaseHelper} instance
     */
    private static WeightScaleProfileBondedDatabaseHelper HELPER;

    /**
     * for Singleton
     *
     * @param context {@link Context} instance
     * @return {@link WeightScaleProfileBondedDatabaseHelper} instance
     */
    @NonNull
    public static synchronized WeightScaleProfileBondedDatabaseHelper getInstance(@NonNull Context context) {
        if (HELPER == null) {
            HELPER = new WeightScaleProfileBondedDatabaseHelper(context);
        }
        return HELPER;
    }

    /**
     * profile name
     */
    public static final String PROFILE_NAME = "wsp";

    /**
     * @param context {@link Context} instance
     */
    private WeightScaleProfileBondedDatabaseHelper(@NonNull Context context) {
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
