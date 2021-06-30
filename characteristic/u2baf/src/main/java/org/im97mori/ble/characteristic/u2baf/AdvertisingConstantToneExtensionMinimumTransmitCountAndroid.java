package org.im97mori.ble.characteristic.u2baf;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.ADVERTISING_CONSTANT_TONE_EXTENSION_MINIMUM_TRANSMIT_COUNT_CHARACTERISTIC;

/**
 * Advertising Constant Tone Extension Minimum Transmit Count (Characteristics UUID: 0x2BAF)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AdvertisingConstantToneExtensionMinimumTransmitCountAndroid extends AdvertisingConstantToneExtensionMinimumTransmitCount implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AdvertisingConstantToneExtensionMinimumTransmitCountAndroid> CREATOR = new ByteArrayCreater<AdvertisingConstantToneExtensionMinimumTransmitCountAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AdvertisingConstantToneExtensionMinimumTransmitCountAndroid createFromParcel(@NonNull Parcel in) {
            return new AdvertisingConstantToneExtensionMinimumTransmitCountAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AdvertisingConstantToneExtensionMinimumTransmitCountAndroid[] newArray(int size) {
            return new AdvertisingConstantToneExtensionMinimumTransmitCountAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AdvertisingConstantToneExtensionMinimumTransmitCountAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ADVERTISING_CONSTANT_TONE_EXTENSION_MINIMUM_TRANSMIT_COUNT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AdvertisingConstantToneExtensionMinimumTransmitCountAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BAF
     */
    public AdvertisingConstantToneExtensionMinimumTransmitCountAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AdvertisingConstantToneExtensionMinimumTransmitCountAndroid(@NonNull Parcel in) {
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
