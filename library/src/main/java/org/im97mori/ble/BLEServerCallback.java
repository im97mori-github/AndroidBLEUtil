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
import android.os.Bundle;

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
    void onNotificationSuccess(long taskId, BluetoothGattServer bluetoothGattServer, BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] value, Bundle argument);

    /**
     * Notification(Indication) error callback
     *
     * @param taskId              task id
     * @param bluetoothGattServer {@link BluetoothGattServer} instance
     * @param device              BLE device
     * @param serviceUUID         service {@link UUID}
     * @param characteristicUUID  characteristic {@link UUID}
     * @param status              one of {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}, {@link BLEConstants.ErrorCodes#BUSY}
     * @param argument            callback argument
     */
    void onNotificationFailed(long taskId, BluetoothGattServer bluetoothGattServer, BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument);

    /**
     * Client Characteristic Configuration (Descriptor UUID: 0x2902) updated callback
     *
     * @param bluetoothGattServer {@link BluetoothGattServer} instance
     * @param device              BLE device
     * @param serviceUUID         service {@link UUID}
     * @param characteristicUUID  characteristic {@link UUID}
     * @param value               one of {@link BluetoothGattDescriptor#ENABLE_NOTIFICATION_VALUE}, {@link BluetoothGattDescriptor#ENABLE_INDICATION_VALUE}, {@link BluetoothGattDescriptor#DISABLE_NOTIFICATION_VALUE}
     */
    void onClientCharacteristicConfigurationUpdated(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, UUID serviceUUID, UUID characteristicUUID, byte[] value);

}