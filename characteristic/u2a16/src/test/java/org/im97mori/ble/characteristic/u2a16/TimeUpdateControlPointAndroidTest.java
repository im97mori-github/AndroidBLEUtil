package org.im97mori.ble.characteristic.u2a16;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class TimeUpdateControlPointAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE;
        //@formatter:on

        TimeUpdateControlPointAndroid result1 = new TimeUpdateControlPointAndroid(data);
        assertEquals(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE, result1.getTimeUpdateControlPoint());
        assertTrue(result1.isTimeUpdateControlPointGetReferenceUpdate());
        assertFalse(result1.isTimeUpdateControlPointCancelReferenceUpdate());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_CANCEL_REFERENCE_UPDATE;
        //@formatter:on

        TimeUpdateControlPointAndroid result1 = new TimeUpdateControlPointAndroid(data);
        assertEquals(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_CANCEL_REFERENCE_UPDATE, result1.getTimeUpdateControlPoint());
        assertFalse(result1.isTimeUpdateControlPointGetReferenceUpdate());
        assertTrue(result1.isTimeUpdateControlPointCancelReferenceUpdate());
    }

    @Test
    public void test_constructor003() {
        int timeUpdateControlPoint = 1;

        TimeUpdateControlPointAndroid result1 = new TimeUpdateControlPointAndroid(timeUpdateControlPoint);
        assertEquals(timeUpdateControlPoint, result1.getTimeUpdateControlPoint());
    }


    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE;
        //@formatter:on

        TimeUpdateControlPointAndroid result1 = new TimeUpdateControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeUpdateControlPointAndroid result2 = TimeUpdateControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeUpdateControlPoint(), result1.getTimeUpdateControlPoint());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_CANCEL_REFERENCE_UPDATE;
        //@formatter:on

        TimeUpdateControlPointAndroid result1 = new TimeUpdateControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeUpdateControlPointAndroid result2 = TimeUpdateControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeUpdateControlPoint(), result1.getTimeUpdateControlPoint());
    }

    @Test
    public void test_parcelable101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE;
        //@formatter:on

        TimeUpdateControlPointAndroid result1 = new TimeUpdateControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_CANCEL_REFERENCE_UPDATE;
        //@formatter:on

        TimeUpdateControlPointAndroid result1 = new TimeUpdateControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE;
        //@formatter:on

        TimeUpdateControlPointAndroid result1 = new TimeUpdateControlPointAndroid(data);
        TimeUpdateControlPointAndroid result2 = TimeUpdateControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_CANCEL_REFERENCE_UPDATE;
        //@formatter:on

        TimeUpdateControlPointAndroid result1 = new TimeUpdateControlPointAndroid(data);
        TimeUpdateControlPointAndroid result2 = TimeUpdateControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
