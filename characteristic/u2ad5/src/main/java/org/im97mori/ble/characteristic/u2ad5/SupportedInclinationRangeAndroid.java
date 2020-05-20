package org.im97mori.ble.characteristic.u2ad5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC;

/**
 * Supported Inclination Range (Characteristics UUID: 0x2AD5)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SupportedInclinationRangeAndroid extends SupportedInclinationRange implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SupportedInclinationRangeAndroid> CREATOR = new ByteArrayCreater<SupportedInclinationRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedInclinationRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new SupportedInclinationRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedInclinationRangeAndroid[] newArray(int size) {
            return new SupportedInclinationRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedInclinationRangeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SupportedInclinationRangeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD5
     */
    public SupportedInclinationRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param minimumInclination Minimum Inclination
     * @param maximumInclination Maximum Inclination
     * @param minimumIncrement   Minimum Increment
     */
    public SupportedInclinationRangeAndroid(int minimumInclination, int maximumInclination, int minimumIncrement) {
        super(minimumInclination, maximumInclination, minimumIncrement);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private SupportedInclinationRangeAndroid(@NonNull Parcel in) {
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
