package org.im97mori.ble.characteristic.u2a44;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Alert Notification Control Point (Characteristics UUID: 0x2A44)
 */
@SuppressWarnings({"WeakerAccess"})
public class AlertNotificationControlPointAndroid extends AlertNotificationControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AlertNotificationControlPointAndroid> CREATOR = new ByteArrayCreator<AlertNotificationControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertNotificationControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new AlertNotificationControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertNotificationControlPointAndroid[] newArray(int size) {
            return new AlertNotificationControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AlertNotificationControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            return new AlertNotificationControlPointAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A44
     */
    @Deprecated
    public AlertNotificationControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public AlertNotificationControlPointAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param commandId  Command ID
     * @param categoryId Category ID
     */
    public AlertNotificationControlPointAndroid(int commandId, int categoryId) {
        super(commandId, categoryId);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AlertNotificationControlPointAndroid(@NonNull Parcel in) {
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
