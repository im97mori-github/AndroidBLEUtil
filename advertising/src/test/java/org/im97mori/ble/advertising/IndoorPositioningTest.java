package org.im97mori.ble.advertising;

import static org.im97mori.ble.constants.DataType.INDOOR_POSITIONING_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.IndoorPositioningUtils;
import org.im97mori.ble.advertising.IndoorPositioningAndroid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressWarnings({"unused"})
public class IndoorPositioningTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[2];
        data[ 0] = 1;
        data[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        data_00001 = data;
    }

    private static final byte[] data_00101;
    static {
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] data = new byte[11];
        data[ 0] = 10;
        data[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        data[ 2] = (byte) flag;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data[ 5] = 0x03;
        data[ 6] = 0x04;
        data[ 7] = 0x05;
        data[ 8] = 0x06;
        data[ 9] = 0x07;
        data[10] = 0x08;
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_LOCAL_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] data = new byte[7];
        data[ 0] = 6;
        data[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        data[ 2] = (byte) flag;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data[ 5] = 0x03;
        data[ 6] = 0x04;
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] data = new byte[4];
        data[ 0] = 3;
        data[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        data[ 2] = (byte) flag;
        data[ 3] = 0x01;
        data_00201 = data;
    }

    private static final byte[] data_00301;
    static {
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] data = new byte[5];
        data[ 0] = 4;
        data[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        data[ 2] = (byte) flag;
        data[ 3] = 0x01;
        data[ 4] = 0x02;
        data_00301 = data;
    }

    private static final byte[] data_00401;
    static {
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] data = new byte[4];
        data[ 0] = 3;
        data[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        data[ 2] = (byte) flag;
        data[ 3] = 0x01;
        data_00401 = data;
    }

    private static final byte[] data_00501;
    static {
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] data = new byte[4];
        data[ 0] = 3;
        data[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        data[ 2] = (byte) flag;
        data[ 3] = IndoorPositioningUtils.UNCERTAINTY_PRECISION_IDEAL;
        data_00501 = data;
    }

    private static final byte[] data_00502;
    static {
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] data = new byte[4];
        data[ 0] = 3;
        data[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        data[ 2] = (byte) flag;
        data[ 3] = IndoorPositioningUtils.UNCERTAINTY_PRECISION_EXCELLENT;
        data_00502 = data;
    }

    private static final byte[] data_00503;
    static {
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] data = new byte[4];
        data[ 0] = 3;
        data[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        data[ 2] = (byte) flag;
        data[ 3] = IndoorPositioningUtils.UNCERTAINTY_PRECISION_GOOD;
        data_00503 = data;
    }

    private static final byte[] data_00504;
    static {
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] data = new byte[4];
        data[ 0] = 3;
        data[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        data[ 2] = (byte) flag;
        data[ 3] = IndoorPositioningUtils.UNCERTAINTY_PRECISION_MODERATE;
        data_00504 = data;
    }

    private static final byte[] data_00505;
    static {
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] data = new byte[4];
        data[ 0] = 3;
        data[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        data[ 2] = (byte) flag;
        data[ 3] = IndoorPositioningUtils.UNCERTAINTY_PRECISION_FAIR;
        data_00505 = data;
    }

    private static final byte[] data_00506;
    static {
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] data = new byte[4];
        data[ 0] = 3;
        data[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        data[ 2] = (byte) flag;
        data[ 3] = IndoorPositioningUtils.UNCERTAINTY_PRECISION_POOR;
        data_00506 = data;
    }

    private static final byte[] data_00507;
    static {
        int flag = IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_COORDINATES_IN_ADVERTISING_PACKETS_COORDINATES_ARE_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_COORDINATE_SYSTEM_USED_IN_ADVERTISING_PACKETS_WGS84_COORDINATE_SYSTEM
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_TX_POWER_FIELD_IN_ADVERTISING_PACKETS_TX_POWER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_ALTITUDE_FIELD_IN_ADVERTISING_PACKETS_ALTITUDE_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_FLOOR_NUMBER_IN_ADVERTISING_PACKETS_FLOOR_NUMBER_IS_NOT_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_PRESENCE_OF_UNCERTAINTY_IN_ADVERTISING_PACKETS_UNCERTAINTY_IS_PRESENT
                | IndoorPositioningUtils.INDOOR_POSITIONING_CONFIGURATION_LOCATION_NAME_AVAILABLE_IN_THE_GATT_DATABASE_LOCATION_NAME_IS_NOT_PRESENT;
        byte[] data = new byte[4];
        data[ 0] = 3;
        data[ 1] = INDOOR_POSITIONING_DATA_TYPE;
        data[ 2] = (byte) flag;
        data[ 3] = IndoorPositioningUtils.UNCERTAINTY_PRECISION_USELESS;
        data_00507 = data;
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
            String[] stringArray = stackTraceElement.getMethodName().split("_");
            try {
                data = (byte[]) this.getClass().getDeclaredField("data_" + stringArray[stringArray.length - 1]).get(null);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(0, result1.getIndoorPositioningConfiguration());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
    }

    @Test
    public void test_constructor_1_00101() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(0x04030201, result1.getGlobalCoordinatesLatitude());
        assertEquals(0x08070605, result1.getGlobalCoordinatesLongitude());
    }

    @Test
    public void test_constructor_1_00102() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(0x0201, result1.getLocalCoordinatesNorth());
        assertEquals(0x0403, result1.getLocalCoordinatesEast());
    }

    @Test
    public void test_constructor_1_00201() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(0x01, result1.getTxPower());
    }

    @Test
    public void test_constructor_1_00301() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(0x0201, result1.getAltitude());
    }

    @Test
    public void test_constructor_1_00401() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(0x01, result1.getFloorNumber());
    }

    @Test
    public void test_constructor_1_00501() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_IDEAL, result1.getUncertainty());
    }

    @Test
    public void test_constructor_1_00502() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_EXCELLENT, result1.getUncertainty());
    }

    @Test
    public void test_constructor_1_00503() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_GOOD, result1.getUncertainty());
    }

    @Test
    public void test_constructor_1_00504() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_MODERATE, result1.getUncertainty());
    }

    @Test
    public void test_constructor_1_00505() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_FAIR, result1.getUncertainty());
    }

    @Test
    public void test_constructor_1_00506() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_POOR, result1.getUncertainty());
    }

    @Test
    public void test_constructor_1_00507() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_USELESS, result1.getUncertainty());
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(0, result1.getIndoorPositioningConfiguration());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
    }

    @Test
    public void test_constructor_2_00101() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(0x04030201, result1.getGlobalCoordinatesLatitude());
        assertEquals(0x08070605, result1.getGlobalCoordinatesLongitude());
    }

    @Test
    public void test_constructor_2_00102() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(0x0201, result1.getLocalCoordinatesNorth());
        assertEquals(0x0403, result1.getLocalCoordinatesEast());
    }

    @Test
    public void test_constructor_2_00201() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(0x01, result1.getTxPower());
    }

    @Test
    public void test_constructor_2_00301() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(0x0201, result1.getAltitude());
    }

    @Test
    public void test_constructor_2_00401() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(0x01, result1.getFloorNumber());
    }

    @Test
    public void test_constructor_2_00501() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_IDEAL, result1.getUncertainty());
    }

    @Test
    public void test_constructor_2_00502() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_EXCELLENT, result1.getUncertainty());
    }

    @Test
    public void test_constructor_2_00503() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_GOOD, result1.getUncertainty());
    }

    @Test
    public void test_constructor_2_00504() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_MODERATE, result1.getUncertainty());
    }

    @Test
    public void test_constructor_2_00505() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_FAIR, result1.getUncertainty());
    }

    @Test
    public void test_constructor_2_00506() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_POOR, result1.getUncertainty());
    }

    @Test
    public void test_constructor_2_00507() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_USELESS, result1.getUncertainty());
    }

    @Test
    public void test_constructor_3_00001() {
        byte[] data = getData();

        int indoorPositioningConfiguration;
        int globalCoordinatesLatitude;
        int globalCoordinatesLongitude;
        int localCoordinatesNorth;
        int localCoordinatesEast;
        int txPower;
        int floorNumber;
        int altitude;
        int uncertainty;
        int index = 2;
        if (data[0] > 1) {
            indoorPositioningConfiguration = (data[index++] & 0xff);
        } else {
            indoorPositioningConfiguration = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(indoorPositioningConfiguration)) {
            if (IndoorPositioningUtils.isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(indoorPositioningConfiguration)) {
                globalCoordinatesLatitude = BLEUtils.createSInt32(data, index);
                index += 4;
                globalCoordinatesLongitude = BLEUtils.createSInt32(data, index);
                index += 4;
                localCoordinatesNorth = 0;
                localCoordinatesEast = 0;
            } else {
                globalCoordinatesLatitude = 0;
                globalCoordinatesLongitude = 0;
                localCoordinatesNorth = BLEUtils.createSInt16(data, index);
                index += 2;
                localCoordinatesEast = BLEUtils.createSInt16(data, index);
                index += 2;
            }
        } else {
            globalCoordinatesLatitude = 0;
            globalCoordinatesLongitude = 0;
            localCoordinatesNorth = 0;
            localCoordinatesEast = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(indoorPositioningConfiguration)) {
            txPower = BLEUtils.createSInt8(data, index++);
        } else {
            txPower = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(indoorPositioningConfiguration)) {
            floorNumber = BLEUtils.createUInt8(data, index++);
        } else {
            floorNumber = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(indoorPositioningConfiguration)) {
            altitude = BLEUtils.createUInt16(data, index);
            index += 2;
        } else {
            altitude = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(indoorPositioningConfiguration)) {
            uncertainty = BLEUtils.createUInt8(data, index);
        } else {
            uncertainty = 0;
        }
        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(indoorPositioningConfiguration
                , globalCoordinatesLatitude
                , globalCoordinatesLongitude
                , localCoordinatesNorth
                , localCoordinatesEast
                , txPower
                , floorNumber
                , altitude
                , uncertainty);
        assertEquals(data[0], result1.getLength());
        assertEquals(0, result1.getIndoorPositioningConfiguration());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
    }

    @Test
    public void test_constructor_3_00101() {
        byte[] data = getData();

        int indoorPositioningConfiguration;
        int globalCoordinatesLatitude;
        int globalCoordinatesLongitude;
        int localCoordinatesNorth;
        int localCoordinatesEast;
        int txPower;
        int floorNumber;
        int altitude;
        int uncertainty;
        int index = 2;
        if (data[0] > 1) {
            indoorPositioningConfiguration = (data[index++] & 0xff);
        } else {
            indoorPositioningConfiguration = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(indoorPositioningConfiguration)) {
            if (IndoorPositioningUtils.isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(indoorPositioningConfiguration)) {
                globalCoordinatesLatitude = BLEUtils.createSInt32(data, index);
                index += 4;
                globalCoordinatesLongitude = BLEUtils.createSInt32(data, index);
                index += 4;
                localCoordinatesNorth = 0;
                localCoordinatesEast = 0;
            } else {
                globalCoordinatesLatitude = 0;
                globalCoordinatesLongitude = 0;
                localCoordinatesNorth = BLEUtils.createSInt16(data, index);
                index += 2;
                localCoordinatesEast = BLEUtils.createSInt16(data, index);
                index += 2;
            }
        } else {
            globalCoordinatesLatitude = 0;
            globalCoordinatesLongitude = 0;
            localCoordinatesNorth = 0;
            localCoordinatesEast = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(indoorPositioningConfiguration)) {
            txPower = BLEUtils.createSInt8(data, index++);
        } else {
            txPower = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(indoorPositioningConfiguration)) {
            floorNumber = BLEUtils.createUInt8(data, index++);
        } else {
            floorNumber = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(indoorPositioningConfiguration)) {
            altitude = BLEUtils.createUInt16(data, index);
            index += 2;
        } else {
            altitude = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(indoorPositioningConfiguration)) {
            uncertainty = BLEUtils.createUInt8(data, index);
        } else {
            uncertainty = 0;
        }
        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(indoorPositioningConfiguration
                , globalCoordinatesLatitude
                , globalCoordinatesLongitude
                , localCoordinatesNorth
                , localCoordinatesEast
                , txPower
                , floorNumber
                , altitude
                , uncertainty);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(0x04030201, result1.getGlobalCoordinatesLatitude());
        assertEquals(0x08070605, result1.getGlobalCoordinatesLongitude());
    }

    @Test
    public void test_constructor_3_00102() {
        byte[] data = getData();

        int indoorPositioningConfiguration;
        int globalCoordinatesLatitude;
        int globalCoordinatesLongitude;
        int localCoordinatesNorth;
        int localCoordinatesEast;
        int txPower;
        int floorNumber;
        int altitude;
        int uncertainty;
        int index = 2;
        if (data[0] > 1) {
            indoorPositioningConfiguration = (data[index++] & 0xff);
        } else {
            indoorPositioningConfiguration = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(indoorPositioningConfiguration)) {
            if (IndoorPositioningUtils.isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(indoorPositioningConfiguration)) {
                globalCoordinatesLatitude = BLEUtils.createSInt32(data, index);
                index += 4;
                globalCoordinatesLongitude = BLEUtils.createSInt32(data, index);
                index += 4;
                localCoordinatesNorth = 0;
                localCoordinatesEast = 0;
            } else {
                globalCoordinatesLatitude = 0;
                globalCoordinatesLongitude = 0;
                localCoordinatesNorth = BLEUtils.createSInt16(data, index);
                index += 2;
                localCoordinatesEast = BLEUtils.createSInt16(data, index);
                index += 2;
            }
        } else {
            globalCoordinatesLatitude = 0;
            globalCoordinatesLongitude = 0;
            localCoordinatesNorth = 0;
            localCoordinatesEast = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(indoorPositioningConfiguration)) {
            txPower = BLEUtils.createSInt8(data, index++);
        } else {
            txPower = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(indoorPositioningConfiguration)) {
            floorNumber = BLEUtils.createUInt8(data, index++);
        } else {
            floorNumber = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(indoorPositioningConfiguration)) {
            altitude = BLEUtils.createUInt16(data, index);
            index += 2;
        } else {
            altitude = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(indoorPositioningConfiguration)) {
            uncertainty = BLEUtils.createUInt8(data, index);
        } else {
            uncertainty = 0;
        }
        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(indoorPositioningConfiguration
                , globalCoordinatesLatitude
                , globalCoordinatesLongitude
                , localCoordinatesNorth
                , localCoordinatesEast
                , txPower
                , floorNumber
                , altitude
                , uncertainty);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(0x0201, result1.getLocalCoordinatesNorth());
        assertEquals(0x0403, result1.getLocalCoordinatesEast());
    }

    @Test
    public void test_constructor_3_00201() {
        byte[] data = getData();

        int indoorPositioningConfiguration;
        int globalCoordinatesLatitude;
        int globalCoordinatesLongitude;
        int localCoordinatesNorth;
        int localCoordinatesEast;
        int txPower;
        int floorNumber;
        int altitude;
        int uncertainty;
        int index = 2;
        if (data[0] > 1) {
            indoorPositioningConfiguration = (data[index++] & 0xff);
        } else {
            indoorPositioningConfiguration = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(indoorPositioningConfiguration)) {
            if (IndoorPositioningUtils.isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(indoorPositioningConfiguration)) {
                globalCoordinatesLatitude = BLEUtils.createSInt32(data, index);
                index += 4;
                globalCoordinatesLongitude = BLEUtils.createSInt32(data, index);
                index += 4;
                localCoordinatesNorth = 0;
                localCoordinatesEast = 0;
            } else {
                globalCoordinatesLatitude = 0;
                globalCoordinatesLongitude = 0;
                localCoordinatesNorth = BLEUtils.createSInt16(data, index);
                index += 2;
                localCoordinatesEast = BLEUtils.createSInt16(data, index);
                index += 2;
            }
        } else {
            globalCoordinatesLatitude = 0;
            globalCoordinatesLongitude = 0;
            localCoordinatesNorth = 0;
            localCoordinatesEast = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(indoorPositioningConfiguration)) {
            txPower = BLEUtils.createSInt8(data, index++);
        } else {
            txPower = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(indoorPositioningConfiguration)) {
            floorNumber = BLEUtils.createUInt8(data, index++);
        } else {
            floorNumber = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(indoorPositioningConfiguration)) {
            altitude = BLEUtils.createUInt16(data, index);
            index += 2;
        } else {
            altitude = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(indoorPositioningConfiguration)) {
            uncertainty = BLEUtils.createUInt8(data, index);
        } else {
            uncertainty = 0;
        }
        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(indoorPositioningConfiguration
                , globalCoordinatesLatitude
                , globalCoordinatesLongitude
                , localCoordinatesNorth
                , localCoordinatesEast
                , txPower
                , floorNumber
                , altitude
                , uncertainty);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(0x01, result1.getTxPower());
    }

    @Test
    public void test_constructor_3_00301() {
        byte[] data = getData();

        int indoorPositioningConfiguration;
        int globalCoordinatesLatitude;
        int globalCoordinatesLongitude;
        int localCoordinatesNorth;
        int localCoordinatesEast;
        int txPower;
        int floorNumber;
        int altitude;
        int uncertainty;
        int index = 2;
        if (data[0] > 1) {
            indoorPositioningConfiguration = (data[index++] & 0xff);
        } else {
            indoorPositioningConfiguration = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(indoorPositioningConfiguration)) {
            if (IndoorPositioningUtils.isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(indoorPositioningConfiguration)) {
                globalCoordinatesLatitude = BLEUtils.createSInt32(data, index);
                index += 4;
                globalCoordinatesLongitude = BLEUtils.createSInt32(data, index);
                index += 4;
                localCoordinatesNorth = 0;
                localCoordinatesEast = 0;
            } else {
                globalCoordinatesLatitude = 0;
                globalCoordinatesLongitude = 0;
                localCoordinatesNorth = BLEUtils.createSInt16(data, index);
                index += 2;
                localCoordinatesEast = BLEUtils.createSInt16(data, index);
                index += 2;
            }
        } else {
            globalCoordinatesLatitude = 0;
            globalCoordinatesLongitude = 0;
            localCoordinatesNorth = 0;
            localCoordinatesEast = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(indoorPositioningConfiguration)) {
            txPower = BLEUtils.createSInt8(data, index++);
        } else {
            txPower = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(indoorPositioningConfiguration)) {
            floorNumber = BLEUtils.createUInt8(data, index++);
        } else {
            floorNumber = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(indoorPositioningConfiguration)) {
            altitude = BLEUtils.createUInt16(data, index);
            index += 2;
        } else {
            altitude = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(indoorPositioningConfiguration)) {
            uncertainty = BLEUtils.createUInt8(data, index);
        } else {
            uncertainty = 0;
        }
        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(indoorPositioningConfiguration
                , globalCoordinatesLatitude
                , globalCoordinatesLongitude
                , localCoordinatesNorth
                , localCoordinatesEast
                , txPower
                , floorNumber
                , altitude
                , uncertainty);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(0x0201, result1.getAltitude());
    }

    @Test
    public void test_constructor_3_00401() {
        byte[] data = getData();

        int indoorPositioningConfiguration;
        int globalCoordinatesLatitude;
        int globalCoordinatesLongitude;
        int localCoordinatesNorth;
        int localCoordinatesEast;
        int txPower;
        int floorNumber;
        int altitude;
        int uncertainty;
        int index = 2;
        if (data[0] > 1) {
            indoorPositioningConfiguration = (data[index++] & 0xff);
        } else {
            indoorPositioningConfiguration = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(indoorPositioningConfiguration)) {
            if (IndoorPositioningUtils.isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(indoorPositioningConfiguration)) {
                globalCoordinatesLatitude = BLEUtils.createSInt32(data, index);
                index += 4;
                globalCoordinatesLongitude = BLEUtils.createSInt32(data, index);
                index += 4;
                localCoordinatesNorth = 0;
                localCoordinatesEast = 0;
            } else {
                globalCoordinatesLatitude = 0;
                globalCoordinatesLongitude = 0;
                localCoordinatesNorth = BLEUtils.createSInt16(data, index);
                index += 2;
                localCoordinatesEast = BLEUtils.createSInt16(data, index);
                index += 2;
            }
        } else {
            globalCoordinatesLatitude = 0;
            globalCoordinatesLongitude = 0;
            localCoordinatesNorth = 0;
            localCoordinatesEast = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(indoorPositioningConfiguration)) {
            txPower = BLEUtils.createSInt8(data, index++);
        } else {
            txPower = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(indoorPositioningConfiguration)) {
            floorNumber = BLEUtils.createUInt8(data, index++);
        } else {
            floorNumber = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(indoorPositioningConfiguration)) {
            altitude = BLEUtils.createUInt16(data, index);
            index += 2;
        } else {
            altitude = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(indoorPositioningConfiguration)) {
            uncertainty = BLEUtils.createUInt8(data, index);
        } else {
            uncertainty = 0;
        }
        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(indoorPositioningConfiguration
                , globalCoordinatesLatitude
                , globalCoordinatesLongitude
                , localCoordinatesNorth
                , localCoordinatesEast
                , txPower
                , floorNumber
                , altitude
                , uncertainty);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(0x01, result1.getFloorNumber());
    }

    @Test
    public void test_constructor_3_00501() {
        byte[] data = getData();

        int indoorPositioningConfiguration;
        int globalCoordinatesLatitude;
        int globalCoordinatesLongitude;
        int localCoordinatesNorth;
        int localCoordinatesEast;
        int txPower;
        int floorNumber;
        int altitude;
        int uncertainty;
        int index = 2;
        if (data[0] > 1) {
            indoorPositioningConfiguration = (data[index++] & 0xff);
        } else {
            indoorPositioningConfiguration = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(indoorPositioningConfiguration)) {
            if (IndoorPositioningUtils.isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(indoorPositioningConfiguration)) {
                globalCoordinatesLatitude = BLEUtils.createSInt32(data, index);
                index += 4;
                globalCoordinatesLongitude = BLEUtils.createSInt32(data, index);
                index += 4;
                localCoordinatesNorth = 0;
                localCoordinatesEast = 0;
            } else {
                globalCoordinatesLatitude = 0;
                globalCoordinatesLongitude = 0;
                localCoordinatesNorth = BLEUtils.createSInt16(data, index);
                index += 2;
                localCoordinatesEast = BLEUtils.createSInt16(data, index);
                index += 2;
            }
        } else {
            globalCoordinatesLatitude = 0;
            globalCoordinatesLongitude = 0;
            localCoordinatesNorth = 0;
            localCoordinatesEast = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(indoorPositioningConfiguration)) {
            txPower = BLEUtils.createSInt8(data, index++);
        } else {
            txPower = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(indoorPositioningConfiguration)) {
            floorNumber = BLEUtils.createUInt8(data, index++);
        } else {
            floorNumber = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(indoorPositioningConfiguration)) {
            altitude = BLEUtils.createUInt16(data, index);
            index += 2;
        } else {
            altitude = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(indoorPositioningConfiguration)) {
            uncertainty = BLEUtils.createUInt8(data, index);
        } else {
            uncertainty = 0;
        }
        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(indoorPositioningConfiguration
                , globalCoordinatesLatitude
                , globalCoordinatesLongitude
                , localCoordinatesNorth
                , localCoordinatesEast
                , txPower
                , floorNumber
                , altitude
                , uncertainty);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_IDEAL, result1.getUncertainty());
    }

    @Test
    public void test_constructor_3_00502() {
        byte[] data = getData();

        int indoorPositioningConfiguration;
        int globalCoordinatesLatitude;
        int globalCoordinatesLongitude;
        int localCoordinatesNorth;
        int localCoordinatesEast;
        int txPower;
        int floorNumber;
        int altitude;
        int uncertainty;
        int index = 2;
        if (data[0] > 1) {
            indoorPositioningConfiguration = (data[index++] & 0xff);
        } else {
            indoorPositioningConfiguration = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(indoorPositioningConfiguration)) {
            if (IndoorPositioningUtils.isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(indoorPositioningConfiguration)) {
                globalCoordinatesLatitude = BLEUtils.createSInt32(data, index);
                index += 4;
                globalCoordinatesLongitude = BLEUtils.createSInt32(data, index);
                index += 4;
                localCoordinatesNorth = 0;
                localCoordinatesEast = 0;
            } else {
                globalCoordinatesLatitude = 0;
                globalCoordinatesLongitude = 0;
                localCoordinatesNorth = BLEUtils.createSInt16(data, index);
                index += 2;
                localCoordinatesEast = BLEUtils.createSInt16(data, index);
                index += 2;
            }
        } else {
            globalCoordinatesLatitude = 0;
            globalCoordinatesLongitude = 0;
            localCoordinatesNorth = 0;
            localCoordinatesEast = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(indoorPositioningConfiguration)) {
            txPower = BLEUtils.createSInt8(data, index++);
        } else {
            txPower = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(indoorPositioningConfiguration)) {
            floorNumber = BLEUtils.createUInt8(data, index++);
        } else {
            floorNumber = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(indoorPositioningConfiguration)) {
            altitude = BLEUtils.createUInt16(data, index);
            index += 2;
        } else {
            altitude = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(indoorPositioningConfiguration)) {
            uncertainty = BLEUtils.createUInt8(data, index);
        } else {
            uncertainty = 0;
        }
        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(indoorPositioningConfiguration
                , globalCoordinatesLatitude
                , globalCoordinatesLongitude
                , localCoordinatesNorth
                , localCoordinatesEast
                , txPower
                , floorNumber
                , altitude
                , uncertainty);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_EXCELLENT, result1.getUncertainty());
    }

    @Test
    public void test_constructor_3_00503() {
        byte[] data = getData();

        int indoorPositioningConfiguration;
        int globalCoordinatesLatitude;
        int globalCoordinatesLongitude;
        int localCoordinatesNorth;
        int localCoordinatesEast;
        int txPower;
        int floorNumber;
        int altitude;
        int uncertainty;
        int index = 2;
        if (data[0] > 1) {
            indoorPositioningConfiguration = (data[index++] & 0xff);
        } else {
            indoorPositioningConfiguration = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(indoorPositioningConfiguration)) {
            if (IndoorPositioningUtils.isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(indoorPositioningConfiguration)) {
                globalCoordinatesLatitude = BLEUtils.createSInt32(data, index);
                index += 4;
                globalCoordinatesLongitude = BLEUtils.createSInt32(data, index);
                index += 4;
                localCoordinatesNorth = 0;
                localCoordinatesEast = 0;
            } else {
                globalCoordinatesLatitude = 0;
                globalCoordinatesLongitude = 0;
                localCoordinatesNorth = BLEUtils.createSInt16(data, index);
                index += 2;
                localCoordinatesEast = BLEUtils.createSInt16(data, index);
                index += 2;
            }
        } else {
            globalCoordinatesLatitude = 0;
            globalCoordinatesLongitude = 0;
            localCoordinatesNorth = 0;
            localCoordinatesEast = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(indoorPositioningConfiguration)) {
            txPower = BLEUtils.createSInt8(data, index++);
        } else {
            txPower = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(indoorPositioningConfiguration)) {
            floorNumber = BLEUtils.createUInt8(data, index++);
        } else {
            floorNumber = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(indoorPositioningConfiguration)) {
            altitude = BLEUtils.createUInt16(data, index);
            index += 2;
        } else {
            altitude = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(indoorPositioningConfiguration)) {
            uncertainty = BLEUtils.createUInt8(data, index);
        } else {
            uncertainty = 0;
        }
        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(indoorPositioningConfiguration
                , globalCoordinatesLatitude
                , globalCoordinatesLongitude
                , localCoordinatesNorth
                , localCoordinatesEast
                , txPower
                , floorNumber
                , altitude
                , uncertainty);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_GOOD, result1.getUncertainty());
    }

    @Test
    public void test_constructor_3_00504() {
        byte[] data = getData();

        int indoorPositioningConfiguration;
        int globalCoordinatesLatitude;
        int globalCoordinatesLongitude;
        int localCoordinatesNorth;
        int localCoordinatesEast;
        int txPower;
        int floorNumber;
        int altitude;
        int uncertainty;
        int index = 2;
        if (data[0] > 1) {
            indoorPositioningConfiguration = (data[index++] & 0xff);
        } else {
            indoorPositioningConfiguration = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(indoorPositioningConfiguration)) {
            if (IndoorPositioningUtils.isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(indoorPositioningConfiguration)) {
                globalCoordinatesLatitude = BLEUtils.createSInt32(data, index);
                index += 4;
                globalCoordinatesLongitude = BLEUtils.createSInt32(data, index);
                index += 4;
                localCoordinatesNorth = 0;
                localCoordinatesEast = 0;
            } else {
                globalCoordinatesLatitude = 0;
                globalCoordinatesLongitude = 0;
                localCoordinatesNorth = BLEUtils.createSInt16(data, index);
                index += 2;
                localCoordinatesEast = BLEUtils.createSInt16(data, index);
                index += 2;
            }
        } else {
            globalCoordinatesLatitude = 0;
            globalCoordinatesLongitude = 0;
            localCoordinatesNorth = 0;
            localCoordinatesEast = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(indoorPositioningConfiguration)) {
            txPower = BLEUtils.createSInt8(data, index++);
        } else {
            txPower = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(indoorPositioningConfiguration)) {
            floorNumber = BLEUtils.createUInt8(data, index++);
        } else {
            floorNumber = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(indoorPositioningConfiguration)) {
            altitude = BLEUtils.createUInt16(data, index);
            index += 2;
        } else {
            altitude = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(indoorPositioningConfiguration)) {
            uncertainty = BLEUtils.createUInt8(data, index);
        } else {
            uncertainty = 0;
        }
        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(indoorPositioningConfiguration
                , globalCoordinatesLatitude
                , globalCoordinatesLongitude
                , localCoordinatesNorth
                , localCoordinatesEast
                , txPower
                , floorNumber
                , altitude
                , uncertainty);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_MODERATE, result1.getUncertainty());
    }

    @Test
    public void test_constructor_3_00505() {
        byte[] data = getData();

        int indoorPositioningConfiguration;
        int globalCoordinatesLatitude;
        int globalCoordinatesLongitude;
        int localCoordinatesNorth;
        int localCoordinatesEast;
        int txPower;
        int floorNumber;
        int altitude;
        int uncertainty;
        int index = 2;
        if (data[0] > 1) {
            indoorPositioningConfiguration = (data[index++] & 0xff);
        } else {
            indoorPositioningConfiguration = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(indoorPositioningConfiguration)) {
            if (IndoorPositioningUtils.isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(indoorPositioningConfiguration)) {
                globalCoordinatesLatitude = BLEUtils.createSInt32(data, index);
                index += 4;
                globalCoordinatesLongitude = BLEUtils.createSInt32(data, index);
                index += 4;
                localCoordinatesNorth = 0;
                localCoordinatesEast = 0;
            } else {
                globalCoordinatesLatitude = 0;
                globalCoordinatesLongitude = 0;
                localCoordinatesNorth = BLEUtils.createSInt16(data, index);
                index += 2;
                localCoordinatesEast = BLEUtils.createSInt16(data, index);
                index += 2;
            }
        } else {
            globalCoordinatesLatitude = 0;
            globalCoordinatesLongitude = 0;
            localCoordinatesNorth = 0;
            localCoordinatesEast = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(indoorPositioningConfiguration)) {
            txPower = BLEUtils.createSInt8(data, index++);
        } else {
            txPower = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(indoorPositioningConfiguration)) {
            floorNumber = BLEUtils.createUInt8(data, index++);
        } else {
            floorNumber = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(indoorPositioningConfiguration)) {
            altitude = BLEUtils.createUInt16(data, index);
            index += 2;
        } else {
            altitude = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(indoorPositioningConfiguration)) {
            uncertainty = BLEUtils.createUInt8(data, index);
        } else {
            uncertainty = 0;
        }
        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(indoorPositioningConfiguration
                , globalCoordinatesLatitude
                , globalCoordinatesLongitude
                , localCoordinatesNorth
                , localCoordinatesEast
                , txPower
                , floorNumber
                , altitude
                , uncertainty);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_FAIR, result1.getUncertainty());
    }

    @Test
    public void test_constructor_3_00506() {
        byte[] data = getData();

        int indoorPositioningConfiguration;
        int globalCoordinatesLatitude;
        int globalCoordinatesLongitude;
        int localCoordinatesNorth;
        int localCoordinatesEast;
        int txPower;
        int floorNumber;
        int altitude;
        int uncertainty;
        int index = 2;
        if (data[0] > 1) {
            indoorPositioningConfiguration = (data[index++] & 0xff);
        } else {
            indoorPositioningConfiguration = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(indoorPositioningConfiguration)) {
            if (IndoorPositioningUtils.isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(indoorPositioningConfiguration)) {
                globalCoordinatesLatitude = BLEUtils.createSInt32(data, index);
                index += 4;
                globalCoordinatesLongitude = BLEUtils.createSInt32(data, index);
                index += 4;
                localCoordinatesNorth = 0;
                localCoordinatesEast = 0;
            } else {
                globalCoordinatesLatitude = 0;
                globalCoordinatesLongitude = 0;
                localCoordinatesNorth = BLEUtils.createSInt16(data, index);
                index += 2;
                localCoordinatesEast = BLEUtils.createSInt16(data, index);
                index += 2;
            }
        } else {
            globalCoordinatesLatitude = 0;
            globalCoordinatesLongitude = 0;
            localCoordinatesNorth = 0;
            localCoordinatesEast = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(indoorPositioningConfiguration)) {
            txPower = BLEUtils.createSInt8(data, index++);
        } else {
            txPower = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(indoorPositioningConfiguration)) {
            floorNumber = BLEUtils.createUInt8(data, index++);
        } else {
            floorNumber = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(indoorPositioningConfiguration)) {
            altitude = BLEUtils.createUInt16(data, index);
            index += 2;
        } else {
            altitude = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(indoorPositioningConfiguration)) {
            uncertainty = BLEUtils.createUInt8(data, index);
        } else {
            uncertainty = 0;
        }
        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(indoorPositioningConfiguration
                , globalCoordinatesLatitude
                , globalCoordinatesLongitude
                , localCoordinatesNorth
                , localCoordinatesEast
                , txPower
                , floorNumber
                , altitude
                , uncertainty);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_POOR, result1.getUncertainty());
    }

    @Test
    public void test_constructor_3_00507() {
        byte[] data = getData();

        int indoorPositioningConfiguration;
        int globalCoordinatesLatitude;
        int globalCoordinatesLongitude;
        int localCoordinatesNorth;
        int localCoordinatesEast;
        int txPower;
        int floorNumber;
        int altitude;
        int uncertainty;
        int index = 2;
        if (data[0] > 1) {
            indoorPositioningConfiguration = (data[index++] & 0xff);
        } else {
            indoorPositioningConfiguration = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfCoordinatesInAdvertisingPacketsCoordinatesArePresent(indoorPositioningConfiguration)) {
            if (IndoorPositioningUtils.isIndoorPositioningConfigurationCoordinateSystemUsedInAdvertisingPacketsWgs84CoordinateSystem(indoorPositioningConfiguration)) {
                globalCoordinatesLatitude = BLEUtils.createSInt32(data, index);
                index += 4;
                globalCoordinatesLongitude = BLEUtils.createSInt32(data, index);
                index += 4;
                localCoordinatesNorth = 0;
                localCoordinatesEast = 0;
            } else {
                globalCoordinatesLatitude = 0;
                globalCoordinatesLongitude = 0;
                localCoordinatesNorth = BLEUtils.createSInt16(data, index);
                index += 2;
                localCoordinatesEast = BLEUtils.createSInt16(data, index);
                index += 2;
            }
        } else {
            globalCoordinatesLatitude = 0;
            globalCoordinatesLongitude = 0;
            localCoordinatesNorth = 0;
            localCoordinatesEast = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfTxPowerFieldInAdvertisingPacketsTxPowerIsPresent(indoorPositioningConfiguration)) {
            txPower = BLEUtils.createSInt8(data, index++);
        } else {
            txPower = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfFloorNumberInAdvertisingPacketsFloorNumberIsPresent(indoorPositioningConfiguration)) {
            floorNumber = BLEUtils.createUInt8(data, index++);
        } else {
            floorNumber = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfAltitudeFieldInAdvertisingPacketsAltitudeIsPresent(indoorPositioningConfiguration)) {
            altitude = BLEUtils.createUInt16(data, index);
            index += 2;
        } else {
            altitude = 0;
        }

        if (IndoorPositioningUtils.isIndoorPositioningConfigurationPresenceOfUncertaintyInAdvertisingPacketsUncertaintyIsPresent(indoorPositioningConfiguration)) {
            uncertainty = BLEUtils.createUInt8(data, index);
        } else {
            uncertainty = 0;
        }
        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(indoorPositioningConfiguration
                , globalCoordinatesLatitude
                , globalCoordinatesLongitude
                , localCoordinatesNorth
                , localCoordinatesEast
                , txPower
                , floorNumber
                , altitude
                , uncertainty);
        assertEquals(data[0], result1.getLength());
        assertEquals(INDOOR_POSITIONING_DATA_TYPE, result1.getDataType());
        assertEquals(data[2], result1.getIndoorPositioningConfiguration());
        assertEquals(IndoorPositioningUtils.UNCERTAINTY_PRECISION_USELESS, result1.getUncertainty());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
        assertEquals(result1.getGlobalCoordinatesLatitude(), result2.getGlobalCoordinatesLatitude());
        assertEquals(result1.getGlobalCoordinatesLongitude(), result2.getGlobalCoordinatesLongitude());
        assertEquals(result1.getLocalCoordinatesNorth(), result2.getLocalCoordinatesNorth());
        assertEquals(result1.getLocalCoordinatesEast(), result2.getLocalCoordinatesEast());
        assertEquals(result1.getTxPower(), result2.getTxPower());
        assertEquals(result1.getFloorNumber(), result2.getFloorNumber());
        assertEquals(result1.getAltitude(), result2.getAltitude());
        assertEquals(result1.getUncertainty(), result2.getUncertainty());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
        assertEquals(result1.getGlobalCoordinatesLatitude(), result2.getGlobalCoordinatesLatitude());
        assertEquals(result1.getGlobalCoordinatesLongitude(), result2.getGlobalCoordinatesLongitude());
        assertEquals(result1.getLocalCoordinatesNorth(), result2.getLocalCoordinatesNorth());
        assertEquals(result1.getLocalCoordinatesEast(), result2.getLocalCoordinatesEast());
        assertEquals(result1.getTxPower(), result2.getTxPower());
        assertEquals(result1.getFloorNumber(), result2.getFloorNumber());
        assertEquals(result1.getAltitude(), result2.getAltitude());
        assertEquals(result1.getUncertainty(), result2.getUncertainty());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
        assertEquals(result1.getGlobalCoordinatesLatitude(), result2.getGlobalCoordinatesLatitude());
        assertEquals(result1.getGlobalCoordinatesLongitude(), result2.getGlobalCoordinatesLongitude());
        assertEquals(result1.getLocalCoordinatesNorth(), result2.getLocalCoordinatesNorth());
        assertEquals(result1.getLocalCoordinatesEast(), result2.getLocalCoordinatesEast());
        assertEquals(result1.getTxPower(), result2.getTxPower());
        assertEquals(result1.getFloorNumber(), result2.getFloorNumber());
        assertEquals(result1.getAltitude(), result2.getAltitude());
        assertEquals(result1.getUncertainty(), result2.getUncertainty());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
        assertEquals(result1.getGlobalCoordinatesLatitude(), result2.getGlobalCoordinatesLatitude());
        assertEquals(result1.getGlobalCoordinatesLongitude(), result2.getGlobalCoordinatesLongitude());
        assertEquals(result1.getLocalCoordinatesNorth(), result2.getLocalCoordinatesNorth());
        assertEquals(result1.getLocalCoordinatesEast(), result2.getLocalCoordinatesEast());
        assertEquals(result1.getTxPower(), result2.getTxPower());
        assertEquals(result1.getFloorNumber(), result2.getFloorNumber());
        assertEquals(result1.getAltitude(), result2.getAltitude());
        assertEquals(result1.getUncertainty(), result2.getUncertainty());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
        assertEquals(result1.getGlobalCoordinatesLatitude(), result2.getGlobalCoordinatesLatitude());
        assertEquals(result1.getGlobalCoordinatesLongitude(), result2.getGlobalCoordinatesLongitude());
        assertEquals(result1.getLocalCoordinatesNorth(), result2.getLocalCoordinatesNorth());
        assertEquals(result1.getLocalCoordinatesEast(), result2.getLocalCoordinatesEast());
        assertEquals(result1.getTxPower(), result2.getTxPower());
        assertEquals(result1.getFloorNumber(), result2.getFloorNumber());
        assertEquals(result1.getAltitude(), result2.getAltitude());
        assertEquals(result1.getUncertainty(), result2.getUncertainty());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
        assertEquals(result1.getGlobalCoordinatesLatitude(), result2.getGlobalCoordinatesLatitude());
        assertEquals(result1.getGlobalCoordinatesLongitude(), result2.getGlobalCoordinatesLongitude());
        assertEquals(result1.getLocalCoordinatesNorth(), result2.getLocalCoordinatesNorth());
        assertEquals(result1.getLocalCoordinatesEast(), result2.getLocalCoordinatesEast());
        assertEquals(result1.getTxPower(), result2.getTxPower());
        assertEquals(result1.getFloorNumber(), result2.getFloorNumber());
        assertEquals(result1.getAltitude(), result2.getAltitude());
        assertEquals(result1.getUncertainty(), result2.getUncertainty());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
        assertEquals(result1.getGlobalCoordinatesLatitude(), result2.getGlobalCoordinatesLatitude());
        assertEquals(result1.getGlobalCoordinatesLongitude(), result2.getGlobalCoordinatesLongitude());
        assertEquals(result1.getLocalCoordinatesNorth(), result2.getLocalCoordinatesNorth());
        assertEquals(result1.getLocalCoordinatesEast(), result2.getLocalCoordinatesEast());
        assertEquals(result1.getTxPower(), result2.getTxPower());
        assertEquals(result1.getFloorNumber(), result2.getFloorNumber());
        assertEquals(result1.getAltitude(), result2.getAltitude());
        assertEquals(result1.getUncertainty(), result2.getUncertainty());
    }

    @Test
    public void test_parcelable_1_00502() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
        assertEquals(result1.getGlobalCoordinatesLatitude(), result2.getGlobalCoordinatesLatitude());
        assertEquals(result1.getGlobalCoordinatesLongitude(), result2.getGlobalCoordinatesLongitude());
        assertEquals(result1.getLocalCoordinatesNorth(), result2.getLocalCoordinatesNorth());
        assertEquals(result1.getLocalCoordinatesEast(), result2.getLocalCoordinatesEast());
        assertEquals(result1.getTxPower(), result2.getTxPower());
        assertEquals(result1.getFloorNumber(), result2.getFloorNumber());
        assertEquals(result1.getAltitude(), result2.getAltitude());
        assertEquals(result1.getUncertainty(), result2.getUncertainty());
    }

    @Test
    public void test_parcelable_1_00503() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
        assertEquals(result1.getGlobalCoordinatesLatitude(), result2.getGlobalCoordinatesLatitude());
        assertEquals(result1.getGlobalCoordinatesLongitude(), result2.getGlobalCoordinatesLongitude());
        assertEquals(result1.getLocalCoordinatesNorth(), result2.getLocalCoordinatesNorth());
        assertEquals(result1.getLocalCoordinatesEast(), result2.getLocalCoordinatesEast());
        assertEquals(result1.getTxPower(), result2.getTxPower());
        assertEquals(result1.getFloorNumber(), result2.getFloorNumber());
        assertEquals(result1.getAltitude(), result2.getAltitude());
        assertEquals(result1.getUncertainty(), result2.getUncertainty());
    }

    @Test
    public void test_parcelable_1_00504() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
        assertEquals(result1.getGlobalCoordinatesLatitude(), result2.getGlobalCoordinatesLatitude());
        assertEquals(result1.getGlobalCoordinatesLongitude(), result2.getGlobalCoordinatesLongitude());
        assertEquals(result1.getLocalCoordinatesNorth(), result2.getLocalCoordinatesNorth());
        assertEquals(result1.getLocalCoordinatesEast(), result2.getLocalCoordinatesEast());
        assertEquals(result1.getTxPower(), result2.getTxPower());
        assertEquals(result1.getFloorNumber(), result2.getFloorNumber());
        assertEquals(result1.getAltitude(), result2.getAltitude());
        assertEquals(result1.getUncertainty(), result2.getUncertainty());
    }

    @Test
    public void test_parcelable_1_00505() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
        assertEquals(result1.getGlobalCoordinatesLatitude(), result2.getGlobalCoordinatesLatitude());
        assertEquals(result1.getGlobalCoordinatesLongitude(), result2.getGlobalCoordinatesLongitude());
        assertEquals(result1.getLocalCoordinatesNorth(), result2.getLocalCoordinatesNorth());
        assertEquals(result1.getLocalCoordinatesEast(), result2.getLocalCoordinatesEast());
        assertEquals(result1.getTxPower(), result2.getTxPower());
        assertEquals(result1.getFloorNumber(), result2.getFloorNumber());
        assertEquals(result1.getAltitude(), result2.getAltitude());
        assertEquals(result1.getUncertainty(), result2.getUncertainty());
    }

    @Test
    public void test_parcelable_1_00506() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
        assertEquals(result1.getGlobalCoordinatesLatitude(), result2.getGlobalCoordinatesLatitude());
        assertEquals(result1.getGlobalCoordinatesLongitude(), result2.getGlobalCoordinatesLongitude());
        assertEquals(result1.getLocalCoordinatesNorth(), result2.getLocalCoordinatesNorth());
        assertEquals(result1.getLocalCoordinatesEast(), result2.getLocalCoordinatesEast());
        assertEquals(result1.getTxPower(), result2.getTxPower());
        assertEquals(result1.getFloorNumber(), result2.getFloorNumber());
        assertEquals(result1.getAltitude(), result2.getAltitude());
        assertEquals(result1.getUncertainty(), result2.getUncertainty());
    }

    @Test
    public void test_parcelable_1_00507() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getIndoorPositioningConfiguration(), result2.getIndoorPositioningConfiguration());
        assertEquals(result1.getGlobalCoordinatesLatitude(), result2.getGlobalCoordinatesLatitude());
        assertEquals(result1.getGlobalCoordinatesLongitude(), result2.getGlobalCoordinatesLongitude());
        assertEquals(result1.getLocalCoordinatesNorth(), result2.getLocalCoordinatesNorth());
        assertEquals(result1.getLocalCoordinatesEast(), result2.getLocalCoordinatesEast());
        assertEquals(result1.getTxPower(), result2.getTxPower());
        assertEquals(result1.getFloorNumber(), result2.getFloorNumber());
        assertEquals(result1.getAltitude(), result2.getAltitude());
        assertEquals(result1.getUncertainty(), result2.getUncertainty());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00502() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00503() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00504() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00505() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00506() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00507() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00502() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00503() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00504() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00505() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00506() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00507() {
        byte[] data = getData();

        IndoorPositioningAndroid result1 = new IndoorPositioningAndroid(data, 0, data[0]);
        IndoorPositioningAndroid result2 = IndoorPositioningAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
