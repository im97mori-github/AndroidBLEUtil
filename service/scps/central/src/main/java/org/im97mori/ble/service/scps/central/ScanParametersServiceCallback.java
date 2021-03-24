package org.im97mori.ble.service.scps.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a31.ScanRefreshAndroid;
import org.im97mori.ble.characteristic.u2a4f.ScanIntervalWindowAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;

import java.util.UUID;

/**
 * Scan Parameters Service (Service UUID: 0x1813) callback
 */
public interface ScanParametersServiceCallback {

    /**
     * Write Scan Interval Window success callback
     *
     * @param taskId                    task id
     * @param bluetoothDevice           BLE device
     * @param serviceUUID               service {@link UUID}
     * @param serviceInstanceId         task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID        characteristic {@link UUID}
     * @param characteristicInstanceId  task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param scanIntervalWindowAndroid {@link ScanIntervalWindowAndroid}
     * @param argument                  callback argument
     */
    void onScanIntervalWindowWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull ScanIntervalWindowAndroid scanIntervalWindowAndroid
            , @Nullable Bundle argument);

    /**
     * Write Scan Interval Window error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   one of {@link BLEConnection#onCharacteristicRead(BluetoothGatt, BluetoothGattCharacteristic, int)} 3rd parameter, {@link org.im97mori.ble.BLEConstants.ErrorCodes#UNKNOWN}, {@link org.im97mori.ble.BLEConstants.ErrorCodes#CANCEL}, {@link org.im97mori.ble.BLEConstants.ErrorCodes#BUSY}
     * @param argument                 callback argument
     */
    void onScanIntervalWindowWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Scan Interval Window timeout callback
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
    void onScanIntervalWindowWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Read Scan Refresh's Client Characteristic Configuration success callback
     *
     * @param taskId                                   task id
     * @param bluetoothDevice                          BLE device
     * @param serviceUUID                              service {@link UUID}
     * @param serviceInstanceId                        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID                       characteristic {@link UUID}
     * @param characteristicInstanceId                 task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId                     task target descriptor incetanceId
     * @param clientCharacteristicConfigurationAndroid {@link ClientCharacteristicConfigurationAndroid}
     * @param argument                                 callback argument
     */
    void onScanRefreshClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid
            , @Nullable Bundle argument);

    /**
     * Read Scan Refresh's Client Characteristic Configuration error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param status                   one of {@link BLEConnection#onDescriptorRead(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter, {@link org.im97mori.ble.BLEConstants.ErrorCodes#UNKNOWN}, {@link org.im97mori.ble.BLEConstants.ErrorCodes#CANCEL}, {@link org.im97mori.ble.BLEConstants.ErrorCodes#BUSY}
     * @param argument                 callback argument
     */
    void onScanRefreshClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Read Scan Refresh's Client Characteristic Configuration timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onScanRefreshClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Start Scan Refresh notificate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param argument                 callback argument
     */
    void onScanRefreshNotificateStartSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Start Scan Refresh notificate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param status                   one of {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter, {@link org.im97mori.ble.BLEConstants.ErrorCodes#UNKNOWN}, {@link org.im97mori.ble.BLEConstants.ErrorCodes#CANCEL}, {@link org.im97mori.ble.BLEConstants.ErrorCodes#BUSY}
     * @param argument                 callback argument
     */
    void onScanRefreshNotificateStartFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Start Scan Refresh notificate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onScanRefreshNotificateStartTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Stop Scan Refresh notificate success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param argument                 callback argument
     */
    void onScanRefreshNotificateStopSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @NonNull Integer descriptorInstanceId
            , @Nullable Bundle argument);

    /**
     * Stop Scan Refresh notificate error callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param status                   one of {@link BLEConnection#onDescriptorWrite(BluetoothGatt, BluetoothGattDescriptor, int)} 3rd parameter, {@link org.im97mori.ble.BLEConstants.ErrorCodes#UNKNOWN}, {@link org.im97mori.ble.BLEConstants.ErrorCodes#CANCEL}, {@link org.im97mori.ble.BLEConstants.ErrorCodes#BUSY}
     * @param argument                 callback argument
     */
    void onScanRefreshNotificateStopFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Stop Scan Refresh notificate timeout callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param descriptorInstanceId     task target descriptor incetanceId
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     */
    void onScanRefreshNotificateStopTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , @Nullable Integer descriptorInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Scan Refresh notified callback
     *
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param scanRefreshAndroid    {@link ScanRefreshAndroid}
     */
    void onScanRefreshNotified(@NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull ScanRefreshAndroid scanRefreshAndroid);

}
