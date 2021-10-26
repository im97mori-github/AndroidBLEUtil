package org.im97mori.ble.service.hrs.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Build;

import org.im97mori.ble.characteristic.u2a37.HeartRateMeasurement;
import org.im97mori.ble.characteristic.u2a38.BodySensorLocation;
import org.im97mori.ble.characteristic.u2a39.HeartRateControlPoint;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.BODY_SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HEART_RATE_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HEART_RATE_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.HEART_RATE_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

public class HeartRateServiceMockCallbackBuilderTest extends AbstractPeripherallTest {

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addHeartRateMeasurement_00001() {
        Exception exception = null;
        try {
            new HeartRateServiceMockCallback.Builder<>().build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Heart Rate Measurement data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addHeartRateMeasurement_00101() {
        HeartRateMeasurement heartRateMeasurement = new HeartRateMeasurement(0, 1, 2, 3, new int[0]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HeartRateServiceMockCallback callback = new HeartRateServiceMockCallback.Builder<>()
                    .addHeartRateMeasurement(heartRateMeasurement, clientCharacteristicConfiguration)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEART_RATE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HEART_RATE_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HEART_RATE_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(heartRateMeasurement.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addHeartRateMeasurement_00201() {
        HeartRateMeasurement heartRateMeasurement = new HeartRateMeasurement(0, 1, 2, 3, new int[0]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HeartRateServiceMockCallback callback = new HeartRateServiceMockCallback.Builder<>()
                    .addHeartRateMeasurement(BluetoothGatt.GATT_SUCCESS, 0, heartRateMeasurement.getBytes(), 0, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEART_RATE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HEART_RATE_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HEART_RATE_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(heartRateMeasurement.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeBloodPressureMeasurement_00001() {
        HeartRateMeasurement heartRateMeasurement = new HeartRateMeasurement(0, 1, 2, 3, new int[0]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Exception exception = null;
        try {
            new HeartRateServiceMockCallback.Builder<>()
                    .addHeartRateMeasurement(heartRateMeasurement, clientCharacteristicConfiguration)
                    .removeHeartRateMeasurement()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Heart Rate Measurement data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBodySensorLocation_00001() {
        HeartRateMeasurement heartRateMeasurement = new HeartRateMeasurement(0, 1, 2, 3, new int[0]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        BodySensorLocation bodySensorLocation = new BodySensorLocation(0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HeartRateServiceMockCallback callback = new HeartRateServiceMockCallback.Builder<>()
                    .addHeartRateMeasurement(heartRateMeasurement, clientCharacteristicConfiguration)
                    .addBodySensorLocation(bodySensorLocation)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEART_RATE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BODY_SENSOR_LOCATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BODY_SENSOR_LOCATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(bodySensorLocation.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBodySensorLocation_00101() {
        HeartRateMeasurement heartRateMeasurement = new HeartRateMeasurement(0, 1, 2, 3, new int[0]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        BodySensorLocation bodySensorLocation = new BodySensorLocation(0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HeartRateServiceMockCallback callback = new HeartRateServiceMockCallback.Builder<>()
                    .addHeartRateMeasurement(heartRateMeasurement, clientCharacteristicConfiguration)
                    .addBodySensorLocation(BluetoothGatt.GATT_SUCCESS, 0, bodySensorLocation.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEART_RATE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BODY_SENSOR_LOCATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BODY_SENSOR_LOCATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(bodySensorLocation.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeBodySensorLocation_00001() {
        HeartRateMeasurement heartRateMeasurement = new HeartRateMeasurement(0, 1, 2, 3, new int[0]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        BodySensorLocation bodySensorLocation = new BodySensorLocation(0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HeartRateServiceMockCallback callback = new HeartRateServiceMockCallback.Builder<>()
                    .addHeartRateMeasurement(heartRateMeasurement, clientCharacteristicConfiguration)
                    .addBodySensorLocation(bodySensorLocation)
                    .removeBodySensorLocation()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEART_RATE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BODY_SENSOR_LOCATION_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addHeartRateControlPoint_00001() {
        HeartRateMeasurement heartRateMeasurement = new HeartRateMeasurement(HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT, 1, 2, 3, new int[0]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Exception exception = null;
        try {
            new HeartRateServiceMockCallback.Builder<>()
                    .addHeartRateMeasurement(heartRateMeasurement, clientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Heart Rate Control Point data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addHeartRateControlPoint_00101() {
        HeartRateMeasurement heartRateMeasurement = new HeartRateMeasurement(HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT, 1, 2, 3, new int[0]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        HeartRateControlPoint heartRateControlPoint = new HeartRateControlPoint(HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HeartRateServiceMockCallback callback = new HeartRateServiceMockCallback.Builder<>()
                    .addHeartRateMeasurement(heartRateMeasurement, clientCharacteristicConfiguration)
                    .addHeartRateControlPoint(heartRateControlPoint)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEART_RATE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HEART_RATE_CONTROL_POINT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HEART_RATE_CONTROL_POINT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(heartRateControlPoint.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addHeartRateControlPoint_00201() {
        HeartRateMeasurement heartRateMeasurement = new HeartRateMeasurement(HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT, 1, 2, 3, new int[0]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        HeartRateControlPoint heartRateControlPoint = new HeartRateControlPoint(HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HeartRateServiceMockCallback callback = new HeartRateServiceMockCallback.Builder<>()
                    .addHeartRateMeasurement(heartRateMeasurement, clientCharacteristicConfiguration)
                    .addHeartRateControlPoint(BluetoothGatt.GATT_SUCCESS, 0, heartRateControlPoint.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEART_RATE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HEART_RATE_CONTROL_POINT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(HEART_RATE_CONTROL_POINT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(heartRateControlPoint.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeHeartRateControlPoint_00001() {
        HeartRateMeasurement heartRateMeasurement = new HeartRateMeasurement(0, 1, 2, 3, new int[0]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        HeartRateControlPoint heartRateControlPoint = new HeartRateControlPoint(HeartRateControlPoint.HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            HeartRateServiceMockCallback callback = new HeartRateServiceMockCallback.Builder<>()
                    .addHeartRateMeasurement(heartRateMeasurement, clientCharacteristicConfiguration)
                    .addHeartRateControlPoint(heartRateControlPoint)
                    .removeHeartRateControlPoint()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(HEART_RATE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HEART_RATE_CONTROL_POINT_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

}
