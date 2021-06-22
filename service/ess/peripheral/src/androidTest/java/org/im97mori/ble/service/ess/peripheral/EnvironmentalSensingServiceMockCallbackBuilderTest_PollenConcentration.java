package org.im97mori.ble.service.ess.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

import org.im97mori.ble.characteristic.u2a75.PollenConcentration;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2906.ValidRange;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfiguration;
import org.im97mori.ble.descriptor.u290c.EnvironmentalSensingMeasurement;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSetting;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.POLLEN_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.ENVIRONMENTAL_SENSING_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class EnvironmentalSensingServiceMockCallbackBuilderTest_PollenConcentration extends AbstractPeripherallTest {

    @Test
    public void test_addPollenConcentration_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>().build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_addPollenConcentration_00002() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, originalValue)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(POLLEN_CONCENTRATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addPollenConcentration_00003() {
        int characteristicIndex = 0;
        int originalProperties = BluetoothGattCharacteristic.PROPERTY_READ;
        PollenConcentration originalValue = new PollenConcentration(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, originalProperties, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(POLLEN_CONCENTRATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(originalProperties, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addPollenConcentration_00101() {
        int characteristicIndex0 = 0;
        int characteristicIndex1 = 1;
        int originalProperties0 = BluetoothGattCharacteristic.PROPERTY_READ;
        PollenConcentration originalValue0 = new PollenConcentration(1);
        int originalProperties1 = BluetoothGattCharacteristic.PROPERTY_READ;
        PollenConcentration originalValue1 = new PollenConcentration(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex0, originalProperties0, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .addPollenConcentration(characteristicIndex1, originalProperties1, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(2, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex0);
        assertEquals(POLLEN_CONCENTRATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(originalProperties0, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue0.getBytes(), bluetoothGattCharacteristic.getValue());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex1);
        assertEquals(POLLEN_CONCENTRATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(originalProperties1, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue1.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removePollenConcentration_00001() {
        int characteristicIndex = 0;
        int originalProperties = BluetoothGattCharacteristic.PROPERTY_READ;
        PollenConcentration originalValue = new PollenConcentration(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, originalProperties, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .removePollenConcentration(characteristicIndex)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_removePollenConcentration_00101() {
        int characteristicIndex0 = 0;
        int characteristicIndex1 = 1;
        int originalProperties0 = BluetoothGattCharacteristic.PROPERTY_READ;
        PollenConcentration originalValue0 = new PollenConcentration(1);
        int originalProperties1 = BluetoothGattCharacteristic.PROPERTY_READ;
        PollenConcentration originalValue1 = new PollenConcentration(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex0, originalProperties0, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .addPollenConcentration(characteristicIndex1, originalProperties1, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .removePollenConcentration(characteristicIndex0)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(1, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex0);
        assertEquals(POLLEN_CONCENTRATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(originalProperties1, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue1.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_setPollenConcentrationEsMeasurement_00001() {
        int characteristicIndex = 0;
        int originalProperties = BluetoothGattCharacteristic.PROPERTY_READ;
        PollenConcentration originalValue = new PollenConcentration(1);
        EnvironmentalSensingMeasurement environmentalSensingMeasurement = new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, originalProperties, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex, environmentalSensingMeasurement)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(1, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingMeasurement.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setPollenConcentrationEsMeasurement_00101() {
        int characteristicIndex0 = 0;
        int characteristicIndex1 = 1;
        int originalProperties0 = BluetoothGattCharacteristic.PROPERTY_READ;
        PollenConcentration originalValue0 = new PollenConcentration(1);
        EnvironmentalSensingMeasurement environmentalSensingMeasurement0 = new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0);
        int originalProperties1 = BluetoothGattCharacteristic.PROPERTY_READ;
        PollenConcentration originalValue1 = new PollenConcentration(2);
        EnvironmentalSensingMeasurement environmentalSensingMeasurement1 = new EnvironmentalSensingMeasurement(new byte[2], 1, 1, 1, 1, 1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex0, originalProperties0, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex0, environmentalSensingMeasurement0)
                .addPollenConcentration(characteristicIndex1, originalProperties1, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex1, environmentalSensingMeasurement1)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(2, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex0);
        assertEquals(originalProperties0, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue0.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingMeasurement0.getBytes(), bluetoothGattDescriptor.getValue());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex1);
        assertEquals(originalProperties1, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue1.getBytes(), bluetoothGattCharacteristic.getValue());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingMeasurement1.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removePollenConcentrationEsMeasurement_00001() {
        int characteristicIndex = 0;
        int originalProperties = BluetoothGattCharacteristic.PROPERTY_READ;
        PollenConcentration originalValue = new PollenConcentration(1);
        EnvironmentalSensingMeasurement environmentalSensingMeasurement = new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, originalProperties, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex, environmentalSensingMeasurement)
                .removePollenConcentrationEsMeasurement(characteristicIndex)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(1, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removePollenConcentrationEsMeasurement_00101() {
        int characteristicIndex0 = 0;
        int characteristicIndex1 = 1;
        int originalProperties0 = BluetoothGattCharacteristic.PROPERTY_READ;
        PollenConcentration originalValue0 = new PollenConcentration(1);
        EnvironmentalSensingMeasurement environmentalSensingMeasurement0 = new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0);
        int originalProperties1 = BluetoothGattCharacteristic.PROPERTY_READ;
        PollenConcentration originalValue1 = new PollenConcentration(2);
        EnvironmentalSensingMeasurement environmentalSensingMeasurement1 = new EnvironmentalSensingMeasurement(new byte[2], 1, 1, 1, 1, 1);

        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(characteristicIndex0, originalProperties0, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                    .setPollenConcentrationEsMeasurement(characteristicIndex0, environmentalSensingMeasurement0)
                    .removePollenConcentrationEsMeasurement(characteristicIndex0)
                    .addPollenConcentration(characteristicIndex1, originalProperties1, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                    .setPollenConcentrationEsMeasurement(characteristicIndex1, environmentalSensingMeasurement1)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + POLLEN_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_setPollenConcentrationEsTriggerSetting_00001() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, originalValue)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setPollenConcentrationEsTriggerSetting_00002() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, originalValue)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setPollenConcentrationEsTriggerSetting_00003() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, originalValue)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setPollenConcentrationEsTriggerSetting_00004() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex = 3;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_setPollenConcentrationEsTriggerSetting_00101() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(3);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, originalValue)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .setPollenConcentrationEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        List<BluetoothGattDescriptor> bluetoothGattDescriptorList = bluetoothGattCharacteristic.getDescriptors();
        assertEquals(3, bluetoothGattDescriptorList.size());

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattDescriptorList.get(0);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingTriggerSetting0.getBytes(), bluetoothGattDescriptor.getValue());

        bluetoothGattDescriptor = bluetoothGattDescriptorList.get(1);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setPollenConcentrationEsTriggerSetting_00102() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, originalValue)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .setPollenConcentrationEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        List<BluetoothGattDescriptor> bluetoothGattDescriptorList = bluetoothGattCharacteristic.getDescriptors();
        assertEquals(3, bluetoothGattDescriptorList.size());

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattDescriptorList.get(0);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingTriggerSetting0.getBytes(), bluetoothGattDescriptor.getValue());

        bluetoothGattDescriptor = bluetoothGattDescriptorList.get(1);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingTriggerSetting1.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setPollenConcentrationEsTriggerSetting_00103() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, originalValue)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .setPollenConcentrationEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        List<BluetoothGattDescriptor> bluetoothGattDescriptorList = bluetoothGattCharacteristic.getDescriptors();
        assertEquals(3, bluetoothGattDescriptorList.size());

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattDescriptorList.get(0);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingTriggerSetting1.getBytes(), bluetoothGattDescriptor.getValue());

        bluetoothGattDescriptor = bluetoothGattDescriptorList.get(1);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setPollenConcentrationEsTriggerSetting_00104() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(0);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, originalValue)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .setPollenConcentrationEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        List<BluetoothGattDescriptor> bluetoothGattDescriptorList = bluetoothGattCharacteristic.getDescriptors();
        assertEquals(4, bluetoothGattDescriptorList.size());

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattDescriptorList.get(0);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingTriggerSetting0.getBytes(), bluetoothGattDescriptor.getValue());

        bluetoothGattDescriptor = bluetoothGattDescriptorList.get(1);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingTriggerSetting1.getBytes(), bluetoothGattDescriptor.getValue());

        bluetoothGattDescriptor = bluetoothGattDescriptorList.get(2);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingTriggerSetting2.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removePollenConcentrationEsTriggerSetting_00001() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .removePollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removePollenConcentrationEsTriggerSetting_00002() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .removePollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removePollenConcentrationEsTriggerSetting_00003() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .removePollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removePollenConcentrationEsTriggerSetting_00004() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex = 3;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .removePollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removePollenConcentrationEsTriggerSetting_00101() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(3);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .removePollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .removePollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2)
                .setPollenConcentrationEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removePollenConcentrationEsTriggerSetting_00102() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .removePollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .removePollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1)
                .setPollenConcentrationEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removePollenConcentrationEsTriggerSetting_00103() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .removePollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .removePollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2)
                .setPollenConcentrationEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removePollenConcentrationEsTriggerSetting_00104() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(0);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .removePollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .removePollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .removePollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex2)
                .setPollenConcentrationEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_setPollenConcentrationEsConfiguration_00001() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(2);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, originalValue)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, 0, environmentalSensingTriggerSetting0)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, 1, environmentalSensingTriggerSetting1)
                .setPollenConcentrationEsConfiguration(characteristicIndex, environmentalSensingConfiguration)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setPollenConcentrationEsConfiguration_00002() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(2);
        int descriptorPermission = BluetoothGattDescriptor.PERMISSION_READ;
        EnvironmentalSensingConfiguration environmentalSensingConfiguration = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, originalValue)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, 0, environmentalSensingTriggerSetting0)
                .setPollenConcentrationEsTriggerSetting(characteristicIndex, 1, environmentalSensingTriggerSetting1)
                .setPollenConcentrationEsConfiguration(characteristicIndex, descriptorPermission, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes())
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(descriptorPermission, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setPollenConcentrationEsConfiguration_00101() {
        int characteristicIndex0 = 0;
        PollenConcentration originalValue0 = new PollenConcentration(1);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration0 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        int characteristicIndex1 = 1;
        PollenConcentration originalValue1 = new PollenConcentration(2);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration1 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex0, originalValue0)
                .setPollenConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setPollenConcentrationEsTriggerSetting(characteristicIndex0, 0, new EnvironmentalSensingTriggerSetting(1))
                .setPollenConcentrationEsTriggerSetting(characteristicIndex0, 1, new EnvironmentalSensingTriggerSetting(2))
                .setPollenConcentrationEsConfiguration(characteristicIndex0, environmentalSensingConfiguration0)
                .addPollenConcentration(characteristicIndex1, originalValue1)
                .setPollenConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setPollenConcentrationEsTriggerSetting(characteristicIndex1, 0, new EnvironmentalSensingTriggerSetting(3))
                .setPollenConcentrationEsTriggerSetting(characteristicIndex1, 1, new EnvironmentalSensingTriggerSetting(4))
                .setPollenConcentrationEsConfiguration(characteristicIndex1, environmentalSensingConfiguration1)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(3, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue0.getBytes(), bluetoothGattCharacteristic.getValue());
        List<BluetoothGattDescriptor> bluetoothGattDescriptorList = bluetoothGattCharacteristic.getDescriptors();
        assertEquals(3, bluetoothGattCharacteristicList.size());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattDescriptorList.get(3);
        assertEquals(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingConfiguration0.getBytes(), bluetoothGattDescriptor.getValue());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue1.getBytes(), bluetoothGattCharacteristic.getValue());
        bluetoothGattDescriptorList = bluetoothGattCharacteristic.getDescriptors();
        assertEquals(3, bluetoothGattCharacteristicList.size());
        bluetoothGattDescriptor = bluetoothGattDescriptorList.get(3);
        assertEquals(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingConfiguration1.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setPollenConcentrationEsConfiguration_00102() {
        int characteristicIndex0 = 0;
        PollenConcentration originalValue0 = new PollenConcentration(1);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration0 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        int characteristicIndex1 = 1;
        PollenConcentration originalValue1 = new PollenConcentration(2);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration1 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        int descriptorPermission = BluetoothGattDescriptor.PERMISSION_READ;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex0, originalValue0)
                .setPollenConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setPollenConcentrationEsTriggerSetting(characteristicIndex0, 0, new EnvironmentalSensingTriggerSetting(1))
                .setPollenConcentrationEsTriggerSetting(characteristicIndex0, 1, new EnvironmentalSensingTriggerSetting(2))
                .setPollenConcentrationEsConfiguration(characteristicIndex0, descriptorPermission, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration0.getBytes())
                .addPollenConcentration(characteristicIndex1, originalValue1)
                .setPollenConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setPollenConcentrationEsTriggerSetting(characteristicIndex1, 0, new EnvironmentalSensingTriggerSetting(3))
                .setPollenConcentrationEsTriggerSetting(characteristicIndex1, 1, new EnvironmentalSensingTriggerSetting(4))
                .setPollenConcentrationEsConfiguration(characteristicIndex1, descriptorPermission, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration1.getBytes())
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(3, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue0.getBytes(), bluetoothGattCharacteristic.getValue());
        List<BluetoothGattDescriptor> bluetoothGattDescriptorList = bluetoothGattCharacteristic.getDescriptors();
        assertEquals(3, bluetoothGattCharacteristicList.size());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattDescriptorList.get(3);
        assertEquals(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(descriptorPermission, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingConfiguration0.getBytes(), bluetoothGattDescriptor.getValue());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue1.getBytes(), bluetoothGattCharacteristic.getValue());
        bluetoothGattDescriptorList = bluetoothGattCharacteristic.getDescriptors();
        assertEquals(3, bluetoothGattCharacteristicList.size());
        bluetoothGattDescriptor = bluetoothGattDescriptorList.get(3);
        assertEquals(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(descriptorPermission, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingConfiguration1.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removePollenConcentrationEsConfiguration_00001() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(2);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(characteristicIndex, originalValue)
                    .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                    .setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                    .setPollenConcentrationEsConfiguration(characteristicIndex, environmentalSensingConfiguration)
                    .removePollenConcentrationEsConfiguration(characteristicIndex)
                    .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + POLLEN_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_removePollenConcentrationEsConfiguration_00101() {
        int characteristicIndex0 = 0;
        PollenConcentration originalValue0 = new PollenConcentration(1);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration0 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        int characteristicIndex1 = 1;
        PollenConcentration originalValue1 = new PollenConcentration(2);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration1 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addPollenConcentration(characteristicIndex0, originalValue0)
                    .setPollenConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                    .setPollenConcentrationEsTriggerSetting(characteristicIndex0, 0, new EnvironmentalSensingTriggerSetting(1))
                    .setPollenConcentrationEsTriggerSetting(characteristicIndex0, 1, new EnvironmentalSensingTriggerSetting(2))
                    .setPollenConcentrationEsConfiguration(characteristicIndex0, environmentalSensingConfiguration0)
                    .removePollenConcentrationEsMeasurement(characteristicIndex0)
                    .addPollenConcentration(characteristicIndex1, originalValue1)
                    .setPollenConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                    .setPollenConcentrationEsTriggerSetting(characteristicIndex1, 0, new EnvironmentalSensingTriggerSetting(3))
                    .setPollenConcentrationEsTriggerSetting(characteristicIndex1, 1, new EnvironmentalSensingTriggerSetting(4))
                    .setPollenConcentrationEsConfiguration(characteristicIndex1, environmentalSensingConfiguration1)
                    .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + POLLEN_CONCENTRATION_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_setPollenConcentrationCharacteristicUserDescription_00001() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        CharacteristicUserDescription characteristicUserDescription = new CharacteristicUserDescription(new byte[]{0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationCharacteristicUserDescription(characteristicIndex, characteristicUserDescription)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicUserDescription.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setPollenConcentrationCharacteristicUserDescription_00002() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        CharacteristicUserDescription characteristicUserDescription = new CharacteristicUserDescription(new byte[]{0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationCharacteristicUserDescription(characteristicIndex, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicUserDescription.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setPollenConcentrationCharacteristicUserDescription_00101() {
        int characteristicIndex0 = 0;
        PollenConcentration originalValue0 = new PollenConcentration(1);
        CharacteristicUserDescription characteristicUserDescription0 = new CharacteristicUserDescription(new byte[]{0});

        int characteristicIndex1 = 1;
        PollenConcentration originalValue1 = new PollenConcentration(2);
        CharacteristicUserDescription characteristicUserDescription1 = new CharacteristicUserDescription(new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setPollenConcentrationCharacteristicUserDescription(characteristicIndex0, characteristicUserDescription0)
                .addPollenConcentration(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setPollenConcentrationCharacteristicUserDescription(characteristicIndex1, characteristicUserDescription1)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(3, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue0.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicUserDescription0.getBytes(), bluetoothGattDescriptor.getValue());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue1.getBytes(), bluetoothGattCharacteristic.getValue());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicUserDescription1.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setPollenConcentrationCharacteristicUserDescription_00102() {
        int characteristicIndex0 = 0;
        PollenConcentration originalValue0 = new PollenConcentration(1);
        CharacteristicUserDescription characteristicUserDescription0 = new CharacteristicUserDescription(new byte[]{0});

        int characteristicIndex1 = 1;
        PollenConcentration originalValue1 = new PollenConcentration(2);
        CharacteristicUserDescription characteristicUserDescription1 = new CharacteristicUserDescription(new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setPollenConcentrationCharacteristicUserDescription(characteristicIndex0, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription0.getBytes())
                .addPollenConcentration(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setPollenConcentrationCharacteristicUserDescription(characteristicIndex1, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription1.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(2, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue0.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicUserDescription0.getBytes(), bluetoothGattDescriptor.getValue());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue1.getBytes(), bluetoothGattCharacteristic.getValue());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicUserDescription1.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removePollenConcentrationCharacteristicUserDescription_00001() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        CharacteristicUserDescription characteristicUserDescription = new CharacteristicUserDescription(new byte[]{0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationCharacteristicUserDescription(characteristicIndex, characteristicUserDescription)
                .removePollenConcentrationCharacteristicUserDescription(characteristicIndex)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removePollenConcentrationCharacteristicUserDescription_00101() {
        int characteristicIndex0 = 0;
        PollenConcentration originalValue0 = new PollenConcentration(1);
        CharacteristicUserDescription characteristicUserDescription0 = new CharacteristicUserDescription(new byte[]{0});

        int characteristicIndex1 = 1;
        PollenConcentration originalValue1 = new PollenConcentration(2);
        CharacteristicUserDescription characteristicUserDescription1 = new CharacteristicUserDescription(new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setPollenConcentrationCharacteristicUserDescription(characteristicIndex0, characteristicUserDescription0)
                .removePollenConcentrationCharacteristicUserDescription(characteristicIndex0)
                .addPollenConcentration(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setPollenConcentrationCharacteristicUserDescription(characteristicIndex1, characteristicUserDescription1)
                .removePollenConcentrationCharacteristicUserDescription(characteristicIndex1)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(2, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue0.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue1.getBytes(), bluetoothGattCharacteristic.getValue());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_setPollenConcentrationValidRange_00001() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        ValidRange validRange = new ValidRange(new byte[]{0}, new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationValidRange(characteristicIndex, validRange)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(validRange.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setPollenConcentrationValidRange_00002() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        ValidRange validRange = new ValidRange(new byte[]{0}, new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationValidRange(characteristicIndex, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(validRange.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setPollenConcentrationValidRange_00101() {
        int characteristicIndex0 = 0;
        PollenConcentration originalValue0 = new PollenConcentration(1);
        ValidRange validRange0 = new ValidRange(new byte[]{0}, new byte[]{1});

        int characteristicIndex1 = 1;
        PollenConcentration originalValue1 = new PollenConcentration(2);
        ValidRange validRange1 = new ValidRange(new byte[]{2}, new byte[]{3});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setPollenConcentrationValidRange(characteristicIndex0, validRange0)
                .addPollenConcentration(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setPollenConcentrationValidRange(characteristicIndex1, validRange1)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(2, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue0.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(validRange0.getBytes(), bluetoothGattDescriptor.getValue());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue1.getBytes(), bluetoothGattCharacteristic.getValue());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(validRange1.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setPollenConcentrationValidRange_00102() {
        int characteristicIndex0 = 0;
        PollenConcentration originalValue0 = new PollenConcentration(1);
        ValidRange validRange0 = new ValidRange(new byte[]{0}, new byte[]{1});

        int characteristicIndex1 = 1;
        PollenConcentration originalValue1 = new PollenConcentration(2);
        ValidRange validRange1 = new ValidRange(new byte[]{2}, new byte[]{3});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setPollenConcentrationValidRange(characteristicIndex0, BluetoothGatt.GATT_SUCCESS, 0, validRange0.getBytes())
                .addPollenConcentration(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setPollenConcentrationValidRange(characteristicIndex1, BluetoothGatt.GATT_SUCCESS, 0, validRange1.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(2, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue0.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(validRange0.getBytes(), bluetoothGattDescriptor.getValue());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue1.getBytes(), bluetoothGattCharacteristic.getValue());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(validRange1.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removePollenConcentrationValidRange_00001() {
        int characteristicIndex = 0;
        PollenConcentration originalValue = new PollenConcentration(1);
        ValidRange validRange = new ValidRange(new byte[]{0}, new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setPollenConcentrationValidRange(characteristicIndex, validRange)
                .removePollenConcentrationValidRange(characteristicIndex)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POLLEN_CONCENTRATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removePollenConcentrationValidRange_00101() {
        int characteristicIndex0 = 0;
        PollenConcentration originalValue0 = new PollenConcentration(1);
        ValidRange validRange0 = new ValidRange(new byte[]{0}, new byte[]{1});

        int characteristicIndex1 = 1;
        PollenConcentration originalValue1 = new PollenConcentration(2);
        ValidRange validRange1 = new ValidRange(new byte[]{2}, new byte[]{3});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addPollenConcentration(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setPollenConcentrationValidRange(characteristicIndex0, validRange0)
                .removePollenConcentrationValidRange(characteristicIndex0)
                .addPollenConcentration(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setPollenConcentrationEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setPollenConcentrationValidRange(characteristicIndex1, validRange1)
                .removePollenConcentrationValidRange(characteristicIndex1)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(3, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(0);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue0.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(1);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue1.getBytes(), bluetoothGattCharacteristic.getValue());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

}
