package org.im97mori.ble.profile.rscp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.rscs.peripheral.RunningSpeedAndCadenceServiceMockCallback;

public class BaseBuilder extends RunningSpeedAndCadenceProfileMockCallback.Builder<RunningSpeedAndCadenceProfileMockCallback> {

    public BaseBuilder(@NonNull Context context, @NonNull RunningSpeedAndCadenceServiceMockCallback.Builder<? extends RunningSpeedAndCadenceServiceMockCallback> runningPowerServiceMockCallbackBuilder
            , @Nullable DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder) {
        super(context, runningPowerServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
    }

}