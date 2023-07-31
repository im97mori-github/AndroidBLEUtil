package org.im97mori.ble.advertising.filter;

import static org.junit.Assert.assertEquals;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.os.Build;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.advertising.AdvertisingDataParser;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/** @noinspection EmptyMethod, EmptyMethod, EmptyMethod, EmptyMethod, EmptyMethod */
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.LOLLIPOP)
@SuppressWarnings("unused")
public class FilteredScanCallbackTest {

    @Test
    @RequiresDevice
    public void test_001() {
        int callbackType = 1;
        byte[] scanRecord = new byte[0];
        Parcel parcel = Parcel.obtain();
        parcel.writeInt(1);
        BLETestUtilsAndroid.MOCK_DEVICE_0.writeToParcel(parcel, 0);
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

        FilteredScanCallback callback = new FilteredScanCallback.Builder(new FilteredScanCallbackInterface() {
            @Override
            public void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {
                list1.add(callbackType);
                list2.add(result);
            }

            @Override
            public void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {
                list3.add(results);
            }

            /** @noinspection EmptyMethod*/
            @Override
            public void onScanFailed(int errorCode) {

            }
        }, null).build();
        callback.onScanResult(callbackType, scanResult);

        assertEquals(1, list1.size());
        assertEquals(1, list2.size());
        assertEquals(0, list3.size());
        assertEquals(callbackType, list1.get(0).intValue());
        assertEquals(scanResult, list2.get(0));
    }

    @Test
    @RequiresDevice
    public void test_002() {
        int callbackType = 1;
        byte[] scanRecord = new byte[0];
        Parcel parcel = Parcel.obtain();
        parcel.writeInt(1);
        BLETestUtilsAndroid.MOCK_DEVICE_0.writeToParcel(parcel, 0);
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

        FilteredScanCallback callback = new FilteredScanCallback.Builder(new FilteredScanCallbackInterface() {
            @Override
            public void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {
                list1.add(callbackType);
                list2.add(result);
            }

            @Override
            public void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {
                list3.add(results);
            }

            /** @noinspection EmptyMethod*/
            @Override
            public void onScanFailed(int errorCode) {

            }
        }, null).addFilter(advertisingDataParseResult -> false).build();
        callback.onScanResult(callbackType, scanResult);

        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
        assertEquals(0, list3.size());
    }

    @Test
    @RequiresDevice
    public void test_003() {
        byte[] scanRecord = new byte[0];
        Parcel parcel = Parcel.obtain();
        parcel.writeInt(1);
        BLETestUtilsAndroid.MOCK_DEVICE_0.writeToParcel(parcel, 0);
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

        FilteredScanCallback callback = new FilteredScanCallback.Builder(new FilteredScanCallbackInterface() {
            @Override
            public void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {
                list1.add(callbackType);
                list2.add(result);
            }

            @Override
            public void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {
                list3.add(results);
            }

            /** @noinspection EmptyMethod*/
            @Override
            public void onScanFailed(int errorCode) {

            }
        }, null).build();
        callback.onBatchScanResults(Collections.singletonList(scanResult));

        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
        assertEquals(1, list3.size());
        assertEquals(1, list3.get(0).size());
        assertEquals(scanResult, list3.get(0).get(0));
    }

    @Test
    @RequiresDevice
    public void test_004() {
        byte[] scanRecord = new byte[0];
        Parcel parcel = Parcel.obtain();
        parcel.writeInt(1);
        BLETestUtilsAndroid.MOCK_DEVICE_0.writeToParcel(parcel, 0);
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

        FilteredScanCallback callback = new FilteredScanCallback.Builder(new FilteredScanCallbackInterface() {
            @Override
            public void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {
                list1.add(callbackType);
                list2.add(result);
            }

            @Override
            public void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {
                list3.add(results);
            }

            /** @noinspection EmptyMethod*/
            @Override
            public void onScanFailed(int errorCode) {

            }
        }, null).addFilter(advertisingDataParseResult -> false).build();
        callback.onBatchScanResults(Collections.singletonList(scanResult));

        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
        assertEquals(0, list3.size());
    }

    @Test
    @RequiresDevice
    public void test_005() {
        final int firstValue = 0;
        final int secondValue = 1;
        final AtomicInteger errorCodeValue = new AtomicInteger(firstValue);

        FilteredScanCallback callback = new FilteredScanCallback.Builder(new FilteredScanCallbackInterface() {
            /** @noinspection EmptyMethod*/
            @Override
            public void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {
            }

            /** @noinspection EmptyMethod*/
            @Override
            public void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {
            }

            @Override
            public void onScanFailed(int errorCode) {
                errorCodeValue.set(errorCode);
            }
        }, null).build();
        callback.onScanFailed(secondValue);

        assertEquals(secondValue, errorCodeValue.get());
    }

