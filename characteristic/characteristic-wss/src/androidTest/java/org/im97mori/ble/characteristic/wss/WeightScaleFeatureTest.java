package org.im97mori.ble.characteristic.wss;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WeightScaleFeatureTest {

    @Test
    public void test_constructor001() {
        int flags = WeightScaleFeature.TIME_STAMP_SUPPORTED_FALSE
                | WeightScaleFeature.MULTIPLE_USERS_SUPPORTED_FALSE
                | WeightScaleFeature.BMI_SUPPORTED_FALSE
                | WeightScaleFeature.WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | WeightScaleFeature.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getWeightScaleFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBmiSupported());
        assertTrue(result1.isBmiNotSupported());
        assertTrue(result1.isWeightScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isWeightScaleMeasurementResolution1());
        assertFalse(result1.isWeightScaleMeasurementResolution2());
        assertFalse(result1.isWeightScaleMeasurementResolution3());
        assertFalse(result1.isWeightScaleMeasurementResolution4());
        assertFalse(result1.isWeightScaleMeasurementResolution5());
        assertFalse(result1.isWeightScaleMeasurementResolution6());
        assertFalse(result1.isWeightScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor002() {
        int flags = WeightScaleFeature.TIME_STAMP_SUPPORTED_TRUE
                | WeightScaleFeature.MULTIPLE_USERS_SUPPORTED_FALSE
                | WeightScaleFeature.BMI_SUPPORTED_FALSE
                | WeightScaleFeature.WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | WeightScaleFeature.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getWeightScaleFeature());
        assertTrue(result1.isTimeStampSupported());
        assertFalse(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBmiSupported());
        assertTrue(result1.isBmiNotSupported());
        assertTrue(result1.isWeightScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isWeightScaleMeasurementResolution1());
        assertFalse(result1.isWeightScaleMeasurementResolution2());
        assertFalse(result1.isWeightScaleMeasurementResolution3());
        assertFalse(result1.isWeightScaleMeasurementResolution4());
        assertFalse(result1.isWeightScaleMeasurementResolution5());
        assertFalse(result1.isWeightScaleMeasurementResolution6());
        assertFalse(result1.isWeightScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor003() {
        int flags = WeightScaleFeature.TIME_STAMP_SUPPORTED_FALSE
                | WeightScaleFeature.MULTIPLE_USERS_SUPPORTED_TRUE
                | WeightScaleFeature.BMI_SUPPORTED_FALSE
                | WeightScaleFeature.WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | WeightScaleFeature.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getWeightScaleFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertTrue(result1.isMultipleUsersSupported());
        assertFalse(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBmiSupported());
        assertTrue(result1.isBmiNotSupported());
        assertTrue(result1.isWeightScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isWeightScaleMeasurementResolution1());
        assertFalse(result1.isWeightScaleMeasurementResolution2());
        assertFalse(result1.isWeightScaleMeasurementResolution3());
        assertFalse(result1.isWeightScaleMeasurementResolution4());
        assertFalse(result1.isWeightScaleMeasurementResolution5());
        assertFalse(result1.isWeightScaleMeasurementResolution6());
        assertFalse(result1.isWeightScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor004() {
        int flags = WeightScaleFeature.TIME_STAMP_SUPPORTED_FALSE
                | WeightScaleFeature.MULTIPLE_USERS_SUPPORTED_FALSE
                | WeightScaleFeature.BMI_SUPPORTED_TRUE
                | WeightScaleFeature.WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | WeightScaleFeature.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getWeightScaleFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertTrue(result1.isBmiSupported());
        assertFalse(result1.isBmiNotSupported());
        assertTrue(result1.isWeightScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isWeightScaleMeasurementResolution1());
        assertFalse(result1.isWeightScaleMeasurementResolution2());
        assertFalse(result1.isWeightScaleMeasurementResolution3());
        assertFalse(result1.isWeightScaleMeasurementResolution4());
        assertFalse(result1.isWeightScaleMeasurementResolution5());
        assertFalse(result1.isWeightScaleMeasurementResolution6());
        assertFalse(result1.isWeightScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor005() {
        int flags = WeightScaleFeature.TIME_STAMP_SUPPORTED_FALSE
                | WeightScaleFeature.MULTIPLE_USERS_SUPPORTED_FALSE
                | WeightScaleFeature.BMI_SUPPORTED_FALSE
                | WeightScaleFeature.WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_5KG_OR_1LB
                | WeightScaleFeature.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getWeightScaleFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBmiSupported());
        assertTrue(result1.isBmiNotSupported());
        assertFalse(result1.isWeightScaleMeasurementResolutionNotSpecified());
        assertTrue(result1.isWeightScaleMeasurementResolution1());
        assertFalse(result1.isWeightScaleMeasurementResolution2());
        assertFalse(result1.isWeightScaleMeasurementResolution3());
        assertFalse(result1.isWeightScaleMeasurementResolution4());
        assertFalse(result1.isWeightScaleMeasurementResolution5());
        assertFalse(result1.isWeightScaleMeasurementResolution6());
        assertFalse(result1.isWeightScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor006() {
        int flags = WeightScaleFeature.TIME_STAMP_SUPPORTED_FALSE
                | WeightScaleFeature.MULTIPLE_USERS_SUPPORTED_FALSE
                | WeightScaleFeature.BMI_SUPPORTED_FALSE
                | WeightScaleFeature.WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_2KG_OR_0_5LB
                | WeightScaleFeature.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getWeightScaleFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBmiSupported());
        assertTrue(result1.isBmiNotSupported());
        assertFalse(result1.isWeightScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isWeightScaleMeasurementResolution1());
        assertTrue(result1.isWeightScaleMeasurementResolution2());
        assertFalse(result1.isWeightScaleMeasurementResolution3());
        assertFalse(result1.isWeightScaleMeasurementResolution4());
        assertFalse(result1.isWeightScaleMeasurementResolution5());
        assertFalse(result1.isWeightScaleMeasurementResolution6());
        assertFalse(result1.isWeightScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor007() {
        int flags = WeightScaleFeature.TIME_STAMP_SUPPORTED_FALSE
                | WeightScaleFeature.MULTIPLE_USERS_SUPPORTED_FALSE
                | WeightScaleFeature.BMI_SUPPORTED_FALSE
                | WeightScaleFeature.WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_1KG_OR_0_2LB
                | WeightScaleFeature.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getWeightScaleFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBmiSupported());
        assertTrue(result1.isBmiNotSupported());
        assertFalse(result1.isWeightScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isWeightScaleMeasurementResolution1());
        assertFalse(result1.isWeightScaleMeasurementResolution2());
        assertTrue(result1.isWeightScaleMeasurementResolution3());
        assertFalse(result1.isWeightScaleMeasurementResolution4());
        assertFalse(result1.isWeightScaleMeasurementResolution5());
        assertFalse(result1.isWeightScaleMeasurementResolution6());
        assertFalse(result1.isWeightScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor008() {
        int flags = WeightScaleFeature.TIME_STAMP_SUPPORTED_FALSE
                | WeightScaleFeature.MULTIPLE_USERS_SUPPORTED_FALSE
                | WeightScaleFeature.BMI_SUPPORTED_FALSE
                | WeightScaleFeature.WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_05KG_OR_0_1B
                | WeightScaleFeature.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getWeightScaleFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBmiSupported());
        assertTrue(result1.isBmiNotSupported());
        assertFalse(result1.isWeightScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isWeightScaleMeasurementResolution1());
        assertFalse(result1.isWeightScaleMeasurementResolution2());
        assertFalse(result1.isWeightScaleMeasurementResolution3());
        assertTrue(result1.isWeightScaleMeasurementResolution4());
        assertFalse(result1.isWeightScaleMeasurementResolution5());
        assertFalse(result1.isWeightScaleMeasurementResolution6());
        assertFalse(result1.isWeightScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor009() {
        int flags = WeightScaleFeature.TIME_STAMP_SUPPORTED_FALSE
                | WeightScaleFeature.MULTIPLE_USERS_SUPPORTED_FALSE
                | WeightScaleFeature.BMI_SUPPORTED_FALSE
                | WeightScaleFeature.WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_02KG_OR_0_05B
                | WeightScaleFeature.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getWeightScaleFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBmiSupported());
        assertTrue(result1.isBmiNotSupported());
        assertFalse(result1.isWeightScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isWeightScaleMeasurementResolution1());
        assertFalse(result1.isWeightScaleMeasurementResolution2());
        assertFalse(result1.isWeightScaleMeasurementResolution3());
        assertFalse(result1.isWeightScaleMeasurementResolution4());
        assertTrue(result1.isWeightScaleMeasurementResolution5());
        assertFalse(result1.isWeightScaleMeasurementResolution6());
        assertFalse(result1.isWeightScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor010() {
        int flags = WeightScaleFeature.TIME_STAMP_SUPPORTED_FALSE
                | WeightScaleFeature.MULTIPLE_USERS_SUPPORTED_FALSE
                | WeightScaleFeature.BMI_SUPPORTED_FALSE
                | WeightScaleFeature.WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_01KG_OR_0_02B
                | WeightScaleFeature.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getWeightScaleFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBmiSupported());
        assertTrue(result1.isBmiNotSupported());
        assertFalse(result1.isWeightScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isWeightScaleMeasurementResolution1());
        assertFalse(result1.isWeightScaleMeasurementResolution2());
        assertFalse(result1.isWeightScaleMeasurementResolution3());
        assertFalse(result1.isWeightScaleMeasurementResolution4());
        assertFalse(result1.isWeightScaleMeasurementResolution5());
        assertTrue(result1.isWeightScaleMeasurementResolution6());
        assertFalse(result1.isWeightScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor011() {
        int flags = WeightScaleFeature.TIME_STAMP_SUPPORTED_FALSE
                | WeightScaleFeature.MULTIPLE_USERS_SUPPORTED_FALSE
                | WeightScaleFeature.BMI_SUPPORTED_FALSE
                | WeightScaleFeature.WEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_005KG_OR_0_01B
                | WeightScaleFeature.HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getWeightScaleFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBmiSupported());
        assertTrue(result1.isBmiNotSupported());
        assertFalse(result1.isWeightScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isWeightScaleMeasurementResolution1());
        assertFalse(result1.isWeightScaleMeasurementResolution2());
        assertFalse(result1.isWeightScaleMeasurementResolution3());
        assertFalse(result1.isWeightScaleMeasurementResolution4());
        assertFalse(result1.isWeightScaleMeasurementResolution5());
        assertFalse(result1.isWeightScaleMeasurementResolution6());
        assertTrue(result1.isWeightScaleMeasurementResolution7());
        assertTrue(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor012() {
        int flags = WeightScaleFeature.TIME_STAMP_SUPPORTED_FALSE
                | WeightScaleFeature.MULTIPLE_USERS_SUPPORTED_FALSE
                | WeightScaleFeature.BMI_SUPPORTED_FALSE
                | WeightScaleFeature.WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | WeightScaleFeature.HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_01_METER_OR_1INCH;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getWeightScaleFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBmiSupported());
        assertTrue(result1.isBmiNotSupported());
        assertTrue(result1.isWeightScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isWeightScaleMeasurementResolution1());
        assertFalse(result1.isWeightScaleMeasurementResolution2());
        assertFalse(result1.isWeightScaleMeasurementResolution3());
        assertFalse(result1.isWeightScaleMeasurementResolution4());
        assertFalse(result1.isWeightScaleMeasurementResolution5());
        assertFalse(result1.isWeightScaleMeasurementResolution6());
        assertFalse(result1.isWeightScaleMeasurementResolution7());
        assertFalse(result1.isHeightMeasurementResolutionNotSpecified());
        assertTrue(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor013() {
        int flags = WeightScaleFeature.TIME_STAMP_SUPPORTED_FALSE
                | WeightScaleFeature.MULTIPLE_USERS_SUPPORTED_FALSE
                | WeightScaleFeature.BMI_SUPPORTED_FALSE
                | WeightScaleFeature.WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | WeightScaleFeature.HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_005METER_OR_0_5INCH;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getWeightScaleFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBmiSupported());
        assertTrue(result1.isBmiNotSupported());
        assertTrue(result1.isWeightScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isWeightScaleMeasurementResolution1());
        assertFalse(result1.isWeightScaleMeasurementResolution2());
        assertFalse(result1.isWeightScaleMeasurementResolution3());
        assertFalse(result1.isWeightScaleMeasurementResolution4());
        assertFalse(result1.isWeightScaleMeasurementResolution5());
        assertFalse(result1.isWeightScaleMeasurementResolution6());
        assertFalse(result1.isWeightScaleMeasurementResolution7());
        assertFalse(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertTrue(result1.isHeightMeasurementResolution2());
        assertFalse(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_constructor014() {
        int flags = WeightScaleFeature.TIME_STAMP_SUPPORTED_FALSE
                | WeightScaleFeature.MULTIPLE_USERS_SUPPORTED_FALSE
                | WeightScaleFeature.BMI_SUPPORTED_FALSE
                | WeightScaleFeature.WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                | WeightScaleFeature.HEIGHT_MEASUREMENT_RESOLUTION_RESOLUTION_OF_0_001METER_OR_0_1INCH;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getWeightScaleFeature());
        assertFalse(result1.isTimeStampSupported());
        assertTrue(result1.isTimeStampNotSupported());
        assertFalse(result1.isMultipleUsersSupported());
        assertTrue(result1.isMultipleUsersNotSupported());
        assertFalse(result1.isBmiSupported());
        assertTrue(result1.isBmiNotSupported());
        assertTrue(result1.isWeightScaleMeasurementResolutionNotSpecified());
        assertFalse(result1.isWeightScaleMeasurementResolution1());
        assertFalse(result1.isWeightScaleMeasurementResolution2());
        assertFalse(result1.isWeightScaleMeasurementResolution3());
        assertFalse(result1.isWeightScaleMeasurementResolution4());
        assertFalse(result1.isWeightScaleMeasurementResolution5());
        assertFalse(result1.isWeightScaleMeasurementResolution6());
        assertFalse(result1.isWeightScaleMeasurementResolution7());
        assertFalse(result1.isHeightMeasurementResolutionNotSpecified());
        assertFalse(result1.isHeightMeasurementResolution1());
        assertFalse(result1.isHeightMeasurementResolution2());
        assertTrue(result1.isHeightMeasurementResolution3());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightScaleFeature result2 = WeightScaleFeature.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getWeightScaleFeature(), result2.getWeightScaleFeature());
        assertEquals(result1.isTimeStampSupported(), result2.isTimeStampSupported());
        assertEquals(result1.isTimeStampNotSupported(), result2.isTimeStampNotSupported());
        assertEquals(result1.isMultipleUsersSupported(), result2.isMultipleUsersSupported());
        assertEquals(result1.isMultipleUsersNotSupported(), result2.isMultipleUsersNotSupported());
        assertEquals(result1.isBmiSupported(), result2.isBmiSupported());
        assertEquals(result1.isBmiNotSupported(), result2.isBmiNotSupported());
        assertEquals(result1.isWeightScaleMeasurementResolutionNotSpecified(), result2.isWeightScaleMeasurementResolutionNotSpecified());
        assertEquals(result1.isWeightScaleMeasurementResolution1(), result2.isWeightScaleMeasurementResolution1());
        assertEquals(result1.isWeightScaleMeasurementResolution2(), result2.isWeightScaleMeasurementResolution2());
        assertEquals(result1.isWeightScaleMeasurementResolution3(), result2.isWeightScaleMeasurementResolution3());
        assertEquals(result1.isWeightScaleMeasurementResolution4(), result2.isWeightScaleMeasurementResolution4());
        assertEquals(result1.isWeightScaleMeasurementResolution5(), result2.isWeightScaleMeasurementResolution5());
        assertEquals(result1.isWeightScaleMeasurementResolution6(), result2.isWeightScaleMeasurementResolution6());
        assertEquals(result1.isWeightScaleMeasurementResolution7(), result2.isWeightScaleMeasurementResolution7());
        assertEquals(result1.isHeightMeasurementResolutionNotSpecified(), result2.isHeightMeasurementResolutionNotSpecified());
        assertEquals(result1.isHeightMeasurementResolution1(), result2.isHeightMeasurementResolution1());
        assertEquals(result1.isHeightMeasurementResolution2(), result2.isHeightMeasurementResolution2());
        assertEquals(result1.isHeightMeasurementResolution3(), result2.isHeightMeasurementResolution3());
    }


    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightScaleFeature result1 = new WeightScaleFeature(bluetoothGattCharacteristic);
        WeightScaleFeature result2 = WeightScaleFeature.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
