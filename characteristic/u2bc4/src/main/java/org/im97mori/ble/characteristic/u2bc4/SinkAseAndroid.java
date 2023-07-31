package org.im97mori.ble.characteristic.u2bc4;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Sink ASE (Characteristics UUID: 0x2BC4)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SinkAseAndroid extends SinkAse implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SinkAseAndroid> CREATOR = new ByteArrayCreator<SinkAseAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SinkAseAndroid createFromParcel(@NonNull Parcel in) {
            return new SinkAseAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SinkAseAndroid[] newArray(int size) {
            return new SinkAseAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SinkAseAndroid createFromByteArray(@NonNull byte[] values) {
            return new SinkAseAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BC4
     */
    @Deprecated
    public SinkAseAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SinkAseAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SinkAseAndroid(@NonNull Parcel in) {
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
