package org.im97mori.ble.profile.pasp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.service.pass.peripheral.PhoneAlertStatusServiceMockCallback;

public class BaseBuilder extends PhoneAlertStatusProfileMockCallback.Builder<PhoneAlertStatusProfileMockCallback> {

    public BaseBuilder(@NonNull Context context
            , @NonNull PhoneAlertStatusServiceMockCallback.Builder<? extends PhoneAlertStatusServiceMockCallback> phoneAlertStatusProfileMockCallbackBuilder) {
        super(context, phoneAlertStatusProfileMockCallbackBuilder);
    }

}