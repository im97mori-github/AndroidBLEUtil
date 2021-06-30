package org.im97mori.ble.characteristic.u2aea;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.COUNT_16_CHARACTERISTIC;

/**
 * Count 16 (Characteristics UUID: 0x2AEA)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class Count_16Android extends Count_16 implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Count_16Android> CREATOR = new ByteArrayCreater<Count_16Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Count_16Android createFromParcel(@NonNull Parcel in) {
            return new Count_16Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Count_16Android[] newArray(int size) {
            return new Count_16Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Count_16Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(COUNT_16_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Count_16Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AEA
     */
    public Count_16Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Count_16Android(@NonNull Parcel in) {
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
