package org.im97mori.ble.characteristic.u2bb9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.BEARER_LIST_CURRENT_CALLS_CHARACTERISTIC;

/**
 * Bearer List Current Calls (Characteristics UUID: 0x2BB9)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BearerListCurrentCallsAndroid extends BearerListCurrentCalls implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<BearerListCurrentCallsAndroid> CREATOR = new ByteArrayCreater<BearerListCurrentCallsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerListCurrentCallsAndroid createFromParcel(@NonNull Parcel in) {
            return new BearerListCurrentCallsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerListCurrentCallsAndroid[] newArray(int size) {
            return new BearerListCurrentCallsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BearerListCurrentCallsAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BEARER_LIST_CURRENT_CALLS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new BearerListCurrentCallsAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BB9
     */
    public BearerListCurrentCallsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BearerListCurrentCallsAndroid(@NonNull Parcel in) {
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
