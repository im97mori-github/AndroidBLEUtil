package org.im97mori.ble.characteristic.u2b7c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Audio Input Description (Characteristics UUID: 0x2B7C)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AudioInputDescriptionAndroid extends AudioInputDescription implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AudioInputDescriptionAndroid> CREATOR = new ByteArrayCreator<AudioInputDescriptionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioInputDescriptionAndroid createFromParcel(@NonNull Parcel in) {
            return new AudioInputDescriptionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioInputDescriptionAndroid[] newArray(int size) {
            return new AudioInputDescriptionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AudioInputDescriptionAndroid createFromByteArray(@NonNull byte[] values) {
            return new AudioInputDescriptionAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B7C
     */
    @Deprecated
    public AudioInputDescriptionAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AudioInputDescriptionAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AudioInputDescriptionAndroid(@NonNull Parcel in) {
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
