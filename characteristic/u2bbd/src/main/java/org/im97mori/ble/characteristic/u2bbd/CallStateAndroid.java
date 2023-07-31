package org.im97mori.ble.characteristic.u2bbd;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Call State (Characteristics UUID: 0x2BBD)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CallStateAndroid extends CallState implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CallStateAndroid> CREATOR = new ByteArrayCreator<CallStateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CallStateAndroid createFromParcel(@NonNull Parcel in) {
            return new CallStateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CallStateAndroid[] newArray(int size) {
            return new CallStateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CallStateAndroid createFromByteArray(@NonNull byte[] values) {
            return new CallStateAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BBD
     */
    @Deprecated
    public CallStateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CallStateAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CallStateAndroid(@NonNull Parcel in) {
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
