package org.im97mori.ble.characteristic.u2b2e;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

@SuppressWarnings({"unused", "UnnecessaryLocalVariable"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class EmergencyTextAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = "0".getBytes();
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = "01234567890123456789".getBytes();
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = "012345678901234567890".getBytes();
        data_00003 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        EmergencyTextAndroid result1 = new EmergencyTextAndroid(data);
        assertEquals("0", result1.getEmergencyText());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        EmergencyTextAndroid result1 = new EmergencyTextAndroid(data);
        assertEquals("01234567890123456789", result1.getEmergencyText());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        EmergencyTextAndroid result1 = new EmergencyTextAndroid(data);
        assertEquals("01234567890123456789", result1.getEmergencyText());
    }

    @Test
    public void test_constructor_00101() {
        String emergencyText = "0";

        EmergencyTextAndroid result1 = new EmergencyTextAndroid(emergencyText);
        assertEquals(emergencyText, result1.getEmergencyText());
    }

    @Test
    public void test_constructor_00102() {
        String emergencyText = "01234567890123456789";

        EmergencyTextAndroid result1 = new EmergencyTextAndroid(emergencyText);
        assertEquals(emergencyText, result1.getEmergencyText());
    }

    @Test
    public void test_constructor_00103() {
        String emergencyText = "012345678901234567890";

        EmergencyTextAndroid result1 = new EmergencyTextAndroid(emergencyText);
        assertEquals("01234567890123456789", result1.getEmergencyText());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        EmergencyTextAndroid result1 = new EmergencyTextAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EmergencyTextAndroid result2 = EmergencyTextAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getEmergencyText(), result2.getEmergencyText());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        EmergencyTextAndroid result1 = new EmergencyTextAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EmergencyTextAndroid result2 = EmergencyTextAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getEmergencyText(), result2.getEmergencyText());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        EmergencyTextAndroid result1 = new EmergencyTextAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EmergencyTextAndroid result2 = EmergencyTextAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getEmergencyText(), result2.getEmergencyText());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        EmergencyTextAndroid result1 = new EmergencyTextAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        EmergencyTextAndroid result1 = new EmergencyTextAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        EmergencyTextAndroid result1 = new EmergencyTextAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 0, EmergencyTextAndroid.MAX_OCTETS), result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        EmergencyTextAndroid result1 = new EmergencyTextAndroid(data);
        EmergencyTextAndroid result2 = EmergencyTextAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        EmergencyTextAndroid result1 = new EmergencyTextAndroid(data);
        EmergencyTextAndroid result2 = EmergencyTextAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        EmergencyTextAndroid result1 = new EmergencyTextAndroid(data);
        EmergencyTextAndroid result2 = EmergencyTextAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
