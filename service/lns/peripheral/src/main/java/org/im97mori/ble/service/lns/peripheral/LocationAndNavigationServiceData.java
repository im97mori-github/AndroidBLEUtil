package org.im97mori.ble.service.lns.peripheral;

import static org.im97mori.ble.constants.ServiceUUID.LOCATION_AND_NAVIGATION_SERVICE;

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
 * Location and Navigation Service data class
 */
public class LocationAndNavigationServiceData extends ServiceData {

    /**
     * @see Creator
     */
    public static final Creator<LocationAndNavigationServiceData> CREATOR = new Creator<LocationAndNavigationServiceData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        @Deprecated
        public LocationAndNavigationServiceData createFromParcel(@NonNull Parcel in) {
            //noinspection deprecation
            return new LocationAndNavigationServiceData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocationAndNavigationServiceData[] newArray(int size) {
            return new LocationAndNavigationServiceData[size];
        }

    };

    /**
     * LN Feature data
     */
    @SerializedName("ln_feature")
    public CharacteristicData lnFeature;

    /**
     * Location and Speed data
     */
    @SerializedName("location_and_speed")
    public CharacteristicData locationAndSpeed;

    /**
     * Position Quality data
     */
    @SerializedName("position_quality")
    public CharacteristicData positionQuality;

    /**
     * LN Control Point data
     */
    @SerializedName("ln_control_point")
    public LNControlPointCharacteristicData lnControlPoint;

    /**
     * Navigation data
     */
    @SerializedName("navigation")
    public CharacteristicData navigation;

    /**
     * Constructor
     */
    public LocationAndNavigationServiceData() {
    }

    /**
     * @param lnFeature        LN Feature data
     * @param locationAndSpeed Location and Speed data
     * @param positionQuality  Position Quality data
     * @param lnControlPoint   LN Control Point data
     * @param navigation       Navigation data
     */
    public LocationAndNavigationServiceData(@NonNull CharacteristicData lnFeature
            , @NonNull CharacteristicData locationAndSpeed
            , @Nullable CharacteristicData positionQuality
            , @Nullable LNControlPointCharacteristicData lnControlPoint
            , @Nullable CharacteristicData navigation) {
        super(LOCATION_AND_NAVIGATION_SERVICE
                , BluetoothGattService.SERVICE_TYPE_PRIMARY
                , Collections.emptyList());
        this.lnFeature = lnFeature;
        this.locationAndSpeed = locationAndSpeed;
        this.positionQuality = positionQuality;
        this.lnControlPoint = lnControlPoint;
        this.navigation = navigation;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @Deprecated
    public LocationAndNavigationServiceData(@NonNull Parcel in) {
        super(in);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            lnFeature = in.readParcelable(this.getClass().getClassLoader(), CharacteristicData.class);
            locationAndSpeed = in.readParcelable(this.getClass().getClassLoader(), CharacteristicData.class);
            positionQuality = in.readParcelable(this.getClass().getClassLoader(), CharacteristicData.class);
            lnControlPoint = in.readParcelable(this.getClass().getClassLoader(), LNControlPointCharacteristicData.class);
            navigation = in.readParcelable(this.getClass().getClassLoader(), CharacteristicData.class);
        } else {
            lnFeature = in.readParcelable(this.getClass().getClassLoader());
            locationAndSpeed = in.readParcelable(this.getClass().getClassLoader());
            positionQuality = in.readParcelable(this.getClass().getClassLoader());
            lnControlPoint = in.readParcelable(this.getClass().getClassLoader());
            navigation = in.readParcelable(this.getClass().getClassLoader());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CharacteristicData> getCharacteristicDataList() {
        List<CharacteristicData> characteristicDataList = new ArrayList<>();
        characteristicDataList.add(lnFeature);
        characteristicDataList.add(locationAndSpeed);
        if (positionQuality != null) {
            characteristicDataList.add(positionQuality);
        }
        if (lnControlPoint != null) {
            characteristicDataList.add(lnControlPoint);
        }
        if (navigation != null) {
            characteristicDataList.add(navigation);
        }
        return characteristicDataList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(lnFeature, flags);
        dest.writeParcelable(locationAndSpeed, flags);
        dest.writeParcelable(positionQuality, flags);
        dest.writeParcelable(lnControlPoint, flags);
        dest.writeParcelable(navigation, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(lnFeature)
                ^ Objects.hashCode(locationAndSpeed)
                ^ Objects.hashCode(positionQuality)
                ^ Objects.hashCode(lnControlPoint)
                ^ Objects.hashCode(navigation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof ServiceData) {
            LocationAndNavigationServiceData target = (LocationAndNavigationServiceData) obj;
            result = super.equals(target)
                    && Objects.equals(lnFeature, target.lnFeature)
                    && Objects.equals(locationAndSpeed, target.locationAndSpeed)
                    && Objects.equals(positionQuality, target.positionQuality)
                    && Objects.equals(lnControlPoint, target.lnControlPoint)
                    && Objects.equals(navigation, target.navigation);
        }
        return result;
    }
}