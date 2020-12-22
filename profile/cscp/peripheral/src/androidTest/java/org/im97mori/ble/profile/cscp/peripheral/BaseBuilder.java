package org.im97mori.ble.profile.cscp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;

public class BaseBuilder extends CyclingSpeedAndCadenceProfileMockCallback.Builder<CyclingSpeedAndCadenceProfileMockCallback> {

    public BaseBuilder(@NonNull Context context, @NonNull CyclingSpeedAndCadenceServiceMockCallback.Builder<? extends CyclingSpeedAndCadenceServiceMockCallback> cyclingPowerServiceMockCallbackBuilder
            , @Nullable DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder) {
        super(context, cyclingPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
    }

}