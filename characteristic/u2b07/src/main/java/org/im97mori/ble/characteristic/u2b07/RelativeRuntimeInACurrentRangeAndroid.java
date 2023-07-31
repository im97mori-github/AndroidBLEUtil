package org.im97mori.ble.characteristic.u2b07;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Relative Runtime In A Current Range (Characteristics UUID: 0x2B07)
 */
@SuppressWarnings({"WeakerAccess"})
public class RelativeRuntimeInACurrentRangeAndroid extends RelativeRuntimeInACurrentRange implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RelativeRuntimeInACurrentRangeAndroid> CREATOR = new ByteArrayCreator<RelativeRuntimeInACurrentRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeRuntimeInACurrentRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new RelativeRuntimeInACurrentRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeRuntimeInACurrentRangeAndroid[] newArray(int size) {
            return new RelativeRuntimeInACurrentRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RelativeRuntimeInACurrentRangeAndroid createFromByteArray(@NonNull byte[] values) {
            return new RelativeRuntimeInACurrentRangeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B07
     */
    @Deprecated
    public RelativeRuntimeInACurrentRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public RelativeRuntimeInACurrentRangeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param relativeRuntimeValue Relative Runtime Value
     * @param minimumCurrent       Minimum Current
     * @param maximumCurrent       Maximum Current
     */
    public RelativeRuntimeInACurrentRangeAndroid(int relativeRuntimeValue, int minimumCurrent, int maximumCurrent) {
        super(relativeRuntimeValue, minimumCurrent, maximumCurrent);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RelativeRuntimeInACurrentRangeAndroid(@NonNull Parcel in) {
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
