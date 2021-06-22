package org.im97mori.ble.characteristic.u2a23;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.SYSTEM_ID_CHARACTERISTIC;

/**
 * System ID (Characteristics UUID: 0x2A23)
 */
@SuppressWarnings({"WeakerAccess"})
public class SystemIdAndroid extends SystemId implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SystemIdAndroid> CREATOR = new ByteArrayCreater<SystemIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SystemIdAndroid createFromParcel(@NonNull Parcel in) {
            return new SystemIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SystemIdAndroid[] newArray(int size) {
            return new SystemIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SystemIdAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SYSTEM_ID_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SystemIdAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A23
     */
    public SystemIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param manufacturerIdentifier           Manufacturer Identifier
     * @param organizationallyUniqueIdentifier Organizationally Unique Identifier
     */
    public SystemIdAndroid(long manufacturerIdentifier, int organizationallyUniqueIdentifier) {
        super(manufacturerIdentifier, organizationallyUniqueIdentifier);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SystemIdAndroid(@NonNull Parcel in) {
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
