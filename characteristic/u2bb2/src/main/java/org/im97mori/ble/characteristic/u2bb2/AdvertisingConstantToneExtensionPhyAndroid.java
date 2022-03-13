package org.im97mori.ble.characteristic.u2bb2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ADVERTISING_CONSTANT_TONE_EXTENSION_PHY_CHARACTERISTIC;

/**
 * Advertising Constant Tone Extension PHY (Characteristics UUID: 0x2BB2)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AdvertisingConstantToneExtensionPhyAndroid extends AdvertisingConstantToneExtensionPhy implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AdvertisingConstantToneExtensionPhyAndroid> CREATOR = new ByteArrayCreator<AdvertisingConstantToneExtensionPhyAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AdvertisingConstantToneExtensionPhyAndroid createFromParcel(@NonNull Parcel in) {
            return new AdvertisingConstantToneExtensionPhyAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AdvertisingConstantToneExtensionPhyAndroid[] newArray(int size) {
            return new AdvertisingConstantToneExtensionPhyAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AdvertisingConstantToneExtensionPhyAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ADVERTISING_CONSTANT_TONE_EXTENSION_PHY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AdvertisingConstantToneExtensionPhyAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BB2
     */
    public AdvertisingConstantToneExtensionPhyAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AdvertisingConstantToneExtensionPhyAndroid(@NonNull Parcel in) {
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
