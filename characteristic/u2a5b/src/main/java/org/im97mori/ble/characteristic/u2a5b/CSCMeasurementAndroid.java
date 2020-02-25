package org.im97mori.ble.characteristic.u2a5b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CSC_MEASUREMENT_CHARACTERISTIC;

/**
 * CSC Measurement (Characteristics UUID: 0x2A5B)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CSCMeasurementAndroid extends CSCMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<CSCMeasurementAndroid> CREATOR = new ByteArrayCreater<CSCMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CSCMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new CSCMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CSCMeasurementAndroid[] newArray(int size) {
            return new CSCMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CSCMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CSC_MEASUREMENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A5B
     */
    public CSCMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private CSCMeasurementAndroid(@NonNull Parcel in) {
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
