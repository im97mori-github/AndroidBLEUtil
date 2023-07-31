package org.im97mori.ble.characteristic.u2a5b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * CSC Measurement (Characteristics UUID: 0x2A5B)
 */
@SuppressWarnings({"WeakerAccess"})
public class CSCMeasurementAndroid extends CSCMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CSCMeasurementAndroid> CREATOR = new ByteArrayCreator<CSCMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CSCMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new CSCMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CSCMeasurementAndroid[] newArray(int size) {
            return new CSCMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CSCMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            return new CSCMeasurementAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A5B
     */
    @Deprecated
    public CSCMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CSCMeasurementAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                      Flags
     * @param cumulativeWheelRevolutions Cumulative Wheel Revolutions
     * @param lastWheelEventTime         Last Wheel Event Time
     * @param cumulativeCrankRevolutions Cumulative Crank Revolutions
     * @param lastCrankEventTime         Last Crank Event Time
     */
    public CSCMeasurementAndroid(int flags, long cumulativeWheelRevolutions, int lastWheelEventTime, int cumulativeCrankRevolutions, int lastCrankEventTime) {
        super(flags, cumulativeWheelRevolutions, lastWheelEventTime, cumulativeCrankRevolutions, lastCrankEventTime);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CSCMeasurementAndroid(@NonNull Parcel in) {
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
