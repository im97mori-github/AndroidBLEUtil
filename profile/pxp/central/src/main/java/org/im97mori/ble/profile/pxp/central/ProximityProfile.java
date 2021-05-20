package org.im97mori.ble.profile.pxp.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a06.AlertLevel;
import org.im97mori.ble.characteristic.u2a06.AlertLevelAndroid;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.profile.pxp.central.db.ProximityProfileBondedDatabaseHelper;
import org.im97mori.ble.service.ias.central.ImmediateAlertService;
import org.im97mori.ble.service.lls.central.LinkLossService;
import org.im97mori.ble.service.tps.central.TxPowerService;
import org.im97mori.ble.task.DiscoverServiceTask;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ALERT_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.ServiceUUID.IMMEDIATE_ALERT_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.LINK_LOSS_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.TX_POWER_SERVICE;

/**
 * Proximity Profile for Central
 */
public class ProximityProfile extends AbstractCentralProfile {

    /**
     * {@link ProximityProfileCallback} instance
     */
    protected final ProximityProfileCallback mProximityProfileCallback;

    /**
     * {@link LinkLossService} instance
     */
    protected LinkLossService mLinkLossService;

    /**
     * {@link ImmediateAlertService} instance
     */
    protected ImmediateAlertService mImmediateAlertService;

    /**
     * {@link TxPowerService} instance
     */
    protected TxPowerService mTxPowerService;

    /**
     * {@code true}:Device has Immediate Alert Service, {@code false}:no Immediate Alert Service
     */
    private boolean mHasImmediateAlertService;

    /**
     * {@code true}:Device has Tx Power Service, {@code false}:no Tx Power Service
     */
    private boolean mHasTxPowerService;

    /**
     * @param context                  {@link Context} instance
     * @param proximityProfileCallback {@link ProximityProfileCallback} instance
     */
    public ProximityProfile(@NonNull Context context, @NonNull ProximityProfileCallback proximityProfileCallback) {
        super(context, proximityProfileCallback);
        mProximityProfileCallback = proximityProfileCallback;
    }

    /**
     * find Proximity Profile device
     *
     * @param argument callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public synchronized Integer findProximityProfileDevices(@Nullable Bundle argument) {
        return scanDevice(new ProximityProfileScanCallback(this, null), ScanTask.TIMEOUT_MILLIS, argument);
    }

    /**
     * @return {@code true}:Device has Immediate Alert Service, {@code false}:no Immediate Alert Service. if {@code null} returned, profile is not ready
     */
    @Nullable
    public synchronized Boolean hasImmediateAlertService() {
        Boolean result = null;
        if (mImmediateAlertService != null) {
            result = mHasImmediateAlertService;
        }
        return result;
    }

    /**
     * @return {@code true}:Device has Tx Power Service, {@code false}:no Tx Power Service. if {@code null} returned, profile is not ready
     */
    @Nullable
    public synchronized Boolean hasTxPowerService() {
        Boolean result = null;
        if (mTxPowerService != null) {
            result = mHasTxPowerService;
        }
        return result;
    }

    /**
     * @see LinkLossService#getAlertLevel()
     */
    @Nullable
    public synchronized Integer getAlertLevel() {
        Integer taskId = null;
        if (mLinkLossService != null) {
            taskId = mLinkLossService.getAlertLevel();
        }
        return taskId;
    }

    /**
     * @see LinkLossService#setAlertLevel(AlertLevel)
     */
    @Nullable
    public synchronized Integer setLinkLossServiceAlertLevel(@NonNull AlertLevel alertLevel) {
        Integer taskId = null;
        if (mLinkLossService != null) {
            taskId = mLinkLossService.setAlertLevel(alertLevel);
        }
        return taskId;
    }

    /**
     * @see ImmediateAlertService#setAlertLevel(AlertLevel)
     */
    @Nullable
    public synchronized Integer setImmediateAlertServiceAlertLevel(@NonNull AlertLevel alertLevel) {
        Integer taskId = null;
        if (mImmediateAlertService != null) {
            taskId = mImmediateAlertService.setAlertLevel(alertLevel);
        }
        return taskId;
    }

    /**
     * @see TxPowerService#getTxPowerLevel()
     */
    @Nullable
    public synchronized Integer getTxPowerLevel() {
        Integer taskId = null;
        if (mTxPowerService != null) {
            taskId = mTxPowerService.getTxPowerLevel();
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return ProximityProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * create {@link ImmediateAlertService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        super.createServices();
        if (mLinkLossService == null) {
            mLinkLossService = new LinkLossService(mBLEConnection, mProximityProfileCallback, null);
        }
        if (mImmediateAlertService == null) {
            mImmediateAlertService = new ImmediateAlertService(mBLEConnection, mProximityProfileCallback, null);
        }
        if (mTxPowerService == null) {
            mTxPowerService = new TxPowerService(mBLEConnection, mProximityProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mHasImmediateAlertService = false;
        mHasTxPowerService = false;
        mLinkLossService = null;
        mImmediateAlertService = null;
        mTxPowerService = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEConnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @Nullable Bundle argument) {
        if (bluetoothDevice.equals(mCurrentBluetoothDevice)) {
            mBLEConnection.createDiscoverServiceTask(DiscoverServiceTask.TIMEOUT_MILLIS, null, this);
        }
        super.onBLEConnected(taskId, bluetoothDevice, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
        if (bluetoothDevice.equals(mCurrentBluetoothDevice)) {
            for (BluetoothGattService bluetoothGattService : serviceList) {
                if (IMMEDIATE_ALERT_SERVICE.equals(bluetoothGattService.getUuid())) {
                    mHasImmediateAlertService = true;
                } else if (TX_POWER_SERVICE.equals(bluetoothGattService.getUuid())) {
                    mHasTxPowerService = true;
                }
            }
        }
        super.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (bluetoothDevice.equals(mCurrentBluetoothDevice) && ALERT_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            if (LINK_LOSS_SERVICE.equals(serviceUUID)) {
                mProximityProfileCallback.onLinkLossServiceAlertLevelWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AlertLevelAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (IMMEDIATE_ALERT_SERVICE.equals(serviceUUID)) {
                mProximityProfileCallback.onImmediateAlertServiceAlertLevelWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AlertLevelAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (bluetoothDevice.equals(mCurrentBluetoothDevice) && ALERT_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            if (LINK_LOSS_SERVICE.equals(serviceUUID)) {
                mProximityProfileCallback.onLinkLossServiceAlertLevelWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (IMMEDIATE_ALERT_SERVICE.equals(serviceUUID)) {
                mProximityProfileCallback.onImmediateAlertServiceAlertLevelWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (bluetoothDevice.equals(mCurrentBluetoothDevice) && ALERT_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            if (LINK_LOSS_SERVICE.equals(serviceUUID)) {
                mProximityProfileCallback.onLinkLossServiceAlertLevelWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (IMMEDIATE_ALERT_SERVICE.equals(serviceUUID)) {
                mProximityProfileCallback.onImmediateAlertServiceAlertLevelWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

}
