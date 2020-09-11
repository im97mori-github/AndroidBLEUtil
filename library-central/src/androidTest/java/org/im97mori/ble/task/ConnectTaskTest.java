package org.im97mori.ble.task;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLECallbackDistributer;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BaseBLECallback;
import org.im97mori.ble.MockBLEConnection;
import org.im97mori.ble.TaskHandler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class ConnectTaskTest {

    @Test
    public void test_createInitialMessage001() {
        ConnectTask task = new ConnectTask(null, null, false, ConnectTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CONNECT, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createConnectSuccess001() {
        Object object = new Object();
        Message message = ConnectTask.createConnectSuccessMessage(object);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CONNECT_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(object, message.obj);
    }

    @Test
    public void test_doProcess_00001() {
        MockBLEConnection mockBleConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return false;
            }
        };
        ConnectTask task = new ConnectTask(mockBleConnection, null, false, ConnectTask.TIMEOUT_MILLIS, null);
        assertFalse(task.doProcess(new Message()));
    }

    @Test
    public void test_doProcess_00101() {
        BLEConnection mockBleConnection = new BLEConnection(ApplicationProvider.getApplicationContext(), null, null) {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        Looper looper = null;
        try {
            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);

            ConnectTask task = new ConnectTask(mockBleConnection, mockTaskHandler, false, ConnectTask.TIMEOUT_MILLIS, null);

            assertTrue(task.doProcess(null));
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }
    }


    @Test
    public void test_cancel_00001() {
        MockBLEConnection mockBleConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return false;
            }
        };
        Looper looper = null;
        try {
            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            ConnectTask task = new ConnectTask(mockBleConnection, mockTaskHandler, false, ConnectTask.TIMEOUT_MILLIS, BLECallbackDistributer.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }
    }

    @Test
    public void test_cancel_00002() {
        MockBLEConnection mockBleConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return false;
            }
        };
        Looper looper = null;
        try {
            mockBleConnection.start();
            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            ConnectTask task = new ConnectTask(mockBleConnection, mockTaskHandler, false, ConnectTask.TIMEOUT_MILLIS, BLECallbackDistributer.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }
    }

    @Test
    public void test_cancel_00003() {
        MockBLEConnection mockBleConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return false;
            }
        };
        Looper looper = null;
        try {
            mockBleConnection.start();
            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);


            BaseBLECallback callback = new BaseBLECallback() {
                @Override
                public void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                    result.set(true);
                }
            };
            mockBleConnection.attach(callback);

            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            ConnectTask task = new ConnectTask(mockBleConnection, mockTaskHandler, false, ConnectTask.TIMEOUT_MILLIS, BLECallbackDistributer.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
            assertTrue(callback.result.get());
        } finally {
            if (looper != null) {
                looper.quit();
            }
            mockBleConnection.quit();
        }
    }

}
