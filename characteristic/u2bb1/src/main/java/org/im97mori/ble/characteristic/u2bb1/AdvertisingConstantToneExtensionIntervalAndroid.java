package org.im97mori.ble.characteristic.u2bb1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ADVERTISING_CONSTANT_TONE_EXTENSION_INTERVAL_CHARACTERISTIC;

/**
 * Advertising Constant Tone Extension Interval (Characteristics UUID: 0x2BB1)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AdvertisingConstantToneExtensionIntervalAndroid extends AdvertisingConstantToneExtensionInterval implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AdvertisingConstantToneExtensionIntervalAndroid> CREATOR = new ByteArrayCreator<AdvertisingConstantToneExtensionIntervalAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AdvertisingConstantToneExtensionIntervalAndroid createFromParcel(@NonNull Parcel in) {
            return new AdvertisingConstantToneExtensionIntervalAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AdvertisingConstantToneExtensionIntervalAndroid[] newArray(int size) {
            return new AdvertisingConstantToneExtensionIntervalAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AdvertisingConstantToneExtensionIntervalAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ADVERTISING_CONSTANT_TONE_EXTENSION_INTERVAL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AdvertisingConstantToneExtensionIntervalAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BB1
     */
    public AdvertisingConstantToneExtensionIntervalAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AdvertisingConstantToneExtensionIntervalAndroid(@NonNull Parcel in) {
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
