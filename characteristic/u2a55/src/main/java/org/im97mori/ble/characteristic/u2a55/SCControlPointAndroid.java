package org.im97mori.ble.characteristic.u2a55;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SC_CONTROL_POINT_CHARACTERISTIC;

/**
 * SC Control Point (Characteristics UUID: 0x2A55)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SCControlPointAndroid extends SCControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SCControlPointAndroid> CREATOR = new ByteArrayCreater<SCControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SCControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new SCControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SCControlPointAndroid[] newArray(int size) {
            return new SCControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SCControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SCControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A55
     */
    public SCControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private SCControlPointAndroid(@NonNull Parcel in) {
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
