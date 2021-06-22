package org.im97mori.ble.service.rscs.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a53.RSCMeasurementAndroid;
import org.im97mori.ble.characteristic.u2a54.RSCFeatureAndroid;
import org.im97mori.ble.characteristic.u2a55.SCControlPoint;
import org.im97mori.ble.characteristic.u2a55.SCControlPointAndroid;
import org.im97mori.ble.characteristic.u2a5d.SensorLocationAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.CharacteristicUUID.RSC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RSC_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SC_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.RUNNING_SPEED_AND_CADENCE_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"UnnecessaryLocalVariable", "unused"})
public class RunningSpeedAndCadenceServiceTest extends AbstractCentralTest {

    @Test
    public void test_onDiscoverServiceSuccess_00001() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(runningSpeedAndCadenceService.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00002() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(runningSpeedAndCadenceService.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00003() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(runningSpeedAndCadenceService.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00004() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SENSOR_LOCATION_CHARACTERISTIC, 0, 0));
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(runningSpeedAndCadenceService.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00005() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SENSOR_LOCATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(runningSpeedAndCadenceService.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00101() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(runningSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00102() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(runningSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00103() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(runningSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00104() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, 0, 0));
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(runningSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00105() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(runningSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00106() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0));
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(runningSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00107() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0));
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(runningSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00108() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(runningSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RSC_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[2];
        final Bundle originalBundle = new Bundle();
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onRSCFeatureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull RSCFeatureAndroid rscFeatureAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, rscFeatureAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[1];
        final Bundle originalBundle = new Bundle();
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RSC_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onRSCFeatureReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RSC_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onRSCFeatureReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new SCControlPoint(new byte[]{SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS}).getBytes();
        final Bundle originalBundle = new Bundle();
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onRSCMeasurementClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onRSCMeasurementClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onRSCMeasurementClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onRSCMeasurementNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onRSCMeasurementNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onRSCMeasurementNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onRSCMeasurementNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onRSCMeasurementNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onRSCMeasurementNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onSCControlPointIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = RSC_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[4];
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

            @Override
            public void onRSCMeasurementNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull RSCMeasurementAndroid rscMeasurementAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, rscMeasurementAndroid.getBytes());
                isCalled.set(true);
            }

        };

        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = RUNNING_SPEED_AND_CADENCE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SC_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, SCControlPoint.OP_CODE_RESPONSE_CODE, SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
        MockRunningSpeedAndCadenceServiceCallback mockRunningSpeedAndCadenceServiceCallback = new MockRunningSpeedAndCadenceServiceCallback() {

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

        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, mockRunningSpeedAndCadenceServiceCallback, null);
        runningSpeedAndCadenceService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_isSensorLocationCharacteristicSupported_00001() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);

        assertFalse(runningSpeedAndCadenceService.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_isSensorLocationCharacteristicSupported_00002() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SENSOR_LOCATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(runningSpeedAndCadenceService.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_isSensorLocationCharacteristicSupported_00003() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SENSOR_LOCATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        runningSpeedAndCadenceService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(runningSpeedAndCadenceService.isSensorLocationCharacteristicSupported());
    }

    @Test
    public void test_isSCControlPointCharacteristicSupported_00001() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);

        assertFalse(runningSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_isSCControlPointCharacteristicSupported_00002() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(runningSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_isSCControlPointCharacteristicSupported_00003() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(RUNNING_SPEED_AND_CADENCE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SC_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        runningSpeedAndCadenceService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        runningSpeedAndCadenceService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(runningSpeedAndCadenceService.isSCControlPointCharacteristicSupported());
    }

    @Test
    public void test_getRSCFeature_000001() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);

        assertNull(runningSpeedAndCadenceService.getRSCFeature());
    }

    @Test
    public void test_getRSCFeature_000002() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(runningSpeedAndCadenceService.getRSCFeature());
    }

