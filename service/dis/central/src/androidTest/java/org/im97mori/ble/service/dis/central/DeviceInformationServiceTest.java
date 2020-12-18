package org.im97mori.ble.service.dis.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.characteristic.u2a23.SystemIdAndroid;
import org.im97mori.ble.characteristic.u2a24.ModelNumberStringAndroid;
import org.im97mori.ble.characteristic.u2a25.SerialNumberStringAndroid;
import org.im97mori.ble.characteristic.u2a26.FirmwareRevisionStringAndroid;
import org.im97mori.ble.characteristic.u2a27.HardwareRevisionStringAndroid;
import org.im97mori.ble.characteristic.u2a28.SoftwareRevisionStringAndroid;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameStringAndroid;
import org.im97mori.ble.characteristic.u2a2a.IEEE_11073_20601_RegulatoryCertificationDataListAndroid;
import org.im97mori.ble.characteristic.u2a50.PnpIdAndroid;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FIRMWARE_REVISION_STRING_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HARDWARE_REVISION_STRING_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MANUFACTURER_NAME_STRING_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MODEL_NUMBER_STRING_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.PNP_ID_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SERIAL_NUMBER_STRING_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SOFTWARE_REVISION_STRING_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SYSTEM_ID_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.GENERIC_ATTRIBUTE_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DeviceInformationServiceTest {

    @Test
    public void test_onDiscoverServiceSuccess_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        deviceInformationService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(deviceInformationService.hasManufacturerNameString());
        assertFalse(deviceInformationService.hasModelNumberString());
        assertFalse(deviceInformationService.hasSerialNumberString());
        assertFalse(deviceInformationService.hasHardwareRevisionString());
        assertFalse(deviceInformationService.hasFirmwareRevisionString());
        assertFalse(deviceInformationService.hasSoftwareRevisionString());
        assertFalse(deviceInformationService.hasSystemId());
        assertFalse(deviceInformationService.hasIEEE_11073_20601_RegulatoryCertificationDataList());
        assertFalse(deviceInformationService.hasPnpId());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MANUFACTURER_NAME_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MODEL_NUMBER_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SERIAL_NUMBER_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HARDWARE_REVISION_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIRMWARE_REVISION_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SOFTWARE_REVISION_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SYSTEM_ID_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PNP_ID_CHARACTERISTIC, 0, 0));
        deviceInformationService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(deviceInformationService.hasManufacturerNameString());
        assertFalse(deviceInformationService.hasModelNumberString());
        assertFalse(deviceInformationService.hasSerialNumberString());
        assertFalse(deviceInformationService.hasHardwareRevisionString());
        assertFalse(deviceInformationService.hasFirmwareRevisionString());
        assertFalse(deviceInformationService.hasSoftwareRevisionString());
        assertFalse(deviceInformationService.hasSystemId());
        assertFalse(deviceInformationService.hasIEEE_11073_20601_RegulatoryCertificationDataList());
        assertFalse(deviceInformationService.hasPnpId());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MANUFACTURER_NAME_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MODEL_NUMBER_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SERIAL_NUMBER_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HARDWARE_REVISION_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIRMWARE_REVISION_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SOFTWARE_REVISION_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SYSTEM_ID_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PNP_ID_CHARACTERISTIC, 0, 0));
        deviceInformationService.onDiscoverServiceSuccess(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), Collections.singletonList(bluetoothGattService), null);

        assertFalse(deviceInformationService.hasManufacturerNameString());
        assertFalse(deviceInformationService.hasModelNumberString());
        assertFalse(deviceInformationService.hasSerialNumberString());
        assertFalse(deviceInformationService.hasHardwareRevisionString());
        assertFalse(deviceInformationService.hasFirmwareRevisionString());
        assertFalse(deviceInformationService.hasSoftwareRevisionString());
        assertFalse(deviceInformationService.hasSystemId());
        assertFalse(deviceInformationService.hasIEEE_11073_20601_RegulatoryCertificationDataList());
        assertFalse(deviceInformationService.hasPnpId());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MANUFACTURER_NAME_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MODEL_NUMBER_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SERIAL_NUMBER_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HARDWARE_REVISION_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIRMWARE_REVISION_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SOFTWARE_REVISION_STRING_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SYSTEM_ID_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC, 0, 0));
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PNP_ID_CHARACTERISTIC, 0, 0));
        deviceInformationService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(deviceInformationService.hasManufacturerNameString());
        assertTrue(deviceInformationService.hasModelNumberString());
        assertTrue(deviceInformationService.hasSerialNumberString());
        assertTrue(deviceInformationService.hasHardwareRevisionString());
        assertTrue(deviceInformationService.hasFirmwareRevisionString());
        assertTrue(deviceInformationService.hasSoftwareRevisionString());
        assertTrue(deviceInformationService.hasSystemId());
        assertTrue(deviceInformationService.hasIEEE_11073_20601_RegulatoryCertificationDataList());
        assertTrue(deviceInformationService.hasPnpId());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MANUFACTURER_NAME_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onManufacturerNameStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ManufacturerNameStringAndroid manufacturerNameStringAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, manufacturerNameStringAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MODEL_NUMBER_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onModelNumberStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ModelNumberStringAndroid modelNumberStringAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, modelNumberStringAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERIAL_NUMBER_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSerialNumberStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SerialNumberStringAndroid serialNumberStringAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, serialNumberStringAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HARDWARE_REVISION_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onHardwareRevisionStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull HardwareRevisionStringAndroid hardwareRevisionStringAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, hardwareRevisionStringAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIRMWARE_REVISION_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onFirmwareRevisionStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull FirmwareRevisionStringAndroid firmwareRevisionStringAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, firmwareRevisionStringAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SOFTWARE_REVISION_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSoftwareRevisionStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SoftwareRevisionStringAndroid softwareRevisionStringAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, softwareRevisionStringAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SYSTEM_ID_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7, 8, 9, 10, 11};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSystemIdReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SystemIdAndroid systemIdAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, systemIdAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onIEEE_11073_20601_RegulatoryCertificationDataListReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull IEEE_11073_20601_RegulatoryCertificationDataListAndroid ieee_11073_20601_regulatoryCertificationDataListAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
