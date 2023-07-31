package org.im97mori.ble.advertising;

import static org.im97mori.ble.constants.DataType.BIG_INFO_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.advertising.BigInfoAndroid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressWarnings("unused")
public class BigInfoTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000001;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b01000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = (byte) 0b10000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00001000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000001;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00100000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00007 = data;
    }

    private static final byte[] data_00008;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000001;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00008 = data;
    }

    private static final byte[] data_00009;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00010000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00009 = data;
    }

    private static final byte[] data_00010;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000001;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00010 = data;
    }

    private static final byte[] data_00011;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00010000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00011 = data;
    }

    private static final byte[] data_00012;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000001;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00012 = data;
    }

    private static final byte[] data_00013;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000001;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00013 = data;
    }

    private static final byte[] data_00014;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000001;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00014 = data;
    }

    private static final byte[] data_00015;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000001;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00015 = data;
    }

    private static final byte[] data_00016;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00010000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00016 = data;
    }

    private static final byte[] data_00017;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000001;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00017 = data;
    }

    private static final byte[] data_00018;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000001;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00018 = data;
    }

    private static final byte[] data_00019;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00100000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00019 = data;
    }

    private static final byte[] data_00020;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000001;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00020 = data;
    }

    private static final byte[] data_00021;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = (byte) 0b10000000;
        data_00021 = data;
    }

    private static final byte[] data_00022;
    static {
        byte[] data = new byte[59];
        data[ 0] = 58;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data[35] = 0b00000001;
        data[36] = 0b00000000;
        data[37] = 0b00000000;
        data[38] = 0b00000000;
        data[39] = 0b00000000;
        data[40] = 0b00000000;
        data[41] = 0b00000000;
        data[42] = 0b00000000;
        data[43] = 0b00000000;
        data[44] = 0b00000000;
        data[45] = 0b00000000;
        data[46] = 0b00000000;
        data[47] = 0b00000000;
        data[48] = 0b00000000;
        data[49] = 0b00000000;
        data[50] = 0b00000000;
        data[51] = 0b00000000;
        data[52] = 0b00000000;
        data[53] = 0b00000000;
        data[54] = 0b00000000;
        data[55] = 0b00000000;
        data[56] = 0b00000000;
        data[57] = 0b00000000;
        data[58] = 0b00000000;
        data_00022 = data;
    }

    private static final byte[] data_00023;
    static {
        byte[] data = new byte[59];
        data[ 0] = 58;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data[35] = 0b00000000;
        data[36] = 0b00000000;
        data[37] = 0b00000000;
        data[38] = 0b00000000;
        data[39] = 0b00000000;
        data[40] = 0b00000000;
        data[41] = 0b00000000;
        data[42] = 0b00000000;
        data[43] = 0b00000001;
        data[44] = 0b00000000;
        data[45] = 0b00000000;
        data[46] = 0b00000000;
        data[47] = 0b00000000;
        data[48] = 0b00000000;
        data[49] = 0b00000000;
        data[50] = 0b00000000;
        data[51] = 0b00000000;
        data[52] = 0b00000000;
        data[53] = 0b00000000;
        data[54] = 0b00000000;
        data[55] = 0b00000000;
        data[56] = 0b00000000;
        data[57] = 0b00000000;
        data[58] = 0b00000000;
        data_00023 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000000;
        data[ 3] = 0b01000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00102 = data;
    }

    private static final byte[] data_00103;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000001;
        data[ 3] = 0b00000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00103 = data;
    }

    private static final byte[] data_00104;
    static {
        byte[] data = new byte[35];
        data[ 0] = 34;
        data[ 1] = BIG_INFO_DATA_TYPE;
        data[ 2] = 0b00000001;
        data[ 3] = 0b01000000;
        data[ 4] = 0b00000000;
        data[ 5] = 0b00000000;
        data[ 6] = 0b00000000;
        data[ 7] = 0b00000000;
        data[ 8] = 0b00000000;
        data[ 9] = 0b00000000;
        data[10] = 0b00000000;
        data[11] = 0b00000000;
        data[12] = 0b00000000;
        data[13] = 0b00000000;
        data[14] = 0b00000000;
        data[15] = 0b00000000;
        data[16] = 0b00000000;
        data[17] = 0b00000000;
        data[18] = 0b00000000;
        data[19] = 0b00000000;
        data[20] = 0b00000000;
        data[21] = 0b00000000;
        data[22] = 0b00000000;
        data[23] = 0b00000000;
        data[24] = 0b00000000;
        data[25] = 0b00000000;
        data[26] = 0b00000000;
        data[27] = 0b00000000;
        data[28] = 0b00000000;
        data[29] = 0b00000000;
        data[30] = 0b00000000;
        data[31] = 0b00000000;
        data[32] = 0b00000000;
        data[33] = 0b00000000;
        data[34] = 0b00000000;
        data_00104 = data;
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
            String[] stringArray = stackTraceElement.getMethodName().split("_");
            try {
                data = (byte[]) this.getClass().getDeclaredField("data_" + stringArray[stringArray.length - 1]).get(null);
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

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00002() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00003() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(1, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00004() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(1, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00005() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(1, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00006() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(1, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00007() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(1, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00008() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(1, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00009() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(1, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00010() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(1, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00011() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(1, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00012() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(1, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00013() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(1, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00014() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(1, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00015() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(1, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00016() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(1, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00017() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(1, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00018() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(1, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00019() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(1, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00020() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(1, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00021() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(1, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_1_00022() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(58, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(Arrays.copyOfRange(data, 35, 43), result1.getGiv());
        assertArrayEquals(Arrays.copyOfRange(data, 43, 59), result1.getGskd());
    }

    @Test
    public void test_constructor_1_00023() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(58, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(Arrays.copyOfRange(data, 35, 43), result1.getGiv());
        assertArrayEquals(Arrays.copyOfRange(data, 43, 59), result1.getGskd());
    }

    @Test
    public void test_constructor_1_00101() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(0, result1.getBigOffsetMillis(), 0);
    }

    @Test
    public void test_constructor_1_00102() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(0, result1.getBigOffsetMillis(), 0);
    }

    @Test
    public void test_constructor_1_00103() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(30, result1.getBigOffsetMillis(), 0);
    }

    @Test
    public void test_constructor_1_00104() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertEquals(300, result1.getBigOffsetMillis(), 0);
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00002() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00003() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(1, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00004() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(1, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00005() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(1, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00006() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(1, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00007() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(1, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00008() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(1, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00009() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(1, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00010() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(1, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00011() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(1, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00012() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(1, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00013() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(1, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00014() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(1, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00015() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(1, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00016() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(1, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00017() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(1, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00018() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(1, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00019() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(1, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00020() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(1, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00021() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(1, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_2_00022() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(58, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(Arrays.copyOfRange(data, 35, 43), result1.getGiv());
        assertArrayEquals(Arrays.copyOfRange(data, 43, 59), result1.getGskd());
    }

    @Test
    public void test_constructor_2_00023() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0);
        assertEquals(58, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(Arrays.copyOfRange(data, 35, 43), result1.getGiv());
        assertArrayEquals(Arrays.copyOfRange(data, 43, 59), result1.getGskd());
    }

    @Test
    public void test_constructor_3_00001() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00002() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00003() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(1, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00004() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(1, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00005() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(1, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00006() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(1, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00007() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(1, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00008() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(1, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00009() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(1, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00010() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(1, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00011() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(1, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00012() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(1, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00013() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(1, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00014() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(1, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00015() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(1, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00016() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(1, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00017() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(1, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00018() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(1, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00019() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(1, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00020() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(1, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00021() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(34, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(1, result1.getFraming());
        assertArrayEquals(null, result1.getGiv());
        assertArrayEquals(null, result1.getGskd());
    }

    @Test
    public void test_constructor_3_00022() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(58, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(Arrays.copyOfRange(data, 35, 43), result1.getGiv());
        assertArrayEquals(Arrays.copyOfRange(data, 43, 59), result1.getGskd());
    }

    @Test
    public void test_constructor_3_00023() {
        byte[] data = getData();

        int value1 = BLEUtils.createUInt16(data, 2);
        int bigOffset = value1 & 0b0011111111111111;
        int bigOffsetUnits = (value1 & 0b0100000000000000) >>> 14;
        int value2 = BLEUtils.createUInt16(data, 4);
        int isoInterval = ((value1 & 0b1000000000000000) >>> 15) | ((value2 & 0b0000011111111111) << 1);
        int numBis = (value2 & 0b1111100000000000) >>> 11;
        int nse = data[6] & 0b00011111;
        int bn = (data[6] & 0b11100000) >>> 5;
        value1 = BLEUtils.createUInt24(data, 7);
        int subInterval = value1 & 0b000011111111111111111111;
        int pto = (value1 & 0b111100000000000000000000) >>> 20;
        value1 = BLEUtils.createUInt24(data, 10);
        int bisSpacing = value1 & 0b000011111111111111111111;
        int irc = (value1 & 0b111100000000000000000000) >>> 20;
        int maxPdu = data[13];
        int rfu = data[14];
        long seedAccessAddress = BLEUtils.createUInt32(data, 15);
        value1 = BLEUtils.createUInt24(data, 19);
        int sduInterval = value1 & 0b000011111111111111111111;
        int maxSdu = (value1 >>> 20) | (data[22] << 4);
        int baseCrcInit = BLEUtils.createUInt16(data, 23);
        long value3 = BLEUtils.createUInt40(data, 25);
        long chm = value3 & 0b0001111111111111111111111111111111111111L;
        int phy = (int) ((value3 & 0b1110000000000000000000000000000000000000L) >>> 37);
        value3 = BLEUtils.createUInt40(data, 30);
        long bisPayloadCount = value3 & 0b0111111111111111111111111111111111111111L;
        int framing = (int) ((value3 & 0b1000000000000000000000000000000000000000L) >>> 39);
        byte[] giv;
        byte[] gskd;
        if (data[0] == 58) {
            giv = Arrays.copyOfRange(data, 35, 43);
            gskd = Arrays.copyOfRange(data, 43, 59);
        } else {
            giv = null;
            gskd = null;
        }

        BigInfoAndroid result1 = new BigInfoAndroid(bigOffset, bigOffsetUnits, isoInterval, numBis, nse, bn, subInterval, pto,
                bisSpacing, irc, maxPdu, rfu, seedAccessAddress, sduInterval, maxSdu, baseCrcInit, chm, phy,
                bisPayloadCount, framing, giv, gskd);
        assertEquals(58, result1.getLength());
        assertEquals(BIG_INFO_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getBigOffset());
        assertEquals(0, result1.getBigOffsetUnits());
        assertEquals(0, result1.getIsoInterval());
        assertEquals(0, result1.getNumBis());
        assertEquals(0, result1.getNse());
        assertEquals(0, result1.getBn());
        assertEquals(0, result1.getSubInterval());
        assertEquals(0, result1.getPto());
        assertEquals(0, result1.getBisSpacing());
        assertEquals(0, result1.getIrc());
        assertEquals(0, result1.getMaxPdu());
        assertEquals(0, result1.getRfu());
        assertEquals(0, result1.getSeedAccessAddress());
        assertEquals(0, result1.getSduInterval());
        assertEquals(0, result1.getMaxSdu());
        assertEquals(0, result1.getBaseCrcInit());
        assertEquals(0, result1.getChm());
        assertEquals(0, result1.getPhy());
        assertEquals(0, result1.getBisPayloadCount());
        assertEquals(0, result1.getFraming());
        assertArrayEquals(Arrays.copyOfRange(data, 35, 43), result1.getGiv());
        assertArrayEquals(Arrays.copyOfRange(data, 43, 59), result1.getGskd());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00010() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00011() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00012() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00013() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00014() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00015() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00016() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00017() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00018() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00019() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00020() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00021() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00022() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_1_00023() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getBigOffset(), result2.getBigOffset());
        assertEquals(result1.getBigOffsetUnits(), result2.getBigOffsetUnits());
        assertEquals(result1.getIsoInterval(), result2.getIsoInterval());
        assertEquals(result1.getNumBis(), result2.getNumBis());
        assertEquals(result1.getNse(), result2.getNse());
        assertEquals(result1.getBn(), result2.getBn());
        assertEquals(result1.getSubInterval(), result2.getSubInterval());
        assertEquals(result1.getPto(), result2.getPto());
        assertEquals(result1.getBisSpacing(), result2.getBisSpacing());
        assertEquals(result1.getIrc(), result2.getIrc());
        assertEquals(result1.getMaxPdu(), result2.getMaxPdu());
        assertEquals(result1.getRfu(), result2.getRfu());
        assertEquals(result1.getSeedAccessAddress(), result2.getSeedAccessAddress());
        assertEquals(result1.getSduInterval(), result2.getSduInterval());
        assertEquals(result1.getMaxSdu(), result2.getMaxSdu());
        assertEquals(result1.getBaseCrcInit(), result2.getBaseCrcInit());
        assertEquals(result1.getChm(), result2.getChm());
        assertEquals(result1.getPhy(), result2.getPhy());
        assertEquals(result1.getBisPayloadCount(), result2.getBisPayloadCount());
        assertEquals(result1.getFraming(), result2.getFraming());
        assertArrayEquals(result1.getGiv(), result2.getGiv());
        assertArrayEquals(result1.getGskd(), result2.getGskd());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00010() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00011() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00012() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00013() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00014() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00015() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00016() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00017() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00018() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00019() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00020() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00021() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00022() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00023() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00009() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00010() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00011() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00012() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00013() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00014() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00015() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00016() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00017() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00018() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00019() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00020() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00021() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00022() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00023() {
        byte[] data = getData();

        BigInfoAndroid result1 = new BigInfoAndroid(data, 0, data[0]);
        BigInfoAndroid result2 = BigInfoAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
