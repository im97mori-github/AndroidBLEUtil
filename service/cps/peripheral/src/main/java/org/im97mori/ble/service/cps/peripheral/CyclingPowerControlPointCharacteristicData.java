package org.im97mori.ble.service.cps.peripheral;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.BLEPeripheralLogUtils;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.characteristic.u2a66.CyclingPowerControlPoint;

import java.util.Arrays;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;

/**
 * Cycling Power Control Point Characteristic data class
 */
@SuppressWarnings("CanBeFinal")
public class CyclingPowerControlPointCharacteristicData extends CharacteristicData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<CyclingPowerControlPointCharacteristicData> CREATOR = new Creator<CyclingPowerControlPointCharacteristicData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerControlPointCharacteristicData createFromParcel(@NonNull Parcel in) {
            return new CyclingPowerControlPointCharacteristicData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CyclingPowerControlPointCharacteristicData[] newArray(int size) {
            return new CyclingPowerControlPointCharacteristicData[size];
        }

    };

    /**
     * characteristic response code (Set Cumulative Value response)
     */
    @SerializedName("set_cumulative_value_response_value")
    public int setCumulativeValueResponseValue;

    /**
     * characteristic response code (Update Sensor Location response)
     */
    @SerializedName("update_sensor_location_response_value")
    public int updateSensorLocationResponseValue;

    /**
     * characteristic response code (Request Supported Sensor Locations response)
     */
    @SerializedName("request_supported_sensor_locations_response_value")
    public int requestSupportedSensorLocationsResponseValue;

    /**
     * part of characteristic data array (Request Supported Sensor Locations response)
     */
    @SerializedName("request_supported_sensor_locations_response_parameter")
    public byte[] requestSupportedSensorLocationsResponseParameter;

    /**
     * characteristic response code (Set Crank Length response)
     */
    @SerializedName("set_crank_length_response_value")
    public int setCrankLengthResponseValue;

    /**
     * characteristic response code (Request Crank Length response)
     */
    @SerializedName("request_crank_length_response_value")
    public int requestCrankLengthResponseValue;

    /**
     * characteristic response parameter (Request Crank Length response)
     */
    @SerializedName("request_crank_length_response_parameter")
    public byte[] requestCrankLengthResponseParameter;

    /**
     * characteristic response code (Set Chain Length response)
     */
    @SerializedName("set_chain_length_response_value")
    public int setChainLengthResponseValue;

    /**
     * characteristic response code (Request Chain Length response)
     */
    @SerializedName("request_chain_length_response_value")
    public int requestChainLengthResponseValue;

    /**
     * characteristic response parameter (Request Chain Length response)
     */
    @SerializedName("request_chain_length_response_parameter")
    public byte[] requestChainLengthResponseParameter;

    /**
     * characteristic response code (Set Chain Weight response)
     */
    @SerializedName("set_chain_weight_response_value")
    public int setChainWeightResponseValue;

    /**
     * characteristic response code (Request Chain Weight response)
     */
    @SerializedName("request_chain_weight_response_value")
    public int requestChainWeightResponseValue;

    /**
     * characteristic response parameter (Request Chain Weight response)
     */
    @SerializedName("request_chain_weight_response_parameter")
    public byte[] requestChainWeightResponseParameter;

    /**
     * characteristic response code (Set Span Length response)
     */
    @SerializedName("set_span_length_response_value")
    public int setSpanLengthResponseValue;

    /**
     * characteristic response code (Request Span Length response)
     */
    @SerializedName("request_span_length_response_value")
    public int requestSpanLengthResponseValue;

    /**
     * characteristic response parameter (Request Span Length response)
     */
    @SerializedName("request_span_length_response_parameter")
    public byte[] requestSpanLengthResponseParameter;

    /**
     * characteristic response code (Start Offset Compensation response)
     */
    @SerializedName("start_offset_compensation_response_value")
    public int startOffsetCompensationResponseValue;

    /**
     * characteristic response parameter (Start Offset Compensation response)
     */
    @SerializedName("start_offset_compensation_response_parameter")
    public byte[] startOffsetCompensationResponseParameter;

    /**
     * characteristic response code (Mask Cycling Power Measurement Characteristic Content response)
     */
    @SerializedName("mask_cycling_power_measurement_characteristic_content_response_value")
    public int maskCyclingPowerMeasurementCharacteristicContentResponseValue;

    /**
     * characteristic response code (Request Sampling Rate response)
     */
    @SerializedName("request_sampling_rate_response_value")
    public int requestSamplingRateResponseValue;

    /**
     * characteristic response parameter (Request Sampling Rate response)
     */
    @SerializedName("request_sampling_rate_response_parameter")
    public byte[] requestSamplingRateResponseParameter;

    /**
     * characteristic response code (Request Factory Calibration Date response)
     */
    @SerializedName("request_factory_calibration_date_response_value")
    public int requestFactoryCalibrationDateResponseValue;

    /**
     * part of characteristic data array (Request Factory Calibration Date response)
     */
    @SerializedName("request_factory_calibration_date_response_parameter")
    public byte[] requestFactoryCalibrationDateResponseParameter;

    /**
     * characteristic response code (Start Enhanced Offset Compensation response)
     */
    @SerializedName("start_enhanced_offset_compensation_response_value")
    public int startEnhancedOffsetCompensationResponseValue;

    /**
     * characteristic response parameter (Start Enhanced Offset Compensation response)
     */
    @SerializedName("start_enhanced_offset_compensation_response_parameter")
    public byte[] startEnhancedOffsetCompensationResponseParameter;

    /**
     * one shot response data
     */
    public transient byte[] highPriorityResponseData;

    /**
     * @param descriptorDataList                                            {@link DescriptorData} list
     * @param responseCode                                                  response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
     * @param delay                                                         response delay(millis)
     * @param setCumulativeValueResponseValue                               characteristic response code (Set Cumulative Value response)
     * @param updateSensorLocationResponseValue                             characteristic response code (Update Sensor Location response)
     * @param requestSupportedSensorLocationsResponseValue                  characteristic response code (Request Supported Sensor Locations response)
     * @param requestSupportedSensorLocationsResponseParameter              part of characteristic data array (Request Supported Sensor Locations response)
     * @param setCrankLengthResponseValue                                   characteristic response code (Set Crank Length response)
     * @param requestCrankLengthResponseValue                               characteristic response code (Request Crank Length response)
     * @param requestCrankLengthResponseParameter                           characteristic response parameter (Request Crank Length response)
     * @param setChainLengthResponseValue                                   characteristic response code (Set Chain Length response)
     * @param requestChainLengthResponseValue                               characteristic response code (Request Chain Length response)
     * @param requestChainLengthResponseParameter                           characteristic response parameter (Request Chain Length response)
     * @param setChainWeightResponseValue                                   characteristic response code (Set Chain Weight response)
     * @param requestChainWeightResponseValue                               characteristic response code (Request Chain Weight response)
     * @param requestChainWeightResponseParameter                           characteristic response parameter (Request Chain Weight response)
     * @param setSpanLengthResponseValue                                    characteristic response code (Set Span Length response)
     * @param requestSpanLengthResponseValue                                characteristic response code (Request Span Length response)
     * @param requestSpanLengthResponseParameter                            characteristic response parameter (Request Span Length response)
     * @param startOffsetCompensationResponseValue                          characteristic response code (Start Offset Compensation response)
     * @param startOffsetCompensationResponseParameter                      characteristic response parameter (Start Offset Compensation response)
     * @param maskCyclingPowerMeasurementCharacteristicContentResponseValue characteristic response code (Mask Cycling Power Measurement Characteristic Content response)
     * @param requestSamplingRateResponseValue                              characteristic response code (Request Sampling Rate response)
     * @param requestSamplingRateResponseParameter                          characteristic response parameter (Request Sampling Rate response)
     * @param requestFactoryCalibrationDateResponseValue                    characteristic response code (Request Factory Calibration Date response)
     * @param requestFactoryCalibrationDateResponseParameter                part of characteristic data array (Request Factory Calibration Date response)
     * @param startEnhancedOffsetCompensationResponseValue                  characteristic response code (Start Enhanced Offset Compensation response)
     * @param startEnhancedOffsetCompensationResponseParameter              characteristic response parameter (Start Enhanced Offset Compensation response)
     */
    public CyclingPowerControlPointCharacteristicData(@NonNull List<DescriptorData> descriptorDataList
            , int responseCode
            , long delay
            , int setCumulativeValueResponseValue
            , int updateSensorLocationResponseValue
            , int requestSupportedSensorLocationsResponseValue
            , @NonNull byte[] requestSupportedSensorLocationsResponseParameter
            , int setCrankLengthResponseValue
            , int requestCrankLengthResponseValue
            , @NonNull byte[] requestCrankLengthResponseParameter
            , int setChainLengthResponseValue
            , int requestChainLengthResponseValue
            , @NonNull byte[] requestChainLengthResponseParameter
            , int setChainWeightResponseValue
            , int requestChainWeightResponseValue
            , @NonNull byte[] requestChainWeightResponseParameter
            , int setSpanLengthResponseValue
            , int requestSpanLengthResponseValue
            , @NonNull byte[] requestSpanLengthResponseParameter
            , int startOffsetCompensationResponseValue
            , @NonNull byte[] startOffsetCompensationResponseParameter
            , int maskCyclingPowerMeasurementCharacteristicContentResponseValue
            , int requestSamplingRateResponseValue
            , @NonNull byte[] requestSamplingRateResponseParameter
            , int requestFactoryCalibrationDateResponseValue
            , @NonNull byte[] requestFactoryCalibrationDateResponseParameter
            , int startEnhancedOffsetCompensationResponseValue
            , @NonNull byte[] startEnhancedOffsetCompensationResponseParameter) {
        super(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC
                , BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE
                , BluetoothGattCharacteristic.PERMISSION_WRITE
                , descriptorDataList
                , responseCode
                , delay
                , null
                , 0);
        this.setCumulativeValueResponseValue = setCumulativeValueResponseValue;
        this.updateSensorLocationResponseValue = updateSensorLocationResponseValue;
        this.requestSupportedSensorLocationsResponseValue = requestSupportedSensorLocationsResponseValue;
        this.requestSupportedSensorLocationsResponseParameter = requestSupportedSensorLocationsResponseParameter;
        Arrays.sort(this.requestSupportedSensorLocationsResponseParameter);
        this.setCrankLengthResponseValue = setCrankLengthResponseValue;
        this.requestCrankLengthResponseValue = requestCrankLengthResponseValue;
        this.requestCrankLengthResponseParameter = requestCrankLengthResponseParameter;
        this.setChainLengthResponseValue = setChainLengthResponseValue;
        this.requestChainLengthResponseValue = requestChainLengthResponseValue;
        this.requestChainLengthResponseParameter = requestChainLengthResponseParameter;
        this.setChainWeightResponseValue = setChainWeightResponseValue;
        this.requestChainWeightResponseValue = requestChainWeightResponseValue;
        this.requestChainWeightResponseParameter = requestChainWeightResponseParameter;
        this.setSpanLengthResponseValue = setSpanLengthResponseValue;
        this.requestSpanLengthResponseValue = requestSpanLengthResponseValue;
        this.requestSpanLengthResponseParameter = requestSpanLengthResponseParameter;
        this.startOffsetCompensationResponseValue = startOffsetCompensationResponseValue;
        this.startOffsetCompensationResponseParameter = startOffsetCompensationResponseParameter;
        this.maskCyclingPowerMeasurementCharacteristicContentResponseValue = maskCyclingPowerMeasurementCharacteristicContentResponseValue;
        this.requestSamplingRateResponseValue = requestSamplingRateResponseValue;
        this.requestSamplingRateResponseParameter = requestSamplingRateResponseParameter;
        this.requestFactoryCalibrationDateResponseValue = requestFactoryCalibrationDateResponseValue;
        this.requestFactoryCalibrationDateResponseParameter = requestFactoryCalibrationDateResponseParameter;
        this.startEnhancedOffsetCompensationResponseValue = startEnhancedOffsetCompensationResponseValue;
        this.startEnhancedOffsetCompensationResponseParameter = startEnhancedOffsetCompensationResponseParameter;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public CyclingPowerControlPointCharacteristicData(@NonNull Parcel in) {
        super(in);
        setCumulativeValueResponseValue = in.readInt();
        updateSensorLocationResponseValue = in.readInt();
        requestSupportedSensorLocationsResponseValue = in.readInt();
        requestSupportedSensorLocationsResponseParameter = in.createByteArray();
        setCrankLengthResponseValue = in.readInt();
        requestCrankLengthResponseValue = in.readInt();
        requestCrankLengthResponseParameter = in.createByteArray();
        setChainLengthResponseValue = in.readInt();
        requestChainLengthResponseValue = in.readInt();
        requestChainLengthResponseParameter = in.createByteArray();
        setChainWeightResponseValue = in.readInt();
        requestChainWeightResponseValue = in.readInt();
        requestChainWeightResponseParameter = in.createByteArray();
        setSpanLengthResponseValue = in.readInt();
        requestSpanLengthResponseValue = in.readInt();
        requestSpanLengthResponseParameter = in.createByteArray();
        startOffsetCompensationResponseValue = in.readInt();
        startOffsetCompensationResponseParameter = in.createByteArray();
        maskCyclingPowerMeasurementCharacteristicContentResponseValue = in.readInt();
        requestSamplingRateResponseValue = in.readInt();
        requestSamplingRateResponseParameter = in.createByteArray();
        requestFactoryCalibrationDateResponseValue = in.readInt();
        requestFactoryCalibrationDateResponseParameter = in.createByteArray();
        startEnhancedOffsetCompensationResponseValue = in.readInt();
        startEnhancedOffsetCompensationResponseParameter = in.createByteArray();
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] result = null;
        if (highPriorityResponseData == null) {
            CyclingPowerControlPoint cyclingPowerControlPoint = null;
            try {
                if (currentData != null) {
                    cyclingPowerControlPoint = new CyclingPowerControlPoint(currentData);
                    if (cyclingPowerControlPoint.isOpCodesSetCumulativeValue(cyclingPowerControlPoint.getOpCodes())) {
                        result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, setCumulativeValueResponseValue, new byte[0]).getBytes();
                    } else if (cyclingPowerControlPoint.isOpCodesUpdateSensorLocation(cyclingPowerControlPoint.getOpCodes())) {
                        result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_UPDATE_SENSOR_LOCATION, updateSensorLocationResponseValue, new byte[0]).getBytes();
                    } else if (cyclingPowerControlPoint.isOpCodesRequestSupportedSensorLocations(cyclingPowerControlPoint.getOpCodes())) {
                        result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_REQUEST_SUPPORTED_SENSOR_LOCATION, requestSupportedSensorLocationsResponseValue, requestSupportedSensorLocationsResponseParameter).getBytes();
                    } else if (cyclingPowerControlPoint.isOpCodesSetCrankLength(cyclingPowerControlPoint.getOpCodes())) {
                        result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_SET_CRANK_LENGTH, setCrankLengthResponseValue, new byte[0]).getBytes();
                    } else if (cyclingPowerControlPoint.isOpCodesRequestCrankLength(cyclingPowerControlPoint.getOpCodes())) {
                        result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_REQUEST_CRANK_LENGTH, requestCrankLengthResponseValue, requestCrankLengthResponseParameter).getBytes();
                    } else if (cyclingPowerControlPoint.isOpCodesSetChainLength(cyclingPowerControlPoint.getOpCodes())) {
                        result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_SET_CHAIN_LENGTH, setChainLengthResponseValue, new byte[0]).getBytes();
                    } else if (cyclingPowerControlPoint.isOpCodesRequestChainLength(cyclingPowerControlPoint.getOpCodes())) {
                        result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_LENGTH, requestChainLengthResponseValue, requestChainLengthResponseParameter).getBytes();
                    } else if (cyclingPowerControlPoint.isOpCodesSetChainWeight(cyclingPowerControlPoint.getOpCodes())) {
                        result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_SET_CHAIN_WEIGHT, setChainWeightResponseValue, new byte[0]).getBytes();
                    } else if (cyclingPowerControlPoint.isOpCodesRequestChainWeight(cyclingPowerControlPoint.getOpCodes())) {
                        result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_REQUEST_CHAIN_WEIGHT, requestChainWeightResponseValue, requestChainWeightResponseParameter).getBytes();
                    } else if (cyclingPowerControlPoint.isOpCodesSetSpanLength(cyclingPowerControlPoint.getOpCodes())) {
                        result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_SET_SPAN_LENGTH, setSpanLengthResponseValue, new byte[0]).getBytes();
                    } else if (cyclingPowerControlPoint.isOpCodesRequestSpanLength(cyclingPowerControlPoint.getOpCodes())) {
                        result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_REQUEST_SPAN_LENGTH, requestSpanLengthResponseValue, requestSpanLengthResponseParameter).getBytes();
                    } else if (cyclingPowerControlPoint.isOpCodesStartOffsetCompensation(cyclingPowerControlPoint.getOpCodes())) {
                        result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_START_OFFSET_COMPENSATION, startOffsetCompensationResponseValue, startOffsetCompensationResponseParameter).getBytes();
                    } else if (cyclingPowerControlPoint.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(cyclingPowerControlPoint.getOpCodes())) {
                        result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT, maskCyclingPowerMeasurementCharacteristicContentResponseValue, new byte[0]).getBytes();
                    } else if (cyclingPowerControlPoint.isOpCodesRequestSamplingRate(cyclingPowerControlPoint.getOpCodes())) {
                        result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_REQUEST_SAMPLING_RATE, requestSamplingRateResponseValue, requestSamplingRateResponseParameter).getBytes();
                    } else if (cyclingPowerControlPoint.isOpCodesRequestFactoryCalibrationDate(cyclingPowerControlPoint.getOpCodes())) {
                        result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_REQUEST_FACTORY_CALIBRATION_DATE, requestFactoryCalibrationDateResponseValue, requestFactoryCalibrationDateResponseParameter).getBytes();
                    } else if (cyclingPowerControlPoint.isOpCodesStartEnhancedOffsetCompensation(cyclingPowerControlPoint.getOpCodes())) {
                        result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_START_ENHANCED_OFFSET_COMPENSATION, startEnhancedOffsetCompensationResponseValue, startEnhancedOffsetCompensationResponseParameter).getBytes();
                    }
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }

            if (result == null) {
                int opCodes;
                if (cyclingPowerControlPoint == null) {
                    opCodes = CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE;
                } else {
                    opCodes = cyclingPowerControlPoint.getOpCodes();
                }
                result = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], opCodes, CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
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
        dest.writeInt(setCumulativeValueResponseValue);
        dest.writeInt(updateSensorLocationResponseValue);
        dest.writeInt(requestSupportedSensorLocationsResponseValue);
        dest.writeByteArray(requestSupportedSensorLocationsResponseParameter);
        dest.writeInt(setCrankLengthResponseValue);
        dest.writeInt(requestCrankLengthResponseValue);
        dest.writeByteArray(requestCrankLengthResponseParameter);
        dest.writeInt(setChainLengthResponseValue);
        dest.writeInt(requestChainLengthResponseValue);
        dest.writeByteArray(requestChainLengthResponseParameter);
        dest.writeInt(setChainWeightResponseValue);
        dest.writeInt(requestChainWeightResponseValue);
        dest.writeByteArray(requestChainWeightResponseParameter);
        dest.writeInt(setSpanLengthResponseValue);
        dest.writeInt(requestSpanLengthResponseValue);
        dest.writeByteArray(requestSpanLengthResponseParameter);
        dest.writeInt(startOffsetCompensationResponseValue);
        dest.writeByteArray(startOffsetCompensationResponseParameter);
        dest.writeInt(maskCyclingPowerMeasurementCharacteristicContentResponseValue);
        dest.writeInt(requestSamplingRateResponseValue);
        dest.writeByteArray(requestSamplingRateResponseParameter);
        dest.writeInt(requestFactoryCalibrationDateResponseValue);
        dest.writeByteArray(requestFactoryCalibrationDateResponseParameter);
        dest.writeInt(startEnhancedOffsetCompensationResponseValue);
        dest.writeByteArray(startEnhancedOffsetCompensationResponseParameter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Integer.valueOf(setCumulativeValueResponseValue).hashCode()
                ^ Integer.valueOf(updateSensorLocationResponseValue).hashCode()
                ^ Integer.valueOf(requestSupportedSensorLocationsResponseValue).hashCode()
                ^ Arrays.hashCode(requestSupportedSensorLocationsResponseParameter)
                ^ Integer.valueOf(setCrankLengthResponseValue).hashCode()
                ^ Integer.valueOf(requestCrankLengthResponseValue).hashCode()
                ^ Arrays.hashCode(requestCrankLengthResponseParameter)
                ^ Integer.valueOf(setChainLengthResponseValue).hashCode()
                ^ Integer.valueOf(requestChainLengthResponseValue).hashCode()
                ^ Arrays.hashCode(requestChainLengthResponseParameter)
                ^ Integer.valueOf(setChainWeightResponseValue).hashCode()
                ^ Integer.valueOf(requestChainWeightResponseValue).hashCode()
                ^ Arrays.hashCode(requestChainWeightResponseParameter)
                ^ Integer.valueOf(setSpanLengthResponseValue).hashCode()
                ^ Integer.valueOf(requestSpanLengthResponseValue).hashCode()
                ^ Arrays.hashCode(requestSpanLengthResponseParameter)
                ^ Integer.valueOf(startOffsetCompensationResponseValue).hashCode()
                ^ Arrays.hashCode(startOffsetCompensationResponseParameter)
                ^ Integer.valueOf(maskCyclingPowerMeasurementCharacteristicContentResponseValue).hashCode()
                ^ Integer.valueOf(requestSamplingRateResponseValue).hashCode()
                ^ Arrays.hashCode(requestSamplingRateResponseParameter)
                ^ Integer.valueOf(requestFactoryCalibrationDateResponseValue).hashCode()
                ^ Arrays.hashCode(requestFactoryCalibrationDateResponseParameter)
                ^ Integer.valueOf(startEnhancedOffsetCompensationResponseValue).hashCode()
                ^ Arrays.hashCode(startEnhancedOffsetCompensationResponseParameter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof CyclingPowerControlPointCharacteristicData) {
            CyclingPowerControlPointCharacteristicData target = (CyclingPowerControlPointCharacteristicData) obj;
            result = super.equals(target)
                    && setCumulativeValueResponseValue == target.setCumulativeValueResponseValue
                    && updateSensorLocationResponseValue == target.updateSensorLocationResponseValue
                    && requestSupportedSensorLocationsResponseValue == target.requestSupportedSensorLocationsResponseValue
                    && Arrays.equals(requestSupportedSensorLocationsResponseParameter, target.requestSupportedSensorLocationsResponseParameter)
                    && setCrankLengthResponseValue == target.setCrankLengthResponseValue
                    && requestCrankLengthResponseValue == target.requestCrankLengthResponseValue
                    && Arrays.equals(requestCrankLengthResponseParameter, target.requestCrankLengthResponseParameter)
                    && setChainLengthResponseValue == target.setChainLengthResponseValue
                    && requestChainLengthResponseValue == target.requestChainLengthResponseValue
                    && Arrays.equals(requestChainLengthResponseParameter, target.requestChainLengthResponseParameter)
                    && setChainWeightResponseValue == target.setChainWeightResponseValue
                    && requestChainWeightResponseValue == target.requestChainWeightResponseValue
                    && Arrays.equals(requestChainWeightResponseParameter, target.requestChainWeightResponseParameter)
                    && setSpanLengthResponseValue == target.setSpanLengthResponseValue
                    && requestSpanLengthResponseValue == target.requestSpanLengthResponseValue
                    && Arrays.equals(requestSpanLengthResponseParameter, target.requestSpanLengthResponseParameter)
                    && startOffsetCompensationResponseValue == target.startOffsetCompensationResponseValue
                    && Arrays.equals(startOffsetCompensationResponseParameter, target.startOffsetCompensationResponseParameter)
                    && maskCyclingPowerMeasurementCharacteristicContentResponseValue == target.maskCyclingPowerMeasurementCharacteristicContentResponseValue
                    && requestSamplingRateResponseValue == target.requestSamplingRateResponseValue
                    && Arrays.equals(requestSamplingRateResponseParameter, target.requestSamplingRateResponseParameter)
                    && requestFactoryCalibrationDateResponseValue == target.requestFactoryCalibrationDateResponseValue
                    && Arrays.equals(requestFactoryCalibrationDateResponseParameter, target.requestFactoryCalibrationDateResponseParameter)
                    && startEnhancedOffsetCompensationResponseValue == target.startEnhancedOffsetCompensationResponseValue
                    && Arrays.equals(startEnhancedOffsetCompensationResponseParameter, target.startEnhancedOffsetCompensationResponseParameter);
        }
        return result;
    }

}
