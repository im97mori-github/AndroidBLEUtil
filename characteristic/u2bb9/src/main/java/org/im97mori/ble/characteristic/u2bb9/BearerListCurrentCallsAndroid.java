package org.im97mori.ble.characteristic.u2bb9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Bearer List Current Calls (Characteristics UUID: 0x2BB9)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BearerListCurrentCallsAndroid extends BearerListCurrentCalls implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BearerListCurrentCallsAndroid> CREATOR = new ByteArrayCreator<BearerListCurrentCallsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerListCurrentCallsAndroid createFromParcel(@NonNull Parcel in) {
            return new BearerListCurrentCallsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BearerListCurrentCallsAndroid[] newArray(int size) {
            return new BearerListCurrentCallsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BearerListCurrentCallsAndroid createFromByteArray(@NonNull byte[] values) {
            return new BearerListCurrentCallsAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BB9
     */
    @Deprecated
    public BearerListCurrentCallsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BearerListCurrentCallsAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BearerListCurrentCallsAndroid(@NonNull Parcel in) {
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
