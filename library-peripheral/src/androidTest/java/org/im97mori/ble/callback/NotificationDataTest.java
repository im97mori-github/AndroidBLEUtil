package org.im97mori.ble.callback;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class NotificationDataTest {

    @Test
    public void test_constructor_00001() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;
        NotificationData notificationData = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);

        assertEquals(bluetoothDevice, notificationData.bluetoothDevice);
        assertEquals(serviceUUID, notificationData.serviceUUID);
        assertEquals(serviceInstanceId, notificationData.serviceInstanceId);
        assertEquals(characteristicUUID, notificationData.characteristicUUID);
        assertEquals(characteristicInstanceId, notificationData.characteristicInstanceId);
    }

    @Test
    public void test_hashCode_00001() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;

        NotificationData notificationData = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
        assertEquals(bluetoothDevice.hashCode()
                        ^ serviceUUID.hashCode()
                        ^ Integer.hashCode(serviceInstanceId)
                        ^ characteristicUUID.hashCode()
                        ^ Integer.hashCode(characteristicInstanceId)
                , notificationData.hashCode());
    }

    @Test
    public void test_equals_00001() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;

        NotificationData result1 = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
        NotificationData result2 = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;

        NotificationData result1 = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
        NotificationData result2 = new NotificationData(bluetoothAdapter.getRemoteDevice("00:11:22:33:AA:CC"), serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;

        NotificationData result1 = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
        NotificationData result2 = new NotificationData(bluetoothDevice, UUID.fromString("00000000-0000-0000-0000-000000000002"), serviceInstanceId, characteristicUUID, characteristicInstanceId);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;

        NotificationData result1 = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
        NotificationData result2 = new NotificationData(bluetoothDevice, serviceUUID, 11, characteristicUUID, characteristicInstanceId);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;

        NotificationData result1 = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
        NotificationData result2 = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, UUID.fromString("00000000-0000-0000-0000-000000000003"), characteristicInstanceId);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;

        NotificationData result1 = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
        NotificationData result2 = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, 22);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00007() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;

        NotificationData result1 = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);

        assertNotEquals(result1, null);
    }

}
