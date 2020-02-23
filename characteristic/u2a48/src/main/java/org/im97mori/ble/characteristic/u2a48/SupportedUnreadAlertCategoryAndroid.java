package org.im97mori.ble.characteristic.u2a48;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC;

/**
 * Supported Unread Alert Category (Characteristics UUID: 0x2A48)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SupportedUnreadAlertCategoryAndroid extends SupportedUnreadAlertCategory implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SupportedUnreadAlertCategoryAndroid> CREATOR = new ByteArrayCreater<SupportedUnreadAlertCategoryAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SupportedUnreadAlertCategoryAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A48
     */
    public SupportedUnreadAlertCategoryAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private SupportedUnreadAlertCategoryAndroid(@NonNull Parcel in) {
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
