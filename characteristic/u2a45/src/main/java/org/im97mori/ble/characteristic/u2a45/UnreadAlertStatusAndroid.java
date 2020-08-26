package org.im97mori.ble.characteristic.u2a45;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.UNREAD_ALERT_STATUS_CHARACTERISTIC;

/**
 * Unread Alert Status (Characteristics UUID: 0x2A45)
 */
@SuppressWarnings({"WeakerAccess"})
public class UnreadAlertStatusAndroid extends UnreadAlertStatus implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<UnreadAlertStatusAndroid> CREATOR = new ByteArrayCreater<UnreadAlertStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UnreadAlertStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new UnreadAlertStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UnreadAlertStatusAndroid[] newArray(int size) {
            return new UnreadAlertStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public UnreadAlertStatusAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(UNREAD_ALERT_STATUS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new UnreadAlertStatusAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A45
     */
    public UnreadAlertStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param categoryId  Category ID
     * @param unreadCount Unread count
     */
    public UnreadAlertStatusAndroid(int categoryId, int unreadCount) {
        super(categoryId, unreadCount);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private UnreadAlertStatusAndroid(@NonNull Parcel in) {
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
