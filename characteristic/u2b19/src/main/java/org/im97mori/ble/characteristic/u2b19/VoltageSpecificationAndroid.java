package org.im97mori.ble.characteristic.u2b19;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.VOLTAGE_SPECIFICATION_CHARACTERISTIC;

/**
 * Voltage Specification (Characteristics UUID: 0x2B19)
 */
@SuppressWarnings({"WeakerAccess"})
public class VoltageSpecificationAndroid extends VoltageSpecification implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<VoltageSpecificationAndroid> CREATOR = new ByteArrayCreator<VoltageSpecificationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VoltageSpecificationAndroid createFromParcel(@NonNull Parcel in) {
            return new VoltageSpecificationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public VoltageSpecificationAndroid[] newArray(int size) {
            return new VoltageSpecificationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public VoltageSpecificationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(VOLTAGE_SPECIFICATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new VoltageSpecificationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B19
     */
    public VoltageSpecificationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param minimumVoltageValue Minimum Voltage Value
     * @param typicalVoltageValue Typical Voltage Value
     * @param maximumVoltageValue Maximum Voltage Value
     */
    public VoltageSpecificationAndroid(int minimumVoltageValue, int typicalVoltageValue, int maximumVoltageValue) {
        super(minimumVoltageValue, typicalVoltageValue, maximumVoltageValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private VoltageSpecificationAndroid(@NonNull Parcel in) {
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
