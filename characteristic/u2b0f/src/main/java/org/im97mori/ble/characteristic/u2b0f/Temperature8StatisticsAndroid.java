package org.im97mori.ble.characteristic.u2b0f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.TEMPERATURE_8_STATISTICS_CHARACTERISTIC;

/**
 * Temperature 8 Statistics (Characteristics UUID: 0x2B0F)
 */
@SuppressWarnings({"WeakerAccess"})
public class Temperature8StatisticsAndroid extends Temperature8Statistics implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<Temperature8StatisticsAndroid> CREATOR = new ByteArrayCreator<Temperature8StatisticsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Temperature8StatisticsAndroid createFromParcel(@NonNull Parcel in) {
            return new Temperature8StatisticsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Temperature8StatisticsAndroid[] newArray(int size) {
            return new Temperature8StatisticsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Temperature8StatisticsAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_8_STATISTICS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Temperature8StatisticsAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B0F
     */
    public Temperature8StatisticsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param average Average
     * @param standardDeviationValue Standard Deviation Value
     * @param minimumValue Minimum Value
     * @param maximumValue Maximum Value
     * @param sensingDuration Sensing Duration
     */
    public Temperature8StatisticsAndroid(int average, int standardDeviationValue, int minimumValue, int maximumValue, int sensingDuration) {
        super(average, standardDeviationValue, minimumValue, maximumValue, sensingDuration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Temperature8StatisticsAndroid(@NonNull Parcel in) {
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
