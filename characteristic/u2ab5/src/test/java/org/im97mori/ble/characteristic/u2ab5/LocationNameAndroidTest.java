package org.im97mori.ble.characteristic.u2ab5;

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
public class LocationNameAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = 'a';
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        data[ 0] = 'a';
        data[ 1] = 'b';
        data_00002 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        LocationNameAndroid result1 = new LocationNameAndroid(data);
        assertEquals("a", result1.getLocationName());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        LocationNameAndroid result1 = new LocationNameAndroid(data);
        assertEquals("ab", result1.getLocationName());
    }

    @Test
    public void test_constructor_00003() {
        String locationName = "1";

        LocationNameAndroid result1 = new LocationNameAndroid(locationName);
        assertEquals(locationName, result1.getLocationName());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        LocationNameAndroid result1 = new LocationNameAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationNameAndroid result2 = LocationNameAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLocationName(), result2.getLocationName());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        LocationNameAndroid result1 = new LocationNameAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationNameAndroid result2 = LocationNameAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLocationName(), result2.getLocationName());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        LocationNameAndroid result1 = new LocationNameAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        LocationNameAndroid result1 = new LocationNameAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        LocationNameAndroid result1 = new LocationNameAndroid(data);
        LocationNameAndroid result2 = LocationNameAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        LocationNameAndroid result1 = new LocationNameAndroid(data);
        LocationNameAndroid result2 = LocationNameAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
