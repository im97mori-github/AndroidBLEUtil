package org.im97mori.ble.characteristic.u2ab2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Floor Number (Characteristics UUID: 0x2AB2)
 */
@SuppressWarnings({"WeakerAccess"})
public class FloorNumberAndroid extends FloorNumber implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<FloorNumberAndroid> CREATOR = new ByteArrayCreator<FloorNumberAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FloorNumberAndroid createFromParcel(@NonNull Parcel in) {
            return new FloorNumberAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FloorNumberAndroid[] newArray(int size) {
            return new FloorNumberAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FloorNumberAndroid createFromByteArray(@NonNull byte[] values) {
            return new FloorNumberAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB2
     */
    @Deprecated
    public FloorNumberAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public FloorNumberAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param floorNumber Floor Number
     */
    public FloorNumberAndroid(int floorNumber) {
        super(floorNumber);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FloorNumberAndroid(@NonNull Parcel in) {
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
