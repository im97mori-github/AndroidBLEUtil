package org.im97mori.ble.characteristic.u2a47;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC;

/**
 * Supported New Alert Category (Characteristics UUID: 0x2A47)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SupportedNewAlertCategoryAndroid extends SupportedNewAlertCategory implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SupportedNewAlertCategoryAndroid> CREATOR = new ByteArrayCreater<SupportedNewAlertCategoryAndroid>() {

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
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private SupportedNewAlertCategoryAndroid(@NonNull Parcel in) {
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
