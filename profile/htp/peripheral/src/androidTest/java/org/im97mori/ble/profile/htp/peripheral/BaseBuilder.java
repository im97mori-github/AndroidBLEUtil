package org.im97mori.ble.profile.htp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.hts.peripheral.HealthThermometerServiceMockCallback;

public class BaseBuilder extends HealthThermometerProfileMockCallback.Builder<HealthThermometerProfileMockCallback> {

    public BaseBuilder(@NonNull Context context, @NonNull DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder, @NonNull HealthThermometerServiceMockCallback.Builder<? extends HealthThermometerServiceMockCallback> healthThermometerServiceMockCallbackBuilder) {
        super(context, deviceInformationServiceMockCallbackBuilder, healthThermometerServiceMockCallbackBuilder);
    }

}
