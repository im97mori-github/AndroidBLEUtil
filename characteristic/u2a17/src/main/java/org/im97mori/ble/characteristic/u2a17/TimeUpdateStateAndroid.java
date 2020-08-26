package org.im97mori.ble.characteristic.u2a17;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TIME_UPDATE_STATE_CHARACTERISTIC;

/**
 * Time Update State (Characteristics UUID: 0x2A17)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeUpdateStateAndroid extends TimeUpdateState implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TimeUpdateStateAndroid> CREATOR = new ByteArrayCreater<TimeUpdateStateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeUpdateStateAndroid createFromParcel(@NonNull Parcel in) {
            return new TimeUpdateStateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeUpdateStateAndroid[] newArray(int size) {
            return new TimeUpdateStateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeUpdateStateAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_UPDATE_STATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeUpdateStateAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A17
     */
    public TimeUpdateStateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param currentState Current State
     * @param result       Result
     */
    public TimeUpdateStateAndroid(int currentState, int result) {
        super(currentState, result);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private TimeUpdateStateAndroid(@NonNull Parcel in) {
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
