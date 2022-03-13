package org.im97mori.ble.characteristic.u2a47;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC;

/**
 * Supported New Alert Category (Characteristics UUID: 0x2A47)
 */
@SuppressWarnings({"WeakerAccess"})
public class SupportedNewAlertCategoryAndroid extends SupportedNewAlertCategory implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SupportedNewAlertCategoryAndroid> CREATOR = new ByteArrayCreator<SupportedNewAlertCategoryAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedNewAlertCategoryAndroid createFromParcel(@NonNull Parcel in) {
            return new SupportedNewAlertCategoryAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedNewAlertCategoryAndroid[] newArray(int size) {
            return new SupportedNewAlertCategoryAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedNewAlertCategoryAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SupportedNewAlertCategoryAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A47
     */
    public SupportedNewAlertCategoryAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     */
    public SupportedNewAlertCategoryAndroid(int categoryIdBitMask0) {
        super(categoryIdBitMask0, false, 0);
    }

    /**
     * Constructor from parameters
     *
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @param categoryIdBitMask1 Category ID Bit Mask 1
     */
    public SupportedNewAlertCategoryAndroid(int categoryIdBitMask0, int categoryIdBitMask1) {
        super(categoryIdBitMask0, true, categoryIdBitMask1);
    }

    /**
     * Constructor from parameters
     *
     * @param categoryIdBitMask0    Category ID Bit Mask 0
     * @param hasCategoryIdBitMask1 {@code true}:has Category ID Bit Mask 1, {@code false}:no Category ID Bit Mask 1
     * @param categoryIdBitMask1    Category ID Bit Mask 1
     */
    public SupportedNewAlertCategoryAndroid(int categoryIdBitMask0, boolean hasCategoryIdBitMask1, int categoryIdBitMask1) {
        super(categoryIdBitMask0, hasCategoryIdBitMask1, categoryIdBitMask1);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SupportedNewAlertCategoryAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(in.createByteArray());
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
