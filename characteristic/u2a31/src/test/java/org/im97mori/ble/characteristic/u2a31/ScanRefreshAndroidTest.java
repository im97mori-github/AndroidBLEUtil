package org.im97mori.ble.characteristic.u2a31;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ScanRefreshAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        //noinspection DataFlowIssue
        data[ 0] = ScanRefresh.SCAN_REFRESH_VALUE_SERVER_REQUIRES_REFRESH;
        data_00001 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        ScanRefreshAndroid result1 = new ScanRefreshAndroid(data);
        assertEquals(ScanRefresh.SCAN_REFRESH_VALUE_SERVER_REQUIRES_REFRESH, result1.getScanRefreshValue());
        assertTrue(result1.isScanRefreshValueServerRequiresRefresh());
    }

    @Test
    public void test_constructor_00002() {
        int scanRefreshValue = 1;

        ScanRefreshAndroid result1 = new ScanRefreshAndroid(scanRefreshValue);
        assertEquals(scanRefreshValue, result1.getScanRefreshValue());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ScanRefreshAndroid result1 = new ScanRefreshAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ScanRefreshAndroid result2 = ScanRefreshAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getScanRefreshValue(), result2.getScanRefreshValue());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ScanRefreshAndroid result1 = new ScanRefreshAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ScanRefreshAndroid result1 = new ScanRefreshAndroid(data);
        ScanRefreshAndroid result2 = ScanRefreshAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
