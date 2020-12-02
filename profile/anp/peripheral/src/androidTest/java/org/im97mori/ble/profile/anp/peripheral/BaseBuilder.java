package org.im97mori.ble.profile.anp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback;

public class BaseBuilder extends AlertNotificationProfileMockCallback.Builder<AlertNotificationProfileMockCallback> {

    public BaseBuilder(@NonNull Context context, @NonNull AlertNotificationServiceMockCallback.Builder<? extends AlertNotificationServiceMockCallback> alertNotificationServiceMockCallbackBuilder) {
        super(context, alertNotificationServiceMockCallbackBuilder);
    }

}
