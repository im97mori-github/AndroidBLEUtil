package org.im97mori.ble.profile.tip.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a16.TimeUpdateControlPoint;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.profile.tip.central.db.TimeProfileBondedDatabaseHelper;
import org.im97mori.ble.service.cts.central.CurrentTimeService;
import org.im97mori.ble.service.ndcs.central.NextDstChangeService;
import org.im97mori.ble.service.rtus.central.ReferenceTimeUpdateService;
import org.im97mori.ble.task.DiscoverServiceTask;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.ServiceUUID.NEXT_DST_CHANGE_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.REFERENCE_TIME_UPDATE_SERVICE;

/**
 * Time Profile for Central
 */
public class TimeProfile extends AbstractCentralProfile {

    /**
     * {@link TimeProfileCallback} instance
     */
    protected final TimeProfileCallback mTimeProfileCallback;

    /**
     * {@link CurrentTimeService} instance
     */
    protected CurrentTimeService mCurrentTimeService;

    /**
     * {@link NextDstChangeService} instance
     */
    protected NextDstChangeService mNextDstChangeService;

    /**
     * {@link ReferenceTimeUpdateService} instance
     */
    protected ReferenceTimeUpdateService mReferenceTimeUpdateService;

    /**
     * {@code true}:Device has Next DST Change Service, {@code false}:no Next DST Change Service
     */
    private boolean mHasNextDstChangeService;

    /**
     * {@code true}:Device has Reference Time Update Service, {@code false}:no Reference Time Update Service
     */
    private boolean mHasReferenceTimeUpdateService;

    /**
     * @param context             {@link Context} instance
     * @param timeProfileCallback {@link TimeProfileCallback} instance
     */
    public TimeProfile(@NonNull Context context, @NonNull TimeProfileCallback timeProfileCallback) {
        super(context, timeProfileCallback);
        mTimeProfileCallback = timeProfileCallback;
    }

    /**
     * find Time Profile device
     *
     * @param serviceUUID advertising UUID
     * @param argument    callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public synchronized Integer findTimeProfileDevices(@NonNull UUID serviceUUID, @Nullable Bundle argument) {
        return scanDevice(new TimeProfileScanCallback(serviceUUID, this, null), ScanTask.TIMEOUT_MILLIS, argument);
    }

    /**
     * @return {@code true}:Device has Next DST Change Service, {@code false}:no Next DST Change Service
     */
    @Nullable
    public synchronized Boolean hasNextDstChangeService() {
        Boolean result = null;
        if (mNextDstChangeService != null) {
            result = mHasNextDstChangeService;
        }
        return result;
    }

    /**
     * @return {@code true}:Device has Reference Time Update Service, {@code false}:no Reference Time Update Service
     */
    @Nullable
    public synchronized Boolean hasReferenceTimeUpdateService() {
        Boolean result = null;
        if (mReferenceTimeUpdateService != null) {
            result = mHasReferenceTimeUpdateService;
        }
        return result;
    }

    /**
     * @see CurrentTimeService#isCurrentTimeCharacteristicWritable()
     */
    @Nullable
    public synchronized Boolean isCurrentTimeCharacteristicWritable() {
        Boolean result = null;
        if (mCurrentTimeService != null) {
            result = mCurrentTimeService.isCurrentTimeCharacteristicWritable();
        }
        return result;
    }

    /**
     * @see CurrentTimeService#isLocalTimeInformationCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isLocalTimeInformationCharacteristicSupported() {
        Boolean result = null;
        if (mCurrentTimeService != null) {
            result = mCurrentTimeService.isLocalTimeInformationCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see CurrentTimeService#isLocalTimeInformationCharacteristicWritable()
     */
    @Nullable
    public synchronized Boolean isLocalTimeInformationCharacteristicWritable() {
        Boolean result = null;
        if (mCurrentTimeService != null) {
            result = mCurrentTimeService.isLocalTimeInformationCharacteristicWritable();
        }
        return result;
    }

    /**
     * @see CurrentTimeService#isReferenceTimeInformationCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isReferenceTimeInformationCharacteristicSupported() {
        Boolean result = null;
        if (mCurrentTimeService != null) {
            result = mCurrentTimeService.isReferenceTimeInformationCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see CurrentTimeService#getCurrentTime()
     */
    @Nullable
    public synchronized Integer getCurrentTime() {
        Integer taskId = null;
        if (mCurrentTimeService != null) {
            taskId = mCurrentTimeService.getCurrentTime();
        }
        return taskId;
    }

