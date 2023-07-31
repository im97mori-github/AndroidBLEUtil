package org.im97mori.ble.characteristic.u2a5f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * PLX Continuous Measurement (Characteristics UUID: 0x2A5F)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class PlxContinuousMeasurementAndroid extends PlxContinuousMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PlxContinuousMeasurementAndroid> CREATOR = new ByteArrayCreator<PlxContinuousMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PlxContinuousMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new PlxContinuousMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PlxContinuousMeasurementAndroid[] newArray(int size) {
            return new PlxContinuousMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PlxContinuousMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            return new PlxContinuousMeasurementAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A5F
     */
    @Deprecated
    public PlxContinuousMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public PlxContinuousMeasurementAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PlxContinuousMeasurementAndroid(@NonNull Parcel in) {
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
