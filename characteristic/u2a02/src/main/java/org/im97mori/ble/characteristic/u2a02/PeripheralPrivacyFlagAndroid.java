package org.im97mori.ble.characteristic.u2a02;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC;

/**
 * Peripheral Privacy Flag (Characteristics UUID: 0x2A02)
 */
@SuppressWarnings({"WeakerAccess"})
public class PeripheralPrivacyFlagAndroid extends PeripheralPrivacyFlag implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<PeripheralPrivacyFlagAndroid> CREATOR = new ByteArrayCreater<PeripheralPrivacyFlagAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PeripheralPrivacyFlagAndroid createFromParcel(@NonNull Parcel in) {
            return new PeripheralPrivacyFlagAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PeripheralPrivacyFlagAndroid[] newArray(int size) {
            return new PeripheralPrivacyFlagAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PeripheralPrivacyFlagAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PeripheralPrivacyFlagAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A02
     */
    public PeripheralPrivacyFlagAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param flag Flag
     */
    public PeripheralPrivacyFlagAndroid(int flag) {
        super(flag);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PeripheralPrivacyFlagAndroid(@NonNull Parcel in) {
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
