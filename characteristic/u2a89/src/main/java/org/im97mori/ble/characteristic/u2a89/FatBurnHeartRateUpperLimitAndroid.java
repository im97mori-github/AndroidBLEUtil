package org.im97mori.ble.characteristic.u2a89;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Fat Burn Heart Rate Upper Limit (Characteristics UUID: 0x2A89)
 */
@SuppressWarnings({"WeakerAccess"})
public class FatBurnHeartRateUpperLimitAndroid extends FatBurnHeartRateUpperLimit implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<FatBurnHeartRateUpperLimitAndroid> CREATOR = new ByteArrayCreator<FatBurnHeartRateUpperLimitAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FatBurnHeartRateUpperLimitAndroid createFromParcel(@NonNull Parcel in) {
            return new FatBurnHeartRateUpperLimitAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FatBurnHeartRateUpperLimitAndroid[] newArray(int size) {
            return new FatBurnHeartRateUpperLimitAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FatBurnHeartRateUpperLimitAndroid createFromByteArray(@NonNull byte[] values) {
            return new FatBurnHeartRateUpperLimitAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A89
     */
    @Deprecated
    public FatBurnHeartRateUpperLimitAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public FatBurnHeartRateUpperLimitAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param fatBurnHeartRateUpperLimit Fat Burn Heart Rate Upper Limit
     */
    public FatBurnHeartRateUpperLimitAndroid(int fatBurnHeartRateUpperLimit) {
        super(fatBurnHeartRateUpperLimit);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FatBurnHeartRateUpperLimitAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeByteArray(getBytes());
    }

}
