package org.im97mori.ble.characteristic.u2a50;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * PnP ID (Characteristics UUID: 0x2A50)
 */
@SuppressWarnings({"WeakerAccess"})
public class PnpIdAndroid extends PnpId implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PnpIdAndroid> CREATOR = new ByteArrayCreator<PnpIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PnpIdAndroid createFromParcel(@NonNull Parcel in) {
            return new PnpIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PnpIdAndroid[] newArray(int size) {
            return new PnpIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PnpIdAndroid createFromByteArray(@NonNull byte[] values) {
            return new PnpIdAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A50
     */
    @Deprecated
    public PnpIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public PnpIdAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param vendorIdSource Vendor ID Source
     * @param vendorId       Vendor ID
     * @param productId      Product ID
     * @param productVersion Product Version
     */
    public PnpIdAndroid(int vendorIdSource, int vendorId, int productId, int productVersion) {
        super(vendorIdSource, vendorId, productId, productVersion);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PnpIdAndroid(@NonNull Parcel in) {
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
