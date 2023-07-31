package org.im97mori.ble.characteristic.u2bcc;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Source Audio Locations (Characteristics UUID: 0x2BCC)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SourceAudioLocationsAndroid extends SourceAudioLocations implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SourceAudioLocationsAndroid> CREATOR = new ByteArrayCreator<SourceAudioLocationsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SourceAudioLocationsAndroid createFromParcel(@NonNull Parcel in) {
            return new SourceAudioLocationsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SourceAudioLocationsAndroid[] newArray(int size) {
            return new SourceAudioLocationsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SourceAudioLocationsAndroid createFromByteArray(@NonNull byte[] values) {
            return new SourceAudioLocationsAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BCC
     */
    @Deprecated
    public SourceAudioLocationsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SourceAudioLocationsAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SourceAudioLocationsAndroid(@NonNull Parcel in) {
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
