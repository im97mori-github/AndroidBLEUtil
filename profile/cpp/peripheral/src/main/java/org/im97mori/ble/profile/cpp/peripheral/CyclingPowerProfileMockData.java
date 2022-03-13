package org.im97mori.ble.profile.cpp.peripheral;

import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Cycling Power Profile Mock data class
 */
public class CyclingPowerProfileMockData extends MockData {

    /**
     * @see Creator
     */
    public static final Creator<CyclingPowerProfileMockData> CREATOR = new Creator<CyclingPowerProfileMockData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerProfileMockData createFromParcel(@NonNull Parcel in) {
            return new CyclingPowerProfileMockData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerProfileMockData[] newArray(int size) {
            return new CyclingPowerProfileMockData[size];
        }

    };

    /**
     * Cycling Power data
     */
    @SerializedName("cycling_power")
    public CyclingPowerServiceData cyclingPower;

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
    public CyclingPowerProfileMockData() {
    }

    /**
     * @param cyclingPower      Cycling Power data
     * @param deviceInformation Device Information data
     * @param batteryList       Battery data list
     */
    public CyclingPowerProfileMockData(@NonNull CyclingPowerServiceData cyclingPower
            , @Nullable ServiceData deviceInformation
            , @Nullable List<ServiceData> batteryList) {
        super(Collections.emptyList());
        this.cyclingPower = cyclingPower;
        this.deviceInformation = deviceInformation;
        this.batteryList = batteryList;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public CyclingPowerProfileMockData(@NonNull Parcel in) {
        super(in);
        cyclingPower = in.readParcelable(this.getClass().getClassLoader());
        deviceInformation = in.readParcelable(this.getClass().getClassLoader());
        batteryList = in.createTypedArrayList(ServiceData.CREATOR);
    }

    /**
     * @return {@link #serviceDataList}
     */
    public List<ServiceData> getServiceDataList() {
        List<ServiceData> serviceDataList = new ArrayList<>();
        serviceDataList.add(cyclingPower);
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
        dest.writeParcelable(cyclingPower, flags);
        dest.writeParcelable(deviceInformation, flags);
        dest.writeTypedList(batteryList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(cyclingPower)
                ^ Objects.hashCode(deviceInformation)
                ^ Objects.hashCode(batteryList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof CyclingPowerProfileMockData) {
            CyclingPowerProfileMockData target = (CyclingPowerProfileMockData) obj;
            result = super.equals(target)
                    && Objects.equals(cyclingPower, target.cyclingPower)
                    && Objects.equals(deviceInformation, target.deviceInformation)
                    && Objects.equals(batteryList, target.batteryList);
        }
        return result;
    }

}
