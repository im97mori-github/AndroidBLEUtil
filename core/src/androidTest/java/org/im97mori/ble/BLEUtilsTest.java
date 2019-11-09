package org.im97mori.ble;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BLEUtilsTest {

    @Test
    public void test_createSInt8_001() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on
        assertEquals(0x01, BLEUtils.createSInt8(value, 0));
    }

    @Test
    public void test_createSInt8_002() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) 0xff;
        //@formatter:on
        assertEquals(0xffffffff, BLEUtils.createSInt8(value, 0));
    }

    @Test
    public void test_createSInt8_003() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on
        assertEquals(0x02, BLEUtils.createSInt8(value, 1));
    }

    @Test
    public void test_createUInt8_001() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on
        assertEquals(0x01, BLEUtils.createUInt8(value, 0));
    }

    @Test
    public void test_createUInt8_002() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) 0xff;
        //@formatter:on
        assertEquals(0x000000ff, BLEUtils.createUInt8(value, 0));
    }

    @Test
    public void test_createUInt8_003() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on
        assertEquals(0x02, BLEUtils.createUInt8(value, 1));
    }

    @Test
    public void test_createSInt16_001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on
        assertEquals(0x0201, BLEUtils.createSInt16(value, 0));
    }

    @Test
    public void test_createSInt16_002() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = (byte) 0x01;
        value[ 1] = (byte) 0xff;
        //@formatter:on
        assertEquals(0xffffff01, BLEUtils.createSInt16(value, 0));
    }

    @Test
    public void test_createSInt16_003() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        //@formatter:on
        assertEquals(0x0302, BLEUtils.createSInt16(value, 1));
    }

    @Test
    public void test_createUInt16_001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on
        assertEquals(0x0201, BLEUtils.createUInt16(value, 0));
    }

    @Test
    public void test_createUInt16_002() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = (byte) 0x01;
        value[ 1] = (byte) 0xff;
        //@formatter:on
        assertEquals(0x0000ff01, BLEUtils.createUInt16(value, 0));
    }

    @Test
    public void test_createUInt16_003() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        //@formatter:on
        assertEquals(0x0302, BLEUtils.createUInt16(value, 1));
    }

    @Test
    public void test_createSInt24_001() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        //@formatter:on
        assertEquals(0x030201, BLEUtils.createSInt24(value, 0));
    }

    @Test
    public void test_createSInt24_002() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) 0x01;
        value[ 1] = (byte) 0x02;
        value[ 2] = (byte) 0xff;
        //@formatter:on
        assertEquals(0xffff0201, BLEUtils.createSInt24(value, 0));
    }

    @Test
    public void test_createSInt24_003() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        //@formatter:on
        assertEquals(0x040302, BLEUtils.createSInt24(value, 1));
    }

    @Test
    public void test_createUInt24_001() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        //@formatter:on
        assertEquals(0x030201, BLEUtils.createUInt24(value, 0));
    }

    @Test
    public void test_createUInt24_002() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) 0x01;
        value[ 1] = (byte) 0x02;
        value[ 2] = (byte) 0xff;
        //@formatter:on
        assertEquals(0x00ff0201, BLEUtils.createUInt24(value, 0));
    }

    @Test
    public void test_createUInt24_003() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        //@formatter:on
        assertEquals(0x040302, BLEUtils.createUInt24(value, 1));
    }

    @Test
    public void test_createSInt32_001() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        //@formatter:on
        assertEquals(0x04030201, BLEUtils.createSInt32(value, 0));
    }

    @Test
    public void test_createSInt32_002() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = (byte) 0x01;
        value[ 1] = (byte) 0x02;
        value[ 2] = (byte) 0x03;
        value[ 3] = (byte) 0xff;
        //@formatter:on
        assertEquals(0xff030201, BLEUtils.createSInt32(value, 0));
    }

    @Test
    public void test_createSInt32_003() {
        //@formatter:off
        byte[] value = new byte[5];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        //@formatter:on
        assertEquals(0x05040302, BLEUtils.createSInt32(value, 1));
    }

    @Test
    public void test_createUInt32_001() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        //@formatter:on
        assertEquals(0x04030201L, BLEUtils.createUInt32(value, 0));
    }

    @Test
    public void test_createUInt32_002() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = (byte) 0x01;
        value[ 1] = (byte) 0x02;
        value[ 2] = (byte) 0x03;
        value[ 3] = (byte) 0xff;
        //@formatter:on
        assertEquals(0xff030201L, BLEUtils.createUInt32(value, 0));
    }

    @Test
    public void test_createUInt32_003() {
        //@formatter:off
        byte[] value = new byte[5];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        //@formatter:on
        assertEquals(0x05040302L, BLEUtils.createUInt32(value, 1));
    }
}
