package org.im97mori.ble.characteristic.u2b80;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.OFFSET_STATE_CHARACTERISTIC;

/**
 * Offset State (Characteristics UUID: 0x2B80)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class OffsetStateAndroid extends OffsetState implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<OffsetStateAndroid> CREATOR = new ByteArrayCreater<OffsetStateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public OffsetStateAndroid createFromParcel(@NonNull Parcel in) {
            return new OffsetStateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public OffsetStateAndroid[] newArray(int size) {
            return new OffsetStateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public OffsetStateAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(OFFSET_STATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new OffsetStateAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B80
     */
    public OffsetStateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private OffsetStateAndroid(@NonNull Parcel in) {
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
