package org.im97mori.ble.characteristic.u2bc0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Termination Reason (Characteristics UUID: 0x2BC0)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TerminationReasonAndroid extends TerminationReason implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TerminationReasonAndroid> CREATOR = new ByteArrayCreator<TerminationReasonAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TerminationReasonAndroid createFromParcel(@NonNull Parcel in) {
            return new TerminationReasonAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TerminationReasonAndroid[] newArray(int size) {
            return new TerminationReasonAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TerminationReasonAndroid createFromByteArray(@NonNull byte[] values) {
            return new TerminationReasonAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BC0
     */
    @Deprecated
    public TerminationReasonAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TerminationReasonAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TerminationReasonAndroid(@NonNull Parcel in) {
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
