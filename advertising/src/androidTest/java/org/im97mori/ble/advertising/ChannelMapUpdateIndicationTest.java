package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import static org.im97mori.ble.constants.DataType.CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class ChannelMapUpdateIndicationTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111110;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111101;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111011;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11110111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11101111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11011111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b10111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00007 = data;
    }

    private static final byte[] data_00008;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b01111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00008 = data;
    }

    private static final byte[] data_00009;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111110;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00009 = data;
    }

    private static final byte[] data_00010;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111101;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00010 = data;
    }

    private static final byte[] data_00011;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111011;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00011 = data;
    }

    private static final byte[] data_00012;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11110111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00012 = data;
    }

    private static final byte[] data_00013;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11101111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00013 = data;
    }

    private static final byte[] data_00014;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11011111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00014 = data;
    }

    private static final byte[] data_00015;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b10111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00015 = data;
    }

    private static final byte[] data_00016;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b01111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00016 = data;
    }

    private static final byte[] data_00017;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111110;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00017 = data;
    }

    private static final byte[] data_00018;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111101;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00018 = data;
    }

    private static final byte[] data_00019;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111011;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00019 = data;
    }

    private static final byte[] data_00020;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11110111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00020 = data;
    }

    private static final byte[] data_00021;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11101111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00021 = data;
    }

    private static final byte[] data_00022;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11011111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00022 = data;
    }

    private static final byte[] data_00023;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b10111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00023 = data;
    }

    private static final byte[] data_00024;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b01111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00024 = data;
    }

    private static final byte[] data_00025;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111110;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00025 = data;
    }

    private static final byte[] data_00026;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111101;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00026 = data;
    }

    private static final byte[] data_00027;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111011;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00027 = data;
    }

    private static final byte[] data_00028;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11110111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00028 = data;
    }

    private static final byte[] data_00029;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11101111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00029 = data;
    }

    private static final byte[] data_00030;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11011111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00030 = data;
    }

    private static final byte[] data_00031;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b10111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00031 = data;
    }

    private static final byte[] data_00032;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b01111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00032 = data;
    }

    private static final byte[] data_00033;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111110;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00033 = data;
    }

    private static final byte[] data_00034;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111101;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00034 = data;
    }

    private static final byte[] data_00035;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111011;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00035 = data;
    }

    private static final byte[] data_00036;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11110111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00036 = data;
    }

    private static final byte[] data_00037;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11101111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00037 = data;
    }

    private static final byte[] data_00038;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11011111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00038 = data;
    }

    private static final byte[] data_00039;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b10111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00039 = data;
    }

    private static final byte[] data_00040;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b01111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00040 = data;
    }

    private static final byte[] data_00041;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00041 = data;
    }

    private static final byte[] data_00042;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000000;
        data[6] = 0b00000000;
        data[7] = 0b00000000;
        data[8] = 0b00000000;
        data_00042 = data;
    }

    private static final byte[] data_00043;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = 0b00000001;
        data[8] = 0b00000000;
        data_00043 = data;
    }

    private static final byte[] data_00044;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = (byte) 0b10000000;
        data[8] = 0b00000000;
        data_00044 = data;
    }

    private static final byte[] data_00045;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = (byte) 0b00000000;
        data[8] = 0b00000001;
        data_00045 = data;
    }

    private static final byte[] data_00046;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = (byte) 0b00000000;
        data[8] = (byte) 0b10000000;
        data_00046 = data;
    }

    private static final byte[] data_00047;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data[7] = (byte) 0b11111111;
        data[8] = (byte) 0b11111111;
        data_00047 = data;
    }
    //@formatter:on

    private byte[] getData() {
        int index = -1;
        byte[] data = null;

        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElementArray.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            if ("getData".equals(stackTraceElement.getMethodName())) {
                index = i + 1;
                break;
            }
        }
        if (index >= 0 && index < stackTraceElementArray.length) {
            StackTraceElement stackTraceElement = stackTraceElementArray[index];
            String[] splitted = stackTraceElement.getMethodName().split("_");
            try {
                data = (byte[]) this.getClass().getDeclaredField("data_" + splitted[splitted.length - 1]).get(null);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11111110 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(1, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2404, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00002() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11111101 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(2, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2406, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00003() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11111011 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(3, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2408, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00004() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11110111 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(4, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2410, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00005() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11101111 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(5, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2412, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00006() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11011111 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(6, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2414, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00007() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b10111111 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(7, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2416, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00008() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b01111111 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(8, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2418, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00009() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11111110 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(9, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2420, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00010() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11111101 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(10, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2422, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00011() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11111011 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(11, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2424, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00012() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11110111 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(13, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2428, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00013() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11101111 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(14, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2430, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00014() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11011111 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(15, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2432, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00015() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b10111111 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(16, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2434, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00016() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b01111111 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(17, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2436, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00017() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11111110 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(18, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2438, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00018() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11111101 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(19, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2440, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00019() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11111011 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(20, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2442, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00020() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11110111 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(21, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2444, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00021() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11101111 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(22, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2446, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00022() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11011111 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(23, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2448, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00023() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b10111111 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(24, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2450, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00024() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b01111111 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(25, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2452, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00025() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11111110 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(26, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2454, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00026() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11111101 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(27, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2456, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00027() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11111011 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(28, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2458, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00028() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11110111 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(29, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2460, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00029() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11101111 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(30, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2462, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00030() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11011111 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(31, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2464, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00031() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b10111111 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(32, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2466, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00032() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b01111111 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(33, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2468, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00033() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11111110 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(34, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2470, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00034() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11111101 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(35, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2472, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00035() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11111011 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(36, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2474, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00036() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11110111 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(37, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2476, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00037() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11101111 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(38, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2478, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00038() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11011111 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2402, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00039() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b10111111 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(12, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2426, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00040() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b01111111 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(39, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2480, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00041() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00042() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b00000000, result1.getChmList().get(0).intValue());
        assertEquals(0b00000000, result1.getChmList().get(1).intValue());
        assertEquals(0b00000000, result1.getChmList().get(2).intValue());
        assertEquals(0b00000000, result1.getChmList().get(3).intValue());
        assertEquals(0b00000000, result1.getChmList().get(4).intValue());
        assertEquals(40, result1.getUnusedPhyChannelList().size());
        for (int i = 0; i < 40; i++) {
            assertEquals(i, result1.getUnusedPhyChannelList().get(i).intValue());
        }
        assertEquals(40, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        for (int i = 0; i < 40; i++) {
            assertEquals(2400 + (i + 1) * 2, result1.getUnusedPhyChannelRfCenterFrequencyList().get(i).intValue());
        }
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00043() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b00000000_00000001, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00044() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b00000000_10000000, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00045() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b00000001_00000000, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00046() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b10000000_00000000, result1.getInstant());
    }

    @Test
    public void test_constructor_1_00047() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b11111111_11111111, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11111110 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(1, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2404, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00002() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11111101 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(2, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2406, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00003() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11111011 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(3, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2408, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00004() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11110111 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(4, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2410, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00005() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11101111 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(5, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2412, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00006() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11011111 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(6, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2414, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00007() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b10111111 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(7, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2416, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00008() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b01111111 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(8, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2418, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00009() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11111110 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(9, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2420, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00010() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11111101 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(10, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2422, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00011() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11111011 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(11, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2424, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00012() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11110111 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(13, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2428, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00013() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11101111 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(14, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2430, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00014() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11011111 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(15, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2432, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00015() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b10111111 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(16, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2434, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00016() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b01111111 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(17, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2436, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00017() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11111110 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(18, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2438, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00018() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11111101 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(19, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2440, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00019() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11111011 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(20, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2442, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00020() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11110111 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(21, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2444, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00021() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11101111 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(22, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2446, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00022() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11011111 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(23, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2448, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00023() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b10111111 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(24, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2450, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00024() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b01111111 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(25, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2452, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00025() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11111110 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(26, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2454, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00026() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11111101 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(27, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2456, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00027() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11111011 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(28, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2458, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00028() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11110111 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(29, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2460, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00029() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11101111 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(30, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2462, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00030() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11011111 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(31, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2464, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00031() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b10111111 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(32, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2466, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00032() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b01111111 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(33, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2468, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00033() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11111110 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(34, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2470, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00034() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11111101 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(35, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2472, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00035() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11111011 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(36, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2474, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00036() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11110111 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(37, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2476, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00037() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11101111 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(38, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2478, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00038() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11011111 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2402, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00039() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b10111111 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(12, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2426, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00040() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b01111111 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(39, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2480, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00041() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00042() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b00000000, result1.getChmList().get(0).intValue());
        assertEquals(0b00000000, result1.getChmList().get(1).intValue());
        assertEquals(0b00000000, result1.getChmList().get(2).intValue());
        assertEquals(0b00000000, result1.getChmList().get(3).intValue());
        assertEquals(0b00000000, result1.getChmList().get(4).intValue());
        assertEquals(40, result1.getUnusedPhyChannelList().size());
        for (int i = 0; i < 40; i++) {
            assertEquals(i, result1.getUnusedPhyChannelList().get(i).intValue());
        }
        assertEquals(40, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        for (int i = 0; i < 40; i++) {
            assertEquals(2400 + (i + 1) * 2, result1.getUnusedPhyChannelRfCenterFrequencyList().get(i).intValue());
        }
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00043() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b00000000_00000001, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00044() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b00000000_10000000, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00045() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b00000001_00000000, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00046() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b10000000_00000000, result1.getInstant());
    }

    @Test
    public void test_constructor_2_00047() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b11111111_11111111, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00001() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11111110 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(1, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2404, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00002() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11111101 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(2, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2406, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00003() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11111011 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(3, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2408, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00004() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11110111 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(4, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2410, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00005() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11101111 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(5, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2412, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00006() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b11011111 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(6, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2414, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00007() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b10111111 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(7, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2416, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00008() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b01111111 & 0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(8, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2418, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00009() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11111110 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(9, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2420, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00010() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11111101 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(10, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2422, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00011() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11111011 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(11, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2424, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00012() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11110111 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(13, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2428, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00013() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11101111 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(14, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2430, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00014() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b11011111 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(15, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2432, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00015() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b10111111 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(16, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2434, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00016() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0b01111111 & 0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(17, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2436, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00017() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11111110 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(18, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2438, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00018() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11111101 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(19, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2440, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00019() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11111011 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(20, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2442, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00020() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11110111 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(21, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2444, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00021() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11101111 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(22, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2446, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00022() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b11011111 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(23, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2448, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00023() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b10111111 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(24, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2450, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00024() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0b01111111 & 0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(25, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2452, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00025() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11111110 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(26, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2454, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00026() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11111101 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(27, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2456, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00027() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11111011 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(28, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2458, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00028() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11110111 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(29, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2460, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00029() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11101111 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(30, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2462, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00030() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b11011111 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(31, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2464, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00031() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b10111111 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(32, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2466, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00032() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0b01111111 & 0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(33, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2468, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00033() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11111110 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(34, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2470, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00034() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11111101 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(35, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2472, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00035() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11111011 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(36, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2474, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00036() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11110111 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(37, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2476, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00037() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11101111 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(38, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2478, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00038() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b11011111 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2402, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00039() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b10111111 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(12, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2426, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00040() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0b01111111 & 0xff, result1.getChmList().get(4).intValue());
        assertEquals(1, result1.getUnusedPhyChannelList().size());
        assertEquals(39, result1.getUnusedPhyChannelList().get(0).intValue());
        assertEquals(1, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(2480, result1.getUnusedPhyChannelRfCenterFrequencyList().get(0).intValue());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00041() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00042() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0b00000000, result1.getChmList().get(0).intValue());
        assertEquals(0b00000000, result1.getChmList().get(1).intValue());
        assertEquals(0b00000000, result1.getChmList().get(2).intValue());
        assertEquals(0b00000000, result1.getChmList().get(3).intValue());
        assertEquals(0b00000000, result1.getChmList().get(4).intValue());
        assertEquals(40, result1.getUnusedPhyChannelList().size());
        for (int i = 0; i < 40; i++) {
            assertEquals(i, result1.getUnusedPhyChannelList().get(i).intValue());
        }
        assertEquals(40, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        for (int i = 0; i < 40; i++) {
            assertEquals(2400 + (i + 1) * 2, result1.getUnusedPhyChannelRfCenterFrequencyList().get(i).intValue());
        }
        assertEquals(0, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00043() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b00000000_00000001, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00044() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b00000000_10000000, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00045() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b00000001_00000000, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00046() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b10000000_00000000, result1.getInstant());
    }

    @Test
    public void test_constructor_3_00047() {
        byte[] data = getData();

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[2] & 0xff);
        chmList.add(data[3] & 0xff);
        chmList.add(data[4] & 0xff);
        chmList.add(data[5] & 0xff);
        chmList.add(data[6] & 0xff);
        int instant = BLEUtils.createUInt16(data, 7);

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(chmList, instant);
        assertEquals(8, result1.getLength());
        assertEquals(CHANNEL_MAP_UPDATE_INDICATION_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getChmList().size());
        assertEquals(0xff, result1.getChmList().get(0).intValue());
        assertEquals(0xff, result1.getChmList().get(1).intValue());
        assertEquals(0xff, result1.getChmList().get(2).intValue());
        assertEquals(0xff, result1.getChmList().get(3).intValue());
        assertEquals(0xff, result1.getChmList().get(4).intValue());
        assertEquals(0, result1.getUnusedPhyChannelList().size());
        assertEquals(0, result1.getUnusedPhyChannelRfCenterFrequencyList().size());
        assertEquals(0b11111111_11111111, result1.getInstant());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00010() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00011() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00012() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00013() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00014() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00015() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00016() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00017() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00018() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00019() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00020() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00021() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00022() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00023() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00024() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00025() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00026() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00027() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00028() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00029() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00030() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00031() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00032() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00033() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00034() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00035() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00036() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00037() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00038() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00039() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00040() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00041() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00042() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00043() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00044() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00045() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00046() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_1_00047() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getChmList().toArray(), result2.getChmList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelList().toArray(), result2.getUnusedPhyChannelList().toArray());
        assertArrayEquals(result1.getUnusedPhyChannelRfCenterFrequencyList().toArray(), result2.getUnusedPhyChannelRfCenterFrequencyList().toArray());
        assertEquals(result1.getInstant(), result2.getInstant());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00010() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00011() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00012() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00013() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00014() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00015() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00016() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00017() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00018() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00019() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00020() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00021() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00022() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00023() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00024() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00025() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00026() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00027() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00028() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00029() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00030() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00031() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00032() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00033() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00034() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00035() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00036() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00037() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00038() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00039() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00040() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00041() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00042() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00043() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00044() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00045() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00046() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00047() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00009() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00010() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00011() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00012() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00013() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00014() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00015() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00016() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00017() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00018() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00019() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00020() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00021() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00022() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00023() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00024() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00025() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00026() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00027() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00028() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00029() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00030() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00031() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00032() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00033() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00034() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00035() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00036() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00037() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00038() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00039() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00040() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00041() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00042() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00043() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00044() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00045() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00046() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00047() {
        byte[] data = getData();

        ChannelMapUpdateIndicationAndroid result1 = new ChannelMapUpdateIndicationAndroid(data, 0, data[0]);
        ChannelMapUpdateIndicationAndroid result2 = ChannelMapUpdateIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
