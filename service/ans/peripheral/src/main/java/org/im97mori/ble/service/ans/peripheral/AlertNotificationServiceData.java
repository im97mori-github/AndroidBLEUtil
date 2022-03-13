package org.im97mori.ble.service.ans.peripheral;

import static org.im97mori.ble.constants.ServiceUUID.ALERT_NOTIFICATION_SERVICE;

import android.bluetooth.BluetoothGattService;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.ServiceData;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Alert Notification Service data class
 */
public class AlertNotificationServiceData extends ServiceData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<AlertNotificationServiceData> CREATOR = new Creator<AlertNotificationServiceData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertNotificationServiceData createFromParcel(@NonNull Parcel in) {
            return new AlertNotificationServiceData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertNotificationServiceData[] newArray(int size) {
            return new AlertNotificationServiceData[size];
        }

    };

    /**
     * Supported New Alert Category data
     */
    @SerializedName("supported_new_alert_category")
    public CharacteristicData supportedNewAlertCategory;

    /**
     * New Alert data
     */
    @SerializedName("new_alert_data")
    public NewAlertCharacteristicData newAlert;

    /**
     * Supported Unread Alert Category data
     */
    @SerializedName("supported_unread_alert_category")
    public CharacteristicData supportedUnreadAlertCategory;

    /**
     * Unread Alert Status data
     */
    @SerializedName("unread_alert_status")
    public UnreadAlertStatusCharacteristicData unreadAlertStatus;

    /**
     * Alert Notification Control Point data
     */
    @SerializedName("alert_notification_control_point")
    public AlertNotificationControlPointCharacteristicData alertNotificationControlPoint;

    /**
     * Constructor
     */
    public AlertNotificationServiceData() {
    }

    /**
     * Constructor
     *
     * @param supportedNewAlertCategory     Supported New Alert Category data
     * @param newAlert                      New Alert data
     * @param supportedUnreadAlertCategory  Supported Unread Alert Category data
     * @param unreadAlertStatus             Unread Alert Status data
     * @param alertNotificationControlPoint Alert Notification Control Point data
     */
    public AlertNotificationServiceData(@NonNull CharacteristicData supportedNewAlertCategory
            , @NonNull NewAlertCharacteristicData newAlert
            , @NonNull CharacteristicData supportedUnreadAlertCategory
            , @NonNull UnreadAlertStatusCharacteristicData unreadAlertStatus
            , @NonNull AlertNotificationControlPointCharacteristicData alertNotificationControlPoint) {
        super(ALERT_NOTIFICATION_SERVICE
                , BluetoothGattService.SERVICE_TYPE_PRIMARY
                , Collections.emptyList());
        this.supportedNewAlertCategory = supportedNewAlertCategory;
        this.newAlert = newAlert;
        this.supportedUnreadAlertCategory = supportedUnreadAlertCategory;
        this.unreadAlertStatus = unreadAlertStatus;
        this.alertNotificationControlPoint = alertNotificationControlPoint;

    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public AlertNotificationServiceData(@NonNull Parcel in) {
        super(in);
        supportedNewAlertCategory = in.readParcelable(this.getClass().getClassLoader());
        newAlert = in.readParcelable(this.getClass().getClassLoader());
        supportedUnreadAlertCategory = in.readParcelable(this.getClass().getClassLoader());
        unreadAlertStatus = in.readParcelable(this.getClass().getClassLoader());
        alertNotificationControlPoint = in.readParcelable(this.getClass().getClassLoader());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CharacteristicData> getCharacteristicDataList() {
        return Arrays.asList(supportedNewAlertCategory
                , newAlert
                , supportedUnreadAlertCategory
                , unreadAlertStatus
                , alertNotificationControlPoint);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(supportedNewAlertCategory, flags);
        dest.writeParcelable(newAlert, flags);
        dest.writeParcelable(supportedUnreadAlertCategory, flags);
        dest.writeParcelable(unreadAlertStatus, flags);
        dest.writeParcelable(alertNotificationControlPoint, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(supportedNewAlertCategory)
                ^ Objects.hashCode(newAlert)
                ^ Objects.hashCode(supportedUnreadAlertCategory)
                ^ Objects.hashCode(unreadAlertStatus)
                ^ Objects.hashCode(alertNotificationControlPoint);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof ServiceData) {
            AlertNotificationServiceData target = (AlertNotificationServiceData) obj;
            result = super.equals(target)
                    && supportedNewAlertCategory.equals(target.supportedNewAlertCategory)
                    && newAlert.equals(target.newAlert)
                    && supportedUnreadAlertCategory.equals(target.supportedUnreadAlertCategory)
                    && unreadAlertStatus.equals(target.unreadAlertStatus)
                    && alertNotificationControlPoint.equals(target.alertNotificationControlPoint);
        }
        return result;
    }
}
