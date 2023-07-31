package org.im97mori.ble.characteristic.u2a4d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Report (Characteristics UUID: 0x2A4D)
 */
@SuppressWarnings({"WeakerAccess"})
public class ReportAndroid extends Report implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ReportAndroid> CREATOR = new ByteArrayCreator<ReportAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReportAndroid createFromParcel(@NonNull Parcel in) {
            return new ReportAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReportAndroid[] newArray(int size) {
            return new ReportAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ReportAndroid createFromByteArray(@NonNull byte[] values) {
            return new ReportAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A4D
     */
    @Deprecated
    public ReportAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ReportAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ReportAndroid(@NonNull Parcel in) {
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
