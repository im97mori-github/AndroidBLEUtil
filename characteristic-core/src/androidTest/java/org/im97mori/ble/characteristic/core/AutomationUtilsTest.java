package org.im97mori.ble.characteristic.core;

import org.im97mori.ble.descriptor.CharacteristicPresentationFormat;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AutomationUtilsTest {

    @Test
    public void test_isInactive001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_INACTIVE;
        //@formatter:on

        assertTrue(AutomationIoUtils.isInactive(data, 0));
        assertFalse(AutomationIoUtils.isActive(data, 0));
        assertFalse(AutomationIoUtils.isTriState(data, 0));
        assertFalse(AutomationIoUtils.isOutputState(data, 0));
    }

    @Test
    public void test_isInactive002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_INACTIVE << 2;
        //@formatter:on

        assertTrue(AutomationIoUtils.isInactive(data, 1));
        assertFalse(AutomationIoUtils.isActive(data, 1));
        assertFalse(AutomationIoUtils.isTriState(data, 1));
        assertFalse(AutomationIoUtils.isOutputState(data, 1));
    }

    @Test
    public void test_isInactive003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_INACTIVE << 2;
        //@formatter:on

        assertTrue(AutomationIoUtils.isInactive(data, 5));
        assertFalse(AutomationIoUtils.isActive(data, 5));
        assertFalse(AutomationIoUtils.isTriState(data, 5));
        assertFalse(AutomationIoUtils.isOutputState(data, 5));
    }

    @Test
    public void test_isActive001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_ACTIVE;
        //@formatter:on

        assertFalse(AutomationIoUtils.isInactive(data, 0));
        assertTrue(AutomationIoUtils.isActive(data, 0));
        assertFalse(AutomationIoUtils.isTriState(data, 0));
        assertFalse(AutomationIoUtils.isOutputState(data, 0));
    }

    @Test
    public void test_isActive002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_ACTIVE << 2;
        //@formatter:on

        assertFalse(AutomationIoUtils.isInactive(data, 1));
        assertTrue(AutomationIoUtils.isActive(data, 1));
        assertFalse(AutomationIoUtils.isTriState(data, 1));
        assertFalse(AutomationIoUtils.isOutputState(data, 1));
    }

    @Test
    public void test_isActive003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_ACTIVE << 2;
        //@formatter:on

        assertFalse(AutomationIoUtils.isInactive(data, 5));
        assertTrue(AutomationIoUtils.isActive(data, 5));
        assertFalse(AutomationIoUtils.isTriState(data, 5));
        assertFalse(AutomationIoUtils.isOutputState(data, 5));
    }

    @Test
    public void test_isTriState001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_TRI_STATE;
        //@formatter:on

        assertFalse(AutomationIoUtils.isInactive(data, 0));
        assertFalse(AutomationIoUtils.isActive(data, 0));
        assertTrue(AutomationIoUtils.isTriState(data, 0));
        assertFalse(AutomationIoUtils.isOutputState(data, 0));
    }

    @Test
    public void test_isTriState002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_TRI_STATE << 2;
        //@formatter:on

        assertFalse(AutomationIoUtils.isInactive(data, 1));
        assertFalse(AutomationIoUtils.isActive(data, 1));
        assertTrue(AutomationIoUtils.isTriState(data, 1));
        assertFalse(AutomationIoUtils.isOutputState(data, 1));
    }

    @Test
    public void test_isTriState003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_TRI_STATE << 2;
        //@formatter:on

        assertFalse(AutomationIoUtils.isInactive(data, 5));
        assertFalse(AutomationIoUtils.isActive(data, 5));
        assertTrue(AutomationIoUtils.isTriState(data, 5));
        assertFalse(AutomationIoUtils.isOutputState(data, 5));
    }

    @Test
    public void test_isOutputState001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_OUTPUT_STATE;
        //@formatter:on

        assertFalse(AutomationIoUtils.isInactive(data, 0));
        assertFalse(AutomationIoUtils.isActive(data, 0));
        assertFalse(AutomationIoUtils.isTriState(data, 0));
        assertTrue(AutomationIoUtils.isOutputState(data, 0));
    }

    @Test
    public void test_isOutputState002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = AutomationIoUtils.DIGITAL_OUTPUT_STATE << 2;
        //@formatter:on

        assertFalse(AutomationIoUtils.isInactive(data, 1));
        assertFalse(AutomationIoUtils.isActive(data, 1));
        assertFalse(AutomationIoUtils.isTriState(data, 1));
        assertTrue(AutomationIoUtils.isOutputState(data, 1));
    }

    @Test
    public void test_isOutputState003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0;
        data[ 1] = AutomationIoUtils.DIGITAL_OUTPUT_STATE << 2;
        //@formatter:on

        assertFalse(AutomationIoUtils.isInactive(data, 5));
        assertFalse(AutomationIoUtils.isActive(data, 5));
        assertFalse(AutomationIoUtils.isTriState(data, 5));
        assertTrue(AutomationIoUtils.isOutputState(data, 5));
    }

    @Test
    public void test_getAnalogWithFormat001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_UNSIGNED_8_BIT_INTEGER;
        formatData[ 1] = 0;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0x81 * Math.pow(10, 0), AutomationIoUtils.getAnalogWithFormat(data, format, 0), 0);
    }

    @Test
    public void test_getAnalogWithFormat002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_UNSIGNED_8_BIT_INTEGER;
        formatData[ 1] = 1;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0x81 * Math.pow(10, 1), AutomationIoUtils.getAnalogWithFormat(data, format, 0), 0);
    }

    @Test
    public void test_getAnalogWithFormat003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = (byte) 0x81;
        data[ 2] = 0x02;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_UNSIGNED_8_BIT_INTEGER;
        formatData[ 1] = 0;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0x81 * Math.pow(10, 0), AutomationIoUtils.getAnalogWithFormat(data, format, 1), 0);
    }

    @Test
    public void test_getAnalogWithFormat101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_UNSIGNED_12_BIT_INTEGER;
        formatData[ 1] = 0;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0x0801 * Math.pow(10, 0), AutomationIoUtils.getAnalogWithFormat(data, format, 0), 0);
    }

    @Test
    public void test_getAnalogWithFormat102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_UNSIGNED_12_BIT_INTEGER;
        formatData[ 1] = 1;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0x0801 * Math.pow(10, 1), AutomationIoUtils.getAnalogWithFormat(data, format, 0), 0);
    }

    @Test
    public void test_getAnalogWithFormat103() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = 0x08;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_UNSIGNED_12_BIT_INTEGER;
        formatData[ 1] = 0;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0x0801 * Math.pow(10, 0), AutomationIoUtils.getAnalogWithFormat(data, format, 1), 0);
    }

    @Test
    public void test_getAnalogWithFormat201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER;
        formatData[ 1] = 0;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0x8201 * Math.pow(10, 0), AutomationIoUtils.getAnalogWithFormat(data, format, 0), 0);
    }

    @Test
    public void test_getAnalogWithFormat202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER;
        formatData[ 1] = 1;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0x8201 * Math.pow(10, 1), AutomationIoUtils.getAnalogWithFormat(data, format, 0), 0);
    }

    @Test
    public void test_getAnalogWithFormat203() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = (byte) 0x82;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER;
        formatData[ 1] = 0;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0x8201 * Math.pow(10, 0), AutomationIoUtils.getAnalogWithFormat(data, format, 1), 0);
    }

    @Test
    public void test_getAnalogWithFormat301() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_SIGNED_8_BIT_INTEGER;
        formatData[ 1] = 0;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0xffffff81 * Math.pow(10, 0), AutomationIoUtils.getAnalogWithFormat(data, format, 0), 0);
    }

    @Test
    public void test_getAnalogWithFormat302() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0x81;
        data[ 1] = 0x02;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_SIGNED_8_BIT_INTEGER;
        formatData[ 1] = 1;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0xffffff81 * Math.pow(10, 1), AutomationIoUtils.getAnalogWithFormat(data, format, 0), 0);
    }

    @Test
    public void test_getAnalogWithFormat303() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = (byte) 0x81;
        data[ 2] = 0x02;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_SIGNED_8_BIT_INTEGER;
        formatData[ 1] = 0;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0xffffff81 * Math.pow(10, 0), AutomationIoUtils.getAnalogWithFormat(data, format, 1), 0);
    }

    @Test
    public void test_getAnalogWithFormat401() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_SIGNED_12_BIT_INTEGER;
        formatData[ 1] = 0;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0xfffff801 * Math.pow(10, 0), AutomationIoUtils.getAnalogWithFormat(data, format, 0), 0);
    }

    @Test
    public void test_getAnalogWithFormat402() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x08;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_SIGNED_12_BIT_INTEGER;
        formatData[ 1] = 1;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0xfffff801 * Math.pow(10, 1), AutomationIoUtils.getAnalogWithFormat(data, format, 0), 0);
    }

    @Test
    public void test_getAnalogWithFormat403() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = 0x08;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_SIGNED_12_BIT_INTEGER;
        formatData[ 1] = 0;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0xfffff801 * Math.pow(10, 0), AutomationIoUtils.getAnalogWithFormat(data, format, 1), 0);
    }

    @Test
    public void test_getAnalogWithFormat501() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_SIGNED_16_BIT_INTEGER;
        formatData[ 1] = 0;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0xffff8201 * Math.pow(10, 0), AutomationIoUtils.getAnalogWithFormat(data, format, 0), 0);
    }

    @Test
    public void test_getAnalogWithFormat502() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x82;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_SIGNED_16_BIT_INTEGER;
        formatData[ 1] = 1;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0xffff8201 * Math.pow(10, 1), AutomationIoUtils.getAnalogWithFormat(data, format, 0), 0);
    }

    @Test
    public void test_getAnalogWithFormat503() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = (byte) 0x82;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_SIGNED_16_BIT_INTEGER;
        formatData[ 1] = 0;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0xffff8201 * Math.pow(10, 0), AutomationIoUtils.getAnalogWithFormat(data, format, 1), 0);
    }

    @Test
    public void test_getAnalogWithFormat601() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0x02;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_IEEE_11073_16_BIT_SFLOAT;
        formatData[ 1] = 0;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0x0201, AutomationIoUtils.getAnalogWithFormat(data, format, 0), 0);
    }

    @Test
    public void test_getAnalogWithFormat602() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = (byte) 0x02;

        byte[] formatData = new byte[7];
        formatData[ 0] = (byte) CharacteristicPresentationFormat.FORMAT_IEEE_11073_16_BIT_SFLOAT;
        formatData[ 1] = 0;
        formatData[ 2] = (byte) 0xff;
        formatData[ 3] = (byte) 0xff;
        formatData[ 4] = (byte) 0xff;
        formatData[ 5] = (byte) 0xff;
        formatData[ 6] = (byte) 0xff;
        //@formatter:on

        CharacteristicPresentationFormat format = CharacteristicPresentationFormat.CREATOR.createFromByteArray(formatData);
        assertEquals(0x0201, AutomationIoUtils.getAnalogWithFormat(data, format, 1), 0);
    }

}
