package org.im97mori.ble.descriptor.u2900;

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
public class CharacteristicExtendedPropertiesAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[2];
        int flags = CharacteristicExtendedPropertiesAndroid.PROPERTIES_RELIABLE_WRITE_DISABLED;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        int flags = CharacteristicExtendedPropertiesAndroid.PROPERTIES_RELIABLE_WRITE_ENABLED;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[2];
        int flags = CharacteristicExtendedPropertiesAndroid.PROPERTIES_WRITABLE_AUXILIARIES_DISABLED;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[2];
        int flags = CharacteristicExtendedPropertiesAndroid.PROPERTIES_WRITABLE_AUXILIARIES_ENABLED;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00004 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        CharacteristicExtendedPropertiesAndroid result = new CharacteristicExtendedPropertiesAndroid(data);
        assertArrayEquals(data, result.getProperties());
        assertTrue(result.isPropertiesReliableWriteDisabled());
        assertFalse(result.isPropertiesReliableWriteEnabled());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        CharacteristicExtendedPropertiesAndroid result = new CharacteristicExtendedPropertiesAndroid(data);
        assertArrayEquals(data, result.getProperties());
        assertFalse(result.isPropertiesReliableWriteDisabled());
        assertTrue(result.isPropertiesReliableWriteEnabled());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        CharacteristicExtendedPropertiesAndroid result = new CharacteristicExtendedPropertiesAndroid(data);
        assertArrayEquals(data, result.getProperties());
        assertTrue(result.isPropertiesWritableAuxiliariesDisabled());
        assertFalse(result.isPropertiesWritableAuxiliariesEnabled());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        CharacteristicExtendedPropertiesAndroid result = new CharacteristicExtendedPropertiesAndroid(data);
        assertArrayEquals(data, result.getProperties());
        assertFalse(result.isPropertiesWritableAuxiliariesDisabled());
        assertTrue(result.isPropertiesWritableAuxiliariesEnabled());
    }

    @Test
    public void test_constructor_00101() {
        int flag = CharacteristicExtendedProperties.PROPERTIES_RELIABLE_WRITE_DISABLED | CharacteristicExtendedProperties.PROPERTIES_WRITABLE_AUXILIARIES_DISABLED;
        byte[] data = new byte[] { (byte) flag, (byte) (flag >> 8) };

        CharacteristicExtendedPropertiesAndroid result = new CharacteristicExtendedPropertiesAndroid(false, false);
        assertArrayEquals(data, result.getProperties());
        assertTrue(result.isPropertiesReliableWriteDisabled());
        assertFalse(result.isPropertiesReliableWriteEnabled());
        assertTrue(result.isPropertiesWritableAuxiliariesDisabled());
        assertFalse(result.isPropertiesWritableAuxiliariesEnabled());
    }

    @Test
    public void test_constructor_00102() {
        int flag = CharacteristicExtendedProperties.PROPERTIES_RELIABLE_WRITE_ENABLED | CharacteristicExtendedProperties.PROPERTIES_WRITABLE_AUXILIARIES_DISABLED;
        byte[] data = new byte[] { (byte) flag, (byte) (flag >> 8) };

        CharacteristicExtendedPropertiesAndroid result = new CharacteristicExtendedPropertiesAndroid(true, false);
        assertArrayEquals(data, result.getProperties());
        assertFalse(result.isPropertiesReliableWriteDisabled());
        assertTrue(result.isPropertiesReliableWriteEnabled());
        assertTrue(result.isPropertiesWritableAuxiliariesDisabled());
        assertFalse(result.isPropertiesWritableAuxiliariesEnabled());
    }

    @Test
    public void test_constructor_00103() {
        int flag = CharacteristicExtendedProperties.PROPERTIES_RELIABLE_WRITE_DISABLED | CharacteristicExtendedProperties.PROPERTIES_WRITABLE_AUXILIARIES_ENABLED;
        byte[] data = new byte[] { (byte) flag, (byte) (flag >> 8) };

        CharacteristicExtendedPropertiesAndroid result = new CharacteristicExtendedPropertiesAndroid(false, true);
        assertArrayEquals(data, result.getProperties());
        assertTrue(result.isPropertiesReliableWriteDisabled());
        assertFalse(result.isPropertiesReliableWriteEnabled());
        assertFalse(result.isPropertiesWritableAuxiliariesDisabled());
        assertTrue(result.isPropertiesWritableAuxiliariesEnabled());
    }

    @Test
    public void test_constructor_00104() {
        int flag = CharacteristicExtendedProperties.PROPERTIES_RELIABLE_WRITE_ENABLED | CharacteristicExtendedProperties.PROPERTIES_WRITABLE_AUXILIARIES_ENABLED;
        byte[] data = new byte[] { (byte) flag, (byte) (flag >> 8) };

        CharacteristicExtendedPropertiesAndroid result = new CharacteristicExtendedPropertiesAndroid(true, true);
        assertArrayEquals(data, result.getProperties());
        assertFalse(result.isPropertiesReliableWriteDisabled());
        assertTrue(result.isPropertiesReliableWriteEnabled());
        assertFalse(result.isPropertiesWritableAuxiliariesDisabled());
        assertTrue(result.isPropertiesWritableAuxiliariesEnabled());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        CharacteristicExtendedPropertiesAndroid result1 = new CharacteristicExtendedPropertiesAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CharacteristicExtendedPropertiesAndroid result2 = CharacteristicExtendedPropertiesAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getProperties(), result2.getProperties());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        CharacteristicExtendedPropertiesAndroid result1 = new CharacteristicExtendedPropertiesAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CharacteristicExtendedPropertiesAndroid result2 = CharacteristicExtendedPropertiesAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getProperties(), result2.getProperties());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        CharacteristicExtendedPropertiesAndroid result1 = new CharacteristicExtendedPropertiesAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CharacteristicExtendedPropertiesAndroid result2 = CharacteristicExtendedPropertiesAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getProperties(), result2.getProperties());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        CharacteristicExtendedPropertiesAndroid result1 = new CharacteristicExtendedPropertiesAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CharacteristicExtendedPropertiesAndroid result2 = CharacteristicExtendedPropertiesAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getProperties(), result2.getProperties());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        CharacteristicExtendedPropertiesAndroid result1 = new CharacteristicExtendedPropertiesAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        CharacteristicExtendedPropertiesAndroid result1 = new CharacteristicExtendedPropertiesAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        CharacteristicExtendedPropertiesAndroid result1 = new CharacteristicExtendedPropertiesAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        CharacteristicExtendedPropertiesAndroid result1 = new CharacteristicExtendedPropertiesAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        CharacteristicExtendedPropertiesAndroid result1 = new CharacteristicExtendedPropertiesAndroid(data);
        CharacteristicExtendedPropertiesAndroid result2 = CharacteristicExtendedPropertiesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        CharacteristicExtendedPropertiesAndroid result1 = new CharacteristicExtendedPropertiesAndroid(data);
        CharacteristicExtendedPropertiesAndroid result2 = CharacteristicExtendedPropertiesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        CharacteristicExtendedPropertiesAndroid result1 = new CharacteristicExtendedPropertiesAndroid(data);
        CharacteristicExtendedPropertiesAndroid result2 = CharacteristicExtendedPropertiesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        CharacteristicExtendedPropertiesAndroid result1 = new CharacteristicExtendedPropertiesAndroid(data);
        CharacteristicExtendedPropertiesAndroid result2 = CharacteristicExtendedPropertiesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
