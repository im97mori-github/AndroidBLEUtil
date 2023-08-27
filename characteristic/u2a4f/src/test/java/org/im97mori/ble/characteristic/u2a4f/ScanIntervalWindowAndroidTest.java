package org.im97mori.ble.characteristic.u2a4f;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("unused")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ScanIntervalWindowAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data_00001 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        ScanIntervalWindowAndroid result1 = new ScanIntervalWindowAndroid(data);
        assertEquals(0x0201, result1.getLeScanInterval());
        assertEquals(ScanIntervalWindow.LE_SCAN_INTERVAL_RESOLUTION * 0x0201, result1.getLeScanIntervalMs(), 0);
        assertEquals(0x0403, result1.getLeScanWindow());
        assertEquals(ScanIntervalWindow.LE_SCAN_WINDOW_RESOLUTION * 0x0403, result1.getLeScanWindowMs(), 0);
    }

    @Test
    public void test_constructor_00002() {
        int leScanInterval = 1;
        int leScanWindow = 2;

        ScanIntervalWindowAndroid result1 = new ScanIntervalWindowAndroid(leScanInterval, leScanWindow);
        assertEquals(leScanInterval, result1.getLeScanInterval());
        assertEquals(leScanWindow, result1.getLeScanWindow());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ScanIntervalWindowAndroid result1 = new ScanIntervalWindowAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ScanIntervalWindowAndroid result2 = ScanIntervalWindowAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLeScanInterval(), result2.getLeScanInterval());
        assertEquals(result1.getLeScanWindow(), result2.getLeScanWindow());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ScanIntervalWindowAndroid result1 = new ScanIntervalWindowAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ScanIntervalWindowAndroid result1 = new ScanIntervalWindowAndroid(data);
        ScanIntervalWindowAndroid result2 = ScanIntervalWindowAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
