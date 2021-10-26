package org.im97mori.ble.service.aios.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.characteristic.u2a56.DigitalAndroid;
import org.im97mori.ble.characteristic.u2a58.AnalogAndroid;
import org.im97mori.ble.characteristic.u2a5a.AggregateAndroid;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescriptionAndroid;
import org.im97mori.ble.descriptor.u290a.ValueTriggerSetting;
import org.im97mori.ble.descriptor.u290a.ValueTriggerSettingAndroid;
import org.im97mori.ble.descriptor.u290e.TimeTriggerSetting;
import org.im97mori.ble.descriptor.u290e.TimeTriggerSettingAndroid;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.CharacteristicUUID.AGGREGATE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ANALOG_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DIGITAL_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.TIME_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.VALUE_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.AUTOMATION_IO_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"UnnecessaryLocalVariable", "WrapperTypeMayBePrimitive", "unused"})
public class AutomationIOServiceTest_002 extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00305() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00402() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = "a".getBytes();
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00403() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = "a".getBytes();
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{ValueTriggerSetting.NONE_7};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalValueTriggerSettingWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, valueTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00502() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{ValueTriggerSetting.NONE_7};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalValueTriggerSettingWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, valueTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00503() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{ValueTriggerSetting.NONE_7};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalValueTriggerSettingWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, valueTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 4};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, timeTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00602() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 4};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, timeTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00603() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 4};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, timeTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00702() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00703() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00704() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00705() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00802() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00803() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00804() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00805() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00902() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00903() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00904() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00905() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = "a".getBytes();
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = "a".getBytes();
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = "a".getBytes();
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicUserDescriptionWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{ValueTriggerSetting.NONE_7};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValueTriggerSettingWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, valueTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{ValueTriggerSetting.NONE_7};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValueTriggerSettingWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, valueTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{ValueTriggerSetting.NONE_7};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValueTriggerSettingWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, valueTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 4};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, timeTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 4};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, timeTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 4};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, timeTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01402() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01403() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01404() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01405() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
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
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01502() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01503() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01504() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01505() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
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
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01602() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01603() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01604() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01605() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
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
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01702() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01703() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01704() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_01705() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00305() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00402() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00403() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalValueTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00502() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalValueTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00503() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalValueTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00602() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00603() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00702() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00703() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00704() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00705() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00802() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00803() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00804() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00805() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00902() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00903() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00904() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00905() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValueTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValueTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValueTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01402() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01403() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01404() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01405() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01502() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01503() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01504() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01505() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01602() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01603() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01604() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01605() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01702() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01703() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01704() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_01705() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00305() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00402() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00403() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalValueTriggerSettingWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00502() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalValueTriggerSettingWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00503() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalValueTriggerSettingWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00602() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00603() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00702() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00703() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00704() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00705() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00802() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00803() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00804() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00805() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00902() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00903() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00904() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00905() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicUserDescriptionWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValueTriggerSettingWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValueTriggerSettingWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValueTriggerSettingWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01402() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01403() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01404() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01405() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01502() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01503() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01504() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01505() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01602() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01603() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01604() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01605() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01702() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01703() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01704() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_01705() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertArrayEquals(originalValues, digitalAndroid.getBytes());
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertArrayEquals(originalValues, digitalAndroid.getBytes());
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertArrayEquals(originalValues, digitalAndroid.getBytes());
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertArrayEquals(originalValues, digitalAndroid.getBytes());
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertArrayEquals(originalValues, analogAndroid.getBytes());
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertArrayEquals(originalValues, analogAndroid.getBytes());
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((0), index.intValue());
                assertArrayEquals(originalValues, analogAndroid.getBytes());
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00305() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals((1), index.intValue());
                assertArrayEquals(originalValues, analogAndroid.getBytes());
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AggregateAndroid aggregateAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00402() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AggregateAndroid aggregateAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00403() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AggregateAndroid aggregateAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00404() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AggregateAndroid aggregateAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00405() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AggregateAndroid aggregateAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, aggregateAndroid.getBytes());
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AggregateAndroid aggregateAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00502() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AggregateAndroid aggregateAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00503() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AggregateAndroid aggregateAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00504() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AggregateAndroid aggregateAndroid) {
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00505() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};

        MOCK_BLE_CONNECTION.setConnected(true);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AggregateAndroid aggregateAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, aggregateAndroid.getBytes());
                isCalled.set(true);
            }

        };

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);
        assertTrue(isCalled.get());
    }

}
