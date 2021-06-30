package org.im97mori.ble.characteristic.u2bae;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.ADVERTISING_CONSTANT_TONE_EXTENSION_MINIMUM_LENGTH_CHARACTERISTIC;

/**
 * Advertising Constant Tone Extension Minimum Length (Characteristics UUID: 0x2BAE)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AdvertisingConstantToneExtensionMinimumLengthAndroid extends AdvertisingConstantToneExtensionMinimumLength implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AdvertisingConstantToneExtensionMinimumLengthAndroid> CREATOR = new ByteArrayCreater<AdvertisingConstantToneExtensionMinimumLengthAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AdvertisingConstantToneExtensionMinimumLengthAndroid createFromParcel(@NonNull Parcel in) {
            return new AdvertisingConstantToneExtensionMinimumLengthAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AdvertisingConstantToneExtensionMinimumLengthAndroid[] newArray(int size) {
            return new AdvertisingConstantToneExtensionMinimumLengthAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AdvertisingConstantToneExtensionMinimumLengthAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ADVERTISING_CONSTANT_TONE_EXTENSION_MINIMUM_LENGTH_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AdvertisingConstantToneExtensionMinimumLengthAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BAE
     */
    public AdvertisingConstantToneExtensionMinimumLengthAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AdvertisingConstantToneExtensionMinimumLengthAndroid(@NonNull Parcel in) {
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
