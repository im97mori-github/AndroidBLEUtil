package org.im97mori.ble.profile.wsp.peripheral;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import org.im97mori.ble.MockData;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class WspUserDataServiceMockCallbackTest {

    @Test
    public void test_hasNoConsent_00001() {
        WspUserDataServiceMockCallback wspUserDataServiceMockCallback = new WspUserDataServiceMockCallback(new MockData(), false);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        assertTrue(wspUserDataServiceMockCallback.hasNoConsent(bluetoothDevice, null));
    }

    @Test
    public void test_hasNoConsent_00002() {
        WspUserDataServiceMockCallback wspUserDataServiceMockCallback = new WspUserDataServiceMockCallback(new MockData(), false);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        Integer userIndex = 1;
        assertTrue(wspUserDataServiceMockCallback.hasNoConsent(bluetoothDevice, userIndex));
    }

    @Test
    public void test_hasNoConsent_00003() {
        ConsentTestWspUserDataServiceMockCallback wspUserDataServiceMockCallback = new ConsentTestWspUserDataServiceMockCallback(new MockData(), false);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        Integer userIndex = 1;
        wspUserDataServiceMockCallback.setConsent(bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:CC"), 2);
        assertTrue(wspUserDataServiceMockCallback.hasNoConsent(bluetoothDevice, userIndex));
    }

    @Test
    public void test_hasNoConsent_00004() {
        ConsentTestWspUserDataServiceMockCallback wspUserDataServiceMockCallback = new ConsentTestWspUserDataServiceMockCallback(new MockData(), false);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        Integer userIndex = 1;
        wspUserDataServiceMockCallback.setConsent(bluetoothDevice, 2);
        assertTrue(wspUserDataServiceMockCallback.hasNoConsent(bluetoothDevice, userIndex));
    }

    @Test
    public void test_hasNoConsent_00005() {
        ConsentTestWspUserDataServiceMockCallback wspUserDataServiceMockCallback = new ConsentTestWspUserDataServiceMockCallback(new MockData(), false);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        Integer userIndex = 1;
        wspUserDataServiceMockCallback.setConsent(bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:CC"), userIndex);
        assertTrue(wspUserDataServiceMockCallback.hasNoConsent(bluetoothDevice, userIndex));
    }

    @Test
    public void test_hasNoConsent_00006() {
        ConsentTestWspUserDataServiceMockCallback wspUserDataServiceMockCallback = new ConsentTestWspUserDataServiceMockCallback(new MockData(), false);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:BB");
        Integer userIndex = 1;
        wspUserDataServiceMockCallback.setConsent(bluetoothDevice, userIndex);
        assertFalse(wspUserDataServiceMockCallback.hasNoConsent(bluetoothDevice, userIndex));
    }

}
