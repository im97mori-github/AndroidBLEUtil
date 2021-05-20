package org.im97mori.ble.characteristic.u2ad8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_POWER_RANGE_CHARACTERISTIC;

/**
 * Supported Power Range (Characteristics UUID: 0x2AD8)
 */
@SuppressWarnings({"WeakerAccess"})
public class SupportedPowerRangeAndroid extends SupportedPowerRange implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SupportedPowerRangeAndroid> CREATOR = new ByteArrayCreater<SupportedPowerRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedPowerRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new SupportedPowerRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedPowerRangeAndroid[] newArray(int size) {
            return new SupportedPowerRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedPowerRangeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_POWER_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SupportedPowerRangeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD8
     */
    public SupportedPowerRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param minimumPower     Minimum Power
     * @param maximumPower     Maximum Power
     * @param minimumIncrement Minimum Increment
     */
    public SupportedPowerRangeAndroid(int minimumPower, int maximumPower, int minimumIncrement) {
        super(minimumPower, maximumPower, minimumIncrement);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SupportedPowerRangeAndroid(@NonNull Parcel in) {
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
