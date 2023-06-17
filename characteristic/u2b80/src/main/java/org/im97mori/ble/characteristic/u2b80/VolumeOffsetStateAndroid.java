package org.im97mori.ble.characteristic.u2b80;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.VOLUME_OFFSET_STATE_CHARACTERISTIC;

/**
 * Volume Offset State (Characteristics UUID: 0x2B80)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class VolumeOffsetStateAndroid extends VolumeOffsetState implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<VolumeOffsetStateAndroid> CREATOR = new ByteArrayCreator<VolumeOffsetStateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VolumeOffsetStateAndroid createFromParcel(@NonNull Parcel in) {
            return new VolumeOffsetStateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VolumeOffsetStateAndroid[] newArray(int size) {
            return new VolumeOffsetStateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VolumeOffsetStateAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(VOLUME_OFFSET_STATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new VolumeOffsetStateAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B80
     */
    public VolumeOffsetStateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private VolumeOffsetStateAndroid(@NonNull Parcel in) {
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
