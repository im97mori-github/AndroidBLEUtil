package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.task.NotifiedTask;

import java.util.List;
import java.util.UUID;

/**
 * BLE callback
 */
public interface BLECallback {

    /**
     * Connected callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param argument        callback argument
     * @see BluetoothGatt#connect()
     * @see BLEConnection#onConnectionStateChange(BluetoothGatt, int, int)
     * @see BLEConnection#onServicesDiscovered(BluetoothGatt, int)
     * @see org.im97mori.ble.task.ConnectTask
     */
    void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument);

    /**
     * Connect error callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param status          {@link BLEConnection#onConnectionStateChange(BluetoothGatt, int, int)} 2nd parameter
     *                        {@link org.im97mori.ble.task.ConnectTask#STATUS_CANCEL}
     *                        {@link org.im97mori.ble.task.ConnectTask#STATUS_CONNECT_GATT_FAILED}
     *                        {@link org.im97mori.ble.task.ConnectTask#STATUS_DISCOVER_SERVICES_FAILED}
     * @param argument        callback argument
     * @see BLEConnection#onConnectionStateChange(BluetoothGatt, int, int)
     * @see org.im97mori.ble.task.ConnectTask
     */
    void onBLEConnectFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Connect task timeout callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param argument        callback argumentF
     * @see BluetoothGatt#connect()
     * @see org.im97mori.ble.task.ConnectTask
     */
    void onBLEConnectTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument);

    /**
     * Disconnected callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param status          {@link BLEConnection#onConnectionStateChange(BluetoothGatt, int, int)} 2nd parameter
     *                        {@link org.im97mori.ble.task.DisconnectTask#STATUS_CANCEL}
     *                        {@link org.im97mori.ble.task.DisconnectTask#STATUS_MANUAL_DISCONNECT}
     * @param argument        callback argument
     * @see BluetoothGatt#disconnect()
     * @see BluetoothGatt#close()
     * @see BLEConnection#onConnectionStateChange(BluetoothGatt, int, int)
     * @see BLEConnection#quit()
     * @see org.im97mori.ble.task.DisconnectTask
     */
    void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Discover service success callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param serviceList     {@link BluetoothGatt#getServices()}
     * @param argument        callback argument
     * @see org.im97mori.ble.task.DiscoverServiceTask
     */
    void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument);

    /**
     * Discover service error callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param status          {@link BLEConnection#onServicesDiscovered(BluetoothGatt, int)} 2nd parameter
     *                        {@link org.im97mori.ble.task.DiscoverServiceTask#STATUS_CANCEL}
     *                        {@link org.im97mori.ble.task.DiscoverServiceTask#STATUS_DISCOVER_SERVICES_FAILED}
     * @param argument        callback argument
     * @see org.im97mori.ble.task.DiscoverServiceTask
     */
    void onDiscoverServiceFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Discover service timeout callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param timeout         timeout(millis)
     * @param argument        callback argument
     * @see org.im97mori.ble.task.DiscoverServiceTask
     */
    void onDiscoverServiceTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument);

    /**
     * Request mtu success callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param mtu             new mtu from  {@link android.bluetooth.BluetoothGattCallback#onMtuChanged(BluetoothGatt, int, int)} 2nd argument
     * @param argument        callback argument
     * @see org.im97mori.ble.task.RequestMtuTask
     */
    void onRequestMtuSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int mtu, @Nullable Bundle argument);

    /**
     * Request mtu error callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param status          {@link BLEConnection#onMtuChanged(BluetoothGatt, int, int)} 3rd parameter
     *                        {@link org.im97mori.ble.task.RequestMtuTask#STATUS_CANCEL}
     *                        {@link org.im97mori.ble.task.RequestMtuTask#STATUS_REQUEST_MTU_FAILED}
     * @param argument        callback argument
     * @see org.im97mori.ble.task.RequestMtuTask
     */
    void onRequestMtuFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Request mtu timeout callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param timeout         timeout(millis)
     * @param argument        callback argument
     * @see org.im97mori.ble.task.RequestMtuTask
     */
    void onRequestMtuTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument);

    /**
     * Read characteristic success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service Instance Id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic Instance Id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param values                   {@link BluetoothGattCharacteristic#getValue()}
     * @param argument                 callback argument
     * @see org.im97mori.ble.task.ReadCharacteristicTask
     */
    void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument);

    /**
     * Read characteristic error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service Instance Id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic Instance Id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadCharacteristicTask#STATUS_READ_CHARACTERISTIC_FAILED}
     * @param argument                 callback argument
     * @see org.im97mori.ble.task.ReadCharacteristicTask
     */
    void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument);

    /**
     * Read characteristic timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service Instance Id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic Instance Id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     * @see org.im97mori.ble.task.ReadCharacteristicTask
     */
    void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument);

    /**
     * Write characteristic success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service Instance Id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic Instance Id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param values                   {@link BluetoothGattCharacteristic#getValue()}
     * @param argument                 callback argument
     * @see org.im97mori.ble.task.WriteCharacteristicTask
     */
    void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument);

    /**
     * Write characteristic error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service Instance Id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic Instance Id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   {@link BLEConnection#onCharacteristicWrite(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter
     *                                 {@link BluetoothGatt#writeCharacteristic(BluetoothGattCharacteristic, byte[], int)} result
     *                                 {@link org.im97mori.ble.task.WriteCharacteristicTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteCharacteristicTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteCharacteristicTask#STATUS_WRITE_CHARACTERISTIC_NOT_FOUND}
     * @param argument                 callback argument
     * @see org.im97mori.ble.task.WriteCharacteristicTask
     */
    void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument);

    /**
     * Write characteristic timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service Instance Id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic Instance Id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     * @see org.im97mori.ble.task.WriteCharacteristicTask
     */
    void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument);

    /**
     * Read descriptor success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service Instance Id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic Instance Id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           descriptor  {@link UUID}
     * @param descriptorInstanceId     task target descriptor Instance Id
     * @param values                   {@link BluetoothGattDescriptor#getValue()}
     * @see org.im97mori.ble.task.ReadDescriptorTask
     */
    void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument);

    /**
     * Read descriptor error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service Instance Id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic Instance Id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           descriptor  {@link UUID}
     * @param descriptorInstanceId     task target descriptor Instance Id
     * @param status                   {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int, byte[])} 3rd parameter
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.ReadDescriptorTask#STATUS_READ_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     * @see org.im97mori.ble.task.ReadDescriptorTask
     */
    void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument);

    /**
     * Read descriptor timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service Instance Id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic Instance Id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           descriptor  {@link UUID}
     * @param descriptorInstanceId     task target descriptor Instance Id
     * @param timeout                  timeout(millis)
     * @see org.im97mori.ble.task.ReadDescriptorTask
     */
    void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument);

    /**
     * Write descriptor success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service Instance Id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic Instance Id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           descriptor  {@link UUID}
     * @param descriptorInstanceId     task target descriptor Instance Id
     * @param values                   {@link BluetoothGattDescriptor#getValue()}
     * @param argument                 callback argument
     * @see org.im97mori.ble.task.WriteDescriptorTask
     */
    void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument);

    /**
     * Write descriptor error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service Instance Id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic Instance Id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor Instance Id
     * @param status                   {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter
     *                                 {@link BluetoothGatt#writeDescriptor(BluetoothGattDescriptor, byte[])} result
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_DESCRIPTOR_NOT_FOUND}
     *                                 {@link org.im97mori.ble.task.WriteDescriptorTask#STATUS_WRITE_DESCRIPTOR_FAILED}
     * @param argument                 callback argument
     * @see org.im97mori.ble.task.WriteDescriptorTask
     */
    void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument);

    /**
     * Write descriptor timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service Instance Id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic Instance Id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           descriptor  {@link UUID}
     * @param descriptorInstanceId     task target descriptor Instance Id
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     * @see org.im97mori.ble.task.WriteDescriptorTask
     */
    void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument);

    /**
     * Notification characteristic callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId characteristic Instance Id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param values                   {@link BluetoothGattCharacteristic#getValue()}
     * @see NotifiedTask
     */
    void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values);

    /**
     * Read phy success callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param txPhy           {@link android.bluetooth.BluetoothGattCallback#onPhyRead(BluetoothGatt, int, int, int)} 2nd argument
     * @param rxPhy           {@link android.bluetooth.BluetoothGattCallback#onPhyRead(BluetoothGatt, int, int, int)} 3rd argument
     * @param argument        callback argument
     * @see org.im97mori.ble.task.ReadPhyTask
     */
    void onReadPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, @Nullable Bundle argument);

    /**
     * Read phy error callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param status          {@link BLEConnection#onPhyRead(BluetoothGatt, int, int, int)} 4th parameter
     *                        {@link org.im97mori.ble.task.ReadPhyTask#STATUS_CANCEL}
     * @param argument        callback argument
     * @see org.im97mori.ble.task.ReadPhyTask
     */
    void onReadPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Read phy timeout callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param timeout         timeout(millis)
     * @param argument        callback argument
     * @see org.im97mori.ble.task.ReadPhyTask
     */
    void onReadPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument);

    /**
     * Set preferred phy success callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param txPhy           {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 2nd argument
     * @param rxPhy           {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 3rd argument
     * @param phyOptions      {@link android.bluetooth.BluetoothGatt#setPreferredPhy(int, int, int)} 3rd argument
     * @param argument        callback argument
     * @see org.im97mori.ble.task.SetPreferredPhyTask
     */
    void onSetPreferredPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, int phyOptions, @Nullable Bundle argument);

    /**
     * Set preferred phy error callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param status          {@link BLEConnection#onPhyRead(BluetoothGatt, int, int, int)} 4th parameter
     *                        {@link org.im97mori.ble.task.SetPreferredPhyTask#STATUS_CANCEL}
     * @param argument        callback argument
     * @see org.im97mori.ble.task.SetPreferredPhyTask
     */
    void onSetPreferredPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Set preferred phy timeout callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param timeout         timeout(millis)
     * @param argument        callback argument
     * @see org.im97mori.ble.task.SetPreferredPhyTask
     */
    void onSetPreferredPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument);

    /**
     * Read remote rssi success callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param rssi            {@link android.bluetooth.BluetoothGattCallback#onReadRemoteRssi(BluetoothGatt, int, int)} 2nd argument
     * @param argument        callback argument
     * @see org.im97mori.ble.task.ReadRemoteRssiTask
     */
    void onReadRemoteRssiSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int rssi, @Nullable Bundle argument);

    /**
     * Read remote rssi error callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param status          {@link BLEConnection#onReadRemoteRssi(BluetoothGatt, int, int)} 3rd parameter
     *                        {@link org.im97mori.ble.task.ReadRemoteRssiTask#STATUS_CANCEL}
     *                        {@link org.im97mori.ble.task.ReadRemoteRssiTask#STATUS_READ_REMOTE_RSSI_FAILED}
     * @param argument        callback argument
     * @see org.im97mori.ble.task.ReadRemoteRssiTask
     */
    void onReadRemoteRssiFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Read remote rssi timeout callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param timeout         timeout(millis)
     * @param argument        callback argument
     * @see org.im97mori.ble.task.ReadRemoteRssiTask
     */
    void onReadRemoteRssiTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument);

    /**
     * Begin reliable write success callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param argument        callback argument
     * @see org.im97mori.ble.task.BeginReliableWriteTask
     */
    void onBeginReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument);

    /**
     * Begin reliable write error callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param status          {@link org.im97mori.ble.task.BeginReliableWriteTask#STATUS_CANCEL}
     *                        {@link org.im97mori.ble.task.BeginReliableWriteTask#STATUS_BEGIN_RELIABLE_WRITE_FAILED}
     * @param argument        callback argument
     * @see org.im97mori.ble.task.BeginReliableWriteTask
     */
    void onBeginReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Execute reliable write success callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param argument        callback argument
     * @see org.im97mori.ble.task.ExecuteReliableWriteTask
     */
    void onExecuteReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument);

    /**
     * Execute reliable write error callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param status          {@link BluetoothGattCallback#onReliableWriteCompleted(BluetoothGatt, int)} 2nd argument
     *                        {@link org.im97mori.ble.task.ExecuteReliableWriteTask#STATUS_CANCEL}
     *                        {@link org.im97mori.ble.task.ExecuteReliableWriteTask#STATUS_EXECUTE_RELIABLE_WRITE_FAILED}
     * @param argument        callback argument
     * @see org.im97mori.ble.task.ExecuteReliableWriteTask
     */
    void onExecuteReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Execute reliable write timeout callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param timeout         timeout(millis)
     * @param argument        callback argument
     * @see org.im97mori.ble.task.ExecuteReliableWriteTask
     */
    void onExecuteReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument);

    /**
     * Abort reliable write success callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param argument        callback argument
     * @see org.im97mori.ble.task.AbortReliableWriteTask
     */
    void onAbortReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument);

    /**
     * Abort reliable write error callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param status          {@link BluetoothGattCallback#onReliableWriteCompleted} 2nd argument
     *                        {@link org.im97mori.ble.task.AbortReliableWriteTask#STATUS_CANCEL}
     * @param argument        callback argument
     * @see org.im97mori.ble.task.AbortReliableWriteTask
     */
    void onAbortReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Abort reliable write timeout callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param timeout         timeout(millis)
     * @param argument        callback argument
     * @see org.im97mori.ble.task.AbortReliableWriteTask
     */
    void onAbortReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument);

    /**
     * Set Notification success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service Instance Id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic Instance Id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param notificationStatus       {@link BluetoothGatt#setCharacteristicNotification(BluetoothGattCharacteristic, boolean)} 2nd parameter
     * @param argument                 callback argument
     * @see org.im97mori.ble.task.SetNotifyTask
     */
    void onSetNotificationSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, boolean notificationStatus, @Nullable Bundle argument);

    /**
     * Set Notification error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service Instance Id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic Instance Id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param notificationStatus       {@link BluetoothGatt#setCharacteristicNotification(BluetoothGattCharacteristic, boolean)} 2nd parameter
     * @param status                   {@link org.im97mori.ble.task.SetNotifyTask#STATUS_CANCEL}
     *                                 {@link org.im97mori.ble.task.SetNotifyTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     * @param argument                 callback argument
     * @see org.im97mori.ble.task.SetNotifyTask
     */
    void onSetNotificationFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, boolean notificationStatus, int status, @Nullable Bundle argument);

    /**
     * Service Changed callback
     *
     * @param bluetoothDevice          BLE device
     * @see org.im97mori.ble.task.ServiceChangedTask
     */
    void onServiceChanged(@NonNull BluetoothDevice bluetoothDevice);
}
