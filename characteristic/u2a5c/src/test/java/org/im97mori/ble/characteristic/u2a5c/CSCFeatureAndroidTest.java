package org.im97mori.ble.characteristic.u2a5c;

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

@SuppressWarnings({"unused", "ConstantConditions"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class CSCFeatureAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[2];
        int flag = CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE
        | CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        int flag = CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE
                | CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[2];
        int flag = CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[2];
        int flag = CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE
                | CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[2];
        int flag = CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[2];
        int flag = CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data_00202 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        assertArrayEquals(data, result1.getCscFeature());
        assertTrue(result1.isCscFeatureWheelRevolutionDataNotSupported());
        assertFalse(result1.isCscFeatureWheelRevolutionDataSupported());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        assertArrayEquals(data, result1.getCscFeature());
        assertFalse(result1.isCscFeatureWheelRevolutionDataNotSupported());
        assertTrue(result1.isCscFeatureWheelRevolutionDataSupported());
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        assertArrayEquals(data, result1.getCscFeature());
        assertTrue(result1.isCscFeatureCrankRevolutionDataSupportedNotSupported());
        assertFalse(result1.isCscFeatureCrankRevolutionDataSupportedSupported());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        assertArrayEquals(data, result1.getCscFeature());
        assertFalse(result1.isCscFeatureCrankRevolutionDataSupportedNotSupported());
        assertTrue(result1.isCscFeatureCrankRevolutionDataSupportedSupported());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        assertArrayEquals(data, result1.getCscFeature());
        assertTrue(result1.isCscFeatureMultipleSensorLocationsSupportedNotSupported());
        assertFalse(result1.isCscFeatureMultipleSensorLocationsSupportedSupported());
    }

    @Test
    public void test_constructor_00202() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        assertArrayEquals(data, result1.getCscFeature());
        assertFalse(result1.isCscFeatureMultipleSensorLocationsSupportedNotSupported());
        assertTrue(result1.isCscFeatureMultipleSensorLocationsSupportedSupported());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CSCFeatureAndroid result2 = CSCFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCscFeature(), result2.getCscFeature());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CSCFeatureAndroid result2 = CSCFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCscFeature(), result2.getCscFeature());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        assertArrayEquals(data, result1.getCscFeature());
        assertTrue(result1.isCscFeatureCrankRevolutionDataSupportedNotSupported());
        assertFalse(result1.isCscFeatureCrankRevolutionDataSupportedSupported());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CSCFeatureAndroid result2 = CSCFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCscFeature(), result2.getCscFeature());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CSCFeatureAndroid result2 = CSCFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCscFeature(), result2.getCscFeature());
    }

    @Test
    public void test_parcelable_1_00202() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CSCFeatureAndroid result2 = CSCFeatureAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCscFeature(), result2.getCscFeature());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        CSCFeatureAndroid result2 = CSCFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        CSCFeatureAndroid result2 = CSCFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        CSCFeatureAndroid result2 = CSCFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        CSCFeatureAndroid result2 = CSCFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        CSCFeatureAndroid result2 = CSCFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        CSCFeatureAndroid result1 = new CSCFeatureAndroid(data);
        CSCFeatureAndroid result2 = CSCFeatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
