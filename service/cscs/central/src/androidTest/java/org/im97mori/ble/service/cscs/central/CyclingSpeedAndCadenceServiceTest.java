package org.im97mori.ble.service.cscs.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a55.SCControlPoint;
import org.im97mori.ble.characteristic.u2a55.SCControlPointAndroid;
import org.im97mori.ble.characteristic.u2a5b.CSCMeasurementAndroid;
import org.im97mori.ble.characteristic.u2a5c.CSCFeatureAndroid;
import org.im97mori.ble.characteristic.u2a5d.SensorLocationAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.CharacteristicUUID.CSC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CSC_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SC_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.CYCLING_SPEED_AND_CADENCE_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"UnnecessaryLocalVariable", "unused"})
public class CyclingSpeedAndCadenceServiceTest extends AbstractCentralTest {

    @Test
    public void test_onDiscoverServiceSuccess_00001() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(cyclingSpeedAndCadenceService.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00002() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingSpeedAndCadenceService.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00003() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingSpeedAndCadenceService.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00004() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SENSOR_LOCATION_CHARACTERISTIC, 0, 0));
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingSpeedAndCadenceService.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00005() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SENSOR_LOCATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(cyclingSpeedAndCadenceService.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00101() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(cyclingSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00102() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00103() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00104() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, 0, 0));
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00105() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00106() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0));
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00107() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0));
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(cyclingSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00108() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(cyclingSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CSC_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[2];
        final Bundle originalBundle = new Bundle();
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onCSCFeatureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CSCFeatureAndroid cscFeatureAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, cscFeatureAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[1];
        final Bundle originalBundle = new Bundle();
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CSC_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onCSCFeatureReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CSC_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onCSCFeatureReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new SCControlPoint(new byte[]{SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS}).getBytes();
        final Bundle originalBundle = new Bundle();
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SCControlPointAndroid scControlPointAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, scControlPointAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onCSCMeasurementClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onCSCMeasurementClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onCSCMeasurementClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onCSCMeasurementNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onCSCMeasurementNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onCSCMeasurementNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onCSCMeasurementNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onCSCMeasurementNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onCSCMeasurementNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[1];
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onCSCMeasurementNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CSCMeasurementAndroid cscMeasurementAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, cscMeasurementAndroid.getBytes());
                isCalled.set(true);
            }

        };

        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CYCLING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, SCControlPoint.OP_CODE_RESPONSE_CODE, SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
        MockCyclingSpeedAndCadenceServiceCallback mockCyclingSpeedAndCadenceServiceCallback = new MockCyclingSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SCControlPointAndroid scControlPointAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, scControlPointAndroid.getBytes());
                isCalled.set(true);
            }

        };

        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockCyclingSpeedAndCadenceServiceCallback, null);
        cyclingSpeedAndCadenceService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_isSensorLocationCharacteristicSupported_00001() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);

        assertFalse(cyclingSpeedAndCadenceService.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_isSensorLocationCharacteristicSupported_00002() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SENSOR_LOCATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(cyclingSpeedAndCadenceService.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_isSensorLocationCharacteristicSupported_00003() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SENSOR_LOCATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        cyclingSpeedAndCadenceService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(cyclingSpeedAndCadenceService.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_isSCControlPointCharacteristicSupported_00001() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);

        assertFalse(cyclingSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_isSCControlPointCharacteristicSupported_00002() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(cyclingSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_isSCControlPointCharacteristicSupported_00003() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CYCLING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        cyclingSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        cyclingSpeedAndCadenceService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(cyclingSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_getCSCFeature_000001() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);

        assertNull(cyclingSpeedAndCadenceService.getCSCFeature());
    }

    @Test
    public void test_getCSCFeature_000002() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingSpeedAndCadenceService.getCSCFeature());
    }

    @Test
    public void test_getCSCFeature_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNotNull(cyclingSpeedAndCadenceService.getCSCFeature());
    }

    @Test
    public void test_getCSCMeasurementClientCharacteristicConfiguration_000001() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);

        assertNull(cyclingSpeedAndCadenceService.getCSCMeasurementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCSCMeasurementClientCharacteristicConfiguration_000002() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingSpeedAndCadenceService.getCSCMeasurementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCSCMeasurementClientCharacteristicConfiguration_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = cyclingSpeedAndCadenceService.getCSCMeasurementClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startCSCMeasurementNotification_000001() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);

        assertNull(cyclingSpeedAndCadenceService.startCSCMeasurementNotification());
    }

    @Test
    public void test_startCSCMeasurementNotification_000002() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingSpeedAndCadenceService.startCSCMeasurementNotification());
    }

    @Test
    public void test_startCSCMeasurementNotification_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = cyclingSpeedAndCadenceService.startCSCMeasurementNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopCSCMeasurementNotification_000001() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);

        assertNull(cyclingSpeedAndCadenceService.stopCSCMeasurementNotification());
    }

    @Test
    public void test_stopCSCMeasurementNotification_000002() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingSpeedAndCadenceService.stopCSCMeasurementNotification());
    }

    @Test
    public void test_stopCSCMeasurementNotification_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = cyclingSpeedAndCadenceService.stopCSCMeasurementNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getSensorLocation_000001() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);

        assertNull(cyclingSpeedAndCadenceService.getSensorLocation());
    }

    @Test
    public void test_getSensorLocation_000002() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingSpeedAndCadenceService.getSensorLocation());
    }

    @Test
    public void test_getSensorLocation_000003() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSensorLocationCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingSpeedAndCadenceService.getSensorLocation());
    }

    @Test
    public void test_getSensorLocation_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSensorLocationCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNotNull(cyclingSpeedAndCadenceService.getSensorLocation());
    }

    @Test
    public void test_setSCControlPoint_000001() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);
        SCControlPoint scControlPoint = new SCControlPoint(new byte[]{SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS});

        assertNull(cyclingSpeedAndCadenceService.setSCControlPoint(scControlPoint));
    }

    @Test
    public void test_setSCControlPoint_000002() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        SCControlPoint scControlPoint = new SCControlPoint(new byte[]{SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS});

        assertNull(cyclingSpeedAndCadenceService.setSCControlPoint(scControlPoint));
    }

    @Test
    public void test_setSCControlPoint_000003() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSCControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        SCControlPoint scControlPoint = new SCControlPoint(new byte[]{SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS});

        assertNull(cyclingSpeedAndCadenceService.setSCControlPoint(scControlPoint));
    }

    @Test
    public void test_setSCControlPoint_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSCControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        SCControlPoint scControlPoint = new SCControlPoint(new byte[]{SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS});

        Integer taskId = cyclingSpeedAndCadenceService.setSCControlPoint(scControlPoint);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getSCControlPointClientCharacteristicConfiguration_000001() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);

        assertNull(cyclingSpeedAndCadenceService.getSCControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getSCControlPointClientCharacteristicConfiguration_000002() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingSpeedAndCadenceService.getSCControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getSCControlPointClientCharacteristicConfiguration_000003() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSCControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingSpeedAndCadenceService.getSCControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getSCControlPointClientCharacteristicConfiguration_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSCControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = cyclingSpeedAndCadenceService.getSCControlPointClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startSCControlPointIndication_000001() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);

        assertNull(cyclingSpeedAndCadenceService.startSCControlPointIndication());
    }

    @Test
    public void test_startSCControlPointIndication_000002() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingSpeedAndCadenceService.startSCControlPointIndication());
    }

    @Test
    public void test_startSCControlPointIndication_000003() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSCControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingSpeedAndCadenceService.startSCControlPointIndication());
    }

    @Test
    public void test_startSCControlPointIndication_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSCControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = cyclingSpeedAndCadenceService.startSCControlPointIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopSCControlPointIndication_000001() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null);

        assertNull(cyclingSpeedAndCadenceService.stopSCControlPointIndication());
    }

    @Test
    public void test_stopSCControlPointIndication_000002() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingSpeedAndCadenceService.stopSCControlPointIndication());
    }

    @Test
    public void test_stopSCControlPointIndication_000003() {
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSCControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(cyclingSpeedAndCadenceService.stopSCControlPointIndication());
    }

    @Test
    public void test_stopSCControlPointIndication_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        CyclingSpeedAndCadenceService cyclingSpeedAndCadenceService = new CyclingSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockCyclingSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSCControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = cyclingSpeedAndCadenceService.stopSCControlPointIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

}
