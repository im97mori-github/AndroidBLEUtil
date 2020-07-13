package org.im97mori.ble.profile.central.db;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.test.core.app.ApplicationProvider;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BondedDeviceDatabaseHelperTest {

    private static BaseBondedDeviceDatabaseHelper DATABASE_HELPER;

    @BeforeClass
    public static void setupClass() {
        DATABASE_HELPER = new BaseBondedDeviceDatabaseHelper(ApplicationProvider.getApplicationContext());
    }

    @Before
    public void setup() {
        DATABASE_HELPER.clearHistory();
    }

    @AfterClass
    public static void tearDownClass() {
        DATABASE_HELPER.close();
    }

    @Test
    public void test_getProfileName_00001() {
        assertEquals(BaseBondedDeviceDatabaseHelper.PROFILE_NAME, DATABASE_HELPER.getProfileName());
    }

    @Test
    public void test_addHistory_00001() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        SQLiteDatabase sqLiteDatabase = DATABASE_HELPER.getWritableDatabase();

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        assertNotEquals(-1, DATABASE_HELPER.addHistory(bluetoothDevice));

        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BONDED_DEVICE_TABLE", null)) {
            assertTrue(cursor.moveToFirst());
            assertEquals(1, cursor.getCount());
            assertEquals(BaseBondedDeviceDatabaseHelper.PROFILE_NAME, cursor.getString(cursor.getColumnIndex("PROFILE_NAME")));
            assertEquals(macAddress, cursor.getString(cursor.getColumnIndex("ADDRESS")));
        }
    }

    @Test
    public void test_addHistory_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        SQLiteDatabase sqLiteDatabase = DATABASE_HELPER.getWritableDatabase();

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        assertNotEquals(-1, DATABASE_HELPER.addHistory(bluetoothDevice));
        assertEquals(-1, DATABASE_HELPER.addHistory(bluetoothDevice));

        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BONDED_DEVICE_TABLE", null)) {
            assertTrue(cursor.moveToFirst());
            assertEquals(1, cursor.getCount());
            assertEquals(BaseBondedDeviceDatabaseHelper.PROFILE_NAME, cursor.getString(cursor.getColumnIndex("PROFILE_NAME")));
            assertEquals(macAddress, cursor.getString(cursor.getColumnIndex("ADDRESS")));
        }
    }

    @Test
    public void test_removeHistory_00001() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        assertFalse(DATABASE_HELPER.removeHistory(bluetoothDevice));
    }

    @Test
    public void test_removeHistory_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        assertNotEquals(-1, DATABASE_HELPER.addHistory(bluetoothDevice));
        assertTrue(DATABASE_HELPER.removeHistory(bluetoothDevice));
    }

    @Test
    public void test_removeHistory_00003() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        SQLiteDatabase sqLiteDatabase = DATABASE_HELPER.getWritableDatabase();

        String macAddress1 = "00:11:22:33:AA:BB";
        String macAddress2 = "00:11:22:33:AA:CC";
        BluetoothDevice bluetoothDevice1 = bluetoothAdapter.getRemoteDevice(macAddress1);
        BluetoothDevice bluetoothDevice2 = bluetoothAdapter.getRemoteDevice(macAddress2);
        assertNotEquals(-1, DATABASE_HELPER.addHistory(bluetoothDevice1));
        assertNotEquals(-1, DATABASE_HELPER.addHistory(bluetoothDevice2));
        assertTrue(DATABASE_HELPER.removeHistory(bluetoothDevice1));

        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BONDED_DEVICE_TABLE", null)) {
            assertTrue(cursor.moveToFirst());
            assertEquals(1, cursor.getCount());
            assertEquals(BaseBondedDeviceDatabaseHelper.PROFILE_NAME, cursor.getString(cursor.getColumnIndex("PROFILE_NAME")));
            assertEquals(macAddress2, cursor.getString(cursor.getColumnIndex("ADDRESS")));
        }
    }

    @Test
    public void test_clearHistory_00001() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        SQLiteDatabase sqLiteDatabase = DATABASE_HELPER.getWritableDatabase();

        String macAddress1 = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice1 = bluetoothAdapter.getRemoteDevice(macAddress1);
        assertNotEquals(-1, DATABASE_HELPER.addHistory(bluetoothDevice1));
        DATABASE_HELPER.clearHistory();

        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BONDED_DEVICE_TABLE", null)) {
            assertFalse(cursor.moveToFirst());
        }
    }

    @Test
    public void test_clearHistory_00002() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        SQLiteDatabase sqLiteDatabase = DATABASE_HELPER.getWritableDatabase();

        String macAddress1 = "00:11:22:33:AA:BB";
        String macAddress2 = "00:11:22:33:AA:CC";
        BluetoothDevice bluetoothDevice1 = bluetoothAdapter.getRemoteDevice(macAddress1);
        BluetoothDevice bluetoothDevice2 = bluetoothAdapter.getRemoteDevice(macAddress2);
        assertNotEquals(-1, DATABASE_HELPER.addHistory(bluetoothDevice1));
        assertNotEquals(-1, DATABASE_HELPER.addHistory(bluetoothDevice2));
        DATABASE_HELPER.clearHistory();

        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BONDED_DEVICE_TABLE", null)) {
            assertFalse(cursor.moveToFirst());
        }
    }

    @Test
    public void test_syncBondedDevice_00001() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress = "00:11:22:33:AA:BB";
        BluetoothDevice bluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddress);
        assertNotEquals(-1, DATABASE_HELPER.addHistory(bluetoothDevice));

        DATABASE_HELPER.syncBondedDevice();

        SQLiteDatabase sqLiteDatabase = DATABASE_HELPER.getWritableDatabase();
        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BONDED_DEVICE_TABLE", null)) {
            assertFalse(cursor.moveToFirst());
        }
    }

    @Test
    public void test_getBondedDevices_00001() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        assertNotNull(bluetoothAdapter);

        String macAddress1 = "00:11:22:33:AA:BB";
        String macAddress2 = "00:11:22:33:AA:CC";
        BluetoothDevice bluetoothDevice1 = bluetoothAdapter.getRemoteDevice(macAddress1);
        BluetoothDevice bluetoothDevice2 = bluetoothAdapter.getRemoteDevice(macAddress2);
        assertNotEquals(-1, DATABASE_HELPER.addHistory(bluetoothDevice1));
        assertNotEquals(-1, DATABASE_HELPER.addHistory(bluetoothDevice2));

        Set<BluetoothDevice> bluetoothDeviceSet = DATABASE_HELPER.getBondedDevices();

        assertTrue(bluetoothDeviceSet.contains(bluetoothDevice1));
        assertTrue(bluetoothDeviceSet.contains(bluetoothDevice2));
    }
}

