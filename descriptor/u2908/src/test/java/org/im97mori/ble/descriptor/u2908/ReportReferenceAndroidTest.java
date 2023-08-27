package org.im97mori.ble.descriptor.u2908;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

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
public class ReportReferenceAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        ReportReferenceAndroid result = new ReportReferenceAndroid(value);
        assertEquals(0x01, result.getReportId());
        assertEquals(0x02, result.getReportType());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = (byte) ReportReferenceAndroid.REPORT_TYPE_INPUT_REPORT;
        //@formatter:on

        ReportReferenceAndroid result = new ReportReferenceAndroid(value);
        assertTrue(result.isReportTypeInputReport());
        assertFalse(result.isReportTypeOutputReport());
        assertFalse(result.isReportTypeFeatureReport());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = (byte) ReportReferenceAndroid.REPORT_TYPE_OUTPUT_REPORT;
        //@formatter:on

        ReportReferenceAndroid result = new ReportReferenceAndroid(value);
        assertFalse(result.isReportTypeInputReport());
        assertTrue(result.isReportTypeOutputReport());
        assertFalse(result.isReportTypeFeatureReport());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = (byte) ReportReferenceAndroid.REPORT_TYPE_FEATURE_REPORT;
        //@formatter:on

        ReportReferenceAndroid result = new ReportReferenceAndroid(value);
        assertFalse(result.isReportTypeInputReport());
        assertFalse(result.isReportTypeOutputReport());
        assertTrue(result.isReportTypeFeatureReport());
    }

    @Test
    public void test_constructor005() {
        int reportId = 0;
        int reportType = 1;

        ReportReferenceAndroid result = new ReportReferenceAndroid(reportId, reportType);
        assertEquals(reportId, result.getReportId());
        assertEquals(reportType, result.getReportType());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        ReportReferenceAndroid result1 = new ReportReferenceAndroid(value);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ReportReferenceAndroid result2 = ReportReferenceAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getReportId(), result2.getReportId());
        assertEquals(result1.getReportType(), result2.getReportType());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        ReportReferenceAndroid result1 = new ReportReferenceAndroid(value);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        ReportReferenceAndroid result1 = new ReportReferenceAndroid(value);
        ReportReferenceAndroid result2 = ReportReferenceAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
