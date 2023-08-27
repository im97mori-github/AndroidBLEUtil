package org.im97mori.ble.characteristic.u2aa6;

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
public class CentralAddressResolutionAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //noinspection DataFlowIssue
        data[ 0] = (byte) (CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_NOT_SUPPORTED & 0xff);
        //@formatter:on

        CentralAddressResolutionAndroid result1 = new CentralAddressResolutionAndroid(data);
        assertEquals(CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_NOT_SUPPORTED, result1.getCentralAddressResolutionSupport());
        assertTrue(result1.isCentralAddressResolutionNotSupported());
        assertFalse(result1.isCentralAddressResolutionSupported());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_SUPPORTED & 0xff);
        //@formatter:on

        CentralAddressResolutionAndroid result1 = new CentralAddressResolutionAndroid(data);
        assertEquals(CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_SUPPORTED, result1.getCentralAddressResolutionSupport());
        assertFalse(result1.isCentralAddressResolutionNotSupported());
        assertTrue(result1.isCentralAddressResolutionSupported());
    }

    @Test
    public void test_constructor003() {
        int centralAddressResolutionSupport = 1;

        CentralAddressResolutionAndroid result1 = new CentralAddressResolutionAndroid(centralAddressResolutionSupport);
        assertEquals(centralAddressResolutionSupport, result1.getCentralAddressResolutionSupport());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_SUPPORTED & 0xff);
        //@formatter:on

        CentralAddressResolutionAndroid result1 = new CentralAddressResolutionAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CentralAddressResolutionAndroid result2 = CentralAddressResolutionAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getCentralAddressResolutionSupport(), result2.getCentralAddressResolutionSupport());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_SUPPORTED & 0xff);
        //@formatter:on

        CentralAddressResolutionAndroid result1 = new CentralAddressResolutionAndroid(data);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(data, resultData);
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_SUPPORTED & 0xff);
        //@formatter:on

        CentralAddressResolutionAndroid result1 = new CentralAddressResolutionAndroid(data);
        CentralAddressResolutionAndroid result2 = CentralAddressResolutionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
