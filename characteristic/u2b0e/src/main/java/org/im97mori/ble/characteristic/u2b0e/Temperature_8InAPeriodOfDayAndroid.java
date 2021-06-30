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
// TODO
@SuppressWarnings({"WeakerAccess"})
public class Temperature_8InAPeriodOfDayAndroid extends Temperature_8InAPeriodOfDay implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Temperature_8InAPeriodOfDayAndroid> CREATOR = new ByteArrayCreater<Temperature_8InAPeriodOfDayAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Temperature_8InAPeriodOfDayAndroid createFromParcel(@NonNull Parcel in) {
            return new Temperature_8InAPeriodOfDayAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Temperature_8InAPeriodOfDayAndroid[] newArray(int size) {
            return new Temperature_8InAPeriodOfDayAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Temperature_8InAPeriodOfDayAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_8_IN_A_PERIOD_OF_DAY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Temperature_8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B0E
     */
    public Temperature_8InAPeriodOfDayAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Temperature_8InAPeriodOfDayAndroid(@NonNull Parcel in) {
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
