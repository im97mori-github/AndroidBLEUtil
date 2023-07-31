package org.im97mori.ble.characteristic.u2a48;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Supported Unread Alert Category (Characteristics UUID: 0x2A48)
 */
@SuppressWarnings({"WeakerAccess"})
public class SupportedUnreadAlertCategoryAndroid extends SupportedUnreadAlertCategory implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SupportedUnreadAlertCategoryAndroid> CREATOR = new ByteArrayCreator<SupportedUnreadAlertCategoryAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedUnreadAlertCategoryAndroid createFromParcel(@NonNull Parcel in) {
            return new SupportedUnreadAlertCategoryAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedUnreadAlertCategoryAndroid[] newArray(int size) {
            return new SupportedUnreadAlertCategoryAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedUnreadAlertCategoryAndroid createFromByteArray(@NonNull byte[] values) {
            return new SupportedUnreadAlertCategoryAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A48
     */
    @Deprecated
    public SupportedUnreadAlertCategoryAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public SupportedUnreadAlertCategoryAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     */
    public SupportedUnreadAlertCategoryAndroid(int categoryIdBitMask0) {
        super(categoryIdBitMask0, false, 0);
    }

    /**
     * Constructor from parameters
     *
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @param categoryIdBitMask1 Category ID Bit Mask 1
     */
    public SupportedUnreadAlertCategoryAndroid(int categoryIdBitMask0, int categoryIdBitMask1) {
        super(categoryIdBitMask0, true, categoryIdBitMask1);
    }

    /**
     * Constructor from parameters
     *
     * @param categoryIdBitMask0    Category ID Bit Mask 0
     * @param hasCategoryIdBitMask1 {@code true}:has Category ID Bit Mask 1, {@code false}:no Category ID Bit Mask 1
     * @param categoryIdBitMask1    Category ID Bit Mask 1
     */
    public SupportedUnreadAlertCategoryAndroid(int categoryIdBitMask0, boolean hasCategoryIdBitMask1, int categoryIdBitMask1) {
        super(categoryIdBitMask0, hasCategoryIdBitMask1, categoryIdBitMask1);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SupportedUnreadAlertCategoryAndroid(@NonNull Parcel in) {
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
