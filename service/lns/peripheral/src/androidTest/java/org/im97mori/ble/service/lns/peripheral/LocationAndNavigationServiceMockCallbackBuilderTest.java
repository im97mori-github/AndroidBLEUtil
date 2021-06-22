package org.im97mori.ble.service.lns.peripheral;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

import org.im97mori.ble.characteristic.u2a67.LocationAndSpeed;
import org.im97mori.ble.characteristic.u2a68.Navigation;
import org.im97mori.ble.characteristic.u2a69.PositionQuality;
import org.im97mori.ble.characteristic.u2a6a.LNFeature;
import org.im97mori.ble.characteristic.u2a6b.LNControlPoint;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.LN_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LN_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LOCATION_AND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.NAVIGATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.POSITION_QUALITY_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.LOCATION_AND_NAVIGATION_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class LocationAndNavigationServiceMockCallbackBuilderTest extends AbstractPeripherallTest {

    @Test
    public void test_addLNFeature_00001() {
        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>().build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no LN Feature data", exception.getMessage());
    }

    @Test
    public void test_addLNFeature_00101() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            LocationAndNavigationServiceMockCallback locationAndNavigationServiceMockCallback = new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            locationAndNavigationServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LN_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LN_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(lnFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addLNFeature_00201() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );
        int responseCode = 1;
        long delay = 2;

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            LocationAndNavigationServiceMockCallback locationAndNavigationServiceMockCallback = new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(responseCode, delay, lnFeature.getBytes())
                    .addLocationAndSpeed(locationAndSpeed, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
            locationAndNavigationServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LN_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LN_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(lnFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeLNFeature_00101() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .removeLNFeature()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no LN Feature data", exception.getMessage());
    }

    @Test
    public void test_addLocationAndSpeed_00001() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Location and Speed data", exception.getMessage());
    }

    @Test
    public void test_addLocationAndSpeed_00101() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            LocationAndNavigationServiceMockCallback locationAndNavigationServiceMockCallback = new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
            locationAndNavigationServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LOCATION_AND_SPEED_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LOCATION_AND_SPEED_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(locationAndSpeed.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(locationAndSpeedClientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addLocationAndSpeed_00201() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        int locationAndSpeedResponseCode = 1;
        long locationAndSpeedDelay = 2;
        int locationAndSpeedNotificationCount = 3;

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        int locationAndSpeedClientCharacteristicConfigurationResponseCode = 4;
        long locationAndSpeedClientCharacteristicConfigurationDelay = 5;


        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            LocationAndNavigationServiceMockCallback locationAndNavigationServiceMockCallback = new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeedResponseCode, locationAndSpeedDelay, locationAndSpeed.getBytes(), locationAndSpeedNotificationCount, locationAndSpeedClientCharacteristicConfigurationResponseCode, locationAndSpeedClientCharacteristicConfigurationDelay, locationAndSpeedClientCharacteristicConfiguration.getBytes())
                    .build();
            locationAndNavigationServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LOCATION_AND_SPEED_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LOCATION_AND_SPEED_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(locationAndSpeed.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(locationAndSpeedClientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeLocationAndSpeed_00101() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .removeLocationAndSpeed()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Location and Speed data", exception.getMessage());
    }

    @Test
    public void test_addPositionQuality_00001() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            LocationAndNavigationServiceMockCallback locationAndNavigationServiceMockCallback = new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
            locationAndNavigationServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POSITION_QUALITY_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addPositionQuality_00002() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , true
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Position Quality data", exception.getMessage());
    }

    @Test
    public void test_addPositionQuality_00003() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , true
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Position Quality data", exception.getMessage());
    }

    @Test
    public void test_addPositionQuality_00004() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , true
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Position Quality data", exception.getMessage());
    }

    @Test
    public void test_addPositionQuality_00005() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , true
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Position Quality data", exception.getMessage());
    }

    @Test
    public void test_addPositionQuality_00006() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , true
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Position Quality data", exception.getMessage());
    }

    @Test
    public void test_addPositionQuality_00007() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , true
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Position Quality data", exception.getMessage());
    }

    @Test
    public void test_addPositionQuality_00101() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        PositionQuality positionQuality = new PositionQuality(new byte[2], 0, 0, 0, 0, 0, 0, 0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            LocationAndNavigationServiceMockCallback locationAndNavigationServiceMockCallback = new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .addPositionQuality(positionQuality)
                    .build();
            locationAndNavigationServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POSITION_QUALITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(POSITION_QUALITY_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(positionQuality.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addPositionQuality_00201() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        PositionQuality positionQuality = new PositionQuality(new byte[2], 0, 0, 0, 0, 0, 0, 0);

        int responseCode = 1;
        long delay = 2;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            LocationAndNavigationServiceMockCallback locationAndNavigationServiceMockCallback = new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .addPositionQuality(responseCode, delay, positionQuality.getBytes())
                    .build();
            locationAndNavigationServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POSITION_QUALITY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(POSITION_QUALITY_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(positionQuality.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removePositionQuality_00001() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        PositionQuality positionQuality = new PositionQuality(new byte[2], 0, 0, 0, 0, 0, 0, 0);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            LocationAndNavigationServiceMockCallback locationAndNavigationServiceMockCallback = new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .addPositionQuality(positionQuality)
                    .removePositionQuality()
                    .build();
            locationAndNavigationServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(POSITION_QUALITY_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addNavigation_00001() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            LocationAndNavigationServiceMockCallback locationAndNavigationServiceMockCallback = new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
            locationAndNavigationServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NAVIGATION_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addNavigation_00002() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , true
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Navigation data", exception.getMessage());
    }

    @Test
    public void test_addNavigation_00003() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , true
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Navigation data", exception.getMessage());
    }

    @Test
    public void test_addNavigation_00004() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , true
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Navigation data", exception.getMessage());
    }

    @Test
    public void test_addNavigation_00005() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , true
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        PositionQuality positionQuality = new PositionQuality(new byte[2], 0, 0, 0, 0, 0, 0, 0);

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .addPositionQuality(positionQuality)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Navigation data", exception.getMessage());
    }

    @Test
    public void test_addNavigation_00101() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , true
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Navigation navigation = new Navigation(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        ClientCharacteristicConfiguration navigationClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        int lnControlPointResponseCode = 1;
        long lnControlPointDelay = 2;

        ClientCharacteristicConfiguration lnControlPointClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        int lnControlPointClientCharacteristicConfigurationResponseCode = 3;
        long lnControlPointClientCharacteristicConfigurationDelay = 4;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            LocationAndNavigationServiceMockCallback locationAndNavigationServiceMockCallback = new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .addNavigation(navigation, navigationClientCharacteristicConfiguration)
                    .addLNControlPoint(lnControlPointResponseCode
                            , lnControlPointDelay
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , lnControlPointClientCharacteristicConfigurationResponseCode
                            , lnControlPointClientCharacteristicConfigurationDelay
                            , lnControlPointClientCharacteristicConfiguration.getBytes())
                    .build();
            locationAndNavigationServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NAVIGATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(NAVIGATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(navigation.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(locationAndSpeedClientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addNavigation_00201() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , true
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Navigation navigation = new Navigation(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);
        int navigationResponseCode = 1;
        long navigationDelay = 2;
        int navigationNotificationCount = 3;

        ClientCharacteristicConfiguration navigationClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        int navigationClientCharacteristicConfigurationResponseCode = 4;
        long navigationClientCharacteristicConfigurationDelay = 5;

        int lnControlPointResponseCode = 1;
        long lnControlPointDelay = 2;

        ClientCharacteristicConfiguration lnControlPointClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        int lnControlPointClientCharacteristicConfigurationResponseCode = 3;
        long lnControlPointClientCharacteristicConfigurationDelay = 4;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            LocationAndNavigationServiceMockCallback locationAndNavigationServiceMockCallback = new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .addNavigation(navigationResponseCode, navigationDelay, navigation.getBytes(), navigationNotificationCount, navigationClientCharacteristicConfigurationResponseCode, navigationClientCharacteristicConfigurationDelay, navigationClientCharacteristicConfiguration.getBytes())
                    .addLNControlPoint(lnControlPointResponseCode
                            , lnControlPointDelay
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , lnControlPointClientCharacteristicConfigurationResponseCode
                            , lnControlPointClientCharacteristicConfigurationDelay
                            , lnControlPointClientCharacteristicConfiguration.getBytes())
                    .build();
            locationAndNavigationServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NAVIGATION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(NAVIGATION_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(navigation.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(locationAndSpeedClientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeNavigation_00001() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Navigation navigation = new Navigation(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        ClientCharacteristicConfiguration navigationClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            LocationAndNavigationServiceMockCallback locationAndNavigationServiceMockCallback = new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .addNavigation(navigation, navigationClientCharacteristicConfiguration)
                    .removeNavigation()
                    .build();
            locationAndNavigationServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(NAVIGATION_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addLNControlPoint_00001() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            LocationAndNavigationServiceMockCallback locationAndNavigationServiceMockCallback = new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
            locationAndNavigationServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LN_CONTROL_POINT_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addLNControlPoint_00002() {
        LNFeature lnFeature = new LNFeature(false
                , true
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no LN Control Point data", exception.getMessage());
    }

    @Test
    public void test_addLNControlPoint_00003() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , true
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no LN Control Point data", exception.getMessage());
    }

    @Test
    public void test_addLNControlPoint_00004() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , true
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no LN Control Point data", exception.getMessage());
    }

    @Test
    public void test_addLNControlPoint_00005() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , true
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no LN Control Point data", exception.getMessage());
    }

    @Test
    public void test_addLNControlPoint_00006() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Navigation navigation = new Navigation(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        ClientCharacteristicConfiguration navigationClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .addNavigation(navigation, navigationClientCharacteristicConfiguration)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no LN Control Point data", exception.getMessage());
    }

    @Test
    public void test_addLNControlPoint_00101() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        int lnControlPointResponseCode = 1;
        long lnControlPointDelay = 2;

        ClientCharacteristicConfiguration lnControlPointClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        int lnControlPointClientCharacteristicConfigurationResponseCode = 3;
        long lnControlPointClientCharacteristicConfigurationDelay = 4;

        LNControlPoint resultLnControlPoint = new LNControlPoint(LNControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], LNControlPoint.OP_CODES_RESPONSE_CODE, LNControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            LocationAndNavigationServiceMockCallback locationAndNavigationServiceMockCallback = new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .addLNControlPoint(lnControlPointResponseCode
                            , lnControlPointDelay
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , lnControlPointClientCharacteristicConfigurationResponseCode
                            , lnControlPointClientCharacteristicConfigurationDelay
                            , lnControlPointClientCharacteristicConfiguration.getBytes())
                    .build();
            locationAndNavigationServiceMockCallback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LN_CONTROL_POINT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(LN_CONTROL_POINT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(resultLnControlPoint.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(locationAndSpeedClientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeLNControlPoint_00001() {
        LNFeature lnFeature = new LNFeature(false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , true
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
                , false
        );

        LocationAndSpeed locationAndSpeed = new LocationAndSpeed(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
        );

        ClientCharacteristicConfiguration locationAndSpeedClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        Navigation navigation = new Navigation(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);
        int navigationResponseCode = 1;
        long navigationDelay = 2;
        int navigationNotificationCount = 3;

        ClientCharacteristicConfiguration navigationClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        int navigationClientCharacteristicConfigurationResponseCode = 4;
        long navigationClientCharacteristicConfigurationDelay = 5;

        int lnControlPointResponseCode = 1;
        long lnControlPointDelay = 2;

        ClientCharacteristicConfiguration lnControlPointClientCharacteristicConfiguration = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
        int lnControlPointClientCharacteristicConfigurationResponseCode = 3;
        long lnControlPointClientCharacteristicConfigurationDelay = 4;

        Exception exception = null;
        try {
            new LocationAndNavigationServiceMockCallback.Builder<>()
                    .addLNFeature(lnFeature)
                    .addLocationAndSpeed(locationAndSpeed, locationAndSpeedClientCharacteristicConfiguration)
                    .addNavigation(navigationResponseCode, navigationDelay, navigation.getBytes(), navigationNotificationCount, navigationClientCharacteristicConfigurationResponseCode, navigationClientCharacteristicConfigurationDelay, navigationClientCharacteristicConfiguration.getBytes())
                    .addLNControlPoint(lnControlPointResponseCode
                            , lnControlPointDelay
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , new byte[0]
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , LNControlPoint.RESPONSE_VALUE_SUCCESS
                            , lnControlPointClientCharacteristicConfigurationResponseCode
                            , lnControlPointClientCharacteristicConfigurationDelay
                            , lnControlPointClientCharacteristicConfiguration.getBytes())
                    .removeLNControlPoint()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no LN Control Point data", exception.getMessage());
    }

}
