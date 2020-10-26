package org.im97mori.ble.characteristic.u2ad7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC;

/**
 * Supported Heart Rate Range (Characteristics UUID: 0x2AD7)
 */
@SuppressWarnings({"WeakerAccess"})
public class SupportedHeartRateRangeAndroid extends SupportedHeartRateRange implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SupportedHeartRateRangeAndroid> CREATOR = new ByteArrayCreater<SupportedHeartRateRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedHeartRateRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new SupportedHeartRateRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedHeartRateRangeAndroid[] newArray(int size) {
            return new SupportedHeartRateRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedHeartRateRangeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SupportedHeartRateRangeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD7
     */
    public SupportedHeartRateRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param minimumHeartRate Minimum Heart Rate
     * @param maximumHeartRate Maximum Heart Rate
     * @param minimumIncrement Minimum Increment
     */
    public SupportedHeartRateRangeAndroid(int minimumHeartRate, int maximumHeartRate, int minimumIncrement) {
        super(minimumHeartRate, maximumHeartRate, minimumIncrement);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SupportedHeartRateRangeAndroid(@NonNull Parcel in) {
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
