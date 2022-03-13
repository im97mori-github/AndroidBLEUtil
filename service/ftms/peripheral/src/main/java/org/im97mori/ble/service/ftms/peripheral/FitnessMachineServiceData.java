package org.im97mori.ble.service.ftms.peripheral;

import static org.im97mori.ble.constants.ServiceUUID.FITNESS_MACHINE_SERVICE;

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
 * Fitness Machine Service data class
 */
public class FitnessMachineServiceData extends ServiceData {

    /**
     * @see Creator
     */
    public static final Creator<FitnessMachineServiceData> CREATOR = new Creator<FitnessMachineServiceData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineServiceData createFromParcel(@NonNull Parcel in) {
            return new FitnessMachineServiceData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineServiceData[] newArray(int size) {
            return new FitnessMachineServiceData[size];
        }

    };

    /**
     * Fitness Machine Feature data
     */
    @SerializedName("fitness_machine_feature")
    public CharacteristicData fitnessMachineFeature;

    /**
     * Treadmill Data data
     */
    @SerializedName("treadmill_data")
    public CharacteristicData treadmillData;

    /**
     * Cross Trainer Data data
     */
    @SerializedName("cross_trainer_data")
    public CharacteristicData crossTrainerData;

    /**
     * Step Climber Data data
     */
    @SerializedName("step_climber_data")
    public CharacteristicData stepClimberData;

    /**
     * Stair Climber Data data
     */
    @SerializedName("stair_climber_data")
    public CharacteristicData stairClimberData;

    /**
     * Rower Data data
     */
    @SerializedName("rower_data")
    public CharacteristicData rowerData;

    /**
     * Indoor Bike Data data
     */
    @SerializedName("indoor_bike_data")
    public CharacteristicData indoorBikeData;

    /**
     * Training Status data
     */
    @SerializedName("training_status")
    public CharacteristicData trainingStatus;

    /**
     * Supported Speed Range data
     */
    @SerializedName("supported_speed_range")
    public CharacteristicData supportedSpeedRange;

    /**
     * Supported Inclination Range data
     */
    @SerializedName("supported_inclination_range")
    public CharacteristicData supportedInclinationRange;

    /**
     * Supported Resistance Level Range data
     */
    @SerializedName("supported_resistance_level_range")
    public CharacteristicData supportedResistanceLevelRange;

    /**
     * Supported Power Range data
     */
    @SerializedName("supported_power_range")
    public CharacteristicData supportedPowerRange;

    /**
     * Supported Heart Rate Range data
     */
    @SerializedName("supported_heart_rate_range")
    public CharacteristicData supportedHeartRateRange;

    /**
     * Fitness Machine Control Point data
     */
    @SerializedName("fitness_machine_control_point")
    public FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint;

    /**
     * Fitness Machine Status data
     */
    @SerializedName("fitness_machine_status")
    public FitnessMachineStatusCharacteristicData fitnessMachineStatus;

    /**
     * Constructor
     */
    public FitnessMachineServiceData() {
    }

