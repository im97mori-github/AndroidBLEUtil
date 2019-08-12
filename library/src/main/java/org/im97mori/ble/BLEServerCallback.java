package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.content.Context;

import java.util.List;

/**
 * BLE server callback
 */
public interface BLEServerCallback {

    /**
     * BLEServer start success callback
     *
     * @see android.bluetooth.BluetoothManager#openGattServer(Context, BluetoothGattServerCallback)
     * @see android.bluetooth.le.BluetoothLeAdvertiser#startAdvertising(AdvertiseSettings, AdvertiseData, AdvertiseCallback)
     */
    void onServerStarted();

    /**
     * BLEServer stopped or start failed callback
     */
    void onServerStopped();

    /**
     * BLEServer's {@link BluetoothGattService} list
     *
     * @return {@link BluetoothGattService} list
     * @see BluetoothGattServer#addService(BluetoothGattService)
     */
    List<BluetoothGattService> getBluetoothGattServiceList();

    /**
     * @return {@code true}:{@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} success or dont need response, {@code false}:need call {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} but not called
     * @see BluetoothGattServerCallback#onCharacteristicReadRequest(BluetoothDevice, int, int, BluetoothGattCharacteristic)
     */
    boolean onCharacteristicReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, int offset, BluetoothGattCharacteristic characteristic);

    /**
     * @return {@code true}:{@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} success or dont need response, {@code false}:need call {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} but not called
     * @see BluetoothGattServerCallback#onCharacteristicWriteRequest(BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[])
     */
    boolean onCharacteristicWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, BluetoothGattCharacteristic characteristic, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value);

    /**
     * @return {@code true}:{@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} success or dont need response, {@code false}:need call {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} but not called
     * @see BluetoothGattServerCallback#onDescriptorReadRequest(BluetoothDevice, int, int, BluetoothGattDescriptor)
     */
    boolean onDescriptorReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, int offset, BluetoothGattDescriptor descriptor);

    /**
     * @return {@code true}:{@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} success or dont need response, {@code false}:need call {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} but not called
     * @see BluetoothGattServerCallback#onDescriptorWriteRequest(BluetoothDevice, int, BluetoothGattDescriptor, boolean, boolean, int, byte[])
     */
    boolean onDescriptorWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, BluetoothGattDescriptor descriptor, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value);

}