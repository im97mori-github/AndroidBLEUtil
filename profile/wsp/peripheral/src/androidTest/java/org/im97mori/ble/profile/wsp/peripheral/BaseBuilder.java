package org.im97mori.ble.profile.wsp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback;
import org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback;
import org.im97mori.ble.service.wss.peripheral.WeightScaleServiceMockCallback;

public class BaseBuilder extends WeightScaleProfileMockCallback.Builder<WeightScaleProfileMockCallback> {

    public BaseBuilder(@NonNull Context context
            , @NonNull WeightScaleServiceMockCallback.Builder<? extends WeightScaleServiceMockCallback> weightScaleServiceMockCallbackBuilder
            , @NonNull DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder
            , @Nullable UserDataServiceMockCallback.Builder<? extends UserDataServiceMockCallback> userDataServiceMockCallbackBuilder
            , @Nullable BatteryServiceMockCallback.Builder<? extends BatteryServiceMockCallback> batteryServiceMockCallbackBuilder
            , @Nullable CurrentTimeServiceMockCallback.Builder<? extends CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder) {
        super(context, weightScaleServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder, userDataServiceMockCallbackBuilder, batteryServiceMockCallbackBuilder, currentTimeServiceMockCallbackBuilder);
    }

}
