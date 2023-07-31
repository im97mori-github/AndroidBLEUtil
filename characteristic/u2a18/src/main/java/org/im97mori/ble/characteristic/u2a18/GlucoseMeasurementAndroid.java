package org.im97mori.ble.characteristic.u2a18;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Glucose Measurement (Characteristics UUID: 0x2A18)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class GlucoseMeasurementAndroid extends GlucoseMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<GlucoseMeasurementAndroid> CREATOR = new ByteArrayCreator<GlucoseMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GlucoseMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new GlucoseMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GlucoseMeasurementAndroid[] newArray(int size) {
            return new GlucoseMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public GlucoseMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            return new GlucoseMeasurementAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A18
     */
    @Deprecated
    public GlucoseMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public GlucoseMeasurementAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private GlucoseMeasurementAndroid(@NonNull Parcel in) {
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
