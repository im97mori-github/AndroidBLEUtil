package org.im97mori.ble.characteristic.u2ab8;

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

/** @noinspection DataFlowIssue*/
@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class HTTPStatusCodeAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        int flag = HTTPStatusCode.DATA_STATUS_HEADERS_RECEIVED_FALSE
                | HTTPStatusCode.DATA_STATUS_HEADERS_TRUNCATED_FALSE
                | HTTPStatusCode.DATA_STATUS_BODY_RECEIVED_FALSE
                | HTTPStatusCode.DATA_STATUS_BODY_TRUNCATED_FALSE;
        byte[] data = new byte[3];
        data[ 0] = (byte) 200;
        data[ 1] = (byte) (200 >> 8);
        data[ 2] = (byte) flag;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        int flag = HTTPStatusCode.DATA_STATUS_HEADERS_RECEIVED_TRUE
                | HTTPStatusCode.DATA_STATUS_HEADERS_TRUNCATED_FALSE
                | HTTPStatusCode.DATA_STATUS_BODY_RECEIVED_FALSE
                | HTTPStatusCode.DATA_STATUS_BODY_TRUNCATED_FALSE;
        byte[] data = new byte[3];
        data[ 0] = (byte) 200;
        data[ 1] = (byte) (200 >> 8);
        data[ 2] = (byte) flag;
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        int flag = HTTPStatusCode.DATA_STATUS_HEADERS_RECEIVED_FALSE
                | HTTPStatusCode.DATA_STATUS_HEADERS_TRUNCATED_FALSE
                | HTTPStatusCode.DATA_STATUS_BODY_RECEIVED_FALSE
                | HTTPStatusCode.DATA_STATUS_BODY_TRUNCATED_FALSE;
        byte[] data = new byte[3];
        data[ 0] = (byte) 200;
        data[ 1] = (byte) (200 >> 8);
        data[ 2] = (byte) flag;
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        int flag = HTTPStatusCode.DATA_STATUS_HEADERS_RECEIVED_FALSE
                | HTTPStatusCode.DATA_STATUS_HEADERS_TRUNCATED_TRUE
                | HTTPStatusCode.DATA_STATUS_BODY_RECEIVED_FALSE
                | HTTPStatusCode.DATA_STATUS_BODY_TRUNCATED_FALSE;
        byte[] data = new byte[3];
        data[ 0] = (byte) 200;
        data[ 1] = (byte) (200 >> 8);
        data[ 2] = (byte) flag;
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        int flag = HTTPStatusCode.DATA_STATUS_HEADERS_RECEIVED_FALSE
                | HTTPStatusCode.DATA_STATUS_HEADERS_TRUNCATED_FALSE
                | HTTPStatusCode.DATA_STATUS_BODY_RECEIVED_FALSE
                | HTTPStatusCode.DATA_STATUS_BODY_TRUNCATED_FALSE;
        byte[] data = new byte[3];
        data[ 0] = (byte) 200;
        data[ 1] = (byte) (200 >> 8);
        data[ 2] = (byte) flag;
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        int flag = HTTPStatusCode.DATA_STATUS_HEADERS_RECEIVED_FALSE
                | HTTPStatusCode.DATA_STATUS_HEADERS_TRUNCATED_FALSE
                | HTTPStatusCode.DATA_STATUS_BODY_RECEIVED_TRUE
                | HTTPStatusCode.DATA_STATUS_BODY_TRUNCATED_FALSE;
        byte[] data = new byte[3];
        data[ 0] = (byte) 200;
        data[ 1] = (byte) (200 >> 8);
        data[ 2] = (byte) flag;
        data_00202 = data;
    }

    private static final byte[] data_00301;
    static {
        int flag = HTTPStatusCode.DATA_STATUS_HEADERS_RECEIVED_FALSE
                | HTTPStatusCode.DATA_STATUS_HEADERS_TRUNCATED_FALSE
                | HTTPStatusCode.DATA_STATUS_BODY_RECEIVED_FALSE
                | HTTPStatusCode.DATA_STATUS_BODY_TRUNCATED_FALSE;
        byte[] data = new byte[3];
        data[ 0] = (byte) 200;
        data[ 1] = (byte) (200 >> 8);
        data[ 2] = (byte) flag;
        data_00301 = data;
    }

    private static final byte[] data_00302;
    static {
        int flag = HTTPStatusCode.DATA_STATUS_HEADERS_RECEIVED_FALSE
                | HTTPStatusCode.DATA_STATUS_HEADERS_TRUNCATED_FALSE
                | HTTPStatusCode.DATA_STATUS_BODY_RECEIVED_FALSE
                | HTTPStatusCode.DATA_STATUS_BODY_TRUNCATED_TRUE;
        byte[] data = new byte[3];
        data[ 0] = (byte) 200;
        data[ 1] = (byte) (200 >> 8);
        data[ 2] = (byte) flag;
        data_00302 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        assertEquals(200, result1.getStatusCode());
        assertTrue(result1.isDataStatusHeadersNotReceived());
        assertFalse(result1.isDataStatusHeadersReceived());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        assertEquals(200, result1.getStatusCode());
        assertFalse(result1.isDataStatusHeadersNotReceived());
        assertTrue(result1.isDataStatusHeadersReceived());
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        assertEquals(200, result1.getStatusCode());
        assertTrue(result1.isDataStatusHeadersNotTruncated());
        assertFalse(result1.isDataStatusHeadersTruncated());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        assertEquals(200, result1.getStatusCode());
        assertFalse(result1.isDataStatusHeadersNotTruncated());
        assertTrue(result1.isDataStatusHeadersTruncated());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        assertEquals(200, result1.getStatusCode());
        assertTrue(result1.isDataStatusBodysNotReceived());
        assertFalse(result1.isDataStatusBodysReceived());
    }

    @Test
    public void test_constructor_00202() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        assertEquals(200, result1.getStatusCode());
        assertFalse(result1.isDataStatusBodysNotReceived());
        assertTrue(result1.isDataStatusBodysReceived());
    }

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        assertEquals(200, result1.getStatusCode());
        assertTrue(result1.isDataStatusBodysNotTruncated());
        assertFalse(result1.isDataStatusBodysTruncated());
    }

    @Test
    public void test_constructor_00302() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        assertEquals(200, result1.getStatusCode());
        assertFalse(result1.isDataStatusBodysNotTruncated());
        assertTrue(result1.isDataStatusBodysTruncated());
    }

    @Test
    public void test_constructor_00303() {
        int statusCode = 1;
        int dataStatus = 2;

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(statusCode, dataStatus);
        assertEquals(statusCode, result1.getStatusCode());
        assertEquals(dataStatus, result1.getDataStatus());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPStatusCodeAndroid result2 = HTTPStatusCodeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getStatusCode(), result2.getStatusCode());
        assertEquals(result1.getDataStatus(), result2.getDataStatus());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPStatusCodeAndroid result2 = HTTPStatusCodeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getStatusCode(), result2.getStatusCode());
        assertEquals(result1.getDataStatus(), result2.getDataStatus());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPStatusCodeAndroid result2 = HTTPStatusCodeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getStatusCode(), result2.getStatusCode());
        assertEquals(result1.getDataStatus(), result2.getDataStatus());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPStatusCodeAndroid result2 = HTTPStatusCodeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getStatusCode(), result2.getStatusCode());
        assertEquals(result1.getDataStatus(), result2.getDataStatus());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPStatusCodeAndroid result2 = HTTPStatusCodeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getStatusCode(), result2.getStatusCode());
        assertEquals(result1.getDataStatus(), result2.getDataStatus());
    }

    @Test
    public void test_parcelable_1_00202() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPStatusCodeAndroid result2 = HTTPStatusCodeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getStatusCode(), result2.getStatusCode());
        assertEquals(result1.getDataStatus(), result2.getDataStatus());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPStatusCodeAndroid result2 = HTTPStatusCodeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getStatusCode(), result2.getStatusCode());
        assertEquals(result1.getDataStatus(), result2.getDataStatus());
    }

    @Test
    public void test_parcelable_1_00302() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPStatusCodeAndroid result2 = HTTPStatusCodeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getStatusCode(), result2.getStatusCode());
        assertEquals(result1.getDataStatus(), result2.getDataStatus());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00302() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        HTTPStatusCodeAndroid result2 = HTTPStatusCodeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        HTTPStatusCodeAndroid result2 = HTTPStatusCodeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        HTTPStatusCodeAndroid result2 = HTTPStatusCodeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        HTTPStatusCodeAndroid result2 = HTTPStatusCodeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        HTTPStatusCodeAndroid result2 = HTTPStatusCodeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        HTTPStatusCodeAndroid result2 = HTTPStatusCodeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        HTTPStatusCodeAndroid result2 = HTTPStatusCodeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00302() {
        byte[] data = getData();

        HTTPStatusCodeAndroid result1 = new HTTPStatusCodeAndroid(data);
        HTTPStatusCodeAndroid result2 = HTTPStatusCodeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }


}
