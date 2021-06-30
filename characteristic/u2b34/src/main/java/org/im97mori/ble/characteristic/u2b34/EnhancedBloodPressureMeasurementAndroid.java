package org.im97mori.ble.characteristic.u2b34;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.ENHANCED_BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC;

/**
 * Enhanced Blood Pressure Measurement (Characteristics UUID: 0x2B34)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class EnhancedBloodPressureMeasurementAndroid extends EnhancedBloodPressureMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<EnhancedBloodPressureMeasurementAndroid> CREATOR = new ByteArrayCreater<EnhancedBloodPressureMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EnhancedBloodPressureMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new EnhancedBloodPressureMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EnhancedBloodPressureMeasurementAndroid[] newArray(int size) {
            return new EnhancedBloodPressureMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public EnhancedBloodPressureMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ENHANCED_BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B34
     */
    public EnhancedBloodPressureMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private EnhancedBloodPressureMeasurementAndroid(@NonNull Parcel in) {
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
