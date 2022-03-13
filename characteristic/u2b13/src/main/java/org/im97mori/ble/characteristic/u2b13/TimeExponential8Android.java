package org.im97mori.ble.characteristic.u2b13;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.TIME_EXPONENTIAL_8_CHARACTERISTIC;

/**
 * Time Exponential 8 (Characteristics UUID: 0x2B13)
 */
@SuppressWarnings({"WeakerAccess"})
public class TimeExponential8Android extends TimeExponential8 implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TimeExponential8Android> CREATOR = new ByteArrayCreator<TimeExponential8Android>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeExponential8Android createFromParcel(@NonNull Parcel in) {
            return new TimeExponential8Android(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeExponential8Android[] newArray(int size) {
            return new TimeExponential8Android[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeExponential8Android createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_EXPONENTIAL_8_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeExponential8Android(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B13
     */
    public TimeExponential8Android(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param timeExponential8 Time Exponential 8
     */
    public TimeExponential8Android(int timeExponential8) {
        super(timeExponential8);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeExponential8Android(@NonNull Parcel in) {
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
