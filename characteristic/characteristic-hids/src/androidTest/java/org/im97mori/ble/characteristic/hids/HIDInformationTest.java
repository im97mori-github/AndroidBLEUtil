package org.im97mori.ble.characteristic.hids;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused"})
public class HIDInformationTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = HIDInformation.FLAGS_REMOTE_WAKE_FALSE
            | HIDInformation.FLAGS_NORMALLY_CONNECTABLE_FALSE;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = HIDInformation.FLAGS_REMOTE_WAKE_TRUE
                | HIDInformation.FLAGS_NORMALLY_CONNECTABLE_FALSE;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = HIDInformation.FLAGS_REMOTE_WAKE_FALSE
                | HIDInformation.FLAGS_NORMALLY_CONNECTABLE_TRUE;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = HIDInformation.FLAGS_REMOTE_WAKE_TRUE
                | HIDInformation.FLAGS_NORMALLY_CONNECTABLE_TRUE;
        data_00004 = data;
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

        HIDInformation result1 = new HIDInformation(bluetoothGattCharacteristic);
        assertEquals(0x0201, result1.getBcdhid());
        assertEquals(0x03, result1.getBcountrycode());
        assertEquals(HIDInformation.FLAGS_REMOTE_WAKE_FALSE
                | HIDInformation.FLAGS_NORMALLY_CONNECTABLE_FALSE, result1.getFlags());
        assertTrue(result1.isFlagsRemoteWakeFalse());
        assertFalse(result1.isFlagsRemoteWakeTrue());
        assertTrue(result1.isFlagsNormallyConnectableFalse());
        assertFalse(result1.isFlagsNormallyConnectableTrue());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HIDInformation result1 = new HIDInformation(bluetoothGattCharacteristic);
        assertEquals(0x0201, result1.getBcdhid());
        assertEquals(0x03, result1.getBcountrycode());
        assertEquals(HIDInformation.FLAGS_REMOTE_WAKE_TRUE
                | HIDInformation.FLAGS_NORMALLY_CONNECTABLE_FALSE, result1.getFlags());
        assertFalse(result1.isFlagsRemoteWakeFalse());
        assertTrue(result1.isFlagsRemoteWakeTrue());
        assertTrue(result1.isFlagsNormallyConnectableFalse());
        assertFalse(result1.isFlagsNormallyConnectableTrue());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HIDInformation result1 = new HIDInformation(bluetoothGattCharacteristic);
        assertEquals(0x0201, result1.getBcdhid());
        assertEquals(0x03, result1.getBcountrycode());
        assertEquals(HIDInformation.FLAGS_REMOTE_WAKE_FALSE
                | HIDInformation.FLAGS_NORMALLY_CONNECTABLE_TRUE, result1.getFlags());
        assertTrue(result1.isFlagsRemoteWakeFalse());
        assertFalse(result1.isFlagsRemoteWakeTrue());
        assertFalse(result1.isFlagsNormallyConnectableFalse());
        assertTrue(result1.isFlagsNormallyConnectableTrue());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HIDInformation result1 = new HIDInformation(bluetoothGattCharacteristic);
        assertEquals(0x0201, result1.getBcdhid());
        assertEquals(0x03, result1.getBcountrycode());
        assertEquals(HIDInformation.FLAGS_REMOTE_WAKE_TRUE
                | HIDInformation.FLAGS_NORMALLY_CONNECTABLE_TRUE, result1.getFlags());
        assertFalse(result1.isFlagsRemoteWakeFalse());
        assertTrue(result1.isFlagsRemoteWakeTrue());
        assertFalse(result1.isFlagsNormallyConnectableFalse());
        assertTrue(result1.isFlagsNormallyConnectableTrue());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HIDInformation result1 = new HIDInformation(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HIDInformation result2 = HIDInformation.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getBcdhid(), result2.getBcdhid());
        assertEquals(result1.getBcountrycode(), result2.getBcountrycode());
        assertEquals(result1.getFlags(), result2.getFlags());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HIDInformation result1 = new HIDInformation(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HIDInformation result2 = HIDInformation.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getBcdhid(), result2.getBcdhid());
        assertEquals(result1.getBcountrycode(), result2.getBcountrycode());
        assertEquals(result1.getFlags(), result2.getFlags());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HIDInformation result1 = new HIDInformation(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HIDInformation result2 = HIDInformation.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getBcdhid(), result2.getBcdhid());
        assertEquals(result1.getBcountrycode(), result2.getBcountrycode());
        assertEquals(result1.getFlags(), result2.getFlags());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HIDInformation result1 = new HIDInformation(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HIDInformation result2 = HIDInformation.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getBcdhid(), result2.getBcdhid());
        assertEquals(result1.getBcountrycode(), result2.getBcountrycode());
        assertEquals(result1.getFlags(), result2.getFlags());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HIDInformation result1 = new HIDInformation(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HIDInformation result1 = new HIDInformation(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HIDInformation result1 = new HIDInformation(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HIDInformation result1 = new HIDInformation(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HIDInformation result1 = new HIDInformation(bluetoothGattCharacteristic);
        HIDInformation result2 = HIDInformation.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HIDInformation result1 = new HIDInformation(bluetoothGattCharacteristic);
        HIDInformation result2 = HIDInformation.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HIDInformation result1 = new HIDInformation(bluetoothGattCharacteristic);
        HIDInformation result2 = HIDInformation.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HIDInformation result1 = new HIDInformation(bluetoothGattCharacteristic);
        HIDInformation result2 = HIDInformation.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
