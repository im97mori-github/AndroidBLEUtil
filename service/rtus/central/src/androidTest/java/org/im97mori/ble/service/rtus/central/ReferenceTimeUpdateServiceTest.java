package org.im97mori.ble.service.rtus.central;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.characteristic.u2a16.TimeUpdateControlPoint;
import org.im97mori.ble.characteristic.u2a16.TimeUpdateControlPointAndroid;
import org.im97mori.ble.characteristic.u2a17.TimeUpdateState;
import org.im97mori.ble.characteristic.u2a17.TimeUpdateStateAndroid;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TIME_UPDATE_STATE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.ServiceUUID.REFERENCE_TIME_UPDATE_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ReferenceTimeUpdateServiceTest {

    @Test
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = REFERENCE_TIME_UPDATE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TIME_UPDATE_STATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new TimeUpdateState(TimeUpdateState.CURRENT_STATE_IDLE, TimeUpdateState.RESULT_SUCCESSFUL).getBytes();
        final Bundle originalBundle = new Bundle();
        MockReferenceTimeUpdateServiceCallback mockReferenceTimeUpdateServiceCallback = new MockReferenceTimeUpdateServiceCallback() {

            @Override
            public void onTimeUpdateStateReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull TimeUpdateStateAndroid timeUpdateStateAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, timeUpdateStateAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        ReferenceTimeUpdateService referenceTimeUpdateService = new ReferenceTimeUpdateService(new MockBLEConnection(), mockReferenceTimeUpdateServiceCallback, null);
        referenceTimeUpdateService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = REFERENCE_TIME_UPDATE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TIME_UPDATE_STATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockReferenceTimeUpdateServiceCallback mockReferenceTimeUpdateServiceCallback = new MockReferenceTimeUpdateServiceCallback() {

            @Override
            public void onTimeUpdateStateReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        ReferenceTimeUpdateService referenceTimeUpdateService = new ReferenceTimeUpdateService(new MockBLEConnection(), mockReferenceTimeUpdateServiceCallback, null);
        referenceTimeUpdateService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = REFERENCE_TIME_UPDATE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TIME_UPDATE_STATE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockReferenceTimeUpdateServiceCallback mockReferenceTimeUpdateServiceCallback = new MockReferenceTimeUpdateServiceCallback() {

            @Override
            public void onTimeUpdateStateReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        ReferenceTimeUpdateService referenceTimeUpdateService = new ReferenceTimeUpdateService(new MockBLEConnection(), mockReferenceTimeUpdateServiceCallback, null);
        referenceTimeUpdateService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = REFERENCE_TIME_UPDATE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE).getBytes();
        final Bundle originalBundle = new Bundle();
        MockReferenceTimeUpdateServiceCallback mockReferenceTimeUpdateServiceCallback = new MockReferenceTimeUpdateServiceCallback() {

            @Override
            public void onTimeUpdateControlPointWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull TimeUpdateControlPointAndroid timeUpdateControlPointAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, timeUpdateControlPointAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        ReferenceTimeUpdateService referenceTimeUpdateService = new ReferenceTimeUpdateService(new MockBLEConnection(), mockReferenceTimeUpdateServiceCallback, null);
        referenceTimeUpdateService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = REFERENCE_TIME_UPDATE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockReferenceTimeUpdateServiceCallback mockReferenceTimeUpdateServiceCallback = new MockReferenceTimeUpdateServiceCallback() {

            @Override
            public void onTimeUpdateControlPointWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        ReferenceTimeUpdateService referenceTimeUpdateService = new ReferenceTimeUpdateService(new MockBLEConnection(), mockReferenceTimeUpdateServiceCallback, null);
        referenceTimeUpdateService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = REFERENCE_TIME_UPDATE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockReferenceTimeUpdateServiceCallback mockReferenceTimeUpdateServiceCallback = new MockReferenceTimeUpdateServiceCallback() {

            @Override
            public void onTimeUpdateControlPointWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        ReferenceTimeUpdateService referenceTimeUpdateService = new ReferenceTimeUpdateService(new MockBLEConnection(), mockReferenceTimeUpdateServiceCallback, null);
        referenceTimeUpdateService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_setTimeUpdateControlPoint_000001() {
        ReferenceTimeUpdateService referenceTimeUpdateService = new ReferenceTimeUpdateService(new MockBLEConnection(), new MockReferenceTimeUpdateServiceCallback(), null);
        TimeUpdateControlPoint timeUpdateControlPoint = new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE);

        assertNull(referenceTimeUpdateService.setTimeUpdateControlPoint(timeUpdateControlPoint));
    }

    @Test
    public void test_setTimeUpdateControlPoint_000002() {
        ReferenceTimeUpdateService referenceTimeUpdateService = new ReferenceTimeUpdateService(new MockBLEConnection(), new MockReferenceTimeUpdateServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        TimeUpdateControlPoint timeUpdateControlPoint = new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE);

        assertNull(referenceTimeUpdateService.setTimeUpdateControlPoint(timeUpdateControlPoint));
    }

    @Test
    public void test_setTimeUpdateControlPoint_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        ReferenceTimeUpdateService referenceTimeUpdateService = new ReferenceTimeUpdateService(mockBLEConnection, new MockReferenceTimeUpdateServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };
        TimeUpdateControlPoint timeUpdateControlPoint = new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE);

        Integer taskId = referenceTimeUpdateService.setTimeUpdateControlPoint(timeUpdateControlPoint);
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getTimeUpdateState_000001() {
        ReferenceTimeUpdateService referenceTimeUpdateService = new ReferenceTimeUpdateService(new MockBLEConnection(), new MockReferenceTimeUpdateServiceCallback(), null);

        assertNull(referenceTimeUpdateService.getTimeUpdateState());
    }

    @Test
    public void test_getTimeUpdateState_000002() {
        ReferenceTimeUpdateService referenceTimeUpdateService = new ReferenceTimeUpdateService(new MockBLEConnection(), new MockReferenceTimeUpdateServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(referenceTimeUpdateService.getTimeUpdateState());
    }

    @Test
    public void test_getTimeUpdateState_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        ReferenceTimeUpdateService referenceTimeUpdateService = new ReferenceTimeUpdateService(mockBLEConnection, new MockReferenceTimeUpdateServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = referenceTimeUpdateService.getTimeUpdateState();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

}
