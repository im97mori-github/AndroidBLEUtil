package org.im97mori.ble.characteristic.u2b0e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.TEMPERATURE_8_IN_A_PERIOD_OF_DAY_CHARACTERISTIC;

/**
 * Temperature 8 In A Period Of Day (Characteristics UUID: 0x2B0E)
 */
@SuppressWarnings({"WeakerAccess"})
public class Temperature8InAPeriodOfDayAndroid extends Temperature8InAPeriodOfDay implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Temperature8InAPeriodOfDayAndroid> CREATOR = new ByteArrayCreater<Temperature8InAPeriodOfDayAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Temperature8InAPeriodOfDayAndroid createFromParcel(@NonNull Parcel in) {
            return new Temperature8InAPeriodOfDayAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Temperature8InAPeriodOfDayAndroid[] newArray(int size) {
            return new Temperature8InAPeriodOfDayAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Temperature8InAPeriodOfDayAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_8_IN_A_PERIOD_OF_DAY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B0E
     */
    public Temperature8InAPeriodOfDayAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param temperature Temperature
     * @param startTime   Start Time
     * @param endTime     End Time
     */
    public Temperature8InAPeriodOfDayAndroid(int temperature, int startTime, int endTime) {
        super(temperature, startTime, endTime);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Temperature8InAPeriodOfDayAndroid(@NonNull Parcel in) {
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
