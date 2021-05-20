package org.im97mori.ble.characteristic.u2a69;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class PositionQualityAndroidTest {

    @Test
    public void test_constructor001() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsNumberOfBeasonsInSolutionNotPresent());
        assertFalse(result1.isFlagsNumberOfBeasonsInSolutionPresent());
    }

    @Test
    public void test_constructor002() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_TRUE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsNumberOfBeasonsInSolutionNotPresent());
        assertTrue(result1.isFlagsNumberOfBeasonsInSolutionPresent());
        assertEquals(0x01, result1.getNumberOfBeaconsInSolution());
    }

    @Test
    public void test_constructor003() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsNumberOfBeasonsInViewNotPresent());
        assertFalse(result1.isFlagsNumberOfBeasonsInViewPresent());
    }

    @Test
    public void test_constructor004() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_TRUE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsNumberOfBeasonsInViewNotPresent());
        assertTrue(result1.isFlagsNumberOfBeasonsInViewPresent());
        assertEquals(0x01, result1.getNumberOfBeaconsInView());
    }

    @Test
    public void test_constructor005() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsTimeToFirstFixNotPresent());
        assertFalse(result1.isFlagsTimeToFirstFixPresent());
    }

    @Test
    public void test_constructor006() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_TRUE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsTimeToFirstFixNotPresent());
        assertTrue(result1.isFlagsTimeToFirstFixPresent());
        assertEquals(0x0201, result1.getTimeToFirstFix());
        assertEquals(PositionQuality.TIME_TO_FIRST_FIX_RESOLUTION * 0x0201, result1.getTimeToFirstFixSeconds(), 0);
    }

    @Test
    public void test_constructor007() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsEhpeNotPresent());
        assertFalse(result1.isFlagsEhpePresent());
    }

    @Test
    public void test_constructor008() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_TRUE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsEhpeNotPresent());
        assertTrue(result1.isFlagsEhpePresent());
        assertEquals(0x04030201, result1.getEhpe());
        assertEquals(PositionQuality.EHPE_RESOLUTION * 0x04030201, result1.getEhpeMeters(), 0);
    }

    @Test
    public void test_constructor009() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagEvpeNotPresent());
        assertFalse(result1.isFlagEvpePresent());
    }

    @Test
    public void test_constructor010() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_TRUE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagEvpeNotPresent());
        assertTrue(result1.isFlagEvpePresent());
        assertEquals(0x04030201, result1.getEvpe());
        assertEquals(PositionQuality.EHPE_RESOLUTION * 0x04030201, result1.getEvpeMeters(), 0);
    }

    @Test
    public void test_constructor011() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsHdopNotPresent());
        assertFalse(result1.isFlagsHdopPresent());
    }

    @Test
    public void test_constructor012() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_TRUE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsHdopNotPresent());
        assertTrue(result1.isFlagsHdopPresent());
        assertEquals(0x01, result1.getHdop());
        assertEquals(PositionQuality.HDOP_RESOLUTION * 0x01, result1.getHdopWithUnit(), 0);
    }

    @Test
    public void test_constructor013() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsVdopNotPresent());
        assertFalse(result1.isFlagsVdopPresent());
    }

    @Test
    public void test_constructor014() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_TRUE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsVdopNotPresent());
        assertTrue(result1.isFlagsVdopPresent());
        assertEquals(0x01, result1.getVdop());
        assertEquals(PositionQuality.VDOP_RESOLUTION * 0x01, result1.getVdopWithUnit(), 0);
    }

    @Test
    public void test_constructor015() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsPositionStatusNoPosition());
        assertFalse(result1.isFlagsPositionStatusPositionOk());
        assertFalse(result1.isFlagsPositionStatusEstimatedPosition());
        assertFalse(result1.isFlagsPositionStatusLastKnownPosition());
    }

    @Test
    public void test_constructor016() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_POSITION_OK;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsPositionStatusNoPosition());
        assertTrue(result1.isFlagsPositionStatusPositionOk());
        assertFalse(result1.isFlagsPositionStatusEstimatedPosition());
        assertFalse(result1.isFlagsPositionStatusLastKnownPosition());
    }

    @Test
    public void test_constructor017() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_ESTIMATED_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsPositionStatusNoPosition());
        assertFalse(result1.isFlagsPositionStatusPositionOk());
        assertTrue(result1.isFlagsPositionStatusEstimatedPosition());
        assertFalse(result1.isFlagsPositionStatusLastKnownPosition());
    }

    @Test
    public void test_constructor018() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_LAST_KNOWN_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsPositionStatusNoPosition());
        assertFalse(result1.isFlagsPositionStatusPositionOk());
        assertFalse(result1.isFlagsPositionStatusEstimatedPosition());
        assertTrue(result1.isFlagsPositionStatusLastKnownPosition());
    }

    @Test
    public void test_parcelable001() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable002() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_TRUE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable003() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable004() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_TRUE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable005() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable006() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_TRUE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable007() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable008() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_TRUE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable009() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable010() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_TRUE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable011() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable012() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_TRUE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable013() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable014() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_TRUE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable015() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable016() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_POSITION_OK;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable017() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_ESTIMATED_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable018() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_LAST_KNOWN_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getNumberOfBeaconsInSolution(), result2.getNumberOfBeaconsInSolution());
        assertEquals(result1.getNumberOfBeaconsInView(), result2.getNumberOfBeaconsInView());
        assertEquals(result1.getTimeToFirstFix(), result2.getTimeToFirstFix());
        assertEquals(result1.getEhpe(), result2.getEhpe());
        assertEquals(result1.getEvpe(), result2.getEvpe());
        assertEquals(result1.getHdop(), result2.getHdop());
        assertEquals(result1.getVdop(), result2.getVdop());
    }

    @Test
    public void test_parcelable101() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_TRUE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_TRUE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable106() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_TRUE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable107() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable108() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_TRUE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable109() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable110() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_TRUE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable111() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable112() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_TRUE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable113() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable114() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_TRUE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable115() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable116() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_POSITION_OK;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable117() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_ESTIMATED_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable118() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_LAST_KNOWN_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_TRUE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_TRUE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable206() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_TRUE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable207() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable208() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_TRUE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable209() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable210() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_TRUE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable211() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable212() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_TRUE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable213() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable214() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_TRUE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable215() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_NO_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable216() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_POSITION_OK;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable217() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_ESTIMATED_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable218() {
        int flags = PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_SOLUTION_PRESENT_FALSE
                | PositionQuality.FLAGS_NUMBER_OF_BEACONS_IN_VIEW_PRESENT_FALSE
                | PositionQuality.FLAGS_TIME_TO_FIRST_FIX_PRESENT_FALSE
                | PositionQuality.FLAGS_EHPE_PRESENT_FALSE
                | PositionQuality.FLAGS_EVPE_PRESENT_FALSE
                | PositionQuality.FLAGS_HDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_VDOP_PRESENT_FALSE
                | PositionQuality.FLAGS_POSITION_STATUS_LAST_KNOWN_POSITION;
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PositionQualityAndroid result1 = new PositionQualityAndroid(bluetoothGattCharacteristic);
        PositionQualityAndroid result2 = PositionQualityAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
