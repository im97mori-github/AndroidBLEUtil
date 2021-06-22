package org.im97mori.ble.service.aios.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a56.DigitalAndroid;
import org.im97mori.ble.characteristic.u2a58.AnalogAndroid;
import org.im97mori.ble.characteristic.u2a5a.AggregateAndroid;
import org.im97mori.ble.descriptor.u2900.CharacteristicExtendedPropertiesAndroid;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescriptionAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormatAndroid;
import org.im97mori.ble.descriptor.u2906.ValidRangeAndroid;
import org.im97mori.ble.descriptor.u2909.NumberOfDigitalsAndroid;
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
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.NUMBER_OF_DIGITALS_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.TIME_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.VALUE_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.AUTOMATION_IO_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"UnnecessaryLocalVariable", "WrapperTypeMayBePrimitive", "unused"})
public class AutomationIOServiceTest_001 extends AbstractCentralTest {

    @Test
    public void test_onBLEDisconnected_00001() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(AUTOMATION_IO_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DIGITAL_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANALOG_CHARACTERISTIC, 0, 0));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AGGREGATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertEquals(1, automationIOService.getDigitalCount().intValue());
        assertEquals(1, automationIOService.getAnalogCount().intValue());
        assertTrue(automationIOService.isAggregateSupported());
        assertTrue(automationIOService.isAggregateReadable());
        assertTrue(automationIOService.isAggregateNotificatable());

        automationIOService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        Integer count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        assertFalse(automationIOService.isAggregateSupported());
        assertFalse(automationIOService.isAggregateReadable());
        assertFalse(automationIOService.isAggregateNotificatable());
    }

    @Test
    public void test_onBLEDisconnected_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(AUTOMATION_IO_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DIGITAL_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANALOG_CHARACTERISTIC, 0, 0));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AGGREGATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, BluetoothGattCharacteristic.PERMISSION_READ);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(1, count.intValue());
        count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(1, count.intValue());
        assertTrue(automationIOService.isAggregateSupported());
        assertTrue(automationIOService.isAggregateReadable());
        assertTrue(automationIOService.isAggregateIndicatable());

        automationIOService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        assertFalse(automationIOService.isAggregateSupported());
        assertFalse(automationIOService.isAggregateReadable());
        assertFalse(automationIOService.isAggregateIndicatable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00001() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        automationIOService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        Integer count = automationIOService.getDigitalCount();
        assertNull(count);
        count = automationIOService.getAnalogCount();
        assertNull(count);
        assertFalse(automationIOService.isAggregateSupported());
        assertFalse(automationIOService.isAggregateReadable());
        assertFalse(automationIOService.isAggregateNotificatable());
        assertFalse(automationIOService.isAggregateIndicatable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        automationIOService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        Integer count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        assertFalse(automationIOService.isAggregateSupported());
        assertFalse(automationIOService.isAggregateReadable());
        assertFalse(automationIOService.isAggregateNotificatable());
        assertFalse(automationIOService.isAggregateIndicatable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(AUTOMATION_IO_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(DIGITAL_CHARACTERISTIC, 0, 0));
        automationIOService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(1, count.intValue());
        count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        assertFalse(automationIOService.isAggregateSupported());
        assertFalse(automationIOService.isAggregateReadable());
        assertFalse(automationIOService.isAggregateNotificatable());
        assertFalse(automationIOService.isAggregateIndicatable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00004() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(AUTOMATION_IO_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ANALOG_CHARACTERISTIC, 0, 0));
        automationIOService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(1, count.intValue());
        assertFalse(automationIOService.isAggregateSupported());
        assertFalse(automationIOService.isAggregateReadable());
        assertFalse(automationIOService.isAggregateNotificatable());
        assertFalse(automationIOService.isAggregateIndicatable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00005() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(AUTOMATION_IO_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AGGREGATE_CHARACTERISTIC, 0, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        assertTrue(automationIOService.isAggregateSupported());
        assertFalse(automationIOService.isAggregateReadable());
        assertFalse(automationIOService.isAggregateNotificatable());
        assertFalse(automationIOService.isAggregateIndicatable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00006() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(AUTOMATION_IO_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AGGREGATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        assertTrue(automationIOService.isAggregateSupported());
        assertTrue(automationIOService.isAggregateReadable());
        assertFalse(automationIOService.isAggregateNotificatable());
        assertFalse(automationIOService.isAggregateIndicatable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00007() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(AUTOMATION_IO_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AGGREGATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        assertTrue(automationIOService.isAggregateSupported());
        assertTrue(automationIOService.isAggregateReadable());
        assertFalse(automationIOService.isAggregateNotificatable());
        assertFalse(automationIOService.isAggregateIndicatable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00008() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(AUTOMATION_IO_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AGGREGATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        assertTrue(automationIOService.isAggregateSupported());
        assertTrue(automationIOService.isAggregateReadable());
        assertTrue(automationIOService.isAggregateNotificatable());
        assertFalse(automationIOService.isAggregateIndicatable());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00009() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(AUTOMATION_IO_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AGGREGATE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        Integer count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
        assertTrue(automationIOService.isAggregateSupported());
        assertTrue(automationIOService.isAggregateReadable());
        assertFalse(automationIOService.isAggregateNotificatable());
        assertTrue(automationIOService.isAggregateIndicatable());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, digitalAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, digitalAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, digitalAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, digitalAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, analogAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, analogAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, analogAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, analogAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull AggregateAndroid aggregateAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, aggregateAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {
            @Override
            public void onAggregateReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        automationIOService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        automationIOService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, digitalAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, digitalAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, digitalAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, digitalAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteWithNoResponseSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, digitalAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteWithNoResponseSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, digitalAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteWithNoResponseSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, digitalAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteWithNoResponseSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull DigitalAndroid digitalAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, digitalAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, analogAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, analogAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, analogAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, analogAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteWithNoResponseSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, analogAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteWithNoResponseSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertArrayEquals(originalValues, analogAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteWithNoResponseSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertArrayEquals(originalValues, analogAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteWithNoResponseSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull AnalogAndroid analogAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertArrayEquals(originalValues, analogAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteWithNoResponseFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteWithNoResponseFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteWithNoResponseFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteWithNoResponseFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteWithNoResponseFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteWithNoResponseFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteWithNoResponseFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteWithNoResponseFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteWithNoResponseTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteWithNoResponseTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteWithNoResponseTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalWriteWithNoResponseTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteWithNoResponseTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteWithNoResponseTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteWithNoResponseTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt(AutomationIOService.KEY_WRITE_TYPE, BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogWriteWithNoResponseTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00001() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00002() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00003() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00004() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicPresentationFormatReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicPresentationFormatAndroid characteristicPresentationFormatAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicPresentationFormatAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicPresentationFormatReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicPresentationFormatAndroid characteristicPresentationFormatAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicPresentationFormatAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicPresentationFormatReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicPresentationFormatAndroid characteristicPresentationFormatAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicPresentationFormatAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicPresentationFormatReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicPresentationFormatAndroid characteristicPresentationFormatAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicPresentationFormatAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00201() {
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
            public void onDigitalCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00202() {
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
            public void onDigitalCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00203() {
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
            public void onDigitalCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00204() {
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
            public void onDigitalCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicExtendedPropertiesReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicExtendedPropertiesAndroid characteristicExtendedPropertiesAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicExtendedPropertiesAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicExtendedPropertiesReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicExtendedPropertiesAndroid characteristicExtendedPropertiesAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicExtendedPropertiesAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicExtendedPropertiesReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicExtendedPropertiesAndroid characteristicExtendedPropertiesAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicExtendedPropertiesAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicExtendedPropertiesReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicExtendedPropertiesAndroid characteristicExtendedPropertiesAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicExtendedPropertiesAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00401() {
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
            public void onDigitalValueTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00402() {
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
            public void onDigitalValueTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00403() {
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
            public void onDigitalValueTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00404() {
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
            public void onDigitalValueTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00502() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00503() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00504() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = NUMBER_OF_DIGITALS_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNumberOfDigitalsReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull NumberOfDigitalsAndroid numberOfDigitalsAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, numberOfDigitalsAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00602() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = NUMBER_OF_DIGITALS_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNumberOfDigitalsReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull NumberOfDigitalsAndroid numberOfDigitalsAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, numberOfDigitalsAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00603() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = NUMBER_OF_DIGITALS_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNumberOfDigitalsReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull NumberOfDigitalsAndroid numberOfDigitalsAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, numberOfDigitalsAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00604() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = NUMBER_OF_DIGITALS_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNumberOfDigitalsReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull NumberOfDigitalsAndroid numberOfDigitalsAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, numberOfDigitalsAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00701() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00702() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00703() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00704() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicPresentationFormatReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, @NonNull CharacteristicPresentationFormatAndroid characteristicPresentationFormatAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicPresentationFormatAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00802() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicPresentationFormatReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, @NonNull CharacteristicPresentationFormatAndroid characteristicPresentationFormatAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicPresentationFormatAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00803() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicPresentationFormatReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, @NonNull CharacteristicPresentationFormatAndroid characteristicPresentationFormatAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicPresentationFormatAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00804() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicPresentationFormatReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, @NonNull CharacteristicPresentationFormatAndroid characteristicPresentationFormatAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicPresentationFormatAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00901() {
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
            public void onAnalogCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00902() {
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
            public void onAnalogCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00903() {
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
            public void onAnalogCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00904() {
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
            public void onAnalogCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicExtendedPropertiesReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, @NonNull CharacteristicExtendedPropertiesAndroid characteristicExtendedPropertiesAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicExtendedPropertiesAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicExtendedPropertiesReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, @NonNull CharacteristicExtendedPropertiesAndroid characteristicExtendedPropertiesAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicExtendedPropertiesAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicExtendedPropertiesReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, @NonNull CharacteristicExtendedPropertiesAndroid characteristicExtendedPropertiesAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicExtendedPropertiesAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicExtendedPropertiesReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, @NonNull CharacteristicExtendedPropertiesAndroid characteristicExtendedPropertiesAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicExtendedPropertiesAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01101() {
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
            public void onAnalogValueTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01102() {
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
            public void onAnalogValueTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01103() {
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
            public void onAnalogValueTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01104() {
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
            public void onAnalogValueTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValueTriggerSettingAndroid valueTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 5};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull TimeTriggerSettingAndroid timeTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, validRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, validRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8};
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0,  Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_01401() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, mockAutomationIOServiceCallback, null);
        automationIOService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00001() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00002() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00003() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00004() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicPresentationFormatReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicPresentationFormatReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicPresentationFormatReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicPresentationFormatReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00201() {
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
            public void onDigitalCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00202() {
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
            public void onDigitalCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00203() {
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
            public void onDigitalCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00204() {
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
            public void onDigitalCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicExtendedPropertiesReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicExtendedPropertiesReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicExtendedPropertiesReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicExtendedPropertiesReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00401() {
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
            public void onDigitalValueTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00402() {
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
            public void onDigitalValueTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00403() {
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
            public void onDigitalValueTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00404() {
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
            public void onDigitalValueTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00501() {
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
            public void onDigitalTimeTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00502() {
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
            public void onDigitalTimeTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00503() {
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
            public void onDigitalTimeTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00504() {
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
            public void onDigitalTimeTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = NUMBER_OF_DIGITALS_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNumberOfDigitalsReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00602() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = NUMBER_OF_DIGITALS_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNumberOfDigitalsReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00603() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = NUMBER_OF_DIGITALS_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNumberOfDigitalsReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00604() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = NUMBER_OF_DIGITALS_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNumberOfDigitalsReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00701() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00702() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00703() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00704() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicPresentationFormatReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00802() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicPresentationFormatReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00803() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicPresentationFormatReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00804() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicPresentationFormatReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00901() {
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
            public void onAnalogCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00902() {
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
            public void onAnalogCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00903() {
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
            public void onAnalogCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00904() {
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
            public void onAnalogCharacteristicUserDescriptionReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicExtendedPropertiesReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicExtendedPropertiesReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicExtendedPropertiesReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicExtendedPropertiesReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01101() {
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
            public void onAnalogValueTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01102() {
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
            public void onAnalogValueTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01103() {
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
            public void onAnalogValueTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01104() {
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
            public void onAnalogValueTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01201() {
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
            public void onAnalogTimeTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01202() {
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
            public void onAnalogTimeTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01203() {
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
            public void onAnalogTimeTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01204() {
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
            public void onAnalogTimeTriggerSettingReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValidRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_01401() {
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
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicPresentationFormatReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicPresentationFormatReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicPresentationFormatReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicPresentationFormatReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicExtendedPropertiesReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicExtendedPropertiesReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicExtendedPropertiesReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalCharacteristicExtendedPropertiesReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalValueTriggerSettingReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00402() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalValueTriggerSettingReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00403() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalValueTriggerSettingReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00404() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalValueTriggerSettingReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00502() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00503() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00504() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalTimeTriggerSettingReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = NUMBER_OF_DIGITALS_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNumberOfDigitalsReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00602() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = NUMBER_OF_DIGITALS_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNumberOfDigitalsReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00603() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = NUMBER_OF_DIGITALS_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNumberOfDigitalsReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00604() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = NUMBER_OF_DIGITALS_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onDigitalNumberOfDigitalsReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00702() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00703() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00704() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicPresentationFormatReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00802() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicPresentationFormatReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00803() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicPresentationFormatReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00804() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicPresentationFormatReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00901() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00902() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00903() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00904() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicUserDescriptionReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicExtendedPropertiesReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicExtendedPropertiesReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicExtendedPropertiesReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogCharacteristicExtendedPropertiesReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValueTriggerSettingReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValueTriggerSettingReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValueTriggerSettingReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValueTriggerSettingReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogTimeTriggerSettingReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01301() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValidRangeReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01302() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValidRangeReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, 0, 0, 0, 0, 0,  Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01303() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValidRangeReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01304() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAnalogValidRangeReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_01401() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockAutomationIOServiceCallback mockAutomationIOServiceCallback = new MockAutomationIOServiceCallback() {

            @Override
            public void onAggregateClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        automationIOService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

}
