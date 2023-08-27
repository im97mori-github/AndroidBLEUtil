package org.im97mori.ble.characteristic.u2a26;

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
public class FirmwareRevisionStringAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        String firmwareRevision = "00.00";

        FirmwareRevisionStringAndroid result1 = new FirmwareRevisionStringAndroid(firmwareRevision.getBytes());
        assertEquals(firmwareRevision, result1.getFirmwareRevision());
    }

    @Test
    public void test_constructor002() {
        String firmwareRevision = "99.99";

        FirmwareRevisionStringAndroid result1 = new FirmwareRevisionStringAndroid(firmwareRevision.getBytes());
        assertEquals(firmwareRevision, result1.getFirmwareRevision());
    }

    @Test
    public void test_constructor003() {
        String firmwareRevision = "99.99";

        FirmwareRevisionStringAndroid result1 = new FirmwareRevisionStringAndroid(firmwareRevision);
        assertEquals(firmwareRevision, result1.getFirmwareRevision());
    }

    @Test
    public void test_parcelable001() {
        String firmwareRevision = "00.00";

        FirmwareRevisionStringAndroid result1 = new FirmwareRevisionStringAndroid(firmwareRevision.getBytes());
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FirmwareRevisionStringAndroid result2 = FirmwareRevisionStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFirmwareRevision(), result1.getFirmwareRevision());
    }

    @Test
    public void test_parcelable002() {
        String firmwareRevision = "12.34";

        FirmwareRevisionStringAndroid result1 = new FirmwareRevisionStringAndroid(firmwareRevision.getBytes());
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FirmwareRevisionStringAndroid result2 = FirmwareRevisionStringAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getFirmwareRevision(), result2.getFirmwareRevision());
    }

    @Test
    public void test_parcelable003() {
        String firmwareRevision = "12.34";

        FirmwareRevisionStringAndroid result1 = new FirmwareRevisionStringAndroid(firmwareRevision.getBytes());
        byte[] resultData = result1.getBytes();
        assertArrayEquals(firmwareRevision.getBytes(), resultData);
    }

    @Test
    public void test_parcelable004() {
        String firmwareRevision = "12.34";

        FirmwareRevisionStringAndroid result1 = new FirmwareRevisionStringAndroid(firmwareRevision.getBytes());
        FirmwareRevisionStringAndroid result2 = FirmwareRevisionStringAndroid.CREATOR.createFromByteArray(firmwareRevision.getBytes());
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
