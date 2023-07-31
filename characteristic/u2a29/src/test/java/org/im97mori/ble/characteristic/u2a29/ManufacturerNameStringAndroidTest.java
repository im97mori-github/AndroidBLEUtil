package org.im97mori.ble.characteristic.u2a29;

import android.os.Build;
import android.os.Parcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ManufacturerNameStringAndroidTest {

    @Test
    public void test_constructor001() {
        String manufactureName = "OMRON";

        ManufacturerNameStringAndroid result1 = new ManufacturerNameStringAndroid(manufactureName.getBytes());
        assertEquals(manufactureName, result1.getManufacturerName());
    }

    @Test
    public void test_constructor002() {
        String manufactureName = "OMRON";

        ManufacturerNameStringAndroid result1 = new ManufacturerNameStringAndroid(manufactureName);
        assertEquals(manufactureName, result1.getManufacturerName());
    }

    @Test
    public void test_parcelable001() {
        String manufactureName = "OMRON";

        ManufacturerNameStringAndroid result1 = new ManufacturerNameStringAndroid(manufactureName.getBytes());
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ManufacturerNameStringAndroid result2 = ManufacturerNameStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getManufacturerName(), result2.getManufacturerName());
    }

    @Test
    public void test_parcelable002() {
        String manufactureName = "OMRON";

        ManufacturerNameStringAndroid result1 = new ManufacturerNameStringAndroid(manufactureName.getBytes());
        byte[] resultData = result1.getBytes();
        assertArrayEquals(manufactureName.getBytes(), resultData);
    }

    @Test
    public void test_parcelable003() {
        String manufactureName = "OMRON";

        ManufacturerNameStringAndroid result1 = new ManufacturerNameStringAndroid(manufactureName.getBytes());
        ManufacturerNameStringAndroid result2 = ManufacturerNameStringAndroid.CREATOR.createFromByteArray(manufactureName.getBytes());
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
