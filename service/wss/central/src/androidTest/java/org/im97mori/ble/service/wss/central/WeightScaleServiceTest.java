package org.im97mori.ble.service.wss.central;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a9d.WeightMeasurement;
import org.im97mori.ble.characteristic.u2a9d.WeightMeasurementAndroid;
import org.im97mori.ble.characteristic.u2a9e.WeightScaleFeatureAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.CharacteristicUUID.BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.BODY_SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LN_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.WEIGHT_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.WEIGHT_SCALE_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.VALUE_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ATTRIBUTE_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.WEIGHT_SCALE_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("UnnecessaryLocalVariable")
public class WeightScaleServiceTest extends AbstractCentralTest {
    @Test
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_SCALE_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightScaleFeatureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull WeightScaleFeatureAndroid weightScaleFeatureAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, weightScaleFeatureAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_SCALE_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightScaleFeatureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull WeightScaleFeatureAndroid weightScaleFeatureAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4, 5, 6, 7};
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightScaleFeatureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull WeightScaleFeatureAndroid weightScaleFeatureAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_SCALE_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightScaleFeatureReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_SCALE_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightScaleFeatureReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightScaleFeatureReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_SCALE_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightScaleFeatureReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_SCALE_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightScaleFeatureReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        UUID originalCharacteristicUUID = BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightScaleFeatureReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
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
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BODY_SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BODY_SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALUE_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BODY_SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
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
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BODY_SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
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
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BODY_SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BODY_SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BODY_SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BODY_SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BODY_SENSOR_LOCATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        final byte[] originalValues = new WeightMeasurement(new byte[3]).getBytes();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull WeightMeasurementAndroid weightMeasurementAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, weightMeasurementAndroid.getBytes());
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_1;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        final byte[] originalValues = new WeightMeasurement(new byte[3]).getBytes();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull WeightMeasurementAndroid weightMeasurementAndroid) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ATTRIBUTE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = WEIGHT_MEASUREMENT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        final byte[] originalValues = new WeightMeasurement(new byte[3]).getBytes();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull WeightMeasurementAndroid weightMeasurementAndroid) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = WEIGHT_SCALE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LN_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;

        final byte[] originalValues = new WeightMeasurement(new byte[3]).getBytes();
        MockWeightScaleServiceCallback mockWeightScaleServiceCallback = new MockWeightScaleServiceCallback() {

            @Override
            public void onWeightMeasurementIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull WeightMeasurementAndroid weightMeasurementAndroid) {
                isCalled.set(true);
            }

        };
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, mockWeightScaleServiceCallback, null);
        weightScaleService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_getWeightScaleFeature_00001() {
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, new MockWeightScaleServiceCallback(), null);

        assertNull(weightScaleService.getWeightScaleFeature());
    }

    @Test
    public void test_getWeightScaleFeature_00002() {
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, new MockWeightScaleServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(weightScaleService.getWeightScaleFeature());
    }

    @Test
    public void test_getWeightScaleFeature_00003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, new MockWeightScaleServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = weightScaleService.getWeightScaleFeature();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getWeightMeasurementClientCharacteristicConfiguration_00001() {
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, new MockWeightScaleServiceCallback(), null);

        assertNull(weightScaleService.getWeightMeasurementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getWeightMeasurementClientCharacteristicConfiguration_00002() {
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, new MockWeightScaleServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(weightScaleService.getWeightMeasurementClientCharacteristicConfiguration());
    }

    @Test
    public void test_getWeightMeasurementClientCharacteristicConfiguration_00003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, new MockWeightScaleServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = weightScaleService.getWeightMeasurementClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startWeightMeasurementIndication_00001() {
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, new MockWeightScaleServiceCallback(), null);

        assertNull(weightScaleService.startWeightMeasurementIndication());
    }

    @Test
    public void test_startWeightMeasurementIndication_00002() {
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, new MockWeightScaleServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(weightScaleService.startWeightMeasurementIndication());
    }

    @Test
    public void test_startWeightMeasurementIndication_00003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, new MockWeightScaleServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = weightScaleService.startWeightMeasurementIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopWeightMeasurementIndication_00001() {
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, new MockWeightScaleServiceCallback(), null);

        assertNull(weightScaleService.stopWeightMeasurementIndication());
    }

    @Test
    public void test_stopWeightMeasurementIndication_00002() {
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, new MockWeightScaleServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(weightScaleService.stopWeightMeasurementIndication());
    }

    @Test
    public void test_stopWeightMeasurementIndication_00003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        WeightScaleService weightScaleService = new WeightScaleService(MOCK_BLE_CONNECTION, new MockWeightScaleServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = weightScaleService.stopWeightMeasurementIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

}
