package org.im97mori.ble.service.lns.peripheral;

import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.BLEPeripheralLogUtils;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.characteristic.u2a6b.LNControlPoint;

import java.util.Arrays;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.LN_CONTROL_POINT_CHARACTERISTIC;

/**
 * LN Control Point Characteristic data class
 */
@SuppressWarnings("CanBeFinal")
public class LNControlPointCharacteristicData extends CharacteristicData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<LNControlPointCharacteristicData> CREATOR = new Creator<LNControlPointCharacteristicData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LNControlPointCharacteristicData createFromParcel(@NonNull Parcel in) {
            return new LNControlPointCharacteristicData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LNControlPointCharacteristicData[] newArray(int size) {
            return new LNControlPointCharacteristicData[size];
        }

    };

    /**
     * characteristic response code (Set Cumulative Value response)
     */
    @SerializedName("set_cumulative_value_response_value")
    public int setCumulativeValueResponseValue;

    /**
     * characteristic response code (Mask Location and Speed Characteristic Content response)
     */
    @SerializedName("mask_location_and_speed_characteristic_content_response_value")
    public int maskLocationAndSpeedCharacteristicContentResponseValue;

    /**
     * characteristic response code (Navigation Control response)
     */
    @SerializedName("navigation_control_response_value")
    public int navigationControlResponseValue;

    /**
     * characteristic response code (Request Number of Routes response)
     */
    @SerializedName("request_number_of_routes_response_value")
    public int requestNumberOfRoutesResponseValue;

    /**
     * part of characteristic data array (Number of Routes)
     */
    @SerializedName("request_number_of_routes_response_parameter")
    public byte[] requestNumberOfRoutesResponseParameter;

    /**
     * characteristic response code (Request Name of Route response)
     */
    @SerializedName("request_name_of_route_response_value")
    public int requestNameOfRouteResponseValue;

    /**
     * part of characteristic data array (Name of Route)
     */
    @SerializedName("request_name_of_route_response_parameter")
    public byte[] requestNameOfRouteResponseParameter;

    /**
     * characteristic response code (Select Route response)
     */
    @SerializedName("select_route_response_value")
    public int selectRouteResponseValue;

    /**
     * characteristic response code (Set Fix Rate response)
     */
    @SerializedName("set_fix_rate_response_value")
    public int setFixRateResponseValue;

    /**
     * characteristic response code (Set Elevation response)
     */
    @SerializedName("set_elevation_response_value")
    public int setElevationResponseValue;

    /**
     * Constructor
     */
    public LNControlPointCharacteristicData() {
    }

    /**
     * @param property                                               combination of
     *                                                               {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
     *                                                               {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_WRITE_NO_RESPONSE}
     *                                                               {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_WRITE}
     *                                                               {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
     *                                                               {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_INDICATE}
     * @param permission                                             combination of
     *                                                               {@link android.bluetooth.BluetoothGattCharacteristic#PERMISSION_READ}
     *                                                               {@link android.bluetooth.BluetoothGattCharacteristic#PERMISSION_WRITE}
     * @param descriptorDataList                                     {@link DescriptorData} list
     * @param responseCode                                           response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
     * @param delay                                                  response delay(millis)
     * @param setCumulativeValueResponseValue                        characteristic response code (Set Cumulative Value response)
     * @param maskLocationAndSpeedCharacteristicContentResponseValue characteristic response code (Mask Location and Speed Characteristic Content response)
     * @param navigationControlResponseValue                         characteristic response code (Navigation Control response)
     * @param requestNumberOfRoutesResponseValue                     characteristic response code (Request Number of Routes response)
     * @param requestNumberOfRoutesResponseParameter                 part of characteristic data array (Number of Routes)
     * @param requestNameOfRouteResponseValue                        characteristic response code (Request Name of Route response)
     * @param requestNameOfRouteResponseParameter                    part of characteristic data array (Name of Route)
     * @param selectRouteResponseValue                               characteristic response code (Select Route response)
     * @param setFixRateResponseValue                                characteristic response code (Set Fix Rate response)
     * @param setElevationResponseValue                              characteristic response code (Set Elevation response)
     */
    public LNControlPointCharacteristicData(int property
            , int permission
            , @NonNull List<DescriptorData> descriptorDataList
            , int responseCode
            , long delay
            , int setCumulativeValueResponseValue
            , int maskLocationAndSpeedCharacteristicContentResponseValue
            , int navigationControlResponseValue
            , int requestNumberOfRoutesResponseValue
            , @NonNull byte[] requestNumberOfRoutesResponseParameter
            , int requestNameOfRouteResponseValue
            , @NonNull byte[] requestNameOfRouteResponseParameter
            , int selectRouteResponseValue
            , int setFixRateResponseValue
            , int setElevationResponseValue) {
        super(LN_CONTROL_POINT_CHARACTERISTIC
                , property
                , permission
                , descriptorDataList
                , responseCode
                , delay
                , new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_RESPONSE_CODE, LNControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes()
                , 0);
        this.setCumulativeValueResponseValue = setCumulativeValueResponseValue;
        this.maskLocationAndSpeedCharacteristicContentResponseValue = maskLocationAndSpeedCharacteristicContentResponseValue;
        this.navigationControlResponseValue = navigationControlResponseValue;
        this.requestNumberOfRoutesResponseValue = requestNumberOfRoutesResponseValue;
        this.requestNumberOfRoutesResponseParameter = requestNumberOfRoutesResponseParameter;
        this.requestNameOfRouteResponseValue = requestNameOfRouteResponseValue;
        this.requestNameOfRouteResponseParameter = requestNameOfRouteResponseParameter;
        this.selectRouteResponseValue = selectRouteResponseValue;
        this.setFixRateResponseValue = setFixRateResponseValue;
        this.setElevationResponseValue = setElevationResponseValue;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public LNControlPointCharacteristicData(@NonNull Parcel in) {
        super(in);
        setCumulativeValueResponseValue = in.readInt();
        maskLocationAndSpeedCharacteristicContentResponseValue = in.readInt();
        navigationControlResponseValue = in.readInt();
        requestNumberOfRoutesResponseValue = in.readInt();
        requestNumberOfRoutesResponseParameter = in.createByteArray();
        requestNameOfRouteResponseValue = in.readInt();
        requestNameOfRouteResponseParameter = in.createByteArray();
        selectRouteResponseValue = in.readInt();
        setFixRateResponseValue = in.readInt();
        setElevationResponseValue = in.readInt();
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public byte[] getBytes() {
        byte[] result = null;
        LNControlPoint lnControlPoint = null;
        try {
            lnControlPoint = new LNControlPoint(super.getBytes());
            if (lnControlPoint.isOpCodesSetCumulativeValue(lnControlPoint.getOpCodes())) {
                result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, setCumulativeValueResponseValue, new byte[0]).getBytes();
            } else if (lnControlPoint.isOpCodesMaskLocationAndSpeedCharacteristicContent(lnControlPoint.getOpCodes())) {
                result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT, maskLocationAndSpeedCharacteristicContentResponseValue, new byte[0]).getBytes();
            } else if (lnControlPoint.isOpCodesNavigationControl(lnControlPoint.getOpCodes())) {
                result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_NAVIGATION_CONTROL, navigationControlResponseValue, new byte[0]).getBytes();
            } else if (lnControlPoint.isOpCodesRequestNumberOfRoutes(lnControlPoint.getOpCodes())) {
                result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_REQUEST_NUMBER_OF_ROUTES, requestNumberOfRoutesResponseValue, requestNumberOfRoutesResponseParameter).getBytes();
            } else if (lnControlPoint.isOpCodesRequestNameOfRoute(lnControlPoint.getOpCodes())) {
                result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_REQUEST_NAME_OF_ROUTE, requestNameOfRouteResponseValue, requestNameOfRouteResponseParameter).getBytes();
            } else if (lnControlPoint.isOpCodesSelectRoute(lnControlPoint.getOpCodes())) {
                result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SELECT_ROUTE, selectRouteResponseValue, new byte[0]).getBytes();
            } else if (lnControlPoint.isOpCodesSetFixRate(lnControlPoint.getOpCodes())) {
                result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SET_FIX_RATE, setFixRateResponseValue, new byte[0]).getBytes();
            } else if (lnControlPoint.isOpCodesSetElevation(lnControlPoint.getOpCodes())) {
                result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SET_ELEVATION, setElevationResponseValue, new byte[0]).getBytes();
            }
        } catch (Exception e) {
            BLEPeripheralLogUtils.stackLog(e);
        }

        if (result == null) {
            int opCodes;
            if (lnControlPoint == null) {
                opCodes = LNControlPoint.OP_CODES_RESPONSE_CODE;
            } else {
                opCodes = lnControlPoint.getOpCodes();
            }
            result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], opCodes, LNControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
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
        dest.writeInt(maskLocationAndSpeedCharacteristicContentResponseValue);
        dest.writeInt(navigationControlResponseValue);
        dest.writeInt(requestNumberOfRoutesResponseValue);
        dest.writeByteArray(requestNumberOfRoutesResponseParameter);
        dest.writeInt(requestNameOfRouteResponseValue);
        dest.writeByteArray(requestNameOfRouteResponseParameter);
        dest.writeInt(selectRouteResponseValue);
        dest.writeInt(setFixRateResponseValue);
        dest.writeInt(setElevationResponseValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Integer.valueOf(setCumulativeValueResponseValue).hashCode()
                ^ Integer.valueOf(maskLocationAndSpeedCharacteristicContentResponseValue).hashCode()
                ^ Integer.valueOf(navigationControlResponseValue).hashCode()
                ^ Integer.valueOf(requestNumberOfRoutesResponseValue).hashCode()
                ^ Arrays.hashCode(requestNumberOfRoutesResponseParameter)
                ^ Integer.valueOf(requestNameOfRouteResponseValue).hashCode()
                ^ Arrays.hashCode(requestNameOfRouteResponseParameter)
                ^ Integer.valueOf(selectRouteResponseValue).hashCode()
                ^ Integer.valueOf(setFixRateResponseValue).hashCode()
                ^ Integer.valueOf(setElevationResponseValue).hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof LNControlPointCharacteristicData) {
            LNControlPointCharacteristicData target = (LNControlPointCharacteristicData) obj;
            result = super.equals(target)
                    && setCumulativeValueResponseValue == target.setCumulativeValueResponseValue
                    && maskLocationAndSpeedCharacteristicContentResponseValue == target.maskLocationAndSpeedCharacteristicContentResponseValue
                    && navigationControlResponseValue == target.navigationControlResponseValue
                    && requestNumberOfRoutesResponseValue == target.requestNumberOfRoutesResponseValue
                    && Arrays.equals(requestNumberOfRoutesResponseParameter, target.requestNumberOfRoutesResponseParameter)
                    && requestNameOfRouteResponseValue == target.requestNameOfRouteResponseValue
                    && Arrays.equals(requestNameOfRouteResponseParameter, target.requestNameOfRouteResponseParameter)
                    && selectRouteResponseValue == target.selectRouteResponseValue
                    && setFixRateResponseValue == target.setFixRateResponseValue
                    && setElevationResponseValue == target.setElevationResponseValue;
        }
        return result;
    }

}
