package org.im97mori.ble.characteristic.u2ae1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.AVERAGE_VOLTAGE_CHARACTERISTIC;

/**
 * Average Voltage (Characteristics UUID: 0x2AE1)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AverageVoltageAndroid extends AverageVoltage implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AverageVoltageAndroid> CREATOR = new ByteArrayCreater<AverageVoltageAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AverageVoltageAndroid createFromParcel(@NonNull Parcel in) {
            return new AverageVoltageAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AverageVoltageAndroid[] newArray(int size) {
            return new AverageVoltageAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AverageVoltageAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AVERAGE_VOLTAGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AverageVoltageAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE1
     */
    public AverageVoltageAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AverageVoltageAndroid(@NonNull Parcel in) {
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
