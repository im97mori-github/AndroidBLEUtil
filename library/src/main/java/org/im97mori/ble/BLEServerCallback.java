package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;

public interface BLEServerCallback {
    boolean onCharacteristicReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, int offset, BluetoothGattCharacteristic characteristic);

    boolean onCharacteristicWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, BluetoothGattCharacteristic characteristic, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value);

    boolean onDescriptorReadRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, int offset, BluetoothGattDescriptor descriptor);

    boolean onDescriptorWriteRequest(BluetoothGattServer bluetoothGattServer, BluetoothDevice device, int requestId, BluetoothGattDescriptor descriptor, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value);
}