package org.im97mori.ble.profile.central.task;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.os.Bundle;
import android.os.Message;

import org.im97mori.ble.task.AbstractBLETask;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ScanTaskTest {

    @SuppressWarnings("ConstantConditions")
    @Test
    public void test_createInitialMessage_00001() {
        ScanTask task = new ScanTask(null, null, null, 0, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_SCAN_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createDeviceFoundMessage_00001() {
        ScanResult scanResult = BLETestUtilsAndroid.createScanResult(BLETestUtilsAndroid.MOCK_DEVICE_0, 1, 2, 3, 4, 5, 6, 7, null, 8);
        Message message = ScanTask.createDeviceFoundMessage(scanResult);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(AbstractBLETask.PROGRESS_SCAN_FINISHED, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        ArrayList<BluetoothDevice> list = bundle.getParcelableArrayList(AbstractBLETask.KEY_BLUETOOTH_DEVICE);
        assertNotNull(list);
        assertArrayEquals(Collections.singletonList(scanResult).toArray(), list.toArray());
    }

    @Test
    public void test_createDeviceFoundMessage_00002() {
        ScanResult scanResult1 = BLETestUtilsAndroid.createScanResult(BLETestUtilsAndroid.MOCK_DEVICE_0, 1, 2, 3, 4, 5, 6, 7, null, 8);
        ScanResult scanResult2 = BLETestUtilsAndroid.createScanResult(BLETestUtilsAndroid.MOCK_DEVICE_1, 11, 22, 33, 44, 55, 66, 77, null, 88);
        Message message = ScanTask.createDeviceFoundMessage(scanResult1, scanResult2);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(AbstractBLETask.PROGRESS_SCAN_FINISHED, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        ArrayList<BluetoothDevice> list = bundle.getParcelableArrayList(AbstractBLETask.KEY_BLUETOOTH_DEVICE);
        assertNotNull(list);
        assertArrayEquals(Arrays.asList(scanResult1, scanResult2).toArray(), list.toArray());
    }

    @Test
    public void test_createDeviceScanErrorMessage_00001() {
        int status = 1;
        Message message = ScanTask.createDeviceScanErrorMessage(status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(AbstractBLETask.PROGRESS_SCAN_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(status, bundle.getInt(AbstractBLETask.KEY_STATUS));
    }

}
