package org.im97mori.ble.ad.filter;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.os.Parcel;

import org.im97mori.ble.ad.AdvertisingDataParser;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FilteredScanCallbackTest {

    @Test
    public void test_001() {
        int callbackType = 1;
        BluetoothDevice bluetoothDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:BB");
        byte[] scanRecord = new byte[0];
        Parcel parcel = Parcel.obtain();
        parcel.writeInt(1);
        bluetoothDevice.writeToParcel(parcel, 0);
        parcel.writeInt(1);
        parcel.writeByteArray(scanRecord);
        parcel.writeInt(1);
        parcel.writeLong(2);
        parcel.writeInt(3);
        parcel.writeInt(4);
        parcel.writeInt(5);
        parcel.writeInt(6);
        parcel.writeInt(7);
        parcel.writeInt(7);
        parcel.setDataPosition(0);
        ScanResult scanResult = ScanResult.CREATOR.createFromParcel(parcel);

        final List<Integer> list1 = new LinkedList<>();
        final List<ScanResult> list2 = new LinkedList<>();
        final List<List<ScanResult>> list3 = new LinkedList<>();

        ScanCallback scanCallback = new ScanCallback() {
            @Override
            public void onScanResult(int callbackType, ScanResult result) {
                list1.add(callbackType);
                list2.add(result);
            }

            @Override
            public void onBatchScanResults(List<ScanResult> results) {
                list3.add(results);
            }
        };
        FilteredScanCallback callback = new FilteredScanCallback.Builder().setScanCallback(scanCallback).build();
        callback.onScanResult(callbackType, scanResult);

        assertEquals(1, list1.size());
        assertEquals(1, list2.size());
        assertEquals(0, list3.size());
        assertEquals(callbackType, list1.get(0).intValue());
        assertEquals(scanResult, list2.get(0));
    }

    @Test
    public void test_002() {
        int callbackType = 1;
        BluetoothDevice bluetoothDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:BB");
        byte[] scanRecord = new byte[0];
        Parcel parcel = Parcel.obtain();
        parcel.writeInt(1);
        bluetoothDevice.writeToParcel(parcel, 0);
        parcel.writeInt(1);
        parcel.writeByteArray(scanRecord);
        parcel.writeInt(1);
        parcel.writeLong(2);
        parcel.writeInt(3);
        parcel.writeInt(4);
        parcel.writeInt(5);
        parcel.writeInt(6);
        parcel.writeInt(7);
        parcel.writeInt(7);
        parcel.setDataPosition(0);
        ScanResult scanResult = ScanResult.CREATOR.createFromParcel(parcel);

        final List<Integer> list1 = new LinkedList<>();
        final List<ScanResult> list2 = new LinkedList<>();
        final List<List<ScanResult>> list3 = new LinkedList<>();

        ScanCallback scanCallback = new ScanCallback() {
            @Override
            public void onScanResult(int callbackType, ScanResult result) {
                list1.add(callbackType);
                list2.add(result);
            }

            @Override
            public void onBatchScanResults(List<ScanResult> results) {
                list3.add(results);
            }
        };
        FilteredScanCallback callback = new FilteredScanCallback.Builder().setScanCallback(scanCallback).addFilter(new AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>() {
            @Override
            public boolean isMatched(AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
                return false;
            }
        }).build();
        callback.onScanResult(callbackType, scanResult);

        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
        assertEquals(0, list3.size());
    }

    @Test
    public void test_003() {
        BluetoothDevice bluetoothDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:BB");
        byte[] scanRecord = new byte[0];
        Parcel parcel = Parcel.obtain();
        parcel.writeInt(1);
        bluetoothDevice.writeToParcel(parcel, 0);
        parcel.writeInt(1);
        parcel.writeByteArray(scanRecord);
        parcel.writeInt(1);
        parcel.writeLong(2);
        parcel.writeInt(3);
        parcel.writeInt(4);
        parcel.writeInt(5);
        parcel.writeInt(6);
        parcel.writeInt(7);
        parcel.writeInt(7);
        parcel.setDataPosition(0);
        ScanResult scanResult = ScanResult.CREATOR.createFromParcel(parcel);

        final List<Integer> list1 = new LinkedList<>();
        final List<ScanResult> list2 = new LinkedList<>();
        final List<List<ScanResult>> list3 = new LinkedList<>();

        ScanCallback scanCallback = new ScanCallback() {
            @Override
            public void onScanResult(int callbackType, ScanResult result) {
                list1.add(callbackType);
                list2.add(result);
            }

            @Override
            public void onBatchScanResults(List<ScanResult> results) {
                list3.add(results);
            }
        };
        FilteredScanCallback callback = new FilteredScanCallback.Builder().setScanCallback(scanCallback).build();
        callback.onBatchScanResults(Collections.singletonList(scanResult));

        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
        assertEquals(1, list3.size());
        assertEquals(1, list3.get(0).size());
        assertEquals(scanResult, list3.get(0).get(0));
    }

    @Test
    public void test_004() {
        BluetoothDevice bluetoothDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:BB");
        byte[] scanRecord = new byte[0];
        Parcel parcel = Parcel.obtain();
        parcel.writeInt(1);
        bluetoothDevice.writeToParcel(parcel, 0);
        parcel.writeInt(1);
        parcel.writeByteArray(scanRecord);
        parcel.writeInt(1);
        parcel.writeLong(2);
        parcel.writeInt(3);
        parcel.writeInt(4);
        parcel.writeInt(5);
        parcel.writeInt(6);
        parcel.writeInt(7);
        parcel.writeInt(7);
        parcel.setDataPosition(0);
        ScanResult scanResult = ScanResult.CREATOR.createFromParcel(parcel);

        final List<Integer> list1 = new LinkedList<>();
        final List<ScanResult> list2 = new LinkedList<>();
        final List<List<ScanResult>> list3 = new LinkedList<>();

        ScanCallback scanCallback = new ScanCallback() {
            @Override
            public void onScanResult(int callbackType, ScanResult result) {
                list1.add(callbackType);
                list2.add(result);
            }

            @Override
            public void onBatchScanResults(List<ScanResult> results) {
                list3.add(results);
            }
        };
        FilteredScanCallback callback = new FilteredScanCallback.Builder().setScanCallback(scanCallback).addFilter(new AdvertisingDataFilter<AdvertisingDataParser.AdvertisingDataParseResult>() {
            @Override
            public boolean isMatched(AdvertisingDataParser.AdvertisingDataParseResult advertisingDataParseResult) {
                return false;
            }
        }).build();
        callback.onBatchScanResults(Collections.singletonList(scanResult));

        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
        assertEquals(0, list3.size());
    }

}
