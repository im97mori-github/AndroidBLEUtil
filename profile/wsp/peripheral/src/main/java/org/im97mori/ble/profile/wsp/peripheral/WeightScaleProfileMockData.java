package org.im97mori.ble.profile.wsp.peripheral;

import android.os.Build;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceData;
import org.im97mori.ble.service.uds.peripheral.UserDataServiceData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Weight Scale Profile Mock data class
 */
public class WeightScaleProfileMockData extends MockData {

    /**
     * @see Creator
     */
    public static final Creator<WeightScaleProfileMockData> CREATOR = new Creator<WeightScaleProfileMockData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        @Deprecated
        public WeightScaleProfileMockData createFromParcel(@NonNull Parcel in) {
            //noinspection deprecation
            return new WeightScaleProfileMockData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public WeightScaleProfileMockData[] newArray(int size) {
            return new WeightScaleProfileMockData[size];
        }

    };

    /**
     * Weight Scale data
     */
    @SerializedName("weight_scale")
    public ServiceData weightScale;

    /**
     * Device Information data
     */
    @SerializedName("device_information")
    public ServiceData deviceInformation;

    /**
     * User Data data
     */
    @SerializedName("user_data")
    public UserDataServiceData userData;

    /**
     * Battery data
     */
    @SerializedName("battery_list")
    public List<ServiceData> batteryList;

    /**
     * Current Time data
     */
    @SerializedName("current_time")
    public CurrentTimeServiceData currentTime;

    /**
     * Constructor
     */
    public WeightScaleProfileMockData() {
    }

    /**
     * @param weightScale       Weight Scale data
     * @param deviceInformation Device Information data
     * @param userData          User Data data
     * @param batteryList       Battery data list
     * @param currentTime       Current Time data
     */
    public WeightScaleProfileMockData(@NonNull ServiceData weightScale
            , @Nullable ServiceData deviceInformation
            , @Nullable UserDataServiceData userData
            , @Nullable List<ServiceData> batteryList
            , @Nullable CurrentTimeServiceData currentTime) {
        super(Collections.emptyList());
        this.weightScale = weightScale;
        this.deviceInformation = deviceInformation;
        this.userData = userData;
        this.batteryList = batteryList;
        this.currentTime = currentTime;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @Deprecated
    public WeightScaleProfileMockData(@NonNull Parcel in) {
        super(in);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            weightScale = in.readParcelable(this.getClass().getClassLoader(), ServiceData.class);
            deviceInformation = in.readParcelable(this.getClass().getClassLoader(), ServiceData.class);
            userData = in.readParcelable(this.getClass().getClassLoader(), UserDataServiceData.class);
            batteryList = in.createTypedArrayList(ServiceData.CREATOR);
            currentTime = in.readParcelable(this.getClass().getClassLoader(), CurrentTimeServiceData.class);
        } else {
            weightScale = in.readParcelable(this.getClass().getClassLoader());
            deviceInformation = in.readParcelable(this.getClass().getClassLoader());
            userData = in.readParcelable(this.getClass().getClassLoader());
            batteryList = in.createTypedArrayList(ServiceData.CREATOR);
            currentTime = in.readParcelable(this.getClass().getClassLoader());
        }
    }

    /**
     * @return {@link #serviceDataList}
     */
    public List<ServiceData> getServiceDataList() {
        List<ServiceData> serviceDataList = new ArrayList<>();
        serviceDataList.add(weightScale);
        if (deviceInformation != null) {
            serviceDataList.add(deviceInformation);
        }
        if (userData != null) {
            serviceDataList.add(userData);
        }
        if (batteryList != null) {
            serviceDataList.addAll(batteryList);
        }
        if (currentTime != null) {
            serviceDataList.add(currentTime);
        }
        return serviceDataList;
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
        dest.writeParcelable(weightScale, flags);
        dest.writeParcelable(deviceInformation, flags);
        dest.writeParcelable(userData, flags);
        dest.writeTypedList(batteryList);
        dest.writeParcelable(currentTime, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(weightScale)
                ^ Objects.hashCode(deviceInformation)
                ^ Objects.hashCode(userData)
                ^ Objects.hashCode(batteryList)
                ^ Objects.hashCode(currentTime);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof WeightScaleProfileMockData) {
            WeightScaleProfileMockData target = (WeightScaleProfileMockData) obj;
            result = super.equals(target)
                    && Objects.equals(weightScale, target.weightScale)
                    && Objects.equals(deviceInformation, target.deviceInformation)
                    && Objects.equals(userData, target.userData)
                    && Objects.equals(batteryList, target.batteryList)
                    && Objects.equals(currentTime, target.currentTime);
        }
        return result;
    }

}
