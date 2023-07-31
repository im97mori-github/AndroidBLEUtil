package org.im97mori.ble.characteristic.u2aa3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Barometric Pressure Trend (Characteristics UUID: 0x2AA3)
 */
@SuppressWarnings({"WeakerAccess"})
public class BarometricPressureTrendAndroid extends BarometricPressureTrend implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BarometricPressureTrendAndroid> CREATOR = new ByteArrayCreator<BarometricPressureTrendAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BarometricPressureTrendAndroid createFromParcel(@NonNull Parcel in) {
            return new BarometricPressureTrendAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BarometricPressureTrendAndroid[] newArray(int size) {
            return new BarometricPressureTrendAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BarometricPressureTrendAndroid createFromByteArray(@NonNull byte[] values) {
            return new BarometricPressureTrendAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA3
     */
    @Deprecated
    public BarometricPressureTrendAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BarometricPressureTrendAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param barometricPressureTrend Barometric Pressure Trend
     */
    public BarometricPressureTrendAndroid(int barometricPressureTrend) {
        super(barometricPressureTrend);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BarometricPressureTrendAndroid(@NonNull Parcel in) {
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
