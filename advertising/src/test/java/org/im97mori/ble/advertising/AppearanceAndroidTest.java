package org.im97mori.ble.advertising;

import static org.im97mori.ble.constants.DataType.APPEARANCE_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.constants.AppearanceValues;
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
public class AppearanceAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = APPEARANCE_DATA_TYPE;
        data[2] = (byte) AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY;
        data[3] = (byte) (AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY >> 8);
        data_00001 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        AppearanceAndroid result1 = new AppearanceAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(APPEARANCE_DATA_TYPE, result1.getDataType());
        long key = (data[2] & 0xff) | ((data[3] & 0xff) << 8);
        assertEquals(key, result1.getAppearance());
        assertEquals((key >> 6) & 0b00000011_11111111, result1.getAppearanceCategory());
        assertEquals(key & 0b11111111_11000000, result1.getAppearanceCategoryWithOffset());
        assertEquals(
                AppearanceValues.APPEARANCE_CATEGORY_MAPPING
                        .get(AppearanceValues.OUTDOOR_SPORTS_ACTIVITY_APPEARANCE_CATEGORY),
                result1.getAppearanceCategoryName());
        assertEquals(key & 0b00111111, result1.getAppearanceSubCategory());
        assertEquals(
                AppearanceValues.APPEARANCE_SUB_CATEGORY_MAPPING
                        .get(AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY),
                result1.getAppearanceSubCategoryName());
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        AppearanceAndroid result1 = new AppearanceAndroid(data, 0);
        assertEquals(3, result1.getLength());
        assertEquals(APPEARANCE_DATA_TYPE, result1.getDataType());
        long key = (data[2] & 0xff) | ((data[3] & 0xff) << 8);
        assertEquals(key, result1.getAppearance());
        assertEquals((key >> 6) & 0b00000011_11111111, result1.getAppearanceCategory());
        assertEquals(key & 0b11111111_11000000, result1.getAppearanceCategoryWithOffset());
        assertEquals(
                AppearanceValues.APPEARANCE_CATEGORY_MAPPING
                        .get(AppearanceValues.OUTDOOR_SPORTS_ACTIVITY_APPEARANCE_CATEGORY),
                result1.getAppearanceCategoryName());
        assertEquals(key & 0b00111111, result1.getAppearanceSubCategory());
        assertEquals(
                AppearanceValues.APPEARANCE_SUB_CATEGORY_MAPPING
                        .get(AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY),
                result1.getAppearanceSubCategoryName());
    }

    @Test
    public void test_constructor_3_00001() {
        byte[] data = getData();

        AppearanceAndroid result1 = new AppearanceAndroid(BLEUtils.createUInt16(data, 2));
        assertEquals(3, result1.getLength());
        assertEquals(APPEARANCE_DATA_TYPE, result1.getDataType());
        long key = (data[2] & 0xff) | ((data[3] & 0xff) << 8);
        assertEquals(key, result1.getAppearance());
        assertEquals((key >> 6) & 0b00000011_11111111, result1.getAppearanceCategory());
        assertEquals(key & 0b11111111_11000000, result1.getAppearanceCategoryWithOffset());
        assertEquals(
                AppearanceValues.APPEARANCE_CATEGORY_MAPPING
                        .get(AppearanceValues.OUTDOOR_SPORTS_ACTIVITY_APPEARANCE_CATEGORY),
                result1.getAppearanceCategoryName());
        assertEquals(key & 0b00111111, result1.getAppearanceSubCategory());
        assertEquals(
                AppearanceValues.APPEARANCE_SUB_CATEGORY_MAPPING
                        .get(AppearanceValues.LOCATION_AND_NAVIGATION_POD_APPEARANCE_SUB_CATEGORY),
                result1.getAppearanceSubCategoryName());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        AppearanceAndroid result1 = new AppearanceAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AppearanceAndroid result2 = AppearanceAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getAppearance(), result2.getAppearance());
        assertEquals(result1.getAppearanceCategory(), result2.getAppearanceCategory());
        assertEquals(result1.getAppearanceCategoryWithOffset(), result2.getAppearanceCategoryWithOffset());
        assertEquals(result1.getAppearanceSubCategory(), result2.getAppearanceSubCategory());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        AppearanceAndroid result1 = new AppearanceAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        AppearanceAndroid result1 = new AppearanceAndroid(data, 0, data[0]);
        AppearanceAndroid result2 = AppearanceAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
