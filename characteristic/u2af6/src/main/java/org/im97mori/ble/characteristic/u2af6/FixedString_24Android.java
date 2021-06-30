package org.im97mori.ble.characteristic.u2af6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.FIXED_STRING_24_CHARACTERISTIC;

/**
 * Fixed String 24 (Characteristics UUID: 0x2AF6)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class FixedString_24Android extends FixedString_24 implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FixedString_24Android> CREATOR = new ByteArrayCreater<FixedString_24Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString_24Android createFromParcel(@NonNull Parcel in) {
            return new FixedString_24Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString_24Android[] newArray(int size) {
            return new FixedString_24Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FixedString_24Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FIXED_STRING_24_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FixedString_24Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AF6
     */
    public FixedString_24Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FixedString_24Android(@NonNull Parcel in) {
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
