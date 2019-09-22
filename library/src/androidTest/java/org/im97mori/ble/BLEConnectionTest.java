package org.im97mori.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.task.AbstractBLETask;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class BLEConnectionTest {

    private static final BluetoothDevice MOCK_DEVICE = BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:BB");
    private static final UUID MOCK_UUID = UUID.randomUUID();

    private static final class MockBLEConnection extends BLEConnection {
        private MockBLEConnection() {
            super(ApplicationProvider.getApplicationContext(), MOCK_DEVICE);
            this.start();
        }
    }

    private static class BaseBLECallback implements BLECallback {
        @Override
        public void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {

        }

        @Override
        public void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {

        }

        @Override
        public void onBLEConnectTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {

        }

        @Override
        public void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {

        }

        @Override
        public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {

        }

        @Override
        public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {

        }

        @Override
        public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {

        }

        @Override
        public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {

        }

        @Override
        public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {

        }

        @Override
        public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {

        }

        @Override
        public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {

        }

        @Override
        public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {

        }

        @Override
        public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {

        }

        @Override
        public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {

        }

        @Override
        public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {

        }

        @Override
        public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {

        }

        @Override
        public void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values) {

        }
    }

    private static abstract class MockBLETask extends AbstractBLETask {

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

    @Test
    public void connectSuccessTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnected(getTaskId(), MOCK_DEVICE, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertTrue(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void connectSuccessTest_002() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnected(getTaskId(), MOCK_DEVICE, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void connectFailedTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnectFailed(getTaskId(), MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertTrue(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void connectFailedTest_002() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnectFailed(getTaskId(), MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void connectTimeoutTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnectTimeout(getTaskId(), MOCK_DEVICE, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertTrue(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void connectTimeoutTest_002() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnectTimeout(getTaskId(), MOCK_DEVICE, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void disconnectedTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEDisconnected(getTaskId(), MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertTrue(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void disconnectedTest_002() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEDisconnected(getTaskId(), MOCK_DEVICE, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void readCharacteristicTaskSuccessTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadSuccess(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, new byte[0], argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void readCharacteristicTaskSuccessTest_002() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadSuccess(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, new byte[0], argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void readCharacteristicTaskFailedTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadFailed(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertTrue(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void readCharacteristicTaskFailedTest_002() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadFailed(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void readCharacteristicTaskTimeoutTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadTimeout(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertTrue(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void readCharacteristicTaskTimeoutTest_002() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadTimeout(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void writeCharacteristicTaskSuccessTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteSuccess(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, new byte[0], argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertTrue(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void writeCharacteristicTaskSuccessTest_002() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteSuccess(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, new byte[0], argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void writeCharacteristicTaskFailedTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteFailed(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertTrue(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void writeCharacteristicTaskFailedTest_002() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteFailed(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void writeCharacteristicTaskTimeoutTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteTimeout(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertTrue(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void writeCharacteristicTaskTimeoutTest_002() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteTimeout(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void notifyCharacteristicTaskSuccessTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicNotified(MOCK_DEVICE, MOCK_UUID, MOCK_UUID, new byte[0]);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertTrue(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }


    @Test
    public void readDescriptorTaskSuccessTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadSuccess(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, new byte[0], argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertTrue(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void readDescriptorTaskSuccessTest_002() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadSuccess(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, new byte[0], argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void readDescriptorTaskFailedTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadFailed(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertTrue(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void readDescriptorTaskFailedTest_002() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadFailed(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void readDescriptorTaskTimeoutTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadTimeout(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertTrue(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void readDescriptorTaskTimeoutTest_002() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadTimeout(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void writeDescriptorTaskSuccessTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteSuccess(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, new byte[0], argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertTrue(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void writeDescriptorTaskSuccessTest_002() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteSuccess(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, new byte[0], argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void writeDescriptorTaskFailedTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteFailed(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertTrue(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void writeDescriptorTaskFailedTest_002() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteFailed(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, BLEConstants.ErrorCodes.UNKNOWN, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void writeDescriptorTaskTimeoutTest_001() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteTimeout(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertTrue(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }

    @Test
    public void writeDescriptorTaskTimeoutTest_002() {
        final AtomicBoolean firstResult = new AtomicBoolean(false);
        BaseBLECallback firstCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(@NonNull Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteTimeout(getTaskId(), MOCK_DEVICE, MOCK_UUID, MOCK_UUID, MOCK_UUID, 0, argument);
                isProccesing.set(false);
                return true;
            }
        };

        try {
            MOCK_BLE_CONNECTION.attach(firstCallback);
            MOCK_BLE_CONNECTION.attach(secondCallback);

            MOCK_BLE_CONNECTION.addTask(task);

            while (isProccesing.get()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            assertTrue(firstResult.get());
            assertFalse(secondResult.get());
        } finally {
            MOCK_BLE_CONNECTION.detach(firstCallback);
            MOCK_BLE_CONNECTION.detach(secondCallback);
        }
    }
}
