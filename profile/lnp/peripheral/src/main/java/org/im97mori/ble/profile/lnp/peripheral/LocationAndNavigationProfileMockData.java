package org.im97mori.ble.profile.lnp.peripheral;

import android.os.Build;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Location and Navigation Profile Mock data class
 */
public class LocationAndNavigationProfileMockData extends MockData {

    /**
     * @see Creator
     */
    public static final Creator<LocationAndNavigationProfileMockData> CREATOR = new Creator<LocationAndNavigationProfileMockData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        @Deprecated
        public LocationAndNavigationProfileMockData createFromParcel(@NonNull Parcel in) {
            //noinspection deprecation
            return new LocationAndNavigationProfileMockData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocationAndNavigationProfileMockData[] newArray(int size) {
            return new LocationAndNavigationProfileMockData[size];
        }

    };

    /**
     * Location and Navigation data
     */
    @SerializedName("location_and_navigation")
    public LocationAndNavigationServiceData locationAndNavigation;

    /**
     * Device Information data
     */
    @SerializedName("device_information")
    public ServiceData deviceInformation;

    /**
     * Battery data
     */
    @SerializedName("battery_list")
    public List<ServiceData> batteryList;

    /**
     * Constructor
     */
    public LocationAndNavigationProfileMockData() {
    }

    /**
     * @param locationAndNavigation Location and Navigation data
     * @param deviceInformation     Device Information data
     * @param batteryList           Battery data list
     */
    public LocationAndNavigationProfileMockData(@NonNull LocationAndNavigationServiceData locationAndNavigation
            , @Nullable ServiceData deviceInformation
            , @Nullable List<ServiceData> batteryList) {
        super(Collections.emptyList());
        this.locationAndNavigation = locationAndNavigation;
        this.deviceInformation = deviceInformation;
        this.batteryList = batteryList;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @Deprecated
    public LocationAndNavigationProfileMockData(@NonNull Parcel in) {
        super(in);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            locationAndNavigation = in.readParcelable(this.getClass().getClassLoader(), LocationAndNavigationServiceData.class);
            deviceInformation = in.readParcelable(this.getClass().getClassLoader(), ServiceData.class);
        } else {
            locationAndNavigation = in.readParcelable(this.getClass().getClassLoader());
            deviceInformation = in.readParcelable(this.getClass().getClassLoader());
        }
        batteryList = in.createTypedArrayList(ServiceData.CREATOR);
    }

    /**
     * @return {@link #serviceDataList}
     */
    public List<ServiceData> getServiceDataList() {
        List<ServiceData> serviceDataList = new ArrayList<>();
        serviceDataList.add(locationAndNavigation);
        if (deviceInformation != null) {
            serviceDataList.add(deviceInformation);
        }
        if (batteryList != null) {
            serviceDataList.addAll(batteryList);
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
        dest.writeParcelable(locationAndNavigation, flags);
        dest.writeParcelable(deviceInformation, flags);
        dest.writeTypedList(batteryList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(locationAndNavigation)
                ^ Objects.hashCode(deviceInformation)
                ^ Objects.hashCode(batteryList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof LocationAndNavigationProfileMockData) {
            LocationAndNavigationProfileMockData target = (LocationAndNavigationProfileMockData) obj;
            result = super.equals(target)
                    && Objects.equals(locationAndNavigation, target.locationAndNavigation)
                    && Objects.equals(deviceInformation, target.deviceInformation)
                    && Objects.equals(batteryList, target.batteryList);
        }
        return result;
    }

}
