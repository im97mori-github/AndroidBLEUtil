package org.im97mori.ble.characteristic.u2baf;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Advertising Constant Tone Extension Minimum Transmit Count (Characteristics UUID: 0x2BAF)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AdvertisingConstantToneExtensionMinimumTransmitCountAndroid extends AdvertisingConstantToneExtensionMinimumTransmitCount implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AdvertisingConstantToneExtensionMinimumTransmitCountAndroid> CREATOR = new ByteArrayCreator<AdvertisingConstantToneExtensionMinimumTransmitCountAndroid>() {

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
            return new AdvertisingConstantToneExtensionMinimumTransmitCountAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BAF
     */
    @Deprecated
    public AdvertisingConstantToneExtensionMinimumTransmitCountAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AdvertisingConstantToneExtensionMinimumTransmitCountAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AdvertisingConstantToneExtensionMinimumTransmitCountAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()));
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
