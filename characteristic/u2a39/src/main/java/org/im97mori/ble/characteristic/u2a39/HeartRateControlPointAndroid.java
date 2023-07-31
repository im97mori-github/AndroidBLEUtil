package org.im97mori.ble.characteristic.u2a39;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Heart Rate Control Point (Characteristics UUID: 0x2A39)
 */
@SuppressWarnings({"WeakerAccess"})
public class HeartRateControlPointAndroid extends HeartRateControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HeartRateControlPointAndroid> CREATOR = new ByteArrayCreator<HeartRateControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeartRateControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new HeartRateControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeartRateControlPointAndroid[] newArray(int size) {
            return new HeartRateControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HeartRateControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new HeartRateControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A39
     */
    @Deprecated
    public HeartRateControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public HeartRateControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param heartRateControlPoint Heart Rate Control Point
     */
    public HeartRateControlPointAndroid(int heartRateControlPoint) {
        super(heartRateControlPoint);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HeartRateControlPointAndroid(@NonNull Parcel in) {
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
