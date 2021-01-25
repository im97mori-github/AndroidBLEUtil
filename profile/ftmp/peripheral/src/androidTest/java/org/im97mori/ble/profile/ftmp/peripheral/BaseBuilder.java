package org.im97mori.ble.profile.ftmp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback;

public class BaseBuilder extends FitnessMachineProfileMockCallback.Builder<FitnessMachineProfileMockCallback> {

    public BaseBuilder(@NonNull Context context, @NonNull FitnessMachineServiceMockCallback.Builder<? extends FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder
            , @Nullable FtmpUserDataServiceMockCallback.Builder<? extends FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder
            , @Nullable DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder) {
        super(context, fitnessMachineServiceMockCallbackBuilder, ftmpUserDataServiceMockCallbackBuilder, deviceInformationServiceMockCallbackBuilder);
    }

}
