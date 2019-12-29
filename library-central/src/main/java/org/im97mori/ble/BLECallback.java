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
     * @param status          one of {@link BLEConnection#onConnectionStateChange(BluetoothGatt, int, int)} 2nd parameter, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}
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
     * @param status          one of {@link BLEConnection#onConnectionStateChange(BluetoothGatt, int, int)} 2nd parameter, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}
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
     * @param status          one of {@link BLEConnection#onServicesDiscovered(BluetoothGatt, int)} 2nd parameter, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}, {@link BLEConstants.ErrorCodes#BUSY}
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
     * @param status          one of {@link BLEConnection#onMtuChanged(BluetoothGatt, int, int)} 2nd parameter, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}, {@link BLEConstants.ErrorCodes#BUSY}
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
     */
    void onRequestMtuTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument);

    /**
     * Read characteristic success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param values                   {@link BluetoothGattCharacteristic#getValue()}
     * @param argument                 callback argument
     */
    void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument);

    /**
     * Read characteristic error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}, {@link BLEConstants.ErrorCodes#BUSY}
     * @param argument                 callback argument
     */
    void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument);

    /**
     * Read characteristic timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument);

    /**
     * Write characteristic success callback
     *
     * @param taskId             task id
     * @param bluetoothDevice    BLE device
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param values             {@link BluetoothGattCharacteristic#getValue()}
     * @param argument           callback argument
     */
    void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, @Nullable Bundle argument);

    /**
     * Write characteristic error callback
     *
     * @param taskId             task id
     * @param bluetoothDevice    BLE device
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param status             one of {@link BLEConnection#onCharacteristicWrite(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}, {@link BLEConstants.ErrorCodes#BUSY}
     * @param argument           callback argument
     * @see BLEConstants.ErrorCodes
     */
    void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, @Nullable Bundle argument);

    /**
     * Write characteristic timeout callback
     *
     * @param taskId             task id
     * @param bluetoothDevice    BLE device
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param timeout            timeout(millis)
     * @param argument           callback argument
     */
    void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, @Nullable Bundle argument);

    /**
     * Read descriptor success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           descriptor  {@link UUID}
     * @param values                   {@link BluetoothGattDescriptor#getValue()}
     */
    void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument);

    /**
     * Read descriptor error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           descriptor  {@link UUID}
     * @param status                   one of {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}, {@link BLEConstants.ErrorCodes#BUSY}
     * @param argument                 callback argument
     */
    void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument);

    /**
     * Read descriptor timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorUUID           descriptor  {@link UUID}
     * @param timeout                  timeout(millis)
     */
    void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument);

    /**
     * Write descriptor success callback
     *
     * @param taskId             task id
     * @param bluetoothDevice    BLE device
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor  {@link UUID}
     * @param values             {@link BluetoothGattDescriptor#getValue()}
     * @param argument           callback argument
     */
    void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument);

    /**
     * Write descriptor error callback
     *
     * @param taskId             task id
     * @param bluetoothDevice    BLE device
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param status             one of {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}, {@link BLEConstants.ErrorCodes#BUSY}
     * @param argument           callback argument
     * @see BLEConstants.ErrorCodes
     */
    void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument);

    /**
     * Write descriptor timeout callback
     *
     * @param taskId             task id
     * @param bluetoothDevice    BLE device
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor  {@link UUID}
     * @param timeout            timeout(millis)
     * @param argument           callback argument
     */
    void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument);

    /**
     * Notification characteristic callback
     *
     * @param bluetoothDevice    BLE device
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param values             {@link BluetoothGattCharacteristic#getValue()}
     */
    void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values);

    /**
     * Read phy success callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param txPhy           {@link android.bluetooth.BluetoothGattCallback#onPhyRead(BluetoothGatt, int, int, int)} 2nd argument
     * @param rxPhy           {@link android.bluetooth.BluetoothGattCallback#onPhyRead(BluetoothGatt, int, int, int)} 3rd argument
     * @param argument        callback argument
     */
    void onReadPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, @Nullable Bundle argument);

    /**
     * Read phy error callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param status          one of {@link BLEConnection#onPhyRead(BluetoothGatt, int, int, int)} 4th parameter, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}, {@link BLEConstants.ErrorCodes#BUSY}
     * @param argument        callback argument
     */
    void onReadPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Read phy timeout callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param timeout         timeout(millis)
     * @param argument        callback argument
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
     */
    void onSetPreferredPhySuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int txPhy, int rxPhy, int phyOptions, @Nullable Bundle argument);

    /**
     * Set preferred phy error callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param status          one of {@link BLEConnection#onPhyRead(BluetoothGatt, int, int, int)} 4th parameter, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}, {@link BLEConstants.ErrorCodes#BUSY}
     * @param argument        callback argument
     */
    void onSetPreferredPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Set preferred phy timeout callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param timeout         timeout(millis)
     * @param argument        callback argument
     */
    void onSetPreferredPhyTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument);

    /**
     * Read remote rssi success callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param rssi            {@link android.bluetooth.BluetoothGattCallback#onReadRemoteRssi(BluetoothGatt, int, int)} 2nd argument
     * @param argument        callback argument
     */
    void onReadRemoteRssiSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int rssi, @Nullable Bundle argument);

    /**
     * Read remote rssi error callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param status          one of {@link BLEConnection#onReadRemoteRssi(BluetoothGatt, int, int)} 3rd parameter, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}, {@link BLEConstants.ErrorCodes#BUSY}
     * @param argument        callback argument
     */
    void onReadRemoteRssiFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Read remote rssi timeout callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param timeout         timeout(millis)
     * @param argument        callback argument
     */
    void onReadRemoteRssiTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument);

    /**
     * Begin reliable write success callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param argument        callback argument
     */
    void onBeginReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument);

    /**
     * Begin reliable write error callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param status          one of {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}
     * @param argument        callback argument
     */
    void onBeginReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Execute reliable write success callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param argument        callback argument
     */
    void onExecuteReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument);

    /**
     * Execute reliable write error callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param status          one of {@link BluetoothGattCallback#onReliableWriteCompleted} 2nd argument, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}
     * @param argument        callback argument
     */
    void onExecuteReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Execute reliable write timeout callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param timeout         timeout(millis)
     * @param argument        callback argument
     */
    void onExecuteReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument);

    /**
     * Execute reliable write success callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param argument        callback argument
     */
    void onAbortReliableWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument);

    /**
     * Abort reliable write error callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param status          one of {@link BluetoothGattCallback#onReliableWriteCompleted} 2nd argument, {@link BLEConstants.ErrorCodes#CANCEL}
     * @param argument        callback argument
     */
    void onAbortReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Abort reliable write timeout callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param timeout         timeout(millis)
     * @param argument        callback argument
     */
    void onAbortReliableWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument);

}
