package org.im97mori.ble.service.tip.peripheral;

import android.bluetooth.BluetoothGatt;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a11.TimeWithDst;
import org.im97mori.ble.characteristic.u2a14.ReferenceTimeInformation;
import org.im97mori.ble.characteristic.u2a16.TimeUpdateControlPoint;
import org.im97mori.ble.characteristic.u2a17.TimeUpdateState;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback;
import org.im97mori.ble.service.ndcs.peripheral.NextDstChangeServiceMockCallback;
import org.im97mori.ble.service.rtus.peripheral.ReferenceTimeUpdateServiceMockCallback;

import java.util.UUID;

/**
 * Time Profile for Peripheral
 */
public class TimeProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link TimeProfileMockCallback}
     *
     * @param <T> subclass of {@link TimeProfileMockCallback}
     */
    public static class Builder<T extends TimeProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback.Builder} instance
         */
        protected final CurrentTimeServiceMockCallback.Builder<? extends CurrentTimeServiceMockCallback> mCurrentTimeServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.ndcs.peripheral.NextDstChangeServiceMockCallback.Builder} instance
         */
        protected final NextDstChangeServiceMockCallback.Builder<? extends NextDstChangeServiceMockCallback> mNextDstChangeServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.rtus.peripheral.ReferenceTimeUpdateServiceMockCallback.Builder} instance
         */
        protected final ReferenceTimeUpdateServiceMockCallback.Builder<? extends ReferenceTimeUpdateServiceMockCallback> mReferenceTimeUpdateServiceMockCallbackBuilder;

        /**
         * @param context                                       {@link Context} instance
         * @param currentTimeServiceMockCallbackBuilder         {@link org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback.Builder} instance
         * @param nextDstChangeServiceMockCallbackBuilder       {@link org.im97mori.ble.service.ndcs.peripheral.NextDstChangeServiceMockCallback.Builder} instance
         * @param referenceTimeUpdateServiceMockCallbackBuilder {@link org.im97mori.ble.service.rtus.peripheral.ReferenceTimeUpdateServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull CurrentTimeServiceMockCallback.Builder<? extends CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder
                , @Nullable NextDstChangeServiceMockCallback.Builder<? extends NextDstChangeServiceMockCallback> nextDstChangeServiceMockCallbackBuilder
                , @Nullable ReferenceTimeUpdateServiceMockCallback.Builder<? extends ReferenceTimeUpdateServiceMockCallback> referenceTimeUpdateServiceMockCallbackBuilder) {
            mContext = context;
            mCurrentTimeServiceMockCallbackBuilder = currentTimeServiceMockCallbackBuilder;
            mNextDstChangeServiceMockCallbackBuilder = nextDstChangeServiceMockCallbackBuilder;
            mReferenceTimeUpdateServiceMockCallbackBuilder = referenceTimeUpdateServiceMockCallbackBuilder;
        }

        /**
         * @see #addCurrentTime(boolean, int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addCurrentTime(@NonNull CurrentTime currentTime, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addCurrentTime(true, BluetoothGatt.GATT_SUCCESS, 0, currentTime.getBytes(), 1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback.Builder#addCurrentTime(boolean, int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addCurrentTime(boolean isWritable, int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mCurrentTimeServiceMockCallbackBuilder.addCurrentTime(isWritable, characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback.Builder#removeCurrentTime()
         */
        @NonNull
        public Builder<T> removeCurrentTime() {
            mCurrentTimeServiceMockCallbackBuilder.removeCurrentTime();
            return this;
        }

        /**
         * @see #addLocalTimeInformation(byte[])
         */
        @NonNull
        public Builder<T> addLocalTimeInformation(@NonNull LocalTimeInformation localTimeInformation) {
            return addLocalTimeInformation(localTimeInformation.getBytes());
        }

        /**
         * @see #addLocalTimeInformation(boolean, int, long, byte[])
         */
        @NonNull
        public Builder<T> addLocalTimeInformation(@NonNull byte[] value) {
            return addLocalTimeInformation(true, BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * @see org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback.Builder#addLocalTimeInformation(boolean, int, long, byte[])
         */
        @NonNull
        public Builder<T> addLocalTimeInformation(boolean isWritable, int responseCode, long delay, @NonNull byte[] value) {
            mCurrentTimeServiceMockCallbackBuilder.addLocalTimeInformation(isWritable, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback.Builder#removeLocalTimeInformation()
         */
        @NonNull
        public Builder<T> removeLocalTimeInformation() {
            mCurrentTimeServiceMockCallbackBuilder.removeLocalTimeInformation();
            return this;
        }

        /**
         * @see #addReferenceTimeInformation(byte[])
         */
        @NonNull
        public Builder<T> addReferenceTimeInformation(@NonNull ReferenceTimeInformation referenceTimeInformation) {
            return addReferenceTimeInformation(referenceTimeInformation.getBytes());
        }

        /**
         * @see #addReferenceTimeInformation(int, long, byte[])
         */
        @NonNull
        public Builder<T> addReferenceTimeInformation(@NonNull byte[] value) {
            return addReferenceTimeInformation(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * @see org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback.Builder#addReferenceTimeInformation(int, long, byte[])
         */
        @NonNull
        public Builder<T> addReferenceTimeInformation(int responseCode, long delay, @NonNull byte[] value) {
            mCurrentTimeServiceMockCallbackBuilder.addReferenceTimeInformation(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback.Builder#removeReferenceTimeInformation()
         */
        @NonNull
        public Builder<T> removeReferenceTimeInformation() {
            mCurrentTimeServiceMockCallbackBuilder.removeReferenceTimeInformation();
            return this;
        }

        /**
         * @see #addTimeWithDst(byte[])
         */
        @NonNull
        public Builder<T> addTimeWithDst(@NonNull TimeWithDst timeWithDst) {
            return addTimeWithDst(timeWithDst.getBytes());
        }

        /**
         * @see #addTimeWithDst(int, long, byte[])
         */
        @NonNull
        public Builder<T> addTimeWithDst(@NonNull byte[] value) {
            return addTimeWithDst(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.ndcs.peripheral.NextDstChangeServiceMockCallback.Builder#addTimeWithDst(int, long, byte[])
         */
        @NonNull
        public Builder<T> addTimeWithDst(int responseCode, long delay, @NonNull byte[] value) {
            if (mNextDstChangeServiceMockCallbackBuilder != null) {
                mNextDstChangeServiceMockCallbackBuilder.addTimeWithDst(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ndcs.peripheral.NextDstChangeServiceMockCallback.Builder#removeTimeWithDst()
         */
        @NonNull
        public Builder<T> removeTimeWithDst() {
            if (mNextDstChangeServiceMockCallbackBuilder != null) {
                mNextDstChangeServiceMockCallbackBuilder.removeTimeWithDst();
            }
            return this;
        }

        /**
         * @see #addTimeUpdateControlPoint(int, long, byte[])
         */
        @NonNull
        public Builder<T> addTimeUpdateControlPoint(@NonNull TimeUpdateControlPoint timeUpdateControlPoint) {
            return addTimeUpdateControlPoint(BluetoothGatt.GATT_SUCCESS, 0, timeUpdateControlPoint.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.rtus.peripheral.ReferenceTimeUpdateServiceMockCallback.Builder#addTimeUpdateControlPoint(int, long, byte[])
         */
        @NonNull
        public Builder<T> addTimeUpdateControlPoint(int responseCode, long delay, @NonNull byte[] value) {
            if (mReferenceTimeUpdateServiceMockCallbackBuilder != null) {
                mReferenceTimeUpdateServiceMockCallbackBuilder.addTimeUpdateControlPoint(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.rtus.peripheral.ReferenceTimeUpdateServiceMockCallback.Builder#removeTimeUpdateControlPoint()
         */
        @NonNull
        public Builder<T> removeTimeUpdateControlPoint() {
            if (mReferenceTimeUpdateServiceMockCallbackBuilder != null) {
                mReferenceTimeUpdateServiceMockCallbackBuilder.removeTimeUpdateControlPoint();
            }
            return this;
        }

        /**
         * @see #addTimeUpdateState(int, long, byte[])
         */
        @NonNull
        public Builder<T> addTimeUpdateState(@NonNull TimeUpdateState timeUpdateState) {
            return addTimeUpdateState(BluetoothGatt.GATT_SUCCESS, 0, timeUpdateState.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.rtus.peripheral.ReferenceTimeUpdateServiceMockCallback.Builder#addTimeUpdateState(int, long, byte[])
         */
        @NonNull
        public Builder<T> addTimeUpdateState(int responseCode, long delay, @NonNull byte[] value) {
            if (mReferenceTimeUpdateServiceMockCallbackBuilder != null) {
                mReferenceTimeUpdateServiceMockCallbackBuilder.addTimeUpdateState(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.rtus.peripheral.ReferenceTimeUpdateServiceMockCallback.Builder#removeTimeUpdateState()
         */
        @NonNull
        public Builder<T> removeTimeUpdateState() {
            if (mReferenceTimeUpdateServiceMockCallbackBuilder != null) {
                mReferenceTimeUpdateServiceMockCallbackBuilder.removeTimeUpdateState();
            }
            return this;
        }

        /**
         * @return {@link TimeProfileMockCallback} instance
         */
        public TimeProfileMockCallback build() {
            return new TimeProfileMockCallback(mContext, mCurrentTimeServiceMockCallbackBuilder.build()
                    , mNextDstChangeServiceMockCallbackBuilder == null ? null : mNextDstChangeServiceMockCallbackBuilder.build()
                    , mReferenceTimeUpdateServiceMockCallbackBuilder == null ? null : mReferenceTimeUpdateServiceMockCallbackBuilder.build());
        }

    }

    /**
     * @param context                                {@link Context} instance
     * @param currentTimeServiceMockCallback         {@link CurrentTimeServiceMockCallback} instance
     * @param nextDstChangeServiceMockCallback       {@link NextDstChangeServiceMockCallback} instance
     * @param referenceTimeUpdateServiceMockCallback {@link ReferenceTimeUpdateServiceMockCallback} instance
     */
    public TimeProfileMockCallback(@NonNull Context context
            , @NonNull CurrentTimeServiceMockCallback currentTimeServiceMockCallback
            , @Nullable NextDstChangeServiceMockCallback nextDstChangeServiceMockCallback
            , @Nullable ReferenceTimeUpdateServiceMockCallback referenceTimeUpdateServiceMockCallback) {
        super(context, true, currentTimeServiceMockCallback, nextDstChangeServiceMockCallback, referenceTimeUpdateServiceMockCallback);
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
