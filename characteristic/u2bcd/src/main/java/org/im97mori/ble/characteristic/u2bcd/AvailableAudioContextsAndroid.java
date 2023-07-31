package org.im97mori.ble.characteristic.u2bcd;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Available Audio Contexts  (Characteristics UUID: 0x2BCD)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AvailableAudioContextsAndroid extends AvailableAudioContexts implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AvailableAudioContextsAndroid> CREATOR = new ByteArrayCreator<AvailableAudioContextsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AvailableAudioContextsAndroid createFromParcel(@NonNull Parcel in) {
            return new AvailableAudioContextsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AvailableAudioContextsAndroid[] newArray(int size) {
            return new AvailableAudioContextsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AvailableAudioContextsAndroid createFromByteArray(@NonNull byte[] values) {
            return new AvailableAudioContextsAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BCD
     */
    @Deprecated
    public AvailableAudioContextsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AvailableAudioContextsAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AvailableAudioContextsAndroid(@NonNull Parcel in) {
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
