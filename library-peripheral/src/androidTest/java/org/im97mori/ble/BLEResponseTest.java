package org.im97mori.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.os.SystemClock;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.task.AbortReliableWriteTask;
import org.im97mori.ble.task.ConnectTask;
import org.im97mori.ble.task.DiscoverServiceTask;
import org.im97mori.ble.task.ExecuteReliableWriteTask;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;
import org.im97mori.ble.characteristic.MockControl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR;
import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_FAILED;
import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_SUCCESS;
import static org.im97mori.ble.BLESyncConnection.BLEResult.RESULT_TIMEOUT;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.DEFAULT_SERVICE_UUID;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.INDICATABLE_CHARACTERISTIC_UUID;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.MESSAGE_SUCCESS;
import static org.im97mori.ble.BLEServerConnection.DefaultServerSetting.NOTIFICATABLE_CHARACTERISTIC_UUID;
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
import static org.im97mori.ble.BLEServerConnection.MOCK_CONTROL_CHARACTERISTIC_UUID;
import static org.im97mori.ble.BLEServerConnection.MOCK_CONTROL_SERVICE_UUID;
import static org.im97mori.ble.BLEServerConnection.MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID;
import static org.im97mori.ble.BLEServerConnection.MOCK_CONTROL_TARGET_NOTIFICATION_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BLEResponseTest {

    private static class BLESyncConnectionInner extends BLESyncConnection {
        /**
         * @param context         {@link Context} instance
         * @param bluetoothDevice BLE device
         */
        BLESyncConnectionInner(Context context, BluetoothDevice bluetoothDevice) {
            super(context, bluetoothDevice);
        }

        BLEConnection getBLEConnection() {
            return mBLEConnection;
        }
    }

    private static BLESyncConnection BLE_SYNC_CONNECTION;
    private static BLEConnection BLE_CONNECTION;

    @BeforeClass
    public static void setup() {
        Context context = ApplicationProvider.getApplicationContext();
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> bluetoothDeviceSet = bluetoothAdapter.getBondedDevices();
        if (bluetoothDeviceSet != null) {
            for (BluetoothDevice device : bluetoothDeviceSet) {
                ParcelUuid[] parcelUuids = device.getUuids();
                if (parcelUuids != null) {
                    for (ParcelUuid parcelUuid : parcelUuids) {
                        if (MOCK_CONTROL_SERVICE_UUID.equals(parcelUuid.getUuid())) {
                            BLESyncConnectionInner bleSyncConnection = new BLESyncConnectionInner(context, device);
                            BLESyncConnection.BLEResult result = bleSyncConnection.connect(
                                    ConnectTask.TIMEOUT_MILLIS
                                    , ConnectTask.TIMEOUT_MILLIS
                                    , null
                                    , true);
                            if (result != null && RESULT_SUCCESS == result.getResultCode()) {
                                BLE_SYNC_CONNECTION = bleSyncConnection;
                                BLE_CONNECTION = bleSyncConnection.getBLEConnection();
                            }
                            break;
                        }
                    }
                }
            }
        }

        if (BLE_SYNC_CONNECTION == null) {
            System.exit(-1);
        }
    }

    @AfterClass
    public static void tearDown() {
        if (BLE_SYNC_CONNECTION != null) {
            BLE_SYNC_CONNECTION.quit();
        }
    }

    private long mUntil;
    private boolean mNeedWait;

    @Before
    public void before() {
        mNeedWait = true;
    }

    @After
    public void after() {
        if (mNeedWait) {
            while (mUntil > SystemClock.elapsedRealtime()) {
                try {
                    Thread.sleep(mUntil - SystemClock.elapsedRealtime());
                } catch (InterruptedException e) {
                    BLEPeripheralLogUtils.stackLog(e);
                }
            }
        }
    }

    @Test
    public void test_createDiscoverServiceTask001() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = DiscoverServiceTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createDiscoverServiceTask(
                DiscoverServiceTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertNotNull(bleResult.getServiceList());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createDiscoverServiceTask002() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = DiscoverServiceTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createDiscoverServiceTask(
                0
                , 0
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertNull(bleResult.getServiceList());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadCharacteristicTask001() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = ReadCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertArrayEquals(MESSAGE_SUCCESS.getBytes(), bleResult.getValues());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createReadCharacteristicTask002() {
        assertNotNull(BLE_SYNC_CONNECTION);
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);

        mUntil = ReadCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , bundle
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertArrayEquals(MESSAGE_SUCCESS.getBytes(), bleResult.getValues());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
        mNeedWait = false;
    }

    @Test
    public void test_createReadCharacteristicTask003() {
        assertNotNull(BLE_SYNC_CONNECTION);
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);

        mUntil = ReadCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_ERROR
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , bundle
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_ERROR, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.APPLICATION_ERROR_9F, bleResult.getStatus());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
        mNeedWait = false;
    }

    @Test
    public void test_createReadCharacteristicTask004() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = ReadCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createReadCharacteristicTask005() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = ReadCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                UNDIFINED_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createReadCharacteristicTask006() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = ReadCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                UNDIFINED_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createReadCharacteristicTask007() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = DateUtils.SECOND_IN_MILLIS * 10 + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S
                , 0
                , 0
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getCharacteristicUUID());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadCharacteristicTask008() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = DateUtils.SECOND_IN_MILLIS * 15 + SystemClock.elapsedRealtime();
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S
                , 0
                , 0
                , bundle
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getCharacteristicUUID());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
    }

    @Test
    public void test_createReadCharacteristicTask009() {
        assertNotNull(BLE_CONNECTION);

        mUntil = ReadCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLESyncConnection.createReadCharacteristicTask(
                BLE_CONNECTION
                , DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , null
                , true);

        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertArrayEquals(MESSAGE_SUCCESS.getBytes(), bleResult.getValues());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createWriteCharacteristicTask001() {
        assertNotNull(BLE_SYNC_CONNECTION);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertArrayEquals(data, bleResult.getValues());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createWriteCharacteristicTask002() {
        assertNotNull(BLE_SYNC_CONNECTION);
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , bundle
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertArrayEquals(data, bleResult.getValues());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
        mNeedWait = false;
    }

    @Test
    public void test_createWriteCharacteristicTask003() {
        assertNotNull(BLE_SYNC_CONNECTION);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_ERROR
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_ERROR, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.APPLICATION_ERROR_9F, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createWriteCharacteristicTask004() {
        assertNotNull(BLE_SYNC_CONNECTION);
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , bundle
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
        mNeedWait = false;
    }

    @Test
    public void test_createWriteCharacteristicTask005() {
        assertNotNull(BLE_SYNC_CONNECTION);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                UNDIFINED_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createWriteCharacteristicTask006() {
        assertNotNull(BLE_SYNC_CONNECTION);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                UNDIFINED_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createWriteCharacteristicTask007() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = DateUtils.SECOND_IN_MILLIS * 10 + SystemClock.elapsedRealtime();
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , 0
                , 0
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getCharacteristicUUID());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createWriteCharacteristicTask008() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = DateUtils.SECOND_IN_MILLIS * 10 + SystemClock.elapsedRealtime();
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , 0
                , 0
                , bundle
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getCharacteristicUUID());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
    }

    @Test
    public void test_createWriteCharacteristicTask009() {
        assertNotNull(BLE_SYNC_CONNECTION);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_NO_RESPONSE_CHARACTERISTIC_UUID
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_NO_RESPONSE_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertArrayEquals(data, bleResult.getValues());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createWriteCharacteristicTask010() {
        assertNotNull(BLE_CONNECTION);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLESyncConnection.createWriteCharacteristicTask(
                BLE_CONNECTION
                , DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertArrayEquals(data, bleResult.getValues());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createReadDescriptorTask001() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = ReadDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertArrayEquals(MESSAGE_SUCCESS.getBytes(), bleResult.getValues());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createReadDescriptorTask002() {
        assertNotNull(BLE_SYNC_CONNECTION);
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);

        mUntil = ReadDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , bundle
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertArrayEquals(MESSAGE_SUCCESS.getBytes(), bleResult.getValues());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
        mNeedWait = false;
    }

    @Test
    public void test_createReadDescriptorTask003() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = ReadDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , READABLE_DESCRIPTOR_UUID_WITH_ERROR
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_ERROR, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.APPLICATION_ERROR_9F, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createReadDescriptorTask004() {
        assertNotNull(BLE_SYNC_CONNECTION);
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);

        mUntil = ReadDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , UNDIFINED_DESCRIPTOR_UUID
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , bundle
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(UNDIFINED_DESCRIPTOR_UUID, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
        mNeedWait = false;
    }

    @Test
    public void test_createReadDescriptorTask005() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = ReadDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createReadDescriptorTask006() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = ReadDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , UNDIFINED_DESCRIPTOR_UUID
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(UNDIFINED_DESCRIPTOR_UUID, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createReadDescriptorTask007() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = ReadDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                UNDIFINED_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createReadDescriptorTask008() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = ReadDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                UNDIFINED_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , UNDIFINED_DESCRIPTOR_UUID
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(UNDIFINED_DESCRIPTOR_UUID, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createReadDescriptorTask009() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = ReadDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                UNDIFINED_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createReadDescriptorTask010() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = ReadDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                UNDIFINED_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , UNDIFINED_DESCRIPTOR_UUID
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(UNDIFINED_DESCRIPTOR_UUID, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createReadDescriptorTask011() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = DateUtils.SECOND_IN_MILLIS * 10 + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S
                , 0
                , 0
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getDescriptorUUID());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createReadDescriptorTask012() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = DateUtils.SECOND_IN_MILLIS * 10 + SystemClock.elapsedRealtime();
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S
                , 0
                , 0
                , bundle
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getDescriptorUUID());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
    }

    @Test
    public void test_createReadDescriptorTask013() {
        assertNotNull(BLE_CONNECTION);

        mUntil = ReadDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLESyncConnection.createReadDescriptorTask(
                BLE_CONNECTION
                , DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertArrayEquals(MESSAGE_SUCCESS.getBytes(), bleResult.getValues());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createWriteDescriptorTask001() {
        assertNotNull(BLE_SYNC_CONNECTION);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertArrayEquals(data, bleResult.getValues());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createWriteDescriptorTask002() {
        assertNotNull(BLE_SYNC_CONNECTION);
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , bundle
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertArrayEquals(data, bleResult.getValues());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
        mNeedWait = false;
    }

    @Test
    public void test_createWriteDescriptorTask003() {
        assertNotNull(BLE_SYNC_CONNECTION);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , WRITABLE_DESCRIPTOR_UUID_WITH_ERROR
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_ERROR, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.APPLICATION_ERROR_9F, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createWriteDescriptorTask004() {
        assertNotNull(BLE_SYNC_CONNECTION);
        long randomLong = new Random().nextLong();
        Bundle bundle = new Bundle();
        bundle.putLong("a", randomLong);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , UNDIFINED_DESCRIPTOR_UUID
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , bundle
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(UNDIFINED_DESCRIPTOR_UUID, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
        mNeedWait = false;
    }

    @Test
    public void test_createWriteDescriptorTask005() {
        assertNotNull(BLE_SYNC_CONNECTION);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createWriteDescriptorTask006() {
        assertNotNull(BLE_SYNC_CONNECTION);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , UNDIFINED_DESCRIPTOR_UUID
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(UNDIFINED_DESCRIPTOR_UUID, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createWriteDescriptorTask007() {
        assertNotNull(BLE_SYNC_CONNECTION);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                UNDIFINED_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createWriteDescriptorTask008() {
        assertNotNull(BLE_SYNC_CONNECTION);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                UNDIFINED_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , UNDIFINED_DESCRIPTOR_UUID
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(UNDIFINED_DESCRIPTOR_UUID, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createWriteDescriptorTask009() {
        assertNotNull(BLE_SYNC_CONNECTION);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                UNDIFINED_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , WRITABLE_DESCRIPTOR_UUID_WITH_ERROR
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_ERROR, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createWriteDescriptorTask010() {
        assertNotNull(BLE_SYNC_CONNECTION);
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                UNDIFINED_SERVICE_UUID
                , UNDIFINED_CHARACTERISTIC_UUID
                , UNDIFINED_DESCRIPTOR_UUID
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(UNDIFINED_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(UNDIFINED_CHARACTERISTIC_UUID, bleResult.getCharacteristicUUID());
        assertEquals(UNDIFINED_DESCRIPTOR_UUID, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, bleResult.getStatus());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createWriteDescriptorTask011() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = DateUtils.SECOND_IN_MILLIS * 10 + SystemClock.elapsedRealtime();
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S
                , WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , 0
                , 0
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getDescriptorUUID());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createWriteDescriptorTask012() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = DateUtils.SECOND_IN_MILLIS * 10 + SystemClock.elapsedRealtime();
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
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , 0
                , 0
                , bundle
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_WAIT_10S, bleResult.getDescriptorUUID());
        assertNotNull(bleResult.getArgument());
        assertEquals(randomLong, bleResult.getArgument().getLong("a"));
    }


    @Test
    public void test_createWriteDescriptorTask013() {
        assertNotNull(BLE_CONNECTION);

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLESyncConnection.createWriteDescriptorTask(
                BLE_CONNECTION
                , DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(WRITABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertArrayEquals(data, bleResult.getValues());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_listen001() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS * 2 + DateUtils.SECOND_IN_MILLIS * 5 + SystemClock.elapsedRealtime();

        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , NOTIFICATABLE_CHARACTERISTIC_UUID
                , CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);

        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());

        List<byte[]> list = BLE_SYNC_CONNECTION.listen(
                DEFAULT_SERVICE_UUID
                , NOTIFICATABLE_CHARACTERISTIC_UUID
                , DateUtils.SECOND_IN_MILLIS * 5
        );

        assertNotNull(list);
        assertFalse(list.isEmpty());

        bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , NOTIFICATABLE_CHARACTERISTIC_UUID
                , CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);

        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        mNeedWait = false;
    }

    @Test
    public void test_listen002() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS * 2 + DateUtils.SECOND_IN_MILLIS * 5 + SystemClock.elapsedRealtime();

        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , INDICATABLE_CHARACTERISTIC_UUID
                , CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);

        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());

        List<byte[]> list = BLE_SYNC_CONNECTION.listen(
                DEFAULT_SERVICE_UUID
                , INDICATABLE_CHARACTERISTIC_UUID
                , DateUtils.SECOND_IN_MILLIS * 5
        );

        assertNotNull(list);
        assertFalse(list.isEmpty());

        bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , INDICATABLE_CHARACTERISTIC_UUID
                , CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);

        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        mNeedWait = false;
    }

    @Test
    public void test_listen003() {
        assertNotNull(BLE_CONNECTION);

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS * 2 + DateUtils.SECOND_IN_MILLIS * 5 + SystemClock.elapsedRealtime();

        BLESyncConnection.BLEResult bleResult = BLESyncConnection.createWriteDescriptorTask(
                BLE_CONNECTION
                , DEFAULT_SERVICE_UUID
                , NOTIFICATABLE_CHARACTERISTIC_UUID
                , CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);

        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());

        List<byte[]> list = BLESyncConnection.listen(
                BLE_CONNECTION
                , DEFAULT_SERVICE_UUID
                , NOTIFICATABLE_CHARACTERISTIC_UUID
                , DateUtils.SECOND_IN_MILLIS * 5
        );

        assertNotNull(list);
        assertFalse(list.isEmpty());

        bleResult = BLESyncConnection.createWriteDescriptorTask(
                BLE_CONNECTION
                , DEFAULT_SERVICE_UUID
                , NOTIFICATABLE_CHARACTERISTIC_UUID
                , CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);

        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        mNeedWait = false;
    }

    @Test
    public void test_mockCharacteristic001() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = WriteCharacteristicTask.TIMEOUT_MILLIS + ReadCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();

        final String newMessage = UUID.randomUUID().toString();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                MOCK_CONTROL_SERVICE_UUID
                , MOCK_CONTROL_CHARACTERISTIC_UUID
                , new MockControl(DEFAULT_SERVICE_UUID
                        , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                        , MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID
                        , MockControl.TARGET_TYPE_CHARACTERISTIC
                        , BluetoothGatt.GATT_SUCCESS
                        , newMessage.getBytes())
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());

        bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(BluetoothGatt.GATT_SUCCESS, bleResult.getStatus());
        assertArrayEquals(newMessage.getBytes(), bleResult.getValues());
        mNeedWait = false;
    }

    @Test
    public void test_mockCharacteristic002() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = WriteCharacteristicTask.TIMEOUT_MILLIS + ReadCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();

        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                MOCK_CONTROL_SERVICE_UUID
                , MOCK_CONTROL_CHARACTERISTIC_UUID
                , new MockControl(DEFAULT_SERVICE_UUID
                        , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                        , MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID
                        , MockControl.TARGET_TYPE_CHARACTERISTIC
                        , BLEConstants.ErrorCodes.OUT_OF_RANGE
                        , new byte[0])
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());

        bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(BLEConstants.ErrorCodes.OUT_OF_RANGE, bleResult.getStatus());
        mNeedWait = false;
    }

    @Test
    public void test_mockCharacteristic003() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = WriteCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();

        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                MOCK_CONTROL_SERVICE_UUID
                , MOCK_CONTROL_CHARACTERISTIC_UUID
                , new MockControl(MOCK_CONTROL_SERVICE_UUID
                        , MOCK_CONTROL_CHARACTERISTIC_UUID
                        , MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID
                        , MockControl.TARGET_TYPE_CHARACTERISTIC
                        , BLEConstants.ErrorCodes.OUT_OF_RANGE
                        , new byte[0])
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(BLEConstants.ErrorCodes.APPLICATION_ERROR_9F, bleResult.getStatus());
        mNeedWait = false;
    }

    @Test
    public void test_mockCharacteristic004() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = WriteCharacteristicTask.TIMEOUT_MILLIS * 2 + ReadCharacteristicTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();

        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                MOCK_CONTROL_SERVICE_UUID
                , MOCK_CONTROL_CHARACTERISTIC_UUID
                , new MockControl(DEFAULT_SERVICE_UUID
                        , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                        , MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID
                        , MockControl.TARGET_TYPE_CHARACTERISTIC
                        , BLEConstants.ErrorCodes.OUT_OF_RANGE
                        , new byte[0])
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());

        bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                MOCK_CONTROL_SERVICE_UUID
                , MOCK_CONTROL_CHARACTERISTIC_UUID
                , new MockControl(DEFAULT_SERVICE_UUID
                        , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                        , MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID
                        , MockControl.TARGET_CLEAR
                        , BLEConstants.ErrorCodes.OUT_OF_RANGE
                        , new byte[0])
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());

        bleResult = BLE_SYNC_CONNECTION.createReadCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , ReadCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertArrayEquals(MESSAGE_SUCCESS.getBytes(), bleResult.getValues());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_mockDescriptor001() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS + ReadDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();

        final String newMessage = UUID.randomUUID().toString();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                MOCK_CONTROL_SERVICE_UUID
                , MOCK_CONTROL_CHARACTERISTIC_UUID
                , new MockControl(DEFAULT_SERVICE_UUID
                        , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                        , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                        , MockControl.TARGET_TYPE_DESCRIPTOR
                        , BluetoothGatt.GATT_SUCCESS
                        , newMessage.getBytes())
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());

        bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertEquals(BluetoothGatt.GATT_SUCCESS, bleResult.getStatus());
        assertArrayEquals(newMessage.getBytes(), bleResult.getValues());
        mNeedWait = false;
    }

    @Test
    public void test_mockDescriptor002() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS + ReadDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();

        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                MOCK_CONTROL_SERVICE_UUID
                , MOCK_CONTROL_CHARACTERISTIC_UUID
                , new MockControl(DEFAULT_SERVICE_UUID
                        , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                        , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                        , MockControl.TARGET_TYPE_DESCRIPTOR
                        , BLEConstants.ErrorCodes.OUT_OF_RANGE
                        , new byte[0])
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());

        bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertEquals(BLEConstants.ErrorCodes.OUT_OF_RANGE, bleResult.getStatus());
        mNeedWait = false;
    }

    @Test
    public void test_mockDescriptor003() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();

        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                MOCK_CONTROL_SERVICE_UUID
                , MOCK_CONTROL_CHARACTERISTIC_UUID
                , new MockControl(MOCK_CONTROL_SERVICE_UUID
                        , MOCK_CONTROL_CHARACTERISTIC_UUID
                        , MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID
                        , MockControl.TARGET_TYPE_DESCRIPTOR
                        , BLEConstants.ErrorCodes.OUT_OF_RANGE
                        , new byte[0])
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_FAILED, bleResult.getResultCode());
        assertEquals(BLEConstants.ErrorCodes.APPLICATION_ERROR_9F, bleResult.getStatus());
        mNeedWait = false;
    }

    @Test
    public void test_mockDescriptor004() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS * 2 + ReadDescriptorTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();

        final String newMessage = UUID.randomUUID().toString();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                MOCK_CONTROL_SERVICE_UUID
                , MOCK_CONTROL_CHARACTERISTIC_UUID
                , new MockControl(DEFAULT_SERVICE_UUID
                        , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                        , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                        , MockControl.TARGET_TYPE_DESCRIPTOR
                        , BluetoothGatt.GATT_SUCCESS
                        , newMessage.getBytes())
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());

        bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                MOCK_CONTROL_SERVICE_UUID
                , MOCK_CONTROL_CHARACTERISTIC_UUID
                , new MockControl(DEFAULT_SERVICE_UUID
                        , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                        , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                        , MockControl.TARGET_CLEAR
                        , BluetoothGatt.GATT_SUCCESS
                        , newMessage.getBytes())
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());

        bleResult = BLE_SYNC_CONNECTION.createReadDescriptorTask(
                DEFAULT_SERVICE_UUID
                , READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT
                , ReadDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(READABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertEquals(READABLE_DESCRIPTOR_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getDescriptorUUID());
        assertArrayEquals(MESSAGE_SUCCESS.getBytes(), bleResult.getValues());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_mockNotification001() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS * 3 + DateUtils.SECOND_IN_MILLIS * 5 + SystemClock.elapsedRealtime();

        final String newMessage = UUID.randomUUID().toString();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                MOCK_CONTROL_SERVICE_UUID
                , MOCK_CONTROL_CHARACTERISTIC_UUID
                , new MockControl(DEFAULT_SERVICE_UUID
                        , NOTIFICATABLE_CHARACTERISTIC_UUID
                        , MOCK_CONTROL_TARGET_NOTIFICATION_UUID
                        , MockControl.TARGET_TYPE_NOTIFICATION
                        , BluetoothGatt.GATT_SUCCESS
                        , newMessage.getBytes())
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());

        bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , NOTIFICATABLE_CHARACTERISTIC_UUID
                , CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());

        List<byte[]> list = BLE_SYNC_CONNECTION.listen(
                DEFAULT_SERVICE_UUID
                , NOTIFICATABLE_CHARACTERISTIC_UUID
                , DateUtils.SECOND_IN_MILLIS * 5
        );

        assertNotNull(list);
        assertFalse(list.isEmpty());
        assertArrayEquals(newMessage.getBytes(), list.get(0));

        bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , NOTIFICATABLE_CHARACTERISTIC_UUID
                , CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);

        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        mNeedWait = false;
    }

    @Test
    public void test_mockNotification002() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = WriteDescriptorTask.TIMEOUT_MILLIS * 4 + DateUtils.SECOND_IN_MILLIS * 5 + SystemClock.elapsedRealtime();

        final String newMessage = UUID.randomUUID().toString();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                MOCK_CONTROL_SERVICE_UUID
                , MOCK_CONTROL_CHARACTERISTIC_UUID
                , new MockControl(DEFAULT_SERVICE_UUID
                        , NOTIFICATABLE_CHARACTERISTIC_UUID
                        , MOCK_CONTROL_TARGET_NOTIFICATION_UUID
                        , MockControl.TARGET_TYPE_NOTIFICATION
                        , BluetoothGatt.GATT_SUCCESS
                        , newMessage.getBytes())
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());

        bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                MOCK_CONTROL_SERVICE_UUID
                , MOCK_CONTROL_CHARACTERISTIC_UUID
                , new MockControl(DEFAULT_SERVICE_UUID
                        , NOTIFICATABLE_CHARACTERISTIC_UUID
                        , MOCK_CONTROL_TARGET_NOTIFICATION_UUID
                        , MockControl.TARGET_CLEAR
                        , BluetoothGatt.GATT_SUCCESS
                        , newMessage.getBytes())
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());

        bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , NOTIFICATABLE_CHARACTERISTIC_UUID
                , CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());

        List<byte[]> list = BLE_SYNC_CONNECTION.listen(
                DEFAULT_SERVICE_UUID
                , NOTIFICATABLE_CHARACTERISTIC_UUID
                , DateUtils.SECOND_IN_MILLIS * 5
        );

        assertNotNull(list);
        assertFalse(list.isEmpty());
        assertNotEquals(newMessage, new String(list.get(0)));

        bleResult = BLE_SYNC_CONNECTION.createWriteDescriptorTask(
                DEFAULT_SERVICE_UUID
                , NOTIFICATABLE_CHARACTERISTIC_UUID
                , CLIENT_CHARACTERISTIC_CONFIGRATION_DESCRIPTOR
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
                    }
                }
                , WriteDescriptorTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);

        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        mNeedWait = false;
    }

    @Test
    public void test_createBeginReliableWriteTask001() {
        assertNotNull(BLE_SYNC_CONNECTION);

        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createBeginReliableWriteTask(
                DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createBeginReliableWriteTask002() {
        assertNotNull(BLE_SYNC_CONNECTION);

        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createBeginReliableWriteTask(
                0
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createExecuteReliableWriteTask001() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = WriteCharacteristicTask.TIMEOUT_MILLIS + ExecuteReliableWriteTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createBeginReliableWriteTask(
                DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertNull(bleResult.getArgument());

        bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertArrayEquals(data, bleResult.getValues());
        assertNull(bleResult.getArgument());

        bleResult = BLE_SYNC_CONNECTION.createExecuteReliableWriteTask(
                ExecuteReliableWriteTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createExecuteReliableWriteTask002() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = WriteCharacteristicTask.TIMEOUT_MILLIS + ExecuteReliableWriteTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createBeginReliableWriteTask(
                DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertNull(bleResult.getArgument());

        bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertArrayEquals(data, bleResult.getValues());
        assertNull(bleResult.getArgument());

        bleResult = BLE_SYNC_CONNECTION.createExecuteReliableWriteTask(
                0
                , 0
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertNull(bleResult.getArgument());
    }

    @Test
    public void test_createAbortReliableWriteTask001() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = WriteCharacteristicTask.TIMEOUT_MILLIS + AbortReliableWriteTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createBeginReliableWriteTask(
                DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertNull(bleResult.getArgument());

        bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertArrayEquals(data, bleResult.getValues());
        assertNull(bleResult.getArgument());

        bleResult = BLE_SYNC_CONNECTION.createAbortReliableWriteTask(
                AbortReliableWriteTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertNull(bleResult.getArgument());
        mNeedWait = false;
    }

    @Test
    public void test_createAbortReliableWriteTask002() {
        assertNotNull(BLE_SYNC_CONNECTION);

        mUntil = WriteCharacteristicTask.TIMEOUT_MILLIS + AbortReliableWriteTask.TIMEOUT_MILLIS + SystemClock.elapsedRealtime();
        final byte[] data = String.valueOf(SystemClock.elapsedRealtime()).getBytes();
        BLESyncConnection.BLEResult bleResult = BLE_SYNC_CONNECTION.createBeginReliableWriteTask(
                DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertNull(bleResult.getArgument());

        bleResult = BLE_SYNC_CONNECTION.createWriteCharacteristicTask(
                DEFAULT_SERVICE_UUID
                , WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT
                , new ByteArrayInterface() {
                    @Override
                    @NonNull
                    public byte[] getBytes() {
                        return data;
                    }
                }
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , DateUtils.MINUTE_IN_MILLIS
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_SUCCESS, bleResult.getResultCode());
        assertEquals(DEFAULT_SERVICE_UUID, bleResult.getServiceUUID());
        assertEquals(WRITABLE_CHARACTERISTIC_UUID_WITH_SUCCESS_NO_WAIT, bleResult.getCharacteristicUUID());
        assertArrayEquals(data, bleResult.getValues());
        assertNull(bleResult.getArgument());

        bleResult = BLE_SYNC_CONNECTION.createAbortReliableWriteTask(
                0
                , 0
                , null
                , true);
        assertNotNull(bleResult);
        assertEquals(RESULT_TIMEOUT, bleResult.getResultCode());
        assertNull(bleResult.getServiceList());
        assertNull(bleResult.getArgument());
    }

}
