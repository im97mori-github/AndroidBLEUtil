package org.im97mori.ble.service.ans.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

import org.im97mori.ble.characteristic.u2a47.SupportedNewAlertCategory;
import org.im97mori.ble.characteristic.u2a48.SupportedUnreadAlertCategory;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.NEW_ALERT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.UNREAD_ALERT_STATUS_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.ALERT_NOTIFICATION_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AlertNotificationServiceMockCallbackBuilderTest extends AbstractPeripherallTest {

    @Test
    public void test_exception_00001() {
        Exception exception = null;
        try {
            new AlertNotificationServiceMockCallback.Builder<>().build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Supported New Alert Category data", exception.getMessage());
    }

    @Test
    public void test_exception_00002() {
        Exception exception = null;
        try {
            new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0, false, 0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no New Alert data", exception.getMessage());
    }

    @Test
    public void test_exception_00003() {
        Exception exception = null;
        try {
            new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0, false, 0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Supported Unread Alert Category data", exception.getMessage());
    }

    @Test
    public void test_exception_00004() {
        Exception exception = null;
        try {
            new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0, false, 0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0, false, 0))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Unread Alert Status data", exception.getMessage());
    }

    @Test
    public void test_exception_00005() {
        Exception exception = null;
        try {
            new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0, false, 0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0, false, 0))
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Alert Notification Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00006() {
        Exception exception = null;
        try {
            new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0, false, 0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0, false, 0))
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addAlertNotificationControlPoint(BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addSupportedNewAlertCategory_00001() {
        SupportedNewAlertCategory supportedNewAlertCategory = new SupportedNewAlertCategory(0, false, 0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AlertNotificationServiceMockCallback callback = new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(supportedNewAlertCategory)
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0, false, 0))
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addAlertNotificationControlPoint(BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(ALERT_NOTIFICATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedNewAlertCategory.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSupportedNewAlertCategory_00101() {
        SupportedNewAlertCategory supportedNewAlertCategory = new SupportedNewAlertCategory(0, false, 0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AlertNotificationServiceMockCallback callback = new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(supportedNewAlertCategory.getBytes())
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0, false, 0))
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addAlertNotificationControlPoint(BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(ALERT_NOTIFICATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedNewAlertCategory.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSupportedNewAlertCategory_00201() {
        SupportedNewAlertCategory supportedNewAlertCategory = new SupportedNewAlertCategory(0, false, 0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AlertNotificationServiceMockCallback callback = new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(BluetoothGatt.GATT_SUCCESS, 0, supportedNewAlertCategory.getBytes())
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0, false, 0))
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addAlertNotificationControlPoint(BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(ALERT_NOTIFICATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedNewAlertCategory.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeSupportedNewAlertCategory_00001() {
        Exception exception = null;
        try {
            new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0, false, 0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0, false, 0))
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addAlertNotificationControlPoint(BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .removeSupportedNewAlertCategory()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Supported New Alert Category data", exception.getMessage());
    }

    @Test
    public void test_addNewAlert_00001() {
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AlertNotificationServiceMockCallback callback = new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0, false, 0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , clientCharacteristicConfiguration.getBytes())
                    .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0, false, 0))
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addAlertNotificationControlPoint(BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(ALERT_NOTIFICATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NEW_ALERT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(NEW_ALERT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(null, bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeNewAlert_00001() {
        Exception exception = null;
        try {
            new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0, false, 0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0, false, 0))
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addAlertNotificationControlPoint(BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .removeNewAlert()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no New Alert data", exception.getMessage());
    }

    @Test
    public void test_addSupportedUnreadAlertCategory_00001() {
        SupportedUnreadAlertCategory supportedUnreadAlertCategory = new SupportedUnreadAlertCategory(0, false, 0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AlertNotificationServiceMockCallback callback = new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0, false, 0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(supportedUnreadAlertCategory)
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addAlertNotificationControlPoint(BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(ALERT_NOTIFICATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedUnreadAlertCategory.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSupportedUnreadAlertCategory_00101() {
        SupportedUnreadAlertCategory supportedUnreadAlertCategory = new SupportedUnreadAlertCategory(0, false, 0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AlertNotificationServiceMockCallback callback = new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0, false, 0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(supportedUnreadAlertCategory.getBytes())
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addAlertNotificationControlPoint(BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(ALERT_NOTIFICATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedUnreadAlertCategory.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSupportedUnreadAlertCategory_00201() {
        SupportedUnreadAlertCategory supportedUnreadAlertCategory = new SupportedUnreadAlertCategory(0, false, 0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AlertNotificationServiceMockCallback callback = new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0, false, 0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(BluetoothGatt.GATT_SUCCESS, 0, supportedUnreadAlertCategory.getBytes())
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addAlertNotificationControlPoint(BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(ALERT_NOTIFICATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedUnreadAlertCategory.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeSupportedUnreadAlertCategory_00001() {
        Exception exception = null;
        try {
            new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0, false, 0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0, false, 0))
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addAlertNotificationControlPoint(BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .removeSupportedUnreadAlertCategory()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Supported Unread Alert Category data", exception.getMessage());
    }

    @Test
    public void test_addUnreadAlertStatus_00001() {
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AlertNotificationServiceMockCallback callback = new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0, false, 0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0, false, 0))
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , clientCharacteristicConfiguration.getBytes())
                    .addAlertNotificationControlPoint(BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(ALERT_NOTIFICATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(UNREAD_ALERT_STATUS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(UNREAD_ALERT_STATUS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(null, bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeUnreadAlertStatus_00001() {
        Exception exception = null;
        try {
            new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0, false, 0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0, false, 0))
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addAlertNotificationControlPoint(BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .removeUnreadAlertStatus()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Unread Alert Status data", exception.getMessage());
    }

    @Test
    public void test_addAlertNotificationControlPoint_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            AlertNotificationServiceMockCallback callback = new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0, false, 0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0, false, 0))
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addAlertNotificationControlPoint(BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(ALERT_NOTIFICATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(null, bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeAlertNotificationControlPoint_00001() {
        Exception exception = null;
        try {
            new AlertNotificationServiceMockCallback.Builder<>()
                    .addSupportedNewAlertCategory(new SupportedNewAlertCategory(0, false, 0))
                    .addNewAlert(0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , ""
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addSupportedUnreadAlertCategory(new SupportedUnreadAlertCategory(0, false, 0))
                    .addUnreadAlertStatus(0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .addAlertNotificationControlPoint(BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , BluetoothGatt.GATT_SUCCESS
                            , 0)
                    .removeAlertNotificationControlPoint()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Alert Notification Control Point data", exception.getMessage());
    }

}
