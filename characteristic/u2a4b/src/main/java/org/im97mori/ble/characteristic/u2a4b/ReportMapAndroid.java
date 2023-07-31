package org.im97mori.ble.characteristic.u2a4b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Report Map (Characteristics UUID: 0x2A4B)
 */
@SuppressWarnings({"WeakerAccess"})
public class ReportMapAndroid extends ReportMap implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ReportMapAndroid> CREATOR = new ByteArrayCreator<ReportMapAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReportMapAndroid createFromParcel(@NonNull Parcel in) {
            return new ReportMapAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReportMapAndroid[] newArray(int size) {
            return new ReportMapAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ReportMapAndroid createFromByteArray(@NonNull byte[] values) {
            return new ReportMapAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A4B
     */
    @Deprecated
    public ReportMapAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ReportMapAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ReportMapAndroid(@NonNull Parcel in) {
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
