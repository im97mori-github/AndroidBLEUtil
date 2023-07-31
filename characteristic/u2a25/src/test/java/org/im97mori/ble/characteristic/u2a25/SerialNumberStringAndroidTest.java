package org.im97mori.ble.characteristic.u2a25;

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
public class SerialNumberStringAndroidTest {

    @Test
    public void test_constructor001() {
        String serialNumber = "0000MY0000";

        SerialNumberStringAndroid result1 = new SerialNumberStringAndroid(serialNumber.getBytes());
        assertEquals(serialNumber, result1.getSerialNumber());
    }

    @Test
    public void test_constructor002() {
        String serialNumber = "39Z9MY9999";

        SerialNumberStringAndroid result1 = new SerialNumberStringAndroid(serialNumber.getBytes());
        assertEquals(serialNumber, result1.getSerialNumber());
    }

    @Test
    public void test_constructor003() {
        String serialNumber = "39Z9MY9999";

        SerialNumberStringAndroid result1 = new SerialNumberStringAndroid(serialNumber);
        assertEquals(serialNumber, result1.getSerialNumber());
    }

    @Test
    public void test_parcelable001() {
        String serialNumber = "0000MY0000";

        SerialNumberStringAndroid result1 = new SerialNumberStringAndroid(serialNumber.getBytes());
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SerialNumberStringAndroid result2 = SerialNumberStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getSerialNumber(), result2.getSerialNumber());
    }

    @Test
    public void test_parcelable002() {
        String serialNumber = "39Z9MY9999";

        SerialNumberStringAndroid result1 = new SerialNumberStringAndroid(serialNumber.getBytes());
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SerialNumberStringAndroid result2 = SerialNumberStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getSerialNumber(), result2.getSerialNumber());
    }

    @Test
    public void test_parcelable003() {
        String serialNumber = "39Z9MY9999";

        SerialNumberStringAndroid result1 = new SerialNumberStringAndroid(serialNumber.getBytes());
        byte[] resultData = result1.getBytes();
        assertArrayEquals(serialNumber.getBytes(), resultData);
    }

    @Test
    public void test_parcelable004() {
        String serialNumber = "39Z9MY9999";

        SerialNumberStringAndroid result1 = new SerialNumberStringAndroid(serialNumber.getBytes());
        SerialNumberStringAndroid result2 = SerialNumberStringAndroid.CREATOR.createFromByteArray(serialNumber.getBytes());
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
