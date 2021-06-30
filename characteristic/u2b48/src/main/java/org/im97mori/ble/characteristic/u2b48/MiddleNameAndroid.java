package org.im97mori.ble.characteristic.u2b48;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.MIDDLE_NAME_CHARACTERISTIC;

/**
 * Middle Name (Characteristics UUID: 0x2B48)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class MiddleNameAndroid extends MiddleName implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<MiddleNameAndroid> CREATOR = new ByteArrayCreater<MiddleNameAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MiddleNameAndroid createFromParcel(@NonNull Parcel in) {
            return new MiddleNameAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MiddleNameAndroid[] newArray(int size) {
            return new MiddleNameAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MiddleNameAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MIDDLE_NAME_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MiddleNameAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B48
     */
    public MiddleNameAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MiddleNameAndroid(@NonNull Parcel in) {
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
