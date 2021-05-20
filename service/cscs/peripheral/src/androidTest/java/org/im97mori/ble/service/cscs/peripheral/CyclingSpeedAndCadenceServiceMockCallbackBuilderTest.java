package org.im97mori.ble.service.cscs.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

import org.im97mori.ble.characteristic.core.SensorLocationUtils;
import org.im97mori.ble.characteristic.u2a55.SCControlPoint;
import org.im97mori.ble.characteristic.u2a5b.CSCMeasurement;
import org.im97mori.ble.characteristic.u2a5c.CSCFeature;
import org.im97mori.ble.characteristic.u2a5d.SensorLocation;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CSC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CSC_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SC_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.CYCLING_SPEED_AND_CADENCE_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CyclingSpeedAndCadenceServiceMockCallbackBuilderTest extends AbstractPeripherallTest {

    @Test
    public void test_exception_00001() {
        Exception exception = null;
        try {
            new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no CSC Feature data", exception.getMessage());
    }

    @Test
    public void test_exception_00002() {
        Exception exception = null;
        try {
            new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[2]))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no CSC Measurement data", exception.getMessage());
    }

    @Test
    public void test_exception_00003() {
        Exception exception = null;
        try {
            new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[2]))
                    .addCSCMeasurement(new CSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00004() {
        Exception exception = null;
        try {
            new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[2]))
                    .addCSCMeasurement(new CSCMeasurement(CSCMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_TRUE
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Wheel Revolution Data not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00005() {
        Exception exception = null;
        try {
            new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[2]))
                    .addCSCMeasurement(new CSCMeasurement(CSCMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Crank Revolution Data not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00006() {
        Exception exception = null;
        try {
            new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[]{CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE
                            , CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE >> 8}))
                    .addCSCMeasurement(new CSCMeasurement(CSCMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_TRUE
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no SC Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00007() {
        Exception exception = null;
        try {
            new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[]{CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE
                            , CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE >> 8}))
                    .addCSCMeasurement(new CSCMeasurement(CSCMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00008() {
        Exception exception = null;
        try {
            new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[]{CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE
                            , CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE >> 8}))
                    .addCSCMeasurement(new CSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Sensor Location data", exception.getMessage());
    }

    @Test
    public void test_exception_00009() {
        Exception exception = null;
        try {
            new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[]{CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE
                            , CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE >> 8}))
                    .addCSCMeasurement(new CSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no SC Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00010() {
        Exception exception = null;
        try {
            new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[]{CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE
                            , CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE >> 8}))
                    .addCSCMeasurement(new CSCMeasurement(CSCMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_TRUE
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER}
                    )
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00011() {
        Exception exception = null;
        try {
            new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[]{CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE | CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE | CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE
                            , (CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE | CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE | CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE) >> 8}))
                    .addCSCMeasurement(new CSCMeasurement(CSCMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_TRUE | CSCMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addCSCFeature_00001() {
        CSCFeature cscFeature = new CSCFeature(new byte[2]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingSpeedAndCadenceServiceMockCallback callback = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(cscFeature)
                    .addCSCMeasurement(new CSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CSC_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CSC_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(cscFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addCSCFeature_00002() {
        CSCFeature cscFeature = new CSCFeature(new byte[2]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingSpeedAndCadenceServiceMockCallback callback = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(cscFeature.getBytes())
                    .addCSCMeasurement(new CSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CSC_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CSC_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(cscFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addCSCFeature_00003() {
        CSCFeature cscFeature = new CSCFeature(new byte[2]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingSpeedAndCadenceServiceMockCallback callback = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , cscFeature.getBytes())
                    .addCSCMeasurement(new CSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CSC_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CSC_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(cscFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeCSCFeature_00001() {
        Exception exception = null;
        try {
            new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[2]))
                    .addCSCMeasurement(new CSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .removeCSCFeature()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no CSC Feature data", exception.getMessage());
    }

    @Test
    public void test_addCSCMeasurement_00001() {
        CSCMeasurement cscMeasurement = new CSCMeasurement(
                0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingSpeedAndCadenceServiceMockCallback callback = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[2]))
                    .addCSCMeasurement(cscMeasurement
                            , clientCharacteristicConfiguration)
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CSC_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CSC_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(cscMeasurement.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addCSCMeasurement_00002() {
        CSCMeasurement cscMeasurement = new CSCMeasurement(
                0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingSpeedAndCadenceServiceMockCallback callback = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[2]))
                    .addCSCMeasurement(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , cscMeasurement.getBytes()
                            , 1
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , clientCharacteristicConfiguration.getBytes())
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CSC_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CSC_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(cscMeasurement.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeCSCMeasurement_00001() {
        Exception exception = null;
        try {
            new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[2]))
                    .addCSCMeasurement(new CSCMeasurement(
                                    0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .removeCSCMeasurement()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no CSC Measurement data", exception.getMessage());
    }

    @Test
    public void test_addSensorLocation_00001() {
        SensorLocation sensorLocation = new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingSpeedAndCadenceServiceMockCallback callback = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[2]))
                    .addCSCMeasurement(new CSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(sensorLocation)
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SENSOR_LOCATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SENSOR_LOCATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(sensorLocation.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSensorLocation_00002() {
        SensorLocation sensorLocation = new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingSpeedAndCadenceServiceMockCallback callback = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[2]))
                    .addCSCMeasurement(new CSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(sensorLocation.getBytes())
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SENSOR_LOCATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SENSOR_LOCATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(sensorLocation.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSensorLocation_00003() {
        SensorLocation sensorLocation = new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingSpeedAndCadenceServiceMockCallback callback = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[2]))
                    .addCSCMeasurement(new CSCMeasurement(0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , sensorLocation.getBytes())
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SENSOR_LOCATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SENSOR_LOCATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(sensorLocation.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeSensorLocation_00001() {
        Exception exception = null;
        try {
            new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[]{CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE, CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE >> 8}))
                    .addCSCMeasurement(new CSCMeasurement(
                                    0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .removeSensorLocation()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Sensor Location data", exception.getMessage());
    }

    @Test
    public void test_addSCControlPoint_00001() {
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CyclingSpeedAndCadenceServiceMockCallback callback = new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[2]))
                    .addCSCMeasurement(new CSCMeasurement(
                                    0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , descriptorValue
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CYCLING_SPEED_AND_CADENCE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SC_CONTROL_POINT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, SCControlPoint.OP_CODE_RESPONSE_CODE, SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(descriptorValue, bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeSCControlPoint_00001() {
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        Exception exception = null;
        try {
            new CyclingSpeedAndCadenceServiceMockCallback.Builder<>()
                    .addCSCFeature(new CSCFeature(new byte[]{CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE, CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE >> 8}))
                    .addCSCMeasurement(new CSCMeasurement(
                                    0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE))
                    .addSensorLocation(new SensorLocation(SensorLocationUtils.SENSOR_LOCATION_OTHER))
                    .addSCControlPoint(BluetoothGatt.GATT_SUCCESS
                            , 0
                            , BluetoothGatt.GATT_SUCCESS
                            , 0
                            , descriptorValue
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , SCControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[]{SensorLocationUtils.SENSOR_LOCATION_OTHER})
                    .removeSCControlPoint()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no SC Control Point data", exception.getMessage());
    }

}
