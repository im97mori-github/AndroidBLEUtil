package org.im97mori.ble.characteristic.u2a83;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Anaerobic Threshold (Characteristics UUID: 0x2A83)
 */
@SuppressWarnings({"WeakerAccess"})
public class AnaerobicThresholdAndroid extends AnaerobicThreshold implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AnaerobicThresholdAndroid> CREATOR = new ByteArrayCreator<AnaerobicThresholdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnaerobicThresholdAndroid createFromParcel(@NonNull Parcel in) {
            return new AnaerobicThresholdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AnaerobicThresholdAndroid[] newArray(int size) {
            return new AnaerobicThresholdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AnaerobicThresholdAndroid createFromByteArray(@NonNull byte[] values) {
            return new AnaerobicThresholdAndroid(values);
        }

    };


    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A83
     */
    @Deprecated
    public AnaerobicThresholdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AnaerobicThresholdAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param anaerobicThreshold Anaerobic Threshold
     */
    public AnaerobicThresholdAndroid(int anaerobicThreshold) {
        super(anaerobicThreshold);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AnaerobicThresholdAndroid(@NonNull Parcel in) {
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
