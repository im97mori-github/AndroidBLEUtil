package org.im97mori.ble;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Mock data class
 */
public class MockData {

    /**
     * {@link ServiceData} list
     */
    @SerializedName("service_data_list")
    public List<ServiceData> serviceDataList = new ArrayList<>();

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

}
