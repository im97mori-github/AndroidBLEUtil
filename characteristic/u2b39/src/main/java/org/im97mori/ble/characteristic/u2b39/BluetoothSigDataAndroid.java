package org.im97mori.ble.characteristic.u2b39;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.BLUETOOTH_SIG_DATA_CHARACTERISTIC;

/**
 * Bluetooth SIG Data (Characteristics UUID: 0x2B39)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BluetoothSigDataAndroid extends BluetoothSigData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BluetoothSigDataAndroid> CREATOR = new ByteArrayCreater<BluetoothSigDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BluetoothSigDataAndroid createFromParcel(@NonNull Parcel in) {
            return new BluetoothSigDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BluetoothSigDataAndroid[] newArray(int size) {
            return new BluetoothSigDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BluetoothSigDataAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BLUETOOTH_SIG_DATA_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BluetoothSigDataAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B39
     */
    public BluetoothSigDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BluetoothSigDataAndroid(@NonNull Parcel in) {
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
