package org.im97mori.ble.profile.blp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.service.bls.peripheral.BloodPressureServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;

public class BaseBuilder extends BloodPressureProfileMockCallback.Builder<BloodPressureProfileMockCallback> {

    public BaseBuilder(@NonNull Context context
            , @NonNull BloodPressureServiceMockCallback.Builder<? extends BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder
            , @Nullable DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder) {
        super(context, bloodPressureServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
    }

}
