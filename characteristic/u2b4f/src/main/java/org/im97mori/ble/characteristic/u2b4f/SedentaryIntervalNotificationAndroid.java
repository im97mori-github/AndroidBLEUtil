package org.im97mori.ble.characteristic.u2b4f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.SEDENTARY_INTERVAL_NOTIFICATION_CHARACTERISTIC;

/**
 * Sedentary Interval Notification (Characteristics UUID: 0x2B4F)
 */
@SuppressWarnings({"WeakerAccess"})
public class SedentaryIntervalNotificationAndroid extends SedentaryIntervalNotification implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<SedentaryIntervalNotificationAndroid> CREATOR = new ByteArrayCreater<SedentaryIntervalNotificationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SedentaryIntervalNotificationAndroid createFromParcel(@NonNull Parcel in) {
            return new SedentaryIntervalNotificationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SedentaryIntervalNotificationAndroid[] newArray(int size) {
            return new SedentaryIntervalNotificationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SedentaryIntervalNotificationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SEDENTARY_INTERVAL_NOTIFICATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SedentaryIntervalNotificationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B4F
     */
    public SedentaryIntervalNotificationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param sedentaryIntervalNotification Sedentary Interval Notification
     */
    public SedentaryIntervalNotificationAndroid(int sedentaryIntervalNotification) {
        super(sedentaryIntervalNotification);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SedentaryIntervalNotificationAndroid(@NonNull Parcel in) {
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
