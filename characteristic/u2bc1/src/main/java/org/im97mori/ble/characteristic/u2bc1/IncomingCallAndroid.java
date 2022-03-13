package org.im97mori.ble.characteristic.u2bc1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.INCOMING_CALL_CHARACTERISTIC;

/**
 * Incoming Call (Characteristics UUID: 0x2BC1)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IncomingCallAndroid extends IncomingCall implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IncomingCallAndroid> CREATOR = new ByteArrayCreator<IncomingCallAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IncomingCallAndroid createFromParcel(@NonNull Parcel in) {
            return new IncomingCallAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IncomingCallAndroid[] newArray(int size) {
            return new IncomingCallAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IncomingCallAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INCOMING_CALL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IncomingCallAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BC1
     */
    public IncomingCallAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IncomingCallAndroid(@NonNull Parcel in) {
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
