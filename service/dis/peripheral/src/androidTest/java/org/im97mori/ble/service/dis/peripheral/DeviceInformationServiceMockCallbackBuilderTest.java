package org.im97mori.ble.service.dis.peripheral;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Build;

import org.im97mori.ble.characteristic.u2a23.SystemId;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a25.SerialNumberString;
import org.im97mori.ble.characteristic.u2a26.FirmwareRevisionString;
import org.im97mori.ble.characteristic.u2a27.HardwareRevisionString;
import org.im97mori.ble.characteristic.u2a28.SoftwareRevisionString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a2a.IEEE_11073_20601_RegulatoryCertificationDataList;
import org.im97mori.ble.characteristic.u2a50.PnpId;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.FIRMWARE_REVISION_STRING_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HARDWARE_REVISION_STRING_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.MANUFACTURER_NAME_STRING_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.MODEL_NUMBER_STRING_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PNP_ID_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SERIAL_NUMBER_STRING_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SOFTWARE_REVISION_STRING_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SYSTEM_ID_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

public class DeviceInformationServiceMockCallbackBuilderTest extends AbstractPeripherallTest {

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addManufacturerNameString_00001() {
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder =
                new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addManufacturerNameString_00002() {
        String manufacturerName = "manufacturerName";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback callback = new DeviceInformationServiceMockCallback.Builder<>().addManufacturerNameString(manufacturerName).build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MANUFACTURER_NAME_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), manufacturerName.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addManufacturerNameString_00003() {
        String manufacturerName = "manufacturerName";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addManufacturerNameString(new ManufacturerNameString(manufacturerName));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MANUFACTURER_NAME_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), manufacturerName.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addManufacturerNameString_00004() {
        String manufacturerName = "manufacturerName";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addManufacturerNameString(manufacturerName.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MANUFACTURER_NAME_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), manufacturerName.getBytes());
    }


    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addManufacturerNameString_00005() {
        String manufacturerName = "manufacturerName";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addManufacturerNameString(0, 0, manufacturerName.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MANUFACTURER_NAME_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), manufacturerName.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeManufacturerNameString_00001() {
        String manufacturerName = "manufacturerName";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback callback = new DeviceInformationServiceMockCallback.Builder<>()
                .addManufacturerNameString(manufacturerName)
                .removeManufacturerNameString()
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addModelNumberString_00001() {
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addModelNumberString_00002() {
        String modelNumber = "modelNumber";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addModelNumberString(modelNumber);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MODEL_NUMBER_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), modelNumber.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addModelNumberString_00003() {
        String modelNumber = "modelNumber";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addModelNumberString(new ModelNumberString(modelNumber));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MODEL_NUMBER_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), modelNumber.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addModelNumberString_00004() {
        String modelNumber = "modelNumber";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addModelNumberString(modelNumber.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MODEL_NUMBER_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), modelNumber.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addModelNumberString_00005() {
        String modelNumber = "modelNumber";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addModelNumberString(0, 0, modelNumber.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MODEL_NUMBER_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), modelNumber.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeModelNumberString_00001() {
        String modelNumber = "modelNumber";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback callback = new DeviceInformationServiceMockCallback.Builder<>()
                .addModelNumberString(modelNumber)
                .removeModelNumberString()
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSerialNumberString_00001() {
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSerialNumberString_00002() {
        String serialNumber = "serialNumber";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSerialNumberString(serialNumber);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SERIAL_NUMBER_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), serialNumber.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSerialNumberString_00003() {
        String serialNumber = "serialNumber";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSerialNumberString(new SerialNumberString(serialNumber));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SERIAL_NUMBER_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), serialNumber.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSerialNumberString_00004() {
        String serialNumber = "serialNumber";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSerialNumberString(serialNumber.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SERIAL_NUMBER_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), serialNumber.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSerialNumberString_00005() {
        String serialNumber = "serialNumber";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSerialNumberString(0, 0, serialNumber.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SERIAL_NUMBER_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), serialNumber.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeSerialNumberString_00001() {
        String serialNumber = "serialNumber";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback callback = new DeviceInformationServiceMockCallback.Builder<>()
                .addSerialNumberString(serialNumber)
                .removeSerialNumberString()
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addHardwareRevisionString_00001() {
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addHardwareRevisionString_00002() {
        String hardwareRevision = "hardwareRevision";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addHardwareRevisionString(hardwareRevision);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HARDWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), hardwareRevision.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addHardwareRevisionString_00003() {
        String hardwareRevision = "hardwareRevision";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addHardwareRevisionString(new HardwareRevisionString(hardwareRevision));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HARDWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), hardwareRevision.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addHardwareRevisionString_00004() {
        String hardwareRevision = "hardwareRevision";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addHardwareRevisionString(hardwareRevision.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HARDWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), hardwareRevision.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addHardwareRevisionString_00005() {
        String hardwareRevision = "hardwareRevision";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addHardwareRevisionString(0, 0, hardwareRevision.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HARDWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), hardwareRevision.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeHardwareRevisionString_00001() {
        String hardwareRevision = "hardwareRevision";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback callback = new DeviceInformationServiceMockCallback.Builder<>()
                .addHardwareRevisionString(hardwareRevision)
                .removeHardwareRevisionString()
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addFirmwareRevisionString_00001() {
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addFirmwareRevisionString_00002() {
        String firmwareRevision = "firmwareRevision";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addFirmwareRevisionString(firmwareRevision);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIRMWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), firmwareRevision.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addFirmwareRevisionString_00003() {
        String firmwareRevision = "firmwareRevision";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addFirmwareRevisionString(new FirmwareRevisionString(firmwareRevision));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIRMWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), firmwareRevision.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addFirmwareRevisionString_00004() {
        String firmwareRevision = "firmwareRevision";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addFirmwareRevisionString(firmwareRevision.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIRMWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), firmwareRevision.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addFirmwareRevisionString_00005() {
        String firmwareRevision = "firmwareRevision";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addFirmwareRevisionString(0, 0, firmwareRevision.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIRMWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), firmwareRevision.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeFirmwareRevisionString_00001() {
        String firmwareRevision = "firmwareRevision";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback callback = new DeviceInformationServiceMockCallback.Builder<>()
                .addFirmwareRevisionString(firmwareRevision)
                .removeFirmwareRevisionString()
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSoftwareRevisionString_00001() {
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSoftwareRevisionString_00002() {
        String softwareRevision = "softwareRevision";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSoftwareRevisionString(softwareRevision);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SOFTWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), softwareRevision.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSoftwareRevisionString_00003() {
        String softwareRevision = "softwareRevision";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSoftwareRevisionString(new SoftwareRevisionString(softwareRevision));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SOFTWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), softwareRevision.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSoftwareRevisionString_00004() {
        String softwareRevision = "softwareRevision";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSoftwareRevisionString(softwareRevision.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SOFTWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), softwareRevision.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSoftwareRevisionString_00005() {
        String softwareRevision = "softwareRevision";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSoftwareRevisionString(0, 0, softwareRevision.getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SOFTWARE_REVISION_STRING_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), softwareRevision.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeSoftwareRevisionString_00001() {
        String softwareRevision = "softwareRevision";
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback callback = new DeviceInformationServiceMockCallback.Builder<>()
                .addSoftwareRevisionString(softwareRevision)
                .removeSoftwareRevisionString()
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSystemId_00001() {
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSystemId_00002() {
        long manufacturerIdentifier = 1;
        int organizationallyUniqueIdentifier = 2;
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSystemId(manufacturerIdentifier, organizationallyUniqueIdentifier);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SYSTEM_ID_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier).getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSystemId_00003() {
        long manufacturerIdentifier = 1;
        int organizationallyUniqueIdentifier = 2;
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSystemId(new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SYSTEM_ID_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier).getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSystemId_00004() {
        long manufacturerIdentifier = 1;
        int organizationallyUniqueIdentifier = 2;
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSystemId(new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier).getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SYSTEM_ID_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier).getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addSystemId_00005() {
        long manufacturerIdentifier = 1;
        int organizationallyUniqueIdentifier = 2;
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addSystemId(0, 0, new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier).getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SYSTEM_ID_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier).getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeSystemId_00001() {
        long manufacturerIdentifier = 1;
        int organizationallyUniqueIdentifier = 2;
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback callback = new DeviceInformationServiceMockCallback.Builder<>()
                .addSystemId(manufacturerIdentifier, organizationallyUniqueIdentifier)
                .removeSystemId()
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addIEEE_11073_20601_RegulatoryCertificationDataList_00001() {
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addIEEE_11073_20601_RegulatoryCertificationDataList_00002() {
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback callback = new DeviceInformationServiceMockCallback.Builder<>().addIEEE_11073_20601_RegulatoryCertificationDataList(new IEEE_11073_20601_RegulatoryCertificationDataList(new byte[0])).build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addIEEE_11073_20601_RegulatoryCertificationDataList_00003() {
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addIEEE_11073_20601_RegulatoryCertificationDataList(new byte[0]);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addIEEE_11073_20601_RegulatoryCertificationDataList_00004() {
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addIEEE_11073_20601_RegulatoryCertificationDataList(0, 0, new byte[0]);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(IEEE_11073_20601_REGULATORY_CERTIFICATION_DATA_LIST_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeIEEE_11073_20601_RegulatoryCertificationDataList_00001() {
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback callback = new DeviceInformationServiceMockCallback.Builder<>()
                .addIEEE_11073_20601_RegulatoryCertificationDataList(new byte[0])
                .removeIEEE_11073_20601_RegulatoryCertificationDataList()
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addPnpId_00001() {
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addPnpId_00002() {
        int vendorIdSource = 1;
        int vendorId = 2;
        int productId = 3;
        int productVersion = 4;
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addPnpId(vendorIdSource, vendorId, productId, productVersion);
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PNP_ID_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), new PnpId(vendorIdSource, vendorId, productId, productVersion).getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addPnpId_00003() {
        int vendorIdSource = 1;
        int vendorId = 2;
        int productId = 3;
        int productVersion = 4;
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addPnpId(new PnpId(vendorIdSource, vendorId, productId, productVersion));
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PNP_ID_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), new PnpId(vendorIdSource, vendorId, productId, productVersion).getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addPnpId_00004() {
        int vendorIdSource = 1;
        int vendorId = 2;
        int productId = 3;
        int productVersion = 4;
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addPnpId(new PnpId(vendorIdSource, vendorId, productId, productVersion).getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PNP_ID_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), new PnpId(vendorIdSource, vendorId, productId, productVersion).getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addPnpId_00005() {
        int vendorIdSource = 1;
        int vendorId = 2;
        int productId = 3;
        int productVersion = 4;
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback.Builder<DeviceInformationServiceMockCallback> builder = new DeviceInformationServiceMockCallback.Builder<>();
        builder.addPnpId(0, 0, new PnpId(vendorIdSource, vendorId, productId, productVersion).getBytes());
        DeviceInformationServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PNP_ID_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), new PnpId(vendorIdSource, vendorId, productId, productVersion).getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removePnpId_00001() {
        int vendorIdSource = 1;
        int vendorId = 2;
        int productId = 3;
        int productVersion = 4;
        List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        DeviceInformationServiceMockCallback callback = new DeviceInformationServiceMockCallback.Builder<>()
                .addPnpId(vendorIdSource, vendorId, productId, productVersion)
                .removePnpId()
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(DEVICE_INFORMATION_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

}
