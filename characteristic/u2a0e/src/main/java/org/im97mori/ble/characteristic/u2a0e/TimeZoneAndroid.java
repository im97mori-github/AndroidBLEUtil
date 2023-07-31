package org.im97mori.ble.characteristic.u2a0e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Time Zone (Characteristics UUID: 0x2A0E)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeZoneAndroid extends TimeZone implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeZoneAndroid> CREATOR = new ByteArrayCreator<TimeZoneAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeZoneAndroid createFromParcel(@NonNull Parcel in) {
            return new TimeZoneAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeZoneAndroid[] newArray(int size) {
            return new TimeZoneAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeZoneAndroid createFromByteArray(@NonNull byte[] values) {
            return new TimeZoneAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A0E
     */
    @Deprecated
    public TimeZoneAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TimeZoneAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param timeZone Time Zone
     */
    public TimeZoneAndroid(int timeZone) {
        super(timeZone);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeZoneAndroid(@NonNull Parcel in) {
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
