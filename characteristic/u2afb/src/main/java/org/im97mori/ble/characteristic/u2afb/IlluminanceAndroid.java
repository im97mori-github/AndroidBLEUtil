package org.im97mori.ble.characteristic.u2afb;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.ILLUMINANCE_CHARACTERISTIC;

/**
 * Illuminance (Characteristics UUID: 0x2AFB)
 */
@SuppressWarnings({"WeakerAccess"})
public class IlluminanceAndroid extends Illuminance implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IlluminanceAndroid> CREATOR = new ByteArrayCreater<IlluminanceAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IlluminanceAndroid createFromParcel(@NonNull Parcel in) {
            return new IlluminanceAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IlluminanceAndroid[] newArray(int size) {
            return new IlluminanceAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IlluminanceAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ILLUMINANCE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IlluminanceAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AFB
     */
    public IlluminanceAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param illuminance Illuminance
     */
    public IlluminanceAndroid(int illuminance) {
        super(illuminance);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IlluminanceAndroid(@NonNull Parcel in) {
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
