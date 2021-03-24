package org.im97mori.ble.profile.ftmp.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a80.Age;
import org.im97mori.ble.characteristic.u2a85.DateOfBirth;
import org.im97mori.ble.characteristic.u2a8a.FirstName;
import org.im97mori.ble.characteristic.u2a8b.FiveZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a8d.HeartRateMax;
import org.im97mori.ble.characteristic.u2a8e.Height;
import org.im97mori.ble.characteristic.u2a91.MaximumRecommendedHeartRate;
import org.im97mori.ble.characteristic.u2a92.RestingHeartRate;
import org.im97mori.ble.characteristic.u2a94.ThreeZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a95.TwoZoneHeartRateLimit;
import org.im97mori.ble.characteristic.u2a96.VO2Max;
import org.im97mori.ble.characteristic.u2a98.Weight;
import org.im97mori.ble.characteristic.u2a99.DatabaseChangeIncrement;
import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
import org.im97mori.ble.characteristic.u2aa2.Language;
import org.im97mori.ble.characteristic.u2ad9.FitnessMachineControlPoint;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.profile.ftmp.central.db.FitnessMachineProfileBondedDatabaseHelper;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.ftms.central.FitnessMachineService;
import org.im97mori.ble.service.uds.central.UserDataService;
import org.im97mori.ble.task.DiscoverServiceTask;

import java.util.List;

import static org.im97mori.ble.BLEConstants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.USER_DATA_SERVICE;

/**
 * Weight Scale Profile for Central
 */
public class FitnessMachineProfile extends AbstractCentralProfile {

    /**
     * {@link FitnessMachineProfileCallback} instance
     */
    protected final FitnessMachineProfileCallback mFitnessMachineProfileCallback;

    /**
     * {@link FitnessMachineService} instance
     */
    protected FitnessMachineService mFitnessMachineService;

    /**
     * {@link DeviceInformationService} instance
     */
    protected DeviceInformationService mDeviceInformationService;

    /**
     * {@link UserDataService} instance
     */
    protected UserDataService mUserDataService;

    /**
     * {@code true}:Device has User Data Service, {@code false}:no User Data Service
     */
    private boolean mHasUserDataService;

    /**
     * {@code true}:Device has Device Information Service, {@code false}:no Device Information Service
     */
    private boolean mHasDeviceInformationService;

    /**
     * @param context                       {@link Context} instance
     * @param fitnessMachineProfileCallback {@link FitnessMachineProfileCallback} instance
     */
    public FitnessMachineProfile(@NonNull Context context, @NonNull FitnessMachineProfileCallback fitnessMachineProfileCallback) {
        super(context, fitnessMachineProfileCallback);
        mFitnessMachineProfileCallback = fitnessMachineProfileCallback;
    }

    /**
     * find Fitness Machine Profile device
     *
     * @param argument callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public synchronized Integer findFitnessMachineProfileDevices(@Nullable Bundle argument) {
        return scanDevice(new FitnessMachineProfileScanCallback(this, null), ScanTask.TIMEOUT_MILLIS, argument);
    }

    /**
     * @return {@code true}:Device has User Data Service, {@code false}:no User Data Service
     */
    @Nullable
    public synchronized Boolean hasUserDataService() {
        Boolean result = null;
        if (isConnected()) {
            result = mHasUserDataService;
        }
        return result;
    }

    /**
     * @return {@code true}:Device has Device Information Service, {@code false}:no Device Information Service
     */
    @Nullable
    public synchronized Boolean hasDeviceInformationService() {
        Boolean result = null;
        if (isConnected()) {
            result = mHasDeviceInformationService;
        }
        return result;
    }

