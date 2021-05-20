package org.im97mori.ble.profile.rcp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.service.bms.peripheral.BondManagementServiceMockCallback;
import org.im97mori.ble.service.rcs.peripheral.ReconnectionConfigurationServiceMockCallback;

public class BaseBuilder extends ReconnectionConfigurationProfileMockCallback.Builder<ReconnectionConfigurationProfileMockCallback> {

    public BaseBuilder(@NonNull Context context
            , @NonNull ReconnectionConfigurationServiceMockCallback.Builder<? extends ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder
            , @Nullable BondManagementServiceMockCallback.Builder<? extends BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder) {
        super(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);
    }

}
