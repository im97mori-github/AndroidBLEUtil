package org.im97mori.ble.characteristic.u2a31;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Scan Refresh (Characteristics UUID: 0x2A31)
 */
@SuppressWarnings({"WeakerAccess"})
public class ScanRefreshAndroid extends ScanRefresh implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<ScanRefreshAndroid> CREATOR = new ByteArrayCreator<ScanRefreshAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ScanRefreshAndroid createFromParcel(@NonNull Parcel in) {
            return new ScanRefreshAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ScanRefreshAndroid[] newArray(int size) {
            return new ScanRefreshAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ScanRefreshAndroid createFromByteArray(@NonNull byte[] values) {
            return new ScanRefreshAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A31
     */
    @Deprecated
    public ScanRefreshAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public ScanRefreshAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param scanRefreshValue Scan Refresh Value
     */
    public ScanRefreshAndroid(int scanRefreshValue) {
        super(scanRefreshValue);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ScanRefreshAndroid(@NonNull Parcel in) {
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
