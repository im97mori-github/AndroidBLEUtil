package org.im97mori.ble.service.cscs.peripheral;

import static org.im97mori.ble.constants.ServiceUUID.CYCLING_SPEED_AND_CADENCE_SERVICE;

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
 * Cycling Speed and Cadence Service data class
 */
public class CyclingSpeedAndCadenceServiceData extends ServiceData {

    /**
     * @see Creator
     */
    public static final Creator<CyclingSpeedAndCadenceServiceData> CREATOR = new Creator<CyclingSpeedAndCadenceServiceData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        @Deprecated
        public CyclingSpeedAndCadenceServiceData createFromParcel(@NonNull Parcel in) {
            //noinspection deprecation
            return new CyclingSpeedAndCadenceServiceData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingSpeedAndCadenceServiceData[] newArray(int size) {
            return new CyclingSpeedAndCadenceServiceData[size];
        }

    };

    /**
     * CSC Measurement data
     */
    @SerializedName("csc_measurement")
    public CharacteristicData cscMeasurement;

    /**
     * CSC Feature data
     */
    @SerializedName("csc_feature")
    public CharacteristicData cscFeature;

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
    public CyclingSpeedAndCadenceServiceData() {
    }

    /**
     * @param cscMeasurement CSC Measurement data
     * @param cscFeature     CSC Feature data
     * @param sensorLocation Sensor Location data
     * @param scControlPoint SC Control Point data
     */
    public CyclingSpeedAndCadenceServiceData(@NonNull CharacteristicData cscMeasurement
            , @NonNull CharacteristicData cscFeature
            , @Nullable CharacteristicData sensorLocation
            , @Nullable SCControlPointCharacteristicData scControlPoint) {
        super(CYCLING_SPEED_AND_CADENCE_SERVICE
                , BluetoothGattService.SERVICE_TYPE_PRIMARY
                , Collections.emptyList());
        this.cscMeasurement = cscMeasurement;
        this.cscFeature = cscFeature;
        this.sensorLocation = sensorLocation;
        this.scControlPoint = scControlPoint;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @Deprecated
    public CyclingSpeedAndCadenceServiceData(@NonNull Parcel in) {
        super(in);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            cscMeasurement = in.readParcelable(this.getClass().getClassLoader(), CharacteristicData.class);
            cscFeature = in.readParcelable(this.getClass().getClassLoader(), CharacteristicData.class);
            sensorLocation = in.readParcelable(this.getClass().getClassLoader(), CharacteristicData.class);
            scControlPoint = in.readParcelable(this.getClass().getClassLoader(), SCControlPointCharacteristicData.class);
        } else {
            cscMeasurement = in.readParcelable(this.getClass().getClassLoader());
            cscFeature = in.readParcelable(this.getClass().getClassLoader());
            sensorLocation = in.readParcelable(this.getClass().getClassLoader());
            scControlPoint = in.readParcelable(this.getClass().getClassLoader());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CharacteristicData> getCharacteristicDataList() {
        List<CharacteristicData> characteristicDataList = new ArrayList<>();
        characteristicDataList.add(cscMeasurement);
        characteristicDataList.add(cscFeature);
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
        dest.writeParcelable(cscMeasurement, flags);
        dest.writeParcelable(cscFeature, flags);
        dest.writeParcelable(sensorLocation, flags);
        dest.writeParcelable(scControlPoint, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(cscMeasurement)
                ^ Objects.hashCode(cscFeature)
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
            CyclingSpeedAndCadenceServiceData target = (CyclingSpeedAndCadenceServiceData) obj;
            result = super.equals(target)
                    && Objects.equals(cscMeasurement, target.cscMeasurement)
                    && Objects.equals(cscFeature, target.cscFeature)
                    && Objects.equals(sensorLocation, target.sensorLocation)
                    && Objects.equals(scControlPoint, target.scControlPoint);
        }
        return result;
    }
}
