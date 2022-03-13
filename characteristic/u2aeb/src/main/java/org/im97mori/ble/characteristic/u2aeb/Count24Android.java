package org.im97mori.ble.characteristic.u2aeb;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.COUNT_24_CHARACTERISTIC;

/**
 * Count 24 (Characteristics UUID: 0x2AEB)
 */
@SuppressWarnings({"WeakerAccess"})
public class Count24Android extends Count24 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<Count24Android> CREATOR = new ByteArrayCreator<Count24Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Count24Android createFromParcel(@NonNull Parcel in) {
            return new Count24Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Count24Android[] newArray(int size) {
            return new Count24Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Count24Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(COUNT_24_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Count24Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AEB
     */
    public Count24Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param count Count
     */
    public Count24Android(int count) {
        super(count);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Count24Android(@NonNull Parcel in) {
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
