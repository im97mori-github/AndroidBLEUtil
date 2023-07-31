package org.im97mori.ble.characteristic.u2a28;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Software Revision String (Characteristics UUID: 0x2A28)
 */
@SuppressWarnings({"WeakerAccess"})
public class SoftwareRevisionStringAndroid extends SoftwareRevisionString implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SoftwareRevisionStringAndroid> CREATOR = new ByteArrayCreator<SoftwareRevisionStringAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SoftwareRevisionStringAndroid createFromParcel(@NonNull Parcel in) {
            return new SoftwareRevisionStringAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SoftwareRevisionStringAndroid[] newArray(int size) {
            return new SoftwareRevisionStringAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SoftwareRevisionStringAndroid createFromByteArray(@NonNull byte[] values) {
            return new SoftwareRevisionStringAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A28
     */
    @Deprecated
    public SoftwareRevisionStringAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SoftwareRevisionStringAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param softwareRevision Software Revision
     */
    public SoftwareRevisionStringAndroid(@NonNull String softwareRevision) {
        super(softwareRevision);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SoftwareRevisionStringAndroid(@NonNull Parcel in) {
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
