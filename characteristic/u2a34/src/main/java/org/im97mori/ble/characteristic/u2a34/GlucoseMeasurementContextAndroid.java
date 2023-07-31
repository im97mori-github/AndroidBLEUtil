package org.im97mori.ble.characteristic.u2a34;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Glucose Measurement Context (Characteristics UUID: 0x2A34)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class GlucoseMeasurementContextAndroid extends GlucoseMeasurementContext implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<GlucoseMeasurementContextAndroid> CREATOR = new ByteArrayCreator<GlucoseMeasurementContextAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GlucoseMeasurementContextAndroid createFromParcel(@NonNull Parcel in) {
            return new GlucoseMeasurementContextAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GlucoseMeasurementContextAndroid[] newArray(int size) {
            return new GlucoseMeasurementContextAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public GlucoseMeasurementContextAndroid createFromByteArray(@NonNull byte[] values) {
            return new GlucoseMeasurementContextAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A34
     */
    @Deprecated
    public GlucoseMeasurementContextAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public GlucoseMeasurementContextAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private GlucoseMeasurementContextAndroid(@NonNull Parcel in) {
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
