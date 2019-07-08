package org.im97mori.ble.ad;

import org.junit.Test;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
import static org.junit.Assert.assertEquals;

public class ChannelMapUpdateIndicationTest {

    @Test
    public void constructTest1() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111110;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0b11111110 & 0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(1, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2404, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest2() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111101;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0b11111101 & 0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(2, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2406, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest3() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111011;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0b11111011 & 0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(3, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2408, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest4() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11110111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0b11110111 & 0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(4, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2410, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest5() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11101111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0b11101111 & 0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(5, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2412, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest6() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11011111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0b11011111 & 0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(6, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2414, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest7() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b10111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0b10111111 & 0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(7, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2416, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest8() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b01111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0b01111111 & 0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(8, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2418, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest9() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111110;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0b11111110 & 0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(9, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2420, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest10() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111101;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0b11111101 & 0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(10, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2422, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest11() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111011;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0b11111011 & 0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(11, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2424, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest12() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11110111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0b11110111 & 0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(13, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2428, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest13() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11101111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0b11101111 & 0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(14, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2430, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest14() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11011111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0b11011111 & 0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(15, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2432, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest15() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b10111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0b10111111 & 0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(16, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2434, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest16() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b01111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0b01111111 & 0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(17, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2436, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest17() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111110;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0b11111110 & 0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(18, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2438, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest18() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111101;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0b11111101 & 0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(19, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2440, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest19() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111011;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0b11111011 & 0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(20, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2442, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest20() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11110111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0b11110111 & 0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(21, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2444, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest21() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11101111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0b11101111 & 0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(22, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2446, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest22() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11011111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0b11011111 & 0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(23, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2448, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest23() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b10111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0b10111111 & 0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(24, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2450, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest24() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b01111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0b01111111 & 0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(25, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2452, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest25() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111110;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0b11111110 & 0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(26, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2454, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest26() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111101;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0b11111101 & 0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(27, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2456, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest27() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111011;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0b11111011 & 0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(28, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2458, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest28() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11110111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0b11110111 & 0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(29, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2460, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest29() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11101111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0b11101111 & 0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(30, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2462, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest30() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11011111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0b11011111 & 0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(31, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2464, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest31() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b10111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0b10111111 & 0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(32, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2466, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest32() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b01111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0b01111111 & 0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(33, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2468, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest33() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111110;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0b11111110 & 0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(34, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2470, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest34() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111101;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0b11111101 & 0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(35, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2472, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest35() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111011;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0b11111011 & 0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(36, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2474, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest36() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11110111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0b11110111 & 0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(37, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2476, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest37() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11101111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0b11101111 & 0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(38, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2478, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest38() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11011111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0b11011111 & 0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(0, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2402, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest39() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b10111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0b10111111 & 0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(12, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2426, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest40() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b01111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0b01111111 & 0xff, result.getChmList().get(4).intValue());
        assertEquals(1, result.getUnusedPhyChannelList().size());
        assertEquals(39, result.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2480, result.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest41() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(0, result.getUnusedPhyChannelList().size());
        assertEquals(0, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest42() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000000;
        data[6] = 0b00000000;
        data[7] = 0b00000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0b00000000, result.getChmList().get(0).intValue());
        assertEquals(0b00000000, result.getChmList().get(1).intValue());
        assertEquals(0b00000000, result.getChmList().get(2).intValue());
        assertEquals(0b00000000, result.getChmList().get(3).intValue());
        assertEquals(0b00000000, result.getChmList().get(4).intValue());
        assertEquals(40, result.getUnusedPhyChannelList().size());
        for (int i = 0; i < 40; i++) {
            assertEquals(i, result.getUnusedPhyChannelList().get(i).intValue());
        }
        assertEquals(40, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        for (int i = 0; i < 40; i++) {
            assertEquals(2400 + (i + 1) * 2, result.getUnusedPhyChannelRfCenterFrequencyList().get(i).intValue());
        }
        assertEquals(0, result.getInstant());
    }

    @Test
    public void constructTest43() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000001;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(0, result.getUnusedPhyChannelList().size());
        assertEquals(0, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b00000000_00000001, result.getInstant());
    }

    @Test
    public void constructTest44() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = (byte) 0b10000000;
        data[8] = 0b00000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(0, result.getUnusedPhyChannelList().size());
        assertEquals(0, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b00000000_10000000, result.getInstant());
    }

    @Test
    public void constructTest45() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = (byte) 0b00000000;
        data[8] = 0b00000001;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(0, result.getUnusedPhyChannelList().size());
        assertEquals(0, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b00000001_00000000, result.getInstant());
    }

    @Test
    public void constructTest46() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = (byte) 0b00000000;
        data[8] = (byte) 0b10000000;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(0, result.getUnusedPhyChannelList().size());
        assertEquals(0, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b10000000_00000000, result.getInstant());
    }

    @Test
    public void constructTest47() {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = (byte) 0b11111111;
        data[8] = (byte) 0b11111111;

        ChannelMapUpdateIndication result = new ChannelMapUpdateIndication(data, 0, data[0]);
        assertEquals(8, result.getLength());
        assertEquals(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION, result.getDataType());
        assertEquals(5, result.getChmList().size());
        assertEquals(0xff, result.getChmList().get(0).intValue());
        assertEquals(0xff, result.getChmList().get(1).intValue());
        assertEquals(0xff, result.getChmList().get(2).intValue());
        assertEquals(0xff, result.getChmList().get(3).intValue());
        assertEquals(0xff, result.getChmList().get(4).intValue());
        assertEquals(0, result.getUnusedPhyChannelList().size());
        assertEquals(0, result.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b11111111_11111111, result.getInstant());
    }
}
