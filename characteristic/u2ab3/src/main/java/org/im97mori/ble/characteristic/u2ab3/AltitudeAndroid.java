package org.im97mori.ble.characteristic.u2ab3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Altitude (Characteristics UUID: 0x2AB3)
 */
@SuppressWarnings({"WeakerAccess"})
public class AltitudeAndroid extends Altitude implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AltitudeAndroid> CREATOR = new ByteArrayCreator<AltitudeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AltitudeAndroid createFromParcel(@NonNull Parcel in) {
            return new AltitudeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AltitudeAndroid[] newArray(int size) {
            return new AltitudeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AltitudeAndroid createFromByteArray(@NonNull byte[] values) {
            return new AltitudeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB3
     */
    @Deprecated
    public AltitudeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AltitudeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param altitude Altitude
     */
    public AltitudeAndroid(int altitude) {
        super(altitude);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AltitudeAndroid(@NonNull Parcel in) {
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
