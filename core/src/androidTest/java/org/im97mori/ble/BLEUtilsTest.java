package org.im97mori.ble;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BLEUtilsTest {

    @Test
    public void test_createBoolean_001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on
        assertEquals(0x01, BLEUtils.createBoolean(data, 0));
    }

    @Test
    public void test_createBoolean_002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x00;
        //@formatter:on
        assertEquals(0x00, BLEUtils.createBoolean(data, 0));
    }

    @Test
    public void test_createSInt8_001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on
        assertEquals(0x01, BLEUtils.createSInt8(data, 0));
    }

    @Test
    public void test_createSInt8_002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on
        assertEquals(0xffffffff, BLEUtils.createSInt8(data, 0));
    }

    @Test
    public void test_createSInt8_003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on
        assertEquals(0x02, BLEUtils.createSInt8(data, 1));
    }

    @Test
    public void test_createUInt8_001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on
        assertEquals(0x01, BLEUtils.createUInt8(data, 0));
    }

    @Test
    public void test_createUInt8_002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on
        assertEquals(0x000000ff, BLEUtils.createUInt8(data, 0));
    }

    @Test
    public void test_createUInt8_003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on
        assertEquals(0x02, BLEUtils.createUInt8(data, 1));
    }

    @Test
    public void test_createSInt16_001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on
        assertEquals(0x0201, BLEUtils.createSInt16(data, 0));
    }

    @Test
    public void test_createSInt16_002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x01;
        data[ 1] = (byte) 0xff;
        //@formatter:on
        assertEquals(0xffffff01, BLEUtils.createSInt16(data, 0));
    }

    @Test
    public void test_createSInt16_003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on
        assertEquals(0x0302, BLEUtils.createSInt16(data, 1));
    }

    @Test
    public void test_createUInt16_001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on
        assertEquals(0x0201, BLEUtils.createUInt16(data, 0));
    }

    @Test
    public void test_createUInt16_002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x01;
        data[ 1] = (byte) 0xff;
        //@formatter:on
        assertEquals(0x0000ff01, BLEUtils.createUInt16(data, 0));
    }

    @Test
    public void test_createUInt16_003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on
        assertEquals(0x0302, BLEUtils.createUInt16(data, 1));
    }

    @Test
    public void test_createSInt24_001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on
        assertEquals(0x030201, BLEUtils.createSInt24(data, 0));
    }

    @Test
    public void test_createSInt24_002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 0x01;
        data[ 1] = (byte) 0x02;
        data[ 2] = (byte) 0xff;
        //@formatter:on
        assertEquals(0xffff0201, BLEUtils.createSInt24(data, 0));
    }

    @Test
    public void test_createSInt24_003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on
        assertEquals(0x040302, BLEUtils.createSInt24(data, 1));
    }

    @Test
    public void test_createUInt24_001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on
        assertEquals(0x030201, BLEUtils.createUInt24(data, 0));
    }

    @Test
    public void test_createUInt24_002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 0x01;
        data[ 1] = (byte) 0x02;
        data[ 2] = (byte) 0xff;
        //@formatter:on
        assertEquals(0x00ff0201, BLEUtils.createUInt24(data, 0));
    }

    @Test
    public void test_createUInt24_003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on
        assertEquals(0x040302, BLEUtils.createUInt24(data, 1));
    }

    @Test
    public void test_createSInt32_001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on
        assertEquals(0x04030201, BLEUtils.createSInt32(data, 0));
    }

    @Test
    public void test_createSInt32_002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 0x01;
        data[ 1] = (byte) 0x02;
        data[ 2] = (byte) 0x03;
        data[ 3] = (byte) 0xff;
        //@formatter:on
        assertEquals(0xff030201, BLEUtils.createSInt32(data, 0));
    }

    @Test
    public void test_createSInt32_003() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        //@formatter:on
        assertEquals(0x05040302, BLEUtils.createSInt32(data, 1));
    }

    @Test
    public void test_createUInt32_001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on
        assertEquals(0x04030201L, BLEUtils.createUInt32(data, 0));
    }

    @Test
    public void test_createUInt32_002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 0x01;
        data[ 1] = (byte) 0x02;
        data[ 2] = (byte) 0x03;
        data[ 3] = (byte) 0xff;
        //@formatter:on
        assertEquals(0xff030201L, BLEUtils.createUInt32(data, 0));
    }

    @Test
    public void test_createUInt32_003() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        //@formatter:on
        assertEquals(0x05040302L, BLEUtils.createUInt32(data, 1));
    }

    @Test
    public void test_createUInt40_001() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        //@formatter:on
        assertEquals(0x0504030201L, BLEUtils.createUInt40(data, 0));
    }

    @Test
    public void test_createUInt40_002() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) 0x01;
        data[ 1] = (byte) 0x02;
        data[ 2] = (byte) 0x03;
        data[ 3] = (byte) 0x04;
        data[ 4] = (byte) 0xff;
        //@formatter:on
        assertEquals(0xff04030201L, BLEUtils.createUInt40(data, 0));
    }

    @Test
    public void test_createUInt40_003() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        //@formatter:on
        assertEquals(0x0605040302L, BLEUtils.createUInt40(data, 1));
    }

    @Test
    public void test_createSInt48_001() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        //@formatter:on
        assertEquals(0x060504030201L, BLEUtils.createSInt48(data, 0));
    }

    @Test
    public void test_createSInt48_002() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 0x01;
        data[ 1] = (byte) 0x02;
        data[ 2] = (byte) 0x03;
        data[ 3] = (byte) 0x04;
        data[ 4] = (byte) 0x05;
        data[ 5] = (byte) 0xff;
        //@formatter:on
        assertEquals(0xffffff0504030201L, BLEUtils.createSInt48(data, 0));
    }

    @Test
    public void test_createSInt48_003() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        //@formatter:on
        assertEquals(0x070605040302L, BLEUtils.createSInt48(data, 1));
    }

    @Test
    public void test_createUInt48_001() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        //@formatter:on
        assertEquals(0x060504030201L, BLEUtils.createUInt48(data, 0));
    }

    @Test
    public void test_createUInt48_002() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 0x01;
        data[ 1] = (byte) 0x02;
        data[ 2] = (byte) 0x03;
        data[ 3] = (byte) 0x04;
        data[ 4] = (byte) 0x05;
        data[ 5] = (byte) 0xff;
        //@formatter:on
        assertEquals(0xff0504030201L, BLEUtils.createUInt48(data, 0));
    }

    @Test
    public void test_createUInt48_003() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        //@formatter:on
        assertEquals(0x070605040302L, BLEUtils.createUInt48(data, 1));
    }

    @Test
    public void test_createUInt128_001() {
        //@formatter:off
        byte[] data = new byte[16];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 8] = 0x09;
        data[ 9] = 0x0a;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        data[14] = 0x0f;
        data[15] = 0x10;
        //@formatter:on

        assertEquals(0x04030201, BLEUtils.createUInt128(data, 0).intValue());
        assertEquals(0x08070605, BLEUtils.createUInt128(data, 0).shiftRight(32).intValue());
        assertEquals(0x0c0b0a09, BLEUtils.createUInt128(data, 0).shiftRight(64).intValue());
        assertEquals(0x100f0e0d, BLEUtils.createUInt128(data, 0).shiftRight(96).intValue());
    }

    @Test
    public void test_createUInt128_002() {
        //@formatter:off
        byte[] data = new byte[16];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 8] = 0x09;
        data[ 9] = 0x0a;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        data[14] = 0x0f;
        data[15] = (byte) 0xff;
        //@formatter:on

        assertEquals(0x04030201, BLEUtils.createUInt128(data, 0).intValue());
        assertEquals(0x08070605, BLEUtils.createUInt128(data, 0).shiftRight(32).intValue());
        assertEquals(0x0c0b0a09, BLEUtils.createUInt128(data, 0).shiftRight(64).intValue());
        assertEquals(0xff0f0e0d, BLEUtils.createUInt128(data, 0).shiftRight(96).intValue());
    }

    @Test
    public void test_createUInt128_003() {
        //@formatter:off
        byte[] data = new byte[17];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 8] = 0x09;
        data[ 9] = 0x0a;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        data[14] = 0x0f;
        data[15] = 0x10;
        data[16] = 0x11;
        //@formatter:on

        assertEquals(0x05040302, BLEUtils.createUInt128(data, 1).intValue());
        assertEquals(0x09080706, BLEUtils.createUInt128(data, 1).shiftRight(32).intValue());
        assertEquals(0x0d0c0b0a, BLEUtils.createUInt128(data, 1).shiftRight(64).intValue());
        assertEquals(0x11100f0e, BLEUtils.createUInt128(data, 1).shiftRight(96).intValue());
    }

    @Test
    public void test_createBigInteger001() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;

        byte[] reverse = new byte[8];
        reverse[ 0] = 0x08;
        reverse[ 1] = 0x07;
        reverse[ 2] = 0x06;
        reverse[ 3] = 0x05;
        reverse[ 4] = 0x04;
        reverse[ 5] = 0x03;
        reverse[ 6] = 0x02;
        reverse[ 7] = 0x01;
        //@formatter:on

        BigInteger result1 = BLEUtils.createBigInteger(data, 0, 8);
        assertEquals(new BigInteger(reverse), result1);
    }

    @Test
    public void test_createBigInteger002() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 0xff;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;

        byte[] reverse = new byte[8];
        reverse[ 0] = 0x08;
        reverse[ 1] = 0x07;
        reverse[ 2] = 0x06;
        reverse[ 3] = 0x05;
        reverse[ 4] = 0x04;
        reverse[ 5] = 0x03;
        reverse[ 6] = 0x02;
        reverse[ 7] = (byte) 0xff;
        //@formatter:on

        BigInteger result1 = BLEUtils.createBigInteger(data, 0, 8);
        assertEquals(new BigInteger(1, reverse), result1);
    }

    @Test
    public void test_createBigInteger003() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 8] = 0x09;

        byte[] reverse = new byte[8];
        reverse[ 0] = 0x09;
        reverse[ 1] = 0x08;
        reverse[ 2] = 0x07;
        reverse[ 3] = 0x06;
        reverse[ 4] = 0x05;
        reverse[ 5] = 0x04;
        reverse[ 6] = 0x03;
        reverse[ 7] = 0x02;
        //@formatter:on

        BigInteger result1 = BLEUtils.createBigInteger(data, 1, 8);
        assertEquals(new BigInteger(reverse), result1);
    }

    @Test
    public void test_createBigInteger004() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;

        byte[] reverse = new byte[4];
        reverse[ 0] = 0x04;
        reverse[ 1] = 0x03;
        reverse[ 2] = 0x02;
        reverse[ 3] = 0x01;
        //@formatter:on

        BigInteger result1 = BLEUtils.createBigInteger(data, 0, 4);
        assertEquals(new BigInteger(reverse), result1);
    }

    @Test
    public void test_createLittleEndianByteArrayFromBigInteger001() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;

        byte[] reverse = new byte[8];
        reverse[ 0] = 0x08;
        reverse[ 1] = 0x07;
        reverse[ 2] = 0x06;
        reverse[ 3] = 0x05;
        reverse[ 4] = 0x04;
        reverse[ 5] = 0x03;
        reverse[ 6] = 0x02;
        reverse[ 7] = 0x01;
        //@formatter:on

        byte[] result1 = BLEUtils.createLittleEndianByteArrayFromBigInteger(new BigInteger(reverse), 8);
        assertArrayEquals(data, result1);
    }

    @Test
    public void test_createLittleEndianByteArrayFromBigInteger002() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) 0xff;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;

        byte[] reverse = new byte[8];
        reverse[ 0] = 0x08;
        reverse[ 1] = 0x07;
        reverse[ 2] = 0x06;
        reverse[ 3] = 0x05;
        reverse[ 4] = 0x04;
        reverse[ 5] = 0x03;
        reverse[ 6] = 0x02;
        reverse[ 7] = (byte) 0xff;
        //@formatter:on

        byte[] result1 = BLEUtils.createLittleEndianByteArrayFromBigInteger(new BigInteger(1, reverse), 8);
        assertArrayEquals(data, result1);
    }

    @Test
    public void test_createLittleEndianByteArrayFromBigInteger003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;

        byte[] reverse = new byte[4];
        reverse[ 0] = 0x04;
        reverse[ 1] = 0x03;
        reverse[ 2] = 0x02;
        reverse[ 3] = 0x01;
        //@formatter:on

        byte[] result1 = BLEUtils.createLittleEndianByteArrayFromBigInteger(new BigInteger(reverse), 4);
        assertArrayEquals(data, result1);
    }
}
