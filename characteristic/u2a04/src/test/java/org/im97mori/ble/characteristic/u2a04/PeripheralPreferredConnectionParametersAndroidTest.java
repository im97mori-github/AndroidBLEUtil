package org.im97mori.ble.characteristic.u2a04;

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
@SuppressWarnings("PointlessBitwiseExpression")
public class PeripheralPreferredConnectionParametersAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) (0x10 & 0xff);
        data[ 1] = (byte) (0x00 & 0xff);
        data[ 2] = (byte) (0x20 & 0xff);
        data[ 3] = (byte) (0x00 & 0xff);
        data[ 4] = (byte) (0x04 & 0xff);
        data[ 5] = (byte) (0x00 & 0xff);
        data[ 6] = (byte) (0x90 & 0xff);
        data[ 7] = (byte) (0x01 & 0xff);
        //@formatter:on

        PeripheralPreferredConnectionParametersAndroid result1 = new PeripheralPreferredConnectionParametersAndroid(data);
        assertEquals(0x0010, result1.getMinimumConnectionInterval());
        assertEquals(20, result1.getMinimumConnectionIntervalMillis(), 0);
        assertEquals(0x0020, result1.getMaximumConnectionInterval());
        assertEquals(40, result1.getMaximumConnectionIntervalMillis(), 0);
        assertEquals(4, result1.getLatency(), 0);
        assertEquals(0x0190, result1.getTimeout());
        assertEquals(4000, result1.getTimeoutMillis(), 0);
    }

    @Test
    public void test_constructor002() {
        int minimumConnectionInterval = 1;
        int maximumConnectionInterval = 2;
        int slaveLatency = 3;
        int connectionSupervisionTimeoutMultiplier = 4;

        PeripheralPreferredConnectionParametersAndroid result1 = new PeripheralPreferredConnectionParametersAndroid(minimumConnectionInterval, maximumConnectionInterval, slaveLatency, connectionSupervisionTimeoutMultiplier);
        assertEquals(minimumConnectionInterval, result1.getMinimumConnectionInterval());
        assertEquals(maximumConnectionInterval, result1.getMaximumConnectionInterval());
        assertEquals(slaveLatency, result1.getLatency());
        assertEquals(connectionSupervisionTimeoutMultiplier, result1.getTimeout());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) (0x10 & 0xff);
        data[ 1] = (byte) (0x00 & 0xff);
        data[ 2] = (byte) (0x20 & 0xff);
        data[ 3] = (byte) (0x00 & 0xff);
        data[ 4] = (byte) (0x04 & 0xff);
        data[ 5] = (byte) (0x00 & 0xff);
        data[ 6] = (byte) (0x90 & 0xff);
        data[ 7] = (byte) (0x01 & 0xff);
        //@formatter:on

        PeripheralPreferredConnectionParametersAndroid result1 = new PeripheralPreferredConnectionParametersAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PeripheralPreferredConnectionParametersAndroid result2 = PeripheralPreferredConnectionParametersAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getMinimumConnectionInterval(), result2.getMinimumConnectionInterval());
        assertEquals(result1.getMaximumConnectionInterval(), result2.getMaximumConnectionInterval());
        assertEquals(result1.getLatency(), result2.getLatency(), 0);
        assertEquals(result1.getTimeout(), result2.getTimeout());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) (0x10 & 0xff);
        data[ 1] = (byte) (0x00 & 0xff);
        data[ 2] = (byte) (0x20 & 0xff);
        data[ 3] = (byte) (0x00 & 0xff);
        data[ 4] = (byte) (0x04 & 0xff);
        data[ 5] = (byte) (0x00 & 0xff);
        data[ 6] = (byte) (0x90 & 0xff);
        data[ 7] = (byte) (0x01 & 0xff);
        //@formatter:on

        PeripheralPreferredConnectionParametersAndroid result1 = new PeripheralPreferredConnectionParametersAndroid(data);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(data, resultData);
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = (byte) (0x10 & 0xff);
        data[ 1] = (byte) (0x00 & 0xff);
        data[ 2] = (byte) (0x20 & 0xff);
        data[ 3] = (byte) (0x00 & 0xff);
        data[ 4] = (byte) (0x04 & 0xff);
        data[ 5] = (byte) (0x00 & 0xff);
        data[ 6] = (byte) (0x90 & 0xff);
        data[ 7] = (byte) (0x01 & 0xff);
        //@formatter:on

        PeripheralPreferredConnectionParametersAndroid result1 = new PeripheralPreferredConnectionParametersAndroid(data);
        PeripheralPreferredConnectionParametersAndroid result2 = PeripheralPreferredConnectionParametersAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
