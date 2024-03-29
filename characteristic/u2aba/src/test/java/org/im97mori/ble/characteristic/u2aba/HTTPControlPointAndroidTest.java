package org.im97mori.ble.characteristic.u2aba;

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

@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class HTTPControlPointAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = HTTPControlPoint.OP_CODE_HTTP_GET_REQUEST;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[1];
        data[ 0] = HTTPControlPoint.OP_CODE_HTTP_HEAD_REQUEST;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[1];
        data[ 0] = HTTPControlPoint.OP_CODE_HTTP_POST_REQUEST;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[1];
        data[ 0] = HTTPControlPoint.OP_CODE_HTTP_PUT_REQUEST;
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        byte[] data = new byte[1];
        data[ 0] = HTTPControlPoint.OP_CODE_HTTP_DELETE_REQUEST;
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        byte[] data = new byte[1];
        data[ 0] = HTTPControlPoint.OP_CODE_HTTPS_GET_REQUEST;
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        byte[] data = new byte[1];
        data[ 0] = HTTPControlPoint.OP_CODE_HTTPS_HEAD_REQUEST;
        data_00007 = data;
    }

    private static final byte[] data_00008;
    static {
        byte[] data = new byte[1];
        data[ 0] = HTTPControlPoint.OP_CODE_HTTPS_POST_REQUEST;
        data_00008 = data;
    }

    private static final byte[] data_00009;
    static {
        byte[] data = new byte[1];
        data[ 0] = HTTPControlPoint.OP_CODE_HTTPS_PUT_REQUEST;
        data_00009 = data;
    }

    private static final byte[] data_00010;
    static {
        byte[] data = new byte[1];
        data[ 0] = HTTPControlPoint.OP_CODE_HTTPS_DELETE_REQUEST;
        data_00010 = data;
    }

    private static final byte[] data_00011;
    static {
        byte[] data = new byte[1];
        data[ 0] = HTTPControlPoint.OP_CODE_HTTP_REQUEST_CANCEL;
        data_00011 = data;
    }

    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertEquals(HTTPControlPoint.OP_CODE_HTTP_GET_REQUEST, result1.getOpCode());
        assertTrue(result1.isOpCodeHttpGetRequest());
        assertFalse(result1.isOpCodeHttpHeadRequest());
        assertFalse(result1.isOpCodeHttpPostRequest());
        assertFalse(result1.isOpCodeHttpPutRequest());
        assertFalse(result1.isOpCodeHttpDeleteRequest());
        assertFalse(result1.isOpCodeHttpsGetRequest());
        assertFalse(result1.isOpCodeHttpsHeadRequest());
        assertFalse(result1.isOpCodeHttpsPostRequest());
        assertFalse(result1.isOpCodeHttpsPutRequest());
        assertFalse(result1.isOpCodeHttpsDeleteRequest());
        assertFalse(result1.isOpCodeHttpRequestCancel());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertEquals(HTTPControlPoint.OP_CODE_HTTP_HEAD_REQUEST, result1.getOpCode());
        assertFalse(result1.isOpCodeHttpGetRequest());
        assertTrue(result1.isOpCodeHttpHeadRequest());
        assertFalse(result1.isOpCodeHttpPostRequest());
        assertFalse(result1.isOpCodeHttpPutRequest());
        assertFalse(result1.isOpCodeHttpDeleteRequest());
        assertFalse(result1.isOpCodeHttpsGetRequest());
        assertFalse(result1.isOpCodeHttpsHeadRequest());
        assertFalse(result1.isOpCodeHttpsPostRequest());
        assertFalse(result1.isOpCodeHttpsPutRequest());
        assertFalse(result1.isOpCodeHttpsDeleteRequest());
        assertFalse(result1.isOpCodeHttpRequestCancel());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertEquals(HTTPControlPoint.OP_CODE_HTTP_POST_REQUEST, result1.getOpCode());
        assertFalse(result1.isOpCodeHttpGetRequest());
        assertFalse(result1.isOpCodeHttpHeadRequest());
        assertTrue(result1.isOpCodeHttpPostRequest());
        assertFalse(result1.isOpCodeHttpPutRequest());
        assertFalse(result1.isOpCodeHttpDeleteRequest());
        assertFalse(result1.isOpCodeHttpsGetRequest());
        assertFalse(result1.isOpCodeHttpsHeadRequest());
        assertFalse(result1.isOpCodeHttpsPostRequest());
        assertFalse(result1.isOpCodeHttpsPutRequest());
        assertFalse(result1.isOpCodeHttpsDeleteRequest());
        assertFalse(result1.isOpCodeHttpRequestCancel());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertEquals(HTTPControlPoint.OP_CODE_HTTP_PUT_REQUEST, result1.getOpCode());
        assertFalse(result1.isOpCodeHttpGetRequest());
        assertFalse(result1.isOpCodeHttpHeadRequest());
        assertFalse(result1.isOpCodeHttpPostRequest());
        assertTrue(result1.isOpCodeHttpPutRequest());
        assertFalse(result1.isOpCodeHttpDeleteRequest());
        assertFalse(result1.isOpCodeHttpsGetRequest());
        assertFalse(result1.isOpCodeHttpsHeadRequest());
        assertFalse(result1.isOpCodeHttpsPostRequest());
        assertFalse(result1.isOpCodeHttpsPutRequest());
        assertFalse(result1.isOpCodeHttpsDeleteRequest());
        assertFalse(result1.isOpCodeHttpRequestCancel());
    }

    @Test
    public void test_constructor_00005() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertEquals(HTTPControlPoint.OP_CODE_HTTP_DELETE_REQUEST, result1.getOpCode());
        assertFalse(result1.isOpCodeHttpGetRequest());
        assertFalse(result1.isOpCodeHttpHeadRequest());
        assertFalse(result1.isOpCodeHttpPostRequest());
        assertFalse(result1.isOpCodeHttpPutRequest());
        assertTrue(result1.isOpCodeHttpDeleteRequest());
        assertFalse(result1.isOpCodeHttpsGetRequest());
        assertFalse(result1.isOpCodeHttpsHeadRequest());
        assertFalse(result1.isOpCodeHttpsPostRequest());
        assertFalse(result1.isOpCodeHttpsPutRequest());
        assertFalse(result1.isOpCodeHttpsDeleteRequest());
        assertFalse(result1.isOpCodeHttpRequestCancel());
    }

    @Test
    public void test_constructor_00006() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertEquals(HTTPControlPoint.OP_CODE_HTTPS_GET_REQUEST, result1.getOpCode());
        assertFalse(result1.isOpCodeHttpGetRequest());
        assertFalse(result1.isOpCodeHttpHeadRequest());
        assertFalse(result1.isOpCodeHttpPostRequest());
        assertFalse(result1.isOpCodeHttpPutRequest());
        assertFalse(result1.isOpCodeHttpDeleteRequest());
        assertTrue(result1.isOpCodeHttpsGetRequest());
        assertFalse(result1.isOpCodeHttpsHeadRequest());
        assertFalse(result1.isOpCodeHttpsPostRequest());
        assertFalse(result1.isOpCodeHttpsPutRequest());
        assertFalse(result1.isOpCodeHttpsDeleteRequest());
        assertFalse(result1.isOpCodeHttpRequestCancel());
    }

    @Test
    public void test_constructor_00007() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertEquals(HTTPControlPoint.OP_CODE_HTTPS_HEAD_REQUEST, result1.getOpCode());
        assertFalse(result1.isOpCodeHttpGetRequest());
        assertFalse(result1.isOpCodeHttpHeadRequest());
        assertFalse(result1.isOpCodeHttpPostRequest());
        assertFalse(result1.isOpCodeHttpPutRequest());
        assertFalse(result1.isOpCodeHttpDeleteRequest());
        assertFalse(result1.isOpCodeHttpsGetRequest());
        assertTrue(result1.isOpCodeHttpsHeadRequest());
        assertFalse(result1.isOpCodeHttpsPostRequest());
        assertFalse(result1.isOpCodeHttpsPutRequest());
        assertFalse(result1.isOpCodeHttpsDeleteRequest());
        assertFalse(result1.isOpCodeHttpRequestCancel());
    }

    @Test
    public void test_constructor_00008() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertEquals(HTTPControlPoint.OP_CODE_HTTPS_POST_REQUEST, result1.getOpCode());
        assertFalse(result1.isOpCodeHttpGetRequest());
        assertFalse(result1.isOpCodeHttpHeadRequest());
        assertFalse(result1.isOpCodeHttpPostRequest());
        assertFalse(result1.isOpCodeHttpPutRequest());
        assertFalse(result1.isOpCodeHttpDeleteRequest());
        assertFalse(result1.isOpCodeHttpsGetRequest());
        assertFalse(result1.isOpCodeHttpsHeadRequest());
        assertTrue(result1.isOpCodeHttpsPostRequest());
        assertFalse(result1.isOpCodeHttpsPutRequest());
        assertFalse(result1.isOpCodeHttpsDeleteRequest());
        assertFalse(result1.isOpCodeHttpRequestCancel());
    }

    @Test
    public void test_constructor_00009() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertEquals(HTTPControlPoint.OP_CODE_HTTPS_PUT_REQUEST, result1.getOpCode());
        assertFalse(result1.isOpCodeHttpGetRequest());
        assertFalse(result1.isOpCodeHttpHeadRequest());
        assertFalse(result1.isOpCodeHttpPostRequest());
        assertFalse(result1.isOpCodeHttpPutRequest());
        assertFalse(result1.isOpCodeHttpDeleteRequest());
        assertFalse(result1.isOpCodeHttpsGetRequest());
        assertFalse(result1.isOpCodeHttpsHeadRequest());
        assertFalse(result1.isOpCodeHttpsPostRequest());
        assertTrue(result1.isOpCodeHttpsPutRequest());
        assertFalse(result1.isOpCodeHttpsDeleteRequest());
        assertFalse(result1.isOpCodeHttpRequestCancel());
    }

    @Test
    public void test_constructor_00010() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertEquals(HTTPControlPoint.OP_CODE_HTTPS_DELETE_REQUEST, result1.getOpCode());
        assertFalse(result1.isOpCodeHttpGetRequest());
        assertFalse(result1.isOpCodeHttpHeadRequest());
        assertFalse(result1.isOpCodeHttpPostRequest());
        assertFalse(result1.isOpCodeHttpPutRequest());
        assertFalse(result1.isOpCodeHttpDeleteRequest());
        assertFalse(result1.isOpCodeHttpsGetRequest());
        assertFalse(result1.isOpCodeHttpsHeadRequest());
        assertFalse(result1.isOpCodeHttpsPostRequest());
        assertFalse(result1.isOpCodeHttpsPutRequest());
        assertTrue(result1.isOpCodeHttpsDeleteRequest());
        assertFalse(result1.isOpCodeHttpRequestCancel());
    }

    @Test
    public void test_constructor_00011() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertEquals(HTTPControlPoint.OP_CODE_HTTP_REQUEST_CANCEL, result1.getOpCode());
        assertFalse(result1.isOpCodeHttpGetRequest());
        assertFalse(result1.isOpCodeHttpHeadRequest());
        assertFalse(result1.isOpCodeHttpPostRequest());
        assertFalse(result1.isOpCodeHttpPutRequest());
        assertFalse(result1.isOpCodeHttpDeleteRequest());
        assertFalse(result1.isOpCodeHttpsGetRequest());
        assertFalse(result1.isOpCodeHttpsHeadRequest());
        assertFalse(result1.isOpCodeHttpsPostRequest());
        assertFalse(result1.isOpCodeHttpsPutRequest());
        assertFalse(result1.isOpCodeHttpsDeleteRequest());
        assertTrue(result1.isOpCodeHttpRequestCancel());
    }

    @Test
    public void test_constructor_00012() {
        int opCode = 1;

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(opCode);
        assertEquals(opCode, result1.getOpCode());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
    }

    @Test
    public void test_parcelable_1_00010() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
    }

    @Test
    public void test_parcelable_1_00011() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00010() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00011() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00009() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00010() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00011() {
        byte[] data = getData();

        HTTPControlPointAndroid result1 = new HTTPControlPointAndroid(data);
        HTTPControlPointAndroid result2 = HTTPControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
