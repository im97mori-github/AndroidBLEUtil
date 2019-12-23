package org.im97mori.ble.characteristic;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IEEE_11073_20601_SFLOATest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0xff;
        data[ 1] = 0x07;
        //@formatter:on

        IEEE_11073_20601_SFLOAT result1 = new IEEE_11073_20601_SFLOAT(data, 0);

        assertTrue(BLEUtils.isSfloatNan(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatNres(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatPositiveInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatNegativeInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatRfu(result1.getData(), 0));
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x00;
        data[ 1] = 0x08;
        //@formatter:on

        IEEE_11073_20601_SFLOAT result1 = new IEEE_11073_20601_SFLOAT(data, 0);

        assertFalse(BLEUtils.isSfloatNan(result1.getData(), 0));
        assertTrue(BLEUtils.isSfloatNres(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatPositiveInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatNegativeInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatRfu(result1.getData(), 0));
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0xfe;
        data[ 1] = 0x07;
        //@formatter:on

        IEEE_11073_20601_SFLOAT result1 = new IEEE_11073_20601_SFLOAT(data, 0);

        assertFalse(BLEUtils.isSfloatNan(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatNres(result1.getData(), 0));
        assertTrue(BLEUtils.isSfloatPositiveInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatNegativeInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatRfu(result1.getData(), 0));
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x02;
        data[ 1] = 0x08;
        //@formatter:on

        IEEE_11073_20601_SFLOAT result1 = new IEEE_11073_20601_SFLOAT(data, 0);

        assertFalse(BLEUtils.isSfloatNan(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatNres(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatPositiveInfinity(result1.getData(), 0));
        assertTrue(BLEUtils.isSfloatNegativeInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatRfu(result1.getData(), 0));
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;
        //@formatter:on

        IEEE_11073_20601_SFLOAT result1 = new IEEE_11073_20601_SFLOAT(data, 0);

        assertFalse(BLEUtils.isSfloatNan(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatNres(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatPositiveInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatNegativeInfinity(result1.getData(), 0));
        assertTrue(BLEUtils.isSfloatRfu(result1.getData(), 0));
    }

    @Test
    public void test_constructor006() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        IEEE_11073_20601_SFLOAT result1 = new IEEE_11073_20601_SFLOAT(data, 0);

        assertEquals(0x0201, BLEUtils.createSfloat(result1.getData(), 0), 0);
        assertFalse(BLEUtils.isSfloatNan(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatNres(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatPositiveInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatNegativeInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatRfu(result1.getData(), 0));
    }

    @Test
    public void test_constructor007() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x72;
        //@formatter:on

        IEEE_11073_20601_SFLOAT result1 = new IEEE_11073_20601_SFLOAT(data, 0);

        assertEquals(0x0201 * Math.pow(10, 7), result1.getSfloat(), 0);
        assertFalse(BLEUtils.isSfloatNan(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatNres(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatPositiveInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatNegativeInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatRfu(result1.getData(), 0));
    }

    @Test
    public void test_constructor008() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0xf2;
        //@formatter:on

        IEEE_11073_20601_SFLOAT result1 = new IEEE_11073_20601_SFLOAT(data, 0);

        assertEquals(0x0201 * Math.pow(10, -1), result1.getSfloat(), 0);
        assertFalse(BLEUtils.isSfloatNan(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatNres(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatPositiveInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatNegativeInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatRfu(result1.getData(), 0));
    }

    @Test
    public void test_constructor009() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        IEEE_11073_20601_SFLOAT result1 = new IEEE_11073_20601_SFLOAT(data, 1);

        assertEquals(0x0302, BLEUtils.createSfloat(result1.getData(), 0), 0);
        assertFalse(BLEUtils.isSfloatNan(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatNres(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatPositiveInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatNegativeInfinity(result1.getData(), 0));
        assertFalse(BLEUtils.isSfloatRfu(result1.getData(), 0));
    }
}
