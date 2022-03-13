package org.im97mori.ble.characteristic.u2b4a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.HANDEDNESS_CHARACTERISTIC;

/**
 * Handedness (Characteristics UUID: 0x2B4A)
 */
@SuppressWarnings({"WeakerAccess"})
public class HandednessAndroid extends Handedness implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HandednessAndroid> CREATOR = new ByteArrayCreator<HandednessAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HandednessAndroid createFromParcel(@NonNull Parcel in) {
            return new HandednessAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HandednessAndroid[] newArray(int size) {
            return new HandednessAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HandednessAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HANDEDNESS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HandednessAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B4A
     */
    public HandednessAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param handedness Handedness
     */
    public HandednessAndroid(int handedness) {
        super(handedness);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HandednessAndroid(@NonNull Parcel in) {
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
