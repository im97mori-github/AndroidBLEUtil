package org.im97mori.ble.characteristic.u2a5a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Aggregate (Characteristics UUID: 0x2A5A)
 */
@SuppressWarnings({"WeakerAccess"})
public class AggregateAndroid extends Aggregate implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AggregateAndroid> CREATOR = new ByteArrayCreator<AggregateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AggregateAndroid createFromParcel(@NonNull Parcel in) {
            return new AggregateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AggregateAndroid[] newArray(int size) {
            return new AggregateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AggregateAndroid createFromByteArray(@NonNull byte[] values) {
            return new AggregateAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A5A
     */
    @Deprecated
    public AggregateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AggregateAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AggregateAndroid(@NonNull Parcel in) {
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
