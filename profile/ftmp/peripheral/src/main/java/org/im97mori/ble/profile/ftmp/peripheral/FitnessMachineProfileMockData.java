package org.im97mori.ble.profile.ftmp.peripheral;

import android.os.Build;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceData;
import org.im97mori.ble.service.uds.peripheral.UserDataServiceData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Fitness Machine Profile Mock data class
 */
public class FitnessMachineProfileMockData extends MockData {

    /**
     * @see Creator
     */
    public static final Creator<FitnessMachineProfileMockData> CREATOR = new Creator<FitnessMachineProfileMockData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        @Deprecated
        public FitnessMachineProfileMockData createFromParcel(@NonNull Parcel in) {
            //noinspection deprecation
            return new FitnessMachineProfileMockData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineProfileMockData[] newArray(int size) {
            return new FitnessMachineProfileMockData[size];
        }

    };

    /**
     * Fitness Machine data
     */
    @SerializedName("fitness_machine")
    public FitnessMachineServiceData fitnessMachine;

    /**
     * User Data data
     */
    @SerializedName("user_data")
    public UserDataServiceData userData;

    /**
     * Device Information data
     */
    @SerializedName("device_information")
    public ServiceData deviceInformation;

    /**
     * Constructor
     */
    public FitnessMachineProfileMockData() {
    }

    /**
     * @param fitnessMachine    Cycling Speed and Cadence data
     * @param userData          User Data data
     * @param deviceInformation Device Information data
     */
    public FitnessMachineProfileMockData(@NonNull FitnessMachineServiceData fitnessMachine
            , @Nullable UserDataServiceData userData
            , @Nullable ServiceData deviceInformation) {
        super(Collections.emptyList());
        this.fitnessMachine = fitnessMachine;
        this.userData = userData;
        this.deviceInformation = deviceInformation;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @Deprecated
    public FitnessMachineProfileMockData(@NonNull Parcel in) {
        super(in);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            fitnessMachine = in.readParcelable(this.getClass().getClassLoader(), FitnessMachineServiceData.class);
            userData = in.readParcelable(this.getClass().getClassLoader(), UserDataServiceData.class);
            deviceInformation = in.readParcelable(this.getClass().getClassLoader(), ServiceData.class);
        } else {
            fitnessMachine = in.readParcelable(this.getClass().getClassLoader());
            userData = in.readParcelable(this.getClass().getClassLoader());
            deviceInformation = in.readParcelable(this.getClass().getClassLoader());
        }
    }

    /**
     * @return {@link #serviceDataList}
     */
    public List<ServiceData> getServiceDataList() {
        List<ServiceData> serviceDataList = new ArrayList<>();
        serviceDataList.add(fitnessMachine);
        if (userData != null) {
            serviceDataList.add(userData);
        }
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
        dest.writeParcelable(fitnessMachine, flags);
        dest.writeParcelable(userData, flags);
        dest.writeParcelable(deviceInformation, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(fitnessMachine)
                ^ Objects.hashCode(userData)
                ^ Objects.hashCode(deviceInformation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof FitnessMachineProfileMockData) {
            FitnessMachineProfileMockData target = (FitnessMachineProfileMockData) obj;
            result = super.equals(target)
                    && Objects.equals(fitnessMachine, target.fitnessMachine)
                    && Objects.equals(userData, target.userData)
                    && Objects.equals(deviceInformation, target.deviceInformation);
        }
        return result;
    }

}
