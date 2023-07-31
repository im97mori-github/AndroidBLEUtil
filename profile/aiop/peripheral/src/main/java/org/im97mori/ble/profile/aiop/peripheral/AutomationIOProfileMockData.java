package org.im97mori.ble.profile.aiop.peripheral;

import android.os.Build;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.service.aios.peripheral.AutomationIOServiceData;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Automation IO Profile Mock data class
 */
public class AutomationIOProfileMockData extends MockData {

    /**
     * @see Creator
     */
    public static final Creator<AutomationIOProfileMockData> CREATOR = new Creator<AutomationIOProfileMockData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        @Deprecated
        public AutomationIOProfileMockData createFromParcel(@NonNull Parcel in) {
            //noinspection deprecation
            return new AutomationIOProfileMockData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AutomationIOProfileMockData[] newArray(int size) {
            return new AutomationIOProfileMockData[size];
        }

    };

    @SerializedName("automation_io")
    public AutomationIOServiceData automationIO;

    /**
     * Constructor
     */
    public AutomationIOProfileMockData() {
    }

    /**
     * @param automationIOServiceData Automation IO Service data
     */
    public AutomationIOProfileMockData(@NonNull AutomationIOServiceData automationIOServiceData) {
        super(Collections.emptyList());
        this.automationIO = automationIOServiceData;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @Deprecated
    public AutomationIOProfileMockData(@NonNull Parcel in) {
        super(in);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            automationIO = in.readParcelable(this.getClass().getClassLoader(), AutomationIOServiceData.class);
        } else {
            automationIO = in.readParcelable(this.getClass().getClassLoader());
        }
    }

    /**
     * @return {@link #serviceDataList}
     */
    public List<ServiceData> getServiceDataList() {
        return Collections.singletonList(automationIO);
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
        dest.writeParcelable(automationIO, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(automationIO);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof AutomationIOProfileMockData) {
            AutomationIOProfileMockData target = (AutomationIOProfileMockData) obj;
            result = super.equals(target)
                    && Objects.equals(automationIO, target.automationIO);
        }
        return result;
    }

}
