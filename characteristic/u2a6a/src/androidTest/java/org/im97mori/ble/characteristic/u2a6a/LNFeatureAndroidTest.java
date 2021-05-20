package org.im97mori.ble.characteristic.u2a6a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class LNFeatureAndroidTest {

    @Test
    public void test_constructor001() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureInstantaneousSpeedNotSupported());
        assertFalse(result1.isLNFeatureInstantaneousSpeedSupported());
    }

    @Test
    public void test_constructor002() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureInstantaneousSpeedNotSupported());
        assertTrue(result1.isLNFeatureInstantaneousSpeedSupported());
    }

    @Test
    public void test_constructor003() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureTotalDistanceNotSupported());
        assertFalse(result1.isLNFeatureTotalDistanceSupported());
    }

    @Test
    public void test_constructor004() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureTotalDistanceNotSupported());
        assertTrue(result1.isLNFeatureTotalDistanceSupported());
    }

    @Test
    public void test_constructor005() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureLocationNotSupported());
        assertFalse(result1.isLNFeatureLocationSupported());
    }

    @Test
    public void test_constructor006() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureLocationNotSupported());
        assertTrue(result1.isLNFeatureLocationSupported());
    }

    @Test
    public void test_constructor007() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureElevationNotSupported());
        assertFalse(result1.isLNFeatureElevationSupported());
    }

    @Test
    public void test_constructor008() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureElevationNotSupported());
        assertTrue(result1.isLNFeatureElevationSupported());
    }

    @Test
    public void test_constructor009() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureHeadingNotSupported());
        assertFalse(result1.isLNFeatureHeadingSupported());
    }

    @Test
    public void test_constructor010() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureHeadingNotSupported());
        assertTrue(result1.isLNFeatureHeadingSupported());
    }

    @Test
    public void test_constructor011() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureRollingTimeNotSupported());
        assertFalse(result1.isLNFeatureRollingTimeSupported());
    }

    @Test
    public void test_constructor012() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureRollingTimeNotSupported());
        assertTrue(result1.isLNFeatureRollingTimeSupported());
    }

    @Test
    public void test_constructor013() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureUtcTimeNotSupported());
        assertFalse(result1.isLNFeatureUtcTimeSupported());
    }

    @Test
    public void test_constructor014() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureUtcTimeNotSupported());
        assertTrue(result1.isLNFeatureUtcTimeSupported());
    }

    @Test
    public void test_constructor015() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureRemainingDistanceNotSupported());
        assertFalse(result1.isLNFeatureRemainingDistanceSupported());
    }

    @Test
    public void test_constructor016() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureRemainingDistanceNotSupported());
        assertTrue(result1.isLNFeatureRemainingDistanceSupported());
    }

    @Test
    public void test_constructor017() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureRemainingVerticalDistanceNotSupported());
        assertFalse(result1.isLNFeatureRemainingVerticalDistanceSupported());
    }

    @Test
    public void test_constructor018() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureRemainingVerticalDistanceNotSupported());
        assertTrue(result1.isLNFeatureRemainingVerticalDistanceSupported());
    }

    @Test
    public void test_constructor019() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureEstimatedTimeOfArrivalNotSupported());
        assertFalse(result1.isLNFeatureEstimatedTimeOfArrivalSupported());
    }

    @Test
    public void test_constructor020() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureEstimatedTimeOfArrivalNotSupported());
        assertTrue(result1.isLNFeatureEstimatedTimeOfArrivalSupported());
    }

    @Test
    public void test_constructor021() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureNumberOfBeaconsInSolutionNotSupported());
        assertFalse(result1.isLNFeatureNumberOfBeaconsInSolutionSupported());
    }

    @Test
    public void test_constructor022() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureNumberOfBeaconsInSolutionNotSupported());
        assertTrue(result1.isLNFeatureNumberOfBeaconsInSolutionSupported());
    }

    @Test
    public void test_constructor023() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureNumberOfBeaconsInViewNotSupported());
        assertFalse(result1.isLNFeatureNumberOfBeaconsInViewSupported());
    }

    @Test
    public void test_constructor024() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureNumberOfBeaconsInViewNotSupported());
        assertTrue(result1.isLNFeatureNumberOfBeaconsInViewSupported());
    }

    @Test
    public void test_constructor025() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureTimeToFirstFixNotSupported());
        assertFalse(result1.isLNFeatureTimeToFirstFixSupported());
    }

    @Test
    public void test_constructor026() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureTimeToFirstFixNotSupported());
        assertTrue(result1.isLNFeatureTimeToFirstFixSupported());
    }

    @Test
    public void test_constructor027() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureEstimatedHorizontalPositionErrorNotSupported());
        assertFalse(result1.isLNFeatureEstimatedHorizontalPositionErrorSupported());
    }

    @Test
    public void test_constructor028() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureEstimatedHorizontalPositionErrorNotSupported());
        assertTrue(result1.isLNFeatureEstimatedHorizontalPositionErrorSupported());
    }

    @Test
    public void test_constructor029() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureEstimatedVerticalPositionErrorNotSupported());
        assertFalse(result1.isLNFeatureEstimatedVerticalPositionErrorSupported());
    }

    @Test
    public void test_constructor030() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureEstimatedVerticalPositionErrorNotSupported());
        assertTrue(result1.isLNFeatureEstimatedVerticalPositionErrorSupported());
    }

    @Test
    public void test_constructor031() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureHorizontalDilutionOfPrecisionNotSupported());
        assertFalse(result1.isLNFeatureHorizontalDilutionOfPrecisionSupported());
    }

    @Test
    public void test_constructor032() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureHorizontalDilutionOfPrecisionNotSupported());
        assertTrue(result1.isLNFeatureHorizontalDilutionOfPrecisionSupported());
    }

    @Test
    public void test_constructor033() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureVerticalDilutionOfPrecisionNotSupported());
        assertFalse(result1.isLNFeatureVerticalDilutionOfPrecisionSupported());
    }

    @Test
    public void test_constructor034() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureVerticalDilutionOfPrecisionNotSupported());
        assertTrue(result1.isLNFeatureVerticalDilutionOfPrecisionSupported());
    }

    @Test
    public void test_constructor035() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureLocationAndSpeedCharacteristicContentMaskingNotSupported());
        assertFalse(result1.isLNFeatureLocationAndSpeedCharacteristicContentMaskingSupported());
    }

    @Test
    public void test_constructor036() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureLocationAndSpeedCharacteristicContentMaskingNotSupported());
        assertTrue(result1.isLNFeatureLocationAndSpeedCharacteristicContentMaskingSupported());
    }

    @Test
    public void test_constructor037() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureFixRateSettingNotSupported());
        assertFalse(result1.isLNFeatureFixRateSettingSupported());
    }

    @Test
    public void test_constructor038() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureFixRateSettingNotSupported());
        assertTrue(result1.isLNFeatureFixRateSettingSupported());
    }

    @Test
    public void test_constructor039() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeatureElevationSettingNotSupported());
        assertFalse(result1.isLNFeatureElevationSettingSupported());
    }

    @Test
    public void test_constructor040() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeatureElevationSettingNotSupported());
        assertTrue(result1.isLNFeatureElevationSettingSupported());
    }

    @Test
    public void test_constructor041() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertTrue(result1.isLNFeaturePositionStatusNotSupported());
        assertFalse(result1.isLNFeaturePositionStatusSupported());
    }

    @Test
    public void test_constructor042() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_TRUE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getLNFeature());
        assertFalse(result1.isLNFeaturePositionStatusNotSupported());
        assertTrue(result1.isLNFeaturePositionStatusSupported());
    }

    @Test
    public void test_parcelable001() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable002() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable003() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable004() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable005() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable006() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable007() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable008() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable009() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable010() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable011() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable012() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable013() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable014() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable015() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable016() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable017() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable018() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable019() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable020() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable021() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable022() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable023() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable024() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable025() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable026() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable027() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable028() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable029() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable030() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable031() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable032() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable033() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable034() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable035() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable036() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable037() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable038() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable039() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable040() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable041() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable042() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_TRUE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable101() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable106() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable107() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable108() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable109() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable110() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable111() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable112() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable113() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable114() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable115() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable116() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable117() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable118() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable119() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable120() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable121() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable122() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable123() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable124() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable125() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable126() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable127() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable128() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable129() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable130() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable131() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable132() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable133() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable134() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable135() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable136() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable137() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable138() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable139() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable140() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable141() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable142() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_TRUE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable206() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable207() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable208() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable209() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable210() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable211() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable212() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable213() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable214() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable215() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable216() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable217() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable218() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable219() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable220() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable221() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable222() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable223() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable224() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getLNFeature(), result2.getLNFeature());
    }

    @Test
    public void test_parcelable225() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable226() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable227() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable228() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable229() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable230() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable231() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable232() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable233() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable234() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable235() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable236() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable237() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable238() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable239() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable240() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_TRUE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable241() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable242() {
        int flags = LNFeature.LN_FEATURE_INSTANTANEOUS_SPEED_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TOTAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HEADING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ROLLING_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_UTC_TIME_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_REMAINING_VERTICAL_DISTANCE_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_TIME_OF_ARRIVAL_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_SOLUTION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_NUMBER_OF_BEACONS_IN_VIEW_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_TIME_TO_FIRST_FIX_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_HORIZONTAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ESTIMATED_VERTICAL_POSITION_ERROR_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_HORIZONTAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_VERTICAL_DILUTION_OF_PRECISION_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_LOCATION_AND_SPEED_CHARACTERISTIC_CONTENT_MASKING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_FIX_RATE_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_ELEVATION_SETTING_SUPPORTED_FALSE
                | LNFeature.LN_FEATURE_POSITION_STATUS_SUPPORTED_TRUE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) (flags >> 16);
        data[ 3] = (byte) (flags >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LNFeatureAndroid result1 = new LNFeatureAndroid(bluetoothGattCharacteristic);
        LNFeatureAndroid result2 = LNFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
