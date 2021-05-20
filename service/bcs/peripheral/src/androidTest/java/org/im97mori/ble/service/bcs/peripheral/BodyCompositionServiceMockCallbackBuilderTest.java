package org.im97mori.ble.service.bcs.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

import org.im97mori.ble.characteristic.u2a9b.BodyCompositionFeature;
import org.im97mori.ble.characteristic.u2a9c.BodyCompositionMeasurement;
import org.im97mori.ble.characteristic.u2a9c.BodyCompositionMeasurementPacket;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BODY_COMPOSITION_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.BODY_COMPOSITION_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BodyCompositionServiceMockCallbackBuilderTest extends AbstractPeripherallTest {

    @Test
    public void test_exception_00001() {
        Exception exception = null;
        try {
            new BodyCompositionServiceMockCallback.Builder<>().build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Body Composition Feature data", exception.getMessage());
    }

    @Test
    public void test_exception_00002() {
        Exception exception = null;
        try {
            new BodyCompositionServiceMockCallback.Builder<>()
                    .addBodyCompositionFeature(new BodyCompositionFeature(new byte[4]))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Body Composition Measurement data", exception.getMessage());
    }

    @Test
    public void test_exception_00003() {
        Exception exception = null;
        try {
            new BodyCompositionServiceMockCallback.Builder<>()
                    .addBodyCompositionFeature(new BodyCompositionFeature(new byte[4]))
                    .addBodyCompositionMeasurement(new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{new BodyCompositionMeasurementPacket(new byte[]{0, 0, (byte) 0xff, (byte) 0xff})})
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addBodyCompositionFeature_00001() {
        BodyCompositionFeature bodyCompositionFeature = new BodyCompositionFeature(new byte[4]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BodyCompositionServiceMockCallback callback = new BodyCompositionServiceMockCallback.Builder<>()
                    .addBodyCompositionFeature(bodyCompositionFeature)
                    .addBodyCompositionMeasurement(new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{new BodyCompositionMeasurementPacket(new byte[]{0, 0, (byte) 0xff, (byte) 0xff})})
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BODY_COMPOSITION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BODY_COMPOSITION_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BODY_COMPOSITION_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(bodyCompositionFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addBodyCompositionFeature_00101() {
        BodyCompositionFeature bodyCompositionFeature = new BodyCompositionFeature(new byte[4]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BodyCompositionServiceMockCallback callback = new BodyCompositionServiceMockCallback.Builder<>()
                    .addBodyCompositionFeature(bodyCompositionFeature.getBytes())
                    .addBodyCompositionMeasurement(new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{new BodyCompositionMeasurementPacket(new byte[]{0, 0, (byte) 0xff, (byte) 0xff})})
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BODY_COMPOSITION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BODY_COMPOSITION_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BODY_COMPOSITION_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(bodyCompositionFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addBodyCompositionFeature_00201() {
        BodyCompositionFeature bodyCompositionFeature = new BodyCompositionFeature(new byte[4]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BodyCompositionServiceMockCallback callback = new BodyCompositionServiceMockCallback.Builder<>()
                    .addBodyCompositionFeature(BluetoothGatt.GATT_SUCCESS, 0, bodyCompositionFeature.getBytes())
                    .addBodyCompositionMeasurement(new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{new BodyCompositionMeasurementPacket(new byte[]{0, 0, (byte) 0xff, (byte) 0xff})})
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BODY_COMPOSITION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BODY_COMPOSITION_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BODY_COMPOSITION_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(bodyCompositionFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeBodyCompositionFeature_00001() {
        BodyCompositionFeature bodyCompositionFeature = new BodyCompositionFeature(new byte[4]);

        Exception exception = null;
        try {
            new BodyCompositionServiceMockCallback.Builder<>()
                    .addBodyCompositionFeature(bodyCompositionFeature)
                    .addBodyCompositionMeasurement(new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{new BodyCompositionMeasurementPacket(new byte[]{0, 0, (byte) 0xff, (byte) 0xff})})
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeBodyCompositionFeature()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Body Composition Feature data", exception.getMessage());
    }

    @Test
    public void test_addBodyCompositionMeasurement_00001() {
        BodyCompositionMeasurement bodyCompositionMeasurement = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{new BodyCompositionMeasurementPacket(new byte[]{0, 0, (byte) 0xff, (byte) 0xff})});
        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BodyCompositionServiceMockCallback userDataServiceMockCallback = new BodyCompositionServiceMockCallback.Builder<>()
                    .addBodyCompositionMeasurement(bodyCompositionMeasurement, clientCharacteristicConfiguration)
                    .addBodyCompositionFeature(new BodyCompositionFeature(new byte[4]))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BODY_COMPOSITION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(bodyCompositionMeasurement.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addBodyCompositionMeasurement_00101() {
        BodyCompositionMeasurement bodyCompositionMeasurement = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{new BodyCompositionMeasurementPacket(new byte[]{0, 0, (byte) 0xff, (byte) 0xff})});
        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);
        int characteristicResponseCode = 1;
        long characteristicDelay = 2;
        int notificationCount = 3;
        int descriptorResponseCode = 4;
        long descriptorDelay = 5;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BodyCompositionServiceMockCallback userDataServiceMockCallback = new BodyCompositionServiceMockCallback.Builder<>()
                    .addBodyCompositionMeasurement(characteristicResponseCode, characteristicDelay, bodyCompositionMeasurement.getBytes(), notificationCount, descriptorResponseCode, descriptorDelay, clientCharacteristicConfiguration.getBytes())
                    .addBodyCompositionFeature(new BodyCompositionFeature(new byte[4]))
                    .build();
            userDataServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BODY_COMPOSITION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(bodyCompositionMeasurement.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeRegisteredUser_00001() {
        BodyCompositionMeasurement bodyCompositionMeasurement = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{new BodyCompositionMeasurementPacket(new byte[]{0, 0, (byte) 0xff, (byte) 0xff})});
        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        Exception exception = null;
        try {
            new BodyCompositionServiceMockCallback.Builder<>()
                    .addBodyCompositionMeasurement(bodyCompositionMeasurement, clientCharacteristicConfiguration)
                    .addBodyCompositionFeature(new BodyCompositionFeature(new byte[4]))
                    .removeBodyCompositionMeasurement()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Body Composition Measurement data", exception.getMessage());
    }

}
