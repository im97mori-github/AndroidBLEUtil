package org.im97mori.ble.characteristic.hps;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused", "ConstantConditions"})
public class HTTPStatusCodeTest {

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

    private byte[] getData() {
        int index = -1;
        byte[] data = null;

        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElementArray.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            if ("getData".equals(stackTraceElement.getMethodName())) {
                index = i + 1;
                break;
            }
        }
        if (index >= 0 && index < stackTraceElementArray.length) {
            StackTraceElement stackTraceElement = stackTraceElementArray[index];
            String[] splitted = stackTraceElement.getMethodName().split("_");
            try {
                data = (byte[]) this.getClass().getDeclaredField("data_" + splitted[splitted.length - 1]).get(null);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        assertEquals(200, result1.getStatusCode());
        assertTrue(result1.isDataStatusHeadersNotReceived());
        assertFalse(result1.isDataStatusHeadersReceived());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        assertEquals(200, result1.getStatusCode());
        assertFalse(result1.isDataStatusHeadersNotReceived());
        assertTrue(result1.isDataStatusHeadersReceived());
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        assertEquals(200, result1.getStatusCode());
        assertTrue(result1.isDataStatusHeadersNotTruncated());
        assertFalse(result1.isDataStatusHeadersTruncated());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        assertEquals(200, result1.getStatusCode());
        assertFalse(result1.isDataStatusHeadersNotTruncated());
        assertTrue(result1.isDataStatusHeadersTruncated());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        assertEquals(200, result1.getStatusCode());
        assertTrue(result1.isDataStatusBodysNotReceived());
        assertFalse(result1.isDataStatusBodysReceived());
    }

    @Test
    public void test_constructor_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        assertEquals(200, result1.getStatusCode());
        assertFalse(result1.isDataStatusBodysNotReceived());
        assertTrue(result1.isDataStatusBodysReceived());
    }

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        assertEquals(200, result1.getStatusCode());
        assertTrue(result1.isDataStatusBodysNotTruncated());
        assertFalse(result1.isDataStatusBodysTruncated());
    }

    @Test
    public void test_constructor_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        assertEquals(200, result1.getStatusCode());
        assertFalse(result1.isDataStatusBodysNotTruncated());
        assertTrue(result1.isDataStatusBodysTruncated());
    }


    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPStatusCode result2 = HTTPStatusCode.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getStatusCode(), result2.getStatusCode());
        assertEquals(result1.getDataStatus(), result2.getDataStatus());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPStatusCode result2 = HTTPStatusCode.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getStatusCode(), result2.getStatusCode());
        assertEquals(result1.getDataStatus(), result2.getDataStatus());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPStatusCode result2 = HTTPStatusCode.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getStatusCode(), result2.getStatusCode());
        assertEquals(result1.getDataStatus(), result2.getDataStatus());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPStatusCode result2 = HTTPStatusCode.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getStatusCode(), result2.getStatusCode());
        assertEquals(result1.getDataStatus(), result2.getDataStatus());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPStatusCode result2 = HTTPStatusCode.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getStatusCode(), result2.getStatusCode());
        assertEquals(result1.getDataStatus(), result2.getDataStatus());
    }

    @Test
    public void test_parcelable_1_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPStatusCode result2 = HTTPStatusCode.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getStatusCode(), result2.getStatusCode());
        assertEquals(result1.getDataStatus(), result2.getDataStatus());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPStatusCode result2 = HTTPStatusCode.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getStatusCode(), result2.getStatusCode());
        assertEquals(result1.getDataStatus(), result2.getDataStatus());
    }

    @Test
    public void test_parcelable_1_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPStatusCode result2 = HTTPStatusCode.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getStatusCode(), result2.getStatusCode());
        assertEquals(result1.getDataStatus(), result2.getDataStatus());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        HTTPStatusCode result2 = HTTPStatusCode.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        HTTPStatusCode result2 = HTTPStatusCode.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        HTTPStatusCode result2 = HTTPStatusCode.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        HTTPStatusCode result2 = HTTPStatusCode.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        HTTPStatusCode result2 = HTTPStatusCode.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        HTTPStatusCode result2 = HTTPStatusCode.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        HTTPStatusCode result2 = HTTPStatusCode.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00302() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HTTPStatusCode result1 = new HTTPStatusCode(bluetoothGattCharacteristic);
        HTTPStatusCode result2 = HTTPStatusCode.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }


}
