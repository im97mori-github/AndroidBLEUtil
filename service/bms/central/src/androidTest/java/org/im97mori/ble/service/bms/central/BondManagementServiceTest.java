package org.im97mori.ble.service.bms.central;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2aa4.BondManagementControlPoint;
import org.im97mori.ble.characteristic.u2aa4.BondManagementControlPointAndroid;
import org.im97mori.ble.characteristic.u2aa5.BondManagementFeaturesAndroid;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.constants.CharacteristicUUID.BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.BOND_MANAGEMENT_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.BOND_MANAGEMENT_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class BondManagementServiceTest extends AbstractCentralTest {

    @Test
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BOND_MANAGEMENT_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BOND_MANAGEMENT_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[3];
        final Bundle originalBundle = new Bundle();
        MockBondManagementServiceCallback mockBondManagementServiceCallback = new MockBondManagementServiceCallback() {

            @Override
            public void onBondManagementFeaturesReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull BondManagementFeaturesAndroid bondManagementFeaturesAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, bondManagementFeaturesAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BondManagementService bondManagementService = new BondManagementService(MOCK_BLE_CONNECTION, mockBondManagementServiceCallback, null);
        bondManagementService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BOND_MANAGEMENT_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BOND_MANAGEMENT_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBondManagementServiceCallback mockBondManagementServiceCallback = new MockBondManagementServiceCallback() {

            @Override
            public void onBondManagementFeaturesReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        BondManagementService bondManagementService = new BondManagementService(MOCK_BLE_CONNECTION, mockBondManagementServiceCallback, null);
        bondManagementService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BOND_MANAGEMENT_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BOND_MANAGEMENT_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBondManagementServiceCallback mockBondManagementServiceCallback = new MockBondManagementServiceCallback() {

            @Override
            public void onBondManagementFeaturesReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        BondManagementService bondManagementService = new BondManagementService(MOCK_BLE_CONNECTION, mockBondManagementServiceCallback, null);
        bondManagementService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BOND_MANAGEMENT_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new BondManagementControlPoint(BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_BR_EDR_LE, "a").getBytes();
        final Bundle originalBundle = new Bundle();
        MockBondManagementServiceCallback mockBondManagementServiceCallback = new MockBondManagementServiceCallback() {

            @Override
            public void onBondManagementControlPointWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull BondManagementControlPointAndroid bondManagementControlPointAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, bondManagementControlPointAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        BondManagementService bondManagementService = new BondManagementService(MOCK_BLE_CONNECTION, mockBondManagementServiceCallback, null);
        bondManagementService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BOND_MANAGEMENT_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBondManagementServiceCallback mockBondManagementServiceCallback = new MockBondManagementServiceCallback() {

            @Override
            public void onBondManagementControlPointWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
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
        BondManagementService bondManagementService = new BondManagementService(MOCK_BLE_CONNECTION, mockBondManagementServiceCallback, null);
        bondManagementService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = BOND_MANAGEMENT_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBondManagementServiceCallback mockBondManagementServiceCallback = new MockBondManagementServiceCallback() {

            @Override
            public void onBondManagementControlPointWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
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
        BondManagementService bondManagementService = new BondManagementService(MOCK_BLE_CONNECTION, mockBondManagementServiceCallback, null);
        bondManagementService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_getBondManagementFeatures_000001() {
        BondManagementService bondManagementService = new BondManagementService(MOCK_BLE_CONNECTION, new MockBondManagementServiceCallback(), null);

        assertNull(bondManagementService.getBondManagementFeatures());
    }


    @Test
    public void test_getBondManagementFeatures_000002() {
        BondManagementService bondManagementService = new BondManagementService(MOCK_BLE_CONNECTION, new MockBondManagementServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(bondManagementService.getBondManagementFeatures());
    }

    @Test
    public void test_getBondManagementFeatures_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        BondManagementService bondManagementService = new BondManagementService(MOCK_BLE_CONNECTION, new MockBondManagementServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = bondManagementService.getBondManagementFeatures();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setBondManagementControlPoint_000001() {
        BondManagementService bondManagementService = new BondManagementService(MOCK_BLE_CONNECTION, new MockBondManagementServiceCallback(), null);

        assertNull(bondManagementService.setBondManagementControlPoint(new BondManagementControlPoint(BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_BR_EDR_LE, "a")));
    }

    @Test
    public void test_setBondManagementControlPoint_000002() {
        BondManagementService bondManagementService = new BondManagementService(MOCK_BLE_CONNECTION, new MockBondManagementServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(bondManagementService.setBondManagementControlPoint(new BondManagementControlPoint(BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_BR_EDR_LE, "a")));
    }

    @Test
    public void test_setBondManagementControlPoint_000003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        BondManagementService bondManagementService = new BondManagementService(MOCK_BLE_CONNECTION, new MockBondManagementServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = bondManagementService.setBondManagementControlPoint(new BondManagementControlPoint(BondManagementControlPoint.OP_CODE_DELETE_BOND_OF_REQUESTING_DEVICE_BR_EDR_LE, "a"));
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

}
