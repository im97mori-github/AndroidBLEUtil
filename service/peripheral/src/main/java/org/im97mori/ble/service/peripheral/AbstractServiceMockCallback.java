package org.im97mori.ble.service.peripheral;

import androidx.annotation.NonNull;

import org.im97mori.ble.MockData;
import org.im97mori.ble.callback.BaseMockCallback;

/**
 * Core Peripheral Service
 */
public abstract class AbstractServiceMockCallback extends BaseMockCallback {

    /**
     * Builder for {@link AbstractServiceMockCallback}
     *
     * @param <T> subclass of {@link AbstractServiceMockCallback}
     */
    public static abstract class Builder<T extends AbstractServiceMockCallback> {

        /**
         * @return {@link MockData} instance
         */
        @NonNull
        public abstract MockData createMockData();

        /**
         * @return {@link AbstractServiceMockCallback} instance
         */
        @NonNull
        public abstract T build();

    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public AbstractServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
    }

}
