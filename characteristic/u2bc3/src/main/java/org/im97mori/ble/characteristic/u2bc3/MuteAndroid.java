package org.im97mori.ble.characteristic.u2bc3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Mute (Characteristics UUID: 0x2BC3)
 */
@SuppressWarnings({"WeakerAccess"})
public class MuteAndroid extends Mute implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<MuteAndroid> CREATOR = new ByteArrayCreator<MuteAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MuteAndroid createFromParcel(@NonNull Parcel in) {
            return new MuteAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MuteAndroid[] newArray(int size) {
            return new MuteAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MuteAndroid createFromByteArray(@NonNull byte[] values) {
            return new MuteAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BC3
     */
    @Deprecated
    public MuteAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public MuteAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param mute Appearance Value
     */
    public MuteAndroid(int mute) {
        super(mute);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MuteAndroid(@NonNull Parcel in) {
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
