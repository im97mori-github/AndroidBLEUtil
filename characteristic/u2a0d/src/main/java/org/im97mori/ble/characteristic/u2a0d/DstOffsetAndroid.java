package org.im97mori.ble.characteristic.u2a0d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * DST Offset (Characteristics UUID: 0x2A0D)
 */
@SuppressWarnings({"WeakerAccess"})
public class DstOffsetAndroid extends DstOffset implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<DstOffsetAndroid> CREATOR = new ByteArrayCreator<DstOffsetAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DstOffsetAndroid createFromParcel(@NonNull Parcel in) {
            return new DstOffsetAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DstOffsetAndroid[] newArray(int size) {
            return new DstOffsetAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DstOffsetAndroid createFromByteArray(@NonNull byte[] values) {
            return new DstOffsetAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A0D
     */
    @Deprecated
    public DstOffsetAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public DstOffsetAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param dstOffset DST Offset
     */
    public DstOffsetAndroid(int dstOffset) {
        super(dstOffset);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DstOffsetAndroid(@NonNull Parcel in) {
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
