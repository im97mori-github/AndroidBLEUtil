package org.im97mori.ble.advertising.filter;

import android.bluetooth.BluetoothDevice;

import androidx.annotation.NonNull;

import org.im97mori.ble.advertising.AdvertisingDataParser;

/**
 * Callback interface for {@link FilteredLeScanCallback}
 */
public interface FilteredLeScanCallbackInterface {

    /**
     * Filtered {@link FilteredLeScanCallback#onLeScan(BluetoothDevice, int, byte[])}
     *
     * @param device     {@link FilteredLeScanCallback#onLeScan(BluetoothDevice, int, byte[])} 1st parameter
     * @param rssi       {@link FilteredLeScanCallback#onLeScan(BluetoothDevice, int, byte[])} 2nd parameter
     * @param scanRecord {@link FilteredLeScanCallback#onLeScan(BluetoothDevice, int, byte[])} 3rd parameter
     * @param result     {@link org.im97mori.ble.advertising.AdvertisingDataParser.AdvertisingDataParseResult} instance, created from scanRecord byte array
     */
    void onFilteredLeScan(@NonNull BluetoothDevice device, int rssi, @NonNull byte[] scanRecord, @NonNull AdvertisingDataParser.AdvertisingDataParseResult result);

}
