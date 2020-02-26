package org.im97mori.ble.characteristic.u2a37;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HEART_RATE_MEASUREMENT_CHARACTERISTIC;

/**
 * Heart Rate Measurement (Characteristics UUID: 0x2A37)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class HeartRateMeasurementAndroid extends HeartRateMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HeartRateMeasurementAndroid> CREATOR = new ByteArrayCreater<HeartRateMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeartRateMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new HeartRateMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeartRateMeasurementAndroid[] newArray(int size) {
            return new HeartRateMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HeartRateMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HEART_RATE_MEASUREMENT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A37
     */
    public HeartRateMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private HeartRateMeasurementAndroid(@NonNull Parcel in) {
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
