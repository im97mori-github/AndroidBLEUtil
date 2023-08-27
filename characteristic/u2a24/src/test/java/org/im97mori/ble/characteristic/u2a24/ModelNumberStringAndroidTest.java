package org.im97mori.ble.characteristic.u2a24;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
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
public class ModelNumberStringAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        String modelNumber = "2JCIE-BU01";

        ModelNumberStringAndroid result1 = new ModelNumberStringAndroid(modelNumber.getBytes());
        assertEquals(modelNumber, result1.getModelNumber());
    }

    @Test
    public void test_constructor002() {
        String modelNumber = "2JCIE-BU01";

        ModelNumberStringAndroid result1 = new ModelNumberStringAndroid(modelNumber);
        assertEquals(modelNumber, result1.getModelNumber());
    }

    @Test
    public void test_parcelable001() {
        String modelNumber = "2JCIE-BU01";

        ModelNumberStringAndroid result1 = new ModelNumberStringAndroid(modelNumber.getBytes());
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ModelNumberStringAndroid result2 = ModelNumberStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getModelNumber(), result2.getModelNumber());
    }


    @Test
    public void test_parcelable002() {
        String modelNumber = "2JCIE-BU01";

        ModelNumberStringAndroid result1 = new ModelNumberStringAndroid(modelNumber.getBytes());
        byte[] resultData = result1.getBytes();
        assertArrayEquals(modelNumber.getBytes(), resultData);
    }

    @Test
    public void test_parcelable003() {
        String modelNumber = "2JCIE-BU01";

        ModelNumberStringAndroid result1 = new ModelNumberStringAndroid(modelNumber.getBytes());
        ModelNumberStringAndroid result2 = ModelNumberStringAndroid.CREATOR.createFromByteArray(modelNumber.getBytes());
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
