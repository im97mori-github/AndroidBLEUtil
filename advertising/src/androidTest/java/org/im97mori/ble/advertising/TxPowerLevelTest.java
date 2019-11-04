package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_TX_POWER_LEVEL;
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

    @Test
    public void constructTest3() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = 127;

        TxPowerLevel result1 = new TxPowerLevel(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TxPowerLevel result2 = TxPowerLevel.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getTxPowerLevel(), result2.getTxPowerLevel());
    }

    @Test
    public void constructTest4() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_TX_POWER_LEVEL;
        data[2] = -127;

        TxPowerLevel result1 = new TxPowerLevel(data, 0, data[0]);
        TxPowerLevel result2 = TxPowerLevel.CREATOR.createFromByteArray(data);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getTxPowerLevel(), result2.getTxPowerLevel());
    }

}
