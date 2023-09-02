package org.im97mori.ble.advertising;

import static org.im97mori.ble.constants.DataType.INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
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
import java.util.UUID;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressWarnings("unused")
public class IncompleteListOf16BitServiceUUIDsAndroidTest extends TestBase {


    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = 0;
        data[3] = 0;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = 127;
        data[3] = 127;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = 0;
        data[3] = 127;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = 127;
        data[3] = 0;
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = 0;
        data[3] = (byte) 0b11111111;
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = 0;
        data_00007 = data;
    }

    private static final byte[] data_00008;
    static {
        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data_00008 = data;
    }

    private static final byte[] data_00009;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE;
        data[2] = 1;
        data[3] = 2;
        data[4] = 3;
        data[5] = 4;
        data_00009 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_1_00002() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("00007f7f-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_1_00003() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("00007f00-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_1_00004() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("0000007f-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_1_00005() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("0000ffff-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_1_00006() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("0000ff00-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_1_00007() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("000000ff-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_1_00008() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertEquals(1, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getUuidList().size());
    }

    @Test
    public void test_constructor_1_00009() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getUuidList().size());
        assertEquals(UUID.fromString("00000201-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
        assertEquals(UUID.fromString("00000403-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(1));
    }

    @Test
    public void test_constructor_1_00101() {
        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid();
        assertEquals(1, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getUuidList().size());
    }

    @Test
    public void test_constructor_1_00102() {
        UUID uuid1 = UUID.randomUUID();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(uuid1);
        assertEquals(3, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(uuid1, result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_1_00103() {
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(uuid1, uuid2);
        assertEquals(5, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getUuidList().size());
        assertEquals(uuid1, result1.getUuidList().get(0));
        assertEquals(uuid2, result1.getUuidList().get(1));
    }

    @Test
    public void test_constructor_1_00104() {
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(Arrays.asList(uuid1, uuid2));
        assertEquals(5, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getUuidList().size());
        assertEquals(uuid1, result1.getUuidList().get(0));
        assertEquals(uuid2, result1.getUuidList().get(1));
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0);
        assertEquals(3, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("00000000-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_2_00002() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0);
        assertEquals(3, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("00007f7f-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_2_00003() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0);
        assertEquals(3, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("00007f00-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_2_00004() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0);
        assertEquals(3, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("0000007f-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_2_00005() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0);
        assertEquals(3, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("0000ffff-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_2_00006() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0);
        assertEquals(3, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("0000ff00-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_2_00007() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0);
        assertEquals(3, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getUuidList().size());
        assertEquals(UUID.fromString("000000ff-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
    }

    @Test
    public void test_constructor_2_00008() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0);
        assertEquals(1, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getUuidList().size());
    }

    @Test
    public void test_constructor_2_00009() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0);
        assertEquals(5, result1.getLength());
        assertEquals(INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getUuidList().size());
        assertEquals(UUID.fromString("00000201-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(0));
        assertEquals(UUID.fromString("00000403-0000-1000-8000-00805F9B34FB"), result1.getUuidList().get(1));
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getUuidList().toArray(), result2.getUuidList().toArray());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00009() {
        byte[] data = getData();

        IncompleteListOf16BitServiceUUIDsAndroid result1 = new IncompleteListOf16BitServiceUUIDsAndroid(data, 0, data[0]);
        IncompleteListOf16BitServiceUUIDsAndroid result2 = IncompleteListOf16BitServiceUUIDsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
