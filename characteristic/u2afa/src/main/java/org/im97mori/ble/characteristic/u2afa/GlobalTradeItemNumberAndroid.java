package org.im97mori.ble.characteristic.u2afa;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Global Trade Item Number (Characteristics UUID: 0x2AFA)
 */
@SuppressWarnings({"WeakerAccess"})
public class GlobalTradeItemNumberAndroid extends GlobalTradeItemNumber implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<GlobalTradeItemNumberAndroid> CREATOR = new ByteArrayCreator<GlobalTradeItemNumberAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GlobalTradeItemNumberAndroid createFromParcel(@NonNull Parcel in) {
            return new GlobalTradeItemNumberAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GlobalTradeItemNumberAndroid[] newArray(int size) {
            return new GlobalTradeItemNumberAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public GlobalTradeItemNumberAndroid createFromByteArray(@NonNull byte[] values) {
            return new GlobalTradeItemNumberAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AFA
     */
    @Deprecated
    public GlobalTradeItemNumberAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public GlobalTradeItemNumberAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param globalTradeItemNumber Global Trade Item Number
     */
    public GlobalTradeItemNumberAndroid(long globalTradeItemNumber) {
        super(globalTradeItemNumber);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private GlobalTradeItemNumberAndroid(@NonNull Parcel in) {
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
