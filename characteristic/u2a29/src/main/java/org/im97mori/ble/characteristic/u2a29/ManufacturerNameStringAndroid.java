package org.im97mori.ble.characteristic.u2a29;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MANUFACTURER_NAME_STRING_CHARACTERISTIC;

/**
 * Manufacturer Name String (Characteristics UUID: 0x2A29)
 */
@SuppressWarnings({"WeakerAccess"})
public class ManufacturerNameStringAndroid extends ManufacturerNameString implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ManufacturerNameStringAndroid> CREATOR = new ByteArrayCreater<ManufacturerNameStringAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ManufacturerNameStringAndroid createFromParcel(@NonNull Parcel in) {
            return new ManufacturerNameStringAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ManufacturerNameStringAndroid[] newArray(int size) {
            return new ManufacturerNameStringAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ManufacturerNameStringAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MANUFACTURER_NAME_STRING_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ManufacturerNameStringAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A29
     */
    public ManufacturerNameStringAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param manufacturerName Manufacturer Name
     */
    public ManufacturerNameStringAndroid(@NonNull String manufacturerName) {
        super(manufacturerName);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private ManufacturerNameStringAndroid(@NonNull Parcel in) {
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
