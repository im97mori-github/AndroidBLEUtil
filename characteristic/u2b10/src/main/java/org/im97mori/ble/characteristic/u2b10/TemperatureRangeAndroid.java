package org.im97mori.ble.characteristic.u2b10;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Temperature Range (Characteristics UUID: 0x2B10)
 */
@SuppressWarnings({"WeakerAccess"})
public class TemperatureRangeAndroid extends TemperatureRange implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TemperatureRangeAndroid> CREATOR = new ByteArrayCreator<TemperatureRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TemperatureRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new TemperatureRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TemperatureRangeAndroid[] newArray(int size) {
            return new TemperatureRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TemperatureRangeAndroid createFromByteArray(@NonNull byte[] values) {
            return new TemperatureRangeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B10
     */
    @Deprecated
    public TemperatureRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TemperatureRangeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param minimumTemperature Minimum Temperature
     * @param maximumTemperature Maximum Temperature
     */
    public TemperatureRangeAndroid(int minimumTemperature, int maximumTemperature) {
        super(minimumTemperature, maximumTemperature);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TemperatureRangeAndroid(@NonNull Parcel in) {
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
