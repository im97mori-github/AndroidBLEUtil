package org.im97mori.ble.service.tip.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback;
import org.im97mori.ble.service.ndcs.peripheral.NextDstChangeServiceMockCallback;
import org.im97mori.ble.service.rtus.peripheral.ReferenceTimeUpdateServiceMockCallback;

public class BaseBuilder extends TimeProfileMockCallback.Builder<TimeProfileMockCallback> {

    public BaseBuilder(@NonNull Context context
            , @NonNull CurrentTimeServiceMockCallback.Builder<? extends CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder
            , @Nullable NextDstChangeServiceMockCallback.Builder<? extends NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder
            , @Nullable ReferenceTimeUpdateServiceMockCallback.Builder<? extends ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder) {
        super(context, currentTimeServiceMockCallbackBuilder, nextDstChangeServiceMockCallbackBuilder, referenceTimeUpdateServiceMockCallbackBuilder);
    }

}
