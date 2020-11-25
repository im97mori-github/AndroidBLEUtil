package org.im97mori.ble.profile.aiop.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback;

public class BaseBuilder extends AutomationIOProfileMockCallback.Builder<AutomationIOProfileMockCallback> {

    public BaseBuilder(@NonNull Context context, @NonNull AutomationIOServiceMockCallback.Builder<? extends AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder) {
        super(context, automationIOServiceMockCallbackBuilder);
    }

}
