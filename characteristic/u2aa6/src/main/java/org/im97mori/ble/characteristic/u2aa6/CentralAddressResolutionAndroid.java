package org.im97mori.ble.characteristic.u2aa6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Central Address Resolution (Characteristics UUID: 0x2AA6)
 */
@SuppressWarnings({"WeakerAccess"})
public class CentralAddressResolutionAndroid extends CentralAddressResolution implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CentralAddressResolutionAndroid> CREATOR = new ByteArrayCreator<CentralAddressResolutionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CentralAddressResolutionAndroid createFromParcel(@NonNull Parcel in) {
            return new CentralAddressResolutionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CentralAddressResolutionAndroid[] newArray(int size) {
            return new CentralAddressResolutionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CentralAddressResolutionAndroid createFromByteArray(@NonNull byte[] values) {
            return new CentralAddressResolutionAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA6
     */
    @Deprecated
    public CentralAddressResolutionAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CentralAddressResolutionAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param centralAddressResolutionSupport Central Address Resolution Support
     */
    public CentralAddressResolutionAndroid(int centralAddressResolutionSupport) {
        super(centralAddressResolutionSupport);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CentralAddressResolutionAndroid(@NonNull Parcel in) {
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
