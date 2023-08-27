package org.im97mori.ble.characteristic.u2a13;

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
public class TimeSourceAndroidTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        //noinspection DataFlowIssue
        data[ 0] = (byte) TimeSource.TIME_SOURCE_UNKNOWN;
        //@formatter:on

        TimeSourceAndroid result1 = new TimeSourceAndroid(data);
        assertEquals(TimeSource.TIME_SOURCE_UNKNOWN, result1.getTimeSource());
        assertTrue(result1.isTimeSourceUnknown());
        assertFalse(result1.isTimeSourceNetworkTimeProtocol());
        assertFalse(result1.isTimeSourceNetworkGps());
        assertFalse(result1.isTimeSourceRadioTimeSignal());
        assertFalse(result1.isTimeSourceManual());
        assertFalse(result1.isTimeSourceAtomicClock());
        assertFalse(result1.isTimeSourceCellularNetwork());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSource.TIME_SOURCE_NETWORK_TIME_PROTOCOL;
        //@formatter:on

        TimeSourceAndroid result1 = new TimeSourceAndroid(data);
        assertEquals(TimeSource.TIME_SOURCE_NETWORK_TIME_PROTOCOL, result1.getTimeSource());
        assertFalse(result1.isTimeSourceUnknown());
        assertTrue(result1.isTimeSourceNetworkTimeProtocol());
        assertFalse(result1.isTimeSourceNetworkGps());
        assertFalse(result1.isTimeSourceRadioTimeSignal());
        assertFalse(result1.isTimeSourceManual());
        assertFalse(result1.isTimeSourceAtomicClock());
        assertFalse(result1.isTimeSourceCellularNetwork());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSource.TIME_SOURCE_GPS;
        //@formatter:on

        TimeSourceAndroid result1 = new TimeSourceAndroid(data);
        assertEquals(TimeSource.TIME_SOURCE_GPS, result1.getTimeSource());
        assertFalse(result1.isTimeSourceUnknown());
        assertFalse(result1.isTimeSourceNetworkTimeProtocol());
        assertTrue(result1.isTimeSourceNetworkGps());
        assertFalse(result1.isTimeSourceRadioTimeSignal());
        assertFalse(result1.isTimeSourceManual());
        assertFalse(result1.isTimeSourceAtomicClock());
        assertFalse(result1.isTimeSourceCellularNetwork());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSource.TIME_SOURCE_RADIO_TIME_SIGNAL;
        //@formatter:on

        TimeSourceAndroid result1 = new TimeSourceAndroid(data);
        assertEquals(TimeSource.TIME_SOURCE_RADIO_TIME_SIGNAL, result1.getTimeSource());
        assertFalse(result1.isTimeSourceUnknown());
        assertFalse(result1.isTimeSourceNetworkTimeProtocol());
        assertFalse(result1.isTimeSourceNetworkGps());
        assertTrue(result1.isTimeSourceRadioTimeSignal());
        assertFalse(result1.isTimeSourceManual());
        assertFalse(result1.isTimeSourceAtomicClock());
        assertFalse(result1.isTimeSourceCellularNetwork());
    }

    @Test
    public void test_constructor_00005() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSource.TIME_SOURCE_MANUAL;
        //@formatter:on

        TimeSourceAndroid result1 = new TimeSourceAndroid(data);
        assertEquals(TimeSource.TIME_SOURCE_MANUAL, result1.getTimeSource());
        assertFalse(result1.isTimeSourceUnknown());
        assertFalse(result1.isTimeSourceNetworkTimeProtocol());
        assertFalse(result1.isTimeSourceNetworkGps());
        assertFalse(result1.isTimeSourceRadioTimeSignal());
        assertTrue(result1.isTimeSourceManual());
        assertFalse(result1.isTimeSourceAtomicClock());
        assertFalse(result1.isTimeSourceCellularNetwork());
    }

    @Test
    public void test_constructor_00006() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSource.TIME_SOURCE_ATOMIC_CLOCK;
        //@formatter:on

        TimeSourceAndroid result1 = new TimeSourceAndroid(data);
        assertEquals(TimeSource.TIME_SOURCE_ATOMIC_CLOCK, result1.getTimeSource());
        assertFalse(result1.isTimeSourceUnknown());
        assertFalse(result1.isTimeSourceNetworkTimeProtocol());
        assertFalse(result1.isTimeSourceNetworkGps());
        assertFalse(result1.isTimeSourceRadioTimeSignal());
        assertFalse(result1.isTimeSourceManual());
        assertTrue(result1.isTimeSourceAtomicClock());
        assertFalse(result1.isTimeSourceCellularNetwork());
    }

    @Test
    public void test_constructor_00007() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSource.TIME_SOURCE_CELLULAR_NETWORK;
        //@formatter:on

        TimeSourceAndroid result1 = new TimeSourceAndroid(data);
        assertEquals(TimeSource.TIME_SOURCE_CELLULAR_NETWORK, result1.getTimeSource());
        assertFalse(result1.isTimeSourceUnknown());
        assertFalse(result1.isTimeSourceNetworkTimeProtocol());
        assertFalse(result1.isTimeSourceNetworkGps());
        assertFalse(result1.isTimeSourceRadioTimeSignal());
        assertFalse(result1.isTimeSourceManual());
        assertFalse(result1.isTimeSourceAtomicClock());
        assertTrue(result1.isTimeSourceCellularNetwork());
    }

    @Test
    public void test_constructor_00101() {
        int timeZone = 1;

        TimeSourceAndroid result1 = new TimeSourceAndroid(timeZone);
        assertEquals(timeZone, result1.getTimeSource());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        TimeSourceAndroid result1 = new TimeSourceAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeSourceAndroid result2 = TimeSourceAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeSource(), result1.getTimeSource());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        TimeSourceAndroid result1 = new TimeSourceAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        TimeSourceAndroid result1 = new TimeSourceAndroid(data);
        TimeSourceAndroid result2 = TimeSourceAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
