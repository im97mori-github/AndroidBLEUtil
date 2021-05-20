package org.im97mori.ble.characteristic.u2ad6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC;

/**
 * Supported Resistance Level Range (Characteristics UUID: 0x2AD6)
 */
@SuppressWarnings({"WeakerAccess"})
public class SupportedResistanceLevelRangeAndroid extends SupportedResistanceLevelRange implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SupportedResistanceLevelRangeAndroid> CREATOR = new ByteArrayCreater<SupportedResistanceLevelRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedResistanceLevelRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new SupportedResistanceLevelRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedResistanceLevelRangeAndroid[] newArray(int size) {
            return new SupportedResistanceLevelRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedResistanceLevelRangeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SupportedResistanceLevelRangeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD6
     */
    public SupportedResistanceLevelRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param minimumResistanceLevel Minimum Inclination
     * @param maximumResistanceLevel Maximum Resistance Level
     * @param minimumIncrement       Minimum Increment
     */
    public SupportedResistanceLevelRangeAndroid(int minimumResistanceLevel, int maximumResistanceLevel, int minimumIncrement) {
        super(minimumResistanceLevel, maximumResistanceLevel, minimumIncrement);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SupportedResistanceLevelRangeAndroid(@NonNull Parcel in) {
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
