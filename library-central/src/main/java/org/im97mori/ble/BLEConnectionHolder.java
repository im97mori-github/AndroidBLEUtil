package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * application global {@link BLEConnection} instance cache
 */
@SuppressWarnings({"WeakerAccess", "UnusedReturnValue", "unchecked"})
public class BLEConnectionHolder {

    /**
     * BLEConnection map instance
     */
    private static final Map<BluetoothDevice, BLEConnection> CONNECTION_MAP = new LinkedHashMap<>();

    /**
     * get {@link BLEConnection} instance
     *
     * @param bluetoothDevice target BLE device
     * @return {@link BLEConnection} instance
     */
    @Nullable
    public static synchronized <T extends BLEConnection> T getInstance(@NonNull BluetoothDevice bluetoothDevice) {
        return (T) CONNECTION_MAP.get(bluetoothDevice);
    }

    /**
     * add {@link BLEConnection} instance
     *
     * @param bleConnection {@link BLEConnection} instance
     * @param force         {@code true}:overwrite current {@link BLEConnection} instance, {@code false}:dont overwrite
     * @return {@code true}:added, {@code false}:not added
     */
    public static synchronized boolean addInstance(@NonNull BLEConnection bleConnection, boolean force) {
        BluetoothDevice bluetoothDevice = bleConnection.getBluetoothDevice();
        boolean result = false;
        if (!CONNECTION_MAP.containsKey(bluetoothDevice) || force) {
            CONNECTION_MAP.put(bluetoothDevice, bleConnection);
            result = true;
        }
        return result;
    }

    /**
     * remove  {@link BLEConnection} instance
     *
     * @param bleConnection removed {@link BLEConnection} instance, or {@code null} when not removed
     */
    @Nullable
    public static synchronized <T extends BLEConnection> T removeInstance(@NonNull BLEConnection bleConnection) {
        BluetoothDevice bluetoothDevice = bleConnection.getBluetoothDevice();
        return (T) CONNECTION_MAP.remove(bluetoothDevice);
    }

    /**
     * {@link BLEConnection#quit()} all instance and clear cache
     */
    public static synchronized void clearInstance() {
        for (BLEConnection bleConnection : CONNECTION_MAP.values()) {
            bleConnection.quit();
        }
        CONNECTION_MAP.clear();
    }

}
