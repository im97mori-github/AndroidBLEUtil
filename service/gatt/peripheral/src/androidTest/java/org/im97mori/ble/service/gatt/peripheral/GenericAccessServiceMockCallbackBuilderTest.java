package org.im97mori.ble.service.gatt.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Build;

import org.im97mori.ble.characteristic.u2a00.DeviceName;
import org.im97mori.ble.characteristic.u2a01.Appearance;
import org.im97mori.ble.characteristic.u2a02.PeripheralPrivacyFlag;
import org.im97mori.ble.characteristic.u2a04.PeripheralPreferredConnectionParameters;
import org.im97mori.ble.characteristic.u2aa6.CentralAddressResolution;
import org.im97mori.ble.characteristic.u2ac9.ResolvablePrivateAddressOnly;
import org.im97mori.ble.characteristic.u2b88.EncryptedDataKeyMaterial;
import org.im97mori.ble.characteristic.u2bf5.LeGattSecurityLevels;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.test.peripheral.AbstractPeripheralTest;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.APPEARANCE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DEVICE_NAME_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ENCRYPTED_DATA_KEY_MATERIAL_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LE_GATT_SECURITY_LEVELS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RECONNECTION_ADDRESS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

public class GenericAccessServiceMockCallbackBuilderTest extends AbstractPeripheralTest {

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00001() {
        Exception exception = null;
        try {
            new GenericAccessServiceMockCallback.Builder<>()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Device Name data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00002() {
        Exception exception = null;
        try {
            new GenericAccessServiceMockCallback.Builder<>()
                    .addDeviceName(new DeviceName(""))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Appearance data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00003() {
        Exception exception = null;
        try {
            new GenericAccessServiceMockCallback.Builder<>()
                    .addDeviceName(new DeviceName(""))
                    .addAppearance(new Appearance(new byte[]{1, 2}))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDeviceName_00001() {
        String deviceName = "deviceName";
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName(deviceName));
        builder.addAppearance(new Appearance(new byte[2]));
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DEVICE_NAME_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDeviceName_00002() {
        String deviceName = "deviceName";
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(deviceName.getBytes());
        builder.addAppearance(new Appearance(new byte[2]));
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DEVICE_NAME_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDeviceName_00003() {
        String deviceName = "deviceName";
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(false, 0, 0, deviceName.getBytes());
        builder.addAppearance(new Appearance(new byte[2]));
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DEVICE_NAME_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addDeviceName_00004() {
        String deviceName = "deviceName";
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(true, 0, 0, deviceName.getBytes());
        builder.addAppearance(new Appearance(new byte[2]));
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DEVICE_NAME_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeDeviceName_00001() {
        String deviceName = "deviceName";

        Exception exception = null;
        try {
            new GenericAccessServiceMockCallback.Builder<>()
                    .addDeviceName(new DeviceName(deviceName))
                    .removeDeviceName()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Device Name data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAppearance_00001() {
        byte[] data = new byte[]{0, 1};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(data));
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(APPEARANCE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAppearance_00002() {
        byte[] data = new byte[]{0, 1};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(data);
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(APPEARANCE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAppearance_00003() {
        byte[] data = new byte[]{0, 1};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(false, 0, 0, data);
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(APPEARANCE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addAppearance_00004() {
        byte[] data = new byte[]{0, 1};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(true, 0, 0, data);
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(APPEARANCE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeAppearance_00001() {
        byte[] data = new byte[]{0, 1};

        Exception exception = null;
        try {
            new GenericAccessServiceMockCallback.Builder<>()
                    .addDeviceName(new DeviceName("deviceName"))
                    .addAppearance(new Appearance(data))
                    .removeAppearance()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Appearance data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addPeripheralPreferredConnectionParameters_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addPeripheralPreferredConnectionParameters_00002() {
        byte[] data = new byte[]{0, 1, 2, 3, 4, 5, 6, 7};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addPeripheralPreferredConnectionParameters(new PeripheralPreferredConnectionParameters(data));
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addPeripheralPreferredConnectionParameters_00003() {
        byte[] data = new byte[]{0, 1, 2, 3, 4, 5, 6, 7};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addPeripheralPreferredConnectionParameters(data);
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addPeripheralPreferredConnectionParameters_00004() {
        byte[] data = new byte[]{0, 1, 2, 3, 4, 5, 6, 7};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addPeripheralPreferredConnectionParameters(BluetoothGatt.GATT_SUCCESS, 0, data);
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removePeripheralPreferredConnectionParameters_00001() {
        byte[] data = new byte[]{0, 1, 2, 3, 4, 5, 6, 7};

        Exception exception = null;
        try {
            new GenericAccessServiceMockCallback.Builder<>()
                    .addDeviceName(new DeviceName("deviceName"))
                    .addAppearance(new Appearance(new byte[]{0, 1}))
                    .addPeripheralPreferredConnectionParameters(new PeripheralPreferredConnectionParameters(data))
                    .removePeripheralPreferredConnectionParameters()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addCentralAddressResolution_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addCentralAddressResolution_00002() {
        byte[] data = new byte[]{1};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addCentralAddressResolution(new CentralAddressResolution(data));
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addCentralAddressResolution_00003() {
        byte[] data = new byte[]{1};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addCentralAddressResolution(data);
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addCentralAddressResolution_00004() {
        byte[] data = new byte[]{1};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addCentralAddressResolution(BluetoothGatt.GATT_SUCCESS, 0, data);
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CENTRAL_ADDRESS_RESOLUTION_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeCentralAddressResolution_00001() {
        byte[] data = new byte[]{1};

        Exception exception = null;
        try {
            new GenericAccessServiceMockCallback.Builder<>()
                    .addDeviceName(new DeviceName("deviceName"))
                    .addAppearance(new Appearance(new byte[]{0, 1}))
                    .addCentralAddressResolution(new CentralAddressResolution(data))
                    .removeCentralAddressResolution()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addResolvablePrivateAddressOnly_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addResolvablePrivateAddressOnly_00002() {
        byte[] data = new byte[]{1};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addResolvablePrivateAddressOnly(new ResolvablePrivateAddressOnly(data));
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addResolvablePrivateAddressOnly_00003() {
        byte[] data = new byte[]{1};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addResolvablePrivateAddressOnly(data);
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addResolvablePrivateAddressOnly_00004() {
        byte[] data = new byte[]{1};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addResolvablePrivateAddressOnly(BluetoothGatt.GATT_SUCCESS, 0, data);
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RESOLVABLE_PRIVATE_ADDRESS_ONLY_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeResolvablePrivateAddressOnly_00001() {
        byte[] data = new byte[]{1};

        Exception exception = null;
        try {
            new GenericAccessServiceMockCallback.Builder<>()
                    .addDeviceName(new DeviceName("deviceName"))
                    .addAppearance(new Appearance(new byte[]{0, 1}))
                    .addResolvablePrivateAddressOnly(new ResolvablePrivateAddressOnly(data))
                    .removeResolvablePrivateAddressOnly()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addReconnectionAddress_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addReconnectionAddress(BluetoothGatt.GATT_SUCCESS, 0);
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RECONNECTION_ADDRESS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeReconnectionAddress_00001() {
        Exception exception = null;
        try {
            new GenericAccessServiceMockCallback.Builder<>()
                    .addDeviceName(new DeviceName("deviceName"))
                    .addAppearance(new Appearance(new byte[]{0, 1}))
                    .addReconnectionAddress(BluetoothGatt.GATT_SUCCESS, 0)
                    .removeReconnectionAddress()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addPeripheralPrivacyFlag_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addPeripheralPrivacyFlag_00002() {
        byte[] data = new byte[]{0};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addPeripheralPrivacyFlag(new PeripheralPrivacyFlag(data));
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addPeripheralPrivacyFlag_00003() {
        byte[] data = new byte[]{0};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addPeripheralPrivacyFlag(data);
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addPeripheralPrivacyFlag_00004() {
        byte[] data = new byte[]{0};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addPeripheralPrivacyFlag(false, BluetoothGatt.GATT_SUCCESS, 0, data);
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addPeripheralPrivacyFlag_00005() {
        byte[] data = new byte[]{0};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addPeripheralPrivacyFlag(true, BluetoothGatt.GATT_SUCCESS, 0, data);
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(PERIPHERAL_PRIVACY_FLAG_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removePeripheralPrivacyFlag_00001() {
        byte[] data = new byte[]{0};

        Exception exception = null;
        try {
            new GenericAccessServiceMockCallback.Builder<>()
                    .addDeviceName(new DeviceName("deviceName"))
                    .addAppearance(new Appearance(new byte[]{0, 1}))
                    .addPeripheralPrivacyFlag(new PeripheralPrivacyFlag(data))
                    .removePeripheralPrivacyFlag()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addEncryptedDataKeyMaterial_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ENCRYPTED_DATA_KEY_MATERIAL_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addEncryptedDataKeyMaterial_00002() {
        byte[] data = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));

        EncryptedDataKeyMaterial encryptedDataKeyMaterial = new EncryptedDataKeyMaterial(data);
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        builder.addEncryptedDataKeyMaterial(encryptedDataKeyMaterial, clientCharacteristicConfiguration);
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ENCRYPTED_DATA_KEY_MATERIAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addEncryptedDataKeyMaterial_00003() {
        byte[] data = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));

        EncryptedDataKeyMaterial encryptedDataKeyMaterial = new EncryptedDataKeyMaterial(data);
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        builder.addEncryptedDataKeyMaterial(BluetoothGatt.GATT_SUCCESS, 0, encryptedDataKeyMaterial.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ENCRYPTED_DATA_KEY_MATERIAL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeEncryptedDataKeyMaterial_00001() {
        byte[] data = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};

        EncryptedDataKeyMaterial encryptedDataKeyMaterial = new EncryptedDataKeyMaterial(data);
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Exception exception = null;
        try {
            new GenericAccessServiceMockCallback.Builder<>()
                    .addDeviceName(new DeviceName("deviceName"))
                    .addAppearance(new Appearance(new byte[]{0, 1}))
                    .addEncryptedDataKeyMaterial(encryptedDataKeyMaterial, clientCharacteristicConfiguration)
                    .removeEncryptedDataKeyMaterial()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addLeGattSecurityLevels_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LE_GATT_SECURITY_LEVELS_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addLeGattSecurityLevels_00002() {
        byte[] data = new byte[]{0};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addLeGattSecurityLevels(new LeGattSecurityLevels(data));
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LE_GATT_SECURITY_LEVELS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addLeGattSecurityLevels_00003() {
        byte[] data = new byte[]{0};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addLeGattSecurityLevels(data);
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LE_GATT_SECURITY_LEVELS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addLeGattSecurityLevels_00004() {
        byte[] data = new byte[]{0};
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        GenericAccessServiceMockCallback.Builder<GenericAccessServiceMockCallback> builder = new GenericAccessServiceMockCallback.Builder<>();
        builder.addDeviceName(new DeviceName("deviceName"));
        builder.addAppearance(new Appearance(new byte[]{0, 1}));
        builder.addLeGattSecurityLevels(BluetoothGatt.GATT_SUCCESS, 0, data);
        GenericAccessServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);


        assertEquals(GENERIC_ACCESS_SERVICE, bluetoothGattService.getUuid());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LE_GATT_SECURITY_LEVELS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeLeGattSecurityLevels_00001() {
        byte[] data = new byte[]{0};

        Exception exception = null;
        try {
            new GenericAccessServiceMockCallback.Builder<>()
                    .addDeviceName(new DeviceName("deviceName"))
                    .addAppearance(new Appearance(new byte[]{0, 1}))
                    .addLeGattSecurityLevels(new LeGattSecurityLevels(data))
                    .removeLeGattSecurityLevels()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

}