    /**
     * @see FitnessMachineService#isTreadmillDataCharacteristicSupported()
     */
    public synchronized Boolean isTreadmillDataCharacteristicSupported() {
        Boolean result = null;
        if (mFitnessMachineService != null) {
            result = mFitnessMachineService.isTreadmillDataCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see FitnessMachineService#isCrossTrainerDataCharacteristicSupported()
     */
    public synchronized Boolean isCrossTrainerDataCharacteristicSupported() {
        Boolean result = null;
        if (mFitnessMachineService != null) {
            result = mFitnessMachineService.isCrossTrainerDataCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see FitnessMachineService#isStepClimberDataCharacteristicSupported()
     */
    public synchronized Boolean isStepClimberDataCharacteristicSupported() {
        Boolean result = null;
        if (mFitnessMachineService != null) {
            result = mFitnessMachineService.isStepClimberDataCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see FitnessMachineService#isStairClimberDataCharacteristicSupported()
     */
    public synchronized Boolean isStairClimberDataCharacteristicSupported() {
        Boolean result = null;
        if (mFitnessMachineService != null) {
            result = mFitnessMachineService.isStairClimberDataCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see FitnessMachineService#isRowerDataCharacteristicSupported()
     */
    public synchronized Boolean isRowerDataCharacteristicSupported() {
        Boolean result = null;
        if (mFitnessMachineService != null) {
            result = mFitnessMachineService.isRowerDataCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see FitnessMachineService#isIndoorBikeDataCharacteristicSupported()
     */
    public synchronized Boolean isIndoorBikeDataCharacteristicSupported() {
        Boolean result = null;
        if (mFitnessMachineService != null) {
            result = mFitnessMachineService.isIndoorBikeDataCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see FitnessMachineService#isTrainingStatusCharacteristicSupported()
     */
    public synchronized Boolean isTrainingStatusCharacteristicSupported() {
        Boolean result = null;
        if (mFitnessMachineService != null) {
            result = mFitnessMachineService.isTrainingStatusCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see FitnessMachineService#isSupportedSpeedRangeCharacteristicSupported()
     */
    public synchronized Boolean isSupportedSpeedRangeCharacteristicSupported() {
        Boolean result = null;
        if (mFitnessMachineService != null) {
            result = mFitnessMachineService.isSupportedSpeedRangeCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see FitnessMachineService#isSupportedInclinationRangeCharacteristicSupported()
     */
    public synchronized Boolean isSupportedInclinationRangeCharacteristicSupported() {
        Boolean result = null;
        if (mFitnessMachineService != null) {
            result = mFitnessMachineService.isSupportedInclinationRangeCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see FitnessMachineService#isSupportedResistanceLevelRangeCharacteristicSupported()
     */
    public synchronized Boolean isSupportedResistanceLevelRangeCharacteristicSupported() {
        Boolean result = null;
        if (mFitnessMachineService != null) {
            result = mFitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see FitnessMachineService#isSupportedPowerRangeCharacteristicSupported()
     */
    public synchronized Boolean isSupportedPowerRangeCharacteristicSupported() {
        Boolean result = null;
        if (mFitnessMachineService != null) {
            result = mFitnessMachineService.isSupportedPowerRangeCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see FitnessMachineService#isSupportedHeartRateRangeCharacteristicSupported()
     */
    public synchronized Boolean isSupportedHeartRateRangeCharacteristicSupported() {
        Boolean result = null;
        if (mFitnessMachineService != null) {
            result = mFitnessMachineService.isSupportedHeartRateRangeCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see FitnessMachineService#isFitnessMachineControlPointCharacteristicSupported()
     */
    public synchronized Boolean isFitnessMachineControlPointCharacteristicSupported() {
        Boolean result = null;
        if (mFitnessMachineService != null) {
            result = mFitnessMachineService.isFitnessMachineControlPointCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see FitnessMachineService#isFitnessMachineStatusCharacteristicSupported()
     */
    public synchronized Boolean isFitnessMachineStatusCharacteristicSupported() {
        Boolean result = null;
        if (mFitnessMachineService != null) {
            result = mFitnessMachineService.isFitnessMachineStatusCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see UserDataService#isFirstNameCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isFirstNameCharacteristicSupported() {
        Boolean result = null;
        if (mUserDataService != null) {
            result = mUserDataService.isFirstNameCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see UserDataService#isWeightCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isWeightCharacteristicSupported() {
        Boolean result = null;
        if (mUserDataService != null) {
            result = mUserDataService.isWeightCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see UserDataService#isGenderCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isGenderCharacteristicSupported() {
        Boolean result = null;
        if (mUserDataService != null) {
            result = mUserDataService.isGenderCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see UserDataService#isHeightCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isHeightCharacteristicSupported() {
        Boolean result = null;
        if (mUserDataService != null) {
            result = mUserDataService.isHeightCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see UserDataService#isAgeCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isAgeCharacteristicSupported() {
        Boolean result = null;
        if (mUserDataService != null) {
            result = mUserDataService.isAgeCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see UserDataService#isDateOfBirthCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isDateOfBirthCharacteristicSupported() {
        Boolean result = null;
        if (mUserDataService != null) {
            result = mUserDataService.isDateOfBirthCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see UserDataService#isHeartRateMaxCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isHeartRateMaxCharacteristicSupported() {
        Boolean result = null;
        if (mUserDataService != null) {
            result = mUserDataService.isHeartRateMaxCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see UserDataService#isRestingHeartRateCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isRestingHeartRateCharacteristicSupported() {
        Boolean result = null;
        if (mUserDataService != null) {
            result = mUserDataService.isRestingHeartRateCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see UserDataService#isMaximumRecommendedHeartRateCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isMaximumRecommendedHeartRateCharacteristicSupported() {
        Boolean result = null;
        if (mUserDataService != null) {
            result = mUserDataService.isMaximumRecommendedHeartRateCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see UserDataService#isVO2MaxCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isVO2MaxCharacteristicSupported() {
        Boolean result = null;
        if (mUserDataService != null) {
            result = mUserDataService.isVO2MaxCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see UserDataService#isLanguageCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isLanguageCharacteristicSupported() {
        Boolean result = null;
        if (mUserDataService != null) {
            result = mUserDataService.isLanguageCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see UserDataService#isTwoZoneHeartRateLimitCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isTwoZoneHeartRateLimitCharacteristicSupported() {
        Boolean result = null;
        if (mUserDataService != null) {
            result = mUserDataService.isTwoZoneHeartRateLimitCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see UserDataService#isThreeZoneHeartRateLimitsCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isThreeZoneHeartRateLimitsCharacteristicSupported() {
        Boolean result = null;
        if (mUserDataService != null) {
            result = mUserDataService.isThreeZoneHeartRateLimitsCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see UserDataService#isFiveZoneHeartRateLimitsCharacteristicSupported()
     */
    @Nullable
    public synchronized Boolean isFiveZoneHeartRateLimitsCharacteristicSupported() {
        Boolean result = null;
        if (mUserDataService != null) {
            result = mUserDataService.isFiveZoneHeartRateLimitsCharacteristicSupported();
        }
        return result;
    }

    /**
     * @see UserDataService#isDatabaseChangeIncrementCharacteristicNotifySupported()
     */
    @Nullable
    public synchronized Boolean isDatabaseChangeIncrementCharacteristicNotifySupported() {
        Boolean result = null;
        if (mUserDataService != null) {
            result = mUserDataService.isDatabaseChangeIncrementCharacteristicNotifySupported();
        }
        return result;
    }

    /**
     * @see DeviceInformationService#hasManufacturerNameString()
     */
    public synchronized Boolean hasManufacturerNameString() {
        Boolean result = null;
        if (mDeviceInformationService != null) {
            result = mDeviceInformationService.hasManufacturerNameString();
        }
        return result;
    }

    /**
     * @see DeviceInformationService#hasModelNumberString()
     */
    public synchronized Boolean hasModelNumberString() {
        Boolean result = null;
        if (mDeviceInformationService != null) {
            result = mDeviceInformationService.hasModelNumberString();
        }
        return result;
    }

    /**
     * @see FitnessMachineService#getFitnessMachineFeature()
     */
    @Nullable
    public synchronized Integer getFitnessMachineFeature() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.getFitnessMachineFeature();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#getTreadmillDataClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getTreadmillDataClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.getTreadmillDataClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#startTreadmillDataNotification()
     */
    @Nullable
    public synchronized Integer startTreadmillDataNotification() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.startTreadmillDataNotification();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#stopTreadmillDataNotification()
     */
    @Nullable
    public synchronized Integer stopTreadmillDataNotification() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.stopTreadmillDataNotification();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#getCrossTrainerDataClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getCrossTrainerDataClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.getCrossTrainerDataClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#startCrossTrainerDataNotification()
     */
    @Nullable
    public synchronized Integer startCrossTrainerDataNotification() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.startCrossTrainerDataNotification();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#stopCrossTrainerDataNotification()
     */
    @Nullable
    public synchronized Integer stopCrossTrainerDataNotification() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.stopCrossTrainerDataNotification();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#stopCrossTrainerDataNotification()
     */
    @Nullable
    public synchronized Integer getStepClimberDataClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.getStepClimberDataClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#startStepClimberDataNotification()
     */
    @Nullable
    public synchronized Integer startStepClimberDataNotification() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.startStepClimberDataNotification();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#stopStepClimberDataNotification()
     */
    @Nullable
    public synchronized Integer stopStepClimberDataNotification() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.stopStepClimberDataNotification();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#getStairClimberDataClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getStairClimberDataClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.getStairClimberDataClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#startStairClimberDataNotification()
     */
    @Nullable
    public synchronized Integer startStairClimberDataNotification() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.startStairClimberDataNotification();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#stopStairClimberDataNotification()
     */
    @Nullable
    public synchronized Integer stopStairClimberDataNotification() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.stopStairClimberDataNotification();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#getRowerDataClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getRowerDataClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.getRowerDataClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#startRowerDataNotification()
     */
    @Nullable
    public synchronized Integer startRowerDataNotification() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.startRowerDataNotification();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#stopRowerDataNotification()
     */
    @Nullable
    public synchronized Integer stopRowerDataNotification() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.stopRowerDataNotification();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#getIndoorBikeDataClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getIndoorBikeDataClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.getIndoorBikeDataClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#startIndoorBikeDataNotification()
     */
    @Nullable
    public synchronized Integer startIndoorBikeDataNotification() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.startIndoorBikeDataNotification();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#stopIndoorBikeDataNotification()
     */
    @Nullable
    public synchronized Integer stopIndoorBikeDataNotification() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.stopIndoorBikeDataNotification();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#stopIndoorBikeDataNotification()
     */
    @Nullable
    public synchronized Integer getTrainingStatus() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.getTrainingStatus();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#getTrainingStatusClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getTrainingStatusClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.getTrainingStatusClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#startTrainingStatusNotification()
     */
    @Nullable
    public synchronized Integer startTrainingStatusNotification() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.startTrainingStatusNotification();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#stopTrainingStatusNotification()
     */
    @Nullable
    public synchronized Integer stopTrainingStatusNotification() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.stopTrainingStatusNotification();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#getSupportedSpeedRange()
     */
    @Nullable
    public synchronized Integer getSupportedSpeedRange() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.getSupportedSpeedRange();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#getSupportedInclinationRange()
     */
    @Nullable
    public synchronized Integer getSupportedInclinationRange() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.getSupportedInclinationRange();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#getSupportedResistanceLevelRange()
     */
    @Nullable
    public synchronized Integer getSupportedResistanceLevelRange() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.getSupportedResistanceLevelRange();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#getSupportedPowerRange()
     */
    @Nullable
    public synchronized Integer getSupportedPowerRange() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.getSupportedPowerRange();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#getSupportedHeartRateRange()
     */
    @Nullable
    public synchronized Integer getSupportedHeartRateRange() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.getSupportedHeartRateRange();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#setFitnessMachineControlPoint(FitnessMachineControlPoint)
     */
    @Nullable
    public synchronized Integer setFitnessMachineControlPoint(@NonNull FitnessMachineControlPoint fitnessMachineControlPoint) {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.setFitnessMachineControlPoint(fitnessMachineControlPoint);
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#getFitnessMachineControlPointClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getFitnessMachineControlPointClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.getFitnessMachineControlPointClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#startFitnessMachineControlPointIndication()
     */
    @Nullable
    public synchronized Integer startFitnessMachineControlPointIndication() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.startFitnessMachineControlPointIndication();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#stopFitnessMachineControlPointIndication()
     */
    @Nullable
    public synchronized Integer stopFitnessMachineControlPointIndication() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.stopFitnessMachineControlPointIndication();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#getFitnessMachineStatusClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getFitnessMachineStatusClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.getFitnessMachineStatusClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#startFitnessMachineStatusNotification()
     */
    @Nullable
    public synchronized Integer startFitnessMachineStatusNotification() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.startFitnessMachineStatusNotification();
        }
        return taskId;
    }

    /**
     * @see FitnessMachineService#stopFitnessMachineStatusNotification()
     */
    @Nullable
    public synchronized Integer stopFitnessMachineStatusNotification() {
        Integer taskId = null;
        if (mFitnessMachineService != null) {
            taskId = mFitnessMachineService.stopFitnessMachineStatusNotification();
        }
        return taskId;
    }

    /**
     * @see UserDataService#getDatabaseChangeIncrement()
     */
    @Nullable
    public synchronized Integer getDatabaseChangeIncrement() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getDatabaseChangeIncrement();
        }
        return taskId;
    }

    /**
     * @see UserDataService#setDatabaseChangeIncrement(DatabaseChangeIncrement)
     */
    @Nullable
    public synchronized Integer setDatabaseChangeIncrement(@NonNull DatabaseChangeIncrement databaseChangeIncrement) {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.setDatabaseChangeIncrement(databaseChangeIncrement);
        }
        return taskId;
    }

    /**
     * @see UserDataService#getDatabaseChangeIncrementClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getDatabaseChangeIncrementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getDatabaseChangeIncrementClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see UserDataService#startDatabaseChangeIncrementNotification()
     */
    @Nullable
    public synchronized Integer startDatabaseChangeIncrementNotification() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.startDatabaseChangeIncrementNotification();
        }
        return taskId;
    }

    /**
     * @see UserDataService#stopDatabaseChangeIncrementNotification()
     */
    @Nullable
    public synchronized Integer stopDatabaseChangeIncrementNotification() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.stopDatabaseChangeIncrementNotification();
        }
        return taskId;
    }

    /**
     * @see UserDataService#setUserControlPoint(UserControlPoint)
     */
    @Nullable
    public synchronized Integer setUserControlPoint(@NonNull UserControlPoint userControlPoint) {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.setUserControlPoint(userControlPoint);
        }
        return taskId;
    }

    /**
     * @see UserDataService#getUserControlPointClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getUserControlPointClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getUserControlPointClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see UserDataService#startUserControlPointIndication()
     */
    @Nullable
    public synchronized Integer startUserControlPointIndication() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.startUserControlPointIndication();
        }
        return taskId;
    }

    /**
     * @see UserDataService#stopUserControlPointIndication()
     */
    @Nullable
    public synchronized Integer stopUserControlPointIndication() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.stopUserControlPointIndication();
        }
        return taskId;
    }

    /**
     * @see UserDataService#getUserIndex()
     */
    @Nullable
    public synchronized Integer getUserIndex() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getUserIndex();
        }
        return taskId;
    }

    /**
     * @see UserDataService#getFirstName()
     */
    @Nullable
    public synchronized Integer getFirstName() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getFirstName();
        }
        return taskId;
    }

    /**
     * @see UserDataService#setFirstName(FirstName)
     */
    @Nullable
    public synchronized Integer setFirstName(@NonNull FirstName firstName) {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.setFirstName(firstName);
        }
        return taskId;
    }

    /**
     * @see UserDataService#getWeight()
     */
    @Nullable
    public synchronized Integer getWeight() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getWeight();
        }
        return taskId;
    }

    /**
     * @see UserDataService#setWeight(Weight)
     */
    @Nullable
    public synchronized Integer setWeight(@NonNull Weight weight) {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.setWeight(weight);
        }
        return taskId;
    }

    /**
     * @see UserDataService#getGender()
     */
    @Nullable
    public synchronized Integer getGender() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getGender();
        }
        return taskId;
    }

    /**
     * @see UserDataService#setGender(Gender)
     */
    @Nullable
    public synchronized Integer setGender(@NonNull Gender gender) {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.setGender(gender);
        }
        return taskId;
    }

    /**
     * @see UserDataService#getHeight()
     */
    @Nullable
    public synchronized Integer getHeight() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getHeight();
        }
        return taskId;
    }

    /**
     * @see UserDataService#setHeight(Height)
     */
    @Nullable
    public synchronized Integer setHeight(@NonNull Height height) {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.setHeight(height);
        }
        return taskId;
    }

    /**
     * @see UserDataService#getAge()
     */
    @Nullable
    public synchronized Integer getAge() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getAge();
        }
        return taskId;
    }

    /**
     * @see UserDataService#setAge(Age)
     */
    @Nullable
    public synchronized Integer setAge(@NonNull Age age) {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.setAge(age);
        }
        return taskId;
    }

    /**
     * @see UserDataService#getDateOfBirth()
     */
    @Nullable
    public synchronized Integer getDateOfBirth() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getDateOfBirth();
        }
        return taskId;
    }

    /**
     * @see UserDataService#setDateOfBirth(DateOfBirth)
     */
    @Nullable
    public synchronized Integer setDateOfBirth(@NonNull DateOfBirth dateOfBirth) {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.setDateOfBirth(dateOfBirth);
        }
        return taskId;
    }

    /**
     * @see UserDataService#getHeartRateMax()
     */
    @Nullable
    public synchronized Integer getHeartRateMax() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getHeartRateMax();
        }
        return taskId;
    }

    /**
     * @see UserDataService#setHeartRateMax(HeartRateMax)
     */
    @Nullable
    public synchronized Integer setHeartRateMax(@NonNull HeartRateMax heartRateMax) {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.setHeartRateMax(heartRateMax);
        }
        return taskId;
    }

    /**
     * @see UserDataService#getRestingHeartRate()
     */
    @Nullable
    public synchronized Integer getRestingHeartRate() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getRestingHeartRate();
        }
        return taskId;
    }

    /**
     * @see UserDataService#setRestingHeartRate(RestingHeartRate)
     */
    @Nullable
    public synchronized Integer setRestingHeartRate(@NonNull RestingHeartRate restingHeartRate) {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.setRestingHeartRate(restingHeartRate);
        }
        return taskId;
    }

    /**
     * @see UserDataService#getMaximumRecommendedHeartRate()
     */
    @Nullable
    public synchronized Integer getMaximumRecommendedHeartRate() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getMaximumRecommendedHeartRate();
        }
        return taskId;
    }

