package org.im97mori.ble.characteristic.u2ac2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * object last modified (Characteristics UUID: 0x2AC2)
 */
@SuppressWarnings({"WeakerAccess"})
public class ObjectLastModifiedAndroid extends ObjectLastModified implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ObjectLastModifiedAndroid> CREATOR = new ByteArrayCreator<ObjectLastModifiedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectLastModifiedAndroid createFromParcel(@NonNull Parcel in) {
            return new ObjectLastModifiedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectLastModifiedAndroid[] newArray(int size) {
            return new ObjectLastModifiedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ObjectLastModifiedAndroid createFromByteArray(@NonNull byte[] values) {
            return new ObjectLastModifiedAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AC2
     */
    @Deprecated
    public ObjectLastModifiedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ObjectLastModifiedAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param year    Year
     * @param month   Month
     * @param day     Day
     * @param hours   Hours
     * @param minutes Minutes
     * @param seconds Seconds
     */
    public ObjectLastModifiedAndroid(int year, int month, int day, int hours, int minutes, int seconds) {
        super(year, month, day, hours, minutes, seconds);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ObjectLastModifiedAndroid(@NonNull Parcel in) {
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
