package org.im97mori.ble.profile.lnp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback;

public class BaseBuilder extends LocationAndNavigationProfileMockCallback.Builder<LocationAndNavigationProfileMockCallback> {

    public BaseBuilder(@NonNull Context context
            , @NonNull LocationAndNavigationServiceMockCallback.Builder<? extends LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder
            , @Nullable DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder
            , @Nullable BatteryServiceMockCallback.Builder<? extends BatteryServiceMockCallback> batteryServiceMockCallbackBuilder) {
        super(context, locationAndNavigationServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder);
    }

}
