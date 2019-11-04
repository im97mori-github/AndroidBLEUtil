package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_FLAGS;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FlagsTest {

    @Test
    public void constructTest1() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_FLAGS;
        data[2] = 0b00000001;

        Flags result = new Flags(data, 0, data[0]);
        assertEquals(2, result.getLength());
        assertEquals(DATA_TYPE_FLAGS, result.getDataType());
        assertEquals(1, result.getFlagsList().size());
        assertEquals(0b00000001, result.getFlagsList().get(0).intValue());
        assertTrue(result.isLeLimitedDiscoverableMode());
        assertFalse(result.isLeGeneralDiscoverableMode());
        assertFalse(result.isBrEdrNotSupported());
        assertFalse(result.isSimultaneousController());
        assertFalse(result.isSimultaneousHost());
    }

    @Test
    public void constructTest2() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_FLAGS;
        data[2] = 0b00000010;
        Flags result = new Flags(data, 0, data[0]);
        assertEquals(2, result.getLength());
        assertEquals(DATA_TYPE_FLAGS, result.getDataType());
        assertEquals(1, result.getFlagsList().size());
        assertEquals(0b00000010, result.getFlagsList().get(0).intValue());
        assertFalse(result.isLeLimitedDiscoverableMode());
        assertTrue(result.isLeGeneralDiscoverableMode());
        assertFalse(result.isBrEdrNotSupported());
        assertFalse(result.isSimultaneousController());
        assertFalse(result.isSimultaneousHost());
    }

    @Test
    public void constructTest3() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_FLAGS;
        data[2] = 0b00000100;
        Flags result = new Flags(data, 0, data[0]);
        assertEquals(2, result.getLength());
        assertEquals(DATA_TYPE_FLAGS, result.getDataType());
        assertEquals(1, result.getFlagsList().size());
        assertEquals(0b00000100, result.getFlagsList().get(0).intValue());
        assertFalse(result.isLeLimitedDiscoverableMode());
        assertFalse(result.isLeGeneralDiscoverableMode());
        assertTrue(result.isBrEdrNotSupported());
        assertFalse(result.isSimultaneousController());
        assertFalse(result.isSimultaneousHost());
    }

    @Test
    public void constructTest4() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_FLAGS;
        data[2] = 0b00001000;
        Flags result = new Flags(data, 0, data[0]);
        assertEquals(2, result.getLength());
        assertEquals(DATA_TYPE_FLAGS, result.getDataType());
        assertEquals(1, result.getFlagsList().size());
        assertEquals(0b00001000, result.getFlagsList().get(0).intValue());
        assertFalse(result.isLeLimitedDiscoverableMode());
        assertFalse(result.isLeGeneralDiscoverableMode());
        assertFalse(result.isBrEdrNotSupported());
        assertTrue(result.isSimultaneousController());
        assertFalse(result.isSimultaneousHost());
    }

    @Test
    public void constructTest5() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_FLAGS;
        data[2] = 0b00010000;
        Flags result = new Flags(data, 0, data[0]);
        assertEquals(2, result.getLength());
        assertEquals(DATA_TYPE_FLAGS, result.getDataType());
        assertEquals(1, result.getFlagsList().size());
        assertEquals(0b00010000, result.getFlagsList().get(0).intValue());
        assertFalse(result.isLeLimitedDiscoverableMode());
        assertFalse(result.isLeGeneralDiscoverableMode());
        assertFalse(result.isBrEdrNotSupported());
        assertFalse(result.isSimultaneousController());
        assertTrue(result.isSimultaneousHost());
    }

    @Test
    public void constructTest6() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_FLAGS;
        data[2] = (byte) 0b11111111;
        Flags result = new Flags(data, 0, data[0]);
        assertEquals(2, result.getLength());
        assertEquals(DATA_TYPE_FLAGS, result.getDataType());
        assertEquals(1, result.getFlagsList().size());
        assertEquals(0b11111111, result.getFlagsList().get(0).intValue());
        assertTrue(result.isLeLimitedDiscoverableMode());
        assertTrue(result.isLeGeneralDiscoverableMode());
        assertTrue(result.isBrEdrNotSupported());
        assertTrue(result.isSimultaneousController());
        assertTrue(result.isSimultaneousHost());
    }

    @Test
    public void constructTest7() {
        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = DATA_TYPE_FLAGS;
        Flags result = new Flags(data, 0, data[0]);
        assertEquals(1, result.getLength());
        assertEquals(DATA_TYPE_FLAGS, result.getDataType());
        assertEquals(0, result.getFlagsList().size());
        assertFalse(result.isLeLimitedDiscoverableMode());
        assertFalse(result.isLeGeneralDiscoverableMode());
        assertFalse(result.isBrEdrNotSupported());
        assertFalse(result.isSimultaneousController());
        assertFalse(result.isSimultaneousHost());
    }

    @Test
    public void constructTest8() {
        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = DATA_TYPE_FLAGS;

        Flags result1 = new Flags(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Flags result2 = Flags.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getFlagsList().toArray(), result2.getFlagsList().toArray());
    }

    @Test
    public void constructTest9() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_FLAGS;
        data[2] = 0b00000001;

        Flags result1 = new Flags(data, 0, data[0]);
        Flags result2 = Flags.CREATOR.createFromByteArray(data);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getFlagsList().toArray(), result2.getFlagsList().toArray());
    }

}
