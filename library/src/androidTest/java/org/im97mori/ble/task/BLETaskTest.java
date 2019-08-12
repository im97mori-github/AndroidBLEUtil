package org.im97mori.ble.task;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.text.format.DateUtils;

import org.im97mori.ble.BLEConstants;
import org.im97mori.ble.BLELogUtils;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.BLESyncConnection;
import org.im97mori.ble.ByteArrayInterface;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;
import java.util.Set;

import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.DEFAULT_SERVICE_UUID;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.MESSAGE_SUCCESS;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.READABLE_CHARACTERISTIC_UUID_WITH_ERROR;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.READABLE_DESCRIPTOR_UUID_WITH_ERROR;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.UNDIFINED_CHARACTERISTIC_UUID;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.UNDIFINED_DESCRIPTOR_UUID;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.UNDIFINED_SERVICE_UUID;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.WRITABLE_CHARACTERISTIC_UUID_WITH_ERROR;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.WRITABLE_DESCRIPTOR_UUID_WITH_ERROR;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.WRITABLE_NO_RESPONSE_CHARACTERISTIC_UUID;
import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_FAILED;
import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_SUCCESS;
import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_TIMEOUT;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BLETaskTest {

    private static BLESyncConnection BLE_SYNC_CONNECTION;

    @BeforeClass
    public static void setup() {
        Context context = InstrumentationRegistry.getContext();
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();
        Set<BluetoothDevice> bluetoothDeviceSet = bluetoothAdapter.getBondedDevices();
        if (bluetoothDeviceSet != null) {
            for (BluetoothDevice device : bluetoothDeviceSet) {
                ParcelUuid[] parcelUuids = device.getUuids();
                if (parcelUuids != null) {
                    for (ParcelUuid parcelUuid : parcelUuids) {
                        if (BLEServerConnection.CONTROL_SERVICE_UUID.equals(parcelUuid.getUuid())) {
                            BLE_SYNC_CONNECTION = new BLESyncConnection(context, device);
                            BLESyncConnection.BLEResult result = BLE_SYNC_CONNECTION.connect(
                                    ConnectTask.TIMEOUT_MILLIS
                                    , ConnectTask.TIMEOUT_MILLIS
                                    , null);
                            BLELogUtils.stackLog(result.getResultCode(), result.getStatus());
                            break;
                        }
                    }
                }
            }
        }
    }

    @AfterClass
    public static void tearDown() {
        if (BLE_SYNC_CONNECTION != null) {
            BLE_SYNC_CONNECTION.quit();
        }
    }

    @Test
    public void test_createReadCharacteristicTask001() {
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertArrayEquals(MESSAGE_SUCCESS.getBytes(), bleResult.getValues());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadCharacteristicTask002() {
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , bundle);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertArrayEquals(MESSAGE_SUCCESS.getBytes(), bleResult.getValues());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
    }

    @Test
    public void test_createReadCharacteristicTask003() {
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_ERROR
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , bundle);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_ERROR, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.VALUE_NOT_ALLOWED, bleResult.getStatus());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
    }

    @Test
    public void test_createReadCharacteristicTask004() {
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadCharacteristicTask005() {
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                UNDIFINED_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadCharacteristicTask006() {
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                UNDIFINED_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadCharacteristicTask007() {
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S
                , 0
                , 0
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getCharacteristicUUID());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadCharacteristicTask008() {
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S
                , 0
                , 0
                , bundle);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getCharacteristicUUID());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
    }

    @Test
    public void test_createWriteCharacteristicTask001() {
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertArrayEquals(data, bleResult.getValues());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createWriteCharacteristicTask002() {
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , bundle);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertArrayEquals(data, bleResult.getValues());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
    }

    @Test
    public void test_createWriteCharacteristicTask003() {
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_ERROR
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_ERROR, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.VALUE_NOT_ALLOWED, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createWriteCharacteristicTask004() {
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , bundle);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
    }

    @Test
    public void test_createWriteCharacteristicTask005() {
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                UNDIFINED_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createWriteCharacteristicTask006() {
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                UNDIFINED_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createWriteCharacteristicTask007() {
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , 0
                , 0
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getCharacteristicUUID());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createWriteCharacteristicTask008() {
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , 0
                , 0
                , bundle);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getCharacteristicUUID());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
    }

    @Test
    public void test_createWriteCharacteristicTask009() {
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_NO_RESPONSE_CHARACTERISTIC_UUID
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_NO_RESPONSE_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertArrayEquals(data, bleResult.getValues());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadDescriptorTask001() {
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertArrayEquals(MESSAGE_SUCCESS.getBytes(), bleResult.getValues());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadDescriptorTask002() {
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , bundle);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertArrayEquals(MESSAGE_SUCCESS.getBytes(), bleResult.getValues());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
    }

    @Test
    public void test_createReadDescriptorTask003() {
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , READABLE_DESCRIPTOR_UUID_WITH_ERROR
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_ERROR, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.VALUE_NOT_ALLOWED, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadDescriptorTask004() {
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , UNDIFINED_DESCRIPTOR_UUID
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , bundle);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(UNDIFINED_DESCRIPTOR_UUID, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
    }

    @Test
    public void test_createReadDescriptorTask005() {
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadDescriptorTask006() {
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , UNDIFINED_DESCRIPTOR_UUID
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(UNDIFINED_DESCRIPTOR_UUID, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadDescriptorTask007() {
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                UNDIFINED_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadDescriptorTask008() {
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                UNDIFINED_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , UNDIFINED_DESCRIPTOR_UUID
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(UNDIFINED_DESCRIPTOR_UUID, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadDescriptorTask009() {
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                UNDIFINED_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadDescriptorTask010() {
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                UNDIFINED_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , UNDIFINED_DESCRIPTOR_UUID
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(UNDIFINED_DESCRIPTOR_UUID, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadDescriptorTask011() {
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S
                , 0
                , 0
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getDescriptorUUID());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadDescriptorTask012() {
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S
                , 0
                , 0
                , bundle);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getDescriptorUUID());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
    }

    @Test
    public void test_createWriteDescriptorTask001() {
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertArrayEquals(data, bleResult.getValues());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createWriteDescriptorTask002() {
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , bundle);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertArrayEquals(data, bleResult.getValues());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
    }

    @Test
    public void test_createWriteDescriptorTask003() {
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , WRITABLE_DESCRIPTOR_UUID_WITH_ERROR
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_ERROR, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.VALUE_NOT_ALLOWED, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createWriteDescriptorTask004() {
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , UNDIFINED_DESCRIPTOR_UUID
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , bundle);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(UNDIFINED_DESCRIPTOR_UUID, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
    }

    @Test
    public void test_createWriteDescriptorTask005() {
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createWriteDescriptorTask006() {
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , UNDIFINED_DESCRIPTOR_UUID
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(UNDIFINED_DESCRIPTOR_UUID, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createWriteDescriptorTask007() {
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                UNDIFINED_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createWriteDescriptorTask008() {
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                UNDIFINED_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , UNDIFINED_DESCRIPTOR_UUID
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(UNDIFINED_DESCRIPTOR_UUID, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createWriteDescriptorTask009() {
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                UNDIFINED_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , WRITABLE_DESCRIPTOR_UUID_WITH_ERROR
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_ERROR, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createWriteDescriptorTask010() {
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                UNDIFINED_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , UNDIFINED_DESCRIPTOR_UUID
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(UNDIFINED_DESCRIPTOR_UUID, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createWriteDescriptorTask011() {
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S
                , WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , 0
                , 0
                , null);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getDescriptorUUID());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createWriteDescriptorTask012() {
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S
                , WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S
                , new ByteArrayInterface() {
                    @Override
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , 0
                , 0
                , bundle);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getDescriptorUUID());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
    }

}
