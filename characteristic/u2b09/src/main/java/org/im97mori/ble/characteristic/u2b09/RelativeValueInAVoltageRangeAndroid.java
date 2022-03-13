package org.im97mori.ble.characteristic.u2b09;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.RELATIVE_VALUE_IN_A_VOLTAGE_RANGE_CHARACTERISTIC;

/**
 * Relative Value In A Voltage Range (Characteristics UUID: 0x2B09)
 */
@SuppressWarnings({"WeakerAccess"})
public class RelativeValueInAVoltageRangeAndroid extends RelativeValueInAVoltageRange implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RelativeValueInAVoltageRangeAndroid> CREATOR = new ByteArrayCreator<RelativeValueInAVoltageRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeValueInAVoltageRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new RelativeValueInAVoltageRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeValueInAVoltageRangeAndroid[] newArray(int size) {
            return new RelativeValueInAVoltageRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RelativeValueInAVoltageRangeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RELATIVE_VALUE_IN_A_VOLTAGE_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RelativeValueInAVoltageRangeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B09
     */
    public RelativeValueInAVoltageRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param relativeValue  Relative Value
     * @param minimumVoltage Minimum Voltage
     * @param maximumVoltage Maximum Voltage
     */
    public RelativeValueInAVoltageRangeAndroid(int relativeValue, int minimumVoltage, int maximumVoltage) {
        super(relativeValue, minimumVoltage, maximumVoltage);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RelativeValueInAVoltageRangeAndroid(@NonNull Parcel in) {
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
