package org.im97mori.ble.characteristic.u2bca;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Sink Audio Locations (Characteristics UUID: 0x2BCA)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SinkAudioLocationsAndroid extends SinkAudioLocations implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SinkAudioLocationsAndroid> CREATOR = new ByteArrayCreator<SinkAudioLocationsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SinkAudioLocationsAndroid createFromParcel(@NonNull Parcel in) {
            return new SinkAudioLocationsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SinkAudioLocationsAndroid[] newArray(int size) {
            return new SinkAudioLocationsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SinkAudioLocationsAndroid createFromByteArray(@NonNull byte[] values) {
            return new SinkAudioLocationsAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BCA
     */
    @Deprecated
    public SinkAudioLocationsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SinkAudioLocationsAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SinkAudioLocationsAndroid(@NonNull Parcel in) {
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
