package org.im97mori.ble;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Mock data class
 */
public class MockData implements Parcelable {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<MockData> CREATOR = new Creator<MockData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MockData createFromParcel(@NonNull Parcel in) {
            return new MockData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MockData[] newArray(int size) {
            return new MockData[size];
        }

    };

    /**
     * {@link MockData} list
     */
    @SerializedName("service_data_list")
    public List<ServiceData> serviceDataList;

    /**
     * Constructor
     */
    public MockData() {
    }

    /**
     * @param serviceDataList {@link ServiceData} list
     */
    public MockData(@NonNull List<ServiceData> serviceDataList) {
        this.serviceDataList = serviceDataList;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public MockData(@NonNull Parcel in) {
        serviceDataList = in.createTypedArrayList(ServiceData.CREATOR);
    }

    /**
     * @return {@link #serviceDataList}
     */
    public List<ServiceData> getServiceDataList() {
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
        ServiceData[] serviceDataArray = new ServiceData[serviceDataList.size()];
        dest.writeTypedArray(serviceDataList.toArray(serviceDataArray), flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(serviceDataList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof MockData) {
            MockData target = (MockData) obj;
            result = Objects.equals(serviceDataList, target.serviceDataList);
        }
        return result;
    }

}
