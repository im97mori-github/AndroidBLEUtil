package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.task.AbstractBLETask;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class BLEServerConnectionTest {

    private static final long SLEEP_DURATION = 50;

    private static abstract class MockBLETask extends AbstractBLETask {

        AtomicBoolean isProccesing = new AtomicBoolean(true);

        @NonNull
        @Override
        public Message createInitialMessage() {
            return new Message();
        }

        @Override
        public boolean isBusy() {
            return false;
        }

        @Override
        public void cancel() {

        }
    }

    private MockBLEServerConnection MOCK_BLE_SERVER_CONNECTION;

    @Before
    public void setup() {
        MOCK_BLE_SERVER_CONNECTION = new MockBLEServerConnection();
    }

    @After
    public void tearDown() {
        if (MOCK_BLE_SERVER_CONNECTION != null) {
            MOCK_BLE_SERVER_CONNECTION.quit();
            MOCK_BLE_SERVER_CONNECTION = null;
        }
    }

    private void check(BaseBLEServerCallback firstCallback, BaseBLEServerCallback secondCallback, MockBLETask task, boolean secondResult) {

        try {
            MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
            MOCK_BLE_SERVER_CONNECTION.attach(secondCallback);

            MOCK_BLE_SERVER_CONNECTION.addTask(task);

            while (task.isProccesing.get()) {
                try {
                    Thread.sleep(SLEEP_DURATION);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstCallback.result.get());
            assertEquals(secondResult, secondCallback.result.get());
        } finally {
            MOCK_BLE_SERVER_CONNECTION.detach(firstCallback);
            MOCK_BLE_SERVER_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void test_start_001() {
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onServerStarted() {
                result.set(true);
            }

        };
        BaseBLEServerCallback secondCallback = new BaseBLEServerCallback() {

            @Override
            public void onServerStarted() {
                result.set(true);
            }
        };
        MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
        MOCK_BLE_SERVER_CONNECTION.attach(secondCallback);
        MOCK_BLE_SERVER_CONNECTION.start();

        assertTrue(firstCallback.result.get());
        assertTrue(secondCallback.result.get());
    }

    @Test
    public void test_quit_001() {
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onServerStopped() {
                result.set(true);
            }

        };
        BaseBLEServerCallback secondCallback = new BaseBLEServerCallback() {

            @Override
            public void onServerStopped() {
                result.set(true);
            }

        };
        MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
        MOCK_BLE_SERVER_CONNECTION.attach(secondCallback);
        MOCK_BLE_SERVER_CONNECTION.start();
        MOCK_BLE_SERVER_CONNECTION.quit();

        assertTrue(firstCallback.result.get());
        assertTrue(secondCallback.result.get());
    }

    @Test
    public void test_isAttached_001() {
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback();
        assertFalse(MOCK_BLE_SERVER_CONNECTION.isAttached(firstCallback));
        MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
        assertTrue(MOCK_BLE_SERVER_CONNECTION.isAttached(firstCallback));
        MOCK_BLE_SERVER_CONNECTION.detach(firstCallback);
        assertFalse(MOCK_BLE_SERVER_CONNECTION.isAttached(firstCallback));
    }

    @Test
    public void test_onConnectionStateChange_001() {
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onDeviceConnected(BluetoothDevice device) {
                result.set(true);
            }

        };
        MOCK_BLE_SERVER_CONNECTION.start();
        MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
        MOCK_BLE_SERVER_CONNECTION.onConnectionStateChange(MockBLEServerConnection.MOCK_DEVICE, 0, BluetoothProfile.STATE_CONNECTED);
        assertTrue(firstCallback.result.get());
    }

    @Test
    public void test_onConnectionStateChange_002() {
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onDeviceDisconnected(BluetoothDevice device) {
                result.set(true);
            }

        };
        MOCK_BLE_SERVER_CONNECTION.start();
        MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
        MOCK_BLE_SERVER_CONNECTION.onConnectionStateChange(MockBLEServerConnection.MOCK_DEVICE, 0, BluetoothProfile.STATE_DISCONNECTED);
        assertTrue(firstCallback.result.get());
    }

    @Test
    public void test_onServiceAdded_success_001() {
        MOCK_BLE_SERVER_CONNECTION.start();
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public boolean onServiceAddSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, @Nullable Bundle argument) {
                result.set(true);
                return super.onServiceAddSuccess(taskId, bleServerConnection, bluetoothGattService, argument);
            }

        };
        BaseBLEServerCallback secondCallback = new BaseBLEServerCallback() {

            @Override
            public boolean onServiceAddSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, @Nullable Bundle argument) {
                result.set(true);
                return super.onServiceAddSuccess(taskId, bleServerConnection, bluetoothGattService, argument);
            }

        };

        final Bundle argument = BLEServerCallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {

            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onServiceAddSuccess(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, argument);
                isProccesing.set(false);
                return true;
            }

        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void test_onServiceAdded_success_002() {
        MOCK_BLE_SERVER_CONNECTION.start();
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public boolean onServiceAddSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, @Nullable Bundle argument) {
                result.set(true);
                return super.onServiceAddSuccess(taskId, bleServerConnection, bluetoothGattService, argument);
            }

        };
        BaseBLEServerCallback secondCallback = new BaseBLEServerCallback() {

            @Override
            public boolean onServiceAddSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, @Nullable Bundle argument) {
                result.set(true);
                return super.onServiceAddSuccess(taskId, bleServerConnection, bluetoothGattService, argument);
            }

        };

        final Bundle argument = BLEServerCallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onServiceAddSuccess(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void test_onServiceAdded_failed_001() {
        MOCK_BLE_SERVER_CONNECTION.start();
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {
                result.set(true);
            }

        };
        BaseBLEServerCallback secondCallback = new BaseBLEServerCallback() {

            @Override
            public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {
                result.set(true);
            }

        };

        final Bundle argument = BLEServerCallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {

            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onServiceAddFailed(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, 0, argument);
                isProccesing.set(false);
                return true;
            }

        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void test_onServiceAdded_failed_002() {
        MOCK_BLE_SERVER_CONNECTION.start();
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {
                result.set(true);
            }

        };
        BaseBLEServerCallback secondCallback = new BaseBLEServerCallback() {

            @Override
            public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {
                result.set(true);
            }

        };

        final Bundle argument = BLEServerCallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onServiceAddFailed(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void test_onServiceAdded_timeout_001() {
        MOCK_BLE_SERVER_CONNECTION.start();
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }

        };
        BaseBLEServerCallback secondCallback = new BaseBLEServerCallback() {

            @Override
            public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }

        };

        final Bundle argument = BLEServerCallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {

            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onServiceAddTimeout(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, 0, argument);
                isProccesing.set(false);
                return true;
            }

        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void test_onServiceAdded_timeout_002() {
        MOCK_BLE_SERVER_CONNECTION.start();
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }

        };
        BaseBLEServerCallback secondCallback = new BaseBLEServerCallback() {

            @Override
            public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }

        };

        final Bundle argument = BLEServerCallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onServiceAddTimeout(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void test_onCharacteristicReadRequest_001() {
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public boolean onCharacteristicReadRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean force) {
                result.set(true);
                return super.onCharacteristicReadRequest(bleServerConnection, device, requestId, offset, bluetoothGattCharacteristic, force);
            }

        };
        MOCK_BLE_SERVER_CONNECTION.start();
        MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
        MOCK_BLE_SERVER_CONNECTION.onCharacteristicReadRequest(MockBLEServerConnection.MOCK_DEVICE, 0, 0, null);
        assertTrue(firstCallback.result.get());
    }

    @Test
    public void test_onCharacteristicWriteRequest_001() {
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public boolean onCharacteristicWriteRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value, boolean force) {
                result.set(true);
                return super.onCharacteristicWriteRequest(bleServerConnection, device, requestId, bluetoothGattCharacteristic, preparedWrite, responseNeeded, offset, value, force);
            }

        };
        MOCK_BLE_SERVER_CONNECTION.start();
        MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
        MOCK_BLE_SERVER_CONNECTION.onCharacteristicWriteRequest(MockBLEServerConnection.MOCK_DEVICE, 0, null, false, false, 0, null);
        assertTrue(firstCallback.result.get());
    }

    @Test
    public void test_onDescriptorReadRequest_001() {
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public boolean onDescriptorReadRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattDescriptor bluetoothGattDescriptor, boolean force) {
                result.set(true);
                return super.onDescriptorReadRequest(bleServerConnection, device, requestId, offset, bluetoothGattDescriptor, force);
            }

        };
        MOCK_BLE_SERVER_CONNECTION.start();
        MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
        MOCK_BLE_SERVER_CONNECTION.onDescriptorReadRequest(MockBLEServerConnection.MOCK_DEVICE, 0, 0, null);
        assertTrue(firstCallback.result.get());
    }

    @Test
    public void test_onDescriptorWriteRequest_001() {
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public boolean onDescriptorWriteRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattDescriptor bluetoothGattDescriptor, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value, boolean force) {
                result.set(true);
                return super.onDescriptorWriteRequest(bleServerConnection, device, requestId, bluetoothGattDescriptor, preparedWrite, responseNeeded, offset, value, force);
            }

        };
        MOCK_BLE_SERVER_CONNECTION.start();
        MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
        MOCK_BLE_SERVER_CONNECTION.onDescriptorWriteRequest(MockBLEServerConnection.MOCK_DEVICE, 0, null, false, false, 0, null);
        assertTrue(firstCallback.result.get());
    }

    @Test
    public void test_onExecuteWrite_001() {
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public boolean onExecuteWrite(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, boolean execute, boolean force) {
                result.set(true);
                return super.onExecuteWrite(bleServerConnection, device, requestId, execute, force);
            }

        };
        MOCK_BLE_SERVER_CONNECTION.start();
        MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
        MOCK_BLE_SERVER_CONNECTION.onExecuteWrite(MockBLEServerConnection.MOCK_DEVICE, 0, false);
        assertTrue(firstCallback.result.get());
    }

    @Test
    public void test_onNotificationSent_success_001() {
        MOCK_BLE_SERVER_CONNECTION.start();
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onNotificationSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull byte[] value, @Nullable Bundle argument) {
                result.set(true);
            }

        };
        BaseBLEServerCallback secondCallback = new BaseBLEServerCallback() {

            @Override
            public void onNotificationSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull byte[] value, @Nullable Bundle argument) {
                result.set(true);
            }

        };

        final Bundle argument = BLEServerCallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {

            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onNotificationSuccess(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, null, 0, null, 1, null, argument);
                isProccesing.set(false);
                return true;
            }

        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void test_onNotificationSent_success_002() {
        MOCK_BLE_SERVER_CONNECTION.start();
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onNotificationSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull byte[] value, @Nullable Bundle argument) {
                result.set(true);
            }

        };
        BaseBLEServerCallback secondCallback = new BaseBLEServerCallback() {

            @Override
            public void onNotificationSuccess(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @NonNull byte[] value, @Nullable Bundle argument) {
                result.set(true);
            }

        };

        final Bundle argument = BLEServerCallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onNotificationSuccess(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, null, 0, null, 1, null, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void test_onNotificationSent_failed_001() {
        MOCK_BLE_SERVER_CONNECTION.start();
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onNotificationFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int status, @Nullable Bundle argument) {
                result.set(true);
            }

        };
        BaseBLEServerCallback secondCallback = new BaseBLEServerCallback() {

            @Override
            public void onNotificationFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int status, @Nullable Bundle argument) {
                result.set(true);
            }

        };

        final Bundle argument = BLEServerCallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {

            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onNotificationFailed(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, null, 0, null, 1, 0, argument);
                isProccesing.set(false);
                return true;
            }

        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void test_onNotificationSent_failed_002() {
        MOCK_BLE_SERVER_CONNECTION.start();
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onNotificationFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int status, @Nullable Bundle argument) {
                result.set(true);
            }

        };
        BaseBLEServerCallback secondCallback = new BaseBLEServerCallback() {

            @Override
            public void onNotificationFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int status, @Nullable Bundle argument) {
                result.set(true);
            }

        };

        final Bundle argument = BLEServerCallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onNotificationFailed(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, null, 0, null, 1, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void test_onNotificationSent_timeout_001() {
        MOCK_BLE_SERVER_CONNECTION.start();
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onNotificationTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }

        };
        BaseBLEServerCallback secondCallback = new BaseBLEServerCallback() {

            @Override
            public void onNotificationTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }

        };

        final Bundle argument = BLEServerCallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {

            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onNotificationTimeout(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, null, 0, null, 1, 0, argument);
                isProccesing.set(false);
                return true;
            }

        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void test_onNotificationSent_timeout_002() {
        MOCK_BLE_SERVER_CONNECTION.start();
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onNotificationTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }

        };
        BaseBLEServerCallback secondCallback = new BaseBLEServerCallback() {

            @Override
            public void onNotificationTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }

        };

        final Bundle argument = BLEServerCallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onNotificationTimeout(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, null, 0, null, 1, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void test_startAdvertising_001() {
        final AtomicBoolean atomicBoolean1 = new AtomicBoolean(true);
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        final AtomicReference<UUID> atomicReference = new AtomicReference<>(UUID.randomUUID());
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {

            @Override
            public synchronized boolean startAdvertising(boolean includeDeviceName, boolean includeUUID, @Nullable UUID serviceUUID) {
                atomicBoolean1.set(includeDeviceName);
                atomicBoolean2.set(includeUUID);
                atomicReference.set(serviceUUID);
                return false;
            }
        };

        mockBLEServerConnection.startAdvertising();
        assertFalse(atomicBoolean1.get());
        assertTrue(atomicBoolean2.get());
        assertNull(atomicReference.get());
    }

    @Test
    public void test_startAdvertising_002() {
        final AtomicBoolean atomicBoolean1 = new AtomicBoolean(true);
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        UUID firstUUID = UUID.randomUUID();
        UUID secondUUID = UUID.randomUUID();
        final AtomicReference<UUID> atomicReference = new AtomicReference<>(firstUUID);
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {

            @Override
            public synchronized boolean startAdvertising(boolean includeDeviceName, boolean includeUUID, @Nullable UUID serviceUUID) {
                atomicBoolean1.set(includeDeviceName);
                atomicBoolean2.set(includeUUID);
                atomicReference.set(serviceUUID);
                return false;
            }
        };

        mockBLEServerConnection.startAdvertising(false, secondUUID);
        assertFalse(atomicBoolean1.get());
        assertTrue(atomicBoolean2.get());
        assertEquals(secondUUID, atomicReference.get());
    }

    @Test
    public void test_startAdvertising_003() {
        final AtomicBoolean atomicBoolean1 = new AtomicBoolean(true);
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
        UUID firstUUID = UUID.randomUUID();
        UUID secondUUID = UUID.randomUUID();
        final AtomicReference<UUID> atomicReference = new AtomicReference<>(firstUUID);
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {

            @Override
            public synchronized boolean startAdvertising(boolean includeDeviceName, boolean includeUUID, @Nullable UUID serviceUUID) {
                atomicBoolean1.set(includeDeviceName);
                atomicBoolean2.set(includeUUID);
                atomicReference.set(serviceUUID);
                return false;
            }
        };

        mockBLEServerConnection.startAdvertising(false, false, secondUUID);
        assertFalse(atomicBoolean1.get());
        assertFalse(atomicBoolean2.get());
        assertEquals(secondUUID, atomicReference.get());
    }

    @Test
    public void test_startAdvertising_success_001() {
        MOCK_BLE_SERVER_CONNECTION.start();
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                isProccesing.set(false);
            }

        };
        MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
        MOCK_BLE_SERVER_CONNECTION.startAdvertising();
        while (firstCallback.isProccesing.get()) {
            try {
                Thread.sleep(SLEEP_DURATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assertTrue(firstCallback.result.get());
    }

    @Test
    public void test_startAdvertising_failed_001() {
        MOCK_BLE_SERVER_CONNECTION.start();
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onAdvertisingStartFailed(Integer errorCode) {
                result.set(true);
                isProccesing.set(false);
            }

        };
        MOCK_BLE_SERVER_CONNECTION.startAdvertising();
        MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
        MOCK_BLE_SERVER_CONNECTION.startAdvertising();
        while (firstCallback.isProccesing.get()) {
            try {
                Thread.sleep(SLEEP_DURATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assertTrue(firstCallback.result.get());
    }

    @Test
    public void test_startAdvertising_failed_002() {
        MOCK_BLE_SERVER_CONNECTION.start();
        assertTrue(MOCK_BLE_SERVER_CONNECTION.startAdvertising());
        assertFalse(MOCK_BLE_SERVER_CONNECTION.startAdvertising());
    }

    @Test
    public void test_stopAdvertising_success_001() {
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
                result.set(true);
                isProccesing.set(false);
            }

        };
        BaseBLEServerCallback secondCallback = new BaseBLEServerCallback() {

            @Override
            public void onAdvertisingFinished() {
                result.set(true);
                isProccesing.set(false);
            }

        };
        MOCK_BLE_SERVER_CONNECTION.start();
        MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
        MOCK_BLE_SERVER_CONNECTION.startAdvertising();
        while (firstCallback.isProccesing.get()) {
            try {
                Thread.sleep(SLEEP_DURATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        MOCK_BLE_SERVER_CONNECTION.attach(secondCallback);
        MOCK_BLE_SERVER_CONNECTION.stopAdvertising();
        while (secondCallback.isProccesing.get()) {
            try {
                Thread.sleep(SLEEP_DURATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        assertTrue(secondCallback.result.get());
    }

    @Test
    public void test_stopAdvertising_success_002() {
        assertFalse(MOCK_BLE_SERVER_CONNECTION.stopAdvertising());
    }

}
