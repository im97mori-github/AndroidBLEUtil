package org.im97mori.ble.characteristic.u2b0c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Relative Value In A Temperature Range (Characteristics UUID: 0x2B0C)
 */
@SuppressWarnings({"WeakerAccess"})
public class RelativeValueInATemperatureRangeAndroid extends RelativeValueInATemperatureRange implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RelativeValueInATemperatureRangeAndroid> CREATOR = new ByteArrayCreator<RelativeValueInATemperatureRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeValueInATemperatureRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new RelativeValueInATemperatureRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RelativeValueInATemperatureRangeAndroid[] newArray(int size) {
            return new RelativeValueInATemperatureRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RelativeValueInATemperatureRangeAndroid createFromByteArray(@NonNull byte[] values) {
            return new RelativeValueInATemperatureRangeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B0C
     */
    @Deprecated
    public RelativeValueInATemperatureRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public RelativeValueInATemperatureRangeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param relativeValue           Relative Value
     * @param minimumTemperatureValue Minimum Temperature Value
     * @param maximumTemperatureValue Maximum Temperature Value
     */
    public RelativeValueInATemperatureRangeAndroid(int relativeValue, int minimumTemperatureValue, int maximumTemperatureValue) {
        super(relativeValue, minimumTemperatureValue, maximumTemperatureValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RelativeValueInATemperatureRangeAndroid(@NonNull Parcel in) {
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
