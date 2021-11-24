package org.im97mori.ble.profile.central;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.service.gap.central.GenericAttributeServiceCallback;
import org.im97mori.ble.service.gatt.central.GenericAccessServiceCallback;

import java.util.Set;

/**
 * Profile callback
 */
@SuppressWarnings({"EmptyMethod", "unused"})
public interface ProfileCallback extends GenericAccessServiceCallback, GenericAttributeServiceCallback, BLECallback {

    /**
     * Scan finished callback
     *
     * @param bluetoothDeviceSet found {@link BluetoothDevice} set
     * @param timeout            scanning time
     * @param argument           callback argument
     * @see org.im97mori.ble.profile.central.task.ScanTask
     */
    void onScanFinished(@NonNull Set<BluetoothDevice> bluetoothDeviceSet, long timeout, @Nullable Bundle argument);

    /**
     * Scan error callback
     *
     * @param errorCode {@link android.bluetooth.le.ScanCallback#onScanFailed(int)} 1st parameter
     *                  {@link org.im97mori.ble.profile.central.task.ScanTask#STATUS_CANCEL}
     * @param argument  callback argument
     * @see org.im97mori.ble.profile.central.task.ScanTask
     */
    void onScanFailed(int errorCode, @Nullable Bundle argument);

    /**
     * Bond success callback
     *
     * @param bluetoothDevice bonded {@link BluetoothDevice} instance
     * @param argument        callback argument
     * @see org.im97mori.ble.profile.central.task.BondTask
     */
    void onBondSuccess(@NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument);

    /**
     * Bond error callback
     *
     * @param bluetoothDevice bonded failed {@link BluetoothDevice} instance
     * @param status          {@link org.im97mori.ble.profile.central.task.BondTask#STATUS_CANCEL}
     *                        {@link org.im97mori.ble.profile.central.task.BondTask#STATUS_CREATE_BOND_FAILED}
     *                        {@link org.im97mori.ble.profile.central.task.BondTask#STATUS_BOND_FAILED}
     * @param argument        callback argument
     * @see org.im97mori.ble.profile.central.task.BondTask
     */
    void onBondFailed(@NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Bond timeout callback
     *
     * @param bluetoothDevice bonded timeout {@link BluetoothDevice} instance
     * @param timeout         timeout(millis)
     * @param argument        callback argument
     * @see org.im97mori.ble.profile.central.task.BondTask
     */
    void onBondTimeout(@NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument);

}
