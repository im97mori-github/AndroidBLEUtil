package org.im97mori.ble.characteristic.u2b7d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.VOLUME_STATE_CHARACTERISTIC;

/**
 * Volume State (Characteristics UUID: 0x2B7D)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class VolumeStateAndroid extends VolumeState implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<VolumeStateAndroid> CREATOR = new ByteArrayCreater<VolumeStateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VolumeStateAndroid createFromParcel(@NonNull Parcel in) {
            return new VolumeStateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VolumeStateAndroid[] newArray(int size) {
            return new VolumeStateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VolumeStateAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(VOLUME_STATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new VolumeStateAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B7D
     */
    public VolumeStateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private VolumeStateAndroid(@NonNull Parcel in) {
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
