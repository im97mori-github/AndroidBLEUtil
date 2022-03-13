package org.im97mori.ble.profile.rcp.peripheral;

import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.service.bms.peripheral.BondManagementServiceData;
import org.im97mori.ble.service.rcs.peripheral.ReconnectionConfigurationServiceData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Cycling Power Profile Mock data class
 */
public class ReconnectionConfigurationProfileMockData extends MockData {

    /**
     * @see Creator
     */
    public static final Creator<ReconnectionConfigurationProfileMockData> CREATOR = new Creator<ReconnectionConfigurationProfileMockData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReconnectionConfigurationProfileMockData createFromParcel(@NonNull Parcel in) {
            return new ReconnectionConfigurationProfileMockData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReconnectionConfigurationProfileMockData[] newArray(int size) {
            return new ReconnectionConfigurationProfileMockData[size];
        }

    };

    /**
     * Cycling Power data
     */
    @SerializedName("cycling_power")
    public ReconnectionConfigurationServiceData reconnectionConfiguration;

    /**
     * Bond Management data
     */
    @SerializedName("bond_management")
    public BondManagementServiceData bondManagement;

    /**
     * Constructor
     */
    public ReconnectionConfigurationProfileMockData() {
    }

    /**
     * @param reconnectionConfiguration Reconnection Configuration Service data
     * @param bondManagement            Bond Management data
     */
    public ReconnectionConfigurationProfileMockData(@NonNull ReconnectionConfigurationServiceData reconnectionConfiguration
            , @Nullable BondManagementServiceData bondManagement) {
        super(Collections.emptyList());
        this.reconnectionConfiguration = reconnectionConfiguration;
        this.bondManagement = bondManagement;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public ReconnectionConfigurationProfileMockData(@NonNull Parcel in) {
        super(in);
        reconnectionConfiguration = in.readParcelable(this.getClass().getClassLoader());
        bondManagement = in.readParcelable(this.getClass().getClassLoader());
    }

    /**
     * @return {@link #serviceDataList}
     */
    public List<ServiceData> getServiceDataList() {
        List<ServiceData> serviceDataList = new ArrayList<>();
        serviceDataList.add(reconnectionConfiguration);
        if (bondManagement != null) {
            serviceDataList.add(bondManagement);
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
        dest.writeParcelable(reconnectionConfiguration, flags);
        dest.writeParcelable(bondManagement, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(reconnectionConfiguration)
                ^ Objects.hashCode(bondManagement);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof ReconnectionConfigurationProfileMockData) {
            ReconnectionConfigurationProfileMockData target = (ReconnectionConfigurationProfileMockData) obj;
            result = super.equals(target)
                    && Objects.equals(reconnectionConfiguration, target.reconnectionConfiguration)
                    && Objects.equals(bondManagement, target.bondManagement);
        }
        return result;
    }

}
