package org.im97mori.ble.service.ans.central;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.characteristic.u2a44.AlertNotificationControlPoint;
import org.im97mori.ble.characteristic.u2a44.AlertNotificationControlPointAndroid;
import org.im97mori.ble.characteristic.u2a45.UnreadAlertStatus;
import org.im97mori.ble.characteristic.u2a45.UnreadAlertStatusAndroid;
import org.im97mori.ble.characteristic.u2a46.NewAlert;
import org.im97mori.ble.characteristic.u2a46.NewAlertAndroid;
import org.im97mori.ble.characteristic.u2a47.SupportedNewAlertCategoryAndroid;
import org.im97mori.ble.characteristic.u2a48.SupportedUnreadAlertCategoryAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.service.ans.AlertNotificationCategoryIdUtils;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.NEW_ALERT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.UNREAD_ALERT_STATUS_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.ALERT_NOTIFICATION_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("UnnecessaryLocalVariable")
public class AlertNotificationServiceTest {

    @Test
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{0};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onSupportedNewAlertCategoryReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SupportedNewAlertCategoryAndroid supportedNewAlertCategoryAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, supportedNewAlertCategoryAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{0};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onSupportedUnreadAlertCategoryReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SupportedUnreadAlertCategoryAndroid supportedUnreadAlertCategoryAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, supportedUnreadAlertCategoryAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onSupportedNewAlertCategoryReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onSupportedUnreadAlertCategoryReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onSupportedNewAlertCategoryReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onSupportedUnreadAlertCategoryReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION, AlertNotificationCategoryIdUtils.CATEGORY_ID_ALL).getBytes();
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onAlertNotificationControlPointWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AlertNotificationControlPointAndroid alertNotificationControlPointAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, alertNotificationControlPointAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onAlertNotificationControlPointWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onAlertNotificationControlPointWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = NEW_ALERT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onNewAlertClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UNREAD_ALERT_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onUnreadAlertStatusClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = NEW_ALERT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onNewAlertClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UNREAD_ALERT_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onUnreadAlertStatusClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = NEW_ALERT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onNewAlertClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UNREAD_ALERT_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onUnreadAlertStatusClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = NEW_ALERT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onNewAlertNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UNREAD_ALERT_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onUnreadAlertStatusNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = NEW_ALERT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onNewAlertNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UNREAD_ALERT_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onUnreadAlertStatusNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = NEW_ALERT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onNewAlertNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UNREAD_ALERT_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onUnreadAlertStatusNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = NEW_ALERT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onNewAlertNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UNREAD_ALERT_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onUnreadAlertStatusNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = NEW_ALERT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onNewAlertNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UNREAD_ALERT_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onUnreadAlertStatusNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = NEW_ALERT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onNewAlertNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UNREAD_ALERT_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onUnreadAlertStatusNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = NEW_ALERT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        final byte[] originalValues = new NewAlert(AlertNotificationCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT, 0, "a").getBytes();

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onNewAlertNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull NewAlertAndroid newAlertAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, newAlertAndroid.getBytes());
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = ALERT_NOTIFICATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = UNREAD_ALERT_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        final byte[] originalValues = new UnreadAlertStatus(AlertNotificationCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT, 0).getBytes();

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockAlertNotificationServiceCallback mockAlertNotificationServiceCallback = new MockAlertNotificationServiceCallback() {

            @Override
            public void onUnreadAlertStatusNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UnreadAlertStatusAndroid unreadAlertStatusAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, unreadAlertStatusAndroid.getBytes());
                isCalled.set(true);
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, mockAlertNotificationServiceCallback, null);
        alertNotificationService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_getSupportedNewAlertCategory_000001() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null);

        assertNull(alertNotificationService.getSupportedNewAlertCategory());
    }

    @Test
    public void test_getSupportedNewAlertCategory_000002() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(alertNotificationService.getSupportedNewAlertCategory());
    }

    @Test
    public void test_getSupportedNewAlertCategory_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = alertNotificationService.getSupportedNewAlertCategory();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getNewAlertClientCharacteristicConfiguration_00001() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null);

        assertNull(alertNotificationService.getNewAlertClientCharacteristicConfiguration());
    }

    @Test
    public void test_getNewAlertClientCharacteristicConfiguration_00002() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(alertNotificationService.getNewAlertClientCharacteristicConfiguration());
    }

    @Test
    public void test_getNewAlertClientCharacteristicConfiguration_00003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = alertNotificationService.getNewAlertClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startNewAlertNotification_00001() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null);

        assertNull(alertNotificationService.startNewAlertNotification());
    }

    @Test
    public void test_startNewAlertNotification_00002() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(alertNotificationService.startNewAlertNotification());
    }

    @Test
    public void test_startNewAlertNotification_00003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = alertNotificationService.startNewAlertNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopNewAlertNotification_00001() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null);

        assertNull(alertNotificationService.stopNewAlertNotification());
    }

    @Test
    public void test_stopNewAlertNotification_00002() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(alertNotificationService.stopNewAlertNotification());
    }

    @Test
    public void test_stopNewAlertNotification_00003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = alertNotificationService.stopNewAlertNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getSupportedUnreadAlertCategory_000001() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null);

        assertNull(alertNotificationService.getSupportedUnreadAlertCategory());
    }

    @Test
    public void test_getSupportedUnreadAlertCategory_000002() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(alertNotificationService.getSupportedUnreadAlertCategory());
    }

    @Test
    public void test_getSupportedUnreadAlertCategory_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = alertNotificationService.getSupportedUnreadAlertCategory();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getUnreadAlertStatusClientCharacteristicConfiguration_00001() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null);

        assertNull(alertNotificationService.getUnreadAlertStatusClientCharacteristicConfiguration());
    }

    @Test
    public void test_getUnreadAlertStatusClientCharacteristicConfiguration_00002() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(alertNotificationService.getUnreadAlertStatusClientCharacteristicConfiguration());
    }

    @Test
    public void test_getUnreadAlertStatusClientCharacteristicConfiguration_00003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = alertNotificationService.getUnreadAlertStatusClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startUnreadAlertStatusNotification_00001() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null);

        assertNull(alertNotificationService.startUnreadAlertStatusNotification());
    }

    @Test
    public void test_startUnreadAlertStatusNotification_00002() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(alertNotificationService.startUnreadAlertStatusNotification());
    }

    @Test
    public void test_startUnreadAlertStatusNotification_00003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = alertNotificationService.startUnreadAlertStatusNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopUnreadAlertStatusNotification_00001() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null);

        assertNull(alertNotificationService.stopUnreadAlertStatusNotification());
    }

    @Test
    public void test_stopUnreadAlertStatusNotification_00002() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(alertNotificationService.stopUnreadAlertStatusNotification());
    }

    @Test
    public void test_stopUnreadAlertStatusNotification_00003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = alertNotificationService.stopUnreadAlertStatusNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setAlertNotificationControlPoint_00001() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null);
        AlertNotificationControlPoint alertNotificationControlPoint = new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION, AlertNotificationCategoryIdUtils.CATEGORY_ID_ALL);

        assertNull(alertNotificationService.setAlertNotificationControlPoint(alertNotificationControlPoint));
    }

    @Test
    public void test_setAlertNotificationControlPoint_00002() {
        AlertNotificationService alertNotificationService = new AlertNotificationService(new MockBLEConnection(), new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AlertNotificationControlPoint alertNotificationControlPoint = new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION, AlertNotificationCategoryIdUtils.CATEGORY_ID_ALL);

        assertNull(alertNotificationService.setAlertNotificationControlPoint(alertNotificationControlPoint));
    }

    @Test
    public void test_setAlertNotificationControlPoint_00003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        AlertNotificationService alertNotificationService = new AlertNotificationService(mockBLEConnection, new MockAlertNotificationServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        AlertNotificationControlPoint alertNotificationControlPoint = new AlertNotificationControlPoint(AlertNotificationControlPoint.COMMAND_ID_ENABLE_NEW_IMCOMING_ALERT_NOTIFICATION, AlertNotificationCategoryIdUtils.CATEGORY_ID_ALL);

        Integer taskId = alertNotificationService.setAlertNotificationControlPoint(alertNotificationControlPoint);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

}
