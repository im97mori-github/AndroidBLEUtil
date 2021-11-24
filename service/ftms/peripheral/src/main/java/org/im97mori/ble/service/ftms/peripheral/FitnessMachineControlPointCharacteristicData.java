package org.im97mori.ble.service.ftms.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.BLEPeripheralLogUtils;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.characteristic.u2ad9.FitnessMachineControlPoint;

import java.util.Arrays;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;

/**
 * Fitness Machine Control Point Characteristic data class
 */
@SuppressWarnings("CanBeFinal")
public class FitnessMachineControlPointCharacteristicData extends CharacteristicData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<FitnessMachineControlPointCharacteristicData> CREATOR = new Creator<FitnessMachineControlPointCharacteristicData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineControlPointCharacteristicData createFromParcel(@NonNull Parcel in) {
            return new FitnessMachineControlPointCharacteristicData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FitnessMachineControlPointCharacteristicData[] newArray(int size) {
            return new FitnessMachineControlPointCharacteristicData[size];
        }

    };

    /**
     * characteristic result code (Request Control result)
     */
    @SerializedName("request_control_result_code")
    public int requestControlResultCode;

    /**
     * characteristic result code (Reset result)
     */
    @SerializedName("reset_result_code")
    public int resetResultCode;

    /**
     * characteristic result code (Set Target Speed result)
     */
    @SerializedName("set_target_speed_result_code")
    public int setTargetSpeedResultCode;

    /**
     * characteristic result code (Set Target Inclination result)
     */
    @SerializedName("set_target_inclination_result_code")
    public int setTargetInclinationResultCode;

    /**
     * characteristic result code (Set Target Resistance Level result)
     */
    @SerializedName("set_target_resistance_level_result_code")
    public int setTargetResistanceLevelResultCode;

    /**
     * characteristic result code (Set Target Power result)
     */
    @SerializedName("set_target_power_result_code")
    public int setTargetPowerResultCode;

    /**
     * characteristic result code (Set Target Heart Rate result)
     */
    @SerializedName("set_target_heart_rate_result_code")
    public int setTargetHeartRateResultCode;

    /**
     * characteristic result code (Start or Resume result)
     */
    @SerializedName("start_or_resume_result_code")
    public int startOrResumeResultCode;

    /**
     * characteristic result code (Stop or Pause result)
     */
    @SerializedName("stop_or_pause_result_code")
    public int stopOrPauseResultCode;

    /**
     * characteristic result code (Set Targeted Expended Energy result)
     */
    @SerializedName("set_targeted_expended_energy_result_code")
    public int setTargetedExpendedEnergyResultCode;

    /**
     * characteristic result code (Set Targeted Number of Steps result)
     */
    @SerializedName("set_targeted_number_of_steps_result_code")
    public int setTargetedNumberOfStepsResultCode;

    /**
     * characteristic result code (Set Targeted Number of Strides result)
     */
    @SerializedName("set_targeted_number_of_strides_result_code")
    public int setTargetedNumberOfStridesResultCode;

    /**
     * characteristic result code (Set Targeted Distance result)
     */
    @SerializedName("set_targeted_distance_result_code")
    public int setTargetedDistanceResultCode;

    /**
     * characteristic result code (Set Targeted Training Time result)
     */
    @SerializedName("set_targeted_training_time_result_code")
    public int setTargetedTrainingTimeResultCode;

    /**
     * characteristic result code (Set Targeted Timein Two Heart Rate Zones result)
     */
    @SerializedName("set_targeted_time_in_two_heart_rate_zones_result_code")
    public int setTargetedTimeInTwoHeartRateZonesResultCode;

    /**
     * characteristic result code (Set Targeted Timein Three Heart Rate Zones result)
     */
    @SerializedName("set_targeted_time_in_three_heart_rate_zones_result_code")
    public int setTargetedTimeInThreeHeartRateZonesResultCode;

    /**
     * characteristic result code (Set Targeted Timein Five Heart Rate Zones result)
     */
    @SerializedName("set_targeted_time_in_five_heart_rate_zones_result_code")
    public int setTargetedTimeInFiveHeartRateZonesResultCode;

    /**
     * characteristic result code (Set Indoor Bike Simulation Parameters result)
     */
    @SerializedName("set_indoor_bike_simulation_parameters_result_code")
    public int setIndoorBikeSimulationParametersResultCode;

    /**
     * characteristic result code (Set Wheel Circumference result)
     */
    @SerializedName("set_wheel_circumference_result_code")
    public int setWheelCircumferenceResultCode;

    /**
     * characteristic result code (Spin Down Control result)
     */
    @SerializedName("spin_down_control_result_code")
    public int spinDownControlResultCode;

    /**
     * characteristic result data array (Spin Down Control result)
     */
    @SerializedName("spin_down_control_result_parameter")
    public byte[] spinDownControlResultParameter;

    /**
     * characteristic result code (Set Targeted Cadence result)
     */
    @SerializedName("set_targeted_Cadence_result_code")
    public int setTargetedCadenceResultCode;

    /**
     * one shot response data
     */
    public transient byte[] highPriorityResponseData;

    /**
     * @param descriptorDataList                             {@link DescriptorData} list
     * @param delay                                          response delay(millis)
     * @param requestControlResultCode                       characteristic result code (Request Control result)
     * @param resetResultCode                                characteristic result code (Reset result)
     * @param setTargetSpeedResultCode                       characteristic result code (Set Target Speed result)
     * @param setTargetInclinationResultCode                 characteristic result code (Set Target Inclination result)
     * @param setTargetResistanceLevelResultCode             characteristic result code (Set Target Power result)
     * @param setTargetPowerResultCode                       characteristic result code (Set Target Power result)
     * @param setTargetHeartRateResultCode                   characteristic result code (Set Target Heart Rate result)
     * @param startOrResumeResultCode                        characteristic result code (Start or Resume result)
     * @param stopOrPauseResultCode                          characteristic result code (Stop or Pause result)
     * @param setTargetedExpendedEnergyResultCode            characteristic result code (Set Targeted Expended Energy result)
     * @param setTargetedNumberOfStepsResultCode             characteristic result code (Set Targeted Number of Steps result)
     * @param setTargetedNumberOfStridesResultCode           characteristic result code (Set Targeted Number of Strides result)
     * @param setTargetedDistanceResultCode                  characteristic result code (Set Targeted Distance result)
     * @param setTargetedTrainingTimeResultCode              characteristic result code (Set Targeted Training Time result)
     * @param setTargetedTimeInTwoHeartRateZonesResultCode   characteristic result code (Set Targeted Timein Two Heart Rate Zones result)
     * @param setTargetedTimeInThreeHeartRateZonesResultCode characteristic result code (Set Targeted Timein Three Heart Rate Zones result)
     * @param setTargetedTimeInFiveHeartRateZonesResultCode  characteristic result code (Set Targeted Timein Five Heart Rate Zones result)
     * @param setIndoorBikeSimulationParametersResultCode    characteristic result code (Set Indoor Bike Simulation Parameters result)
     * @param setWheelCircumferenceResultCode                characteristic result code (Set Wheel Circumference result)
     * @param spinDownControlResultCode                      characteristic result code (Spin Down Control result)
     * @param spinDownControlResultParameter                 characteristic result data array (Spin Down Control result)
     * @param setTargetedCadenceResultCode                   characteristic result code (Set Targeted Cadence result)
     */
    public FitnessMachineControlPointCharacteristicData(@NonNull List<DescriptorData> descriptorDataList
            , long delay
            , int requestControlResultCode
            , int resetResultCode
            , int setTargetSpeedResultCode
            , int setTargetInclinationResultCode
            , int setTargetResistanceLevelResultCode
            , int setTargetPowerResultCode
            , int setTargetHeartRateResultCode
            , int startOrResumeResultCode
            , int stopOrPauseResultCode
            , int setTargetedExpendedEnergyResultCode
            , int setTargetedNumberOfStepsResultCode
            , int setTargetedNumberOfStridesResultCode
            , int setTargetedDistanceResultCode
            , int setTargetedTrainingTimeResultCode
            , int setTargetedTimeInTwoHeartRateZonesResultCode
            , int setTargetedTimeInThreeHeartRateZonesResultCode
            , int setTargetedTimeInFiveHeartRateZonesResultCode
            , int setIndoorBikeSimulationParametersResultCode
            , int setWheelCircumferenceResultCode
            , int spinDownControlResultCode
            , @NonNull byte[] spinDownControlResultParameter
            , int setTargetedCadenceResultCode) {
        super(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC
                , BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE
                , BluetoothGattCharacteristic.PERMISSION_WRITE
                , descriptorDataList
                , BluetoothGatt.GATT_SUCCESS
                , delay
                , null
                , 0);
        this.requestControlResultCode = requestControlResultCode;
        this.resetResultCode = resetResultCode;
        this.setTargetSpeedResultCode = setTargetSpeedResultCode;
        this.setTargetInclinationResultCode = setTargetInclinationResultCode;
        this.setTargetResistanceLevelResultCode = setTargetResistanceLevelResultCode;
        this.setTargetPowerResultCode = setTargetPowerResultCode;
        this.setTargetHeartRateResultCode = setTargetHeartRateResultCode;
        this.startOrResumeResultCode = startOrResumeResultCode;
        this.stopOrPauseResultCode = stopOrPauseResultCode;
        this.setTargetedExpendedEnergyResultCode = setTargetedExpendedEnergyResultCode;
        this.setTargetedNumberOfStepsResultCode = setTargetedNumberOfStepsResultCode;
        this.setTargetedNumberOfStridesResultCode = setTargetedNumberOfStridesResultCode;
        this.setTargetedDistanceResultCode = setTargetedDistanceResultCode;
        this.setTargetedTrainingTimeResultCode = setTargetedTrainingTimeResultCode;
        this.setTargetedTimeInTwoHeartRateZonesResultCode = setTargetedTimeInTwoHeartRateZonesResultCode;
        this.setTargetedTimeInThreeHeartRateZonesResultCode = setTargetedTimeInThreeHeartRateZonesResultCode;
        this.setTargetedTimeInFiveHeartRateZonesResultCode = setTargetedTimeInFiveHeartRateZonesResultCode;
        this.setIndoorBikeSimulationParametersResultCode = setIndoorBikeSimulationParametersResultCode;
        this.setWheelCircumferenceResultCode = setWheelCircumferenceResultCode;
        this.spinDownControlResultCode = spinDownControlResultCode;
        this.spinDownControlResultParameter = spinDownControlResultParameter;
        this.setTargetedCadenceResultCode = setTargetedCadenceResultCode;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public FitnessMachineControlPointCharacteristicData(@NonNull Parcel in) {
        super(in);
        requestControlResultCode = in.readInt();
        resetResultCode = in.readInt();
        setTargetSpeedResultCode = in.readInt();
        setTargetInclinationResultCode = in.readInt();
        setTargetResistanceLevelResultCode = in.readInt();
        setTargetPowerResultCode = in.readInt();
        setTargetHeartRateResultCode = in.readInt();
        startOrResumeResultCode = in.readInt();
        stopOrPauseResultCode = in.readInt();
        setTargetedExpendedEnergyResultCode = in.readInt();
        setTargetedNumberOfStepsResultCode = in.readInt();
        setTargetedNumberOfStridesResultCode = in.readInt();
        setTargetedDistanceResultCode = in.readInt();
        setTargetedTrainingTimeResultCode = in.readInt();
        setTargetedTimeInTwoHeartRateZonesResultCode = in.readInt();
        setTargetedTimeInThreeHeartRateZonesResultCode = in.readInt();
        setTargetedTimeInFiveHeartRateZonesResultCode = in.readInt();
        setIndoorBikeSimulationParametersResultCode = in.readInt();
        setWheelCircumferenceResultCode = in.readInt();
        spinDownControlResultCode = in.readInt();
        spinDownControlResultParameter = in.createByteArray();
        setTargetedCadenceResultCode = in.readInt();
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] result = null;
        if (highPriorityResponseData == null) {
            FitnessMachineControlPoint fitnessMachineControlPoint = null;
            try {
                if (currentData != null) {
                    fitnessMachineControlPoint = new FitnessMachineControlPoint(currentData);
                    if (fitnessMachineControlPoint.isOpCodeRequestControl(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_REQUEST_CONTROL, requestControlResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeReset(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_RESET, resetResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSetTargetSpeed(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED, setTargetSpeedResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSetTargetInclination(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION, setTargetInclinationResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSetTargetResistanceLevel(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL, setTargetResistanceLevelResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSetTargetPower(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER, setTargetPowerResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSetTargetHeartRate(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE, setTargetHeartRateResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeStartOrResume(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_START_OR_RESUME, startOrResumeResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeStopOrPause(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE, stopOrPauseResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSetTargetedExpendedEnergy(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_EXPENDED_ENERGY, setTargetedExpendedEnergyResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSetTargetedNumberOfSteps(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STEPS, setTargetedNumberOfStepsResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSetTargetedNumberOfStrides(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES, setTargetedNumberOfStridesResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSetTargetedDistance(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_DISTANCE, setTargetedDistanceResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSetTargetedTrainingTime(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TRAINING_TIME, setTargetedTrainingTimeResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSetTargetedTimeInTwoHeartRateZones(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES, setTargetedTimeInTwoHeartRateZonesResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSetTargetedTimeInThreeHeartRateZones(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES, setTargetedTimeInThreeHeartRateZonesResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSetTargetedTimeInFiveHeartRateZones(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES, setTargetedTimeInFiveHeartRateZonesResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSetIndoorBikeSimulationParameters(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES, setIndoorBikeSimulationParametersResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSetWheelCircumference(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_WHEEL_CICUMFERENCE, setWheelCircumferenceResultCode, new byte[0]).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSpinDownControl(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL, spinDownControlResultCode, spinDownControlResultParameter).getBytes();
                    } else if (fitnessMachineControlPoint.isOpCodeSetTargetedCadence(fitnessMachineControlPoint.getOpCode())) {
                        result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_CADENCE, setTargetedCadenceResultCode, new byte[0]).getBytes();
                    }
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }

            if (result == null) {
                int opCodes;
                if (fitnessMachineControlPoint == null) {
                    opCodes = FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE;
                } else {
                    opCodes = fitnessMachineControlPoint.getOpCode();
                }
                result = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], opCodes, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
            }
        } else {
            result = highPriorityResponseData;
            highPriorityResponseData = null;
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(requestControlResultCode);
        dest.writeInt(resetResultCode);
        dest.writeInt(setTargetSpeedResultCode);
        dest.writeInt(setTargetInclinationResultCode);
        dest.writeInt(setTargetResistanceLevelResultCode);
        dest.writeInt(setTargetPowerResultCode);
        dest.writeInt(setTargetHeartRateResultCode);
        dest.writeInt(startOrResumeResultCode);
        dest.writeInt(stopOrPauseResultCode);
        dest.writeInt(setTargetedExpendedEnergyResultCode);
        dest.writeInt(setTargetedNumberOfStepsResultCode);
        dest.writeInt(setTargetedNumberOfStridesResultCode);
        dest.writeInt(setTargetedDistanceResultCode);
        dest.writeInt(setTargetedTrainingTimeResultCode);
        dest.writeInt(setTargetedTimeInTwoHeartRateZonesResultCode);
        dest.writeInt(setTargetedTimeInThreeHeartRateZonesResultCode);
        dest.writeInt(setTargetedTimeInFiveHeartRateZonesResultCode);
        dest.writeInt(setIndoorBikeSimulationParametersResultCode);
        dest.writeInt(setWheelCircumferenceResultCode);
        dest.writeInt(spinDownControlResultCode);
        dest.writeByteArray(spinDownControlResultParameter);
        dest.writeInt(setTargetedCadenceResultCode);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Integer.valueOf(requestControlResultCode).hashCode()
                ^ Integer.valueOf(resetResultCode).hashCode()
                ^ Integer.valueOf(setTargetSpeedResultCode).hashCode()
                ^ Integer.valueOf(setTargetInclinationResultCode).hashCode()
                ^ Integer.valueOf(setTargetResistanceLevelResultCode).hashCode()
                ^ Integer.valueOf(setTargetPowerResultCode).hashCode()
                ^ Integer.valueOf(setTargetHeartRateResultCode).hashCode()
                ^ Integer.valueOf(startOrResumeResultCode).hashCode()
                ^ Integer.valueOf(stopOrPauseResultCode).hashCode()
                ^ Integer.valueOf(setTargetedExpendedEnergyResultCode).hashCode()
                ^ Integer.valueOf(setTargetedNumberOfStepsResultCode).hashCode()
                ^ Integer.valueOf(setTargetedNumberOfStridesResultCode).hashCode()
                ^ Integer.valueOf(setTargetedDistanceResultCode).hashCode()
                ^ Integer.valueOf(setTargetedTrainingTimeResultCode).hashCode()
                ^ Integer.valueOf(setTargetedTimeInTwoHeartRateZonesResultCode).hashCode()
                ^ Integer.valueOf(setTargetedTimeInThreeHeartRateZonesResultCode).hashCode()
                ^ Integer.valueOf(setTargetedTimeInFiveHeartRateZonesResultCode).hashCode()
                ^ Integer.valueOf(setIndoorBikeSimulationParametersResultCode).hashCode()
                ^ Integer.valueOf(setWheelCircumferenceResultCode).hashCode()
                ^ Integer.valueOf(spinDownControlResultCode).hashCode()
                ^ Arrays.hashCode(spinDownControlResultParameter)
                ^ Integer.valueOf(setTargetedCadenceResultCode).hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof FitnessMachineControlPointCharacteristicData) {
            FitnessMachineControlPointCharacteristicData target = (FitnessMachineControlPointCharacteristicData) obj;
            result = super.equals(target)
                    && requestControlResultCode == target.requestControlResultCode
                    && resetResultCode == target.resetResultCode
                    && setTargetSpeedResultCode == target.setTargetSpeedResultCode
                    && setTargetInclinationResultCode == target.setTargetInclinationResultCode
                    && setTargetResistanceLevelResultCode == target.setTargetResistanceLevelResultCode
                    && setTargetPowerResultCode == target.setTargetPowerResultCode
                    && setTargetHeartRateResultCode == target.setTargetHeartRateResultCode
                    && startOrResumeResultCode == target.startOrResumeResultCode
                    && stopOrPauseResultCode == target.stopOrPauseResultCode
                    && setTargetedExpendedEnergyResultCode == target.setTargetedExpendedEnergyResultCode
                    && setTargetedNumberOfStepsResultCode == target.setTargetedNumberOfStepsResultCode
                    && setTargetedNumberOfStridesResultCode == target.setTargetedNumberOfStridesResultCode
                    && setTargetedDistanceResultCode == target.setTargetedDistanceResultCode
                    && setTargetedTrainingTimeResultCode == target.setTargetedTrainingTimeResultCode
                    && setTargetedTimeInTwoHeartRateZonesResultCode == target.setTargetedTimeInTwoHeartRateZonesResultCode
                    && setTargetedTimeInThreeHeartRateZonesResultCode == target.setTargetedTimeInThreeHeartRateZonesResultCode
                    && setTargetedTimeInFiveHeartRateZonesResultCode == target.setTargetedTimeInFiveHeartRateZonesResultCode
                    && setIndoorBikeSimulationParametersResultCode == target.setIndoorBikeSimulationParametersResultCode
                    && setWheelCircumferenceResultCode == target.setWheelCircumferenceResultCode
                    && spinDownControlResultCode == target.spinDownControlResultCode
                    && Arrays.equals(spinDownControlResultParameter, target.spinDownControlResultParameter)
                    && setTargetedCadenceResultCode == target.setTargetedCadenceResultCode;
        }
        return result;
    }

}
