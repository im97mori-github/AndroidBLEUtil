package org.im97mori.ble.profile.central.db;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.util.HashSet;
import java.util.Set;

/**
 * Bonded device database helper
 */
@SuppressWarnings("SameReturnValue")
@SuppressLint("MissingPermission")
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public abstract class BondedDeviceDatabaseHelper extends SQLiteOpenHelper {

    /**
     * DATABASE_FILE_NAME
     */
    private static final String DATABASE_NAME = "BONDED_DEVICE_DATABASE";

    /**
     * version for {@link SQLiteOpenHelper#SQLiteOpenHelper(Context, String, SQLiteDatabase.CursorFactory, int)} 4th parameter
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * @param context {@link Context} instance for {@link SQLiteOpenHelper#SQLiteOpenHelper(Context, String, SQLiteDatabase.CursorFactory, int)} 1st parameter
     */
    public BondedDeviceDatabaseHelper(@NonNull Context context) {
        super(context.getApplicationContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS BONDED_DEVICE_TABLE (PROFILE_NAME TEXT NOT NULL, ADDRESS TEXT NOT NULL, CONSTRAINT A UNIQUE (PROFILE_NAME, ADDRESS))");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // do nothing
    }

    /**
     * get bluetooth profile name for BONDED_DEVICE_TABLE
     *
     * @return bluetooth profile name
     */
    @NonNull
    abstract protected String getProfileName();

    /**
     * add bonded device
     *
     * @param bluetoothDevice bonded {@link BluetoothDevice} instance
     * @return BONDED_DEVICE_TABLE's row id
     */
    public synchronized long addHistory(@NonNull BluetoothDevice bluetoothDevice) {
        long rowId;
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.beginTransaction();
        try (SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement("INSERT OR IGNORE INTO BONDED_DEVICE_TABLE (PROFILE_NAME, ADDRESS) VALUES (?, ?)")) {
            sqLiteStatement.bindString(1, getProfileName());
            sqLiteStatement.bindString(2, bluetoothDevice.getAddress());
            rowId = sqLiteStatement.executeInsert();

            sqLiteDatabase.setTransactionSuccessful();
        } finally {
            sqLiteDatabase.endTransaction();
        }
        return rowId;
    }

    /**
     * remove bonded device
     *
     * @param bluetoothDevice remove target {@link BluetoothDevice} instance
     * @return {@code true}:remove success, {@code false}:not removed(remove target not on BONDED_DEVICE_TABLE)
     */
    public synchronized boolean removeHistory(@NonNull BluetoothDevice bluetoothDevice) {
        boolean result;
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.beginTransaction();
        try (SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement("DELETE FROM BONDED_DEVICE_TABLE WHERE PROFILE_NAME = ? AND ADDRESS = ?")) {
            sqLiteStatement.bindString(1, getProfileName());
            sqLiteStatement.bindString(2, bluetoothDevice.getAddress());
            result = sqLiteStatement.executeUpdateDelete() == 1;

            sqLiteDatabase.setTransactionSuccessful();
        } finally {
            sqLiteDatabase.endTransaction();
        }
        return result;
    }

    /**
     * clear this bluetooth profile's bonded device history
     */
    public synchronized void clearHistory() {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.beginTransaction();
        try (SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement("DELETE FROM BONDED_DEVICE_TABLE WHERE PROFILE_NAME = ?")) {
            sqLiteStatement.bindString(1, getProfileName());
            sqLiteStatement.executeUpdateDelete();

            sqLiteDatabase.setTransactionSuccessful();
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }

    /**
     * sync bonded devices with {@link BluetoothAdapter#getBondedDevices()}
     */
    public synchronized void syncBondedDevice() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter != null) {
            Set<BluetoothDevice> bondedDeviceSet = bluetoothAdapter.getBondedDevices();
            if (bondedDeviceSet != null) {
                SQLiteDatabase sqLiteDatabase = getWritableDatabase();
                sqLiteDatabase.beginTransaction();
                try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT ADDRESS FROM BONDED_DEVICE_TABLE WHERE PROFILE_NAME = ?", new String[]{getProfileName()});
                     SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement("DELETE FROM BONDED_DEVICE_TABLE WHERE PROFILE_NAME = ? AND ADDRESS = ?")) {

                    if (cursor.moveToFirst()) {
                        BluetoothDevice currentBluetoothDevice;
                        Set<BluetoothDevice> removedBluetoothDeviceSet = new HashSet<>();
                        do {
                            currentBluetoothDevice = bluetoothAdapter.getRemoteDevice(cursor.getString(cursor.getColumnIndex("ADDRESS")));
                            if (!bondedDeviceSet.contains(currentBluetoothDevice)) {
                                removedBluetoothDeviceSet.add(currentBluetoothDevice);
                            }
                        } while (cursor.moveToNext());

                        if (!removedBluetoothDeviceSet.isEmpty()) {
                            for (BluetoothDevice bluetoothDevice : removedBluetoothDeviceSet) {
                                sqLiteStatement.clearBindings();
                                sqLiteStatement.bindString(1, getProfileName());
                                sqLiteStatement.bindString(2, bluetoothDevice.getAddress());
                                sqLiteStatement.executeUpdateDelete();
                            }

                            sqLiteDatabase.setTransactionSuccessful();
                        }
                    }
                } finally {
                    sqLiteDatabase.endTransaction();
                }
            }
        }
    }

    /**
     * get bonded devices
     *
     * @return this bluetooth profile's bonded device set
     */
    @NonNull
    public synchronized Set<BluetoothDevice> getBondedDevices() {
        Set<BluetoothDevice> bondedDeviceSet = new HashSet<>();
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter != null) {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            sqLiteDatabase.beginTransaction();
            try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT ADDRESS FROM BONDED_DEVICE_TABLE WHERE PROFILE_NAME = ?", new String[]{getProfileName()})) {
                if (cursor.moveToFirst()) {
                    do {
                        bondedDeviceSet.add(bluetoothAdapter.getRemoteDevice(cursor.getString(cursor.getColumnIndex("ADDRESS"))));
                    } while (cursor.moveToNext());
                }
            } finally {
                sqLiteDatabase.endTransaction();
            }
        }
        return bondedDeviceSet;
    }

}
