package org.im97mori.ble.characteristic.u2a80;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.AGE_CHARACTERISTIC;

/**
 * Age (Characteristics UUID: 0x2A80)
 */
@SuppressWarnings({"WeakerAccess"})
public class AgeAndroid extends Age implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AgeAndroid> CREATOR = new ByteArrayCreator<AgeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AgeAndroid createFromParcel(@NonNull Parcel in) {
            return new AgeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AgeAndroid[] newArray(int size) {
            return new AgeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AgeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AgeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A80
     */
    public AgeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param age Age
     */
    public AgeAndroid(int age) {
        super(age);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AgeAndroid(@NonNull Parcel in) {
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
