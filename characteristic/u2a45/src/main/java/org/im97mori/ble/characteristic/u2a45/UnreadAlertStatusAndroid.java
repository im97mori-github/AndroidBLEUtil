package org.im97mori.ble.characteristic.u2a45;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Unread Alert Status (Characteristics UUID: 0x2A45)
 */
@SuppressWarnings({"WeakerAccess"})
public class UnreadAlertStatusAndroid extends UnreadAlertStatus implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<UnreadAlertStatusAndroid> CREATOR = new ByteArrayCreator<UnreadAlertStatusAndroid>() {

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
            return new UnreadAlertStatusAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A45
     */
    @Deprecated
    public UnreadAlertStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public UnreadAlertStatusAndroid(@NonNull byte[] values) {
        super(values);
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
    private UnreadAlertStatusAndroid(@NonNull Parcel in) {
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
