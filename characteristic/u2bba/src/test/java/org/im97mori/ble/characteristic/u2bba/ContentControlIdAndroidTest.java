package org.im97mori.ble.characteristic.u2bba;

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

@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ContentControlIdAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        data_00001 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        ContentControlIdAndroid result1 = new ContentControlIdAndroid(data);
        assertEquals(BLEUtils.createUInt8(data, 0), result1.getContentControlId());
    }

    @Test
    public void test_constructor_00101() {
        int contentControlId = 1;

        ContentControlIdAndroid result1 = new ContentControlIdAndroid(contentControlId);
        assertEquals(contentControlId, result1.getContentControlId());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ContentControlIdAndroid result1 = new ContentControlIdAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ContentControlIdAndroid result2 = ContentControlIdAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getContentControlId(), result2.getContentControlId());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ContentControlIdAndroid result1 = new ContentControlIdAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ContentControlIdAndroid result1 = new ContentControlIdAndroid(data);
        ContentControlIdAndroid result2 = ContentControlIdAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
