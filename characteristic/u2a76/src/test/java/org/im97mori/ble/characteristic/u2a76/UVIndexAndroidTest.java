package org.im97mori.ble.characteristic.u2a76;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class UVIndexAndroidTest extends TestBase {

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

        UVIndexAndroid result1 = new UVIndexAndroid(data);
        assertEquals(0x01, result1.getUVIndex());
    }

    @Test
    public void test_constructor_00002() {
        int UVIndex = 1;

        UVIndexAndroid result1 = new UVIndexAndroid(UVIndex);
        assertEquals(UVIndex, result1.getUVIndex());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        UVIndexAndroid result1 = new UVIndexAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UVIndexAndroid result2 = UVIndexAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getUVIndex(), result2.getUVIndex());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        UVIndexAndroid result1 = new UVIndexAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        UVIndexAndroid result1 = new UVIndexAndroid(data);
        UVIndexAndroid result2 = UVIndexAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
