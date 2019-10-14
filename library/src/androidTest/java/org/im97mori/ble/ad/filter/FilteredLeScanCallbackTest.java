package org.im97mori.ble.ad.filter;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FilteredLeScanCallbackTest {

    @Test
    public void test_001() {
        BluetoothDevice bluetoothDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:BB");
        int rssi = 1;
        byte[] scanRecord = new byte[0];

        final List<BluetoothDevice> list1 = new LinkedList<>();
        final List<Integer> list2 = new LinkedList<>();
        final List<byte[]> list3 = new LinkedList<>();

        BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback() {
            @Override
            public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
                list1.add(device);
                list2.add(rssi);
                list3.add(scanRecord);
            }
        };
        FilteredLeScanCallback callback = new FilteredLeScanCallback.Builder().setScanCallback(leScanCallback).build();
        callback.onLeScan(bluetoothDevice, rssi, scanRecord);

        assertEquals(1, list1.size());
        assertEquals(1, list2.size());
        assertEquals(1, list3.size());
        assertEquals(bluetoothDevice, list1.get(0));
        assertEquals(rssi, list2.get(0).intValue());
        assertArrayEquals(scanRecord, list3.get(0));
    }

    @Test
    public void test_002() {
        BluetoothDevice bluetoothDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:BB");
        int rssi = 1;
        byte[] scanRecord = new byte[0];

        final List<BluetoothDevice> list1 = new LinkedList<>();
        final List<Integer> list2 = new LinkedList<>();
        final List<byte[]> list3 = new LinkedList<>();

        BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback() {
            @Override
            public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
                list1.add(device);
                list2.add(rssi);
                list3.add(scanRecord);
            }
        };
        FilteredLeScanCallback callback = new FilteredLeScanCallback.Builder().setScanCallback(leScanCallback).addFilter(new AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>(){
            @Override
            public boolean isMatched(AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
                return false;
            }
        }).build();
        callback.onLeScan(bluetoothDevice, rssi, scanRecord);

        assertTrue(list1.isEmpty());
        assertTrue(list2.isEmpty());
        assertTrue(list3.isEmpty());
    }

}
