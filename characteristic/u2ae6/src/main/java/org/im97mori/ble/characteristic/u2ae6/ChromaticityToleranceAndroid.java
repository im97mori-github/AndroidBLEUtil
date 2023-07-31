package org.im97mori.ble.characteristic.u2ae6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Chromaticity Tolerance (Characteristics UUID: 0x2AE6)
 */
@SuppressWarnings({"WeakerAccess"})
public class ChromaticityToleranceAndroid extends ChromaticityTolerance implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ChromaticityToleranceAndroid> CREATOR = new ByteArrayCreator<ChromaticityToleranceAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChromaticityToleranceAndroid createFromParcel(@NonNull Parcel in) {
            return new ChromaticityToleranceAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChromaticityToleranceAndroid[] newArray(int size) {
            return new ChromaticityToleranceAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ChromaticityToleranceAndroid createFromByteArray(@NonNull byte[] values) {
            return new ChromaticityToleranceAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE6
     */
    @Deprecated
    public ChromaticityToleranceAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ChromaticityToleranceAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param chromaticityTolerance Chromaticity Tolerance
     */
    public ChromaticityToleranceAndroid(int chromaticityTolerance) {
        super(chromaticityTolerance);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ChromaticityToleranceAndroid(@NonNull Parcel in) {
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
