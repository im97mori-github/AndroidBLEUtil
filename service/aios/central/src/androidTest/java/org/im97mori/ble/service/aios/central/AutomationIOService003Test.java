package org.im97mori.ble.service.aios.central;

import static org.im97mori.ble.constants.CharacteristicUUID.AGGREGATE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ANALOG_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DIGITAL_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.TIME_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.VALUE_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.AUTOMATION_IO_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.characteristic.u2a56.Digital;
import org.im97mori.ble.characteristic.u2a58.Analog;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u290a.ValueTriggerSetting;
import org.im97mori.ble.descriptor.u290e.TimeTriggerSetting;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @noinspection DataFlowIssue, SameReturnValue
 */
@SuppressWarnings({"WrapperTypeMayBePrimitive", "UnnecessaryLocalVariable"})
public class AutomationIOService003Test extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_getDigitalCount_00001() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertNull(automationIOService.getDigitalCount());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCount_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        Integer count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCount_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        Integer count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(1, count.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCount_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        Integer count = automationIOService.getDigitalCount();
        assertNotNull(count);
        assertEquals(2, count.intValue());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalReadable_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalReadable());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalReadable_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalReadable());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalReadable_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalReadable());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalReadable_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalReadable());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalReadable_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalReadable(1));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalReadable_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalReadable(originalCharacteristicInstanceId));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalReadable_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalReadable(1));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalReadable_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalReadable(1));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalWritable_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalWritable());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalWritable_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalWritable());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalWritable_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalWritable());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalWritable_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalWritable());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalWritable_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalWritable_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalWritable_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalWritable_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalWritableWithNoResponse_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalWritableWithNoResponse());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalWritableWithNoResponse_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalWritableWithNoResponse());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalWritableWithNoResponse_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalWritableWithNoResponse());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalWritableWithNoResponse_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalWritableWithNoResponse());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalWritableWithNoResponse_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalWritableWithNoResponse(1));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalWritableWithNoResponse_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalWritableWithNoResponse(1));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalWritableWithNoResponse_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalWritableWithNoResponse(1));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalWritableWithNoResponse_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isDigitalWritableWithNoResponse(1));
    }

    @Test
    @RequiresDevice
    public void test_canDigitalNotify_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.canDigitalNotify());
    }

    @Test
    @RequiresDevice
    public void test_canDigitalNotify_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.canDigitalNotify());
    }

    @Test
    @RequiresDevice
    public void test_canDigitalNotify_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.canDigitalNotify());
    }

    @Test
    @RequiresDevice
    public void test_canDigitalNotify_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.canDigitalNotify());
    }

    @Test
    @RequiresDevice
    public void test_canDigitalNotify_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.canDigitalNotify(1));
    }

    @Test
    @RequiresDevice
    public void test_canDigitalNotify_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.canDigitalNotify(1));
    }

    @Test
    @RequiresDevice
    public void test_canDigitalNotify_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.canDigitalNotify(1));
    }

    @Test
    @RequiresDevice
    public void test_canDigitalIndicate_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.canDigitalIndicate());
    }

    @Test
    @RequiresDevice
    public void test_canDigitalIndicate_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.canDigitalIndicate());
    }

    @Test
    @RequiresDevice
    public void test_canDigitalIndicate_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.canDigitalIndicate());
    }

    @Test
    @RequiresDevice
    public void test_canDigitalIndicate_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.canDigitalIndicate());
    }

    @Test
    @RequiresDevice
    public void test_canDigitalIndicate_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.canDigitalIndicate(1));
    }

    @Test
    @RequiresDevice
    public void test_canDigitalIndicate_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.canDigitalIndicate(1));
    }

    @Test
    @RequiresDevice
    public void test_canDigitalIndicate_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.canDigitalIndicate(1));
    }

    @Test
    @RequiresDevice
    public void test_canDigitalIndicate_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.canDigitalIndicate(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicPresentationFormat_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalCharacteristicPresentationFormat());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicPresentationFormat_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicPresentationFormat());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicPresentationFormat_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalCharacteristicPresentationFormat());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicPresentationFormat_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicPresentationFormat());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicPresentationFormat_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalCharacteristicPresentationFormat(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicPresentationFormat_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicPresentationFormat(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicPresentationFormat_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicPresentationFormat(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicPresentationFormat_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalCharacteristicPresentationFormat(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicUserDescription_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicUserDescription_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicUserDescription_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicUserDescription_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicUserDescription_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalCharacteristicUserDescription(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicUserDescription_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicUserDescription(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicUserDescription_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicUserDescription(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicUserDescription_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalCharacteristicUserDescription(1));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalCharacteristicUserDescriptionWritable_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalCharacteristicUserDescriptionWritable_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalCharacteristicUserDescriptionWritable_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalCharacteristicUserDescriptionWritable_00005() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalCharacteristicUserDescriptionWritable_00006() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(1
                , originalBluetoothDevice
                , AUTOMATION_IO_SERVICE
                , 0
                , originalCharacteristicUUID
                , originalCharacteristicInstanceId
                , CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR
                , 1
                , new byte[]{0b00000010, 0b00000000}
                , null);
        assertTrue(automationIOService.isDigitalCharacteristicUserDescriptionWritable());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalCharacteristicUserDescriptionWritable_00007() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable());
    }

    @Test
    @RequiresDevice
    public void test_isDigitalCharacteristicUserDescriptionWritable_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalCharacteristicUserDescriptionWritable_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalCharacteristicUserDescriptionWritable_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalCharacteristicUserDescriptionWritable_00105() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalCharacteristicUserDescriptionWritable_00106() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isDigitalCharacteristicUserDescriptionWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isDigitalCharacteristicUserDescriptionWritable_00107() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(1
                , originalBluetoothDevice
                , AUTOMATION_IO_SERVICE
                , 0
                , originalCharacteristicUUID
                , originalCharacteristicInstanceId
                , CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR
                , 1
                , new byte[]{0b00000010, 0b00000000}
                , null);
        assertTrue(automationIOService.isDigitalCharacteristicUserDescriptionWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicExtendedProperties_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalCharacteristicExtendedProperties());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicExtendedProperties_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicExtendedProperties());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicExtendedProperties_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalCharacteristicExtendedProperties());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicExtendedProperties_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicExtendedProperties());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicExtendedProperties_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalCharacteristicExtendedProperties(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicExtendedProperties_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicExtendedProperties(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicExtendedProperties_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalCharacteristicExtendedProperties(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalCharacteristicExtendedProperties_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalCharacteristicExtendedProperties(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalValueTriggerSetting_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalValueTriggerSetting_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalValueTriggerSetting_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalValueTriggerSetting_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalValueTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalValueTriggerSetting_00005() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalValueTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalValueTriggerSetting_00006() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalValueTriggerSetting_00007() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalValueTriggerSetting_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalValueTriggerSetting_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalValueTriggerSetting_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalValueTriggerSetting_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalValueTriggerSetting_00105() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalValueTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalValueTriggerSetting_00106() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalValueTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalValueTriggerSetting_00107() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalValueTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalTimeTriggerSetting_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalTimeTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalTimeTriggerSetting_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalTimeTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalTimeTriggerSetting_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalTimeTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalTimeTriggerSetting_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public synchronized boolean hasDigitalValueTriggerSetting(int index) {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalTimeTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalTimeTriggerSetting_00005() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public synchronized boolean hasDigitalValueTriggerSetting(int index) {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalTimeTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalTimeTriggerSetting_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasDigitalTimeTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalTimeTriggerSetting_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalTimeTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalTimeTriggerSetting_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalTimeTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalTimeTriggerSetting_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public synchronized boolean hasDigitalValueTriggerSetting(int index) {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasDigitalTimeTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasDigitalTimeTriggerSetting_00105() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public synchronized boolean hasDigitalValueTriggerSetting(int index) {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasDigitalTimeTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCount_00001() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertNull(automationIOService.getAnalogCount());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCount_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        Integer count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(0, count.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCount_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        Integer count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(1, count.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCount_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        Integer count = automationIOService.getAnalogCount();
        assertNotNull(count);
        assertEquals(2, count.intValue());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogReadable_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogReadable());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogReadable_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogReadable());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogReadable_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogReadable());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogReadable_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogReadable());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogReadable_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogReadable(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogReadable_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogReadable(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogReadable_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogReadable(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogReadable_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogReadable(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogWritable_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogWritable());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogWritable_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogWritable());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogWritable_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogWritable());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogWritable_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogWritable());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogWritable_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogWritable_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogWritable_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogWritable_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogWritableWithNoResponse_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogWritableWithNoResponse());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogWritableWithNoResponse_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogWritableWithNoResponse());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogWritableWithNoResponse_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogWritableWithNoResponse());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogWritableWithNoResponse_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogWritableWithNoResponse());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogWritableWithNoResponse_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogWritableWithNoResponse(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogWritableWithNoResponse_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogWritableWithNoResponse(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogWritableWithNoResponse_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogWritableWithNoResponse(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogWritableWithNoResponse_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.isAnalogWritableWithNoResponse(1));
    }

    @Test
    @RequiresDevice
    public void test_canAnalogNotify_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.canAnalogNotify());
    }

    @Test
    @RequiresDevice
    public void test_canAnalogNotify_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.canAnalogNotify());
    }

    @Test
    @RequiresDevice
    public void test_canAnalogNotify_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.canAnalogNotify());
    }

    @Test
    @RequiresDevice
    public void test_canAnalogNotify_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.canAnalogNotify());
    }

    @Test
    @RequiresDevice
    public void test_canAnalogNotify_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.canAnalogNotify(1));
    }

    @Test
    @RequiresDevice
    public void test_canAnalogNotify_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.canAnalogNotify(1));
    }

    @Test
    @RequiresDevice
    public void test_canAnalogNotify_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.canAnalogNotify(1));
    }

    @Test
    @RequiresDevice
    public void test_canAnalogIndicate_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.canAnalogIndicate());
    }

    @Test
    @RequiresDevice
    public void test_canAnalogIndicate_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.canAnalogIndicate());
    }

    @Test
    @RequiresDevice
    public void test_canAnalogIndicate_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.canAnalogIndicate());
    }

    @Test
    @RequiresDevice
    public void test_canAnalogIndicate_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.canAnalogIndicate());
    }

    @Test
    @RequiresDevice
    public void test_canAnalogIndicate_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.canAnalogIndicate(1));
    }

    @Test
    @RequiresDevice
    public void test_canAnalogIndicate_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.canAnalogIndicate(1));
    }

    @Test
    @RequiresDevice
    public void test_canAnalogIndicate_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.canAnalogIndicate(1));
    }

    @Test
    @RequiresDevice
    public void test_canAnalogIndicate_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.canAnalogIndicate(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicPresentationFormat_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogCharacteristicPresentationFormat());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicPresentationFormat_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicPresentationFormat());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicPresentationFormat_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogCharacteristicPresentationFormat());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicPresentationFormat_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicPresentationFormat());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicPresentationFormat_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogCharacteristicPresentationFormat(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicPresentationFormat_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicPresentationFormat(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicPresentationFormat_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicPresentationFormat(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicPresentationFormat_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogCharacteristicPresentationFormat(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicUserDescription_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicUserDescription_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicUserDescription_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicUserDescription_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicUserDescription());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicUserDescription_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogCharacteristicUserDescription(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicUserDescription_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicUserDescription(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicUserDescription_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicUserDescription(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicUserDescription_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogCharacteristicUserDescription(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogCharacteristicUserDescriptionWritable_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogCharacteristicUserDescriptionWritable_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogCharacteristicUserDescriptionWritable_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogCharacteristicUserDescriptionWritable_00005() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogCharacteristicUserDescriptionWritable_00006() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(1
                , originalBluetoothDevice
                , AUTOMATION_IO_SERVICE
                , 0
                , originalCharacteristicUUID
                , originalCharacteristicInstanceId
                , CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR
                , 1
                , new byte[]{0b00000010, 0b00000000}
                , null);
        assertTrue(automationIOService.isAnalogCharacteristicUserDescriptionWritable());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogCharacteristicUserDescriptionWritable_00007() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable());
    }

    @Test
    @RequiresDevice
    public void test_isAnalogCharacteristicUserDescriptionWritable_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogCharacteristicUserDescriptionWritable_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogCharacteristicUserDescriptionWritable_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogCharacteristicUserDescriptionWritable_00105() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogCharacteristicUserDescriptionWritable_00106() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.isAnalogCharacteristicUserDescriptionWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_isAnalogCharacteristicUserDescriptionWritable_00107() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(1
                , originalBluetoothDevice
                , AUTOMATION_IO_SERVICE
                , 0
                , originalCharacteristicUUID
                , originalCharacteristicInstanceId
                , CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR
                , 1
                , new byte[]{0b00000010, 0b00000000}
                , null);
        assertTrue(automationIOService.isAnalogCharacteristicUserDescriptionWritable(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicExtendedProperties_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogCharacteristicExtendedProperties());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicExtendedProperties_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicExtendedProperties());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicExtendedProperties_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogCharacteristicExtendedProperties());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicExtendedProperties_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicExtendedProperties());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicExtendedProperties_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogCharacteristicExtendedProperties(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicExtendedProperties_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicExtendedProperties(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicExtendedProperties_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogCharacteristicExtendedProperties(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogCharacteristicExtendedProperties_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogCharacteristicExtendedProperties(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogValueTriggerSetting_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogValueTriggerSetting_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogValueTriggerSetting_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogValueTriggerSetting_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogValueTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogValueTriggerSetting_00005() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogValueTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogValueTriggerSetting_00006() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogValueTriggerSetting_00007() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogValueTriggerSetting_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogValueTriggerSetting_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogValueTriggerSetting_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogValueTriggerSetting_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogValueTriggerSetting_00105() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogValueTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogValueTriggerSetting_00106() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogValueTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogValueTriggerSetting_00107() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogValueTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogTimeTriggerSetting_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogTimeTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogTimeTriggerSetting_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogTimeTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogTimeTriggerSetting_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogTimeTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogTimeTriggerSetting_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public synchronized boolean hasAnalogValueTriggerSetting(int index) {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogTimeTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogTimeTriggerSetting_00005() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public synchronized boolean hasAnalogValueTriggerSetting(int index) {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogTimeTriggerSetting());
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogTimeTriggerSetting_00101() {
        MOCK_BLE_CONNECTION.setConnected(true);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.hasAnalogTimeTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogTimeTriggerSetting_00102() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogTimeTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogTimeTriggerSetting_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogTimeTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogTimeTriggerSetting_00104() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public synchronized boolean hasAnalogValueTriggerSetting(int index) {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertFalse(automationIOService.hasAnalogTimeTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_hasAnalogTimeTriggerSetting_00105() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = TIME_TRIGGER_SETTING_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setConnected(true);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {
            @Override
            public synchronized boolean hasAnalogValueTriggerSetting(int index) {
                return true;
            }
        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);

        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        assertTrue(automationIOService.hasAnalogTimeTriggerSetting(1));
    }

    @Test
    @RequiresDevice
    public void test_isAggregateSupported_00001() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAggregateSupported());
    }

    @Test
    @RequiresDevice
    public void test_isAggregateSupported_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertTrue(automationIOService.isAggregateSupported());
    }

    @Test
    @RequiresDevice
    public void test_isAggregateReadable_00001() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.isAggregateReadable());
    }

    @Test
    @RequiresDevice
    public void test_isAggregateReadable_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertFalse(automationIOService.isAggregateReadable());
    }

    @Test
    @RequiresDevice
    public void test_isAggregateReadable_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertTrue(automationIOService.isAggregateReadable());
    }

    @Test
    @RequiresDevice
    public void test_canAggregateNotify_00001() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.canAggregateNotify());
    }

    @Test
    @RequiresDevice
    public void test_canAggregateNotify_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertFalse(automationIOService.canAggregateNotify());
    }

    @Test
    @RequiresDevice
    public void test_canAggregateNotify_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertFalse(automationIOService.canAggregateNotify());
    }

    @Test
    @RequiresDevice
    public void test_canAggregateNotify_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertTrue(automationIOService.canAggregateNotify());
    }

    @Test
    @RequiresDevice
    public void test_canAggregateIndicate_00001() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        assertFalse(automationIOService.canAggregateIndicate());
    }

    @Test
    @RequiresDevice
    public void test_canAggregateIndicate_00002() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertFalse(automationIOService.canAggregateIndicate());
    }

    @Test
    @RequiresDevice
    public void test_canAggregateIndicate_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertFalse(automationIOService.canAggregateIndicate());
    }

    @Test
    @RequiresDevice
    public void test_canAggregateIndicate_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        assertTrue(automationIOService.canAggregateIndicate());
    }

    @Test
    @RequiresDevice
    public void test_getDigital_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getDigital(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.getDigital());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_getDigital_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigital();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigital_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigital();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigital_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigital();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigital_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigital(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigital_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigital(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigital_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigital(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigital_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigital(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setDigital_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setDigital(int index, @NonNull Digital digital) {
                originalIndex.set(index);
                return super.setDigital(index, digital);
            }

        };

        assertNull(automationIOService.setDigital(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_setDigital_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigital(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigital_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigital(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigital_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigital(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setDigital_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigital(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigital_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigital(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigital_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigital(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigital_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigital(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setDigitalWithNoResponse_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setDigitalWithNoResponse(int index, @NonNull Digital digital) {
                originalIndex.set(index);
                return super.setDigitalWithNoResponse(index, digital);
            }

        };

        assertNull(automationIOService.setDigitalWithNoResponse(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_setDigitalWithNoResponse_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigitalWithNoResponse(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalWithNoResponse_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigitalWithNoResponse(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalWithNoResponse_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalWithNoResponse(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setDigitalWithNoResponse_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigitalWithNoResponse(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalWithNoResponse_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigitalWithNoResponse(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalWithNoResponse_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalWithNoResponse(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalWithNoResponse_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalWithNoResponse(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalClientCharacteristicConfiguration_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getDigitalClientCharacteristicConfiguration(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.getDigitalClientCharacteristicConfiguration());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalClientCharacteristicConfiguration_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalClientCharacteristicConfiguration_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalClientCharacteristicConfiguration_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalClientCharacteristicConfiguration_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalClientCharacteristicConfiguration_00006() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalClientCharacteristicConfiguration_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalClientCharacteristicConfiguration_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalClientCharacteristicConfiguration_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalClientCharacteristicConfiguration_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalClientCharacteristicConfiguration_00105() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalClientCharacteristicConfiguration(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_startDigitalNotification_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer startDigitalNotification(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.startDigitalNotification());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_startDigitalNotification_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startDigitalNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startDigitalNotification_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startDigitalNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startDigitalNotification_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startDigitalNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startDigitalNotification_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startDigitalNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_startDigitalNotification_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startDigitalNotification(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startDigitalNotification_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startDigitalNotification(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startDigitalNotification_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startDigitalNotification(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startDigitalNotification_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startDigitalNotification(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalNotification_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer stopDigitalNotification(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.stopDigitalNotification());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalNotification_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopDigitalNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalNotification_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopDigitalNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalNotification_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopDigitalNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalNotification_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopDigitalNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalNotification_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopDigitalNotification(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalNotification_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopDigitalNotification(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalNotification_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopDigitalNotification(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalNotification_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopDigitalNotification(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_startDigitalIndication_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer startDigitalIndication(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.startDigitalIndication());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_startDigitalIndication_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startDigitalIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startDigitalIndication_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startDigitalIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startDigitalIndication_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startDigitalIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startDigitalIndication_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startDigitalIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_startDigitalIndication_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startDigitalNotification(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startDigitalIndication_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startDigitalNotification(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startDigitalIndication_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startDigitalIndication(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startDigitalIndication_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startDigitalIndication(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalIndication_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer stopDigitalIndication(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.stopDigitalIndication());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalIndication_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopDigitalIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalIndication_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopDigitalIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalIndication_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopDigitalIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalIndication_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopDigitalIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalIndication_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopDigitalIndication(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalIndication_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopDigitalIndication(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalIndication_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopDigitalIndication(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopDigitalIndication_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopDigitalIndication(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicPresentationFormat_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getDigitalCharacteristicPresentationFormat(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.getDigitalCharacteristicPresentationFormat());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicPresentationFormat_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalCharacteristicPresentationFormat();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicPresentationFormat_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalCharacteristicPresentationFormat();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicPresentationFormat_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicPresentationFormat(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalCharacteristicPresentationFormat();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicPresentationFormat_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalCharacteristicPresentationFormat(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicPresentationFormat_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalCharacteristicPresentationFormat(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicPresentationFormat_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicPresentationFormat(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalCharacteristicPresentationFormat(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicUserDescription_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getDigitalCharacteristicUserDescription(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.getDigitalCharacteristicUserDescription());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicUserDescription_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalCharacteristicUserDescription();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicUserDescription_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalCharacteristicUserDescription();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicUserDescription_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalCharacteristicUserDescription();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicUserDescription_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalCharacteristicUserDescription(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicUserDescription_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalCharacteristicUserDescription(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicUserDescription_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalCharacteristicUserDescription(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setDigitalCharacteristicUserDescription_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setDigitalCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
                originalIndex.set(index);
                return super.setDigitalCharacteristicUserDescription(index, characteristicUserDescription);
            }

        };

        assertNull(automationIOService.setDigitalCharacteristicUserDescription(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_setDigitalCharacteristicUserDescription_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigitalCharacteristicUserDescription(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalCharacteristicUserDescription_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigitalCharacteristicUserDescription(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalCharacteristicUserDescription_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalCharacteristicUserDescription(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalCharacteristicUserDescription_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(1
                , originalBluetoothDevice
                , AUTOMATION_IO_SERVICE
                , 0
                , originalCharacteristicUUID
                , originalCharacteristicInstanceId
                , CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR
                , 1
                , new byte[]{0b00000010, 0b00000000}
                , null);

        Integer taskId = automationIOService.setDigitalCharacteristicUserDescription(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setDigitalCharacteristicUserDescription_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigitalCharacteristicUserDescription(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalCharacteristicUserDescription_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigitalCharacteristicUserDescription(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalCharacteristicUserDescription_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalCharacteristicUserDescription(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalCharacteristicUserDescription_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(1
                , originalBluetoothDevice
                , AUTOMATION_IO_SERVICE
                , 0
                , originalCharacteristicUUID
                , originalCharacteristicInstanceId
                , CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR
                , 1
                , new byte[]{0b00000010, 0b00000000}
                , null);

        Integer taskId = automationIOService.setDigitalCharacteristicUserDescription(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicExtendedProperties_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getDigitalCharacteristicExtendedProperties(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.getDigitalCharacteristicExtendedProperties());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicExtendedProperties_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalCharacteristicExtendedProperties();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicExtendedProperties_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalCharacteristicExtendedProperties();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicExtendedProperties_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicExtendedProperties(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalCharacteristicExtendedProperties();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicExtendedProperties_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalCharacteristicExtendedProperties(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicExtendedProperties_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalCharacteristicExtendedProperties(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalCharacteristicExtendedProperties_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalCharacteristicExtendedProperties(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalCharacteristicExtendedProperties(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalValueTriggerSetting_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getDigitalValueTriggerSetting(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.getDigitalValueTriggerSetting());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalValueTriggerSetting_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalValueTriggerSetting();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalValueTriggerSetting_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalValueTriggerSetting();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalValueTriggerSetting_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalValueTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalValueTriggerSetting();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalValueTriggerSetting_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalValueTriggerSetting(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalValueTriggerSetting_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalValueTriggerSetting(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalValueTriggerSetting_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalValueTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalValueTriggerSetting(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setDigitalValueTriggerSetting_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setDigitalValueTriggerSetting(int index, @NonNull ValueTriggerSetting valueTriggerSetting) {
                originalIndex.set(index);
                return super.setAnalogValueTriggerSetting(index, valueTriggerSetting);
            }

        };

        assertNull(automationIOService.setDigitalValueTriggerSetting(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_setDigitalValueTriggerSetting_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigitalValueTriggerSetting(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalValueTriggerSetting_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigitalValueTriggerSetting(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalValueTriggerSetting_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalValueTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalValueTriggerSetting(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setDigitalValueTriggerSetting_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigitalValueTriggerSetting(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalValueTriggerSetting_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigitalValueTriggerSetting(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalValueTriggerSetting_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalValueTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalValueTriggerSetting(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalTimeTriggerSetting_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getDigitalTimeTriggerSetting(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.getDigitalTimeTriggerSetting());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalTimeTriggerSetting_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalTimeTriggerSetting();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalTimeTriggerSetting_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalTimeTriggerSetting();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalTimeTriggerSetting_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalTimeTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalTimeTriggerSetting();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalTimeTriggerSetting_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalTimeTriggerSetting(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalTimeTriggerSetting_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalTimeTriggerSetting(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalTimeTriggerSetting_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalTimeTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalTimeTriggerSetting(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setDigitalTimeTriggerSetting_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setDigitalTimeTriggerSetting(int index, @NonNull TimeTriggerSetting timeTriggerSetting) {
                originalIndex.set(index);
                return super.setDigitalTimeTriggerSetting(index, timeTriggerSetting);
            }

        };

        assertNull(automationIOService.setDigitalTimeTriggerSetting(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_setDigitalTimeTriggerSetting_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigitalTimeTriggerSetting(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalTimeTriggerSetting_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigitalTimeTriggerSetting(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalTimeTriggerSetting_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalTimeTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalTimeTriggerSetting(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setDigitalTimeTriggerSetting_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setDigitalTimeTriggerSetting(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalTimeTriggerSetting_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setDigitalTimeTriggerSetting(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setDigitalTimeTriggerSetting_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasDigitalTimeTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setDigitalTimeTriggerSetting(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalNumberOfDigitals_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getDigitalNumberOfDigitals(int index) {
                originalIndex.set(index);
                return super.getDigital(index);
            }

        };

        assertNull(automationIOService.getDigitalNumberOfDigitals());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalNumberOfDigitals_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalNumberOfDigitals();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalNumberOfDigitals_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalNumberOfDigitals();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalNumberOfDigitals_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalNumberOfDigitals();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getDigitalNumberOfDigitals_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getDigitalNumberOfDigitals(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalNumberOfDigitals_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getDigitalNumberOfDigitals(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getDigitalNumberOfDigitals_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = DIGITAL_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getDigitalNumberOfDigitals(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalog_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getAnalog(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.getAnalog());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_getAnalog_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalog();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalog_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalog();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalog_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalog();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalog_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalog(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalog_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalog(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalog_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalog(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalog_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalog(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setAnalog_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setAnalog(int index, @NonNull Analog analog) {
                originalIndex.set(index);
                return super.setAnalog(index, analog);
            }

        };

        assertNull(automationIOService.setAnalog(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_setAnalog_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalog(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalog_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalog(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalog_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalog(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setAnalog_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalog(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalog_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalog(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalog_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalog(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalog_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalog(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setAnalogWithNoResponse_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setAnalogWithNoResponse(int index, @NonNull Analog analog) {
                originalIndex.set(index);
                return super.setAnalogWithNoResponse(index, analog);
            }

        };

        assertNull(automationIOService.setAnalogWithNoResponse(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_setAnalogWithNoResponse_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalogWithNoResponse(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogWithNoResponse_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalogWithNoResponse(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogWithNoResponse_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogWithNoResponse(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setAnalogWithNoResponse_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalogWithNoResponse(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogWithNoResponse_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalogWithNoResponse(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogWithNoResponse_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogWithNoResponse(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogWithNoResponse_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogWithNoResponse(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogClientCharacteristicConfiguration_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getAnalogClientCharacteristicConfiguration(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.getAnalogClientCharacteristicConfiguration());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogClientCharacteristicConfiguration_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogClientCharacteristicConfiguration_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogClientCharacteristicConfiguration_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogClientCharacteristicConfiguration_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogClientCharacteristicConfiguration_00006() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogClientCharacteristicConfiguration_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogClientCharacteristicConfiguration_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogClientCharacteristicConfiguration_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogClientCharacteristicConfiguration_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogClientCharacteristicConfiguration_00105() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogClientCharacteristicConfiguration(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_startAnalogNotification_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer startAnalogNotification(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.startAnalogNotification());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_startAnalogNotification_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startAnalogNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAnalogNotification_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startAnalogNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAnalogNotification_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAnalogNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAnalogNotification_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAnalogNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_startAnalogNotification_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startAnalogNotification(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAnalogNotification_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startAnalogNotification(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAnalogNotification_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAnalogNotification(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAnalogNotification_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAnalogNotification(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogNotification_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer stopAnalogNotification(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.stopAnalogNotification());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogNotification_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopAnalogNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogNotification_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopAnalogNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogNotification_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAnalogNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogNotification_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAnalogNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogNotification_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopAnalogNotification(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogNotification_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopAnalogNotification(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogNotification_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAnalogNotification(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogNotification_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAnalogNotification(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_startAnalogIndication_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer startAnalogIndication(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.startAnalogIndication());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_startAnalogIndication_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startAnalogIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAnalogIndication_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startAnalogIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAnalogIndication_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAnalogIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAnalogIndication_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAnalogIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_startAnalogIndication_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startAnalogNotification(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAnalogIndication_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startAnalogNotification(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAnalogIndication_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAnalogIndication(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAnalogIndication_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAnalogIndication(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogIndication_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer stopAnalogIndication(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.stopAnalogIndication());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogIndication_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopAnalogIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogIndication_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopAnalogIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogIndication_00004() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAnalogIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogIndication_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAnalogIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogIndication_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopAnalogIndication(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogIndication_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopAnalogIndication(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogIndication_00103() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAnalogIndication(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAnalogIndication_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAnalogIndication(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicPresentationFormat_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getAnalogCharacteristicPresentationFormat(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.getAnalogCharacteristicPresentationFormat());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicPresentationFormat_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogCharacteristicPresentationFormat();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicPresentationFormat_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogCharacteristicPresentationFormat();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicPresentationFormat_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicPresentationFormat(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogCharacteristicPresentationFormat();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicPresentationFormat_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogCharacteristicPresentationFormat(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicPresentationFormat_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogCharacteristicPresentationFormat(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicPresentationFormat_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicPresentationFormat(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogCharacteristicPresentationFormat(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicUserDescription_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getAnalogCharacteristicUserDescription(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.getAnalogCharacteristicUserDescription());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicUserDescription_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogCharacteristicUserDescription();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicUserDescription_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogCharacteristicUserDescription();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicUserDescription_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogCharacteristicUserDescription();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicUserDescription_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogCharacteristicUserDescription(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicUserDescription_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogCharacteristicUserDescription(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicUserDescription_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogCharacteristicUserDescription(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setAnalogCharacteristicUserDescription_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setAnalogCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
                originalIndex.set(index);
                return super.setAnalogCharacteristicUserDescription(index, characteristicUserDescription);
            }

        };

        assertNull(automationIOService.setAnalogCharacteristicUserDescription(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_setAnalogCharacteristicUserDescription_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalogCharacteristicUserDescription(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogCharacteristicUserDescription_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalogCharacteristicUserDescription(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogCharacteristicUserDescription_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogCharacteristicUserDescription(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogCharacteristicUserDescription_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(1
                , originalBluetoothDevice
                , AUTOMATION_IO_SERVICE
                , 0
                , originalCharacteristicUUID
                , originalCharacteristicInstanceId
                , CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR
                , 1
                , new byte[]{0b00000010, 0b00000000}
                , null);

        Integer taskId = automationIOService.setAnalogCharacteristicUserDescription(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setAnalogCharacteristicUserDescription_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalogCharacteristicUserDescription(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogCharacteristicUserDescription_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalogCharacteristicUserDescription(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogCharacteristicUserDescription_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogCharacteristicUserDescription(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogCharacteristicUserDescription_00104() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicUserDescription(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(originalDescriptorUUID, 0));
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR, 0);
        bluetoothGattCharacteristic.addDescriptor(bluetoothGattDescriptor);
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);
        automationIOService.onDescriptorReadSuccess(1
                , originalBluetoothDevice
                , AUTOMATION_IO_SERVICE
                , 0
                , originalCharacteristicUUID
                , originalCharacteristicInstanceId
                , CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR
                , 1
                , new byte[]{0b00000010, 0b00000000}
                , null);

        Integer taskId = automationIOService.setAnalogCharacteristicUserDescription(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicExtendedProperties_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getAnalogCharacteristicExtendedProperties(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.getAnalogCharacteristicExtendedProperties());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicExtendedProperties_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogCharacteristicExtendedProperties();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicExtendedProperties_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogCharacteristicExtendedProperties();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicExtendedProperties_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicExtendedProperties(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogCharacteristicExtendedProperties();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicExtendedProperties_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogCharacteristicExtendedProperties(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicExtendedProperties_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogCharacteristicExtendedProperties(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogCharacteristicExtendedProperties_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogCharacteristicExtendedProperties(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogCharacteristicExtendedProperties(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogValueTriggerSetting_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getAnalogValueTriggerSetting(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.getAnalogValueTriggerSetting());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogValueTriggerSetting_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogValueTriggerSetting();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogValueTriggerSetting_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogValueTriggerSetting();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogValueTriggerSetting_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogValueTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogValueTriggerSetting();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogValueTriggerSetting_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogValueTriggerSetting(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogValueTriggerSetting_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogValueTriggerSetting(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogValueTriggerSetting_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogValueTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogValueTriggerSetting(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setAnalogValueTriggerSetting_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setAnalogValueTriggerSetting(int index, @NonNull ValueTriggerSetting valueTriggerSetting) {
                originalIndex.set(index);
                return super.setAnalogValueTriggerSetting(index, valueTriggerSetting);
            }

        };

        assertNull(automationIOService.setAnalogValueTriggerSetting(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_setAnalogValueTriggerSetting_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalogValueTriggerSetting(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogValueTriggerSetting_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalogValueTriggerSetting(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogValueTriggerSetting_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogValueTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogValueTriggerSetting(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setAnalogValueTriggerSetting_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalogValueTriggerSetting(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogValueTriggerSetting_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalogValueTriggerSetting(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogValueTriggerSetting_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogValueTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogValueTriggerSetting(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogTimeTriggerSetting_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getAnalogTimeTriggerSetting(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.getAnalogTimeTriggerSetting());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogTimeTriggerSetting_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogTimeTriggerSetting();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogTimeTriggerSetting_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogTimeTriggerSetting();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogTimeTriggerSetting_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogTimeTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogTimeTriggerSetting();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogTimeTriggerSetting_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogTimeTriggerSetting(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogTimeTriggerSetting_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogTimeTriggerSetting(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogTimeTriggerSetting_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogTimeTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogTimeTriggerSetting(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setAnalogTimeTriggerSetting_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer setAnalogTimeTriggerSetting(int index, @NonNull TimeTriggerSetting timeTriggerSetting) {
                originalIndex.set(index);
                return super.setAnalogTimeTriggerSetting(index, timeTriggerSetting);
            }

        };

        assertNull(automationIOService.setAnalogTimeTriggerSetting(null));
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_setAnalogTimeTriggerSetting_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalogTimeTriggerSetting(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogTimeTriggerSetting_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalogTimeTriggerSetting(null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogTimeTriggerSetting_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogTimeTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogTimeTriggerSetting(null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_setAnalogTimeTriggerSetting_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.setAnalogTimeTriggerSetting(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogTimeTriggerSetting_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.setAnalogTimeTriggerSetting(1, null);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_setAnalogTimeTriggerSetting_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public synchronized boolean hasAnalogTimeTriggerSetting(int index) {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.setAnalogTimeTriggerSetting(1, null);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogValidRange_00001() {
        final AtomicInteger originalIndex = new AtomicInteger(-1);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Nullable
            @Override
            public synchronized Integer getAnalogValidRange(int index) {
                originalIndex.set(index);
                return super.getAnalog(index);
            }

        };

        assertNull(automationIOService.getAnalogValidRange());
        assertEquals(0, originalIndex.get());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogValidRange_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogValidRange();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogValidRange_00003() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogValidRange();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogValidRange_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogValidRange();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAnalogValidRange_00101() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAnalogValidRange(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogValidRange_00102() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAnalogValidRange(1);
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAnalogValidRange_00103() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = ANALOG_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId + 1, 0, 0, 0, 0, Collections.emptyList()));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, 0, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAnalogValidRange(1);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAggregate_00001() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAggregate();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAggregate_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAggregate();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAggregate_00003() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAggregate();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAggregateClientCharacteristicConfiguration_00001() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.getAggregateClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAggregateClientCharacteristicConfiguration_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.getAggregateClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAggregateClientCharacteristicConfiguration_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAggregateClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAggregateClientCharacteristicConfiguration_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAggregateClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAggregateClientCharacteristicConfiguration_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAggregateClientCharacteristicConfiguration();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_getAggregateClientCharacteristicConfiguration_00006() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAggregateClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_getAggregateClientCharacteristicConfiguration_00007() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.getAggregateClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_startAggregateNotification_00001() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startAggregateNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAggregateNotification_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startAggregateNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAggregateNotification_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAggregateNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAggregateNotification_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAggregateNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAggregateNotification_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAggregateNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_stopAggregateNotification_00001() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopAggregateNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAggregateNotification_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopAggregateNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAggregateNotification_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAggregateNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAggregateNotification_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAggregateNotification();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAggregateNotification_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAggregateNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_startAggregateIndication_00001() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.startAggregateIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAggregateIndication_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.startAggregateIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAggregateIndication_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAggregateIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAggregateIndication_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAggregateIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_startAggregateIndication_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.startAggregateIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

    @Test
    @RequiresDevice
    public void test_stopAggregateIndication_00001() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null);

        Integer taskId = automationIOService.stopAggregateIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAggregateIndication_00002() {
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = automationIOService.stopAggregateIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAggregateIndication_00003() {
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAggregateIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAggregateIndication_00004() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList()));
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAggregateIndication();
        assertNull(taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopAggregateIndication_00005() {
        final int originalTaskId = 1;

        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = AUTOMATION_IO_SERVICE;
        final UUID originalCharacteristicUUID = AGGREGATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 2;

        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        AutomationIOService automationIOService = new AutomationIOService(MOCK_BLE_CONNECTION, new MockAutomationIOServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        BluetoothGattService bluetoothGattService = new BluetoothGattService(originalServiceUUID, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = BLETestUtilsAndroid.createBluetoothCharacteristic(originalCharacteristicUUID, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0, 0, 0, Collections.emptyList());
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, 0));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        automationIOService.onDiscoverServiceSuccess(1, originalBluetoothDevice, Collections.singletonList(bluetoothGattService), null);

        Integer taskId = automationIOService.stopAggregateIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId.intValue());
    }

}
