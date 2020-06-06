package org.im97mori.ble.service.dis.peripheral;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.characteristic.u2a23.SystemId;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a25.SerialNumberString;
import org.im97mori.ble.characteristic.u2a26.FirmwareRevisionString;
import org.im97mori.ble.characteristic.u2a27.HardwareRevisionString;
import org.im97mori.ble.characteristic.u2a28.SoftwareRevisionString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a2a.IEEE_11073_20601_RegulatoryCertificationDataList;
import org.im97mori.ble.characteristic.u2a50.PnpId;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

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
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DeviceInformationServiceMockCallbackBuilderTest {

    @Test
    public void test_addManufacturerNameString_00001() {
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addManufacturerNameString_00002() {
        String manufacturerName = "manufacturerName";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addManufacturerNameString(manufacturerName);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MANUFACTURER_NAME_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), manufacturerName.getBytes());
    }

    @Test
    public void test_addManufacturerNameString_00003() {
        String manufacturerName = "manufacturerName";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addManufacturerNameString(new ManufacturerNameString(manufacturerName));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MANUFACTURER_NAME_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), manufacturerName.getBytes());
    }

    @Test
    public void test_addManufacturerNameString_00004() {
        String manufacturerName = "manufacturerName";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addManufacturerNameString(manufacturerName.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MANUFACTURER_NAME_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), manufacturerName.getBytes());
    }


    @Test
    public void test_addManufacturerNameString_00005() {
        String manufacturerName = "manufacturerName";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addManufacturerNameString(0, 0, manufacturerName.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MANUFACTURER_NAME_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), manufacturerName.getBytes());
    }

    @Test
    public void test_removeManufacturerNameString_00001() {
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.removeManufacturerNameString();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addModelNumberString_00001() {
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addModelNumberString_00002() {
        String modelNumber = "modelNumber";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addModelNumberString(modelNumber);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MODEL_NUMBER_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), modelNumber.getBytes());
    }

    @Test
    public void test_addModelNumberString_00003() {
        String modelNumber = "modelNumber";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addModelNumberString(new ModelNumberString(modelNumber));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MODEL_NUMBER_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), modelNumber.getBytes());
    }

    @Test
    public void test_addModelNumberString_00004() {
        String modelNumber = "modelNumber";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addModelNumberString(modelNumber.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MODEL_NUMBER_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), modelNumber.getBytes());
    }

    @Test
    public void test_addModelNumberString_00005() {
        String modelNumber = "modelNumber";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addModelNumberString(0, 0, modelNumber.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MODEL_NUMBER_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), modelNumber.getBytes());
    }

    @Test
    public void test_removeModelNumberString_00001() {
        String modelNumber = "modelNumber";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addModelNumberString(modelNumber);
        builder.removeModelNumberString();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addSerialNumberString_00001() {
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addSerialNumberString_00002() {
        String serialNumber = "serialNumber";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSerialNumberString(serialNumber);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SERIAL_NUMBER_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), serialNumber.getBytes());
    }

    @Test
    public void test_addSerialNumberString_00003() {
        String serialNumber = "serialNumber";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSerialNumberString(new SerialNumberString(serialNumber));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SERIAL_NUMBER_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), serialNumber.getBytes());
    }

    @Test
    public void test_addSerialNumberString_00004() {
        String serialNumber = "serialNumber";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSerialNumberString(serialNumber.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SERIAL_NUMBER_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), serialNumber.getBytes());
    }

    @Test
    public void test_addSerialNumberString_00005() {
        String serialNumber = "serialNumber";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSerialNumberString(0, 0, serialNumber.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SERIAL_NUMBER_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), serialNumber.getBytes());
    }

    @Test
    public void test_removeSerialNumberString_00001() {
        String serialNumber = "serialNumber";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSerialNumberString(serialNumber);
        builder.removeSerialNumberString();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addHardwareRevisionString_00001() {
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addHardwareRevisionString_00002() {
        String hardwareRevision = "hardwareRevision";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addHardwareRevisionString(hardwareRevision);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HARDWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), hardwareRevision.getBytes());
    }

    @Test
    public void test_addHardwareRevisionString_00003() {
        String hardwareRevision = "hardwareRevision";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addHardwareRevisionString(new HardwareRevisionString(hardwareRevision));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HARDWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), hardwareRevision.getBytes());
    }

    @Test
    public void test_addHardwareRevisionString_00004() {
        String hardwareRevision = "hardwareRevision";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addHardwareRevisionString(hardwareRevision.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HARDWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), hardwareRevision.getBytes());
    }

    @Test
    public void test_addHardwareRevisionString_00005() {
        String hardwareRevision = "hardwareRevision";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addHardwareRevisionString(0, 0, hardwareRevision.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HARDWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), hardwareRevision.getBytes());
    }

    @Test
    public void test_removeHardwareRevisionString_00001() {
        String hardwareRevision = "hardwareRevision";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addHardwareRevisionString(hardwareRevision);
        builder.removeHardwareRevisionString();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addFirmwareRevisionString_00001() {
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addFirmwareRevisionString_00002() {
        String firmwareRevision = "firmwareRevision";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addFirmwareRevisionString(firmwareRevision);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIRMWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), firmwareRevision.getBytes());
    }

    @Test
    public void test_addFirmwareRevisionString_00003() {
        String firmwareRevision = "firmwareRevision";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addFirmwareRevisionString(new FirmwareRevisionString(firmwareRevision));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIRMWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), firmwareRevision.getBytes());
    }

    @Test
    public void test_addFirmwareRevisionString_00004() {
        String firmwareRevision = "firmwareRevision";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addFirmwareRevisionString(firmwareRevision.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIRMWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), firmwareRevision.getBytes());
    }

    @Test
    public void test_addFirmwareRevisionString_00005() {
        String firmwareRevision = "firmwareRevision";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addFirmwareRevisionString(0, 0, firmwareRevision.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIRMWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), firmwareRevision.getBytes());
    }

    @Test
    public void test_removeFirmwareRevisionString_00001() {
        String firmwareRevision = "firmwareRevision";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addFirmwareRevisionString(firmwareRevision);
        builder.removeFirmwareRevisionString();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addSoftwareRevisionString_00001() {
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addSoftwareRevisionString_00002() {
        String softwareRevision = "softwareRevision";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSoftwareRevisionString(softwareRevision);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SOFTWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), softwareRevision.getBytes());
    }

    @Test
    public void test_addSoftwareRevisionString_00003() {
        String softwareRevision = "softwareRevision";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSoftwareRevisionString(new SoftwareRevisionString(softwareRevision));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SOFTWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), softwareRevision.getBytes());
    }

    @Test
    public void test_addSoftwareRevisionString_00004() {
        String softwareRevision = "softwareRevision";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSoftwareRevisionString(softwareRevision.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SOFTWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), softwareRevision.getBytes());
    }

    @Test
    public void test_addSoftwareRevisionString_00005() {
        String softwareRevision = "softwareRevision";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSoftwareRevisionString(0, 0, softwareRevision.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SOFTWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), softwareRevision.getBytes());
    }

    @Test
    public void test_removeSoftwareRevisionString_00001() {
        String softwareRevision = "softwareRevision";
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSoftwareRevisionString(softwareRevision);
        builder.removeSoftwareRevisionString();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addSystemId_00001() {
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addSystemId_00002() {
        long manufacturerIdentifier = 1;
        int organizationallyUniqueIdentifier = 2;
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSystemId(manufacturerIdentifier, organizationallyUniqueIdentifier);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SYSTEM_ID_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier).getBytes());
    }

    @Test
    public void test_addSystemId_00003() {
        long manufacturerIdentifier = 1;
        int organizationallyUniqueIdentifier = 2;
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSystemId(new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SYSTEM_ID_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier).getBytes());
    }

    @Test
    public void test_addSystemId_00004() {
        long manufacturerIdentifier = 1;
        int organizationallyUniqueIdentifier = 2;
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSystemId(new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier).getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SYSTEM_ID_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier).getBytes());
    }

    @Test
    public void test_addSystemId_00005() {
        long manufacturerIdentifier = 1;
        int organizationallyUniqueIdentifier = 2;
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSystemId(0, 0, new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier).getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SYSTEM_ID_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier).getBytes());
    }

    @Test
    public void test_removeSystemId_00001() {
        long manufacturerIdentifier = 1;
        int organizationallyUniqueIdentifier = 2;
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSystemId(manufacturerIdentifier, organizationallyUniqueIdentifier);
        builder.removeSystemId();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addIEEE_11073_20601_RegulatoryCertificationDataList_00001() {
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addIEEE_11073_20601_RegulatoryCertificationDataList_00002() {
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addIEEE_11073_20601_RegulatoryCertificationDataList(new IEEE_11073_20601_RegulatoryCertificationDataList(new byte[0]));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addIEEE_11073_20601_RegulatoryCertificationDataList_00003() {
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addIEEE_11073_20601_RegulatoryCertificationDataList(new byte[0]);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addIEEE_11073_20601_RegulatoryCertificationDataList_00004() {
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addIEEE_11073_20601_RegulatoryCertificationDataList(0, 0, new byte[0]);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_removeIEEE_11073_20601_RegulatoryCertificationDataList_00001() {
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addIEEE_11073_20601_RegulatoryCertificationDataList(new byte[0]);
        builder.removeIEEE_11073_20601_RegulatoryCertificationDataList();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addPnpId_00001() {
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addPnpId_00002() {
        int vendorIdSource = 1;
        int vendorId = 2;
        int productId = 3;
        int productVersion = 4;
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addPnpId(vendorIdSource, vendorId, productId, productVersion);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PNP_ID_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), new PnpId(vendorIdSource, vendorId, productId, productVersion).getBytes());
    }

    @Test
    public void test_addPnpId_00003() {
        int vendorIdSource = 1;
        int vendorId = 2;
        int productId = 3;
        int productVersion = 4;
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addPnpId(new PnpId(vendorIdSource, vendorId, productId, productVersion));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PNP_ID_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), new PnpId(vendorIdSource, vendorId, productId, productVersion).getBytes());
    }

    @Test
    public void test_addPnpId_00004() {
        int vendorIdSource = 1;
        int vendorId = 2;
        int productId = 3;
        int productVersion = 4;
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addPnpId(new PnpId(vendorIdSource, vendorId, productId, productVersion).getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PNP_ID_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), new PnpId(vendorIdSource, vendorId, productId, productVersion).getBytes());
    }

    @Test
    public void test_addPnpId_00005() {
        int vendorIdSource = 1;
        int vendorId = 2;
        int productId = 3;
        int productVersion = 4;
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addPnpId(0, 0, new PnpId(vendorIdSource, vendorId, productId, productVersion).getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PNP_ID_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), new PnpId(vendorIdSource, vendorId, productId, productVersion).getBytes());
    }

    @Test
    public void test_removePnpId_00001() {
        int vendorIdSource = 1;
        int vendorId = 2;
        int productId = 3;
        int productVersion = 4;
        final AtomicReference<BluetoothGattService> bluetoothGattServiceAtomicReference = new AtomicReference<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceAtomicReference.set(bluetoothGattService);
                return null;
            }
        };
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addPnpId(vendorIdSource, vendorId, productId, productVersion);
        builder.removePnpId();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);
        BluetoothGattService bluetoothGattService = bluetoothGattServiceAtomicReference.get();

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

}
