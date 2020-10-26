package org.im97mori.ble.characteristic.u2a44;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC;

/**
 * Alert Notification Control Point (Characteristics UUID: 0x2A44)
 */
@SuppressWarnings({"WeakerAccess"})
public class AlertNotificationControlPointAndroid extends AlertNotificationControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AlertNotificationControlPointAndroid> CREATOR = new ByteArrayCreater<AlertNotificationControlPointAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AlertNotificationControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A44
     */
    public AlertNotificationControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
