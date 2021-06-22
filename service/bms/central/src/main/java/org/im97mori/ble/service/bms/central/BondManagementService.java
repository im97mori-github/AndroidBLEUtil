package org.im97mori.ble.service.bms.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2aa4.BondManagementControlPoint;
import org.im97mori.ble.characteristic.u2aa4.BondManagementControlPointAndroid;
import org.im97mori.ble.characteristic.u2aa5.BondManagementFeaturesAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.WriteCharacteristicTask;

import java.util.UUID;

import static org.im97mori.ble.constants.CharacteristicUUID.BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.BOND_MANAGEMENT_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.BOND_MANAGEMENT_SERVICE;

/**
 * Bond Management Service (Service UUID: 0x181E) for Central
 */
public class BondManagementService extends AbstractCentralService {

    /**
     * {@link BondManagementServiceCallback} instance
     */
    private final BondManagementServiceCallback mBondManagementServiceCallback;

    /**
     * @param bleConnection                 {@link BLEConnection} instance
     * @param bondManagementServiceCallback {@link BondManagementServiceCallback} instance
     * @param bleCallback                   {@link BLECallback} instance(optional)
     */
    public BondManagementService(@NonNull BLEConnection bleConnection, @NonNull BondManagementServiceCallback bondManagementServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mBondManagementServiceCallback = bondManagementServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BOND_MANAGEMENT_SERVICE.equals(serviceUUID)) {
            if (BOND_MANAGEMENT_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mBondManagementServiceCallback.onBondManagementFeaturesReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, BondManagementFeaturesAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BOND_MANAGEMENT_SERVICE.equals(serviceUUID)) {
            if (BOND_MANAGEMENT_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mBondManagementServiceCallback.onBondManagementFeaturesReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BOND_MANAGEMENT_SERVICE.equals(serviceUUID)) {
            if (BOND_MANAGEMENT_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mBondManagementServiceCallback.onBondManagementFeaturesReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BOND_MANAGEMENT_SERVICE.equals(serviceUUID)) {
            if (BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mBondManagementServiceCallback.onBondManagementControlPointWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, BondManagementControlPointAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BOND_MANAGEMENT_SERVICE.equals(serviceUUID)) {
            if (BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mBondManagementServiceCallback.onBondManagementControlPointWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && BOND_MANAGEMENT_SERVICE.equals(serviceUUID)) {
            if (BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mBondManagementServiceCallback.onBondManagementControlPointWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * get Bond Management Features
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see BondManagementServiceCallback#onBondManagementFeaturesReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, BondManagementFeaturesAndroid, Bundle)
     * @see BondManagementServiceCallback#onBondManagementFeaturesReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see BondManagementServiceCallback#onBondManagementFeaturesReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getBondManagementFeatures() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(BOND_MANAGEMENT_SERVICE, null, BOND_MANAGEMENT_FEATURE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Bond Management Control Point
     *
     * @param bondManagementControlPoint {@link BondManagementControlPoint} instance
     * @return task id. if {@code null} returned, service is not ready
     * @see BondManagementServiceCallback#onBondManagementControlPointWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, BondManagementControlPointAndroid, Bundle)
     * @see BondManagementServiceCallback#onBondManagementControlPointWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see BondManagementServiceCallback#onBondManagementControlPointWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setBondManagementControlPoint(@NonNull BondManagementControlPoint bondManagementControlPoint) {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(BOND_MANAGEMENT_SERVICE, null, BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC, null, bondManagementControlPoint, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

}
