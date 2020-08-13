package org.im97mori.ble.profile.fmp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.characteristic.u2a06.AlertLevel;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.ServiceUUID.IMMEDIATE_ALERT_SERVICE;

/**
 * Find Me Profile for Peripheral
 */
public class FindMeProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link FindMeProfileMockCallback}
     *
     * @param <T> subclass of {@link FindMeProfileMockCallback}
     */
    public static class Builder<T extends FindMeProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback.Builder} instance
         */
        protected final ImmediateAlertServiceMockCallback.Builder<? extends ImmediateAlertServiceMockCallback> mImmediateAlertServiceMockCallbackBuilder;

        /**
         * @param context                                     {@link Context} instance
         * @param immediateAlertServiceMockCallbackBuilder {@link org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull ImmediateAlertServiceMockCallback.Builder<? extends ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder) {
            mContext = context;
            mImmediateAlertServiceMockCallbackBuilder = immediateAlertServiceMockCallbackBuilder;
        }

        /**
         * @see org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback.Builder#addAlertLevel(int)
         */
        @NonNull
        public FindMeProfileMockCallback.Builder<T> addAlertLevel(int alertLevel) {
            mImmediateAlertServiceMockCallbackBuilder.addAlertLevel(alertLevel);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback.Builder#addAlertLevel(AlertLevel)
         */
        @NonNull
        public FindMeProfileMockCallback.Builder<T> addAlertLevel(@NonNull AlertLevel alertLevel) {
            mImmediateAlertServiceMockCallbackBuilder.addAlertLevel(alertLevel);
            return this;
        }


        /**
         * @see org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback.Builder#addAlertLevel(byte[])
         */
        @NonNull
        public FindMeProfileMockCallback.Builder<T> addAlertLevel(@NonNull byte[] value) {
            mImmediateAlertServiceMockCallbackBuilder.addAlertLevel(value);
            return this;
        }


        /**
         * @see org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback.Builder#addAlertLevel(int, long, byte[])
         */
        @NonNull
        public FindMeProfileMockCallback.Builder<T> addAlertLevel(int responceCode, long delay, @NonNull byte[] value) {
            mImmediateAlertServiceMockCallbackBuilder.addAlertLevel(responceCode, delay, value);
            return this;
        }


        /**
         * @see org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback.Builder#removeAlertLevel()
         */
        @NonNull
        public FindMeProfileMockCallback.Builder<T> removeAlertLevel() {
            mImmediateAlertServiceMockCallbackBuilder.removeAlertLevel();
            return this;
        }

        /**
         * @return {@link FindMeProfileMockCallback} instance
         */
        public FindMeProfileMockCallback build() {
            return new FindMeProfileMockCallback(mContext, mImmediateAlertServiceMockCallbackBuilder.build());
        }

    }

    /**
     * @param context                           {@link Context} instance
     * @param immediateAlertServiceMockCallback {@link ImmediateAlertServiceMockCallback} instance
     */
    public FindMeProfileMockCallback(@NonNull Context context
            , @NonNull ImmediateAlertServiceMockCallback immediateAlertServiceMockCallback) {
        super(context, true, immediateAlertServiceMockCallback);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public UUID getServiceUUID() {
        return IMMEDIATE_ALERT_SERVICE;
    }

}
