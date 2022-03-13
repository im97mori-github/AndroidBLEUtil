package org.im97mori.ble.characteristic.u2af0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.ELECTRIC_CURRENT_SPECIFICATION_CHARACTERISTIC;

/**
 * Electric Current Specification (Characteristics UUID: 0x2AF0)
 */
@SuppressWarnings({"WeakerAccess"})
public class ElectricCurrentSpecificationAndroid extends ElectricCurrentSpecification implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ElectricCurrentSpecificationAndroid> CREATOR = new ByteArrayCreator<ElectricCurrentSpecificationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ElectricCurrentSpecificationAndroid createFromParcel(@NonNull Parcel in) {
            return new ElectricCurrentSpecificationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ElectricCurrentSpecificationAndroid[] newArray(int size) {
            return new ElectricCurrentSpecificationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ElectricCurrentSpecificationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ELECTRIC_CURRENT_SPECIFICATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ElectricCurrentSpecificationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AF0
     */
    public ElectricCurrentSpecificationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param minimumElectricCurrentValue Minimum Electric Current Value
     * @param typicalElectricCurrentValue Typical Electric Current Value
     * @param maximumElectricCurrentValue Maximum Electric Current Value
     */
    public ElectricCurrentSpecificationAndroid(int minimumElectricCurrentValue, int typicalElectricCurrentValue, int maximumElectricCurrentValue) {
        super(minimumElectricCurrentValue, typicalElectricCurrentValue, maximumElectricCurrentValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ElectricCurrentSpecificationAndroid(@NonNull Parcel in) {
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
