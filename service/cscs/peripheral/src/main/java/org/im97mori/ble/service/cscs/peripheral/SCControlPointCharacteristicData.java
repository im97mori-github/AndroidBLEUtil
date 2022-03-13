package org.im97mori.ble.service.cscs.peripheral;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.BLEPeripheralLogUtils;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.characteristic.u2a55.SCControlPoint;

import java.util.Arrays;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.SC_CONTROL_POINT_CHARACTERISTIC;

/**
 * SC Control Point Characteristic data class
 */
@SuppressWarnings("CanBeFinal")
public class SCControlPointCharacteristicData extends CharacteristicData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<SCControlPointCharacteristicData> CREATOR = new Creator<SCControlPointCharacteristicData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SCControlPointCharacteristicData createFromParcel(@NonNull Parcel in) {
            return new SCControlPointCharacteristicData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SCControlPointCharacteristicData[] newArray(int size) {
            return new SCControlPointCharacteristicData[size];
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
     * one shot response data
     */
    public transient byte[] highPriorityResponseData;

    /**
     * Constructor
     */
    public SCControlPointCharacteristicData() {
    }

    /**
     * @param descriptorDataList                               {@link DescriptorData} list
     * @param responseCode                                     response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
     * @param delay                                            response delay(millis)
     * @param setCumulativeValueResponseValue                  characteristic response code (Set Cumulative Value response)
     * @param updateSensorLocationResponseValue                characteristic response code (Update Sensor Location response)
     * @param requestSupportedSensorLocationsResponseValue     characteristic response code (Request Supported Sensor Locations response)
     * @param requestSupportedSensorLocationsResponseParameter part of characteristic data array (Request Supported Sensor Locations response)
     */
    public SCControlPointCharacteristicData(@NonNull List<DescriptorData> descriptorDataList
            , int responseCode
            , long delay
            , int setCumulativeValueResponseValue
            , int updateSensorLocationResponseValue
            , int requestSupportedSensorLocationsResponseValue
            , @NonNull byte[] requestSupportedSensorLocationsResponseParameter) {
        super(SC_CONTROL_POINT_CHARACTERISTIC
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
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public SCControlPointCharacteristicData(@NonNull Parcel in) {
        super(in);
        setCumulativeValueResponseValue = in.readInt();
        updateSensorLocationResponseValue = in.readInt();
        requestSupportedSensorLocationsResponseValue = in.readInt();
        requestSupportedSensorLocationsResponseParameter = in.createByteArray();
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] result = null;
        if (highPriorityResponseData == null) {
            SCControlPoint scControlPoint = null;
            try {
                if (currentData != null) {
                    scControlPoint = new SCControlPoint(currentData);
                    if (scControlPoint.isOpCodeSetCumulativeValue(scControlPoint.getOpCode())) {
                        result = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, SCControlPoint.OP_CODE_SET_CUMULATIVE_VALUE, setCumulativeValueResponseValue, new byte[0]).getBytes();
                    } else if (scControlPoint.isOpCodeUpdateSensorLocation(scControlPoint.getOpCode())) {
                        result = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, SCControlPoint.OP_CODE_UPDATE_SENSOR_LOCATION, updateSensorLocationResponseValue, new byte[0]).getBytes();
                    } else if (scControlPoint.isOpCodeRequestSupportedSensorLocations(scControlPoint.getOpCode())) {
                        result = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS, requestSupportedSensorLocationsResponseValue, requestSupportedSensorLocationsResponseParameter).getBytes();
                    }
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }

            if (result == null) {
                int opCodes;
                if (scControlPoint == null) {
                    opCodes = SCControlPoint.OP_CODE_RESPONSE_CODE;
                } else {
                    opCodes = scControlPoint.getOpCode();
                }
                result = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, opCodes, SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
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
                ^ Arrays.hashCode(requestSupportedSensorLocationsResponseParameter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof SCControlPointCharacteristicData) {
            SCControlPointCharacteristicData target = (SCControlPointCharacteristicData) obj;
            result = super.equals(target)
                    && setCumulativeValueResponseValue == target.setCumulativeValueResponseValue
                    && updateSensorLocationResponseValue == target.updateSensorLocationResponseValue
                    && requestSupportedSensorLocationsResponseValue == target.requestSupportedSensorLocationsResponseValue
                    && Arrays.equals(requestSupportedSensorLocationsResponseParameter, target.requestSupportedSensorLocationsResponseParameter);
        }
        return result;
    }

}
