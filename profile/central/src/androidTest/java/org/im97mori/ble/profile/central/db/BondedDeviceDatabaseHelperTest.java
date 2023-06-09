package org.im97mori.ble.profile.central.db;

import android.bluetooth.BluetoothDevice;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.test.filters.RequiresDevice;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.GrantPermissionRule;

import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class BondedDeviceDatabaseHelperTest {

    @Rule
    public GrantPermissionRule mRuntimePermissionRule = GrantPermissionRule
            .grant(android.Manifest.permission.BLUETOOTH_CONNECT);

    private static BaseBondedDeviceDatabaseHelper DATABASE_HELPER;

    @BeforeClass
    public static void setupClass() {
        DATABASE_HELPER = new BaseBondedDeviceDatabaseHelper(InstrumentationRegistry.getInstrumentation().getContext().getApplicationContext());
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
    @RequiresDevice
    public void test_addHistory_00001() {
        SQLiteDatabase sqLiteDatabase = DATABASE_HELPER.getWritableDatabase();

        assertNotEquals(-1, DATABASE_HELPER.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));

        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BONDED_DEVICE_TABLE", null)) {
            assertTrue(cursor.moveToFirst());
            assertEquals(1, cursor.getCount());
            assertEquals(BaseBondedDeviceDatabaseHelper.PROFILE_NAME, cursor.getString(cursor.getColumnIndex("PROFILE_NAME")));
            assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0.getAddress(), cursor.getString(cursor.getColumnIndex("ADDRESS")));
        }
    }

    @Test
    @RequiresDevice
    public void test_addHistory_00002() {
        SQLiteDatabase sqLiteDatabase = DATABASE_HELPER.getWritableDatabase();

        assertNotEquals(-1, DATABASE_HELPER.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));
        assertEquals(-1, DATABASE_HELPER.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));

        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BONDED_DEVICE_TABLE", null)) {
            assertTrue(cursor.moveToFirst());
            assertEquals(1, cursor.getCount());
            assertEquals(BaseBondedDeviceDatabaseHelper.PROFILE_NAME, cursor.getString(cursor.getColumnIndex("PROFILE_NAME")));
            assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0.getAddress(), cursor.getString(cursor.getColumnIndex("ADDRESS")));
        }
    }

    @Test
    @RequiresDevice
    public void test_removeHistory_00001() {
        assertFalse(DATABASE_HELPER.removeHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));
    }

    @Test
    @RequiresDevice
    public void test_removeHistory_00002() {
        assertNotEquals(-1, DATABASE_HELPER.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));
        assertTrue(DATABASE_HELPER.removeHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));
    }

    @Test
    @RequiresDevice
    public void test_removeHistory_00003() {
        SQLiteDatabase sqLiteDatabase = DATABASE_HELPER.getWritableDatabase();

        assertNotEquals(-1, DATABASE_HELPER.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));
        assertNotEquals(-1, DATABASE_HELPER.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_1));
        assertTrue(DATABASE_HELPER.removeHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));

        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BONDED_DEVICE_TABLE", null)) {
            assertTrue(cursor.moveToFirst());
            assertEquals(1, cursor.getCount());
            assertEquals(BaseBondedDeviceDatabaseHelper.PROFILE_NAME, cursor.getString(cursor.getColumnIndex("PROFILE_NAME")));
            assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_1.getAddress(), cursor.getString(cursor.getColumnIndex("ADDRESS")));
        }
    }

    @Test
    @RequiresDevice
    public void test_clearHistory_00001() {
        SQLiteDatabase sqLiteDatabase = DATABASE_HELPER.getWritableDatabase();

        assertNotEquals(-1, DATABASE_HELPER.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));
        DATABASE_HELPER.clearHistory();

        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BONDED_DEVICE_TABLE", null)) {
            assertFalse(cursor.moveToFirst());
        }
    }

    @Test
    @RequiresDevice
    public void test_clearHistory_00002() {
        SQLiteDatabase sqLiteDatabase = DATABASE_HELPER.getWritableDatabase();

        assertNotEquals(-1, DATABASE_HELPER.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));
        assertNotEquals(-1, DATABASE_HELPER.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_1));
        DATABASE_HELPER.clearHistory();

        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BONDED_DEVICE_TABLE", null)) {
            assertFalse(cursor.moveToFirst());
        }
    }

    @Test
    @RequiresDevice
    public void test_syncBondedDevice_00001() {
        assertNotEquals(-1, DATABASE_HELPER.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));

        DATABASE_HELPER.syncBondedDevice();

        SQLiteDatabase sqLiteDatabase = DATABASE_HELPER.getWritableDatabase();
        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM BONDED_DEVICE_TABLE", null)) {
            assertFalse(cursor.moveToFirst());
        }
    }

    @Test
    @RequiresDevice
    public void test_getBondedDevices_00001() {
        assertNotEquals(-1, DATABASE_HELPER.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_0));
        assertNotEquals(-1, DATABASE_HELPER.addHistory(BLETestUtilsAndroid.MOCK_DEVICE_1));

        Set<BluetoothDevice> bluetoothDeviceSet = DATABASE_HELPER.getBondedDevices();

        assertTrue(bluetoothDeviceSet.contains(BLETestUtilsAndroid.MOCK_DEVICE_0));
        assertTrue(bluetoothDeviceSet.contains(BLETestUtilsAndroid.MOCK_DEVICE_1));
    }
}

