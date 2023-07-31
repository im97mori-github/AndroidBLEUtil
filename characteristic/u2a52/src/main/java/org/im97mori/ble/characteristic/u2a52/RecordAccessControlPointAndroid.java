package org.im97mori.ble.characteristic.u2a52;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Record Access Control Point (Characteristics UUID: 0x2A52)
 */
@SuppressWarnings({"WeakerAccess"})
public class RecordAccessControlPointAndroid extends RecordAccessControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<RecordAccessControlPointAndroid> CREATOR = new ByteArrayCreator<RecordAccessControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RecordAccessControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new RecordAccessControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RecordAccessControlPointAndroid[] newArray(int size) {
            return new RecordAccessControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RecordAccessControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new RecordAccessControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A52
     */
    @Deprecated
    public RecordAccessControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public RecordAccessControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param opCode   Op Code
     * @param operator Operator
     * @param operand  Operand
     */
    public RecordAccessControlPointAndroid(int opCode, int operator, @NonNull byte[] operand) {
        super(opCode, operator, operand);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RecordAccessControlPointAndroid(@NonNull Parcel in) {
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
