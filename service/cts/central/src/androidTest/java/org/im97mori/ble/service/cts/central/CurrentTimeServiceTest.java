package org.im97mori.ble.service.cts.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.characteristic.core.TimeZoneUtils;
import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformationAndroid;
import org.im97mori.ble.characteristic.u2a14.ReferenceTimeInformationAndroid;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.characteristic.u2a2b.CurrentTimeAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.CharacteristicUUID.CURRENT_TIME_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LOCAL_TIME_INFORMATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.REFERENCE_TIME_INFORMATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.CURRENT_TIME_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"UnnecessaryLocalVariable", "unused"})
public class CurrentTimeServiceTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CURRENT_TIME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        currentTimeService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00101() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        currentTimeService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00201() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(REFERENCE_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        currentTimeService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(currentTimeService.isReferenceTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00003() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CURRENT_TIME_CHARACTERISTIC, 0, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00004() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CURRENT_TIME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00005() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CURRENT_TIME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00101() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00102() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00103() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, 0, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00104() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(currentTimeService.isLocalTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00201() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00202() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00203() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, 0, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00204() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00205() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00206() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(currentTimeService.isLocalTimeInformationCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00301() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(currentTimeService.isReferenceTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00302() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isReferenceTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00303() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(REFERENCE_TIME_INFORMATION_CHARACTERISTIC, 0, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(currentTimeService.isReferenceTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00304() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(REFERENCE_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(currentTimeService.isReferenceTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CurrentTimeAndroid currentTimeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, currentTimeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LOCAL_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{0, 1};
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onLocalTimeInformationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull LocalTimeInformationAndroid localTimeInformationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, localTimeInformationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = REFERENCE_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{0, 1, 2, 3};
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onReferenceTimeInformationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ReferenceTimeInformationAndroid referenceTimeInformationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, referenceTimeInformationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LOCAL_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onLocalTimeInformationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = REFERENCE_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onReferenceTimeInformationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LOCAL_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onLocalTimeInformationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00201() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = REFERENCE_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onReferenceTimeInformationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CurrentTimeAndroid currentTimeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, currentTimeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LOCAL_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{0, 1};
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onLocalTimeInformationWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull LocalTimeInformationAndroid localTimeInformationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, localTimeInformationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LOCAL_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onLocalTimeInformationWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = LOCAL_TIME_INFORMATION_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onLocalTimeInformationWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeNotifyStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeNotifyStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeNotifyStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeNotifyStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeNotifyStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeNotifyStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
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
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = CURRENT_TIME_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CURRENT_TIME_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        MockCurrentTimeServiceCallback mockCurrentTimeServiceCallback = new MockCurrentTimeServiceCallback() {

            @Override
            public void onCurrentTimeNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CurrentTimeAndroid currentTimeAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, currentTimeAndroid.getBytes());
                isCalled.set(true);
            }

        };

        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, mockCurrentTimeServiceCallback, null);
        currentTimeService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_isCurrentTimeCharacteristicWritable_00001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);

        assertFalse(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_isCurrentTimeCharacteristicWritable_00002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CURRENT_TIME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_isCurrentTimeCharacteristicWritable_00003() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CURRENT_TIME_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        currentTimeService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(currentTimeService.isCurrentTimeCharacteristicWritable());
    }

    @Test
    @RequiresDevice
    public void test_isLocalTimeInformationCharacteristicSupported_00001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isLocalTimeInformationCharacteristicSupported_00002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(currentTimeService.isLocalTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isLocalTimeInformationCharacteristicSupported_00003() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        currentTimeService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(currentTimeService.isLocalTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isReferenceTimeInformationCharacteristicSupported_00001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);

        assertFalse(currentTimeService.isReferenceTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isReferenceTimeInformationCharacteristicSupported_00002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(REFERENCE_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(currentTimeService.isReferenceTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isReferenceTimeInformationCharacteristicSupported_00003() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(CURRENT_TIME_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(REFERENCE_TIME_INFORMATION_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        currentTimeService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        currentTimeService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(currentTimeService.isReferenceTimeInformationCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_getCurrentTime_000001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);

        assertNull(currentTimeService.getCurrentTime());
    }

    @Test
    @RequiresDevice
    public void test_getCurrentTime_000002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(currentTimeService.getCurrentTime());
    }

    @Test
    @RequiresDevice
    public void test_getCurrentTime_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = currentTimeService.getCurrentTime();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setCurrentTime_000001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        CurrentTime currentTime = new CurrentTime(0, 1, 2, 3, 4, 5, 6, 7, 8);

        assertNull(currentTimeService.setCurrentTime(currentTime));
    }

    @Test
    @RequiresDevice
    public void test_setCurrentTime_000002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        CurrentTime currentTime = new CurrentTime(0, 1, 2, 3, 4, 5, 6, 7, 8);

        assertNull(currentTimeService.setCurrentTime(currentTime));
    }

    @Test
    @RequiresDevice
    public void test_setCurrentTime_000003() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isCurrentTimeCharacteristicWritable() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        CurrentTime currentTime = new CurrentTime(0, 1, 2, 3, 4, 5, 6, 7, 8);

        assertNull(currentTimeService.setCurrentTime(currentTime));
    }

    @Test
    @RequiresDevice
    public void test_setCurrentTime_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isCurrentTimeCharacteristicWritable() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        CurrentTime currentTime = new CurrentTime(0, 1, 2, 3, 4, 5, 6, 7, 8);

        Integer taskId = currentTimeService.setCurrentTime(currentTime);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getCurrentTimeClientCharacteristicConfiguration_000001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);

        assertNull(currentTimeService.getCurrentTimeClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getCurrentTimeClientCharacteristicConfiguration_000002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(currentTimeService.getCurrentTimeClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getCurrentTimeClientCharacteristicConfiguration_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = currentTimeService.getCurrentTimeClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_startCurrentTimeNotification_000001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);

        assertNull(currentTimeService.startCurrentTimeNotification());
    }

    @Test
    @RequiresDevice
    public void test_startCurrentTimeNotification_000002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(currentTimeService.startCurrentTimeNotification());
    }

    @Test
    @RequiresDevice
    public void test_startCurrentTimeNotification_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = currentTimeService.startCurrentTimeNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_stopCurrentTimeNotification_000001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);

        assertNull(currentTimeService.stopCurrentTimeNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopCurrentTimeNotification_000002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(currentTimeService.stopCurrentTimeNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopCurrentTimeNotification_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = currentTimeService.stopCurrentTimeNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getLocalTimeInformation_000001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);

        assertNull(currentTimeService.getLocalTimeInformation());
    }

    @Test
    @RequiresDevice
    public void test_getLocalTimeInformation_000002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(currentTimeService.getLocalTimeInformation());
    }

    @Test
    @RequiresDevice
    public void test_getLocalTimeInformation_000003() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isLocalTimeInformationCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(currentTimeService.getLocalTimeInformation());
    }

    @Test
    @RequiresDevice
    public void test_getLocalTimeInformation_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isLocalTimeInformationCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = currentTimeService.getLocalTimeInformation();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_setLocalTimeInformation_000001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);
        LocalTimeInformation localTimeInformation = new LocalTimeInformation(TimeZoneUtils.TIME_ZONE_IS_NOT_KNOWN, 1);

        assertNull(currentTimeService.setLocalTimeInformation(localTimeInformation));
    }

    @Test
    @RequiresDevice
    public void test_setLocalTimeInformation_000002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        LocalTimeInformation localTimeInformation = new LocalTimeInformation(TimeZoneUtils.TIME_ZONE_IS_NOT_KNOWN, 1);

        assertNull(currentTimeService.setLocalTimeInformation(localTimeInformation));
    }

    @Test
    @RequiresDevice
    public void test_setLocalTimeInformation_000003() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isLocalTimeInformationCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        LocalTimeInformation localTimeInformation = new LocalTimeInformation(TimeZoneUtils.TIME_ZONE_IS_NOT_KNOWN, 1);

        assertNull(currentTimeService.setLocalTimeInformation(localTimeInformation));
    }

    @Test
    @RequiresDevice
    public void test_setLocalTimeInformation_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isLocalTimeInformationCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        LocalTimeInformation localTimeInformation = new LocalTimeInformation(TimeZoneUtils.TIME_ZONE_IS_NOT_KNOWN, 1);

        Integer taskId = currentTimeService.setLocalTimeInformation(localTimeInformation);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    @RequiresDevice
    public void test_getReferenceTimeInformation_000001() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null);

        assertNull(currentTimeService.getReferenceTimeInformation());
    }

    @Test
    @RequiresDevice
    public void test_getReferenceTimeInformation_000002() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(currentTimeService.getReferenceTimeInformation());
    }

    @Test
    @RequiresDevice
    public void test_getReferenceTimeInformation_000003() {
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isReferenceTimeInformationCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(currentTimeService.getReferenceTimeInformation());
    }

    @Test
    @RequiresDevice
    public void test_getReferenceTimeInformation_000004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        CurrentTimeService currentTimeService = new CurrentTimeService(MOCK_BLE_CONNECTION, new MockCurrentTimeServiceCallback(), null) {

            @Override
            public boolean isReferenceTimeInformationCharacteristicSupported() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = currentTimeService.getReferenceTimeInformation();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

}
