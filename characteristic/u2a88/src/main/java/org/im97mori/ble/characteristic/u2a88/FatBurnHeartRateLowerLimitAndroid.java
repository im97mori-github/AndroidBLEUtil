package org.im97mori.ble.characteristic.u2a88;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Fat Burn Heart Rate Lower Limit (Characteristics UUID: 0x2A88)
 */
@SuppressWarnings({"WeakerAccess"})
public class FatBurnHeartRateLowerLimitAndroid extends FatBurnHeartRateLowerLimit implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<FatBurnHeartRateLowerLimitAndroid> CREATOR = new ByteArrayCreator<FatBurnHeartRateLowerLimitAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FatBurnHeartRateLowerLimitAndroid createFromParcel(@NonNull Parcel in) {
            return new FatBurnHeartRateLowerLimitAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FatBurnHeartRateLowerLimitAndroid[] newArray(int size) {
            return new FatBurnHeartRateLowerLimitAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FatBurnHeartRateLowerLimitAndroid createFromByteArray(@NonNull byte[] values) {
            return new FatBurnHeartRateLowerLimitAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A88
     */
    @Deprecated
    public FatBurnHeartRateLowerLimitAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public FatBurnHeartRateLowerLimitAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param fatBurnHeartRateLowerLimit Fat Burn Heart Rate Lower Limit
     */
    public FatBurnHeartRateLowerLimitAndroid(int fatBurnHeartRateLowerLimit) {
        super(fatBurnHeartRateLowerLimit);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FatBurnHeartRateLowerLimitAndroid(@NonNull Parcel in) {
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
