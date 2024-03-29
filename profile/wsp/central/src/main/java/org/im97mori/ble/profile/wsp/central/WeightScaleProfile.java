package org.im97mori.ble.profile.wsp.central;

import static org.im97mori.ble.constants.ServiceUUID.BATTERY_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.BODY_COMPOSITION_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.CURRENT_TIME_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.USER_DATA_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.WEIGHT_SCALE_SERVICE;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.im97mori.ble.advertising.filter.FilteredLeScanCallback;
import org.im97mori.ble.advertising.filter.FilteredScanCallback;
import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.characteristic.u2a80.Age;
import org.im97mori.ble.characteristic.u2a85.DateOfBirth;
import org.im97mori.ble.characteristic.u2a8a.FirstName;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a8e.Height;
import org.im97mori.ble.characteristic.u2a99.DatabaseChangeIncrement;
import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.wsp.central.db.WeightScaleProfileBondedDatabaseHelper;
import org.im97mori.ble.service.bas.central.BatteryService;
import org.im97mori.ble.service.bcs.central.BodyCompositionService;
import org.im97mori.ble.service.cts.central.CurrentTimeService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.uds.central.UserDataService;
import org.im97mori.ble.service.wss.central.WeightScaleService;
import org.im97mori.ble.task.DiscoverServiceTask;

import java.util.List;

/**
 * Weight Scale Profile for Central
 */
public class WeightScaleProfile extends AbstractCentralProfile {

    /**
     * {@link WeightScaleProfileCallback} instance
     */
    protected final WeightScaleProfileCallback mWeightScaleProfileCallback;

    /**
     * {@link WeightScaleService} instance
     */
    protected WeightScaleService mWeightScaleService;

    /**
     * {@link DeviceInformationService} instance
     */
    protected DeviceInformationService mDeviceInformationService;

    /**
     * {@link UserDataService} instance
     */
    protected UserDataService mUserDataService;

    /**
     * {@link BodyCompositionService} instance
     */
    protected BodyCompositionService mBodyCompositionService;

    /**
     * {@link BatteryService} instance
     */
    protected BatteryService mBatteryService;

    /**
     * {@link CurrentTimeService} instance
     */
    protected CurrentTimeService mCurrentTimeService;

    /**
     * {@code true}:Device has Body Composition Service, {@code false}:no Body Composition Service
     */
    private boolean mHasBodyCompositionService;

    /**
     * {@code true}:Device has User Data Service, {@code false}:no User Data Service
     */
    private boolean mHasUserDataService;

    /**
     * {@code true}:Device has Battery Service, {@code false}:no Battery Service
     */
    private boolean mHasBatteryService;

    /**
     * {@code true}:Device has Current Time Service, {@code false}:no Current Time Service
     */
    private boolean mHasCurrentTimeService;

    /**
     * @param context                    {@link Context} instance
     * @param weightScaleProfileCallback {@link WeightScaleProfileCallback} instance
     */
    public WeightScaleProfile(@NonNull Context context, @NonNull WeightScaleProfileCallback weightScaleProfileCallback) {
        super(context, weightScaleProfileCallback);
        mWeightScaleProfileCallback = weightScaleProfileCallback;
    }

    /**
     * @return {@code true}:Device has Body Composition Service, {@code false}:no Body Composition Service
     */
    @Nullable
    public synchronized Boolean hasBodyCompositionService() {
        Boolean result = null;
        if (mBodyCompositionService != null) {
            result = mHasBodyCompositionService;
        }
        return result;
    }

    /**
     * @return {@code true}:Device has User Data Service, {@code false}:no User Data Service
     */
    @Nullable
    public synchronized Boolean hasUserDataService() {
        Boolean result = null;
        if (mUserDataService != null) {
            result = mHasUserDataService;
        }
        return result;
    }

    /**
     * @return {@code true}:Device has Current Time Service, {@code false}:no Current Time Service
     */
    @Nullable
    public synchronized Boolean hasBatteryService() {
        Boolean result = null;
        if (mBatteryService != null) {
            result = mHasBatteryService;
        }
        return result;
    }

    /**
     * @return {@code true}:Device has Current Time Service, {@code false}:no Current Time Service
     */
    @Nullable
    public synchronized Boolean hasCurrentTimeService() {
        Boolean result = null;
        if (mCurrentTimeService != null) {
            result = mHasCurrentTimeService;
        }
        return result;
    }

