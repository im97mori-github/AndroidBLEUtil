package org.im97mori.ble.characteristic.core;

import org.im97mori.ble.BLEUtils;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IEEE_11073_20601_FLOATest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 0xff;
        data[ 1] = (byte) 0xff;
        data[ 2] = (byte) 0x7f;
        data[ 3] = (byte) 0x00;
        //@formatter:on

        IEEE_11073_20601_FLOAT result1 = new IEEE_11073_20601_FLOAT(data, 0);

        assertTrue(BLEUtils.isFloatNan(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatNres(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatPositiveInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatNegativeInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatRfu(result1.getData(), 0));
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 0x00;
        data[ 1] = (byte) 0x00;
        data[ 2] = (byte) 0x80;
        data[ 3] = (byte) 0x00;
        //@formatter:on

        IEEE_11073_20601_FLOAT result1 = new IEEE_11073_20601_FLOAT(data, 0);

        assertFalse(BLEUtils.isFloatNan(result1.getData(), 0));
        assertTrue(BLEUtils.isFloatNres(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatPositiveInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatNegativeInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatRfu(result1.getData(), 0));
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 0xfe;
        data[ 1] = (byte) 0xff;
        data[ 2] = (byte) 0x7f;
        data[ 3] = (byte) 0x00;
        //@formatter:on

        IEEE_11073_20601_FLOAT result1 = new IEEE_11073_20601_FLOAT(data, 0);

        assertFalse(BLEUtils.isFloatNan(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatNres(result1.getData(), 0));
        assertTrue(BLEUtils.isFloatPositiveInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatNegativeInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatRfu(result1.getData(), 0));
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 0x02;
        data[ 1] = (byte) 0x00;
        data[ 2] = (byte) 0x80;
        data[ 3] = (byte) 0x00;
        //@formatter:on

        IEEE_11073_20601_FLOAT result1 = new IEEE_11073_20601_FLOAT(data, 0);

        assertFalse(BLEUtils.isFloatNan(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatNres(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatPositiveInfinity(result1.getData(), 0));
        assertTrue(BLEUtils.isFloatNegativeInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatRfu(result1.getData(), 0));
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 0x01;
        data[ 1] = (byte) 0x00;
        data[ 2] = (byte) 0x80;
        data[ 3] = (byte) 0x00;
        //@formatter:on

        IEEE_11073_20601_FLOAT result1 = new IEEE_11073_20601_FLOAT(data, 0);

        assertFalse(BLEUtils.isFloatNan(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatNres(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatPositiveInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatNegativeInfinity(result1.getData(), 0));
        assertTrue(BLEUtils.isFloatRfu(result1.getData(), 0));
    }

    @Test
    public void test_constructor006() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x00;
        //@formatter:on

        IEEE_11073_20601_FLOAT result1 = new IEEE_11073_20601_FLOAT(data, 0);

        Assert.assertEquals(0x030201, BLEUtils.createFloat(result1.getData(), 0), 0);
        assertFalse(BLEUtils.isFloatNan(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatNres(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatPositiveInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatNegativeInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatRfu(result1.getData(), 0));
    }

    @Test
    public void test_constructor007() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        IEEE_11073_20601_FLOAT result1 = new IEEE_11073_20601_FLOAT(data, 0);

        assertEquals(0x030201 * Math.pow(10, 4), result1.getFloat(), 0);
        assertFalse(BLEUtils.isFloatNan(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatNres(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatPositiveInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatNegativeInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatRfu(result1.getData(), 0));
    }

    @Test
    public void test_constructor008() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = (byte) 0xff;
        //@formatter:on

        IEEE_11073_20601_FLOAT result1 = new IEEE_11073_20601_FLOAT(data, 0);

        assertEquals(0x030201 * Math.pow(10, -1), result1.getFloat(), 0);
        assertFalse(BLEUtils.isFloatNan(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatNres(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatPositiveInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatNegativeInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatRfu(result1.getData(), 0));
    }

    @Test
    public void test_constructor009() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x00;
        //@formatter:on


        IEEE_11073_20601_FLOAT result1 = new IEEE_11073_20601_FLOAT(data, 1);

        Assert.assertEquals(0x040302, BLEUtils.createFloat(result1.getData(), 0), 0);
        assertFalse(BLEUtils.isFloatNan(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatNres(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatPositiveInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatNegativeInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isFloatRfu(result1.getData(), 0));
    }
}
