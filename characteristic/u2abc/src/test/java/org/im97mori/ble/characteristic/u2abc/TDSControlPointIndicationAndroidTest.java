package org.im97mori.ble.characteristic.u2abc;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.TDSControlPointUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/** @noinspection DataFlowIssue*/
@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class TDSControlPointIndicationAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[2];
        data[ 0] = TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT;
        data[ 1] = TDSControlPointUtils.RESULT_CODE_SUCCESS;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[3];
        data[ 0] = TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT;
        data[ 1] = TDSControlPointUtils.RESULT_CODE_SUCCESS;
        data[ 2] = 0x01;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[4];
        data[ 0] = TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT;
        data[ 1] = TDSControlPointUtils.RESULT_CODE_SUCCESS;
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00003 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[2];
        data[ 0] = TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT;
        data[ 1] = TDSControlPointUtils.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[3];
        data[ 0] = TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT;
        data[ 1] = TDSControlPointUtils.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data[ 2] = 0x01;
        data_00102 = data;
    }

    private static final byte[] data_00103;
    static {
        byte[] data = new byte[4];
        data[ 0] = TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT;
        data[ 1] = TDSControlPointUtils.RESULT_CODE_OP_CODE_NOT_SUPPORTED;
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00103 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[2];
        data[ 0] = TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT;
        data[ 1] = TDSControlPointUtils.RESULT_CODE_INVALID_PARAMETER;
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[3];
        data[ 0] = TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT;
        data[ 1] = TDSControlPointUtils.RESULT_CODE_INVALID_PARAMETER;
        data[ 2] = 0x01;
        data_00202 = data;
    }

    private static final byte[] data_00203;
    static {
        byte[] data = new byte[4];
        data[ 0] = TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT;
        data[ 1] = TDSControlPointUtils.RESULT_CODE_INVALID_PARAMETER;
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00203 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[2];
        data[ 0] = TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT;
        data[ 1] = TDSControlPointUtils.RESULT_CODE_UNSUPPORTED_ORGANIZATION_ID;
        data_00301 = data;
    }

    private static final byte[] data_00302;
    static {
        byte[] data = new byte[3];
        data[ 0] = TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT;
        data[ 1] = TDSControlPointUtils.RESULT_CODE_UNSUPPORTED_ORGANIZATION_ID;
        data[ 2] = 0x01;
        data_00302 = data;
    }

    private static final byte[] data_00303;
    static {
        byte[] data = new byte[4];
        data[ 0] = TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT;
        data[ 1] = TDSControlPointUtils.RESULT_CODE_UNSUPPORTED_ORGANIZATION_ID;
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00303 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[2];
        data[ 0] = TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT;
        data[ 1] = TDSControlPointUtils.RESULT_CODE_OPERATION_FAILED;
        data_00401 = data;
    }

    private static final byte[] data_00402;
    static {
        byte[] data = new byte[3];
        data[ 0] = TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT;
        data[ 1] = TDSControlPointUtils.RESULT_CODE_OPERATION_FAILED;
        data[ 2] = 0x01;
        data_00402 = data;
    }

    private static final byte[] data_00403;
    static {
        byte[] data = new byte[4];
        data[ 0] = TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT;
        data[ 1] = TDSControlPointUtils.RESULT_CODE_OPERATION_FAILED;
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00403 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertEquals(TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT, result1.getRequestedOpCode());
        assertEquals(TDSControlPointUtils.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertArrayEquals(new byte[0], result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertEquals(TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT, result1.getRequestedOpCode());
        assertEquals(TDSControlPointUtils.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertEquals(TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT, result1.getRequestedOpCode());
        assertEquals(TDSControlPointUtils.RESULT_CODE_SUCCESS, result1.getResultCode());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 4), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertEquals(TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT, result1.getRequestedOpCode());
        assertEquals(TDSControlPointUtils.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertArrayEquals(new byte[0], result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertEquals(TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT, result1.getRequestedOpCode());
        assertEquals(TDSControlPointUtils.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00103() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertEquals(TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT, result1.getRequestedOpCode());
        assertEquals(TDSControlPointUtils.RESULT_CODE_OP_CODE_NOT_SUPPORTED, result1.getResultCode());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 4), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertEquals(TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT, result1.getRequestedOpCode());
        assertEquals(TDSControlPointUtils.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertArrayEquals(new byte[0], result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00202() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertEquals(TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT, result1.getRequestedOpCode());
        assertEquals(TDSControlPointUtils.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00203() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertEquals(TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT, result1.getRequestedOpCode());
        assertEquals(TDSControlPointUtils.RESULT_CODE_INVALID_PARAMETER, result1.getResultCode());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 4), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertEquals(TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT, result1.getRequestedOpCode());
        assertEquals(TDSControlPointUtils.RESULT_CODE_UNSUPPORTED_ORGANIZATION_ID, result1.getResultCode());
        assertArrayEquals(new byte[0], result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00302() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertEquals(TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT, result1.getRequestedOpCode());
        assertEquals(TDSControlPointUtils.RESULT_CODE_UNSUPPORTED_ORGANIZATION_ID, result1.getResultCode());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00303() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertEquals(TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT, result1.getRequestedOpCode());
        assertEquals(TDSControlPointUtils.RESULT_CODE_UNSUPPORTED_ORGANIZATION_ID, result1.getResultCode());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 4), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00401() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertEquals(TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT, result1.getRequestedOpCode());
        assertEquals(TDSControlPointUtils.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertArrayEquals(new byte[0], result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00402() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertEquals(TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT, result1.getRequestedOpCode());
        assertEquals(TDSControlPointUtils.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 3), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00403() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertEquals(TDSControlPointUtils.OP_CODE_ACTIVATE_TRANSPORT, result1.getRequestedOpCode());
        assertEquals(TDSControlPointUtils.RESULT_CODE_OPERATION_FAILED, result1.getResultCode());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 4), result1.getResponseParameter());
    }

    @Test
    public void test_constructor_00404() {
        int requestedOpCode = 1;
        int resultCode = 2;
        byte[] responseParameter = new byte[]{2};

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(requestedOpCode, resultCode, responseParameter);
        assertEquals(requestedOpCode, result1.getRequestedOpCode());
        assertEquals(resultCode, result1.getResultCode());
        assertArrayEquals(responseParameter, result1.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRequestedOpCode(), result2.getRequestedOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRequestedOpCode(), result2.getRequestedOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRequestedOpCode(), result2.getRequestedOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRequestedOpCode(), result2.getRequestedOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRequestedOpCode(), result2.getRequestedOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00103() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRequestedOpCode(), result2.getRequestedOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRequestedOpCode(), result2.getRequestedOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00202() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRequestedOpCode(), result2.getRequestedOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00203() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRequestedOpCode(), result2.getRequestedOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRequestedOpCode(), result2.getRequestedOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00302() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRequestedOpCode(), result2.getRequestedOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00303() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRequestedOpCode(), result2.getRequestedOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRequestedOpCode(), result2.getRequestedOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00402() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRequestedOpCode(), result2.getRequestedOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_1_00403() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRequestedOpCode(), result2.getRequestedOpCode());
        assertEquals(result1.getResultCode(), result2.getResultCode());
        assertArrayEquals(result1.getResponseParameter(), result2.getResponseParameter());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00103() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00203() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00302() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00303() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00402() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00403() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00103() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00203() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00302() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00303() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00402() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00403() {
        byte[] data = getData();

        TDSControlPointIndicationAndroid result1 = new TDSControlPointIndicationAndroid(data);
        TDSControlPointIndicationAndroid result2 = TDSControlPointIndicationAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
