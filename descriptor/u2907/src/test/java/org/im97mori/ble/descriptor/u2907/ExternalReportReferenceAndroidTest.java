package org.im97mori.ble.descriptor.u2907;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.UUID;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ExternalReportReferenceAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;

        long target = value[0] & 0xff;
        target |= (value[1] & 0xff) << 8;
        target = target << 32;
        UUID uuid = new UUID(BASE_UUID.getMostSignificantBits() | target, BASE_UUID.getLeastSignificantBits());
        //@formatter:on

        ExternalReportReferenceAndroid result = new ExternalReportReferenceAndroid(value);
        assertArrayEquals(value, result.getExternalReportReference());
        assertEquals(uuid, result.getExternalReportReferenceUuid());
    }

    @Test
    public void test_constructor002() {
        byte[] externalReportReference = new byte[]{1};
        UUID uuid = UUID.randomUUID();

        ExternalReportReferenceAndroid result = new ExternalReportReferenceAndroid(externalReportReference, uuid);
        assertArrayEquals(externalReportReference, result.getExternalReportReference());
        assertEquals(uuid, result.getExternalReportReferenceUuid());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        ExternalReportReferenceAndroid result1 = new ExternalReportReferenceAndroid(value);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ExternalReportReferenceAndroid result2 = ExternalReportReferenceAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getExternalReportReference(), result2.getExternalReportReference());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        ExternalReportReferenceAndroid result1 = new ExternalReportReferenceAndroid(value);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        ExternalReportReferenceAndroid result1 = new ExternalReportReferenceAndroid(value);
        ExternalReportReferenceAndroid result2 = ExternalReportReferenceAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
