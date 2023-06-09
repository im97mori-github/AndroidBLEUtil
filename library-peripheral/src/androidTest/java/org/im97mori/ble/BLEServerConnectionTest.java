package org.im97mori.ble;

import android.Manifest;
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
import androidx.test.filters.RequiresDevice;
import androidx.test.rule.GrantPermissionRule;

import org.im97mori.ble.task.AbstractBLETask;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.peripheral.AbstractPeripheralTest;
import org.junit.Rule;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"ConstantConditions", "BusyWait"})
public class BLEServerConnectionTest extends AbstractPeripheralTest {

    @Rule
    public GrantPermissionRule mRuntimePermissionRule = GrantPermissionRule
            .grant(Manifest.permission.BLUETOOTH_ADVERTISE, android.Manifest.permission.BLUETOOTH_CONNECT);

    private static final long SLEEP_DURATION = 50;

    private static abstract class MockBLETask extends AbstractBLETask {

        final AtomicBoolean isProcessing = new AtomicBoolean(true);

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

    private void check(BaseBLEServerCallback firstCallback, BaseBLEServerCallback secondCallback, MockBLETask task, boolean secondResult) {

        try {
            MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
            MOCK_BLE_SERVER_CONNECTION.attach(secondCallback);

            MOCK_BLE_SERVER_CONNECTION.addTask(task);

            while (task.isProcessing.get()) {
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
    @RequiresDevice
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
    @RequiresDevice
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
    @RequiresDevice
    public void test_onConnectionStateChange_001() {
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onDeviceConnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {
                assertEquals(MOCK_BLE_SERVER_CONNECTION, bleServerConnection);
                result.set(true);
            }

        };
        MOCK_BLE_SERVER_CONNECTION.start();
        MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
        MOCK_BLE_SERVER_CONNECTION.onConnectionStateChange(BLETestUtilsAndroid.MOCK_DEVICE_0, 0, BluetoothProfile.STATE_CONNECTED);
        assertTrue(firstCallback.result.get());
    }

    @Test
    @RequiresDevice
    public void test_onConnectionStateChange_002() {
        BaseBLEServerCallback firstCallback = new BaseBLEServerCallback() {

            @Override
            public void onDeviceDisconnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {
                assertEquals(MOCK_BLE_SERVER_CONNECTION, bleServerConnection);
                result.set(true);
            }

        };
        MOCK_BLE_SERVER_CONNECTION.start();
        MOCK_BLE_SERVER_CONNECTION.attach(firstCallback);
        MOCK_BLE_SERVER_CONNECTION.onConnectionStateChange(BLETestUtilsAndroid.MOCK_DEVICE_0, 0, BluetoothProfile.STATE_DISCONNECTED);
        assertTrue(firstCallback.result.get());
    }

    @Test
    @RequiresDevice
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

        final Bundle argument = BLEServerCallbackDistributor.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {

            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onServiceAddSuccess(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, argument);
                isProcessing.set(false);
                return true;
            }

        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    @RequiresDevice
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

        final Bundle argument = BLEServerCallbackDistributor.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onServiceAddSuccess(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, argument);
                isProcessing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    @RequiresDevice
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

        final Bundle argument = BLEServerCallbackDistributor.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {

            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onServiceAddFailed(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, 0, argument);
                isProcessing.set(false);
                return true;
            }

        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    @RequiresDevice
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

        final Bundle argument = BLEServerCallbackDistributor.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onServiceAddFailed(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, 0, argument);
                isProcessing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    @RequiresDevice
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

        final Bundle argument = BLEServerCallbackDistributor.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {

            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onServiceAddTimeout(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, 0, argument);
                isProcessing.set(false);
                return true;
            }

        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    @RequiresDevice
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

        final Bundle argument = BLEServerCallbackDistributor.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onServiceAddTimeout(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, 0, argument);
                isProcessing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    @RequiresDevice
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
        MOCK_BLE_SERVER_CONNECTION.onCharacteristicReadRequest(BLETestUtilsAndroid.MOCK_DEVICE_0, 0, 0, null);
        assertTrue(firstCallback.result.get());
    }

    @Test
    @RequiresDevice
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
        MOCK_BLE_SERVER_CONNECTION.onCharacteristicWriteRequest(BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null, false, false, 0, null);
        assertTrue(firstCallback.result.get());
    }

    @Test
    @RequiresDevice
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
        MOCK_BLE_SERVER_CONNECTION.onDescriptorReadRequest(BLETestUtilsAndroid.MOCK_DEVICE_0, 0, 0, null);
        assertTrue(firstCallback.result.get());
    }

