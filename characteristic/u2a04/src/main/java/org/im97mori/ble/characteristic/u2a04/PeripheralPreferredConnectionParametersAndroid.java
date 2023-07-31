package org.im97mori.ble.characteristic.u2a04;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Peripheral Preferred Connection Parameters (Characteristics UUID: 0x2A04)
 */
@SuppressWarnings({"WeakerAccess"})
public class PeripheralPreferredConnectionParametersAndroid extends PeripheralPreferredConnectionParameters implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PeripheralPreferredConnectionParametersAndroid> CREATOR = new ByteArrayCreator<PeripheralPreferredConnectionParametersAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PeripheralPreferredConnectionParametersAndroid createFromParcel(@NonNull Parcel in) {
            return new PeripheralPreferredConnectionParametersAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PeripheralPreferredConnectionParametersAndroid[] newArray(int size) {
            return new PeripheralPreferredConnectionParametersAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PeripheralPreferredConnectionParametersAndroid createFromByteArray(@NonNull byte[] values) {
            return new PeripheralPreferredConnectionParametersAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A04
     */
    @Deprecated
    public PeripheralPreferredConnectionParametersAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public PeripheralPreferredConnectionParametersAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param minimumConnectionInterval              Minimum Connection Interval
     * @param maximumConnectionInterval              Maximum Connection Interval
     * @param slaveLatency                           Slave Latency
     * @param connectionSupervisionTimeoutMultiplier Connection Supervision Timeout Multiplier
     */
    public PeripheralPreferredConnectionParametersAndroid(int minimumConnectionInterval, int maximumConnectionInterval, int slaveLatency, int connectionSupervisionTimeoutMultiplier) {
        super(minimumConnectionInterval, maximumConnectionInterval, slaveLatency, connectionSupervisionTimeoutMultiplier);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PeripheralPreferredConnectionParametersAndroid(@NonNull Parcel in) {
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
