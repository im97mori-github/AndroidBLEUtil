package org.im97mori.ble.characteristic.u2a36;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC;

/**
 * Intermediate Cuff Pressure (Characteristics UUID: 0x2A36)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class IntermediateCuffPressureAndroid extends IntermediateCuffPressure implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IntermediateCuffPressureAndroid> CREATOR = new ByteArrayCreater<IntermediateCuffPressureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IntermediateCuffPressureAndroid createFromParcel(@NonNull Parcel in) {
            return new IntermediateCuffPressureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IntermediateCuffPressureAndroid[] newArray(int size) {
            return new IntermediateCuffPressureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IntermediateCuffPressureAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IntermediateCuffPressureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A36
     */
    public IntermediateCuffPressureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private IntermediateCuffPressureAndroid(@NonNull Parcel in) {
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
