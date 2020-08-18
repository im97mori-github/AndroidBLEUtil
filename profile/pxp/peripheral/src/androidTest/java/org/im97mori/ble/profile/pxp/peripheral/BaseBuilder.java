package org.im97mori.ble.profile.pxp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback;
import org.im97mori.ble.service.lls.peripheral.LinkLossServiceMockCallback;
import org.im97mori.ble.service.tps.peripheral.TxPowerServiceMockCallback;

public class BaseBuilder extends ProximityProfileMockCallback.Builder<ProximityProfileMockCallback> {

    public BaseBuilder(@NonNull Context context
            , @NonNull LinkLossServiceMockCallback.Builder<? extends LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder
            , @NonNull ImmediateAlertServiceMockCallback.Builder<? extends ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder
            , @NonNull TxPowerServiceMockCallback.Builder<? extends TxPowerServiceMockCallback> txPowerServiceMockCallbackBuilder) {
        super(context, linkLossServiceMockCallbackBuilder, immediateAlertServiceMockCallbackBuilder, txPowerServiceMockCallbackBuilder);
    }

}
