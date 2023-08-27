package org.im97mori.ble.characteristic.u2b29;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ClientSupportedFeaturesAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET + 1];
        data[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET] = ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_BIT;
        //@formatter:on

        ClientSupportedFeaturesAndroid result1 = new ClientSupportedFeaturesAndroid(data);
        assertArrayEquals(data, result1.getClientFeatures());
        assertTrue(result1.isClientFeatresRobustCachingSuppreted());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET + 1];
        data[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET] = (byte) 0xff;
        //@formatter:on

        ClientSupportedFeaturesAndroid result1 = new ClientSupportedFeaturesAndroid(data);
        assertArrayEquals(data, result1.getClientFeatures());
        assertTrue(result1.isClientFeatresRobustCachingSuppreted());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET + 1];
        data[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET] = ~ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_BIT;
        //@formatter:on

        ClientSupportedFeaturesAndroid result1 = new ClientSupportedFeaturesAndroid(data);
        assertArrayEquals(data, result1.getClientFeatures());
        assertFalse(result1.isClientFeatresRobustCachingSuppreted());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET + 2];
        data[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET] = ~ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_BIT;
        data[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET + 1] = ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_BIT;
        //@formatter:on

        ClientSupportedFeaturesAndroid result1 = new ClientSupportedFeaturesAndroid(data);
        assertArrayEquals(data, result1.getClientFeatures());
        assertFalse(result1.isClientFeatresRobustCachingSuppreted());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET + 1];
        data[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET] = ~ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_BIT;
        //@formatter:on

        ClientSupportedFeaturesAndroid result1 = new ClientSupportedFeaturesAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ClientSupportedFeaturesAndroid result2 = ClientSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result2.getClientFeatures(), result1.getClientFeatures());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET + 1];
        data[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET] = ~ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_BIT;
        //@formatter:on

        ClientSupportedFeaturesAndroid result1 = new ClientSupportedFeaturesAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        byte[] data = new byte[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET + 1];
        data[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET] = ~ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_BIT;

        ClientSupportedFeaturesAndroid result1 = new ClientSupportedFeaturesAndroid(data);
        ClientSupportedFeaturesAndroid result2 = ClientSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