//                assertArrayEquals(originalValues, ieee_11073_20601_regulatoryCertificationDataListAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PNP_ID_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7, 8, 9, 10};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onPnPIdReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull PnpIdAndroid pnpIdAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, pnpIdAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onManufacturerNameStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ManufacturerNameStringAndroid manufacturerNameStringAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, MANUFACTURER_NAME_STRING_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onModelNumberStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ModelNumberStringAndroid modelNumberStringAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, MODEL_NUMBER_STRING_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSerialNumberStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SerialNumberStringAndroid serialNumberStringAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, SERIAL_NUMBER_STRING_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onHardwareRevisionStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull HardwareRevisionStringAndroid hardwareRevisionStringAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, HARDWARE_REVISION_STRING_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onFirmwareRevisionStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull FirmwareRevisionStringAndroid firmwareRevisionStringAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, FIRMWARE_REVISION_STRING_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00106() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSoftwareRevisionStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SoftwareRevisionStringAndroid softwareRevisionStringAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, SOFTWARE_REVISION_STRING_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00107() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSystemIdReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SystemIdAndroid systemIdAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, SYSTEM_ID_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00108() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onIEEE_11073_20601_RegulatoryCertificationDataListReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull IEEE_11073_20601_RegulatoryCertificationDataListAndroid ieee_11073_20601_regulatoryCertificationDataListAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00109() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onPnPIdReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull PnpIdAndroid pnpIdAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), GENERIC_ATTRIBUTE_SERVICE, 2, PNP_ID_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onManufacturerNameStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ManufacturerNameStringAndroid manufacturerNameStringAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, MANUFACTURER_NAME_STRING_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onModelNumberStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ModelNumberStringAndroid modelNumberStringAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, MODEL_NUMBER_STRING_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSerialNumberStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SerialNumberStringAndroid serialNumberStringAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, SERIAL_NUMBER_STRING_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onHardwareRevisionStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull HardwareRevisionStringAndroid hardwareRevisionStringAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, HARDWARE_REVISION_STRING_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onFirmwareRevisionStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull FirmwareRevisionStringAndroid firmwareRevisionStringAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, FIRMWARE_REVISION_STRING_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00206() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSoftwareRevisionStringReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SoftwareRevisionStringAndroid softwareRevisionStringAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, SOFTWARE_REVISION_STRING_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00207() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSystemIdReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SystemIdAndroid systemIdAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, SYSTEM_ID_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00208() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onIEEE_11073_20601_RegulatoryCertificationDataListReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull IEEE_11073_20601_RegulatoryCertificationDataListAndroid ieee_11073_20601_regulatoryCertificationDataListAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00209() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onPnPIdReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull PnpIdAndroid pnpIdAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadSuccess(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC, 3, new byte[]{4}, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MANUFACTURER_NAME_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onManufacturerNameStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MODEL_NUMBER_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onModelNumberStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERIAL_NUMBER_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSerialNumberStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HARDWARE_REVISION_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onHardwareRevisionStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIRMWARE_REVISION_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onFirmwareRevisionStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SOFTWARE_REVISION_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSoftwareRevisionStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SYSTEM_ID_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSystemIdReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onIEEE_11073_20601_RegulatoryCertificationDataListReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PNP_ID_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onPnPIdReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onManufacturerNameStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, MANUFACTURER_NAME_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onModelNumberStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, MODEL_NUMBER_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSerialNumberStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, SERIAL_NUMBER_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onHardwareRevisionStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, HARDWARE_REVISION_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onFirmwareRevisionStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, FIRMWARE_REVISION_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00106() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSoftwareRevisionStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, SOFTWARE_REVISION_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00107() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSystemIdReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SystemIdAndroid systemIdAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, SYSTEM_ID_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00108() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onIEEE_11073_20601_RegulatoryCertificationDataListReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00109() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onPnPIdReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), GENERIC_ATTRIBUTE_SERVICE, 2, PNP_ID_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onPnPIdReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, MANUFACTURER_NAME_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onModelNumberStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, MODEL_NUMBER_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSerialNumberStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, SERIAL_NUMBER_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onHardwareRevisionStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, HARDWARE_REVISION_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onFirmwareRevisionStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, FIRMWARE_REVISION_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00206() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSoftwareRevisionStringReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, SOFTWARE_REVISION_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00207() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSystemIdReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, SYSTEM_ID_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00208() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onIEEE_11073_20601_RegulatoryCertificationDataListReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00209() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onPnPIdReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadFailed(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MANUFACTURER_NAME_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onManufacturerNameStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = MODEL_NUMBER_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onModelNumberStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SERIAL_NUMBER_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSerialNumberStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HARDWARE_REVISION_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onHardwareRevisionStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FIRMWARE_REVISION_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onFirmwareRevisionStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SOFTWARE_REVISION_STRING_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSoftwareRevisionStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SYSTEM_ID_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSystemIdReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onIEEE_11073_20601_RegulatoryCertificationDataListReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = DEVICE_INFORMATION_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = PNP_ID_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onPnPIdReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onManufacturerNameStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, MANUFACTURER_NAME_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onModelNumberStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, MODEL_NUMBER_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSerialNumberStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long time, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, SERIAL_NUMBER_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onHardwareRevisionStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, HARDWARE_REVISION_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onFirmwareRevisionStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, FIRMWARE_REVISION_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00106() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSoftwareRevisionStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, SOFTWARE_REVISION_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00107() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSystemIdReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, SYSTEM_ID_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00108() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onIEEE_11073_20601_RegulatoryCertificationDataListReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), DEVICE_INFORMATION_SERVICE, 2, IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00109() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onPnPIdReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:CC"), GENERIC_ATTRIBUTE_SERVICE, 2, PNP_ID_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onManufacturerNameStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, MANUFACTURER_NAME_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00202() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onModelNumberStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, MODEL_NUMBER_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00203() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSerialNumberStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long time, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, SERIAL_NUMBER_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00204() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onHardwareRevisionStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, HARDWARE_REVISION_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00205() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onFirmwareRevisionStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, FIRMWARE_REVISION_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00206() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSoftwareRevisionStringReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, SOFTWARE_REVISION_STRING_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00207() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onSystemIdReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, SYSTEM_ID_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00208() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onIEEE_11073_20601_RegulatoryCertificationDataListReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00209() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockDeviceInformationServiceCallback mockDeviceInformationServiceCallback = new MockDeviceInformationServiceCallback() {
            @Override
            public void onPnPIdReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, mockDeviceInformationServiceCallback, null);
        deviceInformationService.onCharacteristicReadTimeout(1, MockBLEConnection.MOCK_DEVICE, GENERIC_ATTRIBUTE_SERVICE, 2, IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC, 3, 4, null);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_hasManufacturerNameString_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MANUFACTURER_NAME_STRING_CHARACTERISTIC, 0, 0));
        deviceInformationService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(deviceInformationService.hasManufacturerNameString());
    }

    @Test
    public void test_hasManufacturerNameString_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);

        assertFalse(deviceInformationService.hasManufacturerNameString());
    }

    @Test
    public void test_hasModelNumberString_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(MODEL_NUMBER_STRING_CHARACTERISTIC, 0, 0));
        deviceInformationService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(deviceInformationService.hasModelNumberString());
    }

    @Test
    public void test_hasModelNumberString_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);

        assertFalse(deviceInformationService.hasModelNumberString());
    }

    @Test
    public void test_hasSerialNumberString_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SERIAL_NUMBER_STRING_CHARACTERISTIC, 0, 0));
        deviceInformationService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(deviceInformationService.hasSerialNumberString());
    }

    @Test
    public void test_hasSerialNumberString_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);

        assertFalse(deviceInformationService.hasSerialNumberString());
    }

    @Test
    public void test_hasHardwareRevisionString_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HARDWARE_REVISION_STRING_CHARACTERISTIC, 0, 0));
        deviceInformationService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(deviceInformationService.hasHardwareRevisionString());
    }

    @Test
    public void test_hasHardwareRevisionString_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);

        assertFalse(deviceInformationService.hasHardwareRevisionString());
    }

    @Test
    public void test_hasFirmwareRevisionString_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FIRMWARE_REVISION_STRING_CHARACTERISTIC, 0, 0));
        deviceInformationService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(deviceInformationService.hasFirmwareRevisionString());
    }

    @Test
    public void test_hasFirmwareRevisionString_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);

        assertFalse(deviceInformationService.hasFirmwareRevisionString());
    }

    @Test
    public void test_hasSoftwareRevisionString_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SOFTWARE_REVISION_STRING_CHARACTERISTIC, 0, 0));
        deviceInformationService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(deviceInformationService.hasSoftwareRevisionString());
    }

    @Test
    public void test_hasSoftwareRevisionString_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);

        assertFalse(deviceInformationService.hasSoftwareRevisionString());
    }

    @Test
    public void test_hasSystemId_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SYSTEM_ID_CHARACTERISTIC, 0, 0));
        deviceInformationService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(deviceInformationService.hasSystemId());
    }

    @Test
    public void test_hasSystemId_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);

        assertFalse(deviceInformationService.hasSystemId());
    }

    @Test
    public void test_hasIEEE_11073_20601_RegulatoryCertificationDataList_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC, 0, 0));
        deviceInformationService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(deviceInformationService.hasIEEE_11073_20601_RegulatoryCertificationDataList());
    }

    @Test
    public void test_hasIEEE_11073_20601_RegulatoryCertificationDataList_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);

        assertFalse(deviceInformationService.hasIEEE_11073_20601_RegulatoryCertificationDataList());
    }

    @Test
    public void test_hasPnpId_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(DEVICE_INFORMATION_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(PNP_ID_CHARACTERISTIC, 0, 0));
        deviceInformationService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(deviceInformationService.hasPnpId());
    }

    @Test
    public void test_hasPnpId_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        assertFalse(deviceInformationService.hasPnpId());
    }

    @Test
    public void test_getManufacturerNameString_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        assertNull(deviceInformationService.getManufacturerNameString());
    }

    @Test
    public void test_getManufacturerNameString_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getManufacturerNameString());
    }

    @Test
    public void test_getManufacturerNameString_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasManufacturerNameString() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getManufacturerNameString());
    }

    @Test
    public void test_getManufacturerNameString_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasManufacturerNameString() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNotNull(deviceInformationService.getManufacturerNameString());
    }

    @Test
    public void test_getModelNumberString_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        assertNull(deviceInformationService.getModelNumberString());
    }

    @Test
    public void test_getModelNumberString_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getModelNumberString());
    }

    @Test
    public void test_getModelNumberString_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasModelNumberString() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getModelNumberString());
    }

    @Test
    public void test_getModelNumberString_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasModelNumberString() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNotNull(deviceInformationService.getModelNumberString());
    }

    @Test
    public void test_getSerialNumberString_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        assertNull(deviceInformationService.getSerialNumberString());
    }

    @Test
    public void test_getSerialNumberString_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getSerialNumberString());
    }

    @Test
    public void test_getSerialNumberString_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasSerialNumberString() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getSerialNumberString());
    }

    @Test
    public void test_getSerialNumberString_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasSerialNumberString() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNotNull(deviceInformationService.getSerialNumberString());
    }

    @Test
    public void test_getHardwareRevisionString_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        assertNull(deviceInformationService.getHardwareRevisionString());
    }

    @Test
    public void test_getHardwareRevisionString_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getHardwareRevisionString());
    }

    @Test
    public void test_getHardwareRevisionString_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasHardwareRevisionString() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getHardwareRevisionString());
    }

    @Test
    public void test_getHardwareRevisionString_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasHardwareRevisionString() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNotNull(deviceInformationService.getHardwareRevisionString());
    }

    @Test
    public void test_getFirmwareRevisionString_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        assertNull(deviceInformationService.getFirmwareRevisionString());
    }

    @Test
    public void test_getFirmwareRevisionString_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getFirmwareRevisionString());
    }

    @Test
    public void test_getFirmwareRevisionString_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasFirmwareRevisionString() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getFirmwareRevisionString());
    }

    @Test
    public void test_getFirmwareRevisionString_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasFirmwareRevisionString() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNotNull(deviceInformationService.getFirmwareRevisionString());
    }

    @Test
    public void test_getSoftwareRevisionString_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        assertNull(deviceInformationService.getSoftwareRevisionString());
    }

    @Test
    public void test_getSoftwareRevisionString_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getSoftwareRevisionString());
    }

    @Test
    public void test_getSoftwareRevisionString_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasSoftwareRevisionString() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getSoftwareRevisionString());
    }

    @Test
    public void test_getSoftwareRevisionString_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasSoftwareRevisionString() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNotNull(deviceInformationService.getSoftwareRevisionString());
    }

    @Test
    public void test_getSystemId_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        assertNull(deviceInformationService.getSystemId());
    }

    @Test
    public void test_getSystemId_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getSystemId());
    }

    @Test
    public void test_getSystemId_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasSystemId() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getSystemId());
    }

    @Test
    public void test_getSystemId_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasSystemId() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNotNull(deviceInformationService.getSystemId());
    }

    @Test
    public void test_getIEEE_11073_20601_RegulatoryCertificationDataList_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        assertNull(deviceInformationService.getIEEE_11073_20601_RegulatoryCertificationDataList());
    }

    @Test
    public void test_getIEEE_11073_20601_RegulatoryCertificationDataList_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getIEEE_11073_20601_RegulatoryCertificationDataList());
    }

    @Test
    public void test_getIEEE_11073_20601_RegulatoryCertificationDataList_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasIEEE_11073_20601_RegulatoryCertificationDataList() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getIEEE_11073_20601_RegulatoryCertificationDataList());
    }

    @Test
    public void test_getIEEE_11073_20601_RegulatoryCertificationDataList_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasIEEE_11073_20601_RegulatoryCertificationDataList() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNotNull(deviceInformationService.getIEEE_11073_20601_RegulatoryCertificationDataList());
    }

    @Test
    public void test_getPnpId_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null);
        assertNull(deviceInformationService.getPnpId());
    }

    @Test
    public void test_getPnpId_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getPnpId());
    }

    @Test
    public void test_getPnpId_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasPnpId() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNull(deviceInformationService.getPnpId());
    }

    @Test
    public void test_getPnpId_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {
            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return 1;
            }
        };
        DeviceInformationService deviceInformationService = new DeviceInformationService(mockBLEConnection, new MockDeviceInformationServiceCallback(), null) {
            @Override
            public synchronized boolean hasPnpId() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }
        };
        assertNotNull(deviceInformationService.getPnpId());
    }

}
