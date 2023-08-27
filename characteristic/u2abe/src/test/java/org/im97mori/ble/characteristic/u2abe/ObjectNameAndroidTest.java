package org.im97mori.ble.characteristic.u2abe;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

@SuppressWarnings({"UnnecessaryLocalVariable", "unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ObjectNameAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = "0".getBytes();
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = "012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789".getBytes();
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890".getBytes();
        data_00003 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        ObjectNameAndroid result1 = new ObjectNameAndroid(data);
        assertEquals("0", result1.getObjectName());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        ObjectNameAndroid result1 = new ObjectNameAndroid(data);
        assertEquals(
                "012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789",
                result1.getObjectName());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        ObjectNameAndroid result1 = new ObjectNameAndroid(data);
        assertEquals(
                "012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789",
                result1.getObjectName());
    }

    @Test
    public void test_constructor_00101() {
        String objectName = "0";

        ObjectName result1 = new ObjectName(objectName);
        assertEquals(objectName, result1.getObjectName());
    }

    @Test
    public void test_constructor_00102() {
        String objectName = "012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789";

        ObjectNameAndroid result1 = new ObjectNameAndroid(objectName);
        assertEquals(objectName, result1.getObjectName());
    }

    @Test
    public void test_constructor_00103() {
        String objectName = "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";

        ObjectNameAndroid result1 = new ObjectNameAndroid(objectName);
        assertEquals(
                "012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789",
                result1.getObjectName());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ObjectNameAndroid result1 = new ObjectNameAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectNameAndroid result2 = ObjectNameAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getObjectName(), result2.getObjectName());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        ObjectNameAndroid result1 = new ObjectNameAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectNameAndroid result2 = ObjectNameAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getObjectName(), result2.getObjectName());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        ObjectNameAndroid result1 = new ObjectNameAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectNameAndroid result2 = ObjectNameAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getObjectName(), result2.getObjectName());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ObjectNameAndroid result1 = new ObjectNameAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        ObjectNameAndroid result1 = new ObjectNameAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        ObjectNameAndroid result1 = new ObjectNameAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, ObjectName.MAX_OCTETS), result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ObjectNameAndroid result1 = new ObjectNameAndroid(data);
        ObjectNameAndroid result2 = ObjectNameAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        ObjectNameAndroid result1 = new ObjectNameAndroid(data);
        ObjectNameAndroid result2 = ObjectNameAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        ObjectNameAndroid result1 = new ObjectNameAndroid(data);
        ObjectNameAndroid result2 = ObjectNameAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
