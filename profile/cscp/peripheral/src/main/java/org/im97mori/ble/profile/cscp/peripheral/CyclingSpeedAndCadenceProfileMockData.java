package org.im97mori.ble.profile.cscp.peripheral;

import android.os.Build;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Cycling Speed and Cadence Profile Mock data class
 */
public class CyclingSpeedAndCadenceProfileMockData extends MockData {

    /**
     * @see Creator
     */
    public static final Creator<CyclingSpeedAndCadenceProfileMockData> CREATOR = new Creator<CyclingSpeedAndCadenceProfileMockData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        @Deprecated
        public CyclingSpeedAndCadenceProfileMockData createFromParcel(@NonNull Parcel in) {
            //noinspection deprecation
            return new CyclingSpeedAndCadenceProfileMockData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingSpeedAndCadenceProfileMockData[] newArray(int size) {
            return new CyclingSpeedAndCadenceProfileMockData[size];
        }

    };

    /**
     * Cycling Speed and Cadence data
     */
    @SerializedName("cycling_speed_and_cadence")
    public CyclingSpeedAndCadenceServiceData cyclingSpeedAndCadence;

    /**
     * Device Information data
     */
    @SerializedName("device_information")
    public ServiceData deviceInformation;

    /**
     * Constructor
     */
    public CyclingSpeedAndCadenceProfileMockData() {
    }

    /**
     * @param cyclingSpeedAndCadence Cycling Speed and Cadence data
     * @param deviceInformation      Device Information data
     */
    public CyclingSpeedAndCadenceProfileMockData(@NonNull CyclingSpeedAndCadenceServiceData cyclingSpeedAndCadence
            , @Nullable ServiceData deviceInformation) {
        super(Collections.emptyList());
        this.cyclingSpeedAndCadence = cyclingSpeedAndCadence;
        this.deviceInformation = deviceInformation;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @Deprecated
    public CyclingSpeedAndCadenceProfileMockData(@NonNull Parcel in) {
        super(in);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            cyclingSpeedAndCadence = in.readParcelable(this.getClass().getClassLoader(), CyclingSpeedAndCadenceServiceData.class);
            deviceInformation = in.readParcelable(this.getClass().getClassLoader(), ServiceData.class);
        } else {
            cyclingSpeedAndCadence = in.readParcelable(this.getClass().getClassLoader());
            deviceInformation = in.readParcelable(this.getClass().getClassLoader());
        }
    }

    /**
     * @return {@link #serviceDataList}
     */
    public List<ServiceData> getServiceDataList() {
        List<ServiceData> serviceDataList = new ArrayList<>();
        serviceDataList.add(cyclingSpeedAndCadence);
        if (deviceInformation != null) {
            serviceDataList.add(deviceInformation);
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
        dest.writeParcelable(cyclingSpeedAndCadence, flags);
        dest.writeParcelable(deviceInformation, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(cyclingSpeedAndCadence)
                ^ Objects.hashCode(deviceInformation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof CyclingSpeedAndCadenceProfileMockData) {
            CyclingSpeedAndCadenceProfileMockData target = (CyclingSpeedAndCadenceProfileMockData) obj;
            result = super.equals(target)
                    && Objects.equals(cyclingSpeedAndCadence, target.cyclingSpeedAndCadence)
                    && Objects.equals(deviceInformation, target.deviceInformation);
        }
        return result;
    }

}
