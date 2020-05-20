package org.im97mori.ble.characteristic.u2a8c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.GENDER_CHARACTERISTIC;

/**
 * Gender (Characteristics UUID: 0x2A8C)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class GenderAndroid extends Gender implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<GenderAndroid> CREATOR = new ByteArrayCreater<GenderAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GenderAndroid createFromParcel(@NonNull Parcel in) {
            return new GenderAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GenderAndroid[] newArray(int size) {
            return new GenderAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public GenderAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GENDER_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new GenderAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A8C
     */
    public GenderAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param gender Gender
     */
    public GenderAndroid(int gender) {
        super(gender);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private GenderAndroid(@NonNull Parcel in) {
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
