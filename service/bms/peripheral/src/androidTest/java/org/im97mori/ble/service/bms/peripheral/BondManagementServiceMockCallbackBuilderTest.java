package org.im97mori.ble.service.bms.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Build;

import org.im97mori.ble.characteristic.u2aa5.BondManagementFeatures;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.BOND_MANAGEMENT_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.BOND_MANAGEMENT_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import androidx.test.filters.RequiresDevice;
import androidx.test.filters.SdkSuppress;

public class BondManagementServiceMockCallbackBuilderTest extends AbstractPeripherallTest {

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00001() {
        Exception exception = null;
        try {
            new BondManagementServiceMockCallback.Builder<>()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Bond Management Feature data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00101() {
        Exception exception = null;
        try {
            new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementControlPoint(0
                            , 1
                            , "2"
                            , 3
                            , "4"
                            , 5
                            , "6"
                            , 7
                            , "8"
                            , 9
                            , "11"
                            , 12
                            , "13"
                            , 14
                            , "15"
                            , 16
                            , "17"
                            , 18
                            , "19")
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Bond Management Feature data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00201() {
        Exception exception = null;
        try {
            new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementFeatures(new byte[3])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Bond Management Control Point data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00301() {
        Exception exception = null;
        try {
            new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementControlPoint(0
                            , 1
                            , "a"
                            , 3
                            , "4"
                            , 5
                            , "6"
                            , 7
                            , "8"
                            , 9
                            , "11"
                            , 12
                            , "13"
                            , 14
                            , "15"
                            , 16
                            , "17"
                            , 18
                            , "19")
                    .addBondManagementFeatures(new byte[3])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Delete bond of requesting device (BR/EDR and LE)'s Authorization Code is not digit", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00302() {
        Exception exception = null;
        try {
            new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementControlPoint(0
                            , 1
                            , "2"
                            , 3
                            , "a"
                            , 5
                            , "6"
                            , 7
                            , "8"
                            , 9
                            , "11"
                            , 12
                            , "13"
                            , 14
                            , "15"
                            , 16
                            , "17"
                            , 18
                            , "19")
                    .addBondManagementFeatures(new byte[3])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Delete bond of requesting device (BR/EDR transport only)'s Authorization Code is not digit", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00303() {
        Exception exception = null;
        try {
            new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementControlPoint(0
                            , 1
                            , "2"
                            , 3
                            , "4"
                            , 5
                            , "a"
                            , 7
                            , "8"
                            , 9
                            , "11"
                            , 12
                            , "13"
                            , 14
                            , "15"
                            , 16
                            , "17"
                            , 18
                            , "19")
                    .addBondManagementFeatures(new byte[3])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Delete bond of requesting device (LE transport only)'s Authorization Code is not digit", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00304() {
        Exception exception = null;
        try {
            new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementControlPoint(0
                            , 1
                            , "2"
                            , 3
                            , "4"
                            , 5
                            , "6"
                            , 7
                            , "a"
                            , 9
                            , "11"
                            , 12
                            , "13"
                            , 14
                            , "15"
                            , 16
                            , "17"
                            , 18
                            , "19")
                    .addBondManagementFeatures(new byte[3])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Delete all bonds on server (BR/EDR and LE)'s Authorization Code is not digit", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00305() {
        Exception exception = null;
        try {
            new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementControlPoint(0
                            , 1
                            , "2"
                            , 3
                            , "4"
                            , 5
                            , "6"
                            , 7
                            , "8"
                            , 9
                            , "a"
                            , 12
                            , "13"
                            , 14
                            , "15"
                            , 16
                            , "17"
                            , 18
                            , "19")
                    .addBondManagementFeatures(new byte[3])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Delete all bonds on server (BR/EDR transport only)'s Authorization Code is not digit", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00306() {
        Exception exception = null;
        try {
            new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementControlPoint(0
                            , 1
                            , "2"
                            , 3
                            , "4"
                            , 5
                            , "6"
                            , 7
                            , "8"
                            , 9
                            , "11"
                            , 12
                            , "a"
                            , 14
                            , "15"
                            , 16
                            , "17"
                            , 18
                            , "19")
                    .addBondManagementFeatures(new byte[3])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Delete all bonds on server (LE transport only)'s Authorization Code is not digit", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00307() {
        Exception exception = null;
        try {
            new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementControlPoint(0
                            , 1
                            , "2"
                            , 3
                            , "4"
                            , 5
                            , "6"
                            , 7
                            , "8"
                            , 9
                            , "11"
                            , 12
                            , "13"
                            , 14
                            , "a"
                            , 16
                            , "17"
                            , 18
                            , "19")
                    .addBondManagementFeatures(new byte[3])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Delete all but the active bond on server (BR/EDR and LE)'s Authorization Code is not digit", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00308() {
        Exception exception = null;
        try {
            new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementControlPoint(0
                            , 1
                            , "2"
                            , 3
                            , "4"
                            , 5
                            , "6"
                            , 7
                            , "8"
                            , 9
                            , "11"
                            , 12
                            , "13"
                            , 14
                            , "15"
                            , 16
                            , "a"
                            , 18
                            , "19")
                    .addBondManagementFeatures(new byte[3])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Delete all but the active bond on server (BR/EDR transport only)'s Authorization Code", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_exception_00309() {
        Exception exception = null;
        try {
            new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementControlPoint(0
                            , 1
                            , "2"
                            , 3
                            , "4"
                            , 5
                            , "6"
                            , 7
                            , "8"
                            , 9
                            , "11"
                            , 12
                            , "13"
                            , 14
                            , "15"
                            , 16
                            , "17"
                            , 18
                            , "a")
                    .addBondManagementFeatures(new byte[3])
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Delete all but the active bond on server (LE transport only)'s Authorization Code", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBondManagementControlPoint_00001() {

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);
        Exception exception = null;
        try {
            BondManagementServiceMockCallback callback = new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementFeatures(new BondManagementFeatures(new byte[3]))
                    .addBondManagementControlPoint(0
                            , 1
                            , "2"
                            , 3
                            , "4"
                            , 5
                            , "6"
                            , 7
                            , "8"
                            , 9
                            , "11"
                            , 12
                            , "13"
                            , 14
                            , "15"
                            , 16
                            , "17"
                            , 18
                            , "19")
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BOND_MANAGEMENT_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(null, bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeBondManagementControlPoint_00001() {
        Exception exception = null;
        try {
            new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementFeatures(new BondManagementFeatures(new byte[3]))
                    .addBondManagementControlPoint(0
                            , 1
                            , "2"
                            , 3
                            , "4"
                            , 5
                            , "6"
                            , 7
                            , "8"
                            , 9
                            , "11"
                            , 12
                            , "13"
                            , 14
                            , "15"
                            , 16
                            , "17"
                            , 18
                            , "19")
                    .removeBondManagementControlPoint()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Bond Management Control Point data", exception.getMessage());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBondManagementFeatures_00001() {
        BondManagementFeatures bondManagementFeatures = new BondManagementFeatures(new byte[3]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BondManagementServiceMockCallback callback = new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementFeatures(bondManagementFeatures)
                    .addBondManagementControlPoint(0
                            , 1
                            , "2"
                            , 3
                            , "4"
                            , 5
                            , "6"
                            , 7
                            , "8"
                            , 9
                            , "11"
                            , 12
                            , "13"
                            , 14
                            , "15"
                            , 16
                            , "17"
                            , 18
                            , "19")
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BOND_MANAGEMENT_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(bondManagementFeatures.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBondManagementFeatures_00002() {
        BondManagementFeatures bondManagementFeatures = new BondManagementFeatures(new byte[3]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BondManagementServiceMockCallback callback = new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementFeatures(bondManagementFeatures.getBytes())
                    .addBondManagementControlPoint(0
                            , 1
                            , "2"
                            , 3
                            , "4"
                            , 5
                            , "6"
                            , 7
                            , "8"
                            , 9
                            , "11"
                            , 12
                            , "13"
                            , 14
                            , "15"
                            , 16
                            , "17"
                            , 18
                            , "19")
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BOND_MANAGEMENT_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(bondManagementFeatures.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_addBondManagementFeatures_00003() {
        BondManagementFeatures bondManagementFeatures = new BondManagementFeatures(new byte[3]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            BondManagementServiceMockCallback callback = new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementFeatures(BluetoothGatt.GATT_SUCCESS, 0, bondManagementFeatures.getBytes())
                    .addBondManagementControlPoint(0
                            , 1
                            , "2"
                            , 3
                            , "4"
                            , 5
                            , "6"
                            , 7
                            , "8"
                            , 9
                            , "11"
                            , 12
                            , "13"
                            , 14
                            , "15"
                            , 16
                            , "17"
                            , 18
                            , "19")
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(BOND_MANAGEMENT_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(bondManagementFeatures.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    @RequiresDevice
    @SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP)
    public void test_removeBondManagementFeatures_00001() {
        Exception exception = null;
        try {
            new BondManagementServiceMockCallback.Builder<>()
                    .addBondManagementFeatures(new BondManagementFeatures(new byte[3]))
                    .addBondManagementControlPoint(0
                            , 1
                            , "2"
                            , 3
                            , "4"
                            , 5
                            , "6"
                            , 7
                            , "8"
                            , 9
                            , "11"
                            , 12
                            , "13"
                            , 14
                            , "15"
                            , 16
                            , "17"
                            , 18
                            , "19")
                    .removeBondManagementFeatures()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Bond Management Feature data", exception.getMessage());
    }

}
