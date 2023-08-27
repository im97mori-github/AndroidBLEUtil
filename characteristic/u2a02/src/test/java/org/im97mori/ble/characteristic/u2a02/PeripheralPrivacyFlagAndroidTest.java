package org.im97mori.ble.characteristic.u2a02;

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
public class PeripheralPrivacyFlagAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //noinspection DataFlowIssue
        data[ 0] = (byte) (PeripheralPrivacyFlag.FLAGS_PRIVACY_IS_DISABLED_IN_THIS_DEVICE & 0xff);
        //@formatter:on

        PeripheralPrivacyFlagAndroid result1 = new PeripheralPrivacyFlagAndroid(data);
        assertEquals(PeripheralPrivacyFlag.FLAGS_PRIVACY_IS_DISABLED_IN_THIS_DEVICE, result1.getFlag());
        assertTrue(result1.isPrivacyDisabled());
        assertFalse(result1.isPrivacyEnabled());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (PeripheralPrivacyFlag.FLAGS_PRIVACY_IS_ENABLED_IN_THIS_DEVICE & 0xff);
        //@formatter:on

        PeripheralPrivacyFlagAndroid result1 = new PeripheralPrivacyFlagAndroid(data);
        assertEquals(PeripheralPrivacyFlag.FLAGS_PRIVACY_IS_ENABLED_IN_THIS_DEVICE, result1.getFlag());
        assertFalse(result1.isPrivacyDisabled());
        assertTrue(result1.isPrivacyEnabled());
    }

    @Test
    public void test_constructor003() {
        int flag = 1;

        PeripheralPrivacyFlagAndroid result1 = new PeripheralPrivacyFlagAndroid(flag);
        assertEquals(flag, result1.getFlag());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (PeripheralPrivacyFlag.FLAGS_PRIVACY_IS_ENABLED_IN_THIS_DEVICE & 0xff);
        //@formatter:on

        PeripheralPrivacyFlagAndroid result1 = new PeripheralPrivacyFlagAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PeripheralPrivacyFlagAndroid result2 = PeripheralPrivacyFlagAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getFlag(), result2.getFlag());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (PeripheralPrivacyFlag.FLAGS_PRIVACY_IS_ENABLED_IN_THIS_DEVICE & 0xff);
        //@formatter:on

        PeripheralPrivacyFlagAndroid result1 = new PeripheralPrivacyFlagAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (PeripheralPrivacyFlag.FLAGS_PRIVACY_IS_ENABLED_IN_THIS_DEVICE & 0xff);
        //@formatter:on

        PeripheralPrivacyFlagAndroid result1 = new PeripheralPrivacyFlagAndroid(data);
        PeripheralPrivacyFlagAndroid result2 = PeripheralPrivacyFlagAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
