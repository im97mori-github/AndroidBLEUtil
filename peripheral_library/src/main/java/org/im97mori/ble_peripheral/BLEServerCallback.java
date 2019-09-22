package org.im97mori.ble_peripheral;

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
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEConstants.ErrorCodes;
import org.im97mori.ble_peripheral.characteristic.MockControl;

import java.util.List;
import java.util.UUID;

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
     * Central connected callback
     *
     * @param device central BLE device
     */
    void onDeviceConnected(BluetoothDevice device);

    /**
     * Central disconnected callback
     *
     * @param device central BLE device
     */
    void onDeviceDisconnected(BluetoothDevice device);

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
    boolean onCharacteristicReadRequest(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattCharacteristic characteristic);

    /**
     * @return {@code true}:{@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} success or dont need response, {@code false}:need call {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} but not called
     * @see BluetoothGattServerCallback#onCharacteristicWriteRequest(BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[])
     */
    boolean onCharacteristicWriteRequest(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattCharacteristic characteristic, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value);

    /**
     * @return {@code true}:{@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} success or dont need response, {@code false}:need call {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} but not called
     * @see BluetoothGattServerCallback#onDescriptorReadRequest(BluetoothDevice, int, int, BluetoothGattDescriptor)
     */
    boolean onDescriptorReadRequest(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattDescriptor descriptor);

    /**
     * @return {@code true}:{@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} success or dont need response, {@code false}:need call {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} but not called
     * @see BluetoothGattServerCallback#onDescriptorWriteRequest(BluetoothDevice, int, BluetoothGattDescriptor, boolean, boolean, int, byte[])
     */
    boolean onDescriptorWriteRequest(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattDescriptor descriptor, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value);

    /**
     * Notification(Indication) success callback
     *
     * @param taskId              task id
     * @param bluetoothGattServer {@link BluetoothGattServer} instance
     * @param device              BLE device
     * @param serviceUUID         service {@link UUID}
     * @param characteristicUUID  characteristic {@link UUID}
     * @param value               one of {@link BluetoothGattDescriptor#ENABLE_NOTIFICATION_VALUE}, {@link BluetoothGattDescriptor#ENABLE_INDICATION_VALUE}, {@link BluetoothGattDescriptor#DISABLE_NOTIFICATION_VALUE}
     * @param argument            callback argument
     */
    void onNotificationSuccess(@NonNull Integer taskId, @NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] value, @Nullable Bundle argument);

    /**
     * Notification(Indication) error callback
     *
     * @param taskId              task id
     * @param bluetoothGattServer {@link BluetoothGattServer} instance
     * @param device              BLE device
     * @param serviceUUID         service {@link UUID}
     * @param characteristicUUID  characteristic {@link UUID}
     * @param status              one of {@link ErrorCodes#UNKNOWN}, {@link ErrorCodes#CANCEL}, {@link ErrorCodes#BUSY}
     * @param argument            callback argument
     */
    void onNotificationFailed(@NonNull Integer taskId, @NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, @Nullable Bundle argument);

    /**
     * Client Characteristic Configuration (Descriptor UUID: 0x2902) updated callback
     *
     * @param bluetoothGattServer {@link BluetoothGattServer} instance
     * @param device              BLE device
     * @param serviceUUID         service {@link UUID}
     * @param characteristicUUID  characteristic {@link UUID}
     * @param value               one of {@link BluetoothGattDescriptor#ENABLE_NOTIFICATION_VALUE}, {@link BluetoothGattDescriptor#ENABLE_INDICATION_VALUE}, {@link BluetoothGattDescriptor#DISABLE_NOTIFICATION_VALUE}
     */
    void onClientCharacteristicConfigurationUpdated(@NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] value);

    /**
     * Mock updated (Characterisitc UUID:{@link BLEServerConnection#MOCK_CONTROL_CHARACTERISTIC_UUID}) callback
     *
     * @param device      BLE device
     * @param mockControl mock data
     */
    void onMockUpdated(@NonNull BluetoothDevice device, @NonNull MockControl mockControl);

}