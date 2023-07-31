package org.im97mori.ble.descriptor.u2903;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/** @noinspection DataFlowIssue*/
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ServerCharacteristicConfigurationAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        ServerCharacteristicConfigurationAndroid result = new ServerCharacteristicConfigurationAndroid(value);
        assertEquals(0x0201, result.getProperties());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = (byte) ServerCharacteristicConfigurationAndroid.PROPERTIES_BROADCASTS_DISABLED;
        value[ 1] = (byte) ServerCharacteristicConfigurationAndroid.PROPERTIES_BROADCASTS_DISABLED >> 8;
        //@formatter:on

        ServerCharacteristicConfigurationAndroid result = new ServerCharacteristicConfigurationAndroid(value);
        assertTrue(result.isPropertiesBroadcastsDisabled());
        assertFalse(result.isPropertiesBroadcastsEnabled());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = (byte) ServerCharacteristicConfigurationAndroid.PROPERTIES_BROADCASTS_ENABLED;
        value[ 1] = (byte) ServerCharacteristicConfigurationAndroid.PROPERTIES_BROADCASTS_ENABLED >> 8;
        //@formatter:on

        ServerCharacteristicConfigurationAndroid result = new ServerCharacteristicConfigurationAndroid(value);
        assertFalse(result.isPropertiesBroadcastsDisabled());
        assertTrue(result.isPropertiesBroadcastsEnabled());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        ServerCharacteristicConfigurationAndroid result1 = new ServerCharacteristicConfigurationAndroid(value);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServerCharacteristicConfigurationAndroid result2 = ServerCharacteristicConfigurationAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getProperties(), result2.getProperties());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        ServerCharacteristicConfigurationAndroid result1 = new ServerCharacteristicConfigurationAndroid(value);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        ServerCharacteristicConfigurationAndroid result1 = new ServerCharacteristicConfigurationAndroid(value);
        ServerCharacteristicConfigurationAndroid result2 = ServerCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
