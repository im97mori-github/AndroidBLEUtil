package org.im97mori.ble.characteristic.u2a26;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Firmware Revision String (Characteristics UUID: 0x2A26)
 */
@SuppressWarnings({"WeakerAccess"})
public class FirmwareRevisionStringAndroid extends FirmwareRevisionString implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<FirmwareRevisionStringAndroid> CREATOR = new ByteArrayCreator<FirmwareRevisionStringAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FirmwareRevisionStringAndroid createFromParcel(@NonNull Parcel in) {
            return new FirmwareRevisionStringAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FirmwareRevisionStringAndroid[] newArray(int size) {
            return new FirmwareRevisionStringAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FirmwareRevisionStringAndroid createFromByteArray(@NonNull byte[] values) {
            return new FirmwareRevisionStringAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A26
     */
    @Deprecated
    public FirmwareRevisionStringAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public FirmwareRevisionStringAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param firmwareRevision Firmware Revision
     */
    public FirmwareRevisionStringAndroid(@NonNull String firmwareRevision) {
        super(firmwareRevision);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FirmwareRevisionStringAndroid(@NonNull Parcel in) {
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
