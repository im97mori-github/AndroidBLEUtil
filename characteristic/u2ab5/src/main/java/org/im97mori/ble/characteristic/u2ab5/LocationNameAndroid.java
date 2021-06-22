package org.im97mori.ble.characteristic.u2ab5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.LOCATION_NAME_CHARACTERISTIC;

/**
 * Location Name (Characteristics UUID: 0x2AB5)
 */
@SuppressWarnings({"WeakerAccess"})
public class LocationNameAndroid extends LocationName implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LocationNameAndroid> CREATOR = new ByteArrayCreater<LocationNameAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LOCATION_NAME_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LocationNameAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB5
     */
    public LocationNameAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
        //noinspection ConstantConditions
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
