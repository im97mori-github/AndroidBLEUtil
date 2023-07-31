package org.im97mori.ble.characteristic.u2a22;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Boot Keyboard Input Report (Characteristics UUID: 0x2A22)
 */
@SuppressWarnings({"WeakerAccess"})
public class BootKeyboardInputReportAndroid extends BootKeyboardInputReport implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BootKeyboardInputReportAndroid> CREATOR = new ByteArrayCreator<BootKeyboardInputReportAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BootKeyboardInputReportAndroid createFromParcel(@NonNull Parcel in) {
            return new BootKeyboardInputReportAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BootKeyboardInputReportAndroid[] newArray(int size) {
            return new BootKeyboardInputReportAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BootKeyboardInputReportAndroid createFromByteArray(@NonNull byte[] values) {
            return new BootKeyboardInputReportAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A22
     */
    @Deprecated
    public BootKeyboardInputReportAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BootKeyboardInputReportAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BootKeyboardInputReportAndroid(@NonNull Parcel in) {
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
