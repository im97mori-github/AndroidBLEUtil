package org.im97mori.ble.service.ess.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescriptionAndroid;
import org.im97mori.ble.descriptor.u2906.ValidRangeAndroid;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfigurationAndroid;
import org.im97mori.ble.descriptor.u290c.EnvironmentalSensingMeasurementAndroid;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSettingAndroid;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.CharacteristicUUID.GUST_FACTOR_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HEAT_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HUMIDITY_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.IRRADIANCE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TDS_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.REPORT_REFERENCE_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.ENVIRONMENTAL_SENSING_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "UnnecessaryLocalVariable"})
public class EnvironmentalSensingServiceTest_4 extends AbstractCentralTest {

    @Test
    public void test_onDescriptorReadSuccess_00501() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingMeasurementAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00502() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingMeasurementAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00503() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingMeasurementAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00504() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00505() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00506() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00507() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00508() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00509() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00510() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00511() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(characteristicIndex);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00512() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00513() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(1, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00514() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNotNull(descriptorIndex);
                assertEquals(0, descriptorIndex.intValue());
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00515() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Arrays.asList(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0), BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNotNull(descriptorIndex);
                assertEquals(1, descriptorIndex.intValue());
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00516() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00517() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00519() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00520() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00521() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00522() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00523() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00524() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00525() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00526() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00527() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00528() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00529() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00530() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00531() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00532() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00533() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00534() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00535() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00536() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00537() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00538() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00539() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00540() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00541() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00542() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00543() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00544() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, validRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00545() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, validRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00546() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, validRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00547() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00548() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00549() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00550() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00551() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00552() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00553() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00601() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingMeasurementAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00602() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingMeasurementAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00603() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingMeasurementAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00604() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00605() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00606() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00607() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00608() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00609() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00610() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00611() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(characteristicIndex);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00612() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00613() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(1, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00614() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNotNull(descriptorIndex);
                assertEquals(0, descriptorIndex.intValue());
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00615() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Arrays.asList(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0), BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNotNull(descriptorIndex);
                assertEquals(1, descriptorIndex.intValue());
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00616() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00617() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00619() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00620() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00621() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00622() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00623() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00624() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00625() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00626() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00627() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00628() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00629() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00630() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00631() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00632() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00633() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00634() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00635() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00636() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00637() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00638() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00639() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00640() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00641() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00642() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00643() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00644() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, validRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00645() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, validRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00646() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, validRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00647() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00648() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00649() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00650() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00651() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00652() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00653() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00701() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingMeasurementAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00702() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingMeasurementAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00703() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingMeasurementAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00704() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00705() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00706() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00707() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00708() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00709() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00710() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00711() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(characteristicIndex);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00712() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00713() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(1, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00714() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNotNull(descriptorIndex);
                assertEquals(0, descriptorIndex.intValue());
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00715() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Arrays.asList(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0), BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNotNull(descriptorIndex);
                assertEquals(1, descriptorIndex.intValue());
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00716() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00717() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00719() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00720() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00721() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00722() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00723() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00724() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00725() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00726() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00727() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00728() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00729() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00730() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00731() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00732() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00733() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00734() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00735() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00736() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00737() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00738() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00739() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00740() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00741() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00742() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00743() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00744() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, validRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00745() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, validRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00746() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, validRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00747() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00748() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00749() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00750() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00751() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00752() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00753() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00801() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingMeasurementAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00802() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingMeasurementAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00803() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingMeasurementAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00804() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00805() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00806() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00807() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00808() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00809() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00810() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingMeasurementReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingMeasurementAndroid environmentalSensingMeasurementAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00811() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(characteristicIndex);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00812() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00813() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(1, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00814() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNotNull(descriptorIndex);
                assertEquals(0, descriptorIndex.intValue());
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00815() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Arrays.asList(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0), BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(characteristicIndex);
                assertEquals(0, characteristicIndex.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNotNull(descriptorIndex);
                assertEquals(1, descriptorIndex.intValue());
                assertArrayEquals(originalValues, environmentalSensingTriggerSettingAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00816() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00817() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00819() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00820() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00821() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00822() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00823() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @NonNull Integer descriptorInstanceId, @Nullable Integer descriptorIndex, @NonNull EnvironmentalSensingTriggerSettingAndroid environmentalSensingTriggerSettingAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00824() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00825() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00826() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, environmentalSensingConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00827() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00828() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00829() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00830() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00831() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00832() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00833() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull EnvironmentalSensingConfigurationAndroid environmentalSensingConfigurationAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00834() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00835() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00836() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, characteristicUserDescriptionAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00837() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00838() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00839() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00840() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00841() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00842() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00843() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull CharacteristicUserDescriptionAndroid characteristicUserDescriptionAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00844() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, validRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00845() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, validRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00846() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, validRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00847() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00848() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00849() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = VALID_RANGE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00850() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00851() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00852() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00853() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceValidRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @Nullable Integer index, @NonNull Integer descriptorInstanceId, @NonNull ValidRangeAndroid validRangeAndroid, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertFalse(isCalled.get());
    }

}
