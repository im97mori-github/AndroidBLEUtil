package org.im97mori.ble.advertising.filter;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FilteredLeScanCallbackTest {

    @Test
    public void test_001() {
        int rssi = 1;
        byte[] scanRecord = new byte[0];

        final List<BluetoothDevice> list1 = new LinkedList<>();
        final List<Integer> list2 = new LinkedList<>();
        final List<byte[]> list3 = new LinkedList<>();

        FilteredLeScanCallbackInterface filteredLeScanCallbackInterface = (device, rssi1, scanRecord1, result) -> {
            list1.add(device);
            list2.add(rssi1);
            list3.add(scanRecord1);
        };

        FilteredLeScanCallback callback = new FilteredLeScanCallback.Builder(filteredLeScanCallbackInterface, null).build();
        callback.onLeScan(BLETestUtilsAndroid.MOCK_DEVICE_0, rssi, scanRecord);

        assertEquals(1, list1.size());
        assertEquals(1, list2.size());
        assertEquals(1, list3.size());
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0, list1.get(0));
        assertEquals(rssi, list2.get(0).intValue());
        assertArrayEquals(scanRecord, list3.get(0));
    }

    @Test
    public void test_002() {
        int rssi = 1;
        byte[] scanRecord = new byte[0];

        final List<BluetoothDevice> list1 = new LinkedList<>();
        final List<Integer> list2 = new LinkedList<>();
        final List<byte[]> list3 = new LinkedList<>();

        FilteredLeScanCallbackInterface filteredLeScanCallbackInterface = (device, rssi1, scanRecord1, result) -> {
            list1.add(device);
            list2.add(rssi1);
            list3.add(scanRecord1);
        };

        FilteredLeScanCallback callback = new FilteredLeScanCallback.Builder(filteredLeScanCallbackInterface, null).addFilter(advertisingDataParseResult -> false).build();
        callback.onLeScan(BLETestUtilsAndroid.MOCK_DEVICE_0, rssi, scanRecord);

        assertTrue(list1.isEmpty());
        assertTrue(list2.isEmpty());
        assertTrue(list3.isEmpty());
    }

    @Test
    public void test_101() {
        int rssi = 1;
        byte[] scanRecord = new byte[0];

        final List<BluetoothDevice> list1 = new LinkedList<>();
        final List<Integer> list2 = new LinkedList<>();
        final List<byte[]> list3 = new LinkedList<>();

        BluetoothAdapter.LeScanCallback leScanCallback = (device, rssi1, scanRecord1) -> {
            list1.add(device);
            list2.add(rssi1);
            list3.add(scanRecord1);
        };

        FilteredLeScanCallback callback = new FilteredLeScanCallback.Builder((device, rssi12, scanRecord12, result) -> {

        }, leScanCallback).build();
        callback.onLeScan(BLETestUtilsAndroid.MOCK_DEVICE_0, rssi, scanRecord);

        assertEquals(1, list1.size());
        assertEquals(1, list2.size());
        assertEquals(1, list3.size());
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0, list1.get(0));
        assertEquals(rssi, list2.get(0).intValue());
        assertArrayEquals(scanRecord, list3.get(0));
    }

    @Test
    public void test_102() {
        int rssi = 1;
        byte[] scanRecord = new byte[0];

        final List<BluetoothDevice> list1 = new LinkedList<>();
        final List<Integer> list2 = new LinkedList<>();
        final List<byte[]> list3 = new LinkedList<>();

        BluetoothAdapter.LeScanCallback leScanCallback = (device, rssi1, scanRecord1) -> {
            list1.add(device);
            list2.add(rssi1);
            list3.add(scanRecord1);
        };

        FilteredLeScanCallback callback = new FilteredLeScanCallback.Builder((device, rssi12, scanRecord12, result) -> {

        }, leScanCallback).addFilter(advertisingDataParseResult -> false).build();
        callback.onLeScan(BLETestUtilsAndroid.MOCK_DEVICE_0, rssi, scanRecord);

        assertTrue(list1.isEmpty());
        assertTrue(list2.isEmpty());
        assertTrue(list3.isEmpty());
    }

}
