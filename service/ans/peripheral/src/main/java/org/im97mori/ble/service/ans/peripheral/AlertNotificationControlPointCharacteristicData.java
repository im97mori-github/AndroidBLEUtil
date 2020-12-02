package org.im97mori.ble.service.ans.peripheral;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;

import java.util.Arrays;
import java.util.Collections;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC;

/**
 * Alert Notification Control Point Characteristic data class
 */
@SuppressWarnings("CanBeFinal")
public class AlertNotificationControlPointCharacteristicData extends CharacteristicData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<AlertNotificationControlPointCharacteristicData> CREATOR = new Creator<AlertNotificationControlPointCharacteristicData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertNotificationControlPointCharacteristicData createFromParcel(@NonNull Parcel in) {
            return new AlertNotificationControlPointCharacteristicData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertNotificationControlPointCharacteristicData[] newArray(int size) {
            return new AlertNotificationControlPointCharacteristicData[size];
        }

    };

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Enable New Alert Notification response)
     */
    @SerializedName("enable_new_alert_notification_response_value")
    public int enableNewAlertNotificationResponseValue;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Enable Unread Alert Status Notification response)
     */
    @SerializedName("enable_unread_alert_status_notification_response_value")
    public int enableUnreadAlertStatusNotificationResponseValue;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Disable New Alert Notification response)
     */
    @SerializedName("disable_new_alert_notification_response_value")
    public int disableNewAlertNotificationResponseValue;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Disable Unread Alert Status Notification response)
     */
    @SerializedName("disable_unread_alert_status_notification_response_value")
    public int disableUnreadAlertStatusNotificationResponseValue;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Notify New Alert immediately response)
     */
    @SerializedName("notify_new_alert_immediately_response_value")
    public int notifyNewAlertImmediatelyResponseValue;

    /**
     * characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Notify Unread Alert Status immediately response)
     */
    @SerializedName("notify_unread_alert_status_immediately_response_value")
    public int notifyUnreadAlertStatusImmediatelyResponseValue;

    /**
     * @param enableNewAlertNotificationResponseValue           characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Enable New Alert Notification response)
     * @param enableUnreadAlertStatusNotificationResponseValue  characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Enable Unread Alert Status Notification response)
     * @param disableNewAlertNotificationResponseValue          characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Disable New Alert Notification response)
     * @param disableUnreadAlertStatusNotificationResponseValue characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Disable Unread Alert Status Notification response)
     * @param notifyNewAlertImmediatelyResponseValue            characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Notify New Alert immediately response)
     * @param notifyUnreadAlertStatusImmediatelyResponseValue   characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Notify Unread Alert Status immediately response)
     * @param delay                                             response delay(millis)
     */
    public AlertNotificationControlPointCharacteristicData(int enableNewAlertNotificationResponseValue
            , int enableUnreadAlertStatusNotificationResponseValue
            , int disableNewAlertNotificationResponseValue
            , int disableUnreadAlertStatusNotificationResponseValue
            , int notifyNewAlertImmediatelyResponseValue
            , int notifyUnreadAlertStatusImmediatelyResponseValue
            , long delay) {
        super(ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, BluetoothGattCharacteristic.PERMISSION_WRITE, Collections.<DescriptorData>emptyList(), BluetoothGatt.GATT_SUCCESS, delay, null, 1);
        this.enableNewAlertNotificationResponseValue = enableNewAlertNotificationResponseValue;
        this.enableUnreadAlertStatusNotificationResponseValue = enableUnreadAlertStatusNotificationResponseValue;
        this.disableNewAlertNotificationResponseValue = disableNewAlertNotificationResponseValue;
        this.disableUnreadAlertStatusNotificationResponseValue = disableUnreadAlertStatusNotificationResponseValue;
        this.notifyNewAlertImmediatelyResponseValue = notifyNewAlertImmediatelyResponseValue;
        this.notifyUnreadAlertStatusImmediatelyResponseValue = notifyUnreadAlertStatusImmediatelyResponseValue;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public AlertNotificationControlPointCharacteristicData(@NonNull Parcel in) {
        super(in);
        enableNewAlertNotificationResponseValue = in.readInt();
        enableUnreadAlertStatusNotificationResponseValue = in.readInt();
        disableNewAlertNotificationResponseValue = in.readInt();
        disableUnreadAlertStatusNotificationResponseValue = in.readInt();
        notifyNewAlertImmediatelyResponseValue = in.readInt();
        notifyUnreadAlertStatusImmediatelyResponseValue = in.readInt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(enableNewAlertNotificationResponseValue);
        dest.writeInt(enableUnreadAlertStatusNotificationResponseValue);
        dest.writeInt(disableNewAlertNotificationResponseValue);
        dest.writeInt(disableUnreadAlertStatusNotificationResponseValue);
        dest.writeInt(notifyNewAlertImmediatelyResponseValue);
        dest.writeInt(notifyUnreadAlertStatusImmediatelyResponseValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Integer.valueOf(enableNewAlertNotificationResponseValue).hashCode()
                ^ Integer.valueOf(enableUnreadAlertStatusNotificationResponseValue).hashCode()
                ^ Integer.valueOf(disableNewAlertNotificationResponseValue).hashCode()
                ^ Integer.valueOf(disableUnreadAlertStatusNotificationResponseValue).hashCode()
                ^ Integer.valueOf(notifyNewAlertImmediatelyResponseValue).hashCode()
                ^ Integer.valueOf(notifyUnreadAlertStatusImmediatelyResponseValue).hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof AlertNotificationControlPointCharacteristicData) {
            AlertNotificationControlPointCharacteristicData target = (AlertNotificationControlPointCharacteristicData) obj;
            result = uuid.equals(target.uuid)
                    && property == target.property
                    && permission == target.permission
                    && Arrays.equals(descriptorDataList.toArray(), target.descriptorDataList.toArray())
                    && responseCode == target.responseCode
                    && delay == target.delay
                    && Arrays.equals(data, target.data)
                    && Arrays.equals(currentData, target.currentData)
                    && Arrays.equals(temporaryData, target.temporaryData)
                    && notificationCount == target.notificationCount
                    && enableNewAlertNotificationResponseValue == target.enableNewAlertNotificationResponseValue
                    && enableUnreadAlertStatusNotificationResponseValue == target.enableUnreadAlertStatusNotificationResponseValue
                    && disableNewAlertNotificationResponseValue == target.disableNewAlertNotificationResponseValue
                    && disableUnreadAlertStatusNotificationResponseValue == target.disableUnreadAlertStatusNotificationResponseValue
                    && notifyNewAlertImmediatelyResponseValue == target.notifyNewAlertImmediatelyResponseValue
                    && notifyUnreadAlertStatusImmediatelyResponseValue == target.notifyUnreadAlertStatusImmediatelyResponseValue;
        }
        return result;
    }

}
