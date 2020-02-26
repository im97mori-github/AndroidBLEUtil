package org.im97mori.ble.characteristic.u2a1e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.INTERMEDIATE_TEMPERATURE_CHARACTERISTIC;


/**
 * Intermediate Temperature (Characteristics UUID: 0x2A1E)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class IntermediateTemperatureAndroid extends IntermediateTemperature implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<IntermediateTemperatureAndroid> CREATOR = new ByteArrayCreater<IntermediateTemperatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IntermediateTemperatureAndroid createFromParcel(@NonNull Parcel in) {
            return new IntermediateTemperatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IntermediateTemperatureAndroid[] newArray(int size) {
            return new IntermediateTemperatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IntermediateTemperatureAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INTERMEDIATE_TEMPERATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new IntermediateTemperatureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A1E
     */
    public IntermediateTemperatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private IntermediateTemperatureAndroid(@NonNull Parcel in) {
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
