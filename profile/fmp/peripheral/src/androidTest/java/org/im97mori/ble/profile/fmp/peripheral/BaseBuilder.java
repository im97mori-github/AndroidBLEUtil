package org.im97mori.ble.profile.fmp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback;

public class BaseBuilder extends FindMeProfileMockCallback.Builder<FindMeProfileMockCallback> {

    public BaseBuilder(@NonNull Context context, @NonNull ImmediateAlertServiceMockCallback.Builder<? extends ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder) {
        super(context, immediateAlertServiceMockCallbackBuilder);
    }

}
