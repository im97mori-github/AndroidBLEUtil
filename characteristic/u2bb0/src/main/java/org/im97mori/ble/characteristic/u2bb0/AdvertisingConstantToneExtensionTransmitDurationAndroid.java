package org.im97mori.ble.characteristic.u2bb0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ADVERTISING_CONSTANT_TONE_EXTENSION_TRANSMIT_DURATION_CHARACTERISTIC;

/**
 * Advertising Constant Tone Extension Transmit Duration (Characteristics UUID: 0x2BB0)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AdvertisingConstantToneExtensionTransmitDurationAndroid extends AdvertisingConstantToneExtensionTransmitDuration implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AdvertisingConstantToneExtensionTransmitDurationAndroid> CREATOR = new ByteArrayCreator<AdvertisingConstantToneExtensionTransmitDurationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AdvertisingConstantToneExtensionTransmitDurationAndroid createFromParcel(@NonNull Parcel in) {
            return new AdvertisingConstantToneExtensionTransmitDurationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AdvertisingConstantToneExtensionTransmitDurationAndroid[] newArray(int size) {
            return new AdvertisingConstantToneExtensionTransmitDurationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AdvertisingConstantToneExtensionTransmitDurationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ADVERTISING_CONSTANT_TONE_EXTENSION_TRANSMIT_DURATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AdvertisingConstantToneExtensionTransmitDurationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BB0
     */
    public AdvertisingConstantToneExtensionTransmitDurationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AdvertisingConstantToneExtensionTransmitDurationAndroid(@NonNull Parcel in) {
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
