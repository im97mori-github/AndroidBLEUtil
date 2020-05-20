package org.im97mori.ble.characteristic.u2a68;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.NAVIGATION_CHARACTERISTIC;

/**
 * Navigation (Characteristics UUID: 0x2A68)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class NavigationAndroid extends Navigation implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<NavigationAndroid> CREATOR = new ByteArrayCreater<NavigationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NavigationAndroid createFromParcel(@NonNull Parcel in) {
            return new NavigationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NavigationAndroid[] newArray(int size) {
            return new NavigationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public NavigationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(NAVIGATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new NavigationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A68
     */
    public NavigationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param flags                     Flags
     * @param bearing                   Bearing
     * @param heading                   Heading
     * @param remainingDistance         Remaining Distance
     * @param remainingVerticalDistance Remaining Vertical Distance
     * @param year                      Year
     * @param month                     Month
     * @param day                       Day
     * @param hours                     Hours
     * @param minutes                   Minutes
     * @param seconds                   Seconds
     */
    public NavigationAndroid(@NonNull byte[] flags, int bearing, int heading, int remainingDistance, int remainingVerticalDistance, int year, int month, int day, int hours, int minutes, int seconds) {
        super(flags, bearing, heading, remainingDistance, remainingVerticalDistance, year, month, day, hours, minutes, seconds);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private NavigationAndroid(@NonNull Parcel in) {
        super(in.createByteArray());
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
