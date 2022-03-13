package org.im97mori.ble.characteristic.u2ac7;

import static org.im97mori.ble.constants.CharacteristicUUID.OBJECT_LIST_FILTER_CHARACTERISTIC;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

/**
 * object list filter (Characteristics UUID: 0x2AC7)
 */
@SuppressWarnings({"WeakerAccess"})
public class ObjectListFilterAndroid extends ObjectListFilter implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ObjectListFilterAndroid> CREATOR = new ByteArrayCreator<ObjectListFilterAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectListFilterAndroid createFromParcel(@NonNull Parcel in) {
            return new ObjectListFilterAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectListFilterAndroid[] newArray(int size) {
            return new ObjectListFilterAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ObjectListFilterAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(OBJECT_LIST_FILTER_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ObjectListFilterAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AC7
     */
    public ObjectListFilterAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param filter     Filter
     * @param name       Name
     * @param objectType Object Type
     * @param year1      timestamp1 Year
     * @param month1     timestamp1 Month
     * @param day1       timestamp1 Day
     * @param hours1     timestamp1 Hours
     * @param minutes1   timestamp1 Minutes
     * @param seconds1   timestamp1 Seconds
     * @param year2      timestamp2 Year
     * @param month2     timestamp2 Month
     * @param day2       timestamp2 Day
     * @param hours2     timestamp2 Hours
     * @param minutes2   timestamp2 Minutes
     * @param seconds2   timestamp2 Seconds
     * @param size1      size1
     * @param size2      size2
     */
    public ObjectListFilterAndroid(int filter, @NonNull String name, @NonNull byte[] objectType, int year1, int month1,
                                   int day1, int hours1, int minutes1, int seconds1, int year2, int month2, int day2, int hours2, int minutes2,
                                   int seconds2, long size1, long size2) {
        super(filter, name, objectType, year1, month1, day1, hours1, minutes1, seconds1, year2, month2, day2, hours2, minutes2, seconds2, size1, size2);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ObjectListFilterAndroid(@NonNull Parcel in) {
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