    @Test
    @RequiresDevice
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
        MOCK_BLE_SERVER_CONNECTION.onDescriptorWriteRequest(BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null, false, false, 0, null);
        assertTrue(firstCallback.result.get());
    }

    @Test
    @RequiresDevice
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
        MOCK_BLE_SERVER_CONNECTION.onExecuteWrite(BLETestUtilsAndroid.MOCK_DEVICE_0, 0, false);
        assertTrue(firstCallback.result.get());
    }

    @Test
    @RequiresDevice
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

        final Bundle argument = BLEServerCallbackDistributor.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {

            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onNotificationSuccess(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, null, 0, null, 1, null, argument);
                isProcessing.set(false);
                return true;
            }

        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    @RequiresDevice
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

        final Bundle argument = BLEServerCallbackDistributor.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onNotificationSuccess(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, null, 0, null, 1, null, argument);
                isProcessing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    @RequiresDevice
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

        final Bundle argument = BLEServerCallbackDistributor.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {

            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onNotificationFailed(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, null, 0, null, 1, 0, argument);
                isProcessing.set(false);
                return true;
            }

        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    @RequiresDevice
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

        final Bundle argument = BLEServerCallbackDistributor.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onNotificationFailed(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, null, 0, null, 1, 0, argument);
                isProcessing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    @RequiresDevice
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

        final Bundle argument = BLEServerCallbackDistributor.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {

            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onNotificationTimeout(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, null, 0, null, 1, 0, argument);
                isProcessing.set(false);
                return true;
            }

        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    @RequiresDevice
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

        final Bundle argument = BLEServerCallbackDistributor.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_SERVER_CONNECTION.getBLEServerCallback().onNotificationTimeout(getTaskId(), MOCK_BLE_SERVER_CONNECTION, null, null, 0, null, 1, 0, argument);
                isProcessing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    @RequiresDevice
    public void test_startAdvertising_001() {
        MOCK_BLE_SERVER_CONNECTION.setStartAdvertisingIncludeDeviceName(true);
        MOCK_BLE_SERVER_CONNECTION.setStartAdvertisingIncludeUUID(false);
        MOCK_BLE_SERVER_CONNECTION.setStartAdvertisingServiceUUID(null);

        MOCK_BLE_SERVER_CONNECTION.startAdvertising();
        assertFalse(MOCK_BLE_SERVER_CONNECTION.getStartAdvertisingIncludeDeviceName());
        assertTrue(MOCK_BLE_SERVER_CONNECTION.getStartAdvertisingIncludeUUID());
        assertNull(MOCK_BLE_SERVER_CONNECTION.getStartAdvertisingServiceUUID());
    }

    @Test
    @RequiresDevice
    public void test_startAdvertising_002() {
        UUID firstUUID = new UUID(0, 0);
        UUID secondUUID = new UUID(0, 1);
        MOCK_BLE_SERVER_CONNECTION.setStartAdvertisingIncludeDeviceName(true);
        MOCK_BLE_SERVER_CONNECTION.setStartAdvertisingIncludeUUID(false);
        MOCK_BLE_SERVER_CONNECTION.setStartAdvertisingServiceUUID(firstUUID);

        MOCK_BLE_SERVER_CONNECTION.startAdvertising(false, secondUUID);
        assertFalse(MOCK_BLE_SERVER_CONNECTION.getStartAdvertisingIncludeDeviceName());
        assertTrue(MOCK_BLE_SERVER_CONNECTION.getStartAdvertisingIncludeUUID());
        assertEquals(secondUUID, MOCK_BLE_SERVER_CONNECTION.getStartAdvertisingServiceUUID());
    }

    @Test
    @RequiresDevice
    public void test_startAdvertising_003() {
        UUID firstUUID = new UUID(0, 0);
        UUID secondUUID = new UUID(0, 1);
        MOCK_BLE_SERVER_CONNECTION.setStartAdvertisingIncludeDeviceName(true);
        MOCK_BLE_SERVER_CONNECTION.setStartAdvertisingIncludeUUID(true);
        MOCK_BLE_SERVER_CONNECTION.setStartAdvertisingServiceUUID(firstUUID);

        MOCK_BLE_SERVER_CONNECTION.startAdvertising(false, false, secondUUID);
        assertFalse(MOCK_BLE_SERVER_CONNECTION.getStartAdvertisingIncludeDeviceName());
        assertFalse(MOCK_BLE_SERVER_CONNECTION.getStartAdvertisingIncludeUUID());
        assertEquals(secondUUID, MOCK_BLE_SERVER_CONNECTION.getStartAdvertisingServiceUUID());
    }

    @Test
    @RequiresDevice
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
    @RequiresDevice
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
    @RequiresDevice
    public void test_startAdvertising_failed_002() {
        MOCK_BLE_SERVER_CONNECTION.start();
        assertTrue(MOCK_BLE_SERVER_CONNECTION.startAdvertising());
        assertFalse(MOCK_BLE_SERVER_CONNECTION.startAdvertising());
    }

    @Test
    @RequiresDevice
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
