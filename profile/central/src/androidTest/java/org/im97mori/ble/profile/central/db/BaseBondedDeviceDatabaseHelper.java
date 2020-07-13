package org.im97mori.ble.profile.central.db;

import android.content.Context;

import androidx.annotation.NonNull;

public class BaseBondedDeviceDatabaseHelper extends BondedDeviceDatabaseHelper {

    public static final String PROFILE_NAME = "PROFILE_NAME";

    public BaseBondedDeviceDatabaseHelper(@NonNull Context context) {
        super(context);
    }

    @NonNull
    @Override
    protected String getProfileName() {
        return PROFILE_NAME;
    }

}
