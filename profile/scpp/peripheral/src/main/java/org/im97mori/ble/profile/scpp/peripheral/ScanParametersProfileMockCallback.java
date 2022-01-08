package org.im97mori.ble.profile.scpp.peripheral;

import android.bluetooth.BluetoothGatt;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.characteristic.u2a31.ScanRefresh;
import org.im97mori.ble.characteristic.u2a4f.ScanIntervalWindow;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.scps.peripheral.ScanParametersServiceMockCallback;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Scan Parameters Profile for Peripheral
 */
public class ScanParametersProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link ScanParametersProfileMockCallback}
     *
     * @param <T> subclass of {@link ScanParametersProfileMockCallback}
     */
    public static class Builder<T extends ScanParametersProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.scps.peripheral.ScanParametersServiceMockCallback.Builder} instance
         */
        protected final ScanParametersServiceMockCallback.Builder<? extends ScanParametersServiceMockCallback> mScanParametersServiceMockCallbackBuilder;

        /**
         * @param context                                  {@link Context} instance
         * @param scanParametersServiceMockCallbackBuilder {@link org.im97mori.ble.service.scps.peripheral.ScanParametersServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull ScanParametersServiceMockCallback.Builder<? extends ScanParametersServiceMockCallback> scanParametersServiceMockCallbackBuilder) {
            mContext = context;
            mScanParametersServiceMockCallbackBuilder = scanParametersServiceMockCallbackBuilder;
        }

        /**
         * @see #addScanIntervalWindow(byte[])
         */
        @NonNull
        public Builder<T> addScanIntervalWindow(@NonNull ScanIntervalWindow scanIntervalWindow) {
            return addScanIntervalWindow(scanIntervalWindow.getBytes());
        }

        /**
         * @see #addScanIntervalWindow(int, long, byte[])
         */
        @NonNull
        public Builder<T> addScanIntervalWindow(@NonNull byte[] value) {
            return addScanIntervalWindow(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * @see org.im97mori.ble.service.scps.peripheral.ScanParametersServiceMockCallback.Builder#addScanIntervalWindow(int, long, byte[])
         */
        @NonNull
        public Builder<T> addScanIntervalWindow(int responseCode, long delay, @NonNull byte[] value) {
            mScanParametersServiceMockCallbackBuilder.addScanIntervalWindow(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.scps.peripheral.ScanParametersServiceMockCallback.Builder#removeScanIntervalWindow()
         */
        @NonNull
        public Builder<T> removeScanIntervalWindow() {
            mScanParametersServiceMockCallbackBuilder.removeScanIntervalWindow();
            return this;
        }

        /**
         * @see #addScanRefresh(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addScanRefresh(@NonNull ScanRefresh scanRefresh, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addScanRefresh(BluetoothGatt.GATT_SUCCESS, 0, scanRefresh.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.scps.peripheral.ScanParametersServiceMockCallback.Builder#addScanRefresh(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addScanRefresh(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mScanParametersServiceMockCallbackBuilder.addScanRefresh(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.scps.peripheral.ScanParametersServiceMockCallback.Builder#removeScanRefresh()
         */
        @NonNull
        public Builder<T> removeScanRefresh() {
            mScanParametersServiceMockCallbackBuilder.removeScanRefresh();
            return this;
        }

        /**
         * @return {@link ScanParametersProfileMockCallback} instance
         */
        public ScanParametersProfileMockCallback build() {
            return new ScanParametersProfileMockCallback(mContext
                    , mScanParametersServiceMockCallbackBuilder.build());
        }

    }

    /**
     * @param context                           {@link Context} instance
     * @param scanParametersServiceMockCallback {@link org.im97mori.ble.service.scps.peripheral.ScanParametersServiceMockCallback} instance
     * @param bleServerCallbacks                callback array
     */
    public ScanParametersProfileMockCallback(@NonNull Context context
            , @NonNull ScanParametersServiceMockCallback scanParametersServiceMockCallback
            , @NonNull BLEServerCallback... bleServerCallbacks) {
        super(context
                , true
                , Stream.concat(Arrays.stream(bleServerCallbacks)
                        , Stream.of(scanParametersServiceMockCallback))
                        .toArray(BLEServerCallback[]::new));
    }

    /**
     * {@inheritDoc}
     */
    @Nullable
    @Override
    public UUID getServiceUUID() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean startAdvertising() {
        return startAdvertising(false);
    }

}