    /**
     * @see CurrentTimeService#setCurrentTime(CurrentTime)
     */
    @Nullable
    public synchronized Integer setCurrentTime(@NonNull CurrentTime currentTime) {
        Integer taskId = null;
        if (mCurrentTimeService != null) {
            taskId = mCurrentTimeService.setCurrentTime(currentTime);
        }
        return taskId;
    }

    /**
     * @see CurrentTimeService#getCurrentTimeClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getCurrentTimeClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mCurrentTimeService != null) {
            taskId = mCurrentTimeService.getCurrentTimeClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see CurrentTimeService#startCurrentTimeNotification()
     */
    @Nullable
    public synchronized Integer startCurrentTimeNotification() {
        Integer taskId = null;
        if (mCurrentTimeService != null) {
            taskId = mCurrentTimeService.startCurrentTimeNotification();
        }
        return taskId;
    }

    /**
     * @see CurrentTimeService#stopCurrentTimeNotification()
     */
    @Nullable
    public synchronized Integer stopCurrentTimeNotification() {
        Integer taskId = null;
        if (mCurrentTimeService != null) {
            taskId = mCurrentTimeService.stopCurrentTimeNotification();
        }
        return taskId;
    }

    /**
     * @see CurrentTimeService#getLocalTimeInformation()
     */
    @Nullable
    public synchronized Integer getLocalTimeInformation() {
        Integer taskId = null;
        if (mCurrentTimeService != null) {
            taskId = mCurrentTimeService.getLocalTimeInformation();
        }
        return taskId;
    }

    /**
     * @see CurrentTimeService#setLocalTimeInformation(LocalTimeInformation)
     */
    @Nullable
    public synchronized Integer setLocalTimeInformation(@NonNull LocalTimeInformation localTimeInformation) {
        Integer taskId = null;
        if (mCurrentTimeService != null) {
            taskId = mCurrentTimeService.setLocalTimeInformation(localTimeInformation);
        }
        return taskId;
    }

    /**
     * @see CurrentTimeService#getReferenceTimeInformation()
     */
    @Nullable
    public synchronized Integer getReferenceTimeInformation() {
        Integer taskId = null;
        if (mCurrentTimeService != null) {
            taskId = mCurrentTimeService.getReferenceTimeInformation();
        }
        return taskId;
    }

    /**
     * @see NextDstChangeService#getTimeWithDst()
     */
    @Nullable
    public synchronized Integer getTimeWithDst() {
        Integer taskId = null;
        if (mNextDstChangeService != null) {
            taskId = mNextDstChangeService.getTimeWithDst();
        }
        return taskId;
    }

    /**
     * @see ReferenceTimeUpdateService#setTimeUpdateControlPoint(TimeUpdateControlPoint)
     */
    @Nullable
    public synchronized Integer setTimeUpdateControlPoint(@NonNull TimeUpdateControlPoint timeUpdateControlPoint) {
        Integer taskId = null;
        if (mReferenceTimeUpdateService != null) {
            taskId = mReferenceTimeUpdateService.setTimeUpdateControlPoint(timeUpdateControlPoint);
        }
        return taskId;
    }

    /**
     * @see ReferenceTimeUpdateService#getTimeUpdateState()
     */
    @Nullable
    public synchronized Integer getTimeUpdateState() {
        Integer taskId = null;
        if (mReferenceTimeUpdateService != null) {
            taskId = mReferenceTimeUpdateService.getTimeUpdateState();
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return TimeProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void disconnect() {
        mHasNextDstChangeService = false;
        mHasReferenceTimeUpdateService = false;
        super.disconnect();
    }

    /**
     * create {@link CurrentTimeService}, {@link NextDstChangeService} and {@link ReferenceTimeUpdateService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        super.createServices();
        if (mCurrentTimeService == null) {
            mCurrentTimeService = new CurrentTimeService(mBLEConnection, mTimeProfileCallback, null);
        }
        if (mNextDstChangeService == null) {
            mNextDstChangeService = new NextDstChangeService(mBLEConnection, mTimeProfileCallback, null);
        }
        if (mReferenceTimeUpdateService == null) {
            mReferenceTimeUpdateService = new ReferenceTimeUpdateService(mBLEConnection, mTimeProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mCurrentTimeService = null;
        mNextDstChangeService = null;
        mReferenceTimeUpdateService = null;
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
                if (NEXT_DST_CHANGE_SERVICE.equals(bluetoothGattService.getUuid())) {
                    mHasNextDstChangeService = true;
                } else if (REFERENCE_TIME_UPDATE_SERVICE.equals(bluetoothGattService.getUuid())) {
                    mHasReferenceTimeUpdateService = true;
                }
            }
        }
        super.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, argument);
    }

}
