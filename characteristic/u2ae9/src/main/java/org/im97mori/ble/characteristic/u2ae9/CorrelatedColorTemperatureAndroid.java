package org.im97mori.ble.characteristic.u2ae9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Correlated Color Temperature (Characteristics UUID: 0x2AE9)
 */
@SuppressWarnings({"WeakerAccess"})
public class CorrelatedColorTemperatureAndroid extends CorrelatedColorTemperature implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CorrelatedColorTemperatureAndroid> CREATOR = new ByteArrayCreator<CorrelatedColorTemperatureAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CorrelatedColorTemperatureAndroid createFromParcel(@NonNull Parcel in) {
            return new CorrelatedColorTemperatureAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CorrelatedColorTemperatureAndroid[] newArray(int size) {
            return new CorrelatedColorTemperatureAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CorrelatedColorTemperatureAndroid createFromByteArray(@NonNull byte[] values) {
            return new CorrelatedColorTemperatureAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AE9
     */
    @Deprecated
    public CorrelatedColorTemperatureAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CorrelatedColorTemperatureAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param correlatedColorTemperature Correlated Color Temperature
     */
    public CorrelatedColorTemperatureAndroid(int correlatedColorTemperature) {
        super(correlatedColorTemperature);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CorrelatedColorTemperatureAndroid(@NonNull Parcel in) {
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
