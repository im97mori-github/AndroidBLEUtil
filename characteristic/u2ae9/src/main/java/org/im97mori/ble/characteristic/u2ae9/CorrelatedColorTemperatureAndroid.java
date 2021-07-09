package org.im97mori.ble.characteristic.u2ae9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.CORRELATED_COLOR_TEMPERATURE_CHARACTERISTIC;

/**
 * Correlated Color Temperature (Characteristics UUID: 0x2AE9)
 */
@SuppressWarnings({"WeakerAccess"})
public class CorrelatedColorTemperatureAndroid extends CorrelatedColorTemperature implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CorrelatedColorTemperatureAndroid> CREATOR = new ByteArrayCreater<CorrelatedColorTemperatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CorrelatedColorTemperatureAndroid createFromParcel(@NonNull Parcel in) {
            return new CorrelatedColorTemperatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CorrelatedColorTemperatureAndroid[] newArray(int size) {
            return new CorrelatedColorTemperatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CorrelatedColorTemperatureAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CORRELATED_COLOR_TEMPERATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CorrelatedColorTemperatureAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE9
     */
    public CorrelatedColorTemperatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param correlatedColorTemperature Correlated Color Temperature
     */
    public CorrelatedColorTemperatureAndroid(int correlatedColorTemperature) {
        super(correlatedColorTemperature);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CorrelatedColorTemperatureAndroid(@NonNull Parcel in) {
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
