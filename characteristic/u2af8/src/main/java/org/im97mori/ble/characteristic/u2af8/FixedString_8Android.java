package org.im97mori.ble.characteristic.u2af8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.FIXED_STRING_8_CHARACTERISTIC;

/**
 * Fixed String 8 (Characteristics UUID: 0x2AF8)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class FixedString_8Android extends FixedString_8 implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FixedString_8Android> CREATOR = new ByteArrayCreater<FixedString_8Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString_8Android createFromParcel(@NonNull Parcel in) {
            return new FixedString_8Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString_8Android[] newArray(int size) {
            return new FixedString_8Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FixedString_8Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FIXED_STRING_8_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FixedString_8Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AF8
     */
    public FixedString_8Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FixedString_8Android(@NonNull Parcel in) {
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
