package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Bundle;

import java.util.UUID;

/**
 * BLE callback
 */
@SuppressWarnings("JavadocReference")
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
    void onBLEConnected(long taskId, BluetoothDevice bluetoothDevice, Bundle argument);

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
    void onBLEConnectFailed(long taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument);

    /**
     * Connect task timeout callback
     *
     * @param taskId          task id
     * @param bluetoothDevice BLE device
     * @param argument        callback argumentF
     * @see BluetoothGatt#connect()
     * @see org.im97mori.ble.task.ConnectTask
     */
    void onBLEConnectTimeout(long taskId, BluetoothDevice bluetoothDevice, Bundle argument);

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
    void onBLEDisonnected(long taskId, BluetoothDevice bluetoothDevice, int status, Bundle argument);

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
    void onCharacteristicReadSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument);

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
    void onCharacteristicReadFailed(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument);

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
    void onCharacteristicReadTimeout(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument);

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
    void onCharacteristicWriteSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values, Bundle argument);

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
    void onCharacteristicWriteFailed(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, int status, Bundle argument);

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
    void onCharacteristicWriteTimeout(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, long timeout, Bundle argument);

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
    void onDescriptorReadSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument);

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
    void onDescriptorReadFailed(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument);

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
    void onDescriptorReadTimeout(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument);

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
    void onDescriptorWriteSuccess(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, byte[] values, Bundle argument);

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
    void onDescriptorWriteFailed(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, int status, Bundle argument);

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
    void onDescriptorWriteTimeout(long taskId, BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, UUID descriptorUUID, long timeout, Bundle argument);

    /**
     * Notification characteristic callback
     *
     * @param bluetoothDevice    BLE device
     * @param serviceUUID        service {@link UUID}
     * @param characteristicUUID characteristic {@link UUID}
     * @param values             {@link BluetoothGattCharacteristic#getValue()}
     */
    void onCharacteristicNotified(BluetoothDevice bluetoothDevice, UUID serviceUUID, UUID characteristicUUID, byte[] values);

}
