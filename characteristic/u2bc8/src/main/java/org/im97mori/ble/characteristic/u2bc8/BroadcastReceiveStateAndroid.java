package org.im97mori.ble.characteristic.u2bc8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.BROADCAST_RECEIVE_STATE_CHARACTERISTIC;

/**
 * Broadcast Receive State (Characteristics UUID: 0x2BC8)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BroadcastReceiveStateAndroid extends BroadcastReceiveState implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BroadcastReceiveStateAndroid> CREATOR = new ByteArrayCreator<BroadcastReceiveStateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BroadcastReceiveStateAndroid createFromParcel(@NonNull Parcel in) {
            return new BroadcastReceiveStateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BroadcastReceiveStateAndroid[] newArray(int size) {
            return new BroadcastReceiveStateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BroadcastReceiveStateAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BROADCAST_RECEIVE_STATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BroadcastReceiveStateAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BC8
     */
    public BroadcastReceiveStateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BroadcastReceiveStateAndroid(@NonNull Parcel in) {
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
