package org.im97mori.ble.characteristic.u2bad;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.CONSTANT_TONE_EXTENSION_ENABLE_CHARACTERISTIC;

/**
 * Constant Tone Extension Enable (Characteristics UUID: 0x2BAD)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class ConstantToneExtensionEnableAndroid extends ConstantToneExtensionEnable implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ConstantToneExtensionEnableAndroid> CREATOR = new ByteArrayCreater<ConstantToneExtensionEnableAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ConstantToneExtensionEnableAndroid createFromParcel(@NonNull Parcel in) {
            return new ConstantToneExtensionEnableAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ConstantToneExtensionEnableAndroid[] newArray(int size) {
            return new ConstantToneExtensionEnableAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ConstantToneExtensionEnableAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CONSTANT_TONE_EXTENSION_ENABLE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ConstantToneExtensionEnableAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BAD
     */
    public ConstantToneExtensionEnableAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ConstantToneExtensionEnableAndroid(@NonNull Parcel in) {
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
