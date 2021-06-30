package org.im97mori.ble.characteristic.u2bbd;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.CALL_STATE_CHARACTERISTIC;

/**
 * Call State (Characteristics UUID: 0x2BBD)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CallStateAndroid extends CallState implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CallStateAndroid> CREATOR = new ByteArrayCreater<CallStateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CallStateAndroid createFromParcel(@NonNull Parcel in) {
            return new CallStateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CallStateAndroid[] newArray(int size) {
            return new CallStateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CallStateAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CALL_STATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CallStateAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BBD
     */
    public CallStateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CallStateAndroid(@NonNull Parcel in) {
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
