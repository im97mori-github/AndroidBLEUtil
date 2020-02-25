package org.im97mori.ble.characteristic.u2a49;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BloodPressureFeatureAndroidTest {

    @Test
    public void test_constructor001() {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_FALSE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

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
        assertFalse(result1.isMultipleBondDetectionSupported());
        assertTrue(result1.isMultipleBondDetectionNotSupported());
    }

    @Test
    public void test_constructor002() {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_TRUE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_FALSE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

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
        assertFalse(result1.isMultipleBondDetectionSupported());
        assertTrue(result1.isMultipleBondDetectionNotSupported());
    }

    @Test
    public void test_constructor003() {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_TRUE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_FALSE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

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
        assertFalse(result1.isMultipleBondDetectionSupported());
        assertTrue(result1.isMultipleBondDetectionNotSupported());
    }

    @Test
    public void test_constructor004() {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_TRUE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_FALSE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

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
        assertFalse(result1.isMultipleBondDetectionSupported());
        assertTrue(result1.isMultipleBondDetectionNotSupported());
    }

    @Test
    public void test_constructor005() {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_TRUE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_FALSE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

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
        assertFalse(result1.isMultipleBondDetectionSupported());
        assertTrue(result1.isMultipleBondDetectionNotSupported());
    }

    @Test
    public void test_constructor006() {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_TRUE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_FALSE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

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
        assertFalse(result1.isMultipleBondDetectionSupported());
        assertTrue(result1.isMultipleBondDetectionNotSupported());
    }

    @Test
    public void test_constructor007() {
        int flags = BloodPressureFeature.BODY_MOVEMENT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.CUFF_FIT_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.IRREGULAR_PULSE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.PULSE_RATE_RANGE_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MEASUREMENT_POSITION_DETECTION_SUPPORT_FALSE
                | BloodPressureFeature.MULTIPLE_BOND_SUPPORT_TRUE;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

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
        assertTrue(result1.isMultipleBondDetectionSupported());
        assertFalse(result1.isMultipleBondDetectionNotSupported());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

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
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureFeatureAndroid result1 = new BloodPressureFeatureAndroid(bluetoothGattCharacteristic);
        BloodPressureFeatureAndroid result2 = BloodPressureFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
