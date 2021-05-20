package org.im97mori.ble.characteristic.u2a76;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.UV_INDEX_CHARACTERISTIC;

/**
 * UV Index (Characteristics UUID: 0x2A76)
 */
@SuppressWarnings({"WeakerAccess"})
public class UVIndexAndroid extends UVIndex implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<UVIndexAndroid> CREATOR = new ByteArrayCreater<UVIndexAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UVIndexAndroid createFromParcel(@NonNull Parcel in) {
            return new UVIndexAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UVIndexAndroid[] newArray(int size) {
            return new UVIndexAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public UVIndexAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UV_INDEX_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new UVIndexAndroid(bluetoothGattCharacteristic);
        }

    };
    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A76
     */
    public UVIndexAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param UVIndex UV Index
     */
    public UVIndexAndroid(int UVIndex) {
        super(UVIndex);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private UVIndexAndroid(@NonNull Parcel in) {
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
