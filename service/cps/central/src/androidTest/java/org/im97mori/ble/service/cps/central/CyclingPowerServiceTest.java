package org.im97mori.ble.service.cps.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.characteristic.core.SensorLocationUtils;
import org.im97mori.ble.characteristic.u2a5d.SensorLocationAndroid;
import org.im97mori.ble.characteristic.u2a63.CyclingPowerMeasurementAndroid;
import org.im97mori.ble.characteristic.u2a64.CyclingPowerVector;
import org.im97mori.ble.characteristic.u2a64.CyclingPowerVectorAndroid;
import org.im97mori.ble.characteristic.u2a65.CyclingPowerFeatureAndroid;
import org.im97mori.ble.characteristic.u2a66.CyclingPowerControlPoint;
import org.im97mori.ble.characteristic.u2a66.CyclingPowerControlPointAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.CharacteristicUUID.CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CYCLING_POWER_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CYCLING_POWER_VECTOR_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.CYCLING_POWER_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("UnnecessaryLocalVariable")
public class CyclingPowerServiceTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00001() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(cyclingPowerService.isCyclingPowerControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00002() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingPowerService.isCyclingPowerControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00003() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingPowerService.isCyclingPowerControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00004() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, 0, 0));
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingPowerService.isCyclingPowerControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00005() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingPowerService.isCyclingPowerControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00006() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0));
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingPowerService.isCyclingPowerControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00007() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0));
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingPowerService.isCyclingPowerControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00008() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(cyclingPowerService.isCyclingPowerControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00101() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(cyclingPowerService.isCyclingPowerVectorCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00102() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingPowerService.isCyclingPowerVectorCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00103() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingPowerService.isCyclingPowerVectorCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00104() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CYCLING_POWER_VECTOR_CHARACTERISTIC, 0, 0));
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingPowerService.isCyclingPowerVectorCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00105() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CYCLING_POWER_VECTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingPowerService.isCyclingPowerVectorCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00106() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_VECTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(cyclingPowerService.isCyclingPowerVectorCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[4];
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerFeatureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CyclingPowerFeatureAndroid cyclingPowerFeatureAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, cyclingPowerFeatureAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{SensorLocationUtils.SENSOR_LOCATION_TOP_OF_SHOE};
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onSensorLocationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SensorLocationAndroid sensorLocationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, sensorLocationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerFeatureReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onSensorLocationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerFeatureReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onSensorLocationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new CyclingPowerControlPoint(new byte[]{CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE}).getBytes();
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerControlPointWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CyclingPowerControlPointAndroid cyclingPowerControlPointAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, cyclingPowerControlPointAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerControlPointWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerControlPointWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerMeasurementClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerControlPointClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_VECTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerVectorClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerMeasurementClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerControlPointClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_VECTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerVectorClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerMeasurementClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerControlPointClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_VECTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerVectorClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerMeasurementNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerControlPointIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_VECTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerVectorNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerMeasurementNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerControlPointIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_VECTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerVectorNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerMeasurementNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerControlPointIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_VECTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerVectorNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerMeasurementNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerControlPointIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_VECTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerVectorNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerMeasurementNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerControlPointIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_VECTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerVectorNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerMeasurementNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerControlPointIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_VECTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerVectorNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[4];
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerMeasurementNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CyclingPowerMeasurementAndroid cyclingPowerMeasurementAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, cyclingPowerMeasurementAndroid.getBytes());
                isCalled.set(true);
            }

        };

        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new CyclingPowerControlPoint(new byte[]{CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, 0, 0, 0, 0}).getBytes();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerControlPointIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CyclingPowerControlPointAndroid cyclingPowerControlPointAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, cyclingPowerControlPointAndroid.getBytes());
                isCalled.set(true);
            }

        };

        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_POWER_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CYCLING_POWER_VECTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new CyclingPowerVector(new byte[1]).getBytes();
        MockCyclingPowerServiceCallback mockCyclingPowerServiceCallback = new MockCyclingPowerServiceCallback() {

            @Override
            public void onCyclingPowerVectorNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CyclingPowerVectorAndroid cyclingPowerVectorAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, cyclingPowerVectorAndroid.getBytes());
                isCalled.set(true);
            }

        };

        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, mockCyclingPowerServiceCallback, null);
        cyclingPowerService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_isCyclingPowerControlPointCharacteristicSupported_00001() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);

        assertFalse(cyclingPowerService.isCyclingPowerControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isCyclingPowerControlPointCharacteristicSupported_00002() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(cyclingPowerService.isCyclingPowerControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isCyclingPowerControlPointCharacteristicSupported_00003() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        cyclingPowerService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(cyclingPowerService.isCyclingPowerControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isCyclingPowerVectorCharacteristicSupported_00001() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);

        assertFalse(cyclingPowerService.isCyclingPowerVectorCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isCyclingPowerVectorCharacteristicSupported_00002() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_VECTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(cyclingPowerService.isCyclingPowerVectorCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isCyclingPowerVectorCharacteristicSupported_00003() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_POWER_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CYCLING_POWER_VECTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        cyclingPowerService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        cyclingPowerService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(cyclingPowerService.isCyclingPowerVectorCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_getCyclingPowerFeature_000001() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);

        assertNull(cyclingPowerService.getCyclingPowerFeature());
    }

    @Test
    @RequiresDevice
    public void test_getCyclingPowerFeature_000002() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.getCyclingPowerFeature());
    }

    @Test
    @RequiresDevice
    public void test_getCyclingPowerFeature_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNotNull(cyclingPowerService.getCyclingPowerFeature());
    }

    @Test
    @RequiresDevice
    public void test_getCyclingPowerMeasurementClientCharacteristicConfiguration_000001() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);

        assertNull(cyclingPowerService.getCyclingPowerMeasurementClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getCyclingPowerMeasurementClientCharacteristicConfiguration_000002() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.getCyclingPowerMeasurementClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getCyclingPowerMeasurementClientCharacteristicConfiguration_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = cyclingPowerService.getCyclingPowerMeasurementClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_startCyclingPowerMeasurementNotification_000001() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);

        assertNull(cyclingPowerService.startCyclingPowerMeasurementNotification());
    }

    @Test
    @RequiresDevice
    public void test_startCyclingPowerMeasurementNotification_000002() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.startCyclingPowerMeasurementNotification());
    }

    @Test
    @RequiresDevice
    public void test_startCyclingPowerMeasurementNotification_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = cyclingPowerService.startCyclingPowerMeasurementNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopCyclingPowerMeasurementNotification_000001() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);

        assertNull(cyclingPowerService.stopCyclingPowerMeasurementNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopCyclingPowerMeasurementNotification_000002() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.stopCyclingPowerMeasurementNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopCyclingPowerMeasurementNotification_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = cyclingPowerService.stopCyclingPowerMeasurementNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getSensorLocation_000001() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);

        assertNull(cyclingPowerService.getSensorLocation());
    }

    @Test
    @RequiresDevice
    public void test_getSensorLocation_000002() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.getSensorLocation());
    }

    @Test
    @RequiresDevice
    public void test_getSensorLocation_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNotNull(cyclingPowerService.getSensorLocation());
    }

    @Test
    @RequiresDevice
    public void test_setCyclingPowerControlPoint_000001() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);
        CyclingPowerControlPoint cyclingPowerControlPoint = new CyclingPowerControlPoint(new byte[]{CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, 0, 0, 0, 0});

        assertNull(cyclingPowerService.setCyclingPowerControlPoint(cyclingPowerControlPoint));
    }

    @Test
    @RequiresDevice
    public void test_setCyclingPowerControlPoint_000002() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        CyclingPowerControlPoint cyclingPowerControlPoint = new CyclingPowerControlPoint(new byte[]{CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, 0, 0, 0, 0});

        assertNull(cyclingPowerService.setCyclingPowerControlPoint(cyclingPowerControlPoint));
    }

    @Test
    @RequiresDevice
    public void test_setCyclingPowerControlPoint_000003() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isCyclingPowerControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        CyclingPowerControlPoint cyclingPowerControlPoint = new CyclingPowerControlPoint(new byte[]{CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, 0, 0, 0, 0});

        assertNull(cyclingPowerService.setCyclingPowerControlPoint(cyclingPowerControlPoint));
    }

    @Test
    @RequiresDevice
    public void test_setCyclingPowerControlPoint_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isCyclingPowerControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        CyclingPowerControlPoint cyclingPowerControlPoint = new CyclingPowerControlPoint(new byte[]{CyclingPowerControlPoint.OP_CODES_SET_CUMULATIVE_VALUE, 0, 0, 0, 0});

        Integer taskId = cyclingPowerService.setCyclingPowerControlPoint(cyclingPowerControlPoint);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getCyclingPowerControlPointClientCharacteristicConfiguration_000001() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);

        assertNull(cyclingPowerService.getCyclingPowerControlPointClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getCyclingPowerControlPointClientCharacteristicConfiguration_000002() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.getCyclingPowerControlPointClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getCyclingPowerControlPointClientCharacteristicConfiguration_000003() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isCyclingPowerControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.getCyclingPowerControlPointClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getCyclingPowerControlPointClientCharacteristicConfiguration_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isCyclingPowerControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = cyclingPowerService.getCyclingPowerControlPointClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_startCyclingPowerControlPointIndication_000001() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);

        assertNull(cyclingPowerService.startCyclingPowerControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_startCyclingPowerControlPointIndication_000002() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.startCyclingPowerControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_startCyclingPowerControlPointIndication_000003() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isCyclingPowerControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.startCyclingPowerControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_startCyclingPowerControlPointIndication_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {


            @Override
            public boolean isCyclingPowerControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = cyclingPowerService.startCyclingPowerControlPointIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopCyclingPowerControlPointIndication_000001() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);

        assertNull(cyclingPowerService.stopCyclingPowerControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopCyclingPowerControlPointIndication_000002() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.stopCyclingPowerControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopCyclingPowerControlPointIndication_000003() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isCyclingPowerControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.stopCyclingPowerControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopCyclingPowerControlPointIndication_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isCyclingPowerControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = cyclingPowerService.stopCyclingPowerControlPointIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getCyclingPowerVectorClientCharacteristicConfiguration_000001() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);

        assertNull(cyclingPowerService.getCyclingPowerVectorClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getCyclingPowerVectorClientCharacteristicConfiguration_000002() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.getCyclingPowerVectorClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getCyclingPowerVectorClientCharacteristicConfiguration_000003() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isCyclingPowerVectorCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.getCyclingPowerVectorClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getCyclingPowerVectorClientCharacteristicConfiguration_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isCyclingPowerVectorCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = cyclingPowerService.getCyclingPowerVectorClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_startCyclingPowerVectorNotification_000001() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);

        assertNull(cyclingPowerService.startCyclingPowerVectorNotification());
    }

    @Test
    @RequiresDevice
    public void test_startCyclingPowerVectorNotification_000002() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.startCyclingPowerVectorNotification());
    }

    @Test
    @RequiresDevice
    public void test_startCyclingPowerVectorNotification_000003() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isCyclingPowerVectorCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.startCyclingPowerVectorNotification());
    }

    @Test
    @RequiresDevice
    public void test_startCyclingPowerVectorNotification_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {


            @Override
            public boolean isCyclingPowerVectorCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = cyclingPowerService.startCyclingPowerVectorNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopCyclingPowerVectorNotification_000001() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null);

        assertNull(cyclingPowerService.stopCyclingPowerVectorNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopCyclingPowerVectorNotification_000002() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.stopCyclingPowerVectorNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopCyclingPowerVectorNotification_000003() {
        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isCyclingPowerVectorCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingPowerService.stopCyclingPowerVectorNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopCyclingPowerVectorNotification_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);

        CyclingPowerService cyclingPowerService = new CyclingPowerService(MOCK_BLE_CONNECTION, new MockCyclingPowerServiceCallback(), null) {

            @Override
            public boolean isCyclingPowerVectorCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = cyclingPowerService.stopCyclingPowerVectorNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

}
