package org.im97mori.ble.profile.scpp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.service.scps.peripheral.ScanParametersServiceMockCallback;

public class BaseBuilder extends ScanParametersProfileMockCallback.Builder<ScanParametersProfileMockCallback> {

    public BaseBuilder(@NonNull Context context
            , @NonNull ScanParametersServiceMockCallback.Builder<? extends ScanParametersServiceMockCallback> scanParametersServiceMockCallbackBuilder) {
        super(context, scanParametersServiceMockCallbackBuilder);
    }

}
