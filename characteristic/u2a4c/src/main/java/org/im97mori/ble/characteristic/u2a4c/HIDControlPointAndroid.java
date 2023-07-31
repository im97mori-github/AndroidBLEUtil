package org.im97mori.ble.characteristic.u2a4c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * HID Control Point (Characteristics UUID: 0x2A4C)
 */
@SuppressWarnings({"WeakerAccess"})
public class HIDControlPointAndroid extends HIDControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HIDControlPointAndroid> CREATOR = new ByteArrayCreator<HIDControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HIDControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new HIDControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HIDControlPointAndroid[] newArray(int size) {
            return new HIDControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HIDControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new HIDControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A4C
     */
    @Deprecated
    public HIDControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public HIDControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param hidControlPointCommand HID Control Point Command
     */
    public HIDControlPointAndroid(int hidControlPointCommand) {
        super(hidControlPointCommand);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HIDControlPointAndroid(@NonNull Parcel in) {
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
