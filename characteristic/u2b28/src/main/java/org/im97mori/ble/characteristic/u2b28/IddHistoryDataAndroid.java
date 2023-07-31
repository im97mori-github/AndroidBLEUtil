package org.im97mori.ble.characteristic.u2b28;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * IDD History Data (Characteristics UUID: 0x2B28)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class IddHistoryDataAndroid extends IddHistoryData implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<IddHistoryDataAndroid> CREATOR = new ByteArrayCreator<IddHistoryDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddHistoryDataAndroid createFromParcel(@NonNull Parcel in) {
            return new IddHistoryDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IddHistoryDataAndroid[] newArray(int size) {
            return new IddHistoryDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public IddHistoryDataAndroid createFromByteArray(@NonNull byte[] values) {
            return new IddHistoryDataAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B28
     */
    @Deprecated
    public IddHistoryDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public IddHistoryDataAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private IddHistoryDataAndroid(@NonNull Parcel in) {
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
