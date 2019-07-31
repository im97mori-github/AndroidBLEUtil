package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;

import java.util.UUID;

/**
 * BLE callback
 */
public interface BLECallback {

    /**
     * Connected callback
     *
     * @param bluetoothDevice BLE device
     * @see BluetoothGatt#connect()
     * @see android.bluetooth.BluetoothGattCallback#onConnectionStateChange(BluetoothGatt, int, int)
     * @see android.bluetooth.BluetoothGattCallback#onServicesDiscovered(BluetoothGatt, int)
     * @see org.im97mori.ble.task.ConnectTask
     */
    void onBLEConnected(BluetoothDevice bluetoothDevice);

    /**
     * Connect task timeout callback
     *
     * @param bluetoothDevice BLE device
     * @see BluetoothGatt#connect()
     * @see org.im97mori.ble.task.ConnectTask
     */
    void onBLEConnectTimeout(BluetoothDevice bluetoothDevice);

    /**
     * Disconnected callback
     *
     * @param bluetoothDevice BLE device
     * @see BluetoothGatt#disconnect()
     * @see BluetoothGatt#close()
     * @see android.bluetooth.BluetoothGattCallback#onConnectionStateChange(BluetoothGatt, int, int)
     * @see BLEConnection#quit()
     * @see org.im97mori.ble.task.DisconnectTask
     */
    void onBLEDisonnected(BluetoothDevice bluetoothDevice);

    /**
     * Read characteristic success callback
     *
     * @param bluetoothDevice    BLE device
     * @param characteristicUUID characteristic {@link UUID}
     * @param values             {@link BluetoothGattCharacteristic#getValue()}
     */
    void onCharacteristicReadSuccess(BluetoothDevice bluetoothDevice, UUID characteristicUUID, byte[] values);

    /**
     * Read characteristic error callback
     *
     * @param bluetoothDevice    BLE device
     * @param characteristicUUID characteristic {@link UUID}
     * @param status             {@link android.bluetooth.BluetoothGattCallback#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter or {@link BLEConstants.ErrorCodes#UNKNOWN}
     * @see BLEConstants.ErrorCodes
     */
    void onCharacteristicReadFailed(BluetoothDevice bluetoothDevice, UUID characteristicUUID, int status);

    /**
     * Read characteristic timeout callback
     *
     * @param bluetoothDevice    BLE device
     * @param characteristicUUID characteristic {@link UUID}
     * @param timeout            timeout(millis)
     */
    void onCharacteristicReadTimeout(BluetoothDevice bluetoothDevice, UUID characteristicUUID, long timeout);

    /**
     * Write characteristic success callback
     *
     * @param bluetoothDevice    BLE device
     * @param characteristicUUID characteristic {@link UUID}
     * @param values             {@link BluetoothGattCharacteristic#getValue()}
     */
    void onCharacteristicWriteSuccess(BluetoothDevice bluetoothDevice, UUID characteristicUUID, byte[] values);

    /**
     * Write characteristic error callback
     *
     * @param bluetoothDevice    BLE device
     * @param characteristicUUID characteristic {@link UUID}
     * @param status             {@link android.bluetooth.BluetoothGattCallback#onCharacteristicWrite(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter or {@link BLEConstants.ErrorCodes#UNKNOWN}
     * @see BLEConstants.ErrorCodes
     */
    void onCharacteristicWriteFailed(BluetoothDevice bluetoothDevice, UUID characteristicUUID, int status);

    /**
     * Write characteristic timeout callback
     *
     * @param bluetoothDevice    BLE device
     * @param characteristicUUID characteristic {@link UUID}
     * @param timeout            timeout(millis)
     */
    void onCharacteristicWriteTimeout(BluetoothDevice bluetoothDevice, UUID characteristicUUID, long timeout);

    /**
     * Read descriptor success callback
     *
     * @param bluetoothDevice    BLE device
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor  {@link UUID}
     * @param values             {@link android.bluetooth.BluetoothGattDescriptor#getValue()}
     */
    void onDescriptorReadSuccess(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, byte[] values);

    /**
     * Read descriptor error callback
     *
     * @param bluetoothDevice    BLE device
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor  {@link UUID}
     * @param status             {@link android.bluetooth.BluetoothGattCallback#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter or {@link BLEConstants.ErrorCodes#UNKNOWN}
     * @see BLEConstants.ErrorCodes
     */
    void onDescriptorReadFailed(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, int status);

    /**
     * Read descriptor timeout callback
     *
     * @param bluetoothDevice    BLE device
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor  {@link UUID}
     * @param timeout            timeout(millis)
     */
    void onDescriptorReadTimeout(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, long timeout);

    /**
     * Write descriptor success callback
     *
     * @param bluetoothDevice    BLE device
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor  {@link UUID}
     * @param values             {@link android.bluetooth.BluetoothGattDescriptor#getValue()}
     */
    void onDescriptorWriteSuccess(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, byte[] values);


    /**
     * Write descriptor error callback
     *
     * @param bluetoothDevice    BLE device
     * @param characteristicUUID characteristic {@link UUID}
     * @param status             {@link android.bluetooth.BluetoothGattCallback#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter or {@link BLEConstants.ErrorCodes#UNKNOWN}
     * @see BLEConstants.ErrorCodes
     */
    void onDescriptorWriteFailed(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, int status);

    /**
     * Write descriptor timeout callback
     *
     * @param bluetoothDevice    BLE device
     * @param characteristicUUID characteristic {@link UUID}
     * @param descriptorUUID     descriptor  {@link UUID}
     * @param timeout            timeout(millis)
     */
    void onDescriptorWriteTimeout(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, long timeout);

    /**
     * Notification characteristic callback
     *
     * @param bluetoothDevice    BLE device
     * @param characteristicUUID characteristic {@link UUID}
     * @param values             {@link BluetoothGattCharacteristic#getValue()}
     */
    void onCharacteristicNotified(BluetoothDevice bluetoothDevice, UUID characteristicUUID, byte[] values);

}
