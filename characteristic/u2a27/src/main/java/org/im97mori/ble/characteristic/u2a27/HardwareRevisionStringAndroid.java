package org.im97mori.ble.characteristic.u2a27;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Hardware Revision String (Characteristics UUID: 0x2A27)
 */
@SuppressWarnings({"WeakerAccess"})
public class HardwareRevisionStringAndroid extends HardwareRevisionString implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<HardwareRevisionStringAndroid> CREATOR = new ByteArrayCreator<HardwareRevisionStringAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HardwareRevisionStringAndroid createFromParcel(@NonNull Parcel in) {
            return new HardwareRevisionStringAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HardwareRevisionStringAndroid[] newArray(int size) {
            return new HardwareRevisionStringAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HardwareRevisionStringAndroid createFromByteArray(@NonNull byte[] values) {
            return new HardwareRevisionStringAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A27
     */
    @Deprecated
    public HardwareRevisionStringAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public HardwareRevisionStringAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param hardwareRevision Hardware Revision
     */
    public HardwareRevisionStringAndroid(@NonNull String hardwareRevision) {
        super(hardwareRevision);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HardwareRevisionStringAndroid(@NonNull Parcel in) {
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
