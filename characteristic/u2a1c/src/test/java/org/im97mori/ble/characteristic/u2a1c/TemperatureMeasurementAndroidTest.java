package org.im97mori.ble.characteristic.u2a1c;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.DateTimeUtils;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_FLOAT;
import org.im97mori.ble.characteristic.core.TemperatureMeasurementUtils;
import org.im97mori.ble.characteristic.core.TemperatureTypeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class TemperatureMeasurementAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertEquals(0x030201 * Math.pow(10, 0x04), result1.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertTrue(TemperatureMeasurementUtils.isFlagsTemperatureUnitsCelsius(result1.getFlags()));
        assertFalse(TemperatureMeasurementUtils.isFlagsTemperatureUnitsFahrenheit(result1.getFlags()));
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_FAHRENHEIT
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_FAHRENHEIT
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertEquals(0x030201 * Math.pow(10, 0x04), result1.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertFalse(TemperatureMeasurementUtils.isFlagsTemperatureUnitsCelsius(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTemperatureUnitsFahrenheit(result1.getFlags()));
    }

    @Test
    public void test_constructor101() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertTrue(TemperatureMeasurementUtils.isFlagsTimeStampNotPresent(result1.getFlags()));
        assertFalse(TemperatureMeasurementUtils.isFlagsTimeStampPresent(result1.getFlags()));
    }

    @Test
    public void test_constructor102() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 1582;
        data[ 6] = (byte) (1582 >> 8);
        data[ 7] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 8] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTimeStampNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTimeStampPresent(result1.getFlags()));
        assertEquals(1582, result1.getYear());
        assertEquals(DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN, result1.getMonth());
        assertEquals(0, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor103() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JANUARY;
        data[ 8] = 1;
        data[ 9] = 23;
        data[10] = 59;
        data[11] = 59;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTimeStampNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTimeStampPresent(result1.getFlags()));
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JANUARY, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
    }

    @Test
    public void test_constructor104() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTimeStampNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTimeStampPresent(result1.getFlags()));
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_FEBRUARY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor105() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_MARCH;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTimeStampNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTimeStampPresent(result1.getFlags()));
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MARCH, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor106() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_APRIL;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTimeStampNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTimeStampPresent(result1.getFlags()));
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_APRIL, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor107() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_MAY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTimeStampNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTimeStampPresent(result1.getFlags()));
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MAY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor108() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JUNE;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTimeStampNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTimeStampPresent(result1.getFlags()));
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JUNE, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor109() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JULY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTimeStampNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTimeStampPresent(result1.getFlags()));
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JULY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor110() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_AUGUST;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTimeStampNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTimeStampPresent(result1.getFlags()));
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_AUGUST, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor111() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTimeStampNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTimeStampPresent(result1.getFlags()));
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_SEPTEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor112() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_OCTOBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTimeStampNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTimeStampPresent(result1.getFlags()));
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_OCTOBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor113() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTimeStampNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTimeStampPresent(result1.getFlags()));
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_NOVEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor114() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_DECEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTimeStampNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTimeStampPresent(result1.getFlags()));
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor201() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertTrue(TemperatureMeasurementUtils.isFlagsTemperatureTypeNotPresent(result1.getFlags()));
        assertFalse(TemperatureMeasurementUtils.isFlagsTemperatureTypePresent(result1.getFlags()));
    }

    @Test
    public void test_constructor202() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTemperatureTypeNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTemperatureTypePresent(result1.getFlags()));
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT, result1.getTemperatureTextDescription());
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor203() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTemperatureTypeNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTemperatureTypePresent(result1.getFlags()));
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL, result1.getTemperatureTextDescription());
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor204() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTemperatureTypeNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTemperatureTypePresent(result1.getFlags()));
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE, result1.getTemperatureTextDescription());
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor205() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTemperatureTypeNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTemperatureTypePresent(result1.getFlags()));
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER, result1.getTemperatureTextDescription());
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor206() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTemperatureTypeNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTemperatureTypePresent(result1.getFlags()));
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT, result1.getTemperatureTextDescription());
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor207() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTemperatureTypeNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTemperatureTypePresent(result1.getFlags()));
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH, result1.getTemperatureTextDescription());
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor208() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTemperatureTypeNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTemperatureTypePresent(result1.getFlags()));
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM, result1.getTemperatureTextDescription());
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor209() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTemperatureTypeNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTemperatureTypePresent(result1.getFlags()));
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE, result1.getTemperatureTextDescription());
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor210() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertEquals(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(TemperatureMeasurementUtils.isFlagsTemperatureTypeNotPresent(result1.getFlags()));
        assertTrue(TemperatureMeasurementUtils.isFlagsTemperatureTypePresent(result1.getFlags()));
        assertEquals(TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM, result1.getTemperatureTextDescription());
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeArmpit(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeBodyGeneral(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeEarUsuallyEarLobe(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeFinger(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeGastroIntestinalTract(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeMouth(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeRectum(result1.getTemperatureTextDescription()));
        assertFalse(TemperatureTypeUtils.isTemperatureTextDescriptionTypeToe(result1.getTemperatureTextDescription()));
        assertTrue(TemperatureTypeUtils.isTemperatureTextDescriptionTypeTympanumEarDrum(result1.getTemperatureTextDescription()));
    }

    @Test
    public void test_constructor211() {
        int flags = 1;
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[] { 2, 3, 4, 5 }, 0);
        IEEE_11073_20601_FLOAT temperatureMeasurementValueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[] { 6, 7, 8, 9 }, 0);
        int year = 10;
        int month = 11;
        int day = 12;
        int hours = 13;
        int minutes = 14;
        int seconds = 15;
        int temperatureTextDescription = 16;

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(flags, temperatureMeasurementValueCelsius, temperatureMeasurementValueFahrenheit, year, month, day, hours, minutes, seconds, temperatureTextDescription);
        assertEquals(flags, result1.getFlags());
        assertEquals(temperatureMeasurementValueCelsius, result1.getTemperatureMeasurementValueCelsius());
        assertEquals(temperatureMeasurementValueFahrenheit, result1.getTemperatureMeasurementValueFahrenheit());
        assertEquals(year, result1.getYear());
        assertEquals(month, result1.getMonth());
        assertEquals(day, result1.getDay());
        assertEquals(hours, result1.getHours());
        assertEquals(minutes, result1.getMinutes());
        assertEquals(seconds, result1.getSeconds());
        assertEquals(temperatureTextDescription, result1.getTemperatureTextDescription());
    }

    @Test
    public void test_constructor212() {
        int flags = 1;
        double temperatureMeasurementValueCelsius = BLEUtils.createFloat(new byte[] { 2, 3, 4, 5 }, 0);
        double temperatureMeasurementValueFahrenheit = BLEUtils.createFloat(new byte[] { 6, 7, 8, 9 }, 0);
        int year = 10;
        int month = 11;
        int day = 12;
        int hours = 13;
        int minutes = 14;
        int seconds = 15;
        int temperatureTextDescription = 16;

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(flags, temperatureMeasurementValueCelsius, temperatureMeasurementValueFahrenheit, year, month, day, hours, minutes, seconds, temperatureTextDescription);
        assertEquals(flags, result1.getFlags());
        assertEquals(temperatureMeasurementValueCelsius, result1.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(temperatureMeasurementValueFahrenheit, result1.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(year, result1.getYear());
        assertEquals(month, result1.getMonth());
        assertEquals(day, result1.getDay());
        assertEquals(hours, result1.getHours());
        assertEquals(minutes, result1.getMinutes());
        assertEquals(seconds, result1.getSeconds());
        assertEquals(temperatureTextDescription, result1.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_FAHRENHEIT
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable004() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 1582;
        data[ 6] = (byte) (1582 >> 8);
        data[ 7] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 8] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable005() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JANUARY;
        data[ 8] = 1;
        data[ 9] = 23;
        data[10] = 59;
        data[11] = 59;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable006() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable007() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_MARCH;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable008() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_APRIL;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable009() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_MAY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable010() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JUNE;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable011() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JULY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable012() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_AUGUST;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable013() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable014() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_OCTOBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable015() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable016() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_DECEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable017() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable018() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable019() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable020() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable021() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable022() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable023() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable024() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable025() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable026() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable101() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_FAHRENHEIT
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 1582;
        data[ 6] = (byte) (1582 >> 8);
        data[ 7] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 8] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JANUARY;
        data[ 8] = 1;
        data[ 9] = 23;
        data[10] = 59;
        data[11] = 59;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable106() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable107() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_MARCH;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable108() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_APRIL;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable109() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_MAY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable110() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JUNE;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable111() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JULY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable112() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_AUGUST;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable113() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable114() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_OCTOBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable115() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable116() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_DECEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable117() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable118() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable119() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable120() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable121() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable122() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable123() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable124() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable125() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable126() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_FAHRENHEIT
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 1582;
        data[ 6] = (byte) (1582 >> 8);
        data[ 7] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 8] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JANUARY;
        data[ 8] = 1;
        data[ 9] = 23;
        data[10] = 59;
        data[11] = 59;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable206() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable207() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_MARCH;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable208() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_APRIL;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable209() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_MAY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable210() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JUNE;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable211() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JULY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable212() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_AUGUST;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable213() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable214() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_OCTOBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable215() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable216() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_DECEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable217() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable218() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable219() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable220() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable221() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable222() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable223() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable224() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable225() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable226() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurementUtils.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurementUtils.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM;
        //@formatter:on

        TemperatureMeasurementAndroid result1 = new TemperatureMeasurementAndroid(data);
        TemperatureMeasurementAndroid result2 = TemperatureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
