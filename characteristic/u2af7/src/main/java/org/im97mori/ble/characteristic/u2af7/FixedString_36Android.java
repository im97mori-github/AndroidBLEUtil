package org.im97mori.ble.characteristic.u2af7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.FIXED_STRING_36_CHARACTERISTIC;

/**
 * Fixed String 36 (Characteristics UUID: 0x2AF7)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class FixedString_36Android extends FixedString_36 implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FixedString_36Android> CREATOR = new ByteArrayCreater<FixedString_36Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString_36Android createFromParcel(@NonNull Parcel in) {
            return new FixedString_36Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString_36Android[] newArray(int size) {
            return new FixedString_36Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FixedString_36Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FIXED_STRING_36_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FixedString_36Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AF7
     */
    public FixedString_36Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FixedString_36Android(@NonNull Parcel in) {
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
