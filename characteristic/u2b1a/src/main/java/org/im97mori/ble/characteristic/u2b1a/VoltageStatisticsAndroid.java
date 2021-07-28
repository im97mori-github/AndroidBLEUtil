package org.im97mori.ble.characteristic.u2b1a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.VOLTAGE_STATISTICS_CHARACTERISTIC;

/**
 * Voltage Statistics (Characteristics UUID: 0x2B1A)
 */
@SuppressWarnings({"WeakerAccess"})
public class VoltageStatisticsAndroid extends VoltageStatistics implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<VoltageStatisticsAndroid> CREATOR = new ByteArrayCreater<VoltageStatisticsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VoltageStatisticsAndroid createFromParcel(@NonNull Parcel in) {
            return new VoltageStatisticsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VoltageStatisticsAndroid[] newArray(int size) {
            return new VoltageStatisticsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VoltageStatisticsAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(VOLTAGE_STATISTICS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B1A
     */
    public VoltageStatisticsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param averageVoltageValue           Average Voltage Value
     * @param standardDeviationVoltageValue Standard Deviation Voltage Value
     * @param minimumVoltageValue           Minimum Voltage Value
     * @param maximumVoltageValue           Maximum Voltage Value
     * @param sensingDuration               Sensing Duration
     */
    public VoltageStatisticsAndroid(int averageVoltageValue, int standardDeviationVoltageValue, int minimumVoltageValue, int maximumVoltageValue, int sensingDuration) {
        super(averageVoltageValue, standardDeviationVoltageValue, minimumVoltageValue, maximumVoltageValue, sensingDuration);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private VoltageStatisticsAndroid(@NonNull Parcel in) {
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
