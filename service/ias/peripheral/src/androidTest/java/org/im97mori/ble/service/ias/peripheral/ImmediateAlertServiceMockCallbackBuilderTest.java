package org.im97mori.ble.service.ias.peripheral;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Build;

import org.im97mori.ble.characteristic.u2a06.AlertLevel;
import org.im97mori.ble.test.peripheral.AbstractPeripheralTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.ALERT_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.IMMEDIATE_ALERT_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

public class ImmediateAlertServiceMockCallbackBuilderTest extends AbstractPeripheralTest {

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAlertLevel_00001() {
        Exception exception = null;
        try {
            new ImmediateAlertServiceMockCallback.Builder<>().build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Alert Level data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAlertLevel_00002() {
        AlertLevel alertLevel = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT);
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        ImmediateAlertServiceMockCallback callback = new ImmediateAlertServiceMockCallback.Builder<>().addAlertLevel(alertLevel.getAlertLevel()).build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(IMMEDIATE_ALERT_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ALERT_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), alertLevel.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAlertLevel_00003() {
        AlertLevel alertLevel = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT);
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> builder = new ImmediateAlertServiceMockCallback.Builder<>();
        builder.addAlertLevel(alertLevel);
        ImmediateAlertServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(IMMEDIATE_ALERT_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ALERT_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), alertLevel.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAlertLevel_00004() {
        AlertLevel alertLevel = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT);
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> builder = new ImmediateAlertServiceMockCallback.Builder<>();
        builder.addAlertLevel(alertLevel.getBytes());
        ImmediateAlertServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(IMMEDIATE_ALERT_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ALERT_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), alertLevel.getBytes());
    }


    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAlertLevel_00005() {
        AlertLevel alertLevel = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT);
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        ImmediateAlertServiceMockCallback.Builder<ImmediateAlertServiceMockCallback> builder = new ImmediateAlertServiceMockCallback.Builder<>();
        builder.addAlertLevel(0, 0, alertLevel.getBytes());
        ImmediateAlertServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);

        assertEquals(IMMEDIATE_ALERT_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ALERT_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertArrayEquals(bluetoothGattCharacteristic.getValue(), alertLevel.getBytes());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAlertLevel_00001() {
        AlertLevel alertLevel = new AlertLevel(AlertLevel.ALERT_LEVEL_HIGH_ALERT);
        Exception exception = null;
        try {
            new ImmediateAlertServiceMockCallback.Builder<>()
                    .addAlertLevel(alertLevel)
                    .removeAlertLevel()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Alert Level data", exception.getMessage());
    }

}
