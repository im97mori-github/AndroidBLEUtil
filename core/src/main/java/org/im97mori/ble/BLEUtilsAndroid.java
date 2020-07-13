package org.im97mori.ble;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;

/**
 * BLE Core Utilities for Android
 */

public class BLEUtilsAndroid extends BLEUtils {

    /**
     * check bluetooth status
     *
     * @return {@code true}:bluetooth enabled, {@code false}:bluetooth disabled or no bluetooth feature
     */
    @SuppressLint("MissingPermission")
    public static boolean isBluetoothEnabled() {
        boolean result = false;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter != null) {
            result = bluetoothAdapter.isEnabled();
        }
        return result;
    }

    /**
     * convinience method for {@link BluetoothAdapter#enable()}
     *
     * @return return value of {@link BluetoothAdapter#enable()} or {@code false}:no bluetooth feature
     */
    @SuppressLint("MissingPermission")
    public static boolean bluetoothEnable() {
        boolean result = false;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter != null) {
            result = bluetoothAdapter.enable();
        }
        return result;
    }

    /**
     * convinience method for {@link BluetoothAdapter#disable()}
     *
     * @return return value of {@link BluetoothAdapter#disable()} or {@code false}:no bluetooth feature
     */
    @SuppressLint("MissingPermission")
    public static boolean bluetoothDisable() {
        boolean result = false;
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter != null) {
            result = bluetoothAdapter.disable();
        }
        return result;
    }

}
