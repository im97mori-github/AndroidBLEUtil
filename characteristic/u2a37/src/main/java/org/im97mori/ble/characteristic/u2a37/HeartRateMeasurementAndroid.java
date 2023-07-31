package org.im97mori.ble.characteristic.u2a37;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Heart Rate Measurement (Characteristics UUID: 0x2A37)
 */
@SuppressWarnings({"WeakerAccess"})
public class HeartRateMeasurementAndroid extends HeartRateMeasurement implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HeartRateMeasurementAndroid> CREATOR = new ByteArrayCreator<HeartRateMeasurementAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeartRateMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new HeartRateMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeartRateMeasurementAndroid[] newArray(int size) {
            return new HeartRateMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HeartRateMeasurementAndroid createFromByteArray(@NonNull byte[] values) {
            return new HeartRateMeasurementAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A37
     */
    @Deprecated
    public HeartRateMeasurementAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public HeartRateMeasurementAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param flags                           Flags
     * @param heartRateMeasurementValueUint8  Heart Rate Measurement Value (uint8)
     * @param heartRateMeasurementValueUint16 Heart Rate Measurement Value (uint16)
     * @param energyExpended                  Energy Expended
     * @param rrInterval                      RR-Interval
     */
    public HeartRateMeasurementAndroid(int flags, int heartRateMeasurementValueUint8, int heartRateMeasurementValueUint16, int energyExpended, @NonNull int[] rrInterval) {
        super(flags, heartRateMeasurementValueUint8, heartRateMeasurementValueUint16, energyExpended, rrInterval);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HeartRateMeasurementAndroid(@NonNull Parcel in) {
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
