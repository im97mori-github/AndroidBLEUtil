package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Message;

import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.task.AbstractBLETask;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class BLEConnectionTest {

    private static final class MockBLEConnection extends BLEConnection {
        private MockBLEConnection() {
            super(ApplicationProvider.getApplicationContext(), null);
            this.start();
        }
    }

    private static class BaseBLECallback implements BLECallback {
        @Override
        public void onBLEConnected(int taskId, BluetoothDevice bluetoothDevice, Bundle argument) {

        }

        @Override
        public void onBLEConnectFailed(int taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {

        }

        @Override
        public void onBLEConnectTimeout(int taskId, BluetoothDevice bluetoothDevice, Bundle argument) {

        }

        @Override
        public void onBLEDisconnected(int taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {

        }

        @Override
        public void onCharacteristicReadSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {

        }

        @Override
        public void onCharacteristicReadFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {

        }

        @Override
        public void onCharacteristicReadTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {

        }

        @Override
        public void onCharacteristicWriteSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {

        }

        @Override
        public void onCharacteristicWriteFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {

        }

        @Override
        public void onCharacteristicWriteTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {

        }

        @Override
        public void onDescriptorReadSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {

        }

        @Override
        public void onDescriptorReadFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {

        }

        @Override
        public void onDescriptorReadTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {

        }

        @Override
        public void onDescriptorWriteSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {

        }

        @Override
        public void onDescriptorWriteFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {

        }

        @Override
        public void onDescriptorWriteTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {

        }

        @Override
        public void onCharacteristicNotified(BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values) {

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
            public void onBLEConnected(int taskId, BluetoothDevice bluetoothDevice, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnected(int taskId, BluetoothDevice bluetoothDevice, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnected(getTaskId(), null, argument);
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
            public void onBLEConnected(int taskId, BluetoothDevice bluetoothDevice, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnected(int taskId, BluetoothDevice bluetoothDevice, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnected(getTaskId(), null, argument);
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
            public void onBLEConnectFailed(int taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectFailed(int taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnectFailed(getTaskId(), null, BLEConstants.ErrorCodes.UNKNOWN, argument);
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
            public void onBLEConnectFailed(int taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectFailed(int taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnectFailed(getTaskId(), null, BLEConstants.ErrorCodes.UNKNOWN, argument);
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
            public void onBLEConnectTimeout(int taskId, BluetoothDevice bluetoothDevice, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectTimeout(int taskId, BluetoothDevice bluetoothDevice, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnectTimeout(getTaskId(), null, argument);
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
            public void onBLEConnectTimeout(int taskId, BluetoothDevice bluetoothDevice, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEConnectTimeout(int taskId, BluetoothDevice bluetoothDevice, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEConnectTimeout(getTaskId(), null, argument);
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
            public void onBLEDisconnected(int taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEDisconnected(int taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEDisconnected(getTaskId(), null, BLEConstants.ErrorCodes.UNKNOWN, argument);
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
            public void onBLEDisconnected(int taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onBLEDisconnected(int taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onBLEDisconnected(getTaskId(), null, BLEConstants.ErrorCodes.UNKNOWN, argument);
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
            public void onCharacteristicReadSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadSuccess(getTaskId(), null, null, null, null, argument);
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
            public void onCharacteristicReadSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadSuccess(getTaskId(), null, null, null, null, argument);
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
            public void onCharacteristicReadFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadFailed(getTaskId(), null, null, null, BLEConstants.ErrorCodes.UNKNOWN, argument);
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
            public void onCharacteristicReadFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadFailed(getTaskId(), null, null, null, BLEConstants.ErrorCodes.UNKNOWN, argument);
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
            public void onCharacteristicReadTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadTimeout(getTaskId(), null, null, null, 0, argument);
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
            public void onCharacteristicReadTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicReadTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicReadTimeout(getTaskId(), null, null, null, 0, argument);
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
            public void onCharacteristicWriteSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteSuccess(getTaskId(), null, null, null, null, argument);
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
            public void onCharacteristicWriteSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteSuccess(getTaskId(), null, null, null, null, argument);
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
            public void onCharacteristicWriteFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteFailed(getTaskId(), null, null, null, BLEConstants.ErrorCodes.UNKNOWN, argument);
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
            public void onCharacteristicWriteFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteFailed(getTaskId(), null, null, null, BLEConstants.ErrorCodes.UNKNOWN, argument);
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
            public void onCharacteristicWriteTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteTimeout(getTaskId(), null, null, null, 0, argument);
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
            public void onCharacteristicWriteTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicWriteTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicWriteTimeout(getTaskId(), null, null, null, 0, argument);
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
            public void onCharacteristicNotified(BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onCharacteristicNotified(BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onCharacteristicNotified(null, null, null, null);
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
            public void onDescriptorReadSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadSuccess(getTaskId(), null, null, null, null, null, argument);
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
            public void onDescriptorReadSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadSuccess(getTaskId(), null, null, null, null, null, argument);
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
            public void onDescriptorReadFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadFailed(getTaskId(), null, null, null, null, BLEConstants.ErrorCodes.UNKNOWN, argument);
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
            public void onDescriptorReadFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadFailed(getTaskId(), null, null, null, null, BLEConstants.ErrorCodes.UNKNOWN, argument);
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
            public void onDescriptorReadTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadTimeout(getTaskId(), null, null, null, null, 0, argument);
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
            public void onDescriptorReadTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorReadTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorReadTimeout(getTaskId(), null, null, null, null, 0, argument);
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
            public void onDescriptorWriteSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteSuccess(getTaskId(), null, null, null, null, null, argument);
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
            public void onDescriptorWriteSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteSuccess(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteSuccess(getTaskId(), null, null, null, null, null, argument);
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
            public void onDescriptorWriteFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteFailed(getTaskId(), null, null, null, null, BLEConstants.ErrorCodes.UNKNOWN, argument);
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
            public void onDescriptorWriteFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteFailed(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteFailed(getTaskId(), null, null, null, null, BLEConstants.ErrorCodes.UNKNOWN, argument);
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
            public void onDescriptorWriteTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, null);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteTimeout(getTaskId(), null, null, null, null, 0, argument);
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
            public void onDescriptorWriteTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
                firstResult.set(true);
            }
        };
        final AtomicBoolean secondResult = new AtomicBoolean(false);
        BaseBLECallback secondCallback = new BaseBLECallback() {

            @Override
            public void onDescriptorWriteTimeout(int taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument) {
                secondResult.set(true);
            }
        };

        final AtomicBoolean isProccesing = new AtomicBoolean(true);
        final Bundle argument = MOCK_BLE_CONNECTION.wrapArgument(null, firstCallback);
        MockBLETask task = new MockBLETask() {
            @Override
            public boolean doProcess(Message message) {
                MOCK_BLE_CONNECTION.getBLECallback().onDescriptorWriteTimeout(getTaskId(), null, null, null, null, 0, argument);
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
