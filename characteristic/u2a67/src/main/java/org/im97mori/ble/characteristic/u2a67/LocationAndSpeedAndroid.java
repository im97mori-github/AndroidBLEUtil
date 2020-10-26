package org.im97mori.ble.characteristic.u2a67;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LOCATION_AND_SPEED_CHARACTERISTIC;

/**
 * Location and Speed Characteristic (Characteristics UUID: 0x2A67)
 */
@SuppressWarnings({"WeakerAccess"})
public class LocationAndSpeedAndroid extends LocationAndSpeed implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LocationAndSpeedAndroid> CREATOR = new ByteArrayCreater<LocationAndSpeedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocationAndSpeedAndroid createFromParcel(@NonNull Parcel in) {
            return new LocationAndSpeedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocationAndSpeedAndroid[] newArray(int size) {
            return new LocationAndSpeedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LocationAndSpeedAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LOCATION_AND_SPEED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LocationAndSpeedAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A67
     */
    public LocationAndSpeedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param flags              Flags
     * @param instantaneousSpeed Instantaneous Speed
     * @param totalDistance      Total Distance
     * @param locationLatitude   Location - Latitude
     * @param locationLongitude  Location - Longitude
     * @param elevation          Elevation
     * @param heading            Heading
     * @param rollingTime        Rolling Time
     * @param year               Year
     * @param month              Month
     * @param day                Day
     * @param hours              Hours
     * @param minutes            Minutes
     * @param seconds            Seconds
     */
    public LocationAndSpeedAndroid(@NonNull byte[] flags, int instantaneousSpeed, int totalDistance, int locationLatitude, int locationLongitude, int elevation, int heading, int rollingTime, int year, int month, int day, int hours, int minutes, int seconds) {
        super(flags, instantaneousSpeed, totalDistance, locationLatitude, locationLongitude, elevation, heading, rollingTime, year, month, day, hours, minutes, seconds);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LocationAndSpeedAndroid(@NonNull Parcel in) {
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