    @Test
    public void test_getRSCFeature_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNotNull(runningSpeedAndCadenceService.getRSCFeature());
    }

    @Test
    public void test_getRSCMeasurementClientCharacteristicConfiguration_000001() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);

        assertNull(runningSpeedAndCadenceService.getRSCMeasurementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getRSCMeasurementClientCharacteristicConfiguration_000002() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(runningSpeedAndCadenceService.getRSCMeasurementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getRSCMeasurementClientCharacteristicConfiguration_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = runningSpeedAndCadenceService.getRSCMeasurementClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startRSCMeasurementNotification_000001() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);

        assertNull(runningSpeedAndCadenceService.startRSCMeasurementNotification());
    }

    @Test
    public void test_startRSCMeasurementNotification_000002() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(runningSpeedAndCadenceService.startRSCMeasurementNotification());
    }

    @Test
    public void test_startRSCMeasurementNotification_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = runningSpeedAndCadenceService.startRSCMeasurementNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopRSCMeasurementNotification_000001() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);

        assertNull(runningSpeedAndCadenceService.stopRSCMeasurementNotification());
    }

    @Test
    public void test_stopRSCMeasurementNotification_000002() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(runningSpeedAndCadenceService.stopRSCMeasurementNotification());
    }

    @Test
    public void test_stopRSCMeasurementNotification_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = runningSpeedAndCadenceService.stopRSCMeasurementNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getSensorLocation_000001() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);

        assertNull(runningSpeedAndCadenceService.getSensorLocation());
    }

    @Test
    public void test_getSensorLocation_000002() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(runningSpeedAndCadenceService.getSensorLocation());
    }

    @Test
    public void test_getSensorLocation_000003() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSensorLocationCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(runningSpeedAndCadenceService.getSensorLocation());
    }

    @Test
    public void test_getSensorLocation_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSensorLocationCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNotNull(runningSpeedAndCadenceService.getSensorLocation());
    }

    @Test
    public void test_setSCControlPoint_000001() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);
        SCControlPoint scControlPoint = new SCControlPoint(new byte[]{SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS});

        assertNull(runningSpeedAndCadenceService.setSCControlPoint(scControlPoint));
    }

    @Test
    public void test_setSCControlPoint_000002() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        SCControlPoint scControlPoint = new SCControlPoint(new byte[]{SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS});

        assertNull(runningSpeedAndCadenceService.setSCControlPoint(scControlPoint));
    }

    @Test
    public void test_setSCControlPoint_000003() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

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

        assertNull(runningSpeedAndCadenceService.setSCControlPoint(scControlPoint));
    }

    @Test
    public void test_setSCControlPoint_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

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

        Integer taskId = runningSpeedAndCadenceService.setSCControlPoint(scControlPoint);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getSCControlPointClientCharacteristicConfiguration_000001() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);

        assertNull(runningSpeedAndCadenceService.getSCControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getSCControlPointClientCharacteristicConfiguration_000002() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(runningSpeedAndCadenceService.getSCControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getSCControlPointClientCharacteristicConfiguration_000003() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSCControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(runningSpeedAndCadenceService.getSCControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getSCControlPointClientCharacteristicConfiguration_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSCControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = runningSpeedAndCadenceService.getSCControlPointClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startSCControlPointIndication_000001() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);

        assertNull(runningSpeedAndCadenceService.startSCControlPointIndication());
    }

    @Test
    public void test_startSCControlPointIndication_000002() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(runningSpeedAndCadenceService.startSCControlPointIndication());
    }

    @Test
    public void test_startSCControlPointIndication_000003() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSCControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(runningSpeedAndCadenceService.startSCControlPointIndication());
    }

    @Test
    public void test_startSCControlPointIndication_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSCControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = runningSpeedAndCadenceService.startSCControlPointIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopSCControlPointIndication_000001() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null);

        assertNull(runningSpeedAndCadenceService.stopSCControlPointIndication());
    }

    @Test
    public void test_stopSCControlPointIndication_000002() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(runningSpeedAndCadenceService.stopSCControlPointIndication());
    }

    @Test
    public void test_stopSCControlPointIndication_000003() {
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSCControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(runningSpeedAndCadenceService.stopSCControlPointIndication());
    }

    @Test
    public void test_stopSCControlPointIndication_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        RunningSpeedAndCadenceService runningSpeedAndCadenceService = new RunningSpeedAndCadenceService(MOCK_BLE_CONNECTION, new MockRunningSpeedAndCadenceServiceCallback(), null) {

            @Override
            public boolean isSCControlPointCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = runningSpeedAndCadenceService.stopSCControlPointIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

}
