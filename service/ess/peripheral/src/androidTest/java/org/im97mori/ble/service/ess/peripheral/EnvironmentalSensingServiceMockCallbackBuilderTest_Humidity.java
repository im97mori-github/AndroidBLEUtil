package org.im97mori.ble.service.ess.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

import org.im97mori.ble.characteristic.u2a6f.Humidity;
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

import static org.im97mori.ble.constants.CharacteristicUUID.HUMIDITY_CHARACTERISTIC;
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

public class EnvironmentalSensingServiceMockCallbackBuilderTest_Humidity extends AbstractPeripherallTest {

    @Test
    public void test_addHumidity_00001() {
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
    public void test_addHumidity_00002() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, originalValue)
                .setHumidityEsTriggerSetting(characteristicIndex, 0, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, new EnvironmentalSensingTriggerSetting(0).getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HUMIDITY_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addHumidity_00003() {
        int characteristicIndex = 0;
        int originalProperties = BluetoothGattCharacteristic.PROPERTY_READ;
        Humidity originalValue = new Humidity(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, originalProperties, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HUMIDITY_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(originalProperties, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addHumidity_00101() {
        int characteristicIndex0 = 0;
        int characteristicIndex1 = 1;
        int originalProperties0 = BluetoothGattCharacteristic.PROPERTY_READ;
        Humidity originalValue0 = new Humidity(1);
        int originalProperties1 = BluetoothGattCharacteristic.PROPERTY_READ;
        Humidity originalValue1 = new Humidity(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex0, originalProperties0, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setHumidityEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .addHumidity(characteristicIndex1, originalProperties1, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setHumidityEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(2, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex0);
        assertEquals(HUMIDITY_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(originalProperties0, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue0.getBytes(), bluetoothGattCharacteristic.getValue());

        bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex1);
        assertEquals(HUMIDITY_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(originalProperties1, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue1.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeHumidity_00001() {
        int characteristicIndex = 0;
        int originalProperties = BluetoothGattCharacteristic.PROPERTY_READ;
        Humidity originalValue = new Humidity(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, originalProperties, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .removeHumidity(characteristicIndex)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());
        assertTrue(bluetoothGattService.getCharacteristics().isEmpty());
    }

    @Test
    public void test_removeHumidity_00101() {
        int characteristicIndex0 = 0;
        int characteristicIndex1 = 1;
        int originalProperties0 = BluetoothGattCharacteristic.PROPERTY_READ;
        Humidity originalValue0 = new Humidity(1);
        int originalProperties1 = BluetoothGattCharacteristic.PROPERTY_READ;
        Humidity originalValue1 = new Humidity(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex0, originalProperties0, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setHumidityEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .addHumidity(characteristicIndex1, originalProperties1, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setHumidityEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .removeHumidity(characteristicIndex0)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        List<BluetoothGattCharacteristic> bluetoothGattCharacteristicList = bluetoothGattService.getCharacteristics();
        assertEquals(1, bluetoothGattCharacteristicList.size());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattCharacteristicList.get(characteristicIndex0);
        assertEquals(HUMIDITY_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(originalProperties1, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(originalValue1.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_setHumidityEsMeasurement_00001() {
        int characteristicIndex = 0;
        int originalProperties = BluetoothGattCharacteristic.PROPERTY_READ;
        Humidity originalValue = new Humidity(1);
        EnvironmentalSensingMeasurement environmentalSensingMeasurement = new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, originalProperties, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityEsMeasurement(characteristicIndex, environmentalSensingMeasurement)
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
    public void test_setHumidityEsMeasurement_00101() {
        int characteristicIndex0 = 0;
        int characteristicIndex1 = 1;
        int originalProperties0 = BluetoothGattCharacteristic.PROPERTY_READ;
        Humidity originalValue0 = new Humidity(1);
        EnvironmentalSensingMeasurement environmentalSensingMeasurement0 = new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0);
        int originalProperties1 = BluetoothGattCharacteristic.PROPERTY_READ;
        Humidity originalValue1 = new Humidity(2);
        EnvironmentalSensingMeasurement environmentalSensingMeasurement1 = new EnvironmentalSensingMeasurement(new byte[2], 1, 1, 1, 1, 1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex0, originalProperties0, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setHumidityEsMeasurement(characteristicIndex0, environmentalSensingMeasurement0)
                .addHumidity(characteristicIndex1, originalProperties1, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setHumidityEsMeasurement(characteristicIndex1, environmentalSensingMeasurement1)
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
    public void test_removeHumidityEsMeasurement_00001() {
        int characteristicIndex = 0;
        int originalProperties = BluetoothGattCharacteristic.PROPERTY_READ;
        Humidity originalValue = new Humidity(1);
        EnvironmentalSensingMeasurement environmentalSensingMeasurement = new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, originalProperties, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityEsMeasurement(characteristicIndex, environmentalSensingMeasurement)
                .removeHumidityEsMeasurement(characteristicIndex)
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
    public void test_removeHumidityEsMeasurement_00101() {
        int characteristicIndex0 = 0;
        int characteristicIndex1 = 1;
        int originalProperties0 = BluetoothGattCharacteristic.PROPERTY_READ;
        Humidity originalValue0 = new Humidity(1);
        EnvironmentalSensingMeasurement environmentalSensingMeasurement0 = new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0);
        int originalProperties1 = BluetoothGattCharacteristic.PROPERTY_READ;
        Humidity originalValue1 = new Humidity(2);
        EnvironmentalSensingMeasurement environmentalSensingMeasurement1 = new EnvironmentalSensingMeasurement(new byte[2], 1, 1, 1, 1, 1);

        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(characteristicIndex0, originalProperties0, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                    .setHumidityEsMeasurement(characteristicIndex0, environmentalSensingMeasurement0)
                    .removeHumidityEsMeasurement(characteristicIndex0)
                    .addHumidity(characteristicIndex1, originalProperties1, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                    .setHumidityEsMeasurement(characteristicIndex1, environmentalSensingMeasurement1)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + HUMIDITY_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_setHumidityEsTriggerSetting_00001() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, originalValue)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setHumidityEsTriggerSetting_00002() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, originalValue)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setHumidityEsTriggerSetting_00003() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, originalValue)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingTriggerSetting.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setHumidityEsTriggerSetting_00004() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex = 3;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_setHumidityEsTriggerSetting_00101() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(3);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, originalValue)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .setHumidityEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
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
    public void test_setHumidityEsTriggerSetting_00102() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, originalValue)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .setHumidityEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
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
    public void test_setHumidityEsTriggerSetting_00103() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, originalValue)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .setHumidityEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
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
    public void test_setHumidityEsTriggerSetting_00104() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(0);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, originalValue)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .setHumidityEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
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
    public void test_removeHumidityEsTriggerSetting_00001() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .removeHumidityEsTriggerSetting(characteristicIndex, descriptorIndex)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removeHumidityEsTriggerSetting_00002() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .removeHumidityEsTriggerSetting(characteristicIndex, descriptorIndex)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removeHumidityEsTriggerSetting_00003() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .removeHumidityEsTriggerSetting(characteristicIndex, descriptorIndex)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removeHumidityEsTriggerSetting_00004() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex = 3;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting = new EnvironmentalSensingTriggerSetting(1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting)
                .removeHumidityEsTriggerSetting(characteristicIndex, descriptorIndex)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removeHumidityEsTriggerSetting_00101() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(3);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .removeHumidityEsTriggerSetting(characteristicIndex, descriptorIndex0)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .removeHumidityEsTriggerSetting(characteristicIndex, descriptorIndex2)
                .setHumidityEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removeHumidityEsTriggerSetting_00102() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .removeHumidityEsTriggerSetting(characteristicIndex, descriptorIndex0)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .removeHumidityEsTriggerSetting(characteristicIndex, descriptorIndex1)
                .setHumidityEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removeHumidityEsTriggerSetting_00103() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .removeHumidityEsTriggerSetting(characteristicIndex, descriptorIndex1)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .removeHumidityEsTriggerSetting(characteristicIndex, descriptorIndex2)
                .setHumidityEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removeHumidityEsTriggerSetting_00104() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(0);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex2 = 2;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting2 = new EnvironmentalSensingTriggerSetting(2);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, BluetoothGattDescriptor.PERMISSION_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                .removeHumidityEsTriggerSetting(characteristicIndex, descriptorIndex0)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                .removeHumidityEsTriggerSetting(characteristicIndex, descriptorIndex1)
                .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex2, environmentalSensingTriggerSetting2)
                .removeHumidityEsTriggerSetting(characteristicIndex, descriptorIndex2)
                .setHumidityEsConfiguration(characteristicIndex, new EnvironmentalSensingConfiguration(0))
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_setHumidityEsConfiguration_00001() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(2);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, originalValue)
                .setHumidityEsTriggerSetting(characteristicIndex, 0, environmentalSensingTriggerSetting0)
                .setHumidityEsTriggerSetting(characteristicIndex, 1, environmentalSensingTriggerSetting1)
                .setHumidityEsConfiguration(characteristicIndex, environmentalSensingConfiguration)
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setHumidityEsConfiguration_00002() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(2);
        int descriptorPermission = BluetoothGattDescriptor.PERMISSION_READ;
        EnvironmentalSensingConfiguration environmentalSensingConfiguration = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, originalValue)
                .setHumidityEsTriggerSetting(characteristicIndex, 0, environmentalSensingTriggerSetting0)
                .setHumidityEsTriggerSetting(characteristicIndex, 1, environmentalSensingTriggerSetting1)
                .setHumidityEsConfiguration(characteristicIndex, descriptorPermission, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes())
                .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(descriptorPermission, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(environmentalSensingConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setHumidityEsConfiguration_00101() {
        int characteristicIndex0 = 0;
        Humidity originalValue0 = new Humidity(1);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration0 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        int characteristicIndex1 = 1;
        Humidity originalValue1 = new Humidity(2);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration1 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex0, originalValue0)
                .setHumidityEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setHumidityEsTriggerSetting(characteristicIndex0, 0, new EnvironmentalSensingTriggerSetting(1))
                .setHumidityEsTriggerSetting(characteristicIndex0, 1, new EnvironmentalSensingTriggerSetting(2))
                .setHumidityEsConfiguration(characteristicIndex0, environmentalSensingConfiguration0)
                .addHumidity(characteristicIndex1, originalValue1)
                .setHumidityEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setHumidityEsTriggerSetting(characteristicIndex1, 0, new EnvironmentalSensingTriggerSetting(3))
                .setHumidityEsTriggerSetting(characteristicIndex1, 1, new EnvironmentalSensingTriggerSetting(4))
                .setHumidityEsConfiguration(characteristicIndex1, environmentalSensingConfiguration1)
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
    public void test_setHumidityEsConfiguration_00102() {
        int characteristicIndex0 = 0;
        Humidity originalValue0 = new Humidity(1);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration0 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        int characteristicIndex1 = 1;
        Humidity originalValue1 = new Humidity(2);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration1 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        int descriptorPermission = BluetoothGattDescriptor.PERMISSION_READ;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex0, originalValue0)
                .setHumidityEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setHumidityEsTriggerSetting(characteristicIndex0, 0, new EnvironmentalSensingTriggerSetting(1))
                .setHumidityEsTriggerSetting(characteristicIndex0, 1, new EnvironmentalSensingTriggerSetting(2))
                .setHumidityEsConfiguration(characteristicIndex0, descriptorPermission, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration0.getBytes())
                .addHumidity(characteristicIndex1, originalValue1)
                .setHumidityEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setHumidityEsTriggerSetting(characteristicIndex1, 0, new EnvironmentalSensingTriggerSetting(3))
                .setHumidityEsTriggerSetting(characteristicIndex1, 1, new EnvironmentalSensingTriggerSetting(4))
                .setHumidityEsConfiguration(characteristicIndex1, descriptorPermission, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration1.getBytes())
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
    public void test_removeHumidityEsConfiguration_00001() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        int descriptorIndex0 = 0;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting0 = new EnvironmentalSensingTriggerSetting(1);
        int descriptorIndex1 = 1;
        EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting1 = new EnvironmentalSensingTriggerSetting(2);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(characteristicIndex, originalValue)
                    .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex0, environmentalSensingTriggerSetting0)
                    .setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex1, environmentalSensingTriggerSetting1)
                    .setHumidityEsConfiguration(characteristicIndex, environmentalSensingConfiguration)
                    .removeHumidityEsConfiguration(characteristicIndex)
                    .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Configuration data:" + HUMIDITY_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_removeHumidityEsConfiguration_00101() {
        int characteristicIndex0 = 0;
        Humidity originalValue0 = new Humidity(1);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration0 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND);

        int characteristicIndex1 = 1;
        Humidity originalValue1 = new Humidity(2);
        EnvironmentalSensingConfiguration environmentalSensingConfiguration1 = new EnvironmentalSensingConfiguration(EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR);

        Exception exception = null;
        try {
            new EnvironmentalSensingServiceMockCallback.Builder<>()
                    .addHumidity(characteristicIndex0, originalValue0)
                    .setHumidityEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                    .setHumidityEsTriggerSetting(characteristicIndex0, 0, new EnvironmentalSensingTriggerSetting(1))
                    .setHumidityEsTriggerSetting(characteristicIndex0, 1, new EnvironmentalSensingTriggerSetting(2))
                    .setHumidityEsConfiguration(characteristicIndex0, environmentalSensingConfiguration0)
                    .removeHumidityEsMeasurement(characteristicIndex0)
                    .addHumidity(characteristicIndex1, originalValue1)
                    .setHumidityEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                    .setHumidityEsTriggerSetting(characteristicIndex1, 0, new EnvironmentalSensingTriggerSetting(3))
                    .setHumidityEsTriggerSetting(characteristicIndex1, 1, new EnvironmentalSensingTriggerSetting(4))
                    .setHumidityEsConfiguration(characteristicIndex1, environmentalSensingConfiguration1)
                    .addDescriptorValueChanged(new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no ES Measurement data:" + HUMIDITY_CHARACTERISTIC, exception.getMessage());
    }

    @Test
    public void test_setHumidityCharacteristicUserDescription_00001() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        CharacteristicUserDescription characteristicUserDescription = new CharacteristicUserDescription(new byte[]{0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityCharacteristicUserDescription(characteristicIndex, characteristicUserDescription)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicUserDescription.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setHumidityCharacteristicUserDescription_00002() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        CharacteristicUserDescription characteristicUserDescription = new CharacteristicUserDescription(new byte[]{0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityCharacteristicUserDescription(characteristicIndex, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicUserDescription.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setHumidityCharacteristicUserDescription_00101() {
        int characteristicIndex0 = 0;
        Humidity originalValue0 = new Humidity(1);
        CharacteristicUserDescription characteristicUserDescription0 = new CharacteristicUserDescription(new byte[]{0});

        int characteristicIndex1 = 1;
        Humidity originalValue1 = new Humidity(2);
        CharacteristicUserDescription characteristicUserDescription1 = new CharacteristicUserDescription(new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setHumidityEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setHumidityCharacteristicUserDescription(characteristicIndex0, characteristicUserDescription0)
                .addHumidity(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setHumidityEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setHumidityCharacteristicUserDescription(characteristicIndex1, characteristicUserDescription1)
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
    public void test_setHumidityCharacteristicUserDescription_00102() {
        int characteristicIndex0 = 0;
        Humidity originalValue0 = new Humidity(1);
        CharacteristicUserDescription characteristicUserDescription0 = new CharacteristicUserDescription(new byte[]{0});

        int characteristicIndex1 = 1;
        Humidity originalValue1 = new Humidity(2);
        CharacteristicUserDescription characteristicUserDescription1 = new CharacteristicUserDescription(new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setHumidityEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setHumidityCharacteristicUserDescription(characteristicIndex0, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription0.getBytes())
                .addHumidity(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setHumidityEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setHumidityCharacteristicUserDescription(characteristicIndex1, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription1.getBytes())
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
    public void test_removeHumidityCharacteristicUserDescription_00001() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        CharacteristicUserDescription characteristicUserDescription = new CharacteristicUserDescription(new byte[]{0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityCharacteristicUserDescription(characteristicIndex, characteristicUserDescription)
                .removeHumidityCharacteristicUserDescription(characteristicIndex)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removeHumidityCharacteristicUserDescription_00101() {
        int characteristicIndex0 = 0;
        Humidity originalValue0 = new Humidity(1);
        CharacteristicUserDescription characteristicUserDescription0 = new CharacteristicUserDescription(new byte[]{0});

        int characteristicIndex1 = 1;
        Humidity originalValue1 = new Humidity(2);
        CharacteristicUserDescription characteristicUserDescription1 = new CharacteristicUserDescription(new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setHumidityEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setHumidityCharacteristicUserDescription(characteristicIndex0, characteristicUserDescription0)
                .removeHumidityCharacteristicUserDescription(characteristicIndex0)
                .addHumidity(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setHumidityEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setHumidityCharacteristicUserDescription(characteristicIndex1, characteristicUserDescription1)
                .removeHumidityCharacteristicUserDescription(characteristicIndex1)
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
    public void test_setHumidityValidRange_00001() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        ValidRange validRange = new ValidRange(new byte[]{0}, new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityValidRange(characteristicIndex, validRange)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(validRange.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setHumidityValidRange_00002() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        ValidRange validRange = new ValidRange(new byte[]{0}, new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityValidRange(characteristicIndex, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(validRange.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_setHumidityValidRange_00101() {
        int characteristicIndex0 = 0;
        Humidity originalValue0 = new Humidity(1);
        ValidRange validRange0 = new ValidRange(new byte[]{0}, new byte[]{1});

        int characteristicIndex1 = 1;
        Humidity originalValue1 = new Humidity(2);
        ValidRange validRange1 = new ValidRange(new byte[]{2}, new byte[]{3});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setHumidityEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setHumidityValidRange(characteristicIndex0, validRange0)
                .addHumidity(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setHumidityEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setHumidityValidRange(characteristicIndex1, validRange1)
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
    public void test_setHumidityValidRange_00102() {
        int characteristicIndex0 = 0;
        Humidity originalValue0 = new Humidity(1);
        ValidRange validRange0 = new ValidRange(new byte[]{0}, new byte[]{1});

        int characteristicIndex1 = 1;
        Humidity originalValue1 = new Humidity(2);
        ValidRange validRange1 = new ValidRange(new byte[]{2}, new byte[]{3});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setHumidityEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setHumidityValidRange(characteristicIndex0, BluetoothGatt.GATT_SUCCESS, 0, validRange0.getBytes())
                .addHumidity(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setHumidityEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setHumidityValidRange(characteristicIndex1, BluetoothGatt.GATT_SUCCESS, 0, validRange1.getBytes())
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
    public void test_removeHumidityValidRange_00001() {
        int characteristicIndex = 0;
        Humidity originalValue = new Humidity(1);
        ValidRange validRange = new ValidRange(new byte[]{0}, new byte[]{1});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue.getBytes())
                .setHumidityValidRange(characteristicIndex, validRange)
                .removeHumidityValidRange(characteristicIndex)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertFalse(bluetoothGattServiceList.isEmpty());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(ENVIRONMENTAL_SENSING_SERVICE, bluetoothGattService.getUuid());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HUMIDITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);

        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removeHumidityValidRange_00101() {
        int characteristicIndex0 = 0;
        Humidity originalValue0 = new Humidity(1);
        ValidRange validRange0 = new ValidRange(new byte[]{0}, new byte[]{1});

        int characteristicIndex1 = 1;
        Humidity originalValue1 = new Humidity(2);
        ValidRange validRange1 = new ValidRange(new byte[]{2}, new byte[]{3});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        EnvironmentalSensingServiceMockCallback callback = new EnvironmentalSensingServiceMockCallback.Builder<>()
                .addHumidity(characteristicIndex0, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue0.getBytes())
                .setHumidityEsMeasurement(characteristicIndex0, new EnvironmentalSensingMeasurement(new byte[2], 0, 0, 0, 0, 0))
                .setHumidityValidRange(characteristicIndex0, validRange0)
                .removeHumidityValidRange(characteristicIndex0)
                .addHumidity(characteristicIndex1, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, originalValue1.getBytes())
                .setHumidityEsMeasurement(characteristicIndex1, new EnvironmentalSensingMeasurement(new byte[2], 1, 0, 0, 0, 0))
                .setHumidityValidRange(characteristicIndex1, validRange1)
                .removeHumidityValidRange(characteristicIndex1)
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
