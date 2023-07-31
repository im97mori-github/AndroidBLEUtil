package org.im97mori.ble.characteristic.u2bb8;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Bearer Signal Strength Reporting Interval (Characteristics UUID: 0x2BB8)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BearerSignalStrengthReportingIntervalAndroid extends BearerSignalStrengthReportingInterval implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BearerSignalStrengthReportingIntervalAndroid> CREATOR = new ByteArrayCreator<BearerSignalStrengthReportingIntervalAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerSignalStrengthReportingIntervalAndroid createFromParcel(@NonNull Parcel in) {
            return new BearerSignalStrengthReportingIntervalAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerSignalStrengthReportingIntervalAndroid[] newArray(int size) {
            return new BearerSignalStrengthReportingIntervalAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BearerSignalStrengthReportingIntervalAndroid createFromByteArray(@NonNull byte[] values) {
            return new BearerSignalStrengthReportingIntervalAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BB8
     */
    @Deprecated
    public BearerSignalStrengthReportingIntervalAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BearerSignalStrengthReportingIntervalAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BearerSignalStrengthReportingIntervalAndroid(@NonNull Parcel in) {
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
