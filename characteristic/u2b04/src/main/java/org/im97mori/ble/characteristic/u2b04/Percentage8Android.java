package org.im97mori.ble.characteristic.u2b04;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.PERCENTAGE_8_CHARACTERISTIC;

/**
 * Percentage 8 (Characteristics UUID: 0x2B04)
 */
@SuppressWarnings({"WeakerAccess"})
public class Percentage8Android extends Percentage8 implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Percentage8Android> CREATOR = new ByteArrayCreater<Percentage8Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Percentage8Android createFromParcel(@NonNull Parcel in) {
            return new Percentage8Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Percentage8Android[] newArray(int size) {
            return new Percentage8Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Percentage8Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PERCENTAGE_8_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Percentage8Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B04
     */
    public Percentage8Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param percentage8 Percentage 8
     */
    public Percentage8Android(int percentage8) {
        super(percentage8);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Percentage8Android(@NonNull Parcel in) {
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