    /**
     * @return {@code true}:Device has Current Time Service, {@code false}:no Current Time Service
     */
    @Nullable
    public synchronized Integer getWeightScaleFeature() {
        Integer taskId = null;
        if (mWeightScaleService != null) {
            taskId = mWeightScaleService.getWeightScaleFeature();
        }
        return taskId;
    }

    /**
     * @see org.im97mori.ble.service.wss.central.WeightScaleService#getWeightMeasurementClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getWeightMeasurementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mWeightScaleService != null) {
            taskId = mWeightScaleService.getWeightMeasurementClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see org.im97mori.ble.service.wss.central.WeightScaleService#startWeightMeasurementIndication()
     */
    @Nullable
    public synchronized Integer startWeightMeasurementIndication() {
        Integer taskId = null;
        if (mWeightScaleService != null) {
            taskId = mWeightScaleService.startWeightMeasurementIndication();
        }
        return taskId;
    }

    /**
     * @see org.im97mori.ble.service.wss.central.WeightScaleService#stopWeightMeasurementIndication()
     */
    @Nullable
    public synchronized Integer stopWeightMeasurementIndication() {
        Integer taskId = null;
        if (mWeightScaleService != null) {
            taskId = mWeightScaleService.stopWeightMeasurementIndication();
        }
        return taskId;
    }

