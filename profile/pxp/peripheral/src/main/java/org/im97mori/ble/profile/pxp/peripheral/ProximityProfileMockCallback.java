package org.im97mori.ble.profile.pxp.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.characteristic.u2a06.AlertLevel;
import org.im97mori.ble.characteristic.u2a07.TxPowerLevel;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback;
import org.im97mori.ble.service.lls.peripheral.LinkLossServiceMockCallback;
import org.im97mori.ble.service.tps.peripheral.TxPowerServiceMockCallback;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

import static org.im97mori.ble.constants.ServiceUUID.LINK_LOSS_SERVICE;

/**
 * Proximity Profile for Peripheral
 */
public class ProximityProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link ProximityProfileMockCallback}
     *
     * @param <T> subclass of {@link ProximityProfileMockCallback}
     */
    public static class Builder<T extends ProximityProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.lls.peripheral.LinkLossServiceMockCallback.Builder} instance
         */
        protected final LinkLossServiceMockCallback.Builder<? extends LinkLossServiceMockCallback> mLinkLossServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback.Builder} instance
         */
        protected final ImmediateAlertServiceMockCallback.Builder<? extends ImmediateAlertServiceMockCallback> mImmediateAlertServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.tps.peripheral.TxPowerServiceMockCallback.Builder} instance
         */
        protected final TxPowerServiceMockCallback.Builder<? extends TxPowerServiceMockCallback> mTxPowerServiceMockCallbackBuilder;

        /**
         * @param context                                  {@link Context} instance
         * @param linkLossServiceMockCallbackBuilder       {@link org.im97mori.ble.service.lls.peripheral.LinkLossServiceMockCallback.Builder} instance
         * @param immediateAlertServiceMockCallbackBuilder {@link org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback.Builder} instance
         * @param txPowerServiceMockCallbackBuilder        {@link org.im97mori.ble.service.tps.peripheral.TxPowerServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull LinkLossServiceMockCallback.Builder<? extends LinkLossServiceMockCallback> linkLossServiceMockCallbackBuilder
                , @NonNull ImmediateAlertServiceMockCallback.Builder<? extends ImmediateAlertServiceMockCallback> immediateAlertServiceMockCallbackBuilder
                , @NonNull TxPowerServiceMockCallback.Builder<? extends TxPowerServiceMockCallback> txPowerServiceMockCallbackBuilder) {
            mContext = context;
            mLinkLossServiceMockCallbackBuilder = linkLossServiceMockCallbackBuilder;
            mImmediateAlertServiceMockCallbackBuilder = immediateAlertServiceMockCallbackBuilder;
            mTxPowerServiceMockCallbackBuilder = txPowerServiceMockCallbackBuilder;
        }

        /**
         * @see org.im97mori.ble.service.lls.peripheral.LinkLossServiceMockCallback.Builder#addAlertLevel(int)
         */
        @NonNull
        public ProximityProfileMockCallback.Builder<T> addLinkLossServiceAlertLevel(int alertLevel) {
            mLinkLossServiceMockCallbackBuilder.addAlertLevel(alertLevel);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.lls.peripheral.LinkLossServiceMockCallback.Builder#addAlertLevel(AlertLevel)
         */
        @NonNull
        public ProximityProfileMockCallback.Builder<T> addLinkLossServiceAlertLevel(@NonNull AlertLevel alertLevel) {
            mLinkLossServiceMockCallbackBuilder.addAlertLevel(alertLevel);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.lls.peripheral.LinkLossServiceMockCallback.Builder#addAlertLevel(byte[])
         */
        @NonNull
        public ProximityProfileMockCallback.Builder<T> addLinkLossServiceAlertLevel(@NonNull byte[] value) {
            mLinkLossServiceMockCallbackBuilder.addAlertLevel(value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.lls.peripheral.LinkLossServiceMockCallback.Builder#addAlertLevel(int, long, byte[])
         */
        @NonNull
        public ProximityProfileMockCallback.Builder<T> addLinkLossServiceAlertLevel(int responseCode, long delay, @NonNull byte[] value) {
            mLinkLossServiceMockCallbackBuilder.addAlertLevel(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.lls.peripheral.LinkLossServiceMockCallback.Builder#removeAlertLevel()
         */
        @NonNull
        public ProximityProfileMockCallback.Builder<T> removeLinkLossServiceAlertLevel() {
            mLinkLossServiceMockCallbackBuilder.removeAlertLevel();
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback.Builder#addAlertLevel(int)
         */
        @NonNull
        public ProximityProfileMockCallback.Builder<T> addImmediateAlertServiceAlertLevel(int alertLevel) {
            mImmediateAlertServiceMockCallbackBuilder.addAlertLevel(alertLevel);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback.Builder#addAlertLevel(AlertLevel)
         */
        @NonNull
        public ProximityProfileMockCallback.Builder<T> addImmediateAlertServiceAlertLevel(@NonNull AlertLevel alertLevel) {
            mImmediateAlertServiceMockCallbackBuilder.addAlertLevel(alertLevel);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback.Builder#addAlertLevel(byte[])
         */
        @NonNull
        public ProximityProfileMockCallback.Builder<T> addImmediateAlertServiceAlertLevel(@NonNull byte[] value) {
            mImmediateAlertServiceMockCallbackBuilder.addAlertLevel(value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback.Builder#addAlertLevel(int, long, byte[])
         */
        @NonNull
        public ProximityProfileMockCallback.Builder<T> addImmediateAlertServiceAlertLevel(int responseCode, long delay, @NonNull byte[] value) {
            mImmediateAlertServiceMockCallbackBuilder.addAlertLevel(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ias.peripheral.ImmediateAlertServiceMockCallback.Builder#removeAlertLevel()
         */
        @NonNull
        public ProximityProfileMockCallback.Builder<T> removeImmediateAlertServiceAlertLevel() {
            mImmediateAlertServiceMockCallbackBuilder.removeAlertLevel();
            return this;
        }

        /**
         * @see org.im97mori.ble.service.tps.peripheral.TxPowerServiceMockCallback.Builder#addTxPowerLevel(int)
         */
        @NonNull
        public ProximityProfileMockCallback.Builder<T> addTxPowerLevel(int txPower) {
            mTxPowerServiceMockCallbackBuilder.addTxPowerLevel(txPower);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.tps.peripheral.TxPowerServiceMockCallback.Builder#addTxPowerLevel(TxPowerLevel)
         */
        @NonNull
        public ProximityProfileMockCallback.Builder<T> addTxPowerLevel(@NonNull TxPowerLevel txPowerLevel) {
            mTxPowerServiceMockCallbackBuilder.addTxPowerLevel(txPowerLevel);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.tps.peripheral.TxPowerServiceMockCallback.Builder#addTxPowerLevel(byte[])
         */
        @NonNull
        public ProximityProfileMockCallback.Builder<T> addTxPowerLevel(@NonNull byte[] value) {
            mTxPowerServiceMockCallbackBuilder.addTxPowerLevel(value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.tps.peripheral.TxPowerServiceMockCallback.Builder#addTxPowerLevel(int, long, byte[])
         */
        @NonNull
        public ProximityProfileMockCallback.Builder<T> addTxPowerLevel(int responseCode, long delay, @NonNull byte[] value) {
            mTxPowerServiceMockCallbackBuilder.addTxPowerLevel(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.tps.peripheral.TxPowerServiceMockCallback.Builder#removeTxPowerLevel()
         */
        @NonNull
        public ProximityProfileMockCallback.Builder<T> removeTxPowerLevel() {
            mTxPowerServiceMockCallbackBuilder.removeTxPowerLevel();
            return this;
        }

        /**
         * @return {@link ProximityProfileMockCallback} instance
         */
        public ProximityProfileMockCallback build() {
            return new ProximityProfileMockCallback(mContext, mLinkLossServiceMockCallbackBuilder.build(), mImmediateAlertServiceMockCallbackBuilder.build(), mTxPowerServiceMockCallbackBuilder.build());
        }

    }

    /**
     * @param context                           {@link Context} instance
     * @param linkLossServiceMockCallback       {@link LinkLossServiceMockCallback} instance
     * @param immediateAlertServiceMockCallback {@link ImmediateAlertServiceMockCallback} instance
     * @param txPowerServiceMockCallback        {@link TxPowerServiceMockCallback} instance
     * @param bleServerCallbacks                callback array
     */
    public ProximityProfileMockCallback(@NonNull Context context
            , @NonNull LinkLossServiceMockCallback linkLossServiceMockCallback
            , @NonNull ImmediateAlertServiceMockCallback immediateAlertServiceMockCallback
            , @NonNull TxPowerServiceMockCallback txPowerServiceMockCallback
            , @NonNull BLEServerCallback... bleServerCallbacks) {
        super(context
                , true
                , Stream.concat(Arrays.stream(bleServerCallbacks)
                        , Stream.of(linkLossServiceMockCallback, immediateAlertServiceMockCallback, txPowerServiceMockCallback))
                        .toArray(BLEServerCallback[]::new));
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public UUID getServiceUUID() {
        return LINK_LOSS_SERVICE;
    }

}
