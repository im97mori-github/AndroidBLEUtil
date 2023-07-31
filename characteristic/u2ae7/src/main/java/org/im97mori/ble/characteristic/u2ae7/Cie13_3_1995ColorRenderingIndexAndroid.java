package org.im97mori.ble.characteristic.u2ae7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * CIE 13.3-1995 Color Rendering Index (Characteristics UUID: 0x2AE7)
 */
@SuppressWarnings({"WeakerAccess"})
public class Cie13_3_1995ColorRenderingIndexAndroid extends Cie13_3_1995ColorRenderingIndex implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<Cie13_3_1995ColorRenderingIndexAndroid> CREATOR = new ByteArrayCreator<Cie13_3_1995ColorRenderingIndexAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Cie13_3_1995ColorRenderingIndexAndroid createFromParcel(@NonNull Parcel in) {
            return new Cie13_3_1995ColorRenderingIndexAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Cie13_3_1995ColorRenderingIndexAndroid[] newArray(int size) {
            return new Cie13_3_1995ColorRenderingIndexAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Cie13_3_1995ColorRenderingIndexAndroid createFromByteArray(@NonNull byte[] values) {
            return new Cie13_3_1995ColorRenderingIndexAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE7
     */
    @Deprecated
    public Cie13_3_1995ColorRenderingIndexAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public Cie13_3_1995ColorRenderingIndexAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param colorRenderingIndex Color Rendering Index
     */
    public Cie13_3_1995ColorRenderingIndexAndroid(int colorRenderingIndex) {
        super(colorRenderingIndex);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Cie13_3_1995ColorRenderingIndexAndroid(@NonNull Parcel in) {
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
