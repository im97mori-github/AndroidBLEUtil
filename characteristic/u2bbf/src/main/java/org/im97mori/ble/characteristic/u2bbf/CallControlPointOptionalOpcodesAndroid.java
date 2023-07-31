package org.im97mori.ble.characteristic.u2bbf;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Call Control Point Optional Opcodes (Characteristics UUID: 0x2BBF)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CallControlPointOptionalOpcodesAndroid extends CallControlPointOptionalOpcodes implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CallControlPointOptionalOpcodesAndroid> CREATOR = new ByteArrayCreator<CallControlPointOptionalOpcodesAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CallControlPointOptionalOpcodesAndroid createFromParcel(@NonNull Parcel in) {
            return new CallControlPointOptionalOpcodesAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CallControlPointOptionalOpcodesAndroid[] newArray(int size) {
            return new CallControlPointOptionalOpcodesAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CallControlPointOptionalOpcodesAndroid createFromByteArray(@NonNull byte[] values) {
            return new CallControlPointOptionalOpcodesAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BBF
     */
    @Deprecated
    public CallControlPointOptionalOpcodesAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CallControlPointOptionalOpcodesAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CallControlPointOptionalOpcodesAndroid(@NonNull Parcel in) {
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