    /**
     * @param fitnessMachineFeature         Fitness Machine Feature data
     * @param treadmillData                 Treadmill Data data
     * @param crossTrainerData              Cross Trainer Data data
     * @param stepClimberData               Step Climber Data data
     * @param stairClimberData              Stair Climber Data data
     * @param rowerData                     Rower Data data
     * @param indoorBikeData                Indoor Bike Data data
     * @param trainingStatus                Training Status data
     * @param supportedSpeedRange           Supported Speed Range data
     * @param supportedInclinationRange     Supported Inclination Range data
     * @param supportedResistanceLevelRange Supported Resistance Level Range data
     * @param supportedPowerRange           Supported Power Range data
     * @param supportedHeartRateRange       Supported Heart Rate Range data
     * @param fitnessMachineControlPoint    Fitness Machine Control Point data
     * @param fitnessMachineStatus          Fitness Machine Status data
     */
    public FitnessMachineServiceData(@NonNull CharacteristicData fitnessMachineFeature
            , @Nullable CharacteristicData treadmillData
            , @Nullable CharacteristicData crossTrainerData
            , @Nullable CharacteristicData stepClimberData
            , @Nullable CharacteristicData stairClimberData
            , @Nullable CharacteristicData rowerData
            , @Nullable CharacteristicData indoorBikeData
            , @Nullable CharacteristicData trainingStatus
            , @Nullable CharacteristicData supportedSpeedRange
            , @Nullable CharacteristicData supportedInclinationRange
            , @Nullable CharacteristicData supportedResistanceLevelRange
            , @Nullable CharacteristicData supportedPowerRange
            , @Nullable CharacteristicData supportedHeartRateRange
            , @Nullable FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint
            , @Nullable FitnessMachineStatusCharacteristicData fitnessMachineStatus) {
        super(FITNESS_MACHINE_SERVICE
                , BluetoothGattService.SERVICE_TYPE_PRIMARY
                , Collections.emptyList());
        this.fitnessMachineFeature = fitnessMachineFeature;
        this.treadmillData = treadmillData;
        this.crossTrainerData = crossTrainerData;
        this.stepClimberData = stepClimberData;
        this.stairClimberData = stairClimberData;
        this.rowerData = rowerData;
        this.indoorBikeData = indoorBikeData;
        this.trainingStatus = trainingStatus;
        this.supportedSpeedRange = supportedSpeedRange;
        this.supportedInclinationRange = supportedInclinationRange;
        this.supportedResistanceLevelRange = supportedResistanceLevelRange;
        this.supportedPowerRange = supportedPowerRange;
        this.supportedHeartRateRange = supportedHeartRateRange;
        this.fitnessMachineControlPoint = fitnessMachineControlPoint;
        this.fitnessMachineStatus = fitnessMachineStatus;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public FitnessMachineServiceData(@NonNull Parcel in) {
        super(in);
        fitnessMachineFeature = in.readParcelable(this.getClass().getClassLoader());
        treadmillData = in.readParcelable(this.getClass().getClassLoader());
        crossTrainerData = in.readParcelable(this.getClass().getClassLoader());
        stepClimberData = in.readParcelable(this.getClass().getClassLoader());
        stairClimberData = in.readParcelable(this.getClass().getClassLoader());
        rowerData = in.readParcelable(this.getClass().getClassLoader());
        indoorBikeData = in.readParcelable(this.getClass().getClassLoader());
        trainingStatus = in.readParcelable(this.getClass().getClassLoader());
        supportedSpeedRange = in.readParcelable(this.getClass().getClassLoader());
        supportedInclinationRange = in.readParcelable(this.getClass().getClassLoader());
        supportedResistanceLevelRange = in.readParcelable(this.getClass().getClassLoader());
        supportedPowerRange = in.readParcelable(this.getClass().getClassLoader());
        supportedHeartRateRange = in.readParcelable(this.getClass().getClassLoader());
        fitnessMachineControlPoint = in.readParcelable(this.getClass().getClassLoader());
        fitnessMachineStatus = in.readParcelable(this.getClass().getClassLoader());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CharacteristicData> getCharacteristicDataList() {
        List<CharacteristicData> characteristicDataList = new ArrayList<>();
        characteristicDataList.add(fitnessMachineFeature);
        if (treadmillData != null) {
            characteristicDataList.add(treadmillData);
        }
        if (crossTrainerData != null) {
            characteristicDataList.add(crossTrainerData);
        }
        if (stepClimberData != null) {
            characteristicDataList.add(stepClimberData);
        }
        if (stairClimberData != null) {
            characteristicDataList.add(stairClimberData);
        }
        if (rowerData != null) {
            characteristicDataList.add(rowerData);
        }
        if (indoorBikeData != null) {
            characteristicDataList.add(indoorBikeData);
        }
        if (trainingStatus != null) {
            characteristicDataList.add(trainingStatus);
        }
        if (supportedSpeedRange != null) {
            characteristicDataList.add(supportedSpeedRange);
        }
        if (supportedInclinationRange != null) {
            characteristicDataList.add(supportedInclinationRange);
        }
        if (supportedResistanceLevelRange != null) {
            characteristicDataList.add(supportedResistanceLevelRange);
        }
        if (supportedPowerRange != null) {
            characteristicDataList.add(supportedPowerRange);
        }
        if (supportedHeartRateRange != null) {
            characteristicDataList.add(supportedHeartRateRange);
        }
        if (fitnessMachineControlPoint != null) {
            characteristicDataList.add(fitnessMachineControlPoint);
        }
        if (fitnessMachineStatus != null) {
            characteristicDataList.add(fitnessMachineStatus);
        }
        return characteristicDataList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(fitnessMachineFeature, flags);
        dest.writeParcelable(treadmillData, flags);
        dest.writeParcelable(crossTrainerData, flags);
        dest.writeParcelable(stepClimberData, flags);
        dest.writeParcelable(stairClimberData, flags);
        dest.writeParcelable(rowerData, flags);
        dest.writeParcelable(indoorBikeData, flags);
        dest.writeParcelable(trainingStatus, flags);
        dest.writeParcelable(supportedSpeedRange, flags);
        dest.writeParcelable(supportedInclinationRange, flags);
        dest.writeParcelable(supportedResistanceLevelRange, flags);
        dest.writeParcelable(supportedPowerRange, flags);
        dest.writeParcelable(supportedHeartRateRange, flags);
        dest.writeParcelable(fitnessMachineControlPoint, flags);
        dest.writeParcelable(fitnessMachineStatus, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(fitnessMachineFeature)
                ^ Objects.hashCode(treadmillData)
                ^ Objects.hashCode(crossTrainerData)
                ^ Objects.hashCode(stepClimberData)
                ^ Objects.hashCode(stairClimberData)
                ^ Objects.hashCode(rowerData)
                ^ Objects.hashCode(indoorBikeData)
                ^ Objects.hashCode(trainingStatus)
                ^ Objects.hashCode(supportedSpeedRange)
                ^ Objects.hashCode(supportedInclinationRange)
                ^ Objects.hashCode(supportedResistanceLevelRange)
                ^ Objects.hashCode(supportedPowerRange)
                ^ Objects.hashCode(supportedHeartRateRange)
                ^ Objects.hashCode(fitnessMachineControlPoint)
                ^ Objects.hashCode(fitnessMachineStatus);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof ServiceData) {
            FitnessMachineServiceData target = (FitnessMachineServiceData) obj;
            result = super.equals(target)
                    && Objects.equals(fitnessMachineFeature, target.fitnessMachineFeature)
                    && Objects.equals(treadmillData, target.treadmillData)
                    && Objects.equals(crossTrainerData, target.crossTrainerData)
                    && Objects.equals(stepClimberData, target.stepClimberData)
                    && Objects.equals(stairClimberData, target.stairClimberData)
                    && Objects.equals(rowerData, target.rowerData)
                    && Objects.equals(indoorBikeData, target.indoorBikeData)
                    && Objects.equals(trainingStatus, target.trainingStatus)
                    && Objects.equals(supportedSpeedRange, target.supportedSpeedRange)
                    && Objects.equals(supportedInclinationRange, target.supportedInclinationRange)
                    && Objects.equals(supportedResistanceLevelRange, target.supportedResistanceLevelRange)
                    && Objects.equals(supportedPowerRange, target.supportedPowerRange)
                    && Objects.equals(supportedHeartRateRange, target.supportedHeartRateRange)
                    && Objects.equals(fitnessMachineControlPoint, target.fitnessMachineControlPoint)
                    && Objects.equals(fitnessMachineStatus, target.fitnessMachineStatus);
        }
        return result;
    }
}