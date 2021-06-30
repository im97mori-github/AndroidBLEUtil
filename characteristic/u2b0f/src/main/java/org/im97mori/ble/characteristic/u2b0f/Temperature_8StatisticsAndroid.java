package org.im97mori.ble.characteristic.u2b0f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.TEMPERATURE_8_STATISTICS_CHARACTERISTIC;

/**
 * Temperature 8 Statistics (Characteristics UUID: 0x2B0F)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class Temperature_8StatisticsAndroid extends Temperature_8Statistics implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Temperature_8StatisticsAndroid> CREATOR = new ByteArrayCreater<Temperature_8StatisticsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Temperature_8StatisticsAndroid createFromParcel(@NonNull Parcel in) {
            return new Temperature_8StatisticsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Temperature_8StatisticsAndroid[] newArray(int size) {
            return new Temperature_8StatisticsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Temperature_8StatisticsAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_8_STATISTICS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Temperature_8StatisticsAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B0F
     */
    public Temperature_8StatisticsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Temperature_8StatisticsAndroid(@NonNull Parcel in) {
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
