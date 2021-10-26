package org.im97mori.ble.service.ess.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

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
import static org.im97mori.ble.constants.DescriptorUUID.ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.REPORT_REFERENCE_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.ENVIRONMENTAL_SENSING_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "UnnecessaryLocalVariable"})
public class EnvironmentalSensingServiceTest_25 extends AbstractCentralTest {

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00511() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(characteristicIndex);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00512() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
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
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00513() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
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
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00514() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
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
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00515() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Arrays.asList(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0), BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
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
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00516() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00517() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00519() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00520() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00521() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00522() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00523() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00524() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00525() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00526() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00527() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00528() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00529() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00530() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00531() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00532() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00533() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00534() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00535() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00536() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00537() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00538() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00539() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00540() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00541() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = GUST_FACTOR_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00542() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00543() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(GUST_FACTOR_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onGustFactorCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00611() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(characteristicIndex);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00612() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
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
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00613() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
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
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00614() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
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
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00615() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Arrays.asList(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0), BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
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
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00616() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00617() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00619() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00620() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00621() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00622() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00623() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00624() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00625() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00626() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00627() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00628() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00629() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00630() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00631() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00632() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00633() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00634() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00635() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00636() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HEAT_INDEX_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00637() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00638() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00639() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00640() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00641() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HEAT_INDEX_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00642() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00643() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HEAT_INDEX_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHeatIndexCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00711() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(characteristicIndex);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00712() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
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
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00713() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
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
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00714() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
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
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00715() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Arrays.asList(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0), BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
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
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00716() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00717() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00719() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00720() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00721() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00722() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00723() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00724() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00725() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00726() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00727() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00728() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00729() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00730() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00731() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00732() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00733() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00734() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00735() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00736() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00737() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00738() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00739() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00740() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00741() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = HUMIDITY_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00742() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00743() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(HUMIDITY_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onHumidityCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00811() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(characteristicIndex);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertNull(descriptorIndex);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00812() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
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
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00813() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
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
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00814() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
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
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00815() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Arrays.asList(new BluetoothGattDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, 0), BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
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
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00816() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00817() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00819() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00820() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00821() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00822() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00823() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);


        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.singletonList(BLETestUtilsAndroid.createBluetoothDescriptor(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, originalDescriptorInstanceId, 0))));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingTriggerSettingWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer characteristicIndex, @Nullable Integer descriptorInstanceId, @Nullable Integer descriptorIndex, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00824() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00825() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00826() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00827() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00828() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00829() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00830() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00831() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00832() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00833() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceEnvironmentalSensingConfigurationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00834() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNull(index);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00835() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(0, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00836() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(IRRADIANCE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ));

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertNotNull(index);
                assertEquals(1, index.intValue());
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00837() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00838() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00839() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00840() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00841() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = IRRADIANCE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00842() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = ENVIRONMENTAL_SENSING_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.KITKAT)
    public void test_onDescriptorWriteFailed_00843() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = GENERIC_ACCESS_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TDS_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = REPORT_REFERENCE_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();

        BluetoothGattService bluetoothGattService = new BluetoothGattService(ENVIRONMENTAL_SENSING_SERVICE, 0);

        bluetoothGattService.addCharacteristic(BLETestUtilsAndroid.createBluetoothCharacteristic(IRRADIANCE_CHARACTERISTIC, originalCharacteristicInstanceId, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 16, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, Collections.emptyList()));
        MockEnvironmentalSensingServiceCallback mockEnvironmentalSensingServiceCallback = new MockEnvironmentalSensingServiceCallback() {

            @Override
            public void onIrradianceCharacteristicUserDescriptionWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer index, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                isCalled.set(true);
            }

        };
        EnvironmentalSensingService environmentalSensingService = new EnvironmentalSensingService(MOCK_BLE_CONNECTION, mockEnvironmentalSensingServiceCallback, null);
        environmentalSensingService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        environmentalSensingService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertFalse(isCalled.get());
    }

}
