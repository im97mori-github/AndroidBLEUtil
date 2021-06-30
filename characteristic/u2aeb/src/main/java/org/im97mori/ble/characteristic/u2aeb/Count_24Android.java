package org.im97mori.ble.characteristic.u2aeb;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.COUNT_24_CHARACTERISTIC;

/**
 * Count 24 (Characteristics UUID: 0x2AEB)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class Count_24Android extends Count_24 implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Count_24Android> CREATOR = new ByteArrayCreater<Count_24Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Count_24Android createFromParcel(@NonNull Parcel in) {
            return new Count_24Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Count_24Android[] newArray(int size) {
            return new Count_24Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Count_24Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(COUNT_24_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Count_24Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AEB
     */
    public Count_24Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Count_24Android(@NonNull Parcel in) {
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
