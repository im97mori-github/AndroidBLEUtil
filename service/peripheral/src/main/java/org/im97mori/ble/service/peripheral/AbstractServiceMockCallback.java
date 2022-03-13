package org.im97mori.ble.service.peripheral;

import androidx.annotation.NonNull;

import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.callback.BaseMockCallback;

import java.util.Collections;

/**
 * Core Peripheral Service
 */
public abstract class AbstractServiceMockCallback extends BaseMockCallback {

    /**
     * Builder for {@link AbstractServiceMockCallback}
     *
     * @param <T1> subclass of {@link AbstractServiceMockCallback}
     * @param <T2> data class
     */
    public static abstract class Builder<T1 extends BaseMockCallback, T2> {

        /**
         * @return {@link T2} instance
         */
        @NonNull
        public abstract T2 createData();

        /**
         * @return {@link AbstractServiceMockCallback} instance
         */
        @NonNull
        public abstract T1 build();

    }

    /**
     * @param serviceData {@link ServiceData} instance
     * @param isFallback  fallback flag
     */
    public AbstractServiceMockCallback(@NonNull ServiceData serviceData, boolean isFallback) {
        super(new MockData(Collections.singletonList(serviceData)), isFallback);
    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public AbstractServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
    }

}
