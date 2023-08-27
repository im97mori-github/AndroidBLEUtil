package org.im97mori.ble.characteristic.u2a28;

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
public class SoftwareRevisionStringAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        String softwareRevision = "00.00";

        SoftwareRevisionStringAndroid result1 = new SoftwareRevisionStringAndroid(softwareRevision.getBytes());
        assertEquals(softwareRevision, result1.getSoftwareRevision());
    }

    @Test
    public void test_constructor002() {
        String softwareRevision = "99.99";

        SoftwareRevisionStringAndroid result1 = new SoftwareRevisionStringAndroid(softwareRevision.getBytes());
        assertEquals(softwareRevision, result1.getSoftwareRevision());
    }

    @Test
    public void test_constructor003() {
        String softwareRevision = "99.99";

        SoftwareRevisionStringAndroid result1 = new SoftwareRevisionStringAndroid(softwareRevision);
        assertEquals(softwareRevision, result1.getSoftwareRevision());
    }

    @Test
    public void test_parcelable001() {
        String softwareRevision = "00.00";

        SoftwareRevisionStringAndroid result1 = new SoftwareRevisionStringAndroid(softwareRevision.getBytes());
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SoftwareRevisionStringAndroid result2 = SoftwareRevisionStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getSoftwareRevision(), result1.getSoftwareRevision());
    }

    @Test
    public void test_parcelable002() {
        String softwareRevision = "12.34";

        SoftwareRevisionStringAndroid result1 = new SoftwareRevisionStringAndroid(softwareRevision.getBytes());
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SoftwareRevisionStringAndroid result2 = SoftwareRevisionStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getSoftwareRevision(), result2.getSoftwareRevision());
    }

    @Test
    public void test_parcelable003() {
        String softwareRevision = "12.34";

        SoftwareRevisionStringAndroid result1 = new SoftwareRevisionStringAndroid(softwareRevision.getBytes());
        byte[] resultData = result1.getBytes();
        assertArrayEquals(softwareRevision.getBytes(), resultData);
    }

    @Test
    public void test_parcelable004() {
        String softwareRevision = "12.34";

        SoftwareRevisionStringAndroid result1 = new SoftwareRevisionStringAndroid(softwareRevision.getBytes());
        SoftwareRevisionStringAndroid result2 = SoftwareRevisionStringAndroid.CREATOR.createFromByteArray(softwareRevision.getBytes());
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
