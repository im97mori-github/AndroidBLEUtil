package org.im97mori.ble.characteristic.u2b38;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * BR-EDR Handover Data (Characteristics UUID: 0x2B38)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class BrEdrHandoverDataAndroid extends BrEdrHandoverData implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<BrEdrHandoverDataAndroid> CREATOR = new ByteArrayCreator<BrEdrHandoverDataAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BrEdrHandoverDataAndroid createFromParcel(@NonNull Parcel in) {
            return new BrEdrHandoverDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BrEdrHandoverDataAndroid[] newArray(int size) {
            return new BrEdrHandoverDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public BrEdrHandoverDataAndroid createFromByteArray(@NonNull byte[] values) {
            return new BrEdrHandoverDataAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B38
     */
    @Deprecated
    public BrEdrHandoverDataAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public BrEdrHandoverDataAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private BrEdrHandoverDataAndroid(@NonNull Parcel in) {
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
