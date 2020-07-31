package org.im97mori.ble.profile.blp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.service.bls.peripheral.BloodPressureServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;

public class BaseBuilder extends BloodPressureProfileMockCallback.Builder<BloodPressureProfileMockCallback> {

    public BaseBuilder(@NonNull Context context, @NonNull DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder, @NonNull BloodPressureServiceMockCallback.Builder<? extends BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder) {
        super(context, deviceInformationServiceMockCallbackBuilder, bloodPressureServiceMockCallbackBuilder);
    }

}
