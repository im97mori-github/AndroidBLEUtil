package org.im97mori.ble.characteristic.u2ac1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.OBJECT_FIRST_CREATED_CHARACTERISTIC;

/**
 * Object First Created (Characteristics UUID: 0x2AC1)
 */
@SuppressWarnings({"WeakerAccess"})
public class ObjectFirstCreatedAndroid extends ObjectFirstCreated implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ObjectFirstCreatedAndroid> CREATOR = new ByteArrayCreator<ObjectFirstCreatedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectFirstCreatedAndroid createFromParcel(@NonNull Parcel in) {
            return new ObjectFirstCreatedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ObjectFirstCreatedAndroid[] newArray(int size) {
            return new ObjectFirstCreatedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ObjectFirstCreatedAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(OBJECT_FIRST_CREATED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ObjectFirstCreatedAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AC1
     */
    public ObjectFirstCreatedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
    public ObjectFirstCreatedAndroid(int year, int month, int day, int hours, int minutes, int seconds) {
        super(year, month, day, hours, minutes, seconds);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ObjectFirstCreatedAndroid(@NonNull Parcel in) {
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
