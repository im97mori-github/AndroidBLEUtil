package org.im97mori.ble.characteristic.u2b0d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.TEMPERATURE_8_CHARACTERISTIC;

/**
 * Temperature 8 (Characteristics UUID: 0x2B0D)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class Temperature_8Android extends Temperature_8 implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Temperature_8Android> CREATOR = new ByteArrayCreater<Temperature_8Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Temperature_8Android createFromParcel(@NonNull Parcel in) {
            return new Temperature_8Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Temperature_8Android[] newArray(int size) {
            return new Temperature_8Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Temperature_8Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_8_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Temperature_8Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B0D
     */
    public Temperature_8Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Temperature_8Android(@NonNull Parcel in) {
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
