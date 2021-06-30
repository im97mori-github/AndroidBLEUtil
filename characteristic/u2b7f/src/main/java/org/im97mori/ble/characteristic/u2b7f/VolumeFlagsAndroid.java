package org.im97mori.ble.characteristic.u2b7f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.VOLUME_FLAGS_CHARACTERISTIC;

/**
 * Volume Flags (Characteristics UUID: 0x2B7F)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class VolumeFlagsAndroid extends VolumeFlags implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<VolumeFlagsAndroid> CREATOR = new ByteArrayCreater<VolumeFlagsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VolumeFlagsAndroid createFromParcel(@NonNull Parcel in) {
            return new VolumeFlagsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VolumeFlagsAndroid[] newArray(int size) {
            return new VolumeFlagsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VolumeFlagsAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(VOLUME_FLAGS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new VolumeFlagsAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B7F
     */
    public VolumeFlagsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private VolumeFlagsAndroid(@NonNull Parcel in) {
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