    /**
     * @see UserDataService#setMaximumRecommendedHeartRate(MaximumRecommendedHeartRate)
     */
    @Nullable
    public synchronized Integer setMaximumRecommendedHeartRate(@NonNull MaximumRecommendedHeartRate maximumRecommendedHeartRate) {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.setMaximumRecommendedHeartRate(maximumRecommendedHeartRate);
        }
        return taskId;
    }

    /**
     * @see UserDataService#getVO2Max()
     */
    @Nullable
    public synchronized Integer getVO2Max() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getVO2Max();
        }
        return taskId;
    }

    /**
     * @see UserDataService#setVO2Max(VO2Max)
     */
    @Nullable
    public synchronized Integer setVO2Max(@NonNull VO2Max vo2Max) {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.setVO2Max(vo2Max);
        }
        return taskId;
    }

    /**
     * @see UserDataService#getLanguage()
     */
    @Nullable
    public synchronized Integer getLanguage() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getLanguage();
        }
        return taskId;
    }

    /**
     * @see UserDataService#setLanguage(Language)
     */
    @Nullable
    public synchronized Integer setLanguage(@NonNull Language language) {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.setLanguage(language);
        }
        return taskId;
    }

    /**
     * @see UserDataService#getTwoZoneHeartRateLimit()
     */
    @Nullable
    public synchronized Integer getTwoZoneHeartRateLimit() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getTwoZoneHeartRateLimit();
        }
        return taskId;
    }

    /**
     * @see UserDataService#setTwoZoneHeartRateLimit(TwoZoneHeartRateLimit)
     */
    @Nullable
    public synchronized Integer setTwoZoneHeartRateLimit(@NonNull TwoZoneHeartRateLimit twoZoneHeartRateLimit) {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.setTwoZoneHeartRateLimit(twoZoneHeartRateLimit);
        }
        return taskId;
    }

    /**
     * @see UserDataService#getThreeZoneHeartRateLimits()
     */
    @Nullable
    public synchronized Integer getThreeZoneHeartRateLimits() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getThreeZoneHeartRateLimits();
        }
        return taskId;
    }

    /**
     * @see UserDataService#setThreeZoneHeartRateLimits(ThreeZoneHeartRateLimits)
     */
    @Nullable
    public synchronized Integer setThreeZoneHeartRateLimits(@NonNull ThreeZoneHeartRateLimits threeZoneHeartRateLimits) {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.setThreeZoneHeartRateLimits(threeZoneHeartRateLimits);
        }
        return taskId;
    }

    /**
     * @see UserDataService#getFiveZoneHeartRateLimits()
     */
    @Nullable
    public synchronized Integer getFiveZoneHeartRateLimits() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getFiveZoneHeartRateLimits();
        }
        return taskId;
    }

    /**
     * @see UserDataService#setFiveZoneHeartRateLimits(FiveZoneHeartRateLimits)
     */
    @Nullable
    public synchronized Integer setFiveZoneHeartRateLimits(@NonNull FiveZoneHeartRateLimits fiveZoneHeartRateLimits) {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.setFiveZoneHeartRateLimits(fiveZoneHeartRateLimits);
        }
        return taskId;
    }

    /**
     * @see org.im97mori.ble.service.dis.central.DeviceInformationService#getManufacturerNameString()
     */
    @Nullable
    public synchronized Integer getManufacturerNameString() {
        Integer taskId = null;
        if (mDeviceInformationService != null) {
            taskId = mDeviceInformationService.getManufacturerNameString();
        }
        return taskId;
    }

    /**
     * @see org.im97mori.ble.service.dis.central.DeviceInformationService#getModelNumberString()
     */
    @Nullable
    public synchronized Integer getModelNumberString() {
        Integer taskId = null;
        if (mDeviceInformationService != null) {
            taskId = mDeviceInformationService.getModelNumberString();
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return FitnessMachineProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void disconnect() {
        mHasUserDataService = false;
        mHasDeviceInformationService = false;
        super.disconnect();
    }

    /**
     * create {@link FitnessMachineService}, {@link DeviceInformationService} and {@link UserDataService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        super.createServices();
        if (mFitnessMachineService == null) {
            mFitnessMachineService = new FitnessMachineService(mBLEConnection, mFitnessMachineProfileCallback, null);
        }
        if (mDeviceInformationService == null) {
            mDeviceInformationService = new DeviceInformationService(mBLEConnection, mFitnessMachineProfileCallback, null);
        }
        if (mUserDataService == null) {
            mUserDataService = new UserDataService(mBLEConnection, mFitnessMachineProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mFitnessMachineService = null;
        mDeviceInformationService = null;
        mUserDataService = null;
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
                if (USER_DATA_SERVICE.equals(bluetoothGattService.getUuid())) {
                    mHasUserDataService = true;
                } else if (DEVICE_INFORMATION_SERVICE.equals(bluetoothGattService.getUuid())) {
                    mHasDeviceInformationService = true;
                }
            }
        }
        super.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, argument);
    }

}
