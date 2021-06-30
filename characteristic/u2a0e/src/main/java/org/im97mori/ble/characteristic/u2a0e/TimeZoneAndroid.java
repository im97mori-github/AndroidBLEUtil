package org.im97mori.ble.characteristic.u2a0e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.TIME_ZONE_CHARACTERISTIC;

/**
 * Time Zone (Characteristics UUID: 0x2A0E)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TimeZoneAndroid extends TimeZone implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TimeZoneAndroid> CREATOR = new ByteArrayCreater<TimeZoneAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_ZONE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeZoneAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A0E
     */
    public TimeZoneAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeZoneAndroid(@NonNull Parcel in) {
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
