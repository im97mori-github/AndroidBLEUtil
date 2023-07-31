package org.im97mori.ble.characteristic.u2a5e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * PLX Spot-Check Measurement (Characteristics UUID: 0x2A5E)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class PlxSpotCheckMeasurementAndroid extends PlxSpotCheckMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PlxSpotCheckMeasurementAndroid> CREATOR = new ByteArrayCreator<PlxSpotCheckMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PlxSpotCheckMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new PlxSpotCheckMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PlxSpotCheckMeasurementAndroid[] newArray(int size) {
            return new PlxSpotCheckMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PlxSpotCheckMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            return new PlxSpotCheckMeasurementAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A5E
     */
    @Deprecated
    public PlxSpotCheckMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public PlxSpotCheckMeasurementAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PlxSpotCheckMeasurementAndroid(@NonNull Parcel in) {
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
