package org.im97mori.ble.characteristic.u2a33;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Boot Mouse Input Report (Characteristics UUID: 0x2A33)
 */
@SuppressWarnings({"WeakerAccess"})
public class BootMouseInputReportAndroid extends BootMouseInputReport implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BootMouseInputReportAndroid> CREATOR = new ByteArrayCreator<BootMouseInputReportAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BootMouseInputReportAndroid createFromParcel(@NonNull Parcel in) {
            return new BootMouseInputReportAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BootMouseInputReportAndroid[] newArray(int size) {
            return new BootMouseInputReportAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BootMouseInputReportAndroid createFromByteArray(@NonNull byte[] values) {
            return new BootMouseInputReportAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A33
     */
    @Deprecated
    public BootMouseInputReportAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BootMouseInputReportAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BootMouseInputReportAndroid(@NonNull Parcel in) {
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
