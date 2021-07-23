package org.im97mori.ble.characteristic.u2b05;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.POWER_CHARACTERISTIC;

/**
 * Power (Characteristics UUID: 0x2B05)
 */
@SuppressWarnings({"WeakerAccess"})
public class PowerAndroid extends Power implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<PowerAndroid> CREATOR = new ByteArrayCreater<PowerAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PowerAndroid createFromParcel(@NonNull Parcel in) {
            return new PowerAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PowerAndroid[] newArray(int size) {
            return new PowerAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PowerAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(POWER_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PowerAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B05
     */
    public PowerAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param power Power
     */
    public PowerAndroid(int power) {
        super(power);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PowerAndroid(@NonNull Parcel in) {
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
