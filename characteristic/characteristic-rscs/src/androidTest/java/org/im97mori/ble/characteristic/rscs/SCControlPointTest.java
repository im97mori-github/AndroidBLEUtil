package org.im97mori.ble.characteristic.rscs;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.SensorLocationUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused"})
public class SCControlPointTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[5];
        data[ 0] = SCControlPoint.OP_CODE_SET_CUMULATIVE_VALUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data_00001 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[1];
        data[ 0] = SCControlPoint.OP_CODE_START_SENSOR_CALIBRATION;
        data_00101 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[2];
        data[ 0] = SCControlPoint.OP_CODE_UPDATE_SENSOR_LOCATION;
        data[ 1] = 0x01;
        data_00201 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[1];
        data[ 0] = SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS;
        data_00301 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[3];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_SET_CUMULATIVE_VALUE;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_SUCCESS;
        data_00401 = data;
    }

    private static final byte[] data_00402;
    static {
        byte[] data = new byte[3];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_SET_CUMULATIVE_VALUE;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_00402 = data;
    }

    private static final byte[] data_00403;
    static {
        byte[] data = new byte[3];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_SET_CUMULATIVE_VALUE;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_00403 = data;
    }

    private static final byte[] data_00404;
    static {
        byte[] data = new byte[3];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_SET_CUMULATIVE_VALUE;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_00404 = data;
    }

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[3];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_START_SENSOR_CALIBRATION;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_SUCCESS;
        data_00501 = data;
    }

    private static final byte[] data_00502;
    static {
        byte[] data = new byte[3];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_START_SENSOR_CALIBRATION;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_00502 = data;
    }

    private static final byte[] data_00503;
    static {
        byte[] data = new byte[3];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_START_SENSOR_CALIBRATION;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_00503 = data;
    }

    private static final byte[] data_00504;
    static {
        byte[] data = new byte[3];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_START_SENSOR_CALIBRATION;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_00504 = data;
    }

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[3];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_UPDATE_SENSOR_LOCATION;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_SUCCESS;
        data_00601 = data;
    }

    private static final byte[] data_00602;
    static {
        byte[] data = new byte[3];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_UPDATE_SENSOR_LOCATION;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_00602 = data;
    }

    private static final byte[] data_00603;
    static {
        byte[] data = new byte[3];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_UPDATE_SENSOR_LOCATION;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_00603 = data;
    }

    private static final byte[] data_00604;
    static {
        byte[] data = new byte[3];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_UPDATE_SENSOR_LOCATION;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_00604 = data;
    }

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[4];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = SensorLocationUtils.SENSOR_LOCATION_OTHER;
        data_00701 = data;
    }

    private static final byte[] data_00702;
    static {
        byte[] data = new byte[20];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = SensorLocationUtils.SENSOR_LOCATION_OTHER;
        data[ 4] = SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE;
        data[ 5] = SensorLocationUtils.SENSOR_LOCATION_IN_SHOE;
        data[ 6] = SensorLocationUtils.SENSOR_LOCATION_HIP;
        data[ 7] = SensorLocationUtils.SENSOR_LOCATION_FRONT_WHEEL;
        data[ 8] = SensorLocationUtils.SENSOR_LOCATION_LEFT_CRANK;
        data[ 9] = SensorLocationUtils.SENSOR_LOCATION_RIGHT_CRANK;
        data[10] = SensorLocationUtils.SENSOR_LOCATION_LEFT_PEDAL;
        data[11] = SensorLocationUtils.SENSOR_LOCATION_RIGHT_PEDAL;
        data[12] = SensorLocationUtils.SENSOR_LOCATION_FRONT_HUB;
        data[13] = SensorLocationUtils.SENSOR_LOCATION_REAR_DROPOUT;
        data[14] = SensorLocationUtils.SENSOR_LOCATION_CHAINSTAY;
        data[15] = SensorLocationUtils.SENSOR_LOCATION_REAR_WHEEL;
        data[16] = SensorLocationUtils.SENSOR_LOCATION_REAR_HUB;
        data[17] = SensorLocationUtils.SENSOR_LOCATION_CHEST;
        data[18] = SensorLocationUtils.SENSOR_LOCATION_SPIDER;
        data[19] = SensorLocationUtils.SENSOR_LOCATION_CHAIN_RING;
        data_00702 = data;
    }

    private static final byte[] data_00703;
    static {
        byte[] data = new byte[3];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        data_00703 = data;
    }

    private static final byte[] data_00704;
    static {
        byte[] data = new byte[3];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        data_00704 = data;
    }

    private static final byte[] data_00705;
    static {
        byte[] data = new byte[3];
        data[ 0] = SCControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS;
        data[ 2] = SCControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        data_00705 = data;
    }
    //@formatter:on

    private byte[] getData() {
        int index = -1;
        byte[] data = null;

        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElementArray.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            if ("getData".equals(stackTraceElement.getMethodName())) {
                index = i + 1;
                break;
            }
        }
        if (index >= 0 && index < stackTraceElementArray.length) {
            StackTraceElement stackTraceElement = stackTraceElementArray[index];
            String[] splitted = stackTraceElement.getMethodName().split("_");
            try {
                data = (byte[]) this.getClass().getDeclaredField("data_" + splitted[splitted.length - 1]).get(null);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertTrue(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x04030201L, result1.getCumulativeValue());
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertTrue(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertTrue(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(0x01L, result1.getSensorLocationValue());
    }

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertTrue(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_constructor_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertTrue(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
    }

    @Test
    public void test_constructor_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertTrue(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
    }

    @Test
    public void test_constructor_00403() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertTrue(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
    }

    @Test
    public void test_constructor_00404() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertTrue(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
    }

    @Test
    public void test_constructor_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
    }

    @Test
    public void test_constructor_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
    }

    @Test
    public void test_constructor_00503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
    }

    @Test
    public void test_constructor_00504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
    }

    @Test
    public void test_constructor_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
    }

    @Test
    public void test_constructor_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
    }

    @Test
    public void test_constructor_00603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
    }

    @Test
    public void test_constructor_00604() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
    }

    @Test
    public void test_constructor_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 4), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertTrue(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
        assertArrayEquals(Arrays.copyOfRange(data, 3, 20), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertTrue(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
    }

    @Test
    public void test_constructor_00704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertTrue(result1.isResponseValueInvalidParameter());
        assertFalse(result1.isResponseValueOperationFailed());
    }

    @Test
    public void test_constructor_00705() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getOpCode()));
        assertFalse(result1.isOpCodeRequestSupportedSensorLocations(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
        assertEquals(data[1], result1.getRequestOpCode());
        assertFalse(result1.isOpCodeSetCumulativeValue(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeStartSensorCalibration(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeUpdateSensorLocation(result1.getRequestOpCode()));
        assertTrue(result1.isOpCodeRequestSupportedSensorLocations(result1.getRequestOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getRequestOpCode()));
        assertEquals(data[2], result1.getResponseValue());
        assertFalse(result1.isResponseValueSuccess());
        assertFalse(result1.isResponseValueOpCodeNotSupported());
        assertFalse(result1.isResponseValueInvalidParameter());
        assertTrue(result1.isResponseValueOperationFailed());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);
        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00403() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00404() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00604() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00705() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertEquals(result1.getCumulativeValue(), result2.getCumulativeValue());
        assertEquals(result1.getSensorLocationValue(), result2.getSensorLocationValue());
        assertEquals(result1.getRequestOpCode(), result2.getRequestOpCode());
        assertEquals(result1.getResponseValue(), result2.getResponseValue());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);
        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00403() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00404() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00604() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00705() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00402() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);
        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00403() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00404() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00502() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00503() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00504() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00602() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00603() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00604() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00702() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00703() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00704() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00705() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SCControlPoint result1 = new SCControlPoint(bluetoothGattCharacteristic);
        SCControlPoint result2 = SCControlPoint.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
