package org.im97mori.ble.profile.rscp.peripheral;

import android.os.Build;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.service.rscs.peripheral.RunningSpeedAndCadenceServiceData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Running Speed and Cadence Profile Mock data class
 */
public class RunningSpeedAndCadenceProfileMockData extends MockData {

    /**
     * @see Creator
     */
    public static final Creator<RunningSpeedAndCadenceProfileMockData> CREATOR = new Creator<RunningSpeedAndCadenceProfileMockData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        @Deprecated
        public RunningSpeedAndCadenceProfileMockData createFromParcel(@NonNull Parcel in) {
            //noinspection deprecation
            return new RunningSpeedAndCadenceProfileMockData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RunningSpeedAndCadenceProfileMockData[] newArray(int size) {
            return new RunningSpeedAndCadenceProfileMockData[size];
        }

    };

    /**
     * Running Speed and Cadence data
     */
    @SerializedName("running_speed_and_cadence")
    public RunningSpeedAndCadenceServiceData runningSpeedAndCadence;

    /**
     * Device Information data
     */
    @SerializedName("device_information")
    public ServiceData deviceInformation;

    /**
     * Constructor
     */
    public RunningSpeedAndCadenceProfileMockData() {
    }

    /**
     * @param runningSpeedAndCadence Running Speed and Cadence data
     * @param deviceInformation      Device Information data
     */
    public RunningSpeedAndCadenceProfileMockData(@NonNull RunningSpeedAndCadenceServiceData runningSpeedAndCadence
            , @Nullable ServiceData deviceInformation) {
        super(Collections.emptyList());
        this.runningSpeedAndCadence = runningSpeedAndCadence;
        this.deviceInformation = deviceInformation;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @Deprecated
    public RunningSpeedAndCadenceProfileMockData(@NonNull Parcel in) {
        super(in);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            runningSpeedAndCadence = in.readParcelable(this.getClass().getClassLoader(), RunningSpeedAndCadenceServiceData.class);
            deviceInformation = in.readParcelable(this.getClass().getClassLoader(), ServiceData.class);
        } else {
            runningSpeedAndCadence = in.readParcelable(this.getClass().getClassLoader());
            deviceInformation = in.readParcelable(this.getClass().getClassLoader());
        }
    }

    /**
     * @return {@link #serviceDataList}
     */
    public List<ServiceData> getServiceDataList() {
        List<ServiceData> serviceDataList = new ArrayList<>();
        serviceDataList.add(runningSpeedAndCadence);
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
        dest.writeParcelable(runningSpeedAndCadence, flags);
        dest.writeParcelable(deviceInformation, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(runningSpeedAndCadence)
                ^ Objects.hashCode(deviceInformation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof RunningSpeedAndCadenceProfileMockData) {
            RunningSpeedAndCadenceProfileMockData target = (RunningSpeedAndCadenceProfileMockData) obj;
            result = super.equals(target)
                    && Objects.equals(runningSpeedAndCadence, target.runningSpeedAndCadence)
                    && Objects.equals(deviceInformation, target.deviceInformation);
        }
        return result;
    }

}
