package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * <p>
 * LE Bluetooth Device Address
 * <p>
 * <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/">generic-access-profile</a>
 * </p>
 */
public class LeBluetoothDeviceAddressAndroid extends LeBluetoothDeviceAddress implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LeBluetoothDeviceAddressAndroid> CREATOR = new ByteArrayCreator<LeBluetoothDeviceAddressAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LeBluetoothDeviceAddressAndroid createFromParcel(@NonNull Parcel in) {
            return new LeBluetoothDeviceAddressAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LeBluetoothDeviceAddressAndroid[] newArray(int size) {
            return new LeBluetoothDeviceAddressAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public LeBluetoothDeviceAddressAndroid createFromByteArray(@NonNull byte[] values) {
            return new LeBluetoothDeviceAddressAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #LeBluetoothDeviceAddressAndroid(byte[], int, int)
     */
    public LeBluetoothDeviceAddressAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor for Public Target Address
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octet of Advertising Data
     */
    public LeBluetoothDeviceAddressAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }

    /**
     * Constructor from parameters
     *
     * @param leBluetoothDeviceAddress
     *            LE Bluetooth Device Address
     * @param isRandomAddress
     *            {@code true}: Random Device Address, {@code false}: Public Device
     *            Address
     */
    public LeBluetoothDeviceAddressAndroid(@NonNull byte[] leBluetoothDeviceAddress, boolean isRandomAddress) {
        super(leBluetoothDeviceAddress, isRandomAddress);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LeBluetoothDeviceAddressAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()), 0, in.readInt());
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
        dest.writeInt(getLength());
    }

}
