package org.im97mori.ble.profile.pxp.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a06.AlertLevelAndroid;
import org.im97mori.ble.profile.central.ProfileCallback;
import org.im97mori.ble.service.ias.central.ImmediateAlertServiceCallback;
import org.im97mori.ble.service.lls.central.LinkLossServiceCallback;
import org.im97mori.ble.service.tps.central.TxPowerServiceCallback;

import java.util.UUID;

/**
 * Proximity Profile callback
 *
 * @see LinkLossServiceCallback
 * @see ImmediateAlertServiceCallback
 * @see TxPowerServiceCallback
 * @see ProfileCallback
 */
public interface ProximityProfileCallback extends LinkLossServiceCallback, ImmediateAlertServiceCallback, TxPowerServiceCallback, ProfileCallback {

    /**
     * Write Link Loss Service's Alert Level success callback
     *
     * @param taskId                   task id
     * @param bluetoothDevice          BLE device
     * @param serviceUUID              service {@link UUID}
     * @param serviceInstanceId        task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID       characteristic {@link UUID}
     * @param characteristicInstanceId task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param alertLevelAndroid        {@link AlertLevelAndroid}
     * @param argument                 callback argument
     */
    void onLinkLossServiceAlertLevelWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AlertLevelAndroid alertLevelAndroid
            , @Nullable Bundle argument);

    /**
     * Write Link Loss Service's Alert Level error callback
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
    void onLinkLossServiceAlertLevelWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Link Loss Service's Alert Level timeout callback
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
    void onLinkLossServiceAlertLevelWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

    /**
     * Write Immediate Alert Service's Alert Level success callback
     *
     * @param taskId                      task id
     * @param bluetoothDevice             BLE device
     * @param serviceUUID                 service {@link UUID}
     * @param serviceInstanceId           task target service incetanceId {@link BluetoothGattService#getInstanceId()}
     * @param characteristicUUID          characteristic {@link UUID}
     * @param characteristicInstanceId    task target characteristic incetanceId {@link BluetoothGattCharacteristic#getInstanceId()}
     * @param alertLevelAndroid {@link org.im97mori.ble.characteristic.u2a06.AlertLevelAndroid}
     * @param argument                    callback argument
     */
    void onImmediateAlertServiceAlertLevelWriteSuccess(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @NonNull Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @NonNull Integer characteristicInstanceId
            , @NonNull AlertLevelAndroid alertLevelAndroid
            , @Nullable Bundle argument);

    /**
     * Write Immediate Alert Service's Alert Level error callback
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
    void onImmediateAlertServiceAlertLevelWriteFailed(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , int status
            , @Nullable Bundle argument);

    /**
     * Write Immediate Alert Service's Alert Level timeout callback
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
    void onImmediateAlertServiceAlertLevelWriteTimeout(@NonNull Integer taskId
            , @NonNull BluetoothDevice bluetoothDevice
            , @NonNull UUID serviceUUID
            , @Nullable Integer serviceInstanceId
            , @NonNull UUID characteristicUUID
            , @Nullable Integer characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument);

}
