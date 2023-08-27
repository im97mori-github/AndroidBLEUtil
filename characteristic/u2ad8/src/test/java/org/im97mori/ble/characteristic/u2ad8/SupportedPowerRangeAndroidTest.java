package org.im97mori.ble.characteristic.u2ad8;

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
public class SupportedPowerRangeAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data_00001 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        SupportedPowerRangeAndroid result1 = new SupportedPowerRangeAndroid(data);
        assertEquals(0x0201, result1.getMinimumPower());
        assertEquals(0x0403, result1.getMaximumPower());
        assertEquals(0x0605, result1.getMinimumIncrement());
    }

    @Test
    public void test_constructor_00002() {
        int minimumPower = 1;
        int maximumPower = 2;
        int minimumIncrement = 3;

        SupportedPowerRangeAndroid result1 = new SupportedPowerRangeAndroid(minimumPower, maximumPower, minimumIncrement);
        assertEquals(minimumPower, result1.getMinimumPower());
        assertEquals(maximumPower, result1.getMaximumPower());
        assertEquals(minimumIncrement, result1.getMinimumIncrement());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        SupportedPowerRangeAndroid result1 = new SupportedPowerRangeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SupportedPowerRangeAndroid result2 = SupportedPowerRangeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getMinimumPower(), result2.getMinimumPower());
        assertEquals(result1.getMaximumPower(), result2.getMaximumPower());
        assertEquals(result1.getMinimumIncrement(), result2.getMinimumIncrement());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        SupportedPowerRangeAndroid result1 = new SupportedPowerRangeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        SupportedPowerRangeAndroid result1 = new SupportedPowerRangeAndroid(data);
        SupportedPowerRangeAndroid result2 = SupportedPowerRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
