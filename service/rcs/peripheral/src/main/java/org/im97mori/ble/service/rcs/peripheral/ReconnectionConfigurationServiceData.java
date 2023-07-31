package org.im97mori.ble.service.rcs.peripheral;

import static org.im97mori.ble.constants.ServiceUUID.RECONNECTION_CONFIGURATION_SERVICE;

import android.bluetooth.BluetoothGattService;
import android.os.Build;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.ServiceData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Reconnection Configuration Service data class
 */
public class ReconnectionConfigurationServiceData extends ServiceData {

    /**
     * @see Creator
     */
    public static final Creator<ReconnectionConfigurationServiceData> CREATOR = new Creator<ReconnectionConfigurationServiceData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        @Deprecated
        public ReconnectionConfigurationServiceData createFromParcel(@NonNull Parcel in) {
            //noinspection deprecation
            return new ReconnectionConfigurationServiceData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReconnectionConfigurationServiceData[] newArray(int size) {
            return new ReconnectionConfigurationServiceData[size];
        }

    };

    /**
     * RC Feature data
     */
    @SerializedName("rc_feature")
    public CharacteristicData rcFeature;

    /**
     * RC Settings data
     */
    @SerializedName("rc_settings")
    public CharacteristicData rcSettings;

    /**
     * Reconnection Configuration Control Point data
     */
    @SerializedName("reconnection_configuration_control_point")
    public ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPoint;

    /**
     * Constructor
     */
    public ReconnectionConfigurationServiceData() {
    }

    /**
     * @param rcFeatureData                         RC Feature data
     * @param rcSettingsData                        RC Settings data
     * @param reconnectionConfigurationControlPoint Reconnection Configuration Control Point data
     */
    public ReconnectionConfigurationServiceData(@NonNull CharacteristicData rcFeatureData
            , @Nullable CharacteristicData rcSettingsData
            , @Nullable ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPoint) {
        super(RECONNECTION_CONFIGURATION_SERVICE
                , BluetoothGattService.SERVICE_TYPE_PRIMARY
                , Collections.emptyList());
        rcFeature = rcFeatureData;
        rcSettings = rcSettingsData;
        this.reconnectionConfigurationControlPoint = reconnectionConfigurationControlPoint;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @Deprecated
    public ReconnectionConfigurationServiceData(@NonNull Parcel in) {
        super(in);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            rcFeature = in.readParcelable(this.getClass().getClassLoader(), CharacteristicData.class);
            rcSettings = in.readParcelable(this.getClass().getClassLoader(), CharacteristicData.class);
            reconnectionConfigurationControlPoint = in.readParcelable(this.getClass().getClassLoader(), ReconnectionConfigurationControlPointCharacteristicData.class);
        } else {
            rcFeature = in.readParcelable(this.getClass().getClassLoader());
            rcSettings = in.readParcelable(this.getClass().getClassLoader());
            reconnectionConfigurationControlPoint = in.readParcelable(this.getClass().getClassLoader());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CharacteristicData> getCharacteristicDataList() {
        List<CharacteristicData> characteristicDataList = new ArrayList<>();
        characteristicDataList.add(rcFeature);
        if (rcSettings != null) {
            characteristicDataList.add(rcSettings);
        }
        if (reconnectionConfigurationControlPoint != null) {
            characteristicDataList.add(reconnectionConfigurationControlPoint);
        }
        return characteristicDataList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(rcFeature, flags);
        dest.writeParcelable(rcSettings, flags);
        dest.writeParcelable(reconnectionConfigurationControlPoint, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(rcFeature)
                ^ Objects.hashCode(rcSettings)
                ^ Objects.hashCode(reconnectionConfigurationControlPoint);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof ServiceData) {
            ReconnectionConfigurationServiceData target = (ReconnectionConfigurationServiceData) obj;
            result = super.equals(target)
                    && Objects.equals(rcFeature, target.rcFeature)
                    && Objects.equals(rcSettings, target.rcSettings)
                    && Objects.equals(reconnectionConfigurationControlPoint, target.reconnectionConfigurationControlPoint);
        }
        return result;
    }
}