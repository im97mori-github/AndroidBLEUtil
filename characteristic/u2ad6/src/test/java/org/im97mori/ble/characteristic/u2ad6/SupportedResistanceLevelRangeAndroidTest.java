package org.im97mori.ble.characteristic.u2ad6;

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
public class SupportedResistanceLevelRangeAndroidTest extends TestBase {

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

        SupportedResistanceLevelRangeAndroid result1 = new SupportedResistanceLevelRangeAndroid(data);
        assertEquals(0x0201, result1.getMinimumResistanceLevel());
        assertEquals(SupportedResistanceLevelRange.MINIMUM_RESISTANCE_LEVEL_RESOLUTION * 0x0201, result1.getMinimumResistanceLevelWithUnit(), 0);
        assertEquals(0x0403, result1.getMaximumResistanceLevel());
        assertEquals(SupportedResistanceLevelRange.MAXIMUM_RESISTANCE_LEVEL_RESOLUTION * 0x0403, result1.getMaximumResistanceLevelWithUnit(), 0);
        assertEquals(0x0605, result1.getMinimumIncrement());
        assertEquals(SupportedResistanceLevelRange.MINIMUM_INCREMENT_RESOLUTION * 0x0605, result1.getMinimumIncrementWithUnit(), 0);
    }

    @Test
    public void test_constructor_00002() {
        int minimumResistanceLevel = 1;
        int maximumResistanceLevel = 2;
        int minimumIncrement = 3;

        SupportedResistanceLevelRangeAndroid result1 = new SupportedResistanceLevelRangeAndroid(minimumResistanceLevel, maximumResistanceLevel, minimumIncrement);
        assertEquals(minimumResistanceLevel, result1.getMinimumResistanceLevel());
        assertEquals(maximumResistanceLevel, result1.getMaximumResistanceLevel());
        assertEquals(minimumIncrement, result1.getMinimumIncrement());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        SupportedResistanceLevelRangeAndroid result1 = new SupportedResistanceLevelRangeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SupportedResistanceLevelRangeAndroid result2 = SupportedResistanceLevelRangeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getMinimumResistanceLevel(), result2.getMinimumResistanceLevel());
        assertEquals(result1.getMaximumResistanceLevel(), result2.getMaximumResistanceLevel());
        assertEquals(result1.getMinimumIncrement(), result2.getMinimumIncrement());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        SupportedResistanceLevelRangeAndroid result1 = new SupportedResistanceLevelRangeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        SupportedResistanceLevelRangeAndroid result1 = new SupportedResistanceLevelRangeAndroid(data);
        SupportedResistanceLevelRangeAndroid result2 = SupportedResistanceLevelRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
