package org.im97mori.ble.service.cts.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a14.ReferenceTimeInformation;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.CURRENT_TIME_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LOCAL_TIME_INFORMATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.REFERENCE_TIME_INFORMATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.CURRENT_TIME_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CurrentTimeServiceMockCallbackBuilderTest extends AbstractPeripherallTest {

    @Test
    public void test_exception_00001() {
        Exception exception = null;
        try {
            new CurrentTimeServiceMockCallback.Builder<>().build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Current Time data", exception.getMessage());
    }

    @Test
    public void test_exception_00002() {
        Exception exception = null;
        try {
            new CurrentTimeServiceMockCallback.Builder<>()
                    .addCurrentTime(new CurrentTime(new byte[10]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addCurrentTime_00001() {
        CurrentTime currentTime = new CurrentTime(0, 1, 2, 3, 4, 5, 6, 7, 8);

        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CurrentTimeServiceMockCallback currentTimeServiceMockCallback = new CurrentTimeServiceMockCallback.Builder<>()
                    .addCurrentTime(currentTime, clientCharacteristicConfiguration)
                    .build();
            currentTimeServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CURRENT_TIME_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CURRENT_TIME_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CURRENT_TIME_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(currentTime.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addCurrentTime_00101() {
        CurrentTime currentTime = new CurrentTime(0, 1, 2, 3, 4, 5, 6, 7, 8);

        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CurrentTimeServiceMockCallback currentTimeServiceMockCallback = new CurrentTimeServiceMockCallback.Builder<>()
                    .addCurrentTime(false, BluetoothGatt.GATT_SUCCESS, 0, currentTime.getBytes(), 1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes())
                    .build();
            currentTimeServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CURRENT_TIME_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CURRENT_TIME_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CURRENT_TIME_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(currentTime.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addCurrentTime_00102() {
        CurrentTime currentTime = new CurrentTime(0, 1, 2, 3, 4, 5, 6, 7, 8);

        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CurrentTimeServiceMockCallback currentTimeServiceMockCallback = new CurrentTimeServiceMockCallback.Builder<>()
                    .addCurrentTime(true, BluetoothGatt.GATT_SUCCESS, 0, currentTime.getBytes(), 1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes())
                    .build();
            currentTimeServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CURRENT_TIME_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CURRENT_TIME_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CURRENT_TIME_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(currentTime.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeCurrentTime_00001() {
        CurrentTime currentTime = new CurrentTime(0, 1, 2, 3, 4, 5, 6, 7, 8);

        byte[] value = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(value);

        Exception exception = null;
        try {
            new CurrentTimeServiceMockCallback.Builder<>()
                    .addCurrentTime(currentTime, clientCharacteristicConfiguration)
                    .removeCurrentTime()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Current Time data", exception.getMessage());
    }

    @Test
    public void test_addLocalTimeInformation_00001() {
        LocalTimeInformation localTimeInformation = new LocalTimeInformation(LocalTimeInformation.TIME_ZONE_IS_NOT_KNOWN, 1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CurrentTimeServiceMockCallback currentTimeServiceMockCallback = new CurrentTimeServiceMockCallback.Builder<>()
                    .addLocalTimeInformation(localTimeInformation)
                    .addCurrentTime(new CurrentTime(new byte[10]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            currentTimeServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CURRENT_TIME_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LOCAL_TIME_INFORMATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(localTimeInformation.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addLocalTimeInformation_00101() {
        LocalTimeInformation localTimeInformation = new LocalTimeInformation(LocalTimeInformation.TIME_ZONE_IS_NOT_KNOWN, 1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CurrentTimeServiceMockCallback currentTimeServiceMockCallback = new CurrentTimeServiceMockCallback.Builder<>()
                    .addLocalTimeInformation(localTimeInformation.getBytes())
                    .addCurrentTime(new CurrentTime(new byte[10]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            currentTimeServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CURRENT_TIME_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LOCAL_TIME_INFORMATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(localTimeInformation.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addLocalTimeInformation_00201() {
        LocalTimeInformation localTimeInformation = new LocalTimeInformation(LocalTimeInformation.TIME_ZONE_IS_NOT_KNOWN, 1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CurrentTimeServiceMockCallback currentTimeServiceMockCallback = new CurrentTimeServiceMockCallback.Builder<>()
                    .addLocalTimeInformation(false, BluetoothGatt.GATT_SUCCESS, 0, localTimeInformation.getBytes())
                    .addCurrentTime(new CurrentTime(new byte[10]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            currentTimeServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CURRENT_TIME_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LOCAL_TIME_INFORMATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(localTimeInformation.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addLocalTimeInformation_00202() {
        LocalTimeInformation localTimeInformation = new LocalTimeInformation(LocalTimeInformation.TIME_ZONE_IS_NOT_KNOWN, 1);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CurrentTimeServiceMockCallback currentTimeServiceMockCallback = new CurrentTimeServiceMockCallback.Builder<>()
                    .addLocalTimeInformation(true, BluetoothGatt.GATT_SUCCESS, 0, localTimeInformation.getBytes())
                    .addCurrentTime(new CurrentTime(new byte[10]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            currentTimeServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CURRENT_TIME_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LOCAL_TIME_INFORMATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LOCAL_TIME_INFORMATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(localTimeInformation.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeLocalTimeInformation_00001() {
        LocalTimeInformation localTimeInformation = new LocalTimeInformation(LocalTimeInformation.TIME_ZONE_IS_NOT_KNOWN, 1);

        Exception exception = null;
        try {
            new CurrentTimeServiceMockCallback.Builder<>()
                    .addLocalTimeInformation(localTimeInformation)
                    .addCurrentTime(new CurrentTime(new byte[10]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeLocalTimeInformation()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addReferenceTimeInformation_00001() {
        ReferenceTimeInformation referenceTimeInformation = new ReferenceTimeInformation(1, 2, 3, 4);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CurrentTimeServiceMockCallback currentTimeServiceMockCallback = new CurrentTimeServiceMockCallback.Builder<>()
                    .addReferenceTimeInformation(referenceTimeInformation)
                    .addCurrentTime(new CurrentTime(new byte[10]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            currentTimeServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CURRENT_TIME_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(REFERENCE_TIME_INFORMATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(REFERENCE_TIME_INFORMATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        ReferenceTimeInformation result = new ReferenceTimeInformation(bluetoothGattCharacteristic.getValue());
        assertEquals(referenceTimeInformation.getTimeSource(), result.getTimeSource());
        assertEquals(referenceTimeInformation.getAccuracy(), result.getAccuracy());
    }

    @Test
    public void test_addReferenceTimeInformation_00101() {
        ReferenceTimeInformation referenceTimeInformation = new ReferenceTimeInformation(1, 2, 3, 4);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CurrentTimeServiceMockCallback currentTimeServiceMockCallback = new CurrentTimeServiceMockCallback.Builder<>()
                    .addReferenceTimeInformation(referenceTimeInformation.getBytes())
                    .addCurrentTime(new CurrentTime(new byte[10]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            currentTimeServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CURRENT_TIME_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(REFERENCE_TIME_INFORMATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(REFERENCE_TIME_INFORMATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        ReferenceTimeInformation result = new ReferenceTimeInformation(bluetoothGattCharacteristic.getValue());
        assertEquals(referenceTimeInformation.getTimeSource(), result.getTimeSource());
        assertEquals(referenceTimeInformation.getAccuracy(), result.getAccuracy());
    }

    @Test
    public void test_addReferenceTimeInformation_00201() {
        ReferenceTimeInformation referenceTimeInformation = new ReferenceTimeInformation(1, 2, 3, 4);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            CurrentTimeServiceMockCallback currentTimeServiceMockCallback = new CurrentTimeServiceMockCallback.Builder<>()
                    .addReferenceTimeInformation(BluetoothGatt.GATT_SUCCESS, 0, referenceTimeInformation.getBytes())
                    .addCurrentTime(new CurrentTime(new byte[10]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            currentTimeServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(CURRENT_TIME_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(REFERENCE_TIME_INFORMATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(REFERENCE_TIME_INFORMATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        ReferenceTimeInformation result = new ReferenceTimeInformation(bluetoothGattCharacteristic.getValue());
        assertEquals(referenceTimeInformation.getTimeSource(), result.getTimeSource());
        assertEquals(referenceTimeInformation.getAccuracy(), result.getAccuracy());
    }

    @Test
    public void test_removeReferenceTimeInformation_00001() {
        ReferenceTimeInformation referenceTimeInformation = new ReferenceTimeInformation(1, 2, 3, 4);

        Exception exception = null;
        try {
            new CurrentTimeServiceMockCallback.Builder<>()
                    .addReferenceTimeInformation(referenceTimeInformation)
                    .addCurrentTime(new CurrentTime(new byte[10]), new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .removeReferenceTimeInformation()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

}

