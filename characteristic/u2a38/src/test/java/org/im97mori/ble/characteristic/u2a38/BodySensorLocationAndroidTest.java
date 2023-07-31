package org.im97mori.ble.characteristic.u2a38;

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
public class BodySensorLocationAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //noinspection DataFlowIssue
        data[ 0] = BodySensorLocation.BODY_SENSOR_LOCATION_OTHER;
        //@formatter:on

        BodySensorLocationAndroid result1 = new BodySensorLocationAndroid(data);
        assertEquals(BodySensorLocation.BODY_SENSOR_LOCATION_OTHER, result1.getBodySensorLocation());
        assertTrue(result1.isBodySensorLocationOhter());
        assertFalse(result1.isBodySensorLocationChest());
        assertFalse(result1.isBodySensorLocationWrist());
        assertFalse(result1.isBodySensorLocationFinger());
        assertFalse(result1.isBodySensorLocationHand());
        assertFalse(result1.isBodySensorLocationEarLobe());
        assertFalse(result1.isBodySensorLocationFoot());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = BodySensorLocation.BODY_SENSOR_LOCATION_CHEST;
        //@formatter:on

        BodySensorLocationAndroid result1 = new BodySensorLocationAndroid(data);
        assertEquals(BodySensorLocation.BODY_SENSOR_LOCATION_CHEST, result1.getBodySensorLocation());
        assertFalse(result1.isBodySensorLocationOhter());
        assertTrue(result1.isBodySensorLocationChest());
        assertFalse(result1.isBodySensorLocationWrist());
        assertFalse(result1.isBodySensorLocationFinger());
        assertFalse(result1.isBodySensorLocationHand());
        assertFalse(result1.isBodySensorLocationEarLobe());
        assertFalse(result1.isBodySensorLocationFoot());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = BodySensorLocation.BODY_SENSOR_LOCATION_WRIST;
        //@formatter:on

        BodySensorLocationAndroid result1 = new BodySensorLocationAndroid(data);
        assertEquals(BodySensorLocation.BODY_SENSOR_LOCATION_WRIST, result1.getBodySensorLocation());
        assertFalse(result1.isBodySensorLocationOhter());
        assertFalse(result1.isBodySensorLocationChest());
        assertTrue(result1.isBodySensorLocationWrist());
        assertFalse(result1.isBodySensorLocationFinger());
        assertFalse(result1.isBodySensorLocationHand());
        assertFalse(result1.isBodySensorLocationEarLobe());
        assertFalse(result1.isBodySensorLocationFoot());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = BodySensorLocation.BODY_SENSOR_LOCATION_FINGER;
        //@formatter:on

        BodySensorLocationAndroid result1 = new BodySensorLocationAndroid(data);
        assertEquals(BodySensorLocation.BODY_SENSOR_LOCATION_FINGER, result1.getBodySensorLocation());
        assertFalse(result1.isBodySensorLocationOhter());
        assertFalse(result1.isBodySensorLocationChest());
        assertFalse(result1.isBodySensorLocationWrist());
        assertTrue(result1.isBodySensorLocationFinger());
        assertFalse(result1.isBodySensorLocationHand());
        assertFalse(result1.isBodySensorLocationEarLobe());
        assertFalse(result1.isBodySensorLocationFoot());
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = BodySensorLocation.BODY_SENSOR_LOCATION_HAND;
        //@formatter:on

        BodySensorLocationAndroid result1 = new BodySensorLocationAndroid(data);
        assertEquals(BodySensorLocation.BODY_SENSOR_LOCATION_HAND, result1.getBodySensorLocation());
        assertFalse(result1.isBodySensorLocationOhter());
        assertFalse(result1.isBodySensorLocationChest());
        assertFalse(result1.isBodySensorLocationWrist());
        assertFalse(result1.isBodySensorLocationFinger());
        assertTrue(result1.isBodySensorLocationHand());
        assertFalse(result1.isBodySensorLocationEarLobe());
        assertFalse(result1.isBodySensorLocationFoot());
    }

    @Test
    public void test_constructor006() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = BodySensorLocation.BODY_SENSOR_LOCATION_EAR_LOBE;
        //@formatter:on

        BodySensorLocationAndroid result1 = new BodySensorLocationAndroid(data);
        assertEquals(BodySensorLocation.BODY_SENSOR_LOCATION_EAR_LOBE, result1.getBodySensorLocation());
        assertFalse(result1.isBodySensorLocationOhter());
        assertFalse(result1.isBodySensorLocationChest());
        assertFalse(result1.isBodySensorLocationWrist());
        assertFalse(result1.isBodySensorLocationFinger());
        assertFalse(result1.isBodySensorLocationHand());
        assertTrue(result1.isBodySensorLocationEarLobe());
        assertFalse(result1.isBodySensorLocationFoot());
    }

    @Test
    public void test_constructor007() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = BodySensorLocation.BODY_SENSOR_LOCATION_FOOT;
        //@formatter:on

        BodySensorLocationAndroid result1 = new BodySensorLocationAndroid(data);
        assertEquals(BodySensorLocation.BODY_SENSOR_LOCATION_FOOT, result1.getBodySensorLocation());
        assertFalse(result1.isBodySensorLocationOhter());
        assertFalse(result1.isBodySensorLocationChest());
        assertFalse(result1.isBodySensorLocationWrist());
        assertFalse(result1.isBodySensorLocationFinger());
        assertFalse(result1.isBodySensorLocationHand());
        assertFalse(result1.isBodySensorLocationEarLobe());
        assertTrue(result1.isBodySensorLocationFoot());
    }

    @Test
    public void test_constructor008() {
        int bodySensorLocation = 1;

        BodySensorLocationAndroid result1 = new BodySensorLocationAndroid(bodySensorLocation);
        assertEquals(bodySensorLocation, result1.getBodySensorLocation());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = BodySensorLocation.BODY_SENSOR_LOCATION_CHEST;
        //@formatter:on

        BodySensorLocationAndroid result1 = new BodySensorLocationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodySensorLocationAndroid result2 = BodySensorLocationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getBodySensorLocation(), result2.getBodySensorLocation());
    }


    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = BodySensorLocation.BODY_SENSOR_LOCATION_CHEST;
        //@formatter:on

        BodySensorLocationAndroid result1 = new BodySensorLocationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = BodySensorLocation.BODY_SENSOR_LOCATION_CHEST;
        //@formatter:on

        BodySensorLocationAndroid result1 = new BodySensorLocationAndroid(data);
        BodySensorLocationAndroid result2 = BodySensorLocationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
