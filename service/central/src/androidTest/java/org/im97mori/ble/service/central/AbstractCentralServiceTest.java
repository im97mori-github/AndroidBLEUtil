package org.im97mori.ble.service.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AbstractCentralServiceTest extends AbstractCentralTest {

    static class TestCentralService extends AbstractCentralService {

        public TestCentralService(@NonNull BLEConnection bleConnection, @Nullable BLECallback bleCallback) {
            super(bleConnection, bleCallback);
        }
    }

    @Test
    @RequiresDevice
    public void test_isStarted_00001() {
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, null);

        assertFalse(testCentralService.isStarted());
    }

    @Test
    @RequiresDevice
    public void test_isStarted_00002() {
        MOCK_BLE_CONNECTION.setConnected(true);
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, null);

        assertFalse(testCentralService.isStarted());
    }

    @Test
    @RequiresDevice
    public void test_isStarted_00003() {
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, null);
        testCentralService.onDiscoverServiceSuccess(0, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(testCentralService.isStarted());
    }

    @Test
    @RequiresDevice
    public void test_isStarted_00004() {
        MOCK_BLE_CONNECTION.setConnected(true);
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, null);
        testCentralService.onDiscoverServiceSuccess(0, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertTrue(testCentralService.isStarted());
    }

    @Test
    @RequiresDevice
    public void test_start_00001() {
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, null);

        assertNotNull(testCentralService.start());
    }

    @Test
    @RequiresDevice
    public void test_start_00002() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setConnected(true);
        MOCK_BLE_CONNECTION.setCreateDiscoverServiceTaskId(originalTaskId);
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, null);

        assertEquals(originalTaskId, testCentralService.start());
    }

    @Test
    @RequiresDevice
    public void test_start_00003() {
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, null);
        testCentralService.onDiscoverServiceSuccess(0, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertNotNull(testCentralService.start());
    }

    @Test
    @RequiresDevice
    public void test_start_00004() {
        MOCK_BLE_CONNECTION.setConnected(true);
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, null);
        testCentralService.onDiscoverServiceSuccess(0, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertNull(testCentralService.start());
    }

    @Test
    @RequiresDevice
    public void test_quit_00001() {
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, null);

        assertNull(testCentralService.quit());
    }

    @Test
    @RequiresDevice
    public void test_quit_00002() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setQuitTaskId(originalTaskId);
        MOCK_BLE_CONNECTION.setConnected(true);
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, null);

        assertEquals(originalTaskId, testCentralService.quit());
    }

    @Test
    @RequiresDevice
    public void test_onBLEConnected_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {
            @Override
            public void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }
        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onBLEConnected(originalTaskId, originalBluetoothDevice, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onBLEConnected_00002() {
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, null);

        testCentralService.onBLEConnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, null);
        assertTrue(MOCK_BLE_CONNECTION.isCreateDiscoverServiceTaskPassed());
    }

    @Test
    @RequiresDevice
    public void test_onBLEConnectFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final int originalStatus = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onBLEConnectFailed(originalTaskId, originalBluetoothDevice, originalStatus, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onBLEConnectTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onBLEConnectTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onBLEConnectTimeout(originalTaskId, originalBluetoothDevice, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final int originalStatus = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onBLEDisconnected(originalTaskId, originalBluetoothDevice, originalStatus, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00002() {
        MockBLECallback bleCallback = new MockBLECallback();
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);
        testCentralService.mAvailableCharacteristicSet.add(UUID.randomUUID());
        testCentralService.mIsServiceDiscovered = true;

        testCentralService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 2, null);
        assertTrue(testCentralService.mAvailableCharacteristicSet.isEmpty());
        assertFalse(testCentralService.mIsServiceDiscovered);
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00003() {
        MockBLECallback bleCallback = new MockBLECallback();
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);
        testCentralService.mAvailableCharacteristicSet.add(UUID.randomUUID());
        testCentralService.mIsServiceDiscovered = true;

        testCentralService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_1, 2, null);
        assertFalse(testCentralService.mAvailableCharacteristicSet.isEmpty());
        assertTrue(testCentralService.mIsServiceDiscovered);
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final List<BluetoothGattService> originalServiceList = Collections.emptyList();
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceList, serviceList);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onDiscoverServiceSuccess(originalTaskId, originalBluetoothDevice, originalServiceList, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00002() {
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, null);
        testCentralService.mIsServiceDiscovered = false;

        testCentralService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);
        assertTrue(testCentralService.mIsServiceDiscovered);
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00003() {
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, null);
        testCentralService.mIsServiceDiscovered = false;

        testCentralService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_1, Collections.emptyList(), null);
        assertFalse(testCentralService.mIsServiceDiscovered);
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final int originalStatus = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onDiscoverServiceFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onDiscoverServiceFailed(originalTaskId, originalBluetoothDevice, originalStatus, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final long originalTimeout = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onDiscoverServiceTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onDiscoverServiceTimeout(originalTaskId, originalBluetoothDevice, originalTimeout, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onRequestMtuSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final int originalMtu = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onRequestMtuSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int mtu, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalMtu, mtu);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onRequestMtuSuccess(originalTaskId, originalBluetoothDevice, originalMtu, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onRequestMtuFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final int originalStatus = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onRequestMtuFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onRequestMtuFailed(originalTaskId, originalBluetoothDevice, originalStatus, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onRequestMtuTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final long originalTimeout = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onRequestMtuTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onRequestMtuTimeout(originalTaskId, originalBluetoothDevice, 2, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = UUID.randomUUID();
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharactersticUUID = UUID.randomUUID();
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharactersticUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, values);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharactersticUUID, originalCharacteristicInstanceId, originalValues, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = UUID.randomUUID();
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharactersticUUID = UUID.randomUUID();
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertNotNull(serviceInstanceId);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharactersticUUID, characteristicUUID);
                assertNotNull(characteristicInstanceId);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharactersticUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = UUID.randomUUID();
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharactersticUUID = UUID.randomUUID();
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertNotNull(serviceInstanceId);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharactersticUUID, characteristicUUID);
                assertNotNull(characteristicInstanceId);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharactersticUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = UUID.randomUUID();
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharactersticUUID = UUID.randomUUID();
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[]{4};
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharactersticUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, values);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharactersticUUID, originalCharacteristicInstanceId, originalValues, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = UUID.randomUUID();
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharactersticUUID = UUID.randomUUID();
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertNotNull(serviceInstanceId);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharactersticUUID, characteristicUUID);
                assertNotNull(characteristicInstanceId);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharactersticUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = UUID.randomUUID();
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharactersticUUID = UUID.randomUUID();
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertNotNull(serviceInstanceId);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharactersticUUID, characteristicUUID);
                assertNotNull(characteristicInstanceId);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharactersticUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = UUID.randomUUID();
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharactersticUUID = UUID.randomUUID();
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = UUID.randomUUID();
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharactersticUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorUUID, descriptorUUID);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, values);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharactersticUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = UUID.randomUUID();
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharactersticUUID = UUID.randomUUID();
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = UUID.randomUUID();
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharactersticUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorUUID, descriptorUUID);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharactersticUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = UUID.randomUUID();
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharactersticUUID = UUID.randomUUID();
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = UUID.randomUUID();
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharactersticUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorUUID, descriptorUUID);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharactersticUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = UUID.randomUUID();
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharactersticUUID = UUID.randomUUID();
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = UUID.randomUUID();
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5};
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharactersticUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorUUID, descriptorUUID);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, values);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharactersticUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = UUID.randomUUID();
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharactersticUUID = UUID.randomUUID();
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = UUID.randomUUID();
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharactersticUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorUUID, descriptorUUID);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharactersticUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = UUID.randomUUID();
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharactersticUUID = UUID.randomUUID();
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = UUID.randomUUID();
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharactersticUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorUUID, descriptorUUID);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharactersticUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = UUID.randomUUID();
        final Integer originalServiceInstanceId = 1;
        final UUID originalCharactersticUUID = UUID.randomUUID();
        final Integer originalCharacteristicInstanceId = 2;
        final byte[] originalValues = new byte[]{3};
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharactersticUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, values);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharactersticUUID, originalCharacteristicInstanceId, originalValues);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onReadPhySuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final int originalTxPhy = 2;
        final int originalRxPhy = 3;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onReadPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalTxPhy, txPhy);
                assertEquals(originalRxPhy, rxPhy);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onReadPhySuccess(originalTaskId, originalBluetoothDevice, originalTxPhy, originalRxPhy, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onReadPhyFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final int originalStatus = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onReadPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onReadPhyFailed(originalTaskId, originalBluetoothDevice, originalStatus, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onReadPhyTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final long originalTimeout = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onReadPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onReadPhyTimeout(originalTaskId, originalBluetoothDevice, originalTimeout, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onSetPreferredPhySuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final int originalTxPhy = 2;
        final int originalRxPhy = 3;
        final int originalPhyOptions = 4;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onSetPreferredPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, int phyOptions, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalTxPhy, txPhy);
                assertEquals(originalRxPhy, rxPhy);
                assertEquals(originalPhyOptions, phyOptions);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onSetPreferredPhySuccess(originalTaskId, originalBluetoothDevice, originalTxPhy, originalRxPhy, originalPhyOptions, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onSetPreferredPhyFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final int originalStatus = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onSetPreferredPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onSetPreferredPhyFailed(originalTaskId, originalBluetoothDevice, originalStatus, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onSetPreferredPhyTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final long originalTimeout = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onSetPreferredPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onSetPreferredPhyTimeout(originalTaskId, originalBluetoothDevice, originalTimeout, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onReadRemoteRssiSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final int originalRssi = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onReadRemoteRssiSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int rssi, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalRssi, rssi);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onReadRemoteRssiSuccess(originalTaskId, originalBluetoothDevice, originalRssi, originalBundle);
        assertTrue(isCalled.get());
    }


    @Test
    @RequiresDevice
    public void test_onReadRemoteRssiFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final int originalStatus = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onReadRemoteRssiFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onReadRemoteRssiFailed(originalTaskId, originalBluetoothDevice, originalStatus, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onReadRemoteRssiTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final long originalTimeout = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onReadRemoteRssiTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onReadRemoteRssiTimeout(originalTaskId, originalBluetoothDevice, originalTimeout, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onBeginReliableWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onBeginReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onBeginReliableWriteSuccess(originalTaskId, originalBluetoothDevice, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onBeginReliableWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final int originalStatus = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onBeginReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onBeginReliableWriteFailed(originalTaskId, originalBluetoothDevice, originalStatus, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onExecuteReliableWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onExecuteReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onExecuteReliableWriteSuccess(originalTaskId, originalBluetoothDevice, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onExecuteReliableWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final int originalStatus = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onExecuteReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onExecuteReliableWriteFailed(originalTaskId, originalBluetoothDevice, originalStatus, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onExecuteReliableWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final long originalTimeout = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onExecuteReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onExecuteReliableWriteTimeout(originalTaskId, originalBluetoothDevice, originalTimeout, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onAbortReliableWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onAbortReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onAbortReliableWriteSuccess(originalTaskId, originalBluetoothDevice, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onAbortReliableWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final int originalStatus = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onAbortReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onAbortReliableWriteFailed(originalTaskId, originalBluetoothDevice, originalStatus, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onAbortReliableWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final int originalTimeout = 2;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onAbortReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onAbortReliableWriteTimeout(originalTaskId, originalBluetoothDevice, originalTimeout, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onSetNotificationSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = UUID.randomUUID();
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharactersticUUID = UUID.randomUUID();
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onSetNotificationSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, boolean notificationStatus, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharactersticUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalNotificationStatus, notificationStatus);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onSetNotificationSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharactersticUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalBundle);
        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onSetNotificationFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = UUID.randomUUID();
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharactersticUUID = UUID.randomUUID();
        final Integer originalCharacteristicInstanceId = 3;
        final boolean originalNotificationStatus = true;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLECallback bleCallback = new MockBLECallback() {

            @Override
            public void onSetNotificationFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, boolean notificationStatus, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharactersticUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalNotificationStatus, notificationStatus);
                assertEquals(originalBundle, argument);
                assertEquals(originalStatus, status);
                isCalled.set(true);
            }

        };
        TestCentralService testCentralService = new TestCentralService(MOCK_BLE_CONNECTION, bleCallback);

        testCentralService.onSetNotificationFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharactersticUUID, originalCharacteristicInstanceId, originalNotificationStatus, originalStatus, originalBundle);
        assertTrue(isCalled.get());
    }

}
