package org.im97mori.ble.characteristic.u2a93;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Sport Type for Aerobic and Anaerobic Thresholds (Characteristics UUID: 0x2A93)
 */
@SuppressWarnings({"WeakerAccess"})
public class SportTypeForAerobicAndAnaerobicThresholdsAndroid extends SportTypeForAerobicAndAnaerobicThresholds implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SportTypeForAerobicAndAnaerobicThresholdsAndroid> CREATOR = new ByteArrayCreator<SportTypeForAerobicAndAnaerobicThresholdsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SportTypeForAerobicAndAnaerobicThresholdsAndroid createFromParcel(@NonNull Parcel in) {
            return new SportTypeForAerobicAndAnaerobicThresholdsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SportTypeForAerobicAndAnaerobicThresholdsAndroid[] newArray(int size) {
            return new SportTypeForAerobicAndAnaerobicThresholdsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SportTypeForAerobicAndAnaerobicThresholdsAndroid createFromByteArray(@NonNull byte[] values) {
            return new SportTypeForAerobicAndAnaerobicThresholdsAndroid(values);
        }

    };


    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A93
     */
    @Deprecated
    public SportTypeForAerobicAndAnaerobicThresholdsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SportTypeForAerobicAndAnaerobicThresholdsAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param sportTypeForAerobicAndAnaerobicThresholds Sport Type for Aerobic and Anaerobic Thresholds
     */
    public SportTypeForAerobicAndAnaerobicThresholdsAndroid(int sportTypeForAerobicAndAnaerobicThresholds) {
        super(sportTypeForAerobicAndAnaerobicThresholds);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SportTypeForAerobicAndAnaerobicThresholdsAndroid(@NonNull Parcel in) {
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
