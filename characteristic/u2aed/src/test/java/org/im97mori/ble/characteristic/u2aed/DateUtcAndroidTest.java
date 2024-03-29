package org.im97mori.ble.characteristic.u2aed;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/** @noinspection DataFlowIssue*/
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class DateUtcAndroidTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) DateUtc.DATE_UTC_IS_NOT_KNOWN;
        data[ 1] = (byte) (DateUtc.DATE_UTC_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (DateUtc.DATE_UTC_IS_NOT_KNOWN >> 16);
        //@formatter:on

        DateUtcAndroid result1 = new DateUtcAndroid(data);
        assertEquals(DateUtc.DATE_UTC_IS_NOT_KNOWN, result1.getDate());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777214;
        data[ 1] = (byte) (16777214 >> 8);
        data[ 2] = (byte) (16777214 >> 16);
        //@formatter:on

        DateUtcAndroid result1 = new DateUtcAndroid(data);
        assertEquals(16777214, result1.getDate());
    }

    @Test
    public void test_constructor_00101() {
        int dateUtc = DateUtc.DATE_UTC_IS_NOT_KNOWN;

        DateUtcAndroid result1 = new DateUtcAndroid(dateUtc);
        assertEquals(dateUtc, result1.getDate());
    }

    @Test
    public void test_constructor_00102() {
        int dateUtc = 16777214;

        DateUtcAndroid result1 = new DateUtcAndroid(dateUtc);
        assertEquals(dateUtc, result1.getDate());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) DateUtc.DATE_UTC_IS_NOT_KNOWN;
        data[ 1] = (byte) (DateUtc.DATE_UTC_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (DateUtc.DATE_UTC_IS_NOT_KNOWN >> 16);
        //@formatter:on

        DateUtcAndroid result1 = new DateUtcAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DateUtcAndroid result2 = DateUtcAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getDate(), result1.getDate());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777214;
        data[ 1] = (byte) (16777214 >> 8);
        data[ 2] = (byte) (16777214 >> 16);
        //@formatter:on

        DateUtcAndroid result1 = new DateUtcAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DateUtcAndroid result2 = DateUtcAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getDate(), result1.getDate());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) DateUtc.DATE_UTC_IS_NOT_KNOWN;
        data[ 1] = (byte) (DateUtc.DATE_UTC_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (DateUtc.DATE_UTC_IS_NOT_KNOWN >> 16);
        //@formatter:on

        DateUtcAndroid result1 = new DateUtcAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777214;
        data[ 1] = (byte) (16777214 >> 8);
        data[ 2] = (byte) (16777214 >> 16);
        //@formatter:on

        DateUtcAndroid result1 = new DateUtcAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) DateUtc.DATE_UTC_IS_NOT_KNOWN;
        data[ 1] = (byte) (DateUtc.DATE_UTC_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (DateUtc.DATE_UTC_IS_NOT_KNOWN >> 16);
        //@formatter:on

        DateUtcAndroid result1 = new DateUtcAndroid(data);
        DateUtcAndroid result2 = DateUtcAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777214;
        data[ 1] = (byte) (16777214 >> 8);
        data[ 2] = (byte) (16777214 >> 16);
        //@formatter:on

        DateUtcAndroid result1 = new DateUtcAndroid(data);
        DateUtcAndroid result2 = DateUtcAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
