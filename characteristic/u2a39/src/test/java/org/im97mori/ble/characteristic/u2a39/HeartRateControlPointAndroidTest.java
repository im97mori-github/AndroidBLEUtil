package org.im97mori.ble.characteristic.u2a39;

import android.os.Build;
import android.os.Parcel;

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
public class HeartRateControlPointAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //noinspection DataFlowIssue
        data[ 0] = 0;
        //@formatter:on

        HeartRateControlPointAndroid result1 = new HeartRateControlPointAndroid(data);
        assertEquals(0, result1.getHeartRateControlPoint());
        assertFalse(result1.isHeartRateControlPointResetEnergyExpended());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED;
        //@formatter:on

        HeartRateControlPointAndroid result1 = new HeartRateControlPointAndroid(data);
        assertEquals(HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED, result1.getHeartRateControlPoint());
        assertTrue(result1.isHeartRateControlPointResetEnergyExpended());
    }

    @Test
    public void test_constructor003() {
        int heartRateControlPoint = 1;

        HeartRateControlPointAndroid result1 = new HeartRateControlPointAndroid(heartRateControlPoint);
        assertEquals(heartRateControlPoint, result1.getHeartRateControlPoint());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED;
        //@formatter:on

        HeartRateControlPointAndroid result1 = new HeartRateControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeartRateControlPointAndroid result2 = HeartRateControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getHeartRateControlPoint(), result2.getHeartRateControlPoint());
    }


    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED;
        //@formatter:on

        HeartRateControlPointAndroid result1 = new HeartRateControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED;
        //@formatter:on

        HeartRateControlPointAndroid result1 = new HeartRateControlPointAndroid(data);
        HeartRateControlPointAndroid result2 = HeartRateControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
