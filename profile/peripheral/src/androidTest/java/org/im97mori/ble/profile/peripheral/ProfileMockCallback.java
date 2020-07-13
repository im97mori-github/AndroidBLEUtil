package org.im97mori.ble.profile.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEServerCallback;

import java.util.UUID;

public class ProfileMockCallback extends AbstractProfileMockCallback {

    public static final UUID SERVICE_UUID = UUID.randomUUID();

    public ProfileMockCallback(@NonNull Context context, boolean isAdvertising, @NonNull BLEServerCallback... bleServerCallbacks) {
        super(context, isAdvertising, bleServerCallbacks);
    }

    @NonNull
    @Override
    public UUID getServiceUUID() {
        return SERVICE_UUID;
    }

}
