package org.im97mori.ble.callback;

import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import androidx.test.filters.RequiresDevice;

public class NotificationDataTest {

    @Test
    @RequiresDevice
    public void test_constructor_00001() {
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;
        NotificationData notificationData = new NotificationData(BLETestUtilsAndroid.MOCK_DEVICE_0, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);

        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0, notificationData.bluetoothDevice);
        assertEquals(serviceUUID, notificationData.serviceUUID);
        assertEquals(serviceInstanceId, notificationData.serviceInstanceId);
        assertEquals(characteristicUUID, notificationData.characteristicUUID);
        assertEquals(characteristicInstanceId, notificationData.characteristicInstanceId);
    }

    @Test
    @RequiresDevice
    public void test_hashCode_00001() {
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;

        NotificationData notificationData = new NotificationData(BLETestUtilsAndroid.MOCK_DEVICE_0, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0.hashCode()
                        ^ serviceUUID.hashCode()
                        ^ Integer.hashCode(serviceInstanceId)
                        ^ characteristicUUID.hashCode()
                        ^ Integer.hashCode(characteristicInstanceId)
                , notificationData.hashCode());
    }

    @Test
    @RequiresDevice
    public void test_equals_00001() {
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;

        NotificationData result1 = new NotificationData(BLETestUtilsAndroid.MOCK_DEVICE_0, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
        NotificationData result2 = new NotificationData(BLETestUtilsAndroid.MOCK_DEVICE_0, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);

        assertEquals(result1, result2);
    }

    @Test
    @RequiresDevice
    public void test_equals_00002() {
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;

        NotificationData result1 = new NotificationData(BLETestUtilsAndroid.MOCK_DEVICE_0, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
        NotificationData result2 = new NotificationData(BLETestUtilsAndroid.MOCK_DEVICE_1, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);

        assertNotEquals(result1, result2);
    }

    @Test
    @RequiresDevice
    public void test_equals_00003() {
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;

        NotificationData result1 = new NotificationData(BLETestUtilsAndroid.MOCK_DEVICE_0, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
        NotificationData result2 = new NotificationData(BLETestUtilsAndroid.MOCK_DEVICE_0, UUID.fromString("00000000-0000-0000-0000-000000000002"), serviceInstanceId, characteristicUUID, characteristicInstanceId);

        assertNotEquals(result1, result2);
    }

    @Test
    @RequiresDevice
    public void test_equals_00004() {
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;

        NotificationData result1 = new NotificationData(BLETestUtilsAndroid.MOCK_DEVICE_0, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
        NotificationData result2 = new NotificationData(BLETestUtilsAndroid.MOCK_DEVICE_0, serviceUUID, 11, characteristicUUID, characteristicInstanceId);

        assertNotEquals(result1, result2);
    }

    @Test
    @RequiresDevice
    public void test_equals_00005() {
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;

        NotificationData result1 = new NotificationData(BLETestUtilsAndroid.MOCK_DEVICE_0, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
        NotificationData result2 = new NotificationData(BLETestUtilsAndroid.MOCK_DEVICE_0, serviceUUID, serviceInstanceId, UUID.fromString("00000000-0000-0000-0000-000000000003"), characteristicInstanceId);

        assertNotEquals(result1, result2);
    }

    @Test
    @RequiresDevice
    public void test_equals_00006() {
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;

        NotificationData result1 = new NotificationData(BLETestUtilsAndroid.MOCK_DEVICE_0, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
        NotificationData result2 = new NotificationData(BLETestUtilsAndroid.MOCK_DEVICE_0, serviceUUID, serviceInstanceId, characteristicUUID, 22);

        assertNotEquals(result1, result2);
    }

    @Test
    @RequiresDevice
    public void test_equals_00007() {
        UUID serviceUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        int characteristicInstanceId = 2;

        NotificationData result1 = new NotificationData(BLETestUtilsAndroid.MOCK_DEVICE_0, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);

        assertNotEquals(result1, null);
    }

}
