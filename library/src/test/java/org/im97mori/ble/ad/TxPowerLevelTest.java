package org.im97mori.ble.ad;

import org.junit.Test;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_TX_POWER_LEVEL;
import static org.junit.Assert.assertEquals;

public class TxPowerLevelTest {

    @Test
    public void constructTest1() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = -127;

        TxPowerLevel result = new TxPowerLevel(data, 0, data[0]);
        assertEquals(2, result.getLength());
        assertEquals(DATA_TYPE_TX_POWER_LEVEL, result.getDataType());
        assertEquals(-127, result.getTxPowerLevel());
    }

    @Test
    public void constructTest2() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = 127;
        TxPowerLevel result = new TxPowerLevel(data, 0, data[0]);
        assertEquals(2, result.getLength());
        assertEquals(DATA_TYPE_TX_POWER_LEVEL, result.getDataType());
        assertEquals(127, result.getTxPowerLevel());
    }
}
