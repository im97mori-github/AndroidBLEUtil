package org.im97mori.ble.characteristic.u2bc2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.CALL_FRIENDLY_NAME_CHARACTERISTIC;

/**
 * Call Friendly Name (Characteristics UUID: 0x2BC2)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CallFriendlyNameAndroid extends CallFriendlyName implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CallFriendlyNameAndroid> CREATOR = new ByteArrayCreater<CallFriendlyNameAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CallFriendlyNameAndroid createFromParcel(@NonNull Parcel in) {
            return new CallFriendlyNameAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CallFriendlyNameAndroid[] newArray(int size) {
            return new CallFriendlyNameAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CallFriendlyNameAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CALL_FRIENDLY_NAME_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CallFriendlyNameAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BC2
     */
    public CallFriendlyNameAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CallFriendlyNameAndroid(@NonNull Parcel in) {
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
