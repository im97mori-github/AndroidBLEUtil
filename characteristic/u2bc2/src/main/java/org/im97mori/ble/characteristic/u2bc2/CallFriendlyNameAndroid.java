package org.im97mori.ble.characteristic.u2bc2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Call Friendly Name (Characteristics UUID: 0x2BC2)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CallFriendlyNameAndroid extends CallFriendlyName implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CallFriendlyNameAndroid> CREATOR = new ByteArrayCreator<CallFriendlyNameAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CallFriendlyNameAndroid createFromParcel(@NonNull Parcel in) {
            return new CallFriendlyNameAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CallFriendlyNameAndroid[] newArray(int size) {
            return new CallFriendlyNameAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CallFriendlyNameAndroid createFromByteArray(@NonNull byte[] values) {
            return new CallFriendlyNameAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BC2
     */
    @Deprecated
    public CallFriendlyNameAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CallFriendlyNameAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CallFriendlyNameAndroid(@NonNull Parcel in) {
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
