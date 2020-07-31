package org.im97mori.ble.service.bas.peripheral;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.characteristic.u2a19.BatteryLevel;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormat;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BATTERY_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BatteryServiceMockCallbackBuilderTest {

    @Test
    public void test_addBatteryLevel_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> builder = new BatteryServiceMockCallback.Builder<>();
        BatteryServiceMockCallback callback = builder.build();
        callback.setup(mockBLEServerConnection);

        assertTrue(bluetoothGattServiceList.isEmpty());
    }

    @Test
    public void test_addBatteryLevel_00101() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();

        int index1 = 1;
        BatteryLevel batteryLevel1 = new BatteryLevel(50);
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> builder = new BatteryServiceMockCallback.Builder<>();
        BatteryServiceMockCallback callback = builder.addBatteryLevel(index1, batteryLevel1)
                .build();
        callback.setup(mockBLEServerConnection);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(batteryLevel1.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addBatteryLevel_00102() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        BatteryLevel batteryLevel1 = new BatteryLevel(50);
        BatteryLevel batteryLevel2 = new BatteryLevel(90);
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(1, batteryLevel1)
                .addBatteryLevel(11, batteryLevel2)
                .build();
        callback.setup(mockBLEServerConnection);

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
    public void test_addBatteryLevel_00201() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int property1 = 2;
        byte[] data1 = new byte[]{5};
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback.Builder<BatteryServiceMockCallback> builder = new BatteryServiceMockCallback.Builder<>();
        BatteryServiceMockCallback callback = builder.addBatteryLevel(1, property1, 3, 4, data1, 6)
                .build();
        callback.setup(mockBLEServerConnection);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(property1, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(data1, bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addBatteryLevel_00202() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int property1 = 2;
        byte[] data1 = new byte[]{5};
        int property2 = 22;
        byte[] data2 = new byte[]{55};
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(1, property1, 3, 4, data1, 6)
                .addBatteryLevel(11, property2, 33, 44, data2, 66)
                .build();
        callback.setup(mockBLEServerConnection);

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
    public void test_removeBatteryLevel_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        int property1 = 2;
        byte[] data1 = new byte[]{5};
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, property1, 3, 4, data1, 6)
                .removeBatteryLevel(index1)
                .build();
        callback.setup(mockBLEServerConnection);

        assertTrue(bluetoothGattServiceList.isEmpty());
    }

    @Test
    public void test_removeBatteryLevel_00002() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        int property1 = 2;
        byte[] data1 = new byte[]{5};
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, property1, 3, 4, data1, 6)
                .removeBatteryLevel(index1 + 1)
                .build();
        callback.setup(mockBLEServerConnection);

        assertFalse(bluetoothGattServiceList.isEmpty());
    }

    @Test
    public void test_setCharacteristicPresentationFormat_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(4, 5, 6, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{7, 8});
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .setCharacteristicPresentationFormat(index1, characteristicPresentationFormat)
                .build();
        callback.setup(mockBLEServerConnection);

        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertTrue(bluetoothGattCharacteristic.getDescriptors().isEmpty());
    }

    @Test
    public void test_setCharacteristicPresentationFormat_00002() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        int index2 = 11;
        CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(4, 5, 6, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{7, 8});
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .addBatteryLevel(index2, BluetoothGattCharacteristic.PROPERTY_READ, 33, 44, new byte[]{55}, 66)
                .setCharacteristicPresentationFormat(index1, characteristicPresentationFormat)
                .build();
        callback.setup(mockBLEServerConnection);

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
    public void test_setCharacteristicPresentationFormat_00101() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(4, 5, 6, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{7, 8});
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .setCharacteristicPresentationFormat(index1, 2, 3, characteristicPresentationFormat.getBytes())
                .build();
        callback.setup(mockBLEServerConnection);

        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertTrue(bluetoothGattCharacteristic.getDescriptors().isEmpty());
    }

    @Test
    public void test_setCharacteristicPresentationFormat_00102() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        int index2 = 11;
        CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(4, 5, 6, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{7, 8});
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .addBatteryLevel(index2, BluetoothGattCharacteristic.PROPERTY_READ, 33, 44, new byte[]{55}, 66)
                .setCharacteristicPresentationFormat(index1, 2, 3, characteristicPresentationFormat.getBytes())
                .build();
        callback.setup(mockBLEServerConnection);

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
    public void test_removeCharacteristicPresentationFormat_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        int index2 = 11;
        CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(4, 5, 6, CharacteristicPresentationFormat.NAMESPACE_BLUETOOTH_SIG_ASSIGNED_NUMBERS, new byte[]{7, 8});
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .addBatteryLevel(index2, BluetoothGattCharacteristic.PROPERTY_READ, 33, 44, new byte[]{55}, 66)
                .setCharacteristicPresentationFormat(index1, characteristicPresentationFormat)
                .removeCharacteristicPresentationFormat(index1)
                .build();
        callback.setup(mockBLEServerConnection);

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
    public void test_setClientCharacteristicConfiguration_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 3, 4, new byte[]{5}, 6)
                .setClientCharacteristicConfiguration(index1, clientCharacteristicConfigurationAndroid)
                .build();
        callback.setup(mockBLEServerConnection);

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
    public void test_setClientCharacteristicConfiguration_00002() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .setClientCharacteristicConfiguration(index1, clientCharacteristicConfigurationAndroid)
                .build();
        callback.setup(mockBLEServerConnection);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertTrue(bluetoothGattCharacteristic.getDescriptors().isEmpty());
    }

    @Test
    public void test_setClientCharacteristicConfiguration_00003() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .setClientCharacteristicConfiguration(index1 + 1, clientCharacteristicConfigurationAndroid)
                .build();
        callback.setup(mockBLEServerConnection);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertTrue(bluetoothGattCharacteristic.getDescriptors().isEmpty());
    }

    @Test
    public void test_setClientCharacteristicConfiguration_00004() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 3, 4, new byte[]{5}, 6)
                .build();
        callback.setup(mockBLEServerConnection);

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
    public void test_setClientCharacteristicConfiguration_00101() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 3, 4, new byte[]{5}, 6)
                .setClientCharacteristicConfiguration(index1, 77, 88, clientCharacteristicConfigurationAndroid.getBytes())
                .build();
        callback.setup(mockBLEServerConnection);

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
    public void test_setClientCharacteristicConfiguration_00102() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .setClientCharacteristicConfiguration(index1, 77, 88, clientCharacteristicConfigurationAndroid.getBytes())
                .build();
        callback.setup(mockBLEServerConnection);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertTrue(bluetoothGattCharacteristic.getDescriptors().isEmpty());
    }

    @Test
    public void test_setClientCharacteristicConfiguration_00103() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ, 3, 4, new byte[]{5}, 6)
                .setClientCharacteristicConfiguration(index1 + 1, 77, 88, clientCharacteristicConfigurationAndroid.getBytes())
                .build();
        callback.setup(mockBLEServerConnection);

        assertEquals(1, bluetoothGattServiceList.size());
        assertEquals(1, bluetoothGattServiceList.get(0).getCharacteristics().size());
        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattServiceList.get(0).getCharacteristic(BATTERY_LEVEL_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertTrue(bluetoothGattCharacteristic.getDescriptors().isEmpty());
    }

    @Test
    public void test_setClientCharacteristicConfiguration_00104() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 3, 4, new byte[]{5}, 6)
                .build();
        callback.setup(mockBLEServerConnection);

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
    public void test_removeClientCharacteristicConfiguration_00001() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 3, 4, new byte[]{5}, 6)
                .setClientCharacteristicConfiguration(index1, clientCharacteristicConfigurationAndroid)
                .removeClientCharacteristicConfiguration(index1 + 1)
                .build();
        callback.setup(mockBLEServerConnection);

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
    public void test_removeClientCharacteristicConfiguration_00002() {
        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        int index1 = 1;
        ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid = ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        MockBLEServerConnection mockBLEServerConnection = new MockBLEServerConnection() {
            @Override
            public synchronized Integer createAddServiceTask(@NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument, @Nullable BLEServerCallback bleServerCallback) {
                bluetoothGattServiceList.add(bluetoothGattService);
                return null;
            }
        };
        BatteryServiceMockCallback callback = new BatteryServiceMockCallback.Builder<>()
                .addBatteryLevel(index1, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 3, 4, new byte[]{5}, 6)
                .setClientCharacteristicConfiguration(index1, clientCharacteristicConfigurationAndroid)
                .removeClientCharacteristicConfiguration(index1)
                .build();
        callback.setup(mockBLEServerConnection);

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
