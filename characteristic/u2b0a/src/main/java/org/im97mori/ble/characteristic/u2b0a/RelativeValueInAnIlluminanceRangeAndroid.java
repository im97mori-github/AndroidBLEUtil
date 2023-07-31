package org.im97mori.ble.characteristic.u2b0a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Relative Value In An Illuminance Range (Characteristics UUID: 0x2B0A)
 */
@SuppressWarnings({"WeakerAccess"})
public class RelativeValueInAnIlluminanceRangeAndroid extends RelativeValueInAnIlluminanceRange implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RelativeValueInAnIlluminanceRangeAndroid> CREATOR = new ByteArrayCreator<RelativeValueInAnIlluminanceRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeValueInAnIlluminanceRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new RelativeValueInAnIlluminanceRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeValueInAnIlluminanceRangeAndroid[] newArray(int size) {
            return new RelativeValueInAnIlluminanceRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RelativeValueInAnIlluminanceRangeAndroid createFromByteArray(@NonNull byte[] values) {
            return new RelativeValueInAnIlluminanceRangeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B0A
     */
    @Deprecated
    public RelativeValueInAnIlluminanceRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public RelativeValueInAnIlluminanceRangeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param relativeValue  Relative Value
     * @param minimumVoltage Minimum Voltage
     * @param maximumVoltage Maximum Voltage
     */
    public RelativeValueInAnIlluminanceRangeAndroid(int relativeValue, int minimumVoltage, int maximumVoltage) {
        super(relativeValue, minimumVoltage, maximumVoltage);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RelativeValueInAnIlluminanceRangeAndroid(@NonNull Parcel in) {
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
