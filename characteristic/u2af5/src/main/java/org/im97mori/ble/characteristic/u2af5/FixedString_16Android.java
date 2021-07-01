package org.im97mori.ble.characteristic.u2af5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.FIXED_STRING_16_CHARACTERISTIC;

/**
 * Fixed String 16 (Characteristics UUID: 0x2AF5)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class FixedString_16Android extends FixedString_16 implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FixedString_16Android> CREATOR = new ByteArrayCreater<FixedString_16Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString_16Android createFromParcel(@NonNull Parcel in) {
            return new FixedString_16Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString_16Android[] newArray(int size) {
            return new FixedString_16Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FixedString_16Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FIXED_STRING_16_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FixedString_16Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AF5
     */
    public FixedString_16Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FixedString_16Android(@NonNull Parcel in) {
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