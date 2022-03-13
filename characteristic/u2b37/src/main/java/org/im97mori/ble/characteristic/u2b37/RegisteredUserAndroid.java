package org.im97mori.ble.characteristic.u2b37;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.REGISTERED_USER_CHARACTERISTIC;

public class RegisteredUserAndroid extends RegisteredUser implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RegisteredUserAndroid> CREATOR = new ByteArrayCreator<RegisteredUserAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RegisteredUserAndroid createFromParcel(@NonNull Parcel in) {
            return new RegisteredUserAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RegisteredUserAndroid[] newArray(int size) {
            return new RegisteredUserAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RegisteredUserAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(REGISTERED_USER_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RegisteredUserAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B37
     */
    public RegisteredUserAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RegisteredUserAndroid(@NonNull Parcel in) {
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