    @Test
    @RequiresDevice
    public void test_101() {
        int callbackType = 1;
        byte[] scanRecord = new byte[0];
        Parcel parcel = Parcel.obtain();
        parcel.writeInt(1);
        BLETestUtilsAndroid.MOCK_DEVICE_0.writeToParcel(parcel, 0);
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


        FilteredScanCallback callback = new FilteredScanCallback.Builder(new FilteredScanCallbackInterface() {
            /** @noinspection EmptyMethod*/
            @Override
            public void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {

            }

            /** @noinspection EmptyMethod*/
            @Override
            public void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {

            }

            /** @noinspection EmptyMethod*/
            @Override
            public void onScanFailed(int errorCode) {

            }
        }, scanCallback).build();
        callback.onScanResult(callbackType, scanResult);

        assertEquals(1, list1.size());
        assertEquals(1, list2.size());
        assertEquals(0, list3.size());
        assertEquals(callbackType, list1.get(0).intValue());
        assertEquals(scanResult, list2.get(0));
    }

    @Test
    @RequiresDevice
    public void test_102() {
        int callbackType = 1;
        byte[] scanRecord = new byte[0];
        Parcel parcel = Parcel.obtain();
        parcel.writeInt(1);
        BLETestUtilsAndroid.MOCK_DEVICE_0.writeToParcel(parcel, 0);
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

        FilteredScanCallback callback = new FilteredScanCallback.Builder(new FilteredScanCallbackInterface() {
            /** @noinspection EmptyMethod*/
            @Override
            public void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {

            }

            /** @noinspection EmptyMethod*/
            @Override
            public void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {

            }

            /** @noinspection EmptyMethod*/
            @Override
            public void onScanFailed(int errorCode) {

            }
        }, scanCallback).addFilter(advertisingDataParseResult -> false).build();
        callback.onScanResult(callbackType, scanResult);


        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
        assertEquals(0, list3.size());
    }

    @Test
    @RequiresDevice
    public void test_103() {
        byte[] scanRecord = new byte[0];
        Parcel parcel = Parcel.obtain();
        parcel.writeInt(1);
        BLETestUtilsAndroid.MOCK_DEVICE_0.writeToParcel(parcel, 0);
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

        FilteredScanCallback callback = new FilteredScanCallback.Builder(new FilteredScanCallbackInterface() {
            /** @noinspection EmptyMethod*/
            @Override
            public void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {

            }

            /** @noinspection EmptyMethod*/
            @Override
            public void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {

            }

            /** @noinspection EmptyMethod*/
            @Override
            public void onScanFailed(int errorCode) {

            }
        }, scanCallback).build();
        callback.onBatchScanResults(Collections.singletonList(scanResult));

        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
        assertEquals(1, list3.size());
        assertEquals(1, list3.get(0).size());
        assertEquals(scanResult, list3.get(0).get(0));
    }

    @Test
    @RequiresDevice
    public void test_104() {
        byte[] scanRecord = new byte[0];
        Parcel parcel = Parcel.obtain();
        parcel.writeInt(1);
        BLETestUtilsAndroid.MOCK_DEVICE_0.writeToParcel(parcel, 0);
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

        FilteredScanCallback callback = new FilteredScanCallback.Builder(new FilteredScanCallbackInterface() {
            /** @noinspection EmptyMethod*/
            @Override
            public void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {
            }

            /** @noinspection EmptyMethod*/
            @Override
            public void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {
            }

            /** @noinspection EmptyMethod*/
            @Override
            public void onScanFailed(int errorCode) {
            }
        }, scanCallback).addFilter(advertisingDataParseResult -> false).build();
        callback.onBatchScanResults(Collections.singletonList(scanResult));

        assertEquals(0, list1.size());
        assertEquals(0, list2.size());
        assertEquals(0, list3.size());
    }

    @Test
    @RequiresDevice
    public void test_105() {
        final int firstValue = 0;
        final int secondValue = 1;
        final AtomicInteger errorCodeValue = new AtomicInteger(firstValue);
        ScanCallback scanCallback = new ScanCallback() {
            /** @noinspection EmptyMethod*/
            @Override
            public void onScanResult(int callbackType, ScanResult result) {
            }

            /** @noinspection EmptyMethod*/
            @Override
            public void onBatchScanResults(List<ScanResult> results) {
            }

            @Override
            public void onScanFailed(int errorCode) {
                errorCodeValue.set(errorCode);
            }
        };

        FilteredScanCallback callback = new FilteredScanCallback.Builder(new FilteredScanCallbackInterface() {
            /** @noinspection EmptyMethod*/
            @Override
            public void onFilteredScanResult(int callbackType, @NonNull ScanResult result, @NonNull AdvertisingDataParser.AdvertisingDataParseResult parseResult) {
            }

            /** @noinspection EmptyMethod*/
            @Override
            public void onFilteredBatchScanResults(@NonNull List<ScanResult> results, @NonNull List<AdvertisingDataParser.AdvertisingDataParseResult> parseResults) {
            }

            /** @noinspection EmptyMethod*/
            @Override
            public void onScanFailed(int errorCode) {
            }
        }, scanCallback).build();
        callback.onScanFailed(secondValue);

        assertEquals(secondValue, errorCodeValue.get());
    }

}
