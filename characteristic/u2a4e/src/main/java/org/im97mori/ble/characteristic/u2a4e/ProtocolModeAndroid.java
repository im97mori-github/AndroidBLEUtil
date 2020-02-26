package org.im97mori.ble.characteristic.u2a4e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.PROTOCOL_MODE_CHARACTERISTIC;

/**
 * Protocol Mode (Characteristics UUID: 0x2A4E)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ProtocolModeAndroid extends ProtocolMode implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ProtocolModeAndroid> CREATOR = new ByteArrayCreater<ProtocolModeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ProtocolModeAndroid createFromParcel(@NonNull Parcel in) {
            return new ProtocolModeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ProtocolModeAndroid[] newArray(int size) {
            return new ProtocolModeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ProtocolModeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PROTOCOL_MODE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ProtocolModeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A4E
     */
    public ProtocolModeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private ProtocolModeAndroid(@NonNull Parcel in) {
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
