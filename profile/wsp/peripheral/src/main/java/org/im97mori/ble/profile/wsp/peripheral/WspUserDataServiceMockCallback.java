package org.im97mori.ble.profile.wsp.peripheral;

import android.bluetooth.BluetoothDevice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.MockData;
import org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback;

/**
 * Weight Scale Profile specific {@link UserDataServiceMockCallback}
 */
public class WspUserDataServiceMockCallback extends UserDataServiceMockCallback {

    /**
     * Builder for {@link WspUserDataServiceMockCallback}
     *
     * @param <T> subclass of {@link WspUserDataServiceMockCallback}
     */
    public static class Builder<T extends WspUserDataServiceMockCallback> extends UserDataServiceMockCallback.Builder<WspUserDataServiceMockCallback> {

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public WspUserDataServiceMockCallback build() {
            return new WspUserDataServiceMockCallback(createMockData(), false);
        }

    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public WspUserDataServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
    }

    /**
     * check consent status
     *
     * @param device    target device
     * @param userIndex target user index
     * @return {@code true}:no consent, {@code false}:has consent
     */
    public boolean hasNoConsent(@NonNull BluetoothDevice device, @Nullable Integer userIndex) {
        boolean result;
        if (userIndex == null) {
            result = true;
        } else {
            result = !userIndex.equals(mCurrentUserMap.get(device));
        }
        return result;
    }

}
