package org.im97mori.ble.profile.hrp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.hrs.peripheral.HeartRateServiceMockCallback;

public class BaseBuilder extends HeartRateProfileMockCallback.Builder<HeartRateProfileMockCallback> {

    public BaseBuilder(@NonNull Context context, @NonNull DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder, @NonNull HeartRateServiceMockCallback.Builder<? extends HeartRateServiceMockCallback> heartRateServiceMockCallbackBuilder) {
        super(context, deviceInformationServiceMockCallbackBuilder, heartRateServiceMockCallbackBuilder);
    }

}
