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
     */
    void onScanFinished(@NonNull Set<BluetoothDevice> bluetoothDeviceSet, long timeout, @Nullable Bundle argument);

    /**
     * Scan error callback
     *
     * @param errorCode {@link android.bluetooth.le.ScanCallback#onScanFailed(int)} 1st parameter
     * @param argument  callback argument
     */
    void onScanFailed(int errorCode, @Nullable Bundle argument);

    /**
     * Bond success callback
     *
     * @param bluetoothDevice bonded {@link BluetoothDevice} instance
     * @param argument        callback argument
     */
    void onBondSuccess(@NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument);

    /**
     * Bond error callback
     *
     * @param bluetoothDevice bonded failed {@link BluetoothDevice} instance
     * @param status          {@link org.im97mori.ble.constants.ErrorCodeAndroid#UNKNOWN} or {@link  org.im97mori.ble.constants.ErrorCodeAndroid#CANCEL}
     * @param argument        callback argument
     */
    void onBondFailed(@NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument);

    /**
     * Bond timeout callback
     *
     * @param bluetoothDevice bonded timeout {@link BluetoothDevice} instance
     * @param timeout         timeout(millis)
     * @param argument        callback argument
     */
    void onBondTimeout(@NonNull BluetoothDevice bluetoothDevice, long timeout, @Nullable Bundle argument);

}
