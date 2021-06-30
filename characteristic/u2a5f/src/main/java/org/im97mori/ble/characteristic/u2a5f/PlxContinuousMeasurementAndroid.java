package org.im97mori.ble.characteristic.u2a5f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.PLX_CONTINUOUS_MEASUREMENT_CHARACTERISTIC;

/**
 * PLX Continuous Measurement (Characteristics UUID: 0x2A5F)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class PlxContinuousMeasurementAndroid extends PlxContinuousMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<PlxContinuousMeasurementAndroid> CREATOR = new ByteArrayCreater<PlxContinuousMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PlxContinuousMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new PlxContinuousMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PlxContinuousMeasurementAndroid[] newArray(int size) {
            return new PlxContinuousMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PlxContinuousMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PLX_CONTINUOUS_MEASUREMENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PlxContinuousMeasurementAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A5F
     */
    public PlxContinuousMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PlxContinuousMeasurementAndroid(@NonNull Parcel in) {
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
