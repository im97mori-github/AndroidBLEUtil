package org.im97mori.ble.profile.lnp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback;

public class BaseBuilder extends LocationAndNavigationProfileMockCallback.Builder<LocationAndNavigationProfileMockCallback> {

    public BaseBuilder(@NonNull Context context, @NonNull DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder
            , @NonNull BatteryServiceMockCallback.Builder<? extends BatteryServiceMockCallback> batteryServiceMockCallbackBuilder
            , @NonNull LocationAndNavigationServiceMockCallback.Builder<? extends LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder) {
        super(context, deviceInformationServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder, locationAndNavigationServiceMockCallbackBuilder);
    }

}
