package org.im97mori.ble.characteristic.u2bbb;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.STATUS_FLAGS_CHARACTERISTIC;

/**
 * Status Flags (Characteristics UUID: 0x2BBB)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class StatusFlagsAndroid extends StatusFlags implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<StatusFlagsAndroid> CREATOR = new ByteArrayCreator<StatusFlagsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StatusFlagsAndroid createFromParcel(@NonNull Parcel in) {
            return new StatusFlagsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StatusFlagsAndroid[] newArray(int size) {
            return new StatusFlagsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public StatusFlagsAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STATUS_FLAGS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new StatusFlagsAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BBB
     */
    public StatusFlagsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private StatusFlagsAndroid(@NonNull Parcel in) {
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
