package org.im97mori.ble.characteristic.u2a21;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MEASUREMENT_INTERVAL_CHARACTERISTIC;

/**
 * Measurement Interval (Characteristics UUID: 0x2A21)
 */
@SuppressWarnings({"WeakerAccess"})
public class MeasurementIntervalAndroid extends MeasurementInterval implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<MeasurementIntervalAndroid> CREATOR = new ByteArrayCreater<MeasurementIntervalAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MeasurementIntervalAndroid createFromParcel(@NonNull Parcel in) {
            return new MeasurementIntervalAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MeasurementIntervalAndroid[] newArray(int size) {
            return new MeasurementIntervalAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MeasurementIntervalAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MEASUREMENT_INTERVAL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MeasurementIntervalAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A21
     */
    public MeasurementIntervalAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param measurementInterval Measurement Interval
     */
    public MeasurementIntervalAndroid(int measurementInterval) {
        super(measurementInterval);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private MeasurementIntervalAndroid(@NonNull Parcel in) {
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
