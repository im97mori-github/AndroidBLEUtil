package org.im97mori.ble.profile.cpp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback;
import org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;

public class BaseBuilder extends CyclingPowerProfileMockCallback.Builder<CyclingPowerProfileMockCallback> {

    public BaseBuilder(@NonNull Context context, @NonNull CyclingPowerServiceMockCallback.Builder<? extends CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder
            , @Nullable DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder
            , @Nullable BatteryServiceMockCallback.Builder<? extends BatteryServiceMockCallback> batteryServiceMockCallbackBuilder) {
        super(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
    }

}
