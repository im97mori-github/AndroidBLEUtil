package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.task.AbstractBLETask;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BLEConnectionTest {

    private static final long SLEEP_DURATION = 50;
    private static final UUID MOCK_UUID = UUID.randomUUID();

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

    private static MockBLEConnection MOCK_BLE_CONNECTION = new MockBLEConnection();

    @AfterClass
    public static void tearDown() {
        MOCK_BLE_CONNECTION.quit();
    }

    private void check(BaseBLECallback firstCallback, BaseBLECallback secondCallback, MockBLETask task, boolean secondResult) {

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

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
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void connectSuccessTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnected(getTaskId(), MockBLEConnection.MOCK_DEVICE, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void connectSuccessTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnected(getTaskId(), MockBLEConnection.MOCK_DEVICE, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void connectFailedTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnectFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void connectFailedTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnectFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };


        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void connectTimeoutTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnectTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void connectTimeoutTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnectTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void disconnectedTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEDisconnected(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void disconnectedTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEDisconnected(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void readCharacteristicTaskSuccessTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, new byte[0], argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void readCharacteristicTaskSuccessTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, new byte[0], argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void readCharacteristicTaskFailedTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void readCharacteristicTaskFailedTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void readCharacteristicTaskTimeoutTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void readCharacteristicTaskTimeoutTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void writeCharacteristicTaskSuccessTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, new byte[0], argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void writeCharacteristicTaskSuccessTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, new byte[0], argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void writeCharacteristicTaskFailedTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void writeCharacteristicTaskFailedTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void writeCharacteristicTaskTimeoutTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void writeCharacteristicTaskTimeoutTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void discoverServiceSuccessTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDiscoverServiceSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, new ArrayList<BluetoothGattService>(), argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void discoverServiceSuccessTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDiscoverServiceSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, new ArrayList<BluetoothGattService>(), argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void discoverServiceFailedTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDiscoverServiceFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDiscoverServiceFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDiscoverServiceFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void discoverServiceFailedTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDiscoverServiceFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDiscoverServiceFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDiscoverServiceFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void discoverServiceTimeoutTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDiscoverServiceTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDiscoverServiceTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDiscoverServiceTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void discoverServiceTimeoutTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDiscoverServiceTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDiscoverServiceTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDiscoverServiceTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void notifyCharacteristicTaskSuccessTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values) {
                result.set(true);
            }
        };
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicNotified(MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, new byte[0]);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }


    @Test
    public void readDescriptorTaskSuccessTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, new byte[0], argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void readDescriptorTaskSuccessTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, new byte[0], argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void readDescriptorTaskFailedTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void readDescriptorTaskFailedTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void readDescriptorTaskTimeoutTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void readDescriptorTaskTimeoutTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void writeDescriptorTaskSuccessTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, new byte[0], argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void writeDescriptorTaskSuccessTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, new byte[0], argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void writeDescriptorTaskFailedTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void writeDescriptorTaskFailedTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void writeDescriptorTaskTimeoutTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void writeDescriptorTaskTimeoutTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {
                result.set(true);
            }
        };
        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void notifyTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values) {
                result.set(true);
            }
        };

        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicNotified(MockBLEConnection.MOCK_DEVICE, MOCK_UUID, MOCK_UUID, new byte[0]);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void requestMtuSuccessTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onRequestMtuSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int mtu, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onRequestMtuSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int mtu, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onRequestMtuSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void requestMtuSuccessTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onRequestMtuSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int mtu, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onRequestMtuSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int mtu, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onRequestMtuSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void requestMtuFailedTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onRequestMtuFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onRequestMtuFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onRequestMtuFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void requestMtuFailedTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onRequestMtuFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onRequestMtuFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onRequestMtuFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void requestMtuTimeoutTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onRequestMtuTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onRequestMtuTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onRequestMtuTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void requestMtuTimeoutTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onRequestMtuTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onRequestMtuTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onRequestMtuTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void readPhySuccessTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onReadPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onReadPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onReadPhySuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void readPhySuccessTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onReadPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onReadPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onReadPhySuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void readPhyFailedTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onReadPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onReadPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onReadPhyFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void readPhyFailedTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onReadPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onReadPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onReadPhyFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void readPhyTimeoutTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onReadPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onReadPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onReadPhyTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void readPhyTimeoutTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onReadPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onReadPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onReadPhyTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void setPreferredPhySuccessTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onSetPreferredPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, int phyOptions, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onSetPreferredPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, int phyOptions, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onSetPreferredPhySuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, 0, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void setPreferredPhySuccessTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onSetPreferredPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, int phyOptions, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onSetPreferredPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, int phyOptions, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onSetPreferredPhySuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, 0, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void setPreferredPhyFailedTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onSetPreferredPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onSetPreferredPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onSetPreferredPhyFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void setPreferredPhyFailedTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onSetPreferredPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onSetPreferredPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onSetPreferredPhyFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void setPreferredTimeoutTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onSetPreferredPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onSetPreferredPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onSetPreferredPhyTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void setPreferredTimeoutTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onSetPreferredPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onSetPreferredPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onSetPreferredPhyTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void readRemoteRssiSuccessTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onReadRemoteRssiSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int rssi, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onReadRemoteRssiSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int rssi, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onReadRemoteRssiSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void readRemoteRssiSuccessTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onReadRemoteRssiSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int rssi, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onReadRemoteRssiSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int rssi, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onReadRemoteRssiSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void readRemoteRssiFailedTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onReadRemoteRssiFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onReadRemoteRssiFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onReadRemoteRssiFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void readRemoteRssiFailedTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onReadRemoteRssiFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onReadRemoteRssiFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onReadRemoteRssiFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void readRemoteRssiTimeoutTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onReadRemoteRssiTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onReadRemoteRssiTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onReadRemoteRssiTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void readRemoteRssiTimeoutTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onReadRemoteRssiTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onReadRemoteRssiTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onReadRemoteRssiTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void beginReliableWriteSuccessTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBeginReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBeginReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBeginReliableWriteSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void beginReliableWriteSuccessTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBeginReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBeginReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBeginReliableWriteSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void beginReliableWriteFailedTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBeginReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBeginReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBeginReliableWriteFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void beginReliableWriteFailedTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBeginReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBeginReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBeginReliableWriteFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void executeReliableWriteSuccessTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onExecuteReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onExecuteReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onExecuteReliableWriteSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void executeReliableWriteSuccessTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onExecuteReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onExecuteReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onExecuteReliableWriteSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void executeReliableWriteFailedTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onExecuteReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onExecuteReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onExecuteReliableWriteFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void executeReliableWriteFailedTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onExecuteReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onExecuteReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onExecuteReliableWriteFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void executeReliableWriteTimeoutTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onExecuteReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onExecuteReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onExecuteReliableWriteTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void executeReliableWriteTimeoutTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onExecuteReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onExecuteReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onExecuteReliableWriteTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void abortReliableWriteSuccessTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onAbortReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onAbortReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onAbortReliableWriteSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void abortReliableWriteSuccessTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onAbortReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onAbortReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onAbortReliableWriteSuccess(getTaskId(), MockBLEConnection.MOCK_DEVICE, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void abortReliableWriteFailedTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onAbortReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onAbortReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onAbortReliableWriteFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void abortReliableWriteFailedTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onAbortReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onAbortReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onAbortReliableWriteFailed(getTaskId(), MockBLEConnection.MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

    @Test
    public void abortReliableWriteTimeoutTest_001() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onAbortReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onAbortReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onAbortReliableWriteTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, true);
    }

    @Test
    public void abortReliableWriteTimeoutTest_002() {
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onAbortReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onAbortReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument) {
                result.set(true);
            }
        };

        final Bundle argument = BLECallbackDistributer.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onAbortReliableWriteTimeout(getTaskId(), MockBLEConnection.MOCK_DEVICE, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        check(firstCallback, secondCallback, task, false);
    }

}
