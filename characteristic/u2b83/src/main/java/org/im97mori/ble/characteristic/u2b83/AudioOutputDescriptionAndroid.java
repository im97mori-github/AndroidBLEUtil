package org.im97mori.ble.characteristic.u2b83;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Audio Output Description (Characteristics UUID: 0x2B83)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AudioOutputDescriptionAndroid extends AudioOutputDescription implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AudioOutputDescriptionAndroid> CREATOR = new ByteArrayCreator<AudioOutputDescriptionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioOutputDescriptionAndroid createFromParcel(@NonNull Parcel in) {
            return new AudioOutputDescriptionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioOutputDescriptionAndroid[] newArray(int size) {
            return new AudioOutputDescriptionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AudioOutputDescriptionAndroid createFromByteArray(@NonNull byte[] values) {
            return new AudioOutputDescriptionAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B83
     */
    @Deprecated
    public AudioOutputDescriptionAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AudioOutputDescriptionAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AudioOutputDescriptionAndroid(@NonNull Parcel in) {
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
