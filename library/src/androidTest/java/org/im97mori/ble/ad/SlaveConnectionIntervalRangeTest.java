package org.im97mori.ble.ad;

import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
import static org.im97mori.ble.ad.AdvertisingDataConstants.SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SlaveConnectionIntervalRangeTest {

    @Test
    public void constructTest1() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;

        SlaveConnectionIntervalRange result = new SlaveConnectionIntervalRange(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE, result.getDataType());
        assertFalse(result.hasMinimum());
        assertFalse(result.hasMaximum());
    }

    @Test
    public void constructTest2() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0x00;
        data[3] = (byte) 0x00;
        data[4] = (byte) 0x00;
        data[5] = (byte) 0x00;

        SlaveConnectionIntervalRange result = new SlaveConnectionIntervalRange(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE, result.getDataType());
        assertTrue(result.hasMinimum());
        assertTrue(result.hasMaximum());
        assertEquals(0, result.getMinimumValue());
        assertEquals(0, result.getMaximumValue());
        assertEquals(0 * SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS, result.getMinimumValueMillis(), 0);
        assertEquals(0 * SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS, result.getMaximumValueMillis(), 0);
    }

    @Test
    public void constructTest3() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0x06;
        data[3] = (byte) 0x00;
        data[4] = (byte) 0x06;
        data[5] = (byte) 0x00;

        SlaveConnectionIntervalRange result = new SlaveConnectionIntervalRange(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE, result.getDataType());
        assertTrue(result.hasMinimum());
        assertTrue(result.hasMaximum());
        assertEquals(0x0006, result.getMinimumValue());
        assertEquals(0x0006, result.getMaximumValue());
        assertEquals(0x0006 * SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS, result.getMinimumValueMillis(), 0);
        assertEquals(0x0006 * SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS, result.getMaximumValueMillis(), 0);
    }

    @Test
    public void constructTest4() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0x80;
        data[3] = (byte) 0x0c;
        data[4] = (byte) 0x80;
        data[5] = (byte) 0x0c;

        SlaveConnectionIntervalRange result = new SlaveConnectionIntervalRange(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE, result.getDataType());
        assertTrue(result.hasMinimum());
        assertTrue(result.hasMaximum());
        assertEquals(0x0c80, result.getMinimumValue());
        assertEquals(0x0c80, result.getMaximumValue());
        assertEquals(0x0c80 * SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS, result.getMinimumValueMillis(), 0);
        assertEquals(0x0c80 * SLAVE_CONNECTION_INTERVAL_RANGE_UNIT_MILLIS, result.getMaximumValueMillis(), 0);
    }

    @Test
    public void constructTest5() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0x80;
        data[3] = (byte) 0x0c;
        data[4] = (byte) 0x06;
        data[5] = (byte) 0x00;

        SlaveConnectionIntervalRange result1 = new SlaveConnectionIntervalRange(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SlaveConnectionIntervalRange result2 = SlaveConnectionIntervalRange.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getMinimumValue(), result2.getMinimumValue());
        assertEquals(result1.getMaximumValue(), result2.getMaximumValue());
    }

    @Test
    public void constructTest6() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
        data[2] = (byte) 0xff;
        data[3] = (byte) 0xff;
        data[4] = (byte) 0xff;
        data[5] = (byte) 0xff;

        SlaveConnectionIntervalRange result1 = new SlaveConnectionIntervalRange(data, 0, data[0]);
        SlaveConnectionIntervalRange result2 = SlaveConnectionIntervalRange.CREATOR.createFromByteArray(data);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getMinimumValue(), result2.getMinimumValue());
        assertEquals(result1.getMaximumValue(), result2.getMaximumValue());
    }

}
