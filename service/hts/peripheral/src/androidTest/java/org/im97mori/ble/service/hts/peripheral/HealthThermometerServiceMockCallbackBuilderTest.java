package org.im97mori.ble.service.hts.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

import org.im97mori.ble.characteristic.core.IEEE_11073_20601_FLOAT;
import org.im97mori.ble.characteristic.core.TemperatureMeasurementUtils;
import org.im97mori.ble.characteristic.core.TemperatureTypeUtils;
import org.im97mori.ble.characteristic.u2a1c.TemperatureMeasurement;
import org.im97mori.ble.characteristic.u2a1d.TemperatureType;
import org.im97mori.ble.characteristic.u2a1e.IntermediateTemperature;
import org.im97mori.ble.characteristic.u2a21.MeasurementInterval;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2906.ValidRange;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.INTERMEDIATE_TEMPERATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MEASUREMENT_INTERVAL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TEMPERATURE_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TEMPERATURE_TYPE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.HEALTH_THERMOMETER_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class HealthThermometerServiceMockCallbackBuilderTest extends AbstractPeripherallTest {

    @Test
    public void test_addTemperatureMeasurement_00001() {
        Exception exception = null;
        try {
            new HealthThermometerServiceMockCallback.Builder<>().build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Temperature Measurement data", exception.getMessage());
    }

    @Test
    public void test_addTemperatureMeasurement_00101() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HealthThermometerServiceMockCallback callback = new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, clientCharacteristicConfiguration)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEALTH_THERMOMETER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TEMPERATURE_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TEMPERATURE_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(temperatureMeasurement.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addTemperatureMeasurement_00201() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HealthThermometerServiceMockCallback callback = new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(BluetoothGatt.GATT_SUCCESS, 0, temperatureMeasurement.getBytes(), 0, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEALTH_THERMOMETER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TEMPERATURE_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TEMPERATURE_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(temperatureMeasurement.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeTemperatureMeasurement_00001() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Exception exception = null;
        try {
            new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, clientCharacteristicConfiguration)
                    .removeTemperatureMeasurement()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Temperature Measurement data", exception.getMessage());
    }

    @Test
    public void test_addTemperatureType_00001() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        TemperatureType temperatureType = new TemperatureType(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HealthThermometerServiceMockCallback callback = new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, clientCharacteristicConfiguration)
                    .addTemperatureType(temperatureType)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEALTH_THERMOMETER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TEMPERATURE_TYPE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TEMPERATURE_TYPE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(temperatureType.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addTemperatureType_00002() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        TemperatureType temperatureType = new TemperatureType(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HealthThermometerServiceMockCallback callback = new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, clientCharacteristicConfiguration)
                    .addTemperatureType(BluetoothGatt.GATT_SUCCESS, 0, temperatureType.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEALTH_THERMOMETER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TEMPERATURE_TYPE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TEMPERATURE_TYPE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(temperatureType.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeTemperatureType_00001() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        TemperatureType temperatureType = new TemperatureType(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HealthThermometerServiceMockCallback callback = new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, clientCharacteristicConfiguration)
                    .addTemperatureType(temperatureType)
                    .removeTemperatureType()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEALTH_THERMOMETER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TEMPERATURE_TYPE_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addIntermediateTemperature_00001() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration temperatureMeasurementClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        IntermediateTemperature intermediateTemperature = new IntermediateTemperature(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                , temperatureMeasurementValueCelsius
                , valueFahrenheit
                , 0, 0, 0, 0, 0, 0
                , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);
        ClientCharacteristicConfiguration intermediateTemperatureClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HealthThermometerServiceMockCallback callback = new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, temperatureMeasurementClientCharacteristicConfiguration)
                    .addIntermediateTemperature(intermediateTemperature, intermediateTemperatureClientCharacteristicConfiguration)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEALTH_THERMOMETER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(INTERMEDIATE_TEMPERATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(INTERMEDIATE_TEMPERATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(intermediateTemperature.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(intermediateTemperatureClientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addIntermediateTemperature_00002() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration temperatureMeasurementClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        IntermediateTemperature intermediateTemperature = new IntermediateTemperature(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                , temperatureMeasurementValueCelsius
                , valueFahrenheit
                , 0, 0, 0, 0, 0, 0
                , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);
        ClientCharacteristicConfiguration intermediateTemperatureClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HealthThermometerServiceMockCallback callback = new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, temperatureMeasurementClientCharacteristicConfiguration)
                    .addIntermediateTemperature(BluetoothGatt.GATT_SUCCESS, 0, intermediateTemperature.getBytes(), 0, BluetoothGatt.GATT_SUCCESS, 0, intermediateTemperatureClientCharacteristicConfiguration.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEALTH_THERMOMETER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(INTERMEDIATE_TEMPERATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(INTERMEDIATE_TEMPERATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(intermediateTemperature.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(intermediateTemperatureClientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeIntermediateTemperature_00001() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration temperatureMeasurementClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        IntermediateTemperature intermediateTemperature = new IntermediateTemperature(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                , temperatureMeasurementValueCelsius
                , valueFahrenheit
                , 0, 0, 0, 0, 0, 0
                , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);
        ClientCharacteristicConfiguration intermediateTemperatureClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HealthThermometerServiceMockCallback callback = new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, temperatureMeasurementClientCharacteristicConfiguration)
                    .addIntermediateTemperature(intermediateTemperature, intermediateTemperatureClientCharacteristicConfiguration)
                    .removeIntermediateTemperature()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEALTH_THERMOMETER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(INTERMEDIATE_TEMPERATURE_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addMeasurementInterval_00001() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration temperatureMeasurementClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        MeasurementInterval measurementInterval = new MeasurementInterval(1);
        ClientCharacteristicConfiguration measurementIntervalClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{5, 0});

        Exception exception = null;
        try {
            new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, temperatureMeasurementClientCharacteristicConfiguration)
                    .addMeasurementInterval(measurementInterval, measurementIntervalClientCharacteristicConfiguration, validRange)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("A value of 0 is not valid for the lower inclusive value", exception.getMessage());
    }

    @Test
    public void test_addMeasurementInterval_00002() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration temperatureMeasurementClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        MeasurementInterval measurementInterval = new MeasurementInterval(6);
        ClientCharacteristicConfiguration measurementIntervalClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);
        ValidRange validRange = new ValidRange(new byte[]{1, 0}, new byte[]{5, 0});

        Exception exception = null;
        try {
            new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, temperatureMeasurementClientCharacteristicConfiguration)
                    .addMeasurementInterval(measurementInterval, measurementIntervalClientCharacteristicConfiguration, validRange)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Out of Range", exception.getMessage());
    }

    @Test
    public void test_addMeasurementInterval_00003() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration temperatureMeasurementClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        MeasurementInterval measurementInterval = new MeasurementInterval(1);
        ClientCharacteristicConfiguration measurementIntervalClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);
        ValidRange validRange = new ValidRange(new byte[]{2, 0}, new byte[]{5, 0});

        Exception exception = null;
        try {
            new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, temperatureMeasurementClientCharacteristicConfiguration)
                    .addMeasurementInterval(measurementInterval, measurementIntervalClientCharacteristicConfiguration, validRange)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Out of Range", exception.getMessage());
    }

    @Test
    public void test_addMeasurementInterval_00004() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration temperatureMeasurementClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        MeasurementInterval measurementInterval = new MeasurementInterval(0);
        ClientCharacteristicConfiguration measurementIntervalClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);
        ValidRange validRange = new ValidRange(new byte[]{1, 0}, new byte[]{5, 0});

        Exception exception = null;
        try {
            new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, temperatureMeasurementClientCharacteristicConfiguration)
                    .addMeasurementInterval(measurementInterval, measurementIntervalClientCharacteristicConfiguration, validRange)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addMeasurementInterval_00005() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration temperatureMeasurementClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        MeasurementInterval measurementInterval = new MeasurementInterval(6);
        ClientCharacteristicConfiguration measurementIntervalClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);
        ValidRange validRange = new ValidRange(new byte[]{0, 0}, new byte[]{5, 0});

        Exception exception = null;
        try {
            new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, temperatureMeasurementClientCharacteristicConfiguration)
                    .addMeasurementInterval(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , measurementInterval.getBytes()
                            , false
                            , false
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , measurementIntervalClientCharacteristicConfiguration.getBytes()
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addMeasurementInterval_00101() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration temperatureMeasurementClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        MeasurementInterval measurementInterval = new MeasurementInterval(1);
        ClientCharacteristicConfiguration measurementIntervalClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);
        ValidRange validRange = new ValidRange(new byte[]{1, 0}, new byte[]{5, 0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HealthThermometerServiceMockCallback callback = new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, temperatureMeasurementClientCharacteristicConfiguration)
                    .addMeasurementInterval(measurementInterval, measurementIntervalClientCharacteristicConfiguration, validRange)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEALTH_THERMOMETER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MEASUREMENT_INTERVAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(MEASUREMENT_INTERVAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(measurementInterval.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(measurementIntervalClientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(validRange.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addMeasurementInterval_00201() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration temperatureMeasurementClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        MeasurementInterval measurementInterval = new MeasurementInterval(1);
        ClientCharacteristicConfiguration measurementIntervalClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);
        ValidRange validRange = new ValidRange(new byte[]{1, 0}, new byte[]{5, 0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HealthThermometerServiceMockCallback callback = new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, temperatureMeasurementClientCharacteristicConfiguration)
                    .addMeasurementInterval(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , measurementInterval.getBytes()
                            , true
                            , true
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , measurementIntervalClientCharacteristicConfiguration.getBytes()
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEALTH_THERMOMETER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MEASUREMENT_INTERVAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(MEASUREMENT_INTERVAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(measurementInterval.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(measurementIntervalClientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(validRange.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addMeasurementInterval_00202() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration temperatureMeasurementClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        MeasurementInterval measurementInterval = new MeasurementInterval(1);
        ClientCharacteristicConfiguration measurementIntervalClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);
        ValidRange validRange = new ValidRange(new byte[]{1, 0}, new byte[]{5, 0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HealthThermometerServiceMockCallback callback = new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, temperatureMeasurementClientCharacteristicConfiguration)
                    .addMeasurementInterval(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , measurementInterval.getBytes()
                            , false
                            , true
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , measurementIntervalClientCharacteristicConfiguration.getBytes()
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEALTH_THERMOMETER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MEASUREMENT_INTERVAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(MEASUREMENT_INTERVAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(measurementInterval.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(VALID_RANGE_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(validRange.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addMeasurementInterval_00203() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration temperatureMeasurementClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        MeasurementInterval measurementInterval = new MeasurementInterval(1);
        ClientCharacteristicConfiguration measurementIntervalClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);
        ValidRange validRange = new ValidRange(new byte[]{1, 0}, new byte[]{5, 0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HealthThermometerServiceMockCallback callback = new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, temperatureMeasurementClientCharacteristicConfiguration)
                    .addMeasurementInterval(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , measurementInterval.getBytes()
                            , true
                            , false
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , measurementIntervalClientCharacteristicConfiguration.getBytes()
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEALTH_THERMOMETER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MEASUREMENT_INTERVAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(MEASUREMENT_INTERVAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(measurementInterval.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(measurementIntervalClientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_addMeasurementInterval_00204() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration temperatureMeasurementClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        MeasurementInterval measurementInterval = new MeasurementInterval(1);
        ClientCharacteristicConfiguration measurementIntervalClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);
        ValidRange validRange = new ValidRange(new byte[]{1, 0}, new byte[]{5, 0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HealthThermometerServiceMockCallback callback = new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, temperatureMeasurementClientCharacteristicConfiguration)
                    .addMeasurementInterval(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , measurementInterval.getBytes()
                            , false
                            , false
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , measurementIntervalClientCharacteristicConfiguration.getBytes()
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , validRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEALTH_THERMOMETER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MEASUREMENT_INTERVAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(MEASUREMENT_INTERVAL_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(measurementInterval.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
        assertNull(bluetoothGattDescriptor);
    }

    @Test
    public void test_removeMeasurementInterval_00001() {
        IEEE_11073_20601_FLOAT temperatureMeasurementValueCelsius = new IEEE_11073_20601_FLOAT(new byte[]{20, 0, 0, 0}, 0);
        IEEE_11073_20601_FLOAT valueFahrenheit = new IEEE_11073_20601_FLOAT(new byte[]{0, 0, 0, 0}, 0);

        TemperatureMeasurement temperatureMeasurement =
                new TemperatureMeasurement(TemperatureMeasurementUtils.FLAGS_TEMPERATURE_UNITS_CELSIUS
                        , temperatureMeasurementValueCelsius
                        , valueFahrenheit
                        , 0, 0, 0, 0, 0, 0
                        , TemperatureTypeUtils.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration temperatureMeasurementClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        MeasurementInterval measurementInterval = new MeasurementInterval(1);
        ClientCharacteristicConfiguration measurementIntervalClientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);
        ValidRange validRange = new ValidRange(new byte[]{1, 0}, new byte[]{5, 0});

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HealthThermometerServiceMockCallback callback = new HealthThermometerServiceMockCallback.Builder<>()
                    .addTemperatureMeasurement(temperatureMeasurement, temperatureMeasurementClientCharacteristicConfiguration)
                    .addMeasurementInterval(measurementInterval, measurementIntervalClientCharacteristicConfiguration, validRange)
                    .removeMeasurementInterval()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEALTH_THERMOMETER_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MEASUREMENT_INTERVAL_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

}
