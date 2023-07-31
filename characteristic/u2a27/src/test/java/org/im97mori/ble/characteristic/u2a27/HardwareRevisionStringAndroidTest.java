package org.im97mori.ble.characteristic.u2a27;

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
public class HardwareRevisionStringAndroidTest {

    @Test
    public void test_constructor001() {
        String hardwareRevision = "00.00";

        HardwareRevisionStringAndroid result1 = new HardwareRevisionStringAndroid(hardwareRevision.getBytes());
        assertEquals(hardwareRevision, result1.getHardwareRevision());
    }

    @Test
    public void test_constructor002() {
        String hardwareRevision = "99.99";

        HardwareRevisionStringAndroid result1 = new HardwareRevisionStringAndroid(hardwareRevision.getBytes());
        assertEquals(hardwareRevision, result1.getHardwareRevision());
    }

    @Test
    public void test_constructor003() {
        String hardwareRevision = "99.99";

        HardwareRevisionStringAndroid result1 = new HardwareRevisionStringAndroid(hardwareRevision);
        assertEquals(hardwareRevision, result1.getHardwareRevision());
    }

    @Test
    public void test_parcelable001() {
        String hardwareRevision = "00.00";

        HardwareRevisionStringAndroid result1 = new HardwareRevisionStringAndroid(hardwareRevision.getBytes());
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HardwareRevisionStringAndroid result2 = HardwareRevisionStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getHardwareRevision(), result1.getHardwareRevision());
    }

    @Test
    public void test_parcelable002() {
        String hardwareRevision = "12.34";

        HardwareRevisionStringAndroid result1 = new HardwareRevisionStringAndroid(hardwareRevision.getBytes());
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HardwareRevisionStringAndroid result2 = HardwareRevisionStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getHardwareRevision(), result2.getHardwareRevision());
    }

    @Test
    public void test_parcelable003() {
        String hardwareRevision = "12.34";

        HardwareRevisionStringAndroid result1 = new HardwareRevisionStringAndroid(hardwareRevision.getBytes());
        byte[] resultData = result1.getBytes();
        assertArrayEquals(hardwareRevision.getBytes(), resultData);
    }

    @Test
    public void test_parcelable004() {
        String hardwareRevision = "12.34";

        HardwareRevisionStringAndroid result1 = new HardwareRevisionStringAndroid(hardwareRevision.getBytes());
        HardwareRevisionStringAndroid result2 = HardwareRevisionStringAndroid.CREATOR.createFromByteArray(hardwareRevision.getBytes());
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
