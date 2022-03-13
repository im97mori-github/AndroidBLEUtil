package org.im97mori.ble.service.rscs.peripheral;

import static org.im97mori.ble.constants.ServiceUUID.RUNNING_SPEED_AND_CADENCE_SERVICE;

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
 * Running Speed and Cadence Service data class
 */
public class RunningSpeedAndCadenceServiceData extends ServiceData {

    /**
     * @see Creator
     */
    public static final Creator<RunningSpeedAndCadenceServiceData> CREATOR = new Creator<RunningSpeedAndCadenceServiceData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RunningSpeedAndCadenceServiceData createFromParcel(@NonNull Parcel in) {
            return new RunningSpeedAndCadenceServiceData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RunningSpeedAndCadenceServiceData[] newArray(int size) {
            return new RunningSpeedAndCadenceServiceData[size];
        }

    };

    /**
     * RSC Feature data
     */
    @SerializedName("rsc_feature")
    public CharacteristicData rscFeature;

    /**
     * RSC Measurement data
     */
    @SerializedName("rsc_measurement")
    public CharacteristicData rscMeasurement;

    /**
     * Sensor Location data
     */
    @SerializedName("sensor_location")
    public CharacteristicData sensorLocation;

    /**
     * SC Control Point data
     */
    @SerializedName("sc_control_point")
    public SCControlPointCharacteristicData scControlPoint;

    /**
     * Constructor
     */
    public RunningSpeedAndCadenceServiceData() {
    }

    /**
     * @param rscFeature     RSC Feature data
     * @param rscMeasurement RSC Measurement data
     * @param sensorLocation Sensor Location data
     * @param scControlPoint SC Control Point data
     */
    public RunningSpeedAndCadenceServiceData(@NonNull CharacteristicData rscFeature
            , @NonNull CharacteristicData rscMeasurement
            , @Nullable CharacteristicData sensorLocation
            , @Nullable SCControlPointCharacteristicData scControlPoint) {
        super(RUNNING_SPEED_AND_CADENCE_SERVICE
                , BluetoothGattService.SERVICE_TYPE_PRIMARY
                , Collections.emptyList());
        this.rscFeature = rscFeature;
        this.rscMeasurement = rscMeasurement;
        this.sensorLocation = sensorLocation;
        this.scControlPoint = scControlPoint;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public RunningSpeedAndCadenceServiceData(@NonNull Parcel in) {
        super(in);
        rscFeature = in.readParcelable(this.getClass().getClassLoader());
        rscMeasurement = in.readParcelable(this.getClass().getClassLoader());
        sensorLocation = in.readParcelable(this.getClass().getClassLoader());
        scControlPoint = in.readParcelable(this.getClass().getClassLoader());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CharacteristicData> getCharacteristicDataList() {
        List<CharacteristicData> characteristicDataList = new ArrayList<>();
        characteristicDataList.add(rscFeature);
        characteristicDataList.add(rscMeasurement);
        if (sensorLocation != null) {
            characteristicDataList.add(sensorLocation);
        }
        if (scControlPoint != null) {
            characteristicDataList.add(scControlPoint);
        }
        return characteristicDataList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(rscFeature, flags);
        dest.writeParcelable(rscMeasurement, flags);
        dest.writeParcelable(sensorLocation, flags);
        dest.writeParcelable(scControlPoint, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(rscFeature)
                ^ Objects.hashCode(rscMeasurement)
                ^ Objects.hashCode(sensorLocation)
                ^ Objects.hashCode(scControlPoint);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof ServiceData) {
            RunningSpeedAndCadenceServiceData target = (RunningSpeedAndCadenceServiceData) obj;
            result = super.equals(target)
                    && Objects.equals(rscFeature, target.rscFeature)
                    && Objects.equals(rscMeasurement, target.rscMeasurement)
                    && Objects.equals(sensorLocation, target.sensorLocation)
                    && Objects.equals(scControlPoint, target.scControlPoint);
        }
        return result;
    }
}