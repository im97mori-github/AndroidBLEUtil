package org.im97mori.ble.service.wss.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.characteristic.u2a9d.WeightMeasurement;
import org.im97mori.ble.characteristic.u2a9e.WeightScaleFeature;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.test.peripheral.MockBLEServerConnection;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WEIGHT_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WEIGHT_SCALE_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.WEIGHT_SCALE_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class WeightScaleServiceMockCallbackBuilderTest {

    @Test
    public void test_addWeightScaleFeature_00001() {
        Exception exception = null;
        try {
            new WeightScaleServiceMockCallback.Builder<>().build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Weight Scale Feature data", exception.getMessage());
    }

    @Test
    public void test_addWeightScaleFeature_00101() {
        WeightScaleFeature weightScaleFeature = new WeightScaleFeature(false
                , false
                , false
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };

        Exception exception = null;
        try {
            WeightScaleServiceMockCallback callback = new WeightScaleServiceMockCallback.Builder<>()
                    .addWeightScaleFeature(weightScaleFeature)
                    .addWeightMeasurement(new WeightMeasurement(new byte[3]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            callback.setup(mockBLEServerConnection);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(WEIGHT_SCALE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(WEIGHT_SCALE_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(WEIGHT_SCALE_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(weightScaleFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addWeightScaleFeature_00201() {
        WeightScaleFeature weightScaleFeature = new WeightScaleFeature(false
                , false
                , false
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };

        Exception exception = null;
        try {
            WeightScaleServiceMockCallback callback = new WeightScaleServiceMockCallback.Builder<>()
                    .addWeightScaleFeature(weightScaleFeature.getBytes())
                    .addWeightMeasurement(new WeightMeasurement(new byte[3]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            callback.setup(mockBLEServerConnection);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(WEIGHT_SCALE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(WEIGHT_SCALE_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(WEIGHT_SCALE_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(weightScaleFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addWeightScaleFeature_00301() {
        WeightScaleFeature weightScaleFeature = new WeightScaleFeature(false
                , false
                , false
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };

        Exception exception = null;
        try {
            WeightScaleServiceMockCallback callback = new WeightScaleServiceMockCallback.Builder<>()
                    .addWeightScaleFeature(BluetoothGatt.GATT_SUCCESS, 0, weightScaleFeature.getBytes())
                    .addWeightMeasurement(new WeightMeasurement(new byte[3]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            callback.setup(mockBLEServerConnection);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(WEIGHT_SCALE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(WEIGHT_SCALE_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(WEIGHT_SCALE_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(weightScaleFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeWeightScaleFeature_00001() {
        WeightScaleFeature weightScaleFeature = new WeightScaleFeature(false
                , false
                , false
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED);

        Exception exception = null;
        try {
            new WeightScaleServiceMockCallback.Builder<>()
                    .addWeightScaleFeature(weightScaleFeature)
                    .addWeightMeasurement(new WeightMeasurement(new byte[3]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeWeightScaleFeature()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Weight Scale Feature data", exception.getMessage());
    }

    @Test
    public void test_addWeightMeasurement_00001() {
        WeightScaleFeature weightScaleFeature = new WeightScaleFeature(false
                , false
                , false
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED);

        Exception exception = null;
        try {
            new WeightScaleServiceMockCallback.Builder<>()
                    .addWeightScaleFeature(weightScaleFeature)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Weight Measurement data", exception.getMessage());
    }

    @Test
    public void test_addWeightMeasurement_00101() {
        WeightScaleFeature weightScaleFeature = new WeightScaleFeature(false
                , false
                , false
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED);

        WeightMeasurement weightMeasurement = new WeightMeasurement(new byte[]{
                WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        });

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Exception exception = null;
        try {
            new WeightScaleServiceMockCallback.Builder<>()
                    .addWeightScaleFeature(weightScaleFeature)
                    .addWeightMeasurement(weightMeasurement, clientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Time Stamp not Supported", exception.getMessage());
    }

    @Test
    public void test_addWeightMeasurement_00102() {
        WeightScaleFeature weightScaleFeature = new WeightScaleFeature(true
                , false
                , false
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED);

        WeightMeasurement weightMeasurement = new WeightMeasurement(new byte[]{
                WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        });

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Exception exception = null;
        try {
            new WeightScaleServiceMockCallback.Builder<>()
                    .addWeightScaleFeature(weightScaleFeature)
                    .addWeightMeasurement(weightMeasurement, clientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addWeightMeasurement_00103() {
        WeightScaleFeature weightScaleFeature = new WeightScaleFeature(false
                , false
                , false
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED);

        WeightMeasurement weightMeasurement = new WeightMeasurement(new byte[]{
                WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                , 0
                , 0
                , 0
                , 0
        });

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Exception exception = null;
        try {
            new WeightScaleServiceMockCallback.Builder<>()
                    .addWeightScaleFeature(weightScaleFeature)
                    .addWeightMeasurement(weightMeasurement, clientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Multiple Users not Supported", exception.getMessage());
    }

    @Test
    public void test_addWeightMeasurement_00104() {
        WeightScaleFeature weightScaleFeature = new WeightScaleFeature(false
                , true
                , false
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED);

        WeightMeasurement weightMeasurement = new WeightMeasurement(new byte[]{
                WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                , 0
                , 0
                , 0
                , 0
        });

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Exception exception = null;
        try {
            new WeightScaleServiceMockCallback.Builder<>()
                    .addWeightScaleFeature(weightScaleFeature)
                    .addWeightMeasurement(weightMeasurement, clientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addWeightMeasurement_00105() {
        WeightScaleFeature weightScaleFeature = new WeightScaleFeature(false
                , false
                , false
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED);

        WeightMeasurement weightMeasurement = new WeightMeasurement(new byte[]{
                WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        });

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Exception exception = null;
        try {
            new WeightScaleServiceMockCallback.Builder<>()
                    .addWeightScaleFeature(weightScaleFeature)
                    .addWeightMeasurement(weightMeasurement, clientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("BMI not Supported", exception.getMessage());
    }

    @Test
    public void test_addWeightMeasurement_00106() {
        WeightScaleFeature weightScaleFeature = new WeightScaleFeature(false
                , false
                , true
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED);

        WeightMeasurement weightMeasurement = new WeightMeasurement(new byte[]{
                WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        });

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Exception exception = null;
        try {
            new WeightScaleServiceMockCallback.Builder<>()
                    .addWeightScaleFeature(weightScaleFeature)
                    .addWeightMeasurement(weightMeasurement, clientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addWeightMeasurement_00201() {
        WeightScaleFeature weightScaleFeature = new WeightScaleFeature(false
                , false
                , false
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED);

        WeightMeasurement weightMeasurement = new WeightMeasurement(new byte[3]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };

        Exception exception = null;
        try {
            WeightScaleServiceMockCallback callback = new WeightScaleServiceMockCallback.Builder<>()
                    .addWeightScaleFeature(weightScaleFeature)
                    .addWeightMeasurement(weightMeasurement, clientCharacteristicConfiguration)
                    .build();
            callback.setup(mockBLEServerConnection);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(WEIGHT_SCALE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(WEIGHT_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(WEIGHT_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(weightMeasurement.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addWeightMeasurement_00202() {
        WeightScaleFeature weightScaleFeature = new WeightScaleFeature(false
                , false
                , false
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED);

        WeightMeasurement weightMeasurement = new WeightMeasurement(new byte[3]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };

        Exception exception = null;
        try {
            WeightScaleServiceMockCallback callback = new WeightScaleServiceMockCallback.Builder<>()
                    .addWeightScaleFeature(weightScaleFeature)
                    .addWeightMeasurement(BluetoothGatt.GATT_SUCCESS, 0, weightMeasurement.getBytes(), 0, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes())
                    .build();
            callback.setup(mockBLEServerConnection);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(WEIGHT_SCALE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(WEIGHT_MEASUREMENT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(WEIGHT_MEASUREMENT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(weightMeasurement.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeWeightMeasurement_00001() {
        WeightScaleFeature weightScaleFeature = new WeightScaleFeature(false
                , false
                , false
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_WEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED
                , WeightScaleFeature.WEIGHT_SCALE_FEATURE_HEIGHT_MEASUREMENT_RESOLUTION_NOT_SPECIFIED);

        Exception exception = null;
        try {
            new WeightScaleServiceMockCallback.Builder<>()
                    .addWeightScaleFeature(weightScaleFeature)
                    .addWeightMeasurement(new WeightMeasurement(new byte[3]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeWeightMeasurement()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Weight Measurement data", exception.getMessage());
    }

}
