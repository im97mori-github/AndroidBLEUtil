package org.im97mori.ble.characteristic.u2a4e;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ProtocolModeAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        //noinspection DataFlowIssue
        data[ 0] = ProtocolMode.PROTOCOL_MODE_VALUE_BOOT_PROTOCOL_MODE;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[1];
        data[ 0] = ProtocolMode.PROTOCOL_MODE_VALUE_REPORT_PROTOCOL_MODE;
        data_00002 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(data);
        assertEquals(ProtocolMode.PROTOCOL_MODE_VALUE_BOOT_PROTOCOL_MODE, result1.getProtocolModeValue());
        assertTrue(result1.isProtocolModeValueBootProtocolMode());
        assertFalse(result1.isProtocolModeValueReportProtocolMode());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(data);
        assertEquals(ProtocolMode.PROTOCOL_MODE_VALUE_REPORT_PROTOCOL_MODE, result1.getProtocolModeValue());
        assertFalse(result1.isProtocolModeValueBootProtocolMode());
        assertTrue(result1.isProtocolModeValueReportProtocolMode());
    }

    @Test
    public void test_constructor_00003() {
        int protocolModeValues = 1;

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(protocolModeValues);
        assertEquals(ProtocolMode.PROTOCOL_MODE_VALUE_REPORT_PROTOCOL_MODE, result1.getProtocolModeValue());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ProtocolModeAndroid result2 = ProtocolModeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getProtocolModeValue(), result2.getProtocolModeValue());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ProtocolModeAndroid result2 = ProtocolModeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getProtocolModeValue(), result2.getProtocolModeValue());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(data);
        ProtocolModeAndroid result2 = ProtocolModeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(data);
        ProtocolModeAndroid result2 = ProtocolModeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
