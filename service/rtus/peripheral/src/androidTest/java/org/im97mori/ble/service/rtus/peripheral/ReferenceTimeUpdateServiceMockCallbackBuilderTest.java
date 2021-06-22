package org.im97mori.ble.service.rtus.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;

import org.im97mori.ble.characteristic.u2a16.TimeUpdateControlPoint;
import org.im97mori.ble.characteristic.u2a17.TimeUpdateState;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TIME_UPDATE_STATE_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.REFERENCE_TIME_UPDATE_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ReferenceTimeUpdateServiceMockCallbackBuilderTest extends AbstractPeripherallTest {

    @Test
    public void test_exception_00001() {
        Exception exception = null;
        try {
            new ReferenceTimeUpdateServiceMockCallback.Builder<>().build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Time Update Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00002() {
        Exception exception = null;
        try {
            new ReferenceTimeUpdateServiceMockCallback.Builder<>()
                    .addTimeUpdateControlPoint(new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Time Update State data", exception.getMessage());
    }

    @Test
    public void test_exception_00003() {
        Exception exception = null;
        try {
            new ReferenceTimeUpdateServiceMockCallback.Builder<>()
                    .addTimeUpdateControlPoint(new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE))
                    .addTimeUpdateState(new TimeUpdateState(TimeUpdateState.CURRENT_STATE_IDLE, TimeUpdateState.RESULT_SUCCESSFUL))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addTimeUpdateControlPoint_00001() {
        TimeUpdateControlPoint timeUpdateControlPoint = new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            ReferenceTimeUpdateServiceMockCallback referenceTimeUpdateServiceMockCallback = new ReferenceTimeUpdateServiceMockCallback.Builder<>()
                    .addTimeUpdateControlPoint(timeUpdateControlPoint)
                    .addTimeUpdateState(new TimeUpdateState(TimeUpdateState.CURRENT_STATE_IDLE, TimeUpdateState.RESULT_SUCCESSFUL))
                    .build();
            referenceTimeUpdateServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(REFERENCE_TIME_UPDATE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(timeUpdateControlPoint.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addTimeUpdateControlPoint_00002() {
        TimeUpdateControlPoint timeUpdateControlPoint = new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            ReferenceTimeUpdateServiceMockCallback referenceTimeUpdateServiceMockCallback = new ReferenceTimeUpdateServiceMockCallback.Builder<>()
                    .addTimeUpdateControlPoint(BluetoothGatt.GATT_SUCCESS, 0, timeUpdateControlPoint.getBytes())
                    .addTimeUpdateState(new TimeUpdateState(TimeUpdateState.CURRENT_STATE_IDLE, TimeUpdateState.RESULT_SUCCESSFUL))
                    .build();
            referenceTimeUpdateServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(REFERENCE_TIME_UPDATE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(timeUpdateControlPoint.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeCurrentTime_00001() {
        Exception exception = null;
        try {
            new ReferenceTimeUpdateServiceMockCallback.Builder<>()
                    .addTimeUpdateControlPoint(new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE))
                    .removeTimeUpdateControlPoint()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Time Update Control Point data", exception.getMessage());
    }

    @Test
    public void test_addTimeUpdateState_00001() {
        TimeUpdateState timeUpdateState = new TimeUpdateState(TimeUpdateState.CURRENT_STATE_IDLE, TimeUpdateState.RESULT_SUCCESSFUL);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            ReferenceTimeUpdateServiceMockCallback referenceTimeUpdateServiceMockCallback = new ReferenceTimeUpdateServiceMockCallback.Builder<>()
                    .addTimeUpdateControlPoint(new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE))
                    .addTimeUpdateState(timeUpdateState)
                    .build();
            referenceTimeUpdateServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(REFERENCE_TIME_UPDATE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TIME_UPDATE_STATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TIME_UPDATE_STATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(timeUpdateState.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addTimeUpdateState_00101() {
        TimeUpdateState timeUpdateState = new TimeUpdateState(TimeUpdateState.CURRENT_STATE_IDLE, TimeUpdateState.RESULT_SUCCESSFUL);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            ReferenceTimeUpdateServiceMockCallback referenceTimeUpdateServiceMockCallback = new ReferenceTimeUpdateServiceMockCallback.Builder<>()
                    .addTimeUpdateControlPoint(new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE))
                    .addTimeUpdateState(BluetoothGatt.GATT_SUCCESS, 0, timeUpdateState.getBytes())
                    .build();
            referenceTimeUpdateServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(REFERENCE_TIME_UPDATE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TIME_UPDATE_STATE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TIME_UPDATE_STATE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(timeUpdateState.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeTimeUpdateState_00001() {
        Exception exception = null;
        try {
            new ReferenceTimeUpdateServiceMockCallback.Builder<>()
                    .addTimeUpdateControlPoint(new TimeUpdateControlPoint(TimeUpdateControlPoint.TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE))
                    .addTimeUpdateState(new TimeUpdateState(TimeUpdateState.CURRENT_STATE_IDLE, TimeUpdateState.RESULT_SUCCESSFUL))
                    .removeTimeUpdateState()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Time Update State data", exception.getMessage());
    }

}

