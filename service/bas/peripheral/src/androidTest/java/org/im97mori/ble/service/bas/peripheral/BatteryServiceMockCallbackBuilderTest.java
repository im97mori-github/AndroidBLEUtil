package org.im97mori.ble.service.bas.peripheral;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Build;

import org.im97mori.ble.characteristic.u2a19.BatteryLevel;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormat;
import org.im97mori.ble.test.peripheral.AbstractPeripheralTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.BATTERY_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

public class BatteryServiceMockCallbackBuilderTest extends AbstractPeripheralTest {

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBatteryLevel_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> builder = new BatteryServiceMockCallback.Builder<>();
        BatteryServiceMockCallback callback = builder.build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertTrue(bluetoothGattServiceList.isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBatteryLevel_00101() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();

        int index1 = 1;
        BatteryLevel batteryLevel1 = new BatteryLevel(50);
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> builder = new BatteryServiceMockCallback.Builder<>();
        BatteryServiceMockCallback callback = builder.addBatteryLevel(index1, batteryLevel1)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(batteryLevel1.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBatteryLevel_00102() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        BatteryLevel batteryLevel1 = new BatteryLevel(50);
        BatteryLevel batteryLevel2 = new BatteryLevel(90);
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(1, batteryLevel1)
                .addBatteryLevel(11, batteryLevel2)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(2, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(batteryLevel1.getBytes(), bluetoothGattCharacteristic.getValue());
        bluetoothGattCharacteristic = bluetoothGattServiceList.get(1).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(batteryLevel2.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBatteryLevel_00201() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int property1 = 2;
        byte[] data1 = new byte[]{5};
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> builder = new BatteryServiceMockCallback.Builder<>();
        BatteryServiceMockCallback callback = builder.addBatteryLevel(1, property1, 3, 4, data1, 6)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(property1, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(data1, bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBatteryLevel_00202() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int property1 = 2;
        byte[] data1 = new byte[]{5};
        int property2 = 22;
        byte[] data2 = new byte[]{55};
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(1, property1, 3, 4, data1, 6)
                .addBatteryLevel(11, property2, 33, 44, data2, 66)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(2, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(property1, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(data1, bluetoothGattCharacteristic.getValue());
        bluetoothGattCharacteristic = bluetoothGattServiceList.get(1).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(property2, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(data2, bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeBatteryLevel_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        int property1 = 2;
        byte[] data1 = new byte[]{5};
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, property1, 3, 4, data1, 6)
                .removeBatteryLevel(index1)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertTrue(bluetoothGattServiceList.isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeBatteryLevel_00002() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        int property1 = 2;
        byte[] data1 = new byte[]{5};
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, property1, 3, 4, data1, 6)
                .removeBatteryLevel(index1 + 1)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertFalse(bluetoothGattServiceList.isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setBatteryLevelCharacteristicPresentationFormat_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(4, 5, 6, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{7, 8});
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .setBatteryLevelCharacteristicPresentationFormat(index1, characteristicPresentationFormat)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertTrue(bluetoothGattCharacteristic.getDescriptors().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setBatteryLevelCharacteristicPresentationFormat_00002() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        int index2 = 11;
        CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(4, 5, 6, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{7, 8});
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .addBatteryLevel(index2, BluetoothGattCharacteristic.PROPERTY_READ, 33, 44, new byte[]{55}, 66)
                .setBatteryLevelCharacteristicPresentationFormat(index1, characteristicPresentationFormat)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(2, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicPresentationFormat.getBytes(), bluetoothGattDescriptor.getValue());

        bluetoothGattService = bluetoothGattServiceList.get(1);
        bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UTF_8_STRING, 0, 0, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{0, 0}).getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setBatteryLevelCharacteristicPresentationFormat_00101() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(4, 5, 6, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{7, 8});
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .setBatteryLevelCharacteristicPresentationFormat(index1, 2, 3, characteristicPresentationFormat.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertTrue(bluetoothGattCharacteristic.getDescriptors().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setBatteryLevelCharacteristicPresentationFormat_00102() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        int index2 = 11;
        CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(4, 5, 6, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{7, 8});
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .addBatteryLevel(index2, BluetoothGattCharacteristic.PROPERTY_READ, 33, 44, new byte[]{55}, 66)
                .setBatteryLevelCharacteristicPresentationFormat(index1, 2, 3, characteristicPresentationFormat.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(2, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(characteristicPresentationFormat.getBytes(), bluetoothGattDescriptor.getValue());

        bluetoothGattService = bluetoothGattServiceList.get(1);
        bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UTF_8_STRING, 0, 0, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{0, 0}).getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeBatteryLevelCharacteristicPresentationFormat_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        int index2 = 11;
        CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(4, 5, 6, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{7, 8});
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .addBatteryLevel(index2, BluetoothGattCharacteristic.PROPERTY_READ, 33, 44, new byte[]{55}, 66)
                .setBatteryLevelCharacteristicPresentationFormat(index1, characteristicPresentationFormat)
                .removeBatteryLevelCharacteristicPresentationFormat(index1)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(2, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UTF_8_STRING, 0, 0, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{0, 0}).getBytes(), bluetoothGattDescriptor.getValue());

        bluetoothGattService = bluetoothGattServiceList.get(1);
        bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UTF_8_STRING, 0, 0, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{0, 0}).getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setBatteryLevelClientCharacteristicConfiguration_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 3, 4, new byte[]{5}, 6)
                .setBatteryLevelClientCharacteristicConfiguration(index1, clientCharacteristicConfigurationAndroid)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setBatteryLevelClientCharacteristicConfiguration_00002() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .setBatteryLevelClientCharacteristicConfiguration(index1, clientCharacteristicConfigurationAndroid)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertTrue(bluetoothGattCharacteristic.getDescriptors().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setBatteryLevelClientCharacteristicConfiguration_00003() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .setBatteryLevelClientCharacteristicConfiguration(index1 + 1, clientCharacteristicConfigurationAndroid)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertTrue(bluetoothGattCharacteristic.getDescriptors().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setBatteryLevelClientCharacteristicConfiguration_00004() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 3, 4, new byte[]{5}, 6)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(1, bluetoothGattCharacteristic.getDescriptors().size());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setBatteryLevelClientCharacteristicConfiguration_00101() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 3, 4, new byte[]{5}, 6)
                .setBatteryLevelClientCharacteristicConfiguration(index1, 77, 88, clientCharacteristicConfigurationAndroid.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setBatteryLevelClientCharacteristicConfiguration_00102() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .setBatteryLevelClientCharacteristicConfiguration(index1, 77, 88, clientCharacteristicConfigurationAndroid.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertTrue(bluetoothGattCharacteristic.getDescriptors().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setBatteryLevelClientCharacteristicConfiguration_00103() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .setBatteryLevelClientCharacteristicConfiguration(index1 + 1, 77, 88, clientCharacteristicConfigurationAndroid.getBytes())
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertTrue(bluetoothGattCharacteristic.getDescriptors().isEmpty());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_setBatteryLevelClientCharacteristicConfiguration_00104() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 3, 4, new byte[]{5}, 6)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(1, bluetoothGattCharacteristic.getDescriptors().size());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeBatteryLevelClientCharacteristicConfiguration_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 3, 4, new byte[]{5}, 6)
                .setBatteryLevelClientCharacteristicConfiguration(index1, clientCharacteristicConfigurationAndroid)
                .removeBatteryLevelClientCharacteristicConfiguration(index1 + 1)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(1, bluetoothGattCharacteristic.getDescriptors().size());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeBatteryLevelClientCharacteristicConfiguration_00002() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 3, 4, new byte[]{5}, 6)
                .setBatteryLevelClientCharacteristicConfiguration(index1, clientCharacteristicConfigurationAndroid)
                .removeBatteryLevelClientCharacteristicConfiguration(index1)
                .build();
        callback.setup(MOCK_BLE_SERVER_CONNECTION);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(1, bluetoothGattCharacteristic.getDescriptors().size());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, bluetoothGattDescriptor.getValue());
    }

}
