package org.im97mori.ble.characteristic.ans;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC;

/**
 * Alert Notification Control Point (Characteristics UUID: 0x2A44)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class AlertNotificationControlPoint implements ByteArrayInterface, Parcelable {

    /**
     * 0: Enable New Incoming Alert Notification
     */
    public static final int COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION = 0;

    /**
     * 1: Enable Unread Category Status Notification
     */
    public static final int COMMAND_ID_ENABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION = 1;

    /**
     * 2: Disable New Incoming Alert Notification
     */
    public static final int COMMAND_ID_DISABLE_NEW_IMCOMING_ALERT_NOTIFICATION = 2;

    /**
     * 3: Disable Unread Category Status Notification
     */
    public static final int COMMAND_ID_DISABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION = 3;

    /**
     * 4: Notify New Incoming Alert immediately
     */
    public static final int COMMAND_ID_NOTIFY_NEW_INCOMING_ALERT_IMMEDIATELY = 4;

    /**
     * 5: Notify Unread Category Status immediately
     */
    public static final int COMMAND_ID_NOTIFY_UNREAD_CATEGORY_STATUS_IMMEDIATELY = 5;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AlertNotificationControlPoint> CREATOR = new ByteArrayCreater<AlertNotificationControlPoint>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertNotificationControlPoint createFromParcel(@NonNull Parcel in) {
            return new AlertNotificationControlPoint(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertNotificationControlPoint[] newArray(int size) {
            return new AlertNotificationControlPoint[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AlertNotificationControlPoint createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AlertNotificationControlPoint(bluetoothGattCharacteristic);
        }

    };

    /**
     * Command ID
     */
    private final int mCommandId;

    /**
     * Category ID
     */
    private final int mCategoryId;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A44
     */
    public AlertNotificationControlPoint(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mCommandId = (values[0] & 0xff);
        mCategoryId = (values[1] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AlertNotificationControlPoint(@NonNull Parcel in) {
        mCommandId = in.readInt();
        mCategoryId = in.readInt();
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
        dest.writeInt(mCommandId);
        dest.writeInt(mCategoryId);
    }

    /**
     * @return Command ID
     */
    public int getCommandId() {
        return mCommandId;
    }

    /**
     * @return {@code true}:Enable New Incoming Alert Notification, {@code false}:not Enable New Incoming Alert Notification
     */
    public boolean isCommandIdEnableNewIncomingAlertNotification() {
        return COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION == mCommandId;
    }

    /**
     * @return {@code true}:Enable Unread Category Status Notification, {@code false}:not Enable Unread Category Status Notification
     */
    public boolean isCommandIdEnableUnreadCategoryStatusNotification() {
        return COMMAND_ID_ENABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION == mCommandId;
    }

    /**
     * @return {@code true}:Disable New Incoming Alert Notification, {@code false}:not Disable New Incoming Alert Notification
     */
    public boolean isCommandIdDisableNewIncomingAlertNotification() {
        return COMMAND_ID_DISABLE_NEW_IMCOMING_ALERT_NOTIFICATION == mCommandId;
    }

    /**
     * @return {@code true}:Disable Unread Category Status Notification, {@code false}:not Disable Unread Category Status Notification
     */
    public boolean isCommandIdDisableeUnreadCategoryStatusNotification() {
        return COMMAND_ID_DISABLE_UNREAD_CATEGORY_STATUS_NOTIFICATION == mCommandId;
    }

    /**
     * @return {@code true}:Notify New Incoming Alert immediately, {@code false}:not Notify New Incoming Alert immediately
     */
    public boolean isCommandIdNotifyNewIncomingAlertImmediately() {
        return COMMAND_ID_NOTIFY_NEW_INCOMING_ALERT_IMMEDIATELY == mCommandId;
    }

    /**
     * @return {@code true}:Notify Unread Category Status immediately, {@code false}:not Notify Unread Category Status immediately
     */
    public boolean isCommandIdNotifyUnreadCategoryStatusImmediately() {
        return COMMAND_ID_NOTIFY_UNREAD_CATEGORY_STATUS_IMMEDIATELY == mCommandId;
    }

    /**
     * @return Category ID
     */
    public int getCategoryId() {
        return mCategoryId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mCommandId);
        byteBuffer.put((byte) mCategoryId);
        return data;
    }

}
