package org.im97mori.ble.characteristic.u2b13;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.TIME_EXPONENTIAL_8_CHARACTERISTIC;

/**
 * Time Exponential 8 (Characteristics UUID: 0x2B13)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TimeExponential_8Android extends TimeExponential_8 implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TimeExponential_8Android> CREATOR = new ByteArrayCreater<TimeExponential_8Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeExponential_8Android createFromParcel(@NonNull Parcel in) {
            return new TimeExponential_8Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeExponential_8Android[] newArray(int size) {
            return new TimeExponential_8Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeExponential_8Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_EXPONENTIAL_8_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeExponential_8Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B13
     */
    public TimeExponential_8Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeExponential_8Android(@NonNull Parcel in) {
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
