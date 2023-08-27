package org.im97mori.ble.characteristic.u2b3a;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ServerSupportedFeaturesAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        //noinspection DataFlowIssue
        data[0] = 0;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[1];
        data[0] = 1;
        data_00002 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        ServerSupportedFeaturesAndroid result1 = new ServerSupportedFeaturesAndroid(data);
        assertEquals(1, result1.getServerSupportedFeaturesList().size());
        assertEquals(0b00000000, result1.getServerSupportedFeaturesList().get(0).intValue());
        assertFalse(result1.isEattSupported());
    }

    @Test
    public void test_constructor_1_00002() {
        byte[] data = getData();

        ServerSupportedFeaturesAndroid result1 = new ServerSupportedFeaturesAndroid(data);
        assertEquals(1, result1.getServerSupportedFeaturesList().size());
        assertEquals(0b00000001, result1.getServerSupportedFeaturesList().get(0).intValue());
        assertTrue(result1.isEattSupported());
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        List<Integer> serverSupportedFeaturesList = new ArrayList<>();
        for (byte octet : data) {
            serverSupportedFeaturesList.add(octet & 0xff);
        }
        ServerSupportedFeaturesAndroid result1 = new ServerSupportedFeaturesAndroid(serverSupportedFeaturesList);
        assertEquals(1, result1.getServerSupportedFeaturesList().size());
        assertEquals(0b00000000, result1.getServerSupportedFeaturesList().get(0).intValue());
        assertFalse(result1.isEattSupported());
    }

    @Test
    public void test_constructor_2_00002() {
        byte[] data = getData();

        List<Integer> serverSupportedFeaturesList = new ArrayList<>();
        for (byte octet : data) {
            serverSupportedFeaturesList.add(octet & 0xff);
        }
        ServerSupportedFeaturesAndroid result1 = new ServerSupportedFeaturesAndroid(serverSupportedFeaturesList);
        assertEquals(1, result1.getServerSupportedFeaturesList().size());
        assertEquals(0b00000001, result1.getServerSupportedFeaturesList().get(0).intValue());
        assertTrue(result1.isEattSupported());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ServerSupportedFeaturesAndroid result1 = new ServerSupportedFeaturesAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServerSupportedFeaturesAndroid result2 = ServerSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getServerSupportedFeaturesList(), result1.getServerSupportedFeaturesList());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        ServerSupportedFeaturesAndroid result1 = new ServerSupportedFeaturesAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServerSupportedFeaturesAndroid result2 = ServerSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getServerSupportedFeaturesList(), result1.getServerSupportedFeaturesList());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ServerSupportedFeaturesAndroid result1 = new ServerSupportedFeaturesAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        ServerSupportedFeaturesAndroid result1 = new ServerSupportedFeaturesAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ServerSupportedFeaturesAndroid result1 = new ServerSupportedFeaturesAndroid(data);
        ServerSupportedFeaturesAndroid result2 = ServerSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        ServerSupportedFeaturesAndroid result1 = new ServerSupportedFeaturesAndroid(data);
        ServerSupportedFeaturesAndroid result2 = ServerSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
