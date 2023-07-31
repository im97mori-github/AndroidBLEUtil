package org.im97mori.ble.characteristic.u2ab5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Location Name (Characteristics UUID: 0x2AB5)
 */
@SuppressWarnings({"WeakerAccess"})
public class LocationNameAndroid extends LocationName implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LocationNameAndroid> CREATOR = new ByteArrayCreator<LocationNameAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocationNameAndroid createFromParcel(@NonNull Parcel in) {
            return new LocationNameAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocationNameAndroid[] newArray(int size) {
            return new LocationNameAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LocationNameAndroid createFromByteArray(@NonNull byte[] values) {
            return new LocationNameAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB5
     */
    @Deprecated
    public LocationNameAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public LocationNameAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param locationName Location Name
     */
    public LocationNameAndroid(@NonNull String locationName) {
        super(locationName);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LocationNameAndroid(@NonNull Parcel in) {
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
