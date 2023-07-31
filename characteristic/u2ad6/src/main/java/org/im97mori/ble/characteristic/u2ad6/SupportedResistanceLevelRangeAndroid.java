package org.im97mori.ble.characteristic.u2ad6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;
import org.im97mori.ble.ByteArrayInterface;

import java.util.Objects;

/**
 * Supported Resistance Level Range (Characteristics UUID: 0x2AD6)
 */
@SuppressWarnings({"WeakerAccess"})
public class SupportedResistanceLevelRangeAndroid extends SupportedResistanceLevelRange implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SupportedResistanceLevelRangeAndroid> CREATOR = new ByteArrayCreator<SupportedResistanceLevelRangeAndroid>() {

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
            return new SupportedResistanceLevelRangeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AD6
     */
    @Deprecated
    public SupportedResistanceLevelRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SupportedResistanceLevelRangeAndroid(@NonNull byte[] values) {
        super(values);
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
        super(Objects.requireNonNull(in.createByteArray()));
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
