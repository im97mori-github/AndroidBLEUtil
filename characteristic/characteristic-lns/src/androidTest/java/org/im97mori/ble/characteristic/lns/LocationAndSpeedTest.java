package org.im97mori.ble.characteristic.lns;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.DateTimeUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LocationAndSpeedTest {

    @Test
    public void test_constructor001() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsInstantaneousSpeedNotPresent());
        assertFalse(result1.isFlagsInstantaneousSpeedPresent());
    }

    @Test
    public void test_constructor002() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsInstantaneousSpeedNotPresent());
        assertTrue(result1.isFlagsInstantaneousSpeedPresent());
        assertEquals(0x0201, result1.getInstantaneousSpeed());
        assertEquals(LocationAndSpeed.INSTANTANEOUS_SPEED_RESOLUTION * 0x0201, result1.getInstantaneousSpeedMeters(), 0);
    }

    @Test
    public void test_constructor003() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsTotalDistanceNotPresent());
        assertFalse(result1.isFlagsTotalDistancePresent());
    }

    @Test
    public void test_constructor004() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsTotalDistanceNotPresent());
        assertTrue(result1.isFlagsTotalDistancePresent());
        assertEquals(0x030201, result1.getTotalDistance());
        assertEquals(LocationAndSpeed.TOTAL_DISTANCE_RESOLUTION * 0x030201, result1.getTotalDistanceMeters(), 0);
    }

    @Test
    public void test_constructor005() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsLocationNotPresent());
        assertFalse(result1.isFlagsLocationPresent());
    }

    @Test
    public void test_constructor006() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data[ 8] = 0x07;
        data[ 9] = 0x08;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsLocationNotPresent());
        assertTrue(result1.isFlagsLocationPresent());
        assertEquals(0x04030201, result1.getLocationLatitude());
        assertEquals(LocationAndSpeed.LOCATION_LATITUDE_RESOLUTION * 0x04030201, result1.getLocationLatitudeDegrees(), 0);
        assertEquals(0x08070605, result1.getLocationLongitude());
        assertEquals(LocationAndSpeed.LOCATION_LATITUDE_RESOLUTION * 0x08070605, result1.getLocationLongitudeDegrees(), 0);
    }

    @Test
    public void test_constructor007() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsElevationNotPresent());
        assertFalse(result1.isFlagsElevationPresent());
    }

    @Test
    public void test_constructor008() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsElevationNotPresent());
        assertTrue(result1.isFlagsElevationPresent());
        assertEquals(0x030201, result1.getElevation());
        assertEquals(LocationAndSpeed.ELEVATION_RESOLUTION * 0x030201, result1.getElevationMeters(), 0);
    }

    @Test
    public void test_constructor009() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsHeadingNotPresent());
        assertFalse(result1.isFlagsHeadingPresent());
    }

    @Test
    public void test_constructor010() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsHeadingNotPresent());
        assertTrue(result1.isFlagsHeadingPresent());
        assertEquals(0x0201, result1.getHeading());
        assertEquals(LocationAndSpeed.HEADING_RESOLUTION * 0x0201, result1.getHeadingDegrees(), 0);
    }

    @Test
    public void test_constructor011() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsRollingTimeNotPresent());
        assertFalse(result1.isFlagsRollingTimePresent());
    }

    @Test
    public void test_constructor012() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsRollingTimeNotPresent());
        assertTrue(result1.isFlagsRollingTimePresent());
        assertEquals(0x01, result1.getRollingTime());
    }

    @Test
    public void test_constructor013() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsUtcTimeNotPresent());
        assertFalse(result1.isFlagsUtcTimePresent());
    }

    @Test
    public void test_constructor014() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 1582;
        data[ 3] = (byte) (1582 >> 8);
        data[ 4] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 5] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsUtcTimeNotPresent());
        assertTrue(result1.isFlagsUtcTimePresent());
        assertEquals(1582, result1.getYear());
        assertEquals(DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN, result1.getMonth());
        assertEquals(0, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor015() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_JANUARY;
        data[ 5] = 1;
        data[ 6] = 23;
        data[ 7] = 59;
        data[ 8] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsUtcTimeNotPresent());
        assertTrue(result1.isFlagsUtcTimePresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JANUARY, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
    }

    @Test
    public void test_constructor016() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsUtcTimeNotPresent());
        assertTrue(result1.isFlagsUtcTimePresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_FEBRUARY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor017() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_MARCH;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsUtcTimeNotPresent());
        assertTrue(result1.isFlagsUtcTimePresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MARCH, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor018() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_APRIL;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsUtcTimeNotPresent());
        assertTrue(result1.isFlagsUtcTimePresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_APRIL, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor019() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_MAY;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsUtcTimeNotPresent());
        assertTrue(result1.isFlagsUtcTimePresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MAY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor020() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_JUNE;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsUtcTimeNotPresent());
        assertTrue(result1.isFlagsUtcTimePresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JUNE, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor021() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_JULY;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsUtcTimeNotPresent());
        assertTrue(result1.isFlagsUtcTimePresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JULY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor022() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_AUGUST;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsUtcTimeNotPresent());
        assertTrue(result1.isFlagsUtcTimePresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_AUGUST, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor023() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsUtcTimeNotPresent());
        assertTrue(result1.isFlagsUtcTimePresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_SEPTEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor024() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_OCTOBER;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsUtcTimeNotPresent());
        assertTrue(result1.isFlagsUtcTimePresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_OCTOBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
        ;
    }

    @Test
    public void test_constructor025() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsUtcTimeNotPresent());
        assertTrue(result1.isFlagsUtcTimePresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_NOVEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor026() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_DECEMBER;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsUtcTimeNotPresent());
        assertTrue(result1.isFlagsUtcTimePresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor027() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsPositionStatusNoPosition());
        assertFalse(result1.isFlagsPositionStatusPositionOk());
        assertFalse(result1.isFlagsPositionStatusEstimatedPosition());
        assertFalse(result1.isFlagsPositionStatusLastKnownPosition());
    }

    @Test
    public void test_constructor028() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_POSITION_OK
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsPositionStatusNoPosition());
        assertTrue(result1.isFlagsPositionStatusPositionOk());
        assertFalse(result1.isFlagsPositionStatusEstimatedPosition());
        assertFalse(result1.isFlagsPositionStatusLastKnownPosition());
    }

    @Test
    public void test_constructor029() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_ESTIMATED_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsPositionStatusNoPosition());
        assertFalse(result1.isFlagsPositionStatusPositionOk());
        assertTrue(result1.isFlagsPositionStatusEstimatedPosition());
        assertFalse(result1.isFlagsPositionStatusLastKnownPosition());
    }

    @Test
    public void test_constructor030() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_LAST_KNOWN_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsPositionStatusNoPosition());
        assertFalse(result1.isFlagsPositionStatusPositionOk());
        assertFalse(result1.isFlagsPositionStatusEstimatedPosition());
        assertTrue(result1.isFlagsPositionStatusLastKnownPosition());
    }

    @Test
    public void test_constructor031() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsSpeedAndDistanceFormat2d());
        assertFalse(result1.isFlagsSpeedAndDistanceFormat3d());
    }

    @Test
    public void test_constructor032() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_3D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsSpeedAndDistanceFormat2d());
        assertTrue(result1.isFlagsSpeedAndDistanceFormat3d());
    }

    @Test
    public void test_constructor033() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsElevationSourcePositionSystem());
        assertFalse(result1.isFlagsElevationSourceBarometricAirPressure());
        assertFalse(result1.isFlagsElevationSourceDatabase());
        assertFalse(result1.isFlagsElevationOther());
    }

    @Test
    public void test_constructor034() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_BAROMETRIC_AIR_PRESSURE
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsElevationSourcePositionSystem());
        assertTrue(result1.isFlagsElevationSourceBarometricAirPressure());
        assertFalse(result1.isFlagsElevationSourceDatabase());
        assertFalse(result1.isFlagsElevationOther());
    }

    @Test
    public void test_constructor035() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_DATABASE_SERVICE
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsElevationSourcePositionSystem());
        assertFalse(result1.isFlagsElevationSourceBarometricAirPressure());
        assertTrue(result1.isFlagsElevationSourceDatabase());
        assertFalse(result1.isFlagsElevationOther());
    }

    @Test
    public void test_constructor036() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_OTHER
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsElevationSourcePositionSystem());
        assertFalse(result1.isFlagsElevationSourceBarometricAirPressure());
        assertFalse(result1.isFlagsElevationSourceDatabase());
        assertTrue(result1.isFlagsElevationOther());
    }

    @Test
    public void test_constructor037() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsHeadingSourceHeadingBasedOnMovement());
        assertFalse(result1.isFlagsHeadingSourceHeadingBasedOnMagneticCompass());
    }

    @Test
    public void test_constructor038() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MAGNETIC_COMPASS;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsHeadingSourceHeadingBasedOnMovement());
        assertTrue(result1.isFlagsHeadingSourceHeadingBasedOnMagneticCompass());
    }

    @Test
    public void test_parcelable001() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable002() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable003() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable004() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable005() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable006() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data[ 8] = 0x07;
        data[ 9] = 0x08;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable007() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable008() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable009() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable010() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable011() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable012() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable013() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable014() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 1582;
        data[ 3] = (byte) (1582 >> 8);
        data[ 4] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 5] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable015() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_JANUARY;
        data[ 5] = 1;
        data[ 6] = 23;
        data[ 7] = 59;
        data[ 8] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable016() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable017() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_MARCH;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable018() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_APRIL;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable019() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_MAY;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable020() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_JUNE;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable021() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_JULY;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable022() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_AUGUST;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable023() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable024() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_OCTOBER;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable025() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable026() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_DECEMBER;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable027() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable028() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_POSITION_OK
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable029() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_ESTIMATED_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable030() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_LAST_KNOWN_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable031() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable032() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_3D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable033() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable034() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_BAROMETRIC_AIR_PRESSURE
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable035() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_DATABASE_SERVICE
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable036() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_OTHER
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable037() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable038() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MAGNETIC_COMPASS;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getInstantaneousSpeed(), result2.getInstantaneousSpeed());
        assertEquals(result1.getTotalDistance(), result2.getTotalDistance());
        assertEquals(result1.getLocationLatitude(), result2.getLocationLatitude());
        assertEquals(result1.getLocationLongitude(), result2.getLocationLongitude());
        assertEquals(result1.getElevation(), result2.getElevation());
        assertEquals(result1.getHeading(), result2.getHeading());
        assertEquals(result1.getRollingTime(), result2.getRollingTime());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
    }

    @Test
    public void test_parcelable101() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable106() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data[ 8] = 0x07;
        data[ 9] = 0x08;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable107() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable108() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable109() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable110() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable111() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable112() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable113() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable114() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 1582;
        data[ 3] = (byte) (1582 >> 8);
        data[ 4] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 5] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable115() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_JANUARY;
        data[ 5] = 1;
        data[ 6] = 23;
        data[ 7] = 59;
        data[ 8] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable116() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable117() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_MARCH;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable118() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_APRIL;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable119() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_MAY;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable120() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_JUNE;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable121() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_JULY;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable122() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_AUGUST;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable123() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable124() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_OCTOBER;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable125() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable126() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_DECEMBER;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable127() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable128() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_POSITION_OK
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable129() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_ESTIMATED_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable130() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_LAST_KNOWN_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable131() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable132() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_3D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable133() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable134() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_BAROMETRIC_AIR_PRESSURE
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable135() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_DATABASE_SERVICE
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable136() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_OTHER
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable137() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable138() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MAGNETIC_COMPASS;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable206() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data[ 8] = 0x07;
        data[ 9] = 0x08;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable207() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable208() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable209() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable210() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable211() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable212() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable213() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable214() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 1582;
        data[ 3] = (byte) (1582 >> 8);
        data[ 4] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 5] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable215() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_JANUARY;
        data[ 5] = 1;
        data[ 6] = 23;
        data[ 7] = 59;
        data[ 8] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable216() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable217() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_MARCH;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable218() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_APRIL;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable219() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_MAY;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable220() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_JUNE;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable221() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_JULY;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable222() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_AUGUST;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable223() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable224() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_OCTOBER;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable225() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable226() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_TRUE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) 9999;
        data[ 3] = (byte) (9999 >> 8);
        data[ 4] = DateTimeUtils.MONTH_DECEMBER;
        data[ 5] = 31;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable227() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable228() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_POSITION_OK
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable229() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_ESTIMATED_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable230() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_LAST_KNOWN_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable231() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable232() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_3D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable233() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable234() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_BAROMETRIC_AIR_PRESSURE
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable235() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_DATABASE_SERVICE
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable236() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_OTHER
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable237() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MOVEMENT;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable238() {
        int flags = LocationAndSpeed.FLAGS_INSTANTANEOUS_SPEED_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_TOTAL_DISTANCE_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_LOCATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ELEVATION_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_HEADING_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_ROLLING_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_UTC_TIME_PRESENT_FALSE
                | LocationAndSpeed.FLAGS_POSITION_SATUS_NO_POSITION
                | LocationAndSpeed.FLAGS_SPEED_AND_DISTANCE_FORMAT_2D
                | LocationAndSpeed.FLAGS_ELEVATION_SOURCE_POSITION_SYSTEM
                | LocationAndSpeed.FLAGS_HEADING_SOURCE_HEADING_BASED_ON_MAGNETIC_COMPASS;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LocationAndSpeed result1 = new LocationAndSpeed(bluetoothGattCharacteristic);
        LocationAndSpeed result2 = LocationAndSpeed.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
