package org.im97mori.ble.service.scps.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.characteristic.u2a31.ScanRefresh;
import org.im97mori.ble.characteristic.u2a4f.ScanIntervalWindow;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.test.peripheral.MockBLEServerConnection;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SCAN_INTERVAL_WINDOW_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SCAN_REFRESH_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.SCAN_PARAMETERS_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ScanParametersServiceMockCallbackBuilderTest {

    @Test
    public void test_exception_00001() {
        Exception exception = null;
        try {
            new ScanParametersServiceMockCallback.Builder<>().build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Scan Interval Window data", exception.getMessage());
    }

    @Test
    public void test_exception_00002() {
        Exception exception = null;
        try {
            new ScanParametersServiceMockCallback.Builder<>()
                    .addScanIntervalWindow(new ScanIntervalWindow(0, 1))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addScanIntervalWindow_00001() {
        ScanIntervalWindow scanIntervalWindow = new ScanIntervalWindow(0, 1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };

        Exception exception = null;
        try {
            ScanParametersServiceMockCallback scanParametersServiceMockCallback = new ScanParametersServiceMockCallback.Builder<>()
                    .addScanIntervalWindow(scanIntervalWindow)
                    .build();
            scanParametersServiceMockCallback.setup(mockBLEServerConnection);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(SCAN_PARAMETERS_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SCAN_INTERVAL_WINDOW_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SCAN_INTERVAL_WINDOW_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(scanIntervalWindow.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addScanIntervalWindow_00101() {
        ScanIntervalWindow scanIntervalWindow = new ScanIntervalWindow(0, 1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };

        Exception exception = null;
        try {
            ScanParametersServiceMockCallback scanParametersServiceMockCallback = new ScanParametersServiceMockCallback.Builder<>()
                    .addScanIntervalWindow(scanIntervalWindow.getBytes())
                    .build();
            scanParametersServiceMockCallback.setup(mockBLEServerConnection);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(SCAN_PARAMETERS_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SCAN_INTERVAL_WINDOW_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SCAN_INTERVAL_WINDOW_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(scanIntervalWindow.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addScanIntervalWindow_00201() {
        ScanIntervalWindow scanIntervalWindow = new ScanIntervalWindow(0, 1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };

        Exception exception = null;
        try {
            ScanParametersServiceMockCallback scanParametersServiceMockCallback = new ScanParametersServiceMockCallback.Builder<>()
                    .addScanIntervalWindow(BluetoothGatt.GATT_SUCCESS, 0, scanIntervalWindow.getBytes())
                    .build();
            scanParametersServiceMockCallback.setup(mockBLEServerConnection);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(SCAN_PARAMETERS_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SCAN_INTERVAL_WINDOW_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SCAN_INTERVAL_WINDOW_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(scanIntervalWindow.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeCurrentTime_00001() {
        Exception exception = null;
        try {
            new ScanParametersServiceMockCallback.Builder<>()
                    .addScanIntervalWindow(new ScanIntervalWindow(0, 1))
                    .removeScanIntervalWindow()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Scan Interval Window data", exception.getMessage());
    }

    @Test
    public void test_addScanRefresh_00001() {
        ScanRefresh scanRefresh = new ScanRefresh(1);

        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };

        Exception exception = null;
        try {
            ScanParametersServiceMockCallback scanParametersServiceMockCallback = new ScanParametersServiceMockCallback.Builder<>()
                    .addScanIntervalWindow(new ScanIntervalWindow(0, 1))
                    .addScanRefresh(scanRefresh, clientCharacteristicConfiguration)
                    .build();
            scanParametersServiceMockCallback.setup(mockBLEServerConnection);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(SCAN_PARAMETERS_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SCAN_REFRESH_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SCAN_REFRESH_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(scanRefresh.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addScanRefresh_00101() {
        ScanRefresh scanRefresh = new ScanRefresh(1);

        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };

        Exception exception = null;
        try {
            ScanParametersServiceMockCallback scanParametersServiceMockCallback = new ScanParametersServiceMockCallback.Builder<>()
                    .addScanIntervalWindow(new ScanIntervalWindow(0, 1))
                    .addScanRefresh(BluetoothGatt.GATT_SUCCESS, 0, scanRefresh.getBytes(), 0, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes())
                    .build();
            scanParametersServiceMockCallback.setup(mockBLEServerConnection);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(SCAN_PARAMETERS_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SCAN_REFRESH_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SCAN_REFRESH_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(scanRefresh.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeScanRefresh_00001() {
        ScanRefresh scanRefresh = new ScanRefresh(1);

        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };

        Exception exception = null;
        try {
            ScanParametersServiceMockCallback scanParametersServiceMockCallback = new ScanParametersServiceMockCallback.Builder<>()
                    .addScanIntervalWindow(new ScanIntervalWindow(0, 1))
                    .addScanRefresh(scanRefresh, clientCharacteristicConfiguration)
                    .removeScanRefresh()
                    .build();
            scanParametersServiceMockCallback.setup(mockBLEServerConnection);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);

        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(SCAN_PARAMETERS_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SCAN_REFRESH_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

}

