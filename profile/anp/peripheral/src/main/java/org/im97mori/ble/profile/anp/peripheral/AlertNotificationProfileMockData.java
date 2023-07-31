package org.im97mori.ble.profile.anp.peripheral;

import android.os.Build;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceData;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Alert Notification Profile Mock data class
 */
public class AlertNotificationProfileMockData extends MockData {

    /**
     * @see Creator
     */
    public static final Creator<AlertNotificationProfileMockData> CREATOR = new Creator<AlertNotificationProfileMockData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        @Deprecated
        public AlertNotificationProfileMockData createFromParcel(@NonNull Parcel in) {
            //noinspection deprecation
            return new AlertNotificationProfileMockData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AlertNotificationProfileMockData[] newArray(int size) {
            return new AlertNotificationProfileMockData[size];
        }

    };

    @SerializedName("alert_notification")
    public AlertNotificationServiceData alertNotification;

    /**
     * Constructor
     */
    public AlertNotificationProfileMockData() {
    }

    /**
     * @param alertNotification Alert Notification Service data
     */
    public AlertNotificationProfileMockData(@NonNull AlertNotificationServiceData alertNotification) {
        super(Collections.emptyList());
        this.alertNotification = alertNotification;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @Deprecated
    public AlertNotificationProfileMockData(@NonNull Parcel in) {
        super(in);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            alertNotification = in.readParcelable(this.getClass().getClassLoader(), AlertNotificationServiceData.class);
        } else {
            alertNotification = in.readParcelable(this.getClass().getClassLoader());
        }
    }

    /**
     * @return {@link #serviceDataList}
     */
    public List<ServiceData> getServiceDataList() {
        return Collections.singletonList(alertNotification);
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
        super.writeToParcel(dest, flags);
        dest.writeParcelable(alertNotification, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(alertNotification);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof AlertNotificationProfileMockData) {
            AlertNotificationProfileMockData target = (AlertNotificationProfileMockData) obj;
            result = super.equals(target)
                    && Objects.equals(alertNotification, target.alertNotification);
        }
        return result;
    }

}
