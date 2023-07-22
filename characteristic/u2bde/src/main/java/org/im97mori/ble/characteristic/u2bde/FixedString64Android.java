package org.im97mori.ble.characteristic.u2bde;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.FIXED_STRING_64_CHARACTERISTIC;

/**
 * Fixed String 64 (Characteristics UUID: 0x2BDE)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class FixedString64Android extends FixedString64 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<FixedString64Android> CREATOR = new ByteArrayCreator<FixedString64Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString64Android createFromParcel(@NonNull Parcel in) {
            return new FixedString64Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FixedString64Android[] newArray(int size) {
            return new FixedString64Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FixedString64Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FIXED_STRING_64_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FixedString64Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BDE
     */
    public FixedString64Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FixedString64Android(@NonNull Parcel in) {
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
