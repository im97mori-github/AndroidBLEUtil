package org.im97mori.ble.characteristic.u2a2c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Magnetic Declination (Characteristics UUID: 0x2A2C)
 */
@SuppressWarnings({"WeakerAccess"})
public class MagneticDeclinationAndroid extends MagneticDeclination implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<MagneticDeclinationAndroid> CREATOR = new ByteArrayCreator<MagneticDeclinationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MagneticDeclinationAndroid createFromParcel(@NonNull Parcel in) {
            return new MagneticDeclinationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MagneticDeclinationAndroid[] newArray(int size) {
            return new MagneticDeclinationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MagneticDeclinationAndroid createFromByteArray(@NonNull byte[] values) {
            return new MagneticDeclinationAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A2C
     */
    @Deprecated
    public MagneticDeclinationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public MagneticDeclinationAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param magneticDeclination Magnetic Declination
     */
    public MagneticDeclinationAndroid(int magneticDeclination) {
        super(magneticDeclination);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MagneticDeclinationAndroid(@NonNull Parcel in) {
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
