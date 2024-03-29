package org.im97mori.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.task.NotifyTask;

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
     * @param bleServerConnection {@link BLEServerConnection} instance
     * @param device              central BLE device
     */
    void onDeviceConnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device);

    /**
     * Central disconnected callback
     *
     * @param bleServerConnection {@link BLEServerConnection} instance
     * @param device              central BLE device
     */
    void onDeviceDisconnected(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device);

    /**
     * Peripheral service add success callback
     *
     * @param taskId               task id
     * @param bleServerConnection  {@link BLEServerConnection} instance
     * @param bluetoothGattService {@link BluetoothGattService} instance
     * @param argument             callback argument
     * @return {@code true}:handled, {@code false}:not handled
     */
    boolean onServiceAddSuccess(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattService bluetoothGattService
            , @Nullable Bundle argument);

    /**
     * Peripheral service add error callback
     *
     * @param taskId               task id
     * @param bleServerConnection  {@link BLEServerConnection} instance
     * @param bluetoothGattService {@link BluetoothGattService} instance
     * @param status               {@link BluetoothGattServerCallback#onServiceAdded(int, BluetoothGattService)} 1st parameter
     *                             {@link org.im97mori.ble.task.AddServiceTask#STATUS_CANCEL}
     *                             {@link org.im97mori.ble.task.AddServiceTask#STATUS_ADD_SERVICE_FAILED}
     * @param argument             callback argument
     * @see org.im97mori.ble.task.AddServiceTask
     */
    void onServiceAddFailed(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattService bluetoothGattService
            , int status
            , @Nullable Bundle argument);

    /**
     * Peripheral service add timeout callback
     *
     * @param taskId               task id
     * @param bleServerConnection  {@link BLEServerConnection} instance
     * @param bluetoothGattService {@link BluetoothGattService} instance
     * @param timeout              timeout(millis)
     * @param argument             callback argument
     * @see org.im97mori.ble.task.AddServiceTask
     */
    void onServiceAddTimeout(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattService bluetoothGattService
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Peripheral service remove success callback
     *
     * @param taskId               task id
     * @param bleServerConnection  {@link BLEServerConnection} instance
     * @param bluetoothGattService {@link BluetoothGattService} instance
     * @param argument             callback argument
     * @see org.im97mori.ble.task.RemoveServiceTask
     */
    void onServiceRemoveSuccess(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattService bluetoothGattService
            , @Nullable Bundle argument);

    /**
     * Peripheral service remove error callback
     *
     * @param taskId               task id
     * @param bleServerConnection  {@link BLEServerConnection} instance
     * @param bluetoothGattService {@link BluetoothGattService} instance
     * @param status               {@link BluetoothGattServerCallback#onServiceAdded(int, BluetoothGattService)}
     *                             {@link org.im97mori.ble.task.RemoveServiceTask#STATUS_CANCEL}
     *                             {@link org.im97mori.ble.task.RemoveServiceTask#STATUS_REMOVE_SERVICE_FAILED}
     * @param argument             callback argument
     * @see org.im97mori.ble.task.RemoveServiceTask
     */
    void onServiceRemoveFailed(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattService bluetoothGattService
            , int status
            , @Nullable Bundle argument);

    /**
     * Peripheral service remove timeout callback
     *
     * @param taskId               task id
     * @param bleServerConnection  {@link BLEServerConnection} instance
     * @param bluetoothGattService {@link BluetoothGattService} instance
     * @param timeout              timeout(millis)
     * @param argument             callback argument
     * @see org.im97mori.ble.task.RemoveServiceTask
     */
    void onServiceRemoveTimeout(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothGattService bluetoothGattService
            , long timeout
            , @Nullable Bundle argument);

    /**
     * @param force {@code true}:callback must be handle, {@code false}:not must
     * @return {@code true}:handled, {@code false}:not handled
     * @see BluetoothGattServerCallback#onCharacteristicReadRequest(BluetoothDevice, int, int, BluetoothGattCharacteristic)
     */
    boolean onCharacteristicReadRequest(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , int offset
            , @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic
            , boolean force);

    /**
     * @param force {@code true}:callback must be handle, {@code false}:not must
     * @return {@code true}:handled, {@code false}:not handled
     * @see BluetoothGattServerCallback#onCharacteristicWriteRequest(BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[])
     */
    boolean onCharacteristicWriteRequest(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic
            , boolean preparedWrite
            , boolean responseNeeded
            , int offset
            , @NonNull byte[] value
            , boolean force);

    /**
     * @param force {@code true}:callback must be handle, {@code false}:not must
     * @return {@code true}:handled, {@code false}:not handled
     * @see BluetoothGattServerCallback#onDescriptorReadRequest(BluetoothDevice, int, int, BluetoothGattDescriptor)
     */
    boolean onDescriptorReadRequest(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , int offset
            , @NonNull BluetoothGattDescriptor bluetoothGattDescriptor
            , boolean force);

    /**
     * @param force {@code true}:callback must be handle, {@code false}:not must
     * @return {@code true}:handled, {@code false}:not handled
     * @see BluetoothGattServerCallback#onDescriptorWriteRequest(BluetoothDevice, int, BluetoothGattDescriptor, boolean, boolean, int, byte[])
     */
    boolean onDescriptorWriteRequest(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , @NonNull BluetoothGattDescriptor bluetoothGattDescriptor
            , boolean preparedWrite
            , boolean responseNeeded
            , int offset
            , @NonNull byte[] value
            , boolean force);

    /**
     * Notification(Indication) success callback
     *
     * @param taskId                   task id
     * @param bleServerConnection      {@link BLEServerConnection} instance
     * @param device                   BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param value                    {@link BluetoothGattDescriptor#ENABLE_NOTIFICATION_VALUE}
     *                                 {@link BluetoothGattDescriptor#ENABLE_INDICATION_VALUE}
     *                                 {@link BluetoothGattDescriptor#DISABLE_NOTIFICATION_VALUE}
     * @param argument                 callback argument
     * @see NotifyTask
     */
    void onNotificationSuccess(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , @NonNull UUID serviceUUID
            , int serviceInstanceId
            , @NonNull UUID characteristicUUID
            , int characteristicInstanceId
            , @NonNull byte[] value
            , @Nullable Bundle argument);

    /**
     * Notification(Indication) error callback
     *
     * @param taskId                   task id
     * @param bleServerConnection      {@link BLEServerConnection} instance
     * @param device                   BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param status                   {@link NotifyTask#STATUS_CANCEL}
     *                                 {@link NotifyTask#STATUS_CHARACTERISTIC_NOT_FOUND}
     *                                 {@link NotifyTask#STATUS_NOTIFY_CHARACTERISTIC_CHANGE_FAILED}
     * @param argument                 callback argument
     * @see NotifyTask
     */
    void onNotificationFailed(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , @NonNull UUID serviceUUID
            , int serviceInstanceId
            , @NonNull UUID characteristicUUID
            , int characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Notification(Indication) timeout callback
     *
     * @param taskId                   task id
     * @param bleServerConnection      {@link BLEServerConnection} instance
     * @param device                   BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service instance id {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic instance id {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param timeout                  timeout(millis)
     * @param argument                 callback argument
     * @see NotifyTask
     */
    void onNotificationTimeout(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , @NonNull UUID serviceUUID
            , int serviceInstanceId
            , @NonNull UUID characteristicUUID
            , int characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * @param force {@code true}:callback must be handle, {@code false}:not must
     * @return {@code true}:handled, {@code false}:not handled
     * @see BluetoothGattServerCallback#onExecuteWrite(BluetoothDevice, int, boolean)
     */
    boolean onExecuteWrite(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , boolean execute
            , boolean force);

    /**
     * MTU changed callback
     *
     * @param device The remote device that requested the MTU change
     * @param mtu    The new MTU size
     * @see BluetoothGattServerCallback#onMtuChanged(BluetoothDevice, int)
     */
    void onMtuChanged(@NonNull BluetoothDevice device
            , int mtu);

    /**
     * Read phy success callback
     *
     * @param taskId              task id
     * @param bleServerConnection {@link BLEServerConnection} instance
     * @param device              BLE device
     * @param txPhy               {@link android.bluetooth.BluetoothGattCallback#onPhyRead(BluetoothGatt, int, int, int)} 2nd argument
     * @param rxPhy               {@link android.bluetooth.BluetoothGattCallback#onPhyRead(BluetoothGatt, int, int, int)} 3rd argument
     * @param argument            callback argument
     * @see org.im97mori.ble.task.ReadPhyPeripheralTask
     */
    void onPhyReadSuccess(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int txPhy
            , int rxPhy
            , @Nullable Bundle argument);

    /**
     * Read phy error callback
     *
     * @param taskId              task id
     * @param bleServerConnection {@link BLEServerConnection} instance
     * @param device              BLE device
     * @param status              {@link BLEServerConnection#onPhyRead(BluetoothDevice, int, int, int)} 4th parameter
     *                            {@link org.im97mori.ble.task.ReadPhyPeripheralTask#STATUS_CANCEL}
     * @param argument            callback argument
     * @see org.im97mori.ble.task.ReadPhyPeripheralTask
     */
    void onPhyReadFailed(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int status
            , @Nullable Bundle argument);

    /**
     * Read phy timeout callback
     *
     * @param taskId              task id
     * @param bleServerConnection {@link BLEServerConnection} instance
     * @param device              BLE device
     * @param timeout             timeout(millis)
     * @param argument            callback argument
     * @see org.im97mori.ble.task.ReadPhyPeripheralTask
     */
    void onPhyReadTimeout(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Set preferred phy success callback
     *
     * @param taskId              task id
     * @param bleServerConnection {@link BLEServerConnection} instance
     * @param device              BLE device
     * @param txPhy               {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 2nd argument
     * @param rxPhy               {@link android.bluetooth.BluetoothGattCallback#onPhyUpdate(BluetoothGatt, int, int, int)} 3rd argument
     * @param phyOptions          {@link android.bluetooth.BluetoothGatt#setPreferredPhy(int, int, int)} 3rd argument
     * @param argument            callback argument
     * @see org.im97mori.ble.task.SetPreferredPhyPeripheralTask
     */
    void onSetPreferredPhySuccess(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int txPhy
            , int rxPhy
            , int phyOptions
            , @Nullable Bundle argument);

    /**
     * Set preferred phy error callback
     *
     * @param taskId              task id
     * @param bleServerConnection {@link BLEServerConnection} instance
     * @param device              BLE device
     * @param status              {@link BLEServerConnection#onPhyUpdate(BluetoothDevice, int, int, int)} 4th parameter
     *                            {@link org.im97mori.ble.task.SetPreferredPhyPeripheralTask#STATUS_CANCEL}
     * @param argument            callback argument
     * @see org.im97mori.ble.task.SetPreferredPhyPeripheralTask
     */
    void onSetPreferredPhyFailed(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int status
            , @Nullable Bundle argument);

    /**
     * Set preferred phy timeout callback
     *
     * @param taskId              task id
     * @param bleServerConnection {@link BLEServerConnection} instance
     * @param device              BLE device
     * @param timeout             timeout(millis)
     * @param argument            callback argument
     * @see org.im97mori.ble.task.SetPreferredPhyPeripheralTask
     */
    void onSetPreferredPhyTimeout(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Advertising start success callback
     *
     * @param advertiseSettings {@link AdvertiseCallback#onStartSuccess(AdvertiseSettings)} 1st parameter
     */
    void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings);

    /**
     * Advertising start error callback
     *
     * @param errorCode {@link AdvertiseCallback#onStartFailure(int)} 1st parameter, or null({@link BluetoothLeAdvertiser} not available)
     */
    void onAdvertisingStartFailed(@Nullable Integer errorCode);

    /**
     * Advertising finished callback
     */
    void onAdvertisingFinished();

    /**
     * callback for {@link android.bluetooth.BluetoothGattServer#addService(BluetoothGattService)}
     *
     * @param bleServerConnection {@link BLEServerConnection} instance
     */
    void setup(@NonNull BLEServerConnection bleServerConnection);

    /**
     * callback for  {@link android.bluetooth.BluetoothGattServer#removeService(BluetoothGattService)}
     *
     * @param bleServerConnection {@link BLEServerConnection} instance
     */
    void tearDown(@NonNull BLEServerConnection bleServerConnection);

    /**
     * check fallback flag
     *
     * @return {@code true}:fallback callback, {@code false}:not fallback callback
     */
    boolean isFallback();

}