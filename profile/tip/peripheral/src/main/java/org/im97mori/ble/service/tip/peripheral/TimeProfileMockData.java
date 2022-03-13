package org.im97mori.ble.service.tip.peripheral;

import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Time Profile Mock data class
 */
public class TimeProfileMockData extends MockData {

    /**
     * @see Creator
     */
    public static final Creator<TimeProfileMockData> CREATOR = new Creator<TimeProfileMockData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeProfileMockData createFromParcel(@NonNull Parcel in) {
            return new TimeProfileMockData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeProfileMockData[] newArray(int size) {
            return new TimeProfileMockData[size];
        }

    };

    /**
     * Current Time data
     */
    @SerializedName("current_time")
    public CurrentTimeServiceData currentTime;

    /**
     * Next DST Change data
     */
    @SerializedName("next_dst_change")
    public ServiceData nextDstChange;

    /**
     * Reference Time Update data
     */
    @SerializedName("reference_time_update")
    public ServiceData referenceTimeUpdate;

    /**
     * Constructor
     */
    public TimeProfileMockData() {
    }

    /**
     * @param currentTime         Cycling Speed and Cadence data
     * @param nextDstChange       Next DST Change data
     * @param referenceTimeUpdate Reference Time Update data
     */
    public TimeProfileMockData(@NonNull CurrentTimeServiceData currentTime
            , @Nullable ServiceData nextDstChange
            , @Nullable ServiceData referenceTimeUpdate) {
        super(Collections.emptyList());
        this.currentTime = currentTime;
        this.nextDstChange = nextDstChange;
        this.referenceTimeUpdate = referenceTimeUpdate;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public TimeProfileMockData(@NonNull Parcel in) {
        super(in);
        currentTime = in.readParcelable(this.getClass().getClassLoader());
        nextDstChange = in.readParcelable(this.getClass().getClassLoader());
        referenceTimeUpdate = in.readParcelable(this.getClass().getClassLoader());
    }

    /**
     * @return {@link #serviceDataList}
     */
    public List<ServiceData> getServiceDataList() {
        List<ServiceData> serviceDataList = new ArrayList<>();
        serviceDataList.add(currentTime);
        if (nextDstChange != null) {
            serviceDataList.add(nextDstChange);
        }
        if (referenceTimeUpdate != null) {
            serviceDataList.add(referenceTimeUpdate);
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
        dest.writeParcelable(currentTime, flags);
        dest.writeParcelable(nextDstChange, flags);
        dest.writeParcelable(referenceTimeUpdate, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(currentTime)
                ^ Objects.hashCode(nextDstChange)
                ^ Objects.hashCode(referenceTimeUpdate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof TimeProfileMockData) {
            TimeProfileMockData target = (TimeProfileMockData) obj;
            result = super.equals(target)
                    && Objects.equals(currentTime, target.currentTime)
                    && Objects.equals(nextDstChange, target.nextDstChange)
                    && Objects.equals(referenceTimeUpdate, target.referenceTimeUpdate);
        }
        return result;
    }

}
