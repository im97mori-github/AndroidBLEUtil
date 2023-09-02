package org.im97mori.ble.advertising;

import static org.im97mori.ble.constants.DataType.LE_ROLE_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * @noinspection DataFlowIssue
 */
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressWarnings("unused")
public class LeRoleAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_ROLE_DATA_TYPE;
        data[2] = 0x00;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_ROLE_DATA_TYPE;
        data[2] = 0x01;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_ROLE_DATA_TYPE;
        data[2] = 0x02;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_ROLE_DATA_TYPE;
        data[2] = 0x03;
        data_00004 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(LE_ROLE_DATA_TYPE, result1.getDataType());
        assertEquals(0x00, result1.getLeRole());
        assertTrue(result1.isOnlyPeripheralRoleSupported());
        assertFalse(result1.isOnlyCentralRoleSupported());
        assertFalse(result1.isPeripheralRolePreferredForConnectionEstablishment());
        assertFalse(result1.isCentralRolePreferredForConnectionEstablishment());
    }

    @Test
    public void test_constructor_1_00002() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(LE_ROLE_DATA_TYPE, result1.getDataType());
        assertEquals(0x01, result1.getLeRole());
        assertFalse(result1.isOnlyPeripheralRoleSupported());
        assertTrue(result1.isOnlyCentralRoleSupported());
        assertFalse(result1.isPeripheralRolePreferredForConnectionEstablishment());
        assertFalse(result1.isCentralRolePreferredForConnectionEstablishment());
    }

    @Test
    public void test_constructor_1_00003() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(LE_ROLE_DATA_TYPE, result1.getDataType());
        assertEquals(0x02, result1.getLeRole());
        assertFalse(result1.isOnlyPeripheralRoleSupported());
        assertFalse(result1.isOnlyCentralRoleSupported());
        assertTrue(result1.isPeripheralRolePreferredForConnectionEstablishment());
        assertFalse(result1.isCentralRolePreferredForConnectionEstablishment());
    }

    @Test
    public void test_constructor_1_00004() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(LE_ROLE_DATA_TYPE, result1.getDataType());
        assertEquals(0x03, result1.getLeRole());
        assertFalse(result1.isOnlyPeripheralRoleSupported());
        assertFalse(result1.isOnlyCentralRoleSupported());
        assertFalse(result1.isPeripheralRolePreferredForConnectionEstablishment());
        assertTrue(result1.isCentralRolePreferredForConnectionEstablishment());
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(LE_ROLE_DATA_TYPE, result1.getDataType());
        assertEquals(0x00, result1.getLeRole());
        assertTrue(result1.isOnlyPeripheralRoleSupported());
        assertFalse(result1.isOnlyCentralRoleSupported());
        assertFalse(result1.isPeripheralRolePreferredForConnectionEstablishment());
        assertFalse(result1.isCentralRolePreferredForConnectionEstablishment());
    }

    @Test
    public void test_constructor_2_00002() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(LE_ROLE_DATA_TYPE, result1.getDataType());
        assertEquals(0x01, result1.getLeRole());
        assertFalse(result1.isOnlyPeripheralRoleSupported());
        assertTrue(result1.isOnlyCentralRoleSupported());
        assertFalse(result1.isPeripheralRolePreferredForConnectionEstablishment());
        assertFalse(result1.isCentralRolePreferredForConnectionEstablishment());
    }

    @Test
    public void test_constructor_2_00003() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(LE_ROLE_DATA_TYPE, result1.getDataType());
        assertEquals(0x02, result1.getLeRole());
        assertFalse(result1.isOnlyPeripheralRoleSupported());
        assertFalse(result1.isOnlyCentralRoleSupported());
        assertTrue(result1.isPeripheralRolePreferredForConnectionEstablishment());
        assertFalse(result1.isCentralRolePreferredForConnectionEstablishment());
    }

    @Test
    public void test_constructor_2_00004() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(LE_ROLE_DATA_TYPE, result1.getDataType());
        assertEquals(0x03, result1.getLeRole());
        assertFalse(result1.isOnlyPeripheralRoleSupported());
        assertFalse(result1.isOnlyCentralRoleSupported());
        assertFalse(result1.isPeripheralRolePreferredForConnectionEstablishment());
        assertTrue(result1.isCentralRolePreferredForConnectionEstablishment());
    }

    @Test
    public void test_constructor_3_00001() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(0x00);
        assertEquals(2, result1.getLength());
        assertEquals(LE_ROLE_DATA_TYPE, result1.getDataType());
        assertEquals(0x00, result1.getLeRole());
        assertTrue(result1.isOnlyPeripheralRoleSupported());
        assertFalse(result1.isOnlyCentralRoleSupported());
        assertFalse(result1.isPeripheralRolePreferredForConnectionEstablishment());
        assertFalse(result1.isCentralRolePreferredForConnectionEstablishment());
    }

    @Test
    public void test_constructor_3_00002() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(0x01);
        assertEquals(2, result1.getLength());
        assertEquals(LE_ROLE_DATA_TYPE, result1.getDataType());
        assertEquals(0x01, result1.getLeRole());
        assertFalse(result1.isOnlyPeripheralRoleSupported());
        assertTrue(result1.isOnlyCentralRoleSupported());
        assertFalse(result1.isPeripheralRolePreferredForConnectionEstablishment());
        assertFalse(result1.isCentralRolePreferredForConnectionEstablishment());
    }

    @Test
    public void test_constructor_3_00003() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(0x02);
        assertEquals(2, result1.getLength());
        assertEquals(LE_ROLE_DATA_TYPE, result1.getDataType());
        assertEquals(0x02, result1.getLeRole());
        assertFalse(result1.isOnlyPeripheralRoleSupported());
        assertFalse(result1.isOnlyCentralRoleSupported());
        assertTrue(result1.isPeripheralRolePreferredForConnectionEstablishment());
        assertFalse(result1.isCentralRolePreferredForConnectionEstablishment());
    }

    @Test
    public void test_constructor_3_00004() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(0x03);
        assertEquals(2, result1.getLength());
        assertEquals(LE_ROLE_DATA_TYPE, result1.getDataType());
        assertEquals(0x03, result1.getLeRole());
        assertFalse(result1.isOnlyPeripheralRoleSupported());
        assertFalse(result1.isOnlyCentralRoleSupported());
        assertFalse(result1.isPeripheralRolePreferredForConnectionEstablishment());
        assertTrue(result1.isCentralRolePreferredForConnectionEstablishment());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeRoleAndroid result2 = LeRoleAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getLeRole(), result1.getLeRole());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeRoleAndroid result2 = LeRoleAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getLeRole(), result1.getLeRole());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeRoleAndroid result2 = LeRoleAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getLeRole(), result1.getLeRole());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeRoleAndroid result2 = LeRoleAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getLeRole(), result1.getLeRole());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        LeRoleAndroid result2 = LeRoleAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        LeRoleAndroid result2 = LeRoleAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        LeRoleAndroid result2 = LeRoleAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        LeRoleAndroid result1 = new LeRoleAndroid(data, 0, data[0]);
        LeRoleAndroid result2 = LeRoleAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
