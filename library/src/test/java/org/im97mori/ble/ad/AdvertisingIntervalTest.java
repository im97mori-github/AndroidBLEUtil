package org.im97mori.ble.ad;

import org.junit.Test;

import static org.im97mori.ble.ad.AdvertisingDataConstants.ADVERTISING_INTERVAL_UNIT_MILLIS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_ADVERTISING_INTERVAL;
import static org.junit.Assert.assertEquals;

public class AdvertisingIntervalTest {

    @Test
    public void constructTest1() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[2] = 0x00;
        data[3] = 0x00;

        AdvertisingInterval result = new AdvertisingInterval(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_ADVERTISING_INTERVAL, result.getDataType());
        assertEquals(0, result.getAdvertisingInterval());
        assertEquals(0 * ADVERTISING_INTERVAL_UNIT_MILLIS, result.getAdvertisingIntervalMillis(), 0);
    }

    @Test
    public void constructTest2() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[2] = 0x7f;
        data[3] = 0x7f;
        AdvertisingInterval result = new AdvertisingInterval(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_ADVERTISING_INTERVAL, result.getDataType());
        assertEquals(0x7f7f, result.getAdvertisingInterval());
        assertEquals(0x7f7f * ADVERTISING_INTERVAL_UNIT_MILLIS, result.getAdvertisingIntervalMillis(), 0);
    }

    @Test
    public void constructTest3() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[2] = 0x00;
        data[3] = 0x7f;
        AdvertisingInterval result = new AdvertisingInterval(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_ADVERTISING_INTERVAL, result.getDataType());
        assertEquals(0x7f00, result.getAdvertisingInterval());
        assertEquals(0x7f00 * ADVERTISING_INTERVAL_UNIT_MILLIS, result.getAdvertisingIntervalMillis(), 0);
    }

    @Test
    public void constructTest4() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[2] = 0x7f;
        data[3] = 0x00;
        AdvertisingInterval result = new AdvertisingInterval(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_ADVERTISING_INTERVAL, result.getDataType());
        assertEquals(0x007f, result.getAdvertisingInterval());
        assertEquals(0x007f * ADVERTISING_INTERVAL_UNIT_MILLIS, result.getAdvertisingIntervalMillis(), 0);
    }

    @Test
    public void constructTest5() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        AdvertisingInterval result = new AdvertisingInterval(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_ADVERTISING_INTERVAL, result.getDataType());
        assertEquals(0xffff, result.getAdvertisingInterval());
        assertEquals(0xffff * ADVERTISING_INTERVAL_UNIT_MILLIS, result.getAdvertisingIntervalMillis(), 0);
    }

    @Test
    public void constructTest6() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[2] = 0;
        data[3] = (byte) 0b11111111;
        AdvertisingInterval result = new AdvertisingInterval(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_ADVERTISING_INTERVAL, result.getDataType());
        assertEquals(0xff00, result.getAdvertisingInterval());
        assertEquals(0xff00 * ADVERTISING_INTERVAL_UNIT_MILLIS, result.getAdvertisingIntervalMillis(), 0);
    }

    @Test
    public void constructTest7() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_ADVERTISING_INTERVAL;
        data[2] = (byte) 0b11111111;
        data[3] = 0;
        AdvertisingInterval result = new AdvertisingInterval(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_ADVERTISING_INTERVAL, result.getDataType());
        assertEquals(0x00ff, result.getAdvertisingInterval());
        assertEquals(0x00ff * ADVERTISING_INTERVAL_UNIT_MILLIS, result.getAdvertisingIntervalMillis(), 0);
    }

}
