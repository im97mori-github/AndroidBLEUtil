package org.im97mori.ble.profile.central.task;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Message;

import org.im97mori.ble.task.AbstractBLETask;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BondTaskTest {

    @Test
    public void test_createInitialMessage_00001() {
        BondTask task = new BondTask(null, null, null, null, null, 0, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_BOND_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createBondSuccessMessage_00001() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        Message message = BondTask.createBondSuccessMessage(bluetoothDevice);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(AbstractBLETask.PROGRESS_BOND_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(bluetoothDevice, bundle.getParcelable(AbstractBLETask.KEY_BLUETOOTH_DEVICE));
    }

    @Test
    public void test_createBondErrorMessage_00001() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        Message message = BondTask.createBondErrorMessage(bluetoothDevice);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(AbstractBLETask.PROGRESS_BOND_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(bluetoothDevice, bundle.getParcelable(AbstractBLETask.KEY_BLUETOOTH_DEVICE));
    }

}
