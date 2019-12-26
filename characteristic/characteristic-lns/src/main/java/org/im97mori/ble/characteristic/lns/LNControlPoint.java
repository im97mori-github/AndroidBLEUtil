package org.im97mori.ble.characteristic.lns;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LN_CONTROL_POINT_CHARACTERISTIC;

/**
 * LN Control Point (Characteristics UUID: 0x2A6B)
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class LNControlPoint implements ByteArrayInterface, Parcelable {

    /**
     * 1: Set Cumulative Value
     */
    public static final int OP_CODES_SET_CUMULATIVE_VALUE = 1;

    /**
     * 2: Mask Location and Speed Characteristic Content
     */
    public static final int OP_CODES_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT = 2;

    /**
     * 3: Navigation Control
     */
    public static final int OP_CODES_NAVIGATION_CONTROL = 3;

    /**
     * 4: Request Number of Routes
     */
    public static final int OP_CODES_REQUEST_NUMBER_OF_ROUTES = 4;

    /**
     * 5: Request Name of Route
     */
    public static final int OP_CODES_REQUEST_NAME_OF_ROUTE = 5;

    /**
     * 6: Select Route
     */
    public static final int OP_CODES_SELECT_ROUTE = 6;

    /**
     * 7: Set Fix Rate
     */
    public static final int OP_CODES_SET_FIX_RATE = 7;

    /**
     * 8: Set Elevation
     */
    public static final int OP_CODES_SET_ELEVATION = 8;

    /**
     * 9: Response Code
     */
    public static final int OP_CODES_RESPONSE_CODE = 32;

    /**
     * @see #PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_INSTANCE_SPEED_LEAVE_AS_DEFAULT
     * @see #PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_INSTANCE_SPEED_TURN_OFF
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_INSTANCE_SPEED_MASK = 0b00000000_00000001;

    /**
     * <p>
     * Mask Location and Speed Characteristic Content
     * 0: Instantaneous Speed Leave as default
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_INSTANCE_SPEED_LEAVE_AS_DEFAULT = 0b00000000_00000000;

    /**
     * <p>
     * Mask Location and Speed Characteristic Content
     * 1: Instantaneous Speed Turn off
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_INSTANCE_SPEED_TURN_OFF = 0b00000000_00000001;

    /**
     * @see #PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_TOTAL_DISTANCE_LEAVE_AS_DEFAULT
     * @see #PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_TOTAL_DISTANCE_TURN_OFF
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_TOTAL_DISTANCE_MASK = 0b00000000_00000010;

    /**
     * <p>
     * Mask Location and Speed Characteristic Content
     * 0: Total Distance Leave as default
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_TOTAL_DISTANCE_LEAVE_AS_DEFAULT = 0b00000000_00000000;

    /**
     * <p>
     * Mask Location and Speed Characteristic Content
     * 1: Instantaneous Speed Turn off
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_TOTAL_DISTANCE_TURN_OFF = 0b00000000_00000010;

    /**
     * @see #PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_LOCATION_LEAVE_AS_DEFAULT
     * @see #PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_LOCATION_TURN_OFF
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_LOCATION_MASK = 0b00000000_00000100;

    /**
     * <p>
     * Mask Location and Speed Characteristic Content
     * 0: Location Leave as default
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_LOCATION_LEAVE_AS_DEFAULT = 0b00000000_00000000;

    /**
     * <p>
     * Mask Location and Speed Characteristic Content
     * 1: Location Turn off
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_LOCATION_TURN_OFF = 0b00000000_00000100;

    /**
     * @see #PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_ELEVATION_LEAVE_AS_DEFAULT
     * @see #PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_ELEVATION_TURN_OFF
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_ELEVATION_MASK = 0b00000000_00001000;

    /**
     * <p>
     * Mask Location and Speed Characteristic Content
     * 0: Elevation Leave as default
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_ELEVATION_LEAVE_AS_DEFAULT = 0b00000000_00000000;

    /**
     * <p>
     * Mask Location and Speed Characteristic Content
     * 1: Elevation Turn off
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_ELEVATION_TURN_OFF = 0b00000000_00001000;

    /**
     * @see #PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_HEADING_LEAVE_AS_DEFAULT
     * @see #PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_HEADING_TURN_OFF
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_HEADING_MASK = 0b00000000_00010000;

    /**
     * <p>
     * Mask Location and Speed Characteristic Content
     * 0: Heading Leave as default
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_HEADING_LEAVE_AS_DEFAULT = 0b00000000_00000000;

    /**
     * <p>
     * Mask Location and Speed Characteristic Content
     * 1: Heading Turn off
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_HEADING_TURN_OFF = 0b00000000_00010000;

    /**
     * @see #PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_ROLLING_TIME_LEAVE_AS_DEFAULT
     * @see #PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_ROLLING_TIME_TURN_OFF
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_ROLLING_TIME_MASK = 0b00000000_00100000;

    /**
     * <p>
     * Mask Location and Speed Characteristic Content
     * 0: Rolling Time Leave as default
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_ROLLING_TIME_LEAVE_AS_DEFAULT = 0b00000000_00000000;

    /**
     * <p>
     * Mask Location and Speed Characteristic Content
     * 1: Rolling Time Turn off
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_ROLLING_TIME_TURN_OFF = 0b00000000_00100000;

    /**
     * @see #PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_UTC_TIME_LEAVE_AS_DEFAULT
     * @see #PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_UTC_TIME_TURN_OFF
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_UTC_TIME_MASK = 0b00000000_01000000;

    /**
     * <p>
     * Mask Location and Speed Characteristic Content
     * 0: UTC Time Leave as default
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_UTC_TIME_LEAVE_AS_DEFAULT = 0b00000000_00000000;

    /**
     * <p>
     * Mask Location and Speed Characteristic Content
     * 1: UTC Time Turn off
     * </p>
     */
    public static final int PARAMETER_VALUE_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_UTC_TIME_TURN_OFF = 0b00000000_01000000;

    /**
     * <p>
     * Navigation Control
     * 0: Stop Notificationof the Navigation characteristic.Stop Navigation
     * </p>
     */
    public static final int PARAMETER_VALUE_NAVIGATION_CONTROL_00 = 0x00;

    /**
     * <p>
     * Navigation Control
     * 1: Start Notificationof the Navigation characteristic.Start Navigationto the first waypoint on a route
     * </p>
     */
    public static final int PARAMETER_VALUE_NAVIGATION_CONTROL_01 = 0x01;

    /**
     * <p>
     * Navigation Control
     * 2: Stop Notificationof the Navigation characteristic.Pause Navigationkeeping the next waypointon the routein the memory for continuing the navigation later
     * </p>
     */
    public static final int PARAMETER_VALUE_NAVIGATION_CONTROL_02 = 0x02;

    /**
     * <p>
     * Navigation Control
     * 3: Start Notificationof the Navigation characteristic.Continue Navigationfrom the point where navigation was paused to the next waypointon the route
     * </p>
     */
    public static final int PARAMETER_VALUE_NAVIGATION_CONTROL_03 = 0x03;

    /**
     * <p>
     * Navigation Control
     * 4: Notificationof the Navigation characteristicnot affected. Skip Waypoint: disregard next waypoint and continue navigation to the waypoint following next waypoint on the route
     * </p>
     */
    public static final int PARAMETER_VALUE_NAVIGATION_CONTROL_04 = 0x04;

    /**
     * <p>
     * Navigation Control
     * 5: Start Notificationof the Navigation characteristic. Select Nearest Waypoint on a Route: measure the distance to all waypoints on the route, and startnavigation to the closest or optimal waypoint on the route (left to the implementation) and from there to waypoints following next waypoint along the route
     * </p>
     */
    public static final int PARAMETER_VALUE_NAVIGATION_CONTROL_05 = 0x05;

    /**
     * 1: Success
     */
    public static final int RESPONSE_VALUE_SUCCESS = 1;

    /**
     * 2: Op Code not Supported
     */
    public static final int RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED = 2;

    /**
     * 3: Invalid Parameter
     */
    public static final int RESPONSE_VALUE_INVALID_PARAMETER = 3;

    /**
     * 4: Operation Failed
     */
    public static final int RESPONSE_VALUE_OPERATION_FAILED = 4;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LNControlPoint> CREATOR = new ByteArrayCreater<LNControlPoint>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LNControlPoint createFromParcel(@NonNull Parcel in) {
            return new LNControlPoint(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LNControlPoint[] newArray(int size) {
            return new LNControlPoint[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LNControlPoint createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LN_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LNControlPoint(bluetoothGattCharacteristic);
        }

    };

    /**
     * Op Codes
     */
    private final int mOpCodes;

    /**
     * Parameter Value
     */
    private final byte[] mParameterValue;

    /**
     * Request Op Code
     */
    private final int mRequestOpCode;

    /**
     * Response Value
     */
    private final int mResponseValue;

    /**
     * Response Parameter
     */
    private final byte[] mResponseParameter;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A6B
     */
    public LNControlPoint(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mOpCodes = (values[0] & 0xff);
        if (isOpCodesSetCumulativeValue(mOpCodes)) {
            mParameterValue = Arrays.copyOfRange(values, 1, 4);
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesMaskLocationAndSpeedCharacteristicContent(mOpCodes)) {
            mParameterValue = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesNavigationControl(mOpCodes)) {
            mParameterValue = Arrays.copyOfRange(values, 1, 2);
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesRequestNumberOfRoutes(mOpCodes)) {
            mParameterValue = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesRequestNameOfRoute(mOpCodes)) {
            mParameterValue = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesSelectRoute(mOpCodes)) {
            mParameterValue = Arrays.copyOfRange(values, 1, 3);
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesSetFixRate(mOpCodes)) {
            mParameterValue = Arrays.copyOfRange(values, 1, 2);
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesSetElevation(mOpCodes)) {
            mParameterValue = Arrays.copyOfRange(values, 1, 4);
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        } else if (isOpCodesResponseCode(mOpCodes)) {
            mRequestOpCode = (values[1] & 0xff);
            mResponseValue = (values[2] & 0xff);

            if (isOpCodesRequestNumberOfRoutes(mRequestOpCode)) {
                if (isResponseValueSuccess(mResponseValue)) {
                    mResponseParameter = Arrays.copyOfRange(values, 3, 5);
                } else {
                    mResponseParameter = new byte[0];
                }
            } else if (isOpCodesRequestNameOfRoute(mRequestOpCode)) {
                if (isResponseValueSuccess(mResponseValue)) {
                    mResponseParameter = Arrays.copyOfRange(values, 3, values.length);
                } else {
                    mResponseParameter = new byte[0];
                }
            } else {
                mResponseParameter = new byte[0];
            }

            mParameterValue = new byte[0];
        } else {
            mParameterValue = new byte[0];
            mRequestOpCode = 0;
            mResponseValue = 0;
            mResponseParameter = new byte[0];
        }
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LNControlPoint(@NonNull Parcel in) {
        mOpCodes = in.readInt();
        mParameterValue = in.createByteArray();
        mRequestOpCode = in.readInt();
        mResponseValue = in.readInt();
        mResponseParameter = in.createByteArray();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(mOpCodes);
        dest.writeByteArray(mParameterValue);
        dest.writeInt(mRequestOpCode);
        dest.writeInt(mResponseValue);
        dest.writeByteArray(mResponseParameter);
    }

    /**
     * @return Op Codes
     */
    public int getOpCodes() {
        return mOpCodes;
    }

    /**
     * @param opCodes Op Code
     * @return {@code true}:Set Cumulative Value, {@code false}:not Set Cumulative Value
     */
    public boolean isOpCodesSetCumulativeValue(int opCodes) {
        return OP_CODES_SET_CUMULATIVE_VALUE == opCodes;
    }

    /**
     * @param opCodes Op Code
     * @return {@code true}:Mask Location and Speed Characteristic Content, {@code false}:not Mask Location and Speed Characteristic Content
     */
    public boolean isOpCodesMaskLocationAndSpeedCharacteristicContent(int opCodes) {
        return OP_CODES_MASK_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT == opCodes;
    }

    /**
     * @param opCodes Op Code
     * @return {@code true}:Navigation Control, {@code false}:not Navigation Control
     */
    public boolean isOpCodesNavigationControl(int opCodes) {
        return OP_CODES_NAVIGATION_CONTROL == opCodes;
    }

    /**
     * @param opCodes Op Code
     * @return {@code true}:Request Number of Routes, {@code false}:not Request Number of Routes
     */
    public boolean isOpCodesRequestNumberOfRoutes(int opCodes) {
        return OP_CODES_REQUEST_NUMBER_OF_ROUTES == opCodes;
    }

    /**
     * @param opCodes Op Code
     * @return {@code true}:Request Name of Route, {@code false}:not Request Name of Route
     */
    public boolean isOpCodesRequestNameOfRoute(int opCodes) {
        return OP_CODES_REQUEST_NAME_OF_ROUTE == opCodes;
    }

    /**
     * @param opCodes Op Code
     * @return {@code true}:Select Route, {@code false}:not Select Route
     */
    public boolean isOpCodesSelectRoute(int opCodes) {
        return OP_CODES_SELECT_ROUTE == opCodes;
    }

    /**
     * @param opCodes Op Code
     * @return {@code true}:Set Fix Rate, {@code false}:not Set Fix Rate
     */
    public boolean isOpCodesSetFixRate(int opCodes) {
        return OP_CODES_SET_FIX_RATE == opCodes;
    }

    /**
     * @param opCodes Op Code
     * @return {@code true}:Set Elevation, {@code false}:not Set Elevation
     */
    public boolean isOpCodesSetElevation(int opCodes) {
        return OP_CODES_SET_ELEVATION == opCodes;
    }

    /**
     * @param opCodes Op Code
     * @return {@code true}:Response Code, {@code false}:not SResponse Code
     */
    public boolean isOpCodesResponseCode(int opCodes) {
        return OP_CODES_RESPONSE_CODE == opCodes;
    }

    /**
     * @return Parameter Value
     */
    public byte[] getParameterValue() {
        return mParameterValue;
    }

    /**
     * @return Request Op Code
     */
    public int getRequestOpCode() {
        return mRequestOpCode;
    }

    /**
     * @return Response Value
     */
    public int getResponseValue() {
        return mResponseValue;
    }

    /**
     * @param responseValue Response Value
     * @return {@code true}:Success, {@code false}:not Success
     */
    public boolean isResponseValueSuccess(int responseValue) {
        return RESPONSE_VALUE_SUCCESS == responseValue;
    }

    /**
     * @param responseValue Response Value
     * @return {@code true}:Op Code not Supported, {@code false}:not Op Code not Supported
     */
    public boolean isResponseValueOpCodeNotSupported(int responseValue) {
        return RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED == responseValue;
    }

    /**
     * @param responseValue Response Value
     * @return {@code true}:Invalid Parameter, {@code false}:not Invalid Parameter
     */
    public boolean isResponseValueInvalidParameter(int responseValue) {
        return RESPONSE_VALUE_INVALID_PARAMETER == responseValue;
    }

    /**
     * @param responseValue Response Value
     * @return {@code true}:Operation Failed, {@code false}:not Operation Failed
     */
    public boolean isResponseValueOperationFailed(int responseValue) {
        return RESPONSE_VALUE_OPERATION_FAILED == responseValue;
    }

    /**
     * @return Response Parameter
     */
    public byte[] getResponseParameter() {
        return mResponseParameter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        int length = 1;
        byte[] data = new byte[5 + mParameterValue.length + mResponseParameter.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mOpCodes);
        byteBuffer.put(mParameterValue);
        length += mParameterValue.length;
        if (isOpCodesResponseCode(mOpCodes)) {
            byteBuffer.put((byte) mRequestOpCode);
            length++;
            byteBuffer.put((byte) mResponseValue);
            length++;
            if (isOpCodesRequestNumberOfRoutes(mRequestOpCode)) {
                byteBuffer.put(mResponseParameter);
                length += mResponseParameter.length;
            } else if (isOpCodesRequestNameOfRoute(mRequestOpCode)) {
                byteBuffer.put(mResponseParameter);
                length += mResponseParameter.length;
            }
        }
        return Arrays.copyOfRange(data, 0, length);
    }
}
