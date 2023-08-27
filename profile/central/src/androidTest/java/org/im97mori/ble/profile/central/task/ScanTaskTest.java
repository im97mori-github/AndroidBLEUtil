package org.im97mori.ble.profile.central.task;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;

import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

import org.im97mori.ble.advertising.filter.FilteredLeScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.BLETestUtilsAndroidLolipop;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/** @noinspection DataFlowIssue*/
public class ScanTaskTest extends TestBase {

    @Test
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_createInitialMessage_00001() {
        ScanTask task = new ScanTask(null, null, (FilteredScanCallback) null, null, 0, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(ScanTask.KEY_NEXT_PROGRESS));
        assertEquals(ScanTask.PROGRESS_SCAN_START, bundle.getString(ScanTask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createInitialMessage_00101() {
        ScanTask task = new ScanTask(null, null, (FilteredLeScanCallback) null, null, 0, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(ScanTask.KEY_NEXT_PROGRESS));
        assertEquals(ScanTask.PROGRESS_SCAN_START, bundle.getString(ScanTask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(maxSdkVersion = Build.VERSION_CODES.S_V2)
    @Deprecated
    public void test_createDeviceFoundMessage_32_00001() {
        ScanResult scanResult = BLETestUtilsAndroidLolipop.createScanResult(BLETestUtilsAndroid.MOCK_DEVICE_0, 1, 2, 3, 4, 5, 6, 7, null, 8);
        Message message = ScanTask.createDeviceFoundMessage(scanResult);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(ScanTask.PROGRESS_SCAN_FINISHED, bundle.getString(ScanTask.KEY_NEXT_PROGRESS));
        ArrayList<BluetoothDevice> list = bundle.getParcelableArrayList(ScanTask.KEY_BLUETOOTH_DEVICE);
        assertNotNull(list);
        assertArrayEquals(Collections.singletonList(BLETestUtilsAndroid.MOCK_DEVICE_0).toArray(), list.toArray());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(maxSdkVersion = Build.VERSION_CODES.S_V2)
    @Deprecated
    public void test_createDeviceFoundMessage_32_00002() {
        ScanResult scanResult1 = BLETestUtilsAndroidLolipop.createScanResult(BLETestUtilsAndroid.MOCK_DEVICE_0, 1, 2, 3, 4, 5, 6, 7, null, 8);
        ScanResult scanResult2 = BLETestUtilsAndroidLolipop.createScanResult(BLETestUtilsAndroid.MOCK_DEVICE_1, 11, 22, 33, 44, 55, 66, 77, null, 88);
        Message message = ScanTask.createDeviceFoundMessage(scanResult1, scanResult2);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(ScanTask.PROGRESS_SCAN_FINISHED, bundle.getString(ScanTask.KEY_NEXT_PROGRESS));
        ArrayList<BluetoothDevice> list = bundle.getParcelableArrayList(ScanTask.KEY_BLUETOOTH_DEVICE);
        assertNotNull(list);
        assertArrayEquals(Arrays.asList(BLETestUtilsAndroid.MOCK_DEVICE_0, BLETestUtilsAndroid.MOCK_DEVICE_1).toArray(), list.toArray());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.TIRAMISU)
    public void test_createDeviceFoundMessage_33_00001() {
        ScanResult scanResult = BLETestUtilsAndroidLolipop.createScanResult(BLETestUtilsAndroid.MOCK_DEVICE_0, 1, 2, 3, 4, 5, 6, 7, null, 8);
        Message message = ScanTask.createDeviceFoundMessage(scanResult);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(ScanTask.PROGRESS_SCAN_FINISHED, bundle.getString(ScanTask.KEY_NEXT_PROGRESS));
        ArrayList<BluetoothDevice> list = bundle.getParcelableArrayList(ScanTask.KEY_BLUETOOTH_DEVICE, BluetoothDevice.class);
        assertNotNull(list);
        assertArrayEquals(Collections.singletonList(BLETestUtilsAndroid.MOCK_DEVICE_0).toArray(), list.toArray());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.TIRAMISU)
    public void test_createDeviceFoundMessage_33_00002() {
        ScanResult scanResult1 = BLETestUtilsAndroidLolipop.createScanResult(BLETestUtilsAndroid.MOCK_DEVICE_0, 1, 2, 3, 4, 5, 6, 7, null, 8);
        ScanResult scanResult2 = BLETestUtilsAndroidLolipop.createScanResult(BLETestUtilsAndroid.MOCK_DEVICE_1, 11, 22, 33, 44, 55, 66, 77, null, 88);
        Message message = ScanTask.createDeviceFoundMessage(scanResult1, scanResult2);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(ScanTask.PROGRESS_SCAN_FINISHED, bundle.getString(ScanTask.KEY_NEXT_PROGRESS));
        ArrayList<BluetoothDevice> list = bundle.getParcelableArrayList(ScanTask.KEY_BLUETOOTH_DEVICE, BluetoothDevice.class);
        assertNotNull(list);
        assertArrayEquals(Arrays.asList(BLETestUtilsAndroid.MOCK_DEVICE_0, BLETestUtilsAndroid.MOCK_DEVICE_1).toArray(), list.toArray());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(maxSdkVersion = Build.VERSION_CODES.S_V2)
    @Deprecated
    public void test_createDeviceFoundMessage_32_00101() {
        BluetoothDevice bluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        Message message = ScanTask.createDeviceFoundMessage(bluetoothDevice);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(ScanTask.PROGRESS_SCAN_FINISHED, bundle.getString(ScanTask.KEY_NEXT_PROGRESS));
        ArrayList<BluetoothDevice> list = bundle.getParcelableArrayList(ScanTask.KEY_BLUETOOTH_DEVICE);
        assertNotNull(list);
        assertArrayEquals(Collections.singletonList(bluetoothDevice).toArray(), list.toArray());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(maxSdkVersion = Build.VERSION_CODES.S_V2)
    @Deprecated
    public void test_createDeviceFoundMessage_32_00102() {
        BluetoothDevice bluetoothDevice1 = BLETestUtilsAndroid.MOCK_DEVICE_0;
        BluetoothDevice bluetoothDevice2 = BLETestUtilsAndroid.MOCK_DEVICE_1;
        Message message = ScanTask.createDeviceFoundMessage(Arrays.asList(bluetoothDevice1, bluetoothDevice2));

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(ScanTask.PROGRESS_SCAN_FINISHED, bundle.getString(ScanTask.KEY_NEXT_PROGRESS));
        ArrayList<BluetoothDevice> list = bundle.getParcelableArrayList(ScanTask.KEY_BLUETOOTH_DEVICE);
        assertNotNull(list);
        assertArrayEquals(Arrays.asList(bluetoothDevice1, bluetoothDevice2).toArray(), list.toArray());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.TIRAMISU)
    public void test_createDeviceFoundMessage_33_00101() {
        BluetoothDevice bluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        Message message = ScanTask.createDeviceFoundMessage(bluetoothDevice);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(ScanTask.PROGRESS_SCAN_FINISHED, bundle.getString(ScanTask.KEY_NEXT_PROGRESS));
        ArrayList<BluetoothDevice> list = bundle.getParcelableArrayList(ScanTask.KEY_BLUETOOTH_DEVICE, BluetoothDevice.class);
        assertNotNull(list);
        assertArrayEquals(Collections.singletonList(bluetoothDevice).toArray(), list.toArray());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.TIRAMISU)
    public void test_createDeviceFoundMessage_33_00102() {
        BluetoothDevice bluetoothDevice1 = BLETestUtilsAndroid.MOCK_DEVICE_0;
        BluetoothDevice bluetoothDevice2 = BLETestUtilsAndroid.MOCK_DEVICE_1;
        Message message = ScanTask.createDeviceFoundMessage(Arrays.asList(bluetoothDevice1, bluetoothDevice2));

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(ScanTask.PROGRESS_SCAN_FINISHED, bundle.getString(ScanTask.KEY_NEXT_PROGRESS));
        ArrayList<BluetoothDevice> list = bundle.getParcelableArrayList(ScanTask.KEY_BLUETOOTH_DEVICE, BluetoothDevice.class);
        assertNotNull(list);
        assertArrayEquals(Arrays.asList(bluetoothDevice1, bluetoothDevice2).toArray(), list.toArray());
    }

    @Test
    public void test_createDeviceScanErrorMessage_00001() {
        int status = 1;
        Message message = ScanTask.createDeviceScanErrorMessage(status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(ScanTask.PROGRESS_SCAN_ERROR, bundle.getString(ScanTask.KEY_NEXT_PROGRESS));
        assertEquals(status, bundle.getInt(ScanTask.KEY_STATUS));
    }

}
