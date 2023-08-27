package org.im97mori.ble.descriptor.u2902;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressWarnings({"ConstantConditions", "unused"})
public class ClientCharacteristicConfigurationAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[2];
        int flags = ClientCharacteristicConfiguration.PROPERTIES_NOTIFICATIONS_DISABLED;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        int flags = ClientCharacteristicConfiguration.PROPERTIES_NOTIFICATIONS_ENABLED;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[2];
        int flags = ClientCharacteristicConfiguration.PROPERTIES_INDICATIONS_DISABLED;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[2];
        int flags = ClientCharacteristicConfiguration.PROPERTIES_INDICATIONS_ENABLED;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00004 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        ClientCharacteristicConfigurationAndroid result = new ClientCharacteristicConfigurationAndroid(data);
        assertArrayEquals(data, result.getProperties());
        assertTrue(result.isPropertiesNotificationsDisabled());
        assertFalse(result.isPropertiesNotificationsEnabled());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        ClientCharacteristicConfigurationAndroid result = new ClientCharacteristicConfigurationAndroid(data);
        assertArrayEquals(data, result.getProperties());
        assertFalse(result.isPropertiesNotificationsDisabled());
        assertTrue(result.isPropertiesNotificationsEnabled());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        ClientCharacteristicConfigurationAndroid result = new ClientCharacteristicConfigurationAndroid(data);
        assertArrayEquals(data, result.getProperties());
        assertTrue(result.isPropertiesIndicationsDisabled());
        assertFalse(result.isPropertiesIndicationsEnabled());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        ClientCharacteristicConfigurationAndroid result = new ClientCharacteristicConfigurationAndroid(data);
        assertArrayEquals(data, result.getProperties());
        assertFalse(result.isPropertiesIndicationsDisabled());
        assertTrue(result.isPropertiesIndicationsEnabled());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ClientCharacteristicConfigurationAndroid result2 = ClientCharacteristicConfigurationAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getProperties(), result2.getProperties());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ClientCharacteristicConfigurationAndroid result2 = ClientCharacteristicConfigurationAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getProperties(), result2.getProperties());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ClientCharacteristicConfigurationAndroid result2 = ClientCharacteristicConfigurationAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getProperties(), result2.getProperties());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ClientCharacteristicConfigurationAndroid result2 = ClientCharacteristicConfigurationAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getProperties(), result2.getProperties());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(data);
        ClientCharacteristicConfigurationAndroid result2 = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(data);
        ClientCharacteristicConfigurationAndroid result2 = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(data);
        ClientCharacteristicConfigurationAndroid result2 = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        ClientCharacteristicConfigurationAndroid result1 = new ClientCharacteristicConfigurationAndroid(data);
        ClientCharacteristicConfigurationAndroid result2 = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
