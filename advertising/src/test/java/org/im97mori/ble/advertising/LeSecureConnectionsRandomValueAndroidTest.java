package org.im97mori.ble.advertising;

import static org.im97mori.ble.constants.DataType.LE_SECURE_CONNECTIONS_RANDOM_VALUE_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressWarnings("unused")
public class LeSecureConnectionsRandomValueAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[18];
        data[0] = 17;
        data[1] = LE_SECURE_CONNECTIONS_RANDOM_VALUE_DATA_TYPE;
        data[2] = 0x01;
        data[3] = 0x02;
        data[4] = 0x03;
        data[5] = 0x04;
        data[6] = 0x05;
        data[7] = 0x06;
        data[8] = 0x07;
        data[9] = 0x08;
        data[10] = 0x09;
        data[11] = 0x0a;
        data[12] = 0x0b;
        data[13] = 0x0c;
        data[14] = 0x0d;
        data[15] = 0x0e;
        data[16] = 0x0f;
        data[17] = 0x10;
        data_00001 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        LeSecureConnectionsRandomValueAndroid result1 = new LeSecureConnectionsRandomValueAndroid(data, 0, data[0]);
        assertEquals(17, result1.getLength());
        assertEquals(LE_SECURE_CONNECTIONS_RANDOM_VALUE_DATA_TYPE, result1.getDataType());
        assertEquals(BLEUtils.createUInt128(data, 2), result1.getLeSecureConnectionsRandomValue());
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        LeSecureConnectionsRandomValueAndroid result1 = new LeSecureConnectionsRandomValueAndroid(data, 0);
        assertEquals(17, result1.getLength());
        assertEquals(LE_SECURE_CONNECTIONS_RANDOM_VALUE_DATA_TYPE, result1.getDataType());
        assertEquals(BLEUtils.createUInt128(data, 2), result1.getLeSecureConnectionsRandomValue());
    }

    @Test
    public void test_constructor_3_00001() {
        byte[] data = getData();

        byte[] LeSecureConnectionsRandomValueAndroid = new byte[16];
        System.arraycopy(data, 2, LeSecureConnectionsRandomValueAndroid, 0, 16);
        LeSecureConnectionsRandomValueAndroid result1 = new LeSecureConnectionsRandomValueAndroid(LeSecureConnectionsRandomValueAndroid);
        assertEquals(17, result1.getLength());
        assertEquals(LE_SECURE_CONNECTIONS_RANDOM_VALUE_DATA_TYPE, result1.getDataType());
        assertEquals(BLEUtils.createUInt128(data, 2), result1.getLeSecureConnectionsRandomValue());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        LeSecureConnectionsRandomValueAndroid result1 = new LeSecureConnectionsRandomValueAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSecureConnectionsRandomValueAndroid result2 = LeSecureConnectionsRandomValueAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getLeSecureConnectionsRandomValue(), result1.getLeSecureConnectionsRandomValue());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        LeSecureConnectionsRandomValueAndroid result1 = new LeSecureConnectionsRandomValueAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        LeSecureConnectionsRandomValueAndroid result1 = new LeSecureConnectionsRandomValueAndroid(data, 0, data[0]);
        LeSecureConnectionsRandomValueAndroid result2 = LeSecureConnectionsRandomValueAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
