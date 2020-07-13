package org.im97mori.ble.profile.central;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;

import java.util.concurrent.atomic.AtomicBoolean;

public class BaseAbstractCentralProfile extends AbstractCentralProfile {

    public AtomicBoolean result = new AtomicBoolean(false);

    /**
     * @param context         {@link Context} instance
     * @param profileCallback {@link ProfileCallback} instance
     */
    public BaseAbstractCentralProfile(@NonNull Context context, @NonNull ProfileCallback profileCallback) {
        super(context, profileCallback);
    }

    @Nullable
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return null;
    }

    @Override
    protected void createServices() {

    }
}
