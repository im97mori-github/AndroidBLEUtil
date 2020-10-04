package org.im97mori.ble.service.lns.peripheral;

import android.bluetooth.BluetoothDevice;
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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LN_CONTROL_POINT_CHARACTERISTIC;

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
     * characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Cumulative Value response)
     */
    @SerializedName("set_cumulative_value_responce_value")
    public int setCumulativeValueResponceValue;

    /**
     * characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Mask Location and Speed Characteristic Content response)
     */
    @SerializedName("mask_location_and_speed_characteristic_content_responce_value")
    public int maskLocationAndSpeedCharacteristicContentResponceValue;

    /**
     * characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Navigation Control response)
     */
    @SerializedName("navigation_control_responce_value")
    public int navigationControlResponceValue;

    /**
     * part of characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Request Number of Routes response)
     */
    @SerializedName("request_number_of_routes_responce_value")
    public int requestNumberOfRoutesResponceValue;

    /**
     * part of characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Number of Routes)
     */
    @SerializedName("request_number_of_routes_responce_parameter")
    public byte[] requestNumberOfRoutesResponceParameter;

    /**
     * part of characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Request Name of Route response)
     */
    @SerializedName("request_name_of_route_responce_value")
    public int requestNameOfRouteResponceValue;

    /**
     * part of characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Name of Route)
     */
    @SerializedName("request_name_of_route_responce_parameter")
    public byte[] requestNameOfRouteResponceParameter;

    /**
     * characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Select Route response)
     */
    @SerializedName("select_route_responce_value")
    public int selectRouteResponceValue;

    /**
     * characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Fix Rate response)
     */
    @SerializedName("set_fix_rate_responce_value")
    public int setFixRateResponceValue;

    /**
     * characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Elevation response)
     */
    @SerializedName("set_elevation_responce_value")
    public int setElevationResponceValue;

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
     * @param delay                                                  responce delay(millis)
     * @param notificationCount                                      notification / indication count
     * @param setCumulativeValueResponceValue                        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Cumulative Value response)
     * @param maskLocationAndSpeedCharacteristicContentResponceValue characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Mask Location and Speed Characteristic Content response)
     * @param navigationControlResponceValue                         characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Navigation Control response)
     * @param requestNumberOfRoutesResponceValue                     part of characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Request Number of Routes response)
     * @param requestNumberOfRoutesResponceParameter                 part of characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Number of Routes)
     * @param requestNameOfRouteResponceValue                        part of characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Request Name of Route response)
     * @param requestNameOfRouteResponceParameter                    part of characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Name of Route)
     * @param selectRouteResponceValue                               characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Select Route response)
     * @param setFixRateResponceValue                                characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Fix Rate response)
     * @param setElevationResponceValue                              characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Elevation response)
     */
    public LNControlPointCharacteristicData(int property
            , int permission
            , @NonNull List<DescriptorData> descriptorDataList
            , int responseCode
            , long delay
            , int notificationCount
            , int setCumulativeValueResponceValue
            , int maskLocationAndSpeedCharacteristicContentResponceValue
            , int navigationControlResponceValue
            , int requestNumberOfRoutesResponceValue
            , @NonNull byte[] requestNumberOfRoutesResponceParameter
            , int requestNameOfRouteResponceValue
            , @NonNull byte[] requestNameOfRouteResponceParameter
            , int selectRouteResponceValue
            , int setFixRateResponceValue
            , int setElevationResponceValue) {
        super(LN_CONTROL_POINT_CHARACTERISTIC, property, permission, descriptorDataList, responseCode, delay, new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_RESPONSE_CODE, LNControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes(), notificationCount);
        this.setCumulativeValueResponceValue = setCumulativeValueResponceValue;
        this.maskLocationAndSpeedCharacteristicContentResponceValue = maskLocationAndSpeedCharacteristicContentResponceValue;
        this.navigationControlResponceValue = navigationControlResponceValue;
        this.requestNumberOfRoutesResponceValue = requestNumberOfRoutesResponceValue;
        this.requestNumberOfRoutesResponceParameter = requestNumberOfRoutesResponceParameter;
        this.requestNameOfRouteResponceValue = requestNameOfRouteResponceValue;
        this.requestNameOfRouteResponceParameter = requestNameOfRouteResponceParameter;
        this.selectRouteResponceValue = selectRouteResponceValue;
        this.setFixRateResponceValue = setFixRateResponceValue;
        this.setElevationResponceValue = setElevationResponceValue;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public LNControlPointCharacteristicData(@NonNull Parcel in) {
        super(in);
        setCumulativeValueResponceValue = in.readInt();
        maskLocationAndSpeedCharacteristicContentResponceValue = in.readInt();
        navigationControlResponceValue = in.readInt();
        requestNumberOfRoutesResponceValue = in.readInt();
        requestNumberOfRoutesResponceParameter = in.createByteArray();
        requestNameOfRouteResponceValue = in.readInt();
        requestNameOfRouteResponceParameter = in.createByteArray();
        selectRouteResponceValue = in.readInt();
        setFixRateResponceValue = in.readInt();
        setElevationResponceValue = in.readInt();
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
                result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, setCumulativeValueResponceValue, new byte[0]).getBytes();
            } else if (lnControlPoint.isOpCodesMaskLocationAndSpeedCharacteristicContent(lnControlPoint.getOpCodes())) {
                result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT, maskLocationAndSpeedCharacteristicContentResponceValue, new byte[0]).getBytes();
            } else if (lnControlPoint.isOpCodesNavigationControl(lnControlPoint.getOpCodes())) {
                result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_NAVIGATION_CONTROL, navigationControlResponceValue, new byte[0]).getBytes();
            } else if (lnControlPoint.isOpCodesRequestNumberOfRoutes(lnControlPoint.getOpCodes())) {
                result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_REQUEST_NUMBER_OF_ROUTES, requestNumberOfRoutesResponceValue, requestNumberOfRoutesResponceParameter).getBytes();
            } else if (lnControlPoint.isOpCodesRequestNameOfRoute(lnControlPoint.getOpCodes())) {
                result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_REQUEST_NAME_OF_ROUTE, requestNameOfRouteResponceValue, requestNameOfRouteResponceParameter).getBytes();
            } else if (lnControlPoint.isOpCodesSelectRoute(lnControlPoint.getOpCodes())) {
                result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SELECT_ROUTE, selectRouteResponceValue, new byte[0]).getBytes();
            } else if (lnControlPoint.isOpCodesSetFixRate(lnControlPoint.getOpCodes())) {
                result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SET_FIX_RATE, setFixRateResponceValue, new byte[0]).getBytes();
            } else if (lnControlPoint.isOpCodesSetElevation(lnControlPoint.getOpCodes())) {
                result = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_SET_ELEVATION, setElevationResponceValue, new byte[0]).getBytes();
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
        dest.writeInt(setCumulativeValueResponceValue);
        dest.writeInt(maskLocationAndSpeedCharacteristicContentResponceValue);
        dest.writeInt(navigationControlResponceValue);
        dest.writeInt(requestNumberOfRoutesResponceValue);
        dest.writeByteArray(requestNumberOfRoutesResponceParameter);
        dest.writeInt(requestNameOfRouteResponceValue);
        dest.writeByteArray(requestNameOfRouteResponceParameter);
        dest.writeInt(selectRouteResponceValue);
        dest.writeInt(setFixRateResponceValue);
        dest.writeInt(setElevationResponceValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return uuid.hashCode()
                ^ Integer.valueOf(property).hashCode()
                ^ Integer.valueOf(permission).hashCode()
                ^ Arrays.hashCode(descriptorDataList.toArray())
                ^ Integer.valueOf(responseCode).hashCode()
                ^ Long.valueOf(delay).hashCode()
                ^ Arrays.hashCode(data)
                ^ Integer.valueOf(notificationCount).hashCode()
                ^ Arrays.hashCode(currentData)
                ^ Arrays.hashCode(temporaryData)
                ^ Integer.valueOf(setCumulativeValueResponceValue).hashCode()
                ^ Integer.valueOf(maskLocationAndSpeedCharacteristicContentResponceValue).hashCode()
                ^ Integer.valueOf(navigationControlResponceValue).hashCode()
                ^ Integer.valueOf(requestNumberOfRoutesResponceValue).hashCode()
                ^ Arrays.hashCode(requestNumberOfRoutesResponceParameter)
                ^ Integer.valueOf(requestNameOfRouteResponceValue).hashCode()
                ^ Arrays.hashCode(requestNameOfRouteResponceParameter)
                ^ Integer.valueOf(selectRouteResponceValue).hashCode()
                ^ Integer.valueOf(setFixRateResponceValue).hashCode()
                ^ Integer.valueOf(setElevationResponceValue).hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof LNControlPointCharacteristicData) {
            LNControlPointCharacteristicData target = (LNControlPointCharacteristicData) obj;
            result = uuid.equals(target.uuid)
                    && property == target.property
                    && permission == target.permission
                    && Arrays.equals(descriptorDataList.toArray(), target.descriptorDataList.toArray())
                    && responseCode == target.responseCode
                    && delay == target.delay
                    && Arrays.equals(data, target.data)
                    && Arrays.equals(currentData, target.currentData)
                    && Arrays.equals(temporaryData, target.temporaryData)
                    && notificationCount == target.notificationCount
                    && setCumulativeValueResponceValue == target.setCumulativeValueResponceValue
                    && maskLocationAndSpeedCharacteristicContentResponceValue == target.maskLocationAndSpeedCharacteristicContentResponceValue
                    && navigationControlResponceValue == target.navigationControlResponceValue
                    && requestNumberOfRoutesResponceValue == target.requestNumberOfRoutesResponceValue
                    && Arrays.equals(requestNumberOfRoutesResponceParameter, target.requestNumberOfRoutesResponceParameter)
                    && requestNameOfRouteResponceValue == target.requestNameOfRouteResponceValue
                    && Arrays.equals(requestNameOfRouteResponceParameter, target.requestNameOfRouteResponceParameter)
                    && selectRouteResponceValue == target.selectRouteResponceValue
                    && setFixRateResponceValue == target.setFixRateResponceValue
                    && setElevationResponceValue == target.setElevationResponceValue;
        }
        return result;
    }

}
