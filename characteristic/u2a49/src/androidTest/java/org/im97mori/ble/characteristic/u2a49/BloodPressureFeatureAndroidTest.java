package org.im97mori.ble.characteristic.u2a49;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;

@SuppressWarnings({"ConstantConditions", "unused"})
public class BloodPressureFeatureAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_FALSE
                | BloodPressureFeature.E2E_CRC_SUPPORT_FALSE
                | BloodPressureFeature.USER_DATA_SERVICE_SUPPORT_FALSE
                | BloodPressureFeature.USER_FACING_TIME_SUPPORT_FALSE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_TRUE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_FALSE | BloodPressureFeature.E2E_CRC_SUPPORT_FALSE
                | BloodPressureFeature.USER_DATA_SERVICE_SUPPORT_FALSE
                | BloodPressureFeature.USER_FACING_TIME_SUPPORT_FALSE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_TRUE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_FALSE | BloodPressureFeature.E2E_CRC_SUPPORT_FALSE
                | BloodPressureFeature.USER_DATA_SERVICE_SUPPORT_FALSE
                | BloodPressureFeature.USER_FACING_TIME_SUPPORT_FALSE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_TRUE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_FALSE | BloodPressureFeature.E2E_CRC_SUPPORT_FALSE
                | BloodPressureFeature.USER_DATA_SERVICE_SUPPORT_FALSE
                | BloodPressureFeature.USER_FACING_TIME_SUPPORT_FALSE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_TRUE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_FALSE | BloodPressureFeature.E2E_CRC_SUPPORT_FALSE
                | BloodPressureFeature.USER_DATA_SERVICE_SUPPORT_FALSE
                | BloodPressureFeature.USER_FACING_TIME_SUPPORT_FALSE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_TRUE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_FALSE | BloodPressureFeature.E2E_CRC_SUPPORT_FALSE
                | BloodPressureFeature.USER_DATA_SERVICE_SUPPORT_FALSE
                | BloodPressureFeature.USER_FACING_TIME_SUPPORT_FALSE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_TRUE | BloodPressureFeature.E2E_CRC_SUPPORT_FALSE
                | BloodPressureFeature.USER_DATA_SERVICE_SUPPORT_FALSE
                | BloodPressureFeature.USER_FACING_TIME_SUPPORT_FALSE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on
        data_00007 = data;
    }

    private static final byte[] data_00008;
    static {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_FALSE | BloodPressureFeature.E2E_CRC_SUPPORT_TRUE
                | BloodPressureFeature.USER_DATA_SERVICE_SUPPORT_FALSE
                | BloodPressureFeature.USER_FACING_TIME_SUPPORT_FALSE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on
        data_00008 = data;
    }

    private static final byte[] data_00009;
    static {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_FALSE | BloodPressureFeature.E2E_CRC_SUPPORT_FALSE
                | BloodPressureFeature.USER_DATA_SERVICE_SUPPORT_TRUE
                | BloodPressureFeature.USER_FACING_TIME_SUPPORT_FALSE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on
        data_00009 = data;
    }

    private static final byte[] data_00010;
    static {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_FALSE | BloodPressureFeature.E2E_CRC_SUPPORT_FALSE
                | BloodPressureFeature.USER_DATA_SERVICE_SUPPORT_FALSE
                | BloodPressureFeature.USER_FACING_TIME_SUPPORT_TRUE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on
        data_00010 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertTrue(result1.isBodyMovementDetectionSupported());
        assertFalse(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_1_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertTrue(result1.isCuffFitDetectionSupported());
        assertFalse(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_1_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertTrue(result1.isIrregularPulseDetectionSupported());
        assertFalse(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_1_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertTrue(result1.isPulseRateRangeDetectionSupported());
        assertFalse(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_1_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertTrue(result1.isMeasurementPositionDetectionSupported());
        assertFalse(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_1_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertTrue(result1.isMultipleBondSupported());
        assertFalse(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_1_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertTrue(result1.isE2eCrcSupported());
        assertFalse(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_1_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertTrue(result1.isUserDataServiceSupported());
        assertFalse(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_1_00010() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertTrue(result1.isUserFacingTimeSupported());
        assertFalse(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();
        //@formatter:on

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(false, false, false, false, false, false, false, false,
                false);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_2_00002() {
        byte[] data = getData();

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(true, false, false, false, false, false, false, false,
                false);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertTrue(result1.isBodyMovementDetectionSupported());
        assertFalse(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_2_00003() {
        byte[] data = getData();

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(false, true, false, false, false, false, false, false,
                false);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertTrue(result1.isCuffFitDetectionSupported());
        assertFalse(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_2_00004() {
        byte[] data = getData();

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(false, false, true, false, false, false, false, false,
                false);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertTrue(result1.isIrregularPulseDetectionSupported());
        assertFalse(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_2_00005() {
        byte[] data = getData();

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(false, false, false, true, false, false, false, false,
                false);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertTrue(result1.isPulseRateRangeDetectionSupported());
        assertFalse(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_2_00006() {
        byte[] data = getData();

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(false, false, false, false, true, false, false, false,
                false);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertTrue(result1.isMeasurementPositionDetectionSupported());
        assertFalse(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_2_00007() {
        byte[] data = getData();

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(false, false, false, false, false, true, false, false,
                false);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertTrue(result1.isMultipleBondSupported());
        assertFalse(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_2_00008() {
        byte[] data = getData();
        //@formatter:on

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(false, false, false, false, false, false, true, false,
                false);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertTrue(result1.isE2eCrcSupported());
        assertFalse(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_2_00009() {
        byte[] data = getData();
        //@formatter:on

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(false, false, false, false, false, false, false, true,
                false);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertTrue(result1.isUserDataServiceSupported());
        assertFalse(result1.isUserDataServiceNotSupported());
        assertFalse(result1.isUserFacingTimeSupported());
        assertTrue(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_constructor_2_00010() {
        byte[] data = getData();
        //@formatter:on

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(false, false, false, false, false, false, false, false,
                true);
        assertArrayEquals(data, result1.getBloodPressureFeature());
        assertFalse(result1.isBodyMovementDetectionSupported());
        assertTrue(result1.isBodyMovementDetectionNotSupported());
        assertFalse(result1.isCuffFitDetectionSupported());
        assertTrue(result1.isCuffFitDetectionNotSupported());
        assertFalse(result1.isIrregularPulseDetectionSupported());
        assertTrue(result1.isIrregularPulsetDetectionNotSupported());
        assertFalse(result1.isPulseRateRangeDetectionSupported());
        assertTrue(result1.isPulseRateRangeDetectionNotSupported());
        assertFalse(result1.isMeasurementPositionDetectionSupported());
        assertTrue(result1.isMeasurementPositionDetectionNotSupported());
        assertFalse(result1.isMultipleBondSupported());
        assertTrue(result1.isMultipleBondNotSupported());
        assertFalse(result1.isE2eCrcSupported());
        assertTrue(result1.isE2eCrcNotSupported());
        assertFalse(result1.isUserDataServiceSupported());
        assertTrue(result1.isUserDataServiceNotSupported());
        assertTrue(result1.isUserFacingTimeSupported());
        assertFalse(result1.isUserFacingTimeNotSupported());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getBloodPressureFeature(), result2.getBloodPressureFeature());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getBloodPressureFeature(), result2.getBloodPressureFeature());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getBloodPressureFeature(), result2.getBloodPressureFeature());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getBloodPressureFeature(), result2.getBloodPressureFeature());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getBloodPressureFeature(), result2.getBloodPressureFeature());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getBloodPressureFeature(), result2.getBloodPressureFeature());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getBloodPressureFeature(), result2.getBloodPressureFeature());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getBloodPressureFeature(), result2.getBloodPressureFeature());
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getBloodPressureFeature(), result2.getBloodPressureFeature());
    }

    @Test
    public void test_parcelable_1_00010() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getBloodPressureFeature(), result2.getBloodPressureFeature());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00010() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00010() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
