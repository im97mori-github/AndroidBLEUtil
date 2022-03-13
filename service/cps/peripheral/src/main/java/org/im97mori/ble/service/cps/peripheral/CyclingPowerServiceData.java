package org.im97mori.ble.service.cps.peripheral;

import static org.im97mori.ble.constants.ServiceUUID.CYCLING_POWER_SERVICE;

import android.bluetooth.BluetoothGattService;
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
 * Cycling Power Service data class
 */
public class CyclingPowerServiceData extends ServiceData {

    /**
     * @see Creator
     */
    public static final Creator<CyclingPowerServiceData> CREATOR = new Creator<CyclingPowerServiceData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerServiceData createFromParcel(@NonNull Parcel in) {
            return new CyclingPowerServiceData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerServiceData[] newArray(int size) {
            return new CyclingPowerServiceData[size];
        }

    };

    /**
     * Cycling Power Feature data
     */
    @SerializedName("cycling_power_feature")
    public CharacteristicData cyclingPowerFeature;

    /**
     * Cycling Power Measurement data
     */
    @SerializedName("cycling_power_measurement")
    public CharacteristicData cyclingPowerMeasurement;

    /**
     * Sensor Location data
     */
    @SerializedName("sensor_location")
    public CharacteristicData sensorLocation;

    /**
     * Cycling Power Control Point Characteristic data
     */
    @SerializedName("cycling_power_control_point")
    public CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint;

    /**
     * Cycling Power Vector data
     */
    @SerializedName("cycling_power_vector")
    public CharacteristicData cyclingPowerVector;

    /**
     * Constructor
     */
    public CyclingPowerServiceData() {
    }

    /**
     * @param cyclingPowerFeature      Cycling Power Feature data
     * @param cyclingPowerMeasurement  Cycling Power Measurement data
     * @param sensorLocation           Sensor Location data
     * @param cyclingPowerControlPoint Cycling Power Control Point Characteristic data
     * @param cyclingPowerVector       Cycling Power Vector data
     */
    public CyclingPowerServiceData(@NonNull CharacteristicData cyclingPowerFeature
            , @NonNull CharacteristicData cyclingPowerMeasurement
            , @NonNull CharacteristicData sensorLocation
            , @Nullable CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint
            , @Nullable CharacteristicData cyclingPowerVector) {
        super(CYCLING_POWER_SERVICE
                , BluetoothGattService.SERVICE_TYPE_PRIMARY
                , Collections.emptyList());
        this.cyclingPowerFeature = cyclingPowerFeature;
        this.cyclingPowerMeasurement = cyclingPowerMeasurement;
        this.sensorLocation = sensorLocation;
        this.cyclingPowerControlPoint = cyclingPowerControlPoint;
        this.cyclingPowerVector = cyclingPowerVector;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public CyclingPowerServiceData(@NonNull Parcel in) {
        super(in);
        cyclingPowerFeature = in.readParcelable(this.getClass().getClassLoader());
        cyclingPowerMeasurement = in.readParcelable(this.getClass().getClassLoader());
        sensorLocation = in.readParcelable(this.getClass().getClassLoader());
        cyclingPowerControlPoint = in.readParcelable(this.getClass().getClassLoader());
        cyclingPowerVector = in.readParcelable(this.getClass().getClassLoader());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CharacteristicData> getCharacteristicDataList() {
        List<CharacteristicData> characteristicDataList = new ArrayList<>();
        characteristicDataList.add(cyclingPowerFeature);
        characteristicDataList.add(cyclingPowerMeasurement);
        characteristicDataList.add(sensorLocation);
        if (cyclingPowerControlPoint != null) {
            characteristicDataList.add(cyclingPowerControlPoint);
        }
        if (cyclingPowerVector != null) {
            characteristicDataList.add(cyclingPowerVector);
        }
        return characteristicDataList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(cyclingPowerFeature, flags);
        dest.writeParcelable(cyclingPowerMeasurement, flags);
        dest.writeParcelable(sensorLocation, flags);
        dest.writeParcelable(cyclingPowerControlPoint, flags);
        dest.writeParcelable(cyclingPowerVector, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(cyclingPowerFeature)
                ^ Objects.hashCode(cyclingPowerMeasurement)
                ^ Objects.hashCode(sensorLocation)
                ^ Objects.hashCode(cyclingPowerControlPoint)
                ^ Objects.hashCode(cyclingPowerVector);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof ServiceData) {
            CyclingPowerServiceData target = (CyclingPowerServiceData) obj;
            result = super.equals(target)
                    && Objects.equals(cyclingPowerFeature, target.cyclingPowerFeature)
                    && Objects.equals(cyclingPowerMeasurement, target.cyclingPowerMeasurement)
                    && Objects.equals(sensorLocation, target.sensorLocation)
                    && Objects.equals(cyclingPowerControlPoint, target.cyclingPowerControlPoint)
                    && Objects.equals(cyclingPowerVector, target.cyclingPowerVector);
        }
        return result;
    }
}
