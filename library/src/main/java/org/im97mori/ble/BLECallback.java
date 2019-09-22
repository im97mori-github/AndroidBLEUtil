package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
     * Read characteristic success callback
     *
     * @param taskId             task id
     * @param bluetoothDevice    BLE device
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param values             {@link BluetoothGattCharacteristic#getValue()}
     * @param argument           callback argument
     */
    void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull byte[] values, @Nullable Bundle argument);

    /**
     * Read characteristic error callback
     *
     * @param taskId             task id
     * @param bluetoothDevice    BLE device
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param status             one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}, {@link BLEConstants.ErrorCodes#BUSY}
     * @param argument           callback argument
     */
    void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, @Nullable Bundle argument);

    /**
     * Read characteristic timeout callback
     *
     * @param taskId             task id
     * @param bluetoothDevice    BLE device
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param timeout            timeout(millis)
     * @param argument           callback argument
     */
    void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, long timeout, @Nullable Bundle argument);

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
     * @param taskId             task id
     * @param bluetoothDevice    BLE device
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor  {@link UUID}
     * @param values             {@link BluetoothGattDescriptor#getValue()}
     */
    void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, @NonNull byte[] values, @Nullable Bundle argument);

    /**
     * Read descriptor error callback
     *
     * @param taskId             task id
     * @param bluetoothDevice    BLE device
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor  {@link UUID}
     * @param status             one of {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter, {@link BLEConstants.ErrorCodes#UNKNOWN}, {@link BLEConstants.ErrorCodes#CANCEL}, {@link BLEConstants.ErrorCodes#BUSY}
     * @param argument           callback argument
     */
    void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, int status, @Nullable Bundle argument);

    /**
     * Read descriptor timeout callback
     *
     * @param taskId             task id
     * @param bluetoothDevice    BLE device
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor  {@link UUID}
     * @param timeout            timeout(millis)
     */
    void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument);

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

}
