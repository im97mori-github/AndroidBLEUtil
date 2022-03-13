package org.im97mori.ble.characteristic.u2aea;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.COUNT_16_CHARACTERISTIC;

/**
 * Count 16 (Characteristics UUID: 0x2AEA)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class Count16Android extends Count16 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<Count16Android> CREATOR = new ByteArrayCreator<Count16Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Count16Android createFromParcel(@NonNull Parcel in) {
            return new Count16Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Count16Android[] newArray(int size) {
            return new Count16Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Count16Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(COUNT_16_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Count16Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AEA
     */
    public Count16Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param count Count
     */
    public Count16Android(int count) {
        super(count);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Count16Android(@NonNull Parcel in) {
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