    /**
     * @see org.im97mori.ble.service.dis.central.DeviceInformationService#hasSystemId()
     */
    @Nullable
    public synchronized Boolean hasSystemId() {
        Boolean result = null;
        if (mDeviceInformationService != null) {
            result = mDeviceInformationService.hasSystemId();
        }
        return result;
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
     * @see org.im97mori.ble.service.dis.central.DeviceInformationService#getSystemId()
     */
    @Nullable
    public synchronized Integer getSystemId() {
        Integer taskId = null;
        if (mDeviceInformationService != null) {
            taskId = mDeviceInformationService.getSystemId();
        }
        return taskId;
    }

    /**
     * @see org.im97mori.ble.service.bcs.central.BodyCompositionService#getBodyCompositionFeature()
     */
    @Nullable
    public synchronized Integer getBodyCompositionFeature() {
        Integer taskId = null;
        if (mBodyCompositionService != null) {
            taskId = mBodyCompositionService.getBodyCompositionFeature();
        }
        return taskId;
    }

    /**
     * @see org.im97mori.ble.service.uds.central.UserDataService#isAgeCharacteristicSupported()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#isDateOfBirthCharacteristicSupported()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#isFirstNameCharacteristicSupported()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#isHeightCharacteristicSupported()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#isGenderCharacteristicSupported()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#isDatabaseChangeIncrementCharacteristicNotifySupported()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#getAge()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#setAge(Age)
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#getDateOfBirth()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#setDateOfBirth(DateOfBirth)
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#getFirstName()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#setFirstName(FirstName)
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#getHeight()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#setHeight(Height)
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#getGender()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#setGender(Gender)
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#getDatabaseChangeIncrement()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#setDatabaseChangeIncrement(DatabaseChangeIncrement)
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#getDatabaseChangeIncrementClientCharacteristicConfiguration()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#startDatabaseChangeIncrementNotification()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#stopDatabaseChangeIncrementNotification()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#getUserIndex()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#getRegisteredUserClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getRegisteredUserClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.getRegisteredUserClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see org.im97mori.ble.service.uds.central.UserDataService#startRegisteredUserIndication()
     */
    @Nullable
    public synchronized Integer startRegisteredUserIndication() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.startRegisteredUserIndication();
        }
        return taskId;
    }

    /**
     * @see org.im97mori.ble.service.uds.central.UserDataService#stopRegisteredUserIndication()
     */
    @Nullable
    public synchronized Integer stopRegisteredUserIndication() {
        Integer taskId = null;
        if (mUserDataService != null) {
            taskId = mUserDataService.stopRegisteredUserIndication();
        }
        return taskId;
    }

    /**
     * @see org.im97mori.ble.service.uds.central.UserDataService#setUserControlPoint(UserControlPoint)
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#getUserControlPointClientCharacteristicConfiguration()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#startUserControlPointIndication()
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
     * @see org.im97mori.ble.service.uds.central.UserDataService#stopUserControlPointIndication()
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
     * @see org.im97mori.ble.service.bcs.central.BodyCompositionService#getBodyCompositionMeasurementClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getBodyCompositionMeasurementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mBodyCompositionService != null) {
            taskId = mBodyCompositionService.getBodyCompositionMeasurementClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see org.im97mori.ble.service.bcs.central.BodyCompositionService#startBodyCompositionMeasurementIndication()
     */
    @Nullable
    public synchronized Integer startBodyCompositionMeasurementIndication() {
        Integer taskId = null;
        if (mBodyCompositionService != null) {
            taskId = mBodyCompositionService.startBodyCompositionMeasurementIndication();
        }
        return taskId;
    }

    /**
     * @see org.im97mori.ble.service.bcs.central.BodyCompositionService#startBodyCompositionMeasurementIndication()
     */
    @Nullable
    public synchronized Integer stopBodyCompositionMeasurementIndication() {
        Integer taskId = null;
        if (mBodyCompositionService != null) {
            taskId = mBodyCompositionService.stopBodyCompositionMeasurementIndication();
        }
        return taskId;
    }

    /**
     * @see org.im97mori.ble.service.bas.central.BatteryService#getBatteryLevelCount()
     */
    @Nullable
    public synchronized Integer getBatteryLevelCount() {
        Integer count = null;
        if (mBatteryService != null) {
            count = mBatteryService.getBatteryLevelCount();
        }
        return count;
    }

    /**
     * @see #getBatteryLevel(int)
     */
    @Nullable
    public synchronized Integer getBatteryLevel() {
        return getBatteryLevel(0);
    }

    /**
     * @see org.im97mori.ble.service.bas.central.BatteryService#getBatteryLevel(int)
     */
    @Nullable
    public synchronized Integer getBatteryLevel(int index) {
        Integer taskId = null;
        if (mBatteryService != null) {
            taskId = mBatteryService.getBatteryLevel(index);
        }
        return taskId;
    }

    /**
     * @see #canBatteryLevelNotify(int)
     */
    @Nullable
    public synchronized Boolean canBatteryLevelNotify() {
        return canBatteryLevelNotify(0);
    }

    /**
     * @see org.im97mori.ble.service.bas.central.BatteryService#canBatteryLevelNotify(int)
     */
    @Nullable
    public synchronized Boolean canBatteryLevelNotify(int index) {
        Boolean result = null;
        if (mBatteryService != null) {
            result = mBatteryService.canBatteryLevelNotify(index);
        }
        return result;
    }

    /**
     * @see #getBatteryLevelCharacteristicPresentationFormat(int)
     */
    @Nullable
    public synchronized Integer getBatteryLevelCharacteristicPresentationFormat() {
        return getBatteryLevelCharacteristicPresentationFormat(0);
    }

    /**
     * @see org.im97mori.ble.service.bas.central.BatteryService#getBatteryLevelCharacteristicPresentationFormat(int)
     */
    @Nullable
    public synchronized Integer getBatteryLevelCharacteristicPresentationFormat(int index) {
        Integer taskId = null;
        if (mBatteryService != null) {
            taskId = mBatteryService.getBatteryLevelCharacteristicPresentationFormat(index);
        }
        return taskId;
    }

    /**
     * @see #getBatteryLevelClientCharacteristicConfiguration(int)
     */
    @Nullable
    public synchronized Integer getBatteryLevelClientCharacteristicConfiguration() {
        return getBatteryLevelClientCharacteristicConfiguration(0);
    }

    /**
     * @see org.im97mori.ble.service.bas.central.BatteryService#getBatteryLevelClientCharacteristicConfiguration(int)
     */
    @Nullable
    public synchronized Integer getBatteryLevelClientCharacteristicConfiguration(int index) {
        Integer taskId = null;
        if (mBatteryService != null) {
            taskId = mBatteryService.getBatteryLevelClientCharacteristicConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #startBatteryLevelNotification(int)
     */
    @Nullable
    public synchronized Integer startBatteryLevelNotification() {
        return startBatteryLevelNotification(0);
    }

    /**
     * @see org.im97mori.ble.service.bas.central.BatteryService#startBatteryLevelNotification(int)
     */
    @Nullable
    public synchronized Integer startBatteryLevelNotification(int index) {
        Integer taskId = null;
        if (mBatteryService != null) {
            taskId = mBatteryService.startBatteryLevelNotification(index);
        }
        return taskId;
    }

    /**
     * @see #stopBatteryLevelNotification(int)
     */
    @Nullable
    public synchronized Integer stopBatteryLevelNotification() {
        return stopBatteryLevelNotification(0);
    }

    /**
     * @see org.im97mori.ble.service.bas.central.BatteryService#stopBatteryLevelNotification(int)
     */
    @Nullable
    public synchronized Integer stopBatteryLevelNotification(int index) {
        Integer taskId = null;
        if (mBatteryService != null) {
            taskId = mBatteryService.stopBatteryLevelNotification(index);
        }
        return taskId;
    }

    /**
     * @see org.im97mori.ble.service.cts.central.CurrentTimeService#isCurrentTimeCharacteristicWritable()
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
     * @see org.im97mori.ble.service.cts.central.CurrentTimeService#isLocalTimeInformationCharacteristicSupported()
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
     * @see org.im97mori.ble.service.cts.central.CurrentTimeService#isLocalTimeInformationCharacteristicWritable()
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
     * @see org.im97mori.ble.service.cts.central.CurrentTimeService#isReferenceTimeInformationCharacteristicSupported()
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
     * @see org.im97mori.ble.service.cts.central.CurrentTimeService#getCurrentTime()
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
     * @see org.im97mori.ble.service.cts.central.CurrentTimeService#setCurrentTime(CurrentTime)
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
     * @see org.im97mori.ble.service.cts.central.CurrentTimeService#getCurrentTimeClientCharacteristicConfiguration()
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
     * @see org.im97mori.ble.service.cts.central.CurrentTimeService#startCurrentTimeNotification()
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
     * @see org.im97mori.ble.service.cts.central.CurrentTimeService#stopCurrentTimeNotification()
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
     * @see org.im97mori.ble.service.cts.central.CurrentTimeService#getLocalTimeInformation()
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
     * @see org.im97mori.ble.service.cts.central.CurrentTimeService#setLocalTimeInformation(LocalTimeInformation)
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
     * @see org.im97mori.ble.service.cts.central.CurrentTimeService#getReferenceTimeInformation()
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
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return WeightScaleProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void disconnect() {
        mHasBodyCompositionService = false;
        mHasUserDataService = false;
        mHasBatteryService = false;
        mHasCurrentTimeService = false;
        super.disconnect();
    }

    /**
     * create {@link WeightScaleService}, {@link DeviceInformationService}, {@link UserDataService}, {@link BodyCompositionService}, {@link BatteryService} and {@link CurrentTimeService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        super.createServices();
        if (mWeightScaleService == null) {
            mWeightScaleService = new WeightScaleService(mBLEConnection, mWeightScaleProfileCallback, null);
        }
        if (mDeviceInformationService == null) {
            mDeviceInformationService = new DeviceInformationService(mBLEConnection, mWeightScaleProfileCallback, null);
        }
        if (mUserDataService == null) {
            mUserDataService = new UserDataService(mBLEConnection, mWeightScaleProfileCallback, null);
        }
        if (mBodyCompositionService == null) {
            mBodyCompositionService = new BodyCompositionService(mBLEConnection, mWeightScaleProfileCallback, null);
        }
        if (mBatteryService == null) {
            mBatteryService = new BatteryService(mBLEConnection, mWeightScaleProfileCallback, null);
        }
        if (mCurrentTimeService == null) {
            mCurrentTimeService = new CurrentTimeService(mBLEConnection, mWeightScaleProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mWeightScaleService = null;
        mDeviceInformationService = null;
        mUserDataService = null;
        mBodyCompositionService = null;
        mBatteryService = null;
        mCurrentTimeService = null;
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
                if (WEIGHT_SCALE_SERVICE.equals(bluetoothGattService.getUuid())) {
                    List<BluetoothGattService> includedServiceList = bluetoothGattService.getIncludedServices();
                    if (includedServiceList != null) {
                        for (BluetoothGattService includedGattService : includedServiceList) {
                            if (BODY_COMPOSITION_SERVICE.equals(includedGattService.getUuid())) {
                                mHasBodyCompositionService = true;
                                break;
                            }
                        }
                    }
                } else if (USER_DATA_SERVICE.equals(bluetoothGattService.getUuid())) {
                    mHasUserDataService = true;
                } else if (BATTERY_SERVICE.equals(bluetoothGattService.getUuid())) {
                    mHasBatteryService = true;
                } else if (CURRENT_TIME_SERVICE.equals(bluetoothGattService.getUuid())) {
                    mHasCurrentTimeService = true;
                }
            }
        }
        super.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, argument);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected FilteredScanCallback createFilteredScanCallback() {
        return new WeightScaleProfileScanCallback(this, null);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    protected FilteredLeScanCallback createFilteredLeScanCallback() {
        return new WeightScaleProfileLeScanCallback(this, null);
    }

}
